package gov.ifms.pvu.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventDto;
import gov.ifms.pvu.dto.PVUSteppingUpEventView;
import gov.ifms.pvu.dto.PVUSteppingUpInwardView;
import gov.ifms.pvu.dto.PVUSteppingUpOfficeSearchView;
import gov.ifms.pvu.dto.PVUSteppingUpOutwardView;
import gov.ifms.pvu.dto.PVUSteppingUpPrintEndorsementView;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUEventSteppingUpDDOView;
import gov.ifms.pvu.entity.PVUSteppingUpEventEntity;

/**
 * The Class PVUStEventController.
 * 
 * @version v 1.0
 * @created 2019/12/17 18:44:21
 *
 */
public interface PVUSteppingUpEventService {
	/**
	 * Retrieves an PVUStEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUStEventEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUSteppingUpEventEntity getStEvent(Long id);

	/**
	 * Saves a given PVUStEventEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUStEventEntity
	 * @throws CustomException 
	 */
	public PVUSteppingUpEventEntity saveOrUpdateStEvent(PVUSteppingUpEventEntity entity) throws CustomException;

	/**
	 * Fetch all the PVUStEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUStEventDto>
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<PVUSteppingUpEventView> getStEvents(PageDetails pageDetail) throws CustomException;

	/**
	 * Delete st events details.
	 *
	 * @param id             the id
	 * @param inactiveStatus the inactive status
	 * @throws CustomException the custom exception
	 */
	public void deleteStEventsDetails(Long id, int inactiveStatus) throws CustomException;

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @param procedureName the procedure name
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName) throws CustomException;

	/**
	 * Submit validation.
	 *
	 * @param dto the dto
	 * @throws CustomException 
	 */
	public void submitValidation(PVUSteppingUpEventDto dto) throws CustomException;
	
	
	
    /**
     * Checks Senior&Junior employee validations
     *
     * @param PageDetails pageDetail
     * @return error msg 
     * @throws CustomException the custom exception
     */
	public boolean chkSrJrValidation(PageDetails pageDetail) throws CustomException ;

	
	
    /**
     * Use for ddo office Senior scale PVU.
     *
     * @param pageDetails page details
     * @return the response entity
     * @throws CustomException the custom exception
     */
	public PagebleDTO<PVUEventSteppingUpDDOView> ddoWFListing(PageDetails pageDetail) throws CustomException ;

    /**
     * Insert in itr response entity.
     *
     * @param wrapperDto the wrapper dto
     * @return the response entity
     * @throws CustomException the custom exception
     */
	PVUSteppingUpEventDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException;

	Object getSteppingUpOfficeName(IdDto idDto);

    // Inward 
    PagebleDTO<PVUSteppingUpInwardView> getSteppingUpInwardList(PageDetails pageDetail) throws CustomException;
    Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;
    Boolean submiSteppingUpInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

    // Distributer
    Boolean submitSteppingUpDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

    
    
    PagebleDTO<PVUSteppingUpOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail) throws CustomException;

    Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;
    
    // Auditor
    public List<PVUMsReasonDto> getSteppingUpReasons();
    public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;
    public PVUSteppingUpEventDto updateRemarks(PVUSteppingUpEventDto dto) throws CustomException;

    // Outward 
    PagebleDTO<PVUSteppingUpOutwardView> getSteppingUpOutwardList(PageDetails pageDetail) throws CustomException;
    Boolean generateOutwardNumber(List<IdDto> dto) throws CustomException;
    Boolean submiSteppingUpOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;

    // Print Endorsement
    PagebleDTO<PVUSteppingUpPrintEndorsementView> getSteppingUpPrintEndorsement(PageDetails pageDetail) throws CustomException;
	String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws IOException,CustomException, DocumentException;
	String generatePrintEndorsementList(List<PvuPrintStickerReportDto> dto) throws IOException,CustomException, DocumentException;
	
	
	List<PVUPrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;
	
    String getWfRoleCodeByTrnId(Long id);
    
	String generateComparisionReport(IdDto dto) throws IOException,CustomException, DocumentException;
}
