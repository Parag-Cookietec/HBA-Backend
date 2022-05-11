package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocAccountOpenReqBankDtlEntity.
 *
 * @version 1.0
 * @created 2021/01/01 18:18:37
 */
@Entity
@Table(name = "TLOC_OPEN_REQ_BANK_DTL", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqBankDtlEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The lc open req bank dtl id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LC_OPEN_REQ_BANK_DTL_ID")
    private Long lcOpenReqBankDtlId;

    /**
     * The lc open req hdr id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LC_OPEN_REQ_HDR_ID", nullable = false, referencedColumnName = "LC_OPEN_REQ_HDR_ID")
    private LocAccountOpenReqHdrEntity lcOpenReqHdrId;

    /**
     * The bank id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BANK_ID", nullable = false, referencedColumnName = "BANK_IFSC_ID")
    private EDPMsBankIfscEntity bankId;

    /**
     * The bank branch id.
     */
    @Column(name = "BANK_BRANCH_ID")
    private Long bankBranchId;

    /**
     * The bank code.
     */
    @Column(name = "BANK_CODE")
    private Long bankCode;

    /**
     * The bank remarks.
     */
    @Column(name = "BANK_REMARKS")
    private String bankRemarks;

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
     * LocAccountOpenReqBankDtlDto Constructor
     */
    public LocAccountOpenReqBankDtlEntity() {
        super();
    }

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocAccountOpenReqBankDtlEntity)) return false;
        LocAccountOpenReqBankDtlEntity that = (LocAccountOpenReqBankDtlEntity) o;
        return Objects.equals(getLcOpenReqBankDtlId(), that.getLcOpenReqBankDtlId()) && Objects.equals(lcOpenReqHdrId, that.lcOpenReqHdrId) && Objects.equals(getBankId(), that.getBankId()) && Objects.equals(getBankBranchId(), that.getBankBranchId()) && Objects.equals(getBankCode(), that.getBankCode()) && Objects.equals(getBankRemarks(), that.getBankRemarks()) && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLcOpenReqBankDtlId(), lcOpenReqHdrId, getBankId(), getBankBranchId(), getBankCode(), getBankRemarks(), getStatusId(), getWfId(), getWfRoleId());
    }

    /**
     * toString method
     */
    @Override
    public String toString() {
        return "LocAccountOpenReqBankDtlEntity [lcOpenReqBankDtlId = " + lcOpenReqBankDtlId + ",lcOpenReqHdrId = "
                + lcOpenReqHdrId + ",lcOpenReqHdrId = " + lcOpenReqHdrId + ",bankId = " + bankId + ",bankId = " + bankId
                + ",bankBranchId = " + bankBranchId + ",bankCode = " + bankCode + ",bankCode = " + bankCode
                + ",bankRemarks = " + bankRemarks + ",statusId = " + statusId + ",wfId = " + wfId + ",wfRoleId = "
                + wfRoleId + ",]";
    }

    /**
     * getter setter
     */

    /**
     * @return the lcOpenReqBankDtlId
     */
    public Long getLcOpenReqBankDtlId() {
        return lcOpenReqBankDtlId;
    }

    /**
     * @param lcOpenReqBankDtlId the lcOpenReqBankDtlId to set
     */
    public void setLcOpenReqBankDtlId(Long lcOpenReqBankDtlId) {
        this.lcOpenReqBankDtlId = lcOpenReqBankDtlId;
    }

    /**
     * @return the bankId
     */
    public EDPMsBankIfscEntity getBankId() {
        return bankId;
    }

    /**
     * @param bankId the bankId to set
     */
    public void setBankId(EDPMsBankIfscEntity bankId) {
        this.bankId = bankId;
    }

    /**
     * @return the bankBranchId
     */
    public Long getBankBranchId() {
        return bankBranchId;
    }

    /**
     * @param bankBranchId the bankBranchId to set
     */
    public void setBankBranchId(Long bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    /**
     * @return the bankCode
     */
    public Long getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode the bankCode to set
     */
    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return the bankRemarks
     */
    public String getBankRemarks() {
        return bankRemarks;
    }

    /**
     * @param bankRemarks the bankRemarks to set
     */
    public void setBankRemarks(String bankRemarks) {
        this.bankRemarks = bankRemarks;
    }

    /**
     * @return the statusId
     */
    public Long getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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

}
