package gov.ifms.gst.dto;

import gov.ifms.gst.entity.RecordType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class GSTCPINStatusDto implements Serializable {

	private long id;
	private String fileNumber;
	private Date fileDt;
	private RecordType recordType;
	private String cinNo;
	private long cpinNo;
	private Double cpinAmount;
	private Date govtCreditDt;
	private long fileStatusId;
	private String fileStatus;
	private String signedData;
	private long transStatusId;
	private String transStatus;
	private String refrenceNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public Date getFileDt() {
		return fileDt;
	}

	public void setFileDt(Date fileDt) {
		this.fileDt = fileDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public Double getCpinAmount() {
		return cpinAmount;
	}

	public void setCpinAmount(Double cpinAmount) {
		this.cpinAmount = cpinAmount;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public Long getFileStatusId() {
		return fileStatusId;
	}

	public void setFileStatusId(Long fileStatusId) {
		this.fileStatusId = fileStatusId;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getSignedData() {
		return signedData;
	}

	public void setSignedData(String signedData) {
		this.signedData = signedData;
	}

	public Long getTransStatusId() {
		return transStatusId;
	}

	public void setTransStatusId(Long transStatusId) {
		this.transStatusId = transStatusId;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public LocalDateTime getRefrenceDt() {
		return refrenceDt;
	}

	public void setRefrenceDt(LocalDateTime refrenceDt) {
		this.refrenceDt = refrenceDt;
	}

	private LocalDateTime refrenceDt;
}
