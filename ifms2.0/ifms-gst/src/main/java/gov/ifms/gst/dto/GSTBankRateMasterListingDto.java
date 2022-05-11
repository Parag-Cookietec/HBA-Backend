package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.gst.util.GSTUtility;

import java.io.Serializable;
import java.time.LocalDate;

@NativeQueryResultEntity
public class GSTBankRateMasterListingDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The referenceNumber. */
	@NativeQueryResultColumn(index = 1)
	private String referenceNumber;

	/** The referenceDate. */
	@NativeQueryResultColumn(index = 2)
	private String referenceDate;

	/** The effectiveFromDate. */
	@NativeQueryResultColumn(index = 3)
	private String effectiveFromDate;

	/** The effectiveToDate. */
	@NativeQueryResultColumn(index = 4)
	private String effectiveToDate;

	/** The bankRate. */
	@NativeQueryResultColumn(index = 5)
	private Double bankRate;

	/** The additionalRate. */
	@NativeQueryResultColumn(index = 6)
	private Double additionalRate;

	/** The panaltyRate. */
	@NativeQueryResultColumn(index = 7)
	private Double panaltyRate;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 8)
	private String trnStatus;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 9)
	private String wfStatus;

	@NativeQueryResultColumn(index = 10)
	private int isEditable;

	@NativeQueryResultColumn(index = 11)
	private int totalRecords;

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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(String referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getEffectiveFromDate() {
		return effectiveFromDate;
	}

	public void setEffectiveFromDate(String effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}

	public String getEffectiveToDate() {
		return effectiveToDate;
	}

	public void setEffectiveToDate(String effectiveToDate) {
		this.effectiveToDate = effectiveToDate;
	}
}
