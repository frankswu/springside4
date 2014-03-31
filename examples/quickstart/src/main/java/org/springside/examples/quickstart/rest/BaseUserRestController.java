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
import org.springside.examples.quickstart.entity.TMBaseUser;
import org.springside.examples.quickstart.service.tennis.BaseUserService;
import org.springside.modules.beanvalidator.BeanValidators;

/**
 * TMBaseUser的Restful API的Controller.
 * <br>
 * List page : GET /api/v1/TMBaseUser/ <br>
 * get one: GET /api/v1/TMBaseUser/{id} <br>
 * Create page : GET /api/v1/TMBaseUser/create <br>
 * Create action : POST /api/v1/TMBaseUser/create <br>
 * Update page : GET /api/v1/TMBaseUser/update/{id} <br>
 * Update action : POST /api/v1/TMBaseUser/update <br>
 * Delete action : GET /api/v1/TMBaseUser/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/api/v1/TMBaseUser")
public class BaseUserRestController {

	private static Logger logger = LoggerFactory.getLogger(BaseUserRestController.class);

	@Autowired
	private BaseUserService BaseUserService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TMBaseUser> list() {
		return BaseUserService.getAllTMBaseUser();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		TMBaseUser TMBaseUser = BaseUserService.getTMBaseUser(id);
		if (TMBaseUser == null) {
			logger.warn("TMBaseUser with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(TMBaseUser, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TMBaseUser TMBaseUser, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMBaseUser);

		// 保存任务
		BaseUserService.saveTMBaseUser(TMBaseUser);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Long id = TMBaseUser.getId();
		URI uri = uriBuilder.path("/api/v1/TMBaseUser/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TMBaseUser TMBaseUser) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMBaseUser);
		// 保存
		BaseUserService.saveTMBaseUser(TMBaseUser);

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		BaseUserService.deleteTMBaseUser(id);
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
