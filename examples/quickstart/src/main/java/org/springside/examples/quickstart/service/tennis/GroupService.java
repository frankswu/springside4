package org.springside.examples.quickstart.service.tennis;

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
import org.springside.examples.quickstart.entity.TMGroup;
import org.springside.examples.quickstart.repository.GroupDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class GroupService {

	private GroupDao GroupDao;

	public TMGroup getTMGroup(Long id) {
		return GroupDao.findOne(id);
	}

	public void saveTMGroup(TMGroup entity) {
		GroupDao.save(entity);
	}

	public void deleteTMGroup(Long id) {
		GroupDao.delete(id);
	}

	public List<TMGroup> getAllTMGroup() {
		return (List<TMGroup>) GroupDao.findAll();
	}

	public Page<TMGroup> getXXXXTMGroup(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMGroup> spec = buildSpecification(userId, searchParams);

		return GroupDao.findAll(spec, pageRequest);
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
	private Specification<TMGroup> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<TMGroup> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMGroup.class);
		return spec;
	}

	@Autowired
	public void setGroupDao(GroupDao GroupDao) {
		this.GroupDao = GroupDao;
	}
}
