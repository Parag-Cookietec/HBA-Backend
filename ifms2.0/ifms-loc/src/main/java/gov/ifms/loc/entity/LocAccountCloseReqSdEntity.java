package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocAccountCloseReqSdEntity.
 *
 * @version 1.0
 * @created 2021/01/31 12:52:20
 */
@Entity
@Table(name = "TLOC_LC_CLOSING_REQUEST_HDR_SD", schema = LocConstant.LOC_SCHEMA)

public class LocAccountCloseReqSdEntity extends BaseEntity implements Serializable {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /**
     * The lc close req hdr id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LC_CLOSING_REQUEST_SD_ID")
    private Long lcCloseReqSdId;

    /**
     * The reference no.
     */
    @Column(name = "REFERENCE_NO")
    private String referenceNo;

    /**
     * The reference dt.
     */
    @Column(name = "REFERENCE_DT")
    private Date referenceDt;

    /**
     * The Status Id.
     */
    @Column(name = "STATUS_ID")
    private String statusId;


    /**
     * The reference dt.
     */
    @Column(name = "APPROVAL_DT")
    private Date approvalDt;


    /**
     * The reference dt.
     */
    @Column(name = "LC_CLOSING_DT")
    private Date lcclosingDt;


    /**
     * The reference no.
     */
    @Column(name = "CLOSURE_REMARK")
    private String closureRemark;


    /**
     * The reference no.
     */
    @Column(name = "AG_CLOSURE_REMARK")
    private String agClosureRemark;


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
     * The lc open req hdr id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LC_OPEN_REQUEST_ID", nullable = false, referencedColumnName = "LC_OPEN_REQUEST_ID")
    private LocAccountOpeningRequestHdrEntity lcOpenRequestId;


    /**
     * The lc open req hdr id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LC_CLOSING_REQUEST_HDR_ID", nullable = false, referencedColumnName = "LC_CLOSING_REQUEST_HDR_ID")
    private LocAccountCloseReqHdrEntity lcCloseReqHdrId;


    /**
     * LocAccountCloseReqHdrDto Constructor.
     */
    public LocAccountCloseReqSdEntity() {
        super();
    }

    /**
     * Instantiates a new loc account Close req hdr entity.
     *
     * @param lcCloseReqSdId the lc close req sd id
     */
    public LocAccountCloseReqSdEntity(Long lcCloseReqSdId) {
        super();
        this.lcCloseReqSdId = lcCloseReqSdId;
    }

    /**
     * Gets the lc close req sd id.
     *
     * @return the lc close req sd id
     */
    public Long getLcCloseReqSdId() {
        return lcCloseReqSdId;
    }

    /**
     * Sets the lc close req sd id.
     *
     * @param lcCloseReqSdId the new lc close req sd id
     */
    public void setLcCloseReqSdId(Long lcCloseReqSdId) {
        this.lcCloseReqSdId = lcCloseReqSdId;
    }


    /**
     * Gets the reference no.
     *
     * @return the reference no
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * Sets the reference no.
     *
     * @param referenceNo the new reference no
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * Gets the reference dt.
     *
     * @return the reference dt
     */
    public Date getReferenceDt() {
        return referenceDt;
    }

    /**
     * Sets the reference dt.
     *
     * @param referenceDt the new reference dt
     */
    public void setReferenceDt(Date referenceDt) {
        this.referenceDt = referenceDt;
    }


    /**
     * Gets the status id.
     *
     * @return the status id
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * Sets the status id.
     *
     * @param statusId the new status id
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    /**
     * Gets the approval dt.
     *
     * @return the approval dt
     */
    public Date getApprovalDt() {
        return approvalDt;
    }

    /**
     * Sets the approval dt.
     *
     * @param approvalDt the new approval dt
     */
    public void setApprovalDt(Date approvalDt) {
        this.approvalDt = approvalDt;
    }

    /**
     * Gets the lcclosing dt.
     *
     * @return the lcclosing dt
     */
    public Date getLcclosingDt() {
        return lcclosingDt;
    }

    /**
     * Sets the lcclosing dt.
     *
     * @param lcclosingDt the new lcclosing dt
     */
    public void setLcclosingDt(Date lcclosingDt) {
        this.lcclosingDt = lcclosingDt;
    }

    /**
     * Gets the closure remark.
     *
     * @return the closure remark
     */
    public String getClosureRemark() {
        return closureRemark;
    }

    /**
     * Sets the closure remark.
     *
     * @param closureRemark the new closure remark
     */
    public void setClosureRemark(String closureRemark) {
        this.closureRemark = closureRemark;
    }

    /**
     * Gets the ag closure remark.
     *
     * @return the ag closure remark
     */
    public String getAgClosureRemark() {
        return agClosureRemark;
    }

    /**
     * Sets the ag closure remark.
     *
     * @param agClosureRemark the new ag closure remark
     */
    public void setAgClosureRemark(String agClosureRemark) {
        this.agClosureRemark = agClosureRemark;
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
     * Gets the lc open request id.
     *
     * @return the lc open request id
     */
    public LocAccountOpeningRequestHdrEntity getLcOpenRequestId() {
        return lcOpenRequestId;
    }

    /**
     * Sets the lc open request id.
     *
     * @param lcOpenRequestId the new lc open request id
     */
    public void setLcOpenRequestId(LocAccountOpeningRequestHdrEntity lcOpenRequestId) {
        this.lcOpenRequestId = lcOpenRequestId;
    }

    /**
     * Gets the lc close req hdr id.
     *
     * @return the lc close req hdr id
     */
    public LocAccountCloseReqHdrEntity getLcCloseReqHdrId() {
        return lcCloseReqHdrId;
    }

    /**
     * Sets the lc close req hdr id.
     *
     * @param lcCloseReqHdrId the new lc close req hdr id
     */
    public void setLcCloseReqHdrId(LocAccountCloseReqHdrEntity lcCloseReqHdrId) {
        this.lcCloseReqHdrId = lcCloseReqHdrId;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LocAccountCloseReqSdEntity [lcCloseReqSdId=" + lcCloseReqSdId + ", referenceNo=" + referenceNo
                + ", referenceDt=" + referenceDt + ", statusId =" + statusId + ",approvalDt=" + approvalDt + ", lcclosingDt="
                + lcclosingDt + ", closureRemark=" + closureRemark + ", agClosureRemark=" + agClosureRemark + ", lcOpenRequestId="
                + lcOpenRequestId + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId + ",lcCloseReqHdrId =" + lcCloseReqHdrId + ",]";
    }


}
