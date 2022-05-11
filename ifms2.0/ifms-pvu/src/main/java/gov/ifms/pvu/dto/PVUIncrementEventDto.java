
package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.FieldError;

import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUIncrementEventDto.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */

public class PVUIncrementEventDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in event id. */
	private long inEventId;

	/** The trn no. */
	private String trnNo;

	/** The office id. */
	private long officeId;

	/** The post id. */
	private long postId;

	/** The financial year. */
	private long financialYear;

	/** The financial year name. */
	private int financialYearName;

	/** The event order no. */
	private long eventOrderNo;

	/** The increment for. */
	private long incrementFor;

	/** The increment for name. */
	private String incrementForName;

	/** The increment type. */
	private long incrementType;

	/** The increment type name. */
	private String incrementTypeName;

	/** The class id. */
	private long classId;

	/** The class name. */
	private String className;

	/** The designation id. */
	private long designationId;

	/** The designation name. */
	private String designationName;

	/** The increment eff date. */
	private Date incrementEffDate;

	/** The date next inc. */
	private Date dateNextInc;

	/** The emp id. */
	private long empId;

	/** The emp type. */
	private long empType;

	/** The emp type name. */
	private String empTypeName;

	/** The emp pay type. */
	private long empPayType;

	/** The emp pay type name. */
	private String empPayTypeName;

	/** The status id. */
	private long statusId;

	/** The emp no. */
	private String empNo;

	/** The gpf. */
	private String gpf;

	/** The pvu increment emp dtos. */
	private List<PVUIncrementEmpDto> pvuIncrementEmpDtos;

	/** The pvu increment event summary dto. */
	private PVUIncrementEventSummaryDto pvuIncrementEventSummaryDto;

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
		List<FieldError> errors = new ArrayList<>();
		FieldError error = null;
		LocalDate incrementEffectiveDate = this.getIncrementEffDate().toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		LocalDate dateOfNextInc = this.getDateNextInc().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if (this.getIncrementFor() == 152) {
			if (!Utils.seventhCommissionDateValidation(incrementEffectiveDate)) {
				error = new FieldError(PVUIncrementEventDto.class.getName(), "Increment effective date",
						" must be 01/01 or 01/07 for 7th Pay Commission");
				errors.add(error);
			}

			if (!Utils.seventhCommissionDateValidation(dateOfNextInc)) {
				error = new FieldError(PVUIncrementEventDto.class.getName(), "Date of next increment",
						" must be 01/01 or 01/07 for 7th Pay Commission");
				errors.add(error);
			}
		} else if (this.getIncrementFor() == 151) {
			if (!Utils.sixthCommissionDateValidation(incrementEffectiveDate)) {
				error = new FieldError(PVUIncrementEventDto.class.getName(), "Increment effective date",
						" must be 01/07 for 6th Pay Commission");
				errors.add(error);
			}

			if (!Utils.sixthCommissionDateValidation(dateOfNextInc)) {
				error = new FieldError(PVUIncrementEventDto.class.getName(), "Date of next increment",
						" must be 01/07 for 6th Pay Commission");
				errors.add(error);
			}
		}
		if (!(incrementEffectiveDate.equals(dateOfNextInc.plusYears(-1)))) {
			error = new FieldError(PVUIncrementEventDto.class.getName(), "",
					"Must be one year difference between Increment effictive date & Date of next increment");
			errors.add(error);
		}
		return errors;
	}

	/**
	 * Gets the in event id.
	 *
	 * @return the inEventId
	 */

	public long getInEventId() {
		return inEventId;
	}

	/**
	 * Sets the in event id.
	 *
	 * @param inEventId the inEventId to set
	 */

	public void setInEventId(long inEventId) {
		this.inEventId = inEventId;
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
	 * Gets the financial year.
	 *
	 * @return the financialYear
	 */

	public long getFinancialYear() {
		return financialYear;
	}

	/**
	 * Sets the financial year.
	 *
	 * @param financialYear the financialYear to set
	 */

	public void setFinancialYear(long financialYear) {
		this.financialYear = financialYear;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the eventOrderNo
	 */
	public long getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the new event order no
	 */
	public void setEventOrderNo(long eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the increment for.
	 *
	 * @return the incrementFor
	 */

	public long getIncrementFor() {
		return incrementFor;
	}

	/**
	 * Sets the increment for.
	 *
	 * @param incrementFor the incrementFor to set
	 */

	public void setIncrementFor(long incrementFor) {
		this.incrementFor = incrementFor;
	}

	/**
	 * Gets the increment type.
	 *
	 * @return the incrementType
	 */

	public long getIncrementType() {
		return incrementType;
	}

	/**
	 * Sets the increment type.
	 *
	 * @param incrementType the incrementType to set
	 */

	public void setIncrementType(long incrementType) {
		this.incrementType = incrementType;
	}

	/**
	 * Gets the class id.
	 *
	 * @return the classId
	 */

	public long getClassId() {
		return classId;
	}

	/**
	 * Sets the class id.
	 *
	 * @param classId the classId to set
	 */

	public void setClassId(long classId) {
		this.classId = classId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */

	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public Date getIncrementEffDate() {
		return incrementEffDate;
	}

	public void setIncrementEffDate(Date incrementEffDate) {
		this.incrementEffDate = incrementEffDate;
	}

	public Date getDateNextInc() {
		return dateNextInc;
	}

	public void setDateNextInc(Date dateNextInc) {
		this.dateNextInc = dateNextInc;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */

	public long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */

	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the pvu increment emp dtos.
	 *
	 * @return the pvuIncrementEmpDtos
	 */

	public List<PVUIncrementEmpDto> getPvuIncrementEmpDtos() {
		return pvuIncrementEmpDtos;
	}

	/**
	 * Sets the pvu increment emp dtos.
	 *
	 * @param pvuIncrementEmpDtos the pvuIncrementEmpDtos to set
	 */

	public void setPvuIncrementEmpDtos(List<PVUIncrementEmpDto> pvuIncrementEmpDtos) {
		this.pvuIncrementEmpDtos = pvuIncrementEmpDtos;
	}

	/**
	 * Gets the pvu increment event summary dto.
	 *
	 * @return the pvuIncrementEventSummaryDto
	 */

	public PVUIncrementEventSummaryDto getPvuIncrementEventSummaryDto() {
		return pvuIncrementEventSummaryDto;
	}

	/**
	 * Sets the pvu increment event summary dto.
	 *
	 * @param pvuIncrementEventSummaryDto the pvuIncrementEventSummaryDto to set
	 */

	public void setPvuIncrementEventSummaryDto(PVUIncrementEventSummaryDto pvuIncrementEventSummaryDto) {
		this.pvuIncrementEventSummaryDto = pvuIncrementEventSummaryDto;
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
	 * Gets the emp type.
	 *
	 * @return the empType
	 */
	public long getEmpType() {
		return empType;
	}

	/**
	 * Sets the emp type.
	 *
	 * @param empType the empType to set
	 */
	public void setEmpType(long empType) {
		this.empType = empType;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the financial year name.
	 *
	 * @return the financial year name
	 */
	public int getFinancialYearName() {
		return financialYearName;
	}

	/**
	 * Sets the financial year name.
	 *
	 * @param financialYearName the new financial year name
	 */
	public void setFinancialYearName(int financialYearName) {
		this.financialYearName = financialYearName;
	}

	/**
	 * Gets the increment for name.
	 *
	 * @return the increment for name
	 */
	public String getIncrementForName() {
		return incrementForName;
	}

	/**
	 * Sets the increment for name.
	 *
	 * @param incrementForName the new increment for name
	 */
	public void setIncrementForName(String incrementForName) {
		this.incrementForName = incrementForName;
	}

	/**
	 * Gets the increment type name.
	 *
	 * @return the increment type name
	 */
	public String getIncrementTypeName() {
		return incrementTypeName;
	}

	/**
	 * Sets the increment type name.
	 *
	 * @param incrementTypeName the new increment type name
	 */
	public void setIncrementTypeName(String incrementTypeName) {
		this.incrementTypeName = incrementTypeName;
	}

	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designation name
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the new designation name
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the emp type name.
	 *
	 * @return the emp type name
	 */
	public String getEmpTypeName() {
		return empTypeName;
	}

	/**
	 * Sets the emp type name.
	 *
	 * @param empTypeName the new emp type name
	 */
	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the emp pay type.
	 *
	 * @return the empPayType
	 */
	public long getEmpPayType() {
		return empPayType;
	}

	/**
	 * Sets the emp pay type.
	 *
	 * @param empPayType the empPayType to set
	 */
	public void setEmpPayType(long empPayType) {
		this.empPayType = empPayType;
	}

	/**
	 * Gets the emp pay type name.
	 *
	 * @return the empPayTypeName
	 */
	public String getEmpPayTypeName() {
		return empPayTypeName;
	}

	/**
	 * Sets the emp pay type name.
	 *
	 * @param empPayTypeName the empPayTypeName to set
	 */
	public void setEmpPayTypeName(String empPayTypeName) {
		this.empPayTypeName = empPayTypeName;
	}

	/**
	 * Gets the gpf.
	 *
	 * @return the gpf
	 */
	public String getGpf() {
		return gpf;
	}

	/**
	 * Sets the gpf.
	 *
	 * @param gpf the gpf to set
	 */
	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(classId, className, dateNextInc, designationId, designationName, empId,
				empNo, empPayType, empPayTypeName, empType, empTypeName, eventOrderNo, financialYear, financialYearName,
				gpf, inEventId, incrementEffDate, incrementFor, incrementForName, incrementType, incrementTypeName,
				officeId, postId, pvuIncrementEmpDtos, pvuIncrementEventSummaryDto, statusId, trnNo);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUIncrementEventDto)) {
			return false;
		}
		PVUIncrementEventDto other = (PVUIncrementEventDto) obj;
		return classId == other.classId && Objects.equals(className, other.className)
				&& Objects.equals(dateNextInc, other.dateNextInc) && designationId == other.designationId
				&& Objects.equals(designationName, other.designationName) && empId == other.empId
				&& Objects.equals(empNo, other.empNo) && empPayType == other.empPayType
				&& Objects.equals(empPayTypeName, other.empPayTypeName) && empType == other.empType
				&& Objects.equals(empTypeName, other.empTypeName) && eventOrderNo == other.eventOrderNo
				&& financialYear == other.financialYear && financialYearName == other.financialYearName
				&& Objects.equals(gpf, other.gpf) && inEventId == other.inEventId
				&& Objects.equals(incrementEffDate, other.incrementEffDate) && incrementFor == other.incrementFor
				&& Objects.equals(incrementForName, other.incrementForName) && incrementType == other.incrementType
				&& Objects.equals(incrementTypeName, other.incrementTypeName) && officeId == other.officeId
				&& postId == other.postId && Objects.equals(pvuIncrementEmpDtos, other.pvuIncrementEmpDtos)
				&& Objects.equals(pvuIncrementEventSummaryDto, other.pvuIncrementEventSummaryDto)
				&& statusId == other.statusId && Objects.equals(trnNo, other.trnNo);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"PVUIncrementEventDto [inEventId=%s, trnNo=%s, officeId=%s, postId=%s, financialYear=%s, financialYearName=%s, eventOrderNo=%s, incrementFor=%s, incrementForName=%s, incrementType=%s, incrementTypeName=%s, classId=%s, className=%s, designationId=%s, designationName=%s, incrementEffDate=%s, dateNextInc=%s, empId=%s, empType=%s, empTypeName=%s, empPayType=%s, empPayTypeName=%s, statusId=%s, empNo=%s, gpf=%s, pvuIncrementEmpDtos=%s, pvuIncrementEventSummaryDto=%s]",
				inEventId, trnNo, officeId, postId, financialYear, financialYearName, eventOrderNo, incrementFor,
				incrementForName, incrementType, incrementTypeName, classId, className, designationId, designationName,
				incrementEffDate, dateNextInc, empId, empType, empTypeName, empPayType, empPayTypeName, statusId, empNo,
				gpf, pvuIncrementEmpDtos, pvuIncrementEventSummaryDto);
	}

}
