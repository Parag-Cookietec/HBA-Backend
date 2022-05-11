package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import gov.ifms.pvu.util.PvuConstant;
import org.springframework.validation.FieldError;

import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.edp.dto.BaseDto;
import gov.ifms.pvu.common.PartOne;
import gov.ifms.pvu.common.PartSecond;

/**
 * The Class PVUEmployeSuspensionDto.
 *
 * @version 1.0
 * @created 2019 /12/12 15:52:48
 */
public class PVUEmployeSuspensionDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The emp id. */
	private long empId;

	/** The trans no. */
	private String trnNo;

	/** The office id. */
	private long officeId;

	/** The pay commission. */
	@Min(value = 1, groups = { PartOne.class, PartSecond.class })
	private long payCommission;

	/** The sus order no. */
	@NotNull(groups = { PartOne.class, PartSecond.class })
	private String susOrderNo;

	/** The sus order date. */
	/*
	 * @NotNull(groups = { PartOne.class, PartSecond.class })
	 * 
	 * @PastOrPresent(groups = { PartOne.class, PartSecond.class })
	 */
	private LocalDate susOrderDate;

	/** The sus event date. */
	/*
	 * @NotNull(groups = { PartOne.class, PartSecond.class })
	 * 
	 * @PastOrPresent(groups = { PartOne.class, PartSecond.class })
	 */
	private LocalDate susEventDate;

	/** The reason for sus. */
	@Min(value = 1, groups = { PartOne.class, PartSecond.class })
	private long reasonForSus;

	/** The sus start date. */
	@NotNull(groups = { PartOne.class, PartSecond.class })
	private LocalDate susStartDate;

	/** The sus end date. */
	@NotNull(groups = { PartOne.class })
	private LocalDate susEndDate;

	/** The sus cls date. */
	@NotNull(groups = { PartSecond.class })
	private LocalDate susClsDate;

	/** The closure id. */
	private long closureId;

	/** The no of day in sus. */
	private int noOfDayInSus;

	/** The punishment type. */
	private String punishmentType;

	/** The reinstate flag id. */
	private long reinstateFlagId;

	/** The description. */
	@NotNull(groups = { PartOne.class })
	private String description;

	/** The status id. */
	private long statusId;

	/** The is suspension closure. */
	private boolean isSuspensionClosure;

	/** The closure remarks. */
	private String closureRemarks;

	/**
	 * The employee number.
	 */
	private Long employeeNumber;

	private String eventCode = PvuConstant.EVENT_CODE_SUSPENSION;

	private Boolean isFinalClosure;
	private Boolean isFinalEnd;
	private Boolean isCloseSubmit;





	/**
	 * Gets the employee number.
	 *
	 * @return the employee number
	 */
	public Long getEmployeeNumber() {
		return employeeNumber;
	}

	/**
	 * Sets the employee number.
	 *
	 * @param employeeNumber the new employee number
	 */
	public void setEmployeeNumber(Long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/** The pay details dtos. */
	@Valid
	private List<PVUSuspensionPayDetailsDto> payDetailsDtos = new ArrayList<>();

	/**
	 * Validate all.
	 */
	@Override
	public void validateAll() {
		List<FieldError> errors = this.businessValidate();
		if (errors.isEmpty())
			return;
		ValidationUtil.throwErrors(errors);
	}

	/**
	 * Business validate.
	 *
	 * @return the list
	 */
	@Override
	public List<FieldError> businessValidate() {
		List<PVUSuspensionPayDetailsDto> payDetailsDto = this.getPayDetailsDtos();
		List<FieldError> errors = new ArrayList<>();

		if (this.isSuspensionClosure()) {
			if (this.getSusClsDate().isBefore(this.getSusEndDate())) {
				FieldError error = new FieldError("PVUEmployeSuspensionDto", "susClsDate",
						String.format(
								"Suspension closure date %s should be equal or greater than suspension end date %S",
								this.getSusClsDate(), this.getSusEndDate()));
				errors.add(error);
			}
			errors.addAll(ValidationUtil.validateGroup(this, new Class[] { PartOne.class, PartSecond.class }));
		} else {
			errors.addAll(ValidationUtil.validateGroup(this, new Class[] { PartOne.class }));
		}
		if (payDetailsDto.size() > 1) {
			payDetailsDto.stream().sorted(Comparator.comparing(PVUSuspensionPayDetailsDto::getPayableFromDate,
					Comparator.nullsLast(Comparator.reverseOrder())));
			List<PVUSuspensionPayDetailsDto> collect = payDetailsDto.stream().skip(payDetailsDto.size() - 2L)
					.collect(Collectors.toList());
			PVUSuspensionPayDetailsDto old = collect.get(0);
			PVUSuspensionPayDetailsDto newRe = collect.get(1);
			if (newRe.getPayableFromDate().isBefore(old.getPayableFromDate())) {
				FieldError error = new FieldError("PVUEmployeSuspensionDto", "payableFromDate",
						String.format("Payable From Date %s should be after %s", old.getPayableFromDate(),
								newRe.getPayableFromDate()));
				errors.add(error);
			}
		}
		return errors;
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
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
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
	 * @return the reasonForSus
	 */
	public long getReasonForSus() {
		return reasonForSus;
	}

	/**
	 * Sets the reason for sus.
	 *
	 * @param reasonForSus the reasonForSus to set
	 */
	public void setReasonForSus(long reasonForSus) {
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
	 * Gets the status id.
	 *
	 * @return the status
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the status to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the pay details dtos.
	 *
	 * @return the payDetailsDtos
	 */
	public List<PVUSuspensionPayDetailsDto> getPayDetailsDtos() {
		return payDetailsDtos;
	}

	/**
	 * Sets the pay details dtos.
	 *
	 * @param payDetailsDtos the payDetailsDtos to set
	 */
	public void setPayDetailsDtos(List<PVUSuspensionPayDetailsDto> payDetailsDtos) {
		this.payDetailsDtos = payDetailsDtos;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the pay commission.
	 *
	 * @return the pay commission
	 */
	public long getPayCommission() {
		return payCommission;
	}

	/**
	 * Sets the pay commission.
	 *
	 * @param payCommission the new pay commission
	 */
	public void setPayCommission(long payCommission) {
		this.payCommission = payCommission;
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
	 * Sets the sus end date.
	 *
	 * @param susEndDate the new sus end date
	 */
	public void setSusEndDate(LocalDate susEndDate) {
		this.susEndDate = susEndDate;
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
	 * Sets the sus cls date.
	 *
	 * @param susClsDate the new sus cls date
	 */
	public void setSusClsDate(LocalDate susClsDate) {
		this.susClsDate = susClsDate;
	}

	/**
	 * Gets the closure id.
	 *
	 * @return the closure id
	 */
	public long getClosureId() {
		return closureId;
	}

	/**
	 * Sets the closure id.
	 *
	 * @param closureId the new closure id
	 */
	public void setClosureId(long closureId) {
		this.closureId = closureId;
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
	 * Sets the no of day in sus.
	 *
	 * @param noOfDayInSus the new no of day in sus
	 */
	public void setNoOfDayInSus(int noOfDayInSus) {
		this.noOfDayInSus = noOfDayInSus;
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
	 * Sets the punishment type.
	 *
	 * @param punishmentType the new punishment type
	 */
	public void setPunishmentType(String punishmentType) {
		this.punishmentType = punishmentType;
	}

	/**
	 * Gets the reinstate flag id.
	 *
	 * @return the reinstate flag id
	 */
	public long getReinstateFlagId() {
		return reinstateFlagId;
	}

	/**
	 * Sets the reinstate flag id.
	 *
	 * @param reinstateFlagId the new reinstate flag id
	 */
	public void setReinstateFlagId(long reinstateFlagId) {
		this.reinstateFlagId = reinstateFlagId;
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

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
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
		if (!(o instanceof PVUEmployeSuspensionDto)) return false;
		if (!super.equals(o)) return false;
		PVUEmployeSuspensionDto that = (PVUEmployeSuspensionDto) o;
		return getId() == that.getId() &&
				getEmpId() == that.getEmpId() &&
				getOfficeId() == that.getOfficeId() &&
				getPayCommission() == that.getPayCommission() &&
				getReasonForSus() == that.getReasonForSus() &&
				getClosureId() == that.getClosureId() &&
				getNoOfDayInSus() == that.getNoOfDayInSus() &&
				getReinstateFlagId() == that.getReinstateFlagId() &&
				getStatusId() == that.getStatusId() &&
				isSuspensionClosure() == that.isSuspensionClosure() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getSusOrderNo(), that.getSusOrderNo()) &&
				Objects.equals(getSusOrderDate(), that.getSusOrderDate()) &&
				Objects.equals(getSusEventDate(), that.getSusEventDate()) &&
				Objects.equals(getSusStartDate(), that.getSusStartDate()) &&
				Objects.equals(getSusEndDate(), that.getSusEndDate()) &&
				Objects.equals(getSusClsDate(), that.getSusClsDate()) &&
				Objects.equals(getPunishmentType(), that.getPunishmentType()) &&
				Objects.equals(getDescription(), that.getDescription()) &&
				Objects.equals(getClosureRemarks(), that.getClosureRemarks()) &&
				Objects.equals(getEmployeeNumber(), that.getEmployeeNumber()) &&
				Objects.equals(getEventCode(), that.getEventCode()) &&
				Objects.equals(isFinalClosure, that.isFinalClosure) &&
				Objects.equals(isFinalEnd, that.isFinalEnd) &&
				Objects.equals(isCloseSubmit, that.isCloseSubmit) &&
				Objects.equals(getPayDetailsDtos(), that.getPayDetailsDtos());
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getEmpId(), getTrnNo(), getOfficeId(), getPayCommission(), getSusOrderNo(), getSusOrderDate(), getSusEventDate(), getReasonForSus(), getSusStartDate(), getSusEndDate(), getSusClsDate(), getClosureId(), getNoOfDayInSus(), getPunishmentType(), getReinstateFlagId(), getDescription(), getStatusId(), isSuspensionClosure(), getClosureRemarks(), getEmployeeNumber(), getEventCode(), isFinalClosure, isFinalEnd, isCloseSubmit, getPayDetailsDtos());
	}

	@Override
	public String toString() {
		return "PVUEmployeSuspensionDto{" +
				"id=" + id +
				", empId=" + empId +
				", trnNo='" + trnNo + '\'' +
				", officeId=" + officeId +
				", payCommission=" + payCommission +
				", susOrderNo='" + susOrderNo + '\'' +
				", susOrderDate=" + susOrderDate +
				", susEventDate=" + susEventDate +
				", reasonForSus=" + reasonForSus +
				", susStartDate=" + susStartDate +
				", susEndDate=" + susEndDate +
				", susClsDate=" + susClsDate +
				", closureId=" + closureId +
				", noOfDayInSus=" + noOfDayInSus +
				", punishmentType='" + punishmentType + '\'' +
				", reinstateFlagId=" + reinstateFlagId +
				", description='" + description + '\'' +
				", statusId=" + statusId +
				", isSuspensionClosure=" + isSuspensionClosure +
				", closureRemarks='" + closureRemarks + '\'' +
				", employeeNumber=" + employeeNumber +
				", eventCode='" + eventCode + '\'' +
				", isFinalClosure=" + isFinalClosure +
				", isFinalEnd=" + isFinalEnd +
				", isCloseSubmit=" + isCloseSubmit +
				", payDetailsDtos=" + payDetailsDtos +
				'}';
	}
}
