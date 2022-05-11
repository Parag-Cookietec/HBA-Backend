package gov.ifms.edp.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

/**
 * The Class EDPMsAccountHeadEntity.
 * 
 * @version 1.0
 * @created 2019/08/31 12:54:53
 *
 */
@Entity
@Table(name = "MS_ACCOUNTHEAD")
public class EDPMsAccountHeadEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The account id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private long accountId;

	/** The account name. */
	@Column(name = "ACCOUNT_NAME")
	private String accountName;

	/** The account name guj. */
	@Column(name = "ACCOUNT_NAME_GUJ")
	private String accountNameGuj;

	/** The account desc. */
	@Column(name = "ACCOUNT_DESC")
	private String accountDesc;

	/** The account desc guj. */
	@Column(name = "ACCOUNT_DESC_GUJ")
	private String accountDescGuj;

	/** The account code. */
	@Column(name = "ACCOUNT_CODE")
	private String accountCode;

	/** The account code guj. */
	@Column(name = "ACCOUNT_CODE_GUJ")
	private String accountCodeGuj;

	/** The account code name. */
	@Column(name = "ACCOUNT_CODE_NAME")
	private String accountCodeName;

	/** The account type id. */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ACCOUNT_TYPE_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity accountTypeId;

	/** The parent account id. */
	@Column(name = "PARENT_ACCOUNT_ID")
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
	public EDPLuLookUpInfoEntity getAccountTypeId() {
		return accountTypeId;
	}

	/**
	 * Sets the account type id.
	 *
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(EDPLuLookUpInfoEntity accountTypeId) {
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
	 * Instantiates a new EDP ms account head entity.
	 */
	public EDPMsAccountHeadEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(accountCode, accountCodeGuj, accountCodeName, accountDesc, accountDescGuj, accountId,
				accountName, accountNameGuj, accountTypeId, parentAccountId);
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPMsAccountHeadEntity)) {
			return false;
		}
		EDPMsAccountHeadEntity other = (EDPMsAccountHeadEntity) obj;
		return Objects.equals(accountCode, other.accountCode) && Objects.equals(accountCodeGuj, other.accountCodeGuj)
				&& Objects.equals(accountCodeName, other.accountCodeName)
				&& Objects.equals(accountDesc, other.accountDesc)
				&& Objects.equals(accountDescGuj, other.accountDescGuj) && accountId == other.accountId
				&& Objects.equals(accountName, other.accountName)
				&& Objects.equals(accountNameGuj, other.accountNameGuj)
				&& Objects.equals(accountTypeId, other.accountTypeId) && parentAccountId == other.parentAccountId;
	}

}
