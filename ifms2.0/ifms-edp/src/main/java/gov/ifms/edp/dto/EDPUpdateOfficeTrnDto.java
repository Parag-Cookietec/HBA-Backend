package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;

/**
 * The Class UpdateOfficeTrnDto.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 *
 */
public class EDPUpdateOfficeTrnDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The upd offc trn id. */
	@NotNull
	private Long updOffcTrnId;

	/** The office id. */
	@NotNull
	private Long officeIdTrn;

	/** The status id. */
	private Integer statusId;

	/**
	 * Gets the upd offc trn id.
	 *
	 * @return the upd offc trn id
	 */
	public Long getUpdOffcTrnId() {
		return updOffcTrnId;
	}

	/**
	 * Sets the upd offc trn id.
	 *
	 * @param updOffcTrnId the new upd offc trn id
	 */
	public void setUpdOffcTrnId(Long updOffcTrnId) {
		this.updOffcTrnId = updOffcTrnId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeIdTrn() {
		return officeIdTrn;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeIdTrn(Long officeIdTrn) {
		this.officeIdTrn = officeIdTrn;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
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
		result = prime * result + Objects.hash(officeIdTrn, statusId, updOffcTrnId);
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
		if (!(obj instanceof EDPUpdateOfficeTrnDto)) {
			return false;
		}
		EDPUpdateOfficeTrnDto other = (EDPUpdateOfficeTrnDto) obj;
		return Objects.equals(officeIdTrn, other.officeIdTrn) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(updOffcTrnId, other.updOffcTrnId);
	}
	
}
