package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.gst.entity.GSTFileProcess;

import java.io.Serializable;

@NativeQueryResultEntity
public class FileAccountProcessedLstResDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The referenceNumber. */
	@NativeQueryResultColumn(index = 1)
	private String referenceNo;

	@NativeQueryResultColumn(index = 2)
	private String referenceDt;

	@NativeQueryResultColumn(index = 3)
	private String challanDt;

	@NativeQueryResultColumn(index = 4)
	private String voucherNo;

	@NativeQueryResultColumn(index = 5)
	private Long noOfChallans;

	@NativeQueryResultColumn(index = 6)
	private Double totChallanAmt;

	@NativeQueryResultColumn(index = 7)
	private Long fileProcessId;

	@NativeQueryResultColumn(index = 8)
	private String fileName;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 9)
	private String trnStatus;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 10)
	private String wfStatus;

	@NativeQueryResultColumn(index = 11)
	private int isEditable;

	@NativeQueryResultColumn(index = 12)
	private int totalRecords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(String referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getChallanDt() {
		return challanDt;
	}

	public void setChallanDt(String challanDt) {
		this.challanDt = challanDt;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Long getNoOfChallans() {
		return noOfChallans;
	}

	public void setNoOfChallans(Long noOfChallans) {
		this.noOfChallans = noOfChallans;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public int getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Long getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(Long fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}


