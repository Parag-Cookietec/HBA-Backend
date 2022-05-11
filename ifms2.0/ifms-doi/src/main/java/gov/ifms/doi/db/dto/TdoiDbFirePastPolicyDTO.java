package gov.ifms.doi.db.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_FIRE_PAST_POLICIES database table.
 * 
 */

public class TdoiDbFirePastPolicyDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long pastPolicyId;

	private double claimAmount;

	private String policyNo;

	private short policySrno;

	private double premiumAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date premiumEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date premiumStartDt;

	// bi-directional many-to-one association to TdoiDbProposal

	private TdoiDbProposalDTO tdoiDbProposal;

	// bi-directional many-to-one association to TdoiDbPropslFirePeril

	private TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril;

	public TdoiDbFirePastPolicyDTO() {
	}

	public long getPastPolicyId() {
		return this.pastPolicyId;
	}

	public void setPastPolicyId(long pastPolicyId) {
		this.pastPolicyId = pastPolicyId;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public short getPolicySrno() {
		return this.policySrno;
	}

	public void setPolicySrno(short policySrno) {
		this.policySrno = policySrno;
	}

	public double getPremiumAmount() {
		return this.premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getPremiumEndDt() {
		return this.premiumEndDt;
	}

	public void setPremiumEndDt(Date premiumEndDt) {
		this.premiumEndDt = premiumEndDt;
	}

	public Date getPremiumStartDt() {
		return this.premiumStartDt;
	}

	public void setPremiumStartDt(Date premiumStartDt) {
		this.premiumStartDt = premiumStartDt;
	}

	public TdoiDbProposalDTO getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalDTO tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

	public TdoiDbPropslFirePerilDTO getTdoiDbPropslFirePeril() {
		return this.tdoiDbPropslFirePeril;
	}

	public void setTdoiDbPropslFirePeril(TdoiDbPropslFirePerilDTO tdoiDbPropslFirePeril) {
		this.tdoiDbPropslFirePeril = tdoiDbPropslFirePeril;
	}

}
