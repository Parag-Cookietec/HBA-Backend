package gov.ifms.edp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPMsDistrictEntity;

/**
 * The Interface EDPMsDistrictRepository.
 */
@Repository
@Transactional
public interface EDPMsDistrictRepository extends JpaRepository<EDPMsDistrictEntity,Long> , 
                  JpaSpecificationExecutor<EDPMsDistrictEntity> {
	
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPMsDistrictEntity> findByActiveStatus(int activeStatus);
	
	/**
	 * Find by district id and active status.
	 *
	 * @param distId the dist id
	 * @param activeStatus the active status
	 * @return the EDP ms district entity
	 */
	EDPMsDistrictEntity findByDistrictIdAndActiveStatus(Long distId,int activeStatus);
	
	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsDistrictEntity> findByActiveStatusAndStateId(int activeStatus,Long stateId, Sort sort);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPMsDistrictEntity> findByActiveStatus(int activeStatus, Sort sort);

	/**
	 * Find by active status.
	 *
	 * @param activeStatus the active status
	 * @return the list
	 */
	public Optional<EDPMsDistrictEntity> findByDistrictNameAndActiveStatus(String districtName, int activeStatus);

	/**
	 * Find by active status.
	 *
	 * @param sort the sort
	 * @return the list
	 */
	public List<EDPMsDistrictEntity> findByStateId(Long stateId, Sort sort);

}
