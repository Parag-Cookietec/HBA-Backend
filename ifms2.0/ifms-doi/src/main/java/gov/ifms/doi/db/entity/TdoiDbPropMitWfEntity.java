package gov.ifms.doi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_PROP_MIT_WF database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROP_MIT_WF", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropMitWfEntity.findAll", query = "SELECT t FROM TdoiDbPropMitWfEntity t")
public class TdoiDbPropMitWfEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_PROP_MIT_WF_ID", unique = true, nullable = false)
	private long dbPropMitWfId;

	@Column(name = "ACTIONCONFIG_ID")
	private long actionconfigId;

	@Column(name = "ASSIGN_BY_BRANCH_ID")
	private long assignByBranchId;

	@Column(name = "ASSIGN_BY_GROUP_ID")
	private long assignByGroupId;

	@Column(name = "ASSIGN_BY_OFFICE_ID")
	private long assignByOfficeId;

	@Column(name = "ASSIGN_BY_POST_ID")
	private long assignByPostId;

	@Column(name = "ASSIGN_BY_POU_ID")
	private long assignByPouId;

	@Column(name = "ASSIGN_BY_USER_ID")
	private long assignByUserId;

	@Column(name = "ASSIGN_BY_WF_ROLE_ID")
	private long assignByWfRoleId;

	@Column(name = "ASSIGN_TO_BRANCH_ID")
	private long assignToBranchId;

	@Column(name = "ASSIGN_TO_GROUP_ID")
	private long assignToGroupId;

	@Column(name = "ASSIGN_TO_OFFICE_ID")
	private long assignToOfficeId;

	@Column(name = "ASSIGN_TO_POST_ID")
	private long assignToPostId;

	@Column(name = "ASSIGN_TO_POU_ID")
	private long assignToPouId;

	@Column(name = "ASSIGN_TO_USER_ID")
	private long assignToUserId;

	@Column(name = "ASSIGN_TO_WF_ROLE_ID")
	private long assignToWfRoleId;

	@Column(nullable = false)
	private short counter;

	@Column(name = "\"LEVEL\"", nullable = false)
	private short level;

	@Column(name = "REF_COL_OTHER", length = 50)
	private String refColOther;

	@Column(name = "REF_COL_SMALLINT", nullable = false)
	private short refColSmallint;

	@Column(name = "REF_COL_VARCHAR", length = 50)
	private String refColVarchar;

	@Column(length = 500)
	private String remarks;

	@Column(name = "SEND_BACK_FLAG", nullable = false)
	private short sendBackFlag;

	@Column(name = "SUB_COUNTER", nullable = false)
	private short subCounter;

	@Column(name = "TRN_STATUS", length = 50)
	private String trnStatus;

	@Column(name = "WF_ACTION_ID")
	private long wfActionId;

	@Column(name = "WF_STATUS", length = 50)
	private String wfStatus;

	// bi-directional many-to-one association to TdoiDbPropMoneyIntransit
	@ManyToOne
	@JoinColumn(name = "TRN_ID")
	private TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit;

	public TdoiDbPropMitWfEntity() {
	}

	public long getDbPropMitWfId() {
		return this.dbPropMitWfId;
	}

	public void setDbPropMitWfId(long dbPropMitWfId) {
		this.dbPropMitWfId = dbPropMitWfId;
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

	public TdoiDbPropMoneyIntransitEntity getTdoiDbPropMoneyIntransit() {
		return this.tdoiDbPropMoneyIntransit;
	}

	public void setTdoiDbPropMoneyIntransit(TdoiDbPropMoneyIntransitEntity tdoiDbPropMoneyIntransit) {
		this.tdoiDbPropMoneyIntransit = tdoiDbPropMoneyIntransit;
	}

}