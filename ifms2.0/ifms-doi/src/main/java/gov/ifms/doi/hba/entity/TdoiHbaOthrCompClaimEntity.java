package gov.ifms.doi.hba.entity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_HBA_OTHR_COMP_CLAIM database table.
 * * @author Sagar Jadhav
 */
@Entity
@Table(name = "TDOI_HBA_OTHR_COMP_CLAIM", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiHbaOthrCompClaimEntity.findAll", query = "SELECT t FROM TdoiHbaOthrCompClaimEntity t")
public class TdoiHbaOthrCompClaimEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OTHR_COMP_CLAIM_ID", unique = true, nullable = false)
	private long othrCompClaimId;

	@Column(name = "CLAIM_AMT_RECEVD")
	private double claimAmtRecevd;

	@Column(name = "COMPANY_NAME", nullable = false, length = 100)
	private String companyName;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_END_DT")
	private Date policyEndDt;

	@Column(name = "POLICY_NO", length = 30)
	private String policyNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "POLICY_START_DT")
	private Date policyStartDt;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	// bi-directional many-to-one association to TdoiHbaClaimEntry
	@ManyToOne
	@JoinColumn(name = "HBA_CLAIM_ID", nullable = false)
	@JsonBackReference
	private TdoiHbaClaimEntryEntity tdoiHbaClaimEntry;

	/**
	 * @return the othrCompClaimId
	 */
	public long getOthrCompClaimId() {
		return othrCompClaimId;
	}

	/**
	 * @param othrCompClaimId the othrCompClaimId to set
	 */
	public void setOthrCompClaimId(long othrCompClaimId) {
		this.othrCompClaimId = othrCompClaimId;
	}

	/**
	 * @return the claimAmtRecevd
	 */
	public double getClaimAmtRecevd() {
		return claimAmtRecevd;
	}

	/**
	 * @param claimAmtRecevd the claimAmtRecevd to set
	 */
	public void setClaimAmtRecevd(double claimAmtRecevd) {
		this.claimAmtRecevd = claimAmtRecevd;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the policyEndDt
	 */
	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	/**
	 * @param policyEndDt the policyEndDt to set
	 */
	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
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
	 * @return the policyStartDt
	 */
	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	/**
	 * @param policyStartDt the policyStartDt to set
	 */
	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	/**
	 * @return the sumInsured
	 */
	public double getSumInsured() {
		return sumInsured;
	}

	/**
	 * @param sumInsured the sumInsured to set
	 */
	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	/**
	 * @return the tdoiHbaClaimEntry
	 */
	public TdoiHbaClaimEntryEntity getTdoiHbaClaimEntry() {
		return tdoiHbaClaimEntry;
	}

	/**
	 * @param tdoiHbaClaimEntry the tdoiHbaClaimEntry to set
	 */
	public void setTdoiHbaClaimEntry(TdoiHbaClaimEntryEntity tdoiHbaClaimEntry) {
		this.tdoiHbaClaimEntry = tdoiHbaClaimEntry;
	}

}