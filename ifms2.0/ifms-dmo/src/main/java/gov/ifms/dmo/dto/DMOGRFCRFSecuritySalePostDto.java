package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFSecuritySalePostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long accountTypeId;
	private Long transactTypeId;
	@NotNull(message = "{sale.dt.notNull}")
	private LocalDate saleDt;
	@NotNull(message = "{rbi.advice.no.notNull}")
	private String rbiAdviceNo;
	@NotNull(message = "{rbi.advice.dt.notNull}")
	private LocalDate rbiAdviceDt;
	@NotNull(message = "{prog.bal.acc.notNull}")
	private Double currAccBal;
	private LocalDate transactionDt;
	private Double interestAmt;
	private Double totalSecurityAmt;
	@NotNull(message = "{st.acc.transfr.amt.notNull}")
	private Double stAccTransfrAmt;
	private Double progBalAcc;
	private String accountType;
	private Long secSaleId;
	@NotNull(message = "{security.type.id.notNull}")
	private Long securityTypeId;
	@NotNull(message = "{curr.face.value.notNull}")
	private Double currFaceValue;
	@NotNull(message = "{face.val.sec.sold.notNull}")
	private Double faceValSecSold;
	@NotNull(message = "{units.sold.no.notNull}")
	private Long unitsSoldNo;
	@NotNull(message = "{sales.price.notNull}")
	private Double salesPrice;
	private Double saleSecRelzdAmt;
	@NotNull(message = "{broken.days.notNull}")
	private Integer brokenDays;
	@NotNull(message = "{accr.intrst.recv.notNull}")
	private Double accrIntrstRecv;
	@NotNull(message = "{total.relzd.amt.notNull}")
	private Double totalRelzdAmt;
	private String referenceNo;
	private LocalDateTime referenceDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Long getTransactTypeId() {
		return transactTypeId;
	}

	public void setTransactTypeId(Long transactTypeId) {
		this.transactTypeId = transactTypeId;
	}

	public LocalDate getSaleDt() {
		return saleDt;
	}

	public void setSaleDt(LocalDate saleDt) {
		this.saleDt = saleDt;
	}

	public String getRbiAdviceNo() {
		return rbiAdviceNo;
	}

	public void setRbiAdviceNo(String rbiAdviceNo) {
		this.rbiAdviceNo = rbiAdviceNo;
	}

	public LocalDate getRbiAdviceDt() {
		return rbiAdviceDt;
	}

	public void setRbiAdviceDt(LocalDate rbiAdviceDt) {
		this.rbiAdviceDt = rbiAdviceDt;
	}

	public Double getCurrAccBal() {
		return currAccBal;
	}

	public void setCurrAccBal(Double currAccBal) {
		this.currAccBal = currAccBal;
	}

	public LocalDate getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(LocalDate transactionDt) {
		this.transactionDt = transactionDt;
	}

	public Double getInterestAmt() {
		return interestAmt;
	}

	public void setInterestAmt(Double interestAmt) {
		this.interestAmt = interestAmt;
	}

	public Double getTotalSecurityAmt() {
		return totalSecurityAmt;
	}

	public void setTotalSecurityAmt(Double totalSecurityAmt) {
		this.totalSecurityAmt = totalSecurityAmt;
	}

	public Double getStAccTransfrAmt() {
		return stAccTransfrAmt;
	}

	public void setStAccTransfrAmt(Double stAccTransfrAmt) {
		this.stAccTransfrAmt = stAccTransfrAmt;
	}

	public Double getProgBalAcc() {
		return progBalAcc;
	}

	public void setProgBalAcc(Double progBalAcc) {
		this.progBalAcc = progBalAcc;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getSecSaleId() {
		return secSaleId;
	}

	public void setSecSaleId(Long secSaleId) {
		this.secSaleId = secSaleId;
	}

	public Long getSecurityTypeId() {
		return securityTypeId;
	}

	public void setSecurityTypeId(Long securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public Double getCurrFaceValue() {
		return currFaceValue;
	}

	public void setCurrFaceValue(Double currFaceValue) {
		this.currFaceValue = currFaceValue;
	}

	public Double getFaceValSecSold() {
		return faceValSecSold;
	}

	public void setFaceValSecSold(Double faceValSecSold) {
		this.faceValSecSold = faceValSecSold;
	}

	public Long getUnitsSoldNo() {
		return unitsSoldNo;
	}

	public void setUnitsSoldNo(Long unitsSoldNo) {
		this.unitsSoldNo = unitsSoldNo;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Double getSaleSecRelzdAmt() {
		return saleSecRelzdAmt;
	}

	public void setSaleSecRelzdAmt(Double saleSecRelzdAmt) {
		this.saleSecRelzdAmt = saleSecRelzdAmt;
	}

	public Integer getBrokenDays() {
		return brokenDays;
	}

	public void setBrokenDays(Integer brokenDays) {
		this.brokenDays = brokenDays;
	}

	public Double getAccrIntrstRecv() {
		return accrIntrstRecv;
	}

	public void setAccrIntrstRecv(Double accrIntrstRecv) {
		this.accrIntrstRecv = accrIntrstRecv;
	}

	public Double getTotalRelzdAmt() {
		return totalRelzdAmt;
	}

	public void setTotalRelzdAmt(Double totalRelzdAmt) {
		this.totalRelzdAmt = totalRelzdAmt;
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

}
