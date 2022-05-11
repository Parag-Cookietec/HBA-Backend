package gov.ifms.pvu.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class PVUIncrementListView.
 */
@NativeQueryResultEntity
public class PVUEmployeeIncrementListView implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event id. */
	@NativeQueryResultColumn(index = 0)
	private String tranNo;

	@NativeQueryResultColumn(index = 1)
	private String ddoNo;

	@NativeQueryResultColumn(index = 2)
	private String cardex;

	@NativeQueryResultColumn(index = 3)
	private String officeName;

	/** The tran no. */
	@NativeQueryResultColumn(index = 4)
	private long financialYear;

	/** The increment type. */
	@NativeQueryResultColumn(index = 5)
	private String incrementType;

	/** The increment for. */
	@NativeQueryResultColumn(index = 6)
	private String incrementFor;

	@NativeQueryResultColumn(index = 7)
	private long totalCount;

	@NativeQueryResultColumn(index = 8)
	private long successCount;

	@NativeQueryResultColumn(index = 9)
	private long failureCount;

	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The record count. */
	@NativeQueryResultColumn(index = 11)
	private long recordCount;

	@NativeQueryResultColumn(index = 12)
	private long eventId;

	/** The updated date. */
	@NativeQueryResultColumn(index = 13)
	private Date referenceDate;

	/** The updated date. */
	@NativeQueryResultColumn(index = 14)
	private long workflowCount;

	/** The wf status. */
	@NativeQueryResultColumn(index = 15)
	private String wfStatus;

	/** The tran status. */
	@NativeQueryResultColumn(index = 16)
	private String tranStatus;

	/** The updated date. */
	@NativeQueryResultColumn(index = 17)
	private Date incrEffDate;

	@NativeQueryResultColumn(index = 18)
	private String empPayType ;

	@NativeQueryResultColumn(index = 19)
	private Long isEditable;

	@NativeQueryResultColumn(index = 20)
	private Long deleteFlag;


	public String getTranNo() {
		return tranNo;
	}

	public void setTranNo(String tranNo) {
		this.tranNo = tranNo;
	}

	public String getDdoNo() {
		return ddoNo;
	}

	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	public String getCardex() {
		return cardex;
	}

	public void setCardex(String cardex) {
		this.cardex = cardex;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public long getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(long financialYear) {
		this.financialYear = financialYear;
	}

	public String getIncrementType() {
		return incrementType;
	}

	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	public String getIncrementFor() {
		return incrementFor;
	}

	public void setIncrementFor(String incrementFor) {
		this.incrementFor = incrementFor;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(long successCount) {
		this.successCount = successCount;
	}

	public long getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(long failureCount) {
		this.failureCount = failureCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public long getWorkflowCount() {
		return workflowCount;
	}

	public void setWorkflowCount(long workflowCount) {
		this.workflowCount = workflowCount;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public Date getIncrEffDate() {
		return incrEffDate;
	}

	public void setIncrEffDate(Date incrEffDate) {
		this.incrEffDate = incrEffDate;
	}

	public String getEmpPayType() {
		return empPayType;
	}

	public void setEmpPayType(String empPayType) {
		this.empPayType = empPayType;
	}

	public Long getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	public Long getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Long deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUEmployeeIncrementListView)) return false;
		PVUEmployeeIncrementListView that = (PVUEmployeeIncrementListView) o;
		return getFinancialYear() == that.getFinancialYear() &&
				getTotalCount() == that.getTotalCount() &&
				getSuccessCount() == that.getSuccessCount() &&
				getFailureCount() == that.getFailureCount() &&
				getRecordCount() == that.getRecordCount() &&
				getEventId() == that.getEventId() &&
				getWorkflowCount() == that.getWorkflowCount() &&
				Objects.equals(getTranNo(), that.getTranNo()) &&
				Objects.equals(getDdoNo(), that.getDdoNo()) &&
				Objects.equals(getCardex(), that.getCardex()) &&
				Objects.equals(getOfficeName(), that.getOfficeName()) &&
				Objects.equals(getIncrementType(), that.getIncrementType()) &&
				Objects.equals(getIncrementFor(), that.getIncrementFor()) &&
				Objects.equals(getStatus(), that.getStatus()) &&
				Objects.equals(getReferenceDate(), that.getReferenceDate()) &&
				Objects.equals(getWfStatus(), that.getWfStatus()) &&
				Objects.equals(getTranStatus(), that.getTranStatus()) &&
				Objects.equals(getIncrEffDate(), that.getIncrEffDate()) &&
				Objects.equals(getEmpPayType(), that.getEmpPayType()) &&
				Objects.equals(getIsEditable(), that.getIsEditable()) &&
				Objects.equals(getDeleteFlag(), that.getDeleteFlag());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTranNo(), getDdoNo(), getCardex(), getOfficeName(), getFinancialYear(), getIncrementType(), getIncrementFor(), getTotalCount(), getSuccessCount(), getFailureCount(), getStatus(), getRecordCount(), getEventId(), getReferenceDate(), getWorkflowCount(), getWfStatus(), getTranStatus(), getIncrEffDate(), getEmpPayType(), getIsEditable(), getDeleteFlag());
	}

	@Override
	public String toString() {
		return "PVUEmployeeIncrementListView{" +
				"tranNo='" + tranNo + '\'' +
				", ddoNo='" + ddoNo + '\'' +
				", cardex='" + cardex + '\'' +
				", officeName='" + officeName + '\'' +
				", financialYear=" + financialYear +
				", incrementType='" + incrementType + '\'' +
				", incrementFor='" + incrementFor + '\'' +
				", totalCount=" + totalCount +
				", successCount=" + successCount +
				", failureCount=" + failureCount +
				", status='" + status + '\'' +
				", recordCount=" + recordCount +
				", eventId=" + eventId +
				", referenceDate=" + referenceDate +
				", workflowCount=" + workflowCount +
				", wfStatus='" + wfStatus + '\'' +
				", tranStatus='" + tranStatus + '\'' +
				", incrEffDate=" + incrEffDate +
				", empPayType='" + empPayType + '\'' +
				", isEditable=" + isEditable +
				", deleteFlag=" + deleteFlag +
				'}';
	}
}
