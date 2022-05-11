package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPLkPuoRoleWfDto.
 */
public class EDPLkPuoRoleWfDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The puo role grps id. */
	private Long puoRoleGrpsId;

	/** The post user office id. */
	private Long postUserOfficeId;

	/** The role grp id. */
	private Long roleGrpId;

	/** The wf role grp id. */
	private Long wfRoleGrpId;

	/** The is primary post. */
	private Boolean isPrimaryPost;

	/**
	 * EDPLkPuoRoleGrpsDto Constructor.
	 */
	public EDPLkPuoRoleWfDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(puoRoleGrpsId, postUserOfficeId, roleGrpId, wfRoleGrpId, isPrimaryPost);
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
		if (!(obj instanceof EDPLkPuoRoleWfDto)) {
			return false;
		}

		EDPLkPuoRoleWfDto other = (EDPLkPuoRoleWfDto) obj;

		return Objects.equals(puoRoleGrpsId, other.puoRoleGrpsId)
				&& Objects.equals(postUserOfficeId, other.postUserOfficeId)
				&& Objects.equals(roleGrpId, other.roleGrpId) && Objects.equals(wfRoleGrpId, other.wfRoleGrpId)
				&& Objects.equals(isPrimaryPost, other.isPrimaryPost);
	}

	/**
	 * getter setter.
	 *
	 * @return the puo role grps id
	 */

	/**
	 * @return the puoRoleGrpsId
	 */
	public Long getPuoRoleGrpsId() {
		return puoRoleGrpsId;
	}

	/**
	 * Sets the puo role grps id.
	 *
	 * @param puoRoleGrpsId the puoRoleGrpsId to set
	 */
	public void setPuoRoleGrpsId(Long puoRoleGrpsId) {
		this.puoRoleGrpsId = puoRoleGrpsId;
	}

	/**
	 * Gets the post user office id.
	 *
	 * @return the postUserOfficeId
	 */
	public Long getPostUserOfficeId() {
		return postUserOfficeId;
	}

	/**
	 * Sets the post user office id.
	 *
	 * @param postUserOfficeId the postUserOfficeId to set
	 */
	public void setPostUserOfficeId(Long postUserOfficeId) {
		this.postUserOfficeId = postUserOfficeId;
	}

	/**
	 * Gets the role grp id.
	 *
	 * @return the roleGrpId
	 */
	public Long getRoleGrpId() {
		return roleGrpId;
	}

	/**
	 * Sets the role grp id.
	 *
	 * @param roleGrpId the roleGrpId to set
	 */
	public void setRoleGrpId(Long roleGrpId) {
		this.roleGrpId = roleGrpId;
	}

	/**
	 * Gets the wf role grp id.
	 *
	 * @return the wfRoleGrpId
	 */
	public Long getWfRoleGrpId() {
		return wfRoleGrpId;
	}

	/**
	 * Sets the wf role grp id.
	 *
	 * @param wfRoleGrpId the wfRoleGrpId to set
	 */
	public void setWfRoleGrpId(Long wfRoleGrpId) {
		this.wfRoleGrpId = wfRoleGrpId;
	}

	/**
	 * Gets the checks if is primary post.
	 *
	 * @return the isPrimaryPost
	 */
	public Boolean getIsPrimaryPost() {
		return isPrimaryPost;
	}

	/**
	 * Sets the checks if is primary post.
	 *
	 * @param isPrimaryPost the isPrimaryPost to set
	 */
	public void setIsPrimaryPost(Boolean isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

}
