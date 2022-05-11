package gov.ifms.gst.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ManualEntryDto extends BaseDto implements Serializable{

	public Long id;

	public String cinNo;

	public Long typeId;

	public String type;

	public String entryStatus;

	public String referenceNo;

	public Double totalEntryAmt;

	public Double totalDebitAmt;

	public Double totalCreditAmt;

	public Date manualEntryDt;

	public Date valueDt;

	public List<CreditEntryDto> creditEntries;

	public List<DebitEntryDto> debitEntries;

	public Long menuId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntryStatus() {
		return entryStatus;
	}

	public void setEntryStatus(String entryStatus) {
		this.entryStatus = entryStatus;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Double getTotalEntryAmt() {
		return totalEntryAmt;
	}

	public void setTotalEntryAmt(Double totalEntryAmt) {
		this.totalEntryAmt = totalEntryAmt;
	}

	public Double getTotalDebitAmt() {
		return totalDebitAmt;
	}

	public void setTotalDebitAmt(Double totalDebitAmt) {
		this.totalDebitAmt = totalDebitAmt;
	}

	public Double getTotalCreditAmt() {
		return totalCreditAmt;
	}

	public void setTotalCreditAmt(Double totalCreditAmt) {
		this.totalCreditAmt = totalCreditAmt;
	}

	public Date getManualEntryDt() {
		return manualEntryDt;
	}

	public void setManualEntryDt(Date manualEntryDt) {
		this.manualEntryDt = manualEntryDt;
	}

	public Date getValueDt() {
		return valueDt;
	}

	public void setValueDt(Date valueDt) {
		this.valueDt = valueDt;
	}

	public List<CreditEntryDto> getCreditEntries() {
		return creditEntries;
	}

	public void setCreditEntries(List<CreditEntryDto> creditEntries) {
		this.creditEntries = creditEntries;
	}

	public List<DebitEntryDto> getDebitEntries() {
		return debitEntries;
	}

	public void setDebitEntries(List<DebitEntryDto> debitEntries) {
		this.debitEntries = debitEntries;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}


