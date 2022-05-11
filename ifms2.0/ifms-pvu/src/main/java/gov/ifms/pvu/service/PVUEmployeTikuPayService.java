package gov.ifms.pvu.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.pvu.dto.PVUCSPOutwardView;
import gov.ifms.pvu.dto.PVUCsPrintEndorsementView;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeTikuPayDto;
import gov.ifms.pvu.dto.PVUEventRemarksDto;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.dto.PVUPrintEndorsementRemarkHistoryDto;
import gov.ifms.pvu.dto.PVUTikuPayEditListView;
import gov.ifms.pvu.dto.PVUTikuPayInwardView;
import gov.ifms.pvu.dto.PVUTikuPayOfficeSearchView;
import gov.ifms.pvu.dto.PvuPrintStickerReportDto;
import gov.ifms.pvu.dto.PvuWFOutWardWrapperDto;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.response.PVUTikuPayApiDto;
import gov.ifms.pvu.entity.PVUEmployeTikuPayEntity;


public interface PVUEmployeTikuPayService {

	PagebleDTO<PVUEmployeTikuPayDto> getTikuPayDetails(PageDetails pageDetail) throws CustomException;
	
	public PVUTikuPayApiDto getCommonDetailsBasedOnEventDate(Map<String, Object> map) throws CustomException, ParseException;
	
	public Map<String, Object> getEmployeeCurrentDetails(PageDetails pageDetail)   throws CustomException, ParseException;
	public PVUEmployeTikuPayDto saveOrUpdateEmployeTikuPay(PVUEmployeTikuPayDto dto) throws CustomException;
	
	public void postDetailvalidate(PVUEmployeTikuPayDto dto) throws CustomException;
	
	
	public PVUEmployeTikuPayDto insertWorkFlowData(PvuWFWrapperDto wrapperDto) throws CustomException;
	public PagebleDTO<PVUTikuPayEditListView> getTikuPayDDOList(PageDetails pageDetail) throws CustomException;
	public boolean deleteTikuPayEventById(IdDto idDto) throws CustomException;
	String getWfRoleCodeByTrnId(Long id);
	
	public PVUEmployeTikuPayEntity getEmployeTikuPay(Long id);
	
	// Get Tikupay Lookup info 
	public Map<String, List<PVUEmployeCreationDDLView>> getLookUpInfoAsMap(String procedureName) throws CustomException;
    
    
    Object getTikuPayEmpOfficeName(IdDto idDto);
    PagebleDTO<PVUTikuPayOfficeSearchView> pvuAuditorList(PageDetails pageDetail) throws CustomException;
    
    
    // Inward 
    PagebleDTO<PVUTikuPayInwardView> getTikypayInwardList(PageDetails pageDetail) throws CustomException;
    Boolean generateInwardNumber(List<IdDto> dto) throws CustomException;
    Boolean submiTikuPayInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
    
    // Distributer
    Boolean submitTikupayDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException;
    
    // Auditor
    public List<PVUMsReasonDto> getTikupayReasons();
    public List<PVUEventRemarksDto> getReturnReasonByTransactionId(Long id) throws CustomException;
    
    public PVUEmployeTikuPayDto updateTikupayRemarks(PVUEmployeTikuPayDto dto) throws CustomException;
    
    Map<String, Object> getPVUResponse(IdDto dto) throws CustomException;
    
    
    PagebleDTO<PVUCSPOutwardView> getOutwardList(PageDetails pageDetail) throws CustomException;
    Boolean generateOutwardNumber(List<IdDto> dto) throws CustomException;
	Boolean submitOutward(List<PvuWFOutWardWrapperDto> wrapperDto) throws CustomException;
	
	
	public PagebleDTO<PVUCsPrintEndorsementView> getPrintEndorsementsList(PageDetails pageDetail) throws CustomException;
	public String generatePrintEndorsement(PvuPrintStickerReportDto dto) throws CustomException;
	public String generatePrintEndorsement(List<PvuPrintStickerReportDto> dto) throws CustomException;
	
	List<PVUPrintEndorsementRemarkHistoryDto> getPrintEndorsementHistory(Long id) throws CustomException;
	
}
