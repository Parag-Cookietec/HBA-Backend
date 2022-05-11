package gov.ifms.loc.dto;

import java.io.Serializable;

/**
 * The Class LocSubmitWfDto.
 */
public class LocSubmitWfDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn id. */
	private Long trnId;

	/** The wf id. */
	private Long wfId;

	/** The assign by wf role id. */
	private Long assignByWfRoleId;

	/** The trn status. */
	private String trnStatus;

	/** The assign to wf role id. */
	private Long assignToWfRoleId;

	/** The assign by branch id. */
	private Long assignByBranchId;

	/** The wf action id. */
	private Long wfActionId;

	/** The wf action id. */
	private Long assignByOfficeId;

	/** The IsAg flag . */
	private Boolean isAg;

	/** The IsTo flag . */
	private Boolean isTo;

	/** The is dat. */
	private Boolean isDat;

	/** The menuId . */
	private Long menuId;

	/** The assigntoPouId . */
	private Long assignToPouId;

	/** The assigntoPouId . */
	private Long assignToOfficeId;

	/**
	 * Gets the trn id.
	 *
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the assign by wf role id.
	 *
	 * @return the assignByWfRoleId
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * Sets the assign by wf role id.
	 *
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * Gets the trn status.
	 *
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets the trn status.
	 *
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * Gets the assign to wf role id.
	 *
	 * @return the assignToWfRoleId
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * Sets the assign to wf role id.
	 *
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * Gets the assign by branch id.
	 *
	 * @return the assignByBranchId
	 */
	public Long getAssignByBranchId() {
		return assignByBranchId;
	}

	/**
	 * Sets the assign by branch id.
	 *
	 * @param assignByBranchId the assignByBranchId to set
	 */
	public void setAssignByBranchId(Long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	/**
	 * Gets the wf action id.
	 *
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * Sets the wf action id.
	 *
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * Gets the assign by office id.
	 *
	 * @return the assignByOfficeId
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * Sets the assign by office id.
	 *
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * Gets the checks if is ag.
	 *
	 * @return the checks if is ag
	 */
	public Boolean getIsAg() {
		return isAg;
	}

	/**
	 * Sets the checks if is ag.
	 *
	 * @param isAg the new checks if is ag
	 */
	public void setIsAg(Boolean isAg) {
		this.isAg = isAg;
	}

	/**
	 * Gets the checks if is to.
	 *
	 * @return the checks if is to
	 */
	public Boolean getIsTo() {
		return isTo;
	}

	/**
	 * Sets the checks if is to.
	 *
	 * @param isTo the new checks if is to
	 */
	public void setIsTo(Boolean isTo) {
		this.isTo = isTo;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the assign to pou id.
	 *
	 * @return the assignToPouId
	 */
	public Long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * Sets the assign to pou id.
	 *
	 * @param assignToPouId the assignToPouId to set
	 */
	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * Gets the assign to office id.
	 *
	 * @return the assignToOfficeId
	 */
	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * Sets the assign to office id.
	 *
	 * @param assignToOfficeId the assignToOfficeId to set
	 */
	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	public Boolean getIsDat() {
		return isDat;
	}

	public void setIsDat(Boolean isDat) {
		this.isDat = isDat;
	}
}