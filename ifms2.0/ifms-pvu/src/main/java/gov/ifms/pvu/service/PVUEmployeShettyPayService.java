/*
 * 
 */
package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeShettyPayDto;
import gov.ifms.pvu.dto.PVUEmployeeShettyPayAuditViewDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUSPPrintEndorsementView;
import gov.ifms.pvu.dto.PVUShettyPayInwardView;
import gov.ifms.pvu.dto.PVUShettyPayListView;
import gov.ifms.pvu.dto.PVUShettyPayOutwardView;
import gov.ifms.pvu.dto.PVUShettyPayPVUOfficeSearchDto;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUEmployeShettyPayEntity;

/**
 * The Class PVUEmployeShettyPayController.
 * 
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
public interface PVUEmployeShettyPayService {

	/**
	 * Retrieves an PVUEmployeShettyPayEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeShettyPayEntity with the given id or {@literal null} if
	 *         none found
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUEmployeShettyPayEntity getEmployeShettyPay(Long id) throws CustomException;

	/**
	 * Save or update employe shetty pay.
	 *
	 * @param dto the dto
	 * @return the PVU employe shetty pay dto
	 * @throws CustomException the custom exception
	 */

	PVUEmployeShettyPayDto saveOrUpdateEmployeShettyPay(PVUEmployeShettyPayDto dto) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Check eligiblefor shetty pay.
	 *
	 * @param request the request
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	public boolean checkEligibleforShettyPay(PvuCommonRequest request) throws CustomException;

	/**
	 * Search shetty pay events.
	 *
	 * @param pageDetails the page details
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUShettyPayListView> searchShettyPayEvents(PageDetails pageDetails) throws CustomException;

	/**
	 * Insert shetty pay itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU increment event dto
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeShettyPayDto insertShettyPayItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	/**
	 * Gets the PVU office name.
	 *
	 * @param idDto the id dto
	 * @return the PVU office name
	 */
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto);

	/**
	 * Delete SP events details.
	 *
	 * @param idDto the id dto
	 * @return true, if successful
	 * @throws CustomException the custom exception
	 */
	public boolean deleteSPEventsDetails(IdDto idDto) throws CustomException;

	/**
	 * Gets the shetty pay inward list.
	 *
	 * @param pageDetail the page detail
	 * @return the shetty pay inward list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUShettyPayInwardView> getShettyPayInwardList(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate inward number.
	 *
	 * @param dtos the dtos
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException;

	/**
	 * Submit shetty pay inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean submitShettyPayInwardOrDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Gets the SP auditor search list.
	 *
	 * @param pageDetail the page detail
	 * @return the SP auditor search list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUShettyPayPVUOfficeSearchDto> getSPAuditorSearchList(PageDetails pageDetail)
			throws CustomException;

	/**
	 * Gets the PVU response.
	 *
	 * @param dto the dto
	 * @return the PVU response
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeeShettyPayAuditViewDto getPVUResponse(IdDto dto) throws CustomException;

	/**
	 * Gets the remark byevent id.
	 *
	 * @param id the id
	 * @return the remark byevent id
	 * @throws CustomException the custom exception
	 */
	public List<PVUEventRemarksDto> getRemarkByeventId(Long id) throws CustomException;

	/**
	 * Gets the wf code by shetty pay trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf code by shetty pay trn id
	 */
	public String getWfCodeByShettyPayTrnId(Long trnId);

	/**
	 * Update SP remarks.
	 *
	 * @param dto the dto
	 * @return the PVU employe shetty pay dto
	 * @throws CustomException the custom exception
	 */
	public PVUEmployeShettyPayDto updateSPRemarks(PVUEmployeShettyPayDto dto) throws CustomException;

	/**
	 * Gets the CSP outward list.
	 *
	 * @param pageDetail the page detail
	 * @return the CSP outward list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUShettyPayOutwardView> getSPOutwardList(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate outward number.
	 *
	 * @param dto the dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean generateOutwardNumber(List<IdDto> dto) throws CustomException;

	/**
	 * Submit SP outward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public Boolean submitSPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;

	/**
	 * Gets the SP print endorsements.
	 *
	 * @param pageDetail the page detail
	 * @return the SP print endorsements
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUSPPrintEndorsementView> getSPPrintEndorsements(PageDetails pageDetail) throws CustomException;

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the http entity
	 * @throws CustomException the custom exception
	 */
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException;

	/**
	 * Gets the reprint endorsement remarks.
	 *
	 * @param id the id
	 * @return the reprint endorsement remarks
	 * @throws CustomException the custom exception
	 */
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;

	/**
	 * Generate print endorsement.
	 *
	 * @param dto the dto
	 * @return the http entity
	 * @throws CustomException the custom exception
	 */
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException;

}
