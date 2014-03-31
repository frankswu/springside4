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
import org.springside.examples.quickstart.entity.TMBaseEnum;
import org.springside.examples.quickstart.repository.BaseEnumDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class BaseEnumService {

	private BaseEnumDao BaseEnumDao;

	public TMBaseEnum getTMBaseEnum(Long id) {
		return BaseEnumDao.findOne(id);
	}

	public void saveTMBaseEnum(TMBaseEnum entity) {
		BaseEnumDao.save(entity);
	}

	public void deleteTMBaseEnum(Long id) {
		BaseEnumDao.delete(id);
	}

	public List<TMBaseEnum> getAllTMBaseEnum() {
		return (List<TMBaseEnum>) BaseEnumDao.findAll();
	}

	public Page<TMBaseEnum> getXXXXTMBaseEnum(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMBaseEnum> spec = buildSpecification(userId, searchParams);

		return BaseEnumDao.findAll(spec, pageRequest);
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
	private Specification<TMBaseEnum> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<TMBaseEnum> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMBaseEnum.class);
		return spec;
	}

	@Autowired
	public void setBaseEnumDao(BaseEnumDao BaseEnumDao) {
		this.BaseEnumDao = BaseEnumDao;
	}
}
