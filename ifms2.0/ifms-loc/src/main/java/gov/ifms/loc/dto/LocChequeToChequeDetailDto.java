package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChequeToChequeDetailDto.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:16:18
 *
 */
public class LocChequeToChequeDetailDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long id;

	/** The cheque no. */
	private int chequeNo;

	/** The cheque date. */
	private Date chequeDate;

	/** The cheque amount. */
	private Long chequeAmount;

	/** The cheque to cheque id. */
	private Long chequeToChequeId;

	/** The wf id. */
	private Long wfId;

	/** The wf role id. */
	private Long wfRoleId;

	/** The statusd. */
	private Long statusd;

	/**
	 * LocChequeToChequeDetailDto Constructor.
	 */
	public LocChequeToChequeDetailDto() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(chequeAmount, chequeDate, chequeNo, chequeToChequeId, id, statusd, wfId, wfRoleId);
		return result;
	}

	/**
	 * getter setter.
	 *
	 * @return the id
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof LocChequeToChequeDetailDto)) {
			return false;
		}
		LocChequeToChequeDetailDto other = (LocChequeToChequeDetailDto) obj;
		return Objects.equals(chequeAmount, other.chequeAmount) && Objects.equals(chequeDate, other.chequeDate)
				&& chequeNo == other.chequeNo && Objects.equals(chequeToChequeId, other.chequeToChequeId)
				&& Objects.equals(id, other.id) && Objects.equals(statusd, other.statusd)
				&& Objects.equals(wfId, other.wfId) && Objects.equals(wfRoleId, other.wfRoleId);
	}

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
	 * Gets the cheque no.
	 *
	 * @return the chequeNo
	 */
	public int getChequeNo() {
		return chequeNo;
	}

	/**
	 * Sets the cheque no.
	 *
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the cheque date
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the new cheque date
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the cheque amount.
	 *
	 * @return the cheque amount
	 */

	/**
	 * @return the chequeAmount
	 */
	public Long getChequeAmount() {
		return chequeAmount;
	}

	/**
	 * Sets the cheque amount.
	 *
	 * @param chequeAmount the chequeAmount to set
	 */
	public void setChequeAmount(Long chequeAmount) {
		this.chequeAmount = chequeAmount;
	}

	/**
	 * Gets the cheque to cheque id.
	 *
	 * @return the chequeToChequeId
	 */
	public Long getChequeToChequeId() {
		return chequeToChequeId;
	}

	/**
	 * Sets the cheque to cheque id.
	 *
	 * @param chequeToChequeId the chequeToChequeId to set
	 */
	public void setChequeToChequeId(Long chequeToChequeId) {
		this.chequeToChequeId = chequeToChequeId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wfId
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the wfId to set
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Gets the statusd.
	 *
	 * @return the statusd
	 */
	public Long getStatusd() {
		return statusd;
	}

	/**
	 * Sets the statusd.
	 *
	 * @param statusd the statusd to set
	 */
	public void setStatusd(Long statusd) {
		this.statusd = statusd;
	}

}
