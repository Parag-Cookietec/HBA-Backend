package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPUserRoleMappingItrEntity.
 * 
 * @version 1.0
 * @created 2019/12/30 11:43:18
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPUserRoleMappingItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user role mapping itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USR_RG_MAP_ITR_ID")
	private Long userRoleMappingItrId;

	/** The user role mapping id. */
	@Column(name = "T_USR_RG_MAP_ID")
	private Long userRoleMappingId;

	/** The transaction number. */
	@Column(name = "TRN_NO")
	private String transactionNumber;

	/** The employee id. */
	@Column(name = "EMP_ID")
	private Long employeeId;

	/** The post office user id. */
	@Column(name = "LK_PO_OFF_USER_ID")
	private Long postOfficeUserId;


	/** The submission status. */
	@Column(name = "STATUS_ID")
	private Long submissionStatus;
	
	/** The remark. */
	@Column(name = "REMARKS")
	private String remark;
	
	/**
	 * EDPUserRoleMappingItrDto Constructor.
	 */
	public EDPUserRoleMappingItrEntity() {
		super();
	}

	/**
	 * Gets the user role mapping itr id.
	 *
	 * @return the user role mapping itr id
	 */
	public Long getUserRoleMappingItrId() {
		return userRoleMappingItrId;
	}

	/**
	 * Sets the user role mapping itr id.
	 *
	 * @param userRoleMappingItrId the new user role mapping itr id
	 */
	public void setUserRoleMappingItrId(Long userRoleMappingItrId) {
		this.userRoleMappingItrId = userRoleMappingItrId;
	}

	/**
	 * Gets the user role mapping id.
	 *
	 * @return the user role mapping id
	 */
	public Long getUserRoleMappingId() {
		return userRoleMappingId;
	}

	/**
	 * Sets the user role mapping id.
	 *
	 * @param userRoleMappingId the new user role mapping id
	 */
	public void setUserRoleMappingId(Long userRoleMappingId) {
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
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the post office user id.
	 *
	 * @return the post office user id
	 */
	public Long getPostOfficeUserId() {
		return postOfficeUserId;
	}

	/**
	 * Sets the post office user id.
	 *
	 * @param postOfficeUserId the new post office user id
	 */
	public void setPostOfficeUserId(Long postOfficeUserId) {
		this.postOfficeUserId = postOfficeUserId;
	}

	/**
	 * Gets the submission status.
	 *
	 * @return the submission status
	 */
	public Long getSubmissionStatus() {
		return submissionStatus;
	}

	/**
	 * Sets the submission status.
	 *
	 * @param submissionStatus the new submission status
	 */
	public void setSubmissionStatus(Long submissionStatus) {
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
		EDPUserRoleMappingItrEntity other = (EDPUserRoleMappingItrEntity) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(postOfficeUserId, other.postOfficeUserId)
				&& Objects.equals(remark, other.remark) && Objects.equals(submissionStatus, other.submissionStatus)
				&& Objects.equals(transactionNumber, other.transactionNumber)
				&& Objects.equals(userRoleMappingId, other.userRoleMappingId)
				&& Objects.equals(userRoleMappingItrId, other.userRoleMappingItrId);
	}
}
