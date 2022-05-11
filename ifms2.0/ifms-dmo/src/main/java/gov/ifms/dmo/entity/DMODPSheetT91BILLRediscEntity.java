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
@Table(name = "TDMO_DP_T91BILL_REDISC", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT91BILLRediscEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T91BILL_REDISC_ID")
	private Long t91billRediscId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL91_OPEN_BAL")
	private Double tbill91OpenBal;

	@Column(name = "TBILL91_REDISC")
	private Double tbill91Redisc;

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

	@Column(name = "TBILL91_CLOS_BAL")
	private Double tbill91ClosBal;

	public Long getT91billRediscId() {
		return t91billRediscId;
	}

	public void setT91billRediscId(Long t91billRediscId) {
		this.t91billRediscId = t91billRediscId;
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

	public Double getTbill91Redisc() {
		return tbill91Redisc;
	}

	public void setTbill91Redisc(Double tbill91Redisc) {
		this.tbill91Redisc = tbill91Redisc;
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

	public Double getTbill91ClosBal() {
		return tbill91ClosBal;
	}

	public void setTbill91ClosBal(Double tbill91ClosBal) {
		this.tbill91ClosBal = tbill91ClosBal;
	}

}
