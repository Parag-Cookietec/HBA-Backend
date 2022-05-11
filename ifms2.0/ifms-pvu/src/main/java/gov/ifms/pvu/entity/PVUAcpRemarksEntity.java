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
 * The Class PVURopRemarksEntityEntity.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
@Entity
@Table(name = "PVU_AP_EVNT_REMARKS", schema = Constant.PVU_SCHEMA)
public class PVUAcpRemarksEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AP_EVNT_REMARKS_ID")
	private Long id;

	/** The rp event id. */
	@Column(name = "AP_EVNT_ID")
	private Long rpEventId;

	/** The work flow role id. */
	@Column(name = "WORKFLOW_ROLE_ID")
	private Long workFlowRoleId;

	/** The emp id. */
	@Column(name = "EMP_ID")
	private Long empId;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The remarks type. */
	@Column(name = "REMARK_TYPE")
	private String remarksType;

	/** The reason. */
	@Column(name = "REASON")
	private Long reason;

	/**
	 * PVURopRemarksEntityEntity Constructor.
	 */
	public PVUAcpRemarksEntity() {
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
	 * @return the rpEventId
	 */
	public Long getRpEventId() {
		return rpEventId;
	}

	/**
	 * @param rpEventId the rpEventId to set
	 */
	public void setRpEventId(Long rpEventId) {
		this.rpEventId = rpEventId;
	}

	/**
	 * @return the workFlowRoleId
	 */
	public Long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	/**
	 * @param workFlowRoleId the workFlowRoleId to set
	 */
	public void setWorkFlowRoleId(Long workFlowRoleId) {
		this.workFlowRoleId = workFlowRoleId;
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

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the remarksType
	 */
	public String getRemarksType() {
		return remarksType;
	}

	/**
	 * @param remarksType the remarksType to set
	 */
	public void setRemarksType(String remarksType) {
		this.remarksType = remarksType;
	}

	/**
	 * @return the reason
	 */
	public Long getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(Long reason) {
		this.reason = reason;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(empId, id, reason, remarks, remarksType, rpEventId, workFlowRoleId);
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
		if (!(obj instanceof PVUAcpRemarksEntity)) {
			return false;
		}
		PVUAcpRemarksEntity other = (PVUAcpRemarksEntity) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(id, other.id)
				&& Objects.equals(reason, other.reason) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(remarksType, other.remarksType) && Objects.equals(rpEventId, other.rpEventId)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVURopRemarksEntityEntity [id=%s, rpEventId=%s, workFlowRoleId=%s, empId=%s, remarks=%s, remarksType=%s, reason=%s]",
				id, rpEventId, workFlowRoleId, empId, remarks, remarksType, reason);
	}

}
