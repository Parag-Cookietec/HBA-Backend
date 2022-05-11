package gov.ifms.workflow.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class WfActionConfigAsyncSubmitTrnResDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private long wfId;

	@NativeQueryResultColumn(index = 1)
	private long trnId;

	@NativeQueryResultColumn(index = 2)
	private Long actionConfigId;

	@NativeQueryResultColumn(index = 3)
	private Long wfActionId;

	@NativeQueryResultColumn(index = 4)
	private Long assignToWfRoleId;

	@NativeQueryResultColumn(index = 5)
	private Long assignToUserId;

	@NativeQueryResultColumn(index = 6)
	private Long assignToPostId;

	@NativeQueryResultColumn(index = 7)
	private Long assignToPouId;

	@NativeQueryResultColumn(index = 8)
	private Long assignToOfficeId;

	@NativeQueryResultColumn(index = 9)
	private Long assignToBranchId;

	@NativeQueryResultColumn(index = 10)
	private Long assignToGroupId;

	@NativeQueryResultColumn(index = 11)
	private String wfStatus;

	@NativeQueryResultColumn(index = 12)
	private String trnStatus;

	@NativeQueryResultColumn(index = 13)
	private Long assignByWfRoleId;

	@NativeQueryResultColumn(index = 14)
	private Long assignByUserId;

	@NativeQueryResultColumn(index = 15)
	private Long assignByPostId;

	@NativeQueryResultColumn(index = 16)
	private Long assignByPouId;

	@NativeQueryResultColumn(index = 17)
	private Long assignByOfficeId;

	@NativeQueryResultColumn(index = 18)
	private Long assignByBranchId;

	@NativeQueryResultColumn(index = 19)
	private Long assignByGroupId;

	@NativeQueryResultColumn(index = 20)
	private String remarks;

	@NativeQueryResultColumn(index = 21)
	private Long wfReqDetId;

	@NativeQueryResultColumn(index = 22)
	private Integer sqlErrCode;

	@NativeQueryResultColumn(index = 23)
	private String sqlErrState;

	@NativeQueryResultColumn(index = 24)
	private String sqlErrMsg;

	public long getWfId() {
		return wfId;
	}

	public void setWfId(long wfId) {
		this.wfId = wfId;
	}

	public long getTrnId() {
		return trnId;
	}

	public void setTrnId(long trnId) {
		this.trnId = trnId;
	}

	public Long getActionConfigId() {
		return actionConfigId;
	}

	public void setActionConfigId(Long actionConfigId) {
		this.actionConfigId = actionConfigId;
	}

	public Long getWfActionId() {
		return wfActionId;
	}

	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	public Long getAssignToUserId() {
		return assignToUserId;
	}

	public void setAssignToUserId(Long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	public Long getAssignToPostId() {
		return assignToPostId;
	}

	public void setAssignToPostId(Long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	public Long getAssignToPouId() {
		return assignToPouId;
	}

	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	public Long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	public void setAssignToOfficeId(Long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	public Long getAssignToBranchId() {
		return assignToBranchId;
	}

	public void setAssignToBranchId(Long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	public Long getAssignToGroupId() {
		return assignToGroupId;
	}

	public void setAssignToGroupId(Long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	public Long getAssignByUserId() {
		return assignByUserId;
	}

	public void setAssignByUserId(Long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	public Long getAssignByPostId() {
		return assignByPostId;
	}

	public void setAssignByPostId(Long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	public Long getAssignByPouId() {
		return assignByPouId;
	}

	public void setAssignByPouId(Long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	public Long getAssignByBranchId() {
		return assignByBranchId;
	}

	public void setAssignByBranchId(Long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	public Long getAssignByGroupId() {
		return assignByGroupId;
	}

	public void setAssignByGroupId(Long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getWfReqDetId() {
		return wfReqDetId;
	}

	public void setWfReqDetId(Long wfReqDetId) {
		this.wfReqDetId = wfReqDetId;
	}

	public Integer getSqlErrCode() {
		return sqlErrCode;
	}

	public void setSqlErrCode(Integer sqlErrCode) {
		this.sqlErrCode = sqlErrCode;
	}

	public String getSqlErrState() {
		return sqlErrState;
	}

	public void setSqlErrState(String sqlErrState) {
		this.sqlErrState = sqlErrState;
	}

	public String getSqlErrMsg() {
		return sqlErrMsg;
	}

	public void setSqlErrMsg(String sqlErrMsg) {
		this.sqlErrMsg = sqlErrMsg;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfActionConfigAsyncSubmitTrnResDto that = (WfActionConfigAsyncSubmitTrnResDto) o;
		return wfId == that.wfId &&
				trnId == that.trnId &&
				Objects.equals(actionConfigId, that.actionConfigId) &&
				Objects.equals(wfActionId, that.wfActionId) &&
				Objects.equals(assignToWfRoleId, that.assignToWfRoleId) &&
				Objects.equals(assignToUserId, that.assignToUserId) &&
				Objects.equals(assignToPostId, that.assignToPostId) &&
				Objects.equals(assignToPouId, that.assignToPouId) &&
				Objects.equals(assignToOfficeId, that.assignToOfficeId) &&
				Objects.equals(assignToBranchId, that.assignToBranchId) &&
				Objects.equals(assignToGroupId, that.assignToGroupId) &&
				Objects.equals(wfStatus, that.wfStatus) &&
				Objects.equals(trnStatus, that.trnStatus) &&
				Objects.equals(assignByWfRoleId, that.assignByWfRoleId) &&
				Objects.equals(assignByUserId, that.assignByUserId) &&
				Objects.equals(assignByPostId, that.assignByPostId) &&
				Objects.equals(assignByPouId, that.assignByPouId) &&
				Objects.equals(assignByOfficeId, that.assignByOfficeId) &&
				Objects.equals(assignByBranchId, that.assignByBranchId) &&
				Objects.equals(assignByGroupId, that.assignByGroupId) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(wfReqDetId, that.wfReqDetId) &&
				Objects.equals(sqlErrCode, that.sqlErrCode) &&
				Objects.equals(sqlErrState, that.sqlErrState) &&
				Objects.equals(sqlErrMsg, that.sqlErrMsg);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wfId, trnId, actionConfigId, wfActionId, assignToWfRoleId, assignToUserId, assignToPostId, assignToPouId, assignToOfficeId, assignToBranchId, assignToGroupId, wfStatus, trnStatus, assignByWfRoleId, assignByUserId, assignByPostId, assignByPouId, assignByOfficeId, assignByBranchId, assignByGroupId, remarks, wfReqDetId, sqlErrCode, sqlErrState, sqlErrMsg);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfActionConfigAsyncSubmitTrnResDto.class.getSimpleName() + "[", "]")
				.add("wfId=" + wfId)
				.add("trnId=" + trnId)
				.add("actionConfigId=" + actionConfigId)
				.add("wfActionId=" + wfActionId)
				.add("assignToWfRoleId=" + assignToWfRoleId)
				.add("assignToUserId=" + assignToUserId)
				.add("assignToPostId=" + assignToPostId)
				.add("assignToPouId=" + assignToPouId)
				.add("assignToOfficeId=" + assignToOfficeId)
				.add("assignToBranchId=" + assignToBranchId)
				.add("assignToGroupId=" + assignToGroupId)
				.add("wfStatus='" + wfStatus + "'")
				.add("trnStatus='" + trnStatus + "'")
				.add("assignByWfRoleId=" + assignByWfRoleId)
				.add("assignByUserId=" + assignByUserId)
				.add("assignByPostId=" + assignByPostId)
				.add("assignByPouId=" + assignByPouId)
				.add("assignByOfficeId=" + assignByOfficeId)
				.add("assignByBranchId=" + assignByBranchId)
				.add("assignByGroupId=" + assignByGroupId)
				.add("remarks='" + remarks + "'")
				.add("wfReqDetId=" + wfReqDetId)
				.add("sqlErrCode=" + sqlErrCode)
				.add("sqlErrState='" + sqlErrState + "'")
				.add("sqlErrMsg='" + sqlErrMsg + "'")
				.toString();
	}
}
