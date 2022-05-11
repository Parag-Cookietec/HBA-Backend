package gov.ifms.edp.oauth.entity;

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

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.EDPMsUserEntity;

/**
 * The Class OAuthMsUserSessionsEntity.
 */
@Entity
@Table(name = "MS_USER_SESSIONS", schema = Constant.OAUTH_SCHEMA)
public class OAuthMsUserSessionsEntity implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The user session id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_SESSION_ID")
	private long userSessionId;

	/** The session id. */
	@Column(name = "SESSION_ID")
	private String sessionId;

	/** The expire timeout. */
	@Column(name = "EXPIRE_TIMEOUT")
	private int expireTimeout;
	
	/** The max session. */
	@Column(name = "MAX_SESSION")
	private int maxSession ;
	
	/** The edp ms user entity id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity edpMsUserEntityId;
	
	/** The session start time. */
	@Column(name = "SESSION_STARTTIME")
	private Date sessionStartTime;
	
	/** The session end time. */
	@Column(name = "SESSION_ENDTIME")
	private Date sessionEndTime;
	
	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private int activeStatus;

	/**
	 * Instantiates a new o auth ms user sessions entity.
	 */
	public OAuthMsUserSessionsEntity() {
	}


	/**
	 * Instantiates a new o auth ms user sessions entity.
	 *
	 * @param sessionId the session id
	 * @param expireTimeout the expire timeout
	 * @param maxSession the max session
	 * @param edpMsUserEntityId the edp ms user entity id
	 * @param sessionStartTime the session start time
	 * @param sessionEndTime the session end time
	 * @param activeStatus the active status
	 */
	public OAuthMsUserSessionsEntity(String sessionId, int expireTimeout, int maxSession,
			EDPMsUserEntity edpMsUserEntityId, Date sessionStartTime, Date sessionEndTime, int activeStatus) {
		super();
		this.sessionId = sessionId;
		this.expireTimeout = expireTimeout;
		this.maxSession = maxSession;
		this.edpMsUserEntityId = edpMsUserEntityId;
		this.sessionStartTime = sessionStartTime;
		this.sessionEndTime = sessionEndTime;
		this.activeStatus = activeStatus;
	}



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
	public EDPMsUserEntity getEdpMsUserEntityId() {
		return edpMsUserEntityId;
	}

	/**
	 * Sets the edp ms user entity id.
	 *
	 * @param edpMsUserEntityId the new edp ms user entity id
	 */
	public void setEdpMsUserEntityId(EDPMsUserEntity edpMsUserEntityId) {
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


	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(activeStatus, edpMsUserEntityId, expireTimeout, maxSession, sessionEndTime, sessionId,
				sessionStartTime, userSessionId);
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
		if (!(obj instanceof OAuthMsUserSessionsEntity)) {
			return false;
		}
		OAuthMsUserSessionsEntity other = (OAuthMsUserSessionsEntity) obj;
		return activeStatus == other.activeStatus && Objects.equals(edpMsUserEntityId, other.edpMsUserEntityId)
				&& expireTimeout == other.expireTimeout && maxSession == other.maxSession
				&& Objects.equals(sessionEndTime, other.sessionEndTime) && Objects.equals(sessionId, other.sessionId)
				&& Objects.equals(sessionStartTime, other.sessionStartTime) && userSessionId == other.userSessionId;
	}

}
