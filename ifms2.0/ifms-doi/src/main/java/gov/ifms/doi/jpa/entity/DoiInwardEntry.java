package gov.ifms.doi.jpa.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;


/**
 * @author Rudra
 *
 */
@Entity
@Table(name="TDOI_INWARD_ENTRY", schema = DoiJPAConstants.DOI_SCHEMA)
public class DoiInwardEntry extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 700733070134174104L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="INWARD_ID")
	private long inwardId;

	private double amount;

	@Column(name="BANK_BRANCH_NAME", length=15)
	private String bankBranchName;

	@Column(name="BANK_NAME", length=15)
	private String bankName;

	@Temporal(TemporalType.DATE)
	@Column(name="CHEQUE_DT")
	private Date chequeDt;

	@Column(name="CHEQUE_NO")
	private long chequeNo;

	@Column(name="CHEQUE_TYPE", length=10)
	private String chequeType;

	@Column(name="DOI_BRANCH_ID")
	private long doiBranchId;

	@Column(name="DOI_EMPLOYEE_ID")
	private long doiEmployeeId;

	@Column(name="DOI_EMPLOYEE_NAME", length=100)
	private String doiEmployeeName;

	@Column(name="FROM_WHERE_DETAILS", length=100)
	private String fromWhereDetails;

	@Temporal(TemporalType.DATE)
	@Column(name="INWARD_DT", nullable=false)
	private Date inwardDt;

	@Column(name="INWARD_NO", nullable=false, length=15)
	private String inwardNo;

	@Column(name="LETTER_DETAILS", length=100)
	private String letterDetails;

	@Temporal(TemporalType.DATE)
	@Column(name="LETTER_DT", nullable=false)
	private Date letterDt;

	@Column(name="LETTER_NO", length=20)
	private String letterNo;

	@Column(name="LETTER_TYPE", length=20)
	private String letterType;

	@Column(name="LETTER_TYPE_ID", nullable=false)
	private long letterTypeId;

	@Column(name="REFERENCE_DT")
	private Timestamp referenceDt;

	@Column(name="REFERENCE_NO", length=30)
	private String referenceNo;
	
	@OneToMany(mappedBy="doiInwardEntry")
	private List<DoiJPAClaimEntryEntity> doiJpaClaimEntries;

	public DoiInwardEntry() {
	}

	/**
	 * @return the inwardId
	 */
	public long getInwardId() {
		return inwardId;
	}
	/**
	 * @param inwardId the inwardId to set
	 */
	public void setInwardId(long inwardId) {
		this.inwardId = inwardId;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the bankBranchName
	 */
	public String getBankBranchName() {
		return bankBranchName;
	}
	/**
	 * @param bankBranchName the bankBranchName to set
	 */
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
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
	 * @return the chequeType
	 */
	public String getChequeType() {
		return chequeType;
	}
	/**
	 * @param chequeType the chequeType to set
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	/**
	 * @return the doiBranchId
	 */
	public long getDoiBranchId() {
		return doiBranchId;
	}
	/**
	 * @param doiBranchId the doiBranchId to set
	 */
	public void setDoiBranchId(long doiBranchId) {
		this.doiBranchId = doiBranchId;
	}
	/**
	 * @return the doiEmployeeId
	 */
	public long getDoiEmployeeId() {
		return doiEmployeeId;
	}
	/**
	 * @param doiEmployeeId the doiEmployeeId to set
	 */
	public void setDoiEmployeeId(long doiEmployeeId) {
		this.doiEmployeeId = doiEmployeeId;
	}
	/**
	 * @return the doiEmployeeName
	 */
	public String getDoiEmployeeName() {
		return doiEmployeeName;
	}
	/**
	 * @param doiEmployeeName the doiEmployeeName to set
	 */
	public void setDoiEmployeeName(String doiEmployeeName) {
		this.doiEmployeeName = doiEmployeeName;
	}
	/**
	 * @return the fromWhereDetails
	 */
	public String getFromWhereDetails() {
		return fromWhereDetails;
	}
	/**
	 * @param fromWhereDetails the fromWhereDetails to set
	 */
	public void setFromWhereDetails(String fromWhereDetails) {
		this.fromWhereDetails = fromWhereDetails;
	}
	/**
	 * @return the inwardDt
	 */
	public Date getInwardDt() {
		return inwardDt;
	}
	/**
	 * @param inwardDt the inwardDt to set
	 */
	public void setInwardDt(Date inwardDt) {
		this.inwardDt = inwardDt;
	}
	/**
	 * @return the inwardNo
	 */
	public String getInwardNo() {
		return inwardNo;
	}
	/**
	 * @param inwardNo the inwardNo to set
	 */
	public void setInwardNo(String inwardNo) {
		this.inwardNo = inwardNo;
	}
	/**
	 * @return the letterDetails
	 */
	public String getLetterDetails() {
		return letterDetails;
	}
	/**
	 * @param letterDetails the letterDetails to set
	 */
	public void setLetterDetails(String letterDetails) {
		this.letterDetails = letterDetails;
	}
	/**
	 * @return the letterDt
	 */
	public Date getLetterDt() {
		return letterDt;
	}
	/**
	 * @param letterDt the letterDt to set
	 */
	public void setLetterDt(Date letterDt) {
		this.letterDt = letterDt;
	}
	/**
	 * @return the letterNo
	 */
	public String getLetterNo() {
		return letterNo;
	}
	/**
	 * @param letterNo the letterNo to set
	 */
	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}
	/**
	 * @return the letterType
	 */
	public String getLetterType() {
		return letterType;
	}
	/**
	 * @param letterType the letterType to set
	 */
	public void setLetterType(String letterType) {
		this.letterType = letterType;
	}
	/**
	 * @return the letterTypeId
	 */
	public long getLetterTypeId() {
		return letterTypeId;
	}
	/**
	 * @param letterTypeId the letterTypeId to set
	 */
	public void setLetterTypeId(long letterTypeId) {
		this.letterTypeId = letterTypeId;
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
	 * @return the doiJpaClaimEntries
	 */
	public List<DoiJPAClaimEntryEntity> getDoiJpaClaimEntries() {
		return doiJpaClaimEntries;
	}
	/**
	 * @param doiJpaClaimEntries the doiJpaClaimEntries to set
	 */
	public void setDoiJpaClaimEntries(List<DoiJPAClaimEntryEntity> doiJpaClaimEntries) {
		this.doiJpaClaimEntries = doiJpaClaimEntries;
	}

}