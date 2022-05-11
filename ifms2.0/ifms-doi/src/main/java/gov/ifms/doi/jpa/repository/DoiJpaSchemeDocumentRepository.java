package gov.ifms.doi.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.doi.jpa.entity.DoiJpaSchemeDocumentEntity;

/**
 * @author Rudra
 *
 */

@Repository
@Transactional
public interface DoiJpaSchemeDocumentRepository extends JpaRepository<DoiJpaSchemeDocumentEntity, Long>{

	@Query("select entity from DoiJpaSchemeDocumentEntity entity where entity.activeStatus = 1")
	/* 
	@Query("select entity "
			+ " from DoiJpaSchemeDocumentEntity entity "
			+ " inner join DoiJPASchemeMaster scheme "
			+ " ON entity.scheme = scheme.schemeId"
			+ " where entity.activeStatus = 1")
	*/ 
	List<DoiJpaSchemeDocumentEntity> findAllByStatus(); 

	@Modifying(clearAutomatically = true)
	@Query("update DoiJpaSchemeDocumentEntity entity SET entity.activeStatus = 0 where entity.id = :schemeDocID")
	void softDeleteById(@Param("schemeDocID") Long schemeDocID);
	
	@Query("select entity from DoiJpaSchemeDocumentEntity entity where entity.activeStatus = 1 and entity.scheme = :schemeId")
	List<DoiJpaSchemeDocumentEntity> findAllActiveBySchemeId(@Param("schemeId") Long schemeId); 
}