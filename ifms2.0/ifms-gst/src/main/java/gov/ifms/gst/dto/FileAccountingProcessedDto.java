package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;

import gov.ifms.gst.entity.GSTFileProcess;

public class FileAccountingProcessedDto {
	private static final long serialVersionUID = 1L;
	public static final String TRN_SCREEN_BMS = "GFP";
	private long id;
	private GSTFileProcess fileProcessId;
	private String referenceNo;
	private Date referenceDt;
	private short noOfChallans;
	private Date challanDt;
	private String voucherNo;
	private Double totChallanAmt;
	private String fileAccountsStatus;
	private LocalDateTime accountingDt;
	private long accountDoneBy;
	private Date fromDate;
	private Date toDate;
	private String fileName;
	private Long menuId;
	private String message;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public GSTFileProcess getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(GSTFileProcess fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
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

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public String getFileAccountsStatus() {
		return fileAccountsStatus;
	}

	public void setFileAccountsStatus(String fileAccountsStatus) {
		this.fileAccountsStatus = fileAccountsStatus;
	}

	public LocalDateTime getAccountingDt() {
		return accountingDt;
	}

	public void setAccountingDt(LocalDateTime accountingDt) {
		this.accountingDt = accountingDt;
	}

	public long getAccountDoneBy() {
		return accountDoneBy;
	}

	public void setAccountDoneBy(long accountDoneBy) {
		this.accountDoneBy = accountDoneBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getTrnScreenBms() {
		return TRN_SCREEN_BMS;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
