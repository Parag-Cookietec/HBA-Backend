package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVURevisionOfPayEntity.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
/**
 * @author Admin
 *
 */

/**
 * @author Admin
 *
 */
@Entity
@Table(name = "PVU_EVNT_RMKS", schema = Constant.PVU_SCHEMA)
public class PVUEventRemarksEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PVU_EVNT_RMKS_ID")
	private Long id;

	/** The trans no. */
	@Column(name = "EVNT_TRN_ID")
	private Long trnNo;

	/** The trans no. */
	@Column(name = "PVU_EVNT_ID")
	private Long eventID;

	/** The status id. */

	@Column(name = "WORKFLOW_ROLE_ID")
	private Long wfRoleId;

	/** The emp id. */

	@Column(name = "EMP_ID")
	private Long empId;

	/** The rop type. */

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "REMARK_TYPE")
	private String remarksType;

	@Column(name = "reason")
	private Long reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(Long trnNo) {
		this.trnNo = trnNo;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarksType() {
		return remarksType;
	}

	public void setRemarksType(String remarksType) {
		this.remarksType = remarksType;
	}

	public Long getReason() {
		return reason;
	}

	public void setReason(Long reason) {
		this.reason = reason;
	}

	public PVUEventRemarksEntity() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PVUEventRemarksEntity that = (PVUEventRemarksEntity) o;
		return Objects.equals(id, that.id) && Objects.equals(trnNo, that.trnNo)
				&& Objects.equals(wfRoleId, that.wfRoleId) && Objects.equals(empId, that.empId)
				&& Objects.equals(remarks, that.remarks) && Objects.equals(remarksType, that.remarksType)
				&& Objects.equals(reason, that.reason);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, trnNo, wfRoleId, empId, remarks, remarksType, reason);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PVUEventRemarksEntity.class.getSimpleName() + "[", "]").add("id=" + id)
				.add("trnNo=" + trnNo).add("wfRoleId=" + wfRoleId).add("empId=" + empId)
				.add("remarks='" + remarks + "'").add("remarksType='" + remarksType + "'")
				.add("reason='" + reason + "'").toString();
	}

	/**
	 * @return the eventID
	 */
	public Long getEventID() {
		return eventID;
	}

	/**
	 * @param eventID the eventID to set
	 */
	public void setEventID(Long eventID) {
		this.eventID = eventID;
	}

}
