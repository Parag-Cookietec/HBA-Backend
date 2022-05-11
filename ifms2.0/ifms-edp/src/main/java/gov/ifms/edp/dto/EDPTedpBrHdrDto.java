package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPTedpBrHdrDto.
 */
public class EDPTedpBrHdrDto extends BaseDto implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tedp br hdr id. */
	private Long tedpBrHdrId;

	/** The trn no. */
	private String trnNo;
	
	/** The request type. */
	private Long requestType;

	/** The branch name. */
	private String branchName;
	
	/** The office id. */
	private Long officeId;
	
	/** The branch type. */
	private Long branchType;
	
	/** The status id. */
	private Long statusId;
	
	/** The menu code. */
	private String menuCode;
	
	/** The branch id. */
	private Long branchId;

	/**
	 * Gets the tedp br hdr id.
	 *
	 * @return the tedpBrHdrId
	 */
	public Long getTedpBrHdrId() {
		return tedpBrHdrId;
	}

	/**
	 * Sets the tedp br hdr id.
	 *
	 * @param tedpBrHdrId the tedpBrHdrId to set
	 */
	public void setTedpBrHdrId(Long tedpBrHdrId) {
		this.tedpBrHdrId = tedpBrHdrId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the request type.
	 *
	 * @return the requestType
	 */
	public Long getRequestType() {
		return requestType;
	}

	/**
	 * Sets the request type.
	 *
	 * @param requestType the requestType to set
	 */
	public void setRequestType(Long requestType) {
		this.requestType = requestType;
	}

	/**
	 * Gets the branch name.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Sets the branch name.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the branch type.
	 *
	 * @return the branchType
	 */
	public Long getBranchType() {
		return branchType;
	}

	/**
	 * Sets the branch type.
	 *
	 * @param branchType the branchType to set
	 */
	public void setBranchType(Long branchType) {
		this.branchType = branchType;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * @param menuCode the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(branchId, branchName, branchType, menuCode, officeId, requestType,
				statusId, tedpBrHdrId, trnNo);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPTedpBrHdrDto)) {
			return false;
		}
		EDPTedpBrHdrDto other = (EDPTedpBrHdrDto) obj;
		return Objects.equals(branchId, other.branchId) && Objects.equals(branchName, other.branchName)
				&& Objects.equals(branchType, other.branchType) && Objects.equals(menuCode, other.menuCode)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(requestType, other.requestType)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(tedpBrHdrId, other.tedpBrHdrId)
				&& Objects.equals(trnNo, other.trnNo);
	}
	
}
