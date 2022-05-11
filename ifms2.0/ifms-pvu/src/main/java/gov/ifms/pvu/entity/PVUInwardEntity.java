package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

@Entity
@Table(name = "T_PVU_INWARD", schema = Constant.PVU_SCHEMA)
public class PVUInwardEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_INWARD_ID")
	private Long id;

	@ManyToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    private PVUEmployeEntity employee;
	
	@Column(name = "PVU_TRN_ID")
	private Long trnId;
	
	@Column(name = "PVU_EVENT_ID")
	private Long pvuEventId;
	
	@Column(name = "WF_ID")
	private Long workFlowId;
	
	@Column(name = "INWARD_DATE")
	private LocalDate inwardDate;
	
	@Column(name = "INWARD_NO")
	private String inwardNumber;
	
	@Column(name = "OUTWARD_DATE")
	private LocalDate outwardDate;
	
	@Column(name = "OUTWARD_NO")
	private Long outwardNumber;
	
	@Column(name = "POST_CONSIGNMENT_NO")
	private String postConsignationNo;
	
	@Column(name = "POU_ID")
	private long pouId; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity officeId;
	
	@Column(name = "PVU_OFFICE_ID")
	private long pouOfficeId;
	
	@Column(name = "AUTH_DATE")
	private LocalDateTime authDate;
	
	@Column(name = "RETURN_DATE")
	private LocalDateTime returnDate;
	
	@Column(name = "OUTWARD_FLAG")
	private int outwardFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PVUEmployeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(PVUEmployeEntity employee) {
		this.employee = employee;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public Long getPvuEventId() {
		return pvuEventId;
	}

	public void setPvuEventId(Long pvuEventId) {
		this.pvuEventId = pvuEventId;
	}

	public Long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(Long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public LocalDate getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(LocalDate inwardDate) {
		this.inwardDate = inwardDate;
	}

	public String getInwardNumber() {
		return inwardNumber;
	}

	public void setInwardNumber(String inwardNumber) {
		this.inwardNumber = inwardNumber;
	}

	public LocalDate getOutwardDate() {
		return outwardDate;
	}

	public void setOutwardDate(LocalDate outwardDate) {
		this.outwardDate = outwardDate;
	}

	public Long getOutwardNumber() {
		return outwardNumber;
	}

	public void setOutwardNumber(Long outwardNumber) {
		this.outwardNumber = outwardNumber;
	}

	public String getPostConsignationNo() {
		return postConsignationNo;
	}

	public void setPostConsignationNo(String postConsignationNo) {
		this.postConsignationNo = postConsignationNo;
	}

	public long getPouId() {
		return pouId;
	}

	public void setPouId(long pouId) {
		this.pouId = pouId;
	}

	public EDPMsOfficeEntity getOfficeId() {
		return officeId;
	}

	public void setOfficeId(EDPMsOfficeEntity officeId) {
		this.officeId = officeId;
	}

	public long getPouOfficeId() {
		return pouOfficeId;
	}

	public void setPouOfficeId(long pouOfficeId) {
		this.pouOfficeId = pouOfficeId;
	}

	public LocalDateTime getAuthDate() {
		return authDate;
	}

	public void setAuthDate(LocalDateTime authDate) {
		this.authDate = authDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public int getOutwardFlag() {
		return outwardFlag;
	}

	public void setOutwardFlag(int outwardFlag) {
		this.outwardFlag = outwardFlag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authDate, employee, id, inwardDate, inwardNumber, officeId, outwardDate, outwardFlag,
				outwardNumber, postConsignationNo, pouId, pouOfficeId, pvuEventId, returnDate, trnId, workFlowId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUInwardEntity other = (PVUInwardEntity) obj;
		return Objects.equals(authDate, other.authDate) && Objects.equals(employee, other.employee)
				&& Objects.equals(id, other.id) && Objects.equals(inwardDate, other.inwardDate)
				&& Objects.equals(inwardNumber, other.inwardNumber) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(outwardDate, other.outwardDate) && Objects.equals(outwardFlag, other.outwardFlag)
				&& Objects.equals(outwardNumber, other.outwardNumber)
				&& Objects.equals(postConsignationNo, other.postConsignationNo) && pouId == other.pouId
				&& pouOfficeId == other.pouOfficeId && Objects.equals(pvuEventId, other.pvuEventId)
				&& Objects.equals(returnDate, other.returnDate) && Objects.equals(trnId, other.trnId)
				&& Objects.equals(workFlowId, other.workFlowId);
	}
	
}
