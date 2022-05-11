package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.edp.oauth.dto.OAuthMsUserEndpointsDTO;

/**
 * The Class EDPMsMenuDto.
 * 
 * @version 1.0
 * @created 2019/08/29 17:40:15
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EDPMsMenuDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The menu id. */
	private long menuId;

	/** The menu name. */
	private String menuName;

	/** The menu name guj. */
	private String menuNameGuj;

	/** The menu description. */
	private String menuDescription;

	/** The menu description guj. */
	private String menuDescriptionGuj;

	/** The order id. */
	private Short orderId;

	/** The menu link. */
	private String menuLink;

	/** The parent menu id. */
	private long parentMenuId;

	/** The from id. */
	private long fromId;

	/** The menu dtos. */
	private List<EDPMsMenuDto> menuDtos = new ArrayList<>();

	/** The oauth ms user endpoints DTO list. */
	private List<OAuthMsUserEndpointsDTO> oauthMsUserEndpointsDTOList;

	/** The wf id. */
	private Set<ClueDto> wfRoleId;

	/** The edp ms role permissions dto. */
	private List<ClueDto> edpMsRolePermissionsDto;
	
	/** The form id. */
	private Long formId;
	
	/** The link menu id. */
	private Long linkMenuId;
	
	/** The link menu wf role id. */
	private Set<ClueDto> linkMenuWfRoleId;
	
	/** The menu code. */
	private String menuCode;
	
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
	public Short getOrderId() {
		return orderId;
	}

	/**
	 * Sets the order id.
	 *
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Short orderId) {
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
	 * Gets the menu dtos.
	 *
	 * @return the menu dtos
	 */
	public List<EDPMsMenuDto> getMenuDtos() {
		return menuDtos;
	}

	/**
	 * Sets the menu dtos.
	 *
	 * @param menuDtos the new menu dtos
	 */
	public void setMenuDtos(List<EDPMsMenuDto> menuDtos) {
		this.menuDtos = menuDtos;
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
	 * Gets the from id.
	 *
	 * @return the fromId
	 */
	public long getFromId() {
		return fromId;
	}

	/**
	 * Sets the from id.
	 *
	 * @param fromId the fromId to set
	 */
	public void setFromId(long fromId) {
		this.fromId = fromId;
	}

	/**
	 * Gets the oauth ms user endpoints DTO list.
	 *
	 * @return the oauthMsUserEndpointsDTOList
	 */
	public List<OAuthMsUserEndpointsDTO> getOauthMsUserEndpointsDTOList() {
		return oauthMsUserEndpointsDTOList;
	}

	/**
	 * Sets the oauth ms user endpoints DTO list.
	 *
	 * @param oauthMsUserEndpointsDTOList the oauthMsUserEndpointsDTOList to set
	 */
	public void setOauthMsUserEndpointsDTOList(List<OAuthMsUserEndpointsDTO> oauthMsUserEndpointsDTOList) {
		this.oauthMsUserEndpointsDTOList = oauthMsUserEndpointsDTOList;
	}

	

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Set<ClueDto> getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Set<ClueDto> wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the edp ms role permissions dto.
	 *
	 * @return the edpMsRolePermissionsDto
	 */
	public List<ClueDto> getEdpMsRolePermissionsDto() {
		return edpMsRolePermissionsDto;
	}

	/**
	 * Sets the edp ms role permissions dto.
	 *
	 * @param edpMsRolePermissionsDto the edpMsRolePermissionsDto to set
	 */
	public void setEdpMsRolePermissionsDto(List<ClueDto> edpMsRolePermissionsDto) {
		this.edpMsRolePermissionsDto = edpMsRolePermissionsDto;
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
	 * Gets the link menu wf role id.
	 *
	 * @return the linkMenuWfRoleId
	 */
	public Set<ClueDto> getLinkMenuWfRoleId() {
		return linkMenuWfRoleId;
	}

	/**
	 * Sets the link menu wf role id.
	 *
	 * @param linkMenuWfRoleId the linkMenuWfRoleId to set
	 */
	public void setLinkMenuWfRoleId(Set<ClueDto> linkMenuWfRoleId) {
		this.linkMenuWfRoleId = linkMenuWfRoleId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpMsRolePermissionsDto, formId, fromId, linkMenuId, linkMenuWfRoleId, menuCode,
				menuDescription, menuDescriptionGuj, menuDtos, menuId, menuLink, menuName, menuNameGuj,
				oauthMsUserEndpointsDTOList, orderId, parentMenuId, wfRoleId);
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
		if (!(obj instanceof EDPMsMenuDto)) {
			return false;
		}
		EDPMsMenuDto other = (EDPMsMenuDto) obj;
		return Objects.equals(edpMsRolePermissionsDto, other.edpMsRolePermissionsDto)
				&& Objects.equals(formId, other.formId) && fromId == other.fromId
				&& Objects.equals(linkMenuId, other.linkMenuId)
				&& Objects.equals(linkMenuWfRoleId, other.linkMenuWfRoleId) && Objects.equals(menuCode, other.menuCode)
				&& Objects.equals(menuDescription, other.menuDescription)
				&& Objects.equals(menuDescriptionGuj, other.menuDescriptionGuj)
				&& Objects.equals(menuDtos, other.menuDtos) && menuId == other.menuId
				&& Objects.equals(menuLink, other.menuLink) && Objects.equals(menuName, other.menuName)
				&& Objects.equals(menuNameGuj, other.menuNameGuj)
				&& Objects.equals(oauthMsUserEndpointsDTOList, other.oauthMsUserEndpointsDTOList)
				&& Objects.equals(orderId, other.orderId) && parentMenuId == other.parentMenuId
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}

}