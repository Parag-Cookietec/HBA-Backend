package gov.ifms.gst.pagination;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GSTUtility;

/**s
 * The Class GstSearchCriteria.
 */
@Component
public class GstSearchCriteria extends SearchCriteria implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public <GSTBankRateMaster> Specification<GSTBankRateMaster> getGstSpecificationDetail(
			SpecificationImpl<GSTBankRateMaster> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("effectiveFromDate") || searchParam.getKey().equals("effectiveToDate")
					|| searchParam.getKey().equals("referenceDate")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
						GSTUtility.convertStringToLocalDate(searchParam.getValue()));

			}else if(searchParam.getKey().equals("fromDate")) {
				spec.with("effectiveToDate", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("toDate")) {
				spec.with("effectiveToDate", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));

			}
		}

		return spec.build();
	}

	public <GSTFileSummery> Specification<GSTFileSummery> getFileSummery(SpecificationImpl<GSTFileSummery> spec,
			List<SearchParam> jsonArr) {
		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("fileDate")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
						GSTUtility.convertStringToLocalDate(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return spec.build();
	}

	public <GSTFileAccounting> Specification<GSTFileAccounting> getFileDetail(SpecificationImpl<GSTFileAccounting> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("FromDate") || searchParam.getKey().equals("ToDate")
					|| searchParam.getKey().equals("fileName")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
						GSTUtility.convertStringToLocalDate(searchParam.getValue()));

			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));

			}
		}

		return spec.build();
	}

	public <GSTBlockCPIN> Specification<GSTBlockCPIN> getGsts(SpecificationImpl<GSTBlockCPIN> spec,
			List<SearchParam> jsonArr) {
		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().equals("referenceDt")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
						GSTUtility.convertStringToLocalDate(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return spec.build();
	}

	public <GSTCINFileData> Specification<GSTCINFileData> getfile(SpecificationImpl<GSTCINFileData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <GSTCPINFileData> Specification<GSTCPINFileData> file(SpecificationImpl<GSTCPINFileData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <NonReconGstData> Specification<NonReconGstData> getfileGst(SpecificationImpl<NonReconGstData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <NonReconHeadsData> Specification<NonReconHeadsData> getfileHead(SpecificationImpl<NonReconHeadsData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <NonReconMismatchData> Specification<NonReconMismatchData> getfileMismatch(
			SpecificationImpl<NonReconMismatchData> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIFileTranxn> Specification<RBIFileTranxn> getfileTrans(SpecificationImpl<RBIFileTranxn> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <NonReconErrorData> Specification<NonReconErrorData> getError(SpecificationImpl<NonReconErrorData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIFileHdr> Specification<RBIFileHdr> getRbifilehdr(SpecificationImpl<RBIFileHdr> spec,
			List<SearchParam> jsonArr) {
		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIAccStmtTranxn> Specification<RBIAccStmtTranxn> getfileAccTarns(SpecificationImpl<RBIAccStmtTranxn> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIAccStmtHdr> Specification<RBIAccStmtHdr> getfileAccHdr(SpecificationImpl<RBIAccStmtHdr> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIAccStmtBal> Specification<RBIAccStmtBal> getAccStmtBal(SpecificationImpl<RBIAccStmtBal> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIAccHdr> Specification<RBIAccHdr> getRbiAccHdr(SpecificationImpl<RBIAccHdr> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <PanelIntrestEntry> Specification<PanelIntrestEntry> getPanelEntry(SpecificationImpl<PanelIntrestEntry> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <PenalIntrestDTL> Specification<PenalIntrestDTL> getPanelDtl(SpecificationImpl<PenalIntrestDTL> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIMOEConfCaseAcknwlge> Specification<RBIMOEConfCaseAcknwlge> getMoeConf(
			SpecificationImpl<RBIMOEConfCaseAcknwlge> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIMOERejctCaseAcknwlge> Specification<RBIMOERejctCaseAcknwlge> getMoeRejct(
			SpecificationImpl<RBIMOERejctCaseAcknwlge> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIMoeResHdr> Specification<RBIMoeResHdr> getMoeResHdr(SpecificationImpl<RBIMoeResHdr> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <RBIMoeReslvdCase> Specification<RBIMoeReslvdCase> getMoeResolvd(SpecificationImpl<RBIMoeReslvdCase> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <ReconFileData> Specification<ReconFileData> getReconFile(SpecificationImpl<ReconFileData> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <ScrollDistribute> Specification<ScrollDistribute> getScrollDistribution(
			SpecificationImpl<ScrollDistribute> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <ChallanDistributionSADA> Specification<ChallanDistributionSADA> getCallanDistrSADA(
			SpecificationImpl<ChallanDistributionSADA> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
		
	}

	return spec.build();
	}

	public <GenerateMoeHdr> Specification<GenerateMoeHdr> getGenerateMoe(SpecificationImpl<GenerateMoeHdr> spec,
																		 List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if(searchParam.getKey().equals("fromDate")) {
				spec.with("referenceDt", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("toDate")) {
				spec.with("referenceDt", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("moeRaisedFromDate")) {
				spec.with("MOE_RAISED_DT", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("MOE_REASON_ID")) {
				spec.with("MOE_REASON.lookUpInfoId", Constant.COLON,String.valueOf(searchParam.getValue()));
			}else if(searchParam.getKey().equals("moeRaisedToDate")) {
				spec.with("MOE_RAISED_DT", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("GSTIN_TMPID_NO") || searchParam.getKey().equals("CIN_NO")) {
				spec.with(searchParam.getKey(), "like","%"+searchParam.getValue()+"%");
			}else{
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}
		return spec.build();
	}

	public <AccManualEntryHdr> Specification<AccManualEntryHdr> getManualEntrySpecificationDetail(SpecificationImpl<AccManualEntryHdr> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if(searchParam.getKey().equals("manualEntryDt")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,GSTUtility.convertStringToDate(searchParam.getValue()));
			}else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return  spec.build();
	}

		public <GstRbiFilesTranxn> Specification<GstRbiFilesTranxn> getChallanSearchSpecificationDetail(SpecificationImpl<GstRbiFilesTranxn> spec, List<SearchParam> jsonArr) {

			for (SearchParam searchParam : jsonArr) {
				if(searchParam.getKey().equals("fromDate")) {
					spec.with("transactionDttm", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
				}else if(searchParam.getKey().equals("toDate")) {
					spec.with("transactionDttm", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
				}else if(searchParam.getKey().equals("type")) {
					spec.with("rbiFileHdr.fileType", Constant.COLON, String.valueOf(searchParam.getValue()));
				}else if(searchParam.getKey().equals("bankId")) {
					spec.with("gstSaDaChallanMapping.bankId", Constant.COLON, String.valueOf(searchParam.getValue()));
				}else{
					spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
				}
			}

			return  spec.build();
		}

	public <PenalIntrestEntry> Specification<PenalIntrestEntry> getPenalSearchSpecificationDetail(SpecificationImpl<PenalIntrestEntry> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if(searchParam.getKey().equals("fromDate")) {
				spec.with("receiptDt", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("toDate")) {
				spec.with("receiptDt", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("receiptModeId")){
				spec.with("receiptMode.lookUpInfoId", Constant.COLON,String.valueOf(searchParam.getValue()));
			}else{
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return  spec.build();
	}
}
