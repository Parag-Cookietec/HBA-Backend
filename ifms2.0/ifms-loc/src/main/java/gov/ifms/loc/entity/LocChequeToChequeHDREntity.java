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
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocChequeToChequeHDREntity.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:27:48
 *
 */
@Entity
@Table(name = "TLOC_CHEQUE2CHEQUE_HDR", schema = LocDBConstants.LOC_SCHEMA)
public class LocChequeToChequeHDREntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHEQUE2CHEQUE_ID")
	private Long id;

	/** The referance number. */
	@Column(name = "REFERENCE_NO")
	private String referanceNumber;

	/** The referance date. */
	@Column(name = "REFERENCE_DATE")
	private Date referanceDate;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/** The status desc. */
	@Column(name = "STATUS_DESCRIPTION")
	private String statusDesc;

	/** The missing cheque no. */
	@Column(name = "MISSING_CHEQUE_NO")
	private String missingChequeNo;

	/** The reason. */
	@Column(name = "REASON")
	private String reason;

	/** The lc adviceid. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "LC_ADVICE_ID", nullable = false, referencedColumnName = "TLOC_ADVICE_HDR_ID")
	private LocAdvicePrepHdrEntity lcAdviceid;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The missing cheque date. */
	@Column(name = "MISSING_CHEQUE_DT")
	private Date missingChequeDate;

	/** The missing cheque amt. */
	@Column(name = "MISSING_CHEQUE_AMNT")
	private Double missingChequeAmt;

	/**
	 * LocChequeToChequeHDREntity Constructor.
	 */
	public LocChequeToChequeHDREntity() {
		super();
	}

	/**
	 * Instantiates a new loc cheque to cheque HDR entity.
	 *
	 * @param id the id
	 */
	public LocChequeToChequeHDREntity(Long id) {
		this.id = id;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocChequeToChequeHDREntity))
			return false;
		LocChequeToChequeHDREntity that = (LocChequeToChequeHDREntity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getReferanceNumber(), that.getReferanceNumber())
				&& Objects.equals(getReferanceDate(), that.getReferanceDate())
				&& Objects.equals(getStatusId(), that.getStatusId())
				&& Objects.equals(getStatusDesc(), that.getStatusDesc())
				&& Objects.equals(getMissingChequeNo(), that.getMissingChequeNo())
				&& Objects.equals(getReason(), that.getReason())
				&& Objects.equals(getLcAdviceid(), that.getLcAdviceid()) && Objects.equals(getWfId(), that.getWfId())
				&& Objects.equals(getWfRoleId(), that.getWfRoleId())
				&& Objects.equals(getMissingChequeDate(), that.getMissingChequeDate())
				&& Objects.equals(getMissingChequeAmt(), that.getMissingChequeAmt());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getId(), getReferanceNumber(), getReferanceDate(), getStatusId(), getStatusDesc(),
				getMissingChequeNo(), getReason(), getLcAdviceid(), getWfId(), getWfRoleId(), getMissingChequeDate(),
				getMissingChequeAmt());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocChequeToChequeHDREntity{" + "id=" + id + ", referanceNumber='" + referanceNumber + '\''
				+ ", referanceDate=" + referanceDate + ", statusId=" + statusId + ", statusDesc='" + statusDesc + '\''
				+ ", missingChequeNo='" + missingChequeNo + '\'' + ", reason='" + reason + '\'' + ", lcAdviceid="
				+ lcAdviceid + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId + ", missingChequeDate=" + missingChequeDate
				+ ", missingChequeAmt=" + missingChequeAmt + '}';
	}

	/**
	 * Gets the missing cheque date.
	 *
	 * @return the missing cheque date
	 */
	public Date getMissingChequeDate() {
		return missingChequeDate;
	}

	/**
	 * Sets the missing cheque date.
	 *
	 * @param missingChequeDate the new missing cheque date
	 */
	public void setMissingChequeDate(Date missingChequeDate) {
		this.missingChequeDate = missingChequeDate;
	}

	/**
	 * Gets the missing cheque amt.
	 *
	 * @return the missing cheque amt
	 */
	public Double getMissingChequeAmt() {
		return missingChequeAmt;
	}

	/**
	 * Sets the missing cheque amt.
	 *
	 * @param missingChequeAmt the new missing cheque amt
	 */
	public void setMissingChequeAmt(Double missingChequeAmt) {
		this.missingChequeAmt = missingChequeAmt;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the referance number.
	 *
	 * @return the referance number
	 */
	public String getReferanceNumber() {
		return referanceNumber;
	}

	/**
	 * Sets the referance number.
	 *
	 * @param referanceNumber the new referance number
	 */
	public void setReferanceNumber(String referanceNumber) {
		this.referanceNumber = referanceNumber;
	}

	/**
	 * Gets the referance date.
	 *
	 * @return the referance date
	 */
	public Date getReferanceDate() {
		return referanceDate;
	}

	/**
	 * Sets the referance date.
	 *
	 * @param referanceDate the new referance date
	 */
	public void setReferanceDate(Date referanceDate) {
		this.referanceDate = referanceDate;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status desc.
	 *
	 * @return the status desc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Sets the status desc.
	 *
	 * @param statusDesc the new status desc
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * Gets the missing cheque no.
	 *
	 * @return the missing cheque no
	 */
	public String getMissingChequeNo() {
		return missingChequeNo;
	}

	/**
	 * Sets the missing cheque no.
	 *
	 * @param missingChequeNo the new missing cheque no
	 */
	public void setMissingChequeNo(String missingChequeNo) {
		this.missingChequeNo = missingChequeNo;
	}

	/**
	 * Gets the reason.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Sets the reason.
	 *
	 * @param reason the new reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * Gets the lc adviceid.
	 *
	 * @return the lc adviceid
	 */
	public LocAdvicePrepHdrEntity getLcAdviceid() {
		return lcAdviceid;
	}

	/**
	 * Sets the lc adviceid.
	 *
	 * @param lcAdviceid the new lc adviceid
	 */
	public void setLcAdviceid(LocAdvicePrepHdrEntity lcAdviceid) {
		this.lcAdviceid = lcAdviceid;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}
}
