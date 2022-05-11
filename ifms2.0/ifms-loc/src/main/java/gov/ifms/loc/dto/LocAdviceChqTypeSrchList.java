package gov.ifms.loc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class LocAdviceChqTypeSrchList.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocAdviceChqTypeSrchList {

	/** The chq type list. */
	private List<LocIdNameDto> chqTypeList;

	/** The designation list. */
	private List<LocIdNameDto> designationList;

	/** The emp type list. */
	private List<LocIdNameDto> empTypeList;

	/**
	 * Gets the chq type list.
	 *
	 * @return the chq type list
	 */
	public List<LocIdNameDto> getChqTypeList() {
		return chqTypeList;
	}

	/**
	 * Sets the chq type list.
	 *
	 * @param chqTypeList the new chq type list
	 */
	public void setChqTypeList(List<LocIdNameDto> chqTypeList) {
		this.chqTypeList = chqTypeList;
	}

	/**
	 * Gets the designation list.
	 *
	 * @return the designation list
	 */
	public List<LocIdNameDto> getDesignationList() {
		return designationList;
	}

	/**
	 * Sets the designation list.
	 *
	 * @param designationList the new designation list
	 */
	public void setDesignationList(List<LocIdNameDto> designationList) {
		this.designationList = designationList;
	}

	/**
	 * Gets the emp type list.
	 *
	 * @return the emp type list
	 */
	public List<LocIdNameDto> getEmpTypeList() {
		return empTypeList;
	}

	/**
	 * Sets the emp type list.
	 *
	 * @param empTypeList the new emp type list
	 */
	public void setEmpTypeList(List<LocIdNameDto> empTypeList) {
		this.empTypeList = empTypeList;
	}
}
