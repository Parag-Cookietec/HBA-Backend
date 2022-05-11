package gov.ifms.doi.hba.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_SURVEYOR_BILL_DTLS database table.
 * 
 */
@Entity
@Table(name = "TDOI_SURVEYOR_BILL_DTLS", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiSurveyorBillDtlEntity.findAll", query = "SELECT t FROM TdoiSurveyorBillDtlEntity t")
public class TdoiSurveyorBillDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SURVEYOR_BILL_ID", unique = true, nullable = false)
	private long surveyorBillId;

	@Column(name = "CLAIM_NO", length = 60)
	private String claimNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SURVEY_BILL_AMT")
	private double surveyBillAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "SURVEY_BILL_DT")
	private Date surveyBillDt;

	@Column(name = "SURVEY_BILL_NO", length = 30)
	private String surveyBillNo;

	@Column(name = "SURVEY_BRANCH", length = 60)
	private String surveyBranch;

	@Column(name = "SURVEYOR_NAME", nullable = false, length = 100)
	private String surveyorName;

	@Column(name = "SURVEYR_APPOINT_FOR", length = 10)
	private String surveyrAppointFor;

	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSACTION_DT")
	private Date transactionDt;

	@Column(name = "TRANSACTION_NO", length = 30)
	private String transactionNo;

	@Column(name = "WORKFLOW_STATUS_ID")
	private long workflowStatusId;

	// bi-directional many-to-one association to TdoiSurveyorDtl
	@ManyToOne
	@JoinColumn(name = "SURVEYOR_ID", nullable = false)
	@JsonBackReference
	private TdoiSurveyorDtlEntity tdoiSurveyorDtl;

	// bi-directional many-to-one association to TdoiSurveyorBillWf
	@OneToMany(mappedBy = "surveyorBillWfId")
	@JsonManagedReference
	private List<TdoiSurveyorBillWfEntity> tdoiSurveyorBillWfs;

	/**
	 * @return the surveyorBillId
	 */
	public long getSurveyorBillId() {
		return surveyorBillId;
	}

	/**
	 * @param surveyorBillId the surveyorBillId to set
	 */
	public void setSurveyorBillId(long surveyorBillId) {
		this.surveyorBillId = surveyorBillId;
	}

	/**
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * @return the referenceDt
	 */
	public Date getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Date referenceDt) {
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
	 * @return the surveyBillAmt
	 */
	public double getSurveyBillAmt() {
		return surveyBillAmt;
	}

	/**
	 * @param surveyBillAmt the surveyBillAmt to set
	 */
	public void setSurveyBillAmt(double surveyBillAmt) {
		this.surveyBillAmt = surveyBillAmt;
	}

	/**
	 * @return the surveyBillDt
	 */
	public Date getSurveyBillDt() {
		return surveyBillDt;
	}

	/**
	 * @param surveyBillDt the surveyBillDt to set
	 */
	public void setSurveyBillDt(Date surveyBillDt) {
		this.surveyBillDt = surveyBillDt;
	}

	/**
	 * @return the surveyBillNo
	 */
	public String getSurveyBillNo() {
		return surveyBillNo;
	}

	/**
	 * @param surveyBillNo the surveyBillNo to set
	 */
	public void setSurveyBillNo(String surveyBillNo) {
		this.surveyBillNo = surveyBillNo;
	}

	/**
	 * @return the surveyBranch
	 */
	public String getSurveyBranch() {
		return surveyBranch;
	}

	/**
	 * @param surveyBranch the surveyBranch to set
	 */
	public void setSurveyBranch(String surveyBranch) {
		this.surveyBranch = surveyBranch;
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
	 * @return the surveyrAppointFor
	 */
	public String getSurveyrAppointFor() {
		return surveyrAppointFor;
	}

	/**
	 * @param surveyrAppointFor the surveyrAppointFor to set
	 */
	public void setSurveyrAppointFor(String surveyrAppointFor) {
		this.surveyrAppointFor = surveyrAppointFor;
	}

	/**
	 * @return the transactionDt
	 */
	public Date getTransactionDt() {
		return transactionDt;
	}

	/**
	 * @param transactionDt the transactionDt to set
	 */
	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	/**
	 * @return the transactionNo
	 */
	public String getTransactionNo() {
		return transactionNo;
	}

	/**
	 * @param transactionNo the transactionNo to set
	 */
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	/**
	 * @return the workflowStatusId
	 */
	public long getWorkflowStatusId() {
		return workflowStatusId;
	}

	/**
	 * @param workflowStatusId the workflowStatusId to set
	 */
	public void setWorkflowStatusId(long workflowStatusId) {
		this.workflowStatusId = workflowStatusId;
	}

	/**
	 * @return the tdoiSurveyorDtl
	 */
	public TdoiSurveyorDtlEntity getTdoiSurveyorDtl() {
		return tdoiSurveyorDtl;
	}

	/**
	 * @param tdoiSurveyorDtl the tdoiSurveyorDtl to set
	 */
	public void setTdoiSurveyorDtl(TdoiSurveyorDtlEntity tdoiSurveyorDtl) {
		this.tdoiSurveyorDtl = tdoiSurveyorDtl;
	}

	/**
	 * @return the tdoiSurveyorBillWfs
	 */
	public List<TdoiSurveyorBillWfEntity> getTdoiSurveyorBillWfs() {
		return tdoiSurveyorBillWfs;
	}

	/**
	 * @param tdoiSurveyorBillWfs the tdoiSurveyorBillWfs to set
	 */
	public void setTdoiSurveyorBillWfs(List<TdoiSurveyorBillWfEntity> tdoiSurveyorBillWfs) {
		this.tdoiSurveyorBillWfs = tdoiSurveyorBillWfs;
	}

}
