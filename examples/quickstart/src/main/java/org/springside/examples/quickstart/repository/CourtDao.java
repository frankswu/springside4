package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMCourt;


/**
 * @auther frankswu
 */
public interface CourtDao extends PagingAndSortingRepository<TMCourt, Long>, JpaSpecificationExecutor<TMCourt> {

//    Page<TMCourt> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMCourt findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMCourt TMCourt where TMCourt.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
