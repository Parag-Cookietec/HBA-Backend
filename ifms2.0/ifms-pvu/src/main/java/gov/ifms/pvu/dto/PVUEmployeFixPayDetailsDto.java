package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeFixPayDetailsDto.
 * 
 * @version v 1.0
 * @created 2020/01/08 20:46:39
 *
 */
public class PVUEmployeFixPayDetailsDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The fix pay value. */
	private long fixPayValue;
	private String fixPayValueName;

	/** The fix pay id. */
	private long fixPayId;

	/** The eff date. */
	private Date effDate;

	/** The emp id. */
	private long empId;

	/**
	 * PVUEmployeFixPayDetailsDto Constructor.
	 */
	public PVUEmployeFixPayDetailsDto() {
		super();
	}

	/**
	 * Gets the fix pay id.
	 *
	 * @return the fixPayId
	 */
	public long getFixPayId() {
		return fixPayId;
	}

	/**
	 * Sets the fix pay id.
	 *
	 * @param fixPayId the fixPayId to set
	 */
	public void setFixPayId(long fixPayId) {
		this.fixPayId = fixPayId;
	}

	/**
	 * Gets the eff date.
	 *
	 * @return the effDate
	 */
	public Date getEffDate() {
		return effDate;
	}

	/**
	 * Sets the eff date.
	 *
	 * @param effDate the effDate to set
	 */
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the fix pay value.
	 *
	 * @return the fix pay value
	 */
	public long getFixPayValue() {
		return fixPayValue;
	}

	/**
	 * Sets the fix pay value.
	 *
	 * @param fixPayValue the new fix pay value
	 */
	public void setFixPayValue(long fixPayValue) {
		this.fixPayValue = fixPayValue;
	}

	/**
	 * @return the fixPayValueName
	 */
	public String getFixPayValueName() {
		return fixPayValueName;
	}

	/**
	 * @param fixPayValueName the fixPayValueName to set
	 */
	public void setFixPayValueName(String fixPayValueName) {
		this.fixPayValueName = fixPayValueName;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(effDate, empId, fixPayId, fixPayValue);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUEmployeFixPayDetailsDto other = (PVUEmployeFixPayDetailsDto) obj;
		return Objects.equals(effDate, other.effDate) && empId == other.empId && fixPayId == other.fixPayId
				&& fixPayValue == other.fixPayValue;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeFixPayDetailsDto [fixPayValue=" + fixPayValue + ", fixPayId=" + fixPayId + ", effDate="
				+ effDate + ", empId=" + empId + "]";
	}

}
