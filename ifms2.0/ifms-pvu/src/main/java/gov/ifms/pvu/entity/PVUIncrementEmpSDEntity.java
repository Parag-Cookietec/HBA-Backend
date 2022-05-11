package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;

/**
 * The Class PVUIncrementEmpEntity.
 * 
 * @version v 1.0
 * @created 2020/01/12 19:19:14
 *
 */
@Entity
@Table(name = "T_PVU_IN_EMP_SD", schema = Constant.PVU_SCHEMA)
@NamedEntityGraph(name = "PVUIncrementSTPSDEntity.pvuIncrementSTPSDPEntity",
		attributeNodes = @NamedAttributeNode("pvuIncrementSTPSDPEntity")
)
public class PVUIncrementEmpSDEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The in emp id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_EMP_SD_ID")
	private long idEmpSDId;

	/** The in event id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_PVU_IN_EVNT_ID", referencedColumnName = "T_PVU_IN_EVNT_ID")
	private PVUIncrementEventEntity inEventId;

	/** The emp id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	/** The cur pay level. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity curPayLevel;

	/** The cur cell id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity curCellId;

	/** The cur grade. */
	@Column(name = "C_GRADE")
	private Long curGrade;

	/** The cur scale. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity curScale;

	/** The cur pay band. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity curPayBand;

	/** The cur pay band value. */
	@Column(name = "C_PAY_BAND_VALUE")
	private long curPayBandValue;

	/** The cur grade pay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "C_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity curGradePay;

	/** The cur basic pay. */
	@Column(name = "C_BASIC_PAY")
	private long curBasicPay;

	/** The rev pay level. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_PAY_LEVEL", referencedColumnName = "PAY_LEVEL_ID")
	private PVUMsPayLevelEntity revPayLevel;

	/** The rev cell id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_CELL_ID", referencedColumnName = "PAY_CELL_ID")
	private PVUMsPayCellEntity revCellId;

	/** The rev grade. */
	@Column(name = "R_GRADE")
	private Long revGrade;

	/** The rev scale. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_SCALE", referencedColumnName = "PAY_SCALE_ID")
	private PVUMsPayScaleEntity revScale;

	/** The rev pay band. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_PAY_BAND", referencedColumnName = "PAY_BAND_ID")
	private PVUMsPayBandEntity revPayBand;

	/** The rev pay band value. */
	@Column(name = "R_PAY_BAND_VALUE")
	private Long revPayBandValue;

	/** The rev grade pay. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "R_GRADE_PAY", referencedColumnName = "GRADE_PAY_ID")
	private PVUMsGradePayEntity revGradePay;

	/** The rev basic pay. */
	@Column(name = "R_BASIC_PAY")
	private Long revBasicPay;

	/** The rev eff date. */
	@Column(name = "R_EFF_DATE")
	private Date revEffDate;

	/** The rev date nex inc. */
	@Column(name = "R_DATE_OF_INC")
	private Date revDateNexInc;

	/** The diff amt. */
	@Column(name = "DIFF_AMT")
	private Long diffAmt;

	/** The REASON FOR EXCLUDE. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REASON_FOR_EXCLUDE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reasonForExclude;

	/** The stop increment type. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOP_INCREMENT_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity stopIncrementType;

	/** The from date. */
	@Column(name = "FROM_DATE")
	private Date stopIncFromDate;

	/** The to date. */
	@Column(name = "TO_DATE")
	private Date stopIncToDate;

	/** The date nxt inc. */
	@Column(name = "DATE_NXT_INC")
	private Date dateNxtInc;

	/** The sus start date. */
	@Column(name = "SUS_START_DATE")
	private Date susStartDate;

	/** The sus end date. */
	@Column(name = "SUS_END_DATE")
	private Date susEndDate;

	/** The eol start date. */
	@Column(name = "EOL_START_DATE")
	private Date eolStartDate;

	/** The eol end date. */
	@Column(name = "EOL_END_DATE")
	private Date eolEndDate;

	/** The cur emp class. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity classId;

	/** The cur emp dsgn. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private EDPMsDesignationEntity designationId;

	/** The emp type. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMP_TYPE", nullable = false, referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity empType;

	/** The remarks. */
	@Column(name = "REMARKS")
	private String remarks;

	/** The status id. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	/** The status id. */
	@Column(name = "SYSTEM_EXCL")
	private int systemExcluded;

	/** The remarks. */
	@Column(name = "INCREMENT_TYPE")
	private String incrementType;

	/** The gpf no. */
	@Column(name = "GPF")
	private String gpf;

	@Column(name = "IS_ELIGIBLE")
	private long isEligible;
	@Column(name = "IS_INCLUDED")
	private long isIncluded;
	@Column(name = "DEPT_CAT")
	private long deptCategory;
	@Column(name = "LAST_PAY_SCALE")
	private long lastPayScale;
	@Column(name = "WHL_IS_ELIGIBLE")
	private long whlIsEligible;
	@Column(name = "LAST_PAY_LEVEL")
	private long lastPayLevel;
	@Column(name = "LAST_GRD_PAY")
	private long lastGradePay;
	@Column(name = "DATE_JOINING")
	private Date dateOfJoining;

	/** The gpf no. */
	@Column(name = "USER_REMARKS")
	private String userRemarks;
	

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, mappedBy = "pvuIncrementEmpSDEntity")
	private PVUIncrementSTPSDEntity pvuIncrementSTPSDPEntity;

	/*public void addIncrementSTPSDPEntity(PVUIncrementSTPSDEntity entity) {
		if (pvuIncrementSTPSDPEntity == null) {
			pvuIncrementSTPSDPEntity = new PVUIncrementSTPSDEntity();
		}
		entity.setPvuIncrementEmpSDEntity(this);
		this.setPvuIncrementSTPSDPEntity(entity);



	}*/

	/**
	 * PVUIncrementEmpEntity Constructor.
	 */
	public PVUIncrementEmpSDEntity() {
		super();
	}

	public PVUIncrementEmpSDEntity(long idEmpSDId) {
		this.idEmpSDId = idEmpSDId;
	}


	public long getIdEmpSDId() {
		return idEmpSDId;
	}

	public void setIdEmpSDId(long idEmpSDId) {
		this.idEmpSDId = idEmpSDId;
	}

	public PVUIncrementEventEntity getInEventId() {
		return inEventId;
	}

	public void setInEventId(PVUIncrementEventEntity inEventId) {
		this.inEventId = inEventId;
	}

	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	public PVUMsPayLevelEntity getCurPayLevel() {
		return curPayLevel;
	}

	public void setCurPayLevel(PVUMsPayLevelEntity curPayLevel) {
		this.curPayLevel = curPayLevel;
	}

	public PVUMsPayCellEntity getCurCellId() {
		return curCellId;
	}

	public void setCurCellId(PVUMsPayCellEntity curCellId) {
		this.curCellId = curCellId;
	}

	public Long getCurGrade() {
		return curGrade;
	}

	public void setCurGrade(Long curGrade) {
		this.curGrade = curGrade;
	}

	public PVUMsPayScaleEntity getCurScale() {
		return curScale;
	}

	public void setCurScale(PVUMsPayScaleEntity curScale) {
		this.curScale = curScale;
	}

	public PVUMsPayBandEntity getCurPayBand() {
		return curPayBand;
	}

	public void setCurPayBand(PVUMsPayBandEntity curPayBand) {
		this.curPayBand = curPayBand;
	}

	public long getCurPayBandValue() {
		return curPayBandValue;
	}

	public void setCurPayBandValue(long curPayBandValue) {
		this.curPayBandValue = curPayBandValue;
	}

	public PVUMsGradePayEntity getCurGradePay() {
		return curGradePay;
	}

	public void setCurGradePay(PVUMsGradePayEntity curGradePay) {
		this.curGradePay = curGradePay;
	}

	public long getCurBasicPay() {
		return curBasicPay;
	}

	public void setCurBasicPay(long curBasicPay) {
		this.curBasicPay = curBasicPay;
	}

	public PVUMsPayLevelEntity getRevPayLevel() {
		return revPayLevel;
	}

	public void setRevPayLevel(PVUMsPayLevelEntity revPayLevel) {
		this.revPayLevel = revPayLevel;
	}

	public PVUMsPayCellEntity getRevCellId() {
		return revCellId;
	}

	public void setRevCellId(PVUMsPayCellEntity revCellId) {
		this.revCellId = revCellId;
	}

	public Long getRevGrade() {
		return revGrade;
	}

	public void setRevGrade(Long revGrade) {
		this.revGrade = revGrade;
	}

	public PVUMsPayScaleEntity getRevScale() {
		return revScale;
	}

	public void setRevScale(PVUMsPayScaleEntity revScale) {
		this.revScale = revScale;
	}

	public PVUMsPayBandEntity getRevPayBand() {
		return revPayBand;
	}

	public void setRevPayBand(PVUMsPayBandEntity revPayBand) {
		this.revPayBand = revPayBand;
	}

	public Long getRevPayBandValue() {
		return revPayBandValue;
	}

	public void setRevPayBandValue(Long revPayBandValue) {
		this.revPayBandValue = revPayBandValue;
	}

	public PVUMsGradePayEntity getRevGradePay() {
		return revGradePay;
	}

	public void setRevGradePay(PVUMsGradePayEntity revGradePay) {
		this.revGradePay = revGradePay;
	}

	public Long getRevBasicPay() {
		return revBasicPay;
	}

	public void setRevBasicPay(Long revBasicPay) {
		this.revBasicPay = revBasicPay;
	}

	public Date getRevEffDate() {
		return revEffDate;
	}

	public void setRevEffDate(Date revEffDate) {
		this.revEffDate = revEffDate;
	}

	public Date getRevDateNexInc() {
		return revDateNexInc;
	}

	public void setRevDateNexInc(Date revDateNexInc) {
		this.revDateNexInc = revDateNexInc;
	}

	public Long getDiffAmt() {
		return diffAmt;
	}

	public void setDiffAmt(Long diffAmt) {
		this.diffAmt = diffAmt;
	}

	public EDPLuLookUpInfoEntity getReasonForExclude() {
		return reasonForExclude;
	}

	public void setReasonForExclude(EDPLuLookUpInfoEntity reasonForExclude) {
		this.reasonForExclude = reasonForExclude;
	}

	public EDPLuLookUpInfoEntity getStopIncrementType() {
		return stopIncrementType;
	}

	public void setStopIncrementType(EDPLuLookUpInfoEntity stopIncrementType) {
		this.stopIncrementType = stopIncrementType;
	}

	public Date getStopIncFromDate() {
		return stopIncFromDate;
	}

	public void setStopIncFromDate(Date stopIncFromDate) {
		this.stopIncFromDate = stopIncFromDate;
	}

	public Date getStopIncToDate() {
		return stopIncToDate;
	}

	public void setStopIncToDate(Date stopIncToDate) {
		this.stopIncToDate = stopIncToDate;
	}

	public Date getDateNxtInc() {
		return dateNxtInc;
	}

	public void setDateNxtInc(Date dateNxtInc) {
		this.dateNxtInc = dateNxtInc;
	}

	public Date getSusStartDate() {
		return susStartDate;
	}

	public void setSusStartDate(Date susStartDate) {
		this.susStartDate = susStartDate;
	}

	public Date getSusEndDate() {
		return susEndDate;
	}

	public void setSusEndDate(Date susEndDate) {
		this.susEndDate = susEndDate;
	}

	public Date getEolStartDate() {
		return eolStartDate;
	}

	public void setEolStartDate(Date eolStartDate) {
		this.eolStartDate = eolStartDate;
	}

	public Date getEolEndDate() {
		return eolEndDate;
	}

	public void setEolEndDate(Date eolEndDate) {
		this.eolEndDate = eolEndDate;
	}

	public EDPLuLookUpInfoEntity getClassId() {
		return classId;
	}

	public void setClassId(EDPLuLookUpInfoEntity classId) {
		this.classId = classId;
	}

	public EDPMsDesignationEntity getDesignationId() {
		return designationId;
	}

	public void setDesignationId(EDPMsDesignationEntity designationId) {
		this.designationId = designationId;
	}

	public EDPLuLookUpInfoEntity getEmpType() {
		return empType;
	}

	public void setEmpType(EDPLuLookUpInfoEntity empType) {
		this.empType = empType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	public int getSystemExcluded() {
		return systemExcluded;
	}

	public void setSystemExcluded(int systemExcluded) {
		this.systemExcluded = systemExcluded;
	}

	public String getIncrementType() {
		return incrementType;
	}

	public void setIncrementType(String incrementType) {
		this.incrementType = incrementType;
	}

	public String getGpf() {
		return gpf;
	}

	public void setGpf(String gpf) {
		this.gpf = gpf;
	}

	public PVUIncrementSTPSDEntity getPvuIncrementSTPSDPEntity() {
		return pvuIncrementSTPSDPEntity;
	}

	public void setPvuIncrementSTPSDPEntity(PVUIncrementSTPSDEntity pvuIncrementSTPSDPEntity) {
		if (pvuIncrementSTPSDPEntity == null) {
			pvuIncrementSTPSDPEntity =new PVUIncrementSTPSDEntity();
		}
		pvuIncrementSTPSDPEntity.setPvuIncrementEmpSDEntity(this);
		this.pvuIncrementSTPSDPEntity = pvuIncrementSTPSDPEntity;
	}

	public long getIsEligible() {
		return isEligible;
	}

	public void setIsEligible(long isEligible) {
		this.isEligible = isEligible;
	}

	public long getIsIncluded() {
		return isIncluded;
	}

	public void setIsIncluded(long isIncluded) {
		this.isIncluded = isIncluded;
	}

	public long getDeptCategory() {
		return deptCategory;
	}

	public void setDeptCategory(long deptCategory) {
		this.deptCategory = deptCategory;
	}

	public long getLastPayScale() {
		return lastPayScale;
	}

	public void setLastPayScale(long lastPayScale) {
		this.lastPayScale = lastPayScale;
	}

	public long getWhlIsEligible() {
		return whlIsEligible;
	}

	public void setWhlIsEligible(long whlIsEligible) {
		this.whlIsEligible = whlIsEligible;
	}

	public long getLastPayLevel() {
		return lastPayLevel;
	}

	public void setLastPayLevel(long lastPayLevel) {
		this.lastPayLevel = lastPayLevel;
	}

	public long getLastGradePay() {
		return lastGradePay;
	}

	public void setLastGradePay(long lastGradePay) {
		this.lastGradePay = lastGradePay;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	@Override
	public String toString() {
		return "PVUIncrementEmpSDEntity{" +
				"idEmpSDId=" + idEmpSDId +
				", inEventId=" + inEventId +
				", empId=" + empId +
				", curPayLevel=" + curPayLevel +
				", curCellId=" + curCellId +
				", curGrade=" + curGrade +
				", curScale=" + curScale +
				", curPayBand=" + curPayBand +
				", curPayBandValue=" + curPayBandValue +
				", curGradePay=" + curGradePay +
				", curBasicPay=" + curBasicPay +
				", revPayLevel=" + revPayLevel +
				", revCellId=" + revCellId +
				", revGrade=" + revGrade +
				", revScale=" + revScale +
				", revPayBand=" + revPayBand +
				", revPayBandValue=" + revPayBandValue +
				", revGradePay=" + revGradePay +
				", revBasicPay=" + revBasicPay +
				", revEffDate=" + revEffDate +
				", revDateNexInc=" + revDateNexInc +
				", diffAmt=" + diffAmt +
				", reasonForExclude=" + reasonForExclude +
				", stopIncrementType=" + stopIncrementType +
				", stopIncFromDate=" + stopIncFromDate +
				", stopIncToDate=" + stopIncToDate +
				", dateNxtInc=" + dateNxtInc +
				", susStartDate=" + susStartDate +
				", susEndDate=" + susEndDate +
				", eolStartDate=" + eolStartDate +
				", eolEndDate=" + eolEndDate +
				", classId=" + classId +
				", designationId=" + designationId +
				", empType=" + empType +
				", remarks='" + remarks + '\'' +
				", statusId=" + statusId +
				", systemExcluded=" + systemExcluded +
				", incrementType='" + incrementType + '\'' +
				", gpf='" + gpf + '\'' +
				", isEligible=" + isEligible +
				", isIncluded=" + isIncluded +
				", deptCategory=" + deptCategory +
				", lastPayScale=" + lastPayScale +
				", whlIsEligible=" + whlIsEligible +
				", lastPayLevel=" + lastPayLevel +
				", lastGradePay=" + lastGradePay +
				", dateOfJoining=" + dateOfJoining +
				", pvuIncrementSTPSDPEntity=" + pvuIncrementSTPSDPEntity +
				'}';
	}
}
