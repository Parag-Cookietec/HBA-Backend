package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetT91BILLInvestPostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long t91billInvestId;
	private Long dpSheetDtlId;
	private Double tbill91OpenBal;
	private LocalDate investmentDt;
	private LocalDate maturityDt;
	private Double costValue;
	private String intimationNo;
	private LocalDate intimationDt;
	private Double intimatedAmt;
	private Double yieldPercent;
	private Double tbill91ClosBal;

	private Long t91billMatureId;
	private Double tbill91Maturity;
	private LocalDate issueDt;
	private Double orgFaceValue;
	private Double currFaceValue;

	private Long t91billRediscId;
	private Double tbill91Redisc;
	private Double rediscountValue;
	private Double faceValRedisc;
	private Double residualAmt;

	private List<DMODPSheetT91BILLInvestPostDTO> data;

	public List<DMODPSheetT91BILLInvestPostDTO> getData() {
		return data;
	}

	public void setData(List<DMODPSheetT91BILLInvestPostDTO> data) {
		this.data = data;
	}

	public Long getT91billRediscId() {
		return t91billRediscId;
	}

	public void setT91billRediscId(Long t91billRediscId) {
		this.t91billRediscId = t91billRediscId;
	}

	public Double getTbill91Redisc() {
		return tbill91Redisc;
	}

	public void setTbill91Redisc(Double tbill91Redisc) {
		this.tbill91Redisc = tbill91Redisc;
	}

	public Long getT91billMatureId() {
		return t91billMatureId;
	}

	public void setT91billMatureId(Long t91billMatureId) {
		this.t91billMatureId = t91billMatureId;
	}

	public Double getTbill91Maturity() {
		return tbill91Maturity;
	}

	public void setTbill91Maturity(Double tbill91Maturity) {
		this.tbill91Maturity = tbill91Maturity;
	}

	public Long getT91billInvestId() {
		return t91billInvestId;
	}

	public void setT91billInvestId(Long t91billInvestId) {
		this.t91billInvestId = t91billInvestId;
	}

	public Double getTbill91OpenBal() {
		return tbill91OpenBal;
	}

	public void setTbill91OpenBal(Double tbill91OpenBal) {
		this.tbill91OpenBal = tbill91OpenBal;
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

	public Double getTbill91ClosBal() {
		return tbill91ClosBal;
	}

	public void setTbill91ClosBal(Double tbill91ClosBal) {
		this.tbill91ClosBal = tbill91ClosBal;
	}

	public Long getDpSheetDtlId() {
		return dpSheetDtlId;
	}

	public void setDpSheetDtlId(Long dpSheetDtlId) {
		this.dpSheetDtlId = dpSheetDtlId;
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

	public Double getYieldPercent() {
		return yieldPercent;
	}

	public void setYieldPercent(Double yieldPercent) {
		this.yieldPercent = yieldPercent;
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

	public Double getResidualAmt() {
		return residualAmt;
	}

	public void setResidualAmt(Double residualAmt) {
		this.residualAmt = residualAmt;
	}

}
