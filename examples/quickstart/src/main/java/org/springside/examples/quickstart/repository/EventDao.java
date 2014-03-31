package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMEvent;


/**
 * @auther frankswu
 */
public interface EventDao extends PagingAndSortingRepository<TMEvent, Long>, JpaSpecificationExecutor<TMEvent> {

    Page<TMEvent> findByXXXXId(Long id, Pageable pageRequest);

    TMEvent findByXXXXX(String loginName);

    @Modifying
	@Query("delete from TMEvent TMEvent where TMEvent.user.id=?1")
	void deleteByXXXXXId(Long id);
}
