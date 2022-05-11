package gov.ifms.edp.oauth.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.edp.dto.EDPMsMenuInfoDto;
import gov.ifms.edp.dto.EDPMsRolePermissionsDto;

/**
 * The Class OAuthLkPostUserRoleMenuEndpointsDTO.
 */
public class OAuthLkPostUserRoleMenuEndpointsDTO extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post user role menu endpoints id. */
	private long postUserRoleMenuEndpointsId;

	/** The financtial year. */
	private String financtialYear;

	/** The edp ms posts id. */
	private long edpMsPostsId;

	/** The edp ms users id. */
	private long edpMsUsersId;

	/**
	 * Gets the menuinfoid.
	 *
	 * @return the menuinfoid
	 */
	public EDPMsMenuInfoDto getMenuinfoid() {
		return menuinfoid;
	}

	/**
	 * Sets the menuinfoid.
	 *
	 * @param menuinfoid the new menuinfoid
	 */
	public void setMenuinfoid(EDPMsMenuInfoDto menuinfoid) {
		this.menuinfoid = menuinfoid;
	}

	/**
	 * Gets the o auth ms user endpoints.
	 *
	 * @return the o auth ms user endpoints
	 */
	public OAuthMsUserEndpointsDTO getoAuthMsUserEndpoints() {
		return oAuthMsUserEndpoints;
	}

	/**
	 * Sets the o auth ms user endpoints.
	 *
	 * @param oAuthMsUserEndpoints the new o auth ms user endpoints
	 */
	public void setoAuthMsUserEndpoints(OAuthMsUserEndpointsDTO oAuthMsUserEndpoints) {
		this.oAuthMsUserEndpoints = oAuthMsUserEndpoints;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The edp ms role activity. */
	private EDPMsRolePermissionsDto edpMsRoleActivity;

	/** The menuinfoid. */
	private EDPMsMenuInfoDto menuinfoid;

	/** The o auth ms user endpoints. */
	private OAuthMsUserEndpointsDTO oAuthMsUserEndpoints;

	/**
	 * Gets the post user role menu endpoints id.
	 *
	 * @return the post user role menu endpoints id
	 */
	public long getPostUserRoleMenuEndpointsId() {
		return postUserRoleMenuEndpointsId;
	}

	/**
	 * Sets the post user role menu endpoints id.
	 *
	 * @param postUserRoleMenuEndpointsId the new post user role menu endpoints id
	 */
	public void setPostUserRoleMenuEndpointsId(long postUserRoleMenuEndpointsId) {
		this.postUserRoleMenuEndpointsId = postUserRoleMenuEndpointsId;
	}

	/**
	 * Gets the financtial year.
	 *
	 * @return the financtial year
	 */
	public String getFinanctialYear() {
		return financtialYear;
	}

	/**
	 * Sets the financtial year.
	 *
	 * @param financtialYear the new financtial year
	 */
	public void setFinanctialYear(String financtialYear) {
		this.financtialYear = financtialYear;
	}



	/**
	 * Gets the edp ms posts id.
	 *
	 * @return the edp ms posts id
	 */
	public long getEdpMsPostsId() {
		return edpMsPostsId;
	}

	/**
	 * Sets the edp ms posts id.
	 *
	 * @param edpMsPostsId the new edp ms posts id
	 */
	public void setEdpMsPostsId(long edpMsPostsId) {
		this.edpMsPostsId = edpMsPostsId;
	}

	/**
	 * Gets the edp ms users id.
	 *
	 * @return the edp ms users id
	 */
	public long getEdpMsUsersId() {
		return edpMsUsersId;
	}

	/**
	 * Sets the edp ms users id.
	 *
	 * @param edpMsUsersId the new edp ms users id
	 */
	public void setEdpMsUsersId(long edpMsUsersId) {
		this.edpMsUsersId = edpMsUsersId;
	}

	/**
	 * Gets the edp ms role activity.
	 *
	 * @return the edp ms role activity
	 */
	public EDPMsRolePermissionsDto getEdpMsRoleActivity() {
		return edpMsRoleActivity;
	}

	/**
	 * Sets the edp ms role activity.
	 *
	 * @param edpMsRoleActivity the new edp ms role activity
	 */
	public void setEdpMsRoleActivity(EDPMsRolePermissionsDto edpMsRoleActivity) {
		this.edpMsRoleActivity = edpMsRoleActivity;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(edpMsPostsId, edpMsRoleActivity, edpMsUsersId, financtialYear,
				menuinfoid, oAuthMsUserEndpoints, postUserRoleMenuEndpointsId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof OAuthLkPostUserRoleMenuEndpointsDTO)) {
			return false;
		}
		OAuthLkPostUserRoleMenuEndpointsDTO other = (OAuthLkPostUserRoleMenuEndpointsDTO) obj;
		return edpMsPostsId == other.edpMsPostsId && Objects.equals(edpMsRoleActivity, other.edpMsRoleActivity)
				&& edpMsUsersId == other.edpMsUsersId && Objects.equals(financtialYear, other.financtialYear)
				&& Objects.equals(menuinfoid, other.menuinfoid)
				&& Objects.equals(oAuthMsUserEndpoints, other.oAuthMsUserEndpoints)
				&& postUserRoleMenuEndpointsId == other.postUserRoleMenuEndpointsId;
	}

}
