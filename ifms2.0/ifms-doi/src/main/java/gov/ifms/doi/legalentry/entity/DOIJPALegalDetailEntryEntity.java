/**
 * 
 */
package gov.ifms.doi.legalentry.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "TDOI_JPA_LEGAL_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
public class DOIJPALegalDetailEntryEntity extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7161401579141353915L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEGAL_ENTRY_ID")
	private long legalEntryId;

	@Temporal(TemporalType.DATE)
	@Column(name="INWARD_DT", nullable=false)
	private Date inwardDt;

	@Column(name="INWARD_NO", nullable=false)
	private long inwardNo;

	@Column(name="JPA_CLAIM_ID", nullable=false)
	private long jpaClaimId;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@OneToMany(mappedBy="doiJpaLegalEntry", cascade = CascadeType.ALL)
	private List<DOIJpaLegalDtlEntity> doiJpaLegalDtls;

	/**
	 * @return the legalEntryId
	 */
	public long getLegalEntryId() {
		return legalEntryId;
	}

	/**
	 * @param legalEntryId the legalEntryId to set
	 */
	public void setLegalEntryId(long legalEntryId) {
		this.legalEntryId = legalEntryId;
	}

	/**
	 * @return the inwardDt
	 */
	public Date getInwardDt() {
		return inwardDt;
	}

	/**
	 * @param inwardDt the inwardDt to set
	 */
	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}

	/**
	 * @return the inwardNo
	 */
	public long getInwardNo() {
		return inwardNo;
	}

	/**
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(long inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * @return the jpaClaimId
	 */
	public long getJpaClaimId() {
		return jpaClaimId;
	}

	/**
	 * @param jpaClaimId the jpaClaimId to set
	 */
	public void setJpaClaimId(long jpaClaimId) {
		this.jpaClaimId = jpaClaimId;
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
	 * @return the doiJpaLegalDtls
	 */
	public List<DOIJpaLegalDtlEntity> getDoiJpaLegalDtls() {
		return doiJpaLegalDtls;
	}

	/**
	 * @param doiJpaLegalDtls the doiJpaLegalDtls to set
	 */
	public void setDoiJpaLegalDtls(List<DOIJpaLegalDtlEntity> doiJpaLegalDtls) {
		this.doiJpaLegalDtls = doiJpaLegalDtls;
	}

}
