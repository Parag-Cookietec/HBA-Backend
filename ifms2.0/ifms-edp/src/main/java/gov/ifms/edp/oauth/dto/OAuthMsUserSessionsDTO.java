package gov.ifms.edp.oauth.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class OAuthMsUserSessionsDTO.
 */
public class OAuthMsUserSessionsDTO implements Serializable{
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user session id. */
	private long userSessionId;

	/** The session id. */
	private String sessionId;

	/** The expire timeout. */
	private int expireTimeout;
	
	/** The max session. */
	private int maxSession ;
	
	/** The edp ms user entity id. */
	private long edpMsUserEntityId;
	
	/** The session start time. */
	private Date sessionStartTime;
	
	/** The session end time. */
	private Date sessionEndTime;
	
	/** The active status. */
	private int activeStatus;
	
	/**
	 * Gets the user session id.
	 *
	 * @return the user session id
	 */
	public long getUserSessionId() {
		return userSessionId;
	}

	/**
	 * Sets the user session id.
	 *
	 * @param userSessionId the new user session id
	 */
	public void setUserSessionId(long userSessionId) {
		this.userSessionId = userSessionId;
	}

	/**
	 * Gets the session id.
	 *
	 * @return the session id
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * Sets the session id.
	 *
	 * @param sessionId the new session id
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Gets the expire timeout.
	 *
	 * @return the expire timeout
	 */
	public int getExpireTimeout() {
		return expireTimeout;
	}

	/**
	 * Sets the expire timeout.
	 *
	 * @param expireTimeout the new expire timeout
	 */
	public void setExpireTimeout(int expireTimeout) {
		this.expireTimeout = expireTimeout;
	}

	/**
	 * Gets the max session.
	 *
	 * @return the max session
	 */
	public int getMaxSession() {
		return maxSession;
	}

	/**
	 * Sets the max session.
	 *
	 * @param maxSession the new max session
	 */
	public void setMaxSession(int maxSession) {
		this.maxSession = maxSession;
	}

	

	/**
	 * Gets the edp ms user entity id.
	 *
	 * @return the edp ms user entity id
	 */
	public long getEdpMsUserEntityId() {
		return edpMsUserEntityId;
	}

	/**
	 * Sets the edp ms user entity id.
	 *
	 * @param edpMsUserEntityId the new edp ms user entity id
	 */
	public void setEdpMsUserEntityId(long edpMsUserEntityId) {
		this.edpMsUserEntityId = edpMsUserEntityId;
	}

	/**
	 * Gets the session start time.
	 *
	 * @return the session start time
	 */
	public Date getSessionStartTime() {
		return sessionStartTime;
	}

	/**
	 * Sets the session start time.
	 *
	 * @param sessionStartTime the new session start time
	 */
	public void setSessionStartTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	/**
	 * Gets the session end time.
	 *
	 * @return the session end time
	 */
	public Date getSessionEndTime() {
		return sessionEndTime;
	}

	/**
	 * Sets the session end time.
	 *
	 * @param sessionEndTime the new session end time
	 */
	public void setSessionEndTime(Date sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
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
}
