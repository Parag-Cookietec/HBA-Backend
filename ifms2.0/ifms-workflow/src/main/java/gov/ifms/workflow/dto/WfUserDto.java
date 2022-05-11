package gov.ifms.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class WfUserDto
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class WfUserDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private long userId;

	@NativeQueryResultColumn(index = 1)
	private String userName;

	@NativeQueryResultColumn(index = 2)
	private long postId;

	@NativeQueryResultColumn(index = 3)
	private long officeId;

	@NativeQueryResultColumn(index = 4)
	private long pouId;

	@NativeQueryResultColumn(index = 5)
	private Long branchId;

	@NativeQueryResultColumn(index = 6)
	private Long wfRoleId;

	@NativeQueryResultColumn(index = 7)
	private int level;

	@NativeQueryResultColumn(index = 8)
	private String postName;


	/**
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * @return the pouId
	 */
	public long getPouId() {
		return pouId;
	}

	/**
	 * @param pouId the pouId to set
	 */
	public void setPouId(long pouId) {
		this.pouId = pouId;
	}

	/**
	 * @return the branchId
	 */
	public Long getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public WfUserDto() {
		super();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param postId
	 * @param officeId
	 */
	public WfUserDto(long userId, String userName, long postId, long officeId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.officeId = officeId;
	}

	/**
	 * @param userId
	 * @param userName
	 * @param postId
	 * @param officeId
	 * @param pouId
	 */
	public WfUserDto(long userId, String userName, long postId, long officeId, long pouId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.officeId = officeId;
		this.pouId = pouId;
	}

	public WfUserDto(long userId, String userName, long postId, long officeId, long pouId, Long wfRoleId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.officeId = officeId;
		this.pouId = pouId;
		this.wfRoleId = wfRoleId;
	}

	/**
	 * Instantiates a new wf user dto.
	 *
	 * @param userId the user id
	 * @param userName the user name
	 * @param postId the post id
	 * @param officeId the office id
	 * @param pouId the pou id
	 * @param branchId the branch id
	 * @param wfRoleId the wf role id
	 */
	public WfUserDto(long userId, String userName, long postId, long officeId, long pouId, Long branchId,
					 Long wfRoleId,String postName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.officeId = officeId;
		this.pouId = pouId;
		this.branchId = branchId;
		this.wfRoleId = wfRoleId;
		this.postName =postName;
	}

	public WfUserDto(long userId, String userName, long postId, long officeId, long pouId,
					 Long wfRoleId,String postName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.postId = postId;
		this.officeId = officeId;
		this.pouId = pouId;
		this.wfRoleId = wfRoleId;
		this.postName =postName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfUserDto wfUserDto = (WfUserDto) o;
		return userId == wfUserDto.userId &&
				postId == wfUserDto.postId &&
				officeId == wfUserDto.officeId &&
				pouId == wfUserDto.pouId &&
				level == wfUserDto.level &&
				Objects.equals(userName, wfUserDto.userName) &&
				Objects.equals(branchId, wfUserDto.branchId) &&
				Objects.equals(wfRoleId, wfUserDto.wfRoleId) &&
				Objects.equals(postName, wfUserDto.postName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, postId, officeId, pouId, branchId, wfRoleId, level, postName);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfUserDto.class.getSimpleName() + "[", "]")
				.add("userId=" + userId)
				.add("userName='" + userName + "'")
				.add("postId=" + postId)
				.add("officeId=" + officeId)
				.add("pouId=" + pouId)
				.add("branchId=" + branchId)
				.add("wfRoleId=" + wfRoleId)
				.add("level=" + level)
				.add("postName='" + postName + "'")
				.toString();
	}
}
