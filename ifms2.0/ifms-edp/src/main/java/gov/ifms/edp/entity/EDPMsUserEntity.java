package gov.ifms.edp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

/**
 * The Class EDPMsUserEntity.
 */
@Entity
@Table(name = "MS_USER", schema = Constant.EDP_MASTER_SCHEMA)
public class EDPMsUserEntity extends BaseEntity implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;

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
	@Column(name="USER_CODE")
	private Long userCode;
	
	/** The user code guj. */
	@Column(name="USER_CODE_GUJ")
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
	
	
	/** The is pass reset. */
	@Column(name = "IS_PASS_RESET")
	private int isPassReset;
	
	/**
	 * Instantiates a new EDP ms user entity.
	 */
	public EDPMsUserEntity() {
	}
	
	/**
	 * Instantiates a new EDP ms user entity.
	 *
	 * @param userId the user id
	 */
	public EDPMsUserEntity(long userId) {
		super();
		this.userId = userId;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Gets the parent user id.
	 *
	 * @return the parent user id
	 */
	public long getParentUserId() {
		return parentUserId;
	}

	/**
	 * Sets the parent user id.
	 *
	 * @param parentUserId the new parent user id
	 */
	public void setParentUserId(long parentUserId) {
		this.parentUserId = parentUserId;
	}

	/**
	 * Gets the first login.
	 *
	 * @return the first login
	 */
	public int getFirstLogin() {
		return firstLogin;
	}

	/**
	 * Sets the first login.
	 *
	 * @param firstLogin the new first login
	 */
	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}

	/**
	 * Gets the invalid login cnt.
	 *
	 * @return the invalid login cnt
	 */
	public int getInvalidLoginCnt() {
		return invalidLoginCnt;
	}

	/**
	 * Sets the invalid login cnt.
	 *
	 * @param invalidLoginCnt the new invalid login cnt
	 */
	public void setInvalidLoginCnt(int invalidLoginCnt) {
		this.invalidLoginCnt = invalidLoginCnt;
	}

	/**
	 * Gets the always login.
	 *
	 * @return the always login
	 */
	public int getAlwaysLogin() {
		return alwaysLogin;
	}

	/**
	 * Sets the always login.
	 *
	 * @param alwaysLogin the new always login
	 */
	public void setAlwaysLogin(int alwaysLogin) {
		this.alwaysLogin = alwaysLogin;
	}

	/**
	 * Gets the pwd changed date.
	 *
	 * @return the pwd changed date
	 */
	public Date getPwdChangedDate() {
		return pwdChangedDate;
	}

	/**
	 * Sets the pwd changed date.
	 *
	 * @param pwdChangedDate the new pwd changed date
	 */
	public void setPwdChangedDate(Date pwdChangedDate) {
		this.pwdChangedDate = pwdChangedDate;
	}

	/**
	 * Gets the unlock time.
	 *
	 * @return the unlock time
	 */
	public Date getUnlockTime() {
		return unlockTime;
	}

	/**
	 * Sets the unlock time.
	 *
	 * @param unlockTime the new unlock time
	 */
	public void setUnlockTime(Date unlockTime) {
		this.unlockTime = unlockTime;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the user name guj.
	 *
	 * @return the user name guj
	 */
	public String getUserNameGuj() {
		return userNameGuj;
	}

	/**
	 * Sets the user name guj.
	 *
	 * @param userNameGuj the new user name guj
	 */
	public void setUserNameGuj(String userNameGuj) {
		this.userNameGuj = userNameGuj;
	}

	/**
	 * Gets the user description.
	 *
	 * @return the user description
	 */
	public String getUserDescription() {
		return userDescription;
	}

	/**
	 * Sets the user description.
	 *
	 * @param userDescription the new user description
	 */
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	/**
	 * Gets the user description guj.
	 *
	 * @return the user description guj
	 */
	public String getUserDescriptionGuj() {
		return userDescriptionGuj;
	}

	/**
	 * Sets the user description guj.
	 *
	 * @param userDescriptionGuj the new user description guj
	 */
	public void setUserDescriptionGuj(String userDescriptionGuj) {
		this.userDescriptionGuj = userDescriptionGuj;
	}

	
	
	
	/**
	 * Gets the user code.
	 *
	 * @return the user code
	 */
	public Long getUserCode() {
		return userCode;
	}

	/**
	 * Sets the user code.
	 *
	 * @param userCode the new user code
	 */
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}
	
	/**
	 * Gets the user code guj.
	 *
	 * @return the user code guj
	 */
	public String getUserCodeGuj() {
		return userCodeGuj;
	}

	/**
	 * Sets the user code guj.
	 *
	 * @param userCodeGuj the new user code guj
	 */
	public void setUserCodeGuj(String userCodeGuj) {
		this.userCodeGuj = userCodeGuj;
	}

	/**
	 * Gets the secret que code.
	 *
	 * @return the secret que code
	 */
	public String getSecretQueCode() {
		return secretQueCode;
	}

	/**
	 * Sets the secret que code.
	 *
	 * @param secretQueCode the new secret que code
	 */
	public void setSecretQueCode(String secretQueCode) {
		this.secretQueCode = secretQueCode;
	}

	/**
	 * Gets the secret que code guj.
	 *
	 * @return the secret que code guj
	 */
	public String getSecretQueCodeGuj() {
		return secretQueCodeGuj;
	}

	/**
	 * Sets the secret que code guj.
	 *
	 * @param secretQueCodeGuj the new secret que code guj
	 */
	public void setSecretQueCodeGuj(String secretQueCodeGuj) {
		this.secretQueCodeGuj = secretQueCodeGuj;
	}

	/**
	 * Gets the secret answer.
	 *
	 * @return the secret answer
	 */
	public String getSecretAnswer() {
		return secretAnswer;
	}

	/**
	 * Sets the secret answer.
	 *
	 * @param secretAnswer the new secret answer
	 */
	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	/**
	 * Gets the secret answer guj.
	 *
	 * @return the secret answer guj
	 */
	public String getSecretAnswerGuj() {
		return secretAnswerGuj;
	}

	/**
	 * Sets the secret answer guj.
	 *
	 * @param secretAnswerGuj the new secret answer guj
	 */
	public void setSecretAnswerGuj(String secretAnswerGuj) {
		this.secretAnswerGuj = secretAnswerGuj;
	}

	/**
	 * Gets the secret que other.
	 *
	 * @return the secret que other
	 */
	public String getSecretQueOther() {
		return secretQueOther;
	}

	/**
	 * Sets the secret que other.
	 *
	 * @param secretQueOther the new secret que other
	 */
	public void setSecretQueOther(String secretQueOther) {
		this.secretQueOther = secretQueOther;
	}

	/**
	 * Gets the secret que other guj.
	 *
	 * @return the secret que other guj
	 */
	public String getSecretQueOtherGuj() {
		return secretQueOtherGuj;
	}

	/**
	 * Sets the secret que other guj.
	 *
	 * @param secretQueOtherGuj the new secret que other guj
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
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the checks if is pass reset.
	 *
	 * @return the isPassReset
	 */
	public int getIsPassReset() {
		return isPassReset;
	}
	
	/**
	 * Sets the checks if is pass reset.
	 *
	 * @param isPassReset the isPassReset to set
	 */
	public void setIsPassReset(int isPassReset) {
		this.isPassReset = isPassReset;
	}
	
	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(alwaysLogin, firstLogin, invalidLoginCnt, parentUserId, password, pwdChangedDate,
				secretAnswer, secretAnswerGuj, secretQueCode, secretQueCodeGuj, secretQueOther, secretQueOtherGuj,
				unlockTime, userCode, userCodeGuj, userDescription, userDescriptionGuj, userId, userName, userNameGuj);
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
		if (!(obj instanceof EDPMsUserEntity)) {
			return false;
		}
		EDPMsUserEntity other = (EDPMsUserEntity) obj;
		return alwaysLogin == other.alwaysLogin && firstLogin == other.firstLogin
				&& invalidLoginCnt == other.invalidLoginCnt && parentUserId == other.parentUserId
				&& Objects.equals(password, other.password) && Objects.equals(pwdChangedDate, other.pwdChangedDate)
				&& Objects.equals(secretAnswer, other.secretAnswer)
				&& Objects.equals(secretAnswerGuj, other.secretAnswerGuj)
				&& Objects.equals(secretQueCode, other.secretQueCode)
				&& Objects.equals(secretQueCodeGuj, other.secretQueCodeGuj)
				&& Objects.equals(secretQueOther, other.secretQueOther)
				&& Objects.equals(secretQueOtherGuj, other.secretQueOtherGuj)
				&& Objects.equals(unlockTime, other.unlockTime) && Objects.equals(userCode, other.userCode)
				&& Objects.equals(userCodeGuj, other.userCodeGuj)
				&& Objects.equals(userDescription, other.userDescription)
				&& Objects.equals(userDescriptionGuj, other.userDescriptionGuj) && userId == other.userId
				&& Objects.equals(userName, other.userName) && Objects.equals(userNameGuj, other.userNameGuj);
	}

}
