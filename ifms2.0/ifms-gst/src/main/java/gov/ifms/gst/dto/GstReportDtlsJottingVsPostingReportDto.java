package gov.ifms.gst.dto;

import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsJottingVsPostingReportDto {
	
	@NativeQueryResultColumn(index = 0)
	private String employee_Name;
	@NativeQueryResultColumn(index = 1)
	private Integer challan_Alloted;
	@NativeQueryResultColumn(index = 2)
	private Integer challan_Posted;
	@NativeQueryResultColumn(index = 3)
	private Integer challan_Pending;
	@NativeQueryResultColumn(index = 4)
	private String branch;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsJottingVsPostingReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the employee_Name
	 */
	public String getEmployee_Name() {
		return employee_Name;
	}

	/**
	 * @param employee_Name the employee_Name to set
	 */
	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}

	/**
	 * @return the challan_Alloted
	 */
	public Integer getChallan_Alloted() {
		return challan_Alloted;
	}

	/**
	 * @param challan_Alloted the challan_Alloted to set
	 */
	public void setChallan_Alloted(Integer challan_Alloted) {
		this.challan_Alloted = challan_Alloted;
	}

	/**
	 * @return the challan_Posted
	 */
	public Integer getChallan_Posted() {
		return challan_Posted;
	}

	/**
	 * @param challan_Posted the challan_Posted to set
	 */
	public void setChallan_Posted(Integer challan_Posted) {
		this.challan_Posted = challan_Posted;
	}

	/**
	 * @return the challan_Pending
	 */
	public Integer getChallan_Pending() {
		return challan_Pending;
	}

	/**
	 * @param challan_Pending the challan_Pending to set
	 */
	public void setChallan_Pending(Integer challan_Pending) {
		this.challan_Pending = challan_Pending;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
}
