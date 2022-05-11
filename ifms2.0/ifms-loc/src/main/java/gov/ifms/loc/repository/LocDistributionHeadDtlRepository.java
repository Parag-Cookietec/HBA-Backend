package gov.ifms.loc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocDistributionHeadDtlEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocDistributionHeadDtlController.
 *
 * @version v 1.0
 * @created 2021/02/11 14:51:40
 */

@Repository
@Transactional
public interface LocDistributionHeadDtlRepository extends JpaRepository<LocDistributionHeadDtlEntity, Long>,
		JpaSpecificationExecutor<LocDistributionHeadDtlEntity>, GenericDao {

	List<LocDistributionHeadDtlEntity> findByHdrIdIdAndActiveStatus(Long hdrId, int activeStatus);

	/**
	 * @param chargedVoted
	 * @param fundType
	 * @param budgetType
	 * @param ddoNo
	 * @param statusId 
	 * @return
	 */

	@Query(value = LocDBConstants.GET_ALL_DEMAND, nativeQuery = true)
	List<Object[]> getDemandList(String chargedVoted, String fundType, Long budgetType, String ddoNo, Long statusId);

	
	/**
			 * @param fundType
	 * @param ddoNo 
	 * @param statusId 
			 * @param demandId
			 * @return
			 */
	
	  @Query(value = LocDBConstants.GET_MAJOR_HEAD_LIST_PA,nativeQuery=true)
	  List<Object[]> getMajorHeadListPA(String fundType, String ddoNo, Long statusId);
	  
	 /**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param demandId
	 * @param ddoNo 
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_MAJOR_HEAD_LIST, nativeQuery = true)
		List<Object[]> getMajorHeadList(String chargedVoted, String fundType, Long budgetType, String ddoNo, Long demandId, Long statusId);
  
	 /**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
	 * @param ddoNo 
		 * @param demandId
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_SUB_MAJOR_HEAD_LIST, nativeQuery = true)
		List<Object[]> getSubMajorHeadList(String chargedVoted, String fundType, Long budgetType, String ddoNo, Long demandId,
				Long majorHeadId, Long statusId);
  
		 /**
		 * @param fundType
	 * @param ddoNo 
		 * @param majorHeadId
		 * @param statusId 
		 * @return
		 */
	
	@Query(value = LocDBConstants.GET_SUB_MAJOR_HEAD_LIST_PA, nativeQuery = true)
	List<Object[]> getSubMajorHeadListPA(String fundType, String ddoNo,Long majorHeadId, Long statusId);
  
	 /**
		 * @param fundType
		 * @param ddoNo
		 * @param majorHeadId
		 * @param subMajorHeadId
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_MINOR_HEAD_LIST_PA, nativeQuery = true)
		List<Object[]> getMinorHeadListPA(String fundType, String ddoNo,  Long majorHeadId,
				Long subMajorHeadId, Long statusId);
  
	 /**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorHeadId
		 * @param subMajorHeadId
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_MINOR_HEAD_LIST, nativeQuery = true)
		List<Object[]> getMinorHeadList(String chargedVoted, String fundType, Long budgetType, String ddoNo,
				Long demandId, Long majorHeadId, Long subMajorHeadId, Long statusId);
  
	 /**
		 * @param fundType
		 * @param ddoNo
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_SUB_HEAD_LIST_PA, nativeQuery = true)
		List<Object[]> getSubHeadListPA(String fundType, String ddoNo, Long majorHeadId,
				Long subMajorHeadId, Long minorHeadId, Long statusId);
	  
	 /**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
	 * @param statusId 
		 * @return
		 */

		@Query(value = LocDBConstants.GET_SUB_HEAD_LIST, nativeQuery = true)
		List<Object[]> getSubHeadList(String chargedVoted, String fundType, Long budgetType, String ddoNo, Long demandId,
				Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long statusId);
	  
	 /**
		 * @param fundType
		 * @param ddoNo
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
		 * @param subHeadId
	 * @param statusId 
		 * @return
		 */
	
	  @Query(value = LocDBConstants.GET_DETAIL_HEAD_LIST_PA,nativeQuery = true)
	  List<Object[]> getDetailHeadListPA(String fundType, String ddoNo, Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long
	  subHeadId, Long statusId);
	  
	 /**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
		 * @param subHeadId
	 * @param statusId 
		 * @return
		 */
	
	  @Query(value = LocDBConstants.GET_DETAIL_HEAD_LIST,nativeQuery = true)
		List<Object[]> getDetailHeadList(String chargedVoted, String fundType, Long budgetType, String ddoNo,
				Long demandId, Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId, Long statusId);
	  

	  
	 	/**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
		 * @param subHeadId
		 * @param detailHeadId
	 	 * @param statusId 
		 * @return
		 */
		@Query(value = LocDBConstants.GET_ITEM_LIST, nativeQuery = true)
		List<Object[]> getItemNameList(String chargedVoted, String fundType, Long budgetType, String ddoNo, Long demandId,
				Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId, Long detailHeadId, Long statusId);

		/**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorHeadId
		 * @param subMajorHeadId
		 * @param minorHeadId
		 * @param subHeadId
		 * @param detailHeadId
		 * @param itemId 
		 * @param statusId 
		 * @return
		 */
		@Query(value = LocDBConstants.GET_OBJECT_CLASS_LIST, nativeQuery = true)
		List<Object[]> getObjectClassList(String chargedVoted, String fundType, Long budgetType, String ddoNo,
				Long demandId, Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId,
				Long detailHeadId, Long itemId, Long statusId);

		/**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorheadId
		 * @param submajorheadId
		 * @param minorheadId
		 * @param subheadId
		 * @param detailHeadId
		 * @param luApprovedLookupInfoId
		 * @return
		 */
		@Query(value = LocDBConstants.GET_ESTIMATE_TYPE, nativeQuery = true)
		List<Object[]> getBudgetEstimateTypeList(@Param("chargedVoted") String chargedVoted, @Param("fundType") String fundType,@Param("budgetType") Long budgetType, @Param("ddoNo") String ddoNo,
				@Param("demandId") Long demandId, @Param("majorHeadId") Long majorheadId, @Param("subMajorHeadId") Long submajorheadId, @Param("minorHeadId") Long minorheadId, @Param("subHeadId") Long subheadId,
				@Param("detailHeadId") Long detailHeadId, @Param("statusId") Long statusId);

		/**
		 * @param ddoNo
		 * @param demandId
		 * @param majorheadId
		 * @param submajorheadId
		 * @param minorheadId
		 * @param subheadId
		 * @param detailHeadId
		 * @param luApprovedLookupInfoId
		 * @return
		 */
		@Query(value = LocDBConstants.GET_ESTIMATE_TYPE_PA, nativeQuery = true)
		List<Object[]> getBudgetEstimateTypeListPA( @Param("ddoNo") String ddoNo,
				 @Param("majorHeadId") Long majorheadId, @Param("subMajorHeadId") Long submajorheadId, @Param("minorHeadId") Long minorheadId, @Param("subHeadId") Long subheadId,
				@Param("detailHeadId") Long detailHeadId, @Param("statusId") Long statusId);

		/**
		 * @param chargedVoted
		 * @param fundType
		 * @param budgetType
		 * @param ddoNo
		 * @param demandId
		 * @param majorheadId
		 * @param submajorheadId
		 * @param minorheadId
		 * @param subheadId
		 * @param detailHeadId
		 * @param luApprovedLookupInfoId
		 * @return
		 */
		@Query(value = LocDBConstants.GET_OBJECT_CLASS_LIST_SC, nativeQuery = true)
		List<Object[]> getObjectClassListSC(String chargedVoted, String fundType, Long budgetType, String ddoNo,
				Long demandId, Long majorHeadId, Long subMajorHeadId, Long minorHeadId, Long subHeadId,
				Long detailHeadId, Long statusId);

			
			 

}
