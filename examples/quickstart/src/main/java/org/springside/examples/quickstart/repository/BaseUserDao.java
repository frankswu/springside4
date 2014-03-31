package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMBaseUser;


/**
 * @auther frankswu
 */
public interface BaseUserDao extends PagingAndSortingRepository<TMBaseUser, Long>, JpaSpecificationExecutor<TMBaseUser> {

    Page<TMBaseUser> findByXXXXId(Long id, Pageable pageRequest);

    TMBaseUser findByXXXXX(String loginName);

    @Modifying
	@Query("delete from TMBaseUser TMBaseUser where TMBaseUser.user.id=?1")
	void deleteByXXXXXId(Long id);
}
