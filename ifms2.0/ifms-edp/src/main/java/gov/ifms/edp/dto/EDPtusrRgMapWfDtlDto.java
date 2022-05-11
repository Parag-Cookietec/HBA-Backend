package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapWfDtlDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:34:26
 *
 */
public class EDPtusrRgMapWfDtlDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map wf dtl id. */
	private Long tusrRgMapWfDtlId;

	/** The tusr rg map dtl id. */
	private Long tusrRgMapDtlId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The old wf role id. */
	private Long oldWfRoleId;

	/** The is removed. */
	private Long isRemoved;

	/**
	 * EDPtusrRgMapWfDtlDto Constructor.
	 */
	public EDPtusrRgMapWfDtlDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tusrRgMapWfDtlId, tusrRgMapDtlId, wfRoleId, oldWfRoleId, isRemoved);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof EDPtusrRgMapWfDtlDto)) {
			return false;
		}

		EDPtusrRgMapWfDtlDto other = (EDPtusrRgMapWfDtlDto) obj;

		return Objects.equals(tusrRgMapWfDtlId, other.tusrRgMapWfDtlId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId) && Objects.equals(wfRoleId, other.wfRoleId)
				&& Objects.equals(oldWfRoleId, other.oldWfRoleId) && Objects.equals(isRemoved, other.isRemoved);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPtusrRgMapWfDtlDto [tusrRgMapWfDtlId = " + tusrRgMapWfDtlId + ",tusrRgMapDtlId = " + tusrRgMapDtlId
				+ ",wfRoleId = " + wfRoleId + ",oldWfRoleId = " + oldWfRoleId + ",isRemoved = " + isRemoved + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the tusr rg map wf dtl id
	 */

	/**
	 * @return the tusrRgMapWfDtlId
	 */
	public Long getTusrRgMapWfDtlId() {
		return tusrRgMapWfDtlId;
	}

	/**
	 * Sets the tusr rg map wf dtl id.
	 *
	 * @param tusrRgMapWfDtlId the tusrRgMapWfDtlId to set
	 */
	public void setTusrRgMapWfDtlId(Long tusrRgMapWfDtlId) {
		this.tusrRgMapWfDtlId = tusrRgMapWfDtlId;
	}

	/**
	 * Gets the tusr rg map dtl id.
	 *
	 * @return the tusrRgMapDtlId
	 */
	public Long getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * Sets the tusr rg map dtl id.
	 *
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(Long tusrRgMapDtlId) {
		this.tusrRgMapDtlId = tusrRgMapDtlId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the old wf role id.
	 *
	 * @return the oldWfRoleId
	 */
	public Long getOldWfRoleId() {
		return oldWfRoleId;
	}

	/**
	 * Sets the old wf role id.
	 *
	 * @param oldWfRoleId the oldWfRoleId to set
	 */
	public void setOldWfRoleId(Long oldWfRoleId) {
		this.oldWfRoleId = oldWfRoleId;
	}

	/**
	 * Gets the checks if is removed.
	 *
	 * @return the isRemoved
	 */
	public Long getIsRemoved() {
		return isRemoved;
	}

	/**
	 * Sets the checks if is removed.
	 *
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(Long isRemoved) {
		this.isRemoved = isRemoved;
	}

}
