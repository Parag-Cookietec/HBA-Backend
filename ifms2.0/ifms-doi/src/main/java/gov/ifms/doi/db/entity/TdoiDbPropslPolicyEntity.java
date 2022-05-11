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
 * The persistent class for the TDOI_DB_PROPSL_POLICIES database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_POLICIES", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslPolicyEntity.findAll", query = "SELECT t FROM TdoiDbPropslPolicyEntity t")
public class TdoiDbPropslPolicyEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROPSL_POLICIES_ID", unique = true, nullable = false)
	private long propslPoliciesId;

	@Column(name = "OLD_POLICY_NO", length = 30)
	private String oldPolicyNo;

	@Column(name = "POLICY_TYPE_ID", nullable = false)
	private long policyTypeId;

	@Column(name = "PREMIUM_AMOUNT")
	private double premiumAmount;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROPOSAL_GENR_DT")
	private Date proposalGenrDt;

	@Column(name = "PROPOSAL_NO", length = 30)
	private String proposalNo;

	@Column(name = "SUM_INSURED", nullable = false)
	private double sumInsured;

	// bi-directional many-to-one association to TdoiDbProposal
	@ManyToOne
	@JoinColumn(name = "DB_PROPOSAL_ID", nullable = false)
	private TdoiDbProposalEntity tdoiDbProposal;

	public TdoiDbPropslPolicyEntity() {
	}

	public long getPropslPoliciesId() {
		return this.propslPoliciesId;
	}

	public void setPropslPoliciesId(long propslPoliciesId) {
		this.propslPoliciesId = propslPoliciesId;
	}

	public String getOldPolicyNo() {
		return this.oldPolicyNo;
	}

	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
	}

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public double getPremiumAmount() {
		return this.premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Date getProposalGenrDt() {
		return this.proposalGenrDt;
	}

	public void setProposalGenrDt(Date proposalGenrDt) {
		this.proposalGenrDt = proposalGenrDt;
	}

	public String getProposalNo() {
		return this.proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public TdoiDbProposalEntity getTdoiDbProposal() {
		return this.tdoiDbProposal;
	}

	public void setTdoiDbProposal(TdoiDbProposalEntity tdoiDbProposal) {
		this.tdoiDbProposal = tdoiDbProposal;
	}

}