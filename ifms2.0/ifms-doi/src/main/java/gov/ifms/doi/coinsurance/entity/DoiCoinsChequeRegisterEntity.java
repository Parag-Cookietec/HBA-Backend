package gov.ifms.doi.coinsurance.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.edp.entity.BaseEntity;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_COINS_CHEQUE_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiCoinsChequeRegisterEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3863630593032154547L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COINS_CHEQUE_ID", unique=true, nullable=false)
	private long coinsChequeId;

	@Column(name="AGENT_COMMISSION")
	private double agentCommission;

	@Column(name="AGENT_REMARKS", length=200)
	private String agentRemarks;

	@Column(name="BANK_ID", nullable=false)
	private long bankId;

	@Column(name="BANK_NAME", length=60)
	private String bankName;

	@Column(name="BRANCH_ID")
	private long branchId;

	@Column(name="BRANCH_NAME", length=60)
	private String branchName;

	@Temporal(TemporalType.DATE)
	@Column(name="CHALLAN_DT")
	private Date challanDt;

	@Column(name="CHALLAN_NO", length=30)
	private String challanNo;

	@Temporal(TemporalType.DATE)
	@Column(name="CHEQUE_DT")
	private Date chequeDt;

	@Column(name="CHEQUE_NO")
	private long chequeNo;

	@Column(name="CHEQUE_STATUS", length=30)
	private String chequeStatus;

	@Column(name="CHEQUE_TYPE_ID")
	private long chequeTypeId;

	@Column(name="DO_BO_PLACE", length=100)
	private String doBoPlace;

	@Column(name="MOBILE_NO")
	private long mobileNo;

	@Column(name="PARTY_NAME", length=60)
	private String partyName;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;

	@Column(name="RISK_TYPE_ID")
	private long riskTypeId;

	@Column(name="TRANS_CHEQUE_AMOUNT")
	private double transChequeAmount;

	@Column(name="TRANSACTION_NO")
	private long transactionNo;

	@Column(name="TRANSACTION_TYPE_ID")
	private long transactionTypeId;

	/**
	 * @return the coinsChequeId
	 */
	public long getCoinsChequeId() {
		return coinsChequeId;
	}

	/**
	 * @param coinsChequeId the coinsChequeId to set
	 */
	public void setCoinsChequeId(long coinsChequeId) {
		this.coinsChequeId = coinsChequeId;
	}

	/**
	 * @return the agentCommission
	 */
	public double getAgentCommission() {
		return agentCommission;
	}

	/**
	 * @param agentCommission the agentCommission to set
	 */
	public void setAgentCommission(double agentCommission) {
		this.agentCommission = agentCommission;
	}

	/**
	 * @return the agentRemarks
	 */
	public String getAgentRemarks() {
		return agentRemarks;
	}

	/**
	 * @param agentRemarks the agentRemarks to set
	 */
	public void setAgentRemarks(String agentRemarks) {
		this.agentRemarks = agentRemarks;
	}

	/**
	 * @return the bankId
	 */
	public long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchId
	 */
	public long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the challanDt
	 */
	public Date getChallanDt() {
		return challanDt;
	}

	/**
	 * @param challanDt the challanDt to set
	 */
	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}

	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	/**
	 * @return the chequeDt
	 */
	public Date getChequeDt() {
		return chequeDt;
	}

	/**
	 * @param chequeDt the chequeDt to set
	 */
	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	/**
	 * @return the chequeNo
	 */
	public long getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @return the chequeStatus
	 */
	public String getChequeStatus() {
		return chequeStatus;
	}

	/**
	 * @param chequeStatus the chequeStatus to set
	 */
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

	/**
	 * @return the chequeTypeId
	 */
	public long getChequeTypeId() {
		return chequeTypeId;
	}

	/**
	 * @param chequeTypeId the chequeTypeId to set
	 */
	public void setChequeTypeId(long chequeTypeId) {
		this.chequeTypeId = chequeTypeId;
	}

	/**
	 * @return the doBoPlace
	 */
	public String getDoBoPlace() {
		return doBoPlace;
	}

	/**
	 * @param doBoPlace the doBoPlace to set
	 */
	public void setDoBoPlace(String doBoPlace) {
		this.doBoPlace = doBoPlace;
	}

	/**
	 * @return the mobileNo
	 */
	public long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * @return the referenceDt
	 */
	public Timestamp getReferenceDt() {
		return referenceDt;
	}

	/**
	 * @param referenceDt the referenceDt to set
	 */
	public void setReferenceDt(Timestamp referenceDt) {
		this.referenceDt = referenceDt;
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
	 * @return the riskTypeId
	 */
	public long getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(long riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the transChequeAmount
	 */
	public double getTransChequeAmount() {
		return transChequeAmount;
	}

	/**
	 * @param transChequeAmount the transChequeAmount to set
	 */
	public void setTransChequeAmount(double transChequeAmount) {
		this.transChequeAmount = transChequeAmount;
	}

	/**
	 * @return the transactionNo
	 */
	public long getTransactionNo() {
		return transactionNo;
	}

	/**
	 * @param transactionNo the transactionNo to set
	 */
	public void setTransactionNo(long transactionNo) {
		this.transactionNo = transactionNo;
	}

	/**
	 * @return the transactionTypeId
	 */
	public long getTransactionTypeId() {
		return transactionTypeId;
	}

	/**
	 * @param transactionTypeId the transactionTypeId to set
	 */
	public void setTransactionTypeId(long transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

}