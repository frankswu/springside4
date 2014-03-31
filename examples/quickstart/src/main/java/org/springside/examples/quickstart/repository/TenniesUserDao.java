package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMTennisUser;


/**
 * @auther frankswu
 */
public interface TenniesUserDao extends PagingAndSortingRepository<TMTennisUser, Long>, JpaSpecificationExecutor<TMTennisUser> {

    Page<TMTennisUser> findByXXXXId(Long id, Pageable pageRequest);

    TMTennisUser findByXXXXX(String loginName);

    @Modifying
	@Query("delete from TMTennisUser TMTennisUser where TMTennisUser.user.id=?1")
	void deleteByXXXXXId(Long id);
}
