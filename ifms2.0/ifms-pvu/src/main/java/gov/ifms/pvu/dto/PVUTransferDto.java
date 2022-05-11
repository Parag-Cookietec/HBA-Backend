package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.util.PvuConstant;

import javax.validation.constraints.Min;

/**
 * The Class PVUTransferDto.
 *
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */
public class PVUTransferDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	private long id;

	/**
	 * The transaction no.
	 */
	private String trnNo;

	/**
	 * The office id.
	 */
	private long officeId;

	/**
	 * The transfer order no.
	 */
	private String transferOrderNo;

	/**
	 * The transfer order date.
	 */
	private LocalDate transferOrderDate;

	@Min(value = 0)
	private long employeeId;

	private long districtId;

	private String cardexNo;

	/**
	 * The ddo code.
	 */
	private String ddoCode;

	/**
	 * The sub office id.
	 */
	private long subOfficeId;

	/**
	 * The relieving date.
	 */
	private Date relievingDate;

	/**
	 * The transfer noon type.
	 */
	private long transferNoonType;

	/**
	 * The reason for transfer.
	 */
	private long reasonForTransfer;

	/**
	 * The transfer remarks.
	 */
	private String transferRemarks;

	/**
	 * The joining noon type.
	 */
	private long joiningNoonType;
	/**
	 * The joining remarks.
	 */
	private String joiningRemarks;

	/**
	 * The status id.
	 */
	private long statusId;

	/**
	 * The joining sub office id.
	 */
	private long joiningSubOfficeId;

	/**
	 * The actual joining date.
	 */
	private Date actualJoiningDate;


	private long workflowActionId;

	private long workflowStatusId;

	private long curOfficeId;

	private long curDistrict;

	private String curCardexNo;

	/**
	 * The ddo code.
	 */
	private String curDDONo;
	private String eventCode = PvuConstant.EVENT_CODE_TRANSFER;

	private long employeeNo;

	private String empName;
	private String empDesignation;
	private String curDistrictName;
	private String curOffName;
	private String curSubOfficeName;
	private LocalDateTime refDate;
	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	public String getTransferOrderNo() {
		return transferOrderNo;
	}

	public void setTransferOrderNo(String transferOrderNo) {
		this.transferOrderNo = transferOrderNo;
	}

	public LocalDate getTransferOrderDate() {
		return transferOrderDate;
	}

	public void setTransferOrderDate(LocalDate transferOrderDate) {
		this.transferOrderDate = transferOrderDate;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getSubOfficeId() {
		return subOfficeId;
	}

	public void setSubOfficeId(long subOfficeId) {
		this.subOfficeId = subOfficeId;
	}

	public Date getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(Date relievingDate) {
		this.relievingDate = relievingDate;
	}

	public long getTransferNoonType() {
		return transferNoonType;
	}

	public void setTransferNoonType(long transferNoonType) {
		this.transferNoonType = transferNoonType;
	}

	public long getReasonForTransfer() {
		return reasonForTransfer;
	}

	public void setReasonForTransfer(long reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}

	public String getTransferRemarks() {
		return transferRemarks;
	}

	public void setTransferRemarks(String transferRemarks) {
		this.transferRemarks = transferRemarks;
	}

	public long getJoiningNoonType() {
		return joiningNoonType;
	}

	public void setJoiningNoonType(long joiningNoonType) {
		this.joiningNoonType = joiningNoonType;
	}

	public String getJoiningRemarks() {
		return joiningRemarks;
	}

	public void setJoiningRemarks(String joiningRemarks) {
		this.joiningRemarks = joiningRemarks;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getJoiningSubOfficeId() {
		return joiningSubOfficeId;
	}

	public void setJoiningSubOfficeId(long joiningSubOfficeId) {
		this.joiningSubOfficeId = joiningSubOfficeId;
	}

	public Date getActualJoiningDate() {
		return actualJoiningDate;
	}

	public void setActualJoiningDate(Date actualJoiningDate) {
		this.actualJoiningDate = actualJoiningDate;
	}

	public long getWorkflowActionId() {
		return workflowActionId;
	}

	public void setWorkflowActionId(long workflowActionId) {
		this.workflowActionId = workflowActionId;
	}

	public long getWorkflowStatusId() {
		return workflowStatusId;
	}

	public void setWorkflowStatusId(long workflowStatusId) {
		this.workflowStatusId = workflowStatusId;
	}

	public long getCurOfficeId() {
		return curOfficeId;
	}

	public void setCurOfficeId(long curOfficeId) {
		this.curOfficeId = curOfficeId;
	}

	public long getCurDistrict() {
		return curDistrict;
	}

	public void setCurDistrict(long curDistrict) {
		this.curDistrict = curDistrict;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getCurDistrictName() {
		return curDistrictName;
	}

	public void setCurDistrictName(String curDistrictName) {
		this.curDistrictName = curDistrictName;
	}

	public String getCurOffName() {
		return curOffName;
	}

	public void setCurOffName(String curOffName) {
		this.curOffName = curOffName;
	}

	public String getCurSubOfficeName() {
		return curSubOfficeName;
	}

	public void setCurSubOfficeName(String curSubOfficeName) {
		this.curSubOfficeName = curSubOfficeName;
	}

	public String getCardexNo() {
		return cardexNo;
	}

	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	public String getDdoCode() {
		return ddoCode;
	}

	public void setDdoCode(String ddoCode) {
		this.ddoCode = ddoCode;
	}

	public String getCurCardexNo() {
		return curCardexNo;
	}

	public void setCurCardexNo(String curCardexNo) {
		this.curCardexNo = curCardexNo;
	}

	public String getCurDDONo() {
		return curDDONo;
	}

	public void setCurDDONo(String curDDONo) {
		this.curDDONo = curDDONo;
	}

	@JsonIgnore
	public boolean isNew() {
		return this.id == 0;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUTransferDto)) return false;
		if (!super.equals(o)) return false;
		PVUTransferDto that = (PVUTransferDto) o;
		return getId() == that.getId() &&
				getOfficeId() == that.getOfficeId() &&
				getEmployeeId() == that.getEmployeeId() &&
				getDistrictId() == that.getDistrictId() &&
				getSubOfficeId() == that.getSubOfficeId() &&
				getTransferNoonType() == that.getTransferNoonType() &&
				getReasonForTransfer() == that.getReasonForTransfer() &&
				getJoiningNoonType() == that.getJoiningNoonType() &&
				getStatusId() == that.getStatusId() &&
				getJoiningSubOfficeId() == that.getJoiningSubOfficeId() &&
				getWorkflowActionId() == that.getWorkflowActionId() &&
				getWorkflowStatusId() == that.getWorkflowStatusId() &&
				getCurOfficeId() == that.getCurOfficeId() &&
				getCurDistrict() == that.getCurDistrict() &&
				getEmployeeNo() == that.getEmployeeNo() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getTransferOrderNo(), that.getTransferOrderNo()) &&
				Objects.equals(getTransferOrderDate(), that.getTransferOrderDate()) &&
				Objects.equals(getCardexNo(), that.getCardexNo()) &&
				Objects.equals(getDdoCode(), that.getDdoCode()) &&
				Objects.equals(getRelievingDate(), that.getRelievingDate()) &&
				Objects.equals(getTransferRemarks(), that.getTransferRemarks()) &&
				Objects.equals(getJoiningRemarks(), that.getJoiningRemarks()) &&
				Objects.equals(getActualJoiningDate(), that.getActualJoiningDate()) &&
				Objects.equals(getCurCardexNo(), that.getCurCardexNo()) &&
				Objects.equals(getCurDDONo(), that.getCurDDONo()) &&
				Objects.equals(getEventCode(), that.getEventCode()) &&
				Objects.equals(getEmpName(), that.getEmpName()) &&
				Objects.equals(getEmpDesignation(), that.getEmpDesignation()) &&
				Objects.equals(getCurDistrictName(), that.getCurDistrictName()) &&
				Objects.equals(getCurOffName(), that.getCurOffName()) &&
				Objects.equals(getCurSubOfficeName(), that.getCurSubOfficeName()) &&
				Objects.equals(refDate, that.refDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getTrnNo(), getOfficeId(), getTransferOrderNo(), getTransferOrderDate(), getEmployeeId(), getDistrictId(), getCardexNo(), getDdoCode(), getSubOfficeId(), getRelievingDate(), getTransferNoonType(), getReasonForTransfer(), getTransferRemarks(), getJoiningNoonType(), getJoiningRemarks(), getStatusId(), getJoiningSubOfficeId(), getActualJoiningDate(), getWorkflowActionId(), getWorkflowStatusId(), getCurOfficeId(), getCurDistrict(), getCurCardexNo(), getCurDDONo(), getEventCode(), getEmployeeNo(), getEmpName(), getEmpDesignation(), getCurDistrictName(), getCurOffName(), getCurSubOfficeName(), refDate);
	}

	@Override
	public String toString() {
		return "PVUTransferDto{" +
				"id=" + id +
				", trnNo='" + trnNo + '\'' +
				", officeId=" + officeId +
				", transferOrderNo='" + transferOrderNo + '\'' +
				", transferOrderDate=" + transferOrderDate +
				", employeeId=" + employeeId +
				", districtId=" + districtId +
				", cardexNo='" + cardexNo + '\'' +
				", ddoCode='" + ddoCode + '\'' +
				", subOfficeId=" + subOfficeId +
				", relievingDate=" + relievingDate +
				", transferNoonType=" + transferNoonType +
				", reasonForTransfer=" + reasonForTransfer +
				", transferRemarks='" + transferRemarks + '\'' +
				", joiningNoonType=" + joiningNoonType +
				", joiningRemarks='" + joiningRemarks + '\'' +
				", statusId=" + statusId +
				", joiningSubOfficeId=" + joiningSubOfficeId +
				", actualJoiningDate=" + actualJoiningDate +
				", workflowActionId=" + workflowActionId +
				", workflowStatusId=" + workflowStatusId +
				", curOfficeId=" + curOfficeId +
				", curDistrict=" + curDistrict +
				", curCardexNo='" + curCardexNo + '\'' +
				", curDDONo='" + curDDONo + '\'' +
				", eventCode='" + eventCode + '\'' +
				", employeeNo=" + employeeNo +
				", empName='" + empName + '\'' +
				", empDesignation='" + empDesignation + '\'' +
				", curDistrictName='" + curDistrictName + '\'' +
				", curOffName='" + curOffName + '\'' +
				", curSubOfficeName='" + curSubOfficeName + '\'' +
				", refDate=" + refDate +
				'}';
	}
}
