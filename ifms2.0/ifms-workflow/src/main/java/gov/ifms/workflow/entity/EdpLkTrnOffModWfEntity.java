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
 * The Class EdpLkTrnOffModWfEntity.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 *
 */
@Entity
@Table(name = "LK_TEDP_OFFMODWF", schema = Constant.EDP_SCHEMA)
public class EdpLkTrnOffModWfEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_OFFMODWF_ID")
	private long edpWfLkTrnId;

	@Column(name = "T_EDPOFFMOD_WF_ID")
	private long edpWfTrnId;

	@Column(name = "MENU_ID")
	private long menuId;
	
	@Column(name = "T_EDP_OFF_ATTACH_ID")
	private long edpWfAttachId;

	public EdpLkTrnOffModWfEntity() {
		super();
	}

	/**
	 * @return the edpWfLkTrnId
	 */
	public long getEdpWfLkTrnId() {
		return edpWfLkTrnId;
	}

	/**
	 * @param edpWfLkTrnId the edpWfLkTrnId to set
	 */
	public void setEdpWfLkTrnId(long edpWfLkTrnId) {
		this.edpWfLkTrnId = edpWfLkTrnId;
	}

	/**
	 * @return the edpWfTrnId
	 */
	public long getEdpWfTrnId() {
		return edpWfTrnId;
	}

	/**
	 * @param edpWfTrnId the edpWfTrnId to set
	 */
	public void setEdpWfTrnId(long edpWfTrnId) {
		this.edpWfTrnId = edpWfTrnId;
	}

	/**
	 * @return the menuId
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the edpWfAttachId
	 */
	public long getEdpWfAttachId() {
		return edpWfAttachId;
	}

	/**
	 * @param edpWfAttachId the edpWfAttachId to set
	 */
	public void setEdpWfAttachId(long edpWfAttachId) {
		this.edpWfAttachId = edpWfAttachId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edpWfAttachId, edpWfLkTrnId, edpWfTrnId, menuId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EdpLkTrnOffModWfEntity)) {
			return false;
		}
		EdpLkTrnOffModWfEntity other = (EdpLkTrnOffModWfEntity) obj;
		return edpWfAttachId == other.edpWfAttachId && edpWfLkTrnId == other.edpWfLkTrnId
				&& edpWfTrnId == other.edpWfTrnId && menuId == other.menuId;
	}

}
