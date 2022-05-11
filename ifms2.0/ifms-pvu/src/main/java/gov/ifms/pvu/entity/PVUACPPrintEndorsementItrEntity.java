package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.util.Date;
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
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUPVURopPrintEndorsementItrEntity.
 * 
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 *
 */
@Entity
@Table(name = "T_CMNPVU_PREN_LST_ITR", schema = Constant.PVU_SCHEMA)
public class PVUACPPrintEndorsementItrEntity extends BaseEntity implements Serializable {

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
	private Long pvuTrnEventId;
	
	@Column(name = "PVU_EVENT_ID")
	private Long pvuEventId;
	
	/** The print cnt. */
	@Column(name = "PRINT_CNT")
	private Long printCnt;

	/** The print doc type. */
	@Column(name = "PRINT_DOC_TYPE")
	private Long printDocType;

	/** The status. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity statusId;

	@Column(name = "PRINT_DATE")
	private Date printDate;
	
	/** The reprint date. */
	@Column(name = "REPRINT_DATE")
	private Date reprintDate;
	
	/** The remark. */
	@Column(name = "REMARK")
	private String remark;
	
	/**
	 * PVUPVURopPrintEndorsementItrEntity Constructor.
	 */
	public PVUACPPrintEndorsementItrEntity() {
		super();
	}

	/**
	 * Gets the prints the end itr id.
	 *
	 * @return the prints the end itr id
	 */
	public Long getPrintEndItrId() {
		return printEndItrId;
	}

	/**
	 * Sets the prints the end itr id.
	 *
	 * @param printEndItrId the new prints the end itr id
	 */
	public void setPrintEndItrId(Long printEndItrId) {
		this.printEndItrId = printEndItrId;
	}

	
	
	/**
	 * Gets the prints the cnt.
	 *
	 * @return the prints the cnt
	 */
	public Long getPrintCnt() {
		return printCnt;
	}

	/**
	 * Sets the prints the cnt.
	 *
	 * @param printCnt the new prints the cnt
	 */
	public void setPrintCnt(Long printCnt) {
		this.printCnt = printCnt;
	}

	/**
	 * Gets the prints the doc type.
	 *
	 * @return the prints the doc type
	 */
	public Long getPrintDocType() {
		return printDocType;
	}

	/**
	 * Sets the prints the doc type.
	 *
	 * @param printDocType the new prints the doc type
	 */
	public void setPrintDocType(Long printDocType) {
		this.printDocType = printDocType;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public EDPLuLookUpInfoEntity getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(EDPLuLookUpInfoEntity statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the prints the date.
	 *
	 * @return the prints the date
	 */
	public Date getPrintDate() {
		return printDate;
	}

	/**
	 * Sets the prints the date.
	 *
	 * @param printDate the new prints the date
	 */
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	/**
	 * Gets the reprint date.
	 *
	 * @return the reprint date
	 */
	public Date getReprintDate() {
		return reprintDate;
	}

	/**
	 * Sets the reprint date.
	 *
	 * @param reprintDate the new reprint date
	 */
	public void setReprintDate(Date reprintDate) {
		this.reprintDate = reprintDate;
	}
	
	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the pvuTrnEventId
	 */
	public Long getPvuTrnEventId() {
		return pvuTrnEventId;
	}

	/**
	 * @param pvuTrnEventId the pvuTrnEventId to set
	 */
	public void setPvuTrnEventId(Long pvuTrnEventId) {
		this.pvuTrnEventId = pvuTrnEventId;
	}

	

	/**
	 * @return the pvuEventId
	 */
	public Long getPvuEventId() {
		return pvuEventId;
	}

	/**
	 * @param pvuEventId the pvuEventId to set
	 */
	public void setPvuEventId(Long pvuEventId) {
		this.pvuEventId = pvuEventId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, printCnt, printDate, printDocType, printEndItrId, pvuEventId, pvuTrnEventId, remark,
				reprintDate, statusId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVUACPPrintEndorsementItrEntity other = (PVUACPPrintEndorsementItrEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(printCnt, other.printCnt)
				&& Objects.equals(printDate, other.printDate) && Objects.equals(printDocType, other.printDocType)
				&& Objects.equals(printEndItrId, other.printEndItrId) && Objects.equals(pvuEventId, other.pvuEventId)
				&& Objects.equals(pvuTrnEventId, other.pvuTrnEventId) && Objects.equals(remark, other.remark)
				&& Objects.equals(reprintDate, other.reprintDate) && Objects.equals(statusId, other.statusId);
	}

	@Override
	public String toString() {
		return "PVUACPPrintEndorsementItrEntity [printEndItrId=" + printEndItrId + ", id=" + id + ", pvuTrnEventId="
				+ pvuTrnEventId + ", pvuEventId=" + pvuEventId + ", printCnt=" + printCnt + ", printDocType="
				+ printDocType + ", statusId=" + statusId + ", printDate=" + printDate + ", reprintDate=" + reprintDate
				+ ", remark=" + remark + "]";
	}



	
}
