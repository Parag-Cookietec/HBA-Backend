package gov.ifms.pvu.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Entity
@Table(name = "PVU_ROP_EVNT_REMARKS", schema = Constant.PVU_SCHEMA)
public class PVURevisionOfPayRemarkEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RP_EVNT_REMARKS_ID")
	private Long id;

	/** The trans no. */
	@Column(name = "RP_EVNT_ID")
	private Long trnNo;


	/** The status id. */

	@Column(name = "WORKFLOW_ROLE_ID")
	private Long wfRoleId;

	/** The emp id. */

	@ManyToOne(fetch = FetchType.LAZY ,optional = false)
	@JoinColumn(name = "EMP_ID")
	private PVUEmployeEntity empId;

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

	public Long getReason() {
		return reason;
	}

	public void setReason(Long reason) {
		this.reason = reason;
	}

	public PVURevisionOfPayRemarkEntity() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVURevisionOfPayRemarkEntity that = (PVURevisionOfPayRemarkEntity) o;
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
		return new StringJoiner(", ", PVURevisionOfPayRemarkEntity.class.getSimpleName() + "[", "]")
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
