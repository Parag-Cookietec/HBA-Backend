package gov.ifms.edp.entity;

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

/**
 * The Class EDPtusrRgMapWfDtlEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:34:26
 *
 */
@Entity
@Table(name = "T_USR_RG_MAP_WF_DTL" , schema = Constant.EDP_SCHEMA)
public class EDPtusrRgMapWfDtlEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map wf dtl id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USRRG_MAP_WF_DTLID")
	private Long tusrRgMapWfDtlId;

	/** The tusr rg map dtl id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USR_RG_MAP_DTL_ID", referencedColumnName = "T_USR_RG_MAP_DTL_ID")
	private EDPtusrRgMapDtlEntity tusrRgMapDtlId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The old wf role id. */
	@Column(name = "OLD_WF_ROLE_ID")
	private String oldWfRoleId;

	/** The is removed. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_REMOVED", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isRemoved;

	/**
	 * Gets the tusr rg map wf dtl id.
	 *
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
	public EDPtusrRgMapDtlEntity getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * Sets the tusr rg map dtl id.
	 *
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(EDPtusrRgMapDtlEntity tusrRgMapDtlId) {
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
	public String getOldWfRoleId() {
		return oldWfRoleId;
	}

	/**
	 * Sets the old wf role id.
	 *
	 * @param oldWfRoleId the oldWfRoleId to set
	 */
	public void setOldWfRoleId(String oldWfRoleId) {
		this.oldWfRoleId = oldWfRoleId;
	}

	/**
	 * Gets the checks if is removed.
	 *
	 * @return the isRemoved
	 */
	public EDPLuLookUpInfoEntity getIsRemoved() {
		return isRemoved;
	}

	/**
	 * Sets the checks if is removed.
	 *
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(EDPLuLookUpInfoEntity isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
	 * Gets the serialversionuid.
	 *
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
		return Objects.hash(isRemoved, oldWfRoleId, tusrRgMapDtlId, tusrRgMapWfDtlId, wfRoleId);
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
		if (!(obj instanceof EDPtusrRgMapWfDtlEntity)) {
			return false;
		}
		EDPtusrRgMapWfDtlEntity other = (EDPtusrRgMapWfDtlEntity) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(oldWfRoleId, other.oldWfRoleId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapWfDtlId, other.tusrRgMapWfDtlId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

}
