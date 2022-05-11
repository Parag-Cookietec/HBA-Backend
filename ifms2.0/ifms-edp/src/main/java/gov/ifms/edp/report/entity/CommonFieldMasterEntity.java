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
 * The Class CommonFieldMasterEntity.
 * 
 * @version 1.0
 * @created 2021/02/23 13:41:52
 *
 */
@Entity
@Table(name = "FIELD_MASTER", schema = "DUMMY")
public class CommonFieldMasterEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The field master id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FIELD_MASTER_ID")
	private Long fieldMasterId;

	/** The report id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_ID", referencedColumnName = "REPORT_ID")
	private CommonReportMasterEntity reportId;

	/** The param ui name. */
	@Column(name = "PARAM_UI_NAME")
	private String paramUiName;

	/** The param proc name. */
	@Column(name = "PARAM_PROC_NAME")
	private String paramProcName;

	/** The param disp name. */
	@Column(name = "PARAM_DISP_NAME")
	private String paramDispName;

	/** The param type. */
	@Column(name = "PARAM_TYPE")
	private String paramType;

	/** The column size. */
	@Column(name = "COLUMN_SIZE")
	private Long columnSize;

	/** The order no. */
	@Column(name = "ORDER_NO")
	private Long orderNo;

	/** The is sum. */
	@Column(name = "IS_SUM")
	private Long isSum;

	/** The is required. */
	@Column(name = "IS_REQUIRED")
	private Long isRequired;

	/** The css. */
	@Column(name = "CSS")
	private String css;
	
	/** The type. */
	@Column(name = "TYPE")
	private String type;
	
	/** The disp order no. */
	@Column(name = "DISP_ORDER_NO")
	private Long dispOrderNo;
	
	/** The regex. */
	@Column(name = "REGEX")
	private String regex;
	
	/** The html type. */
	@Column(name = "HTML_TYPE")
	private String htmlType;
	
	/** The query. */
	@Column(name = "QUERY")
	private String query;

	/**
	 * CommonFieldMasterDto Constructor.
	 */
	public CommonFieldMasterEntity() {
		super();
	}

	/**
	 * Gets the field master id.
	 *
	 * @return the field master id
	 */
	public Long getFieldMasterId() {
		return fieldMasterId;
	}

	/**
	 * Sets the field master id.
	 *
	 * @param fieldMasterId the new field master id
	 */
	public void setFieldMasterId(Long fieldMasterId) {
		this.fieldMasterId = fieldMasterId;
	}

	/**
	 * Gets the report id.
	 *
	 * @return the report id
	 */
	public CommonReportMasterEntity getReportId() {
		return reportId;
	}

	/**
	 * Sets the report id.
	 *
	 * @param reportId the new report id
	 */
	public void setReportId(CommonReportMasterEntity reportId) {
		this.reportId = reportId;
	}

	/**
	 * Gets the param ui name.
	 *
	 * @return the param ui name
	 */
	public String getParamUiName() {
		return paramUiName;
	}

	/**
	 * Sets the param ui name.
	 *
	 * @param paramUiName the new param ui name
	 */
	public void setParamUiName(String paramUiName) {
		this.paramUiName = paramUiName;
	}

	/**
	 * Gets the param proc name.
	 *
	 * @return the param proc name
	 */
	public String getParamProcName() {
		return paramProcName;
	}

	/**
	 * Sets the param proc name.
	 *
	 * @param paramProcName the new param proc name
	 */
	public void setParamProcName(String paramProcName) {
		this.paramProcName = paramProcName;
	}

	/**
	 * Gets the param disp name.
	 *
	 * @return the param disp name
	 */
	public String getParamDispName() {
		return paramDispName;
	}

	/**
	 * Sets the param disp name.
	 *
	 * @param paramDispName the new param disp name
	 */
	public void setParamDispName(String paramDispName) {
		this.paramDispName = paramDispName;
	}

	/**
	 * Gets the param type.
	 *
	 * @return the param type
	 */
	public String getParamType() {
		return paramType;
	}

	/**
	 * Sets the param type.
	 *
	 * @param paramType the new param type
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * Gets the column size.
	 *
	 * @return the column size
	 */
	public Long getColumnSize() {
		return columnSize;
	}

	/**
	 * Sets the column size.
	 *
	 * @param columnSize the new column size
	 */
	public void setColumnSize(Long columnSize) {
		this.columnSize = columnSize;
	}

	/**
	 * Gets the order no.
	 *
	 * @return the order no
	 */
	public Long getOrderNo() {
		return orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the new order no
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * Gets the checks if is sum.
	 *
	 * @return the checks if is sum
	 */
	public Long getIsSum() {
		return isSum;
	}

	/**
	 * Sets the checks if is sum.
	 *
	 * @param isSum the new checks if is sum
	 */
	public void setIsSum(Long isSum) {
		this.isSum = isSum;
	}

	/**
	 * Gets the checks if is required.
	 *
	 * @return the checks if is required
	 */
	public Long getIsRequired() {
		return isRequired;
	}

	/**
	 * Sets the checks if is required.
	 *
	 * @param isRequired the new checks if is required
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
	 * @param css the new css
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

	/**
	 * Gets the query.
	 *
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * Sets the query.
	 *
	 * @param query the new query
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(columnSize, css, dispOrderNo, fieldMasterId, htmlType, isRequired, isSum, orderNo,
				paramDispName, paramProcName, paramType, paramUiName, query, regex, reportId, type);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommonFieldMasterEntity other = (CommonFieldMasterEntity) obj;
		return Objects.equals(columnSize, other.columnSize) && Objects.equals(css, other.css)
				&& Objects.equals(dispOrderNo, other.dispOrderNo) && Objects.equals(fieldMasterId, other.fieldMasterId)
				&& Objects.equals(htmlType, other.htmlType) && Objects.equals(isRequired, other.isRequired)
				&& Objects.equals(isSum, other.isSum) && Objects.equals(orderNo, other.orderNo)
				&& Objects.equals(paramDispName, other.paramDispName)
				&& Objects.equals(paramProcName, other.paramProcName) && Objects.equals(paramType, other.paramType)
				&& Objects.equals(paramUiName, other.paramUiName) && Objects.equals(query, other.query)
				&& Objects.equals(regex, other.regex) && Objects.equals(reportId, other.reportId)
				&& Objects.equals(type, other.type);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CommonFieldMasterEntity [fieldMasterId=" + fieldMasterId + ", reportId=" + reportId + ", paramUiName="
				+ paramUiName + ", paramProcName=" + paramProcName + ", paramDispName=" + paramDispName + ", paramType="
				+ paramType + ", columnSize=" + columnSize + ", orderNo=" + orderNo + ", isSum=" + isSum
				+ ", isRequired=" + isRequired + ", css=" + css + ", type=" + type + ", dispOrderNo=" + dispOrderNo
				+ ", regex=" + regex + ", htmlType=" + htmlType + ", query=" + query + "]";
	}

}
