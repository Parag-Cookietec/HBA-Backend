package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPUsrPoTrnsItrDto.
 */
public class EDPUsrPoTrnsItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The edp usr po trns itr id. */
	private Long edpUsrPoTrnsItrId;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/** The post office id. */
	private Long postOfficeId;

	/** The trn no. */
	private String trnNo;

	/** The from user id. */
	private Long fromUserId;

	/** The to pou id. */
	private Long toUserId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The will be primary. */
	private long willBePrimary;

	/**
	 * EDPUserPoTrnsDto Constructor.
	 */
	public EDPUsrPoTrnsItrDto() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(edpUsrPoTrnsId, edpUsrPoTrnsItrId, fromUserId, postOfficeId, toUserId, trnNo, wfRoleId,
				willBePrimary);
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
		if (!(obj instanceof EDPUsrPoTrnsItrDto)) {
			return false;
		}
		EDPUsrPoTrnsItrDto other = (EDPUsrPoTrnsItrDto) obj;
		return Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId)
				&& Objects.equals(edpUsrPoTrnsItrId, other.edpUsrPoTrnsItrId)
				&& Objects.equals(fromUserId, other.fromUserId) && Objects.equals(postOfficeId, other.postOfficeId)
				&& Objects.equals(toUserId, other.toUserId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(wfRoleId, other.wfRoleId) && willBePrimary == other.willBePrimary;
	}

	/**
	 * getter setter.
	 *
	 * @return the post office id
	 */

	/**
	 * @return the postOfficeId
	 */
	public Long getPostOfficeId() {
		return postOfficeId;
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
	 * Sets the post office id.
	 *
	 * @param postOfficeId the postOfficeId to set
	 */
	public void setPostOfficeId(Long postOfficeId) {
		this.postOfficeId = postOfficeId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the from user id.
	 *
	 * @return the fromUserId
	 */
	public Long getFromUserId() {
		return fromUserId;
	}

	/**
	 * Sets the from user id.
	 *
	 * @param fromUserId the fromUserId to set
	 */
	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	/**
	 * Gets the to user id.
	 *
	 * @return the toUserId
	 */
	public Long getToUserId() {
		return toUserId;
	}

	/**
	 * Sets the to user id.
	 *
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * Gets the will be primary.
	 *
	 * @return the willBePrimary
	 */
	public long getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * Sets the will be primary.
	 *
	 * @param willBePrimary the willBePrimary to set
	 */
	public void setWillBePrimary(long willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the edp usr po trns itr id.
	 *
	 * @return the edpUsrPoTrnsItrId
	 */
	public Long getEdpUsrPoTrnsItrId() {
		return edpUsrPoTrnsItrId;
	}

	/**
	 * Sets the edp usr po trns itr id.
	 *
	 * @param edpUsrPoTrnsItrId the edpUsrPoTrnsItrId to set
	 */
	public void setEdpUsrPoTrnsItrId(Long edpUsrPoTrnsItrId) {
		this.edpUsrPoTrnsItrId = edpUsrPoTrnsItrId;
	}

}
