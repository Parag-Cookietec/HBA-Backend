package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class EDPTrnUpdDsgnItrDto.
 */
public class EDPTrnUpdDsgnItrDto extends BaseDto implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The tedp upd dsgn itr id. */
	private Long tedpUpdDsgnItrId;
	
	/** The tedp upd dsgn id. */
	private Long tedpUpdDsgnId;

	/** The office id. */
	private  Long officeId;
	
	/** The office name. */
	private String officeName;
	
	/** The district name. */
	private String districtName;
	
	/** The ddo number. */
	private String ddoNumber;
	
	/** The cardex no. */
	private Long cardexNo;
	
	/** The trn no. */
	private String trnNo;
	
	/** The emp id. */
	private  Long empId;
	
	/** The emp name. */
	private String empName;
	
	/** The emp no. */
	private String empNo;
	
	/** The active post id. */
	private  Long activePostId;
	
	/** The active post name. */
	private String activePostName;
	
	/** The designation id. */
	private  Long designationId;
	
	/** The designation name. */
	private String designationName;
	
	/** The post id. */
	private  Long postId;
	
	/** The post name. */
	private String postName;
	
	/** The status id. */
	private  long statusId;
	
	/** The status name. */
	private String statusName;
	
	/** The wf role id. */
	private Long wfRoleId;

	/**
	 * Gets the tedp upd dsgn itr id.
	 *
	 * @return the tedpUpdDsgnItrId
	 */
	public Long getTedpUpdDsgnItrId() {
		return tedpUpdDsgnItrId;
	}

	/**
	 * Sets the tedp upd dsgn itr id.
	 *
	 * @param tedpUpdDsgnItrId the tedpUpdDsgnItrId to set
	 */
	public void setTedpUpdDsgnItrId(Long tedpUpdDsgnItrId) {
		this.tedpUpdDsgnItrId = tedpUpdDsgnItrId;
	}

	/**
	 * Gets the tedp upd dsgn id.
	 *
	 * @return the tedpUpdDsgnId
	 */
	public Long getTedpUpdDsgnId() {
		return tedpUpdDsgnId;
	}

	/**
	 * Sets the tedp upd dsgn id.
	 *
	 * @param tedpUpdDsgnId the tedpUpdDsgnId to set
	 */
	public void setTedpUpdDsgnId(Long tedpUpdDsgnId) {
		this.tedpUpdDsgnId = tedpUpdDsgnId;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
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
	 * Gets the district name.
	 *
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the ddo number.
	 *
	 * @return the ddoNumber
	 */
	public String getDdoNumber() {
		return ddoNumber;
	}

	/**
	 * Sets the ddo number.
	 *
	 * @param ddoNumber the ddoNumber to set
	 */
	public void setDdoNumber(String ddoNumber) {
		this.ddoNumber = ddoNumber;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the trn no.
	 *
	 * @return the trnNo
	 */
	public String getTrnNo() {
		return trnNo;
	}

	/**
	 * Sets the trn no.
	 *
	 * @param trnNo the trnNo to set
	 */
	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	/**
	 * Gets the emp id.
	 *
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * Gets the active post id.
	 *
	 * @return the activePostId
	 */
	public Long getActivePostId() {
		return activePostId;
	}

	/**
	 * Sets the active post id.
	 *
	 * @param activePostId the activePostId to set
	 */
	public void setActivePostId(Long activePostId) {
		this.activePostId = activePostId;
	}

	/**
	 * Gets the active post name.
	 *
	 * @return the activePostName
	 */
	public String getActivePostName() {
		return activePostName;
	}

	/**
	 * Sets the active post name.
	 *
	 * @param activePostName the activePostName to set
	 */
	public void setActivePostName(String activePostName) {
		this.activePostName = activePostName;
	}

	/**
	 * Gets the designation id.
	 *
	 * @return the designationId
	 */
	public Long getDesignationId() {
		return designationId;
	}

	/**
	 * Sets the designation id.
	 *
	 * @param designationId the designationId to set
	 */
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	/**
	 * Gets the designation name.
	 *
	 * @return the designationName
	 */
	public String getDesignationName() {
		return designationName;
	}

	/**
	 * Sets the designation name.
	 *
	 * @param designationName the designationName to set
	 */
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
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
	 * Gets the status id.
	 *
	 * @return the statusId
	 */
	public long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the statusId to set
	 */
	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the status name.
	 *
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * Sets the status name.
	 *
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wfRoleId
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the wfRoleId to set
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
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
		return Objects.hash(activePostId, activePostName, cardexNo, ddoNumber, designationId, designationName,
				districtName, empId, empName, empNo, officeId, officeName, postId, postName, statusId, statusName,
				tedpUpdDsgnId, tedpUpdDsgnItrId, trnNo, wfRoleId);
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
		if (!(obj instanceof EDPTrnUpdDsgnItrDto)) {
			return false;
		}
		EDPTrnUpdDsgnItrDto other = (EDPTrnUpdDsgnItrDto) obj;
		return Objects.equals(activePostId, other.activePostId) && Objects.equals(activePostName, other.activePostName)
				&& Objects.equals(cardexNo, other.cardexNo) && Objects.equals(ddoNumber, other.ddoNumber)
				&& Objects.equals(designationId, other.designationId)
				&& Objects.equals(designationName, other.designationName)
				&& Objects.equals(districtName, other.districtName) && Objects.equals(empId, other.empId)
				&& Objects.equals(empName, other.empName) && Objects.equals(empNo, other.empNo)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(postId, other.postId) && Objects.equals(postName, other.postName)
				&& statusId == other.statusId && Objects.equals(statusName, other.statusName)
				&& Objects.equals(tedpUpdDsgnId, other.tedpUpdDsgnId)
				&& Objects.equals(tedpUpdDsgnItrId, other.tedpUpdDsgnItrId) && Objects.equals(trnNo, other.trnNo)
				&& Objects.equals(wfRoleId, other.wfRoleId);
	}
	
	

}
