package gov.ifms.loc.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class LocAccountOpenReqAgDtlDto.
 *
 * @version 1.0
 * @created 2021/01/01 21:17:12
 */
public class LocAccountOpenReqAgDtlDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * The lc open req ag id.
     */
    private Long lcOpenReqAgId;

    /**
     * The lc open req hdr id.
     */
    private Long lcOpenReqHdrId;

    /**
     * The ag authorization no.
     */
    private String agAuthorizationNo;

    /**
     * The ag authorization dt.
     */
    private Date agAuthorizationDt;

    /**
     * The major head id.
     */
    private long majorHeadId;

    /**
     * The sub major head id.
     */
    private long subMajorHeadId;

    /**
     * The sub head id.
     */
    private long subHeadId;

    /**
     * The detail head id.
     */
    private long detailHeadId;

    /**
     * The minor head id.
     */
    private long minorHeadId;

    /**
     * The ag remarks.
     */
    private String agRemarks;

    /**
     * The status id.
     */
    private Long statusId;

    /**
     * The wf id.
     */
    private Long wfId;

    /**
     * The wf role id.
     */
    private Long wfRoleId;

    /**
     * The is editable.
     */
    private int isEditable;

    /**
     * LocAccountOpenReqAgDtlDto Constructor
     */
    public LocAccountOpenReqAgDtlDto() {
        super();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LocAccountOpenReqAgDtlDto [lcOpenReqAgId=" + lcOpenReqAgId + ", lcOpenReqHdrId=" + lcOpenReqHdrId
                + ", agAuthorizationNo=" + agAuthorizationNo + ", agAuthorizationDt=" + agAuthorizationDt
                + ", majorHeadId=" + majorHeadId + ", subMajorHeadId=" + subMajorHeadId + ", subHeadId=" + subHeadId
                + ", detailHeadId=" + detailHeadId + ", minorHeadId=" + minorHeadId + ", agRemarks=" + agRemarks
                + ", statusId=" + statusId + ", wfId=" + wfId + ", wfRoleId=" + wfRoleId + ", isEditable=" + isEditable
                + "]";
    }

    /**
     * @return the lcOpenReqAgId
     */
    public Long getLcOpenReqAgId() {
        return lcOpenReqAgId;
    }

    /**
     * @param lcOpenReqAgId the lcOpenReqAgId to set
     */
    public void setLcOpenReqAgId(Long lcOpenReqAgId) {
        this.lcOpenReqAgId = lcOpenReqAgId;
    }

    /**
     * @return the lcOpenReqHdrId
     */
    public Long getLcOpenReqHdrId() {
        return lcOpenReqHdrId;
    }

    /**
     * @param lcOpenReqHdrId the lcOpenReqHdrId to set
     */
    public void setLcOpenReqHdrId(Long lcOpenReqHdrId) {
        this.lcOpenReqHdrId = lcOpenReqHdrId;
    }

    /**
     * @return the agAuthorizationNo
     */
    public String getAgAuthorizationNo() {
        return agAuthorizationNo;
    }

    /**
     * @param agAuthorizationNo the agAuthorizationNo to set
     */
    public void setAgAuthorizationNo(String agAuthorizationNo) {
        this.agAuthorizationNo = agAuthorizationNo;
    }

    /**
     * @return the agAuthorizationDt
     */
    public Date getAgAuthorizationDt() {
        return agAuthorizationDt;
    }

    /**
     * @param agAuthorizationDt the agAuthorizationDt to set
     */
    public void setAgAuthorizationDt(Date agAuthorizationDt) {
        this.agAuthorizationDt = agAuthorizationDt;
    }

    /**
     * @return the majorHeadId
     */
    public long getMajorHeadId() {
        return majorHeadId;
    }

    /**
     * @param majorHeadId the majorHeadId to set
     */
    public void setMajorHeadId(long majorHeadId) {
        this.majorHeadId = majorHeadId;
    }

    /**
     * @return the subMajorHeadId
     */
    public long getSubMajorHeadId() {
        return subMajorHeadId;
    }

    /**
     * @param subMajorHeadId the subMajorHeadId to set
     */
    public void setSubMajorHeadId(long subMajorHeadId) {
        this.subMajorHeadId = subMajorHeadId;
    }

    /**
     * @return the subHeadId
     */
    public long getSubHeadId() {
        return subHeadId;
    }

    /**
     * @param subHeadId the subHeadId to set
     */
    public void setSubHeadId(long subHeadId) {
        this.subHeadId = subHeadId;
    }

    /**
     * @return the detailHeadId
     */
    public long getDetailHeadId() {
        return detailHeadId;
    }

    /**
     * @param detailHeadId the detailHeadId to set
     */
    public void setDetailHeadId(long detailHeadId) {
        this.detailHeadId = detailHeadId;
    }

    /**
     * @return the minorHeadId
     */
    public long getMinorHeadId() {
        return minorHeadId;
    }

    /**
     * @param minorHeadId the minorHeadId to set
     */
    public void setMinorHeadId(long minorHeadId) {
        this.minorHeadId = minorHeadId;
    }

    /**
     * @return the agRemarks
     */
    public String getAgRemarks() {
        return agRemarks;
    }

    /**
     * @param agRemarks the agRemarks to set
     */
    public void setAgRemarks(String agRemarks) {
        this.agRemarks = agRemarks;
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

    /**
     * @return the isEditable
     */
    public int getIsEditable() {
        return isEditable;
    }

    /**
     * @param isEditable the isEditable to set
     */
    public void setIsEditable(int isEditable) {
        this.isEditable = isEditable;
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
        if (!(o instanceof LocAccountOpenReqAgDtlDto)) return false;
        if (!super.equals(o)) return false;
        LocAccountOpenReqAgDtlDto that = (LocAccountOpenReqAgDtlDto) o;
        return getMajorHeadId() == that.getMajorHeadId() && getSubMajorHeadId() == that.getSubMajorHeadId() && getSubHeadId() == that.getSubHeadId() && getDetailHeadId() == that.getDetailHeadId() && getMinorHeadId() == that.getMinorHeadId() && getIsEditable() == that.getIsEditable() && Objects.equals(getLcOpenReqAgId(), that.getLcOpenReqAgId()) && Objects.equals(getLcOpenReqHdrId(), that.getLcOpenReqHdrId()) && Objects.equals(getAgAuthorizationNo(), that.getAgAuthorizationNo()) && Objects.equals(getAgAuthorizationDt(), that.getAgAuthorizationDt()) && Objects.equals(getAgRemarks(), that.getAgRemarks()) && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getWfId(), that.getWfId()) && Objects.equals(getWfRoleId(), that.getWfRoleId());
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLcOpenReqAgId(), getLcOpenReqHdrId(), getAgAuthorizationNo(), getAgAuthorizationDt(), getMajorHeadId(), getSubMajorHeadId(), getSubHeadId(), getDetailHeadId(), getMinorHeadId(), getAgRemarks(), getStatusId(), getWfId(), getWfRoleId(), getIsEditable());
    }
}
