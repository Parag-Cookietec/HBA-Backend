package gov.ifms.edp.oauth.dto;

import java.io.Serializable;


/**
 * The Class OAuthMsUserEndpointsDTO.
 */
public class OAuthMsUserEndpointsDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user end points id. */
	private long userEndPointsId;

	/** The url end point. */
	private String urlEndPoint;

	/** The url description. */
	private String urlDescription;

	/** The edp ms module entity. */
	private Long menuId;

	/** The active status. */
	private int activeStatus;

	/**
	 * Gets the user end points id.
	 *
	 * @return the user end points id
	 */
	public long getUserEndPointsId() {
		return userEndPointsId;
	}

	/**
	 * Sets the user end points id.
	 *
	 * @param userEndPointsId the new user end points id
	 */
	public void setUserEndPointsId(long userEndPointsId) {
		this.userEndPointsId = userEndPointsId;
	}

	/**
	 * Gets the url end point.
	 *
	 * @return the url end point
	 */
	public String getUrlEndPoint() {
		return urlEndPoint;
	}

	/**
	 * Sets the url end point.
	 *
	 * @param urlEndPoint the new url end point
	 */
	public void setUrlEndPoint(String urlEndPoint) {
		this.urlEndPoint = urlEndPoint;
	}

	/**
	 * Gets the url description.
	 *
	 * @return the url description
	 */
	public String getUrlDescription() {
		return urlDescription;
	}

	/**
	 * Sets the url description.
	 *
	 * @param urlDescription the new url description
	 */
	public void setUrlDescription(String urlDescription) {
		this.urlDescription = urlDescription;
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
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
