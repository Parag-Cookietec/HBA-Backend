package gov.ifms.dmo.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.util.Constant;
import gov.ifms.dmo.dto.DMOLoanRepayListReportDto;
import gov.ifms.dmo.dto.DMOLoanRepayReportDto;
import gov.ifms.dmo.dto.DMOLoanRepayReportSearchDto;
import gov.ifms.dmo.repository.DMOGOILoanRepository;
import gov.ifms.dmo.repository.DMOInstitutionLoanRepository;
import gov.ifms.dmo.repository.DMOMarketLoanRepository;
import gov.ifms.dmo.repository.DMONSSFLoanRepository;
import gov.ifms.dmo.utils.DMOConstant;
import gov.ifms.dmo.utils.DMODBConstants;

@Service
public class DMOLoanRepayReportService {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	DMOInstitutionLoanRepository institutionLoanRepository;
	@Autowired
	DMOGOILoanRepository dmogoiLoanRepository;
	@Autowired
	DMONSSFLoanRepository dmonssfLoanRepository;
	@Autowired
	DMOMarketLoanRepository dmoMarketLoanRepository;

	@SuppressWarnings("unchecked")
	public Object dmoLoanRepayReport(DMOLoanRepayReportSearchDto pageDetail) {

		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_LOAN_REPAYMENT_SCHEDULE_REPORT));
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procName);

		// Declare the parameters in the same order
		createINOUTQuery(11, 1, query);

		// Pass the parameter values
		setParameter(pageDetail, query);
		query.setParameter(5, pageDetail.getTypeOfLoan());
		query.setParameter(6, pageDetail.getSanctionNo());
		query.setParameter(7, pageDetail.getLoanPurpose());
		query.setParameter(8, pageDetail.getSchemeName());
		query.setParameter(9, pageDetail.getMinistryName());
		query.setParameter(10, pageDetail.getLoanDescription());
		query.setParameter(11, pageDetail.getInstituteId());

		// Execute query
		query.execute();
		List<DMOLoanRepayReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = query.getResultList();
		arraStrings.forEach(ar -> {
			DMOLoanRepayReportDto dto = new DMOLoanRepayReportDto();
			dto.setId(Long.valueOf(String.valueOf(ar[0])));
			if(pageDetail.getTypeOfLoan().equals("1") || pageDetail.getTypeOfLoan().equals("2")) {
				dto.setSanctionNo(String.valueOf(ar[1]));
			}else if(pageDetail.getTypeOfLoan().equals("3")) {
				dto.setLoanDescription(String.valueOf(ar[1]));
			}else {
				dto.setAccountNo(String.valueOf(ar[1]));
			}
			dto.setLoanStartDt(LocalDate.parse(String.valueOf(ar[2])));
			dto.setLoanTenure(Integer.valueOf(String.valueOf(ar[3])));
			dto.setMoratoriumPeriod(Integer.valueOf(String.valueOf(ar[4])));
			dto.setLoanAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setLoanROI(Double.valueOf(String.valueOf(ar[6])));
			list.add(dto);
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	public Object loanRepayDetailReport(DMOLoanRepayReportSearchDto pageDetail) {
		
		String procName = DMOConstant.DMO_SCHEMA
				.concat(Constant.DOT.concat(DMODBConstants.SP_LOAN_REPAYMENT_REPORT));
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery(procName);
		
		// Declare the parameters in the same order
		createINOUTQuery(4, 1, query);
		
		// Pass the parameter values
		query.setParameter(1, pageDetail.getNssfId());
		query.setParameter(2, pageDetail.getGoiId());
		query.setParameter(3, pageDetail.getMarketId());
		query.setParameter(4, pageDetail.getInstitutionId());
		
		// Execute query
		query.execute();
		DMOLoanRepayReportDto reportDto = setHdrData(pageDetail);
		List<DMOLoanRepayListReportDto> list = new ArrayList<>();
		// Get output parameters
		List<Object[]> arraStrings = query.getResultList();
		arraStrings.forEach(ar -> {
			DMOLoanRepayListReportDto dto = new DMOLoanRepayListReportDto();
			dto.setFinancialYr(String.valueOf(ar[0]));
			dto.setInstallmentDt(LocalDate.parse(String.valueOf(ar[1])));
			dto.setOpeningBalance(Double.valueOf(String.valueOf(ar[2])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[3])));
			dto.setInterestAmount(Double.valueOf(String.valueOf(ar[4])));
			dto.setPrincipalAmount(Double.valueOf(String.valueOf(ar[5])));
			dto.setPrincipalPaidAmount(Double.valueOf(String.valueOf(ar[6])));
			if(!pageDetail.getGoiId().equals("")) {
				dto.setInterestPaidAmount(Double.valueOf(String.valueOf(ar[7])));
				dto.setLoanROI(Double.valueOf(String.valueOf(ar[6])));
			}else {
				dto.setInterestPaidAmount(Double.valueOf(String.valueOf(ar[7])));
				dto.setLoanROI(Double.valueOf(String.valueOf(ar[8])));
			}
			dto.setLoanROI(reportDto.getLoanROI());
			list.add(dto);
		});
		reportDto.setLoanRepay(list);
		return reportDto;
	}
	
	private DMOLoanRepayReportDto setHdrData(DMOLoanRepayReportSearchDto pageDetail) {
		DMOLoanRepayReportDto dto = new DMOLoanRepayReportDto();
		if(!pageDetail.getNssfId().equals("")) {
			dmonssfLoanRepository.findById(Long.valueOf(pageDetail.getNssfId())).ifPresent(nssf->{
				dto.setSanctionNo(nssf.getSanctionOrderNo());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		} 
		if(!pageDetail.getGoiId().equals("")) {
			dmogoiLoanRepository.findById(Long.valueOf(pageDetail.getGoiId())).ifPresent(nssf->{
				dto.setSanctionNo(nssf.getSanctionOrderNo());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		} 
		if(!pageDetail.getMarketId().equals("")) {
			dmoMarketLoanRepository.findById(Long.valueOf(pageDetail.getMarketId())).ifPresent(nssf->{
				dto.setLoanDescription(nssf.getTransactionDesc());
				dto.setLoanStartDt(nssf.getLoanStartDt());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratoriumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanRoi());
			});
		}
		if(!pageDetail.getInstitutionId().equals("")) {
			institutionLoanRepository.findById(Long.valueOf(pageDetail.getInstitutionId())).ifPresent(nssf->{
				dto.setAccountNo(nssf.getLoanAccNumber());
				dto.setLoanStartDt(nssf.getLoanStartDate());
				dto.setLoanTenure(nssf.getLoanTenure());
				dto.setMoratoriumPeriod(nssf.getMoratariumPeriod());
				dto.setLoanAmount(nssf.getLoanAmount());
				dto.setLoanROI(nssf.getLoanROI());
			});
		}
		return dto;
	}
	
	private void setParameter(DMOLoanRepayReportSearchDto pageDetail, StoredProcedureQuery query) {
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
