package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PenalIntrestEntryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String referenceNo;
	private long bankId;
	private String bankName;
	private Date referenceDt;
	private long receiptModeId;
	private String receiptModeText;
	private String chqCeferenceNo;
	private Date receiptDt;
	private Date govtCreditDt;
	private Double interestAmount;
	private long entryStatusId;
	private String entryStatus;
	List<PenalIntrestDTLDto> penalDetailsList;
	private Long menuId;

	public List<PenalIntrestDTLDto> getPenalDetailsList() {
		return penalDetailsList;
	}

	public void setPenalDetailsList(List<PenalIntrestDTLDto> penalDetailsList) {
		this.penalDetailsList = penalDetailsList;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public long getReceiptModeId() {
		return receiptModeId;
	}

	public void setReceiptModeId(long receiptModeId) {
		this.receiptModeId = receiptModeId;
	}

	public String getReceiptModeText() {
		return receiptModeText;
	}

	public void setReceiptModeText(String receiptModeText) {
		this.receiptModeText = receiptModeText;
	}

	public String getChqCeferenceNo() {
		return chqCeferenceNo;
	}

	public void setChqCeferenceNo(String chqCeferenceNo) {
		this.chqCeferenceNo = chqCeferenceNo;
	}

	public Date getReceiptDt() {
		return receiptDt;
	}

	public void setReceiptDt(Date receiptDt) {
		this.receiptDt = receiptDt;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public Double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(Double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public long getEntryStatusId() {
		return entryStatusId;
	}

	public void setEntryStatusId(long entryStatusId) {
		this.entryStatusId = entryStatusId;
	}

	public String getEntryStatus() {
		return entryStatus;
	}

	public void setEntryStatus(String entryStatus) {
		this.entryStatus = entryStatus;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
