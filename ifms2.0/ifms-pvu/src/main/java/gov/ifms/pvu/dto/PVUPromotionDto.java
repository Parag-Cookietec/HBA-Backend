package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.pvu.common.PVUCurrentDto;
import gov.ifms.pvu.common.PartFifth;
import gov.ifms.pvu.common.PartMain;
import gov.ifms.pvu.common.PartSeventh;
import gov.ifms.pvu.common.PartSixth;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVUPromotionDto.
 */
public class PVUPromotionDto extends PVUCurrentDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The className.
	 */
	private final String className = this.getClass().getSimpleName();

	/**
	 * The id.
	 */
	private Long id;

	/**
	 * The submit flag.
	 */
	private boolean submit = false;

	/**
	 * The submit flag.
	 */
	private boolean same = true;

	/**
	 * The trn no.
	 */
	private String trnNo;

	/**
	 * The event code.
	 */
	@NotNull
	private String eventCode = PvuConstant.EVENT_CODE_PROMOTION;

	/**
	 * The office id.
	 */
	@Min(1)
	private long officeId;

	/**
	 * The event order no.
	 */
	@NotNull
	private String eventOrderNo;

	/**
	 * The event order no.
	 */
	private LocalDateTime refDate;

	/**
	 * The event order date.
	 */
	@NotNull
	private LocalDate eventOrderDate;

	/**
	 * The event effective date.
	 */
	@NotNull
	private LocalDate eventEffectiveDate;

	/**
	 * The status id.
	 */
	private long statusId;

	/**
	 * The promotion type id.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long promotionTypeId;

	/**
	 * The employee no.
	 */
	@Digits(integer = 10, fraction = 0, groups = PartMain.class)
	private long employeeNo;

	/**
	 * The pay comm id.
	 */
	@Min(1)
	private long payCommId;

	/**
	 * The employee id.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long employeeId;

	/**
	 * The employee class id.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long employeeClassId;

	/**
	 * The designationId id.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long designationId;

	/** The option available id. */
	private long optionAvailableId;

	/**
	 * The date of joining.
	 */
	@NotNull(groups = PartMain.class)
	private LocalDate dateOfJoining;

	/**
	 * The basic pay.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long basicPay;

	/**
	 * The noon type id.
	 */
	@Min(value = 1, groups = PartMain.class)
	private long noonTypeId;

	/**
	 * The date of next increment.
	 */
	@NotNull(groups = PartMain.class)
	private LocalDate dateOfNextIncrement;

	/**
	 * The department category id.
	 */
	@Min(value = 1, groups = PartMain.class)
	@NotNull(groups = PartMain.class)
	private Long departmentCategoryId;

	/**
	 * The pay scale.
	 */
	@Min(value = 1, groups = PartFifth.class)
	private long payScale;

	/**
	 * The pay band value.
	 */
	@Min(value = 1, groups = PartSixth.class)
	private long payBandValue;

	/**
	 * The pay band id.
	 */
	@Min(value = 1, groups = PartSixth.class)
	private long payBandId;

	/**
	 * The grade pay id.
	 */
	@Min(value = 1, groups = PartSixth.class)
	private long gradePayId;

	/**
	 * The cell id.
	 */
	@Min(value = 1, groups = PartSeventh.class)
	private long cellId;

	/**
	 * The pay level id.
	 */
	@Min(value = 1, groups = PartSeventh.class)
	private long payLevelId;

	/**
	 * The option available date.
	 */
	private LocalDate optionAvailableDate;

	/**
	 * The remarks.
	 */
	private String remarks;

	/**
	 * The grade pay id.
	 */
	@JsonIgnore
	private Exists exists;

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

	/** The pay band name. */
	private String payBandName;

	/** The grade pay name. */
	private String gradePayName;

	/** The pay level name. */
	private String payLevelName;

	/** The scale name. */
	private String scaleName;

	/**
	 * Getter for property 'submit'.
	 *
	 * @return Value for property 'submit'.
	 */
	public boolean isSubmit() {
		return submit;
	}

	/**
	 * Setter for property 'submit'.
	 *
	 * @param submit Value to set for property 'submit'.
	 */
	public void setSubmit(boolean submit) {
		this.submit = submit;
	}

	/* Getter Setter */

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
	 * Gets the status id.
	 *
	 * @return statusId status id
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets employee id.
	 *
	 * @return employeeId employee id
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Gets the employee class id.
	 *
	 * @return employeeClassId employee class id
	 */
	public long getEmployeeClassId() {
		return employeeClassId;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return designationId designation id
	 */
	public long getDesignationId() {
		return designationId;
	}

	/**
	 * Gets the option available id.
	 *
	 * @return optionAvailableId option available id
	 */
	public long getOptionAvailableId() {
		return optionAvailableId;
	}

	/**
	 * Gets the option available date.
	 *
	 * @return optionAvailableDate option available date
	 */
	public LocalDate getOptionAvailableDate() {
		return optionAvailableDate;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return payScale pay scale
	 */
	public long getPayScale() {
		return payScale;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return payBandValue pay band value
	 */
	public long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return basicPay basic pay
	 */
	public long getBasicPay() {
		return basicPay;
	}

	/**
	 * Gets the date of joining.
	 *
	 * @return dateOfJoining date of joining
	 */
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * Gets the noon type id.
	 *
	 * @return noonTypeId noon type id
	 */
	public long getNoonTypeId() {
		return noonTypeId;
	}

	/**
	 * Gets the date of next increment.
	 *
	 * @return dateOfNextIncrement date of next increment
	 */
	public LocalDate getDateOfNextIncrement() {
		return dateOfNextIncrement;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return cellId cell id
	 */
	public long getCellId() {
		return cellId;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return remarks remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Gets the promotion type id.
	 *
	 * @return promotionTypeId promotion type id
	 */
	public long getPromotionTypeId() {
		return promotionTypeId;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return payLevelId pay level id
	 */
	public long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return payBandId pay band id
	 */
	public long getPayBandId() {
		return payBandId;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return gradePayId grade pay id
	 */
	public long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Set employeeId.
	 *
	 * @param employeeId the employeeId
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Set employeeClassId.
	 *
	 * @param employeeClassId the employeeClassId
	 */
	public void setEmployeeClassId(long employeeClassId) {
		this.employeeClassId = employeeClassId;
	}

	/**
	 * Set designationId.
	 *
	 * @param designationId the designationId
	 */
	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Set optionAvailableId.
	 *
	 * @param optionAvailableId the optionAvailableId
	 */
	public void setOptionAvailableId(long optionAvailableId) {
		this.optionAvailableId = optionAvailableId;
	}

	/**
	 * Set optionAvailableDate.
	 *
	 * @param optionAvailableDate the optionAvailableDate
	 */
	public void setOptionAvailableDate(LocalDate optionAvailableDate) {
		this.optionAvailableDate = optionAvailableDate;
	}

	/**
	 * Set payScale.
	 *
	 * @param payScale the payScale
	 */
	public void setPayScale(long payScale) {
		this.payScale = payScale;
	}

	/**
	 * Set payBandValue.
	 *
	 * @param payBandValue the payBandValue
	 */
	public void setPayBandValue(long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Set basicPay.
	 *
	 * @param basicPay the basicPay
	 */
	public void setBasicPay(long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Set dateOfJoining.
	 *
	 * @param dateOfJoining the dateOfJoining
	 */
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * Set noonTypeId.
	 *
	 * @param noonTypeId the noonTypeId
	 */
	public void setNoonTypeId(long noonTypeId) {
		this.noonTypeId = noonTypeId;
	}

	/**
	 * Set dateOfNextIncrement.
	 *
	 * @param dateOfNextIncrement the dateOfNextIncrement
	 */
	public void setDateOfNextIncrement(LocalDate dateOfNextIncrement) {
		this.dateOfNextIncrement = dateOfNextIncrement;
	}

	/**
	 * Set cellId.
	 *
	 * @param cellId the cellId
	 */
	public void setCellId(long cellId) {
		this.cellId = cellId;
	}

	/**
	 * Set remarks.
	 *
	 * @param remarks the remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Set promotionTypeId.
	 *
	 * @param promotionTypeId the promotionTypeId
	 */
	public void setPromotionTypeId(long promotionTypeId) {
		this.promotionTypeId = promotionTypeId;
	}

	/**
	 * Set payLevelId.
	 *
	 * @param payLevelId the payLevelId
	 */
	public void setPayLevelId(long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Set payBandId.
	 *
	 * @param payBandId the payBandId
	 */
	public void setPayBandId(long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Set gradePayId.
	 *
	 * @param gradePayId the gradePayId
	 */
	public void setGradePayId(long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the event code.
	 *
	 * @return eventCode event code
	 */
	public String getEventCode() {
		return eventCode;
	}

	/**
	 * Set eventCode.
	 *
	 * @param eventCode the eventCode
	 */
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	/**
	 * Gets the employee no.
	 *
	 * @return employeeNo employee no
	 */
	public long getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * Set employeeNo.
	 *
	 * @param employeeNo the employeeNo
	 */
	public void setEmployeeNo(long employeeNo) {
		this.employeeNo = employeeNo;
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
	 * Setter for property 'exists'.
	 *
	 * @param exists Value to set for property 'exists'.
	 */
	public void setExists(Exists exists) {
		this.exists = exists;
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
	 * Property based validation.
	 *
	 * @return the sets the
	 */
	@Override
	public Set<String> propertyBasedValidation() {
		Set<String> fields = new HashSet<>();
		fields.add("eventEffectiveDate");
		fields.add("eventOrderDate");
		fields.add("eventOrderNo");
		fields.add("eventCode");
		fields.add("officeId");
//        fields.add("promotionTypeId");
		fields.add("payCommId");
		return fields;
	}

	/**
	 * The type Exists.
	 */
	public static class Exists implements Serializable {

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
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/*
	 * @Override public List<FieldError> businessValidate() { List<FieldError>
	 * errors = new ArrayList<>(); if (this.getExists().getPayCommId() ==
	 * PvuConstant.FIFTH_COMMISSION_ID || this.getExists().getPayCommId() ==
	 * PvuConstant.SIXTH_COMMISSION_ID || this.getExists().getPayCommId() ==
	 * PvuConstant.SEVENTH_COMMISSION_ID) {
	 *//*
		 * errors.add(PvuUtils.errorField("PVUPromotionDto", null,
		 * "Employee can eligible for only if he in 5, 6 or 7 pay commission"));
		 * 
		 *//*
			 * 
			 * // Promotion in same pay scale if ((this.getPromotionTypeId() == 275) &&
			 * (this.getExists().getEmployeeClassId() == this.getEmployeeClassId()) &&
			 * (this.getExists().getDesignationId() == this.getDesignationId())) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "Either class or designation must be change")); } else { if
			 * (this.getPromotionTypeId() == 275) { if (this.getExists().getPayCommId() !=
			 * this.getPayCommId()) { errors.add(PvuUtils.errorField(className, "payCommId",
			 * "Can't able to change Pay commission")); } if (this.getExists().getBasicPay()
			 * != this.getBasicPay()) { errors.add(PvuUtils.errorField(className,
			 * "basicPay", "Can't able to change Basic Pay")); } // 5th if
			 * (this.getExists().getPayCommId() == 150) { if (this.getExists().getPayScale()
			 * != this.getPayScale()) { errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in same pay scale can't change Pay Scale")); } } // 6 th pay
			 * else if (this.getExists().getPayBandValue() == 151) { if
			 * (this.getExists().getPayBandValue() != this.getPayBandValue()) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in same pay scale can't change Pay Band Value")); } if
			 * (this.getExists().getPayBandId() != this.getPayBandId()) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in same pay scale can't change Pay Band")); } if
			 * (this.getExists().getGradePayId() != this.getGradePayId()) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in same pay scale can't change Grade Pay")); } } // 7 th pay
			 * else if (this.getExists().getPayCommId() == 152) { if
			 * (this.getExists().getCellId() != this.getCellId()) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in same pay scale can't change Cell Id")); } if
			 * (this.getExists().getPayLevelId() != this.getPayLevelId()) {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "In, Promotion in Same Pay Scale Can't Pay Level")); } } } else if
			 * (this.getPromotionTypeId() == 274) { if (this.getExists().getBasicPay() <=
			 * this.getBasicPay()) { errors.add(PvuUtils.errorField(className, "basicPay",
			 * "In Promotion Basic Should Not Be Same or Less!")); } } else {
			 * errors.add(PvuUtils.errorField(className, null,
			 * "Invalid request, Either Select Promotion or Promotion in Same pay Scale."));
			 * } } } else { errors.add(PvuUtils.errorField(className, null,
			 * "Employee can eligible for only if he/she in 5, 6 or 7 pay commission")); }
			 * return errors; }
			 */

	/**
	 * Checks if is new.
	 *
	 * @return true, if is new
	 */
	@JsonIgnore
	public boolean isNew() {
		return this.id == null || this.id == 0;
	}

	/**
	 * Gets the oa basic pay value.
	 *
	 * @return the oaBasicPayValue
	 */
	public Long getOaBasicPayValue() {
		return oaBasicPayValue;
	}

	/**
	 * Sets the oa basic pay value.
	 *
	 * @param oaBasicPayValue the oaBasicPayValue to set
	 */
	public void setOaBasicPayValue(Long oaBasicPayValue) {
		this.oaBasicPayValue = oaBasicPayValue;
	}

	/**
	 * Gets the oa pay scale id.
	 *
	 * @return the oaPayScaleId
	 */
	public Long getOaPayScaleId() {
		return oaPayScaleId;
	}

	/**
	 * Sets the oa pay scale id.
	 *
	 * @param oaPayScaleId the oaPayScaleId to set
	 */
	public void setOaPayScaleId(Long oaPayScaleId) {
		this.oaPayScaleId = oaPayScaleId;
	}

	/**
	 * Gets the oa pay band id.
	 *
	 * @return the oaPayBandId
	 */
	public Long getOaPayBandId() {
		return oaPayBandId;
	}

	/**
	 * Sets the oa pay band id.
	 *
	 * @param oaPayBandId the oaPayBandId to set
	 */
	public void setOaPayBandId(Long oaPayBandId) {
		this.oaPayBandId = oaPayBandId;
	}

	/**
	 * Gets the oa pay band value.
	 *
	 * @return the oaPayBandValue
	 */
	public Long getOaPayBandValue() {
		return oaPayBandValue;
	}

	/**
	 * Sets the oa pay band value.
	 *
	 * @param oaPayBandValue the oaPayBandValue to set
	 */
	public void setOaPayBandValue(Long oaPayBandValue) {
		this.oaPayBandValue = oaPayBandValue;
	}

	/**
	 * Gets the oa grade pay id.
	 *
	 * @return the oaGradePayId
	 */
	public Long getOaGradePayId() {
		return oaGradePayId;
	}

	/**
	 * Sets the oa grade pay id.
	 *
	 * @param oaGradePayId the oaGradePayId to set
	 */
	public void setOaGradePayId(Long oaGradePayId) {
		this.oaGradePayId = oaGradePayId;
	}

	/**
	 * Gets the oa pay level id.
	 *
	 * @return the oaPayLevelId
	 */
	public Long getOaPayLevelId() {
		return oaPayLevelId;
	}

	/**
	 * Sets the oa pay level id.
	 *
	 * @param oaPayLevelId the oaPayLevelId to set
	 */
	public void setOaPayLevelId(Long oaPayLevelId) {
		this.oaPayLevelId = oaPayLevelId;
	}

	/**
	 * Gets the oa cell id value.
	 *
	 * @return the oaCellIdValue
	 */
	public Long getOaCellIdValue() {
		return oaCellIdValue;
	}

	/**
	 * Sets the oa cell id value.
	 *
	 * @param oaCellIdValue the oaCellIdValue to set
	 */
	public void setOaCellIdValue(Long oaCellIdValue) {
		this.oaCellIdValue = oaCellIdValue;
	}

	/**
	 * Gets the oa pay cell id.
	 *
	 * @return the oaPayCellId
	 */
	public Long getOaPayCellId() {
		return oaPayCellId;
	}

	/**
	 * Sets the oa pay cell id.
	 *
	 * @param oaPayCellId the oaPayCellId to set
	 */
	public void setOaPayCellId(Long oaPayCellId) {
		this.oaPayCellId = oaPayCellId;
	}

	/**
	 * Gets the pay band name.
	 *
	 * @return the payBandName
	 */
	public String getPayBandName() {
		return payBandName;
	}

	/**
	 * Sets the pay band name.
	 *
	 * @param payBandName the payBandName to set
	 */
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	/**
	 * Gets the grade pay name.
	 *
	 * @return the gradePayName
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * Sets the grade pay name.
	 *
	 * @param gradePayName the gradePayName to set
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * Gets the pay level name.
	 *
	 * @return the payLevelName
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * Sets the pay level name.
	 *
	 * @param payLevelName the payLevelName to set
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * @return the scaleName
	 */
	public String getScaleName() {
		return scaleName;
	}

	/**
	 * @param scaleName the scaleName to set
	 */
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (basicPay ^ (basicPay >>> 32));
		result = prime * result + (int) (cellId ^ (cellId >>> 32));
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((dateOfJoining == null) ? 0 : dateOfJoining.hashCode());
		result = prime * result + ((dateOfNextIncrement == null) ? 0 : dateOfNextIncrement.hashCode());
		result = prime * result + ((departmentCategoryId == null) ? 0 : departmentCategoryId.hashCode());
		result = prime * result + (int) (designationId ^ (designationId >>> 32));
		result = prime * result + (int) (employeeClassId ^ (employeeClassId >>> 32));
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
		result = prime * result + (int) (employeeNo ^ (employeeNo >>> 32));
		result = prime * result + ((eventCode == null) ? 0 : eventCode.hashCode());
		result = prime * result + ((eventEffectiveDate == null) ? 0 : eventEffectiveDate.hashCode());
		result = prime * result + ((eventOrderDate == null) ? 0 : eventOrderDate.hashCode());
		result = prime * result + ((eventOrderNo == null) ? 0 : eventOrderNo.hashCode());
		result = prime * result + ((exists == null) ? 0 : exists.hashCode());
		result = prime * result + (int) (gradePayId ^ (gradePayId >>> 32));
		result = prime * result + ((gradePayName == null) ? 0 : gradePayName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (noonTypeId ^ (noonTypeId >>> 32));
		result = prime * result + ((oaBasicPayValue == null) ? 0 : oaBasicPayValue.hashCode());
		result = prime * result + ((oaCellIdValue == null) ? 0 : oaCellIdValue.hashCode());
		result = prime * result + ((oaGradePayId == null) ? 0 : oaGradePayId.hashCode());
		result = prime * result + ((oaPayBandId == null) ? 0 : oaPayBandId.hashCode());
		result = prime * result + ((oaPayBandValue == null) ? 0 : oaPayBandValue.hashCode());
		result = prime * result + ((oaPayCellId == null) ? 0 : oaPayCellId.hashCode());
		result = prime * result + ((oaPayLevelId == null) ? 0 : oaPayLevelId.hashCode());
		result = prime * result + ((oaPayScaleId == null) ? 0 : oaPayScaleId.hashCode());
		result = prime * result + (int) (officeId ^ (officeId >>> 32));
		result = prime * result + ((optionAvailableDate == null) ? 0 : optionAvailableDate.hashCode());
		result = prime * result + (int) (optionAvailableId ^ (optionAvailableId >>> 32));
		result = prime * result + (int) (payBandId ^ (payBandId >>> 32));
		result = prime * result + ((payBandName == null) ? 0 : payBandName.hashCode());
		result = prime * result + (int) (payBandValue ^ (payBandValue >>> 32));
		result = prime * result + (int) (payCommId ^ (payCommId >>> 32));
		result = prime * result + (int) (payLevelId ^ (payLevelId >>> 32));
		result = prime * result + ((payLevelName == null) ? 0 : payLevelName.hashCode());
		result = prime * result + (int) (payScale ^ (payScale >>> 32));
		result = prime * result + (int) (promotionTypeId ^ (promotionTypeId >>> 32));
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		result = prime * result + (same ? 1231 : 1237);
		result = prime * result + ((scaleName == null) ? 0 : scaleName.hashCode());
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
		result = prime * result + (submit ? 1231 : 1237);
		result = prime * result + ((trnNo == null) ? 0 : trnNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUPromotionDto other = (PVUPromotionDto) obj;
		if (basicPay != other.basicPay)
			return false;
		if (cellId != other.cellId)
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (dateOfJoining == null) {
			if (other.dateOfJoining != null)
				return false;
		} else if (!dateOfJoining.equals(other.dateOfJoining))
			return false;
		if (dateOfNextIncrement == null) {
			if (other.dateOfNextIncrement != null)
				return false;
		} else if (!dateOfNextIncrement.equals(other.dateOfNextIncrement))
			return false;
		if (departmentCategoryId == null) {
			if (other.departmentCategoryId != null)
				return false;
		} else if (!departmentCategoryId.equals(other.departmentCategoryId))
			return false;
		if (designationId != other.designationId)
			return false;
		if (employeeClassId != other.employeeClassId)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeNo != other.employeeNo)
			return false;
		if (eventCode == null) {
			if (other.eventCode != null)
				return false;
		} else if (!eventCode.equals(other.eventCode))
			return false;
		if (eventEffectiveDate == null) {
			if (other.eventEffectiveDate != null)
				return false;
		} else if (!eventEffectiveDate.equals(other.eventEffectiveDate))
			return false;
		if (eventOrderDate == null) {
			if (other.eventOrderDate != null)
				return false;
		} else if (!eventOrderDate.equals(other.eventOrderDate))
			return false;
		if (eventOrderNo == null) {
			if (other.eventOrderNo != null)
				return false;
		} else if (!eventOrderNo.equals(other.eventOrderNo))
			return false;
		if (exists == null) {
			if (other.exists != null)
				return false;
		} else if (!exists.equals(other.exists))
			return false;
		if (gradePayId != other.gradePayId)
			return false;
		if (gradePayName == null) {
			if (other.gradePayName != null)
				return false;
		} else if (!gradePayName.equals(other.gradePayName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (noonTypeId != other.noonTypeId)
			return false;
		if (oaBasicPayValue == null) {
			if (other.oaBasicPayValue != null)
				return false;
		} else if (!oaBasicPayValue.equals(other.oaBasicPayValue))
			return false;
		if (oaCellIdValue == null) {
			if (other.oaCellIdValue != null)
				return false;
		} else if (!oaCellIdValue.equals(other.oaCellIdValue))
			return false;
		if (oaGradePayId == null) {
			if (other.oaGradePayId != null)
				return false;
		} else if (!oaGradePayId.equals(other.oaGradePayId))
			return false;
		if (oaPayBandId == null) {
			if (other.oaPayBandId != null)
				return false;
		} else if (!oaPayBandId.equals(other.oaPayBandId))
			return false;
		if (oaPayBandValue == null) {
			if (other.oaPayBandValue != null)
				return false;
		} else if (!oaPayBandValue.equals(other.oaPayBandValue))
			return false;
		if (oaPayCellId == null) {
			if (other.oaPayCellId != null)
				return false;
		} else if (!oaPayCellId.equals(other.oaPayCellId))
			return false;
		if (oaPayLevelId == null) {
			if (other.oaPayLevelId != null)
				return false;
		} else if (!oaPayLevelId.equals(other.oaPayLevelId))
			return false;
		if (oaPayScaleId == null) {
			if (other.oaPayScaleId != null)
				return false;
		} else if (!oaPayScaleId.equals(other.oaPayScaleId))
			return false;
		if (officeId != other.officeId)
			return false;
		if (optionAvailableDate == null) {
			if (other.optionAvailableDate != null)
				return false;
		} else if (!optionAvailableDate.equals(other.optionAvailableDate))
			return false;
		if (optionAvailableId != other.optionAvailableId)
			return false;
		if (payBandId != other.payBandId)
			return false;
		if (payBandName == null) {
			if (other.payBandName != null)
				return false;
		} else if (!payBandName.equals(other.payBandName))
			return false;
		if (payBandValue != other.payBandValue)
			return false;
		if (payCommId != other.payCommId)
			return false;
		if (payLevelId != other.payLevelId)
			return false;
		if (payLevelName == null) {
			if (other.payLevelName != null)
				return false;
		} else if (!payLevelName.equals(other.payLevelName))
			return false;
		if (payScale != other.payScale)
			return false;
		if (promotionTypeId != other.promotionTypeId)
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (same != other.same)
			return false;
		if (scaleName == null) {
			if (other.scaleName != null)
				return false;
		} else if (!scaleName.equals(other.scaleName))
			return false;
		if (statusId != other.statusId)
			return false;
		if (submit != other.submit)
			return false;
		if (trnNo == null) {
			if (other.trnNo != null)
				return false;
		} else if (!trnNo.equals(other.trnNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PVUPromotionDto [className=" + className + ", id=" + id + ", submit=" + submit + ", same=" + same
				+ ", trnNo=" + trnNo + ", eventCode=" + eventCode + ", officeId=" + officeId + ", eventOrderNo="
				+ eventOrderNo + ", refDate=" + refDate + ", eventOrderDate=" + eventOrderDate + ", eventEffectiveDate="
				+ eventEffectiveDate + ", statusId=" + statusId + ", promotionTypeId=" + promotionTypeId
				+ ", employeeNo=" + employeeNo + ", payCommId=" + payCommId + ", employeeId=" + employeeId
				+ ", employeeClassId=" + employeeClassId + ", designationId=" + designationId + ", optionAvailableId="
				+ optionAvailableId + ", dateOfJoining=" + dateOfJoining + ", basicPay=" + basicPay + ", noonTypeId="
				+ noonTypeId + ", dateOfNextIncrement=" + dateOfNextIncrement + ", departmentCategoryId="
				+ departmentCategoryId + ", payScale=" + payScale + ", payBandValue=" + payBandValue + ", payBandId="
				+ payBandId + ", gradePayId=" + gradePayId + ", cellId=" + cellId + ", payLevelId=" + payLevelId
				+ ", optionAvailableDate=" + optionAvailableDate + ", remarks=" + remarks + ", exists=" + exists
				+ ", oaBasicPayValue=" + oaBasicPayValue + ", oaPayScaleId=" + oaPayScaleId + ", oaPayBandId="
				+ oaPayBandId + ", oaPayBandValue=" + oaPayBandValue + ", oaGradePayId=" + oaGradePayId
				+ ", oaPayLevelId=" + oaPayLevelId + ", oaCellIdValue=" + oaCellIdValue + ", oaPayCellId=" + oaPayCellId
				+ ", payBandName=" + payBandName + ", gradePayName=" + gradePayName + ", payLevelName=" + payLevelName
				+ ", scaleName=" + scaleName + "]";
	}

}
