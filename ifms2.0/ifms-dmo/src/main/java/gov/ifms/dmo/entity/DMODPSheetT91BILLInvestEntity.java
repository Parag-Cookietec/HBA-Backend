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
@Table(name = "TDMO_DP_T91BILL_INVEST", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT91BILLInvestEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T91BILL_INVEST_ID")
	private Long t91billInvestId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL91_OPEN_BAL")
	private Double tbill91OpenBal;

	@Column(name = "INVESTMENT_DT")
	private LocalDate investmentDt;

	@Column(name = "MATURITY_DT")
	private LocalDate maturityDt;

	@Column(name = "COST_VALUE")
	private Double costValue;

	@Column(name = "INTIMATION_NO")
	private String intimationNo;

	@Column(name = "INTIMATION_DT")
	private LocalDate intimationDt;

	@Column(name = "INTIMATED_AMT")
	private Double intimatedAmt;

	@Column(name = "YIELD_PERCENT")
	private Double yieldPercent;

	@Column(name = "TBILL91_CLOS_BAL")
	private Double tbill91ClosBal;

	public Long getT91billInvestId() {
		return t91billInvestId;
	}

	public void setT91billInvestId(Long t91billInvestId) {
		this.t91billInvestId = t91billInvestId;
	}

	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long dpSheetDtlId) {
		this.dpSheetDtlId = dpSheetDtlId;
	}

	public Double getTbill91OpenBal() {
		return tbill91OpenBal;
	}

	public void setTbill91OpenBal(Double tbill91OpenBal) {
		this.tbill91OpenBal = tbill91OpenBal;
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

	public Double getCostValue() {
		return costValue;
	}

	public void setCostValue(Double costValue) {
		this.costValue = costValue;
	}

	public String getIntimationNo() {
		return intimationNo;
	}

	public void setIntimationNo(String intimationNo) {
		this.intimationNo = intimationNo;
	}

	public LocalDate getIntimationDt() {
		return intimationDt;
	}

	public void setIntimationDt(LocalDate intimationDt) {
		this.intimationDt = intimationDt;
	}

	public Double getIntimatedAmt() {
		return intimatedAmt;
	}

	public void setIntimatedAmt(Double intimatedAmt) {
		this.intimatedAmt = intimatedAmt;
	}

	public Double getYieldPercent() {
		return yieldPercent;
	}

	public void setYieldPercent(Double yieldPercent) {
		this.yieldPercent = yieldPercent;
	}

	public Double getTbill91ClosBal() {
		return tbill91ClosBal;
	}

	public void setTbill91ClosBal(Double tbill91ClosBal) {
		this.tbill91ClosBal = tbill91ClosBal;
	}

}
