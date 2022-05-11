package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;

/**
 * The Class PVUEmployeSuspensionEntity.
 *
 * @version 1.0
 * @created 2019 /12/12 15:52:48
 */
@Entity
@Table(schema = Constant.PVU_SCHEMA, name = "T_PVU_SUS_CRT")
@NamedEntityGraph(name = "PVUEmployeSuspensionEntity.payDetailsEntity",
		attributeNodes = @NamedAttributeNode("payDetailsEntity")
)
public class PVUEmployeSuspensionEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_SUS_CRT_ID")
	private long id;

	/**
	 * The trans no.
	 */
	@Column(name = "TRN_NO")
	private String trnNo;

	/**
	 * The sus order no.
	 */
	@Column(name = "SUS_ORDER_NO")
	private String susOrderNo;

	/**
	 * The sus order date.
	 */
	@Column(name = "SUS_ORDER_DATE")
	private LocalDate susOrderDate;

	/**
	 * The sus event date.
	 */
	@Column(name = "SUS_EVNT_DATE")
	private LocalDate susEventDate;

	/**
	 * The reason for sus.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REASON_FOR_SUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reasonForSus;

	/**
	 * The sus start date.
	 */
	@Column(name = "SUS_START_DATE")
	private LocalDate susStartDate;

	/**
	 * The description.
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * The employee.
	 */
	@ManyToOne
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity employee;

	/**
	 * The office.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity office;

	/**
	 * The pay commission.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PAY_COMM", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity payCommission;

	/**
	 * The status id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	/**
	 * The reinstate flag.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "REINSTATE_FLAG", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reinstateFlag;

	/**
	 * The sus end date.
	 */
	@Column(name = "SUS_END_DATE")
	private LocalDate susEndDate;

	/**
	 * The sus cls date.
	 */
	@Column(name = "SUS_CLS_DATE")
	private LocalDate susClsDate;

	/**
	 * The closure.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CLOSURE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity closure;

	/**
	 * The no of day in sus.
	 */
	@Column(name = "NO_OF_DAY_IN_SUS")
	private int noOfDayInSus;

	/**
	 * The punishment type.
	 */
	@Column(name = "PUNISHMENT_TYPE")
	private String punishmentType;

	/**
	 * The is suspension closure.
	 */
	@Column(name = "IS_SUS_CLOSE")
	private boolean isSuspensionClosure;

	/**
	 * The closure remarks.
	 */
	@Column(name = "CLOSURE_REMARKS")
	private String closureRemarks;

	/**
	 * The suspension.
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "suspension")
	private List<PVUSuspensionPayDetailsEntity> payDetailsEntity;


	@Column(name = "IS_FINALLY_APPROVED")
	private Boolean isFinalClosure;

	@Column(name = "IS_FINALLY_ENDED")
	private Boolean isFinalEnd;

	@Column(name = "CLOSE_SUB")
	private Boolean isCloseSubmit;

	/**
	 * Adds the suspension.
	 *
	 * @param entity the entity
	 */
	public void addSuspension(PVUSuspensionPayDetailsEntity entity) {
		if (payDetailsEntity == null) {
			payDetailsEntity = new ArrayList<>();
		}
		entity.setSuspension(this);
		this.getPayDetailsEntity().add(entity);
	}

	/**
	 * Adds the suspension.
	 *
	 * @param list the list
	 */
	public void addSuspension(List<PVUSuspensionPayDetailsEntity> list) {
		list.forEach(this::addSuspension);
	}

	/**
	 * Removes the suspension.
	 *
	 * @param entity the entity
	 */
	public void removeSuspension(PVUSuspensionPayDetailsEntity entity) {
		this.getPayDetailsEntity().removeIf(e -> e.getId() == entity.getId());
	}

	/**
	 * Removes the suspension.
	 *
	 * @param list the list
	 */
	public void removeSuspension(List<PVUSuspensionPayDetailsEntity> list) {
		list.forEach(this::removeSuspension);
	}

	/**
	 * Instantiates a new PVU employe suspension entity.
	 *
	 * @param suspensionId the suspension id
	 */
	public PVUEmployeSuspensionEntity(long suspensionId) {
		this.id = suspensionId;
	}

	/**
	 * Instantiates a new PVU employe suspension entity.
	 */
	public PVUEmployeSuspensionEntity() {

	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the trans no.
	 *
	 * @return the trans no
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trans no.
	 *
	 * @param trnNo the new trans no
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the sus order no.
	 *
	 * @return the susOrderNo
	 */
	public String getSusOrderNo() {
		return susOrderNo;
	}

	/**
	 * Sets the sus order no.
	 *
	 * @param susOrderNo the susOrderNo to set
	 */
	public void setSusOrderNo(String susOrderNo) {
		this.susOrderNo = susOrderNo;
	}

	/**
	 * Gets the sus order date.
	 *
	 * @return the susOrderDate
	 */
	public LocalDate getSusOrderDate() {
		return susOrderDate;
	}

	/**
	 * Sets the sus order date.
	 *
	 * @param susOrderDate the susOrderDate to set
	 */
	public void setSusOrderDate(LocalDate susOrderDate) {
		this.susOrderDate = susOrderDate;
	}

	/**
	 * Gets the sus event date.
	 *
	 * @return the susEventDate
	 */
	public LocalDate getSusEventDate() {
		return susEventDate;
	}

	/**
	 * Sets the sus event date.
	 *
	 * @param susEventDate the susEventDate to set
	 */
	public void setSusEventDate(LocalDate susEventDate) {
		this.susEventDate = susEventDate;
	}

	/**
	 * Gets the reason for sus.
	 *
	 * @return the reason for sus
	 */
	public EDPLuLookUpInfoEntity getReasonForSus() {
		return reasonForSus;
	}

	/**
	 * Sets the reason for sus.
	 *
	 * @param reasonForSus the new reason for sus
	 */
	public void setReasonForSus(EDPLuLookUpInfoEntity reasonForSus) {
		this.reasonForSus = reasonForSus;
	}

	/**
	 * Gets the sus start date.
	 *
	 * @return the susStartDate
	 */
	public LocalDate getSusStartDate() {
		return susStartDate;
	}

	/**
	 * Sets the sus start date.
	 *
	 * @param susStartDate the susStartDate to set
	 */
	public void setSusStartDate(LocalDate susStartDate) {
		this.susStartDate = susStartDate;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public PVUEmployeEntity getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the employee to set
	 */
	public void setEmployee(PVUEmployeEntity employee) {
		this.employee = employee;
	}

	/**
	 * Gets the office.
	 *
	 * @return the office
	 */
	public EDPMsOfficeEntity getOffice() {
		return office;
	}

	/**
	 * Sets the office.
	 *
	 * @param office the office to set
	 */
	public void setOffice(EDPMsOfficeEntity office) {
		this.office = office;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the pay commission
	 */
	public EDPLuLookUpInfoEntity getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the new pay commission
	 */
	public void setPayCommission(EDPLuLookUpInfoEntity payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status
	 */
	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	/**
	 * Sets the status id.
	 *
	 * @param status the status to set
	 */
	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	/**
	 * Gets the pay details entity.
	 *
	 * @return the payDetailsEntity
	 */
	public List<PVUSuspensionPayDetailsEntity> getPayDetailsEntity() {
		return payDetailsEntity;
	}

	/**
	 * Sets the pay details entity.
	 *
	 * @param payDetailsEntity the payDetailsEntity to set
	 */
	public void setPayDetailsEntity(List<PVUSuspensionPayDetailsEntity> payDetailsEntity) {
		this.payDetailsEntity = payDetailsEntity;
	}

	/**
	 * Sets the reinstate flag.
	 *
	 * @param reinstateFlag the new reinstate flag
	 */
	public void setReinstateFlag(EDPLuLookUpInfoEntity reinstateFlag) {
		this.reinstateFlag = reinstateFlag;
	}

	/**
	 * Sets the sus end date.
	 *
	 * @param susEndDate the new sus end date
	 */
	public void setSusEndDate(LocalDate susEndDate) {
		this.susEndDate = susEndDate;
	}

	/**
	 * Sets the sus cls date.
	 *
	 * @param susClsDate the new sus cls date
	 */
	public void setSusClsDate(LocalDate susClsDate) {
		this.susClsDate = susClsDate;
	}

	/**
	 * Sets the closure.
	 *
	 * @param closure the new closure
	 */
	public void setClosure(EDPLuLookUpInfoEntity closure) {
		this.closure = closure;
	}

	/**
	 * Sets the no of day in sus.
	 *
	 * @param noOfDayInSus the new no of day in sus
	 */
	public void setNoOfDayInSus(int noOfDayInSus) {
		this.noOfDayInSus = noOfDayInSus;
	}

	/**
	 * Sets the punishment type.
	 *
	 * @param punishmentType the new punishment type
	 */
	public void setPunishmentType(String punishmentType) {
		this.punishmentType = punishmentType;
	}

	/**
	 * Gets the reinstate flag.
	 *
	 * @return the reinstate flag
	 */
	public EDPLuLookUpInfoEntity getReinstateFlag() {
		return reinstateFlag;
	}

	/**
	 * Gets the sus end date.
	 *
	 * @return the sus end date
	 */
	public LocalDate getSusEndDate() {
		return susEndDate;
	}

	/**
	 * Gets the sus cls date.
	 *
	 * @return the sus cls date
	 */
	public LocalDate getSusClsDate() {
		return susClsDate;
	}

	/**
	 * Gets the closure.
	 *
	 * @return the closure
	 */
	public EDPLuLookUpInfoEntity getClosure() {
		return closure;
	}

	/**
	 * Gets the no of day in sus.
	 *
	 * @return the no of day in sus
	 */
	public int getNoOfDayInSus() {
		return noOfDayInSus;
	}

	/**
	 * Gets the punishment type.
	 *
	 * @return the punishment type
	 */
	public String getPunishmentType() {
		return punishmentType;
	}

	/**
	 * Checks if is suspension closure.
	 *
	 * @return true, if is suspension closure
	 */
	public boolean isSuspensionClosure() {
		return isSuspensionClosure;
	}

	/**
	 * Sets the suspension closure.
	 *
	 * @param suspensionClosure the new suspension closure
	 */
	public void setSuspensionClosure(boolean suspensionClosure) {
		isSuspensionClosure = suspensionClosure;
	}

	/**
	 * Gets the closure remarks.
	 *
	 * @return the closure remarks
	 */
	public String getClosureRemarks() {
		return closureRemarks;
	}

	/**
	 * Sets the closure remarks.
	 *
	 * @param closureRemarks the new closure remarks
	 */
	public void setClosureRemarks(String closureRemarks) {
		this.closureRemarks = closureRemarks;
	}

	public Boolean getFinalClosure() {
		return isFinalClosure;
	}

	public void setFinalClosure(Boolean finalClosure) {
		isFinalClosure = finalClosure;
	}

	public Boolean getFinalEnd() {
		return isFinalEnd;
	}

	public void setFinalEnd(Boolean finalEnd) {
		isFinalEnd = finalEnd;
	}

	public Boolean getCloseSubmit() {
		return isCloseSubmit;
	}

	public void setCloseSubmit(Boolean closeSubmit) {
		isCloseSubmit = closeSubmit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUEmployeSuspensionEntity)) return false;
		PVUEmployeSuspensionEntity that = (PVUEmployeSuspensionEntity) o;
		return getId() == that.getId() &&
				getNoOfDayInSus() == that.getNoOfDayInSus() &&
				isSuspensionClosure() == that.isSuspensionClosure() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getSusOrderNo(), that.getSusOrderNo()) &&
				Objects.equals(getSusOrderDate(), that.getSusOrderDate()) &&
				Objects.equals(getSusEventDate(), that.getSusEventDate()) &&
				Objects.equals(getReasonForSus(), that.getReasonForSus()) &&
				Objects.equals(getSusStartDate(), that.getSusStartDate()) &&
				Objects.equals(getDescription(), that.getDescription()) &&
				Objects.equals(getEmployee(), that.getEmployee()) &&
				Objects.equals(getOffice(), that.getOffice()) &&
				Objects.equals(getPayCommission(), that.getPayCommission()) &&
				Objects.equals(getStatus(), that.getStatus()) &&
				Objects.equals(getReinstateFlag(), that.getReinstateFlag()) &&
				Objects.equals(getSusEndDate(), that.getSusEndDate()) &&
				Objects.equals(getSusClsDate(), that.getSusClsDate()) &&
				Objects.equals(getClosure(), that.getClosure()) &&
				Objects.equals(getPunishmentType(), that.getPunishmentType()) &&
				Objects.equals(getClosureRemarks(), that.getClosureRemarks()) &&
				Objects.equals(getPayDetailsEntity(), that.getPayDetailsEntity()) &&
				Objects.equals(isFinalClosure, that.isFinalClosure) &&
				Objects.equals(isFinalEnd, that.isFinalEnd) &&
				Objects.equals(isCloseSubmit, that.isCloseSubmit);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTrnNo(), getSusOrderNo(), getSusOrderDate(), getSusEventDate(), getReasonForSus(), getSusStartDate(), getDescription(), getEmployee(), getOffice(), getPayCommission(), getStatus(), getReinstateFlag(), getSusEndDate(), getSusClsDate(), getClosure(), getNoOfDayInSus(), getPunishmentType(), isSuspensionClosure(), getClosureRemarks(), getPayDetailsEntity(), isFinalClosure, isFinalEnd, isCloseSubmit);
	}

	@Override
	public String toString() {
		return "PVUEmployeSuspensionEntity{" +
				"id=" + id +
				", trnNo='" + trnNo + '\'' +
				", susOrderNo='" + susOrderNo + '\'' +
				", susOrderDate=" + susOrderDate +
				", susEventDate=" + susEventDate +
				", reasonForSus=" + reasonForSus +
				", susStartDate=" + susStartDate +
				", description='" + description + '\'' +
				", employee=" + employee +
				", office=" + office +
				", payCommission=" + payCommission +
				", status=" + status +
				", reinstateFlag=" + reinstateFlag +
				", susEndDate=" + susEndDate +
				", susClsDate=" + susClsDate +
				", closure=" + closure +
				", noOfDayInSus=" + noOfDayInSus +
				", punishmentType='" + punishmentType + '\'' +
				", isSuspensionClosure=" + isSuspensionClosure +
				", closureRemarks='" + closureRemarks + '\'' +
				", payDetailsEntity=" + payDetailsEntity +
				", isFinalClosure=" + isFinalClosure +
				", isFinalEnd=" + isFinalEnd +
				", isCloseSubmit=" + isCloseSubmit +
				'}';
	}
}

