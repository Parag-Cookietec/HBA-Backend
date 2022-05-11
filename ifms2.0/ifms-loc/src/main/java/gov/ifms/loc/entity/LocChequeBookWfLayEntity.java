package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class LocChqDtlWfLayEntity.
 * 
 * @version 1.0
 * @created 2020/09/14 11:23:40
 *
 */
@Entity
@Table(name = "TLOC_LC_CHEQUEBOOK_WF_LAY", schema = LocConstant.LOC_SCHEMA)
public class LocChequeBookWfLayEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The wf lay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_LAY_ID")
	private Long wfLayId;

	/** The trn id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRN_ID", referencedColumnName = "LC_CHEQUEBOOK_ID")
	private LocChequeBookHdrEntity trnId;

	/** The office id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;

	/** The wf id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WF_ID", referencedColumnName = "WF_ID")
	private LocAccountOpenReqWfEntity wfId;

	/** The user id. */
	@Column(name = "USER_ID")
	private Long userId;

	/** The post id. */
	@Column(name = "POST_ID")
	private Long postId;

	/** The pou id. */
	@Column(name = "POU_ID")
	private Long pouId;

	/** The laying on date. */
	@Column(name = "LAYING_ON_DATE")
	private Date layingOnDate;

	/**
	 * BudgetSubHeadWfLayDto Constructor.
	 */
	public LocChequeBookWfLayEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(wfLayId, trnId, officeId, wfId, userId, postId, pouId, layingOnDate);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocChequeBookWfLayEntity)) {
			return false;
		}

		LocChequeBookWfLayEntity other = (LocChequeBookWfLayEntity) obj;

		return Objects.equals(wfLayId, other.wfLayId) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(wfId, other.wfId)
				&& Objects.equals(userId, other.userId) && Objects.equals(postId, other.postId)
				&& Objects.equals(pouId, other.pouId) && Objects.equals(layingOnDate, other.layingOnDate);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BudgetSubHeadWfLayEntity [wfLayId = " + wfLayId + ",trnId = " + trnId + ",officeId = " + officeId
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
	 * @return the trnId
	 */
	public LocChequeBookHdrEntity getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(LocChequeBookHdrEntity trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public LocAccountOpenReqWfEntity getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(LocAccountOpenReqWfEntity wfId) {
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
