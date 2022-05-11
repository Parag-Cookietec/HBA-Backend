package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

/**
 * The Class PVUPVURopPrintEndorsementItrEntity.
 *
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 *
 */
@Entity
@Table(name = "T_CMNPVU_PREN_LST_ITR", schema = Constant.PVU_SCHEMA)
public class PVUPrintEndorsementItrEntity extends BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_CMNPVU_PREN_LST_ITR_ID")
	private Long printEndItrId;

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

	public Long getPrintEndItrId() {
		return printEndItrId;
	}

	public void setPrintEndItrId(Long printEndItrId) {
		this.printEndItrId = printEndItrId;
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
}
