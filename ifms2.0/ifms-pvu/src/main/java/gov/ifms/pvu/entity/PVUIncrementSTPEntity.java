package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

@Entity
@Table(name = "T_PVU_IN_STP", schema = Constant.PVU_SCHEMA)
public class PVUIncrementSTPEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_IN_STP_SD_ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity empId;

	@Column(name = "STP_IN_TYPE")
	private Long stpType;

	@Column(name = "STP_IN_ORDER_DATE")
	private LocalDateTime stpOrderDate;

	@Column(name = "STP_IN_ORDER_NO")
	private String stpOrderNo;

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
	private LocalDateTime stpStartDate;

	@Column(name = "STP_END_DATE")
	private LocalDateTime stpEndDate;

	@Column(name = "WH_START_DATE")
	private LocalDateTime whStartDate;

	@Column(name = "WH_END_DATE")
	private LocalDateTime whEndDate;

/*	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "T_PVU_IN_STP_SD_ID", nullable = false, referencedColumnName = "T_PVU_IN_STP_SD_ID")
	private PVUIncrementSTPSDEntity inSTPSDId;*/

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUIncrementSTPEntity)) return false;
		PVUIncrementSTPEntity that = (PVUIncrementSTPEntity) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getEmpId(), that.getEmpId()) &&
				Objects.equals(getStpType(), that.getStpType()) &&
				Objects.equals(getStpOrderDate(), that.getStpOrderDate()) &&
				Objects.equals(getStpOrderNo(), that.getStpOrderNo()) &&
				Objects.equals(getDurationOfSTPIn(), that.getDurationOfSTPIn()) &&
				Objects.equals(getUnitYearMonth(), that.getUnitYearMonth()) &&
				Objects.equals(getNoOfSTPIn(), that.getNoOfSTPIn()) &&
				Objects.equals(getInEventId(), that.getInEventId()) &&
				Objects.equals(getStpStartDate(), that.getStpStartDate()) &&
				Objects.equals(getStpEndDate(), that.getStpEndDate()) &&
				Objects.equals(getWhStartDate(), that.getWhStartDate()) &&
				Objects.equals(getWhEndDate(), that.getWhEndDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getEmpId(), getStpType(), getStpOrderDate(), getStpOrderNo(), getDurationOfSTPIn(), getUnitYearMonth(), getNoOfSTPIn(), getInEventId(), getStpStartDate(), getStpEndDate(), getWhStartDate(), getWhEndDate());
	}

	@Override
	public String toString() {
		return "PVUIncrementSTPEntity{" +
				"id=" + id +
				", empId=" + empId +
				", stpType=" + stpType +
				", stpOrderDate=" + stpOrderDate +
				", stpOrderNo='" + stpOrderNo + '\'' +
				", durationOfSTPIn=" + durationOfSTPIn +
				", unitYearMonth=" + unitYearMonth +
				", noOfSTPIn=" + noOfSTPIn +
				", inEventId=" + inEventId +
				", stpStartDate=" + stpStartDate +
				", stpEndDate=" + stpEndDate +
				", whStartDate=" + whStartDate +
				", whEndDate=" + whEndDate +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	/**
	 * @return the stpType
	 */
	public Long getStpType() {
		return stpType;
	}

	/**
	 * @param stpType the stpType to set
	 */
	public void setStpType(Long stpType) {
		this.stpType = stpType;
	}

	/**
	 * @return the stpOrderDate
	 */
	public LocalDateTime getStpOrderDate() {
		return stpOrderDate;
	}

	/**
	 * @param stpOrderDate the stpOrderDate to set
	 */
	public void setStpOrderDate(LocalDateTime stpOrderDate) {
		this.stpOrderDate = stpOrderDate;
	}

	/**
	 * @return the stpOrderNo
	 */
	public String getStpOrderNo() {
		return stpOrderNo;
	}

	/**
	 * @param stpOrderNo the stpOrderNo to set
	 */
	public void setStpOrderNo(String stpOrderNo) {
		this.stpOrderNo = stpOrderNo;
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

	/**
	 * @return the stpStartDate
	 */
	public LocalDateTime getStpStartDate() {
		return stpStartDate;
	}

	/**
	 * @param stpStartDate the stpStartDate to set
	 */
	public void setStpStartDate(LocalDateTime stpStartDate) {
		this.stpStartDate = stpStartDate;
	}

	/**
	 * @return the stpEndDate
	 */
	public LocalDateTime getStpEndDate() {
		return stpEndDate;
	}

	/**
	 * @param stpEndDate the stpEndDate to set
	 */
	public void setStpEndDate(LocalDateTime stpEndDate) {
		this.stpEndDate = stpEndDate;
	}

	/**
	 * @return the whStartDate
	 */
	public LocalDateTime getWhStartDate() {
		return whStartDate;
	}

	/**
	 * @param whStartDate the whStartDate to set
	 */
	public void setWhStartDate(LocalDateTime whStartDate) {
		this.whStartDate = whStartDate;
	}

	/**
	 * @return the whEndDate
	 */
	public LocalDateTime getWhEndDate() {
		return whEndDate;
	}

	/**
	 * @param whEndDate the whEndDate to set
	 */
	public void setWhEndDate(LocalDateTime whEndDate) {
		this.whEndDate = whEndDate;
	}


}
