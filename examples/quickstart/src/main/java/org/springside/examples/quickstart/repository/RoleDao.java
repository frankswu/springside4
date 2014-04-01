package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMRole;


/**
 * @auther frankswu
 */
public interface RoleDao extends PagingAndSortingRepository<TMRole, Long>, JpaSpecificationExecutor<TMRole> {

//    Page<TMRole> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMRole findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMRole TMRole where TMRole.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
