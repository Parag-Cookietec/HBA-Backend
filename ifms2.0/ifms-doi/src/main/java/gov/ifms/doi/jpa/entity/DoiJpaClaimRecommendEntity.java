package gov.ifms.doi.jpa.entity;

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


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_JPA_CLAIM_RECOMMEND", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiJpaClaimRecommendEntity extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 759820923682047510L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CLAIM_RECOMM_ID")
	private long claimRecommId;

	@Column(name="CLAIM_NUMBER", length=40)
	private String claimNumber;

	@Column(name="IS_LEGAL_REQUESTED", nullable=false)
	private short isLegalRequested;

	@Column(name="LEGAL_ENTRY_ID")
	private long legalEntryId;

	@Temporal(TemporalType.DATE)
	@Column(name="LEGAL_REQUEST_DT")
	private Date legalRequestDt;

	@Temporal(TemporalType.DATE)
	@Column(name="PAYMENT_SEND_DT")
	private Date paymentSendDt;

	@Temporal(TemporalType.DATE)
	@Column(name="RECOMMEND_DT")
	private Date recommendDt;

	@Column(name="RECOMMEND_STATUS", length=20)
	private String recommendStatus;

	@Column(name="RECOMMEND_TYPE_ID", nullable=false)
	private long recommendTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name="REOPEN_DT")
	private Date reopenDt;

	@Temporal(TemporalType.DATE)
	@Column(name="SETTLEMENT_DT")
	private Date settlementDt;

	@Column(name="SURVEYOR_ID")
	private long surveyorId;

	@Column(name="SURVEYOR_NAME", length=100)
	private String surveyorName;

	//bi-directional many-to-one association to TdoiJpaClaimQuery
	@OneToMany(mappedBy="doiJpaClaimRecommend")
	private List<DoiJpaClaimQueryEntity> doiJpaClaimQueries;

	//bi-directional many-to-one association to TdoiJpaClaimEntry
	@ManyToOne
	@JoinColumn(name="JPA_CLAIM_ID", nullable=false)
	private DoiJPAClaimEntryEntity doiJpaClaimEntry;

	//bi-directional many-to-one association to DoiJpaClaimRejectEntity
	@OneToMany(mappedBy="doiJpaClaimRecommend")
	private List<DoiJpaClaimRejectEntity> doiJpaClaimRejects;

	/**
	 * @return the claimRecommId
	 */
	public long getClaimRecommId() {
		return claimRecommId;
	}

	/**
	 * @param claimRecommId the claimRecommId to set
	 */
	public void setClaimRecommId(long claimRecommId) {
		this.claimRecommId = claimRecommId;
	}

	/**
	 * @return the claimNumber
	 */
	public String getClaimNumber() {
		return claimNumber;
	}

	/**
	 * @param claimNumber the claimNumber to set
	 */
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	/**
	 * @return the isLegalRequested
	 */
	public short getIsLegalRequested() {
		return isLegalRequested;
	}

	/**
	 * @param isLegalRequested the isLegalRequested to set
	 */
	public void setIsLegalRequested(short isLegalRequested) {
		this.isLegalRequested = isLegalRequested;
	}

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
	 * @return the legalRequestDt
	 */
	public Date getLegalRequestDt() {
		return legalRequestDt;
	}

	/**
	 * @param legalRequestDt the legalRequestDt to set
	 */
	public void setLegalRequestDt(Date legalRequestDt) {
		this.legalRequestDt = legalRequestDt;
	}

	/**
	 * @return the paymentSendDt
	 */
	public Date getPaymentSendDt() {
		return paymentSendDt;
	}

	/**
	 * @param paymentSendDt the paymentSendDt to set
	 */
	public void setPaymentSendDt(Date paymentSendDt) {
		this.paymentSendDt = paymentSendDt;
	}

	/**
	 * @return the recommendDt
	 */
	public Date getRecommendDt() {
		return recommendDt;
	}

	/**
	 * @param recommendDt the recommendDt to set
	 */
	public void setRecommendDt(Date recommendDt) {
		this.recommendDt = recommendDt;
	}

	/**
	 * @return the recommendStatus
	 */
	public String getRecommendStatus() {
		return recommendStatus;
	}

	/**
	 * @param recommendStatus the recommendStatus to set
	 */
	public void setRecommendStatus(String recommendStatus) {
		this.recommendStatus = recommendStatus;
	}

	/**
	 * @return the recommendTypeId
	 */
	public long getRecommendTypeId() {
		return recommendTypeId;
	}

	/**
	 * @param recommendTypeId the recommendTypeId to set
	 */
	public void setRecommendTypeId(long recommendTypeId) {
		this.recommendTypeId = recommendTypeId;
	}

	/**
	 * @return the reopenDt
	 */
	public Date getReopenDt() {
		return reopenDt;
	}

	/**
	 * @param reopenDt the reopenDt to set
	 */
	public void setReopenDt(Date reopenDt) {
		this.reopenDt = reopenDt;
	}

	/**
	 * @return the settlementDt
	 */
	public Date getSettlementDt() {
		return settlementDt;
	}

	/**
	 * @param settlementDt the settlementDt to set
	 */
	public void setSettlementDt(Date settlementDt) {
		this.settlementDt = settlementDt;
	}

	/**
	 * @return the surveyorId
	 */
	public long getSurveyorId() {
		return surveyorId;
	}

	/**
	 * @param surveyorId the surveyorId to set
	 */
	public void setSurveyorId(long surveyorId) {
		this.surveyorId = surveyorId;
	}

	/**
	 * @return the surveyorName
	 */
	public String getSurveyorName() {
		return surveyorName;
	}

	/**
	 * @param surveyorName the surveyorName to set
	 */
	public void setSurveyorName(String surveyorName) {
		this.surveyorName = surveyorName;
	}

	/**
	 * @return the doiJpaClaimQueries
	 */
	public List<DoiJpaClaimQueryEntity> getDoiJpaClaimQueries() {
		return doiJpaClaimQueries;
	}

	/**
	 * @param doiJpaClaimQueries the doiJpaClaimQueries to set
	 */
	public void setDoiJpaClaimQueries(List<DoiJpaClaimQueryEntity> doiJpaClaimQueries) {
		this.doiJpaClaimQueries = doiJpaClaimQueries;
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
	 * @return the doiJpaClaimRejects
	 */
	public List<DoiJpaClaimRejectEntity> getDoiJpaClaimRejects() {
		return doiJpaClaimRejects;
	}

	/**
	 * @param doiJpaClaimRejects the doiJpaClaimRejects to set
	 */
	public void setDoiJpaClaimRejects(List<DoiJpaClaimRejectEntity> doiJpaClaimRejects) {
		this.doiJpaClaimRejects = doiJpaClaimRejects;
	}

}