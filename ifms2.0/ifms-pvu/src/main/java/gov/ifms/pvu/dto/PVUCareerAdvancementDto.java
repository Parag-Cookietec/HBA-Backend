package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUCarrearAdvancementDto.
 *
 * @version v 1.0
 * @created 2020/01/09 11:46:59
 *
 */
public class PVUCareerAdvancementDto extends PVUCurrentDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private long id;

	/** The event code. */
	@NotNull
	private String eventCode = PvuConstant.EVENT_CODE_CAREER_ADVANCE;

	/** The employee id. */
	private long employeeId;

	/** The trn no. */
	private String trnNo;

	/** The office id. */
	@Min(1)
	private long officeId;

	/** The pay comm id. */
	@Min(1)
	private long payCommId;

	/** The event order no. */
	@NotNull
	private String eventOrderNo;

	/** The event order date. */
	@NotNull
	private LocalDate eventOrderDate;

	/** The event effective date. */
	@NotNull
	private LocalDate eventEffectiveDate;

	/** The adv sch type. */
	@NotNull
	private long casType;

	/** The designation id. */
	private long designationId;

	/** The uni app lect type. */
	private long uniAppLectType;

	/** The option available id. */
	private long optionAvailableId;

	/** The option available date. */
	private LocalDate optionAvailableDate;

	/** The ori cour atte. */
	private long oriCourAtte;

	/** The ori cert date. */
	private LocalDate oriCertDate;

	/** The bene effict date. */
	private LocalDate beneEffictDate;

	/** The date of next increment. */
	private LocalDate dateOfNextIncrement;

	/** The ref cour atte. */
	private long refCourAtte;

	/** The ref cert date. */
	private LocalDate refCertDate;

	/** The pay scale. */
	private long payScale;

	/** The grade pay id. */
	private long gradePayId;

	/** The basic pay. */
	private long basicPay;

	/** The pay band id. */
	private long payBandId;

	/** The pay band value. */
	private long payBandValue;

	/** The pay level id. */
	private long payLevelId;

	/** The cell id. */
	private long cellId;

	/** The remarks. */
	private String remarks;

	/** The status id. */
	private long statusId;

	private Long employeeNo;

	private String officeName;

	@JsonIgnore
	private Exists exists;

	/** The auditor remarks. */
	private String auditorRemarks;

	/** The verifier remarks. */
	private String verifierRemarks;

	/** The class two remarks. */
	private String classTwoRemarks;

	/** The class one remarks. */
	private String classOneRemarks;

	/** The print remarks. */
	private String printRemarks;

	/** The auditor return reason. */
	private Long auditorReturnReason;

	/** The verifier return reason. */
	private Long verifierReturnReason;

	/** The class two return reason. */
	private Long classTwoReturnReason;

	/** The class one return reason. */
	private Long classOneReturnReason;

	/** The print return reason. */
	private Long printReturnReason;

	/** The print count. */
	private int printCount;

	/** The ref date. */
	private LocalDateTime refDate;

	/**
	 * The submit flag.
	 */
	private boolean same = true;
	private String scaleName;
	private String payBandName;
	private String payLevelName;
	private String cellName;
	private String gradePayName;
	private long personalPay;

	/** Files Attachments. */
	private List<AttachmentMasterDto> fileAttachment;

	private long eventId;
	
	/** The oa basic pay value. */
	private Long oaBasicPayValue;

	/** The oa pay scale id. */
	private Long oaPayScaleId;

	/** The oa pay band id. */
	private Long oaPayBandId;

	/** The oa pay band value. */
	private Long oaPayBandValue;

	/** The oa grade pay id. */
	private Long oaGradePayId;

	/** The oa pay level id. */
	private Long oaPayLevelId;

	/** The oa cell id value. */
	private Long oaCellIdValue;

	/** The oa pay cell id. */
	private Long oaPayCellId;

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
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
	 * Gets the event code.
	 *
	 * @return the eventCode
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * Sets the event code.
	 *
	 * @param eventCode the eventCode to set
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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
	 * Gets the pay comm id.
	 *
	 * @return the payCommId
	 */
	public long getPayCommId() {
		return payCommId;
	}

	/**
	 * Sets the pay comm id.
	 *
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * Gets the event order no.
	 *
	 * @return the eventOrderNo
	 */
	public String getEventOrderNo() {
		return eventOrderNo;
	}

	/**
	 * Sets the event order no.
	 *
	 * @param eventOrderNo the eventOrderNo to set
	 */
	public void setEventOrderNo(String eventOrderNo) {
		this.eventOrderNo = eventOrderNo;
	}

	/**
	 * Gets the event order date.
	 *
	 * @return the eventOrderDate
	 */
	public LocalDate getEventOrderDate() {
		return eventOrderDate;
	}

	/**
	 * Sets the event order date.
	 *
	 * @param eventOrderDate the eventOrderDate to set
	 */
	public void setEventOrderDate(LocalDate eventOrderDate) {
		this.eventOrderDate = eventOrderDate;
	}

	/**
	 * Gets the event effective date.
	 *
	 * @return the eventEffectiveDate
	 */
	public LocalDate getEventEffectiveDate() {
		return eventEffectiveDate;
	}

	/**
	 * Sets the event effective date.
	 *
	 * @param eventEffectiveDate the eventEffectiveDate to set
	 */
	public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
		this.eventEffectiveDate = eventEffectiveDate;
	}

	/**
	 * Gets the adv sch type.
	 *
	 * @return the advSchType
	 */
	public long getCasType() {
		return casType;
	}

	/**
	 * Sets the adv sch type.
	 *
	 * @param casType the advSchType to set
	 */
	public void setCasType(long casType) {
		this.casType = casType;
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

	/**
	 * Gets the uni app lect type.
	 *
	 * @return the uniAppLectType
	 */
	public long getUniAppLectType() {
		return uniAppLectType;
	}

	/**
	 * Sets the uni app lect type.
	 *
	 * @param uniAppLectType the uniAppLectType to set
	 */
	public void setUniAppLectType(long uniAppLectType) {
		this.uniAppLectType = uniAppLectType;
	}

	/**
	 * Gets the option available id.
	 *
	 * @return the optionAvailableId
	 */
	public long getOptionAvailableId() {
		return optionAvailableId;
	}

	/**
	 * Sets the option available id.
	 *
	 * @param optionAvailableId the optionAvailableId to set
	 */
	public void setOptionAvailableId(long optionAvailableId) {
		this.optionAvailableId = optionAvailableId;
	}

	/**
	 * Gets the option available date.
	 *
	 * @return the optionAvailableDate
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Sets the option available date.
	 *
	 * @param optionAvailableDate the optionAvailableDate to set
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Gets the ori cour atte.
	 *
	 * @return the oriCourAtte
	 */
	public long getOriCourAtte() {
		return oriCourAtte;
	}

	/**
	 * Sets the ori cour atte.
	 *
	 * @param oriCourAtte the oriCourAtte to set
	 */
	public void setOriCourAtte(long oriCourAtte) {
		this.oriCourAtte = oriCourAtte;
	}

	/**
	 * Gets the ori cert date.
	 *
	 * @return the oriCertDate
	 */
	public LocalDate getOriCertDate() {
		return oriCertDate;
	}

	/**
	 * Sets the ori cert date.
	 *
	 * @param oriCertDate the oriCertDate to set
	 */
	public void setOriCertDate(LocalDate oriCertDate) {
		this.oriCertDate = oriCertDate;
	}

	/**
	 * Gets the bene effict date.
	 *
	 * @return the beneEffictDate
	 */
	public LocalDate getBeneEffictDate() {
		return beneEffictDate;
	}

	/**
	 * Sets the bene effict date.
	 *
	 * @param beneEffictDate the beneEffictDate to set
	 */
	public void setBeneEffictDate(LocalDate beneEffictDate) {
		this.beneEffictDate = beneEffictDate;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return the dateOfNextIncrement
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Sets the date of next increment.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement to set
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Gets the ref cour atte.
	 *
	 * @return the refCourAtte
	 */
	public long getRefCourAtte() {
		return refCourAtte;
	}

	/**
	 * Sets the ref cour atte.
	 *
	 * @param refCourAtte the refCourAtte to set
	 */
	public void setRefCourAtte(long refCourAtte) {
		this.refCourAtte = refCourAtte;
	}

	/**
	 * Gets the ref cert date.
	 *
	 * @return the refCertDate
	 */
	public LocalDate getRefCertDate() {
		return refCertDate;
	}

	/**
	 * Sets the ref cert date.
	 *
	 * @param refCertDate the refCertDate to set
	 */
	public void setRefCertDate(LocalDate refCertDate) {
		this.refCertDate = refCertDate;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the gradePayId
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
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
	 * Gets the file attachment.
	 *
	 * @return the fileAttachment
	 */
	public List<AttachmentMasterDto> getFileAttachment() {
		return fileAttachment;
	}

	/**
	 * Sets the file attachment.
	 *
	 * @param fileAttachment the fileAttachment to set
	 */
	public void setFileAttachment(List<AttachmentMasterDto> fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	/**
	 * Getter for property 'exists'.
	 *
	 * @return Value for property 'exists'.
	 */
	public Exists getExists() {
		return exists;
	}

	/**
	 * Getter for property 'same'.
	 *
	 * @return Value for property 'same'.
	 */
	public boolean isSame() {
		return same;
	}

	/**
	 * Setter for property 'same'.
	 *
	 * @param same Value to set for property 'same'.
	 */
	public void setSame(boolean same) {
		this.same = same;
	}

	/**
	 * Setter for property 'exists'.
	 *
	 * @param exists Value to set for property 'exists'.
	 */
	public void setExists(Exists exists) {
		this.exists = exists;
	}

	public String getAuditorRemarks() {
		return auditorRemarks;
	}

	public void setAuditorRemarks(String auditorRemarks) {
		this.auditorRemarks = auditorRemarks;
	}

	public String getVerifierRemarks() {
		return verifierRemarks;
	}

	public void setVerifierRemarks(String verifierRemarks) {
		this.verifierRemarks = verifierRemarks;
	}

	public String getClassTwoRemarks() {
		return classTwoRemarks;
	}

	public void setClassTwoRemarks(String classTwoRemarks) {
		this.classTwoRemarks = classTwoRemarks;
	}

	public String getClassOneRemarks() {
		return classOneRemarks;
	}

	public void setClassOneRemarks(String classOneRemarks) {
		this.classOneRemarks = classOneRemarks;
	}

	public String getPrintRemarks() {
		return printRemarks;
	}

	public void setPrintRemarks(String printRemarks) {
		this.printRemarks = printRemarks;
	}

	public Long getAuditorReturnReason() {
		return auditorReturnReason;
	}

	public void setAuditorReturnReason(Long auditorReturnReason) {
		this.auditorReturnReason = auditorReturnReason;
	}

	public Long getVerifierReturnReason() {
		return verifierReturnReason;
	}

	public void setVerifierReturnReason(Long verifierReturnReason) {
		this.verifierReturnReason = verifierReturnReason;
	}

	public Long getClassTwoReturnReason() {
		return classTwoReturnReason;
	}

	public void setClassTwoReturnReason(Long classTwoReturnReason) {
		this.classTwoReturnReason = classTwoReturnReason;
	}

	public Long getClassOneReturnReason() {
		return classOneReturnReason;
	}

	public void setClassOneReturnReason(Long classOneReturnReason) {
		this.classOneReturnReason = classOneReturnReason;
	}

	public Long getPrintReturnReason() {
		return printReturnReason;
	}

	public void setPrintReturnReason(Long printReturnReason) {
		this.printReturnReason = printReturnReason;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	@Override
	public Set<String> propertyBasedValidation() {
		Set<String> fields = new HashSet<>();
		fields.add("eventEffectiveDate");
		fields.add("eventOrderDate");
		fields.add("eventOrderNo");
		fields.add("eventCode");
		fields.add("officeId");
		fields.add("casType");
		fields.add("payCommId");
		return fields;
	}

	/**
	 * The type Exists.
	 */
	public static class Exists implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * The event effective date.
		 */
		private LocalDate eventEffectiveDate;

		/**
		 * The pay comm id.
		 */
		private long payCommId;

		/**
		 * The employee class id.
		 */
		private long employeeClassId;

		/**
		 * The designationId id.
		 */
		private long designationId;

		/**
		 * The pay scale.
		 */
		private long payScale;

		/**
		 * The pay band value.
		 */
		private long payBandValue;

		/**
		 * The basic pay.
		 */
		private long basicPay;

		/**
		 * The date of joining.
		 */
		private LocalDate dateOfJoining;

		/**
		 * The date of next increment.
		 */
		private LocalDate dateOfNextIncrement;

		/**
		 * The cell id.
		 */
		private long cellId;

		/**
		 * The pay level id.
		 */
		private long payLevelId;

		/**
		 * The pay band id.
		 */
		private long payBandId;

		/**
		 * The grade pay id.
		 */
		private long gradePayId;

		/**
		 * Gets event effective date.
		 *
		 * @return the event effective date
		 */
		public LocalDate getEventEffectiveDate() {
			return eventEffectiveDate;
		}

		/**
		 * Sets event effective date.
		 *
		 * @param eventEffectiveDate the event effective date
		 */
		public void setEventEffectiveDate(LocalDate eventEffectiveDate) {
			this.eventEffectiveDate = eventEffectiveDate;
		}

		/**
		 * Gets pay comm id.
		 *
		 * @return the pay comm id
		 */
		public long getPayCommId() {
			return payCommId;
		}

		/**
		 * Sets pay comm id.
		 *
		 * @param payCommId the pay comm id
		 */
		public void setPayCommId(long payCommId) {
			this.payCommId = payCommId;
		}

		/**
		 * Gets employee class id.
		 *
		 * @return the employee class id
		 */
		public long getEmployeeClassId() {
			return employeeClassId;
		}

		/**
		 * Sets employee class id.
		 *
		 * @param employeeClassId the employee class id
		 */
		public void setEmployeeClassId(long employeeClassId) {
			this.employeeClassId = employeeClassId;
		}

		/**
		 * Gets designation id.
		 *
		 * @return the designation id
		 */
		public long getDesignationId() {
			return designationId;
		}

		/**
		 * Sets designation id.
		 *
		 * @param designationId the designation id
		 */
		public void setDesignationId(long designationId) {
			this.designationId = designationId;
		}

		/**
		 * Gets pay scale.
		 *
		 * @return the pay scale
		 */
		public long getPayScale() {
			return payScale;
		}

		/**
		 * Sets pay scale.
		 *
		 * @param payScale the pay scale
		 */
		public void setPayScale(long payScale) {
			this.payScale = payScale;
		}

		/**
		 * Gets pay band value.
		 *
		 * @return the pay band value
		 */
		public long getPayBandValue() {
			return payBandValue;
		}

		/**
		 * Sets pay band value.
		 *
		 * @param payBandValue the pay band value
		 */
		public void setPayBandValue(long payBandValue) {
			this.payBandValue = payBandValue;
		}

		/**
		 * Gets basic pay.
		 *
		 * @return the basic pay
		 */
		public long getBasicPay() {
			return basicPay;
		}

		/**
		 * Sets basic pay.
		 *
		 * @param basicPay the basic pay
		 */
		public void setBasicPay(long basicPay) {
			this.basicPay = basicPay;
		}

		/**
		 * Gets date of joining.
		 *
		 * @return the date of joining
		 */
		public LocalDate getDateOfJoining() {
			return dateOfJoining;
		}

		/**
		 * Sets date of joining.
		 *
		 * @param dateOfJoining the date of joining
		 */
		public void setDateOfJoining(LocalDate dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		/**
		 * Gets date of next increment.
		 *
		 * @return the date of next increment
		 */
		public LocalDate getDateOfNextIncrement() {
			return dateOfNextIncrement;
		}

		/**
		 * Sets date of next increment.
		 *
		 * @param dateOfNextIncrement the date of next increment
		 */
		public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
			this.dateOfNextIncrement = dateOfNextIncrement;
		}

		/**
		 * Gets cell id.
		 *
		 * @return the cell id
		 */
		public long getCellId() {
			return cellId;
		}

		/**
		 * Sets cell id.
		 *
		 * @param cellId the cell id
		 */
		public void setCellId(long cellId) {
			this.cellId = cellId;
		}

		/**
		 * Gets pay level id.
		 *
		 * @return the pay level id
		 */
		public long getPayLevelId() {
			return payLevelId;
		}

		/**
		 * Sets pay level id.
		 *
		 * @param payLevelId the pay level id
		 */
		public void setPayLevelId(long payLevelId) {
			this.payLevelId = payLevelId;
		}

		/**
		 * Gets pay band id.
		 *
		 * @return the pay band id
		 */
		public long getPayBandId() {
			return payBandId;
		}

		/**
		 * Sets pay band id.
		 *
		 * @param payBandId the pay band id
		 */
		public void setPayBandId(long payBandId) {
			this.payBandId = payBandId;
		}

		/**
		 * Gets grade pay id.
		 *
		 * @return the grade pay id
		 */
		public long getGradePayId() {
			return gradePayId;
		}

		/**
		 * Sets grade pay id.
		 *
		 * @param gradePayId the grade pay id
		 */
		public void setGradePayId(long gradePayId) {
			this.gradePayId = gradePayId;
		}
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	public String getPayBandName() {
		return payBandName;
	}

	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	public String getPayLevelName() {
		return payLevelName;
	}

	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	public String getCellName() {
		return cellName;
	}

	public void setCellName(String cellName) {
		this.cellName = cellName;
	}

	public String getGradePayName() {
		return gradePayName;
	}

	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	public long getPersonalPay() {
		return personalPay;
	}

	public void setPersonalPay(long personalPay) {
		this.personalPay = personalPay;
	}
	
	

	/**
	 * @return the oaBasicPayValue
	 */
	public Long getOaBasicPayValue() {
		return oaBasicPayValue;
	}

	/**
	 * @param oaBasicPayValue the oaBasicPayValue to set
	 */
	public void setOaBasicPayValue(Long oaBasicPayValue) {
		this.oaBasicPayValue = oaBasicPayValue;
	}

	/**
	 * @return the oaPayScaleId
	 */
	public Long getOaPayScaleId() {
		return oaPayScaleId;
	}

	/**
	 * @param oaPayScaleId the oaPayScaleId to set
	 */
	public void setOaPayScaleId(Long oaPayScaleId) {
		this.oaPayScaleId = oaPayScaleId;
	}

	/**
	 * @return the oaPayBandId
	 */
	public Long getOaPayBandId() {
		return oaPayBandId;
	}

	/**
	 * @param oaPayBandId the oaPayBandId to set
	 */
	public void setOaPayBandId(Long oaPayBandId) {
		this.oaPayBandId = oaPayBandId;
	}

	/**
	 * @return the oaPayBandValue
	 */
	public Long getOaPayBandValue() {
		return oaPayBandValue;
	}

	/**
	 * @param oaPayBandValue the oaPayBandValue to set
	 */
	public void setOaPayBandValue(Long oaPayBandValue) {
		this.oaPayBandValue = oaPayBandValue;
	}

	/**
	 * @return the oaGradePayId
	 */
	public Long getOaGradePayId() {
		return oaGradePayId;
	}

	/**
	 * @param oaGradePayId the oaGradePayId to set
	 */
	public void setOaGradePayId(Long oaGradePayId) {
		this.oaGradePayId = oaGradePayId;
	}

	/**
	 * @return the oaPayLevelId
	 */
	public Long getOaPayLevelId() {
		return oaPayLevelId;
	}

	/**
	 * @param oaPayLevelId the oaPayLevelId to set
	 */
	public void setOaPayLevelId(Long oaPayLevelId) {
		this.oaPayLevelId = oaPayLevelId;
	}

	/**
	 * @return the oaCellIdValue
	 */
	public Long getOaCellIdValue() {
		return oaCellIdValue;
	}

	/**
	 * @param oaCellIdValue the oaCellIdValue to set
	 */
	public void setOaCellIdValue(Long oaCellIdValue) {
		this.oaCellIdValue = oaCellIdValue;
	}

	/**
	 * @return the oaPayCellId
	 */
	public Long getOaPayCellId() {
		return oaPayCellId;
	}

	/**
	 * @param oaPayCellId the oaPayCellId to set
	 */
	public void setOaPayCellId(Long oaPayCellId) {
		this.oaPayCellId = oaPayCellId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUCareerAdvancementDto)) return false;
		if (!super.equals(o)) return false;
		PVUCareerAdvancementDto that = (PVUCareerAdvancementDto) o;
		return getId() == that.getId() &&
				getEmployeeId() == that.getEmployeeId() &&
				getOfficeId() == that.getOfficeId() &&
				getPayCommId() == that.getPayCommId() &&
				getCasType() == that.getCasType() &&
				getDesignationId() == that.getDesignationId() &&
				getUniAppLectType() == that.getUniAppLectType() &&
				getOptionAvailableId() == that.getOptionAvailableId() &&
				getOriCourAtte() == that.getOriCourAtte() &&
				getRefCourAtte() == that.getRefCourAtte() &&
				getPayScale() == that.getPayScale() &&
				getGradePayId() == that.getGradePayId() &&
				getBasicPay() == that.getBasicPay() &&
				getPayBandId() == that.getPayBandId() &&
				getPayBandValue() == that.getPayBandValue() &&
				getPayLevelId() == that.getPayLevelId() &&
				getCellId() == that.getCellId() &&
				getStatusId() == that.getStatusId() &&
				getPrintCount() == that.getPrintCount() &&
				isSame() == that.isSame() &&
				getPersonalPay() == that.getPersonalPay() &&
				getEventId() == that.getEventId() &&
				Objects.equals(getEventCode(), that.getEventCode()) &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getEventOrderNo(), that.getEventOrderNo()) &&
				Objects.equals(getEventOrderDate(), that.getEventOrderDate()) &&
				Objects.equals(getEventEffectiveDate(), that.getEventEffectiveDate()) &&
				Objects.equals(getOptionAvailableDate(), that.getOptionAvailableDate()) &&
				Objects.equals(getOriCertDate(), that.getOriCertDate()) &&
				Objects.equals(getBeneEffictDate(), that.getBeneEffictDate()) &&
				Objects.equals(getDateOfNextIncrement(), that.getDateOfNextIncrement()) &&
				Objects.equals(getRefCertDate(), that.getRefCertDate()) &&
				Objects.equals(getRemarks(), that.getRemarks()) &&
				Objects.equals(getEmployeeNo(), that.getEmployeeNo()) &&
				Objects.equals(getOfficeName(), that.getOfficeName()) &&
				Objects.equals(getExists(), that.getExists()) &&
				Objects.equals(getAuditorRemarks(), that.getAuditorRemarks()) &&
				Objects.equals(getVerifierRemarks(), that.getVerifierRemarks()) &&
				Objects.equals(getClassTwoRemarks(), that.getClassTwoRemarks()) &&
				Objects.equals(getClassOneRemarks(), that.getClassOneRemarks()) &&
				Objects.equals(getPrintRemarks(), that.getPrintRemarks()) &&
				Objects.equals(getAuditorReturnReason(), that.getAuditorReturnReason()) &&
				Objects.equals(getVerifierReturnReason(), that.getVerifierReturnReason()) &&
				Objects.equals(getClassTwoReturnReason(), that.getClassTwoReturnReason()) &&
				Objects.equals(getClassOneReturnReason(), that.getClassOneReturnReason()) &&
				Objects.equals(getPrintReturnReason(), that.getPrintReturnReason()) &&
				Objects.equals(getRefDate(), that.getRefDate()) &&
				Objects.equals(getScaleName(), that.getScaleName()) &&
				Objects.equals(getPayBandName(), that.getPayBandName()) &&
				Objects.equals(getPayLevelName(), that.getPayLevelName()) &&
				Objects.equals(getCellName(), that.getCellName()) &&
				Objects.equals(getGradePayName(), that.getGradePayName()) &&
				Objects.equals(getFileAttachment(), that.getFileAttachment())
				&& Objects.equals(oaBasicPayValue, that.oaBasicPayValue)
				&& Objects.equals(oaCellIdValue, that.oaCellIdValue)
				&& Objects.equals(oaGradePayId, that.oaGradePayId)
				&& Objects.equals(oaPayBandId, that.oaPayBandId)
				&& Objects.equals(oaPayBandValue, that.oaPayBandValue)
				&& Objects.equals(oaPayCellId, that.oaPayCellId)
				&& Objects.equals(oaPayLevelId, that.oaPayLevelId)
				&& Objects.equals(oaPayScaleId, that.oaPayScaleId);
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getId(), getEventCode(), getEmployeeId(), getTrnNo(), getOfficeId(), getPayCommId(), getEventOrderNo(),
				getEventOrderDate(), getEventEffectiveDate(), getCasType(), getDesignationId(), getUniAppLectType(), getOptionAvailableId(),
				getOptionAvailableDate(), getOriCourAtte(), getOriCertDate(), getBeneEffictDate(), getDateOfNextIncrement(), getRefCourAtte(),
				getRefCertDate(), getPayScale(), getGradePayId(), getBasicPay(), getPayBandId(), getPayBandValue(), getPayLevelId(), getCellId(),
				getRemarks(), getStatusId(), getEmployeeNo(), getOfficeName(), getExists(), getAuditorRemarks(), getVerifierRemarks(),
				getClassTwoRemarks(), getClassOneRemarks(), getPrintRemarks(), getAuditorReturnReason(), getVerifierReturnReason(),
				getClassTwoReturnReason(), getClassOneReturnReason(), getPrintReturnReason(), getPrintCount(), getRefDate(), isSame(), getEventId(),
				getScaleName(), getPayBandName(), getPayLevelName(), getCellName(), getGradePayName(), getPersonalPay(), getFileAttachment(),
				oaCellIdValue, oaBasicPayValue, oaGradePayId, oaPayBandId, oaPayBandValue, oaPayCellId, oaPayScaleId, oaPayLevelId);
	}

	@Override
	public String toString() {
		return "PVUCareerAdvancementDto [id=" + id + ", eventCode=" + eventCode + ", employeeId=" + employeeId
				+ ", trnNo=" + trnNo + ", officeId=" + officeId + ", payCommId=" + payCommId + ", eventOrderNo="
				+ eventOrderNo + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate=" + eventEffectiveDate
				+ ", casType=" + casType + ", designationId=" + designationId + ", uniAppLectType=" + uniAppLectType
				+ ", optionAvailableId=" + optionAvailableId + ", optionAvailableDate=" + optionAvailableDate
				+ ", oriCourAtte=" + oriCourAtte + ", oriCertDate=" + oriCertDate + ", beneEffictDate=" + beneEffictDate
				+ ", dateOfNextIncrement=" + dateOfNextIncrement + ", refCourAtte=" + refCourAtte + ", refCertDate="
				+ refCertDate + ", payScale=" + payScale + ", gradePayId=" + gradePayId + ", basicPay=" + basicPay
				+ ", payBandId=" + payBandId + ", payBandValue=" + payBandValue + ", payLevelId=" + payLevelId
				+ ", cellId=" + cellId + ", remarks=" + remarks + ", statusId=" + statusId + ", employeeNo="
				+ employeeNo + ", officeName=" + officeName + ", exists=" + exists + ", auditorRemarks="
				+ auditorRemarks + ", verifierRemarks=" + verifierRemarks + ", classTwoRemarks=" + classTwoRemarks
				+ ", classOneRemarks=" + classOneRemarks + ", printRemarks=" + printRemarks + ", auditorReturnReason="
				+ auditorReturnReason + ", verifierReturnReason=" + verifierReturnReason + ", classTwoReturnReason="
				+ classTwoReturnReason + ", classOneReturnReason=" + classOneReturnReason + ", printReturnReason="
				+ printReturnReason + ", printCount=" + printCount + ", refDate=" + refDate + ", same=" + same
				+ ", scaleName=" + scaleName + ", payBandName=" + payBandName + ", payLevelName=" + payLevelName
				+ ", cellName=" + cellName + ", gradePayName=" + gradePayName + ", personalPay=" + personalPay
				+ ", fileAttachment=" + fileAttachment + ", eventId=" + eventId + ", oaBasicPayValue=" + oaBasicPayValue
				+ ", oaPayScaleId=" + oaPayScaleId + ", oaPayBandId=" + oaPayBandId + ", oaPayBandValue="
				+ oaPayBandValue + ", oaGradePayId=" + oaGradePayId + ", oaPayLevelId=" + oaPayLevelId
				+ ", oaCellIdValue=" + oaCellIdValue + ", oaPayCellId=" + oaPayCellId + "]";
	}

	
}
