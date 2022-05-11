package gov.ifms.doi.hba.dto;

import java.sql.Timestamp;
import java.util.List;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_SURVEYOR_DTL database table.
 * 
 */
public class TdoiSurveyorDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long surveyorId;

	private long aadharNum;

	private long accountNo;

	private long bankId;

	private long branchId;

	private String city;

	private String contactNumber;

	private long districtId;

	private String emailId;

	private String firmAddress;

	private String ifscCode;

	private String panNum;

	private long paymentModeId;

	private long pincode;

	private Timestamp referenceDt;

	private String referenceNo;

	private String surveyFirmName;

	private String surveyorName;

	private long talukaId;

	private List<TdoiSurveyorBillDtlDTO> tdoiSurveyorBillDtls;

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
	 * @return the aadharNum
	 */
	public long getAadharNum() {
		return aadharNum;
	}

	/**
	 * @param aadharNum the aadharNum to set
	 */
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	/**
	 * @return the accountNo
	 */
	public long getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the bankId
	 */
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the branchId
	 */
	public long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the firmAddress
	 */
	public String getFirmAddress() {
		return firmAddress;
	}

	/**
	 * @param firmAddress the firmAddress to set
	 */
	public void setFirmAddress(String firmAddress) {
		this.firmAddress = firmAddress;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the panNum
	 */
	public String getPanNum() {
		return panNum;
	}

	/**
	 * @param panNum the panNum to set
	 */
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}

	/**
	 * @return the paymentModeId
	 */
	public long getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @param paymentModeId the paymentModeId to set
	 */
	public void setPaymentModeId(long paymentModeId) {
		this.paymentModeId = paymentModeId;
	}

	/**
	 * @return the pincode
	 */
	public long getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(long pincode) {
		this.pincode = pincode;
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
	 * @return the surveyFirmName
	 */
	public String getSurveyFirmName() {
		return surveyFirmName;
	}

	/**
	 * @param surveyFirmName the surveyFirmName to set
	 */
	public void setSurveyFirmName(String surveyFirmName) {
		this.surveyFirmName = surveyFirmName;
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
	 * @return the talukaId
	 */
	public long getTalukaId() {
		return talukaId;
	}

	/**
	 * @param talukaId the talukaId to set
	 */
	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	/**
	 * @return the tdoiSurveyorBillDtls
	 */
	public List<TdoiSurveyorBillDtlDTO> getTdoiSurveyorBillDtls() {
		return tdoiSurveyorBillDtls;
	}

	/**
	 * @param tdoiSurveyorBillDtls the tdoiSurveyorBillDtls to set
	 */
	public void setTdoiSurveyorBillDtls(List<TdoiSurveyorBillDtlDTO> tdoiSurveyorBillDtls) {
		this.tdoiSurveyorBillDtls = tdoiSurveyorBillDtls;
	}

}
