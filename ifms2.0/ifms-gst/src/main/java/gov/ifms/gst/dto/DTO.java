package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.Date;

public class DTO implements Serializable{
	private long cpinNo;
	private Date cpinDtTime;
	private String cinNo;
	private Date cinDtTime;
	private String bankCd;
	private long bankRefNum;
	private String instrumentType;
	private String paymentModeCd;
	private String fileName;
	private Double totalAmt;
	private String status;
	private Double cpinAmount;
	private short stateCd;
	private String fileTypeCd;
	private String gstinTmpidNo;
	private long ackNum;
	private Date fileDate;
	private Date govtCreditDt;
	private Double tax;
	private Double fee;
	private Double penalty;
	private Double interest;
	private String partyName;
	
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Double getPenalty() {
		return penalty;
	}
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public long getCpinNo() {
		return cpinNo;
	}
	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}
	public Date getCpinDtTime() {
		return cpinDtTime;
	}
	public void setCpinDtTime(Date cpinDtTime) {
		this.cpinDtTime = cpinDtTime;
	}
	public String getCinNo() {
		return cinNo;
	}
	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}
	public Date getCinDtTime() {
		return cinDtTime;
	}
	public void setCinDtTime(Date cinDtTime) {
		this.cinDtTime = cinDtTime;
	}
	public String getBankCd() {
		return bankCd;
	}
	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}
	public long getBankRefNum() {
		return bankRefNum;
	}
	public void setBankRefNum(long bankRefNum) {
		this.bankRefNum = bankRefNum;
	}
	public String getInstrumentType() {
		return instrumentType;
	}
	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}
	public String getPaymentModeCd() {
		return paymentModeCd;
	}
	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getCpinAmount() {
		return cpinAmount;
	}
	public void setCpinAmount(Double cpinAmount) {
		this.cpinAmount = cpinAmount;
	}
	public short getStateCd() {
		return stateCd;
	}
	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}
	public String getFileTypeCd() {
		return fileTypeCd;
	}
	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}
	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}
	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}
	public long getAckNum() {
		return ackNum;
	}
	public void setAckNum(long ackNum) {
		this.ackNum = ackNum;
	}
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	public Date getGovtCreditDt() {
		return govtCreditDt;
	}
	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

}
