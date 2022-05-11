package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class PVUEmployeEntity.
 *
 * @version v 1.0
 * @created 2019/11/22 01:17:36
 *
 */
@Entity
@Table(name = "RP_EVNT_REMARKS_ID", schema = Constant.PVU_SCHEMA)
public class PVURopEventRemarksEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RP_EVNT_REMARKS_ID")
	private long ropEventRemarkId;


	@Column(name = "RP_EVNT_ID")
	private long rpEventId;


	@Column(name = "WORKFLOW_ID")
	private long workFlowId;

	@Column(name = "WORKFLOW_ROLE_ID")
	private long workFlowRoleId;

	@Column(name = "APPR_REMARKS")
	private String approverRemarks;

	@Column(name = "AUDIT_REMARKS")
	private String auditorRemarks;


	@Column(name = "PRINT_REMARKS")
	private String printRemarks;

	@Column(name = "EMP_ID")
	private long empId;

	public PVURopEventRemarksEntity() {
		super();
	}

	public long getRopEventRemarkId() {
		return ropEventRemarkId;
	}

	public void setRopEventRemarkId(long ropEventRemarkId) {
		this.ropEventRemarkId = ropEventRemarkId;
	}

	public long getRpEventId() {
		return rpEventId;
	}

	public void setRpEventId(long rpEventId) {
		this.rpEventId = rpEventId;
	}

	public long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	public void setWorkFlowRoleId(long workFlowRoleId) {
		this.workFlowRoleId = workFlowRoleId;
	}

	public String getApproverRemarks() {
		return approverRemarks;
	}

	public void setApproverRemarks(String approverRemarks) {
		this.approverRemarks = approverRemarks;
	}

	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	public String getPrintRemarks() {
		return printRemarks;
	}

	public void setPrintRemarks(String printRemarks) {
		this.printRemarks = printRemarks;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVURopEventRemarksEntity that = (PVURopEventRemarksEntity) o;
		return ropEventRemarkId == that.ropEventRemarkId &&
				rpEventId == that.rpEventId &&
				workFlowId == that.workFlowId &&
				workFlowRoleId == that.workFlowRoleId &&
				empId == that.empId &&
				Objects.equals(approverRemarks, that.approverRemarks) &&
				Objects.equals(auditorRemarks, that.auditorRemarks) &&
				Objects.equals(printRemarks, that.printRemarks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ropEventRemarkId, rpEventId, workFlowId, workFlowRoleId, approverRemarks, auditorRemarks, printRemarks, empId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PVURopEventRemarksEntity.class.getSimpleName() + "[", "]")
				.add("ropEventRemarkId=" + ropEventRemarkId)
				.add("rpEventId=" + rpEventId)
				.add("workFlowId=" + workFlowId)
				.add("workFlowRoleId=" + workFlowRoleId)
				.add("approverRemarks='" + approverRemarks + "'")
				.add("auditorRemarks='" + auditorRemarks + "'")
				.add("printRemarks='" + printRemarks + "'")
				.add("empId=" + empId)
				.toString();
	}
}
