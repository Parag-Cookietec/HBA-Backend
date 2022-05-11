package gov.ifms.edp.report.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.report.dto.CommonFieldMasterDto;
import gov.ifms.edp.report.dto.CommonReportClueDto;
import gov.ifms.edp.report.dto.CommonReportFieldDataDto;
import gov.ifms.edp.report.dto.CommonReportHeaderDto;
import gov.ifms.edp.report.dto.CommonReportMasterDto;
import gov.ifms.edp.report.dto.CommonReportPageDetails;
import gov.ifms.edp.report.dto.CommonReportResponseDto;
import gov.ifms.edp.report.dto.CommonReportScreenDisplayResponseDto;
import gov.ifms.edp.report.dto.CommonReportSearchParamDto;
import gov.ifms.edp.report.dto.CommonReportViewPageDetails;
import gov.ifms.edp.report.entity.CommonDesignMasterEntity;
import gov.ifms.edp.report.entity.CommonFieldMasterEntity;
import gov.ifms.edp.report.entity.CommonReportMasterEntity;
import gov.ifms.edp.report.repository.CommonDesignMasterRepository;
import gov.ifms.edp.report.repository.CommonFieldMasterRepository;
import gov.ifms.edp.report.repository.CommonReportMasterRepository;
import gov.ifms.edp.report.util.CommonReportAction;
import gov.ifms.edp.report.util.CommonReportConstant;

/**
 * The Class CommonReportServiceImpl.
 */
