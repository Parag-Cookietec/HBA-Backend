package gov.ifms.loc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.dao.GenericDao;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Interface LocAdvicePrepHdrRepository.
 */
@Repository
@Transactional
public interface LocAdvicePrepHdrRepository extends JpaRepository<LocAdvicePrepHdrEntity, Long>,
		JpaSpecificationExecutor<LocAdvicePrepHdrEntity>, GenericDao {

	/**
	 * Find by hdr id and active status.
	 *
	 * @param trnId the trn id
	 * @return the optional
	 */
	Optional<LocAdvicePrepHdrEntity> findById(Long trnId);

	/**
	 * Gets the advice dtl view data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the advice dtl view data
	 */
	@Query(value = LocDBConstants.LOC_ADVICE_DTL_VIEW, nativeQuery = true)
	List<Object[]> getAdviceDtlViewData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the advice dtl edit data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the advice dtl edit data
	 */
	@Query(value = LocDBConstants.LOC_ADVICE_DTL_EDIT, nativeQuery = true)
	List<Object[]> getAdviceDtlEditData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the advice dtl bank.
	 *
	 * @param cardexNo     the cardex no
	 * @param ddoNO        the ddo NO
	 * @param districtId   the district id
	 * @param activeStatus the active status
	 * @return the advice dtl bank
	 */
	@Query(value = LocDBConstants.LOC_ADVICE_DTL_BANK, nativeQuery = true)
	List<Object[]> getAdviceDtlBank(@Param("cardexNo") Long cardexNo, @Param("ddoNo") String ddoNO,
			@Param("districtId") Long districtId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the advice dtl sub treasury treas.
	 *
	 * @param officeId the office id
	 * @return the advice dtl sub treasury treas
	 */
	@Query(value = LocDBConstants.LOC_ADVICE_TRES, nativeQuery = true)
	List<Object[]> getAdviceDtlSubTreasuryTreas(@Param("officeId") Long officeId);

	/**
	 * Gets the lookup idand name.
	 *
	 * @param parentLookupId the parent lookup id
	 * @param activeStatus   the active status
	 * @return the lookup idand name
	 */
	@Query(value = LocDBConstants.GET_LOOKUP_NAME_ID, nativeQuery = true)
	List<Object[]> getLookupIdandName(@Param("parentLookupId") Long parentLookupId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Gets the lookup idand name budget type.
	 *
	 * @param parentLookupId the parent lookup id
	 * @param activeStatus   the active status
	 * @return the lookup idand name budget type
	 */
	@Query(value = LocDBConstants.GET_LOOKUP_NAME_ID_BUDGET_TYPE, nativeQuery = true)
	List<Object[]> getLookupIdandNameBudgetType(@Param("parentLookupId") Long parentLookupId,
			@Param("activeStatus") int activeStatus);

	/**
	 * Soft delete by id.
	 *
	 * @param hdrId the hdr id
	 */
	@Modifying
	@Query(value = " update LocAdvicePrepHdrEntity set activeStatus = 0 WHERE  id =:hdrId")
	void softDeleteById(@Param("hdrId") Long hdrId);

	/**
	 * Gets the lc valid from.
	 *
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @param officeId     the office id
	 * @param activeStatus the active status
	 * @return the lc valid from
	 */
	@Query(value = LocDBConstants.LOC_ADVICE_LC_VALID_FROM, nativeQuery = true)
	String getLcValidFrom(@Param("cardexNo") Long cardexNo, @Param("ddoNo") String ddoNo,
			@Param("officeId") Long officeId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the advice payment details.
	 *
	 * @param ddoNo    the ddo no
	 * @param statusId the status id
	 * @return the advice payment details
	 */
	@Query(value = LocDBConstants.GET_PAYMENT_DTLS, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetails(@Param("ddoNo") String ddoNo, @Param("statusId") long statusId);

	/**
	 * Gets the advice payment details LC search.
	 *
	 * @param ddoNo          the ddo no
	 * @param statusId       the status id
	 * @param demandId       the demand id
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param itemId         the item id
	 * @param objectClassId  the object class id
	 * @param fundType       the fund type
	 * @param budgetType     the budget type
	 * @param chargedVoted   the charged voted
	 * @param estimateType   the estimate type
	 * @return the advice payment details LC search
	 */

	@Query(value = LocDBConstants.GET_POSTING_DTLS_SEARCH_LC, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearch(@Param("ddoNo") String ddoNo, @Param("statusId") long statusId,
			@Param("demandId") Long demandId, @Param("majorHeadId") Long majorHeadId,
			@Param("subMajorHeadId") Long subMajorHeadId, @Param("minorHeadId") Long minorHeadId,
			@Param("subHeadId") Long subHeadId, @Param("detailHeadId") Long detailHeadId, @Param("itemId") Long itemId,
			@Param("objectClassId") Long objectClassId, @Param("fundType") String fundType,
			@Param("budgetType") Long budgetType, @Param("chargedVoted") String chargedVoted,
			@Param("estimateType") String estimateType);

	/**
	 * Gets the posting dtl view data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the posting dtl view data
	 */
	@Query(value = LocDBConstants.GET_POSTING_DTLS_VIEW_DATA, nativeQuery = true)
	List<Object[]> getPostingDtlViewData(@Param("hdrId") Long hdrId, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the posting dtl edit data.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the posting dtl edit data
	 */
	@Query(value = LocDBConstants.GET_POSTING_DTLS_EDIT_DATA, nativeQuery = true)
	List<Object[]> getPostingDtlEditData(Long hdrId, int activeStatus);

	/**
	 * Gets the posting dtl map epymnt view.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the posting dtl map epymnt view
	 */
	@Query(value = LocDBConstants.GET_LOC_ADVICE_POSTING_DTL_MAP_EPYMNT_VIEW, nativeQuery = true)
	List<Object[]> getPostingDtlMapEpymntView(Long hdrId, int activeStatus);

	/**
	 * Gets the posting dtl map epymnt edit.
	 *
	 * @param hdrId        the hdr id
	 * @param activeStatus the active status
	 * @return the posting dtl map epymnt edit
	 */
	@Query(value = LocDBConstants.GET_LOC_ADVICE_POSTING_DTL_MAP_EPYMNT_EDIT, nativeQuery = true)
	List<Object[]> getPostingDtlMapEpymntEdit(Long hdrId, int activeStatus);

	/**
	 * Find by id and active status.
	 *
	 * @param trnId        the trn id
	 * @param activeStatus the active status
	 * @return the loc advice prep hdr entity
	 */
	LocAdvicePrepHdrEntity findByIdAndActiveStatus(Long trnId, int activeStatus);

	/**
	 * Gets the designation list.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the designation list
	 */
	@Query(value = LocDBConstants.GET_DESIGNATION_LIST, nativeQuery = true)
	List<Object[]> getDesignationList(@Param("officeId") Long id, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the header advice list.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the header advice list
	 */
	@Query(value = LocDBConstants.GET_HEDER_ADVICE_DATA, nativeQuery = true)
	List<Object[]> getHeaderAdviceList(Long id, int activeStatus);

	/**
	 * Gets the chq series from chq act inactive.
	 *
	 * @param districtId   the district id
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @param activeStatus the active status
	 * @return the chq series from chq act inactive
	 */
	@Query(value = LocDBConstants.GET_CHEQUEBOOK_DATA, nativeQuery = true)
	List<Object[]> getChqSeriesFromChqActInactive(@Param("districtId") Long districtId,
			@Param("cardexNo") Long cardexNo, @Param("ddoNo") String ddoNo, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the loc advice chq list.
	 *
	 * @param districtId   the district id
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @param activeStatus the active status
	 * @return the loc advice chq list
	 */
	@Query(value = LocDBConstants.GET_ADVICE_PREP_CHEQUEBOOK_DATA, nativeQuery = true)
	List<Object[]> getLocAdviceChqList(@Param("districtId") Long districtId, @Param("cardexNo") Long cardexNo,
			@Param("ddoNo") String ddoNo, @Param("activeStatus") int activeStatus);

	/**
	 * s.
	 *
	 * @param ddoNo          the ddo no
	 * @param statusId       the status id
	 * @param demandId       the demand id
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param objectClassId  the object class id
	 * @param fundType       the fund type
	 * @param budgetType     the budget type
	 * @param chargedVoted   the charged voted
	 * @param estimateType   the estimate type
	 * @return the advice payment details LC search SC
	 */
	@Query(value = LocDBConstants.GET_POSTING_DTLS_SEARCH_LC_SC, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearchSC(@Param("ddoNo") String ddoNo, @Param("statusId") long statusId,
			@Param("demandId") Long demandId, @Param("majorHeadId") Long majorHeadId,
			@Param("subMajorHeadId") Long subMajorHeadId, @Param("minorHeadId") Long minorHeadId,
			@Param("subHeadId") Long subHeadId, @Param("detailHeadId") Long detailHeadId,
			@Param("objectClassId") Long objectClassId, @Param("fundType") String fundType,
			@Param("budgetType") Long budgetType, @Param("chargedVoted") String chargedVoted,
			@Param("estimateType") String estimateType);

	/**
	 * Gets the advice payment details LC search PA.
	 *
	 * @param ddoNo          the ddo no
	 * @param statusId       the status id
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param fundType       the fund type
	 * @return the advice payment details LC search PA
	 */
	@Query(value = LocDBConstants.GET_POSTING_DTLS_SEARCH_LC_PA, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearchPA(@Param("ddoNo") String ddoNo, @Param("statusId") long statusId,
			@Param("majorHeadId") Long majorHeadId, @Param("subMajorHeadId") Long subMajorHeadId,
			@Param("minorHeadId") Long minorHeadId, @Param("subHeadId") Long subHeadId,
			@Param("detailHeadId") Long detailHeadId, @Param("fundType") String fundType);

	/**
	 * Gets the sd id.
	 *
	 * @param adviceHdrId the advice hdr id
	 * @return the sd id
	 */
	@Query(value = LocDBConstants.GET_PARTY_SD_ID, nativeQuery = true)
	Long getSdId(@Param("hdrId") Long adviceHdrId);

	/**
	 * Gets the latest chq.
	 *
	 * @param districtId   the district id
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @param activeStatus the active status
	 * @return the latest chq
	 */
	@Query(value = LocDBConstants.GET_LAST_CHQ_NO, nativeQuery = true)
	List<Object[]> getLatestChq(Long districtId, Long cardexNo, String ddoNo, int activeStatus);

	/**
	 * Find max token no by cardex no and ddo no and district id and active status.
	 *
	 * @param cardexNo     the cardex no
	 * @param ddoNo        the ddo no
	 * @param districtId   the district id
	 * @param activeStatus the active status
	 * @return the integer
	 */
	@Query(value = LocDBConstants.GET_LAST_TOKEN_NO, nativeQuery = true)
	Integer findMaxTokenNoByCardexNoAndDdoNoAndDistrictIdAndActiveStatus(Long cardexNo, String ddoNo, Long districtId,
			int activeStatus);

	/**
	 * Gets the multiple list.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @return the multiple list
	 */
	@Query(value = LocDBConstants.GET_MULTIPLE_DATA, nativeQuery = true)
	List<Object[]> getMultipleList(@Param("hdrId") Long id, @Param("activeStatus") int activeStatus);

	/**
	 * Gets the search param.
	 *
	 * @return the search param
	 */
	@Query(value = LocDBConstants.GET_LOC_ADVICE_PREP_SRCH_PARAM, nativeQuery = true)
	List<Object[]> getSearchParam();

	/**
	 * Gets the inward cardex search param.
	 *
	 * @return the inward cardex search param
	 */
	@Query(value = LocDBConstants.GET_CARDEX_INWARD_SRCH_PARAM, nativeQuery = true)
	List<Object[]> getInwardCardexSearchParam();

	/**
	 * Gets the advice verify auth search param.
	 *
	 * @return the advice verify auth search param
	 */
	@Query(value = LocDBConstants.GET_ADVICE_VERIFY_AUTH_SRCH_PARAM, nativeQuery = true)
	List<Object[]> getAdviceVerifyAuthSearchParam();

	/**
	 * Gets the circle.
	 *
	 * @param divId the div id
	 * @return the circle
	 */
	@Query(value = LocDBConstants.GET_CIRCLECODE, nativeQuery = true)
	String getCircle(@Param("divId") Long divId);

	/**
	 * Check advice val.
	 *
	 * @param divisionId the division id
	 * @param ddoNo      the ddo no
	 * @param cardexNo   the cardex no
	 * @param deptId     the dept id
	 * @param districtId the district id
	 * @return the list
	 */
	@Query(value = LocDBConstants.ADVICE_VAL, nativeQuery = true)
	List<Object[]> checkAdviceVal(@Param("divisionId") Long divisionId, @Param("ddoNo") String ddoNo,
			@Param("cardexNo") Long cardexNo, @Param("deptId") Long deptId, @Param("districtId") Long districtId);

	/**
	 * Update flagin advice.
	 *
	 * @param ddoNo    the ddo no
	 * @param cardexNo the cardex no
	 * @param officeId the office id
	 */
	@Modifying
	@Query(value = LocDBConstants.LOC_ADVICE_UPDATE_FLAG, nativeQuery = true)
	void updateFlaginAdvice(@Param("ddoNo") String ddoNo, @Param("cardexNo") Long cardexNo,
			@Param("officeId") Long officeId);

	/**
	 * Gets the advice payment details LC search advc amounts PA.
	 *
	 * @param ddoNo          the ddo no
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param fundTypeId     the fund type id
	 * @return the advice payment details LC search advc amounts PA
	 */
	@Query(value = LocDBConstants.LOC_LC_SEARCH_ADVC_AMNTS_PA, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearchAdvcAmountsPA(@Param("ddoNo") String ddoNo,
			@Param("majorHeadId") Long majorHeadId, @Param("subMajorHeadId") Long subMajorHeadId,
			@Param("minorHeadId") Long minorHeadId, @Param("subHeadId") Long subHeadId,
			@Param("detailHeadId") Long detailHeadId, @Param("fundType") Long fundTypeId);

	/**
	 * Gets the advice payment details LC search SC advc amounts.
	 *
	 * @param ddoNo          the ddo no
	 * @param demandId       the demand id
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param objectClassId  the object class id
	 * @param fundTypeId     the fund type id
	 * @param budgetType     the budget type
	 * @param chargedVotedId the charged voted id
	 * @param estimateTypeId the estimate type id
	 * @return the advice payment details LC search SC advc amounts
	 */
	@Query(value = LocDBConstants.LOC_LC_SEARCH_ADVC_AMNTS_SC, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearchSCAdvcAmounts(@Param("ddoNo") String ddoNo,
			@Param("demandId") Long demandId, @Param("majorHeadId") Long majorHeadId,
			@Param("subMajorHeadId") Long subMajorHeadId, @Param("minorHeadId") Long minorHeadId,
			@Param("subHeadId") Long subHeadId, @Param("detailHeadId") Long detailHeadId,
			@Param("objectClassId") Long objectClassId, @Param("fundType") Long fundTypeId,
			@Param("budgetType") Long budgetType, @Param("chargedVoted") Long chargedVotedId,
			@Param("estimateType") Long estimateTypeId);

	/**
	 * Gets the advice payment details LC search advc amounts.
	 *
	 * @param ddoNo          the ddo no
	 * @param demandId       the demand id
	 * @param majorHeadId    the major head id
	 * @param subMajorHeadId the sub major head id
	 * @param minorHeadId    the minor head id
	 * @param subHeadId      the sub head id
	 * @param detailHeadId   the detail head id
	 * @param itemId         the item id
	 * @param objectClassId  the object class id
	 * @param fundTypeId     the fund type id
	 * @param budgetType     the budget type
	 * @param chargedVotedId the charged voted id
	 * @param estimateTypeId the estimate type id
	 * @return the advice payment details LC search advc amounts
	 */
	@Query(value = LocDBConstants.LOC_LC_SEARCH_ADVC_AMNTS, nativeQuery = true)
	List<Object[]> getAdvicePaymentDetailsLCSearchAdvcAmounts(@Param("ddoNo") String ddoNo,
			@Param("demandId") Long demandId, @Param("majorHeadId") Long majorHeadId,
			@Param("subMajorHeadId") Long subMajorHeadId, @Param("minorHeadId") Long minorHeadId,
			@Param("subHeadId") Long subHeadId, @Param("detailHeadId") Long detailHeadId, @Param("itemId") Long itemId,
			@Param("objectClassId") Long objectClassId, @Param("fundType") Long fundTypeId,
			@Param("budgetType") Long budgetType, @Param("chargedVoted") Long chargedVotedId,
			@Param("estimateType") Long estimateTypeId);

	/**
	 * Gets the inactive cheque.
	 *
	 * @param chqNo        the chq no
	 * @param activeStatus the active status
	 * @return the inactive cheque
	 */
	@Query(value = LocDBConstants.GET_INACTIVE_CHEQUE, nativeQuery = true)
	List<Object[]> getInactiveCheque(@Param("chqNo") String chqNo, @Param("activeStatus") int activeStatus);
}
