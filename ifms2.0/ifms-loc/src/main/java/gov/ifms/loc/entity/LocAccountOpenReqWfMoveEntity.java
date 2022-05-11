package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Date;
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

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;

/**
 * The Class BudgetSubHeadWfMoveEntity.
 * 
 * @version 1.0
 * @created 2020/09/14 11:30:06
 *
 */
@Entity
@Table(name = "TLOC_LC_OPEN_REQ_WF_MOVE", schema = LocConstant.LOC_SCHEMA)
public class LocAccountOpenReqWfMoveEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The wf move id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "WF_MOVE_ID")
	private Long wfMoveId;

	/** The trn id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRN_ID", referencedColumnName = "LC_OPEN_REQ_HDR_ID")
	private LocAccountOpenReqHdrEntity trnId;
	
	/** The user id. */
	@Column(name = "USER_ID")
	private Long userId;

	/** The post id. */
	@Column(name = "POST_ID")
	private Long postId;

	/** The pou id. */
	@Column(name = "POU_ID")
	private Long pouId;

	/** The received from wf id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECEIVED_FROM_WF_ID", referencedColumnName = "WF_ID")
	private LocAccountOpenReqWfEntity receivedFromWfId;

	/** The received from user id. */
	@Column(name = "RECEIVED_FROM_USER_ID")
	private Long receivedFromUserId;

	/** The received from post id. */
	@Column(name = "RECEIVED_FROM_POST_ID")
	private Long receivedFromPostId;

	/** The received from pou id. */
	@Column(name = "RECEIVED_FROM_POU_ID")
	private Long receivedFromPouId;

	/** The received on date. */
	@Column(name = "RECEIVED_ON_DATE")
	private Date receivedOnDate;

	/** The sent to wf id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SENT_TO_WF_ID", referencedColumnName = "WF_ID")
	private LocAccountOpenReqWfEntity sentToWfId;

	/** The sent to user id. */
	@Column(name = "SENT_TO_USER_ID")
	private Long sentToUserId;

	/** The sent to post id. */
	@Column(name = "SENT_TO_POST_ID")
	private Long sentToPostId;

	/** The sent to pou id. */
	@Column(name = "SENT_TO_POU_ID")
	private Long sentToPouId;

	/** The sent on date. */
	@Column(name = "SENT_ON_DATE")
	private Date sentOnDate;

	/**
	 * BudgetSubHeadWfMoveDto Constructor.
	 */
	public LocAccountOpenReqWfMoveEntity() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(wfMoveId, trnId, userId, postId, pouId, receivedFromWfId, receivedFromUserId,
				receivedFromPostId, receivedFromPouId, receivedOnDate, sentToWfId, sentToUserId, sentToPostId,
				sentToPouId, sentOnDate);
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
		if (!(obj instanceof LocAccountOpenReqWfMoveEntity)) {
			return false;
		}

		LocAccountOpenReqWfMoveEntity other = (LocAccountOpenReqWfMoveEntity) obj;

		return Objects.equals(wfMoveId, other.wfMoveId) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(userId, other.userId) && Objects.equals(postId, other.postId)
				&& Objects.equals(pouId, other.pouId) && Objects.equals(receivedFromWfId, other.receivedFromWfId)
				&& Objects.equals(receivedFromUserId, other.receivedFromUserId)
				&& Objects.equals(receivedFromPostId, other.receivedFromPostId)
				&& Objects.equals(receivedFromPouId, other.receivedFromPouId)
				&& Objects.equals(receivedOnDate, other.receivedOnDate) && Objects.equals(sentToWfId, other.sentToWfId)
				&& Objects.equals(sentToUserId, other.sentToUserId) && Objects.equals(sentToPostId, other.sentToPostId)
				&& Objects.equals(sentToPouId, other.sentToPouId) && Objects.equals(sentOnDate, other.sentOnDate);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "BudgetSubHeadWfMoveEntity [wfMoveId = " + wfMoveId + ",trnId = " + trnId + ",userId = " + userId
				+ ",postId = " + postId + ",pouId = " + pouId + ",receivedFromWfId = " + receivedFromWfId
				+ ",receivedFromUserId = " + receivedFromUserId + ",receivedFromPostId = " + receivedFromPostId
				+ ",receivedFromPouId = " + receivedFromPouId + ",receivedOnDate = " + receivedOnDate + ",sentToWfId = "
				+ sentToWfId + ",sentToUserId = " + sentToUserId + ",sentToPostId = " + sentToPostId + ",sentToPouId = "
				+ sentToPouId + ",sentOnDate = " + sentOnDate + ",]";
	}

	/**
	 * @return the wfMoveId
	 */
	public Long getWfMoveId() {
		return wfMoveId;
	}

	/**
	 * Sets the wf move id.
	 *
	 * @param wfMoveId the wfMoveId to set
	 */
	public void setWfMoveId(Long wfMoveId) {
		this.wfMoveId = wfMoveId;
	}

	/**
	 * Gets the trn id.
	 *
	 * @return the trnId
	 */
	public LocAccountOpenReqHdrEntity getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(LocAccountOpenReqHdrEntity trnId) {
		this.trnId = trnId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pouId
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the pouId to set
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the received from wf id.
	 *
	 * @return the receivedFromWfId
	 */
	public LocAccountOpenReqWfEntity getReceivedFromWfId() {
		return receivedFromWfId;
	}

	/**
	 * Sets the received from wf id.
	 *
	 * @param receivedFromWfId the receivedFromWfId to set
	 */
	public void setReceivedFromWfId(LocAccountOpenReqWfEntity receivedFromWfId) {
		this.receivedFromWfId = receivedFromWfId;
	}

	/**
	 * Gets the received from user id.
	 *
	 * @return the receivedFromUserId
	 */
	public Long getReceivedFromUserId() {
		return receivedFromUserId;
	}

	/**
	 * Sets the received from user id.
	 *
	 * @param receivedFromUserId the receivedFromUserId to set
	 */
	public void setReceivedFromUserId(Long receivedFromUserId) {
		this.receivedFromUserId = receivedFromUserId;
	}

	/**
	 * Gets the received from post id.
	 *
	 * @return the receivedFromPostId
	 */
	public Long getReceivedFromPostId() {
		return receivedFromPostId;
	}

	/**
	 * Sets the received from post id.
	 *
	 * @param receivedFromPostId the receivedFromPostId to set
	 */
	public void setReceivedFromPostId(Long receivedFromPostId) {
		this.receivedFromPostId = receivedFromPostId;
	}

	/**
	 * Gets the received from pou id.
	 *
	 * @return the receivedFromPouId
	 */
	public Long getReceivedFromPouId() {
		return receivedFromPouId;
	}

	/**
	 * Sets the received from pou id.
	 *
	 * @param receivedFromPouId the receivedFromPouId to set
	 */
	public void setReceivedFromPouId(Long receivedFromPouId) {
		this.receivedFromPouId = receivedFromPouId;
	}

	/**
	 * Gets the received on date.
	 *
	 * @return the receivedOnDate
	 */
	public Date getReceivedOnDate() {
		return receivedOnDate;
	}

	/**
	 * Sets the received on date.
	 *
	 * @param receivedOnDate the receivedOnDate to set
	 */
	public void setReceivedOnDate(Date receivedOnDate) {
		this.receivedOnDate = receivedOnDate;
	}

	/**
	 * Gets the sent to wf id.
	 *
	 * @return the sentToWfId
	 */
	public LocAccountOpenReqWfEntity getSentToWfId() {
		return sentToWfId;
	}

	/**
	 * Sets the sent to wf id.
	 *
	 * @param sentToWfId the sentToWfId to set
	 */
	public void setSentToWfId(LocAccountOpenReqWfEntity sentToWfId) {
		this.sentToWfId = sentToWfId;
	}

	/**
	 * Gets the sent to user id.
	 *
	 * @return the sentToUserId
	 */
	public Long getSentToUserId() {
		return sentToUserId;
	}

	/**
	 * Sets the sent to user id.
	 *
	 * @param sentToUserId the sentToUserId to set
	 */
	public void setSentToUserId(Long sentToUserId) {
		this.sentToUserId = sentToUserId;
	}

	/**
	 * Gets the sent to post id.
	 *
	 * @return the sentToPostId
	 */
	public Long getSentToPostId() {
		return sentToPostId;
	}

	/**
	 * Sets the sent to post id.
	 *
	 * @param sentToPostId the sentToPostId to set
	 */
	public void setSentToPostId(Long sentToPostId) {
		this.sentToPostId = sentToPostId;
	}

	/**
	 * Gets the sent to pou id.
	 *
	 * @return the sentToPouId
	 */
	public Long getSentToPouId() {
		return sentToPouId;
	}

	/**
	 * Sets the sent to pou id.
	 *
	 * @param sentToPouId the sentToPouId to set
	 */
	public void setSentToPouId(Long sentToPouId) {
		this.sentToPouId = sentToPouId;
	}

	/**
	 * Gets the sent on date.
	 *
	 * @return the sentOnDate
	 */
	public Date getSentOnDate() {
		return sentOnDate;
	}

	/**
	 * Sets the sent on date.
	 *
	 * @param sentOnDate the sentOnDate to set
	 */
	public void setSentOnDate(Date sentOnDate) {
		this.sentOnDate = sentOnDate;
	}

}
