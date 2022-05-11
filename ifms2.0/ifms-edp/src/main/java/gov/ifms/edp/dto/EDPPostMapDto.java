package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Class EDPPostMapDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EDPPostMapDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The post id. */
	private long postId;

	/** The post name. */
	private String postName;

	/** The post type. */
	private String postType;

	/** The office name. */
	private String officeName;

	/** The is checked. */
	private boolean isChecked;

	/** The post type id. */
	private Long willBePrimary;

	/** The office id. */
	private long officeId;

	/** The lk po off id. */
	private long lkPoOffId;

	/** The is transfered. */
	private boolean isTransfered;

	/** The user name. */
	private String userName;

	/** The edp usr po trns id. */
	private Long edpUsrPoTrnsId;

	/** The district id. */
	private Long districtId;

	/** The post type id. */
	private Long postTypeId;
	
	/** The is same office. */
	private Boolean isSameOffice;
	
	/** The is primary post. */
	private Boolean isPrimaryPost;

	/**
	 * Gets the edp usr po trns id.
	 *
	 * @return the edpUsrPoTrnsId
	 */
	public Long getEdpUsrPoTrnsId() {
		return edpUsrPoTrnsId;
	}

	/**
	 * Sets the edp usr po trns id.
	 *
	 * @param edpUsrPoTrnsId the edpUsrPoTrnsId to set
	 */
	public void setEdpUsrPoTrnsId(Long edpUsrPoTrnsId) {
		this.edpUsrPoTrnsId = edpUsrPoTrnsId;
	}

	/**
	 * Checks if is transfered.
	 *
	 * @return the isTransfered
	 */
	public boolean isTransfered() {
		return isTransfered;
	}

	/**
	 * Sets the transfered.
	 *
	 * @param isTransfered the isTransfered to set
	 */
	public void setTransfered(boolean isTransfered) {
		this.isTransfered = isTransfered;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the postName
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the postName to set
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the post type.
	 *
	 * @return the postType
	 */
	public String getPostType() {
		return postType;
	}

	/**
	 * Sets the post type.
	 *
	 * @param postType the postType to set
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Checks if is checked.
	 *
	 * @return the isChecked
	 */
	public boolean isChecked() {
		return isChecked;
	}

	/**
	 * Sets the checked.
	 *
	 * @param isChecked the isChecked to set
	 */
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the lk po off id.
	 *
	 * @return the lkPoOffId
	 */
	public long getLkPoOffId() {
		return lkPoOffId;
	}

	/**
	 * Sets the lk po off id.
	 *
	 * @param lkPoOffId the lkPoOffId to set
	 */
	public void setLkPoOffId(long lkPoOffId) {
		this.lkPoOffId = lkPoOffId;
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
	 * Gets the will be primary.
	 *
	 * @return the willBePrimary
	 */
	public Long getWillBePrimary() {
		return willBePrimary;
	}

	/**
	 * Sets the will be primary.
	 *
	 * @param willBePrimary the willBePrimary to set
	 */
	public void setWillBePrimary(Long willBePrimary) {
		this.willBePrimary = willBePrimary;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(districtId, edpUsrPoTrnsId, isChecked, isTransfered, lkPoOffId, officeId, officeName,
				postId, postName, postType, postTypeId, userName, willBePrimary);
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
		if (!(obj instanceof EDPPostMapDto)) {
			return false;
		}
		EDPPostMapDto other = (EDPPostMapDto) obj;
		return Objects.equals(districtId, other.districtId) && Objects.equals(edpUsrPoTrnsId, other.edpUsrPoTrnsId)
				&& isChecked == other.isChecked && isTransfered == other.isTransfered && lkPoOffId == other.lkPoOffId
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName) && postId == other.postId
				&& Objects.equals(postName, other.postName) && Objects.equals(postType, other.postType)
				&& Objects.equals(postTypeId, other.postTypeId) && Objects.equals(userName, other.userName)
				&& Objects.equals(willBePrimary, other.willBePrimary);
	}

	/**
	 * Gets the district id.
	 *
	 * @return the districtId
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the districtId to set
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the post type id.
	 *
	 * @return the postTypeId
	 */
	public Long getPostTypeId() {
		return postTypeId;
	}

	/**
	 * Sets the post type id.
	 *
	 * @param postTypeId the postTypeId to set
	 */
	public void setPostTypeId(Long postTypeId) {
		this.postTypeId = postTypeId;
	}

	/**
	 * Gets the checks if is same office.
	 *
	 * @return the checks if is same office
	 */
	public Boolean getIsSameOffice() {
		return isSameOffice;
	}

	/**
	 * Sets the checks if is same office.
	 *
	 * @param isSameOffice the new checks if is same office
	 */
	public void setIsSameOffice(Boolean isSameOffice) {
		this.isSameOffice = isSameOffice;
	}

	public Boolean getIsPrimaryPost() {
		return isPrimaryPost;
	}

	public void setIsPrimaryPost(Boolean isPrimaryPost) {
		this.isPrimaryPost = isPrimaryPost;
	}

}