package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TEDP_BULK_EMP_CREATION", schema = Constant.EDP_SCHEMA)
public class EDPBulkEmployeeCreationEntity extends BaseEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The designation attach id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEDP_BULK_EMP_CREATION_ID")
	private Long becId;
	
	/** The transaction id. */
	@Column(name = "TRN_NO")
	private String trnNo;
	
	/** The status id. */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * @return the becId
	 */
	public Long getBecId() {
		return becId;
	}

	/**
	 * @param becId the becId to set
	 */
	public void setBecId(Long becId) {
		this.becId = becId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(becId, statusId, trnNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPBulkEmployeeCreationEntity)) {
			return false;
		}
		EDPBulkEmployeeCreationEntity other = (EDPBulkEmployeeCreationEntity) obj;
		return Objects.equals(becId, other.becId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo);
	}

	@Override
	public String toString() {
		return "EDPBulkEmployeeCreationEntity [becId=" + becId + ", trnNo=" + trnNo + ", statusId=" + statusId + "]";
	}

	
	

}
