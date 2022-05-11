package gov.ifms.doi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the MDOI_DB_PARTY_BANK_DTL database table.
 * 
 */
@Entity
@Table(name = "MDOI_DB_PARTY_BANK_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "MdoiDbPartyBankDtlEntity.findAll", query = "SELECT m FROM MdoiDbPartyBankDtlEntity m")
public class MdoiDbPartyBankDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_PARTY_BANK_ID", unique = true, nullable = false)
	private long dbPartyBankId;

	@Column(name = "ACCOUNT_NO", length = 20)
	private String accountNo;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_IFSC_CODE", length = 20)
	private String bankIfscCode;

	@Column(name = "BANK_NAME", length = 30)
	private String bankName;

	@Column(name = "BRANCH_CODE", length = 20)
	private String branchCode;

	@Column(name = "BRANCH_ID")
	private long branchId;

	@Column(name = "BRANCH_NAME", length = 60)
	private String branchName;

	@Column(name = "BRANCH_TYPE_ID")
	private long branchTypeId;

	@Column(name = "PREF_PAYMENT_TYPE", length = 20)
	private String prefPaymentType;

	// bi-directional many-to-one association to MdoiDbPartyMst
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "DB_PARTY_ID", nullable = false)
	private MdoiDbPartyMstEntity mdoiDbPartyMst;

	public MdoiDbPartyBankDtlEntity() {
	}

	public long getDbPartyBankId() {
		return this.dbPartyBankId;
	}

	public void setDbPartyBankId(long dbPartyBankId) {
		this.dbPartyBankId = dbPartyBankId;
	}

	public String getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public long getBankId() {
		return this.bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankIfscCode() {
		return this.bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public long getBranchTypeId() {
		return this.branchTypeId;
	}

	public void setBranchTypeId(long branchTypeId) {
		this.branchTypeId = branchTypeId;
	}

	public String getPrefPaymentType() {
		return this.prefPaymentType;
	}

	public void setPrefPaymentType(String prefPaymentType) {
		this.prefPaymentType = prefPaymentType;
	}

	public MdoiDbPartyMstEntity getMdoiDbPartyMst() {
		return this.mdoiDbPartyMst;
	}

	public void setMdoiDbPartyMst(MdoiDbPartyMstEntity mdoiDbPartyMst) {
		this.mdoiDbPartyMst = mdoiDbPartyMst;
	}

}