package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVURopRemarksEntityDto.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
@NativeQueryResultEntity
public class PVUEventRemarksDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The rp event id. */
	private Long trnNo;

	private Long eventID;

	/** The work flow role id. */
	private Long workFlowRoleId;

	/** The emp id. */
	private Long empId;

	/** The remarks. */
	@NativeQueryResultColumn(index = 3)
	private String remarks;

	/** The remarks type. */
	@NativeQueryResultColumn(index = 4)
	private String remarksType;

	/** The reason. */
	@NativeQueryResultColumn(index = 1)
	private Long reasonId;

	@NativeQueryResultColumn(index = 2)
	private String reasonName;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the work flow role id.
	 *
	 * @return the workFlowRoleId
	 */
	public Long getWorkFlowRoleId() {
		return workFlowRoleId;
	}

	/**
	 * Sets the work flow role id.
	 *
	 * @param workFlowRoleId the workFlowRoleId to set
	 */
	public void setWorkFlowRoleId(Long workFlowRoleId) {
		this.workFlowRoleId = workFlowRoleId;
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
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Gets the remarks type.
	 *
	 * @return the remarksType
	 */
	public String getRemarksType() {
		return remarksType;
	}

	/**
	 * Sets the remarks type.
	 *
	 * @param remarksType the remarksType to set
	 */
	public void setRemarksType(String remarksType) {
		this.remarksType = remarksType;
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
	 * @return the reasonId
	 */
	public Long getReasonId() {
		return reasonId;
	}

	/**
	 * @param reasonId the reasonId to set
	 */
	public void setReasonId(Long reasonId) {
		this.reasonId = reasonId;
	}

	/**
	 * @return the trnNo
	 */
	public Long getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(Long trnNo) {
		this.trnNo = trnNo;
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

	@Override
	public int hashCode() {
		return Objects.hash(empId, eventID, id, reasonId, reasonName, remarks, remarksType, trnNo, workFlowRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEventRemarksDto)) {
			return false;
		}
		PVUEventRemarksDto other = (PVUEventRemarksDto) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(eventID, other.eventID)
				&& Objects.equals(id, other.id) && Objects.equals(reasonId, other.reasonId)
				&& Objects.equals(reasonName, other.reasonName) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(remarksType, other.remarksType) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(workFlowRoleId, other.workFlowRoleId);
	}

}
