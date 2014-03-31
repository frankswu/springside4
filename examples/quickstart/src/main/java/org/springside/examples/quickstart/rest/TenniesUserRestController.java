package org.springside.examples.quickstart.rest;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.examples.quickstart.service.tennis.TenniesUserService;
import org.springside.modules.beanvalidator.BeanValidators;

/**
 * TMTennisUser的Restful API的Controller.
 * <br>
 * List page : GET /api/v1/TMTennisUser/ <br>
 * get one: GET /api/v1/TMTennisUser/{id} <br>
 * Create page : GET /api/v1/TMTennisUser/create <br>
 * Create action : POST /api/v1/TMTennisUser/create <br>
 * Update page : GET /api/v1/TMTennisUser/update/{id} <br>
 * Update action : POST /api/v1/TMTennisUser/update <br>
 * Delete action : GET /api/v1/TMTennisUser/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/api/v1/TMTennisUser")
public class TenniesUserRestController {

	private static Logger logger = LoggerFactory.getLogger(TenniesUserRestController.class);

	@Autowired
	private TenniesUserService TenniesUserService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TMTennisUser> list() {
		return TenniesUserService.getAllTMTennisUser();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		TMTennisUser TMTennisUser = TenniesUserService.getTMTennisUser(id);
		if (TMTennisUser == null) {
			logger.warn("TMTennisUser with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(TMTennisUser, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TMTennisUser TMTennisUser, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMTennisUser);

		// 保存任务
		TenniesUserService.saveTMTennisUser(TMTennisUser);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Long id = TMTennisUser.getId();
		URI uri = uriBuilder.path("/api/v1/TMTennisUser/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TMTennisUser TMTennisUser) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMTennisUser);
		// 保存
		TenniesUserService.saveTMTennisUser(TMTennisUser);

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		TenniesUserService.deleteTMTennisUser(id);
	}

	// Total control - setup a model and return the view name yourself. Or consider
	// subclassing ExceptionHandlerExceptionResolver (see below).
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception exception) {
		System.out.println("Request: " + req.getRequestURL() + ",method:" + req.getMethod() + ",raised " + exception);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}

}
