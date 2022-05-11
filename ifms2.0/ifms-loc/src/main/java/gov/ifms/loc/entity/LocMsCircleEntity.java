package gov.ifms.loc.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class LocMsCircleEntity.
 */
@Entity
@Table(name = "MS_CIRCLE", schema = Constant.BUDGET_MASTER_SCHEMA)
public class LocMsCircleEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIRCLE_ID")
	private Long id;

	/** The circle cd. */
	@Column(name = "CIRCLE_CD")
	private String circleCd;

	/** The circle name. */
	@Column(name = "CIRCLE_NAME")
	private String circleName;

	/** The circle name guj. */
	@Column(name = "CIRCLE_NAME_GUJ")
	private String circleNameGuj;

	/**
	 * Instantiates a new loc ms circle entity.
	 */
	public LocMsCircleEntity() {
		super();

	}

	/**
	 * Instantiates a new loc ms circle entity.
	 *
	 * @param id the id
	 */
	public LocMsCircleEntity(Long id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the circle cd.
	 *
	 * @return the circle cd
	 */
	public String getCircleCd() {
		return circleCd;
	}

	/**
	 * Sets the circle cd.
	 *
	 * @param circleCd the new circle cd
	 */
	public void setCircleCd(String circleCd) {
		this.circleCd = circleCd;
	}

	/**
	 * Gets the circle name.
	 *
	 * @return the circle name
	 */
	public String getCircleName() {
		return circleName;
	}

	/**
	 * Sets the circle name.
	 *
	 * @param circleName the new circle name
	 */
	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	/**
	 * Gets the circle name guj.
	 *
	 * @return the circle name guj
	 */
	public String getCircleNameGuj() {
		return circleNameGuj;
	}

	/**
	 * Sets the circle name guj.
	 *
	 * @param circleNameGuj the new circle name guj
	 */
	public void setCircleNameGuj(String circleNameGuj) {
		this.circleNameGuj = circleNameGuj;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocMsCircleEntity))
			return false;
		LocMsCircleEntity that = (LocMsCircleEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(circleCd, that.circleCd)
				&& Objects.equals(circleName, that.circleName) && Objects.equals(circleNameGuj, that.circleNameGuj);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, circleCd, circleName, circleNameGuj);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocMsCircle{" + "id=" + id + ", circleCd=" + circleCd + ", circleName='" + circleName + '\''
				+ ", circleNameGuj='" + circleNameGuj + '\'' + '}';
	}

}