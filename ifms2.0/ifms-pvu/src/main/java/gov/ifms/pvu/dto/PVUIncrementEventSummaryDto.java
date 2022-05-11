package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUIncrementEventSummaryDto.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 *
 */
public class PVUIncrementEventSummaryDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in smry id. */
	private long inSmryId;

	/** The in event id. */
	private long inEventId;

	/** The class one incl count. */
	private long classOneInclCount;

	/** The class two incl count. */
	private long classTwoInclCount;

	/** The class three incl count. */
	private long classThreeInclCount;

	/** The class four incl count. */
	private long classFourInclCount;

	/** The class one excl count. */
	private long classOneExclCount;

	/** The class two excl count. */
	private long classTwoExclCount;

	/** The class three excl count. */
	private long classThreeExclCount;

	/** The class four excl count. */
	private long classFourExclCount;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private long statusId;

	/**
	 * Gets the in smry id.
	 *
	 * @return the inSmryId
	 */
	public long getInSmryId() {
		return inSmryId;
	}

	/**
	 * Sets the in smry id.
	 *
	 * @param inSmryId the inSmryId to set
	 */
	public void setInSmryId(long inSmryId) {
		this.inSmryId = inSmryId;
	}

	/**
	 * Gets the in event id.
	 *
	 * @return the inEventId
	 */
	public long getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(long inEventId) {
		this.inEventId = inEventId;
	}

	/**
	 * Gets the class one incl count.
	 *
	 * @return the classOneInclCount
	 */
	public long getClassOneInclCount() {
		return classOneInclCount;
	}

	/**
	 * Sets the class one incl count.
	 *
	 * @param classOneInclCount the classOneInclCount to set
	 */
	public void setClassOneInclCount(long classOneInclCount) {
		this.classOneInclCount = classOneInclCount;
	}

	/**
	 * Gets the class two incl count.
	 *
	 * @return the classTwoInclCount
	 */
	public long getClassTwoInclCount() {
		return classTwoInclCount;
	}

	/**
	 * Sets the class two incl count.
	 *
	 * @param classTwoInclCount the classTwoInclCount to set
	 */
	public void setClassTwoInclCount(long classTwoInclCount) {
		this.classTwoInclCount = classTwoInclCount;
	}

	/**
	 * Gets the class three incl count.
	 *
	 * @return the classThreeInclCount
	 */
	public long getClassThreeInclCount() {
		return classThreeInclCount;
	}

	/**
	 * Sets the class three incl count.
	 *
	 * @param classThreeInclCount the classThreeInclCount to set
	 */
	public void setClassThreeInclCount(long classThreeInclCount) {
		this.classThreeInclCount = classThreeInclCount;
	}

	/**
	 * Gets the class four incl count.
	 *
	 * @return the classFourInclCount
	 */
	public long getClassFourInclCount() {
		return classFourInclCount;
	}

	/**
	 * Sets the class four incl count.
	 *
	 * @param classFourInclCount the classFourInclCount to set
	 */
	public void setClassFourInclCount(long classFourInclCount) {
		this.classFourInclCount = classFourInclCount;
	}

	/**
	 * Gets the class one excl count.
	 *
	 * @return the classOneExclCount
	 */
	public long getClassOneExclCount() {
		return classOneExclCount;
	}

	/**
	 * Sets the class one excl count.
	 *
	 * @param classOneExclCount the classOneExclCount to set
	 */
	public void setClassOneExclCount(long classOneExclCount) {
		this.classOneExclCount = classOneExclCount;
	}

	/**
	 * Gets the class two excl count.
	 *
	 * @return the classTwoExclCount
	 */
	public long getClassTwoExclCount() {
		return classTwoExclCount;
	}

	/**
	 * Sets the class two excl count.
	 *
	 * @param classTwoExclCount the classTwoExclCount to set
	 */
	public void setClassTwoExclCount(long classTwoExclCount) {
		this.classTwoExclCount = classTwoExclCount;
	}

	/**
	 * Gets the class three excl count.
	 *
	 * @return the classThreeExclCount
	 */
	public long getClassThreeExclCount() {
		return classThreeExclCount;
	}

	/**
	 * Sets the class three excl count.
	 *
	 * @param classThreeExclCount the classThreeExclCount to set
	 */
	public void setClassThreeExclCount(long classThreeExclCount) {
		this.classThreeExclCount = classThreeExclCount;
	}

	/**
	 * Gets the class four excl count.
	 *
	 * @return the classFourExclCount
	 */
	public long getClassFourExclCount() {
		return classFourExclCount;
	}

	/**
	 * Sets the class four excl count.
	 *
	 * @param classFourExclCount the classFourExclCount to set
	 */
	public void setClassFourExclCount(long classFourExclCount) {
		this.classFourExclCount = classFourExclCount;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(classFourExclCount, classFourInclCount, classOneExclCount, classOneInclCount,
				classThreeExclCount, classThreeInclCount, classTwoExclCount, classTwoInclCount, inEventId, inSmryId,
				remarks, statusId);
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
		if (!(obj instanceof PVUIncrementEventSummaryDto)) {
			return false;
		}
		PVUIncrementEventSummaryDto other = (PVUIncrementEventSummaryDto) obj;
		return classFourExclCount == other.classFourExclCount && classFourInclCount == other.classFourInclCount
				&& classOneExclCount == other.classOneExclCount && classOneInclCount == other.classOneInclCount
				&& classThreeExclCount == other.classThreeExclCount && classThreeInclCount == other.classThreeInclCount
				&& classTwoExclCount == other.classTwoExclCount && classTwoInclCount == other.classTwoInclCount
				&& inEventId == other.inEventId && inSmryId == other.inSmryId && Objects.equals(remarks, other.remarks)
				&& statusId == other.statusId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUIncrementEventSummaryDto [inSmryId=" + inSmryId + ", inEventId=" + inEventId + ", classOneInclCount="
				+ classOneInclCount + ", classTwoInclCount=" + classTwoInclCount + ", classThreeInclCount="
				+ classThreeInclCount + ", classFourInclCount=" + classFourInclCount + ", classOneExclCount="
				+ classOneExclCount + ", classTwoExclCount=" + classTwoExclCount + ", classThreeExclCount="
				+ classThreeExclCount + ", classFourExclCount=" + classFourExclCount + ", remarks=" + remarks
				+ ", statusId=" + statusId + "]";
	}

	
}
