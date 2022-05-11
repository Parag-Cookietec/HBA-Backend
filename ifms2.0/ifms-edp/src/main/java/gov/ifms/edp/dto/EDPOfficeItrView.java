package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class EDPOfficeItrView.
 */
public class EDPOfficeItrView extends BaseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The request no. */
	private String requestNo;

	/** The district id. */
	private long districtId;

	/** The designation DDO id. */
	private long designationDDOId;

	/** The designation name. */
	private String designationName;

	/** The location name. */
	private String locationName;

	/** The edp office name. */
	private String edpOfficeName;

	/** The edp office name guj. */
	private String edpOfficeNameGuj;

	/** The created date. */
	private Date createdDate;

	/** The request to user id. */
	private long requestToUserId;

	/** The request to user name. */
	private String requestToUserName;

	/** The status. */
	private String status;

	/** The office id. */
	private long officeId;

	/** The cardex no. */
	private long cardexNo;

	/** The ddo no. */
	private String ddoNo;

	/** The cardex no. */
	private long officeTypeId;
	
	private long pouId;
	
	private String wfRoles;
	
	private String wfStatus;
	
	private String ddoTypeId;
	
	private String trnStatus;
	
	private Long isEditable;
	
	private String lyingWith;

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public long getOfficeId() {
		return officeId;
	}

	public String getDdoTypeId() {
		return ddoTypeId;
	}

	public void setDdoTypeId(String ddoTypeId) {
		this.ddoTypeId = ddoTypeId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, createdDate, ddoNo, designationDDOId, designationName, districtId, edpOfficeName,
				edpOfficeNameGuj, locationName, officeId, officeTypeId, requestNo, requestToUserId, requestToUserName,
				status);
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
		if (!(obj instanceof EDPOfficeItrView)) {
			return false;
		}
		EDPOfficeItrView other = (EDPOfficeItrView) obj;
		return cardexNo == other.cardexNo && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(ddoNo, other.ddoNo) && designationDDOId == other.designationDDOId
				&& Objects.equals(designationName, other.designationName) && districtId == other.districtId
				&& Objects.equals(edpOfficeName, other.edpOfficeName)
				&& Objects.equals(edpOfficeNameGuj, other.edpOfficeNameGuj)
				&& Objects.equals(locationName, other.locationName) && officeId == other.officeId
				&& officeTypeId == other.officeTypeId && Objects.equals(requestNo, other.requestNo)
				&& requestToUserId == other.requestToUserId
				&& Objects.equals(requestToUserName, other.requestToUserName) && Objects.equals(status, other.status);
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
	 * Gets the request no.
	 *
	 * @return the request no
	 */
	public String getRequestNo() {
		return requestNo;
	}

	/**
	 * Sets the request no.
	 *
	 * @param requestNo the new request no
	 */
	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	/**
	 * Gets the designation DDO id.
	 *
	 * @return the designation DDO id
	 */
	public long getDesignationDDOId() {
		return designationDDOId;
	}

	/**
	 * Sets the designation DDO id.
	 *
	 * @param designationDDOId the new designation DDO id
	 */
	public void setDesignationDDOId(long designationDDOId) {
		this.designationDDOId = designationDDOId;
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
	 * Gets the location name.
	 *
	 * @return the location name
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * Sets the location name.
	 *
	 * @param locationName the new location name
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * Gets the edp office name.
	 *
	 * @return the edp office name
	 */
	public String getEdpOfficeName() {
		return edpOfficeName;
	}

	/**
	 * Sets the edp office name.
	 *
	 * @param edpOfficeName the new edp office name
	 */
	public void setEdpOfficeName(String edpOfficeName) {
		this.edpOfficeName = edpOfficeName;
	}

	/**
	 * Gets the edp office name guj.
	 *
	 * @return the edp office name guj
	 */
	public String getEdpOfficeNameGuj() {
		return edpOfficeNameGuj;
	}

	/**
	 * Sets the edp office name guj.
	 *
	 * @param edpOfficeNameGuj the new edp office name guj
	 */
	public void setEdpOfficeNameGuj(String edpOfficeNameGuj) {
		this.edpOfficeNameGuj = edpOfficeNameGuj;
	}

	/**
	 * Gets the request to user id.
	 *
	 * @return the request to user id
	 */
	public long getRequestToUserId() {
		return requestToUserId;
	}

	/**
	 * Sets the request to user id.
	 *
	 * @param requestToUserId the new request to user id
	 */
	public void setRequestToUserId(long requestToUserId) {
		this.requestToUserId = requestToUserId;
	}

	/**
	 * Gets the request to user name.
	 *
	 * @return the request to user name
	 */
	public String getRequestToUserName() {
		return requestToUserName;
	}

	/**
	 * Sets the request to user name.
	 *
	 * @param requestToUserName the new request to user name
	 */
	public void setRequestToUserName(String requestToUserName) {
		this.requestToUserName = requestToUserName;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Instantiates a new EDP office itr view.
	 */
	public EDPOfficeItrView() {
		super();
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the office type id.
	 *
	 * @return the officeTypeId
	 */
	public long getOfficeTypeId() {
		return officeTypeId;
	}

	/**
	 * Sets the office type id.
	 *
	 * @param officeTypeId the officeTypeId to set
	 */
	public void setOfficeTypeId(long officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	public long getPouId() {
		return pouId;
	}

	public void setPouId(long pouId) {
		this.pouId = pouId;
	}

	public String getWfRoles() {
		return wfRoles;
	}

	public void setWfRoles(String wfRoles) {
		this.wfRoles = wfRoles;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public Long getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}

	public String getLyingWith() {
		return lyingWith;
	}

	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
	}

}
