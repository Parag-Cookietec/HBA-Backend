package gov.ifms.gst.pagination;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GSTUtility;

/**
 * The Class ChallanearchCriteria.
 */
@Component
public class ChallanSearchCriteria extends SearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 
	public <GstRbiFilesTranxn> Specification<GstRbiFilesTranxn> getRbiFileTranxnSpecificationDetail(SpecificationImpl<GstRbiFilesTranxn> spec, List<SearchParam> jsonArr) {

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

	public <GstSaDaChallanMapping> Specification<GstSaDaChallanMapping> getSaDaChallanMappingSpecificationDetail(SpecificationImpl<GstSaDaChallanMapping> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if(searchParam.getKey().equals("fromDate")) {
				spec.with("rbiFileTranxn.transactionDttm", ">=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("toDate")) {
				spec.with("rbiFileTranxn.transactionDttm", "<=",GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("type")) {
				spec.with("rbiFileTranxn.rbiFileHdr.fileType", Constant.COLON, String.valueOf(searchParam.getValue()));
			}else if(searchParam.getKey().equals("bankId")) {
				spec.with("bankId", Constant.COLON, String.valueOf(searchParam.getValue()));
			}else{
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return  spec.build();
	}
}
