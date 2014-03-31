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
import org.springside.examples.quickstart.entity.TMTennisUser;
import org.springside.examples.quickstart.repository.TenniesUserDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class TenniesUserService {

	private TenniesUserDao TenniesUserDao;

	public TMTennisUser getTMTennisUser(Long id) {
		return TenniesUserDao.findOne(id);
	}

	public void saveTMTennisUser(TMTennisUser entity) {
		TenniesUserDao.save(entity);
	}

	public void deleteTMTennisUser(Long id) {
		TenniesUserDao.delete(id);
	}

	public List<TMTennisUser> getAllTMTennisUser() {
		return (List<TMTennisUser>) TenniesUserDao.findAll();
	}

	public Page<TMTennisUser> getXXXXTMTennisUser(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMTennisUser> spec = buildSpecification(userId, searchParams);

		return TenniesUserDao.findAll(spec, pageRequest);
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
	private Specification<TMTennisUser> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<TMTennisUser> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMTennisUser.class);
		return spec;
	}

	@Autowired
	public void setTenniesUserDao(TenniesUserDao TenniesUserDao) {
		this.TenniesUserDao = TenniesUserDao;
	}
}
