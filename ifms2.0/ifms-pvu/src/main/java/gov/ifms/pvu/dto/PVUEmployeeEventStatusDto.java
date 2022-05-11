package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeEventStatusDto.
 * 
 * @version v 1.0
 * @created 2020/02/15 14:20:18
 *
 */
public class PVUEmployeeEventStatusDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event status id. */
	private long eventStatusId;

	/** The emp id. */
	private long empId;

	/** The emp creation. */
	private long empCreation;

	/** The eol. */
	private long eol;

	/** The suspension. */
	private long suspension;

	/** The increment. */
	private long increment;

	/** The high pay scale. */
	private long highPayScale;

	/** The promotion. */
	private long promotion;

	/** The reversion. */
	private long reversion;

	/** The rop. */
	private long rop;

	/** The assured career prog. */
	private long assuredCareerProg;

	/** The career advancement. */
	private long careerAdvancement;

	/** The tiku pay. */
	private long tikuPay;

	/** The shetty pay. */
	private long shettyPay;

	/** The senior scale. */
	private long seniorScale;

	/** The selection grade. */
	private long selectionGrade;

	/** The stepping up. */
	private long steppingUp;

	/** The change scale. */
	private long changeScale;

	/** The deemed date. */
	private long deemedDate;

	/** The promotion forgo. */
	private long promotionForgo;

	/** The change scale R 13. */
	private long changeScaleR13;

	/** The transfer. */
	private long transfer;

	/** The trans id. */
	private String transId;

	/** The trans name. */
	private String transName;

	/** The in progress. */
	private boolean inProgress;

	/** The employee code. */
	private Long employeeCode;

	/** The employee code. */
	private Long seniorScalePvu;

	private Long eventCount;

	/**
	 * PVUEmployeeEventStatusDto Constructor.
	 */
	public PVUEmployeeEventStatusDto() {
		super();
	}

	/**
	 * Getter for property 'seniorScalePvu'.
	 *
	 * @return Value for property 'seniorScalePvu'.
	 */
	public Long getSeniorScalePvu() {
		return seniorScalePvu;
	}

	/**
	 * Setter for property 'seniorScalePvu'.
	 *
	 * @param seniorScalePvu Value to set for property 'seniorScalePvu'.
	 */
	public void setSeniorScalePvu(Long seniorScalePvu) {
		this.seniorScalePvu = seniorScalePvu;
	}

	/**
	 * Instantiates a new PVU employee event status dto.
	 *
	 * @param eventStatusId the event status id
	 * @param empId         the emp id
	 * @param employeeCode  the employee code
	 * @param transId       the trans id
	 * @param inProgress    the in progress
	 */
	public PVUEmployeeEventStatusDto(@NotNull long eventStatusId, long empId, Long employeeCode, String transId,
			boolean inProgress) {
		super();
		this.eventStatusId = eventStatusId;
		this.empId = empId;
		this.transId = transId;
		this.inProgress = inProgress;
		this.employeeCode = employeeCode;
	}

	public PVUEmployeeEventStatusDto(@NotNull long eventStatusId, long empId, Long employeeCode, String transId,
			Long eventCount) {
		super();
		this.eventStatusId = eventStatusId;
		this.empId = empId;
		this.transId = transId;
		this.eventCount = eventCount;
		this.inProgress = eventCount >= 1;
		this.employeeCode = employeeCode;
	}

	/**
	 * Gets the event status id.
	 *
	 * @return the eventStatusId
	 */
	public long getEventStatusId() {
		return eventStatusId;
	}

	/**
	 * Sets the event status id.
	 *
	 * @param eventStatusId the eventStatusId to set
	 */
	public void setEventStatusId(long eventStatusId) {
		this.eventStatusId = eventStatusId;
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
	 * Gets the emp creation.
	 *
	 * @return the empCreation
	 */
	public long getEmpCreation() {
		return empCreation;
	}

	/**
	 * Sets the emp creation.
	 *
	 * @param empCreation the empCreation to set
	 */
	public void setEmpCreation(long empCreation) {
		this.empCreation = empCreation;
	}

	/**
	 * Gets the eol.
	 *
	 * @return the eol
	 */
	public long getEol() {
		return eol;
	}

	/**
	 * Sets the eol.
	 *
	 * @param eol the eol to set
	 */
	public void setEol(long eol) {
		this.eol = eol;
	}

	/**
	 * Gets the suspension.
	 *
	 * @return the suspension
	 */
	public long getSuspension() {
		return suspension;
	}

	/**
	 * Sets the suspension.
	 *
	 * @param suspension the suspension to set
	 */
	public void setSuspension(long suspension) {
		this.suspension = suspension;
	}

	/**
	 * Gets the increment.
	 *
	 * @return the increment
	 */
	public long getIncrement() {
		return increment;
	}

	/**
	 * Sets the increment.
	 *
	 * @param increment the increment to set
	 */
	public void setIncrement(long increment) {
		this.increment = increment;
	}

	/**
	 * Gets the high pay scale.
	 *
	 * @return the highPayScale
	 */
	public long getHighPayScale() {
		return highPayScale;
	}

	/**
	 * Sets the high pay scale.
	 *
	 * @param highPayScale the highPayScale to set
	 */
	public void setHighPayScale(long highPayScale) {
		this.highPayScale = highPayScale;
	}

	/**
	 * Gets the promotion.
	 *
	 * @return the promotion
	 */
	public long getPromotion() {
		return promotion;
	}

	/**
	 * Sets the promotion.
	 *
	 * @param promotion the promotion to set
	 */
	public void setPromotion(long promotion) {
		this.promotion = promotion;
	}

	/**
	 * Gets the reversion.
	 *
	 * @return the reversion
	 */
	public long getReversion() {
		return reversion;
	}

	/**
	 * Sets the reversion.
	 *
	 * @param reversion the reversion to set
	 */
	public void setReversion(long reversion) {
		this.reversion = reversion;
	}

	/**
	 * Gets the rop.
	 *
	 * @return the rop
	 */
	public long getRop() {
		return rop;
	}

	/**
	 * Sets the rop.
	 *
	 * @param rop the rop to set
	 */
	public void setRop(long rop) {
		this.rop = rop;
	}

	/**
	 * Gets the assured career prog.
	 *
	 * @return the assuredCareerProg
	 */
	public long getAssuredCareerProg() {
		return assuredCareerProg;
	}

	/**
	 * Sets the assured career prog.
	 *
	 * @param assuredCareerProg the assuredCareerProg to set
	 */
	public void setAssuredCareerProg(long assuredCareerProg) {
		this.assuredCareerProg = assuredCareerProg;
	}

	/**
	 * Gets the career advancement.
	 *
	 * @return the careerAdvancement
	 */
	public long getCareerAdvancement() {
		return careerAdvancement;
	}

	/**
	 * Sets the career advancement.
	 *
	 * @param careerAdvancement the careerAdvancement to set
	 */
	public void setCareerAdvancement(long careerAdvancement) {
		this.careerAdvancement = careerAdvancement;
	}

	/**
	 * Gets the tiku pay.
	 *
	 * @return the tikuPay
	 */
	public long getTikuPay() {
		return tikuPay;
	}

	/**
	 * Sets the tiku pay.
	 *
	 * @param tikuPay the tikuPay to set
	 */
	public void setTikuPay(long tikuPay) {
		this.tikuPay = tikuPay;
	}

	/**
	 * Gets the shetty pay.
	 *
	 * @return the shettyPay
	 */
	public long getShettyPay() {
		return shettyPay;
	}

	/**
	 * Sets the shetty pay.
	 *
	 * @param shettyPay the shettyPay to set
	 */
	public void setShettyPay(long shettyPay) {
		this.shettyPay = shettyPay;
	}

	/**
	 * Gets the senior scale.
	 *
	 * @return the seniorScale
	 */
	public long getSeniorScale() {
		return seniorScale;
	}

	/**
	 * Sets the senior scale.
	 *
	 * @param seniorScale the seniorScale to set
	 */
	public void setSeniorScale(long seniorScale) {
		this.seniorScale = seniorScale;
	}

	/**
	 * Gets the selection grade.
	 *
	 * @return the selectionGrade
	 */
	public long getSelectionGrade() {
		return selectionGrade;
	}

	/**
	 * Sets the selection grade.
	 *
	 * @param selectionGrade the selectionGrade to set
	 */
	public void setSelectionGrade(long selectionGrade) {
		this.selectionGrade = selectionGrade;
	}

	/**
	 * Gets the stepping up.
	 *
	 * @return the steppingUp
	 */
	public long getSteppingUp() {
		return steppingUp;
	}

	/**
	 * Sets the stepping up.
	 *
	 * @param steppingUp the steppingUp to set
	 */
	public void setSteppingUp(long steppingUp) {
		this.steppingUp = steppingUp;
	}

	/**
	 * Gets the change scale.
	 *
	 * @return the changeScale
	 */
	public long getChangeScale() {
		return changeScale;
	}

	/**
	 * Sets the change scale.
	 *
	 * @param changeScale the changeScale to set
	 */
	public void setChangeScale(long changeScale) {
		this.changeScale = changeScale;
	}

	/**
	 * Gets the deemed date.
	 *
	 * @return the deemedDate
	 */
	public long getDeemedDate() {
		return deemedDate;
	}

	/**
	 * Sets the deemed date.
	 *
	 * @param deemedDate the deemedDate to set
	 */
	public void setDeemedDate(long deemedDate) {
		this.deemedDate = deemedDate;
	}

	/**
	 * Gets the promotion forgo.
	 *
	 * @return the promotionForgo
	 */
	public long getPromotionForgo() {
		return promotionForgo;
	}

	/**
	 * Sets the promotion forgo.
	 *
	 * @param promotionForgo the promotionForgo to set
	 */
	public void setPromotionForgo(long promotionForgo) {
		this.promotionForgo = promotionForgo;
	}

	/**
	 * Gets the change scale R 13.
	 *
	 * @return the changeScaleR13
	 */
	public long getChangeScaleR13() {
		return changeScaleR13;
	}

	/**
	 * Sets the change scale R 13.
	 *
	 * @param changeScaleR13 the changeScaleR13 to set
	 */
	public void setChangeScaleR13(long changeScaleR13) {
		this.changeScaleR13 = changeScaleR13;
	}

	/**
	 * Gets the transfer.
	 *
	 * @return the transfer
	 */
	public long getTransfer() {
		return transfer;
	}

	/**
	 * Sets the transfer.
	 *
	 * @param transfer the transfer to set
	 */
	public void setTransfer(long transfer) {
		this.transfer = transfer;
	}

	/**
	 * Gets the trans name.
	 *
	 * @return the transName
	 */
	public String getTransName() {
		return transName;
	}

	/**
	 * Sets the trans name.
	 *
	 * @param transName the transName to set
	 */
	public void setTransName(String transName) {
		this.transName = transName;
	}

	/**
	 * Checks if is in progress.
	 *
	 * @return the inProgress
	 */
	public boolean isInProgress() {
		return inProgress;
	}

	/**
	 * Sets the in progress.
	 *
	 * @param inProgress the inProgress to set
	 */
	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	/**
	 * Gets the trans id.
	 *
	 * @return the transId
	 */
	public String getTransId() {
		return transId;
	}

	/**
	 * Sets the trans id.
	 *
	 * @param transId the transId to set
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}

	/**
	 * Gets the employee code.
	 *
	 * @return the employeeCode
	 */
	public Long getEmployeeCode() {
		return employeeCode;
	}

	/**
	 * @return the eventCount
	 */
	public Long getEventCount() {
		return eventCount;
	}

	/**
	 * @param eventCount the eventCount to set
	 */
	public void setEventCount(Long eventCount) {
		this.eventCount = eventCount;
	}

	/**
	 * Sets the employee code.
	 *
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(Long employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(assuredCareerProg, careerAdvancement, changeScale, changeScaleR13, deemedDate, empCreation,
				empId, employeeCode, eol, eventStatusId, highPayScale, inProgress, increment, promotion, promotionForgo,
				reversion, rop, selectionGrade, seniorScale, shettyPay, steppingUp, suspension, tikuPay, transId,
				transName,seniorScalePvu, transfer);
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
		if (!(obj instanceof PVUEmployeeEventStatusDto)) {
			return false;
		}
		PVUEmployeeEventStatusDto other = (PVUEmployeeEventStatusDto) obj;
		return assuredCareerProg == other.assuredCareerProg && careerAdvancement == other.careerAdvancement
				&& changeScale == other.changeScale && changeScaleR13 == other.changeScaleR13
				&& deemedDate == other.deemedDate && empCreation == other.empCreation && empId == other.empId
				&& Objects.equals(employeeCode, other.employeeCode) && eol == other.eol
				&& eventStatusId == other.eventStatusId && highPayScale == other.highPayScale
				&& inProgress == other.inProgress && increment == other.increment && promotion == other.promotion
				&& promotionForgo == other.promotionForgo && reversion == other.reversion && rop == other.rop
				&& selectionGrade == other.selectionGrade && seniorScale == other.seniorScale
				&& shettyPay == other.shettyPay && steppingUp == other.steppingUp && suspension == other.suspension
				&& tikuPay == other.tikuPay && Objects.equals(transId, other.transId) && Objects.equals(seniorScalePvu, other.seniorScalePvu)
				&& Objects.equals(transName, other.transName) && transfer == other.transfer;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeeEventStatusDto [eventStatusId=" + eventStatusId + ", empId=" + empId + ", empCreation="
				+ empCreation + ", eol=" + eol + ", suspension=" + suspension + ", increment=" + increment
				+ ", highPayScale=" + highPayScale + ", promotion=" + promotion + ", reversion=" + reversion + ", rop="
				+ rop + ", assuredCareerProg=" + assuredCareerProg + ", careerAdvancement=" + careerAdvancement
				+ ", tikuPay=" + tikuPay + ", shettyPay=" + shettyPay + ", seniorScale=" + seniorScale
				+ ", selectionGrade=" + selectionGrade + ", steppingUp=" + steppingUp + ", changeScale=" + changeScale
				+ ", deemedDate=" + deemedDate + ", promotionForgo=" + promotionForgo + ", changeScaleR13="
				+ changeScaleR13 + ", transfer=" + transfer + ", transId=" + transId + ", transName=" + transName
				+ ", inProgress=" + inProgress + ", seniorScalePvu=" + seniorScalePvu + ", employeeCode=" + employeeCode + "]";
	}

}
