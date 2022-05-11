package gov.ifms.loc.entity;

import gov.ifms.edp.entity.*;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocAccountOpeningRequestHdrEntity.
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQUEST_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpeningRequestHdrEntity extends BaseEntity implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The lc open req id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name = "LC_OPEN_REQUEST_ID")
    private Long lcOpenRequestId;

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
     * The lcAccount Name.
     */
    @Column(name = "LC_ACCOUNT_NAME")
    private String lcAccountName;

    @Column(name = "STATUS_CD")
    private String statusCd;


    /**
     * The office id re lay.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REQUESTING_OFFICE_ID", referencedColumnName = "OFFICE_ID")
    private EDPMsOfficeEntity requestingOfficeId;


    /**
     * The office id re lay.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO_OFFICE_ID", referencedColumnName = "OFFICE_ID")
    private EDPMsOfficeEntity toOfficeId;


    /**
     * The dept id re hdr.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
    private EDPMsDepartmentEntity deptIdReHdr;


    /**
     * The division code.
     */
    @Column(name = "DIVISION_CD")
    private Long divisionCd;

    /**
     * The circle Id.
     */
    @Column(name = "CIRCLE_ID")
    private Long circleId;


    /**
     * The Circle Name.
     */
    @Column(name = "CIRCLE_NAME")
    private String circleName;

    /**
     * The hod id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOD_ID", referencedColumnName = "HOD_ID")
    private EDPMsHodEntity hodIdreHdr;


    /**
     * The HOD Name.
     */
    @Column(name = "HOD_NAME")
    private String hodName;


    /**
     * The cardex no.
     */
    @Column(name = "CARDEX_NO")
    private Long cardexNo;

    /**
     * The ddo no.
     */
    @Column(name = "DDO_NO")
    private Long ddoNo;


    /**
     * The remarks.
     */
    @Column(name = "REMARKS")
    private String remarks;


    /**
     * The ag authorization no.
     */
    @Column(name = "AG_AUTHORIZATION_NO")
    private Long agAuthorizationNo;

    /**
     * The ag authorization dt.
     */
    @Column(name = "AG_AUTHORIZATION_DT")
    private Date agAuthorizationDt;

    /**
     * The ag remarks.
     */
    @Column(name = "AG_REMARKS")
    private String agRemarks;


    /**
     * The major head id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAJORHEAD_ID", nullable = false, referencedColumnName = "MAJORHEAD_ID")
    private LocMsMajorHeadEntity majorHeadId;

    /**
     * The submajorhead id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBMAJORHEAD_ID", nullable = false, referencedColumnName = "SUBMAJORHEAD_ID")
    private LocMsSubMajorHeadEntity submajorheadId;

    /**
     * The subhead id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBHEAD_ID", nullable = false, referencedColumnName = "SUBHEAD_ID")
    private LocMsSubHeadEntity subheadId;

    /**
     * The detailhead id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DETAILHEAD_ID", nullable = false, referencedColumnName = "DETAILHEAD_ID")
    private LocMsDetailHeadEntity detailheadId;

    /**
     * The minorhead id.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MINORHEAD_ID", nullable = false, referencedColumnName = "MINORHEAD_ID")
    private LocMsMinorHeadEntity minorheadId;


    /**
     * The bank id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    private LocMsBankEntity bankId;

    /**
     * The bank branch id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_BRANCH_ID", referencedColumnName = "BRANCH_ID")
    private EDPMsBranchEntity bankBranchId;


    /**
     * The bank remarks.
     */
    @Column(name = "BANK_REMARKS")
    private String bankRemarks;


    /**
     * The division remarks.
     */
    @Column(name = "DIVISION_REMARKS")
    private String divisionRemarks;


    /**
     * The pending with user id.
     */
    @Column(name = "PENDING_WITH_USERID")
    private Long pendingWithUserId;

    /**
     * The created by user id.
     */


    @Column(name = "CREATED_BY_USER_ID")
    private Long createdByUserId;

    /**
     * The created by post id.
     */
    @Column(name = "CREATED_BY_POST_ID")
    private Long createdByPostId;

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
     * The division office address.
     */
    @Column(name = "DIVISION_OFFICE_ADDRESS")
    private String divisionOfficeAddress;


    /**
     * The division Id.
     */
    @Column(name = "DISTRICT_ID")
    private long districtId;

    /**
     * The division code.
     */
    @Column(name = "DIVISION_CODE")
    private String divisionCode;

    /**
     * The division Name.
     */
    @Column(name = "DIVISION_NAME")
    private String divisionName;

    /**
     * The circle code.
     */
    @Column(name = "CIRCLE_CODE")
    private String circleCode;


    /**
     * LocAccountOpeningRequestHdrDto Constructor
     */
    public LocAccountOpeningRequestHdrEntity() {
        super();
    }

    /**
     * Instantiates a new loc account open request hdr entity.
     *
     * @param lcOpenReqHdrId the lc open request hdr id
     */
    public LocAccountOpeningRequestHdrEntity(Long lcOpenRequestId) {
        super();
        this.lcOpenRequestId = lcOpenRequestId;
    }


    /**
     * Gets the lc open request id.
     *
     * @return the lc open request id
     */
    public Long getLcOpenRequestId() {
        return lcOpenRequestId;
    }

    /**
     * Sets the lc open request id.
     *
     * @param lcOpenRequestId the new lc open request id
     */
    public void setLcOpenRequestId(Long lcOpenRequestId) {
        this.lcOpenRequestId = lcOpenRequestId;
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
     * Gets the lc account name.
     *
     * @return the lc account name
     */
    public String getLcAccountName() {
        return lcAccountName;
    }

    /**
     * Sets the lc account name.
     *
     * @param lcAccountName the new lc account name
     */
    public void setLcAccountName(String lcAccountName) {
        this.lcAccountName = lcAccountName;
    }

    /**
     * Gets the status cd.
     *
     * @return the status cd
     */
    public String getStatusCd() {
        return statusCd;
    }

    /**
     * Sets the status cd.
     *
     * @param statusCd the new status cd
     */
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    /**
     * Gets the requesting office id.
     *
     * @return the requesting office id
     */
    public EDPMsOfficeEntity getRequestingOfficeId() {
        return requestingOfficeId;
    }

    /**
     * Sets the requesting office id.
     *
     * @param requestingOfficeId the new requesting office id
     */
    public void setRequestingOfficeId(EDPMsOfficeEntity requestingOfficeId) {
        this.requestingOfficeId = requestingOfficeId;
    }

    /**
     * Gets the to office id.
     *
     * @return the to office id
     */
    public EDPMsOfficeEntity getToOfficeId() {
        return toOfficeId;
    }

    /**
     * Sets the to office id.
     *
     * @param toOfficeId the new to office id
     */
    public void setToOfficeId(EDPMsOfficeEntity toOfficeId) {
        this.toOfficeId = toOfficeId;
    }

    /**
     * Gets the dept id re hdr.
     *
     * @return the dept id re hdr
     */
    public EDPMsDepartmentEntity getDeptIdReHdr() {
        return deptIdReHdr;
    }

    /**
     * Sets the dept id re hdr.
     *
     * @param deptIdReHdr the new dept id re hdr
     */
    public void setDeptIdReHdr(EDPMsDepartmentEntity deptIdReHdr) {
        this.deptIdReHdr = deptIdReHdr;
    }

    /**
     * Gets the division cd.
     *
     * @return the division cd
     */
    public Long getDivisionCd() {
        return divisionCd;
    }

    /**
     * Sets the division cd.
     *
     * @param divisionCd the new division cd
     */
    public void setDivisionCd(Long divisionCd) {
        this.divisionCd = divisionCd;
    }

    /**
     * Gets the circle id.
     *
     * @return the circle id
     */
    public Long getCircleId() {
        return circleId;
    }

    /**
     * Sets the circle id.
     *
     * @param circleId the new circle id
     */
    public void setCircleId(Long circleId) {
        this.circleId = circleId;
    }

    /**
     * Gets the circle name.
     *
     * @return the circle name
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * Sets the circle name.
     *
     * @param circleName the new circle name
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * Gets the hod idre hdr.
     *
     * @return the hod idre hdr
     */
    public EDPMsHodEntity getHodIdreHdr() {
        return hodIdreHdr;
    }

    /**
     * Sets the hod idre hdr.
     *
     * @param hodIdreHdr the new hod idre hdr
     */
    public void setHodIdreHdr(EDPMsHodEntity hodIdreHdr) {
        this.hodIdreHdr = hodIdreHdr;
    }

    /**
     * Gets the hod name.
     *
     * @return the hod name
     */
    public String getHodName() {
        return hodName;
    }

    /**
     * Sets the hod name.
     *
     * @param hodName the new hod name
     */
    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    /**
     * Gets the cardex no.
     *
     * @return the cardex no
     */
    public Long getCardexNo() {
        return cardexNo;
    }

    /**
     * Sets the cardex no.
     *
     * @param cardexNo the new cardex no
     */
    public void setCardexNo(Long cardexNo) {
        this.cardexNo = cardexNo;
    }

    /**
     * Gets the ddo no.
     *
     * @return the ddo no
     */
    public Long getDdoNo() {
        return ddoNo;
    }

    /**
     * Sets the ddo no.
     *
     * @param ddoNo the new ddo no
     */
    public void setDdoNo(Long ddoNo) {
        this.ddoNo = ddoNo;
    }

    /**
     * Gets the remarks.
     *
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the remarks.
     *
     * @param remarks the new remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets the ag authorization no.
     *
     * @return the ag authorization no
     */
    public Long getAgAuthorizationNo() {
        return agAuthorizationNo;
    }

    /**
     * Sets the ag authorization no.
     *
     * @param agAuthorizationNo the new ag authorization no
     */
    public void setAgAuthorizationNo(Long agAuthorizationNo) {
        this.agAuthorizationNo = agAuthorizationNo;
    }

    /**
     * Gets the ag authorization dt.
     *
     * @return the ag authorization dt
     */
    public Date getAgAuthorizationDt() {
        return agAuthorizationDt;
    }

    /**
     * Sets the ag authorization dt.
     *
     * @param agAuthorizationDt the new ag authorization dt
     */
    public void setAgAuthorizationDt(Date agAuthorizationDt) {
        this.agAuthorizationDt = agAuthorizationDt;
    }

    /**
     * Gets the ag remarks.
     *
     * @return the ag remarks
     */
    public String getAgRemarks() {
        return agRemarks;
    }

    /**
     * Sets the ag remarks.
     *
     * @param agRemarks the new ag remarks
     */
    public void setAgRemarks(String agRemarks) {
        this.agRemarks = agRemarks;
    }

    /**
     * Gets the major head id.
     *
     * @return the major head id
     */
    public LocMsMajorHeadEntity getMajorHeadId() {
        return majorHeadId;
    }

    /**
     * Sets the major head id.
     *
     * @param majorHeadId the new major head id
     */
    public void setMajorHeadId(LocMsMajorHeadEntity majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    /**
     * Gets the submajorhead id.
     *
     * @return the submajorhead id
     */
    public LocMsSubMajorHeadEntity getSubmajorheadId() {
        return submajorheadId;
    }

    /**
     * Sets the submajorhead id.
     *
     * @param submajorheadId the new submajorhead id
     */
    public void setSubmajorheadId(LocMsSubMajorHeadEntity submajorheadId) {
        this.submajorheadId = submajorheadId;
    }

    /**
     * Gets the subhead id.
     *
     * @return the subhead id
     */
    public LocMsSubHeadEntity getSubheadId() {
        return subheadId;
    }

    /**
     * Sets the subhead id.
     *
     * @param subheadId the new subhead id
     */
    public void setSubheadId(LocMsSubHeadEntity subheadId) {
        this.subheadId = subheadId;
    }

    /**
     * Gets the detailhead id.
     *
     * @return the detailhead id
     */
    public LocMsDetailHeadEntity getDetailheadId() {
        return detailheadId;
    }

    /**
     * Sets the detailhead id.
     *
     * @param detailheadId the new detailhead id
     */
    public void setDetailheadId(LocMsDetailHeadEntity detailheadId) {
        this.detailheadId = detailheadId;
    }

    /**
     * Gets the minorhead id.
     *
     * @return the minorhead id
     */
    public LocMsMinorHeadEntity getMinorheadId() {
        return minorheadId;
    }

    /**
     * Sets the minorhead id.
     *
     * @param minorheadId the new minorhead id
     */
    public void setMinorheadId(LocMsMinorHeadEntity minorheadId) {
        this.minorheadId = minorheadId;
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
     * Gets the bank branch id.
     *
     * @return the bank branch id
     */
    public EDPMsBranchEntity getBankBranchId() {
        return bankBranchId;
    }

    /**
     * Sets the bank branch id.
     *
     * @param bankBranchId the new bank branch id
     */
    public void setBankBranchId(EDPMsBranchEntity bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    /**
     * Gets the bank remarks.
     *
     * @return the bank remarks
     */
    public String getBankRemarks() {
        return bankRemarks;
    }

    /**
     * Sets the bank remarks.
     *
     * @param bankRemarks the new bank remarks
     */
    public void setBankRemarks(String bankRemarks) {
        this.bankRemarks = bankRemarks;
    }

    /**
     * Gets the division remarks.
     *
     * @return the division remarks
     */
    public String getDivisionRemarks() {
        return divisionRemarks;
    }

    /**
     * Sets the division remarks.
     *
     * @param divisionRemarks the new division remarks
     */
    public void setDivisionRemarks(String divisionRemarks) {
        this.divisionRemarks = divisionRemarks;
    }

    /**
     * Gets the pending with user id.
     *
     * @return the pending with user id
     */
    public Long getPendingWithUserId() {
        return pendingWithUserId;
    }

    /**
     * Sets the pending with user id.
     *
     * @param pendingWithUserId the new pending with user id
     */
    public void setPendingWithUserId(Long pendingWithUserId) {
        this.pendingWithUserId = pendingWithUserId;
    }

    /**
     * Gets the created by user id.
     *
     * @return the created by user id
     */
    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    /**
     * Sets the created by user id.
     *
     * @param createdByUserId the new created by user id
     */
    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    /**
     * Gets the created by post id.
     *
     * @return the created by post id
     */
    public Long getCreatedByPostId() {
        return createdByPostId;
    }

    /**
     * Sets the created by post id.
     *
     * @param createdByPostId the new created by post id
     */
    public void setCreatedByPostId(Long createdByPostId) {
        this.createdByPostId = createdByPostId;
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
     * Gets the division office address.
     *
     * @return the division office address
     */
    public String getDivisionOfficeAddress() {
        return divisionOfficeAddress;
    }

    /**
     * Sets the division office address.
     *
     * @param divisionOfficeAddress the new division office address
     */
    public void setDivisionOfficeAddress(String divisionOfficeAddress) {
        this.divisionOfficeAddress = divisionOfficeAddress;
    }

    /**
     * Gets the district id.
     *
     * @return the district id
     */
    public long getDistrictId() {
        return districtId;
    }

    /**
     * Sets the district id.
     *
     * @param districtId the new district id
     */
    public void setDistrictId(long districtId) {
        this.districtId = districtId;
    }

    /**
     * Gets the division code.
     *
     * @return the division code
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the division code.
     *
     * @param divisionCode the new division code
     */
    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    /**
     * Gets the division name.
     *
     * @return the division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Sets the division name.
     *
     * @param divisionName the new division name
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * Gets the circle code.
     *
     * @return the circle code
     */
    public String getCircleCode() {
        return circleCode;
    }

    /**
     * Sets the circle code.
     *
     * @param circleCode the new circle code
     */
    public void setCircleCode(String circleCode) {
        this.circleCode = circleCode;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LocAccountOpeningRequestHdrEntity [lcOpenRequestId=" + lcOpenRequestId + ", referenceNo=" + referenceNo
                + ", referenceDt=" + referenceDt + ", lcAccountName=" + lcAccountName + ", statusCd="
                + statusCd + ", requestingOfficeId=" + requestingOfficeId + ", toOfficeId=" + toOfficeId + ", deptIdReHdr="
                + deptIdReHdr + ", divisionCd=" + divisionCd + ", circleId=" + circleId + ", circleName=" + circleName + ", hodIdreHdr="
                + hodIdreHdr + ", hodName=" + hodName + ", cardexNo=" + cardexNo + ", ddoNo="
                + ddoNo + ", remarks=" + remarks + ",agAuthorizationNo=" + agAuthorizationNo + ", agAuthorizationDt=" + agAuthorizationDt + ",agRemarks ="
                + agRemarks + ", majorHeadId=" + majorHeadId + ", submajorheadId=" + submajorheadId + ", subheadId ="
                + subheadId + ", detailheadId=" + detailheadId + ", minorheadId=" + minorheadId + ", bankId =" + bankId + ",bankBranchId =" + bankBranchId + ",bankRemarks = " + bankRemarks + ",divisionRemarks=" + divisionRemarks + ",createdByUserId =" + createdByUserId + ",createdByPostId ="
                + createdByPostId + ",wfId =" + wfId + ",wfRoleId = " + wfRoleId + ",divisionOfficeAddress=" + divisionOfficeAddress + ",districtId ="
                + districtId + ",divisionCode =" + divisionCode + ",divisionName =" + divisionName + ",circleCode =" + circleCode + ",]";
    }

}
