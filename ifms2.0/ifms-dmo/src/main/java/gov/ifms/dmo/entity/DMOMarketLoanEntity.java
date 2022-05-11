package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import gov.ifms.common.util.Constant;

/**
 * The Class DMOMarketLoanEntity.
 * 
 * @version 2.0
 * @created 2021/07/31 08:19:32
 *
 */

@Entity
@Table(name = "TDMO_MARKET_LOAN_HDR", schema = Constant.DMO_SCHEMA)
public class DMOMarketLoanEntity extends BaseEntity implements Serializable{

	/** The serialVersionUID. **/
	private static final long serialVersionUID = 1L;
	

	/** The Market loan HRD Id **/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MARKET_LOAN_HDR_ID")
	private Long id;

	/** The is DP_SHEET_ID. */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DP_SHEET_ID", referencedColumnName = "DP_SHEET_ID")
	private DMODPSheetEntryEntity dpSheetId;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "MARKET_LOAN_HDR_ID")
	private List<DMOMarketLoanRePaymentEntity> repayments = new ArrayList<>();

	/** The DP Sheet Received Date**/
	@Column(name = "DP_SHEET_RECV_DT")
	private LocalDate dpSheetRecvDt;

	@Column(name = "IS_LOAN_OLDER")
	private int isLoanOlder;

	@Column(name = "LOAN_NUMBER")
	private String loanNumber;

	@Column(name = "MEMO_NO")
	private String memoNo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "ADVICE_NO")
	private String adviceNo;

	@Column(name = "ADVICE_DT")
	private LocalDate adviceDt;

	@Column(name = "ADVICE_BY")
	private String adviceBy;

	@Column(name = "TRANSACTION_DESC")
	private String transactionDesc;

	@Column(name = "SANCTION_ORDER_NO")
	private String sanctionOrderNo;

	@Column(name = "SANCTION_ORDER_DT")
	private LocalDateTime sanctionOrderDt;

	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;

	@Column(name = "LOAN_RECEIPT_DT")
	private LocalDate loanReceiptDt;

	@Column(name = "LOAN_FIN_YR_ID")
	private Long loanFinYrId;

	@Column(name = "LOAN_START_DT")
	private LocalDate loanStartDt;

	@Column(name = "TOT_AMOUNT_RECD")
	private Double totAmountRecd;

	@Column(name = "LOAN_AMOUNT")
	private Double loanAmount;

	@Column(name = "PREMIUM_AMOUNT")
	private Double premiumAmount;

	@Column(name = "NOTIFICATION_NO")
	private String notificationNo;

	@Column(name = "NOTIFICATION_DT")
	private LocalDateTime notificationDt;

	@Column(name = "FLOATATION_WAY_ID")
	private Long floatationWayId;

	@Column(name = "LOAN_TYPE_ID")
	private Long loanTypeId;

	@Column(name = "NEW_LOAN_TRANCHE")
	private String newLoanTran;

	@Column(name = "TRANCHE_DESC")
	private String tranDesc;

	@Column(name = "LOAN_TENURE")
	private int loanTenure;

	@Column(name = "LOAN_ROI")
	private Double loanRoi;

	@Column(name = "ISSUE_NUMBER")
	private int issueNumber;

	@Column(name = "MORATORIUM_PERIOD")
	private int moratoriumPeriod;

	@Column(name = "MORATRM_PNCPL_PERC")
	private Double moratrmPncplPerc;

	@Column(name = "TOT_REPAY_INSTALL")
	private int totRepayInstall;

	@Column(name = "REPAY_INSTALL_YR")
	private int repayInstallYr;

	@Column(name = "PNCPL_FIRST_INSTALL_DT")
	private LocalDate pncplFirstInstallDt;

	@Column(name = "INTERST_INSTALL_YR")
	private int interstInstallYr;

	@Column(name = "INTRST_FIRST_INSTALL_DT")
	private LocalDate intrstFirstInstallDt;

	@Column(name = "LOAN_MATURITY_DT")
	private LocalDate loanMaturityDt;

	@Column(name = "LOAN_DELETE_DT")
	private LocalDate loanDeleteDt;

	@Column(name = "LOAN_DELETE_BY")
	private Long loanDeleteBy;

	public List<DMOMarketLoanRePaymentEntity> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<DMOMarketLoanRePaymentEntity> repayments) {
		this.repayments = repayments;
	}

	public DMOMarketLoanEntity(Long goiLoanId) {
		super();
		this.id = goiLoanId;
	}

	public DMOMarketLoanEntity() {
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
	public DMODPSheetEntryEntity getDpSheetId() {
		return dpSheetId;
	}

	/**
	 * @param dpSheetId the dpSheetId to set
	 */
	public void setDpSheetId(DMODPSheetEntryEntity dpSheetId) {
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

	@Override
	public int hashCode() {
		return Objects.hash(adviceBy, adviceDt, adviceNo, dpSheetId, dpSheetRecvDt, floatationWayId, id,
				interstInstallYr, intrstFirstInstallDt, isLoanOlder, issueNumber, loanAmount, loanDeleteBy,
				loanDeleteDt, loanFinYrId, loanMaturityDt, loanNumber, loanReceiptDt, loanRoi, loanStartDt, loanTenure,
				loanTypeId, memoNo, moratoriumPeriod, moratrmPncplPerc, newLoanTran, notificationDt, notificationNo,
				organizationName, pncplFirstInstallDt, premiumAmount, referenceDt, referenceNo, repayInstallYr,
				sanctionOrderDt, sanctionOrderNo, totAmountRecd, totRepayInstall, tranDesc, transactionDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DMOMarketLoanEntity other = (DMOMarketLoanEntity) obj;
		return Objects.equals(adviceBy, other.adviceBy) && Objects.equals(adviceDt, other.adviceDt)
				&& Objects.equals(adviceNo, other.adviceNo) && Objects.equals(dpSheetId, other.dpSheetId)
				&& Objects.equals(dpSheetRecvDt, other.dpSheetRecvDt)
				&& Objects.equals(floatationWayId, other.floatationWayId) && Objects.equals(id, other.id)
				&& interstInstallYr == other.interstInstallYr
				&& Objects.equals(intrstFirstInstallDt, other.intrstFirstInstallDt) && isLoanOlder == other.isLoanOlder
				&& issueNumber == other.issueNumber && Objects.equals(loanAmount, other.loanAmount)
				&& Objects.equals(loanDeleteBy, other.loanDeleteBy) && Objects.equals(loanDeleteDt, other.loanDeleteDt)
				&& Objects.equals(loanFinYrId, other.loanFinYrId)
				&& Objects.equals(loanMaturityDt, other.loanMaturityDt) && Objects.equals(loanNumber, other.loanNumber)
				&& Objects.equals(loanReceiptDt, other.loanReceiptDt) && Objects.equals(loanRoi, other.loanRoi)
				&& Objects.equals(loanStartDt, other.loanStartDt) && loanTenure == other.loanTenure
				&& Objects.equals(loanTypeId, other.loanTypeId) && Objects.equals(memoNo, other.memoNo)
				&& moratoriumPeriod == other.moratoriumPeriod
				&& Objects.equals(moratrmPncplPerc, other.moratrmPncplPerc)
				&& Objects.equals(newLoanTran, other.newLoanTran)
				&& Objects.equals(notificationDt, other.notificationDt)
				&& Objects.equals(notificationNo, other.notificationNo)
				&& Objects.equals(organizationName, other.organizationName)
				&& Objects.equals(pncplFirstInstallDt, other.pncplFirstInstallDt)
				&& Objects.equals(premiumAmount, other.premiumAmount) && Objects.equals(referenceDt, other.referenceDt)
				&& Objects.equals(referenceNo, other.referenceNo) && repayInstallYr == other.repayInstallYr
				&& Objects.equals(sanctionOrderDt, other.sanctionOrderDt)
				&& Objects.equals(sanctionOrderNo, other.sanctionOrderNo)
				&& Objects.equals(totAmountRecd, other.totAmountRecd) && totRepayInstall == other.totRepayInstall
				&& Objects.equals(tranDesc, other.tranDesc) && Objects.equals(transactionDesc, other.transactionDesc);
	}

	
}
