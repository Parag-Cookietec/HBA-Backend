package gov.ifms.dmo.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ResponseUtil;
import gov.ifms.dmo.dto.DMOGOILoanPostDto;
import gov.ifms.dmo.dto.DMOGOILoanRePaymentDto;
import gov.ifms.dmo.dto.DMOMarketLoanDto;
import gov.ifms.dmo.dto.DMOMarketLoanRePaymentDto;
import gov.ifms.dmo.dto.DMONSSFLoanPostDto;
import gov.ifms.dmo.dto.DMONSSFLoanRePaymentDto;

/**
 * The Class DMOUtility.
 * 
 * @version v 1.0.
 * @created 2021/07/13 11:40:45.
 *
 */
public class DMOUtility {

	/**
	 * Populate arguments.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	
	public static Map<String, Object> populateArguments(PageDetails pageDetail) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> argsMap.put(DMODBConstants.getDPSheetListing().get(search.getKey()), search.getValue()));
		} else {
			DMODBConstants.getDPSheetListing()
					.forEach((k, v) -> argsMap.put(DMODBConstants.getDPSheetListing().get(k), 0));
		}
		return argsMap;
	}
	
	
	public static List<DMONSSFLoanRePaymentDto> rePaymentUtility(DMONSSFLoanPostDto dto) {
		List<DMONSSFLoanRePaymentDto> repayments = new ArrayList<>();
		double openingBal = dto.getLoanAmount();
		LocalDate date = dto.getFirstInstallDate();
		int installment = dto.getLoanTenure() * dto.getPrncplInstallYear();
		double interest = (dto.getLoanAmount() * dto.getLoanROI()) / 100;
		double principal = (dto.getLoanAmount() / (dto.getLoanTenure() - dto.getMoratariumPeriod())) / dto.getPrncplInstallYear();
		for(int i = 0; i< installment; i++) {
			DMONSSFLoanRePaymentDto repayment = new DMONSSFLoanRePaymentDto();
			if(dto.getPrncplInstallYear() > i) {
				repayment.setPrincipalAmount(0.0);
				repayment.setOpeningBalanceAmount(dto.getLoanAmount());
			}else {
				repayment.setPrincipalAmount(principal);                                                                                                                                                                             
				repayment.setOpeningBalanceAmount(openingBal);
			}
			repayment.setInstallDueDate(date);
			repayment.setIntrestAmount(interest);
			repayment.setClosingBalAmount(repayment.getOpeningBalanceAmount() - repayment.getPrincipalAmount());
			repayment.setRePaymentNo(i);
			repayment.setDpSheetRecDate(dto.getDpSheetRecDate());
			repayment.setLoanNumber(dto.getLoanNumber());
			repayment.setDpSheetEntity(dto.getDpSheetId());
			repayment.setNssfLoanId(dto.getId());
			openingBal = repayment.getClosingBalAmount();
			date = date.plusMonths(dto.getPrncplInstallYear() - 1);
			repayments.add(repayment);
		}
		return repayments;
	}

	public static List<DMOGOILoanRePaymentDto> rePaymentGOIUtility(DMOGOILoanPostDto dto) {
		List<DMOGOILoanRePaymentDto> repayments = new ArrayList<>();
		double openingBal = dto.getLoanAmount();
		LocalDate date = dto.getInterestFirstInstallDate();
		int installment = dto.getLoanTenure() * dto.getPrncplInstallYear();
		double interest = (dto.getLoanAmount() * dto.getLoanROI()) / 100;
		double principal = (dto.getLoanAmount() / (dto.getLoanTenure() - dto.getMoratariumPeriod())) / dto.getPrncplInstallYear();
		for(int i = 0; i< installment; i++) {
			DMOGOILoanRePaymentDto repayment = new DMOGOILoanRePaymentDto();
			if(dto.getPrncplInstallYear() > i) {
				repayment.setPrincipalAmount(0.0);
				repayment.setOpeningBalanceAmount(dto.getLoanAmount());
			}else {
				repayment.setPrincipalAmount(principal);
				repayment.setOpeningBalanceAmount(openingBal);
			}
			repayment.setIntrestRate(dto.getLoanROI());
			repayment.setLoanAmount(dto.getLoanAmount());
			repayment.setInstallDueDate(date);
			repayment.setIntrestAmount(interest);
			repayment.setClosingBalAmount(repayment.getOpeningBalanceAmount() - repayment.getPrincipalAmount());
			repayment.setRePaymentNo(i);
			repayment.setDpSheetRecDate(dto.getDpSheetRecDate());
			repayment.setLoanNumber(dto.getLoanNumber());
			repayment.setDpSheetEntity(dto.getDpSheetId());
			repayment.setGoiLoanId(dto.getId());
			repayment.setActiveStatus(1);
			openingBal = repayment.getClosingBalAmount();
			date = date.plusMonths(dto.getPrncplInstallYear() - 1);
			repayments.add(repayment);
		}
		return repayments;
	}

	public static List<DMOMarketLoanRePaymentDto> rePaymentMarketUtility(DMOMarketLoanDto dto) {
		List<DMOMarketLoanRePaymentDto> repayments = new ArrayList<>();
		double openingBal = dto.getLoanAmount();
		LocalDate date = dto.getIntrstFirstInstallDt();
		int installment = dto.getLoanTenure() * dto.getInterstInstallYr();
		double interest = (dto.getLoanAmount() * dto.getLoanRoi()) / 100;
		double principal = (dto.getLoanAmount() / (dto.getLoanTenure() - dto.getMoratoriumPeriod())) / dto.getInterstInstallYr();
		for(int i = 0; i< installment; i++) {
			DMOMarketLoanRePaymentDto repayment = new DMOMarketLoanRePaymentDto();
			if(dto.getInterstInstallYr() > i) {
				repayment.setPrincipalAmount(0.0);
				repayment.setOpeningBalAmt(dto.getLoanAmount());
			}else {
				repayment.setPrincipalAmount(principal);
				repayment.setOpeningBalAmt(openingBal);
			}
			repayment.setInstallDueDt(date);
			repayment.setInterstAmount(interest);
			repayment.setClosingBalAmt(repayment.getOpeningBalAmt() - repayment.getPrincipalAmount());
			repayment.setRepaymentSrno(i);
			repayment.setLdSheetRecvDt(dto.getDpSheetRecvDt());
			repayment.setLoanNumber(dto.getLoanNumber());
			repayment.setDpSheetId(dto.getDpSheetId());
			repayment.setMarketLoanHdrId(dto.getId());
			repayment.setActiveStatus(1);
			openingBal = repayment.getClosingBalAmt();
			date = date.plusMonths(dto.getInterstInstallYr() - 1);
			repayments.add(repayment);
		}
		return repayments;
	}
	
	/**
	 * Gets the string value.
	 *
	 * @param obj the obj
	 * @return the string value
	 */
	public static String convertObjectToString(Object obj) {
		try {
			if (obj == null || String.valueOf(obj).isEmpty())
				return "";
			else {
				return String.valueOf(obj);
			}
		} catch (Exception ex) {
			return "";
		}
	}
	
	public static Integer checkDecimal(Double value) {
		String doubleAsString = String.valueOf(value);
		int indexOfDecimal = doubleAsString.indexOf(".");
		int val = 0;
		if(Double.valueOf(doubleAsString.substring(indexOfDecimal)) == 0.0) {
			val = Integer.valueOf(doubleAsString.substring(0, indexOfDecimal));
		}else {
			val = Integer.valueOf(doubleAsString.substring(0, indexOfDecimal)) + 1;
		}
		return val;
	}
	
	public static BigDecimal convertAmount(final BigDecimal amount, final String amountIn) {
		if(Objects.isNull(amount) || amount.equals(0.0)) {
			return BigDecimal.ZERO;
		}
		switch(amountIn) {
		case "THOUSAND":
			return amount.divide(BigDecimal.valueOf(1000));
		case "LACS":
			return amount.divide(BigDecimal.valueOf(100000));
		case "CRORE":
			return amount.divide(BigDecimal.valueOf(10000000));
		default :
			return amount;
		}
	}
}
