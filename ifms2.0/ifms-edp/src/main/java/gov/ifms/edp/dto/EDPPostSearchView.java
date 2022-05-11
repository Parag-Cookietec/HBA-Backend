package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPPostSearchView.
 */
@NativeQueryResultEntity
public class EDPPostSearchView extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The request no. */
	@NativeQueryResultColumn(index = 0)
	private String referenceNo;

	/** The district id. */
	@NativeQueryResultColumn(index = 1)
	private Date requestDate;

	/** The district name. */
	@NativeQueryResultColumn(index = 2)
	private String districtName;

	/** The designation name. */
	@NativeQueryResultColumn(index = 3)
	private String ddoNo;

	/** The location name. */
	@NativeQueryResultColumn(index = 4)
	private long cardexNo;

	/** The edp office name. */
	@NativeQueryResultColumn(index = 5)
	private String officeName;

	/** The edp office name. */
	@NativeQueryResultColumn(index = 6)
	private String designationName;

	/** The post id. */
	@NativeQueryResultColumn(index = 7)
	private String postName;

	/** The status. */
	@NativeQueryResultColumn(index = 8)
	private String postId;

	/** The status id. */
	@NativeQueryResultColumn(index = 9)
	private int statusId;

	/** The total count. */
	@NativeQueryResultColumn(index = 10)
	private int totalCount;

	/** The lying with. */
	@NativeQueryResultColumn(index = 11)
	private String lyingWith;

	/** The assign to user id. */
	@NativeQueryResultColumn(index = 12)
	private String assignToUserId;

	/** The assign to user id. */
	@NativeQueryResultColumn(index = 13)
	private String wfStatus;

	/** The wf status. */
	@NativeQueryResultColumn(index = 14)
	private String trnStatus;

	/** The is editable. */
	@NativeQueryResultColumn(index = 15)
	private int isEditable;

	/**
	 * Gets the reference no.
	 *
	 * @return the reference no
	 */
	public String getReferenceNo() {
		return referenceNo;
	}

	/**
	 * Sets the reference no.
	 *
	 * @param referenceNo the new reference no
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	/**
	 * Gets the request date.
	 *
	 * @return the request date
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * Sets the request date.
	 *
	 * @param requestDate the new request date
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designation name
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the new designation name
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the post name.
	 *
	 * @return the post name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * Sets the post name.
	 *
	 * @param postName the new post name
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}

	/**
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the total count.
	 *
	 * @return the total count
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount the new total count
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * Gets the lying with.
	 *
	 * @return the lying with
	 */
	public String getLyingWith() {
		return lyingWith;
	}

	/**
	 * Sets the lying with.
	 *
	 * @param lyingWith the new lying with
	 */
	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

	/**
	 * Gets the assign to user id.
	 *
	 * @return the assign to user id
	 */
	public String getAssignToUserId() {
		return assignToUserId;
	}

	/**
	 * Sets the assign to user id.
	 *
	 * @param assignToUserId the new assign to user id
	 */
	public void setAssignToUserId(String assignToUserId) {
		this.assignToUserId = assignToUserId;
	}

	/**
	 * Gets the trn status.
	 *
	 * @return the trn status
	 */
	public String getTrnStatus() {
		return trnStatus;
	}

	/**
	 * Sets the trn status.
	 *
	 * @param trnStatus the new trn status
	 */
	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	/**
	 * Gets the wf status.
	 *
	 * @return the wf status
	 */
	public String getWfStatus() {
		return wfStatus;
	}

	/**
	 * Sets the wf status.
	 *
	 * @param wfStatus the new wf status
	 */
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	/**
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public int getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
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
		result = prime * result + Objects.hash(assignToUserId, cardexNo, ddoNo, designationName, districtName,
				isEditable, lyingWith, officeName, postId, postName, referenceNo, requestDate, statusId, totalCount,
				trnStatus, wfStatus);
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
		if (!(obj instanceof EDPPostSearchView)) {
			return false;
		}
		EDPPostSearchView other = (EDPPostSearchView) obj;
		return Objects.equals(assignToUserId, other.assignToUserId) && cardexNo == other.cardexNo
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(designationName, other.designationName)
				&& Objects.equals(districtName, other.districtName) && isEditable == other.isEditable
				&& Objects.equals(lyingWith, other.lyingWith) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& Objects.equals(referenceNo, other.referenceNo) && Objects.equals(requestDate, other.requestDate)
				&& statusId == other.statusId && totalCount == other.totalCount
				&& Objects.equals(trnStatus, other.trnStatus) && Objects.equals(wfStatus, other.wfStatus);
	}
	
}