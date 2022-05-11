package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_SURVEYOR_BILL_DTLS database table.
 * 
 */
public class TdoiSurveyorBillDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long surveyorBillId;

	private String claimNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private double surveyBillAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date surveyBillDt;

	private String surveyBillNo;

	private String surveyBranch;

	private String surveyorName;

	private String surveyrAppointFor;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date transactionDt;

	private String transactionNo;

	private long workflowStatusId;

	private TdoiSurveyorDtlDTO tdoiSurveyorDtl;

	private List<TdoiSurveyorDtlDTO> tdoiSurveyorBillWfs;

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
	public TdoiSurveyorDtlDTO getTdoiSurveyorDtl() {
		return tdoiSurveyorDtl;
	}

	/**
	 * @param tdoiSurveyorDtl the tdoiSurveyorDtl to set
	 */
	public void setTdoiSurveyorDtl(TdoiSurveyorDtlDTO tdoiSurveyorDtl) {
		this.tdoiSurveyorDtl = tdoiSurveyorDtl;
	}

	/**
	 * @return the tdoiSurveyorBillWfs
	 */
	public List<TdoiSurveyorDtlDTO> getTdoiSurveyorBillWfs() {
		return tdoiSurveyorBillWfs;
	}

	/**
	 * @param tdoiSurveyorBillWfs the tdoiSurveyorBillWfs to set
	 */
	public void setTdoiSurveyorBillWfs(List<TdoiSurveyorDtlDTO> tdoiSurveyorBillWfs) {
		this.tdoiSurveyorBillWfs = tdoiSurveyorBillWfs;
	}

}
