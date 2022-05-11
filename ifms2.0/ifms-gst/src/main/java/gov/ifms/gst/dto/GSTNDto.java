package gov.ifms.gst.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class GSTNDto {
	@JsonProperty("rec_cnt")
	private int recCnt;

	@JsonProperty("file_cnt")
	private int fileCnt;

	@JsonProperty("cgst_amt")
	private Double cgstAmt;

	@JsonProperty("sgst_amt")
	private Double sgstAmt;

	@JsonProperty("igst_amt")
	private Double igstAmt;

	@JsonProperty("cessAmt")
	private Double cessAmt;

	@JsonProperty("total_amt")
	private Double totalAmt;

	@JsonProperty("file_dt")
	private Date fileDt;

	@JsonProperty("state_cd")
	private long stateCd;

	@JsonProperty("fileType")
	private String fileType;
	
	@JsonProperty("fileName")
	private String fileName;
	
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getRecCnt(int i) {
		return recCnt;
	}

	public void setRecCnt(int recCnt) {
		this.recCnt = recCnt;
	}

	public int getFileCnt() {
		return fileCnt;
	}

	public void setFileCnt(int fileCnt) {
		this.fileCnt = fileCnt;
	}

	public Double getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(Double cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public Double getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(Double sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public Double getIgstAmt() {
		return igstAmt;
	}

	public void setIgstAmt(Double igstAmt) {
		this.igstAmt = igstAmt;
	}

	public Double getCessAmt() {
		return cessAmt;
	}

	public void setCessAmt(Double cessAmt) {
		this.cessAmt = cessAmt;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getFileDt() {
		return fileDt;
	}

	public void setFileDt(Date fileDt) {
		this.fileDt = fileDt;
	}

	public long getStateCd() {
		return stateCd;
	}

	public void setStateCd(long stateCd) {
		this.stateCd = stateCd;
	}

	public int getRecCnt() {
		return recCnt;
	}

}
