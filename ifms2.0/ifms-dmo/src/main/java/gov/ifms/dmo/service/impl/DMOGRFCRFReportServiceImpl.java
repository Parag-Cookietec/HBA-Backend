package gov.ifms.dmo.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMOGRFCRFReportDto;
import gov.ifms.dmo.dto.DMOGRFCRFReportPostDto;
import gov.ifms.dmo.dto.DMOGRFCRFStatementReportDto;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.repository.DMOGRFCRFReportRepository;
import gov.ifms.dmo.service.DMOGRFCRFLuLookUpService;
import gov.ifms.dmo.service.DMOGRFCRFReportService;
import gov.ifms.dmo.utils.DMOConstant;

@Service
public class DMOGRFCRFReportServiceImpl implements DMOGRFCRFReportService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private DMOGRFCRFReportRepository grfcrfReportRepos;

	@Autowired
	private DMOGRFCRFLuLookUpService lookupService;

	@Override
	public PagebleDTO<DMOGRFCRFReportDto> investmentSaleReport(DMOGRFCRFReportPostDto dto) throws CustomException {
		try {
			Map<String, Object> spParamMap = new HashMap<>();
			String financialYear = dto.getFinancialYear();
			String investFromId = dto.getInvestFromId();
			String fromDate = dto.getFromDate();
			String toDate = dto.getToDate();
			if (StringUtils.isNotBlank(financialYear)) {
				List<String> items = Arrays.asList(financialYear.split("-"));
				spParamMap.put(DMOConstant.IN_FROM_DT, items.get(0) + DMOConstant._04_01);
				spParamMap.put(DMOConstant.IN_TO_DT, items.get(1) + DMOConstant._03_31);
			}
			if (StringUtils.isNotBlank(fromDate) && StringUtils.isNotBlank(toDate)) {
				spParamMap.put(DMOConstant.IN_FROM_DT, fromDate);
				spParamMap.put(DMOConstant.IN_TO_DT, toDate);
			}
			if (StringUtils.isNotBlank(investFromId) && investFromId.equals(DMOConstant.ALL)) {
				DMOLookUpDto lookUpDto = new DMOLookUpDto();
				lookUpDto.setName("Investment Form");
				List<DMOLookUpDto> list = lookupService.fetchLookUpData(lookUpDto);
				List<Long> ids = list.stream().map(DMOLookUpDto::getId).collect(Collectors.toList());
				logger.info("ids {} ", ids);
				String txnIds = ids.toString().replace("[", "").replace("]", "");
				logger.info("ids string {} ", txnIds);
				spParamMap.put(DMOConstant.IN_INVEST_FRM_ID, txnIds);
			} else {
				spParamMap.put(DMOConstant.IN_INVEST_FRM_ID, investFromId);
			}
			spParamMap.put(DMOConstant.IN_ACCOUNT_TYPE_ID, dto.getAccountTypeId());
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageSize());
			String procName = DMOConstant.DMO_SCHEMA
					.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_INVST_SALE_REPORT));
			List<Object[]> responseList = grfcrfReportRepos.callStoredProcedure(procName, spParamMap);
			List<DMOGRFCRFReportDto> response = NativeQueryResultsMapper.map(responseList, DMOGRFCRFReportDto.class);
			return new PagebleDTO<>(dto.getPageSize(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					response);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public PagebleDTO<DMOGRFCRFStatementReportDto> statementReport(DMOGRFCRFReportPostDto dto) throws CustomException {
		try {
			Map<String, Object> spParamMap = new HashMap<>();
			String fromDate = dto.getFromDate();
			String toDate = dto.getToDate();
			spParamMap.put(DMOConstant.IN_FROM_DT, fromDate);
			spParamMap.put(DMOConstant.IN_TO_DT, toDate);
			spParamMap.put(DMOConstant.IN_ACCOUNT_TYPE_ID, dto.getAccountTypeId());
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageSize());
			String procName = DMOConstant.DMO_SCHEMA
					.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_STATEMENT_REPORT));
			List<Object[]> responseList = grfcrfReportRepos.callStoredProcedure(procName, spParamMap);
			List<DMOGRFCRFStatementReportDto> response = NativeQueryResultsMapper.map(responseList,
					DMOGRFCRFStatementReportDto.class);
			return new PagebleDTO<>(dto.getPageSize(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					response);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public PagebleDTO<DMOGRFCRFReportDto> totalInvestmentSecurityReport(DMOGRFCRFReportPostDto dto)
			throws CustomException {
		try {
			Map<String, Object> spParamMap = new HashMap<>();
			String financialYear = dto.getFinancialYear();
			String typeOfSecurity = dto.getTypeOfSecurity();
			if (StringUtils.isNotBlank(financialYear)) {
				List<String> items = Arrays.asList(financialYear.split("-"));
				spParamMap.put(DMOConstant.IN_FROM_DT, items.get(0) + DMOConstant._04_01);
				spParamMap.put(DMOConstant.IN_TO_DT, items.get(1) + DMOConstant._03_31);
			}
			spParamMap.put(DMOConstant.IN_ACCOUNT_TYPE_ID, dto.getAccountTypeId());
			spParamMap.put(DMOConstant.IN_SECURITY_TYPE_ID, typeOfSecurity);
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageSize());
			String procName = DMOConstant.DMO_SCHEMA
					.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_TOTAL_INVEST_SECURITY_REPORT));
			List<Object[]> responseList = grfcrfReportRepos.callStoredProcedure(procName, spParamMap);
			List<DMOGRFCRFReportDto> response = NativeQueryResultsMapper.map(responseList, DMOGRFCRFReportDto.class);
			return new PagebleDTO<>(dto.getPageSize(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					response);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	@Override
	public PagebleDTO<DMOGRFCRFReportDto> yearWiseMaturityInvestmentReport(DMOGRFCRFReportPostDto dto)
			throws CustomException {
		try {
			Map<String, Object> spParamMap = new HashMap<>();
			String fromDate = dto.getFromDate();
			String toDate = dto.getToDate();
			if (StringUtils.isNotBlank(fromDate)) {
				List<String> items = Arrays.asList(fromDate.split("-"));
				spParamMap.put(DMOConstant.IN_FROM_DT, items.get(0) + DMOConstant._04_01);
			}
			if (StringUtils.isNotBlank(toDate)) {
				List<String> items = Arrays.asList(toDate.split("-"));
				spParamMap.put(DMOConstant.IN_TO_DT, items.get(1) + DMOConstant._03_31);
			}
			spParamMap.put(DMOConstant.IN_ACCOUNT_TYPE_ID, dto.getAccountTypeId());
			spParamMap.put(DMOConstant.IN_PAGE_INDEX, dto.getPageIndex());
			spParamMap.put(DMOConstant.IN_PAGE_SIZE, dto.getPageSize());
			String procName = DMOConstant.DMO_SCHEMA
					.concat(Constant.DOT.concat(DMOConstant.SP_GRFCRF_YR_WISE_MATURITY_INVST_REPORT));
			List<Object[]> responseList = grfcrfReportRepos.callStoredProcedure(procName, spParamMap);
			List<DMOGRFCRFReportDto> response = NativeQueryResultsMapper.map(responseList, DMOGRFCRFReportDto.class);
			return new PagebleDTO<>(dto.getPageSize(), 0, response.isEmpty() ? 0 : response.get(0).getCount(),
					response);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}
