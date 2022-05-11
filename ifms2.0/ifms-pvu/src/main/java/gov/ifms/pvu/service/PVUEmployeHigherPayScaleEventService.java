package gov.ifms.pvu.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeHigherPayScaleEventDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUHigherPayGradeEventDDOView;
import gov.ifms.pvu.dto.PVUHigherPayInwardView;
import gov.ifms.pvu.dto.PVUHigherPayOfficeSearchView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUOutwardView;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.dto.request.PVUOptAvDto;
import gov.ifms.pvu.entity.PVUEmployeHigherPayScaleEventEntity;


/**
 * The Class PVUEmployeHigherPayScaleEventController.
 *
 * @version v 1.0
 * @created 2020/01/07 16:13:21
 *
 */
public interface PVUEmployeHigherPayScaleEventService {
	/**
	 * Retrieves an PVUEmployeHigherPayScaleEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeHigherPayScaleEventEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeHigherPayScaleEventEntity getEmployeHigherPayScaleEvent(Long id);

	/**
	 * Saves a given PVUEmployeHigherPayScaleEventEntity. Use the returned instance
	 * for further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUEmployeHigherPayScaleEventEntity
	 */
	public PVUEmployeHigherPayScaleEventDto saveOrUpdateEmployeHigherPayScaleEvent(
			PVUEmployeHigherPayScaleEventDto dto) throws CustomException;

	/**
	 * Saves all given PVUEmployeHigherPayScaleEventEntity entities.
	 *
	 * @return the saved entities
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUEmployeHigherPayScaleEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeHigherPayScaleEventDto>
	 */

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Gets the valid eligle employee for higher pay scale.
	 *
	 * @param request the request
	 * @return the valid eligle employee for higher pay scale
	 * @throws CustomException the custom exception
	 */
	Map<String, Object> getValidEligleEmployeeForHigherPayScale(PvuCommonRequest request) throws CustomException,ParseException;

	/**
	 * Ddo WF listing.
	 *
	 * @param pageDetails the page details
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUHigherPayGradeEventDDOView> ddoWFListing(PageDetails pageDetails) throws CustomException;

	/**
	 * Insert higher pay itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU employe higher pay scale event dto
	 * @throws CustomException the custom exception
	 */
	PVUEmployeHigherPayScaleEventDto insertHigherPayItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Gets the PVU office name.
	 *
	 * @param idDto the id dto
	 * @return the PVU office name
	 */
	Object getPVUOfficeName(IdDto idDto);

	/**
	 * Gets the higher pay inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the higher pay inward list
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUHigherPayInwardView> getHigherPayInwardList(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate inward number.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;

	/**
	 * Submi higher pay inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean submiHigherPayInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Submit higherpay distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	// Distributer
	Boolean submitHigherpayDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Pvu office employee search.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUHigherPayOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the higherpay reasons.
	 *
	 * @return the higherpay reasons
	 */
	public List<PVUMsReasonDto> getHigherpayReasons();

	/**
	 * Gets the return reason by transaction id.
	 *
	 * @param id the id
	 * @return the return reason by transaction id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;

	/**
	 * Update higherpay remarks.
	 *
	 * @param dto the dto
	 * @return the PVU employe higher pay scale event dto
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeHigherPayScaleEventDto updateHigherpayRemarks(PVUSSPRemarkRequest dto) throws CustomException;

	/**
	 * Gets the wf code by higher pay trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf code by higher pay trn id
	 */
	public String getWfCodeByHigherPayTrnId(Long trnId);

	/**
	 * Gets the PVU response.
	 *
	 * @param dto the dto
	 * @return the PVU response
	 * @throws CustomException the custom exception
	 */
	Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;

	/**
	 * Gets the HPS out ward list.
	 *
	 * @param pageDetail the page detail
	 * @return the HPS out ward list
	 * @throws CustomException the custom exception
	 */
	PagebleDTO<PVUOutwardView> getHPSOutWardList(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate out ward number.
	 *
	 * @param dtos the dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException;

	/**
	 * Submit HPS out ward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	Boolean submitHPSOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;
	List<PVUSearchEnum> getPrintPrintEndorsementSearchFields();
	PagebleDTO<PVUPrintEndorsementView> getHPGPrintEndorsementList(PageDetails pageDetail) throws CustomException;
	public String generateHPSPrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException;
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException;
	List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;
	public boolean deleteHigherPayEventById(IdDto idDto) throws CustomException;
}
