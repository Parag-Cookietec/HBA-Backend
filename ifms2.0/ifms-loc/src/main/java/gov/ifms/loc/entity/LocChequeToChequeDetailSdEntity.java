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
 * The Class LocChequeToChequeDetailSdEntity.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:21:51
 *
 */
@Entity
@Table(name = "TLOC_CHEQUE2CHEQUE_DETAIL_SD", schema = LocDBConstants.LOC_SCHEMA)
public class LocChequeToChequeDetailSdEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHEQUE2CHEQUE_DETAI_ID")
	private Long id;

	/** The cheque no. */
	@Column(name = "CHEQUE_NO")
	private String chequeNo;

	/** The cheque date. */
	@Column(name = "CHEQUE_DATE")
	private Date chequeDate;

	/** The cheque amt. */
	@Column(name = "CHEQUE_AMT")
	private Double chequeAmt;

	/** The cheque to chequeid. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CHEQUE2CHEQUE_ID", nullable = false, referencedColumnName = "CHEQUE2CHEQUE_ID")
	private LocChequeToChequeHDREntity hdrId;

	/** The wfid. */
	@Column(name = "WF_ID")
	private Long wfid;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	@Column(name = "PARTY_NAME")
	private String partyName;
	/**
	 * LocChequeToChequeDetailSdEntity Constructor.
	 */
	public LocChequeToChequeDetailSdEntity() {
		super();
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
	 * Gets the cheque no.
	 *
	 * @return the cheque no
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Sets the cheque no.
	 *
	 * @param chequeNo the new cheque no
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the cheque date
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the new cheque date
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the cheque amt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the new cheque amt
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public LocChequeToChequeHDREntity getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(LocChequeToChequeHDREntity hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the wfid.
	 *
	 * @return the wfid
	 */
	public Long getWfid() {
		return wfid;
	}

	/**
	 * Sets the wfid.
	 *
	 * @param wfid the new wfid
	 */
	public void setWfid(Long wfid) {
		this.wfid = wfid;
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

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof LocChequeToChequeDetailSdEntity)) return false;
		LocChequeToChequeDetailSdEntity that = (LocChequeToChequeDetailSdEntity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getChequeNo(), that.getChequeNo()) && Objects.equals(getChequeDate(), that.getChequeDate()) && Objects.equals(getChequeAmt(), that.getChequeAmt()) && Objects.equals(getHdrId(), that.getHdrId()) && Objects.equals(getWfid(), that.getWfid()) && Objects.equals(getWfRoleId(), that.getWfRoleId()) && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getPartyName(), that.getPartyName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getChequeNo(), getChequeDate(), getChequeAmt(), getHdrId(), getWfid(), getWfRoleId(), getStatusId(), getPartyName());
	}
}
