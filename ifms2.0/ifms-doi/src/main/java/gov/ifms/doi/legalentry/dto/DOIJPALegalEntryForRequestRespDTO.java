/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Rudra
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJPALegalEntryForRequestRespDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 816478610896162678L;

	private String courtCaseNo; 
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date courtCaseDt;
	
	private String claimNumber;
	
	private String policyNum;
	
	private long districtId;
	
	private String districtName;
	
	private String applicantName;
	
	private String deadPersonName;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date accidentDeathDt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm")
	private Date createdDateOn;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm")
	private Date modifiedDateOn;
	
	private String status;

	/**
	 * @return the courtCaseNo
	 */
	public String getCourtCaseNo() {
		return courtCaseNo;
	}

	/**
	 * @param courtCaseNo the courtCaseNo to set
	 */
	public void setCourtCaseNo(String courtCaseNo) {
		this.courtCaseNo = courtCaseNo;
	}

	/**
	 * @return the courtCaseDt
	 */
	public Date getCourtCaseDt() {
		return courtCaseDt;
	}

	/**
	 * @param courtCaseDt the courtCaseDt to set
	 */
	public void setCourtCaseDt(Date courtCaseDt) {
		this.courtCaseDt = courtCaseDt;
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
	 * @return the policyNum
	 */
	public String getPolicyNum() {
		return policyNum;
	}

	/**
	 * @param policyNum the policyNum to set
	 */
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	/**
	 * @return the districtId
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the deadPersonName
	 */
	public String getDeadPersonName() {
		return deadPersonName;
	}

	/**
	 * @param deadPersonName the deadPersonName to set
	 */
	public void setDeadPersonName(String deadPersonName) {
		this.deadPersonName = deadPersonName;
	}

	/**
	 * @return the accidentDeathDt
	 */
	public Date getAccidentDeathDt() {
		return accidentDeathDt;
	}

	/**
	 * @param accidentDeathDt the accidentDeathDt to set
	 */
	public void setAccidentDeathDt(Date accidentDeathDt) {
		this.accidentDeathDt = accidentDeathDt;
	}

	/**
	 * @return the createdDateOn
	 */
	public Date getCreatedDateOn() {
		return createdDateOn;
	}

	/**
	 * @param createdDateOn the createdDateOn to set
	 */
	public void setCreatedDateOn(Date createdDateOn) {
		this.createdDateOn = createdDateOn;
	}

	/**
	 * @return the modifiedDateOn
	 */
	public Date getModifiedDateOn() {
		return modifiedDateOn;
	}

	/**
	 * @param modifiedDateOn the modifiedDateOn to set
	 */
	public void setModifiedDateOn(Date modifiedDateOn) {
		this.modifiedDateOn = modifiedDateOn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
