package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPUserPostDto.
 */
public class EDPUserPostDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	private Long userId;
	
	/** The user code. */
	private Long userCode;
	
	/** The emp id. */
	private Long empId;
	
	/** The name. */
	private String name;

	/** The to user id. */
	private Long toUserId;
	
	/** The to emp id. */
	private Long toEmpId;
	
	/** The to user name. */
	private String toUserName;
	
	/** The post map dto. */
	private List<EDPPostMapDto> postMapDto; // tomapDto

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userCode
	 */
	public Long getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the toUserId
	 */
	public Long getToUserId() {
		return toUserId;
	}

	/**
	 * @param toUserId the toUserId to set
	 */
	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	/**
	 * @return the toEmpId
	 */
	public Long getToEmpId() {
		return toEmpId;
	}

	/**
	 * @param toEmpId the toEmpId to set
	 */
	public void setToEmpId(Long toEmpId) {
		this.toEmpId = toEmpId;
	}

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * Gets the post map dto.
	 *
	 * @return the postMapDto
	 */
	public List<EDPPostMapDto> getPostMapDto() {
		return postMapDto;
	}

	/**
	 * Sets the post map dto.
	 *
	 * @param postMapDto the postMapDto to set
	 */
	public void setPostMapDto(List<EDPPostMapDto> postMapDto) {
		this.postMapDto = postMapDto;
	}

	/**
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
		return Objects.hash(empId, name, postMapDto, toEmpId, toUserId, toUserName, userCode, userId);
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
		if (!(obj instanceof EDPUserPostDto)) {
			return false;
		}
		EDPUserPostDto other = (EDPUserPostDto) obj;
		return Objects.equals(empId, other.empId) && Objects.equals(name, other.name)
				&& Objects.equals(postMapDto, other.postMapDto) && Objects.equals(toEmpId, other.toEmpId)
				&& Objects.equals(toUserId, other.toUserId) && Objects.equals(toUserName, other.toUserName)
				&& Objects.equals(userCode, other.userCode) && Objects.equals(userId, other.userId);
	}

	
}
