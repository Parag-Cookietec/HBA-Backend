package gov.ifms.dmo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_DP_WMA_PRINCPAL", schema = Constant.DMO_SCHEMA)
public class DMODPSheetWMAPrincipalEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WMA_PRINCPAL_ID")
	private Long wmaPrincipalId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "WMA_TYPE_ID")
	private Long wmaTypeId;

	@Column(name = "WMA_OUTSTAND_AMT")
	private Double wmaOutstandAmt;

	@Column(name = "WMA_REPAY_AMT")
	private Double wmaRepayAmt;

	@Column(name = "WMA_INTRST_PAYMNT")
	private Double wmaIntrstPaymnt;

	@Column(name = "TOT_WMA_OS_AMT")
	private Double totWmaOsAmt;

	@Column(name = "WMA_DAYS")
	private int wmaDays;

	@Column(name = "INTEREST_RATE")
	private Double interestRate;

	@Column(name = "INTEREST_PAYABLE")
	private Double interestPayable;

	@Column(name = "INTEREST_PAID")
	private Double interestPaid;

	@Column(name = "WMA_PC_UTILIZED")
	private Double wmaPcUtilized;


	public Long getWmaPrincipalId() {
		return wmaPrincipalId;
	}

	public void setWmaPrincipalId(Long wmaPrincipalId) {
		this.wmaPrincipalId = wmaPrincipalId;
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

	public Double getWmaOutstandAmt() {
		return wmaOutstandAmt;
	}

	public void setWmaOutstandAmt(Double wmaOutstandAmt) {
		this.wmaOutstandAmt = wmaOutstandAmt;
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
