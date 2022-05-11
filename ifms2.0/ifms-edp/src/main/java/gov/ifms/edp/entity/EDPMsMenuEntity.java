package gov.ifms.edp.entity;

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

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsMenuEntity.
 */
@Entity
@Table(name = "MS_MENU", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsMenuEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MENU_ID")
	private long menuId;

	/** The menu name. */
	@Column(name = "MENU_NAME")
	private String menuName;

	/** The menu name guj. */
	@Column(name = "MENU_NAME_GUJ")
	private String menuNameGuj;

	/** The menu description. */
	@Column(name = "MENU_DESCRIPTION")
	private String menuDescription;

	/** The menu description guj. */
	@Column(name = "MENU_DESCRIPTION_GUJ")
	private String menuDescriptionGuj;
	
	/** The parent menu id. */
	@Column(name = "PARENT_MENU_ID")
	private long parentMenuId;

	/** The order id. */
	@Column(name = "ORDER_ID")
	private short orderId;

	/** The menu link. */
	@Column(name = "MENU_LINKS")
	private String menuLink;
	
	/** The form id. */
	@Column(name="FORM_ID")
	private Long formId;
	
	/** The link menu id. */
	@Column(name="LINK_MENU_ID")
	private Long linkMenuId;
	
	/** The menu code. */
	@Column(name="MENU_CODE")
	private String menuCode;
	
	/** The sub module id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SUB_MODULE_ID", referencedColumnName = "SUB_MODULE_ID")
	private EDPMsSubModuleEntity subModuleId;

	/** The module id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MODULE_ID", referencedColumnName = "MODULE_ID")
	private EDPMsModuleEntity moduleId;
	
	
	

	

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public EDPMsModuleEntity getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(EDPMsModuleEntity moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Instantiates a new EDP ms menu entity.
	 */
	public EDPMsMenuEntity() {
		super();
	}

	public EDPMsMenuEntity(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the menu name.
	 *
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * Sets the menu name.
	 *
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * Gets the menu name guj.
	 *
	 * @return the menuNameGuj
	 */
	public String getMenuNameGuj() {
		return menuNameGuj;
	}

	/**
	 * Sets the menu name guj.
	 *
	 * @param menuNameGuj the menuNameGuj to set
	 */
	public void setMenuNameGuj(String menuNameGuj) {
		this.menuNameGuj = menuNameGuj;
	}

	/**
	 * Gets the menu description.
	 *
	 * @return the menuDescription
	 */
	public String getMenuDescription() {
		return menuDescription;
	}

	/**
	 * Sets the menu description.
	 *
	 * @param menuDescription the menuDescription to set
	 */
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	/**
	 * Gets the menu description guj.
	 *
	 * @return the menuDescriptionGuj
	 */
	public String getMenuDescriptionGuj() {
		return menuDescriptionGuj;
	}

	/**
	 * Sets the menu description guj.
	 *
	 * @param menuDescriptionGuj the menuDescriptionGuj to set
	 */
	public void setMenuDescriptionGuj(String menuDescriptionGuj) {
		this.menuDescriptionGuj = menuDescriptionGuj;
	}

	/**
	 * Gets the order id.
	 *
	 * @return the orderId
	 */
	public short getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(short orderId) {
		this.orderId = orderId;
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
	 * Gets the parent menu id.
	 *
	 * @return the parent menu id
	 */
	public long getParentMenuId() {
		return parentMenuId;
	}

	/**
	 * Sets the parent menu id.
	 *
	 * @param parentMenuId the new parent menu id
	 */
	public void setParentMenuId(long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	/**
	 * Gets the form id.
	 *
	 * @return the formId
	 */
	public Long getFormId() {
		return formId;
	}

	/**
	 * Sets the form id.
	 *
	 * @param formId the formId to set
	 */
	public void setFormId(Long formId) {
		this.formId = formId;
	}

	/**
	 * Gets the link menu id.
	 *
	 * @return the linkMenuId
	 */
	public Long getLinkMenuId() {
		return linkMenuId;
	}

	/**
	 * Sets the link menu id.
	 *
	 * @param linkMenuId the linkMenuId to set
	 */
	public void setLinkMenuId(Long linkMenuId) {
		this.linkMenuId = linkMenuId;
	}

	/**
	 * Gets the menu code.
	 *
	 * @return the menuCode
	 */
	public String getMenuCode() {
		return menuCode;
	}

	/**
	 * Sets the menu code.
	 *
	 * @param menuCode the menuCode to set
	 */
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * Gets the sub module id.
	 *
	 * @return the subModuleId
	 */
	public EDPMsSubModuleEntity getSubModuleId() {
		return subModuleId;
	}

	/**
	 * Sets the sub module id.
	 *
	 * @param subModuleId the subModuleId to set
	 */
	public void setSubModuleId(EDPMsSubModuleEntity subModuleId) {
		this.subModuleId = subModuleId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(formId, linkMenuId, menuCode, menuDescription, menuDescriptionGuj, menuId, menuLink,
				menuName, menuNameGuj, orderId, parentMenuId, subModuleId);
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
		EDPMsMenuEntity other = (EDPMsMenuEntity) obj;
		return Objects.equals(formId, other.formId) && Objects.equals(linkMenuId, other.linkMenuId)
				&& Objects.equals(menuCode, other.menuCode) && Objects.equals(menuDescription, other.menuDescription)
				&& Objects.equals(menuDescriptionGuj, other.menuDescriptionGuj) && menuId == other.menuId
				&& Objects.equals(menuLink, other.menuLink) && Objects.equals(menuName, other.menuName)
				&& Objects.equals(menuNameGuj, other.menuNameGuj) && orderId == other.orderId
				&& parentMenuId == other.parentMenuId && Objects.equals(subModuleId, other.subModuleId);
	}
}
