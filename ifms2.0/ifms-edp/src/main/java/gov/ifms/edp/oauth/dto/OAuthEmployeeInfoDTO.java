package gov.ifms.edp.oauth.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class OAuthEmployeeInfoDTO.
 */
@NativeQueryResultEntity
public class OAuthEmployeeInfoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/** The mobile no. */
	@NativeQueryResultColumn(index = 0)
	private String mobileNo;
	
	/** The email id. */
	@NativeQueryResultColumn(index = 1)
	private String emailId;
	
	
	/** The pan no. */
	@NativeQueryResultColumn(index = 2)
	private String panNo;

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, mobileNo, panNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OAuthEmployeeInfoDTO)) {
			return false;
		}
		OAuthEmployeeInfoDTO other = (OAuthEmployeeInfoDTO) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(panNo, other.panNo);
	}

	/**
	 * Instantiates a new o auth employee info DTO.
	 *
	 * @param mobileNo the mobile no
	 * @param emailId the email id
	 * @param panNo the pan no
	 */
	public OAuthEmployeeInfoDTO(String mobileNo, String emailId, String panNo) {
		super();
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.panNo = panNo;
	}

	/**
	 * Instantiates a new o auth employee info DTO.
	 */
	public OAuthEmployeeInfoDTO() {
		super();
	}
}
