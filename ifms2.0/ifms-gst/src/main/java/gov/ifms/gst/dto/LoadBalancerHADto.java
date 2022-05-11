package gov.ifms.gst.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class LoadBalancerHADto {
	private long id;
	private Date transferDt;
	private Long bankId;
	private String bankName;
	private long fromSaDaId;
	private String fromSaDaName;
	private int totalChallans;
	private Double totalAmount;
	private long toSaDaId;
	private String toSaDaName;
	private int totalChallansTrnf;
	private Double totalAmountTrnf;
	private String referenceNo;
	private LocalDateTime referenceDt;
	private Date fromDate;
	private Date toDate;
	private List<String> branchId;
	private long fileProcessId;

	public List<String> getBranchId() {
		return branchId;
	}

	public void setBranchId(List<String> branchId) {
		this.branchId = branchId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getFromSaDaId() {
		return fromSaDaId;
	}

	public void setFromSaDaId(long fromSaDaId) {
		this.fromSaDaId = fromSaDaId;
	}

	public String getFromSaDaName() {
		return fromSaDaName;
	}

	public void setFromSaDaName(String fromSaDaName) {
		this.fromSaDaName = fromSaDaName;
	}

	public int getTotalChallans() {
		return totalChallans;
	}

	public void setTotalChallans(int totalChallans) {
		this.totalChallans = totalChallans;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getToSaDaId() {
		return toSaDaId;
	}

	public void setToSaDaId(long toSaDaId) {
		this.toSaDaId = toSaDaId;
	}

	public String getToSaDaName() {
		return toSaDaName;
	}

	public void setToSaDaName(String toSaDaName) {
		this.toSaDaName = toSaDaName;
	}

	public int getTotalChallansTrnf() {
		return totalChallansTrnf;
	}

	public void setTotalChallansTrnf(int totalChallansTrnf) {
		this.totalChallansTrnf = totalChallansTrnf;
	}

	public Double getTotalAmountTrnf() {
		return totalAmountTrnf;
	}

	public void setTotalAmountTrnf(Double totalAmountTrnf) {
		this.totalAmountTrnf = totalAmountTrnf;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public long getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(long fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

}
