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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.dmo.dto.DMONSSFLoanReportDto;
import gov.ifms.dmo.dto.DMONSSFLoanReportSearchDto;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;
import gov.ifms.dmo.utils.DMOUtility;

@Service
public class DMONSSFLoanReportService {

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private DMONSSFLoanRepository dmonssfLoanRepository;

	@SuppressWarnings("unchecked")
	public Object nssfReceiptReport(DMONSSFLoanReportSearchDto pageDetail)  {

		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_LOAN_RECEIPT_REPORT));		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setSanctionNo(String.valueOf(ar[0]));
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[2])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[3])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[5]))));
			dto.setFinancialYr(String.valueOf(ar[6]));
			fy.add(dto.getFinancialYr());
			list.add(dto);
		});
		Map<String, List<DMONSSFLoanReportDto>> map = new HashMap<>();
			for (String fyr : fy) {
				map.put(fyr, list.stream().filter(a -> a.getFinancialYr().equals(fyr)).collect(Collectors.toList()));
			}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Object nssfMonthlyReceipt(DMONSSFLoanReportSearchDto pageDetail) {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_LOAN_MONTHLY_REPORT));
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procName);

		// Declare the parameters in the same order
		createINOUTQuery(5, 1, query);

		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getSanctionNo());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		Set<String> fy = new HashSet<>();
		// Get output parameters
		List<Object[]> arraStrings = query.getResultList();
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setMonthName(String.valueOf(ar[0]));
			dto.setSanctionNo(String.valueOf(ar[1]));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[3])));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[4]))));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[5]))));
			dto.setTotalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[6]))));
			dto.setFinancialYr(String.valueOf(ar[7]));
			dto.setMonthName(String.valueOf(ar[11]));
			dto.setMonthNo(String.valueOf(ar[10]));
			dto.setYearId(Long.valueOf(String.valueOf(ar[8])));
			dto.setYearName(String.valueOf(ar[9]));
			final Double repaymentOutstandingPercentage = (dto.getOutstandingAmount() / dto.getPrincipalAmount().doubleValue())*100;
			dto.setRepaymentOutstandingPercentage(Double.isNaN(repaymentOutstandingPercentage) ? 0.0 : repaymentOutstandingPercentage);
			fy.add(dto.getMonthName());
			list.add(dto);
		});
		Map<String, List<DMONSSFLoanReportDto>> map = new HashMap<>();
		for (String fyr : fy) {
			map.put(fyr, list.stream().filter(a -> a.getMonthName().equals(fyr)).collect(Collectors.toList()));
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Object nssfOutstanding(DMONSSFLoanReportSearchDto pageDetail) {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_TOTAL_OUTSTANDING_REPORT));
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procName);

		// Declare the parameters in the same order
		createINOUTQuery(5, 1, query);

		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getSanctionNo());
		// Execute query
		query.execute();
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = query.getResultList();
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setSanctionNo(String.valueOf(ar[0]));
			dto.setLoanReceiptDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[3]))));
			dto.setOutstandingAmount(Double.valueOf(String.valueOf(ar[4])));
			final Double repaymentOutstandingPercentage = (dto.getOutstandingAmount() / dto.getPrincipalAmount().doubleValue())*100;
			dto.setRepaymentOutstandingPercentage(Double.isNaN(repaymentOutstandingPercentage) ? 0.0 : repaymentOutstandingPercentage);
			dto.setFinancialYr(String.valueOf(ar[5]));
			dto.setMonthName(String.valueOf(ar[9]));
			dto.setMonthNo(String.valueOf(ar[8]));
			dto.setYearId(Long.valueOf(String.valueOf(ar[6])));
			dto.setYearName(String.valueOf(ar[7]));
			
			list.add(dto);
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object nssfRepaidYearly(DMONSSFLoanReportSearchDto pageDetail) {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_YEARLY_REPORT));
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
	
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			if(StringUtils.isNotEmpty(pageDetail.getAmountIn())) {
			dto.setInterestAmount(DMOUtility.convertAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[1]))), pageDetail.getAmountIn()));
			dto.setPrincipalAmount(DMOUtility.convertAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))), pageDetail.getAmountIn()));
			dto.setTotalAmount(BigDecimal.valueOf(Double.sum(dto.getPrincipalAmount().doubleValue() ,dto.getInterestAmount().doubleValue())));	
			}
			else {
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[1])).doubleValue()));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2])).doubleValue()));
			dto.setTotalAmount(BigDecimal.valueOf(Double.sum(dto.getPrincipalAmount().doubleValue() ,dto.getInterestAmount().doubleValue())));	
			}
			final Double repaymentOutstandingPercentage = (dto.getOutstandingAmount()/dto.getPrincipalAmount().doubleValue())* 100;
			dto.setRepaymentOutstandingPercentage(Double.isNaN(repaymentOutstandingPercentage) ? 0.0 : repaymentOutstandingPercentage);
			dto.setMonthName(String.valueOf(ar[6]));
			dto.setMonthNo(String.valueOf(ar[5]));
			dto.setYearId(Long.valueOf(String.valueOf(ar[3])));
			dto.setYearName(String.valueOf(ar[4]));
			list.add(dto);
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object nssfRepaidMonthly(DMONSSFLoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_MONTHLY_REPORT));
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_YEAR, pageDetail.getFinancialYearId());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
		
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setMonthName(String.valueOf(ar[6]));
			dto.setMonthNo(String.valueOf(ar[0]));
			dto.setFinancialYr(String.valueOf(ar[4]));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[3]))));
			dto.setTotalAmount(BigDecimal.valueOf(dto.getPrincipalAmount().doubleValue() + dto.getInterestAmount().doubleValue()));
			dto.setYearId(Long.valueOf(String.valueOf(ar[1])));
			dto.setYearName(String.valueOf(ar[5]));
			final Double repaymentOutstandingPercentage = (dto.getOutstandingAmount() / dto.getPrincipalAmount().doubleValue())*100;
			dto.setRepaymentOutstandingPercentage(Double.isNaN(repaymentOutstandingPercentage) ? 0.0 : repaymentOutstandingPercentage);
			list.add(dto);
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object nssfRepaidDateWise(DMONSSFLoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_REPAID_DATE_WISE_REPORT));
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_YEAR, pageDetail.getFinancialYearId());
		map1.put(DMOConstant.IN_MONTH, pageDetail.getMonthNo());		
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
		
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setPaymentDt(LocalDate.parse(String.valueOf(ar[0])));
			dto.setSanctionNo(String.valueOf(ar[1]));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[2]))));
			dto.setLoanReceiptDt(LocalDate.parse(String.valueOf(ar[3])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[5])));
			dto.setPrincipalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[6]))));
			dto.setInterestAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[7]))));
			dto.setTotalAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[8]))));
			final Double repaymentOutstandingPercentage = (dto.getOutstandingAmount() / dto.getPrincipalAmount().doubleValue())*100;
			dto.setRepaymentOutstandingPercentage(Double.isNaN(repaymentOutstandingPercentage) ? 0.0 : repaymentOutstandingPercentage);
			dto.setMonthName(String.valueOf(ar[13]));
			dto.setMonthNo(String.valueOf(ar[12]));
			dto.setYearId(Long.valueOf(String.valueOf(ar[10])));
			dto.setYearName(String.valueOf(ar[11]));
			dto.setFinancialYr(String.valueOf(ar[9]));
			list.add(dto);
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object getNssfLoanOutstandingYearly(DMONSSFLoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_OUTSTANDING_YEARLY_REPORT));
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
	
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		Map<String, List<Object[]>> resultMap = arraStrings.stream().collect(Collectors.groupingBy(ar -> String.valueOf(ar[0])));
		resultMap.forEach((key, value) -> {
			DMONSSFLoanReportDto dMONSSFLoanReportDto = new DMONSSFLoanReportDto();
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
			list.add(dMONSSFLoanReportDto);
		});
		if (!Utils.isEmpty(list)) {
			long totalPages = !list.isEmpty() ? list.size() : 0;
			return new PagebleDTO<>(Integer.valueOf(pageDetail.getPageSize()), 0, totalPages, list);
		} else {
			return list;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object getNssfLoanOutstandingMonthly(DMONSSFLoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_OUTSTANDING_MONTHLY_REPORT));
		
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_FROM_DT, pageDetail.getFromDate());
		map1.put(DMOConstant.IN_TO_DT, pageDetail.getToDate());
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
	
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		Map<String, List<Object[]>> resultMap = arraStrings.stream().collect(Collectors.groupingBy(ar -> String.valueOf(ar[2]).concat("-").concat(String.valueOf(ar[1]))));
		resultMap.forEach((key, value) -> {
			DMONSSFLoanReportDto dMONSSFLoanReportDto = new DMONSSFLoanReportDto();
			dMONSSFLoanReportDto.setMonthWithYear(key);				
			Double newLoanRecievedSum = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[7]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[7]))).sum();
			Double newLoanRepaidSum = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[9]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[9]))).sum();
			Double weightedAverageInterestRate = value.stream().filter(rs -> Objects.nonNull(rs) && Objects.nonNull(rs[8]))
					.mapToDouble(rs -> Double.valueOf(String.valueOf(rs[8]))).average().orElse(0.0);
			Double openingBalance = (Double)value.stream().filter(Objects::nonNull)
					.sorted(Comparator.comparing(rs -> (BigInteger)rs[4])).findFirst().get()[5];
			Collections.reverse(value);
		    Double closingBalance = (Double)value.stream().filter(Objects::nonNull)
					.sorted(Comparator.comparing(rs -> (BigInteger)rs[4])).findFirst().get()[6];
			 
			dMONSSFLoanReportDto.setOpeningBalanceAmount(BigDecimal.valueOf(openingBalance.doubleValue()));
			dMONSSFLoanReportDto.setClosingAmount(BigDecimal.valueOf(closingBalance.doubleValue()));
			dMONSSFLoanReportDto.setNewLoansRecieved(BigDecimal.valueOf(newLoanRecievedSum.doubleValue()));
			dMONSSFLoanReportDto.setLoanRepaid(BigDecimal.valueOf(newLoanRepaidSum));
			dMONSSFLoanReportDto.setWeightedAverageInterestRate(weightedAverageInterestRate);
			dMONSSFLoanReportDto.setFinancialYr(String.valueOf(value.get(0)[0]));
			dMONSSFLoanReportDto.setMonthNo(String.valueOf(value.get(0)[3]));
			dMONSSFLoanReportDto.setMonthName(String.valueOf(value.get(0)[2]));
			dMONSSFLoanReportDto.setYearName(String.valueOf(value.get(0)[1]));
			list.add(dMONSSFLoanReportDto);			
		});
		if (!Utils.isEmpty(list)) {
			List<DMONSSFLoanReportDto> sortedList = list.stream().sorted(Comparator.comparing(DMONSSFLoanReportDto::getFinancialYr).thenComparing(DMONSSFLoanReportDto::getMonthNo)).collect(Collectors.toList());
			Collections.sort(sortedList, Comparator.comparing(DMONSSFLoanReportDto::getFinancialYr)
		            .thenComparing(DMONSSFLoanReportDto::getMonthNo));
			long totalPages = !sortedList.isEmpty() ? sortedList.size() : 0;
			return new PagebleDTO<>(Integer.valueOf(pageDetail.getPageSize()), 0, totalPages, sortedList);
		} else {
			return list;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Object nssfOutstandingDateWise(DMONSSFLoanReportSearchDto pageDetail)  {
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_NSSF_OUTSTANDING_DATE_WISE_REPORT));
		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put(DMOConstant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map1.put(DMOConstant.IN_PAGE_SIZE, pageDetail.getPageSize());
		map1.put(DMOConstant.IN_YEAR, pageDetail.getFinancialYearId());
		map1.put(DMOConstant.IN_MONTH, pageDetail.getMonthNo());		
		map1.put(DMOConstant.LOAN_TENURE, pageDetail.getLoanTenure());
		map1.put(DMOConstant.SANCTION_NO, pageDetail.getSanctionNo());
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
		
		List<DMONSSFLoanReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = dmonssfLoanRepository.callStoredProcedure(procName, map1);
		arraStrings.forEach(ar -> {
			DMONSSFLoanReportDto dto = new DMONSSFLoanReportDto();
			dto.setLoanReceiptDt(LocalDate.parse(String.valueOf(ar[0])));
			dto.setSanctionNo(String.valueOf(ar[1]));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[2])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[3])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(BigDecimal.valueOf(Double.valueOf(String.valueOf(ar[5]))));			
			dto.setMonthName(String.valueOf(ar[10]));
			dto.setMonthNo(String.valueOf(ar[9]));
			dto.setYearId(Long.valueOf(String.valueOf(ar[7])));
			dto.setYearName(String.valueOf(ar[8]));
			dto.setFinancialYr(String.valueOf(ar[6]));
			list.add(dto);
		});
		return list;
	}
	
	public static String doubleToString(final Double d) {
	    if (d == null)
	        return null;
	    if (d.isNaN() || d.isInfinite())
	        return d.toString();

	    return new BigDecimal(d.toString()).stripTrailingZeros().toPlainString();
	}
	
	private void setParameter(DMONSSFLoanReportSearchDto pageDetail, StoredProcedureQuery query) {
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
