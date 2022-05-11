package gov.ifms.gst.dto;

import java.util.Date;

public class ReconFileDataDto {

	private long id;
	private long paoFileHdrId;
	private short stateCd;
	private char paymentModeCd;
	private char isGstinTmpid;
	private char reconTypeCd;
	private String gstinTmpidNo;
	private long cpinNo;
	private String cinNo;
	private long eScrollNum;
	private Date nerReconDt;
	private Date othrModeReconDt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPaoFileHdrId() {
		return paoFileHdrId;
	}

	public void setPaoFileHdrId(long paoFileHdrId) {
		this.paoFileHdrId = paoFileHdrId;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public char getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(char paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public char getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(char isGstinTmpid) {
		this.isGstinTmpid = isGstinTmpid;
	}

	public char getReconTypeCd() {
		return reconTypeCd;
	}

	public void setReconTypeCd(char reconTypeCd) {
		this.reconTypeCd = reconTypeCd;
	}

	public String getGstinTmpidNo() {
		return gstinTmpidNo;
	}

	public void setGstinTmpidNo(String gstinTmpidNo) {
		this.gstinTmpidNo = gstinTmpidNo;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long geteScrollNum() {
		return eScrollNum;
	}

	public void seteScrollNum(long eScrollNum) {
		this.eScrollNum = eScrollNum;
	}

	public Date getNerReconDt() {
		return nerReconDt;
	}

	public void setNerReconDt(Date nerReconDt) {
		this.nerReconDt = nerReconDt;
	}

	public Date getOthrModeReconDt() {
		return othrModeReconDt;
	}

	public void setOthrModeReconDt(Date othrModeReconDt) {
		this.othrModeReconDt = othrModeReconDt;
	}

}