@Service
public class CommonReportServiceImpl implements CommonReportService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(CommonReportServiceImpl.class);
	
	/** The report master repository. */
	@Autowired
	private CommonReportMasterRepository reportMasterRepository; 
	
	/** The field master repository. */
	@Autowired
	private CommonFieldMasterRepository fieldMasterRepository;
	
	/** The design master repository. */
	@Autowired
	private CommonDesignMasterRepository designMasterRepository;
	
	/** The pdf service. */
	@Autowired
	private CommonReportPdfServiceImpl pdfService;
	
	/** The excel service. */
	@Autowired
	private CommonReportExcelServiceImpl excelService;
	
	@Override
	public Object generateReport(CommonReportPageDetails pageDetails) throws CustomException {
		Optional<CommonReportMasterEntity> reportMasterEntity = reportMasterRepository.findByAliasAndMenuId(
				pageDetails.getAlias(), pageDetails.getMenuId());
		if (reportMasterEntity.isPresent()) {
			List<CommonFieldMasterEntity> fieldMasterEntityList = fieldMasterRepository.
						findByReportIdReportId(reportMasterEntity.get().getReportId());
			List<CommonDesignMasterEntity> designMasterEntityList = designMasterRepository.
						findByReportIdReportId(reportMasterEntity.get().getReportId());
			try {
				List<Object[]> response = callSp(reportMasterEntity.get().getProcName(), pageDetails, fieldMasterEntityList);
				if (!CollectionUtils.isEmpty(response)) {
					if (pageDetails.getReportAction().equals(CommonReportAction.PDF)) {
						return pdfService.getPdfReport(pageDetails, response, reportMasterEntity.get(), designMasterEntityList
								, fieldMasterEntityList);
					} else if (pageDetails.getReportAction().equals(CommonReportAction.EXCEL)) {
						return excelService.getExcelReport(pageDetails, response, reportMasterEntity.get(), designMasterEntityList
								, fieldMasterEntityList);
					}
				} else {
					return null;
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}
		}
		return null;
	}

	/**
	 * Call sp.
	 *
	 * @param procName the proc name
	 * @param pageDetails the page details
	 * @param fieldMasterEntityList the field master entity list
	 * @return the list
	 */
	private List<Object[]> callSp(String procName, CommonReportPageDetails pageDetails, 
				List<CommonFieldMasterEntity> fieldMasterEntityList) {
		Map<String , Object> argsMap = populateArgMap(pageDetails, fieldMasterEntityList);
		return reportMasterRepository.callStoredProcedure(procName, argsMap);
	}
	
	/**
	 * Populate arg map.
	 *
	 * @param pageDetails the page details
	 * @param fieldMasterEntityList the field master entity list
	 * @return the map
	 */
	private Map<String, Object> populateArgMap(CommonReportPageDetails pageDetails, 
				List<CommonFieldMasterEntity> fieldMasterEntityList) {
		Map<String , Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetails.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetails.getPageElement());
		List<CommonReportSearchParamDto> searchParams = pageDetails.getJsonArr();
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
					sorted(Comparator.comparing(CommonFieldMasterEntity::getOrderNo)).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(searchParams)) {
			searchParams.forEach(searchParam -> {
				Optional<CommonFieldMasterEntity> fieldMasterEntity = fmEntityList1.stream().filter(entity -> 
							entity.getParamUiName().equals(searchParam.getKey()) && 
							(entity.getType().equals(CommonReportConstant.INPUT) || 
									entity.getType().equals(CommonReportConstant.BOTH) ||
									entity.getType().equals(CommonReportConstant.HIDDEN))).findFirst();
				if (fieldMasterEntity.isPresent()) {
					if (fieldMasterEntity.get().getType().equals(CommonReportConstant.HIDDEN)) {
						argsMap.put(fieldMasterEntity.get().getParamProcName(), 
								OAuthUtility.getOauthMap().get(fieldMasterEntity.get().getParamUiName()));
					} else {
						argsMap.put(fieldMasterEntity.get().getParamProcName(), searchParam.getValue());
					}
				}
			});
		}
		return argsMap;
	}

	@Override
	public CommonReportScreenDisplayResponseDto getScreenDisplayDetails(CommonReportMasterDto reportMasterDto) {
		CommonReportScreenDisplayResponseDto responseDto = new CommonReportScreenDisplayResponseDto();
		List<CommonFieldMasterEntity> fieldMasterEntityList = findFieldsByReportAlias(reportMasterDto.getAlias());
		List<CommonFieldMasterEntity> fieldEntities = fieldMasterEntityList.stream().
					filter(fieldEntity -> (null != fieldEntity.getHtmlType())).collect(Collectors.toList());
		List<CommonReportFieldDataDto> fieldDataList = fieldEntities.stream().map(fieldEntity -> {
			CommonReportFieldDataDto fieldDataDto = new CommonReportFieldDataDto();
			CommonFieldMasterDto fieldMasterDto = new CommonFieldMasterDto();
			fieldMasterDto.setParamType(fieldEntity.getParamType());
			fieldMasterDto.setParamDispName(fieldEntity.getParamDispName());
			fieldMasterDto.setParamUiName(fieldEntity.getParamUiName());
			fieldMasterDto.setIsRequired(fieldEntity.getIsRequired());
			fieldMasterDto.setRegex(fieldEntity.getRegex());
			fieldMasterDto.setHtmlType(fieldEntity.getHtmlType());
			fieldDataDto.setFieldMasterDto(fieldMasterDto);
			if (fieldEntity.getHtmlType().contains(CommonReportConstant.DROPDOWN_SQL) && 
					!StringUtils.isEmpty(fieldEntity.getQuery())) {
				fieldDataDto.setClueDtos(getClueDtoList(fieldEntity.getQuery(), fieldEntity.getHtmlType()));
			}
			return fieldDataDto;
		}).collect(Collectors.toList());
		responseDto.setAlias(fieldMasterEntityList.get(CommonReportConstant.INT_ZERO).getReportId().getAlias());
		responseDto.setReportName(fieldMasterEntityList.get(CommonReportConstant.INT_ZERO).getReportId().getName());
		responseDto.setFieldData(fieldDataList);
		return responseDto;
	}

	/**
	 * Find fields by report alias.
	 *
	 * @param alias the alias
	 * @return the list
	 */
	private List<CommonFieldMasterEntity> findFieldsByReportAlias(String alias) {
		return fieldMasterRepository.findByReportIdAlias(alias);
	}
	
	/**
	 * Gets the clue dto list.
	 *
	 * @param query the query
	 * @return the clue dto list
	 */
	private List<CommonReportClueDto> getClueDtoList(String query, String htmlType) {
		List<Object[]> queryObjs = reportMasterRepository.executeSQLQueryOnly(query);
		return queryObjs.stream().map(queryObj -> {
			CommonReportClueDto clueDto = new CommonReportClueDto();
			clueDto.setId(Long.valueOf(String.valueOf(queryObj[CommonReportConstant.INT_ZERO])));
			clueDto.setName(String.valueOf(queryObj[CommonReportConstant.INT_ONE]));
			if (htmlType.contains(CommonReportConstant.FY)) {
				clueDto.setIsCurrentYear(Integer.valueOf(String.valueOf(queryObj[CommonReportConstant.INT_TWO])));
			}
			return clueDto;
		}).collect(Collectors.toList());
	}
	
	@Override
	public CommonReportResponseDto viewReportDetails(CommonReportViewPageDetails pageDetails) throws CustomException {
		CommonReportResponseDto responseDto = new CommonReportResponseDto();
		if (pageDetails.getReportAction().equals(CommonReportAction.VIEW)) {
			List<CommonFieldMasterEntity> fieldMasterEntityList = findFieldsByReportAlias(pageDetails.getAlias());
			responseDto.setHeaderDtos(getHeaderDtoData(fieldMasterEntityList));
			List<Object[]> spObjArr = callSpForView(fieldMasterEntityList.get(CommonReportConstant.INT_ZERO)
					.getReportId().getProcName(), pageDetails, fieldMasterEntityList);
			List<String> headerList = responseDto.getHeaderDtos().stream().map(CommonReportHeaderDto::getHeader).collect(Collectors.toList());
			List<Map<String, Object>> dataMap = new ArrayList<>();
			for(int i = CommonReportConstant.INT_ZERO; i < spObjArr.size(); i++) {
				int j = CommonReportConstant.INT_ZERO;
				Map<String, Object> map = new HashMap<>();
				map.put(headerList.get(j++), i + CommonReportConstant.INT_ONE);
				for(Object obj : spObjArr.get(i)) {
					map.put(headerList.get(j++), obj);
				}
				dataMap.add(map);
			}
			responseDto.setData(dataMap);
		}
		return responseDto;
	}
	
	/**
	 * Gets the header dto data.
	 *
	 * @param fieldMasterEntityList the field master entity list
	 * @return the header dto data
	 */
	private List<CommonReportHeaderDto> getHeaderDtoData(List<CommonFieldMasterEntity> fieldMasterEntityList) {
		Predicate<CommonFieldMasterEntity> isDispOrderNo = entity -> null != entity.getDispOrderNo();
		Predicate<CommonFieldMasterEntity> getTypeBoth = entity -> entity.getType().equals(CommonReportConstant.BOTH);
		Predicate<CommonFieldMasterEntity> getTypeOutput = entity -> entity.getType().equals(CommonReportConstant.OUTPUT);
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().
				filter(isDispOrderNo.and((getTypeBoth).or(getTypeOutput))).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
				sorted(Comparator.comparing(CommonFieldMasterEntity::getDispOrderNo)).collect(Collectors.toList());
		return fmEntityList1.stream().map(entity -> new CommonReportHeaderDto(entity.getParamDispName(), entity.getDispOrderNo())).
				collect(Collectors.toList());
	}
	
	/**
	 * Call sp for view.
	 *
	 * @param procName the proc name
	 * @param pageDetails the page details
	 * @param fieldMasterEntityList the field master entity list
	 * @return the list
	 */
	private List<Object[]> callSpForView(String procName, CommonReportViewPageDetails pageDetails, 
			List<CommonFieldMasterEntity> fieldMasterEntityList) {
		Map<String , Object> argsMap = populateArgMapForView(pageDetails, fieldMasterEntityList);
		return reportMasterRepository.callStoredProcedure(procName, argsMap);
	}
	
	/**
	 * Populate arg map for view.
	 *
	 * @param pageDetails the page details
	 * @param fieldMasterEntityList the field master entity list
	 * @return the map
	 */
	private Map<String, Object> populateArgMapForView(CommonReportViewPageDetails pageDetails, 
				List<CommonFieldMasterEntity> fieldMasterEntityList) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetails.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetails.getPageElement());
		List<CommonFieldMasterEntity> fmEntityList = fieldMasterEntityList.stream().filter(entity -> 
				null != entity.getOrderNo()).collect(Collectors.toList());
		List<CommonFieldMasterEntity> fmEntityList1 = fmEntityList.stream().
					sorted(Comparator.comparing(CommonFieldMasterEntity::getOrderNo)).collect(Collectors.toList());
		Map<String, Object> map = pageDetails.getMap();
		map.forEach((key,value) -> {
			Optional<CommonFieldMasterEntity> fieldMasterEntity = fmEntityList1.stream().filter(entity -> 
						entity.getParamUiName().equals(key) && 
						(entity.getType().equals(CommonReportConstant.INPUT) || 
								entity.getType().equals(CommonReportConstant.BOTH) ||
								entity.getType().equals(CommonReportConstant.HIDDEN))).findFirst();
			if (fieldMasterEntity.isPresent()) {
				if (fieldMasterEntity.get().getType().equals(CommonReportConstant.HIDDEN)) {
					argsMap.put(fieldMasterEntity.get().getParamProcName(), 
							OAuthUtility.getOauthMap().get(fieldMasterEntity.get().getParamUiName()));
				} else {
					argsMap.put(fieldMasterEntity.get().getParamProcName(), value);
				}
			}
		});
		return argsMap;
	}
	
}
