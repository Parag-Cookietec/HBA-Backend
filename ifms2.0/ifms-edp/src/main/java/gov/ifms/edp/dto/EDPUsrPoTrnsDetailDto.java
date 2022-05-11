package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPUsrPoTrnsDetailDto.
 */
public class EDPUsrPoTrnsDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post office id. */
	private Long postOfficeId;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;
	
	/** The post name. */
	private String postName;

	/** The edp usr po trns header id. */
	private Long edpUsrPoTrnsHeaderId;

	/** The will be primary. */
	private Boolean willBePrimary;

	/**
	 * Gets the post office id.
	 *
	 * @return the postOfficeId
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
	}

	/**
	 * Sets the post office id.
	 *
	 * @param postOfficeId the postOfficeId to set
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edpUsrPoTrnsId
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the edpUsrPoTrnsId to set
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Gets the edp usr po trns header id.
	 *
	 * @return the edpUsrPoTrnsHeaderId
	 */
	public Long getEdpUsrPoTrnsHeaderId() {
		return edpUsrPoTrnsHeaderId;
	}

	/**
	 * Sets the edp usr po trns header id.
	 *
	 * @param edpUsrPoTrnsHeaderId the edpUsrPoTrnsHeaderId to set
	 */
	public void setEdpUsrPoTrnsHeaderId(Long edpUsrPoTrnsHeaderId) {
		this.edpUsrPoTrnsHeaderId = edpUsrPoTrnsHeaderId;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the willBePrimary
	 */
	public Boolean getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * @param willBePrimary the willBePrimary to set
	 */
	public void setWillBePrimary(Boolean willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsHeaderId, edpUsrPoTrnsId, postName, postOfficeId, willBePrimary);
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
		if (!(obj instanceof EDPUsrPoTrnsDetailDto)) {
			return false;
		}
		EDPUsrPoTrnsDetailDto other = (EDPUsrPoTrnsDetailDto) obj;
		return Objects.equals(edpUsrPoTrnsHeaderId, other.edpUsrPoTrnsHeaderId)
				&& Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId) && Objects.equals(postName, other.postName)
				&& Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(willBePrimary, other.willBePrimary);
	}

	
}
