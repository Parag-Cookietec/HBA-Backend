package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gov.ifms.dmo.entity.BaseEntity;

/**
 * The Class DMOMarketLoanDto.
 * 
 * @version 2.0
 * @created 2021/07/31 08:19:32
 *
 */
public class DMOMarketLoanDto extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	
	private Long id;


	private Long dpSheetId;


	private LocalDate dpSheetRecvDt;


	private int isLoanOlder;


	private String loanNumber;


	private String memoNo;


	private String referenceNo;


	private LocalDateTime referenceDt;


	private String adviceNo;


	private LocalDate adviceDt;


	private String adviceBy;


	private String transactionDesc;


	private String sanctionOrderNo;


	private LocalDateTime sanctionOrderDt;


	private String organizationName;


	private LocalDate loanReceiptDt;


	private Long loanFinYrId;


	private LocalDate loanStartDt;


	private Double totAmountRecd;


	private Double loanAmount;


	private Double premiumAmount;


	private String notificationNo;


	private LocalDateTime notificationDt;


	private Long floatationWayId;


	private Long loanTypeId;


	private String newLoanTran;


	private String tranDesc;


	private int loanTenure;


	private Double loanRoi;


	private int issueNumber;


	private int moratoriumPeriod;


	private Double moratrmPncplPerc;


	private int totRepayInstall;


	private int repayInstallYr;


	private LocalDate pncplFirstInstallDt;


	private int interstInstallYr;


	private LocalDate intrstFirstInstallDt;


	private LocalDate loanMaturityDt;


	private LocalDate loanDeleteDt;


	private Long loanDeleteBy;

	private List<DMOMarketLoanRePaymentDto> dtos = new ArrayList<>();
	
	public List<DMOMarketLoanRePaymentDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<DMOMarketLoanRePaymentDto> dtos) {
		this.dtos = dtos;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the dpSheetId
	 */
	public Long getDpSheetId() {
		return dpSheetId;
	}


	/**
	 * @param dpSheetId the dpSheetId to set
	 */
	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}


	/**
	 * @return the dpSheetRecvDt
	 */
	public LocalDate getDpSheetRecvDt() {
		return dpSheetRecvDt;
	}


	/**
	 * @param dpSheetRecvDt the dpSheetRecvDt to set
	 */
	public void setDpSheetRecvDt(LocalDate dpSheetRecvDt) {
		this.dpSheetRecvDt = dpSheetRecvDt;
	}


	/**
	 * @return the isLoanOlder
	 */
	public int getIsLoanOlder() {
		return isLoanOlder;
	}


	/**
	 * @param isLoanOlder the isLoanOlder to set
	 */
	public void setIsLoanOlder(int isLoanOlder) {
		this.isLoanOlder = isLoanOlder;
	}


	/**
	 * @return the loanNumber
	 */
	public String getLoanNumber() {
		return loanNumber;
	}


	/**
	 * @param loanNumber the loanNumber to set
	 */
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
	}


	/**
	 * @return the memoNo
	 */
	public String getMemoNo() {
		return memoNo;
	}


	/**
	 * @param memoNo the memoNo to set
	 */
	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}


	/**
	 * @return the referenceNo
	 */
	public String getReferenceNo() {
		return referenceNo;
	}


	/**
	 * @param referenceNo the referenceNo to set
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}


	/**
	 * @return the referenceDt
	 */
	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}


	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}


	/**
	 * @return the adviceNo
	 */
	public String getAdviceNo() {
		return adviceNo;
	}


	/**
	 * @param adviceNo the adviceNo to set
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}


	/**
	 * @return the adviceDt
	 */
	public LocalDate getAdviceDt() {
		return adviceDt;
	}


	/**
	 * @param adviceDt the adviceDt to set
	 */
	public void setAdviceDt(LocalDate adviceDt) {
		this.adviceDt = adviceDt;
	}


	/**
	 * @return the adviceBy
	 */
	public String getAdviceBy() {
		return adviceBy;
	}


	/**
	 * @param adviceBy the adviceBy to set
	 */
	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}


	/**
	 * @return the transactionDesc
	 */
	public String getTransactionDesc() {
		return transactionDesc;
	}


	/**
	 * @param transactionDesc the transactionDesc to set
	 */
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}


	/**
	 * @return the sanctionOrderNo
	 */
	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}


	/**
	 * @param sanctionOrderNo the sanctionOrderNo to set
	 */
	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}


	/**
	 * @return the sanctionOrderDt
	 */
	public LocalDateTime getSanctionOrderDt() {
		return sanctionOrderDt;
	}


	/**
	 * @param sanctionOrderDt the sanctionOrderDt to set
	 */
	public void setSanctionOrderDt(LocalDateTime sanctionOrderDt) {
		this.sanctionOrderDt = sanctionOrderDt;
	}


	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}


	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}


	/**
	 * @return the loanReceiptDt
	 */
	public LocalDate getLoanReceiptDt() {
		return loanReceiptDt;
	}


	/**
	 * @param loanReceiptDt the loanReceiptDt to set
	 */
	public void setLoanReceiptDt(LocalDate loanReceiptDt) {
		this.loanReceiptDt = loanReceiptDt;
	}


	/**
	 * @return the loanFinYrId
	 */
	public Long getLoanFinYrId() {
		return loanFinYrId;
	}


	/**
	 * @param loanFinYrId the loanFinYrId to set
	 */
	public void setLoanFinYrId(Long loanFinYrId) {
		this.loanFinYrId = loanFinYrId;
	}


	/**
	 * @return the loanStartDt
	 */
	public LocalDate getLoanStartDt() {
		return loanStartDt;
	}


	/**
	 * @param loanStartDt the loanStartDt to set
	 */
	public void setLoanStartDt(LocalDate loanStartDt) {
		this.loanStartDt = loanStartDt;
	}


	/**
	 * @return the totAmountRecd
	 */
	public Double getTotAmountRecd() {
		return totAmountRecd;
	}


	/**
	 * @param totAmountRecd the totAmountRecd to set
	 */
	public void setTotAmountRecd(Double totAmountRecd) {
		this.totAmountRecd = totAmountRecd;
	}


	/**
	 * @return the loanAmount
	 */
	public Double getLoanAmount() {
		return loanAmount;
	}


	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}


	/**
	 * @return the premiumAmount
	 */
	public Double getPremiumAmount() {
		return premiumAmount;
	}


	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}


	/**
	 * @return the notificationNo
	 */
	public String getNotificationNo() {
		return notificationNo;
	}


	/**
	 * @param notificationNo the notificationNo to set
	 */
	public void setNotificationNo(String notificationNo) {
		this.notificationNo = notificationNo;
	}


	/**
	 * @return the notificationDt
	 */
	public LocalDateTime getNotificationDt() {
		return notificationDt;
	}


	/**
	 * @param notificationDt the notificationDt to set
	 */
	public void setNotificationDt(LocalDateTime notificationDt) {
		this.notificationDt = notificationDt;
	}


	/**
	 * @return the floatationWayId
	 */
	public Long getFloatationWayId() {
		return floatationWayId;
	}


	/**
	 * @param floatationWayId the floatationWayId to set
	 */
	public void setFloatationWayId(Long floatationWayId) {
		this.floatationWayId = floatationWayId;
	}


	/**
	 * @return the loanTypeId
	 */
	public Long getLoanTypeId() {
		return loanTypeId;
	}


	/**
	 * @param loanTypeId the loanTypeId to set
	 */
	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}


	

	/**
	 * @return the newLoanTran
	 */
	public String getNewLoanTran() {
		return newLoanTran;
	}


	/**
	 * @param newLoanTran the newLoanTran to set
	 */
	public void setNewLoanTran(String newLoanTran) {
		this.newLoanTran = newLoanTran;
	}


	/**
	 * @return the tranDesc
	 */
	public String getTranDesc() {
		return tranDesc;
	}


	/**
	 * @param tranDesc the tranDesc to set
	 */
	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}


	/**
	 * @return the loanTenure
	 */
	public int getLoanTenure() {
		return loanTenure;
	}


	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}


	/**
	 * @return the loanRoi
	 */
	public Double getLoanRoi() {
		return loanRoi;
	}


	/**
	 * @param loanRoi the loanRoi to set
	 */
	public void setLoanRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}


	/**
	 * @return the issueNumber
	 */
	public int getIssueNumber() {
		return issueNumber;
	}


	/**
	 * @param issueNumber the issueNumber to set
	 */
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}


	/**
	 * @return the moratoriumPeriod
	 */
	public int getMoratoriumPeriod() {
		return moratoriumPeriod;
	}


	/**
	 * @param moratoriumPeriod the moratoriumPeriod to set
	 */
	public void setMoratoriumPeriod(int moratoriumPeriod) {
		this.moratoriumPeriod = moratoriumPeriod;
	}


	/**
	 * @return the moratrmPncplPerc
	 */
	public Double getMoratrmPncplPerc() {
		return moratrmPncplPerc;
	}


	/**
	 * @param moratrmPncplPerc the moratrmPncplPerc to set
	 */
	public void setMoratrmPncplPerc(Double moratrmPncplPerc) {
		this.moratrmPncplPerc = moratrmPncplPerc;
	}


	/**
	 * @return the totRepayInstall
	 */
	public int getTotRepayInstall() {
		return totRepayInstall;
	}


	/**
	 * @param totRepayInstall the totRepayInstall to set
	 */
	public void setTotRepayInstall(int totRepayInstall) {
		this.totRepayInstall = totRepayInstall;
	}


	/**
	 * @return the repayInstallYr
	 */
	public int getRepayInstallYr() {
		return repayInstallYr;
	}


	/**
	 * @param repayInstallYr the repayInstallYr to set
	 */
	public void setRepayInstallYr(int repayInstallYr) {
		this.repayInstallYr = repayInstallYr;
	}


	/**
	 * @return the pncplFirstInstallDt
	 */
	public LocalDate getPncplFirstInstallDt() {
		return pncplFirstInstallDt;
	}


	/**
	 * @param pncplFirstInstallDt the pncplFirstInstallDt to set
	 */
	public void setPncplFirstInstallDt(LocalDate pncplFirstInstallDt) {
		this.pncplFirstInstallDt = pncplFirstInstallDt;
	}


	/**
	 * @return the interstInstallYr
	 */
	public int getInterstInstallYr() {
		return interstInstallYr;
	}


	/**
	 * @param interstInstallYr the interstInstallYr to set
	 */
	public void setInterstInstallYr(int interstInstallYr) {
		this.interstInstallYr = interstInstallYr;
	}


	/**
	 * @return the intrstFirstInstallDt
	 */
	public LocalDate getIntrstFirstInstallDt() {
		return intrstFirstInstallDt;
	}


	/**
	 * @param intrstFirstInstallDt the intrstFirstInstallDt to set
	 */
	public void setIntrstFirstInstallDt(LocalDate intrstFirstInstallDt) {
		this.intrstFirstInstallDt = intrstFirstInstallDt;
	}


	/**
	 * @return the loanMaturityDt
	 */
	public LocalDate getLoanMaturityDt() {
		return loanMaturityDt;
	}


	/**
	 * @param loanMaturityDt the loanMaturityDt to set
	 */
	public void setLoanMaturityDt(LocalDate loanMaturityDt) {
		this.loanMaturityDt = loanMaturityDt;
	}


	/**
	 * @return the loanDeleteDt
	 */
	public LocalDate getLoanDeleteDt() {
		return loanDeleteDt;
	}


	/**
	 * @param loanDeleteDt the loanDeleteDt to set
	 */
	public void setLoanDeleteDt(LocalDate loanDeleteDt) {
		this.loanDeleteDt = loanDeleteDt;
	}


	/**
	 * @return the loanDeleteBy
	 */
	public Long getLoanDeleteBy() {
		return loanDeleteBy;
	}


	/**
	 * @param loanDeleteBy the loanDeleteBy to set
	 */
	public void setLoanDeleteBy(Long loanDeleteBy) {
		this.loanDeleteBy = loanDeleteBy;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
