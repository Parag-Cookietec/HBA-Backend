package gov.ifms.edp.report.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class CommonReportMasterEntity.
 * 
 * @version 1.0
 * @created 2021/02/23 13:34:48
 *
 */
@Entity
@Table(name = "REPORT_MASTER", schema = "DUMMY")
public class CommonReportMasterEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The report id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REPORT_ID")
	private Long reportId;

	/** The name. */
	@Column(name = "NAME")
	private String name;

	/** The alias. */
	@Column(name = "ALIAS")
	private String alias;

	/** The proc name. */
	@Column(name = "PROC_NAME")
	private String procName;

	/** The menu id. */
	@Column(name = "MENU_ID")
	private Long menuId;

	/**
	 * CommonReportMasterDto Constructor.
	 */
	public CommonReportMasterEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(reportId, name, alias, procName, menuId);
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
		if (!(obj instanceof CommonReportMasterEntity)) {
			return false;
		}

		CommonReportMasterEntity other = (CommonReportMasterEntity) obj;

		return Objects.equals(reportId, other.reportId) && Objects.equals(name, other.name)
				&& Objects.equals(alias, other.alias) && Objects.equals(procName, other.procName)
				&& Objects.equals(menuId, other.menuId);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CommonReportMasterEntity [reportId = " + reportId + ",name = " + name + ",alias = " + alias
				+ ",procName = " + procName + ",menuId = " + menuId + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the report id
	 */

	/**
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
