package gov.ifms.gst.pagination;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import gov.ifms.gst.pagination.SearchCriteria;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.util.GSTUtility;

/**
 * The Class ManualEntrySearchCriteria.
 */
@Component
public class ManualEntrySearchCriteria extends SearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 
	public <AccManualEntryHdr> Specification<AccManualEntryHdr> getManualEntrySpecificationDetail(SpecificationImpl<AccManualEntryHdr> spec, List<SearchParam> jsonArr) {

		for (SearchParam searchParam : jsonArr) {
			if(searchParam.getKey().equals("manualEntryDt")) {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON,GSTUtility.convertStringToDate(searchParam.getValue()));
			}else if(searchParam.getKey().equals("typeId")){
				spec.with("type.lookUpInfoId", Constant.COLON,String.valueOf(searchParam.getValue()));
			}else if(searchParam.getKey().equals("cinNo")){
				spec.with("cinNo", "like","%"+searchParam.getValue()+"%");
			}else if(searchParam.getKey().equals("referenceNo")){
				spec.with("referenceNo", "like","%"+searchParam.getValue()+"%");
			}else {
				spec.with(String.valueOf(searchParam.getKey()), Constant.COLON, String.valueOf(searchParam.getValue()));
			}
		}

		return  spec.build();
	}
}
