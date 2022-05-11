package gov.ifms.doi.reinsurance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="TDOI_RI_POLICY_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiRiPolicyDtlEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6628405628008375079L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_POLICY_DTL_ID", unique=true, nullable=false)
	private long riPolicyDtlId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Column(name="PREM_SHARE_AMT")
	private double premShareAmt;

	@Column(length=100)
	private String remarks;

	@Column(name="RI_LOCATION", length=100)
	private String riLocation;

	@Column(name="RI_NAME", length=60)
	private String riName;

	@Column(name="RI_SHARE_PC")
	private double riSharePc;

	@ManyToOne
	@JoinColumn(name="RI_POLICY_HDR_ID", nullable=false)
	private DoiRiPolicyHdrEntity doiRiPolicyHdrEntity;

	/**
	 * @return the riPolicyDtlId
	 */
	public long getRiPolicyDtlId() {
		return riPolicyDtlId;
	}

	/**
	 * @param riPolicyDtlId the riPolicyDtlId to set
	 */
	public void setRiPolicyDtlId(long riPolicyDtlId) {
		this.riPolicyDtlId = riPolicyDtlId;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the premShareAmt
	 */
	public double getPremShareAmt() {
		return premShareAmt;
	}

	/**
	 * @param premShareAmt the premShareAmt to set
	 */
	public void setPremShareAmt(double premShareAmt) {
		this.premShareAmt = premShareAmt;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the riLocation
	 */
	public String getRiLocation() {
		return riLocation;
	}

	/**
	 * @param riLocation the riLocation to set
	 */
	public void setRiLocation(String riLocation) {
		this.riLocation = riLocation;
	}

	/**
	 * @return the riName
	 */
	public String getRiName() {
		return riName;
	}

	/**
	 * @param riName the riName to set
	 */
	public void setRiName(String riName) {
		this.riName = riName;
	}

	/**
	 * @return the riSharePc
	 */
	public double getRiSharePc() {
		return riSharePc;
	}

	/**
	 * @param riSharePc the riSharePc to set
	 */
	public void setRiSharePc(double riSharePc) {
		this.riSharePc = riSharePc;
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

}