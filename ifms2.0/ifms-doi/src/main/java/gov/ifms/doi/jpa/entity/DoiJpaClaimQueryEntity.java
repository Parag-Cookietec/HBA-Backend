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
@Table(name="TDOI_JPA_CLAIM_QUERY", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaClaimQueryEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5567101773562795963L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLAIM_QUERY_ID")
	private long claimQueryId;

	@Column(name="IS_QUERY_RESOLVED")
	private short isQueryResolved;

	@Temporal(TemporalType.DATE)
	@Column(name="QUERY_GENERATE_DT")
	private Date queryGenerateDt;

	@Column(name="QUERY_SRNO", nullable=false)
	private int querySrno;

	@Column(name="QUERY_TYPE_DESC", length=200)
	private String queryTypeDesc;

	@Column(name="QUERY_TYPE_ID", nullable=false)
	private long queryTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="RESOLUTION_DT")
	private Date resolutionDt;

	//bi-directional many-to-one association to TdoiJpaClaimEntry
	@ManyToOne
	@JoinColumn(name="JPA_CLAIM_ID", nullable=false)
	private DoiJPAClaimEntryEntity doiJpaClaimEntry;

	//bi-directional many-to-one association to TdoiJpaClaimRecommend
	@ManyToOne
	@JoinColumn(name="CLAIM_RECOMM_ID", nullable=false)
	private DoiJpaClaimRecommendEntity doiJpaClaimRecommend;
	
	/**
	 * @return the claimQueryId
	 */
	public long getClaimQueryId() {
		return claimQueryId;
	}

	/**
	 * @param claimQueryId the claimQueryId to set
	 */
	public void setClaimQueryId(long claimQueryId) {
		this.claimQueryId = claimQueryId;
	}

	/**
	 * @return the isQueryResolved
	 */
	public short getIsQueryResolved() {
		return isQueryResolved;
	}

	/**
	 * @param isQueryResolved the isQueryResolved to set
	 */
	public void setIsQueryResolved(short isQueryResolved) {
		this.isQueryResolved = isQueryResolved;
	}

	/**
	 * @return the queryGenerateDt
	 */
	public Date getQueryGenerateDt() {
		return queryGenerateDt;
	}

	/**
	 * @param queryGenerateDt the queryGenerateDt to set
	 */
	public void setQueryGenerateDt(Date queryGenerateDt) {
		this.queryGenerateDt = queryGenerateDt;
	}

	/**
	 * @return the querySrno
	 */
	public int getQuerySrno() {
		return querySrno;
	}

	/**
	 * @param querySrno the querySrno to set
	 */
	public void setQuerySrno(int querySrno) {
		this.querySrno = querySrno;
	}

	/**
	 * @return the queryTypeDesc
	 */
	public String getQueryTypeDesc() {
		return queryTypeDesc;
	}

	/**
	 * @param queryTypeDesc the queryTypeDesc to set
	 */
	public void setQueryTypeDesc(String queryTypeDesc) {
		this.queryTypeDesc = queryTypeDesc;
	}

	/**
	 * @return the queryTypeId
	 */
	public long getQueryTypeId() {
		return queryTypeId;
	}

	/**
	 * @param queryTypeId the queryTypeId to set
	 */
	public void setQueryTypeId(long queryTypeId) {
		this.queryTypeId = queryTypeId;
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
	 * @return the doiJpaClaimEntry
	 */
	public DoiJPAClaimEntryEntity getDoiJpaClaimEntry() {
		return doiJpaClaimEntry;
	}

	/**
	 * @param doiJpaClaimEntry the doiJpaClaimEntry to set
	 */
	public void setDoiJpaClaimEntry(DoiJPAClaimEntryEntity doiJpaClaimEntry) {
		this.doiJpaClaimEntry = doiJpaClaimEntry;
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