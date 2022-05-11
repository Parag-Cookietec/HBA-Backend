package gov.ifms.edp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsLocationEntity;

/**
 * The Interface EDPMsLocationRepository.
 */
@Repository
@Transactional
public interface EDPMsLocationRepository extends JpaRepository<EDPMsLocationEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsLocationEntity> {
	
	/**
	 * This method is used to find location by lookup info id and active status.
	 *
	 * @param lookUpInfoId the look up info id
	 * @param activeStatus the active status
	 * @return list of EDPMsLocationEntity
	 */
	List<EDPMsLocationEntity> findByLocationTypeIdLookUpInfoIdAndActiveStatusOrderByLocationNameAsc(Long lookUpInfoId,int activeStatus);
	
	
	/**
	 * This method is used to find District by lookup info id,active status and location code.
	 *
	 * @param lookUpInfoId the look up info id
	 * @param activeStatus the active status
	 * @param locationCode the location code
	 * @return list of EDPMsLocationEntity
	 */
	List<EDPMsLocationEntity>  findByLocationTypeIdLookUpInfoIdAndActiveStatusAndLocationCodeNotInOrderByLocationNameAsc(Long lookUpInfoId, int activeStatus ,String locationCode);
	
}
