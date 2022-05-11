package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

public class EDPBulkEmployeeCreationDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long becId;
	
	/** The transaction id. */
	private String trnNo;
	
	/** The status id. */
	private Long statusId;

	/**
	 * @return the becId
	 */
	public Long getBecId() {
		return becId;
	}

	/**
	 * @param becId the becId to set
	 */
	public void setBecId(Long becId) {
		this.becId = becId;
	}

	/**
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(becId, statusId, trnNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPBulkEmployeeCreationDto)) {
			return false;
		}
		EDPBulkEmployeeCreationDto other = (EDPBulkEmployeeCreationDto) obj;
		return Objects.equals(becId, other.becId) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(trnNo, other.trnNo);
	}

	@Override
	public String toString() {
		return "EDPBulkEmployeeCreationDto [becId=" + becId + ", trnNo=" + trnNo + ", statusId=" + statusId + "]";
	}

	

}
