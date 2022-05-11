package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVURevisionOfPayDto.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
public class PVURevisionOfPayDto extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The trn no. */
	private String trnNo;

	/** The next increment date. */
	private Date revNextIncrementDate;

	/** The next increment date. */
	private Date curNextIncrementDate;

	/** The status id. */
	private Long statusId;

	/** The emp id. */
	private Long empId;

	/** The rop type. */
	private Long ropType;

	/** The rev pay level. */
	private Long revPayLevel;

	/** The rev cell id. */
	private Long revCellId;

	/** The rev pay band. */
	private Long revPayBand;

	/** The rev pay band value. */
	private Long revPayBandValue;

	/** The rev grade pay. */
	private Long revGradePay;

	/** The rev basic pay. */
	private Long revBasicPay;

	/** The effective date. */
	private Date effectiveDate;

	/** The rop change eff date. */
	private Long ropChangeEffDate;

	/** The order no. */
	private String orderNo;

	/** The order date. */
	private Date orderDate;

	/** The office id. */
	private Long officeId;

	/** The remarks. */
	private String remarks;

	/** The auditor remarks. */
	private String auditorRemarks;

	/** The class two remarks. */
	private String classTwoRemarks;

	/** The print remarks. */
	private String printRemarks;

	/** The auditor return reason. */
	private Long auditorReturnReason;

	/** The class two return reason. */
	private Long classTwoReturnReason;

	/** The print return reason. */
	private String printReturnReason;

	/** The print count. */
	private Long printCount;

	/** The class id. */
	private Long classId;

	/** The designation id. */
	private Long designationId;

	/** The cur scale. */
	private Long curScale;

	/** The cur grade pay. */
	private Long curGradePay;

	/** The cur pay band. */
	private Long curPayBand;

	/** The cur basic pay. */
	private Long curBasicPay;

	/** The cur pay band value. */
	private Long curPayBandValue;

	/** The emp no. */
	private Long empNo;

	/** The wf role id. */
	private Long wfRoleId;

	/** The npa. */
	private Long npa;

	/** The auto six valid basic. */
	private Long autoSixValidBasic;

	/** The auto six valid pay value. */
	private Long autoSixValidPayValue;

	/** The auto six valid flag. */
	private Long autoSixValidFlag;

	/** The return reasons. */
	private List<PVURopRemarksDto> returnReasons;

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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
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
	 * Gets the rop type.
	 *
	 * @return the ropType
	 */
	public Long getRopType() {
		return ropType;
	}

	/**
	 * Sets the rop type.
	 *
	 * @param ropType the ropType to set
	 */
	public void setRopType(Long ropType) {
		this.ropType = ropType;
	}

	/**
	 * Gets the rev pay level.
	 *
	 * @return the revPayLevel
	 */
	public Long getRevPayLevel() {
		return revPayLevel;
	}

	/**
	 * Sets the rev pay level.
	 *
	 * @param revPayLevel the revPayLevel to set
	 */
	public void setRevPayLevel(Long revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	/**
	 * Gets the rev cell id.
	 *
	 * @return the revCellId
	 */
	public Long getRevCellId() {
		return revCellId;
	}

	/**
	 * Sets the rev cell id.
	 *
	 * @param revCellId the revCellId to set
	 */
	public void setRevCellId(Long revCellId) {
		this.revCellId = revCellId;
	}

	/**
	 * Gets the rev pay band.
	 *
	 * @return the revPayBand
	 */
	public Long getRevPayBand() {
		return revPayBand;
	}

	/**
	 * Sets the rev pay band.
	 *
	 * @param revPayBand the revPayBand to set
	 */
	public void setRevPayBand(Long revPayBand) {
		this.revPayBand = revPayBand;
	}

	/**
	 * Gets the rev pay band value.
	 *
	 * @return the revPayBandValue
	 */
	public Long getRevPayBandValue() {
		return revPayBandValue;
	}

	/**
	 * Sets the rev pay band value.
	 *
	 * @param revPayBandValue the revPayBandValue to set
	 */
	public void setRevPayBandValue(Long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	/**
	 * Gets the rev grade pay.
	 *
	 * @return the revGradePay
	 */
	public Long getRevGradePay() {
		return revGradePay;
	}

	/**
	 * Sets the rev grade pay.
	 *
	 * @param revGradePay the revGradePay to set
	 */
	public void setRevGradePay(Long revGradePay) {
		this.revGradePay = revGradePay;
	}

	/**
	 * Gets the rev basic pay.
	 *
	 * @return the revBasicPay
	 */
	public Long getRevBasicPay() {
		return revBasicPay;
	}

	/**
	 * Sets the rev basic pay.
	 *
	 * @param revBasicPay the revBasicPay to set
	 */
	public void setRevBasicPay(Long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	/**
	 * Gets the effective date.
	 *
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Sets the effective date.
	 *
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Gets the rop change eff date.
	 *
	 * @return the ropChangeEffDate
	 */
	public Long getRopChangeEffDate() {
		return ropChangeEffDate;
	}

	/**
	 * Sets the rop change eff date.
	 *
	 * @param ropChangeEffDate the ropChangeEffDate to set
	 */
	public void setRopChangeEffDate(Long ropChangeEffDate) {
		this.ropChangeEffDate = ropChangeEffDate;
	}

	/**
	 * Gets the order no.
	 *
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
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
	public String getPrintReturnReason() {
		return printReturnReason;
	}

	/**
	 * Sets the prints the return reason.
	 *
	 * @param printReturnReason the printReturnReason to set
	 */
	public void setPrintReturnReason(String printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	/**
	 * Gets the prints the count.
	 *
	 * @return the printCount
	 */
	public Long getPrintCount() {
		return printCount;
	}

	/**
	 * Sets the prints the count.
	 *
	 * @param printCount the printCount to set
	 */
	public void setPrintCount(Long printCount) {
		this.printCount = printCount;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */
	public Long getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the cur scale.
	 *
	 * @return the curScale
	 */
	public Long getCurScale() {
		return curScale;
	}

	/**
	 * Sets the cur scale.
	 *
	 * @param curScale the curScale to set
	 */
	public void setCurScale(Long curScale) {
		this.curScale = curScale;
	}

	/**
	 * Gets the cur grade pay.
	 *
	 * @return the curGradePay
	 */
	public Long getCurGradePay() {
		return curGradePay;
	}

	/**
	 * Sets the cur grade pay.
	 *
	 * @param curGradePay the curGradePay to set
	 */
	public void setCurGradePay(Long curGradePay) {
		this.curGradePay = curGradePay;
	}

	/**
	 * Gets the cur pay band.
	 *
	 * @return the curPayBand
	 */
	public Long getCurPayBand() {
		return curPayBand;
	}

	/**
	 * Sets the cur pay band.
	 *
	 * @param curPayBand the curPayBand to set
	 */
	public void setCurPayBand(Long curPayBand) {
		this.curPayBand = curPayBand;
	}

	/**
	 * Gets the cur basic pay.
	 *
	 * @return the curBasicPay
	 */
	public Long getCurBasicPay() {
		return curBasicPay;
	}

	/**
	 * Sets the cur basic pay.
	 *
	 * @param curBasicPay the curBasicPay to set
	 */
	public void setCurBasicPay(Long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	/**
	 * Gets the cur pay band value.
	 *
	 * @return the curPayBandValue
	 */
	public Long getCurPayBandValue() {
		return curPayBandValue;
	}

	/**
	 * Sets the cur pay band value.
	 *
	 * @param curPayBandValue the curPayBandValue to set
	 */
	public void setCurPayBandValue(Long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
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
	 * Gets the rev next increment date.
	 *
	 * @return the revNextIncrementDate
	 */
	public Date getRevNextIncrementDate() {
		return revNextIncrementDate;
	}

	/**
	 * Sets the rev next increment date.
	 *
	 * @param revNextIncrementDate the revNextIncrementDate to set
	 */
	public void setRevNextIncrementDate(Date revNextIncrementDate) {
		this.revNextIncrementDate = revNextIncrementDate;
	}

	/**
	 * Gets the cur next increment date.
	 *
	 * @return the curNextIncrementDate
	 */
	public Date getCurNextIncrementDate() {
		return curNextIncrementDate;
	}

	/**
	 * Sets the cur next increment date.
	 *
	 * @param curNextIncrementDate the curNextIncrementDate to set
	 */
	public void setCurNextIncrementDate(Date curNextIncrementDate) {
		this.curNextIncrementDate = curNextIncrementDate;
	}

	/**
	 * Gets the npa.
	 *
	 * @return the npa
	 */
	public Long getNpa() {
		return npa;
	}

	/**
	 * Sets the npa.
	 *
	 * @param npa the npa to set
	 */
	public void setNpa(Long npa) {
		this.npa = npa;
	}

	/**
	 * Gets the return reasons.
	 *
	 * @return the returnReasons
	 */
	public List<PVURopRemarksDto> getReturnReasons() {
		return returnReasons;
	}

	/**
	 * Sets the return reasons.
	 *
	 * @param returnReasons the returnReasons to set
	 */
	public void setReturnReasons(List<PVURopRemarksDto> returnReasons) {
		this.returnReasons = returnReasons;
	}

	/**
	 * Gets the auto six valid basic.
	 *
	 * @return the autoSixValidBasic
	 */
	public Long getAutoSixValidBasic() {
		return autoSixValidBasic;
	}

	/**
	 * Sets the auto six valid basic.
	 *
	 * @param autoSixValidBasic the autoSixValidBasic to set
	 */
	public void setAutoSixValidBasic(Long autoSixValidBasic) {
		this.autoSixValidBasic = autoSixValidBasic;
	}

	/**
	 * Gets the auto six valid pay value.
	 *
	 * @return the autoSixValidPayValue
	 */
	public Long getAutoSixValidPayValue() {
		return autoSixValidPayValue;
	}

	/**
	 * Sets the auto six valid pay value.
	 *
	 * @param autoSixValidPayValue the autoSixValidPayValue to set
	 */
	public void setAutoSixValidPayValue(Long autoSixValidPayValue) {
		this.autoSixValidPayValue = autoSixValidPayValue;
	}

	/**
	 * Gets the auto six valid flag.
	 *
	 * @return the autoSixValidFlag
	 */
	public Long getAutoSixValidFlag() {
		return autoSixValidFlag;
	}

	/**
	 * Sets the auto six valid flag.
	 *
	 * @param autoSixValidFlag the autoSixValidFlag to set
	 */
	public void setAutoSixValidFlag(Long autoSixValidFlag) {
		this.autoSixValidFlag = autoSixValidFlag;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(auditorRemarks, auditorReturnReason, autoSixValidBasic, autoSixValidFlag,
				autoSixValidPayValue, classId, classTwoRemarks, classTwoReturnReason, curBasicPay, curGradePay,
				curNextIncrementDate, curPayBand, curPayBandValue, curScale, designationId, effectiveDate, empId, empNo,
				id, npa, officeId, orderDate, orderNo, printCount, printRemarks, printReturnReason, remarks,
				returnReasons, revBasicPay, revCellId, revGradePay, revNextIncrementDate, revPayBand, revPayBandValue,
				revPayLevel, ropChangeEffDate, ropType, statusId, trnNo, wfRoleId);
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
		if (!(obj instanceof PVURevisionOfPayDto)) {
			return false;
		}
		PVURevisionOfPayDto other = (PVURevisionOfPayDto) obj;
		return Objects.equals(auditorRemarks, other.auditorRemarks)
				&& Objects.equals(auditorReturnReason, other.auditorReturnReason)
				&& Objects.equals(autoSixValidBasic, other.autoSixValidBasic)
				&& Objects.equals(autoSixValidFlag, other.autoSixValidFlag)
				&& Objects.equals(autoSixValidPayValue, other.autoSixValidPayValue)
				&& Objects.equals(classId, other.classId) && Objects.equals(classTwoRemarks, other.classTwoRemarks)
				&& Objects.equals(classTwoReturnReason, other.classTwoReturnReason)
				&& Objects.equals(curBasicPay, other.curBasicPay) && Objects.equals(curGradePay, other.curGradePay)
				&& Objects.equals(curNextIncrementDate, other.curNextIncrementDate)
				&& Objects.equals(curPayBand, other.curPayBand)
				&& Objects.equals(curPayBandValue, other.curPayBandValue) && Objects.equals(curScale, other.curScale)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(effectiveDate, other.effectiveDate) && Objects.equals(empId, other.empId)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(id, other.id) && Objects.equals(npa, other.npa)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderNo, other.orderNo) && Objects.equals(printCount, other.printCount)
				&& Objects.equals(printRemarks, other.printRemarks)
				&& Objects.equals(printReturnReason, other.printReturnReason) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(returnReasons, other.returnReasons) && Objects.equals(revBasicPay, other.revBasicPay)
				&& Objects.equals(revCellId, other.revCellId) && Objects.equals(revGradePay, other.revGradePay)
				&& Objects.equals(revNextIncrementDate, other.revNextIncrementDate)
				&& Objects.equals(revPayBand, other.revPayBand)
				&& Objects.equals(revPayBandValue, other.revPayBandValue)
				&& Objects.equals(revPayLevel, other.revPayLevel)
				&& Objects.equals(ropChangeEffDate, other.ropChangeEffDate) && Objects.equals(ropType, other.ropType)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVURevisionOfPayDto [id=%s, trnNo=%s, revNextIncrementDate=%s, curNextIncrementDate=%s, statusId=%s, empId=%s, ropType=%s, revPayLevel=%s, revCellId=%s, revPayBand=%s, revPayBandValue=%s, revGradePay=%s, revBasicPay=%s, effectiveDate=%s, ropChangeEffDate=%s, orderNo=%s, orderDate=%s, officeId=%s, remarks=%s, auditorRemarks=%s, classTwoRemarks=%s, printRemarks=%s, auditorReturnReason=%s, classTwoReturnReason=%s, printReturnReason=%s, printCount=%s, classId=%s, designationId=%s, curScale=%s, curGradePay=%s, curPayBand=%s, curBasicPay=%s, curPayBandValue=%s, empNo=%s, wfRoleId=%s, npa=%s, autoSixValidBasic=%s, autoSixValidPayValue=%s, autoSixValidFlag=%s, returnReasons=%s]",
				id, trnNo, revNextIncrementDate, curNextIncrementDate, statusId, empId, ropType, revPayLevel, revCellId,
				revPayBand, revPayBandValue, revGradePay, revBasicPay, effectiveDate, ropChangeEffDate, orderNo,
				orderDate, officeId, remarks, auditorRemarks, classTwoRemarks, printRemarks, auditorReturnReason,
				classTwoReturnReason, printReturnReason, printCount, classId, designationId, curScale, curGradePay,
				curPayBand, curBasicPay, curPayBandValue, empNo, wfRoleId, npa, autoSixValidBasic, autoSixValidPayValue,
				autoSixValidFlag, returnReasons);
	}

}
