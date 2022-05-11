package gov.ifms.loc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class LocAdviceChqEpayList.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocAdviceChqEpayList {

	/** The emp dtl list. */
	private List<LocAdviceChqTypeEmpList> empDtlList;

	/** The dtl list. */
	private List<LocAdviceChqTypeList> dtlList;

	/**
	 * Gets the emp dtl list.
	 *
	 * @return the emp dtl list
	 */
	public List<LocAdviceChqTypeEmpList> getEmpDtlList() {
		return empDtlList;
	}

	/**
	 * Sets the emp dtl list.
	 *
	 * @param empDtlList the new emp dtl list
	 */
	public void setEmpDtlList(List<LocAdviceChqTypeEmpList> empDtlList) {
		this.empDtlList = empDtlList;
	}

	/**
	 * Gets the dtl list.
	 *
	 * @return the dtl list
	 */
	public List<LocAdviceChqTypeList> getDtlList() {
		return dtlList;
	}

	/**
	 * Sets the dtl list.
	 *
	 * @param dtlList the new dtl list
	 */
	public void setDtlList(List<LocAdviceChqTypeList> dtlList) {
		this.dtlList = dtlList;
	}
}
