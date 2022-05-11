package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeShettyPayDto.
 *
 * @version v 1.0
 * @created 2020/01/06 12:53:37
 *
 */
/**
 * @author HP
 *
 */
public class PVUSelectiongGradePostDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private LocalDate eventEffectiveDate;

	private String payLevelId;

	/** The trn no. */
	private String trnNo;

	private String cellId;

	/** The employee no. */
	private String employeeNo;

	/** The event code. */
	private String eventCode;

	/** The office id. */
	private String personalPay;

	private String dateOfNextIncrement;

	private String officeId;

	private String payCommId;

	private String basicPay;

	private String eventOrderDate;

	private String benefitEffectiveDate;

	private String eventOrderNo;

	private String remarks;

	private String payBandId;

	private String payBandValue;

	private String gradePayId;

	private String payScale;

	private String retirementDate;
	
	private String designationId;
	
	private LocalDateTime refDate;

	/**
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * @return the payLevelId
	 */
	public String getPayLevelId() {
		return payLevelId;
	}

	/**
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the cellId
	 */
	public String getCellId() {
		return cellId;
	}

	/**
	 * @param cellId the cellId to set
	 */
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * @param employeeNo the employeeNo to set
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * @return the personalPay
	 */
	public String getPersonalPay() {
		return personalPay;
	}

	/**
	 * @param personalPay the personalPay to set
	 */
	public void setPersonalPay(String personalPay) {
		this.personalPay = personalPay;
	}

	/**
	 * @return the dateOfNextIncrement
	 */
	public String getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(String dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * @return the officeId
	 */
	public String getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the payCommId
	 */
	public String getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(String payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the basicPay
	 */
	public String getBasicPay() {
		return basicPay;
	}

	/**
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * @return the eventOrderDate
	 */
	public String getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(String eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * @return the benefitEffectiveDate
	 */
	public String getBenefitEffectiveDate() {
		return benefitEffectiveDate;
	}

	/**
	 * @param benefitEffectiveDate the benefitEffectiveDate to set
	 */
	public void setBenefitEffectiveDate(String benefitEffectiveDate) {
		this.benefitEffectiveDate = benefitEffectiveDate;
	}

	/**
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the payBandValue
	 */
	public String getPayBandValue() {
		return payBandValue;
	}

	/**
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * @return the retirementDate
	 */
	public String getRetirementDate() {
		return retirementDate;
	}

	/**
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(String retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * @return the payBandId
	 */
	public String getPayBandId() {
		return payBandId;
	}

	/**
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * @return the gradePayId
	 */
	public String getGradePayId() {
		return gradePayId;
	}

	/**
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(String gradePayId) {
		this.gradePayId = gradePayId;
	}

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	
	/**
	 * @return the refDate
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(basicPay, benefitEffectiveDate, cellId, dateOfNextIncrement, designationId, employeeNo,
						eventCode, eventEffectiveDate, eventOrderDate, eventOrderNo, gradePayId, officeId, payBandId,
						payBandValue, payCommId, payLevelId, payScale, personalPay, remarks, retirementDate, trnNo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUSelectiongGradePostDetailDto)) {
			return false;
		}
		PVUSelectiongGradePostDetailDto other = (PVUSelectiongGradePostDetailDto) obj;
		return Objects.equals(basicPay, other.basicPay)
				&& Objects.equals(benefitEffectiveDate, other.benefitEffectiveDate)
				&& Objects.equals(cellId, other.cellId)
				&& Objects.equals(dateOfNextIncrement, other.dateOfNextIncrement)
				&& Objects.equals(designationId, other.designationId) && Objects.equals(employeeNo, other.employeeNo)
				&& Objects.equals(eventCode, other.eventCode)
				&& Objects.equals(eventEffectiveDate, other.eventEffectiveDate)
				&& Objects.equals(eventOrderDate, other.eventOrderDate)
				&& Objects.equals(eventOrderNo, other.eventOrderNo) && Objects.equals(gradePayId, other.gradePayId)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(payBandId, other.payBandId)
				&& Objects.equals(payBandValue, other.payBandValue) && Objects.equals(payCommId, other.payCommId)
				&& Objects.equals(payLevelId, other.payLevelId) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(personalPay, other.personalPay) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(retirementDate, other.retirementDate) && Objects.equals(trnNo, other.trnNo);
	}
	
	
}
