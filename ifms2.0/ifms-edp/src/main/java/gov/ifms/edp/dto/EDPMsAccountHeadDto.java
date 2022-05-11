package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPMsAccountHeadDto.
 * 
 * @version 1.0
 * @created 2019/08/31 12:54:53
 *
 */
public class EDPMsAccountHeadDto extends BaseDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The account id. */
	private long accountId;

	/** The account name. */
	private String accountName;

	/** The account name guj. */
	private String accountNameGuj;

	/** The account desc. */
	private String accountDesc;

	/** The account desc guj. */
	private String accountDescGuj;

	/** The account code. */
	private String accountCode;

	/** The account code guj. */
	private String accountCodeGuj;

	/** The account code name. */
	private String accountCodeName;

	/** The account type id. */
	private long accountTypeId;

	/** The parent account id. */
	private long parentAccountId;

	/**
	 * Gets the account id.
	 *
	 * @return the accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * Sets the account id.
	 *
	 * @param accountId the accountId to set
	 */
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	/**
	 * Gets the account name.
	 *
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Sets the account name.
	 *
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * Gets the account name guj.
	 *
	 * @return the accountNameGuj
	 */
	public String getAccountNameGuj() {
		return accountNameGuj;
	}

	/**
	 * Sets the account name guj.
	 *
	 * @param accountNameGuj the accountNameGuj to set
	 */
	public void setAccountNameGuj(String accountNameGuj) {
		this.accountNameGuj = accountNameGuj;
	}

	/**
	 * Gets the account desc.
	 *
	 * @return the accountDesc
	 */
	public String getAccountDesc() {
		return accountDesc;
	}

	/**
	 * Sets the account desc.
	 *
	 * @param accountDesc the accountDesc to set
	 */
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}

	/**
	 * Gets the account desc guj.
	 *
	 * @return the accountDescGuj
	 */
	public String getAccountDescGuj() {
		return accountDescGuj;
	}

	/**
	 * Sets the account desc guj.
	 *
	 * @param accountDescGuj the accountDescGuj to set
	 */
	public void setAccountDescGuj(String accountDescGuj) {
		this.accountDescGuj = accountDescGuj;
	}

	/**
	 * Gets the account code.
	 *
	 * @return the accountCode
	 */
	public String getAccountCode() {
		return accountCode;
	}

	/**
	 * Sets the account code.
	 *
	 * @param accountCode the accountCode to set
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	/**
	 * Gets the account code guj.
	 *
	 * @return the accountCodeGuj
	 */
	public String getAccountCodeGuj() {
		return accountCodeGuj;
	}

	/**
	 * Sets the account code guj.
	 *
	 * @param accountCodeGuj the accountCodeGuj to set
	 */
	public void setAccountCodeGuj(String accountCodeGuj) {
		this.accountCodeGuj = accountCodeGuj;
	}

	/**
	 * Gets the account code name.
	 *
	 * @return the accountCodeName
	 */
	public String getAccountCodeName() {
		return accountCodeName;
	}

	/**
	 * Sets the account code name.
	 *
	 * @param accountCodeName the accountCodeName to set
	 */
	public void setAccountCodeName(String accountCodeName) {
		this.accountCodeName = accountCodeName;
	}

	/**
	 * Gets the account type id.
	 *
	 * @return the accountTypeId
	 */
	public long getAccountTypeId() {
		return accountTypeId;
	}

	/**
	 * Sets the account type id.
	 *
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	/**
	 * Gets the parent account id.
	 *
	 * @return the parentAccountId
	 */
	public long getParentAccountId() {
		return parentAccountId;
	}

	/**
	 * Sets the parent account id.
	 *
	 * @param parentAccountId the parentAccountId to set
	 */
	public void setParentAccountId(long parentAccountId) {
		this.parentAccountId = parentAccountId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(accountCode, accountCodeGuj, accountCodeName, accountDesc,
				accountDescGuj, accountId, accountName, accountNameGuj, accountTypeId, parentAccountId);
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EDPMsAccountHeadDto)) {
			return false;
		}
		EDPMsAccountHeadDto other = (EDPMsAccountHeadDto) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(accountCodeGuj, other.accountCodeGuj)
				&& Objects.equals(accountCodeName, other.accountCodeName)
				&& Objects.equals(accountDesc, other.accountDesc)
				&& Objects.equals(accountDescGuj, other.accountDescGuj) && accountId == other.accountId
				&& Objects.equals(accountName, other.accountName)
				&& Objects.equals(accountNameGuj, other.accountNameGuj) && accountTypeId == other.accountTypeId
				&& parentAccountId == other.parentAccountId;
	}

}
