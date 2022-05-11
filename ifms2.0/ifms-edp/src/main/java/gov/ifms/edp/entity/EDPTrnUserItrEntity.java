package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPTrnUserItrEntity.
 */
@Entity
@Table(name = "T_MS_USER_ITR", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPTrnUserItrEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user itr id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_USER_ITR_ID")
	private long userItrId;

	/** The user id. */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "USER_ID")
	private EDPMsUserEntity userId;

	/** The parent user id. */
	@Column(name = "PARENT_USER_ID")
	private long parentUserId;

	/** The first login. */
	@Column(name = "FIRST_LOGIN")
	private int firstLogin;

	/** The invalid login cnt. */
	@Column(name = "INVALID_LOGIN_CNT")
	private int invalidLoginCnt;

	/** The always login. */
	@Column(name = "ALWAYS_LOGIN")
	private int alwaysLogin;

	/** The pwd changed date. */
	@Column(name = "PWDCHANGED_DATE")
	private Date pwdChangedDate;

	/** The unlock time. */
	@Column(name = "UNLOCK_TIME")
	private Date unlockTime;

	/** The user name. */
	@Column(name = "USER_NAME")
	private String userName;

	/** The user name guj. */
	@Column(name = "USER_NAME_GUJ")
	private String userNameGuj;

	/** The user description. */
	@Column(name = "USER_DESC")
	private String userDescription;

	/** The user description guj. */
	@Column(name = "USER_DESC_GUJ")
	private String userDescriptionGuj;

	/** The user code. */
	@Column(name = "USER_CODE")
	private String userCode;

	/** The user code guj. */
	@Column(name = "USER_CODE_GUJ")
	private String userCodeGuj;

	/** The secret que code. */
	@Column(name = "SECRET_QUE_CODE")
	private String secretQueCode;

	/** The secret que code guj. */
	@Column(name = "SECRET_QUE_CODE_GUJ")
	private String secretQueCodeGuj;

	/** The secret answer. */
	@Column(name = "SECRET_ANSWER")
	private String secretAnswer;

	/** The secret answer guj. */
	@Column(name = "SECRET_ANSWER_GUJ")
	private String secretAnswerGuj;

	/** The secret que other. */
	@Column(name = "SECRET_QUE_OTHER")
	private String secretQueOther;

	/** The secret que other guj. */
	@Column(name = "SECRET_QUE_OTHER_GUJ")
	private String secretQueOtherGuj;

	/** The password. */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * Gets the user itr id.
	 *
	 * @return the userItrId
	 */
	public long getUserItrId() {
		return userItrId;
	}

	/**
	 * Sets the user itr id.
	 *
	 * @param userItrId the userItrId to set
	 */
	public void setUserItrId(long userItrId) {
		this.userItrId = userItrId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the userId
	 */
	public EDPMsUserEntity getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the userId to set
	 */
	public void setUserId(EDPMsUserEntity userId) {
		this.userId = userId;
	}

	/**
	 * Gets the parent user id.
	 *
	 * @return the parentUserId
	 */
	public long getParentUserId() {
		return parentUserId;
	}

	/**
	 * Sets the parent user id.
	 *
	 * @param parentUserId the parentUserId to set
	 */
	public void setParentUserId(long parentUserId) {
		this.parentUserId = parentUserId;
	}

	/**
	 * Gets the first login.
	 *
	 * @return the firstLogin
	 */
	public int getFirstLogin() {
		return firstLogin;
	}

	/**
	 * Sets the first login.
	 *
	 * @param firstLogin the firstLogin to set
	 */
	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}

	/**
	 * Gets the invalid login cnt.
	 *
	 * @return the invalidLoginCnt
	 */
	public int getInvalidLoginCnt() {
		return invalidLoginCnt;
	}

	/**
	 * Sets the invalid login cnt.
	 *
	 * @param invalidLoginCnt the invalidLoginCnt to set
	 */
	public void setInvalidLoginCnt(int invalidLoginCnt) {
		this.invalidLoginCnt = invalidLoginCnt;
	}

	/**
	 * Gets the always login.
	 *
	 * @return the alwaysLogin
	 */
	public int getAlwaysLogin() {
		return alwaysLogin;
	}

	/**
	 * Sets the always login.
	 *
	 * @param alwaysLogin the alwaysLogin to set
	 */
	public void setAlwaysLogin(int alwaysLogin) {
		this.alwaysLogin = alwaysLogin;
	}

	/**
	 * Gets the pwd changed date.
	 *
	 * @return the pwdChangedDate
	 */
	public Date getPwdChangedDate() {
		return pwdChangedDate;
	}

	/**
	 * Sets the pwd changed date.
	 *
	 * @param pwdChangedDate the pwdChangedDate to set
	 */
	public void setPwdChangedDate(Date pwdChangedDate) {
		this.pwdChangedDate = pwdChangedDate;
	}

	/**
	 * Gets the unlock time.
	 *
	 * @return the unlockTime
	 */
	public Date getUnlockTime() {
		return unlockTime;
	}

	/**
	 * Sets the unlock time.
	 *
	 * @param unlockTime the unlockTime to set
	 */
	public void setUnlockTime(Date unlockTime) {
		this.unlockTime = unlockTime;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the user name guj.
	 *
	 * @return the userNameGuj
	 */
	public String getUserNameGuj() {
		return userNameGuj;
	}

	/**
	 * Sets the user name guj.
	 *
	 * @param userNameGuj the userNameGuj to set
	 */
	public void setUserNameGuj(String userNameGuj) {
		this.userNameGuj = userNameGuj;
	}

	/**
	 * Gets the user description.
	 *
	 * @return the userDescription
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * Sets the user description.
	 *
	 * @param userDescription the userDescription to set
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	/**
	 * Gets the user description guj.
	 *
	 * @return the userDescriptionGuj
	 */
	public String getUserDescriptionGuj() {
		return userDescriptionGuj;
	}

	/**
	 * Sets the user description guj.
	 *
	 * @param userDescriptionGuj the userDescriptionGuj to set
	 */
	public void setUserDescriptionGuj(String userDescriptionGuj) {
		this.userDescriptionGuj = userDescriptionGuj;
	}

	/**
	 * Gets the user code.
	 *
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * Gets the user code guj.
	 *
	 * @return the userCodeGuj
	 */
	public String getUserCodeGuj() {
		return userCodeGuj;
	}

	/**
	 * Sets the user code guj.
	 *
	 * @param userCodeGuj the userCodeGuj to set
	 */
	public void setUserCodeGuj(String userCodeGuj) {
		this.userCodeGuj = userCodeGuj;
	}

	/**
	 * Gets the secret que code.
	 *
	 * @return the secretQueCode
	 */
	public String getSecretQueCode() {
		return secretQueCode;
	}

	/**
	 * Sets the secret que code.
	 *
	 * @param secretQueCode the secretQueCode to set
	 */
	public void setSecretQueCode(String secretQueCode) {
		this.secretQueCode = secretQueCode;
	}

	/**
	 * Gets the secret que code guj.
	 *
	 * @return the secretQueCodeGuj
	 */
	public String getSecretQueCodeGuj() {
		return secretQueCodeGuj;
	}

	/**
	 * Sets the secret que code guj.
	 *
	 * @param secretQueCodeGuj the secretQueCodeGuj to set
	 */
	public void setSecretQueCodeGuj(String secretQueCodeGuj) {
		this.secretQueCodeGuj = secretQueCodeGuj;
	}

	/**
	 * Gets the secret answer.
	 *
	 * @return the secretAnswer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}

	/**
	 * Sets the secret answer.
	 *
	 * @param secretAnswer the secretAnswer to set
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	/**
	 * Gets the secret answer guj.
	 *
	 * @return the secretAnswerGuj
	 */
	public String getSecretAnswerGuj() {
		return secretAnswerGuj;
	}

	/**
	 * Sets the secret answer guj.
	 *
	 * @param secretAnswerGuj the secretAnswerGuj to set
	 */
	public void setSecretAnswerGuj(String secretAnswerGuj) {
		this.secretAnswerGuj = secretAnswerGuj;
	}

	/**
	 * Gets the secret que other.
	 *
	 * @return the secretQueOther
	 */
	public String getSecretQueOther() {
		return secretQueOther;
	}

	/**
	 * Sets the secret que other.
	 *
	 * @param secretQueOther the secretQueOther to set
	 */
	public void setSecretQueOther(String secretQueOther) {
		this.secretQueOther = secretQueOther;
	}

	/**
	 * Gets the secret que other guj.
	 *
	 * @return the secretQueOtherGuj
	 */
	public String getSecretQueOtherGuj() {
		return secretQueOtherGuj;
	}

	/**
	 * Sets the secret que other guj.
	 *
	 * @param secretQueOtherGuj the secretQueOtherGuj to set
	 */
	public void setSecretQueOtherGuj(String secretQueOtherGuj) {
		this.secretQueOtherGuj = secretQueOtherGuj;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Instantiates a new EDP trn user itr entity.
	 */
	public EDPTrnUserItrEntity() {
		super();
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(alwaysLogin, firstLogin, invalidLoginCnt, parentUserId, password, pwdChangedDate, secretAnswer, secretAnswerGuj,
				secretQueCode, secretQueCodeGuj, secretQueOther, secretQueOtherGuj, unlockTime, userCode, userCodeGuj, userDescription,
				userDescriptionGuj, userId, userItrId, userName, userNameGuj);
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
		if (!(obj instanceof EDPTrnUserItrEntity)) {
			return false;
		}
		EDPTrnUserItrEntity other = (EDPTrnUserItrEntity) obj;
		return alwaysLogin == other.alwaysLogin && firstLogin == other.firstLogin && invalidLoginCnt == other.invalidLoginCnt
				&& parentUserId == other.parentUserId && Objects.equals(password, other.password)
				&& Objects.equals(pwdChangedDate, other.pwdChangedDate) && Objects.equals(secretAnswer, other.secretAnswer)
				&& Objects.equals(secretAnswerGuj, other.secretAnswerGuj) && Objects.equals(secretQueCode, other.secretQueCode)
				&& Objects.equals(secretQueCodeGuj, other.secretQueCodeGuj) && Objects.equals(secretQueOther, other.secretQueOther)
				&& Objects.equals(secretQueOtherGuj, other.secretQueOtherGuj) && Objects.equals(unlockTime, other.unlockTime)
				&& Objects.equals(userCode, other.userCode) && Objects.equals(userCodeGuj, other.userCodeGuj)
				&& Objects.equals(userDescription, other.userDescription) && Objects.equals(userDescriptionGuj, other.userDescriptionGuj)
				&& Objects.equals(userId, other.userId) && userItrId == other.userItrId && Objects.equals(userName, other.userName)
				&& Objects.equals(userNameGuj, other.userNameGuj);
	}

}
