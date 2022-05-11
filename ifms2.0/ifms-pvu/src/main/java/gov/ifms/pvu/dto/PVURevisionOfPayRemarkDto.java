package gov.ifms.pvu.dto;


import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

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
public class PVURevisionOfPayRemarkDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */

	private Long id;

	private Long trnNo;


	/** The status id. */


	private Long wfRoleId;

	/** The emp id. */
	private PVUEmployeEntity empId;

	/** The rop type. */

	private String remarks;

	private String remarksType;

	private String reason;

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

	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	public void setEmpId(PVUEmployeEntity empId) {
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public PVURevisionOfPayRemarkDto() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVURevisionOfPayRemarkDto that = (PVURevisionOfPayRemarkDto) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(trnNo, that.trnNo) &&
				Objects.equals(wfRoleId, that.wfRoleId) &&
				Objects.equals(empId, that.empId) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(remarksType, that.remarksType) &&
				Objects.equals(reason, that.reason);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, trnNo, wfRoleId, empId, remarks, remarksType, reason);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PVURevisionOfPayRemarkDto.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("trnNo=" + trnNo)
				.add("wfRoleId=" + wfRoleId)
				.add("empId=" + empId)
				.add("remarks='" + remarks + "'")
				.add("remarksType='" + remarksType + "'")
				.add("reason='" + reason + "'")
				.toString();
	}
}
