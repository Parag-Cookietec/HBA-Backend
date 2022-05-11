package gov.ifms.edp.report.dto;

import java.io.Serializable;
import java.util.List;

/**
 * The Class CommonReportScreenDisplayResponseDto.
 */
public class CommonReportScreenDisplayResponseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The alias. */
	private String alias;
	
	/** The report name. */
	private String reportName;
	
	/** The field data. */
	private List<CommonReportFieldDataDto> fieldData;

	/**
	 * Gets the alias.
	 *
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the alias.
	 *
	 * @param alias the new alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Gets the report name.
	 *
	 * @return the report name
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * Sets the report name.
	 *
	 * @param reportName the new report name
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * Gets the field data.
	 *
	 * @return the field data
	 */
	public List<CommonReportFieldDataDto> getFieldData() {
		return fieldData;
	}

	/**
	 * Sets the field data.
	 *
	 * @param fieldData the new field data
	 */
	public void setFieldData(List<CommonReportFieldDataDto> fieldData) {
		this.fieldData = fieldData;
	}

}
