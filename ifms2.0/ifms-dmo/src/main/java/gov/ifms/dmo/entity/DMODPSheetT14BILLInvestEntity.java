package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_DP_T14BILL_INVEST", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT14BILLInvestEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T14BILL_INVEST_ID")
	private Long t14billInvestId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL14_OPEN_BAL")
	private Double tbill14OpenBal;

	@Column(name = "INVESTMENT_DT")
	private LocalDate investmentDt;

	@Column(name = "MATURITY_DT")
	private LocalDate maturityDt;

	@Column(name = "FACE_VALUE")
	private Double faceValue;

	@Column(name = "DISCOUNT_VALUE")
	private Double discountValue;

	@Column(name = "COST_VALUE")
	private Double costValue;

	@Column(name = "YIELD_PERCENT")
	private Double yieldPercent;

	@Column(name = "TBILL14_CLOS_BAL")
	private Double tbill14ClosBal;

	public Long getT14billInvestId() {
		return t14billInvestId;
	}

	public void setT14billInvestId(Long t14billInvestId) {
		this.t14billInvestId = t14billInvestId;
	}

	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long dpSheetDtlId) {
		this.dpSheetDtlId = dpSheetDtlId;
	}

	public Double getTbill14OpenBal() {
		return tbill14OpenBal;
	}

	public void setTbill14OpenBal(Double tbill14OpenBal) {
		this.tbill14OpenBal = tbill14OpenBal;
	}

	public LocalDate getInvestmentDt() {
		return investmentDt;
	}

	public void setInvestmentDt(LocalDate investmentDt) {
		this.investmentDt = investmentDt;
	}

	public LocalDate getMaturityDt() {
		return maturityDt;
	}

	public void setMaturityDt(LocalDate maturityDt) {
		this.maturityDt = maturityDt;
	}

	public Double getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Double faceValue) {
		this.faceValue = faceValue;
	}

	public Double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
	}

	public Double getCostValue() {
		return costValue;
	}

	public void setCostValue(Double costValue) {
		this.costValue = costValue;
	}

	public Double getYieldPercent() {
		return yieldPercent;
	}

	public void setYieldPercent(Double yieldPercent) {
		this.yieldPercent = yieldPercent;
	}

	public Double getTbill14ClosBal() {
		return tbill14ClosBal;
	}

	public void setTbill14ClosBal(Double tbill14ClosBal) {
		this.tbill14ClosBal = tbill14ClosBal;
	}

}
