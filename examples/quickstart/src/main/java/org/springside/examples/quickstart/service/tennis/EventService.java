package org.springside.examples.quickstart.service.tennis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.examples.quickstart.entity.TMEvent;
import org.springside.examples.quickstart.repository.BaseEnumDao;
import org.springside.examples.quickstart.repository.CourtDao;
import org.springside.examples.quickstart.repository.EvaluateDao;
import org.springside.examples.quickstart.repository.EventDao;
import org.springside.examples.quickstart.repository.TenniesUserDao;
import org.springside.examples.quickstart.restdto.EventDTO;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class EventService {

	private EventDao eventDao;
	private BaseEnumDao baseEnumDao;
	private CourtDao courtDao;
	private EvaluateDao evaluateDao;
	private TenniesUserDao tenniesUserDao;

	public TMEvent getTMEvent(Long id) {
		return eventDao.findOne(id);
	}

	public void saveEvent(TMEvent entity) {
		// TODO frankswu 保存任务
		// 需要先判断相应的关联的，球友，评论，场地是否有id，保存
		baseEnumDao.save(entity.getCategory());
		baseEnumDao.save(entity.getStatues());
		courtDao.save(entity.getCourtList());
		evaluateDao.save(entity.getComments());
//		tenniesUserDao.save(entity.getStartUsersList());
		
		eventDao.save(entity);
	}

	public void deleteTMEvent(Long id) {
		eventDao.delete(id);
	}

	public List<TMEvent> getAllTMEvent() {
		return (List<TMEvent>) eventDao.findAll();
	}

	public Page<TMEvent> getMoreEventPageList(Long userId, Map<String, Object> searchParams, int pageNumber,
			int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMEvent> spec = buildSpecification(userId, searchParams);

		return eventDao.findAll(spec, pageRequest);
	}

	public List<EventDTO> getMoreEventDTOPageList(Long userId, Map<String, Object> searchParams, int pageNumber,
			int pageSize, String sortType) {
		List<EventDTO> eventDtoList = new ArrayList<EventDTO>();
		Page<TMEvent> eventList = getMoreEventPageList(null, searchParams, pageNumber, pageSize, sortType);
		Iterator<TMEvent> it = eventList.iterator();
		while (it.hasNext()) {
			TMEvent event = it.next();
			eventDtoList.add(EventDTO.createByEvent4List(event));
		}
		return eventDtoList;
	}

	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	/**
	 * 创建动态查询条件组合.
	 */
	private Specification<TMEvent> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		if (userId != null && userId > 0) {
			filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		}
		Specification<TMEvent> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMEvent.class);
		return spec;
	}

	@Autowired
	public void setEventDao(EventDao EventDao) {
		this.eventDao = EventDao;
	}

	@Autowired
	public void setCourtDao(CourtDao courtDao) {
		this.courtDao = courtDao;
	}

	@Autowired
	public void setEvaluateDao(EvaluateDao evaluateDao) {
		this.evaluateDao = evaluateDao;
	}

	@Autowired
	public void setTenniesUserDao(TenniesUserDao tenniesUserDao) {
		this.tenniesUserDao = tenniesUserDao;
	}

	@Autowired
	public void setBaseEnumDao(BaseEnumDao baseEnumDao) {
		this.baseEnumDao = baseEnumDao;
	}

	
}
