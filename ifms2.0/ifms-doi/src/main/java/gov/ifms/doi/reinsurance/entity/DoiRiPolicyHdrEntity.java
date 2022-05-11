package gov.ifms.doi.reinsurance.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_RI_POLICY_HDR", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiRiPolicyHdrEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7850600922016966994L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_POLICY_HDR_ID", unique=true, nullable=false)
	private long riPolicyHdrId;

	@Column(name="AGENCY_COMMISS_PC")
	private double agencyCommissPc;

	@Column(name="COMMISSION_AMT")
	private double commissionAmt;

	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Column(name="DEPARTMENT_NAME", length=60)
	private String departmentName;

	@Temporal(TemporalType.DATE)
	@Column(name="INSUR_END_DT")
	private Date insurEndDt;

	@Temporal(TemporalType.DATE)
	@Column(name="INSUR_START_DT")
	private Date insurStartDt;

	@Column(name="INSURED_ADDRESS", length=100)
	private String insuredAddress;

	@Column(name="INSURED_NAME", length=60)
	private String insuredName;

	@Column(name="POLICY_NO", length=30)
	private String policyNo;

	@Column(name="POLICY_TYPE_ID")
	private long policyTypeId;

	@Column(name="PREMIUM_AMOUNT")
	private double premiumAmount;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(name="RISK_LOCATION", length=100)
	private String riskLocation;

	@Column(name="RISK_LOCATION_ID")
	private long riskLocationId;

	@Column(name="SUM_INSURED_AMT")
	private double sumInsuredAmt;

	@OneToMany(mappedBy="doiRiPolicyHdrEntity")
	private List<DoiRiClaimHdrEntity> doiRiClaimHdrEntities;

	@OneToMany(mappedBy="doiRiPolicyHdrEntity")
	private List<DoiRiPolicyDtlEntity> doiRiPolicyDtlEntities;

	@OneToMany(mappedBy="doiRiPolicyHdrEntity")
	private List<DoiRiPolicyHdrWFEntity> doiRiPolicyHdrWFEntities;

	public DoiRiClaimHdrEntity addTdoiRiClaimHdr(DoiRiClaimHdrEntity doiRiClaimHdrEntity) {
		getDoiRiClaimHdrEntities().add(doiRiClaimHdrEntity);
		doiRiClaimHdrEntity.setDoiRiPolicyHdrEntity(this);

		return doiRiClaimHdrEntity;
	}

	public DoiRiClaimHdrEntity removeTdoiRiClaimHdr(DoiRiClaimHdrEntity doiRiClaimHdrEntity) {
		getDoiRiClaimHdrEntities().remove(doiRiClaimHdrEntity);
		doiRiClaimHdrEntity.setDoiRiPolicyHdrEntity(null);

		return doiRiClaimHdrEntity;
	}
	
	public DoiRiPolicyDtlEntity addTdoiRiPolicyDtl(DoiRiPolicyDtlEntity doiRiPolicyDtlEntity) {
		getDoiRiPolicyDtlEntities().add(doiRiPolicyDtlEntity);
		doiRiPolicyDtlEntity.setDoiRiPolicyHdrEntity(this);

		return doiRiPolicyDtlEntity;
	}

	
	public DoiRiPolicyDtlEntity removeTdoiRiPolicyDtl(DoiRiPolicyDtlEntity doiRiPolicyDtlEntity) {
		getDoiRiPolicyDtlEntities().remove(doiRiPolicyDtlEntity);
		doiRiPolicyDtlEntity.setDoiRiPolicyHdrEntity(null);

		return doiRiPolicyDtlEntity;
	}

	/**
	 * @return the riPolicyHdrId
	 */
	public long getRiPolicyHdrId() {
		return riPolicyHdrId;
	}

	/**
	 * @param riPolicyHdrId the riPolicyHdrId to set
	 */
	public void setRiPolicyHdrId(long riPolicyHdrId) {
		this.riPolicyHdrId = riPolicyHdrId;
	}

	/**
	 * @return the agencyCommissPc
	 */
	public double getAgencyCommissPc() {
		return agencyCommissPc;
	}

	/**
	 * @param agencyCommissPc the agencyCommissPc to set
	 */
	public void setAgencyCommissPc(double agencyCommissPc) {
		this.agencyCommissPc = agencyCommissPc;
	}

	/**
	 * @return the commissionAmt
	 */
	public double getCommissionAmt() {
		return commissionAmt;
	}

	/**
	 * @param commissionAmt the commissionAmt to set
	 */
	public void setCommissionAmt(double commissionAmt) {
		this.commissionAmt = commissionAmt;
	}

	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the insurEndDt
	 */
	public Date getInsurEndDt() {
		return insurEndDt;
	}

	/**
	 * @param insurEndDt the insurEndDt to set
	 */
	public void setInsurEndDt(Date insurEndDt) {
		this.insurEndDt = insurEndDt;
	}

	/**
	 * @return the insurStartDt
	 */
	public Date getInsurStartDt() {
		return insurStartDt;
	}

	/**
	 * @param insurStartDt the insurStartDt to set
	 */
	public void setInsurStartDt(Date insurStartDt) {
		this.insurStartDt = insurStartDt;
	}

	/**
	 * @return the insuredAddress
	 */
	public String getInsuredAddress() {
		return insuredAddress;
	}

	/**
	 * @param insuredAddress the insuredAddress to set
	 */
	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	/**
	 * @return the insuredName
	 */
	public String getInsuredName() {
		return insuredName;
	}

	/**
	 * @param insuredName the insuredName to set
	 */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the policyTypeId
	 */
	public long getPolicyTypeId() {
		return policyTypeId;
	}

	/**
	 * @param policyTypeId the policyTypeId to set
	 */
	public void setPolicyTypeId(long policyTypeId) {
		this.policyTypeId = policyTypeId;
	}

	/**
	 * @return the premiumAmount
	 */
	public double getPremiumAmount() {
		return premiumAmount;
	}

	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	/**
	 * @return the referenceDt
	 */
	public Timestamp getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Timestamp referenceDt) {
		this.referenceDt = referenceDt;
	}

	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * @return the riskLocation
	 */
	public String getRiskLocation() {
		return riskLocation;
	}

	/**
	 * @param riskLocation the riskLocation to set
	 */
	public void setRiskLocation(String riskLocation) {
		this.riskLocation = riskLocation;
	}

	/**
	 * @return the riskLocationId
	 */
	public long getRiskLocationId() {
		return riskLocationId;
	}

	/**
	 * @param riskLocationId the riskLocationId to set
	 */
	public void setRiskLocationId(long riskLocationId) {
		this.riskLocationId = riskLocationId;
	}

	/**
	 * @return the sumInsuredAmt
	 */
	public double getSumInsuredAmt() {
		return sumInsuredAmt;
	}

	/**
	 * @param sumInsuredAmt the sumInsuredAmt to set
	 */
	public void setSumInsuredAmt(double sumInsuredAmt) {
		this.sumInsuredAmt = sumInsuredAmt;
	}

	/**
	 * @return the doiRiClaimHdrEntities
	 */
	public List<DoiRiClaimHdrEntity> getDoiRiClaimHdrEntities() {
		return doiRiClaimHdrEntities;
	}

	/**
	 * @param doiRiClaimHdrEntities the doiRiClaimHdrEntities to set
	 */
	public void setDoiRiClaimHdrEntities(List<DoiRiClaimHdrEntity> doiRiClaimHdrEntities) {
		this.doiRiClaimHdrEntities = doiRiClaimHdrEntities;
	}

	/**
	 * @return the doiRiPolicyDtlEntities
	 */
	public List<DoiRiPolicyDtlEntity> getDoiRiPolicyDtlEntities() {
		return doiRiPolicyDtlEntities;
	}

	/**
	 * @param doiRiPolicyDtlEntities the doiRiPolicyDtlEntities to set
	 */
	public void setDoiRiPolicyDtlEntities(List<DoiRiPolicyDtlEntity> doiRiPolicyDtlEntities) {
		this.doiRiPolicyDtlEntities = doiRiPolicyDtlEntities;
	}

	/**
	 * @return the doiRiPolicyHdrWFEntities
	 */
	public List<DoiRiPolicyHdrWFEntity> getDoiRiPolicyHdrWFEntities() {
		return doiRiPolicyHdrWFEntities;
	}

	/**
	 * @param doiRiPolicyHdrWFEntities the doiRiPolicyHdrWFEntities to set
	 */
	public void setDoiRiPolicyHdrWFEntities(List<DoiRiPolicyHdrWFEntity> doiRiPolicyHdrWFEntities) {
		this.doiRiPolicyHdrWFEntities = doiRiPolicyHdrWFEntities;
	}
	
}