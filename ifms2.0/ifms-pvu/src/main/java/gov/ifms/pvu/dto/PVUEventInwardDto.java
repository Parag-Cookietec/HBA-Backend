package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEventInwardDto.
 *
 */
public class PVUEventInwardDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/** The inward id. */
	private Long id;

	/** The pvu employee id. */
	private Long employeeId;

	private Long trnId;

	private Long eventId;

	private Long wfRoleId;

	/** The inward date. */
	private LocalDateTime inwardDate;

	/** The inward no. */
	private String inwardNo;

	/** The inward date. */
	private LocalDateTime outWardDate;

	/** The inward no. */
	private String outWardNo;

	/** The inward no. */
	private String postConsignmentNo;

	/** The pou id. */
	private Long pouId;

	/** The pou id. */
	private Long officeId;

	private Long pvuOfficeId;

	private LocalDateTime authDate;

	private LocalDateTime returnDate;

	/**
	 * PVURopInwardEntity Constructor.
	 */
	public PVUEventInwardDto() {
		super();
	}

	/**
	 * Gets the inward id.
	 *
	 * @return the inward id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the inward id.
	 *
	 * @param id the new inward id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets the inward no.
	 *
	 * @return the inward no
	 */
	public String getInwardNo() {
		return inwardNo;
	}

	/**
	 * Sets the inward no.
	 *
	 * @param inwardNo the new inward no
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}

	/**
	 * Gets the pou id.
	 *
	 * @return the pou id
	 */
	public Long getPouId() {
		return pouId;
	}

	/**
	 * Sets the pou id.
	 *
	 * @param pouId the new pou id
	 */
	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTrnId() {
		return trnId;
	}

	public void setTrnId(Long trnId) {
		this.trnId = trnId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public LocalDateTime getInwardDate() {
		return inwardDate;
	}

	public void setInwardDate(LocalDateTime inwardDate) {
		this.inwardDate = inwardDate;
	}

	public LocalDateTime getOutWardDate() {
		return outWardDate;
	}

	public void setOutWardDate(LocalDateTime outWardDate) {
		this.outWardDate = outWardDate;
	}

	public String getOutWardNo() {
		return outWardNo;
	}

	public void setOutWardNo(String outWardNo) {
		this.outWardNo = outWardNo;
	}

	public String getPostConsignmentNo() {
		return postConsignmentNo;
	}

	public void setPostConsignmentNo(String postConsignmentNo) {
		this.postConsignmentNo = postConsignmentNo;
	}

	public Long getPvuOfficeId() {
		return pvuOfficeId;
	}

	public void setPvuOfficeId(Long pvuOfficeId) {
		this.pvuOfficeId = pvuOfficeId;
	}

	public LocalDateTime getAuthDate() {
		return authDate;
	}

	public void setAuthDate(LocalDateTime authDate) {
		this.authDate = authDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUEventInwardDto that = (PVUEventInwardDto) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(employeeId, that.employeeId) &&
				Objects.equals(trnId, that.trnId) &&
				Objects.equals(eventId, that.eventId) &&
				Objects.equals(wfRoleId, that.wfRoleId) &&
				Objects.equals(inwardDate, that.inwardDate) &&
				Objects.equals(inwardNo, that.inwardNo) &&
				Objects.equals(outWardDate, that.outWardDate) &&
				Objects.equals(outWardNo, that.outWardNo) &&
				Objects.equals(postConsignmentNo, that.postConsignmentNo) &&
				Objects.equals(pouId, that.pouId) &&
				Objects.equals(officeId, that.officeId) &&
				Objects.equals(pvuOfficeId, that.pvuOfficeId) &&
				Objects.equals(authDate, that.authDate) &&
				Objects.equals(returnDate, that.returnDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, employeeId, trnId, eventId, wfRoleId, inwardDate, inwardNo, outWardDate, outWardNo, postConsignmentNo, pouId, officeId, pvuOfficeId, authDate, returnDate);
	}
}
