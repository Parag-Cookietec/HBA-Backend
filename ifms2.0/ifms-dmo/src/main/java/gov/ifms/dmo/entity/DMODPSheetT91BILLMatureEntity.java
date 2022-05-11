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
@Table(name = "TDMO_DP_T91BILL_MATURE", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT91BILLMatureEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T91BILL_MATURE_ID")
	private Long t91billMatureId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL91_OPEN_BAL")
	private Double tbill91OpenBal;

	@Column(name = "TBILL91_MATURITY")
	private Double tbill91Maturity;

	@Column(name = "ISSUE_DT")
	private LocalDate issueDt;

	@Column(name = "ORG_FACE_VALUE")
	private Double orgFaceValue;

	@Column(name = "CURR_FACE_VALUE")
	private Double currFaceValue;

	@Column(name = "TBILL91_CLOS_BAL")
	private Double tbill91ClosBal;

	public Long getT91billMatureId() {
		return t91billMatureId;
	}

	public void setT91billMatureId(Long t91billMatureId) {
		this.t91billMatureId = t91billMatureId;
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

	public Double getTbill91Maturity() {
		return tbill91Maturity;
	}

	public void setTbill91Maturity(Double tbill91Maturity) {
		this.tbill91Maturity = tbill91Maturity;
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

	public Double getTbill91ClosBal() {
		return tbill91ClosBal;
	}

	public void setTbill91ClosBal(Double tbill91ClosBal) {
		this.tbill91ClosBal = tbill91ClosBal;
	}

}
