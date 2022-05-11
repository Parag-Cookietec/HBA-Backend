package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ChallanDistributionSADADto {

	private long id;
	private long fileProcessId;
	private LocalDateTime distributeDt;
	private String bankCd;
	private String bankName;
	private short totalChallans;
	private short availableChallans;
	private Short toBeDitributed =0;
	private String distributeStatus;
	private short totalDitributed;
	private String saDaName;
	private Double totChallanAmt;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private LocalDateTime fromDate;
	private LocalDateTime toDate;
	private String accountant;
	private Long saDaId;
	private Long bankId;
	private Date date;
	private Long haId;

	public String getAccountant() {
		return accountant;
	}

	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}

	private List<String> branchId;

	public List<String> getBranchId() {
		return branchId;
	}

	public void setBranchId(List<String> branchId) {
		this.branchId = branchId;
	}

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	public String getBankCd() {
		return bankCd;
	}

	public Short getToBeDitributed() {
		return toBeDitributed;
	}

	public String getDistributeStatus() {
		return distributeStatus;
	}

	public short getTotalDitributed() {
		return totalDitributed;
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

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public void setToBeDitributed(Short toBeDitributed) {
		this.toBeDitributed = toBeDitributed;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}

	public void setTotalDitributed(short totalDitributed) {
		this.totalDitributed = totalDitributed;
	}

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

	public LocalDateTime getDistributeDt() {
		return distributeDt;
	}

	public void setDistributeDt(LocalDateTime distributeDt) {
		this.distributeDt = distributeDt;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public short getTotalChallans() {
		return totalChallans;
	}

	public void setTotalChallans(short totalChallans) {
		this.totalChallans = totalChallans;
	}

	public short getAvailableChallans() {
		return availableChallans;
	}

	public void setAvailableChallans(short availableChallans) {
		this.availableChallans = availableChallans;
	}

	public String getSaDaName() {
		return saDaName;
	}

	public void setSaDaName(String saDaName) {
		this.saDaName = saDaName;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public Long getSaDaId() {
		return saDaId;
	}

	public void setSaDaId(Long saDaId) {
		this.saDaId = saDaId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getHaId() {
		return haId;
	}

	public void setHaId(Long haId) {
		this.haId = haId;
	}
	
}
