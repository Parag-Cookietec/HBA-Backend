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
@Table(name = "TDMO_DP_T14BILL_MATURE", schema = Constant.DMO_SCHEMA)
public class DMODPSheetT14BILLMatureEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T14BILL_MATURE_ID")
	private Long t14billMatureId;

	@Column(name = "DP_SHEET_ID")
	private Long dpSheetDtlId;

	@Column(name = "TBILL14_OPEN_BAL")
	private Double tbill14OpenBal;

	@Column(name = "TBILL14_MATURITY")
	private Double tbill14Maturity;

	@Column(name = "ISSUE_DT")
	private LocalDate issueDt;

	@Column(name = "ORG_FACE_VALUE")
	private Double orgFaceValue;

	@Column(name = "CURR_FACE_VALUE")
	private Double currFaceValue;

	@Column(name = "TBILL14_CLOS_BAL")
	private Double tbill14ClosBal;

	public Long getT14billMatureId() {
		return t14billMatureId;
	}

	public void setT14billMatureId(Long t14billMatureId) {
		this.t14billMatureId = t14billMatureId;
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

	public Double getTbill14ClosBal() {
		return tbill14ClosBal;
	}

	public void setTbill14ClosBal(Double tbill14ClosBal) {
		this.tbill14ClosBal = tbill14ClosBal;
	}

}
