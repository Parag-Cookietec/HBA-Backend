package gov.ifms.edp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;

/**
 * The Interface EDPBillObjectClassMapRepository.
 */
@Repository
@Transactional
public interface EDPBillObjectClassMapRepository
		extends JpaRepository<EDPBillObjectClassMapEntity, Long>, JpaSpecificationExecutor<EDPBillObjectClassMapEntity> {
	
	/**
	 * Deletes the EDPBillObjectClassMapEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param activeStatus the active status
	 * @param updatedBy the updated by
	 * @param updatedDate the updated date
	 * @return the int
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Modifying
	@Query(value = "update EDPBillObjectClassMapEntity set activeStatus= :activeStatus , updatedBy=:updatedBy , "
			+ "updatedDate=:updatedDate where id = :id")
	public int deleteBillObjectClassMap(@Param("id") long id, @Param("activeStatus") int activeStatus,
			@Param("updatedBy") long updatedBy, @Param("updatedDate") Date updatedDate);
	
	
	/**
	 * Gets the object class data.
	 *
	 * @return the object class data
	 */
	@Query(value = "SELECT OBJECTCLASS_ID,OBJECTCLASS_CODE_NAME FROM MASTER_V1.MS_OBJECTCLASS",nativeQuery = true)
	public List<Object[]> getObjectClassData(); 
	
	
	/**
	 * Find by bill type id look up info id and active status.
	 *
	 * @param billType the bill type
	 * @param activeStatus the active status
	 * @return the list
	 */
	public List<EDPBillObjectClassMapEntity> findByBillTypeIdLookUpInfoIdAndActiveStatus(Long billType,int activeStatus);
}
