package gov.ifms.pvu.entity;

import java.io.Serializable;
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
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

 /**
 * The Class PVUIncrementEventSummaryEntity.
 * 
 * @version v 1.0
 * @created 2020/01/10 15:30:02
 *
 */
@Entity
@Table(name = "T_PVU_IN_SMRY", schema = Constant.PVU_SCHEMA)
public class PVUIncrementEventSummaryEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in smry id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_SMRY_ID")
	private long inSmryId;

	/** The in event id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_IN_EVNT_ID", nullable = false, referencedColumnName = "T_PVU_IN_EVNT_ID")
	private PVUIncrementEventEntity inEventId;

	/** The class one incl count. */
	@Column(name = "CLASS_1_INCL_COUNT")
	private long classOneInclCount;

	/** The class two incl count. */
	@Column(name = "CLASS_2_INCL_COUNT")
	private long classTwoInclCount;

	/** The class three incl count. */
	@Column(name = "CLASS_3_INCL_COUNT")
	private long classThreeInclCount;

	/** The class four incl count. */
	@Column(name = "CLASS_4_INCL_COUNT")
	private long classFourInclCount;

	/** The class one excl count. */
	@Column(name = "CLASS_1_EXCL_COUNT")
	private long classOneExclCount;

	/** The class two excl count. */
	@Column(name = "CLASS_2_EXCL_COUNT")
	private long classTwoExclCount;

	/** The class three excl count. */
	@Column(name = "CLASS_3_EXCL_COUNT")
	private long classThreeExclCount;

	/** The class four excl count. */
	@Column(name = "CLASS_4_EXCL_COUNT")
	private long classFourExclCount;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/**
	 * PVUIncrementEventSummaryEntity Constructor.
	 */
	public PVUIncrementEventSummaryEntity() {
		super();
	}

	public PVUIncrementEventSummaryEntity(Long inSmryId) {
		this.inSmryId = inSmryId;
	}

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
	public PVUIncrementEventEntity getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(PVUIncrementEventEntity inEventId) {
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
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
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
		if (!(obj instanceof PVUIncrementEventSummaryEntity)) {
			return false;
		}
		PVUIncrementEventSummaryEntity other = (PVUIncrementEventSummaryEntity) obj;
		return classFourExclCount == other.classFourExclCount && classFourInclCount == other.classFourInclCount
				&& classOneExclCount == other.classOneExclCount && classOneInclCount == other.classOneInclCount
				&& classThreeExclCount == other.classThreeExclCount && classThreeInclCount == other.classThreeInclCount
				&& classTwoExclCount == other.classTwoExclCount && classTwoInclCount == other.classTwoInclCount
				&& Objects.equals(inEventId, other.inEventId) && inSmryId == other.inSmryId
				&& Objects.equals(remarks, other.remarks) && Objects.equals(statusId, other.statusId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUIncrementEventSummaryEntity [inSmryId=" + inSmryId + ", inEventId=" + inEventId
				+ ", classOneInclCount=" + classOneInclCount + ", classTwoInclCount=" + classTwoInclCount
				+ ", classThreeInclCount=" + classThreeInclCount + ", classFourInclCount=" + classFourInclCount
				+ ", classOneExclCount=" + classOneExclCount + ", classTwoExclCount=" + classTwoExclCount
				+ ", classThreeExclCount=" + classThreeExclCount + ", classFourExclCount=" + classFourExclCount
				+ ", remarks=" + remarks + ", statusId=" + statusId + "]";
	}
	
	
}
