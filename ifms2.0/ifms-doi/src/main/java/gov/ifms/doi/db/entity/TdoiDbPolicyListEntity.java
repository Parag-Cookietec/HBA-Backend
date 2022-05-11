package gov.ifms.doi.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;



/**
 * The persistent class for the TDOI_DB_POLICY_LIST database table.
 * 
 */
@Entity
@Table(name="TDOI_DB_POLICY_LIST", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name="TdoiDbPolicyListEntity.findAll", query="SELECT t FROM TdoiDbPolicyListEntity t")
public class TdoiDbPolicyListEntity  extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DB_POLICY_LST_ID", unique=true, nullable=false)
	private long dbPolicyLstId;

	@Column(name="DB_PROPOSAL_ID")
	private long dbProposalId;

	@Column(name="DISTRICT_ID")
	private long districtId;

	@Column(name="INSURED_NAME", length=60)
	private String insuredName;

	@Column(name="POLICY_CREATE_BY", length=50)
	private String policyCreateBy;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_CREATE_DT")
	private Date policyCreateDt;

	@Column(name="POLICY_CREATE_MNTH", length=20)
	private String policyCreateMnth;

	@Column(name="POLICY_CREATE_MNTH_ID")
	private long policyCreateMnthId;

	@Column(name="POLICY_CREATE_YR")
	private int policyCreateYr;

	@Column(name="POLICY_CREATE_YR_ID")
	private long policyCreateYrId;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_END_DT")
	private Date policyEndDt;

	@Column(name="POLICY_MODIFY_BY", length=50)
	private String policyModifyBy;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_MODIFY_DT")
	private Date policyModifyDt;

	@Column(name="POLICY_NO", length=30)
	private String policyNo;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_RENEW_DT")
	private Date policyRenewDt;

	@Temporal(TemporalType.DATE)
	@Column(name="POLICY_START_DT")
	private Date policyStartDt;

	@Column(name="POLICY_STATUS", length=30)
	private String policyStatus;

	@Column(name="POLICY_TYPE_ID", nullable=false)
	private long policyTypeId;

	@Column(name="REFERENCE_DT")
	private Date referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(name="RISK_TYPE_ID")
	private long riskTypeId;

	@Column(name="TALUKA_ID")
	private long talukaId;

	public TdoiDbPolicyListEntity() {
	}

	public long getDbPolicyLstId() {
		return this.dbPolicyLstId;
	}

	public void setDbPolicyLstId(long dbPolicyLstId) {
		this.dbPolicyLstId = dbPolicyLstId;
	}

	public long getDbProposalId() {
		return this.dbProposalId;
	}

	public void setDbProposalId(long dbProposalId) {
		this.dbProposalId = dbProposalId;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getInsuredName() {
		return this.insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getPolicyCreateBy() {
		return this.policyCreateBy;
	}

	public void setPolicyCreateBy(String policyCreateBy) {
		this.policyCreateBy = policyCreateBy;
	}

	public Date getPolicyCreateDt() {
		return this.policyCreateDt;
	}

	public void setPolicyCreateDt(Date policyCreateDt) {
		this.policyCreateDt = policyCreateDt;
	}

	public String getPolicyCreateMnth() {
		return this.policyCreateMnth;
	}

	public void setPolicyCreateMnth(String policyCreateMnth) {
		this.policyCreateMnth = policyCreateMnth;
	}

	public long getPolicyCreateMnthId() {
		return this.policyCreateMnthId;
	}

	public void setPolicyCreateMnthId(long policyCreateMnthId) {
		this.policyCreateMnthId = policyCreateMnthId;
	}

	public int getPolicyCreateYr() {
		return this.policyCreateYr;
	}

	public void setPolicyCreateYr(int policyCreateYr) {
		this.policyCreateYr = policyCreateYr;
	}

	public long getPolicyCreateYrId() {
		return this.policyCreateYrId;
	}

	public void setPolicyCreateYrId(long policyCreateYrId) {
		this.policyCreateYrId = policyCreateYrId;
	}

	public Date getPolicyEndDt() {
		return this.policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyModifyBy() {
		return this.policyModifyBy;
	}

	public void setPolicyModifyBy(String policyModifyBy) {
		this.policyModifyBy = policyModifyBy;
	}

	public Date getPolicyModifyDt() {
		return this.policyModifyDt;
	}

	public void setPolicyModifyDt(Date policyModifyDt) {
		this.policyModifyDt = policyModifyDt;
	}

	public String getPolicyNo() {
		return this.policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getPolicyRenewDt() {
		return this.policyRenewDt;
	}

	public void setPolicyRenewDt(Date policyRenewDt) {
		this.policyRenewDt = policyRenewDt;
	}

	public Date getPolicyStartDt() {
		return this.policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public String getPolicyStatus() {
		return this.policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public long getPolicyTypeId() {
		return this.policyTypeId;
	}

	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public long getRiskTypeId() {
		return this.riskTypeId;
	}

	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

}