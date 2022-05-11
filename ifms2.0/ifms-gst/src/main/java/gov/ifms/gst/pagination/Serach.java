package gov.ifms.gst.pagination;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GSTUtility;

public class Serach extends SearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public <GSTAccountHdr> Specification<GSTAccountHdr> file(SpecificationImpl<GSTAccountHdr> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <FileTypeHdr> Specification<FileTypeHdr> findAll(SpecificationImpl<FileTypeHdr> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <AccDebitEntry> Specification<AccDebitEntry> getfile(SpecificationImpl<AccDebitEntry> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <AccountCreditEntry> Specification<AccountCreditEntry> search(SpecificationImpl<AccountCreditEntry> spec,
			List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
					GSTUtility.convertStringToLocalDate(searchParam.getValue()));
		}
		return spec.build();
	}

	public <FileAccountingProcessed> Specification<FileAccountingProcessed> getFileDetail(
			SpecificationImpl<FileAccountingProcessed> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if (searchParam.getKey().contentEquals("referenceDt")
					|| searchParam.getKey().equals("fileName") || searchParam.getKey().equals("refrenceNo")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,
						GSTUtility.convertStringToLocalDate(searchParam.getValue()));
			} else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}
		return spec.build();
	}

}
