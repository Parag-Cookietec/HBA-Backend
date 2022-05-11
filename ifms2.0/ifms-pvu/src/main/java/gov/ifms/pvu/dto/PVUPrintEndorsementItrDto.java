package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.edp.dto.BaseDto;

public class PVUPrintEndorsementItrDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long printEndItrId;

	private Long id;

	private Long trnId;

	private Long eventId;

	private Long printCnt;

	private Long printDocType;

	private Long status;

	private Date printDate;

	private Date reprintDate;

	private String remark;

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

	public Long getPrintEndItrId() {
		return printEndItrId;
	}

	public void setPrintEndItrId(Long printEndItrId) {
		this.printEndItrId = printEndItrId;
	}
}
