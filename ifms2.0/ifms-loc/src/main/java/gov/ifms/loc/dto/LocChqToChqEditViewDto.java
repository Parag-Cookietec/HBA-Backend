package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqToChqEditViewDto.
 */
@NativeQueryResultEntity
public class LocChqToChqEditViewDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 1)
	private Long hdrId;

	/** The cheque no. */
	@NativeQueryResultColumn(index = 2)
	private String chequeNo;

	/** The cheque amnt. */
	@NativeQueryResultColumn(index = 3)
	private Double chequeAmnt;

	/** The cheque date. */
	@NativeQueryResultColumn(index = 4)
	private Date chequeDate;

	/** The party name. */
	@NativeQueryResultColumn(index = 5)
	private String partyName;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the cheque no.
	 *
	 * @return the cheque no
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * Sets the cheque no.
	 *
	 * @param chequeNo the new cheque no
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * Gets the cheque amnt.
	 *
	 * @return the cheque amnt
	 */
	public Double getChequeAmnt() {
		return chequeAmnt;
	}

	/**
	 * Sets the cheque amnt.
	 *
	 * @param chequeAmnt the new cheque amnt
	 */
	public void setChequeAmnt(Double chequeAmnt) {
		this.chequeAmnt = chequeAmnt;
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
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
}
