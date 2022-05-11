package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * The Class PVUMsEventsEntity.
 */
@Entity
@Table(name = "MS_PVU_EVENTS", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsEventEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The course id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MS_PVU_EVENTS_ID")
	private long id;

	/**
	 * The course name.
	 */
	@Column(name = "EVENT_NAME")
	private String eventName;

	/**
	 * The course name guj.
	 */
	@Column(name = "SCREEN_TYPE")
	private int screenType;

	/**
	 * The course desc.
	 */
	@Column(name = "EVENT_CODE")
	private String eventCode;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the new event name
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the screen type.
	 *
	 * @return the screen type
	 */
	public int getScreenType() {
		return screenType;
	}

	/**
	 * Sets the screen type.
	 *
	 * @param screenType the new screen type
	 */
	public void setScreenType(int screenType) {
		this.screenType = screenType;
	}

	/**
	 * Gets the event code.
	 *
	 * @return the event code
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * Sets the event code.
	 *
	 * @param eventCode the new event code
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * Instantiates a new PVU ms event entity.
	 */
	public PVUMsEventEntity() {
		super();
	}

	/**
	 * Instantiates a new PVU ms event entity.
	 *
	 * @param id the id
	 */
	public PVUMsEventEntity(long id) {
		super();
		this.id = id;
	}

}