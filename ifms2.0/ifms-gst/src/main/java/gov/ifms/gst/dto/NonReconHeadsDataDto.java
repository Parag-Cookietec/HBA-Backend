package gov.ifms.gst.dto;

import java.util.Date;

public class NonReconHeadsDataDto {

	private long id;
	private long paoFileHdrId;
	private short stateCd;
	private Date nerReconDt;
	private Date othrModeReconDt;
	private String reconTypeCd;
	private String paymentModeCd;
	private String isGstinTmpid;
	private String gstinTmpidNo;
	private long cpinNo;
	private String cinNo;
	private long eScrollNum;
	private Double rbiCgstTotal;
	private Double rbiIgstTotal;
	private Double rbiSgstTotal;
	private Double rbiCessTotal;
	private Double gstCgstTotal;
	private Double gstIgstTotal;
	private Double gstSgstTotal;
	private Double gstCessTotal;

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

	public String getReconTypeCd() {
		return reconTypeCd;
	}

	public void setReconTypeCd(String reconTypeCd) {
		this.reconTypeCd = reconTypeCd;
	}

	public String getPaymentModeCd() {
		return paymentModeCd;
	}

	public void setPaymentModeCd(String paymentModeCd) {
		this.paymentModeCd = paymentModeCd;
	}

	public String getIsGstinTmpid() {
		return isGstinTmpid;
	}

	public void setIsGstinTmpid(String isGstinTmpid) {
		this.isGstinTmpid = isGstinTmpid;
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

	public Double getRbiCgstTotal() {
		return rbiCgstTotal;
	}

	public void setRbiCgstTotal(Double rbiCgstTotal) {
		this.rbiCgstTotal = rbiCgstTotal;
	}

	public Double getRbiIgstTotal() {
		return rbiIgstTotal;
	}

	public void setRbiIgstTotal(Double rbiIgstTotal) {
		this.rbiIgstTotal = rbiIgstTotal;
	}

	public Double getRbiSgstTotal() {
		return rbiSgstTotal;
	}

	public void setRbiSgstTotal(Double rbiSgstTotal) {
		this.rbiSgstTotal = rbiSgstTotal;
	}

	public Double getRbiCessTotal() {
		return rbiCessTotal;
	}

	public void setRbiCessTotal(Double rbiCessTotal) {
		this.rbiCessTotal = rbiCessTotal;
	}

	public Double getGstCgstTotal() {
		return gstCgstTotal;
	}

	public void setGstCgstTotal(Double gstCgstTotal) {
		this.gstCgstTotal = gstCgstTotal;
	}

	public Double getGstIgstTotal() {
		return gstIgstTotal;
	}

	public void setGstIgstTotal(Double gstIgstTotal) {
		this.gstIgstTotal = gstIgstTotal;
	}

	public Double getGstSgstTotal() {
		return gstSgstTotal;
	}

	public void setGstSgstTotal(Double gstSgstTotal) {
		this.gstSgstTotal = gstSgstTotal;
	}

	public Double getGstCessTotal() {
		return gstCessTotal;
	}

	public void setGstCessTotal(Double gstCessTotal) {
		this.gstCessTotal = gstCessTotal;
	}

}
