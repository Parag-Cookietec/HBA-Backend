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
@Table(name="TDOI_RI_CLAIM_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiRiClaimDtlEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5180643394758543323L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RI_CLAIM_DTL_ID", unique=true, nullable=false)
	private long riClaimDtlId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Column(length=200)
	private String remarks;

	@Column(name="RI_CLAIM_AMT")
	private double riClaimAmt;

	@Column(name="RI_COMPANY_NAME", length=100)
	private String riCompanyName;

	@Column(name="RI_SHARE_PERC")
	private double riSharePerc;

	//bi-directional many-to-one association to DoiRiClaimHdrEntity
	@ManyToOne
	@JoinColumn(name="RI_CLAIM_ID", nullable=false)
	private DoiRiClaimHdrEntity doiRiClaimHdrEntity;

	/**
	 * @return the riClaimDtlId
	 */
	public long getRiClaimDtlId() {
		return riClaimDtlId;
	}

	/**
	 * @param riClaimDtlId the riClaimDtlId to set
	 */
	public void setRiClaimDtlId(long riClaimDtlId) {
		this.riClaimDtlId = riClaimDtlId;
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
	 * @return the riClaimAmt
	 */
	public double getRiClaimAmt() {
		return riClaimAmt;
	}

	/**
	 * @param riClaimAmt the riClaimAmt to set
	 */
	public void setRiClaimAmt(double riClaimAmt) {
		this.riClaimAmt = riClaimAmt;
	}

	/**
	 * @return the riCompanyName
	 */
	public String getRiCompanyName() {
		return riCompanyName;
	}

	/**
	 * @param riCompanyName the riCompanyName to set
	 */
	public void setRiCompanyName(String riCompanyName) {
		this.riCompanyName = riCompanyName;
	}

	/**
	 * @return the riSharePerc
	 */
	public double getRiSharePerc() {
		return riSharePerc;
	}

	/**
	 * @param riSharePerc the riSharePerc to set
	 */
	public void setRiSharePerc(double riSharePerc) {
		this.riSharePerc = riSharePerc;
	}

	/**
	 * @return the doiRiClaimHdrEntity
	 */
	public DoiRiClaimHdrEntity getDoiRiClaimHdrEntity() {
		return doiRiClaimHdrEntity;
	}

	/**
	 * @param doiRiClaimHdrEntity the doiRiClaimHdrEntity to set
	 */
	public void setDoiRiClaimHdrEntity(DoiRiClaimHdrEntity doiRiClaimHdrEntity) {
		this.doiRiClaimHdrEntity = doiRiClaimHdrEntity;
	}
}