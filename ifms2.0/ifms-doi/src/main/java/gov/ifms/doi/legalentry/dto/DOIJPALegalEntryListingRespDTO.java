/**
 * 
 */
package gov.ifms.doi.legalentry.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Rudra
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class DOIJPALegalEntryListingRespDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 816478610896162678L;

	private long districtId;
	
	private String districtName;
	
	private long inwardNo;
	
	//@JsonFormat(pattern="dd-MMM-yyyy")
	private Date inwardDt;
	
	private String courtCaseNo;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date courtCaseDt;
	
	private long courtTypeId;
	
	private long courtDetails;
	
	private String claimNumber;
	
	private String policyNum;
	
	private long schemeId;
	
	private String schemeName;
	
	private String applicantName;
	
	private String deadPersonName;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date accidentDeathDt;
	
	private String queryDetails;
	
	private String courtDecision;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm")
	private Date createdDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm")
	private Date updatedDate;
	
	private long orderStatusId;
	
	private String orderStatus;
	
	private long legalEntryId;
	
	private long legalDtlsId;
	
	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	private int activeStatus;

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
	 * @return the courtTypeId
	 */
	public long getCourtTypeId() {
		return courtTypeId;
	}

	/**
	 * @param courtTypeId the courtTypeId to set
	 */
	public void setCourtTypeId(long courtTypeId) {
		this.courtTypeId = courtTypeId;
	}

	/**
	 * @return the courtDetails
	 */
	public long getCourtDetails() {
		return courtDetails;
	}

	/**
	 * @param courtDetails the courtDetails to set
	 */
	public void setCourtDetails(long courtDetails) {
		this.courtDetails = courtDetails;
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
	 * @return the schemeId
	 */
	public long getSchemeId() {
		return schemeId;
	}

	/**
	 * @param schemeId the schemeId to set
	 */
	public void setSchemeId(long schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * @return the schemeName
	 */
	public String getSchemeName() {
		return schemeName;
	}

	/**
	 * @param schemeName the schemeName to set
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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
	 * @return the queryDetails
	 */
	public String getQueryDetails() {
		return queryDetails;
	}

	/**
	 * @param queryDetails the queryDetails to set
	 */
	public void setQueryDetails(String queryDetails) {
		this.queryDetails = queryDetails;
	}

	/**
	 * @return the courtDecision
	 */
	public String getCourtDecision() {
		return courtDecision;
	}

	/**
	 * @param courtDecision the courtDecision to set
	 */
	public void setCourtDecision(String courtDecision) {
		this.courtDecision = courtDecision;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the orderStatusId
	 */
	public long getOrderStatusId() {
		return orderStatusId;
	}

	/**
	 * @param orderStatusId the orderStatusId to set
	 */
	public void setOrderStatusId(long orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	 * @return the legalDtlsId
	 */
	public long getLegalDtlsId() {
		return legalDtlsId;
	}

	/**
	 * @param legalDtlsId the legalDtlsId to set
	 */
	public void setLegalDtlsId(long legalDtlsId) {
		this.legalDtlsId = legalDtlsId;
	}
}
