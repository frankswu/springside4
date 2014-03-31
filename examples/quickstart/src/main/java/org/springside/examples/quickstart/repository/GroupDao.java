package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMGroup;


/**
 * @auther frankswu
 */
public interface GroupDao extends PagingAndSortingRepository<TMGroup, Long>, JpaSpecificationExecutor<TMGroup> {

    Page<TMGroup> findByXXXXId(Long id, Pageable pageRequest);

    TMGroup findByXXXXX(String loginName);

    @Modifying
	@Query("delete from TMGroup TMGroup where TMGroup.user.id=?1")
	void deleteByXXXXXId(Long id);
}
