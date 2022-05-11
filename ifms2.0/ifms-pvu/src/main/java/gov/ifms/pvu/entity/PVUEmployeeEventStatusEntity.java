package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUEmployeeEventStatusEntity.
 * 
 * @version v 1.0
 * @created 2020/02/15 14:20:18
 *
 */
@Entity
@Table(name = "T_EMP_EVNT_STATUS", schema = Constant.PVU_SCHEMA)
public class PVUEmployeeEventStatusEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event status id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_EMP_EVNT_STAT_ID")
	private long eventStatusId;

	/** The emp id. */
	@ManyToOne
	@JoinColumn(name = "EMP_ID", nullable = false, referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The emp creation. */
	@Column(name = "EMP_CREATION")
	private long empCreation;

	/** The eol. */
	@Column(name = "EOL")
	private long eol;

	/** The suspension. */
	@Column(name = "SUSPENSION")
	private long suspension;

	/** The increment. */
	@Column(name = "INCREMENT")
	private long increment;

	/** The high pay scale. */
	@Column(name = "HIGH_PAY_SCALE")
	private long highPayScale;

	/** The promotion. */
	@Column(name = "PROMOTION")
	private long promotion;

	/** The reversion. */
	@Column(name = "REVERSION")
	private long reversion;

	/** The rop. */
	@Column(name = "ROP")
	private long rop;

	/** The assured career prog. */
	@Column(name = "ASURD_CARR_PROG")
	private long assuredCareerProg;

	/** The career advancement. */
	@Column(name = "CARR_ADVAN_SCHM")
	private long careerAdvancement;

	/** The tiku pay. */
	@Column(name = "TIKU_PAY")
	private long tikuPay;

	/** The shetty pay. */
	@Column(name = "SHETTY_PAY")
	private long shettyPay;

	/** The senior scale. */
	@Column(name = "SENIOR_SCALE")
	private long seniorScale;

	/** The senior scale. */
	@Column(name = "SENIOR_SCALE_PVU")
	private long seniorScalePvu;

	/** The selection grade. */
	@Column(name = "SELECTION_GRADE")
	private long selectionGrade;

	/** The stepping up. */
	@Column(name = "STEPPING_UP")
	private long steppingUp;

	/** The change scale. */
	@Column(name = "CHNG_SCALE_PVU")
	private long changeScale;

	/** The deemed date. */
	@Column(name = "DEEMED_DATE")
	private long deemedDate;

	/** The promotion forgo. */
	@Column(name = "PROMO_FOR_GO")
	private long promotionForgo;

	/** The change scale R 13. */
	@Column(name = "CHNG_SCALE_R13")
	private long changeScaleR13;

	/** The transfer. */
	@Column(name = "TRANSFER")
	private long transfer;

	/** The trans id. */
	@Column(name = "TRN_ID")
	private String transId;

	/**
	 * PVUEmployeeEventStatusEntity Constructor.
	 */
	public PVUEmployeeEventStatusEntity() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the event status id
	 */

	/**
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
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(PVUEmployeEntity empId) {
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
	 * Gets the trans id.
	 *
	 * @return the trans id
	 */
	public String getTransId() {
		return transId;
	}

	/**
	 * Sets the trans id.
	 *
	 * @param transId the new trans id
	 */
	public void setTransId(String transId) {
		this.transId = transId;
	}

	/**
	 * Getter for property 'seniorScalePvu'.
	 *
	 * @return Value for property 'seniorScalePvu'.
	 */
	public long getSeniorScalePvu() {
		return seniorScalePvu;
	}

	/**
	 * Setter for property 'seniorScalePvu'.
	 *
	 * @param seniorScalePvu Value to set for property 'seniorScalePvu'.
	 */
	public void setSeniorScalePvu(long seniorScalePvu) {
		this.seniorScalePvu = seniorScalePvu;
	}

	public boolean isEventInProgress() {
		boolean isEventInProgress;
		long eventCount = (this.eol + this.suspension + this.increment + this.highPayScale +
				this.promotion + this.reversion + this.rop + this.assuredCareerProg + 
				this.careerAdvancement + this.tikuPay + this.shettyPay + this.seniorScale + this.selectionGrade + 
				this.steppingUp + this.changeScale + this.deemedDate + this.promotionForgo + this.changeScaleR13 + this.seniorScalePvu +
				this.transfer);
		isEventInProgress = eventCount == 1;
		return isEventInProgress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assuredCareerProg, careerAdvancement, changeScale, changeScaleR13, deemedDate, empCreation,
				empId, eol, eventStatusId, highPayScale, increment, promotion, promotionForgo, reversion, rop,
				selectionGrade, seniorScale, shettyPay, steppingUp, suspension, tikuPay, transId,seniorScalePvu, transfer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeeEventStatusEntity)) {
			return false;
		}
		PVUEmployeeEventStatusEntity other = (PVUEmployeeEventStatusEntity) obj;
		return assuredCareerProg == other.assuredCareerProg && careerAdvancement == other.careerAdvancement
				&& changeScale == other.changeScale && changeScaleR13 == other.changeScaleR13
				&& deemedDate == other.deemedDate && empCreation == other.empCreation
				&& Objects.equals(empId, other.empId) && eol == other.eol && eventStatusId == other.eventStatusId
				&& highPayScale == other.highPayScale && increment == other.increment && promotion == other.promotion
				&& promotionForgo == other.promotionForgo && reversion == other.reversion && rop == other.rop
				&& selectionGrade == other.selectionGrade && seniorScale == other.seniorScale
				&& shettyPay == other.shettyPay && steppingUp == other.steppingUp && suspension == other.suspension && seniorScalePvu == other.seniorScalePvu
				&& tikuPay == other.tikuPay && Objects.equals(transId, other.transId) && transfer == other.transfer;
	}

	@Override
	public String toString() {
		return "PVUEmployeeEventStatusEntity [eventStatusId=" + eventStatusId + ", empId=" + empId + ", empCreation="
				+ empCreation + ", eol=" + eol + ", suspension=" + suspension + ", increment=" + increment
				+ ", highPayScale=" + highPayScale + ", promotion=" + promotion + ", reversion=" + reversion + ", rop="
				+ rop + ", assuredCareerProg=" + assuredCareerProg + ", careerAdvancement=" + careerAdvancement
				+ ", tikuPay=" + tikuPay + ", shettyPay=" + shettyPay + ", seniorScale=" + seniorScale
				+ ", selectionGrade=" + selectionGrade + ", steppingUp=" + steppingUp + ", changeScale=" + changeScale
				+ ", deemedDate=" + deemedDate + ", promotionForgo=" + promotionForgo + ", changeScaleR13="
				+ changeScaleR13 + ", transfer=" + transfer + ", seniorScalePvu=" + seniorScalePvu + ", transId=" + transId + "]";
	}
}
