package gov.ifms.loc.entity;


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
 * The Class LocAdvcPrepCheqPaySdEntity.
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_PARTY_SD", schema = LocDBConstants.LOC_SCHEMA)
public class LocAdvcPrepCheqPaySdEntity extends BaseEntity {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The dtl id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TLOC_ADVICE_PARTY_SD_ID")
    private Long sdId;

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
    private String vendorName;

    /**
     * The bank acc no.
     */
    @Column(name = "BANK_ACNT_NO")
    private String accNo;

    /**
     * The ifsc code.
     */
    @Column(name = "IFSC_CODE")
    private String ifscCode;

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
     * Gets the sd id.
     *
     * @return the sd id
     */
    public Long getSdId() {
        return sdId;
    }

    /**
     * Sets the sd id.
     *
     * @param sdId the new sd id
     */
    public void setSdId(Long sdId) {
        this.sdId = sdId;
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
     * Gets the ifsc code.
     *
     * @return the ifsc code
     */
    public String getIfscCode() {
        return ifscCode;
    }

    /**
     * Sets the ifsc code.
     *
     * @param ifscCode the new ifsc code
     */
    public void setIfscCode(String ifscCode) {
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
     * @param chequeDt the new cheque dts
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


    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocAdvcPrepCheqPaySdEntity)) return false;
        LocAdvcPrepCheqPaySdEntity entity = (LocAdvcPrepCheqPaySdEntity) o;
        return Objects.equals(getSdId(), entity.getSdId()) && Objects.equals(getAdviceHdrId(), entity.getAdviceHdrId()) && Objects.equals(getVendorName(), entity.getVendorName()) && Objects.equals(getAccNo(), entity.getAccNo()) && Objects.equals(getIfscCode(), entity.getIfscCode()) && Objects.equals(getEpayAmnt(), entity.getEpayAmnt()) && Objects.equals(getStatusId(), entity.getStatusId()) && Objects.equals(getWfId(), entity.getWfId()) && Objects.equals(getWfRoleId(), entity.getWfRoleId()) && Objects.equals(getChequeNo(), entity.getChequeNo()) && Objects.equals(getChequeDt(), entity.getChequeDt()) && Objects.equals(getChequeAmnt(), entity.getChequeAmnt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSdId(), getAdviceHdrId(), getVendorName(), getAccNo(), getIfscCode(), getEpayAmnt(), getStatusId(), getWfId(), getWfRoleId(), getChequeNo(), getChequeDt(), getChequeAmnt());
    }
}
