package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_HBA_CLAIM_WF database table. * @author
 * Sagar Jadhav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaClaimWfDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long hbaClaimWfId;

	private long actionconfigId;

	private long assignByBranchId;

	private long assignByGroupId;

	private long assignByOfficeId;

	private long assignByPostId;

	private long assignByPouId;

	private long assignByUserId;

	private long assignByWfRoleId;

	private long assignToBranchId;

	private long assignToGroupId;

	private long assignToOfficeId;

	private long assignToPostId;

	private long assignToPouId;

	private long assignToUserId;

	private long assignToWfRoleId;

	private short counter;

	private short level;

	private String refColOther;

	private short refColSmallint;

	private String refColVarchar;

	private String remarks;

	private short sendBackFlag;

	private short subCounter;

	private String trnStatus;

	private long wfActionId;

	private String wfStatus;

	private TdoiHbaClaimEntryDTO tdoiHbaClaimEntry;

	public long getHbaClaimWfId() {
		return hbaClaimWfId;
	}

	public void setHbaClaimWfId(long hbaClaimWfId) {
		this.hbaClaimWfId = hbaClaimWfId;
	}

	public long getActionconfigId() {
		return actionconfigId;
	}

	public void setActionconfigId(long actionconfigId) {
		this.actionconfigId = actionconfigId;
	}

	public long getAssignByBranchId() {
		return assignByBranchId;
	}

	public void setAssignByBranchId(long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	public long getAssignByGroupId() {
		return assignByGroupId;
	}

	public void setAssignByGroupId(long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
	}

	public long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	public void setAssignByOfficeId(long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	public long getAssignByPostId() {
		return assignByPostId;
	}

	public void setAssignByPostId(long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	public long getAssignByPouId() {
		return assignByPouId;
	}

	public void setAssignByPouId(long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	public long getAssignByUserId() {
		return assignByUserId;
	}

	public void setAssignByUserId(long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	public long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	public void setAssignByWfRoleId(long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	public long getAssignToBranchId() {
		return assignToBranchId;
	}

	public void setAssignToBranchId(long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	public long getAssignToGroupId() {
		return assignToGroupId;
	}

	public void setAssignToGroupId(long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	public long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	public void setAssignToOfficeId(long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	public long getAssignToPostId() {
		return assignToPostId;
	}

	public void setAssignToPostId(long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	public long getAssignToPouId() {
		return assignToPouId;
	}

	public void setAssignToPouId(long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	public long getAssignToUserId() {
		return assignToUserId;
	}

	public void setAssignToUserId(long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	public long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	public void setAssignToWfRoleId(long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	public short getCounter() {
		return counter;
	}

	public void setCounter(short counter) {
		this.counter = counter;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getRefColOther() {
		return refColOther;
	}

	public void setRefColOther(String refColOther) {
		this.refColOther = refColOther;
	}

	public short getRefColSmallint() {
		return refColSmallint;
	}

	public void setRefColSmallint(short refColSmallint) {
		this.refColSmallint = refColSmallint;
	}

	public String getRefColVarchar() {
		return refColVarchar;
	}

	public void setRefColVarchar(String refColVarchar) {
		this.refColVarchar = refColVarchar;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public short getSendBackFlag() {
		return sendBackFlag;
	}

	public void setSendBackFlag(short sendBackFlag) {
		this.sendBackFlag = sendBackFlag;
	}

	public short getSubCounter() {
		return subCounter;
	}

	public void setSubCounter(short subCounter) {
		this.subCounter = subCounter;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public long getWfActionId() {
		return wfActionId;
	}

	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public TdoiHbaClaimEntryDTO getTdoiHbaClaimEntry() {
		return tdoiHbaClaimEntry;
	}

	public void setTdoiHbaClaimEntry(TdoiHbaClaimEntryDTO tdoiHbaClaimEntry) {
		this.tdoiHbaClaimEntry = tdoiHbaClaimEntry;
	}

}
