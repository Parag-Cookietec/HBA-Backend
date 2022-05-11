package gov.ifms.doi.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.jpa.entity.DoiJpaCommonDocumentEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiJpaCommonDocumentRepository extends JpaRepository<DoiJpaCommonDocumentEntity, Long>, JpaSpecificationExecutor<DoiJpaCommonDocumentEntity>{

	@Query("select entity from DoiJpaCommonDocumentEntity entity where entity.activeStatus = 1")
	List<DoiJpaCommonDocumentEntity> findAllByStatus();

	@Modifying(clearAutomatically = true)
	@Query("update DoiJpaCommonDocumentEntity entity SET entity.activeStatus = 0 where entity.id = :commonDocID")
	void softDeleteById(@Param("commonDocID") Long commonDocID);
	
}