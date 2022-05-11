package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPUserRoleMappingItrDto.
 * 
 * @version 1.0
 * @created 2019/12/30 11:43:18
 *
 */
public class EDPUserRoleMappingItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user role mapping itr id. */
	private long userRoleMappingItrId;

	/** The user role mapping id. */
	private long userRoleMappingId;

	/** The transaction number. */
	private String transactionNumber;

	/** The employee id. */
	private long employeeId;

	/** The post office user id. */
	private long postOfficeUserId;

	/** The submission status. */
	private long submissionStatus;

	/** The remark. */
	private String remark;

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(employeeId, postOfficeUserId, remark, submissionStatus, transactionNumber,
				userRoleMappingId, userRoleMappingItrId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EDPUserRoleMappingItrDto other = (EDPUserRoleMappingItrDto) obj;
		return employeeId == other.employeeId && postOfficeUserId == other.postOfficeUserId
				&& Objects.equals(remark, other.remark) && submissionStatus == other.submissionStatus
				&& Objects.equals(transactionNumber, other.transactionNumber)
				&& userRoleMappingId == other.userRoleMappingId && userRoleMappingItrId == other.userRoleMappingItrId;
	}

	/**
	 * Instantiates a new EDP user role mapping itr dto.
	 */
	public EDPUserRoleMappingItrDto() {
		super();
	}

	/**
	 * Gets the user role mapping itr id.
	 *
	 * @return the user role mapping itr id
	 */
	public long getUserRoleMappingItrId() {
		return userRoleMappingItrId;
	}

	/**
	 * Sets the user role mapping itr id.
	 *
	 * @param userRoleMappingItrId the new user role mapping itr id
	 */
	public void setUserRoleMappingItrId(long userRoleMappingItrId) {
		this.userRoleMappingItrId = userRoleMappingItrId;
	}

	/**
	 * Gets the user role mapping id.
	 *
	 * @return the user role mapping id
	 */
	public long getUserRoleMappingId() {
		return userRoleMappingId;
	}

	/**
	 * Sets the user role mapping id.
	 *
	 * @param userRoleMappingId the new user role mapping id
	 */
	public void setUserRoleMappingId(long userRoleMappingId) {
		this.userRoleMappingId = userRoleMappingId;
	}

	/**
	 * Gets the transaction number.
	 *
	 * @return the transaction number
	 */
	public String getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * Sets the transaction number.
	 *
	 * @param transactionNumber the new transaction number
	 */
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the post office user id.
	 *
	 * @return the post office user id
	 */
	public long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the new post office user id
	 */
	public void setPostOfficeUserId(long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * Gets the submission status.
	 *
	 * @return the submission status
	 */
	public long getSubmissionStatus() {
		return submissionStatus;
	}

	/**
	 * Sets the submission status.
	 *
	 * @param submissionStatus the new submission status
	 */
	public void setSubmissionStatus(long submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
