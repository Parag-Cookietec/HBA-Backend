package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ScrollDistributeDto {

	private long id;
	private long fileProcessId;
	private String scrollNo;
	private LocalDateTime scrollDt;
	private short noOfChallans;
	private Date challanDt;
	private String branchName;
	private Double totChallanAmt = 0.00;
	private String distributeStatus;
	private LocalDateTime distributionDt;
	private long distributedTo;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private Date fromDate;
	private Date toDate;
	private Long branchId;
	private Long haId;
	private Long fileHdrId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(long fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public LocalDateTime getScrollDt() {
		return scrollDt;
	}

	public void setScrollDt(LocalDateTime scrollDt) {
		this.scrollDt = scrollDt;
	}

	public short getNoOfChallans() {
		return noOfChallans;
	}

	public void setNoOfChallans(short noOfChallans) {
		this.noOfChallans = noOfChallans;
	}

	public Date getChallanDt() {
		return challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public String getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}

	public LocalDateTime getDistributionDt() {
		return distributionDt;
	}

	public void setDistributionDt(LocalDateTime distributionDt) {
		this.distributionDt = distributionDt;
	}

	public long getDistributedTo() {
		return distributedTo;
	}

	public void setDistributedTo(long distributedTo) {
		this.distributedTo = distributedTo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime localDateTime) {
		this.referenceDt = localDateTime;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public Long getHaId() {
		return haId;
	}

	public void setHaId(Long haId) {
		this.haId = haId;
	}

	public Long getFileHdrId() {
		return fileHdrId;
	}

	public void setFileHdrId(Long fileHdrId) {
		this.fileHdrId = fileHdrId;
	}

}
