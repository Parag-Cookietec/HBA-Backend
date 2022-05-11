package gov.ifms.doi.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_POL_FIRE_PAST_POLICIES database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_FIRE_PAST_POLICIES", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolFirePastPolicyEntity.findAll", query = "SELECT t FROM TdoiDbPolFirePastPolicyEntity t")
public class TdoiDbPolFirePastPolicyEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAST_POLICY_ID", unique = true, nullable = false)
	private long pastPolicyId;

	@Column(name = "CLAIM_AMOUNT")
	private double claimAmount;

	@Column(name = "DB_PROPOSAL_ID", nullable = false)
	private long dbProposalId;

	@Column(name = "POLICY_NO", length = 30)
	private String policyNo;

	@Column(name = "POLICY_SRNO")
	private short policySrno;

	@Column(name = "PREMIUM_AMOUNT")
	private double premiumAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "PREMIUM_END_DT")
	private Date premiumEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name = "PREMIUM_START_DT")
	private Date premiumStartDt;

	// bi-directional many-to-one association to TdoiDbPolFirePeril
	@ManyToOne
	@JoinColumn(name = "POL_FIRE_PERIL_ID", nullable = false)
	private TdoiDbPolFirePerilEntity tdoiDbPolFirePeril;

	public TdoiDbPolFirePastPolicyEntity() {
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

	public TdoiDbPolFirePerilEntity getTdoiDbPolFirePeril() {
		return this.tdoiDbPolFirePeril;
	}

	public void setTdoiDbPolFirePeril(TdoiDbPolFirePerilEntity tdoiDbPolFirePeril) {
		this.tdoiDbPolFirePeril = tdoiDbPolFirePeril;
	}

}