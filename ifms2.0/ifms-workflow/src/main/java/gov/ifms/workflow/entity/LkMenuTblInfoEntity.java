package gov.ifms.workflow.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class LkMenuTblInfoEntity.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Entity
@Table(name = "LK_MENU_TBL_INFO", schema = Constant.WORKFLOW_SCHEMA)
public class LkMenuTblInfoEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_TBL_INFO_ID")
	private long menuTblInfoId;

	@Column(name = "MENU_ID")
	private long menuId;

	@Column(name = "TRN_WF_TBL_NAME")
	private String trnWfTblName;
	
	@Column(name = "SCHEMA_NAME")
	private String schemaName;

	@Column(name = "ACTIVE_STATUS")
	private int	activeStatus;
	
	@Column(name = "EVENT_ID")
	private Long eventId;

	@Column(name="LK_WF_ATT_TBL_NAME")
	private String attachTblName;

	@Column(name="TRN_WF_MV_TBL_NAME")
	private String moveTblName;

	@Column(name="TRN_WF_LY_TBL_NAME")
	private String layTblName;

	@Column(name="TRN_RETURN_WF_TBL_NAME")
	private String returnWfTblName;

	public String getAttachTblName() {
		return attachTblName;
	}

	public void setAttachTblName(String attachTblName) {
		this.attachTblName = attachTblName;
	}

	public LkMenuTblInfoEntity() {
		super();
	}

	/**
	 * @return the menuTblInfoId
	 */
	public long getMenuTblInfoId() {
		return menuTblInfoId;
	}

	/**
	 * @param menuTblInfoId the menuTblInfoId to set
	 */
	public void setMenuTblInfoId(long menuTblInfoId) {
		this.menuTblInfoId = menuTblInfoId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the trnWfTblName
	 */
	public String getTrnWfTblName() {
		return trnWfTblName;
	}

	/**
	 * @param trnWfTblName the trnWfTblName to set
	 */
	public void setTrnWfTblName(String trnWfTblName) {
		this.trnWfTblName = trnWfTblName;
	}

	/**
	 * @return the schemaName
	 */
	public String getSchemaName() {
		return schemaName;
	}

	/**
	 * @param schemaName the schemaName to set
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	/**
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getMoveTblName() {
		return moveTblName;
	}

	public void setMoveTblName(String moveTblName) {
		this.moveTblName = moveTblName;
	}

	public String getLayTblName() {
		return layTblName;
	}

	public void setLayTblName(String layTblName) {
		this.layTblName = layTblName;
	}

	public String getReturnWfTblName() {
		return returnWfTblName;
	}

	public void setReturnWfTblName(String returnWfTblName) {
		this.returnWfTblName = returnWfTblName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LkMenuTblInfoEntity that = (LkMenuTblInfoEntity) o;
		return menuTblInfoId == that.menuTblInfoId &&
				menuId == that.menuId &&
				activeStatus == that.activeStatus &&
				Objects.equals(trnWfTblName, that.trnWfTblName) &&
				Objects.equals(schemaName, that.schemaName) &&
				Objects.equals(eventId, that.eventId) &&
				Objects.equals(attachTblName, that.attachTblName) &&
				Objects.equals(moveTblName, that.moveTblName) &&
				Objects.equals(layTblName, that.layTblName) &&
				Objects.equals(returnWfTblName, that.returnWfTblName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(menuTblInfoId, menuId, trnWfTblName, schemaName, activeStatus, eventId, attachTblName, moveTblName, layTblName, returnWfTblName);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", LkMenuTblInfoEntity.class.getSimpleName() + "[", "]")
				.add("menuTblInfoId=" + menuTblInfoId)
				.add("menuId=" + menuId)
				.add("trnWfTblName='" + trnWfTblName + "'")
				.add("schemaName='" + schemaName + "'")
				.add("activeStatus=" + activeStatus)
				.add("eventId=" + eventId)
				.add("attachTblName='" + attachTblName + "'")
				.add("moveTblName='" + moveTblName + "'")
				.add("layTblName='" + layTblName + "'")
				.add("returnWfTblName='" + returnWfTblName + "'")
				.toString();
	}
}
