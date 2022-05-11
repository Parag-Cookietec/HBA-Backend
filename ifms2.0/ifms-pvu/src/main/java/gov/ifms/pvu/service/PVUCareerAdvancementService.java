package gov.ifms.pvu.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUCASDDOView;
import gov.ifms.pvu.dto.PVUCASInwardView;
import gov.ifms.pvu.dto.PVUCareerAdvanceCurDetailDto;
import gov.ifms.pvu.dto.PVUCareerAdvancementDto;
import gov.ifms.pvu.dto.PVUCareerAdvancementOfficeSearchView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUOutwardView;
import gov.ifms.pvu.dto.PVUPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSSPRemarkRequest;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.request.CASValidationRequest;
import gov.ifms.pvu.entity.PVUCareerAdvancementEntity;

/**
 * The Class PVUCarrearAdvancementController.
 *
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 *
 */
public interface PVUCareerAdvancementService {
	/**
	 * Retrieves an PVUCarrearAdvancementEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUCarrearAdvancementEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUCareerAdvancementEntity getCarrearAdvancement(Long id);

	/**
	 * Saves a given PVUCarrearAdvancementEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUCarrearAdvancementEntity
	 * @throws CustomException
	 */
	public PVUCareerAdvancementDto saveOrUpdateCarrearAdvancement(PVUCareerAdvancementDto dto) throws CustomException;

	/**
	 * Fetch all the PVUCarrearAdvancement items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUCarrearAdvancementDto>
	 */
	public PagebleDTO<PVUCareerAdvancementDto> getCarrearAdvancements(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the DDL lu look up info as map.
	 *
	 * @return the DDL lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getDDLLuLookUpInfoAsMap() throws CustomException;

	public Map<String, Object> getEmployeeCurrDetail(PVUCareerAdvanceCurDetailDto curDetailDto) throws CustomException, ParseException;

	boolean validateCAS(CASValidationRequest request) throws CustomException;

	PVUCareerAdvancementDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

	public PagebleDTO<PVUCASDDOView> getCASDDOList(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the cas inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the cas inward list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUCASInwardView> getCASInwardList(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate inward number.
	 *
	 * @param dto the field value
	 * @return
	 * @throws CustomException
	 */
	public Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;

	/**
	 * Submit cas inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean submitCasInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Submit cas distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException
	 */
	public Boolean submitCasDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
	public boolean deleteCasEventById(IdDto idDto) throws CustomException;
	Object getPVUOfficeName(IdDto idDto);
	PagebleDTO<PVUCareerAdvancementOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail) throws CustomException;
	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;
	String getWfRlCdByCATrnId(Long id);
	Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;
	public PVUCareerAdvancementDto updateCarrierAdvancementRemarks(PVUSSPRemarkRequest dto) throws CustomException;
	PagebleDTO<PVUOutwardView> getCAOutWardList(PageDetails pageDetail) throws CustomException;
	Boolean generateOutWardNumber(List<IdDto> dtos) throws CustomException;
	Boolean submitCAOutWard(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;
	PagebleDTO<PVUPrintEndorsementView> getCAPrintEndorsementList(PageDetails pageDetail) throws CustomException;
	String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException, IOException, DocumentException, ParseException;
	String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException, IOException, DocumentException;
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;

}
