package org.springside.examples.quickstart.rest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.InvalidHMACException;
import org.cryptonode.jncryptor.JNCryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.restdto.EventDTO;
import org.springside.examples.quickstart.restdto.EventDetailDTO;
import org.springside.examples.quickstart.restdto.EventDetailWrapDTO;
import org.springside.examples.quickstart.restdto.EventListDTO;
import org.springside.examples.quickstart.service.tennis.EventService;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

/**
 * TMEvent的Restful API的Controller. <br>
 * 活动列表<br>
 * method:get http://218.244.146.177:8080/quickstart/api/v1/event?filter_LIKE_title=ddsf&page=10#<br>
 * filter_LIKE_title作为查询条件，有前缀filer标示查询条件，大写LIKE是查询表达式，title查询的字段,等号后面就是该字段查询值,等价于 （title like '%ddsf%'）。 page是分页页数<br>
 * 
 * 活动詳情<br>
 * method:get http://218.244.146.177:8080/quickstart/api/v1/event/1<br>
 * 
 * Create page : GET /api/v1/event/create <br>
 * Create action : POST /api/v1/event/ <br>
 * Update action : PUT /api/v1/event/{id} <br>
 * Delete action : GET /api/v1/event/delete/{id}
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/api/v1/event")
public class EventRestController {

	private static Logger logger = LoggerFactory.getLogger(EventRestController.class);

	@Autowired
	private EventService eventService;

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> list(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "page.size", defaultValue = "5") int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "filter_");

		List<EventDTO> eventDtoList = new ArrayList<EventDTO>();
		Page<TMEvent> eventList = eventService.getMoreEventPageList(null, searchParams, page, pageSize, sortType);
		Iterator<TMEvent> it = eventList.iterator();
		while (it.hasNext()) {
			TMEvent event = it.next();
			eventDtoList.add(EventDTO.createByEvent4List(event));
		}
		if (eventDtoList.isEmpty()) {
			logger.warn("Event list is empty");
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}

		EventListDTO listDto = new EventListDTO();
		listDto.setEvent_Event_List(eventDtoList);

		return new ResponseEntity(listDto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		TMEvent event = eventService.getTMEvent(id);
		if (event == null) {
			logger.warn("TMEvent with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(new EventDetailWrapDTO(EventDetailDTO.createByEvent4Detail(event)), HttpStatus.OK);
	}

	// 活动信息提交
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody EventDetailDTO eventDto, UriComponentsBuilder uriBuilder) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, eventDto);

		// TODO 接口中暴露DTO，转换成entity : 保存任务
		eventService.saveEvent(TMEvent.mapEventDTO2Event(eventDto));

		// 按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		// Long id = eventDto.getId();
		// URI uri = uriBuilder.path("/api/v1/event/" + id).build().toUri();
		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(uri);

		return new ResponseEntity(HttpStatus.CREATED);
	}

	// TODO frankswu : 活动信息提交
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody EventDetailDTO eventDto) {
		// 调用JSR303 Bean Validator进行校验, 异常将由RestExceptionHandler统一处理.
		BeanValidators.validateWithException(validator, eventDto);
		// 保存
		eventService.saveEvent(TMEvent.mapEventDTO2Event(eventDto));

		// 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/demo1", method = RequestMethod.POST)
	public ResponseEntity<?> aesDemo(@RequestBody String context) {

		logger.debug("before[" + context + "]");
		// JNCryptor cryptor = new AES256JNCryptor();
		String password = "secretsquirrel";
		String context2 = new String(decryptData(context.getBytes(), password));
		logger.debug("after[" + context2 + "]");
		return null;
	}

	private static byte[] decryptData(byte[] ciphertext, String password) {
		JNCryptor cryptor = new AES256JNCryptor();
		try {
			return cryptor.decryptData(ciphertext, password.toCharArray());
		} catch (InvalidHMACException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CryptorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/demo2", method = RequestMethod.POST)
	public ResponseEntity<?> aesAndMd5Demo() {
		// TODO Auto-generated method stub
		return null;
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	// @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		eventService.deleteTMEvent(id);
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

	// private TMEvent mapEventDTO2Event(EventDetailDTO eventDto) {
	// TMEvent event = BeanMapper.map(eventDto, TMEvent.class);
	// event.setStartUsers(eventDto.getStartUsersModelList());
	// event.setOwner(eventDto.getOwnersModelList());
	// event.setParticipant(eventDto.getParticipantModelList());
	// event.setComments(eventDto.getEvaluatesModelList());
	// event.setCourtList(eventDto.getCourtsModelList());
	// // TODO Auto-generated method stub
	// return event;
	// }

}
