package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPRightsMappingDto.
 */
public class EDPRightsMappingDataDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The menu id. */
	private Long menuId;
	
	/** The rights list. */
	private List<String> rightsList;
	
	/** The old rights list. */
	private List<String> oldRightsList;
	
	/** The is rights removed. */
	private Boolean isRightsRemoved;
	
	/** The wf role list. */
	private List<ClueDto> wfRoleList;
	
	/** The old wf role list. */
	private List<ClueDto> oldWfRoleList;
	

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

	/**
	 * Gets the rights list.
	 *
	 * @return the rightsList
	 */
	public List<String> getRightsList() {
		return rightsList;
	}

	/**
	 * Sets the rights list.
	 *
	 * @param rightsList the rightsList to set
	 */
	public void setRightsList(List<String> rightsList) {
		this.rightsList = rightsList;
	}

	/**
	 * Gets the old rights list.
	 *
	 * @return the oldRightsList
	 */
	public List<String> getOldRightsList() {
		return oldRightsList;
	}

	/**
	 * Sets the old rights list.
	 *
	 * @param oldRightsList the oldRightsList to set
	 */
	public void setOldRightsList(List<String> oldRightsList) {
		this.oldRightsList = oldRightsList;
	}

	/**
	 * Gets the checks if is rights removed.
	 *
	 * @return the isRightsRemoved
	 */
	public Boolean getIsRightsRemoved() {
		return isRightsRemoved;
	}

	/**
	 * Sets the checks if is rights removed.
	 *
	 * @param isRightsRemoved the isRightsRemoved to set
	 */
	public void setIsRightsRemoved(Boolean isRightsRemoved) {
		this.isRightsRemoved = isRightsRemoved;
	}

	/**
	 * Gets the wf role list.
	 *
	 * @return the wfRoleList
	 */
	public List<ClueDto> getWfRoleList() {
		return wfRoleList;
	}

	/**
	 * Sets the wf role list.
	 *
	 * @param wfRoleList the wfRoleList to set
	 */
	public void setWfRoleList(List<ClueDto> wfRoleList) {
		this.wfRoleList = wfRoleList;
	}

	/**
	 * Gets the old wf role list.
	 *
	 * @return the oldWfRoleList
	 */
	public List<ClueDto> getOldWfRoleList() {
		return oldWfRoleList;
	}

	/**
	 * Sets the old wf role list.
	 *
	 * @param oldWfRoleList the oldWfRoleList to set
	 */
	public void setOldWfRoleList(List<ClueDto> oldWfRoleList) {
		this.oldWfRoleList = oldWfRoleList;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isRightsRemoved, menuId, oldRightsList, oldWfRoleList, rightsList, wfRoleList);
	}

	/**
	 * Equals.
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
		if (!(obj instanceof EDPRightsMappingDataDto)) {
			return false;
		}
		EDPRightsMappingDataDto other = (EDPRightsMappingDataDto) obj;
		return Objects.equals(isRightsRemoved, other.isRightsRemoved)
				&& Objects.equals(menuId, other.menuId)
				&& Objects.equals(oldRightsList, other.oldRightsList)
				&& Objects.equals(oldWfRoleList, other.oldWfRoleList) && Objects.equals(rightsList, other.rightsList)
				&& Objects.equals(wfRoleList, other.wfRoleList);
	}
	
}
