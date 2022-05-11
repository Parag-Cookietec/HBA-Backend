package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class BudgetSubHeadWfLayDto.
 * 
 * @version 1.0
 * @created 2020/09/14 11:23:40
 *
 */
public class LocChequeBookWfLayDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The wf lay id. */
	@NotNull
	private Long wfLayId;

	/** The trn id. */
	@NotNull
	private Long trnId;

	/** The office id. */
	private Long officeId;

	/** The wf id. */
	private Long wfId;

	/** The user id. */
	@NotNull
	private Long userId;

	/** The post id. */
	private Long postId;

	/** The pou id. */
	private Long pouId;

	/** The laying on date. */
	private Date layingOnDate;

	/**
	 * BudgetSubHeadWfLayDto Constructor.
	 */
	public LocChequeBookWfLayDto() {
		super();
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
		result = prime * result + Objects.hash(layingOnDate, officeId, postId, pouId, trnId, userId, wfId, wfLayId);
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
		if (!(obj instanceof LocChequeBookWfLayDto)) {
			return false;
		}
		LocChequeBookWfLayDto other = (LocChequeBookWfLayDto) obj;
		return Objects.equals(layingOnDate, other.layingOnDate) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(postId, other.postId) && Objects.equals(pouId, other.pouId)
				&& Objects.equals(trnId, other.trnId) && Objects.equals(userId, other.userId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfLayId, other.wfLayId);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BudgetSubHeadWfLayDto [wfLayId = " + wfLayId + ",trnId = " + trnId + ",officeId = " + officeId
				+ ",wfId = " + wfId + ",userId = " + userId + ",postId = " + postId + ",pouId = " + pouId
				+ ",layingOnDate = " + layingOnDate + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the wf lay id
	 */

	/**
	 * @return the wfLayId
	 */
	public Long getWfLayId() {
		return wfLayId;
	}

	/**
	 * Sets the wf lay id.
	 *
	 * @param wfLayId the wfLayId to set
	 */
	public void setWfLayId(Long wfLayId) {
		this.wfLayId = wfLayId;
	}

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
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pouId
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the pouId to set
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the laying on date.
	 *
	 * @return the layingOnDate
	 */
	public Date getLayingOnDate() {
		return layingOnDate;
	}

	/**
	 * Sets the laying on date.
	 *
	 * @param layingOnDate the layingOnDate to set
	 */
	public void setLayingOnDate(Date layingOnDate) {
		this.layingOnDate = layingOnDate;
	}

}
