package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocDBConstants;

/**
 * The Class LocChequeToChequeDetailEntity.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:16:18
 *
 */
@Entity
@Table(name = "TLOC_CHEQUE2CHEQUE_DETAIL_D", schema = LocDBConstants.LOC_SCHEMA)
public class LocChequeToChequeDetailEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHEQUE2CHEQUE_DETAI_ID")
	private Long id;

	/** The cheque no. */
	@Column(name = "CHEQUE_NO")
	private int chequeNo;

	/** The cheque date. */
	@Column(name = "CHEQUE_DATE")
	private Date chequeDate;

	/** The cheque amount. */
	@Column(name = "CHEQUE_AMT")
	private Long chequeAmount;

	/** The cheque to cheque id. */
	@Column(name = "CHEQUE2CHEQUE_ID")
	private Long chequeToChequeId;

	/** The wf id. */
	@Column(name = "WF_ID")
	private Long wfId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The statusd. */
	@Column(name = "STATUS_ID")
	private Long statusd;

	/**
	 * LocChequeToChequeDetailEntity Constructor.
	 */
	public LocChequeToChequeDetailEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, chequeNo, chequeDate, chequeAmount, chequeAmount, chequeToChequeId, wfId, wfRoleId,
				statusd);
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
		if (!(obj instanceof LocChequeToChequeDetailEntity)) {
			return false;
		}

		LocChequeToChequeDetailEntity other = (LocChequeToChequeDetailEntity) obj;

		return Objects.equals(id, other.id) && chequeNo == other.chequeNo
				&& Objects.equals(chequeDate, other.chequeDate) && Objects.equals(chequeAmount, other.chequeAmount)
				&& Objects.equals(chequeToChequeId, other.chequeToChequeId) && Objects.equals(wfId, other.wfId)
				&& Objects.equals(wfRoleId, other.wfRoleId) && Objects.equals(statusd, other.statusd);
	}

	@Override
	public String toString() {
		return "LocChequeToChequeDetailEntity [id=" + id + ", chequeNo=" + chequeNo + ", chequeDate=" + chequeDate
				+ ", chequeAmount=" + chequeAmount + ", chequeToChequeId=" + chequeToChequeId + ", wfId=" + wfId
				+ ", wfRoleId=" + wfRoleId + ", statusd=" + statusd + "]";
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the chequeNo
	 */
	public int getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @param chequeAmount the chequeAmount to set
	 */
	public void setChequeAmount(Long chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	/**
	 * @return the chequeToChequeId
	 */
	public Long getChequeToChequeId() {
		return chequeToChequeId;
	}

	/**
	 * @param chequeToChequeId the chequeToChequeId to set
	 */
	public void setChequeToChequeId(Long chequeToChequeId) {
		this.chequeToChequeId = chequeToChequeId;
	}

	/**
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the statusd
	 */
	public Long getStatusd() {
		return statusd;
	}

	/**
	 * @param statusd the statusd to set
	 */
	public void setStatusd(Long statusd) {
		this.statusd = statusd;
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
	 * Gets the cheque amount.
	 *
	 * @return the cheque amount
	 */
	public Long getChequeAmount() {
		return chequeAmount;
	}

}
