package gov.ifms.dmo.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.dmo.dto.DMOGOILoanReportDto;
import gov.ifms.dmo.dto.DMOGOILoanReportSearchDto;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;

@Service
public class DMOGOILoanReportService {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private DMOGOILoanRepository dmoGOILoanRepository;
	
	@SuppressWarnings("unchecked")
	public Object goiMinistryReport(DMOGOILoanReportSearchDto pageDetail) {

		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_MINISTRY_WISE_LOAN_REPORT));
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.IN_FINANCIAL_YR, pageDetail.getFinancialYr());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.MINISTRY_NAME, pageDetail.getMinistryName());
		map1.put(DMOConstant.LOAN_ROI_EQUALS, pageDetail.getLoanROIEquals());
		map1.put(DMOConstant.LOAN_ROI_LESS_THAN, pageDetail.getLoanROILessThan());
		map1.put(DMOConstant.LOAN_ROI_GREATER_THAN, pageDetail.getLoanROIGreaterThan());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_FROM, pageDetail.getLoanROIBetweenFrom());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_TO, pageDetail.getLoanROIBetweenTo());		
		map1.put(DMOConstant.LOAN_AMOUNT_EQUALS, pageDetail.getLoanAmountEquals());
		map1.put(DMOConstant.LOAN_AMOUNT_LESS_THAN, pageDetail.getLoanAmountLessThan());
		map1.put(DMOConstant.LOAN_AMOUNT_GREATER_THAN, pageDetail.getLoanAmountGreaterThan());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_FROM, pageDetail.getLoanAmountBetweenFrom());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_TO, pageDetail.getLoanAmountBetweenTo());
		
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		List<Object[]> arraStrings = dmoGOILoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setDepartmentName(String.valueOf(ar[0]));
			dto.setSanctionOrderNo(String.valueOf(ar[1]));
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[3])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[6])));
			fy.add(dto.getDepartmentName());
			list.add(dto);
		});
		Map<String, List<DMOGOILoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getDepartmentName().equals(fyr)).collect(Collectors.toList()));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Object goiCentralReport(DMOGOILoanReportSearchDto pageDetail) {
		
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_CENTRAL_LOAN_REPORT));
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procName);
		
		// Declare the parameters in the same order
		createINOUTQuery(4, 1, query);
		
		// Pass the parameter values
		setParameter(pageDetail, query);
		
		// Execute query
		query.execute();
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		List<Object[]> arraStrings = query.getResultList();
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setDepartmentName(String.valueOf(ar[0]));
			dto.setMonthName(String.valueOf(ar[1]));
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[4])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setTotalAmount(Double.valueOf(String.valueOf(ar[6])));
			fy.add(dto.getMonthName());
			list.add(dto);
		});
		Map<String, List<DMOGOILoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getMonthName().equals(fyr)).collect(Collectors.toList()));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Object goiSchemeWiseCentralReport(DMOGOILoanReportSearchDto pageDetail) {
		
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_SCHEME_WISE_REPORT));		
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_YR, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_YR, pageDetail.getToDate());		
		map1.put(DMOConstant.LOAN_PURPOSE, pageDetail.getLoanPurpose());
		map1.put(DMOConstant.PLAN_SCHEME, pageDetail.getSchemeName());
		map1.put(DMOConstant.MINISTRY_NAME, pageDetail.getMinistryName());
		map1.put(DMOConstant.LOAN_ROI_EQUALS, pageDetail.getLoanROIEquals());
		map1.put(DMOConstant.LOAN_ROI_LESS_THAN, pageDetail.getLoanROILessThan());
		map1.put(DMOConstant.LOAN_ROI_GREATER_THAN, pageDetail.getLoanROIGreaterThan());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_FROM, pageDetail.getLoanROIBetweenFrom());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_TO, pageDetail.getLoanROIBetweenTo());		
		map1.put(DMOConstant.LOAN_AMOUNT_EQUALS, pageDetail.getLoanAmountEquals());
		map1.put(DMOConstant.LOAN_AMOUNT_LESS_THAN, pageDetail.getLoanAmountLessThan());
		map1.put(DMOConstant.LOAN_AMOUNT_GREATER_THAN, pageDetail.getLoanAmountGreaterThan());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_FROM, pageDetail.getLoanAmountBetweenFrom());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_TO, pageDetail.getLoanAmountBetweenTo());
		
		List<DMOGOILoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		List<Object[]> arraStrings = dmoGOILoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMOGOILoanReportDto dto = new DMOGOILoanReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			dto.setSchemeName(String.valueOf(ar[1]));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[2])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setTotalAmount(Double.valueOf(String.valueOf(ar[4])));
			fy.add(dto.getFinancialYr());
			list.add(dto);
		});
		Map<String, List<DMOGOILoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getFinancialYr().equals(fyr)).collect(Collectors.toList()));
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Object getGoiCentralOutstandingYearly(DMOGOILoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_GOI_OUTSTANDING_YEARLY_REPORT));
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.LOAN_PURPOSE, pageDetail.getLoanPurpose());
		map1.put(DMOConstant.PLAN_SCHEME, pageDetail.getSchemeName());
		map1.put(DMOConstant.MINISTRY_NAME, pageDetail.getMinistryName());
		map1.put(DMOConstant.LOAN_ROI_EQUALS, pageDetail.getLoanROIEquals());
		map1.put(DMOConstant.LOAN_ROI_LESS_THAN, pageDetail.getLoanROILessThan());
		map1.put(DMOConstant.LOAN_ROI_GREATER_THAN, pageDetail.getLoanROIGreaterThan());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_FROM, pageDetail.getLoanROIBetweenFrom());
		map1.put(DMOConstant.LOAN_ROI_BETWEEN_TO, pageDetail.getLoanROIBetweenTo());		
		map1.put(DMOConstant.LOAN_AMOUNT_EQUALS, pageDetail.getLoanAmountEquals());
		map1.put(DMOConstant.LOAN_AMOUNT_LESS_THAN, pageDetail.getLoanAmountLessThan());
		map1.put(DMOConstant.LOAN_AMOUNT_GREATER_THAN, pageDetail.getLoanAmountGreaterThan());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_FROM, pageDetail.getLoanAmountBetweenFrom());
		map1.put(DMOConstant.LOAN_AMOUNT_BETWEEN_TO, pageDetail.getLoanAmountBetweenTo());
	
		List<DMOGOILoanReportSearchDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmoGOILoanRepository.callStoredProcedure(procName, map1);
		Map<String, List<Object[]>> resultMap = arraStrings.stream().collect(Collectors.groupingBy(ar -> String.valueOf(ar[0])));
		resultMap.forEach((key, value) -> {
			DMOGOILoanReportSearchDto dMONSSFLoanReportDto = new DMOGOILoanReportSearchDto();
			dMONSSFLoanReportDto.setFinancialYr(key);
			Double newLoanRecievedSum = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[4]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[4]))).sum();
			Double newLoanRepaidSum = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[6]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[6]))).sum();
			Double weightedAverageInterestRate = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[5]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[5]))).average().orElse(0.0);
			Double openingBalance = (Double)value.stream().filter(Objects::nonNull)
					.sorted(Comparator.comparing(rs -> (BigInteger)rs[1])).findFirst().get()[2];
			Collections.reverse(value);
		    Double closingBalance = (Double)value.stream().filter(Objects::nonNull)
					.sorted(Comparator.comparing(rs -> (BigInteger)rs[1])).findFirst().get()[3];
			 
			dMONSSFLoanReportDto.setOpeningBalanceAmount(BigDecimal.valueOf(openingBalance.doubleValue()));
			dMONSSFLoanReportDto.setClosingAmount(BigDecimal.valueOf(closingBalance.doubleValue()));
			dMONSSFLoanReportDto.setNewLoansRecieved(BigDecimal.valueOf(newLoanRecievedSum.doubleValue()));
			dMONSSFLoanReportDto.setLoanRepaid(BigDecimal.valueOf(newLoanRepaidSum));
			dMONSSFLoanReportDto.setWeightedAverageInterestRate(weightedAverageInterestRate);
			dMONSSFLoanReportDto.setYearId(Long.valueOf(String.valueOf(value.get(0)[7])));
			dMONSSFLoanReportDto.setSchemeName(String.valueOf(value.get(0)[8]));
			list.add(dMONSSFLoanReportDto);
		});
		if (!Utils.isEmpty(list)) {
			long totalPages = !list.isEmpty() ? list.size() : 0;
			return new PagebleDTO<>(Integer.valueOf(pageDetail.getPageSize()), 0, totalPages, list);
		} else {
			return list;
		}
	}

	private void setParameter(DMOGOILoanReportSearchDto pageDetail, StoredProcedureQuery query) {
		query.setParameter(1, pageDetail.getPageIndex());
		query.setParameter(2, pageDetail.getPageSize());
		query.setParameter(3, pageDetail.getFromDate());
		query.setParameter(4, pageDetail.getToDate());

	}

	private void createINOUTQuery(int countin, int countout, StoredProcedureQuery query) {
		for (int i = 1; i <= countin; i++) {
			query.registerStoredProcedureParameter(i, String.class, ParameterMode.IN);
		}
		for (int i = 1; i <= countout; i++) {
			query.registerStoredProcedureParameter(i, String.class, ParameterMode.OUT);
		}
	}

}
