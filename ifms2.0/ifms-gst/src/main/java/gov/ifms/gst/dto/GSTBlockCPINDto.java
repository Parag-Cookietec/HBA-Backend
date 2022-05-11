package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class GSTBlockCPINDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String fileName;
	private Date cpinDt;
	private String cinNo;
	private Long cpinNo;
	private Double cpinAmount;
	private Date govtCreditDt;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private long recStatusId;
	private String recStatus;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCpinDt() {
		return cpinDt;
	}

	public void setCpinDt(Date cpinDt) {
		this.cpinDt = cpinDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public Long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(Long cpinNo) {
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

	public long getRecStatusId() {
		return recStatusId;
	}

	public void setRecStatusId(long recStatusId) {
		this.recStatusId = recStatusId;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}
}
