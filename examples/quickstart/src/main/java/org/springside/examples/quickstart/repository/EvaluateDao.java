package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMEvaluate;


/**
 * @auther frankswu
 */
public interface EvaluateDao extends PagingAndSortingRepository<TMEvaluate, Long>, JpaSpecificationExecutor<TMEvaluate> {

//    Page<TMEvaluate> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMEvaluate findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMEvaluate TMEvaluate where TMEvaluate.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
