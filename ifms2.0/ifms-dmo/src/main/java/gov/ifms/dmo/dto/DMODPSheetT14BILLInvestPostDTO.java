package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetT14BILLInvestPostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long t14billInvestId;
	private Long dpSheetDtlId;
	private Double tbill14OpenBal;
	private LocalDate investmentDt;
	private LocalDate maturityDt;
	private Double faceValue;
	private Double discountValue;
	private Double costValue;
	private Double yieldPercent;
	private Double tbill14ClosBal;

	private Long t14billMatureId;
	private Double tbill14Maturity;
	private LocalDate issueDt;
	private Double orgFaceValue;
	private Double currFaceValue;

	private Long t14billRediscId;
	private Double tbill14Redisc;
	private Double rediscountValue;
	private Double faceValRedisc;
	private Double residualAmt;
	private List<DMODPSheetT14BILLInvestPostDTO> data;

	public List<DMODPSheetT14BILLInvestPostDTO> getData() {
		return data;
	}

	public void setData(List<DMODPSheetT14BILLInvestPostDTO> data) {
		this.data = data;
	}

	public Double getResidualAmt() {
		return residualAmt;
	}

	public void setResidualAmt(Double residualAmt) {
		this.residualAmt = residualAmt;
	}

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

	public Long getT14billMatureId() {
		return t14billMatureId;
	}

	public void setT14billMatureId(Long t14billMatureId) {
		this.t14billMatureId = t14billMatureId;
	}

	public Double getTbill14Maturity() {
		return tbill14Maturity;
	}

	public void setTbill14Maturity(Double tbill14Maturity) {
		this.tbill14Maturity = tbill14Maturity;
	}

	public LocalDate getIssueDt() {
		return issueDt;
	}

	public void setIssueDt(LocalDate issueDt) {
		this.issueDt = issueDt;
	}

	public Double getOrgFaceValue() {
		return orgFaceValue;
	}

	public void setOrgFaceValue(Double orgFaceValue) {
		this.orgFaceValue = orgFaceValue;
	}

	public Double getCurrFaceValue() {
		return currFaceValue;
	}

	public void setCurrFaceValue(Double currFaceValue) {
		this.currFaceValue = currFaceValue;
	}

	public Double getTbill14Redisc() {
		return tbill14Redisc;
	}

	public void setTbill14Redisc(Double tbill14Redisc) {
		this.tbill14Redisc = tbill14Redisc;
	}

	public Double getRediscountValue() {
		return rediscountValue;
	}

	public void setRediscountValue(Double rediscountValue) {
		this.rediscountValue = rediscountValue;
	}

	public Double getFaceValRedisc() {
		return faceValRedisc;
	}

	public void setFaceValRedisc(Double faceValRedisc) {
		this.faceValRedisc = faceValRedisc;
	}

	public Long getT14billRediscId() {
		return t14billRediscId;
	}

	public void setT14billRediscId(Long t14billRediscId) {
		this.t14billRediscId = t14billRediscId;
	}

}
