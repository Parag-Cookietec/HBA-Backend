package gov.ifms.gst.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class GSTBlkEODCPINFileDataDto implements Serializable {

	private Long id;
	private Long fileHdrId;
	private short stateCd;
	private char fileTypeCd;
	private char paymentModeCd;
	private char IsGstinTmpid;
	private String gstinTmpidNo;
	private LocalDate cpinDt;
	private LocalDate cpinDtTime;
	private Long cpinNo;
	private String cinNo;
	private String blockedBy;
	private LocalDate blockedDt;
	private LocalDate blockedDtTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFileHdrId() {
		return fileHdrId;
	}
	public void setFileHdrId(Long fileHdrId) {
		this.fileHdrId = fileHdrId;
	}
	public short getStateCd() {
		return stateCd;
	}
	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}
	public char getFileTypeCd() {
		return fileTypeCd;
	}
	public void setFileTypeCd(char fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}
	public char getPaymentModeCd() {
		return paymentModeCd;
	}
	public void setPaymentModeCd(char paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}
	public char getIsGstinTmpid() {
		return IsGstinTmpid;
	}
	public void setIsGstinTmpid(char isGstinTmpid) {
		IsGstinTmpid = isGstinTmpid;
	}
	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}
	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}
	public LocalDate getCpinDt() {
		return cpinDt;
	}
	public void setCpinDt(LocalDate cpinDt) {
		this.cpinDt = cpinDt;
	}
	public LocalDate getCpinDtTime() {
		return cpinDtTime;
	}
	public void setCpinDtTime(LocalDate cpinDtTime) {
		this.cpinDtTime = cpinDtTime;
	}
	public Long getCpinNo() {
		return cpinNo;
	}
	public void setCpinNo(Long cpinNo) {
		this.cpinNo = cpinNo;
	}
	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public String getBlockedBy() {
		return blockedBy;
	}
	public void setBlockedBy(String blockedBy) {
		this.blockedBy = blockedBy;
	}
	public LocalDate getBlockedDt() {
		return blockedDt;
	}
	public void setBlockedDt(LocalDate blockedDt) {
		this.blockedDt = blockedDt;
	}
	public LocalDate getBlockedDtTime() {
		return blockedDtTime;
	}
	public void setBlockedDtTime(LocalDate blockedDtTime) {
		this.blockedDtTime = blockedDtTime;
	}

}
