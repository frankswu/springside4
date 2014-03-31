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
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.examples.quickstart.service.tennis.BaseEnumService;
import org.springside.modules.beanvalidator.BeanValidators;

/**
 * TMBaseEnum的Restful API的Controller.
 * <br>
 * List page : GET /api/v1/TMBaseEnum/ <br>
 * get one: GET /api/v1/TMBaseEnum/{id} <br>
 * Create page : GET /api/v1/TMBaseEnum/create <br>
 * Create action : POST /api/v1/TMBaseEnum/create <br>
 * Update page : GET /api/v1/TMBaseEnum/update/{id} <br>
 * Update action : POST /api/v1/TMBaseEnum/update <br>
 * Delete action : GET /api/v1/TMBaseEnum/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/api/v1/TMBaseEnum")
public class BaseEnumRestController {

	private static Logger logger = LoggerFactory.getLogger(BaseEnumRestController.class);

	@Autowired
	private BaseEnumService BaseEnumService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TMBaseEnum> list() {
		return BaseEnumService.getAllTMBaseEnum();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		TMBaseEnum TMBaseEnum = BaseEnumService.getTMBaseEnum(id);
		if (TMBaseEnum == null) {
			logger.warn("TMBaseEnum with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(TMBaseEnum, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TMBaseEnum TMBaseEnum, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMBaseEnum);

		// 保存任务
		BaseEnumService.saveTMBaseEnum(TMBaseEnum);

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Long id = TMBaseEnum.getId();
		URI uri = uriBuilder.path("/api/v1/TMBaseEnum/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TMBaseEnum TMBaseEnum) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, TMBaseEnum);
		// 保存
		BaseEnumService.saveTMBaseEnum(TMBaseEnum);

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		BaseEnumService.deleteTMBaseEnum(id);
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
