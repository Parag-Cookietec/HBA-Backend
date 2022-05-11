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
@Table(name = "TDMO_DP_T14BILL_REDISC", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT14BILLRediscEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T14BILL_REDISC_ID")
	private Long t14billRediscId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL14_OPEN_BAL")
	private Double tbill14OpenBal;

	@Column(name = "TBILL14_REDISC")
	private Double tbill14Redisc;

	@Column(name = "ISSUE_DT")
	private LocalDate issueDt;

	@Column(name = "ORG_FACE_VALUE")
	private Double orgFaceValue;

	@Column(name = "CURR_FACE_VALUE")
	private Double currFaceValue;

	@Column(name = "REDISCOUNT_VALUE")
	private Double rediscountValue;

	@Column(name = "FACE_VAL_REDISC")
	private Double faceValRedisc;

	@Column(name = "RESIDUAL_AMT")
	private Double residualAmt;

	@Column(name = "TBILL14_CLOS_BAL")
	private Double tbill14ClosBal;

	public Long getT14billRediscId() {
		return t14billRediscId;
	}

	public void setT14billRediscId(Long t14billRediscId) {
		this.t14billRediscId = t14billRediscId;
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

	public Double getTbill14Redisc() {
		return tbill14Redisc;
	}

	public void setTbill14Redisc(Double tbill14Redisc) {
		this.tbill14Redisc = tbill14Redisc;
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

	public Double getTbill14ClosBal() {
		return tbill14ClosBal;
	}

	public void setTbill14ClosBal(Double tbill14ClosBal) {
		this.tbill14ClosBal = tbill14ClosBal;
	}

}
