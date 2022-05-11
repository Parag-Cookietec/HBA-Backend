package gov.ifms.edp.oauth.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class OAuthMsUserEndpointsEntity.
 */

@Entity
@Table(name = "MS_USER_ENDPOINTS", schema = Constant.OAUTH_SCHEMA)
public class OAuthMsUserEndpointsEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user end points id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ENDPOINTS_ID")
	private long userEndPointsId;

	/** The url end point. */
	@Column(name = "URL_ENDPOINT")
	private String urlEndPoint;

	/** The url description. */
	@Column(name = "URL_DESCRIPTION")
	private String urlDescription;

	/** The edp ms module entity. */
	@Column(name = "MENU_ID")
	private Long menuId;

	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus;

	/**
	 * Instantiates a new o auth ms user endpoints entity.
	 */
	public OAuthMsUserEndpointsEntity() {
	}

	/**
	 * Instantiates a new o auth ms user endpoints entity.
	 *
	 * @param userEndPointsId   the user end points id
	 * @param urlEndPoint       the url end point
	 * @param urlDescription    the url description
	 * @param activeStatus      the active status
	 */
	public OAuthMsUserEndpointsEntity(long userEndPointsId, String urlEndPoint, String urlDescription,
			int activeStatus) {
		super();
		this.userEndPointsId = userEndPointsId;
		this.urlEndPoint = urlEndPoint;
		this.urlDescription = urlDescription;
		this.activeStatus = activeStatus;
	}

	/**
	 * Instantiates a new o auth ms user endpoints entity.
	 *
	 * @param urlEndPoint       the url end point
	 * @param urlDescription    the url description
	 * @param activeStatus      the active status
	 */
	public OAuthMsUserEndpointsEntity(String urlEndPoint, String urlDescription, int activeStatus) {
		super();
		this.urlEndPoint = urlEndPoint;
		this.urlDescription = urlDescription;
		this.activeStatus = activeStatus;
	}

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
	 * @return the menu id
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, urlDescription, urlEndPoint, userEndPointsId);
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
		if (!(obj instanceof OAuthMsUserEndpointsEntity)) {
			return false;
		}
		OAuthMsUserEndpointsEntity other = (OAuthMsUserEndpointsEntity) obj;
		return activeStatus == other.activeStatus && Objects.equals(urlDescription, other.urlDescription)
				&& Objects.equals(urlEndPoint, other.urlEndPoint) && userEndPointsId == other.userEndPointsId;
	}

}
