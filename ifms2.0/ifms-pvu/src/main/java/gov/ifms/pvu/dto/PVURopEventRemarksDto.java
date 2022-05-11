package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

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
public class PVURopEventRemarksDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The emp id. */
	private long ropEventRemarkId;


	private long rpEventId;


	private long workFlowId;

	private long workFlowRoleId;

	private String approverRemarks;

	private String auditorRemarks;


	private String printRemarks;

	private long empId;

	public PVURopEventRemarksDto() {
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
		PVURopEventRemarksDto that = (PVURopEventRemarksDto) o;
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
		return new StringJoiner(", ", PVURopEventRemarksDto.class.getSimpleName() + "[", "]")
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
