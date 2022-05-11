package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.util.PvuUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * The Class PVUSSPPrintDto.
 */

public class PVUCASPrintDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	private long employeeNo;
	private String salutation;
	private String firstName;
	private String middleName;
	private String surname;
	private String designation;
	private String officeName;
	private Integer years;
	private String gender;
	private String eventName;
	private String eventEffectiveDate;
	private String genderHisHerPrefix;
	private String genderHeShePrefix;
	private Long basicPay;
	private Long personalPay;
	private String optionDate;
	private String payScaleValue;
	private String dateOfNextIncrement ;
	private String printDate;
	private String rePrintDate;
	private Long reprintCount;
	private String authorizedByName;
	private String currentScaleName;
	private String scaleName;
	private Long currentPayBandValue;
	private String currentGradePay;
	private String currentPayBand;
	private Long payBandValue;
	private String gradePay;
	private String payBand;
	private String currentPayLevel;
	private String payLevel;
	private String authorizedBy;
	private String authorizerRemark;
	private Integer cellIdValue;
	private Long cellName;
	private String rePrintRemark;
	
	public String getRePrintRemark() {
		return rePrintRemark;
	}

	public void setRePrintRemark(String rePrintRemark) {
		this.rePrintRemark = rePrintRemark;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	public void setEventEffectiveDate(String eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	public String getGenderHisHerPrefix() {
		return genderHisHerPrefix;
	}

	public void setGenderHisHerPrefix(String genderHisHerPrefix) {
		this.genderHisHerPrefix = genderHisHerPrefix;
	}

	public String getGenderHeShePrefix() {
		return genderHeShePrefix;
	}

	public void setGenderHeShePrefix(String genderHeShePrefix) {
		this.genderHeShePrefix = genderHeShePrefix;
	}

	public Long getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	public Long getPersonalPay() {
		return personalPay;
	}

	public void setPersonalPay(Long personalPay) {
		this.personalPay = personalPay;
	}

	public String getOptionDate() {
		return optionDate;
	}

	public void setOptionDate(String optionDate) {
		this.optionDate = optionDate;
	}

	public String getPayScaleValue() {
		return payScaleValue;
	}

	public void setPayScaleValue(String payScaleValue) {
		this.payScaleValue = payScaleValue;
	}

	public String getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	public void setDateOfNextIncrement(String dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	public String getPrintDate() {
		return printDate;
	}

	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}

	public String getRePrintDate() {
		return rePrintDate;
	}

	public void setRePrintDate(String rePrintDate) {
		this.rePrintDate = rePrintDate;
	}

	public Long getReprintCount() {
		return reprintCount;
	}

	public void setReprintCount(Long reprintCount) {
		this.reprintCount = reprintCount;
	}

	public String getAuthorizedByName() {
		return authorizedByName;
	}

	public void setAuthorizedByName(String authorizedByName) {
		this.authorizedByName = authorizedByName;
	}

	public String getCurrentScaleName() {
		return currentScaleName;
	}

	public void setCurrentScaleName(String currentScaleName) {
		this.currentScaleName = currentScaleName;
	}

	public String getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	public Long getCurrentPayBandValue() {
		return currentPayBandValue;
	}

	public void setCurrentPayBandValue(Long currentPayBandValue) {
		this.currentPayBandValue = currentPayBandValue;
	}

	public String getCurrentGradePay() {
		return currentGradePay;
	}

	public void setCurrentGradePay(String currentGradePay) {
		this.currentGradePay = currentGradePay;
	}

	public String getCurrentPayBand() {
		return currentPayBand;
	}

	public void setCurrentPayBand(String currentPayBand) {
		this.currentPayBand = currentPayBand;
	}

	public Long getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	public String getGradePay() {
		return gradePay;
	}

	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	public String getPayBand() {
		return payBand;
	}

	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	public String getCurrentPayLevel() {
		return currentPayLevel;
	}

	public void setCurrentPayLevel(String currentPayLevel) {
		this.currentPayLevel = currentPayLevel;
	}

	public String getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}

	public String getAuthorizedBy() {
		return authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public String getAuthorizerRemark() {
		return authorizerRemark;
	}

	public void setAuthorizerRemark(String authorizerRemark) {
		this.authorizerRemark = authorizerRemark;
	}

	public Integer getCellIdValue() {
		return cellIdValue;
	}

	public void setCellIdValue(Integer cellIdValue) {
		this.cellIdValue = cellIdValue;
	}

	public Long getCellName() {
		return cellName;
	}

	public void setCellName(Long cellName) {
		this.cellName = cellName;
	}

	public PVUCASPrintDto(Date printDate, Date rePrintDate, Long printCount) {
		this.printDate = PvuUtils.getStrOfLocalDateInDDMMYYYY(PvuUtils.convertLocalDate(printDate));
		this.rePrintDate = rePrintDate != null ? PvuUtils.getStrOfLocalDateInDDMMYYYY(PvuUtils.convertLocalDate(rePrintDate)) : "";
		this.reprintCount = printCount - 1;
	}
}
