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
import org.springside.examples.quickstart.entity.TMRole;
import org.springside.examples.quickstart.repository.RoleDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class RoleService {

	private RoleDao RoleDao;

	public TMRole getTMRole(Long id) {
		return RoleDao.findOne(id);
	}

	public void saveTMRole(TMRole entity) {
		RoleDao.save(entity);
	}

	public void deleteTMRole(Long id) {
		RoleDao.delete(id);
	}

	public List<TMRole> getAllTMRole() {
		return (List<TMRole>) RoleDao.findAll();
	}

	public Page<TMRole> getXXXXTMRole(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMRole> spec = buildSpecification(userId, searchParams);

		return RoleDao.findAll(spec, pageRequest);
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
	private Specification<TMRole> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<TMRole> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMRole.class);
		return spec;
	}

	@Autowired
	public void setRoleDao(RoleDao RoleDao) {
		this.RoleDao = RoleDao;
	}
}
