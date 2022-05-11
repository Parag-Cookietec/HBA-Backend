package gov.ifms.dmo.scheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.dmo.entity.DMODPSheetEntryEntity;
import gov.ifms.dmo.entity.DMODPSheetHDREntity;
import gov.ifms.dmo.repository.DMODPSheetEntryHRDRepository;
import gov.ifms.dmo.repository.DMODPSheetEntryRepository;
import gov.ifms.edp.repository.EDPMsFinancialYearRepository;

@Service
public class DPSheetSchedulerService {

	@Autowired
	DMODPSheetEntryHRDRepository hrdRepository;

	@Autowired
	DMODPSheetEntryRepository dtlRepository;
	
	@Autowired
	EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	private static Logger logger = LoggerFactory.getLogger(DPSheetSchedulerService.class);

	// @Scheduled(fixedRate = 5000)
	public String readApi() {
		logger.info("Api Expression Current time is :: {}", Calendar.getInstance().getTime());
		try {
			buildHdr(LoadXmlScheduler.loadRequestPayloadForHdr());
			buildDtl(LoadXmlScheduler.loadRequestPayloadForDtl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Data Extract Successfully !!";
	}

	@Transactional
	private void buildHdr(DPHdrFaxRequestPayload requestPayload) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		if (!hrdRepository.findByDpSheetReciveDate(
				LocalDate.parse(requestPayload.getBkToCstmrAcctRpt().getRpt().getCreDtTm(), format))
				.isPresent()) {
			Rpt rpt = requestPayload.getBkToCstmrAcctRpt().getRpt();
			DMODPSheetHDREntity dp = new DMODPSheetHDREntity();
			dp.setDpSheetReciveDate(LocalDate.parse(rpt.getCreDtTm(), format));
			dp.setDpSheetDate(LocalDate.parse(rpt.getFrToDt().getFrDtTm(), format));
			if (rpt.getFrToDt().getBal().getTp().getCdtDbtInd().equals("CR")) {
				dp.setOpenBalCr(Double.parseDouble(rpt.getFrToDt().getBal().getTp().getAmount().replace(",", "")));
			} else {
				dp.setOpenBalDr(Double.parseDouble(rpt.getFrToDt().getBal().getTp().getAmount().replace(",", "")));
			}
			for (NtryHdr tax : rpt.getTxsSummry().getNtryHdr()) {
				if (tax.getBkTxCd().getPrtry().getCd().equals("PAD")) {
					if (tax.getCdtDbtInd().equals("CR")) {
						dp.setPadTransCr(Double.parseDouble(tax.getAmount().replace(",", "")));
					} 
					if (tax.getCdtDbtInd().equals("DB")) {
						dp.setPadTransDr(Double.parseDouble(tax.getAmount().replace(",", "")));
					}
				}
				if (tax.getBkTxCd().getPrtry().getCd().equals("AGBK")) {
					if (tax.getCdtDbtInd().equals("CR")) {
						dp.setAgencyBankCr(Double.parseDouble(tax.getAmount().replace(",", "")));
					} 
					if (tax.getCdtDbtInd().equals("DB")) {
						dp.setAgencyBankDr(Double.parseDouble(tax.getAmount().replace(",", "")));
					}
				}
				if (tax.getBkTxCd().getPrtry().getCd().equals("TIGAD")) {
					dp.setTotIgaDr(Double.parseDouble(tax.getAmount().replace(",", "")));
				}
				if (tax.getBkTxCd().getPrtry().getCd().equals("TIGAC")) {
					dp.setTotIgaCr(Double.parseDouble(tax.getAmount().replace(",", "")));
				}
				if (tax.getBkTxCd().getPrtry().getCd().equals("PAD_MUM_LOAN")) {
					if (tax.getCdtDbtInd().equals("CR")) {
						dp.setPadMumbLoanCr(Double.parseDouble(tax.getAmount().replace(",", "")));
					} 
					if (tax.getCdtDbtInd().equals("DB")) {
						dp.setPadMumbLoanDr(Double.parseDouble(tax.getAmount().replace(",", "")));
					}
				}
				if (tax.getBkTxCd().getPrtry().getCd().equals("PAD_MUM_GST")) {
					if (tax.getCdtDbtInd().equals("CR")) {
						dp.setPadMumbGstCr(Double.parseDouble(tax.getAmount().replace(",", "")));
					} 
					if (tax.getCdtDbtInd().equals("DB")) {
						dp.setPadMumbGstDr(Double.parseDouble(tax.getAmount().replace(",", "")));
					}
				}
			}
			if(null != eDPMsFinancialYearRepository.findByFyStart(dp.getDpSheetDate().getYear())){
				dp.setFinancialYear(eDPMsFinancialYearRepository.findByFyStart(dp.getDpSheetDate().getYear()).getFy());
			}
			hrdRepository.save(dp);
		}
	}

	private void buildDtl(DPDtlClearenceRequestPayload requestPayload) throws CustomException {
		Stmt stmt = requestPayload.getDocument().getBkToCstmrStmt().getStmt();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Optional<DMODPSheetHDREntity> optional = hrdRepository.findByDpSheetReciveDate(
				LocalDate.parse(stmt.getCreDtTm().replace("T", " "), format));
		if(!optional.isPresent()) {
			throw new CustomException(401, "DP Sheet Hdr data not present !!");
		}
		DMODPSheetHDREntity entity = optional.get();
		entity.setMemoNo(stmt.getId());
		hrdRepository.save(entity);
		for(Ntry ntry : stmt.getNtry()) {
			if(!dtlRepository.findByAdviceNo(ntry.getNtryRef()).isPresent()) {
				DMODPSheetEntryEntity dp = new DMODPSheetEntryEntity();
				dp.setAdviceNo(ntry.getNtryRef());
				dp.setAdviceBy(ntry.getBkTxCd().getPrtry().getCd());
				dp.setAdviceDate(LocalDate.parse(ntry.getValDt().getDt()));
				if(ntry.getCdtDbtInd().equals("DBIT")) {
					dp.setDebitAmt(ntry.getAmount().getValue());
				}
				if(ntry.getCdtDbtInd().equals("CRDT")) {
					dp.setCreditAmt(ntry.getAmount().getValue());
				}
				dp.setPaymentTypeDesc(ntry.getNtryDtls().getTxDtls().getAddtlTxInf());
				dp.setEntity(entity);
				dp.setMemoNo(stmt.getId());
				dtlRepository.save(dp);
			}
		}
	}

}
