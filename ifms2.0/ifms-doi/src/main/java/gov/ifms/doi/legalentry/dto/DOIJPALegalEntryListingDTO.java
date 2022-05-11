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
public class DOIJPALegalEntryListingDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 816478610896162678L;

	private long district;
	
	private long inwardNo;
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date inwardDate;
	
	private String courtCaseNo; 
	
	private String claimNumber; 
	
	private long courtDetails; //courtTypeId
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	private Date dateOfAccident; 
	
	private String applicantName;

	/**
	 * @return the district
	 */
	public long getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(long district) {
		this.district = district;
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
	 * @return the inwardDate
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * @param inwardDate the inwardDate to set
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
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
	 * @return the dateOfAccident
	 */
	public Date getDateOfAccident() {
		return dateOfAccident;
	}

	/**
	 * @param dateOfAccident the dateOfAccident to set
	 */
	public void setDateOfAccident(Date dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
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
}
