package gov.ifms.workflow.entity;

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
 * The Class PvuLkTrnEmpCrWfEntity.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Entity
@Table(name = "LK_TPVUEMPCR_WF", schema = Constant.PVU_SCHEMA)
public class PvuLkTrnEmpCrWfEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LK_TPVUEMPCR_WF_ID")
	private long pvuWfLkTrnId;

	@Column(name = "T_PVU_EMPCR_WF_ID")
	private long pvuWfTrnId;

	@Column(name = "T_PVU_EMP_ATT_ID")
	private long pvuWfAttachId;

	public PvuLkTrnEmpCrWfEntity() {
		super();
	}

	/**
	 * @return the pvuWfLkTrnId
	 */
	public long getPvuWfLkTrnId() {
		return pvuWfLkTrnId;
	}

	/**
	 * @param pvuWfLkTrnId the pvuWfLkTrnId to set
	 */
	public void setPvuWfLkTrnId(long pvuWfLkTrnId) {
		this.pvuWfLkTrnId = pvuWfLkTrnId;
	}

	/**
	 * @return the pvuWfTrnId
	 */
	public long getPvuWfTrnId() {
		return pvuWfTrnId;
	}

	/**
	 * @param pvuWfTrnId the pvuWfTrnId to set
	 */
	public void setPvuWfTrnId(long pvuWfTrnId) {
		this.pvuWfTrnId = pvuWfTrnId;
	}

	/**
	 * @return the pvuWfAttachId
	 */
	public long getPvuWfAttachId() {
		return pvuWfAttachId;
	}

	/**
	 * @param pvuWfAttachId the pvuWfAttachId to set
	 */
	public void setPvuWfAttachId(long pvuWfAttachId) {
		this.pvuWfAttachId = pvuWfAttachId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pvuWfAttachId, pvuWfLkTrnId, pvuWfTrnId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PvuLkTrnEmpCrWfEntity)) {
			return false;
		}
		PvuLkTrnEmpCrWfEntity other = (PvuLkTrnEmpCrWfEntity) obj;
		return pvuWfAttachId == other.pvuWfAttachId && pvuWfLkTrnId == other.pvuWfLkTrnId
				&& pvuWfTrnId == other.pvuWfTrnId;
	}
}
