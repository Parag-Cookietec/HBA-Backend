package gov.ifms.common.cache.dto;

public class MsOfficeCacheDto {

	private Long officeId;

	private String officeName;

	private String ddoNo;

	private Long cardexno;

	private String officeNameDisp;
	
	private Long departmentId;
	
	private String departmentName;

	public MsOfficeCacheDto() {
		super();
	}

	public MsOfficeCacheDto(Long officeId, String officeName, String ddoNo, Long cardexno, String officeNameDisp,
			Long departmentId, String departmentName) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.ddoNo = ddoNo;
		this.cardexno = cardexno;
		this.officeNameDisp = officeNameDisp;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the cardexno
	 */
	public Long getCardexno() {
		return cardexno;
	}

	/**
	 * @param cardexno the cardexno to set
	 */
	public void setCardexno(Long cardexno) {
		this.cardexno = cardexno;
	}

	/**
	 * @return the officeNameDisp
	 */
	public String getOfficeNameDisp() {
		return officeNameDisp;
	}

	/**
	 * @param officeNameDisp the officeNameDisp to set
	 */
	public void setOfficeNameDisp(String officeNameDisp) {
		this.officeNameDisp = officeNameDisp;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
}
