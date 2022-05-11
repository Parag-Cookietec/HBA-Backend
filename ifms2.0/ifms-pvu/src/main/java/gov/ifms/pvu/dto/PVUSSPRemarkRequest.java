package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class PVUEventsRemarkRequest.
 */
public class PVUSSPRemarkRequest extends BaseDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private Long id;

    /**
     * The trn no.
     */
    private String trnNo;

    /**
     * The emp id.
     */
    private Long empId;

    /**
     * The remarks.
     */
    private String remarks;

    /**
     * The auditor remarks.
     */
    private String auditorRemarks;

    /**
     * The class two remarks.
     */
    private String classTwoRemarks;

    /**
     * The print remarks.
     */
    private String printRemarks;

    /**
     * The auditor return reason.
     */
    private Long auditorReturnReason;

    /**
     * The class two return reason.
     */
    private Long classTwoReturnReason;

    /**
     * The print return reason.
     */
    private Long printReturnReason;

    /**
     * The print count.
     */
    private int printCount;

    /**
     * The emp no.
     */
    private Long empNo;

    /**
     * The wf role id.
     */
    private Long wfRoleId;

    private String verifierRemarks;

    private String classOneRemarks;

    private Long verifierReturnReason;

    private Long classOneReturnReason;

    /**
     * The return reasons.
     */
    private List<PVUEventsRemarkDto> returnReasons;

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
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the trn no.
     *
     * @return the trnNo
     */
    public String getTrnNo() {
        return trnNo;
    }

    /**
     * Sets the trn no.
     *
     * @param trnNo the trnNo to set
     */
    public void setTrnNo(String trnNo) {
        this.trnNo = trnNo;
    }

    /**
     * Gets the emp id.
     *
     * @return the empId
     */
    public Long getEmpId() {
        return empId;
    }

    /**
     * Sets the emp id.
     *
     * @param empId the empId to set
     */
    public void setEmpId(Long empId) {
        this.empId = empId;
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
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * Gets the auditor remarks.
     *
     * @return the auditorRemarks
     */
    public String getAuditorRemarks() {
        return auditorRemarks;
    }

    /**
     * Sets the auditor remarks.
     *
     * @param auditorRemarks the auditorRemarks to set
     */
    public void setAuditorRemarks(String auditorRemarks) {
        this.auditorRemarks = auditorRemarks;
    }

    /**
     * Gets the class two remarks.
     *
     * @return the classTwoRemarks
     */
    public String getClassTwoRemarks() {
        return classTwoRemarks;
    }

    /**
     * Sets the class two remarks.
     *
     * @param classTwoRemarks the classTwoRemarks to set
     */
    public void setClassTwoRemarks(String classTwoRemarks) {
        this.classTwoRemarks = classTwoRemarks;
    }

    /**
     * Gets the prints the remarks.
     *
     * @return the printRemarks
     */
    public String getPrintRemarks() {
        return printRemarks;
    }

    /**
     * Sets the prints the remarks.
     *
     * @param printRemarks the printRemarks to set
     */
    public void setPrintRemarks(String printRemarks) {
        this.printRemarks = printRemarks;
    }

    /**
     * Gets the auditor return reason.
     *
     * @return the auditorReturnReason
     */
    public Long getAuditorReturnReason() {
        return auditorReturnReason;
    }

    /**
     * Sets the auditor return reason.
     *
     * @param auditorReturnReason the auditorReturnReason to set
     */
    public void setAuditorReturnReason(Long auditorReturnReason) {
        this.auditorReturnReason = auditorReturnReason;
    }

    /**
     * Gets the class two return reason.
     *
     * @return the classTwoReturnReason
     */
    public Long getClassTwoReturnReason() {
        return classTwoReturnReason;
    }

    /**
     * Sets the class two return reason.
     *
     * @param classTwoReturnReason the classTwoReturnReason to set
     */
    public void setClassTwoReturnReason(Long classTwoReturnReason) {
        this.classTwoReturnReason = classTwoReturnReason;
    }

    /**
     * Gets the prints the return reason.
     *
     * @return the printReturnReason
     */
    public Long getPrintReturnReason() {
        return printReturnReason;
    }

    /**
     * Sets the prints the return reason.
     *
     * @param printReturnReason the printReturnReason to set
     */
    public void setPrintReturnReason(Long printReturnReason) {
        this.printReturnReason = printReturnReason;
    }

    /**
     * Gets the prints the count.
     *
     * @return the printCount
     */
    public int getPrintCount() {
        return printCount;
    }

    /**
     * Sets the prints the count.
     *
     * @param printCount the printCount to set
     */
    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    /**
     * Gets the emp no.
     *
     * @return the empNo
     */
    public Long getEmpNo() {
        return empNo;
    }

    /**
     * Sets the emp no.
     *
     * @param empNo the empNo to set
     */
    public void setEmpNo(Long empNo) {
        this.empNo = empNo;
    }

    /**
     * Gets the return reasons.
     *
     * @return the returnReasons
     */
    public List<PVUEventsRemarkDto> getReturnReasons() {
        return returnReasons;
    }

    /**
     * Sets the return reasons.
     *
     * @param returnReasons the returnReasons to set
     */
    public void setReturnReasons(List<PVUEventsRemarkDto> returnReasons) {
        this.returnReasons = returnReasons;
    }


    public String getVerifierRemarks() {
        return verifierRemarks;
    }

    public void setVerifierRemarks(String verifierRemarks) {
        this.verifierRemarks = verifierRemarks;
    }

    public String getClassOneRemarks() {
        return classOneRemarks;
    }

    public void setClassOneRemarks(String classOneRemarks) {
        this.classOneRemarks = classOneRemarks;
    }

    public Long getVerifierReturnReason() {
        return verifierReturnReason;
    }

    public void setVerifierReturnReason(Long verifierReturnReason) {
        this.verifierReturnReason = verifierReturnReason;
    }

    public Long getClassOneReturnReason() {
        return classOneReturnReason;
    }

    public void setClassOneReturnReason(Long classOneReturnReason) {
        this.classOneReturnReason = classOneReturnReason;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PVUSSPRemarkRequest that = (PVUSSPRemarkRequest) obj;
        return Objects.equals(id, that.id) &&
                Objects.equals(trnNo, that.trnNo) &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(auditorRemarks, that.auditorRemarks) &&
                Objects.equals(classTwoRemarks, that.classTwoRemarks) &&
                Objects.equals(printRemarks, that.printRemarks) &&
                Objects.equals(auditorReturnReason, that.auditorReturnReason) &&
                Objects.equals(classTwoReturnReason, that.classTwoReturnReason) &&
                Objects.equals(printReturnReason, that.printReturnReason) &&
                Objects.equals(printCount, that.printCount) &&
                Objects.equals(empNo, that.empNo) &&
                Objects.equals(wfRoleId, that.wfRoleId) &&
                Objects.equals(verifierRemarks, that.verifierRemarks) &&
                Objects.equals(classOneRemarks, that.classOneRemarks) &&
                Objects.equals(verifierReturnReason, that.verifierReturnReason) &&
                Objects.equals(classOneReturnReason, that.classOneReturnReason) &&
                Objects.equals(returnReasons, that.returnReasons);
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, trnNo, empId, remarks, auditorRemarks, classTwoRemarks,
                printRemarks, auditorReturnReason, classTwoReturnReason,
                printReturnReason, printCount, empNo, wfRoleId, verifierRemarks,
                classOneRemarks, verifierReturnReason, classOneReturnReason, returnReasons);
    }


    @Override
    public String toString() {
        return "PVUSSPRemarkRequest{" +
                "id=" + id +
                ", trnNo='" + trnNo + '\'' +
                ", empId=" + empId +
                ", remarks='" + remarks + '\'' +
                ", auditorRemarks='" + auditorRemarks + '\'' +
                ", classTwoRemarks='" + classTwoRemarks + '\'' +
                ", printRemarks='" + printRemarks + '\'' +
                ", auditorReturnReason=" + auditorReturnReason +
                ", classTwoReturnReason=" + classTwoReturnReason +
                ", printReturnReason='" + printReturnReason + '\'' +
                ", printCount=" + printCount +
                ", empNo=" + empNo +
                ", wfRoleId=" + wfRoleId +
                ", returnReasons=" + returnReasons +
                '}';
    }
}
