package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the MDOI_DB_PARTY_BANK_DTL database table.
 * 
 */

public class MdoiDbPartyBankDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbPartyBankId;

	private String accountNo;

	private long bankId;

	private String bankIfscCode;

	private String bankName;

	private String branchCode;

	private long branchId;

	private String branchName;

	private long branchTypeId;

	private String prefPaymentType;

	// bi-directional many-to-one association to MdoiDbPartyMst

	private MdoiDbPartyMstDTO mdoiDbPartyMst;

	public MdoiDbPartyBankDtlDTO() {
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

	public MdoiDbPartyMstDTO getMdoiDbPartyMst() {
		return this.mdoiDbPartyMst;
	}

	public void setMdoiDbPartyMst(MdoiDbPartyMstDTO mdoiDbPartyMst) {
		this.mdoiDbPartyMst = mdoiDbPartyMst;
	}

}
