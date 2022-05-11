package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

@Entity
@Table(name = "T_COMMON_PVU_PREN_LST", schema = Constant.PVU_SCHEMA)
public class PVUPrintEndorsementEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_COMMON_PVU_PREN_LST_ID")
	private Long id;

	@Column(name = "T_PVU_TRN_EVNT_ID")
	private Long trnId;

	@Column(name = "PVU_EVENT_ID")
	private Long eventId;

	@Column(name = "PRINT_CNT")
	private Long printCnt;

	@Column(name = "PRINT_DOC_TYPE")
	private Long printDocType;

	@Column(name = "STATUS")
	private Long status;

	@Column(name = "PRINT_DATE")
	private Date printDate;

	@Column(name = "REPRINT_DATE")
	private Date reprintDate;

	@Column(name = "REMARK")
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

	public void setTrnId(Long trnEventId) {
		this.trnId = trnEventId;
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
		PVUPrintEndorsementEntity other = (PVUPrintEndorsementEntity) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(id, other.id)
				&& Objects.equals(printCnt, other.printCnt) && Objects.equals(printDate, other.printDate)
				&& Objects.equals(printDocType, other.printDocType) && Objects.equals(remark, other.remark)
				&& Objects.equals(reprintDate, other.reprintDate) && Objects.equals(status, other.status)
				&& Objects.equals(trnId, other.trnId);
	}

	@Override
	public String toString() {
		return "PVUPrintEndorsementEntity [id=" + id + ", trnEventId=" + trnId + ", eventId=" + eventId
				+ ", printCnt=" + printCnt + ", printDocType=" + printDocType + ", status=" + status + ", printDate="
				+ printDate + ", reprintDate=" + reprintDate + ", remark=" + remark + "]";
	}


}
