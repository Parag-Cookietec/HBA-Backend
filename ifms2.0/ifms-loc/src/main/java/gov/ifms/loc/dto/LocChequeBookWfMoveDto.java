package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChqDtlWfMoveDto.
 * 
 * @version 1.0
 * @created 2020/09/14 11:30:06
 *
 */
public class LocChequeBookWfMoveDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The wf move id. */
	@NotNull
	private Long wfMoveId;

	/** The trn id. */
	@NotNull
	private Long trnId;

	/** The user id. */
	@NotNull
	private Long userId;

	/** The post id. */
	private Long postId;

	/** The pou id. */
	private Long pouId;

	/** The received from wf id. */
	private Long receivedFromWfId;

	/** The received from user id. */
	private Long receivedFromUserId;

	/** The received from post id. */
	private Long receivedFromPostId;

	/** The received from pou id. */
	private Long receivedFromPouId;

	/** The received on date. */
	private Date receivedOnDate;

	/** The sent to wf id. */
	private Long sentToWfId;

	/** The sent to user id. */
	private Long sentToUserId;

	/** The sent to post id. */
	private Long sentToPostId;

	/** The sent to pou id. */
	private Long sentToPouId;

	/** The sent on date. */
	private Date sentOnDate;

	/**
	 * BudgetSubHeadWfMoveDto Constructor.
	 */
	public LocChequeBookWfMoveDto() {
		super();
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
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the trnId to set
	 */
	public void setTrnId(Long trnId) {
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
	public Long getReceivedFromWfId() {
		return receivedFromWfId;
	}

	/**
	 * Sets the received from wf id.
	 *
	 * @param receivedFromWfId the receivedFromWfId to set
	 */
	public void setReceivedFromWfId(Long receivedFromWfId) {
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
	public Long getSentToWfId() {
		return sentToWfId;
	}

	/**
	 * Sets the sent to wf id.
	 *
	 * @param sentToWfId the sentToWfId to set
	 */
	public void setSentToWfId(Long sentToWfId) {
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
