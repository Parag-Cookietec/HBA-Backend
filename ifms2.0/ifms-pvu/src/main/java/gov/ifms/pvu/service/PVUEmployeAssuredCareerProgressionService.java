package gov.ifms.pvu.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.entity.PVUEmployeAssuredCareerProgressionEntity;

/**
 *
 */
/**
 * @author shaunak
 *
 */
public interface PVUEmployeAssuredCareerProgressionService {

	
	/**
	 * @param id
	 * @return 
	 */
	PVUEmployeAssuredCareerProgressionEntity getEmployeAssuredCareerProgression(Long id);

	/**
	 * @param entity
	 * @return
	 */
	PVUEmployeAssuredCareerProgressionEntity saveOrUpdateEmployeAssuredCareerProgression(PVUEmployeAssuredCareerProgressionDto entity) throws CustomException;

	/**
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	PagebleDTO<PVUEmployeAssuredCareerProgressionDto> getEmployeAssuredCareerProgressions(PageDetails pageDetail) throws CustomException;

	/**
	 * @return
	 * @throws CustomException
	 */
	Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException;
	
	/**
	 * @param acpEmployeeRequest
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */
	AcpEmployeeDetailDto getAcpEmployeeDetails(PVUACPDetailRequest acpEmployeeRequest) throws CustomException, ParseException;

    /**
     * @param idDto
     * @return
     * @throws CustomException
     */
    boolean deleteAcpTrns(IdDto idDto) throws CustomException;
    
    /**
     * @param request
     * @return
     * @throws CustomException
     */
    List<PvuSixthPayCommissionResponse> getSixthPayComissionScale(PvusixthPayCommissionRequest request) throws CustomException;
    
    /**
     * @param pageDetail
     * @return
     * @throws CustomException
     */
    PagebleDTO<PVUEmpACPEditListView> getACPDDOList(PageDetails pageDetail) throws CustomException;
    
    /**
     * @param pvuWFWrapperDto
     * @return
     * @throws CustomException
     */
    PVUEmployeAssuredCareerProgressionDto insertACPItr(PvuWFWrapperDto pvuWFWrapperDto) throws CustomException;
    
    /**
     * @param dto
     * @return
     * @throws CustomException
     */
    Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;
    
    /**
     * @param wrapperDto
     * @return
     * @throws CustomException
     */
    boolean submiAcpInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
    
    /**
     * @param pageDetail
     * @return
     * @throws CustomException
     */
    PagebleDTO<PVUAcpInwardView> getAcpInwardList(PageDetails pageDetail) throws CustomException;
    
    /**
     * @param wrapperDto
     * @return
     * @throws CustomException
     */
    Boolean submitAcpDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;

    /**
     * @param dto
     * @return
     * @throws CustomException
     */
    PVUEmployeAssuredCareerProgressionDto updateAcpRemarks(PVUEmployeAssuredCareerProgressionDto dto) throws CustomException;
    
    /**
     * @param id
     * @return
     */
    PVUEmployeAssuredCareerProgressionEntity getAssuredCareerProgressionById(Long id);

	/**
	 * @param idDto
	 * @return
	 */
	EDPMsOfficeDto getPVUOfficeName(IdDto idDto);

	/**
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	PagebleDTO<PVUAcpPayOfficeSearchView> pvuAuditorList(PageDetails pageDetail) throws CustomException;

	/**
	 * @param dto
	 * @return
	 * @throws CustomException
	 * @throws ParseException
	 */
	Map<String, Object> getPVUResponse(IdDto dto) throws CustomException, ParseException;
	
	/**
	 * @param id
	 * @return
	 */
	String getWfRoleCodeByTrnId(Long id);

	/**
	 * @return
	 */
	List<PVUMsReasonDto> getAcpPayReasons();

	/**
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	List<PVUEventRemarksDto> getRemarkByeventId(Long id) throws CustomException;

	/**
	 * @param dtos
	 * @return
	 * @throws CustomException
	 */
	boolean generateOutwardNumber(List<IdDto> dtos) throws CustomException;

	/**
	 * @param wrapperDto
	 * @return
	 * @throws CustomException
	 */
	boolean submitACPOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;

	/**
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	PagebleDTO<PVUACPOutwardView> getACPOutwardList(PageDetails pageDetail) throws CustomException;

	/**
	 * @param pageDetail
	 * @return
	 * @throws CustomException
	 */
	PagebleDTO<PVUPrintEndorsementView> getACPPrintEndorsement(PageDetails pageDetail) throws CustomException;

	/**
	 * @param transId
	 */
	void authorizedRop(Long transId);
	
	/**
	 * @param dto
	 * @return
	 * @throws CustomException
	 * @throws IOException
	 */
	String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException, IOException;

	/**
	 * @param dto
	 * @return
	 * @throws CustomException
	 * @throws IOException
	 */
	String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException, IOException;

	/**
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException;
}
