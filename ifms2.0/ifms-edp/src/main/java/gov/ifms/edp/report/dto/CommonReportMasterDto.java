package gov.ifms.edp.report.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The Class CommonReportMasterDto.
 * 
 * @version 1.0
 * @created 2021/02/23 13:34:48
 *
 */
public class CommonReportMasterDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The report id. */
	@NotNull
	private Long reportId;

	/** The name. */
	@NotNull
	private String name;

	/** The alias. */
	@NotNull
	private String alias;

	/** The proc name. */
	@NotNull
	private String procName;

	/** The menu id. */
	@NotNull
	private Long menuId;

	/**
	 * CommonReportMasterDto Constructor.
	 */
	public CommonReportMasterDto() {
		super();
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

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
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Gets the proc name.
	 *
	 * @return the procName
	 */
	public String getProcName() {
		return procName;
	}

	/**
	 * Sets the proc name.
	 *
	 * @param procName the procName to set
	 */
	public void setProcName(String procName) {
		this.procName = procName;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

}
