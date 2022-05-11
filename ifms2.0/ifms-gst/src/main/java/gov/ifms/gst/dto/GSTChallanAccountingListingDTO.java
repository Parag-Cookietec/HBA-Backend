package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.gst.util.GSTUtility;

public class GSTChallanAccountingListingDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The cin. */
	@NativeQueryResultColumn(index = 1)
	private String cin;

	/** The govCreditDate. */
	@NativeQueryResultColumn(index = 2)
	private String govCreditDate;

	/** The amount. */
	@NativeQueryResultColumn(index = 3)
	private Double amount;

	/** The scrollDate. */
	@NativeQueryResultColumn(index = 4)
	private String scrollDate;

	/** The paymentDate. */
	@NativeQueryResultColumn(index = 5)
	private String paymentDate;

	/** The partyName. */
	@NativeQueryResultColumn(index = 6)
	private String partyName;

	/** The bankId. */
	@NativeQueryResultColumn(index = 7)
	private String bankId;

	/** The accountHdrId. */
	@NativeQueryResultColumn(index = 8)
	private String accountHdrId;

	/** The isEditable. */
	@NativeQueryResultColumn(index = 9)
	private String isEditable;

	/** The status. */
	@NativeQueryResultColumn(index = 10)
	private String status;

	/** The remarks. */
	@NativeQueryResultColumn(index = 11)
	private String remarks;

	/** The bankId. */
	@NativeQueryResultColumn(index = 12)
	private String totalRecords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGovCreditDate() {
		return govCreditDate;
	}

	public void setGovCreditDate(String govCreditDate) {
		this.govCreditDate = govCreditDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getScrollDate() {
		return scrollDate;
	}

	public void setScrollDate(String scrollDate) {
		this.scrollDate = scrollDate;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	public String getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}

	public String getAccountHdrId() {
		return accountHdrId;
	}

	public void setAccountHdrId(String accountHdrId) {
		this.accountHdrId = accountHdrId;
	}
}
