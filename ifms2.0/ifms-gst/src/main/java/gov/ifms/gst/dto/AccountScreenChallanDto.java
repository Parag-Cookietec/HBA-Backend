package gov.ifms.gst.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class AccountScreenChallanDto implements Serializable {

	public Long id;

	public String cin;

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date govCreditDate;

	public Double amount;

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date scrollDate;

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date paymentDate;

	public String partyName;

	public String remarks;

	public String status;

	public Long bankId;

	public long cpinNo;

	public AccountScreenChallanDto(Long id, String cin, Date govCreditDate, Double amount, Date scrollDate, Date paymentDate, String partyName, String remarks, String status, Long bankId) {
		this.id = id;
		this.cin = cin;
		this.govCreditDate = govCreditDate;
		this.amount = amount;
		this.scrollDate = scrollDate;
		this.paymentDate = paymentDate;
		this.partyName = partyName;
		this.remarks = remarks;
		this.status = status;
		this.bankId=bankId;
	}

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

	public Date getGovCreditDate() {
		return govCreditDate;
	}

	public void setGovCreditDate(Date govCreditDate) {
		this.govCreditDate = govCreditDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getScrollDate() {
		return scrollDate;
	}

	public void setScrollDate(Date scrollDate) {
		this.scrollDate = scrollDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}


	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}
}