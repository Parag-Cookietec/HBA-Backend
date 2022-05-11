package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:23:40
 *
 */
public class EDPtusrRgMapDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map id. */
	private Long tusrRgMapId;

	/** The trn no. */
	private String trnNo;

	/** The emp id. */
	private Long empId;

	/** The lk po off user id. */
	private Long lkPoOffUserId;

	/** The status id. */
	private Long statusId;

	/** The remarks. */
	private String remarks;

	/**
	 * EDPtusrRgMapDto Constructor.
	 */
	public EDPtusrRgMapDto() {
		super();
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tusrRgMapId, trnNo, empId, lkPoOffUserId, statusId, remarks);
	}

	/**
	 * equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapDto)) {
			return false;
		}

		EDPtusrRgMapDto other = (EDPtusrRgMapDto) obj;

		return Objects.equals(tusrRgMapId, other.tusrRgMapId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(empId, other.empId) && Objects.equals(lkPoOffUserId, other.lkPoOffUserId)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(remarks, other.remarks);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EDPtusrRgMapDto [tusrRgMapId = " + tusrRgMapId + ",trnNo = " + trnNo + ",empId = " + empId
				+ ",lkPoOffUserId = " + lkPoOffUserId + ",statusId = " + statusId + ",remarks = " + remarks + ",]";
	}

	/**
	 * getter setter.
	 *
	 * @return the tusr rg map id
	 */

	/**
	 * @return the tusrRgMapId
	 */
	public Long getTusrRgMapId() {
		return tusrRgMapId;
	}

	/**
	 * Sets the tusr rg map id.
	 *
	 * @param tusrRgMapId the tusrRgMapId to set
	 */
	public void setTusrRgMapId(Long tusrRgMapId) {
		this.tusrRgMapId = tusrRgMapId;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the lk po off user id.
	 *
	 * @return the lkPoOffUserId
	 */
	public Long getLkPoOffUserId() {
		return lkPoOffUserId;
	}

	/**
	 * Sets the lk po off user id.
	 *
	 * @param lkPoOffUserId the lkPoOffUserId to set
	 */
	public void setLkPoOffUserId(Long lkPoOffUserId) {
		this.lkPoOffUserId = lkPoOffUserId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the remarks.
	 *
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * Sets the remarks.
	 *
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
