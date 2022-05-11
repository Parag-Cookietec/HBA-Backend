package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPtusrRgMapItrDto.
 * 
 * @version 1.0
 * @created 2020/07/16 09:28:25
 *
 */
public class EDPtusrRgMapItrDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The tusr rg map itr id. */
	private Long tusrRgMapItrId;

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
	 * EDPtusrRgMapItrDto Constructor.
	 */
	public EDPtusrRgMapItrDto() {
		super();
	}
	
	/**
	 * Gets the tusr rg map itr id.
	 *
	 * @return the tusrRgMapItrId
	 */
	public Long getTusrRgMapItrId() {
		return tusrRgMapItrId;
	}
	
	/**
	 * Sets the tusr rg map itr id.
	 *
	 * @param tusrRgMapItrId the tusrRgMapItrId to set
	 */
	public void setTusrRgMapItrId(Long tusrRgMapItrId) {
		this.tusrRgMapItrId = tusrRgMapItrId;
	}
	
	/**
	 * Gets the tusr rg map id.
	 *
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
	
	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(empId, lkPoOffUserId, remarks, statusId, trnNo, tusrRgMapId, tusrRgMapItrId);
		return result;
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPtusrRgMapItrDto)) {
			return false;
		}
		EDPtusrRgMapItrDto other = (EDPtusrRgMapItrDto) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(lkPoOffUserId, other.lkPoOffUserId)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo) && Objects.equals(tusrRgMapId, other.tusrRgMapId)
				&& Objects.equals(tusrRgMapItrId, other.tusrRgMapItrId);
	}

	
}
