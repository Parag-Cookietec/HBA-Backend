package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * The Class LocChequeCancelHdrEntity.
 *
 * @version v 1.0
 * @created 2021/03/05 17:12:26
 */
@Entity
@Table(name = "TLOC_CHEQUE_CANCEL_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocChequeCancelHdrEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHEQUE_CANCELLATION_ID")
    private Long hdrId;

    /**
     * The ref no.
     */
    @Column(name = "REFERENCE_NO")
    private String refNo;

    /**
     * The ref date.
     */
    @Column(name = "REFERENCE_DT")
    private Date refDate;

    /**
     * The status code.
     */
    @Column(name = "STATUS_CD")
    private String statusCode;

    /**
     * The status desc.
     */
    @Column(name = "STATUS_DESCRIPTION")
    private String statusDesc;

    /**
     * The status date.
     */
    @Column(name = "STATUS_DT")
    private Date statusDate;

    /**
     * The approval date.
     */
    @Column(name = "APPROVAL_DT")
    private Date approvalDate;

    /**
     * The cheque no.
     */
    @Column(name = "CHEQUE_NO")
    private String chequeNo;

    /**
     * The cheque date.
     */
    @Column(name = "CHEQUE_DT")
    private Date chequeDate;

    /**
     * The Cheque amt.
     */
    @Column(name = "CHEQUE_AMT")
    private Double ChequeAmt;

    /**
     * The in favour.
     */
    @Column(name = "IN_FAVOUR")
    private String inFavour;

    /**
     * The reason.
     */
    @Column(name = "Reason")
    private String reason;

    /**
     * The div id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DIVISION_ID", nullable = false, referencedColumnName = "DIVISION_ID")
    private LocMsDivisonEntity divId;

    /**
     * The bank id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANK_ID", nullable = false, referencedColumnName = "BANK_ID")
    private LocMsBankEntity bankId;

    /**
     * The lc adviceid.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LC_ADVICE_ID", nullable = false, referencedColumnName = "TLOC_ADVICE_HDR_ID")
    private LocAdvicePrepHdrEntity lcAdviceid;

    /**
     * The wf id.
     */
    @Column(name = "WF_ID")
    private Long wfId;

    /**
     * The wf role id.
     */
    @Column(name = "WF_ROLE_ID")
    private Long wfRoleId;

    /**
     * The status id.
     */
    @Column(name = "STATUS_ID")
    private Long statusId;
    
    /** The cardex no. */
    @Column(name="CARDEX_NO")
    private Long cardexNo;
    
    /** The ddo no. */
    @Column(name="DDO_NO")
    private String ddoNo;

    /**
     * LocChequeCancelHdrEntity Constructor.
     */
    public LocChequeCancelHdrEntity() {
    	super();
    }

    /**
     * Instantiates a new loc cheque cancel hdr entity.
     *
     * @param id the id
     */
    public LocChequeCancelHdrEntity(Long hdrId) {
    	super();
    	this.hdrId = hdrId;
    }


    /**
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
     * Gets the ref no.
     *
     * @return the ref no
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * Sets the ref no.
     *
     * @param refNo the new ref no
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
     * Gets the ref date.
     *
     * @return the ref date
     */
    public Date getRefDate() {
        return refDate;
    }

    /**
     * Sets the ref date.
     *
     * @param refDate the new ref date
     */
    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

    /**
     * Gets the status code.
     *
     * @return the status code
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code.
     *
     * @param statusCode the new status code
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
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
     * Gets the status date.
     *
     * @return the status date
     */
    public Date getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the status date.
     *
     * @param statusDate the new status date
     */
    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    /**
     * Gets the approval date.
     *
     * @return the approval date
     */
    public Date getApprovalDate() {
        return approvalDate;
    }

    /**
     * Sets the approval date.
     *
     * @param approvalDate the new approval date
     */
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
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
        return ChequeAmt;
    }

    /**
     * Sets the cheque amt.
     *
     * @param chequeAmt the new cheque amt
     */
    public void setChequeAmt(Double chequeAmt) {
        ChequeAmt = chequeAmt;
    }

    /**
     * Gets the in favour.
     *
     * @return the in favour
     */
    public String getInFavour() {
        return inFavour;
    }

    /**
     * Sets the in favour.
     *
     * @param inFavour the new in favour
     */
    public void setInFavour(String inFavour) {
        this.inFavour = inFavour;
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
     * Gets the div id.
     *
     * @return the div id
     */
    public LocMsDivisonEntity getDivId() {
        return divId;
    }

    /**
     * Sets the div id.
     *
     * @param divId the new div id
     */
    public void setDivId(LocMsDivisonEntity divId) {
        this.divId = divId;
    }

    /**
     * Gets the bank id.
     *
     * @return the bank id
     */
    public LocMsBankEntity getBankId() {
        return bankId;
    }

    /**
     * Sets the bank id.
     *
     * @param bankId the new bank id
     */
    public void setBankId(LocMsBankEntity bankId) {
        this.bankId = bankId;
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
     * Gets the cardex no.
     *
     * @return the cardexNo
     */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocChequeCancelHdrEntity [hdrId=" + hdrId + ", refNo=" + refNo + ", refDate=" + refDate + ", statusCode="
				+ statusCode + ", statusDesc=" + statusDesc + ", statusDate=" + statusDate + ", approvalDate="
				+ approvalDate + ", chequeNo=" + chequeNo + ", chequeDate=" + chequeDate + ", ChequeAmt=" + ChequeAmt
				+ ", inFavour=" + inFavour + ", reason=" + reason + ", divId=" + divId + ", bankId=" + bankId
				+ ", lcAdviceid=" + lcAdviceid + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId + ", statusId=" + statusId
				+ ", cardexNo=" + cardexNo + ", ddoNo=" + ddoNo + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ChequeAmt, approvalDate, bankId, cardexNo, chequeDate, chequeNo, ddoNo, divId, hdrId, inFavour,
				lcAdviceid, reason, refDate, refNo, statusCode, statusDate, statusDesc, statusId, wfId, wfRoleId);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LocChequeCancelHdrEntity)) {
			return false;
		}
		LocChequeCancelHdrEntity other = (LocChequeCancelHdrEntity) obj;
		return Objects.equals(ChequeAmt, other.ChequeAmt) && Objects.equals(approvalDate, other.approvalDate)
				&& Objects.equals(bankId, other.bankId) && Objects.equals(cardexNo, other.cardexNo)
				&& Objects.equals(chequeDate, other.chequeDate) && Objects.equals(chequeNo, other.chequeNo)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(divId, other.divId)
				&& Objects.equals(hdrId, other.hdrId) && Objects.equals(inFavour, other.inFavour)
				&& Objects.equals(lcAdviceid, other.lcAdviceid) && Objects.equals(reason, other.reason)
				&& Objects.equals(refDate, other.refDate) && Objects.equals(refNo, other.refNo)
				&& Objects.equals(statusCode, other.statusCode) && Objects.equals(statusDate, other.statusDate)
				&& Objects.equals(statusDesc, other.statusDesc) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

	
}
