package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapWfDtlItrDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:35:32
 *
 */
public class EDPtusrRgMapWfDtlItrDto extends BaseDto implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map wf dtl itr id. */
	private Long tusrRgMapWfDtlItrId;
	
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
	 * @return the tusrRgMapWfDtlItrId
	 */
	public Long getTusrRgMapWfDtlItrId() {
		return tusrRgMapWfDtlItrId;
	}

	/**
	 * @param tusrRgMapWfDtlItrId the tusrRgMapWfDtlItrId to set
	 */
	public void setTusrRgMapWfDtlItrId(Long tusrRgMapWfDtlItrId) {
		this.tusrRgMapWfDtlItrId = tusrRgMapWfDtlItrId;
	}

	/**
	 * @return the tusrRgMapWfDtlId
	 */
	public Long getTusrRgMapWfDtlId() {
		return tusrRgMapWfDtlId;
	}

	/**
	 * @param tusrRgMapWfDtlId the tusrRgMapWfDtlId to set
	 */
	public void setTusrRgMapWfDtlId(Long tusrRgMapWfDtlId) {
		this.tusrRgMapWfDtlId = tusrRgMapWfDtlId;
	}

	/**
	 * @return the tusrRgMapDtlId
	 */
	public Long getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(Long tusrRgMapDtlId) {
		this.tusrRgMapDtlId = tusrRgMapDtlId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the oldWfRoleId
	 */
	public Long getOldWfRoleId() {
		return oldWfRoleId;
	}

	/**
	 * @param oldWfRoleId the oldWfRoleId to set
	 */
	public void setOldWfRoleId(Long oldWfRoleId) {
		this.oldWfRoleId = oldWfRoleId;
	}

	/**
	 * @return the isRemoved
	 */
	public Long getIsRemoved() {
		return isRemoved;
	}

	/**
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(Long isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(isRemoved, oldWfRoleId, tusrRgMapDtlId, tusrRgMapWfDtlId, tusrRgMapWfDtlItrId, wfRoleId);
		return result;
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapWfDtlItrDto)) {
			return false;
		}
		EDPtusrRgMapWfDtlItrDto other = (EDPtusrRgMapWfDtlItrDto) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(oldWfRoleId, other.oldWfRoleId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapWfDtlId, other.tusrRgMapWfDtlId)
				&& Objects.equals(tusrRgMapWfDtlItrId, other.tusrRgMapWfDtlItrId)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}

	
}
