package gov.ifms.gst.dto;

import java.util.Date;

public class RBIAccStmtTranxnDto {

	private long id;
	private long rbiAccStmtId;
	private String ntryRefId;
	private Double ccyInrAmt;
	private String crtDbtType;
	private String rvslIndType;
	private String statusType;
	private Date bookingDt;
	private Date valueDt;
	private String bookTxCd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiAccStmtId() {
		return rbiAccStmtId;
	}

	public void setRbiAccStmtId(long rbiAccStmtId) {
		this.rbiAccStmtId = rbiAccStmtId;
	}

	public String getNtryRefId() {
		return ntryRefId;
	}

	public void setNtryRefId(String ntryRefId) {
		this.ntryRefId = ntryRefId;
	}

	public Double getCcyInrAmt() {
		return ccyInrAmt;
	}

	public void setCcyInrAmt(Double ccyInrAmt) {
		this.ccyInrAmt = ccyInrAmt;
	}

	public String getCrtDbtType() {
		return crtDbtType;
	}

	public void setCrtDbtType(String crtDbtType) {
		this.crtDbtType = crtDbtType;
	}

	public String getRvslIndType() {
		return rvslIndType;
	}

	public void setRvslIndType(String rvslIndType) {
		this.rvslIndType = rvslIndType;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Date getBookingDt() {
		return bookingDt;
	}

	public void setBookingDt(Date bookingDt) {
		this.bookingDt = bookingDt;
	}

	public Date getValueDt() {
		return valueDt;
	}

	public void setValueDt(Date valueDt) {
		this.valueDt = valueDt;
	}

	public String getBookTxCd() {
		return bookTxCd;
	}

	public void setBookTxCd(String bookTxCd) {
		this.bookTxCd = bookTxCd;
	}

}
