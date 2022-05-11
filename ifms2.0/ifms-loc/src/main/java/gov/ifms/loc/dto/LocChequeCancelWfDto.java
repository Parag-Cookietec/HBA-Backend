package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChequeCancelWfDto.
 * 
 * @version v 1.0
 * @created 2021/03/05 18:24:32
 *
 */
public class LocChequeCancelWfDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Id. */
	private Long Id;

	/** The trn id. */
	private Long trnId;

	/** The actionconfig id. */
	private Long actionconfigId;

	/** The wf action id. */
	private Long wfActionId;

	/** The assign to wf role id. */
	private Long assignToWfRoleId;

	/** The assign to user id. */
	private Long assignToUserId;

	/** The assign to post id. */
	private Long assignToPostId;

	/** The assign to pou id. */
	private Long assignToPouId;

	/** The assign tooffice id. */
	private Long assignToofficeId;

	/** The assign to branch id. */
	private Long assignToBranchId;

	/** The assign to group id. */
	private Long assignToGroupId;

	/** The wf status. */
	private String wfStatus;

	/** The trn status. */
	private String trnStatus;

	/** The assign by wf role id. */
	private Long assignByWfRoleId;

	/** The assign by user id. */
	private Long assignByUserId;

	/** The assign by post id. */
	private Long assignByPostId;

	/** The assign by pou id. */
	private Long assignByPouId;

	/** The assign by office id. */
	private Long assignByOfficeId;

	/** The assign by branch id. */
	private Long assignByBranchId;

	/** The assign by group id. */
	private Long assignByGroupId;

	/** The remarks. */
	private String remarks;

	/** The send back flag. */
	private int sendBackFlag;

	/** The counter. */
	private int counter;

	/** The sub counter. */
	private int subCounter;

	/** The level. */
	private int level;

	/** The ref col smallint. */
	private int refColSmallint;

	/** The ref col varchar. */
	private String refColVarchar;

	/** The ref col other. */
	private String refColOther;

	/**
	 * LocChequeCancelWfDto Constructor.
	 */
	public LocChequeCancelWfDto() {
		super();
	}

	/**
	 * @return the Id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param Id the Id to set
	 */
	public void setId(Long Id) {
		this.Id = Id;
	}

	/**
	 * @return the trnId
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	/**
	 * @return the actionconfigId
	 */
	public Long getActionconfigId() {
		return actionconfigId;
	}

	/**
	 * @param actionconfigId the actionconfigId to set
	 */
	public void setActionconfigId(Long actionconfigId) {
		this.actionconfigId = actionconfigId;
	}

	/**
	 * @return the wfActionId
	 */
	public Long getWfActionId() {
		return wfActionId;
	}

	/**
	 * @param wfActionId the wfActionId to set
	 */
	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	/**
	 * @return the assignToWfRoleId
	 */
	public Long getAssignToWfRoleId() {
		return assignToWfRoleId;
	}

	/**
	 * @param assignToWfRoleId the assignToWfRoleId to set
	 */
	public void setAssignToWfRoleId(Long assignToWfRoleId) {
		this.assignToWfRoleId = assignToWfRoleId;
	}

	/**
	 * @return the assignToUserId
	 */
	public Long getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * @param assignToUserId the assignToUserId to set
	 */
	public void setAssignToUserId(Long assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * @return the assignToPostId
	 */
	public Long getAssignToPostId() {
		return assignToPostId;
	}

	/**
	 * @param assignToPostId the assignToPostId to set
	 */
	public void setAssignToPostId(Long assignToPostId) {
		this.assignToPostId = assignToPostId;
	}

	/**
	 * @return the assignToPouId
	 */
	public Long getAssignToPouId() {
		return assignToPouId;
	}

	/**
	 * @param assignToPouId the assignToPouId to set
	 */
	public void setAssignToPouId(Long assignToPouId) {
		this.assignToPouId = assignToPouId;
	}

	/**
	 * @return the assignToofficeId
	 */
	public Long getAssignToofficeId() {
		return assignToofficeId;
	}

	/**
	 * @param assignToofficeId the assignToofficeId to set
	 */
	public void setAssignToofficeId(Long assignToofficeId) {
		this.assignToofficeId = assignToofficeId;
	}

	/**
	 * @return the assignToBranchId
	 */
	public Long getAssignToBranchId() {
		return assignToBranchId;
	}

	/**
	 * @param assignToBranchId the assignToBranchId to set
	 */
	public void setAssignToBranchId(Long assignToBranchId) {
		this.assignToBranchId = assignToBranchId;
	}

	/**
	 * @return the assignToGroupId
	 */
	public Long getAssignToGroupId() {
		return assignToGroupId;
	}

	/**
	 * @param assignToGroupId the assignToGroupId to set
	 */
	public void setAssignToGroupId(Long assignToGroupId) {
		this.assignToGroupId = assignToGroupId;
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
	 * @return the assignByWfRoleId
	 */
	public Long getAssignByWfRoleId() {
		return assignByWfRoleId;
	}

	/**
	 * @param assignByWfRoleId the assignByWfRoleId to set
	 */
	public void setAssignByWfRoleId(Long assignByWfRoleId) {
		this.assignByWfRoleId = assignByWfRoleId;
	}

	/**
	 * @return the assignByUserId
	 */
	public Long getAssignByUserId() {
		return assignByUserId;
	}

	/**
	 * @param assignByUserId the assignByUserId to set
	 */
	public void setAssignByUserId(Long assignByUserId) {
		this.assignByUserId = assignByUserId;
	}

	/**
	 * @return the assignByPostId
	 */
	public Long getAssignByPostId() {
		return assignByPostId;
	}

	/**
	 * @param assignByPostId the assignByPostId to set
	 */
	public void setAssignByPostId(Long assignByPostId) {
		this.assignByPostId = assignByPostId;
	}

	/**
	 * @return the assignByPouId
	 */
	public Long getAssignByPouId() {
		return assignByPouId;
	}

	/**
	 * @param assignByPouId the assignByPouId to set
	 */
	public void setAssignByPouId(Long assignByPouId) {
		this.assignByPouId = assignByPouId;
	}

	/**
	 * @return the assignByOfficeId
	 */
	public Long getAssignByOfficeId() {
		return assignByOfficeId;
	}

	/**
	 * @param assignByOfficeId the assignByOfficeId to set
	 */
	public void setAssignByOfficeId(Long assignByOfficeId) {
		this.assignByOfficeId = assignByOfficeId;
	}

	/**
	 * @return the assignByBranchId
	 */
	public Long getAssignByBranchId() {
		return assignByBranchId;
	}

	/**
	 * @param assignByBranchId the assignByBranchId to set
	 */
	public void setAssignByBranchId(Long assignByBranchId) {
		this.assignByBranchId = assignByBranchId;
	}

	/**
	 * @return the assignByGroupId
	 */
	public Long getAssignByGroupId() {
		return assignByGroupId;
	}

	/**
	 * @param assignByGroupId the assignByGroupId to set
	 */
	public void setAssignByGroupId(Long assignByGroupId) {
		this.assignByGroupId = assignByGroupId;
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
	public int getSendBackFlag() {
		return sendBackFlag;
	}

	/**
	 * @param sendBackFlag the sendBackFlag to set
	 */
	public void setSendBackFlag(int sendBackFlag) {
		this.sendBackFlag = sendBackFlag;
	}

	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * @return the subCounter
	 */
	public int getSubCounter() {
		return subCounter;
	}

	/**
	 * @param subCounter the subCounter to set
	 */
	public void setSubCounter(int subCounter) {
		this.subCounter = subCounter;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the refColSmallint
	 */
	public int getRefColSmallint() {
		return refColSmallint;
	}

	/**
	 * @param refColSmallint the refColSmallint to set
	 */
	public void setRefColSmallint(int refColSmallint) {
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

}
