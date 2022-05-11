package gov.ifms.doi.db.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;
import lombok.Data;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_PAST_POLICIES database table.
 * 
 */


public class TdoiDbPolFirePastPolicyDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long pastPolicyId;

	private double claimAmount;

	private long dbProposalId;

	private String policyNo;

	private short policySrno;

	private double premiumAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date premiumEndDt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date premiumStartDt;

	// bi-directional many-to-one association to TdoiDbPolFirePeril

	private TdoiDbPolFirePerilDTO tdoiDbPolFirePeril;

	public TdoiDbPolFirePastPolicyDTO() {
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

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
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

	public TdoiDbPolFirePerilDTO getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilDTO tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}
