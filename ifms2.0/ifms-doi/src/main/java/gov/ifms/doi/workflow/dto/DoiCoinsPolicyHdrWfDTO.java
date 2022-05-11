package gov.ifms.doi.workflow.dto;

import gov.ifms.doi.coinsurance.dto.DoiCoinsPolicyHdrDTO;
import gov.ifms.doi.jpa.dto.BaseDto;


/**
 * @author Rudra
 *
 */

public class DoiCoinsPolicyHdrWfDTO extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -90898971693747316L;

	private long coinsPolicyWfId;
	
	private long coinsPolicyHdrId;

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

	private DoiCoinsPolicyHdrDTO doiCoinsPolicyHdr;

	/**
	 * @return the coinsPolicyWfId
	 */
	public long getCoinsPolicyWfId() {
		return coinsPolicyWfId;
	}

	/**
	 * @param coinsPolicyWfId the coinsPolicyWfId to set
	 */
	public void setCoinsPolicyWfId(long coinsPolicyWfId) {
		this.coinsPolicyWfId = coinsPolicyWfId;
	}

	/**
	 * @return the coinsPolicyHdrId
	 */
	public long getCoinsPolicyHdrId() {
		return coinsPolicyHdrId;
	}

	/**
	 * @param coinsPolicyHdrId the coinsPolicyHdrId to set
	 */
	public void setCoinsPolicyHdrId(long coinsPolicyHdrId) {
		this.coinsPolicyHdrId = coinsPolicyHdrId;
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
	 * @return the doiCoinsPolicyHdr
	 */
	public DoiCoinsPolicyHdrDTO getDoiCoinsPolicyHdr() {
		return doiCoinsPolicyHdr;
	}

	/**
	 * @param doiCoinsPolicyHdr the doiCoinsPolicyHdr to set
	 */
	public void setDoiCoinsPolicyHdr(DoiCoinsPolicyHdrDTO doiCoinsPolicyHdr) {
		this.doiCoinsPolicyHdr = doiCoinsPolicyHdr;
	}

}