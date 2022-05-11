package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUEmployeEventsEntity.
 */
@Entity
@Table(name = "T_EMP_EVENTS", schema = Constant.PVU_SCHEMA)
public class PVUEmployeEventsEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The emp event id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_EVNT_ID")
	private Long empEventId;

	/**
	 * The emp id.
	 */
	@Column(name = "EMP_ID")
	private Long empId;

	/**
	 * The trn no.
	 */
	@Column(name = "TRN_NO")
	private String trnNo;

	/**
	 * The event name.
	 */
	@Column(name = "EVNT_NAME")
	private String eventName;

	/**
	 * The event date.
	 */
	@Column(name = "EVNT_DATE")
	private LocalDateTime eventDate;

	/**
	 * The emp pay band.
	 */
	@Column(name = "EMP_PAY_BAND")
	private Long empPayBand;

	/**
	 * The emp pay lvl grd pay.
	 */
	@Column(name = "EMP_PAY_LEVEL")
	private Long empPaylevel;

	/**
	 * The emp basic pay.
	 */
	@Column(name = "EMP_BASIC_PAY")
	private Long empBasicPay;

	/**
	 * The emp next incr date.
	 */
	@Column(name = "DATE_NXT_INCR")
	private LocalDateTime empNextIncrDate;

	/**
	 * The cur emp dsgn.
	 */
	@Column(name = "DSGN")
	private Long empDesignation;

	/**
	 * The emp option.
	 */
	@Column(name = "OPTION_DATE")
	private Long empOption;

	/**
	 * The emp auto approve.
	 */
	@Column(name = "DATE_AUD_APPR")
	private LocalDateTime empAutoApprove;

	/**
	 * The pay commission.
	 */
	@Column(name = "PAY_COMMISSION")
	private Long payCommission;

	/**
	 * The cell id.
	 */
	@Column(name = "CELL_ID")
	private Long cellId;

	/**
	 * The pay band value.
	 */
	@Column(name = "PAY_BAND_VALUE")
	private Long payBandValue;

	/**
	 * The pay scale.
	 */
	@Column(name = "PAY_SCALE")
	private Long payScale;

	/**
	 * The emp grd pay.
	 */
	@Column(name = "EMP_GRD_PAY")
	private Long empGrdPay;

	/**
	 * The office id.
	 */
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/**
	 * The office id.
	 */
	@Column(name = "EVENT_ID")
	private Long eventId;

	/**
	 * The office id.
	 */
	@Column(name = "SRC_EVENT_ID")
	private Long sourceId;

	/**
	 * The office id.
	 */
	@Column(name = "EVNT_TYPE")
	private byte eventType;

	/**
	 * The office id.
	 */
	@Column(name = "REMARKS")
	private String remarks;

	/**
	 * The departmentCategoryId.
	 */
	@Column(name = "DEPT_CAT_ID")
	private Long departmentCategoryId;

	/**
	 * The departmentCategoryId.
	 */
	@Column(name = "PERSONAL_PAY")
	private Long personalPay = 0l;

	/**
	 * The departmentCategoryId.
	 */
	@Column(name = "EMP_CLASS")
	private Long employeeClassId;

	/**
	 * The employeeTypeId.
	 */
	@Column(name = "EMP_TYPE")
	private Long employeeTypeId;

	@Column(name = "OPT_AVAL_DT")
	private LocalDate empOptionAvalDate;

	@Column(name = "REVISION_NO")
	private Long revisionNo;

	@Column(name = "IMPACTED_BY_REVISION_NO")
	private Long impByRevisionNo;

	public Long getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Long employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	/**
	 * PVUEmployeEventsEntity Constructor.
	 */
	public PVUEmployeEventsEntity() {
		super();
	}

	/**
	 * Gets the emp event id.
	 *
	 * @return the empEventId
	 */
	public Long getEmpEventId() {
		return empEventId;
	}

	/**
	 * Sets the emp event id.
	 *
	 * @param empEventId the empEventId to set
	 */
	public void setEmpEventId(Long empEventId) {
		this.empEventId = empEventId;
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
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the event name.
	 *
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * Sets the event name.
	 *
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * Gets the event date.
	 *
	 * @return the eventDate
	 */
	public LocalDateTime getEventDate() {
		return eventDate;
	}

	/**
	 * Sets the event date.
	 *
	 * @param eventDate the eventDate to set
	 */
	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * Gets the emp pay band.
	 *
	 * @return the empPayBand
	 */
	public Long getEmpPayBand() {
		return empPayBand;
	}

	/**
	 * Sets the emp pay band.
	 *
	 * @param empPayBand the empPayBand to set
	 */
	public void setEmpPayBand(Long empPayBand) {
		this.empPayBand = empPayBand;
	}

	/**
	 * Gets the emp paylevel.
	 *
	 * @return the empPaylevel
	 */
	public Long getEmpPaylevel() {
		return empPaylevel;
	}

	/**
	 * Sets the emp paylevel.
	 *
	 * @param empPaylevel the empPaylevel to set
	 */
	public void setEmpPaylevel(Long empPaylevel) {
		this.empPaylevel = empPaylevel;
	}

	/**
	 * Gets the emp basic pay.
	 *
	 * @return the empBasicPay
	 */
	public Long getEmpBasicPay() {
		return empBasicPay;
	}

	/**
	 * Sets the emp basic pay.
	 *
	 * @param empBasicPay the empBasicPay to set
	 */
	public void setEmpBasicPay(Long empBasicPay) {
		this.empBasicPay = empBasicPay;
	}

	/**
	 * Gets the emp next incr date.
	 *
	 * @return the empNextIncrDate
	 */
	public LocalDateTime getEmpNextIncrDate() {
		return empNextIncrDate;
	}

	/**
	 * Sets the emp next incr date.
	 *
	 * @param empNextIncrDate the empNextIncrDate to set
	 */
	public void setEmpNextIncrDate(LocalDateTime empNextIncrDate) {
		this.empNextIncrDate = empNextIncrDate;
	}

	/**
	 * Gets the emp designation.
	 *
	 * @return the empDesignation
	 */
	public Long getEmpDesignation() {
		return empDesignation;
	}

	/**
	 * Sets the emp designation.
	 *
	 * @param empDesignation the empDesignation to set
	 */
	public void setEmpDesignation(Long empDesignation) {
		this.empDesignation = empDesignation;
	}

	/**
	 * Gets the emp option.
	 *
	 * @return the empOption
	 */
	public Long getEmpOption() {
		return empOption;
	}

	/**
	 * Sets the emp option.
	 *
	 * @param empOption the empOption to set
	 */
	public void setEmpOption(Long empOption) {
		this.empOption = empOption;
	}

	/**
	 * Gets the emp auto approve.
	 *
	 * @return the empAutoApprove
	 */
	public LocalDateTime getEmpAutoApprove() {
		return empAutoApprove;
	}

	/**
	 * Sets the emp auto approve.
	 *
	 * @param empAutoApprove the empAutoApprove to set
	 */
	public void setEmpAutoApprove(LocalDateTime empAutoApprove) {
		this.empAutoApprove = empAutoApprove;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the payCommission
	 */
	public Long getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(Long payCommission) {
		this.payCommission = payCommission;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public Long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public Long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(Long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the emp grd pay.
	 *
	 * @return the empGrdPay
	 */
	public Long getEmpGrdPay() {
		return empGrdPay;
	}

	/**
	 * Sets the emp grd pay.
	 *
	 * @param empGrdPay the empGrdPay to set
	 */
	public void setEmpGrdPay(Long empGrdPay) {
		this.empGrdPay = empGrdPay;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Getter for property 'eventId'.
	 *
	 * @return Value for property 'eventId'.
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * Setter for property 'eventId'.
	 *
	 * @param eventId Value to set for property 'eventId'.
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Getter for property 'sourceId'.
	 *
	 * @return Value for property 'sourceId'.
	 */
	public Long getSourceId() {
		return sourceId;
	}

	/**
	 * Setter for property 'sourceId'.
	 *
	 * @param sourceId Value to set for property 'sourceId'.
	 */
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * Getter for property 'eventType'.
	 *
	 * @return Value for property 'eventType'.
	 */
	public byte getEventType() {
		return eventType;
	}

	/**
	 * Setter for property 'eventType'.
	 *
	 * @param eventType Value to set for property 'eventType'.
	 */
	public void setEventType(byte eventType) {
		this.eventType = eventType;
	}

	/**
	 * Getter for property 'remarks'.
	 *
	 * @return Value for property 'remarks'.
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Setter for property 'remarks'.
	 *
	 * @param remarks Value to set for property 'remarks'.
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Getter for property 'departmentCategoryId'.
	 *
	 * @return Value for property 'departmentCategoryId'.
	 */
	public Long getDepartmentCategoryId() {
		return departmentCategoryId;
	}

	/**
	 * Setter for property 'departmentCategoryId'.
	 *
	 * @param departmentCategoryId Value to set for property 'departmentCategoryId'.
	 */
	public void setDepartmentCategoryId(Long departmentCategoryId) {
		this.departmentCategoryId = departmentCategoryId;
	}

	/**
	 * Getter for property 'personalPay'.
	 *
	 * @return Value for property 'personalPay'.
	 */
	public Long getPersonalPay() {
		return personalPay;
	}

	/**
	 * Setter for property 'personalPay'.
	 *
	 * @param personalPay Value to set for property 'personalPay'.
	 */
	public void setPersonalPay(Long personalPay) {
		this.personalPay = personalPay;
	}

	/**
	 * Getter for property 'employeeClassId'.
	 *
	 * @return Value for property 'employeeClassId'.
	 */
	public Long getEmployeeClassId() {
		return employeeClassId;
	}

	/**
	 * Setter for property 'employeeClassId'.
	 *
	 * @param employeeClassId Value to set for property 'employeeClassId'.
	 */
	public void setEmployeeClassId(Long employeeClassId) {
		this.employeeClassId = employeeClassId;
	}

	/**
	 * @return the empOptionAvalDate
	 */
	public LocalDate getEmpOptionAvalDate() {
		return empOptionAvalDate;
	}

	/**
	 * @param empOptionAvalDate the empOptionAvalDate to set
	 */
	public void setEmpOptionAvalDate(LocalDate empOptionAvalDate) {
		this.empOptionAvalDate = empOptionAvalDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cellId, departmentCategoryId, empAutoApprove, empBasicPay, empDesignation, empEventId,
				empGrdPay, empId, empNextIncrDate, empOption, empOptionAvalDate, empPayBand, empPaylevel,
				employeeClassId, employeeTypeId, eventDate, eventId, eventName, eventType, impByRevisionNo, officeId,
				payBandValue, payCommission, payScale, personalPay, remarks, revisionNo, sourceId, trnNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeEventsEntity)) {
			return false;
		}
		PVUEmployeEventsEntity other = (PVUEmployeEventsEntity) obj;
		return Objects.equals(cellId, other.cellId) && Objects.equals(departmentCategoryId, other.departmentCategoryId)
				&& Objects.equals(empAutoApprove, other.empAutoApprove)
				&& Objects.equals(empBasicPay, other.empBasicPay)
				&& Objects.equals(empDesignation, other.empDesignation) && Objects.equals(empEventId, other.empEventId)
				&& Objects.equals(empGrdPay, other.empGrdPay) && Objects.equals(empId, other.empId)
				&& Objects.equals(empNextIncrDate, other.empNextIncrDate) && Objects.equals(empOption, other.empOption)
				&& Objects.equals(empOptionAvalDate, other.empOptionAvalDate)
				&& Objects.equals(empPayBand, other.empPayBand) && Objects.equals(empPaylevel, other.empPaylevel)
				&& Objects.equals(employeeClassId, other.employeeClassId)
				&& Objects.equals(employeeTypeId, other.employeeTypeId) && Objects.equals(eventDate, other.eventDate)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(eventName, other.eventName)
				&& eventType == other.eventType && Objects.equals(impByRevisionNo, other.impByRevisionNo)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCommission, other.payCommission) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(personalPay, other.personalPay) && Objects.equals(remarks, other.remarks)
				&& Objects.equals(revisionNo, other.revisionNo) && Objects.equals(sourceId, other.sourceId)
				&& Objects.equals(trnNo, other.trnNo);
	}

	@Override
	public String toString() {
		return "PVUEmployeEventsEntity [empEventId=" + empEventId + ", empId=" + empId + ", trnNo=" + trnNo
				+ ", eventName=" + eventName + ", eventDate=" + eventDate + ", empPayBand=" + empPayBand
				+ ", empPaylevel=" + empPaylevel + ", empBasicPay=" + empBasicPay + ", empNextIncrDate="
				+ empNextIncrDate + ", empDesignation=" + empDesignation + ", empOption=" + empOption
				+ ", empAutoApprove=" + empAutoApprove + ", payCommission=" + payCommission + ", cellId=" + cellId
				+ ", payBandValue=" + payBandValue + ", payScale=" + payScale + ", empGrdPay=" + empGrdPay
				+ ", officeId=" + officeId + ", eventId=" + eventId + ", sourceId=" + sourceId + ", eventType="
				+ eventType + ", remarks=" + remarks + ", departmentCategoryId=" + departmentCategoryId
				+ ", personalPay=" + personalPay + ", employeeClassId=" + employeeClassId + ", employeeTypeId="
				+ employeeTypeId + ", empOptionAvalDate=" + empOptionAvalDate + ", revisionNo=" + revisionNo
				+ ", impByRevisionNo=" + impByRevisionNo + "]";
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	public PVUEmployeEventsEntity(Long empEventId, Long empId, String eventName, LocalDateTime eventDate) {
		super();
		this.empEventId = empEventId;
		this.empId = empId;
		this.eventName = eventName;
		this.eventDate = eventDate;
	}

	/**
	 * @return the revisionNo
	 */
	public Long getRevisionNo() {
		return revisionNo;
	}

	/**
	 * @param revisionNo the revisionNo to set
	 */
	public void setRevisionNo(Long revisionNo) {
		this.revisionNo = revisionNo;
	}

	/**
	 * @return the impByRevisionNo
	 */
	public Long getImpByRevisionNo() {
		return impByRevisionNo;
	}

	/**
	 * @param impByRevisionNo the impByRevisionNo to set
	 */
	public void setImpByRevisionNo(Long impByRevisionNo) {
		this.impByRevisionNo = impByRevisionNo;
	}

}
