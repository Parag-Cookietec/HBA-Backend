package gov.ifms.edp.report.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CommonFieldMasterDto.
 * 
 * @version 1.0
 * @created 2021/02/23 13:41:52
 *
 */
@JsonInclude(Include.NON_NULL)
public class CommonFieldMasterDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The field master id. */
	@NotNull
	private Long fieldMasterId;

	/** The report id. */
	@NotNull
	private Long reportId;

	/** The param ui name. */
	@NotNull
	private String paramUiName;

	/** The param proc name. */
	@NotNull
	private String paramProcName;

	/** The param disp name. */
	@NotNull
	private String paramDispName;

	/** The param type. */
	@NotNull
	private String paramType;

	/** The column size. */
	@NotNull
	private Long columnSize;

	/** The order no. */
	@NotNull
	private Long orderNo;

	/** The is sum. */
	@NotNull
	private Long isSum;

	/** The is required. */
	@NotNull
	private Long isRequired;

	/** The css. */
	private String css;
	
	/** The type. */
	private String type;
	
	/** The disp order no. */
	private Long dispOrderNo;
	
	/** The regex. */
	private String regex;
	
	/** The html type. */
	private String htmlType;

	/**
	 * CommonFieldMasterDto Constructor.
	 */
	public CommonFieldMasterDto() {
		super();
	}

	/**
	 * Gets the field master id.
	 *
	 * @return the fieldMasterId
	 */
	public Long getFieldMasterId() {
		return fieldMasterId;
	}

	/**
	 * Sets the field master id.
	 *
	 * @param fieldMasterId the fieldMasterId to set
	 */
	public void setFieldMasterId(Long fieldMasterId) {
		this.fieldMasterId = fieldMasterId;
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
	 * Gets the param ui name.
	 *
	 * @return the paramUiName
	 */
	public String getParamUiName() {
		return paramUiName;
	}

	/**
	 * Sets the param ui name.
	 *
	 * @param paramUiName the paramUiName to set
	 */
	public void setParamUiName(String paramUiName) {
		this.paramUiName = paramUiName;
	}

	/**
	 * Gets the param proc name.
	 *
	 * @return the paramProcName
	 */
	public String getParamProcName() {
		return paramProcName;
	}

	/**
	 * Sets the param proc name.
	 *
	 * @param paramProcName the paramProcName to set
	 */
	public void setParamProcName(String paramProcName) {
		this.paramProcName = paramProcName;
	}

	/**
	 * Gets the param disp name.
	 *
	 * @return the paramDispName
	 */
	public String getParamDispName() {
		return paramDispName;
	}

	/**
	 * Sets the param disp name.
	 *
	 * @param paramDispName the paramDispName to set
	 */
	public void setParamDispName(String paramDispName) {
		this.paramDispName = paramDispName;
	}

	/**
	 * Gets the param type.
	 *
	 * @return the paramType
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * Sets the param type.
	 *
	 * @param paramType the paramType to set
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * Gets the column size.
	 *
	 * @return the columnSize
	 */
	public Long getColumnSize() {
		return columnSize;
	}

	/**
	 * Sets the column size.
	 *
	 * @param columnSize the columnSize to set
	 */
	public void setColumnSize(Long columnSize) {
		this.columnSize = columnSize;
	}

	/**
	 * Gets the order no.
	 *
	 * @return the orderNo
	 */
	public Long getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the checks if is sum.
	 *
	 * @return the isSum
	 */
	public Long getIsSum() {
		return isSum;
	}

	/**
	 * Sets the checks if is sum.
	 *
	 * @param isSum the isSum to set
	 */
	public void setIsSum(Long isSum) {
		this.isSum = isSum;
	}

	/**
	 * Gets the checks if is required.
	 *
	 * @return the isRequired
	 */
	public Long getIsRequired() {
		return isRequired;
	}

	/**
	 * Sets the checks if is required.
	 *
	 * @param isRequired the isRequired to set
	 */
	public void setIsRequired(Long isRequired) {
		this.isRequired = isRequired;
	}

	/**
	 * Gets the css.
	 *
	 * @return the css
	 */
	public String getCss() {
		return css;
	}

	/**
	 * Sets the css.
	 *
	 * @param css the css to set
	 */
	public void setCss(String css) {
		this.css = css;
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
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the disp order no.
	 *
	 * @return the disp order no
	 */
	public Long getDispOrderNo() {
		return dispOrderNo;
	}

	/**
	 * Sets the disp order no.
	 *
	 * @param dispOrderNo the new disp order no
	 */
	public void setDispOrderNo(Long dispOrderNo) {
		this.dispOrderNo = dispOrderNo;
	}

	/**
	 * Gets the regex.
	 *
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * Sets the regex.
	 *
	 * @param regex the new regex
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/**
	 * Gets the html type.
	 *
	 * @return the html type
	 */
	public String getHtmlType() {
		return htmlType;
	}

	/**
	 * Sets the html type.
	 *
	 * @param htmlType the new html type
	 */
	public void setHtmlType(String htmlType) {
		this.htmlType = htmlType;
	}

}
