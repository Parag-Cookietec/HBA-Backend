package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUCSPInwardView;
import gov.ifms.pvu.dto.PVUCSPOutwardView;
import gov.ifms.pvu.dto.PVUChangeOfScalePVUOfficeSearchDto;
import gov.ifms.pvu.dto.PVUCsEventDto;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUEventChangeOfScaleDDOView;

/**
 * The Class PVUCsEventController.
 *
 * @version v 1.0
 * @created 2020/01/06 15:19:21
 *
 */
public interface PVUCsEventService {
	/**
	 * Retrieves an PVUCsEventEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUCsEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUCsEventDto getCsEvent(Long id);

	/**
	 * Saves a given PVUCsEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUCsEventEntity
	 */
	public PVUCsEventDto saveOrUpdateCsEvent(PVUCsEventDto entity) throws CustomException;

	/**
	 * Fetch all the PVUCsEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUCsEventDto>
	 */
	public PagebleDTO<PVUCsEventDto> getCsEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;

	/**
	 * Insert cs itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU cs event dto
	 * @throws CustomException the custom exception
	 */
	public PVUCsEventDto insertCsItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;

	public PagebleDTO<PVUEventChangeOfScaleDDOView> getCommonDetailsCspvuddolist(PageDetails pageDetail)
			throws CustomException;

	Object getPVUOfficeName(IdDto idDto);

	Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;

	Boolean submitCSPInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	Boolean submitCSPDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

	PagebleDTO<PVUCSPInwardView> getCSPInwardList(PageDetails pageDetail) throws CustomException;

	String getWfRlCdByCSPTrnId(Long id);

	public boolean deleteCsEvent(Long id) throws CustomException;

	PagebleDTO<PVUChangeOfScalePVUOfficeSearchDto> getPVUOfficeCSPEmployeeSearch(PageDetails pageDetail)
			throws CustomException;

	List<PVUMsReasonDto> getPvuOfficeCSPReasonCode();

	Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;

	public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;

	public PVUCsEventDto updateCsRemarks(PVUCsEventDto dto) throws CustomException;

	PagebleDTO<PVUCSPOutwardView> getCSPOutwardList(PageDetails pageDetail) throws CustomException;

	Boolean generateOutwardNumber(List<IdDto> dto) throws CustomException;

	Boolean submitCSPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;

	public PagebleDTO<PVUCsPrintEndorsementView> getCSPrintEndorsements(PageDetails pageDetail) throws CustomException;

	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException;

	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException;

	List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException;

	String generatePrintEndorsement(IdDto dto) throws IOException, CustomException, DocumentException;
}
