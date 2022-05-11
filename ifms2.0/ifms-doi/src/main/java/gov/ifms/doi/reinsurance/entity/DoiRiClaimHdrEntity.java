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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="TDOI_RI_CLAIM_HDR", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiRiClaimHdrEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7998909281197787167L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_CLAIM_ID", unique=true, nullable=false)
	private long riClaimId;

	@Column(name="CLAIM_AMOUNT")
	private double claimAmount;

	@Column(name="CLAIM_ID", length=30)
	private String claimId;

	@Column(name="CLAIM_STATUS", length=30)
	private String claimStatus;

	@Column(name="CLAIM_STATUS_ID")
	private long claimStatusId;

	@Column(name="GIF_SHARE_AMT")
	private double gifShareAmt;

	@Column(name="GIF_SHARE_PERC")
	private double gifSharePerc;

	@Column(name="INSURED_NAME", length=60)
	private String insuredName;

	@Column(name="LEADER_NAME", length=60)
	private String leaderName;

	@Column(name="POLICY_NO", length=30)
	private String policyNo;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Temporal(TemporalType.DATE)
	@Column(name="RI_CLAIM_DT")
	private Date riClaimDt;

	@OneToMany(mappedBy="doiRiClaimHdrEntity")
	private List<DoiRiClaimDtlEntity> doiRiClaimDtlEntities;

	@ManyToOne
	@JoinColumn(name="RI_POLICY_HDR_ID", nullable=false)
	private DoiRiPolicyHdrEntity doiRiPolicyHdrEntity;

	@OneToMany(mappedBy="doiRiClaimHdrEntity")
	private List<DoiRiClaimHdrWFEntity> doiRiClaimHdrWFEntities;

	/**
	 * @return the riClaimId
	 */
	public long getRiClaimId() {
		return riClaimId;
	}

	/**
	 * @param riClaimId the riClaimId to set
	 */
	public void setRiClaimId(long riClaimId) {
		this.riClaimId = riClaimId;
	}

	/**
	 * @return the claimAmount
	 */
	public double getClaimAmount() {
		return claimAmount;
	}

	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	/**
	 * @return the claimId
	 */
	public String getClaimId() {
		return claimId;
	}

	/**
	 * @param claimId the claimId to set
	 */
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	/**
	 * @return the claimStatus
	 */
	public String getClaimStatus() {
		return claimStatus;
	}

	/**
	 * @param claimStatus the claimStatus to set
	 */
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	/**
	 * @return the claimStatusId
	 */
	public long getClaimStatusId() {
		return claimStatusId;
	}

	/**
	 * @param claimStatusId the claimStatusId to set
	 */
	public void setClaimStatusId(long claimStatusId) {
		this.claimStatusId = claimStatusId;
	}

	/**
	 * @return the gifShareAmt
	 */
	public double getGifShareAmt() {
		return gifShareAmt;
	}

	/**
	 * @param gifShareAmt the gifShareAmt to set
	 */
	public void setGifShareAmt(double gifShareAmt) {
		this.gifShareAmt = gifShareAmt;
	}

	/**
	 * @return the gifSharePerc
	 */
	public double getGifSharePerc() {
		return gifSharePerc;
	}

	/**
	 * @param gifSharePerc the gifSharePerc to set
	 */
	public void setGifSharePerc(double gifSharePerc) {
		this.gifSharePerc = gifSharePerc;
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
	 * @return the leaderName
	 */
	public String getLeaderName() {
		return leaderName;
	}

	/**
	 * @param leaderName the leaderName to set
	 */
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
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
	 * @return the riClaimDt
	 */
	public Date getRiClaimDt() {
		return riClaimDt;
	}

	/**
	 * @param riClaimDt the riClaimDt to set
	 */
	public void setRiClaimDt(Date riClaimDt) {
		this.riClaimDt = riClaimDt;
	}

	/**
	 * @return the doiRiClaimDtlEntities
	 */
	public List<DoiRiClaimDtlEntity> getDoiRiClaimDtlEntities() {
		return doiRiClaimDtlEntities;
	}

	/**
	 * @param doiRiClaimDtlEntities the doiRiClaimDtlEntities to set
	 */
	public void setDoiRiClaimDtlEntities(List<DoiRiClaimDtlEntity> doiRiClaimDtlEntities) {
		this.doiRiClaimDtlEntities = doiRiClaimDtlEntities;
	}

	/**
	 * @return the doiRiPolicyHdrEntity
	 */
	public DoiRiPolicyHdrEntity getDoiRiPolicyHdrEntity() {
		return doiRiPolicyHdrEntity;
	}

	/**
	 * @param doiRiPolicyHdrEntity the doiRiPolicyHdrEntity to set
	 */
	public void setDoiRiPolicyHdrEntity(DoiRiPolicyHdrEntity doiRiPolicyHdrEntity) {
		this.doiRiPolicyHdrEntity = doiRiPolicyHdrEntity;
	}

	/**
	 * @return the doiRiClaimHdrWFEntities
	 */
	public List<DoiRiClaimHdrWFEntity> getDoiRiClaimHdrWFEntities() {
		return doiRiClaimHdrWFEntities;
	}

	/**
	 * @param doiRiClaimHdrWFEntities the doiRiClaimHdrWFEntities to set
	 */
	public void setDoiRiClaimHdrWFEntities(List<DoiRiClaimHdrWFEntity> doiRiClaimHdrWFEntities) {
		this.doiRiClaimHdrWFEntities = doiRiClaimHdrWFEntities;
	}

}