package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocDBConstants;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The Class LocAdvcPrepCheqPayDtlEntity.
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_PARTY_D", schema = LocDBConstants.LOC_SCHEMA)
public class LocAdvcPrepCheqPayDtlEntity extends BaseEntity {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The dtl id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TLOC_ADVICE_PARTY_D_ID")
    private Long dtlId;

    /**
     * The advice hdr id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TLOC_ADVICE_HDR_ID", referencedColumnName = "TLOC_ADVICE_HDR_ID")
    private LocAdvicePrepHdrEntity adviceHdrId;

    /**
     * The party name.
     */
    @Column(name = "PARTY_NAME")
    private String partyName;

    /**
     * The bank acc no.
     */
    @Column(name = "BANK_ACNT_NO")
    private String bankAccNo;

    /**
     * The ifsc code.
     */
    @Column(name = "IFSC_CODE")
    private Long ifscCode;

    /**
     * The epay amnt.
     */
    @Column(name = "EPAY_AMNT")
    private Double epayAmnt;

    /**
     * The status id.
     */
    @Column(name = "STATUS_ID")
    private Long statusId;

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
     * The cheque no.
     */
    @Column(name = "CHEQUE_NO")
    private String chequeNo;

    /**
     * The cheque dt.
     */
    @Column(name = "CHEQUE_DT")
    private Date chequeDt;

    /**
     * The cheque amnt.
     */
    @Column(name = "CHEQUE_AMNT")
    private Double chequeAmnt;


    /**
     * Gets the dtl id.
     *
     * @return the dtl id
     */
    public Long getDtlId() {
        return dtlId;
    }

    /**
     * Sets the dtl id.
     *
     * @param dtlId the new dtl id
     */
    public void setDtlId(Long dtlId) {
        this.dtlId = dtlId;
    }

    /**
     * Gets the advice hdr id.
     *
     * @return the advice hdr id
     */
    public LocAdvicePrepHdrEntity getAdviceHdrId() {
        return adviceHdrId;
    }

    /**
     * Sets the advice hdr id.
     *
     * @param adviceHdrId the new advice hdr id
     */
    public void setAdviceHdrId(LocAdvicePrepHdrEntity adviceHdrId) {
        this.adviceHdrId = adviceHdrId;
    }

    /**
     * Gets the party name.
     *
     * @return the party name
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * Sets the party name.
     *
     * @param partyName the new party name
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    /**
     * Gets the ifsc code.
     *
     * @return the ifsc code
     */
    public Long getIfscCode() {
        return ifscCode;
    }

    /**
     * Sets the ifsc code.
     *
     * @param ifscCode the new ifsc code
     */
    public void setIfscCode(Long ifscCode) {
        this.ifscCode = ifscCode;
    }

    /**
     * Gets the epay amnt.
     *
     * @return the epay amnt
     */
    public Double getEpayAmnt() {
        return epayAmnt;
    }

    /**
     * Sets the epay amnt.
     *
     * @param epayAmnt the new epay amnt
     */
    public void setEpayAmnt(Double epayAmnt) {
        this.epayAmnt = epayAmnt;
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
     * Gets the cheque dt.
     *
     * @return the cheque dt
     */
    public Date getChequeDt() {
        return chequeDt;
    }

    /**
     * Sets the cheque dt.
     *
     * @param chequeDt the new cheque dt
     */
    public void setChequeDt(Date chequeDt) {
        this.chequeDt = chequeDt;
    }

    /**
     * Gets the cheque amnt.
     *
     * @return the cheque amnt
     */
    public Double getChequeAmnt() {
        return chequeAmnt;
    }

    /**
     * Sets the cheque amnt.
     *
     * @param chequeAmnt the new cheque amnt
     */
    public void setChequeAmnt(Double chequeAmnt) {
        this.chequeAmnt = chequeAmnt;
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
        if (!(o instanceof LocAdvcPrepCheqPayDtlEntity))
            return false;
        LocAdvcPrepCheqPayDtlEntity that = (LocAdvcPrepCheqPayDtlEntity) o;
        return Objects.equals(getDtlId(), that.getDtlId()) && Objects.equals(getAdviceHdrId(), that.getAdviceHdrId())
                && Objects.equals(getPartyName(), that.getPartyName())
                && Objects.equals(getBankAccNo(), that.getBankAccNo())
                && Objects.equals(getIfscCode(), that.getIfscCode())
                && Objects.equals(getEpayAmnt(), that.getEpayAmnt())
                && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getWfId(), that.getWfId())
                && Objects.equals(getWfRoleId(), that.getWfRoleId())
                && Objects.equals(getChequeNo(), that.getChequeNo())
                && Objects.equals(getChequeDt(), that.getChequeDt())
                && Objects.equals(getChequeAmnt(), that.getChequeAmnt());

    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDtlId(), getAdviceHdrId(), getPartyName(), getBankAccNo(), getIfscCode(), getEpayAmnt(),
                getStatusId(), getWfId(), getWfRoleId(), getChequeNo(), getChequeDt(), getChequeAmnt());
    }

    @Override
    public String toString() {
        return "LocAdvcPrepCheqPayDtlEntity{" +
                "dtlId=" + dtlId +
                ", adviceHdrId=" + adviceHdrId +
                ", partyName='" + partyName + '\'' +
                ", bankAccNo=" + bankAccNo +
                ", ifscCode=" + ifscCode +
                ", epayAmnt=" + epayAmnt +
                ", statusId=" + statusId +
                ", wfId=" + wfId +
                ", wfRoleId=" + wfRoleId +
                ", chequeNo='" + chequeNo + '\'' +
                ", chequeDt=" + chequeDt +
                ", chequeAmnt=" + chequeAmnt +
                '}';
    }
}
