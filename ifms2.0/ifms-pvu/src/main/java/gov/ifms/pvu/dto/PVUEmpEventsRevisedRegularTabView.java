package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class PVUEmpEventsRevisedRegularTabView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event traNo. */
	@NativeQueryResultColumn(index = 0)
	private String empEventId;

	/** The event empNo. */
	@NativeQueryResultColumn(index = 1)
	private String trnNo;

	/** The event empName. */
	@NativeQueryResultColumn(index = 2)
	private String eventName;

	/** The event designation. */
	@NativeQueryResultColumn(index = 3)
	private String eventDate;

	/** The event empType. */
	@NativeQueryResultColumn(index = 4)
	private String payScalePayBand;

	/** The event officeName. */
	@NativeQueryResultColumn(index = 5)
	private String gradePayPayLevel;

	/** The event officeName. */
	@NativeQueryResultColumn(index = 6)
	private String payBandValueCellId;

	/** The event status. */
	@NativeQueryResultColumn(index = 7)
	private String basicPay;

	/** The event status. */
	@NativeQueryResultColumn(index = 8)
	private String dateOfNextIncr;

	/** The event eventCode. */
	@NativeQueryResultColumn(index = 9)
	private String designation;

	/** The event recordsCount. */
	@NativeQueryResultColumn(index = 10)
	private String optionAvail;

	/** The event id. */
	@NativeQueryResultColumn(index = 11)
	private String optionAvailDate;

	/** The event eventUpdateDate. */
	@NativeQueryResultColumn(index = 12)
	private String eventAuditDate;

	/** The event isEdit. */
	@NativeQueryResultColumn(index = 13)
	private String revised;

	@NativeQueryResultColumn(index = 14)
	private String revisionNo;

	@NativeQueryResultColumn(index = 15)
	private String impactedByRevNo;

	@NativeQueryResultColumn(index = 16)
	private String eventCode;

	@NativeQueryResultColumn(index = 17)
	private String status;

	@NativeQueryResultColumn(index = 18)
	private String visibleFlag;

	@NativeQueryResultColumn(index = 19)
	private String eventByeffectedName;

	@NativeQueryResultColumn(index = 20)
	private String eventByTranNumber;


	@Override
	public int hashCode() {
		return Objects.hash(basicPay, dateOfNextIncr, designation, empEventId, eventAuditDate, eventCode, eventDate,
				eventName, gradePayPayLevel, impactedByRevNo, optionAvail, optionAvailDate, payBandValueCellId,
				payScalePayBand, revised, revisionNo, status, trnNo, visibleFlag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmpEventsRevisedRegularTabView)) {
			return false;
		}
		PVUEmpEventsRevisedRegularTabView other = (PVUEmpEventsRevisedRegularTabView) obj;
		return Objects.equals(basicPay, other.basicPay) && Objects.equals(dateOfNextIncr, other.dateOfNextIncr)
				&& Objects.equals(designation, other.designation) && Objects.equals(empEventId, other.empEventId)
				&& Objects.equals(eventAuditDate, other.eventAuditDate) && Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventDate, other.eventDate) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(gradePayPayLevel, other.gradePayPayLevel)
				&& Objects.equals(impactedByRevNo, other.impactedByRevNo)
				&& Objects.equals(optionAvail, other.optionAvail)
				&& Objects.equals(optionAvailDate, other.optionAvailDate)
				&& Objects.equals(payBandValueCellId, other.payBandValueCellId)
				&& Objects.equals(payScalePayBand, other.payScalePayBand) && Objects.equals(revised, other.revised)
				&& Objects.equals(revisionNo, other.revisionNo) && Objects.equals(status, other.status)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(visibleFlag, other.visibleFlag);
	}

	/**
	 * @return the empEventId
	 */
	public String getEmpEventId() {
		return empEventId;
	}

	/**
	 * @param empEventId the empEventId to set
	 */
	public void setEmpEventId(String empEventId) {
		this.empEventId = empEventId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the eventDate
	 */
	public String getEventDate() {
		return eventDate;
	}

	/**
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the payScalePayBand
	 */
	public String getPayScalePayBand() {
		return payScalePayBand;
	}

	/**
	 * @param payScalePayBand the payScalePayBand to set
	 */
	public void setPayScalePayBand(String payScalePayBand) {
		this.payScalePayBand = payScalePayBand;
	}

	/**
	 * @return the gradePayPayLevel
	 */
	public String getGradePayPayLevel() {
		return gradePayPayLevel;
	}

	/**
	 * @param gradePayPayLevel the gradePayPayLevel to set
	 */
	public void setGradePayPayLevel(String gradePayPayLevel) {
		this.gradePayPayLevel = gradePayPayLevel;
	}

	/**
	 * @return the payBandValueCellId
	 */
	public String getPayBandValueCellId() {
		return payBandValueCellId;
	}

	/**
	 * @param payBandValueCellId the payBandValueCellId to set
	 */
	public void setPayBandValueCellId(String payBandValueCellId) {
		this.payBandValueCellId = payBandValueCellId;
	}

	/**
	 * @return the basicPay
	 */
	public String getBasicPay() {
		return basicPay;
	}

	/**
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the dateOfNextIncr
	 */
	public String getDateOfNextIncr() {
		return dateOfNextIncr;
	}

	/**
	 * @param dateOfNextIncr the dateOfNextIncr to set
	 */
	public void setDateOfNextIncr(String dateOfNextIncr) {
		this.dateOfNextIncr = dateOfNextIncr;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the optionAvail
	 */
	public String getOptionAvail() {
		return optionAvail;
	}

	/**
	 * @param optionAvail the optionAvail to set
	 */
	public void setOptionAvail(String optionAvail) {
		this.optionAvail = optionAvail;
	}

	/**
	 * @return the optionAvailDate
	 */
	public String getOptionAvailDate() {
		return optionAvailDate;
	}

	/**
	 * @param optionAvailDate the optionAvailDate to set
	 */
	public void setOptionAvailDate(String optionAvailDate) {
		this.optionAvailDate = optionAvailDate;
	}

	/**
	 * @return the eventAuditDate
	 */
	public String getEventAuditDate() {
		return eventAuditDate;
	}

	/**
	 * @param eventAuditDate the eventAuditDate to set
	 */
	public void setEventAuditDate(String eventAuditDate) {
		this.eventAuditDate = eventAuditDate;
	}

	/**
	 * @return the revised
	 */
	public String getRevised() {
		return revised;
	}

	/**
	 * @param revised the revised to set
	 */
	public void setRevised(String revised) {
		this.revised = revised;
	}

	/**
	 * @return the revisionNo
	 */
	public String getRevisionNo() {
		return revisionNo;
	}

	/**
	 * @param revisionNo the revisionNo to set
	 */
	public void setRevisionNo(String revisionNo) {
		this.revisionNo = revisionNo;
	}

	/**
	 * @return the impactedByRevNo
	 */
	public String getImpactedByRevNo() {
		return impactedByRevNo;
	}

	/**
	 * @param impactedByRevNo the impactedByRevNo to set
	 */
	public void setImpactedByRevNo(String impactedByRevNo) {
		this.impactedByRevNo = impactedByRevNo;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public PVUEmpEventsRevisedRegularTabView() {
		super();
	}

	/**
	 * @return the visibleFlag
	 */
	public String getVisibleFlag() {
		return visibleFlag;
	}

	/**
	 * @param visibleFlag the visibleFlag to set
	 */
	public void setVisibleFlag(String visibleFlag) {
		this.visibleFlag = visibleFlag;
	}

	public String getEventByeffectedName() {
		return eventByeffectedName;
	}

	public void setEventByeffectedName(String eventByeffectedName) {
		this.eventByeffectedName = eventByeffectedName;
	}

	public String getEventByTranNumber() {
		return eventByTranNumber;
	}

	public void setEventByTranNumber(String eventByTranNumber) {
		this.eventByTranNumber = eventByTranNumber;
	}
}