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
 * The Class EDPtusrRgMapWfDtlItrEntity.
 * 
 * @version 1.0
 * @created 2020/07/16 09:35:32
 *
 */
@Entity
@Table(name = "T_USRRG_MP_WF_DTLITR", schema = Constant.EDP_SCHEMA)
public class EDPtusrRgMapWfDtlItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TUSRRGMP_WF_DTLITRID")
	private Long tusrRgMapWfDtlItrId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USRRG_MAP_WF_DTLID", referencedColumnName = "T_USRRG_MAP_WF_DTLID")
	private EDPtusrRgMapWfDtlEntity tusrRgMapWfDtlId;

	/** The tusr rg map dtl id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_USR_RG_MAP_DTL_ID", referencedColumnName = "T_USR_RG_MAP_DTL_ID")
	private EDPtusrRgMapDtlEntity tusrRgMapDtlId;

	/** The wf role id. */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/** The old wf role id. */
	@Column(name = "OLD_WF_ROLE_ID")
	private Long oldWfRoleId;

	/** The is removed. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IS_REMOVED", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity isRemoved;

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
	public EDPtusrRgMapWfDtlEntity getTusrRgMapWfDtlId() {
		return tusrRgMapWfDtlId;
	}

	/**
	 * @param tusrRgMapWfDtlId the tusrRgMapWfDtlId to set
	 */
	public void setTusrRgMapWfDtlId(EDPtusrRgMapWfDtlEntity tusrRgMapWfDtlId) {
		this.tusrRgMapWfDtlId = tusrRgMapWfDtlId;
	}

	/**
	 * @return the tusrRgMapDtlId
	 */
	public EDPtusrRgMapDtlEntity getTusrRgMapDtlId() {
		return tusrRgMapDtlId;
	}

	/**
	 * @param tusrRgMapDtlId the tusrRgMapDtlId to set
	 */
	public void setTusrRgMapDtlId(EDPtusrRgMapDtlEntity tusrRgMapDtlId) {
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
	public EDPLuLookUpInfoEntity getIsRemoved() {
		return isRemoved;
	}

	/**
	 * @param isRemoved the isRemoved to set
	 */
	public void setIsRemoved(EDPLuLookUpInfoEntity isRemoved) {
		this.isRemoved = isRemoved;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isRemoved, oldWfRoleId, tusrRgMapDtlId, tusrRgMapWfDtlId, tusrRgMapWfDtlItrId, wfRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapWfDtlItrEntity)) {
			return false;
		}
		EDPtusrRgMapWfDtlItrEntity other = (EDPtusrRgMapWfDtlItrEntity) obj;
		return Objects.equals(isRemoved, other.isRemoved) && Objects.equals(oldWfRoleId, other.oldWfRoleId)
				&& Objects.equals(tusrRgMapDtlId, other.tusrRgMapDtlId)
				&& Objects.equals(tusrRgMapWfDtlId, other.tusrRgMapWfDtlId)
				&& Objects.equals(tusrRgMapWfDtlItrId, other.tusrRgMapWfDtlItrId)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}
	
	
}
