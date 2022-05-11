package gov.ifms.pvu.dto.response;

import gov.ifms.pvu.util.PvuUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class PVUSSPPrintDto.
 */

public class PVUSSPPrintDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The emp id.
	 */
	private long employeeNo;
	private String employeeName;
	private String designation;
	private String officeName;
	
	private Long basicPay;
	
	private String currentScaleName;
	private String scaleName;
	
	private Long currentPayBandValue;
	private Long payBandValue;
	private String currentGradePay;
	private String gradePay;
	private String currentPayBand;
	private String payBand;
	
	private String currentPayLevel;
	private String payLevel;
	private String currentCellId;
	private int cellId;
	private long cellIdValue;
	
	
	private String genderHeShePrefix;
	private String eventType;
	
	private String eventEffectiveDate;
	private String genderHisHerPrefix;
	
	private Long personalPay;
	
	private String dni;
	private String printDate;
	private String rePrintDate;
	private Long reprintCount;
	
	private String authorizedBy;
	private String authorizerRemark;
	private String rePrintRemark;
	
	
	
	
	public long getCellIdValue() {
		return cellIdValue;
	}

	public void setCellIdValue(long cellIdValue) {
		this.cellIdValue = cellIdValue;
	}

	public String getCurrentCellId() {
		return currentCellId;
	}

	public void setCurrentCellId(String currentCellId) {
		this.currentCellId = currentCellId;
	}

	

	public int getCellId() {
		return cellId;
	}

	public void setCellId(int cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the rePrintRemark
	 */
	public String getRePrintRemark() {
		return rePrintRemark;
	}

	/**
	 * @param rePrintRemark the rePrintRemark to set
	 */
	public void setRePrintRemark(String rePrintRemark) {
		this.rePrintRemark = rePrintRemark;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	public String getCurrentPayLevel() {
		return currentPayLevel;
	}

	public void setCurrentPayLevel(String currentPayLevel) {
		this.currentPayLevel = currentPayLevel;
	}

	public String getGenderHeShePrefix() {
		return genderHeShePrefix;
	}

	public void setGenderHeShePrefix(String genderHeShePrefix) {
		this.genderHeShePrefix = genderHeShePrefix;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
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

	public PVUSSPPrintDto(Date printDate, Date rePrintDate, Long printCount) {
		this.printDate = PvuUtils.getStrOfLocalDateInDDMMYYYY(PvuUtils.convertLocalDate(printDate));
		this.rePrintDate = rePrintDate != null ? PvuUtils.getStrOfLocalDateInDDMMYYYY(PvuUtils.convertLocalDate(rePrintDate)) : "";
		this.reprintCount = printCount - 1;
	}

	public PVUSSPPrintDto() {
	}
}
