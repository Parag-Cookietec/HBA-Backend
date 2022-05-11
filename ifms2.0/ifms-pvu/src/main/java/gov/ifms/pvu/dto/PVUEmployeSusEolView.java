package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVUEmployeSixPayEventView.
 */
@NativeQueryResultEntity
public class PVUEmployeSusEolView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp event id. */
	@NativeQueryResultColumn(index = 0)
	private long empEventId;

	/** The emp id. */
	@NativeQueryResultColumn(index = 1)
	private long empId;

	/** The transac number. */
	@NativeQueryResultColumn(index = 2)
	private String trnNo;

	/** The event name. */
	@NativeQueryResultColumn(index = 3)
	private String eventName;

	/** The event date. */
	@NativeQueryResultColumn(index = 4)
	private String fromDate;

	/** The pay band. */
	@NativeQueryResultColumn(index = 5)
	private String endDate;

	/** The designation. */
	@NativeQueryResultColumn(index = 6)
	private String designationId;

	/** The designation. */
	@NativeQueryResultColumn(index = 7)
	private String designation;

	/** The emp basic pay. */
	@NativeQueryResultColumn(index = 8)
	private String empBasicPay;

	/** The active status. */
	@NativeQueryResultColumn(index = 9)
	private String activeStatus;

	@NativeQueryResultColumn(index = 10)
	private String payCommission;

	@NativeQueryResultColumn(index = 11)
	private Long officeId;

	@NativeQueryResultColumn(index = 12)
	private String officeName;

	@NativeQueryResultColumn(index = 13)
	private String payBandValue;

	@NativeQueryResultColumn(index = 14)
	private String payScale;

	@NativeQueryResultColumn(index = 15)
	private String paylevelId;

	@NativeQueryResultColumn(index = 16)
	private String gradePay;

	/** The recored. */
	@NativeQueryResultColumn(index = 17)
	private String recored;

	/** The recored. */
	@NativeQueryResultColumn(index = 18)
	private String payCommId;

	@NativeQueryResultColumn(index = 19)
	private String eventCode;

	@NativeQueryResultColumn(index = 20)
	private String visibleFlag;

	@NativeQueryResultColumn(index = 21)
	private String cellId;

	public long getEmpEventId() {
		return empEventId;
	}

	public void setEmpEventId(long empEventId) {
		this.empEventId = empEventId;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpBasicPay() {
		return empBasicPay;
	}

	public void setEmpBasicPay(String empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * @return the activeStatus
	 */
	public String getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getRecored() {
		return recored;
	}

	public void setRecored(String recored) {
		this.recored = recored;
	}

	@Override
	public String toString() {
		return "PVUEmployeSusEolView [empEventId=" + empEventId + ", empId=" + empId + ", transacNumber=" + trnNo
				+ ", eventName=" + eventName + ", fromDate=" + fromDate + ", endDate=" + endDate + ", designationId="
				+ designationId + ", designation=" + designation + ", empBasicPay=" + empBasicPay + ", activeStatus="
				+ activeStatus + ", recored=" + recored + ", payCommission=" + payCommission + ", payBandValue="
				+ payBandValue + ", payScale=" + payScale + ", paylevelId=" + paylevelId + ", gradePay=" + gradePay
				+ ", officeId=" + officeId + ", officeName=" + officeName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, cellId, designation, designationId, empBasicPay, empEventId, empId, endDate,
				eventCode, eventName, fromDate, gradePay, officeId, officeName, payBandValue, payCommId, payCommission,
				payScale, paylevelId, recored, trnNo, visibleFlag);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeSusEolView)) {
			return false;
		}
		PVUEmployeSusEolView other = (PVUEmployeSusEolView) obj;
		return Objects.equals(activeStatus, other.activeStatus) && Objects.equals(cellId, other.cellId)
				&& Objects.equals(designation, other.designation) && Objects.equals(designationId, other.designationId)
				&& Objects.equals(empBasicPay, other.empBasicPay) && empEventId == other.empEventId
				&& empId == other.empId && Objects.equals(endDate, other.endDate)
				&& Objects.equals(eventCode, other.eventCode) && Objects.equals(eventName, other.eventName)
				&& Objects.equals(fromDate, other.fromDate) && Objects.equals(gradePay, other.gradePay)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(payBandValue, other.payBandValue) && Objects.equals(payCommId, other.payCommId)
				&& Objects.equals(payCommission, other.payCommission) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(paylevelId, other.paylevelId) && Objects.equals(recored, other.recored)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(visibleFlag, other.visibleFlag);
	}

	public String getPayCommission() {
		return payCommission;
	}

	public void setPayCommission(String payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the paylevelId
	 */
	public String getPaylevelId() {
		return paylevelId;
	}

	/**
	 * @param paylevelId the paylevelId to set
	 */
	public void setPaylevelId(String paylevelId) {
		this.paylevelId = paylevelId;
	}

	/**
	 * @return the gradePay
	 */
	public String getGradePay() {
		return gradePay;
	}

	/**
	 * @param gradePay the gradePay to set
	 */
	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the payCommId
	 */
	public String getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(String payCommId) {
		this.payCommId = payCommId;
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

	/**
	 * @return the cellId
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

}
