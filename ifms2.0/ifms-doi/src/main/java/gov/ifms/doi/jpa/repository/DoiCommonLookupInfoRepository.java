package gov.ifms.doi.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.ifms.doi.jpa.entity.DoiCommonLookUpInfo;

/**
 * 
 * @author Sagar Jadhav
 *
 */
public interface DoiCommonLookupInfoRepository extends JpaRepository<DoiCommonLookUpInfo, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from DoiCommonLookUpInfo entity where entity.activeStatus = 1 and parentLookupId in (select lookupId from DoiCommonLookUp where lookupName = :lookupName) order by orderId")
	List<DoiCommonLookUpInfo> getByParentLookUpName(@Param("lookupName") String lookupName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update DoiCommonLookUpInfo entity set entity.lookupInfoValue=:updatedValue where entity.activeStatus = 1 and parentLookupId in (select lookupId from DoiCommonLookUp where lookupName = :lookupName) and entity.lookupInfoName = :lookupName")
	void updateLookupInfoValue(@Param("lookupName") String lookupName, @Param("updatedValue") String updatedValue);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from DoiCommonLookUpInfo entity where entity.activeStatus = 1 and entity.lookupInfoDescription = 'Policy Type'")
	List<DoiCommonLookUpInfo> getAllPolicyTypes();
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("select entity from DoiCommonLookUpInfo entity where entity.activeStatus = 1 and entity.lookupInfoDescription = 'Status'")
	List<DoiCommonLookUpInfo> getAllStatus();
}
