package gov.ifms.doi.db.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_CLAIM_RI_DTL database table.
 * 
 */

public class TdoiDbClaimRiDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long claimRiDtlId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date challanDt;

	private String challanNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date paymentRecvOn;

	private String paymentRecvThru;

	private String paymentRespTo;

	private String riCompAddress;

	private String riCompName;

	private double riPremAmount;

	private double riSharePerc;

	// bi-directional many-to-one association to TdoiDbClaimEntry

	private TdoiDbClaimEntryDTO tdoiDbClaimEntry;

	public TdoiDbClaimRiDtlDTO() {
	}

	public long getClaimRiDtlId() {
		return this.claimRiDtlId;
	}

	public void setClaimRiDtlId(long claimRiDtlId) {
		this.claimRiDtlId = claimRiDtlId;
	}

	public Date getChallanDt() {
		return this.challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getChallanNo() {
		return this.challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getPaymentRecvOn() {
		return this.paymentRecvOn;
	}

	public void setPaymentRecvOn(Date paymentRecvOn) {
		this.paymentRecvOn = paymentRecvOn;
	}

	public String getPaymentRecvThru() {
		return this.paymentRecvThru;
	}

	public void setPaymentRecvThru(String paymentRecvThru) {
		this.paymentRecvThru = paymentRecvThru;
	}

	public String getPaymentRespTo() {
		return this.paymentRespTo;
	}

	public void setPaymentRespTo(String paymentRespTo) {
		this.paymentRespTo = paymentRespTo;
	}

	public String getRiCompAddress() {
		return this.riCompAddress;
	}

	public void setRiCompAddress(String riCompAddress) {
		this.riCompAddress = riCompAddress;
	}

	public String getRiCompName() {
		return this.riCompName;
	}

	public void setRiCompName(String riCompName) {
		this.riCompName = riCompName;
	}

	public double getRiPremAmount() {
		return this.riPremAmount;
	}

	public void setRiPremAmount(double riPremAmount) {
		this.riPremAmount = riPremAmount;
	}

	public double getRiSharePerc() {
		return this.riSharePerc;
	}

	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	public TdoiDbClaimEntryDTO getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryDTO tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}
