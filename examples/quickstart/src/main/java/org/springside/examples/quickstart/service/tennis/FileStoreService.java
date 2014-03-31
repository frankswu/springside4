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
import org.springside.examples.quickstart.entity.TMFileStore;
import org.springside.examples.quickstart.repository.FileStoreDao;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

//Spring Bean的标识.
@Component
// 默认将类中的所有public函数纳入事务管理.
@Transactional
public class FileStoreService {

	private FileStoreDao FileStoreDao;

	public TMFileStore getTMFileStore(Long id) {
		return FileStoreDao.findOne(id);
	}

	public void saveTMFileStore(TMFileStore entity) {
		FileStoreDao.save(entity);
	}

	public void deleteTMFileStore(Long id) {
		FileStoreDao.delete(id);
	}

	public List<TMFileStore> getAllTMFileStore() {
		return (List<TMFileStore>) FileStoreDao.findAll();
	}

	public Page<TMFileStore> getXXXXTMFileStore(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		Specification<TMFileStore> spec = buildSpecification(userId, searchParams);

		return FileStoreDao.findAll(spec, pageRequest);
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
	private Specification<TMFileStore> buildSpecification(Long userId, Map<String, Object> searchParams) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<TMFileStore> spec = DynamicSpecifications.bySearchFilter(filters.values(), TMFileStore.class);
		return spec;
	}

	@Autowired
	public void setFileStoreDao(FileStoreDao FileStoreDao) {
		this.FileStoreDao = FileStoreDao;
	}
}
