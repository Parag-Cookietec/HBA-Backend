package gov.ifms.doi.jpa.entity;

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


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_JPA_CLAIM_REJECT", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaClaimRejectEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1816004825834812247L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLAIM_REJECT_ID")
	private long claimRejectId;

	@Column(name="IS_REJECT_RESOLVED")
	private short isRejectResolved;

	@Column(name="JPA_CLAIM_ID", nullable=false)
	private long jpaClaimId;

	@Temporal(TemporalType.DATE)
	@Column(name="REJECT_GENERATE_DT")
	private Date rejectGenerateDt;

	@Column(name="REJECT_REASON_SRNO", nullable=false)
	private int rejectReasonSrno;

	@Column(name="REJECT_TYPE_DESC", length=200)
	private String rejectTypeDesc;

	@Column(name="REJECT_TYPE_ID", nullable=false)
	private long rejectTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="RESOLUTION_DT")
	private Date resolutionDt;

	//bi-directional many-to-one association to TdoiJpaClaimRecommend
	@ManyToOne
	@JoinColumn(name="CLAIM_RECOMM_ID", nullable=false)
	private DoiJpaClaimRecommendEntity doiJpaClaimRecommend;
	
	/**
	 * @return the claimRejectId
	 */
	public long getClaimRejectId() {
		return claimRejectId;
	}

	/**
	 * @param claimRejectId the claimRejectId to set
	 */
	public void setClaimRejectId(long claimRejectId) {
		this.claimRejectId = claimRejectId;
	}

	/**
	 * @return the isRejectResolved
	 */
	public short getIsRejectResolved() {
		return isRejectResolved;
	}

	/**
	 * @param isRejectResolved the isRejectResolved to set
	 */
	public void setIsRejectResolved(short isRejectResolved) {
		this.isRejectResolved = isRejectResolved;
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
	 * @return the rejectGenerateDt
	 */
	public Date getRejectGenerateDt() {
		return rejectGenerateDt;
	}

	/**
	 * @param rejectGenerateDt the rejectGenerateDt to set
	 */
	public void setRejectGenerateDt(Date rejectGenerateDt) {
		this.rejectGenerateDt = rejectGenerateDt;
	}

	/**
	 * @return the rejectReasonSrno
	 */
	public int getRejectReasonSrno() {
		return rejectReasonSrno;
	}

	/**
	 * @param rejectReasonSrno the rejectReasonSrno to set
	 */
	public void setRejectReasonSrno(int rejectReasonSrno) {
		this.rejectReasonSrno = rejectReasonSrno;
	}

	/**
	 * @return the rejectTypeDesc
	 */
	public String getRejectTypeDesc() {
		return rejectTypeDesc;
	}

	/**
	 * @param rejectTypeDesc the rejectTypeDesc to set
	 */
	public void setRejectTypeDesc(String rejectTypeDesc) {
		this.rejectTypeDesc = rejectTypeDesc;
	}

	/**
	 * @return the rejectTypeId
	 */
	public long getRejectTypeId() {
		return rejectTypeId;
	}

	/**
	 * @param rejectTypeId the rejectTypeId to set
	 */
	public void setRejectTypeId(long rejectTypeId) {
		this.rejectTypeId = rejectTypeId;
	}

	/**
	 * @return the resolutionDt
	 */
	public Date getResolutionDt() {
		return resolutionDt;
	}

	/**
	 * @param resolutionDt the resolutionDt to set
	 */
	public void setResolutionDt(Date resolutionDt) {
		this.resolutionDt = resolutionDt;
	}

	/**
	 * @return the doiJpaClaimRecommend
	 */
	public DoiJpaClaimRecommendEntity getDoiJpaClaimRecommend() {
		return doiJpaClaimRecommend;
	}

	/**
	 * @param doiJpaClaimRecommend the doiJpaClaimRecommend to set
	 */
	public void setDoiJpaClaimRecommend(DoiJpaClaimRecommendEntity doiJpaClaimRecommend) {
		this.doiJpaClaimRecommend = doiJpaClaimRecommend;
	}
	
}