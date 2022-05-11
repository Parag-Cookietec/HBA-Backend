package gov.ifms.pvu.entity;

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
 * The Class PVUMsReasonEntity.
 * 
 * @version v 1.0
 * @created 2020/04/14 02:50:39
 *
 */
@Entity
@Table(name = "MS_REASON", schema = Constant.PVU_SCHEMA_MASTER)
public class PVUMsReasonEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REASON_ID")
	private Long id;

	@Column(name = "REASON_NAME")
	private String reasonName;

	@Column(name = "REASON_DESC")
	private String reasonDesc;

	@Column(name = "REASON_TYPE")
	private String reasonType;

	/**
	 * PVUMsReasonEntity Constructor
	 */
	public PVUMsReasonEntity() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the reasonName
	 */
	public String getReasonName() {
		return reasonName;
	}

	/**
	 * @param reasonName the reasonName to set
	 */
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}

	/**
	 * @return the reasonDesc
	 */
	public String getReasonDesc() {
		return reasonDesc;
	}

	/**
	 * @param reasonDesc the reasonDesc to set
	 */
	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	/**
	 * @return the reasonType
	 */
	public String getReasonType() {
		return reasonType;
	}

	/**
	 * @param reasonType the reasonType to set
	 */
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reasonDesc, reasonName, reasonType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUMsReasonEntity)) {
			return false;
		}
		PVUMsReasonEntity other = (PVUMsReasonEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(reasonDesc, other.reasonDesc)
				&& Objects.equals(reasonName, other.reasonName) && Objects.equals(reasonType, other.reasonType);
	}

	@Override
	public String toString() {
		return String.format("PVUMsReasonEntity [id=%s, reasonName=%s, reasonDesc=%s, reasonType=%s]", id, reasonName,
				reasonDesc, reasonType);
	}

}
