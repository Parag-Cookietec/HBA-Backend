package gov.ifms.edp.report.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class CommonDesignMasterEntity.
 * 
 * @version 1.0
 * @created 2021/02/23 13:37:15
 *
 */
@Entity
@Table(name = "DESIGN_MASTER", schema = "DUMMY")
public class CommonDesignMasterEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The design master id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DESIGN_MASTER_ID")
	private Long designMasterId;

	/** The report id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_ID", referencedColumnName = "REPORT_ID")
	private CommonReportMasterEntity reportId;

	/** The display name. */
	@Column(name = "DISPLAY_NAME")
	private String displayName;

	/** The display key. */
	@Column(name = "DISPLAY_KEY")
	private String displayKey;

	/** The display value. */
	@Column(name = "DISPLAY_VALUE")
	private String displayValue;

	/** The type. */
	@Column(name = "TYPE")
	private String type;

	/**
	 * CommonDesignMasterDto Constructor.
	 */
	public CommonDesignMasterEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(designMasterId, reportId, displayName, displayKey, displayValue, type);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CommonDesignMasterEntity)) {
			return false;
		}

		CommonDesignMasterEntity other = (CommonDesignMasterEntity) obj;

		return Objects.equals(designMasterId, other.designMasterId) && Objects.equals(reportId, other.reportId)
				&& Objects.equals(displayName, other.displayName) && Objects.equals(displayKey, other.displayKey)
				&& Objects.equals(displayValue, other.displayValue) && Objects.equals(type, other.type);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CommonDesignMasterEntity [designMasterId = " + designMasterId + ",reportId = " + reportId
				+ ",displayName = " + displayName + ",displayKey = " + displayKey + ",displayValue = " + displayValue
				+ ",type = " + type + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the design master id
	 */

	/**
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
	public CommonReportMasterEntity getReportId() {
		return reportId;
	}

	/**
	 * Sets the report id.
	 *
	 * @param reportId the reportId to set
	 */
	public void setReportId(CommonReportMasterEntity reportId) {
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
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
