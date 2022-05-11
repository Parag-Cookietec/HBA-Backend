package gov.ifms.gst.dto;

import gov.ifms.gst.util.GSTUtility;

import java.io.Serializable;
import java.time.LocalDate;

public class GSTBankRateMasterDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The bankRate. */
	private Double bankRate;

	/** The additionalRate. */
	private Double additionalRate;

	/** The panaltyRate. */
	private Double panaltyRate;

	/** The effectiveFromDate. */
	private LocalDate effectiveFromDate;

	/** The effectiveToDate. */
	private LocalDate effectiveToDate;

	/** The referenceNumber. */
	private String referenceNumber;

	/** The referenceDate. */
	private LocalDate referenceDate;

	/** The menuId. */
	private Long menuId;
	
	private int activeStatus;

	private int isEditable=1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBankRate() {
		return GSTUtility.roundUpDoubleValue(bankRate);
	}

	public void setBankRate(Double bankRate) {
		this.bankRate = bankRate;
	}

	public Double getAdditionalRate() {
		return GSTUtility.roundUpDoubleValue(additionalRate);
	}

	public void setAdditionalRate(Double additionalRate) {
		this.additionalRate = additionalRate;
	}

	public Double getPanaltyRate() {
		return GSTUtility.roundUpDoubleValue(panaltyRate);
	}

	public void setPanaltyRate(Double panaltyRate) {
		this.panaltyRate = panaltyRate;
	}

	public LocalDate getEffectiveFromDate() {
		return effectiveFromDate;
	}

	public void setEffectiveFromDate(LocalDate effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}

	public LocalDate getEffectiveToDate() {
		return effectiveToDate;
	}

	public void setEffectiveToDate(LocalDate effectiveToDate) {
		this.effectiveToDate = effectiveToDate;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		this.referenceDate = referenceDate;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public int getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}
}
