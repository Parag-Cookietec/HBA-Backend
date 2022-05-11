package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_WF database table.
 * 
 */

public class TdoiDbPolFireWfDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbPolFireWfId;

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

	// bi-directional many-to-one association to TdoiDbPolFirePeril

	private TdoiDbPolFirePerilDTO tdoiDbPolFirePeril;

	public TdoiDbPolFireWfDTO() {
	}

	public long getDbPolFireWfId() {
		return this.dbPolFireWfId;
	}

	public void setDbPolFireWfId(long dbPolFireWfId) {
		this.dbPolFireWfId = dbPolFireWfId;
	}

	public long getActionconfigId() {
		return this.actionconfigId;
	}

	public void setActionconfigId(long actionconfigId) {
		this.actionconfigId = actionconfigId;
	}

	public long getAssignByBranchId() {
		return this.assignByBranchId;
	}

	public void setAssignByBranchId(long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	public long getAssignByGroupId() {
		return this.assignByGroupId;
	}

	public void setAssignByGroupId(long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
	}

	public long getAssignByOfficeId() {
		return this.assignByOfficeId;
	}

	public void setAssignByOfficeId(long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	public long getAssignByPostId() {
		return this.assignByPostId;
	}

	public void setAssignByPostId(long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	public long getAssignByPouId() {
		return this.assignByPouId;
	}

	public void setAssignByPouId(long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	public long getAssignByUserId() {
		return this.assignByUserId;
	}

	public void setAssignByUserId(long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	public long getAssignByWfRoleId() {
		return this.assignByWfRoleId;
	}

	public void setAssignByWfRoleId(long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	public long getAssignToBranchId() {
		return this.assignToBranchId;
	}

	public void setAssignToBranchId(long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	public long getAssignToGroupId() {
		return this.assignToGroupId;
	}

	public void setAssignToGroupId(long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	public long getAssignToOfficeId() {
		return this.assignToOfficeId;
	}

	public void setAssignToOfficeId(long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	public long getAssignToPostId() {
		return this.assignToPostId;
	}

	public void setAssignToPostId(long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	public long getAssignToPouId() {
		return this.assignToPouId;
	}

	public void setAssignToPouId(long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	public long getAssignToUserId() {
		return this.assignToUserId;
	}

	public void setAssignToUserId(long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	public long getAssignToWfRoleId() {
		return this.assignToWfRoleId;
	}

	public void setAssignToWfRoleId(long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	public short getCounter() {
		return this.counter;
	}

	public void setCounter(short counter) {
		this.counter = counter;
	}

	public short getLevel() {
		return this.level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getRefColOther() {
		return this.refColOther;
	}

	public void setRefColOther(String refColOther) {
		this.refColOther = refColOther;
	}

	public short getRefColSmallint() {
		return this.refColSmallint;
	}

	public void setRefColSmallint(short refColSmallint) {
		this.refColSmallint = refColSmallint;
	}

	public String getRefColVarchar() {
		return this.refColVarchar;
	}

	public void setRefColVarchar(String refColVarchar) {
		this.refColVarchar = refColVarchar;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public short getSendBackFlag() {
		return this.sendBackFlag;
	}

	public void setSendBackFlag(short sendBackFlag) {
		this.sendBackFlag = sendBackFlag;
	}

	public short getSubCounter() {
		return this.subCounter;
	}

	public void setSubCounter(short subCounter) {
		this.subCounter = subCounter;
	}

	public String getTrnStatus() {
		return this.trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public long getWfActionId() {
		return this.wfActionId;
	}

	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	public String getWfStatus() {
		return this.wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public TdoiDbPolFirePerilDTO getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}
