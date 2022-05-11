package gov.ifms.pvu.service;

import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUEventSelectionGradeView;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUSGPrintEndorsementView;
import gov.ifms.pvu.dto.PVUSelectionGradOutwardView;
import gov.ifms.pvu.dto.PVUSelectionGradPayLelevView;
import gov.ifms.pvu.dto.PVUSelectionGradeEventDto;
import gov.ifms.pvu.dto.PVUSelectionGradeOfficeSearchView;
import gov.ifms.pvu.dto.PVUSelectionGradenwardView;
import gov.ifms.pvu.dto.PrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PvuCommonRequest;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.entity.PVUSelectionGradeEventEntity;

/**
 * The Class PVUSelectionGradeEventController.
 * 
 * @version v 1.0
 * @created 2019/12/18 11:56:47
 *
 */
public interface PVUSelectionGradeEventService {
	/**
	 * Retrieves an PVUSelectionGradeEventEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUSelectionGradeEventEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	public PVUSelectionGradeEventEntity getSelectionGradeEvent(Long id);

	/**
	 * Saves a given PVUSelectionGradeEventEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUSelectionGradeEventEntity
	 * @throws CustomException 
	 */
	public PVUSelectionGradeEventEntity saveOrUpdateSelectionGradeEvent(PVUSelectionGradeEventDto dto) throws CustomException;

	/**
	 * Saves all given PVUSelectionGradeEventEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	/**
	 * Fetch all the PVUSelectionGradeEvent items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSelectionGradeEventDto>
	 */
	public PagebleDTO<PVUSelectionGradenwardView> getSelectionGradeEvents(PageDetails pageDetail) throws CustomException;
	
	public PVUSelectionGradPayLelevView getEmployeeCheckPayLevelByPaylevelId(PvuCommonRequest pvuRequest)
			throws CustomException;

	public PVUSelectionGradeEventDto insertSelectionGradeItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;
	
	
	public PagebleDTO<PVUEventSelectionGradeView> ddoWFListingSg(PageDetails pageDetails) throws CustomException;
	
	public EDPMsOfficeDto getPVUOfficeName(IdDto idDto);
	
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException;
	
	public Boolean submitSelectionGradeInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
	
	public boolean deleteSgEvent(Long id) throws CustomException;
	
	public Boolean submitSelectionGradDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
	
	 public PagebleDTO<PVUSelectionGradeOfficeSearchView> pvuOfficeEmployeeSearch(PageDetails pageDetail) throws CustomException;
	 
	 public List<PVUMsReasonDto> getSelectionGradReasons();

	 public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;
	
	public  Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;

	public List<PVUEventRemarksDto> getRemarkByeventId(Long id) throws CustomException ;
	
	public PVUSelectionGradeEventDto updateSGRemarks(PVUSelectionGradeEventDto dto) throws CustomException;
	
	public String getWfCodeBySelectionGradeTrnId(Long trnId);
	
	public PagebleDTO<PVUSelectionGradOutwardView> getSGOutwardList(PageDetails pageDetail) throws CustomException;
	
	public Boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException;

	public Boolean submitSGOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;
	
	public PagebleDTO<PVUSGPrintEndorsementView> getPrintEndorsementsList(PageDetails pageDetail)	throws CustomException;
	
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException;
	
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException;
	
	public List<PrintEndorsementRemarkHistoryDto> getReprintEndorsementRemarks(Long id) throws CustomException;
	
	
}
