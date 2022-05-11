package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocCheckPayPaymentDto.
 */
@NativeQueryResultEntity
public class LocCheckPayPaymentDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/**
	 * The sd id.
	 */
	@NativeQueryResultColumn(index = 1)
	private Long sdId;

	/**
	 * The party name.
	 */
	@NativeQueryResultColumn(index = 2)
	private String vendorName;

	/**
	 * The bank account no.
	 */
	@NativeQueryResultColumn(index = 3)
	private String accNo;

	/**
	 * The ifsc.
	 */
	@NativeQueryResultColumn(index = 4)
	private String ifscCode;

	/**
	 * The epay amt.
	 */
	@NativeQueryResultColumn(index = 5)
	private Double epayAmnt;

	/**
	 * The chq date.
	 */
	@NativeQueryResultColumn(index = 6)
	private Date chequeDate;

	/**
	 * The chq no.
	 */
	@NativeQueryResultColumn(index = 7)
	private String chequeNo;

	/**
	 * The chq amt.
	 */
	@NativeQueryResultColumn(index = 8)
	private Double chequeAmount;

	/**
	 * LocCheckPayPaymentDto Constructor.
	 */

	public LocCheckPayPaymentDto() {
		super();

	}

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
	 * Gets the sd id.
	 *
	 * @return the sd id
	 */
	public Long getSdId() {
		return sdId;
	}

	/**
	 * Sets the sd id.
	 *
	 * @param sdId the new sd id
	 */
	public void setSdId(Long sdId) {
		this.sdId = sdId;
	}

	/**
	 * Gets the vendor name.
	 *
	 * @return the vendor name
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * Sets the vendor name.
	 *
	 * @param vendorName the new vendor name
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * Gets the ifsc code.
	 *
	 * @return the ifsc code
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * Sets the ifsc code.
	 *
	 * @param ifscCode the new ifsc code
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


	/**
	 * Gets the epay amnt.
	 *
	 * @return the epay amnt
	 */
	public Double getEpayAmnt() {
		return epayAmnt;
	}

	/**
	 * Sets the epay amnt.
	 *
	 * @param epayAmnt the new epay amnt
	 */
	public void setEpayAmnt(Double epayAmnt) {
		this.epayAmnt = epayAmnt;
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
	 * Gets the acc no.
	 *
	 * @return the acc no
	 */
	public String getAccNo() {
		return accNo;
	}

	/**
	 * Sets the acc no.
	 *
	 * @param accNo the new acc no
	 */
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	/**
	 * Gets the cheque amount.
	 *
	 * @return the cheque amount
	 */
	public Double getChequeAmount() {
		return chequeAmount;
	}

	/**
	 * Sets the cheque amount.
	 *
	 * @param chequeAmount the new cheque amount
	 */
	public void setChequeAmount(Double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}
}