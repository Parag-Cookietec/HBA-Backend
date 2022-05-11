package gov.ifms.dmo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetWMAPostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long wmaAdvanceId;
	private Long dpSheetDtlId;
	private Long wmaTypeId;
	private Double wmaLimitAmt = 0.00;
	private Double wmaOutstandAmt;
	private Double wmaAdvanceAmt;
	private Double totWmaOsAmt;
	private int wmaDays;
	private Double interestRate;
	private Double interestPayable;
	private Double interestPaid;
	private Double wmaPcUtilized;

	private Long wmaInterestId;
	private Double wmaRepayAmt = 0.00;
	private Double wmaIntrstPaymnt;

	private Long wmaPrincipalId;

	public Long getWmaInterestId() {
		return wmaInterestId;
	}

	public void setWmaInterestId(Long wmaInterestId) {
		this.wmaInterestId = wmaInterestId;
	}

	public Double getWmaRepayAmt() {
		return wmaRepayAmt;
	}

	public void setWmaRepayAmt(Double wmaRepayAmt) {
		this.wmaRepayAmt = wmaRepayAmt;
	}

	public Double getWmaIntrstPaymnt() {
		return wmaIntrstPaymnt;
	}

	public void setWmaIntrstPaymnt(Double wmaIntrstPaymnt) {
		this.wmaIntrstPaymnt = wmaIntrstPaymnt;
	}

	public Long getWmaPrincipalId() {
		return wmaPrincipalId;
	}

	public void setWmaPrincipalId(Long wmaPrincipalId) {
		this.wmaPrincipalId = wmaPrincipalId;
	}

	public Long getWmaAdvanceId() {
		return wmaAdvanceId;
	}

	public void setWmaAdvanceId(Long wmaAdvanceId) {
		this.wmaAdvanceId = wmaAdvanceId;
	}

	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long dpSheetDtlId) {
		this.dpSheetDtlId = dpSheetDtlId;
	}

	public Long getWmaTypeId() {
		return wmaTypeId;
	}

	public void setWmaTypeId(Long wmaTypeId) {
		this.wmaTypeId = wmaTypeId;
	}

	public Double getWmaLimitAmt() {
		return wmaLimitAmt;
	}

	public void setWmaLimitAmt(Double wmaLimitAmt) {
		this.wmaLimitAmt = wmaLimitAmt;
	}

	public Double getWmaOutstandAmt() {
		return wmaOutstandAmt;
	}

	public void setWmaOutstandAmt(Double wmaOutstandAmt) {
		this.wmaOutstandAmt = wmaOutstandAmt;
	}

	public Double getWmaAdvanceAmt() {
		return wmaAdvanceAmt;
	}

	public void setWmaAdvanceAmt(Double wmaAdvanceAmt) {
		this.wmaAdvanceAmt = wmaAdvanceAmt;
	}

	public Double getTotWmaOsAmt() {
		return totWmaOsAmt;
	}

	public void setTotWmaOsAmt(Double totWmaOsAmt) {
		this.totWmaOsAmt = totWmaOsAmt;
	}

	public int getWmaDays() {
		return wmaDays;
	}

	public void setWmaDays(int wmaDays) {
		this.wmaDays = wmaDays;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getInterestPayable() {
		return interestPayable;
	}

	public void setInterestPayable(Double interestPayable) {
		this.interestPayable = interestPayable;
	}

	public Double getInterestPaid() {
		return interestPaid;
	}

	public void setInterestPaid(Double interestPaid) {
		this.interestPaid = interestPaid;
	}

	public Double getWmaPcUtilized() {
		return wmaPcUtilized;
	}

	public void setWmaPcUtilized(Double wmaPcUtilized) {
		this.wmaPcUtilized = wmaPcUtilized;
	}

}
