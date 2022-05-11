package gov.ifms.edp.entity;

import gov.ifms.common.util.Constant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsSubTypeEntity.
 */
@Entity
@Table(name = "MS_SUB_TYPE", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsSubTypeEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The subTypeId. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUB_TYPE_ID")
	private Long subTypeId;

	/** The subTypeName. */
	@Column(name = "SUBTYPE_NAME")
	private String subTypeName;

	/** The parentSubTypeId. */
	@Column(name = "PARENT_SUBTYPE_ID")
	private Long parentSubTypeId;

	public Long getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(Long subTypeId) {
		this.subTypeId = subTypeId;
	}

	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

	public Long getParentSubTypeId() {
		return parentSubTypeId;
	}

	public void setParentSubTypeId(Long parentSubTypeId) {
		this.parentSubTypeId = parentSubTypeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof EDPMsSubTypeEntity)) return false;
		EDPMsSubTypeEntity that = (EDPMsSubTypeEntity) o;
		return Objects.equals(getSubTypeId(), that.getSubTypeId()) && Objects.equals(getSubTypeName(), that.getSubTypeName()) && Objects.equals(getParentSubTypeId(), that.getParentSubTypeId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSubTypeId(), getSubTypeName(), getParentSubTypeId());
	}
}
