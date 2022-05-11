package gov.ifms.edp.service;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsPostConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeCreationSummaryReportDto;
import gov.ifms.edp.dto.EDPPostHistoryReportDto;
import gov.ifms.edp.dto.EDPPostTransferSummaryReportDto;
import gov.ifms.edp.dto.EDPReportPageDetails;
import gov.ifms.edp.dto.EDPRightsMappingReportDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthConstant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPReportRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPReportAction;
import gov.ifms.edp.util.EDPReportConstant;
import gov.ifms.edp.util.EDPUtility;

@Service
public class EDPReportsServiceImpl implements EDPReportsService {
	

	/** The report repository. */
	@Autowired
	private EDPReportRepository reportRepository;

	/** The edp ms district repository. */
	@Autowired
	private EDPMsDistrictRepository edpMsDistrictRepository;

	/** The district converter. */
	@Autowired
	private EDPMsDistrictConverter districtConverter;

	/** The edp ms office repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;
	
	/** The edp reporst pdf service impl. */
	@Autowired
	private EDPReporstPdfServiceImpl edpReporstPdfServiceImpl;

	/** The edp reporst excel service impl. */
	@Autowired
	private EDPReporstExcelServiceImpl edpReporstExcelServiceImpl;
	
	/** The service. */
	@Autowired
	private EDPLuLookUpInfoService lookupinfoservice;

	/** The converter. */
	@Autowired
	private EDPLuLookUpInfoConverter lookupinfoconverter;
	
	/** The edp ms post converter. */
	@Autowired
	private EDPMsPostConverter edpMsPostConverter;
	
	/** The designation repository. */
	@Autowired
	private EDPMsDesignationRepository designationRepository;
	
	/** The look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;
	
	/** The repository. */
	@Autowired
	private EDPMsOfficeRepository officeRepository;
	
	/** The edpmsdepartmentservice. */
	@Autowired
	private EDPMsDepartmentService edpmsdepartmentservice;

	/**
	 * Edp generate report.
	 *
	 * @param pageDetail the page detail
	 * @return the object
	 * @throws CustomException
	 */
	@Override
	public Object edpGenerateReport(EDPReportPageDetails pageDetail) throws CustomException {
		List<Object[]> response = callSPAndGetResult(pageDetail);
		if(!CollectionUtils.isEmpty(response)) {
			if (pageDetail.getReportAction().equals(EDPReportAction.VIEW)) {
				return responseView(pageDetail, response);
			} else if(pageDetail.getReportAction().equals(EDPReportAction.PDF)) {
				response =  getFilterDataOfSp(response,pageDetail);
				return edpReporstPdfServiceImpl.getReportPdf(pageDetail,response);
			} else {
				response =  getFilterDataOfSp(response,pageDetail);
				return edpReporstExcelServiceImpl.getReportExcel(pageDetail,response);
			}
		} else {
			return null;
		}
	}

