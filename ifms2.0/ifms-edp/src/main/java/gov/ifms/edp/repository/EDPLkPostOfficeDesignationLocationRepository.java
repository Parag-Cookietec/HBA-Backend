package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPLkPostOfficeDesignationLocationEntity;

/**
 * The Interface EDPLkPostOfficeDesignationLocationRepository.
 */
@Repository
@Transactional
public interface EDPLkPostOfficeDesignationLocationRepository extends JpaRepository<EDPLkPostOfficeDesignationLocationEntity,Long> , 
                  JpaSpecificationExecutor<EDPLkPostOfficeDesignationLocationEntity> {
	
	/**
	 * This method is used to find link of post and office by post id.
	 *
	 * @param postId the post id
	 * @return list of EDPLkPostOfficeDesignationLocationEntity
	 */
	List<EDPLkPostOfficeDesignationLocationEntity> findByPostId(Long postId);
}
