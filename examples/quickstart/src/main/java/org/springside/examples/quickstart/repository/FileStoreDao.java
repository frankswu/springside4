package org.springside.examples.quickstart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springside.examples.quickstart.entity.TMFileStore;


/**
 * @auther frankswu
 */
public interface FileStoreDao extends PagingAndSortingRepository<TMFileStore, Long>, JpaSpecificationExecutor<TMFileStore> {

//    Page<TMFileStore> findByXXXXId(Long id, Pageable pageRequest);
//
//    TMFileStore findByXXXXX(String loginName);
//
//    @Modifying
//	@Query("delete from TMFileStore TMFileStore where TMFileStore.user.id=?1")
//	void deleteByXXXXXId(Long id);
}