	/**
	 * Call SP and get result.
	 *
	 * @param pageDetail the page detail
	 * @return the list
	 */
	private List<Object[]> callSPAndGetResult(EDPReportPageDetails pageDetail) throws CustomException {
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(getStoreProcsNameForReport(pageDetail.getMenuId())));
		Map<String, Object> argsMap = EDPUtility.populateArgumentsForReport(pageDetail);
		return reportRepository.callStoredProcedure(procName, argsMap);
	}

	/**
	 * Gets the store procs name for report.
	 *
	 * @param report the report
	 * @return the store procs name for report
	 * @throws CustomException the custom exception
	 */
	private String getStoreProcsNameForReport(Long menuId) throws CustomException {
		Map<Long, String> procList = EDPUtility.reportProcList();
		if (procList.containsKey(menuId)) {
			return procList.get(menuId);
		} else {
			throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
		}
	}

	/**
	 * Response view.
	 *
	 * @param pageDetail the page detail
	 * @param response   the response
	 * @return the object
	 * @throws CustomException the custom exception
	 */
	private Object responseView(EDPReportPageDetails pageDetail, List<Object[]> response) throws CustomException {
		if (pageDetail.getMenuId().equals(EDPReportConstant.RIGHTS_MAPPING_REPORT_MENU_ID)) {
			return getEdpRightsMappingReportDtoList(pageDetail, response);
		} else if(pageDetail.getMenuId().equals(EDPReportConstant.POST_TRANSFER_SUMMARY_REPORT_MENU_ID)) {
			return getEdpPostTransferSummaryReportDtoList(pageDetail, response);			
		} else if (pageDetail.getMenuId().equals(EDPReportConstant.REPORT_POST_HISTORY_MENU_ID)) {
			return getEdpPostHistoryReportDtoList(pageDetail, response);
		} else if(pageDetail.getMenuId().equals(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID)) {
			return getEdpOfficeCreationSummaryReportDto(pageDetail, response);
		}
		return null;
	}

	/**
	 * Gets the edp office creation summary report dto.
	 *
	 * @param pageDetail the page detail
	 * @param response the response
	 * @return the edp office creation summary report dto
	 * @throws CustomException the custom exception
	 */
	private Object getEdpOfficeCreationSummaryReportDto(EDPReportPageDetails pageDetail, List<Object[]> response)
			throws CustomException {
		List<EDPOfficeCreationSummaryReportDto> responseList = NativeQueryResultsMapper.map(response, EDPOfficeCreationSummaryReportDto.class);
		int count = !responseList.isEmpty() && null != responseList.get(0) ? responseList.get(0).getCount() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, responseList);
	}

	/**
	 * Gets the edp post history report dto list.
	 *
	 * @param pageDetail the page detail
	 * @param response the response
	 * @return the edp post history report dto list
	 * @throws CustomException the custom exception
	 */
	private Object getEdpPostHistoryReportDtoList(EDPReportPageDetails pageDetail, List<Object[]> response)
			throws CustomException {
		List<EDPPostHistoryReportDto> responseList = NativeQueryResultsMapper.map(response, EDPPostHistoryReportDto.class);
		int count = !responseList.isEmpty() && null != responseList.get(0) ? responseList.get(0).getCount() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, responseList);
	}
	
	/**
	 * Gets the edp post transfer summary report dto list.
	 *
	 * @param pageDetail the page detail
	 * @param response the response
	 * @return the edp post transfer summary report dto list
	 * @throws CustomException the custom exception
	 */
	private Object getEdpPostTransferSummaryReportDtoList(EDPReportPageDetails pageDetail, List<Object[]> response)
			throws CustomException {
		List<EDPPostTransferSummaryReportDto> responseList = NativeQueryResultsMapper.map(response, EDPPostTransferSummaryReportDto.class);
		int count = !responseList.isEmpty() && null != responseList.get(0) ? responseList.get(0).getCount() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, responseList);
	}

	/**
	 * Gets the edp rights mapping report dto list.
	 *
	 * @param pageDetail the page detail
	 * @param response the response
	 * @return the edp rights mapping report dto list
	 * @throws CustomException the custom exception
	 */
	private PagebleDTO<EDPRightsMappingReportDto>  getEdpRightsMappingReportDtoList(EDPReportPageDetails pageDetail, List<Object[]> response)
			throws CustomException {
		List<EDPRightsMappingReportDto> responseList = NativeQueryResultsMapper.map(response, EDPRightsMappingReportDto.class);
		int count = !responseList.isEmpty() && null != responseList.get(0) ? responseList.get(0).getCount() : 0;
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, responseList);
	}

	/**
	 * Edp generate report.
	 *
	 * @param id the id
	 * @return the clue dto
	 * @throws CustomException 
	 */
	@Override
	public ClueDto edpGenerateReportFilterData(Long id) throws CustomException {
		ClueDto response = new ClueDto();
		response.setIsDatUser(OAuthUtility.isCurrentUserIsDAT());
		if (OAuthUtility.isCurrentUserIsDAT()) {
			List<ClueDto> distList = districtConverter.toClueDTO(edpMsDistrictRepository.findByActiveStatusAndStateId(
					Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
					EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));
			response.setDistrictList(distList);
		} else {
			ClueDto dto = getCurrentUserOfficeDistrictDto();
			response.setDistrictDto(dto);
		}
		if(!id.equals(EDPReportConstant.CREATE_NEW_POST_MENU_ID)) {
			response.setHodList(getHodList());
			response.setDepartmentList(edpmsdepartmentservice.getAllCodeAndId());
			if(!id.equals(EDPReportConstant.CREATE_OFFICE_MENU_ID)) {				
				setWorkFlowAndTrnStatus(id, response);
			} else {
				setOfficeReportData(response);
			}
		} else {
			setOfficeDataInDto(response);
		}
		return response;
	}

	/**
	 * Gets the current user office district dto.
	 *
	 * @return the current user office district dto
	 */
	private ClueDto getCurrentUserOfficeDistrictDto() {
		EDPMsOfficeDto office = OAuthUtility.getCurrentUserOfficeFromToken();
		ClueDto dto = new ClueDto();
		dto.setId(office.getDistrictId());
		dto.setName(office.getDistrictName());
		return dto;
	}

	/**
	 * Sets the work flow and trn status.
	 *
	 * @param id the id
	 * @param response the response
	 */
	private void setWorkFlowAndTrnStatus(Long id, ClueDto response) {
		List<Object[]> dataList = reportRepository.getWfStatusAndTrnStatus(id);
		Set<ClueDto> wfStatusSet = new HashSet<>();
		Set<ClueDto> trnStatusSet = new HashSet<>();
		dataList.forEach(obj->{
			if(null != obj[0]) 				
				trnStatusSet.add(getClueDtoForStatus(obj[0]));		
			if(null != obj[1]) 
				trnStatusSet.add(getClueDtoForStatus(obj[1]));	
			if(null != obj[2]) 			
				wfStatusSet.add(getClueDtoForStatus(obj[2]));	
			if(null != obj[3]) 
				wfStatusSet.add(getClueDtoForStatus(obj[3]));	
		});
		List<ClueDto> wfStatusList = wfStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		List<ClueDto> trnStatusList = trnStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		response.setWorkFlowStatusList(wfStatusList);
		response.setTransStatusList(trnStatusList);
	}

	/**
	 * Gets the hod list.
	 *
	 * @return the hod list
	 */
	public List<ClueDto> getHodList() {

		List<EDPMsOfficeEntity> listMsOffices = edpMsOfficeRepository
				.findByIsHodAndStatusIdAndOfficeStatusAndActiveStatus(EDPConstant.LOOKUP_INFO_YES,
						Short.valueOf(String.valueOf(Constant.LU_APPROVED_LOOKUP_INFO_ID)),
						EDPConstant.LOOKUP_INFO_ACTIVE, EDPConstant.ACTIVE_STATUS_TRUE);
		return  listMsOffices.stream()
					.filter(office -> office.getParentOfficeId() != null)
					.map(office -> {
						ClueDto dto = new ClueDto();
						dto.setId(office.getOfficeId());
						dto.setName(office.getOfficeNameDisp());
						dto.setDepartmentId(office.getParentOfficeId());
						return dto;
					}).collect(Collectors.toList());
	}
	
	/**
	 * Gets the clue dto for status.
	 *
	 * @param status the status
	 * @return the clue dto for status
	 */
	private ClueDto getClueDtoForStatus(Object status) {
		ClueDto dto = new ClueDto();
		dto.setStatusId(EDPUtility.convertObjectToString(status));
		dto.setName(EDPUtility.convertObjectToString(status));
		return dto;
	}

	/**
	 * Sets the office data in dto.
	 *
	 * @param response the new office data in dto
	 */
	public void setOfficeDataInDto(ClueDto response) {
		List<ClueDto> officeData =  getDistrictWiseOfficeDetails(response.getIsDatUser()?null:response.getDistrictDto().getId());
		response.setOfficeList(officeData);
	}
	
	/**
	 * Gets the district wise office details.
	 *
	 * @param districtId the district id
	 * @return the district wise office details
	 */
	public List<ClueDto> getDistrictWiseOfficeDetails(Long districtId) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_DISTRICT_ID, districtId==null?0:districtId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPReportConstant.SP_REPORT_DISTRICT_WISE_OFFICE_DTL));
		List<Object[]> dataList = reportRepository.callStoredProcedure(procName,argsMap);
		return dataList.stream().filter(obj-> !StringUtils.isEmpty(EDPUtility.convertObjectToString(obj[1]))).map(object -> {
			ClueDto dto = new ClueDto();
			dto.setDistrictid(EDPUtility.convertObjectToLong(object[0]));
			dto.setId(EDPUtility.convertObjectToLong(object[2]));
			dto.setName(EDPUtility.convertObjectToString(object[1]));
			dto.setCardexNo(EDPUtility.convertObjectToLong(object[3]));
			dto.setDdoNo(EDPUtility.convertObjectToString(object[4]));
			return dto;
		}).sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
	}

	/**
	 * Gets the post details post report.
	 *
	 * @param officeId the office id
	 * @return the post details post report
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<ClueDto> getPostDetailsPostReport(Long officeId) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_OFFICE_ID, officeId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPReportConstant.SP_REPORT_POST_HISORY_GET_DETAIL));
		List<Object[]> dataList = reportRepository.callStoredProcedure(procName,argsMap);
		return dataList.stream().map(data->{
			ClueDto dto = new ClueDto();
			dto.setId(EDPUtility.convertObjectToLong(data[0]));
			dto.setName(EDPUtility.convertObjectToString(data[1]));
			return dto;
		}).collect(Collectors.toList());
	}
	
	/**
	 * Sets the office report data.
	 *
	 * @param response the new office report data
	 */
	private void setOfficeReportData(ClueDto response) {
		response.setOfficeLevel(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.FIND_LEVEL)));
		response.setOfficeType(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.FIND_OFFICE_TYPE)));
		response.setOfficeDesignation(edpMsPostConverter.toDesignationClueDTO(designationRepository
				.findByStatusIdLookUpInfoNameOrStatusIdIsNullAndActiveStatus(EDPConstant.LK_STATUS_VAL_APPROVED, OAuthConstant.ACTIVE_STATUS,
				EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC))));
		response.setControllingOffice(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(
				OAuthConstant.LOOK_UP_CONDITIONCHECK, EDPConstant.LOOKUP_INFO_ID, EDPConstant.ORDER_DESC)));
		response.setBillType(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(OAuthConstant.LOOK_UP_BILLTYPE)));
		response.setOfficeStatus(lookupinfoconverter.toClueDTO(lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(
				OAuthConstant.LOOK_UP_STATUS_OFFICE, EDPConstant.ACTIVE_STATUS_TRUE,EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID, 
				EDPConstant.ORDER_DESC))));
		response.setPvuOffice(getPvuOffice());
		response.setDdoType(lookupinfoconverter.toClueDTO(lookupinfoservice.findByLookUpName(EDPConstant.ARG_DDOTYPE)));
	}

	/**
	 * Gets the pvu office.
	 *
	 * @return the pvu office
	 */
	private List<ClueDto> getPvuOffice() {
		List<EDPMsOfficeEntity> officeEntities = officeRepository.findByOfficePVUAndActiveStatus(EDPConstant.FIND_PVU,EDPConstant.ACTIVE_STATUS_TRUE);
		EDPMsOfficeEntity officeEntity = new EDPMsOfficeEntity();
		officeEntity.setOfficeId(1l);
		officeEntity.setOfficeNameAlias(EDPReportConstant.PAY_VERIFICATION_UNIT_SELF);
		officeEntities.add(officeEntity);
		return lookupinfoconverter.toOfficeDto(officeEntities);
	}
	
	/**
	 * Gets the filter data of sp.
	 *
	 * @param response the response
	 * @param pageDetail the page detail
	 * @return the filter data of sp
	 */
	private List<Object[]> getFilterDataOfSp(List<Object[]> response,EDPReportPageDetails pageDetail) {
		if(pageDetail.getMenuId().equals(EDPReportConstant.OFFICE_SUMMARY_REPORT_MENU_ID)) {
			response = getOfficeFilterData(response);
		}
		return response;
	}

	/**
	 * Gets the office filter data.
	 *
	 * @param response the response
	 * @return the office filter data
	 */
	private List<Object[]> getOfficeFilterData(List<Object[]> response) {
		return response.stream().map(obj->{
			Object[] resArray = new Object[obj.length-1];
			for(int i=0;i<obj.length-1;i++)
				resArray[i]=obj[i];
			return resArray;
		}).collect(Collectors.toList());
	}
}
