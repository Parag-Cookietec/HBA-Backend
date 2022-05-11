package gov.ifms.doi.reinsurance.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_RI_CLAIM_HDR_WF", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiRiClaimHdrWFEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3230657610201103625L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_CLAIM_WF_ID", unique=true, nullable=false)
	private long riClaimWfId;

	@Column(name="ACTIONCONFIG_ID")
	private long actionconfigId;

	@Column(name="ASSIGN_BY_BRANCH_ID")
	private long assignByBranchId;

	@Column(name="ASSIGN_BY_GROUP_ID")
	private long assignByGroupId;

	@Column(name="ASSIGN_BY_OFFICE_ID")
	private long assignByOfficeId;

	@Column(name="ASSIGN_BY_POST_ID")
	private long assignByPostId;

	@Column(name="ASSIGN_BY_POU_ID")
	private long assignByPouId;

	@Column(name="ASSIGN_BY_USER_ID")
	private long assignByUserId;

	@Column(name="ASSIGN_BY_WF_ROLE_ID")
	private long assignByWfRoleId;

	@Column(name="ASSIGN_TO_BRANCH_ID")
	private long assignToBranchId;

	@Column(name="ASSIGN_TO_GROUP_ID")
	private long assignToGroupId;

	@Column(name="ASSIGN_TO_OFFICE_ID")
	private long assignToOfficeId;

	@Column(name="ASSIGN_TO_POST_ID")
	private long assignToPostId;

	@Column(name="ASSIGN_TO_POU_ID")
	private long assignToPouId;

	@Column(name="ASSIGN_TO_USER_ID")
	private long assignToUserId;

	@Column(name="ASSIGN_TO_WF_ROLE_ID")
	private long assignToWfRoleId;

	@Column(nullable=false)
	private short counter;

	@Column(name="\"LEVEL\"", nullable=false)
	private short level;

	@Column(name="REF_COL_OTHER", length=50)
	private String refColOther;

	@Column(name="REF_COL_SMALLINT", nullable=false)
	private short refColSmallint;

	@Column(name="REF_COL_VARCHAR", length=50)
	private String refColVarchar;

	@Column(length=500)
	private String remarks;

	@Column(name="SEND_BACK_FLAG", nullable=false)
	private short sendBackFlag;

	@Column(name="SUB_COUNTER", nullable=false)
	private short subCounter;

	@Column(name="TRN_STATUS", length=50)
	private String trnStatus;

	@Column(name="WF_ACTION_ID")
	private long wfActionId;

	@Column(name="WF_STATUS", length=50)
	private String wfStatus;

	@ManyToOne
	@JoinColumn(name="TRN_ID")
	private DoiRiClaimHdrEntity doiRiClaimHdrEntity;

	/**
	 * @return the riClaimWfId
	 */
	public long getRiClaimWfId() {
		return riClaimWfId;
	}

	/**
	 * @param riClaimWfId the riClaimWfId to set
	 */
	public void setRiClaimWfId(long riClaimWfId) {
		this.riClaimWfId = riClaimWfId;
	}

	/**
	 * @return the actionconfigId
	 */
	public long getActionconfigId() {
		return actionconfigId;
	}

	/**
	 * @param actionconfigId the actionconfigId to set
	 */
	public void setActionconfigId(long actionconfigId) {
		this.actionconfigId = actionconfigId;
	}

	/**
	 * @return the assignByBranchId
	 */
	public long getAssignByBranchId() {
		return assignByBranchId;
	}

	/**
	 * @param assignByBranchId the assignByBranchId to set
	 */
	public void setAssignByBranchId(long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	/**
	 * @return the assignByGroupId
	 */
	public long getAssignByGroupId() {
		return assignByGroupId;
	}

	/**
	 * @param assignByGroupId the assignByGroupId to set
	 */
	public void setAssignByGroupId(long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
	}

	/**
	 * @return the assignByOfficeId
	 */
	public long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * @return the assignByPostId
	 */
	public long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * @param assignByPostId the assignByPostId to set
	 */
	public void setAssignByPostId(long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * @return the assignByPouId
	 */
	public long getAssignByPouId() {
		return assignByPouId;
	}

	/**
	 * @param assignByPouId the assignByPouId to set
	 */
	public void setAssignByPouId(long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	/**
	 * @return the assignByUserId
	 */
	public long getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * @param assignByUserId the assignByUserId to set
	 */
	public void setAssignByUserId(long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * @return the assignByWfRoleId
	 */
	public long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * @return the assignToBranchId
	 */
	public long getAssignToBranchId() {
		return assignToBranchId;
	}

	/**
	 * @param assignToBranchId the assignToBranchId to set
	 */
	public void setAssignToBranchId(long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	/**
	 * @return the assignToGroupId
	 */
	public long getAssignToGroupId() {
		return assignToGroupId;
	}

	/**
	 * @param assignToGroupId the assignToGroupId to set
	 */
	public void setAssignToGroupId(long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
	}

	/**
	 * @return the assignToOfficeId
	 */
	public long getAssignToOfficeId() {
		return assignToOfficeId;
	}

	/**
	 * @param assignToOfficeId the assignToOfficeId to set
	 */
	public void setAssignToOfficeId(long assignToOfficeId) {
		this.assignToOfficeId = assignToOfficeId;
	}

	/**
	 * @return the assignToPostId
	 */
	public long getAssignToPostId() {
		return assignToPostId;
	}

	/**
	 * @param assignToPostId the assignToPostId to set
	 */
	public void setAssignToPostId(long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	/**
	 * @return the assignToPouId
	 */
	public long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * @param assignToPouId the assignToPouId to set
	 */
	public void setAssignToPouId(long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * @return the assignToUserId
	 */
	public long getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * @param assignToUserId the assignToUserId to set
	 */
	public void setAssignToUserId(long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * @return the assignToWfRoleId
	 */
	public long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * @return the counter
	 */
	public short getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(short counter) {
		this.counter = counter;
	}

	/**
	 * @return the level
	 */
	public short getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(short level) {
		this.level = level;
	}

	/**
	 * @return the refColOther
	 */
	public String getRefColOther() {
		return refColOther;
	}

	/**
	 * @param refColOther the refColOther to set
	 */
	public void setRefColOther(String refColOther) {
		this.refColOther = refColOther;
	}

	/**
	 * @return the refColSmallint
	 */
	public short getRefColSmallint() {
		return refColSmallint;
	}

	/**
	 * @param refColSmallint the refColSmallint to set
	 */
	public void setRefColSmallint(short refColSmallint) {
		this.refColSmallint = refColSmallint;
	}

	/**
	 * @return the refColVarchar
	 */
	public String getRefColVarchar() {
		return refColVarchar;
	}

	/**
	 * @param refColVarchar the refColVarchar to set
	 */
	public void setRefColVarchar(String refColVarchar) {
		this.refColVarchar = refColVarchar;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the sendBackFlag
	 */
	public short getSendBackFlag() {
		return sendBackFlag;
	}

	/**
	 * @param sendBackFlag the sendBackFlag to set
	 */
	public void setSendBackFlag(short sendBackFlag) {
		this.sendBackFlag = sendBackFlag;
	}

	/**
	 * @return the subCounter
	 */
	public short getSubCounter() {
		return subCounter;
	}

	/**
	 * @param subCounter the subCounter to set
	 */
	public void setSubCounter(short subCounter) {
		this.subCounter = subCounter;
	}

	/**
	 * @return the trnStatus
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * @param trnStatus the trnStatus to set
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * @return the wfActionId
	 */
	public long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the wfStatus
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * @param wfStatus the wfStatus to set
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * @return the doiRiClaimHdrEntity
	 */
	public DoiRiClaimHdrEntity getDoiRiClaimHdrEntity() {
		return doiRiClaimHdrEntity;
	}

	/**
	 * @param doiRiClaimHdrEntity the doiRiClaimHdrEntity to set
	 */
	public void setDoiRiClaimHdrEntity(DoiRiClaimHdrEntity doiRiClaimHdrEntity) {
		this.doiRiClaimHdrEntity = doiRiClaimHdrEntity;
	}	
}