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
public class PVURopPrintEndorsementDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The print doc id. */
	private Long trnId;

	/** The print cnt. */
	private Long printCnt;

	/** The print doc type. */
	private Long printDocType;

	/** The status. */
	private Long status;

	/** The print date. */
	private Date printDate;
	
	/** The reprint date. */
	private Date reprintDate;

	/** The remark. */
	private String remark;
	
	/**
	 * PVURopPrintEndorsementDto Constructor.
	 */
	public PVURopPrintEndorsementDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the id
	 */

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the prints the cnt.
	 *
	 * @return the printCnt
	 */
	public Long getPrintCnt() {
		return printCnt;
	}

	/**
	 * Sets the prints the cnt.
	 *
	 * @param printCnt the printCnt to set
	 */
	public void setPrintCnt(Long printCnt) {
		this.printCnt = printCnt;
	}

	/**
	 * Gets the prints the doc type.
	 *
	 * @return the printDocType
	 */
	public Long getPrintDocType() {
		return printDocType;
	}

	/**
	 * Sets the prints the doc type.
	 *
	 * @param printDocType the printDocType to set
	 */
	public void setPrintDocType(Long printDocType) {
		this.printDocType = printDocType;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Long getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(Long status) {
		this.status = status;
	}

	/**
	 * Gets the trn id.
	 *
	 * @return the trn id
	 */
	public Long getTrnId() {
		return trnId;
	}

	/**
	 * Sets the trn id.
	 *
	 * @param trnId the new trn id
	 */
	public void setTrnId(Long trnId) {
		this.trnId = trnId;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, printCnt, printDate, printDocType, remark, reprintDate, status, trnId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVURopPrintEndorsementDto other = (PVURopPrintEndorsementDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(printCnt, other.printCnt)
				&& Objects.equals(printDate, other.printDate) && Objects.equals(printDocType, other.printDocType)
				&& Objects.equals(remark, other.remark) && Objects.equals(reprintDate, other.reprintDate)
				&& Objects.equals(status, other.status) && Objects.equals(trnId, other.trnId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURopPrintEndorsementDto [id=" + id + ", trnId=" + trnId + ", printCnt=" + printCnt + ", printDocType="
				+ printDocType + ", status=" + status + ", printDate=" + printDate + ", reprintDate=" + reprintDate
				+ ", remark=" + remark + "]";
	}

}
