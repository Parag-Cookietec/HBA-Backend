package gov.ifms.edp.report.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The Class CommonDesignMasterDto.
 * 
 * @version 1.0
 * @created 2021/02/23 13:37:15
 *
 */
public class CommonDesignMasterDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The design master id. */
	@NotNull
	private Long designMasterId;

	/** The report id. */
	@NotNull
	private Long reportId;

	/** The display name. */
	@NotNull
	private String displayName;

	/** The display key. */
	@NotNull
	private String displayKey;

	/** The display value. */
	@NotNull
	private String displayValue;

	/** The type. */
	@NotNull
	private Long type;

	/**
	 * CommonDesignMasterDto Constructor.
	 */
	public CommonDesignMasterDto() {
		super();
	}

	/**
	 * Gets the design master id.
	 *
	 * @return the designMasterId
	 */
	public Long getDesignMasterId() {
		return designMasterId;
	}

	/**
	 * Sets the design master id.
	 *
	 * @param designMasterId the designMasterId to set
	 */
	public void setDesignMasterId(Long designMasterId) {
		this.designMasterId = designMasterId;
	}

	/**
	 * Gets the report id.
	 *
	 * @return the reportId
	 */
	public Long getReportId() {
		return reportId;
	}

	/**
	 * Sets the report id.
	 *
	 * @param reportId the reportId to set
	 */
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Gets the display key.
	 *
	 * @return the displayKey
	 */
	public String getDisplayKey() {
		return displayKey;
	}

	/**
	 * Sets the display key.
	 *
	 * @param displayKey the displayKey to set
	 */
	public void setDisplayKey(String displayKey) {
		this.displayKey = displayKey;
	}

	/**
	 * Gets the display value.
	 *
	 * @return the displayValue
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * Sets the display value.
	 *
	 * @param displayValue the displayValue to set
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public Long getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(Long type) {
		this.type = type;
	}

}
