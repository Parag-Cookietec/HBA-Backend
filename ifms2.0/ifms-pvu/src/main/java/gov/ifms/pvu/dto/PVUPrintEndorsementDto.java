package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVURopPrintEndorsementDto.
 *
 * @version v 1.0
 * @created 2020/04/06 16:00:01
 *
 */
public class PVUPrintEndorsementDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long trnId;
	private Long eventId;
	private Long printCnt;
	private Long printDocType;
	private Long status;
	private Date printDate;
	private Date reprintDate;
	private String remark;

	public PVUPrintEndorsementDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getPrintCnt() {
		return printCnt;
	}

	public void setPrintCnt(Long printCnt) {
		this.printCnt = printCnt;
	}

	public Long getPrintDocType() {
		return printDocType;
	}

	public void setPrintDocType(Long printDocType) {
		this.printDocType = printDocType;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Date getReprintDate() {
		return reprintDate;
	}

	public void setReprintDate(Date reprintDate) {
		this.reprintDate = reprintDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(eventId, id, printCnt, printDate, printDocType, remark, reprintDate, status, trnId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUPrintEndorsementDto other = (PVUPrintEndorsementDto) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(id, other.id)
				&& Objects.equals(printCnt, other.printCnt) && Objects.equals(printDate, other.printDate)
				&& Objects.equals(printDocType, other.printDocType) && Objects.equals(remark, other.remark)
				&& Objects.equals(reprintDate, other.reprintDate) && Objects.equals(status, other.status)
				&& Objects.equals(trnId, other.trnId);
	}

	@Override
	public String toString() {
		return "PVUPrintEndorsementDto [id=" + id + ", trnId=" + trnId + ", eventId=" + eventId + ", printCnt="
				+ printCnt + ", printDocType=" + printDocType + ", status=" + status + ", printDate=" + printDate
				+ ", reprintDate=" + reprintDate + ", remark=" + remark + "]";
	}

}
