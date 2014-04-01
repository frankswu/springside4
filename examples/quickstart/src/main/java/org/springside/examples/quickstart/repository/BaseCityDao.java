package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMBaseCity;


/**
 * @auther frankswu
 */
public interface BaseCityDao extends PagingAndSortingRepository<TMBaseCity, Long>, JpaSpecificationExecutor<TMBaseCity> {

//    Page<TMBaseCity> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMBaseCity findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMBaseCity TMBaseCity where TMBaseCity.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
