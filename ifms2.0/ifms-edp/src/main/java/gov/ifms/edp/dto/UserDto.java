package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;


import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class WfUserDto
 */
@NativeQueryResultEntity
public class UserDto implements Serializable {

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

    private String postName;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

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

    public UserDto() {
        super();
    }

    /**
     * @param userId
     * @param userName
     * @param postId
     * @param officeId
     */
    public UserDto(long userId, String userName, long postId, long officeId) {
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
    public UserDto(long userId, String userName, long postId, long officeId, long pouId) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.postId = postId;
        this.officeId = officeId;
        this.pouId = pouId;
    }

    public UserDto(long userId, String userName, long postId, long officeId, long pouId, Long wfRoleId,String postName) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.postId = postId;
        this.officeId = officeId;
        this.pouId = pouId;
        this.wfRoleId = wfRoleId;
        this.postName = postName;
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
    public UserDto(long userId, String userName, long postId, long officeId, long pouId, Long branchId,
                     Long wfRoleId) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.postId = postId;
        this.officeId = officeId;
        this.pouId = pouId;
        this.branchId = branchId;
        this.wfRoleId = wfRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return userId == userDto.userId &&
                postId == userDto.postId &&
                officeId == userDto.officeId &&
                pouId == userDto.pouId &&
                Objects.equals(userName, userDto.userName) &&
                Objects.equals(branchId, userDto.branchId) &&
                Objects.equals(wfRoleId, userDto.wfRoleId) &&
                Objects.equals(postName, userDto.postName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, postId, officeId, pouId, branchId, wfRoleId, postName);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("userId=" + userId)
                .add("userName='" + userName + "'")
                .add("postId=" + postId)
                .add("officeId=" + officeId)
                .add("pouId=" + pouId)
                .add("branchId=" + branchId)
                .add("wfRoleId=" + wfRoleId)
                .add("postName='" + postName + "'")
                .toString();
    }
}
