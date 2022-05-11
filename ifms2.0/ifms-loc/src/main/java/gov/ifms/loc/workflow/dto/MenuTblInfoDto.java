package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class WfUserDto
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class MenuTblInfoDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu tbl info id. */
	@NativeQueryResultColumn(index = 0)
	private long menuTblInfoId;

	/** The menu id. */
	@NativeQueryResultColumn(index = 1)
	private long menuId;

	/** The wf tbl name. */
	@NativeQueryResultColumn(index = 2)
	private String wfTblName;

	/** The wf att tbl name. */
	@NativeQueryResultColumn(index = 3)
	private String wfAttTblName;

	/** The active status. */
	@NativeQueryResultColumn(index = 4)
	private int activeStatus;

	/** The schema name. */
	@NativeQueryResultColumn(index = 5)
	private String schemaName;

	/** The wf move tbl name. */
	@NativeQueryResultColumn(index = 6)
	private String wfMoveTblName;

	/** The wf lay tbl name. */
	@NativeQueryResultColumn(index = 7)
	private String wfLayTblName;

	/** The return wf tbl name. */
	@NativeQueryResultColumn(index = 8)
	private String returnWfTblName;

	/**
	 * Instantiates a new menu tbl info dto.
	 */
	public MenuTblInfoDto() {
	}

	/**
	 * Gets the menu tbl info id.
	 *
	 * @return the menu tbl info id
	 */
	public long getMenuTblInfoId() {
		return menuTblInfoId;
	}

	/**
	 * Sets the menu tbl info id.
	 *
	 * @param menuTblInfoId the new menu tbl info id
	 */
	public void setMenuTblInfoId(long menuTblInfoId) {
		this.menuTblInfoId = menuTblInfoId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the wf tbl name.
	 *
	 * @return the wf tbl name
	 */
	public String getWfTblName() {
		return wfTblName;
	}

	/**
	 * Sets the wf tbl name.
	 *
	 * @param wfTblName the new wf tbl name
	 */
	public void setWfTblName(String wfTblName) {
		this.wfTblName = wfTblName;
	}

	/**
	 * Gets the wf att tbl name.
	 *
	 * @return the wf att tbl name
	 */
	public String getWfAttTblName() {
		return wfAttTblName;
	}

	/**
	 * Sets the wf att tbl name.
	 *
	 * @param wfAttTblName the new wf att tbl name
	 */
	public void setWfAttTblName(String wfAttTblName) {
		this.wfAttTblName = wfAttTblName;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the active status
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the new active status
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * Gets the schema name.
	 *
	 * @return the schema name
	 */
	public String getSchemaName() {
		return schemaName;
	}

	/**
	 * Sets the schema name.
	 *
	 * @param schemaName the new schema name
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	/**
	 * Gets the wf move tbl name.
	 *
	 * @return the wf move tbl name
	 */
	public String getWfMoveTblName() {
		return wfMoveTblName;
	}

	/**
	 * Sets the wf move tbl name.
	 *
	 * @param wfMoveTblName the new wf move tbl name
	 */
	public void setWfMoveTblName(String wfMoveTblName) {
		this.wfMoveTblName = wfMoveTblName;
	}

	/**
	 * Gets the wf lay tbl name.
	 *
	 * @return the wf lay tbl name
	 */
	public String getWfLayTblName() {
		return wfLayTblName;
	}

	/**
	 * Sets the wf lay tbl name.
	 *
	 * @param wfLayTblName the new wf lay tbl name
	 */
	public void setWfLayTblName(String wfLayTblName) {
		this.wfLayTblName = wfLayTblName;
	}

	/**
	 * Gets the return wf tbl name.
	 *
	 * @return the return wf tbl name
	 */
	public String getReturnWfTblName() {
		return returnWfTblName;
	}

	/**
	 * Sets the return wf tbl name.
	 *
	 * @param returnWfTblName the new return wf tbl name
	 */
	public void setReturnWfTblName(String returnWfTblName) {
		this.returnWfTblName = returnWfTblName;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MenuTblInfoDto)) return false;
		MenuTblInfoDto that = (MenuTblInfoDto) o;
		return getMenuTblInfoId() == that.getMenuTblInfoId() && getMenuId() == that.getMenuId() && getActiveStatus() == that.getActiveStatus() && Objects.equals(getWfTblName(), that.getWfTblName()) && Objects.equals(getWfAttTblName(), that.getWfAttTblName()) && Objects.equals(getSchemaName(), that.getSchemaName()) && Objects.equals(getWfMoveTblName(), that.getWfMoveTblName()) && Objects.equals(getWfLayTblName(), that.getWfLayTblName()) && Objects.equals(getReturnWfTblName(), that.getReturnWfTblName());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(getMenuTblInfoId(), getMenuId(), getWfTblName(), getWfAttTblName(), getActiveStatus(), getSchemaName(), getWfMoveTblName(), getWfLayTblName(), getReturnWfTblName());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("MenuTblInfoDto{");
		sb.append("menuTblInfoId=").append(menuTblInfoId);
		sb.append(", menuId=").append(menuId);
		sb.append(", wfTblName='").append(wfTblName).append('\'');
		sb.append(", wfAttTblName='").append(wfAttTblName).append('\'');
		sb.append(", activeStatus=").append(activeStatus);
		sb.append(", schemaName='").append(schemaName).append('\'');
		sb.append(", wfMoveTblName='").append(wfMoveTblName).append('\'');
		sb.append(", wfLayTblName='").append(wfLayTblName).append('\'');
		sb.append(", returnWfTblName='").append(returnWfTblName).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
