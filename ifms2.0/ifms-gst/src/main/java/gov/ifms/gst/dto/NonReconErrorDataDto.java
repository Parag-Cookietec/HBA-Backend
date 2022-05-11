package gov.ifms.gst.dto;

import java.util.Date;

public class NonReconErrorDataDto {

	private long id;
	private long paoFileHdrId;
	private short stateCd;
	private Date nerReconDt;
	private Date othrModeReconDt;
	private String reconTypeCd;
	private String errorCd;
	private long cpinNo;
	private long eScrollNum;

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

	public String getErrorCd() {
		return errorCd;
	}

	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public long geteScrollNum() {
		return eScrollNum;
	}

	public void seteScrollNum(long eScrollNum) {
		this.eScrollNum = eScrollNum;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
