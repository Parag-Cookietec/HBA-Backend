package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUMsGradePayDto.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 *
 */
public class PVUMsGradePayDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The grade pay id. */
	private long gradePayId;

	/** The pay band id. */
	private long payBandId;

	/** The grade pay value. */
	private String gradePayValue;

	/**
	 * PVUMsGradePayDto Constructor.
	 */
	public PVUMsGradePayDto() {
		super();
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the grade pay id
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the new grade pay id
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the pay band id
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the new pay band id
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
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
		return Objects.hash(gradePayId, gradePayValue, payBandId);
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
		if (!(obj instanceof PVUMsGradePayDto)) {
			return false;
		}
		PVUMsGradePayDto other = (PVUMsGradePayDto) obj;
		return Objects.equals(gradePayId, other.gradePayId) && Objects.equals(gradePayValue, other.gradePayValue)
				&& Objects.equals(payBandId, other.payBandId);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */

	@Override
	public String toString() {
		return "PVUMsGradePayDto [gradePayId = " + gradePayId + ",payBandId = " + payBandId + ",gradePayValue = "
				+ gradePayValue + ",]";
	}

}
