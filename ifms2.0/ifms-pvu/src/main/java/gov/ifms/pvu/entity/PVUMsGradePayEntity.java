package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUMsGradePayEntity.
 */
@Entity
@Table(name = "MS_GRADE_PAY", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsGradePayEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The grade pay id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GRADE_PAY_ID")
	private long id;

	/** The pay band id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAY_BAND_ID")
	private PVUMsPayBandEntity payBand;

	/** The grade pay value. */
	@Column(name = "GRADE_PAY_VALUE")
	private String gradePayValue;

	/**
	 * PVUMsGradePayEntity Constructor.
	 */
	public PVUMsGradePayEntity() {
		super();
	}

	/**
	 * @param id Constructor for set id
	 */
	public PVUMsGradePayEntity(long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the gradePay.
	 *
	 * @param id the id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the pay band id
	 */
	public PVUMsPayBandEntity getPayBand() {
		return payBand;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBand the payBand id
	 */
	public void setPayBand(PVUMsPayBandEntity payBand) {
		this.payBand = payBand;
	}

	/**
	 * Gets the grade pay value.
	 *
	 * @return the grade pay value
	 */
	public String getGradePayValue() {
		return gradePayValue;
	}

	/**
	 * Sets the grade pay value.
	 *
	 * @param gradePayValue the new grade pay value
	 */
	public void setGradePayValue(String gradePayValue) {
		this.gradePayValue = gradePayValue;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, gradePayValue, payBand);
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
		if (!(obj instanceof PVUMsGradePayEntity)) {
			return false;
		}
		PVUMsGradePayEntity other = (PVUMsGradePayEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(gradePayValue, other.gradePayValue)
				&& Objects.equals(payBand, other.payBand);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUMsGradePayEntity [id=" + id + ", payBandId=" + payBand + ", gradePayValue="
				+ gradePayValue + "]";
	}

}
