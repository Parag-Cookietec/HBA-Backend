package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class EDPMsMenuInfoDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:44:35
 *
 */
public class EDPMsMenuInfoDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu info id. */
	private long menuInfoId;

	/** The menu info name. */
	private String menuInfoName;

	/** The menu info name guj. */
	private String menuInfoNameGuj;

	/** The menu info description. */
	private String menuInfoDescription;

	/** The menu info description guj. */
	private String menuInfoDescriptionGuj;

	/** The parent menu id. */
	private long parentMenuId;

	/** The order id. */
	private int orderId;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/** The active status. */
	private int activeStatus;
	
	/** The menu link. */
	private String menuLink;


	/**
	 * Gets the menu info id.
	 *
	 * @return the menuInfoId
	 */
	public long getMenuInfoId() {
		return menuInfoId;
	}

	/**
	 * Sets the menu info id.
	 *
	 * @param menuInfoId the menuInfoId to set
	 */
	public void setMenuInfoId(long menuInfoId) {
		this.menuInfoId = menuInfoId;
	}

	/**
	 * Gets the menu info name.
	 *
	 * @return the menuInfoName
	 */
	public String getMenuInfoName() {
		return menuInfoName;
	}

	/**
	 * Sets the menu info name.
	 *
	 * @param menuInfoName the menuInfoName to set
	 */
	public void setMenuInfoName(String menuInfoName) {
		this.menuInfoName = menuInfoName;
	}

	/**
	 * Gets the menu info name guj.
	 *
	 * @return the menuInfoNameGuj
	 */
	public String getMenuInfoNameGuj() {
		return menuInfoNameGuj;
	}

	/**
	 * Sets the menu info name guj.
	 *
	 * @param menuInfoNameGuj the menuInfoNameGuj to set
	 */
	public void setMenuInfoNameGuj(String menuInfoNameGuj) {
		this.menuInfoNameGuj = menuInfoNameGuj;
	}

	/**
	 * Gets the menu info description.
	 *
	 * @return the menuInfoDescription
	 */
	public String getMenuInfoDescription() {
		return menuInfoDescription;
	}

	/**
	 * Sets the menu info description.
	 *
	 * @param menuInfoDescription the menuInfoDescription to set
	 */
	public void setMenuInfoDescription(String menuInfoDescription) {
		this.menuInfoDescription = menuInfoDescription;
	}

	/**
	 * Gets the menu info description guj.
	 *
	 * @return the menuInfoDescriptionGuj
	 */
	public String getMenuInfoDescriptionGuj() {
		return menuInfoDescriptionGuj;
	}

	/**
	 * Sets the menu info description guj.
	 *
	 * @param menuInfoDescriptionGuj the menuInfoDescriptionGuj to set
	 */
	public void setMenuInfoDescriptionGuj(String menuInfoDescriptionGuj) {
		this.menuInfoDescriptionGuj = menuInfoDescriptionGuj;
	}

	/**
	 * Gets the parent menu id.
	 *
	 * @return the parentMenuId
	 */
	public long getParentMenuId() {
		return parentMenuId;
	}

	/**
	 * Sets the parent menu id.
	 *
	 * @param parentMenuId the parentMenuId to set
	 */
	public void setParentMenuId(long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the activeStatus
	 */
	public int getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the activeStatus to set
	 */
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	/**
	 * Gets the menu link.
	 *
	 * @return the menu link
	 */
	public String getMenuLink() {
		return menuLink;
	}

	/**
	 * Sets the menu link.
	 *
	 * @param menuLink the new menu link
	 */
	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, createdDate, menuInfoDescription, menuInfoDescriptionGuj, menuInfoId,
				menuInfoName, menuInfoNameGuj, menuLink, orderId, parentMenuId, updatedDate);
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
		if (!(obj instanceof EDPMsMenuInfoDto)) {
			return false;
		}
		EDPMsMenuInfoDto other = (EDPMsMenuInfoDto) obj;
		return activeStatus == other.activeStatus && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(menuInfoDescription, other.menuInfoDescription)
				&& Objects.equals(menuInfoDescriptionGuj, other.menuInfoDescriptionGuj)
				&& menuInfoId == other.menuInfoId && Objects.equals(menuInfoName, other.menuInfoName)
				&& Objects.equals(menuInfoNameGuj, other.menuInfoNameGuj) && Objects.equals(menuLink, other.menuLink)
				&& orderId == other.orderId && parentMenuId == other.parentMenuId
				&& Objects.equals(updatedDate, other.updatedDate);
	}

}
