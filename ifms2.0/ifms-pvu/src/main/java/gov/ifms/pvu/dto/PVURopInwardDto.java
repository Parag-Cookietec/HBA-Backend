package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVURopInwardDto.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 *
 */
public class PVURopInwardDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The inward id. */
	private Long inwardId;

	/** The emp id. */
	private Long empId;

	/** The Rop event id. */
	private Long ropEventId;

	/** The workflow id. */
	private Long workflowId;

	/** The inward date. */
	private Date inwardDate;

	/** The inward no. */
	private String inwardNo;

	/** The pou id. */
	private Long pouId;

	/** The office id. */
	private Long officeId;

	/**
	 * PVURopInwardDto Constructor.
	 */
	public PVURopInwardDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the inward id
	 */

	/**
	 * @return the inwardId
	 */
	public Long getInwardId() {
		return inwardId;
	}

	/**
	 * Sets the inward id.
	 *
	 * @param inwardId the inwardId to set
	 */
	public void setInwardId(Long inwardId) {
		this.inwardId = inwardId;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the rop event id.
	 *
	 * @return the RopEventId
	 */
	public Long getRopEventId() {
		return ropEventId;
	}

	/**
	 * Sets the rop event id.
	 *
	 * @param RopEventId the RopEventId to set
	 */
	public void setRopEventId(Long ropEventId) {
		this.ropEventId = ropEventId;
	}

	/**
	 * Gets the workflow id.
	 *
	 * @return the workflowId
	 */
	public Long getWorkflowId() {
		return workflowId;
	}

	/**
	 * Sets the workflow id.
	 *
	 * @param workflowId the workflowId to set
	 */
	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	/**
	 * Gets the inward date.
	 *
	 * @return the inwardDate
	 */
	public Date getInwardDate() {
		return inwardDate;
	}

	/**
	 * Sets the inward date.
	 *
	 * @param inwardDate the inwardDate to set
	 */
	public void setInwardDate(Date inwardDate) {
		this.inwardDate = inwardDate;
	}

	/**
	 * Gets the inward no.
	 *
	 * @return the inwardNo
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets the inward no.
	 *
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ropEventId, empId, inwardDate, inwardId, inwardNo, officeId, pouId, workflowId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVURopInwardDto other = (PVURopInwardDto) obj;
		return Objects.equals(ropEventId, other.ropEventId) && Objects.equals(empId, other.empId)
				&& Objects.equals(inwardDate, other.inwardDate) && Objects.equals(inwardId, other.inwardId)
				&& Objects.equals(inwardNo, other.inwardNo) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(pouId, other.pouId) && Objects.equals(workflowId, other.workflowId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURopInwardDto [inwardId=" + inwardId + ", empId=" + empId + ", RopEventId=" + ropEventId
				+ ", workflowId=" + workflowId + ", inwardDate=" + inwardDate + ", inwardNo=" + inwardNo + ", pouId="
				+ pouId + ", officeId=" + officeId + "]";
	}

}
