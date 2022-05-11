package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

@Entity
@Table(name = "T_PVU_IN_STP_SD", schema = Constant.PVU_SCHEMA)
public class PVUIncrementSTPSDEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_STP_SD_ID")
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STP_IN_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity resionForStop;

	@Column(name = "STP_IN_ORDER_DATE")
	private Date stopIncOrderDate;

	@Column(name = "STP_IN_ORDER_NO")
	private String stopIncOrderNo;

	@Column(name = "DURATION_OF_STP_IN")
	private Long durationOfSTPIn;

	@Column(name = "UNIT_YEAR_MONTH")
	private Character unitYearMonth;

	@Column(name = "NO_OF_STP_IN")
	private Long noOfSTPIn;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_IN_EVNT_ID", nullable = false, referencedColumnName = "T_PVU_IN_EVNT_ID")
	private PVUIncrementEventEntity inEventId;

	@Column(name = "STP_START_DATE")
	private Date stpStartDate;

	@Column(name = "STP_END_DATE")
	private Date stpEndDate;

	@Column(name = "WH_START_DATE")
	private Date whStartDate;

	@Column(name = "WH_END_DATE")
	private Date whEndDate;


	@JsonIgnore
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "T_PVU_IN_EMP_SD_ID", nullable = false, referencedColumnName = "T_PVU_IN_EMP_SD_ID")
	private PVUIncrementEmpSDEntity pvuIncrementEmpSDEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the empId
	 */
	public PVUEmployeEntity getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(PVUEmployeEntity empId) {
		this.empId = empId;
	}

	public EDPLuLookUpInfoEntity getResionForStop() {
		return resionForStop;
	}

	public void setResionForStop(EDPLuLookUpInfoEntity resionForStop) {
		this.resionForStop = resionForStop;
	}

	public Date getStopIncOrderDate() {
		return stopIncOrderDate;
	}

	public void setStopIncOrderDate(Date stopIncOrderDate) {
		this.stopIncOrderDate = stopIncOrderDate;
	}

	public String getStopIncOrderNo() {
		return stopIncOrderNo;
	}

	public void setStopIncOrderNo(String stopIncOrderNo) {
		this.stopIncOrderNo = stopIncOrderNo;
	}

	/**
	 * @return the durationOfSTPIn
	 */
	public Long getDurationOfSTPIn() {
		return durationOfSTPIn;
	}

	/**
	 * @param durationOfSTPIn the durationOfSTPIn to set
	 */
	public void setDurationOfSTPIn(Long durationOfSTPIn) {
		this.durationOfSTPIn = durationOfSTPIn;
	}

	/**
	 * @return the unitYearMonth
	 */
	public Character getUnitYearMonth() {
		return unitYearMonth;
	}

	/**
	 * @param unitYearMonth the unitYearMonth to set
	 */
	public void setUnitYearMonth(Character unitYearMonth) {
		this.unitYearMonth = unitYearMonth;
	}

	/**
	 * @return the noOfSTPIn
	 */
	public Long getNoOfSTPIn() {
		return noOfSTPIn;
	}

	/**
	 * @param noOfSTPIn the noOfSTPIn to set
	 */
	public void setNoOfSTPIn(Long noOfSTPIn) {
		this.noOfSTPIn = noOfSTPIn;
	}

	/**
	 * @return the inEventId
	 */
	public PVUIncrementEventEntity getInEventId() {
		return inEventId;
	}

	/**
	 * @param inEventId the inEventId to set
	 */
	public void setInEventId(PVUIncrementEventEntity inEventId) {
		this.inEventId = inEventId;
	}

	public Date getStpStartDate() {
		return stpStartDate;
	}

	public void setStpStartDate(Date stpStartDate) {
		this.stpStartDate = stpStartDate;
	}

	public Date getStpEndDate() {
		return stpEndDate;
	}

	public void setStpEndDate(Date stpEndDate) {
		this.stpEndDate = stpEndDate;
	}

	public Date getWhStartDate() {
		return whStartDate;
	}

	public void setWhStartDate(Date whStartDate) {
		this.whStartDate = whStartDate;
	}

	public Date getWhEndDate() {
		return whEndDate;
	}

	public void setWhEndDate(Date whEndDate) {
		this.whEndDate = whEndDate;
	}

	public PVUIncrementEmpSDEntity getPvuIncrementEmpSDEntity() {
		return pvuIncrementEmpSDEntity;
	}

	public void setPvuIncrementEmpSDEntity(PVUIncrementEmpSDEntity pvuIncrementEmpSDEntity) {
		this.pvuIncrementEmpSDEntity = pvuIncrementEmpSDEntity;
	}

	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	}
