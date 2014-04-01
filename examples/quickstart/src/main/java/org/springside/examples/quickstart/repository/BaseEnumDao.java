package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMBaseEnum;


/**
 * @auther frankswu
 */
public interface BaseEnumDao extends PagingAndSortingRepository<TMBaseEnum, Long>, JpaSpecificationExecutor<TMBaseEnum> {

//    Page<TMBaseEnum> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMBaseEnum findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMBaseEnum TMBaseEnum where TMBaseEnum.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
