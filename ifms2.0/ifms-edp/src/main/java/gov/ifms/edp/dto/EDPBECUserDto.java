package gov.ifms.edp.dto;

import java.util.Objects;

public class EDPBECUserDto {

	private Long id;

	private String districtName;

	private String ddoNo;

	private String cardexNo;

	private String officeName;

	private String salutation;

	private String firstName;

	private String middleName;

	private String lastName;

	private String designation;

	private String dob;

	private String pan;

	private Long mobileNo;

	private String caseNo;

	private Long empNo;

	private String wf1;

	private String wf2;

	private String wf3;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
	 * @return the cardexNo
	 */
	public String getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
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
	 * @return the salutation
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * @param salutation the salutation to set
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	/**
	 * @return the mobileNo
	 */
	public Long getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}

	/**
	 * @param caseNo the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the wf1
	 */
	public String getWf1() {
		return wf1;
	}

	/**
	 * @param wf1 the wf1 to set
	 */
	public void setWf1(String wf1) {
		this.wf1 = wf1;
	}

	/**
	 * @return the wf2
	 */
	public String getWf2() {
		return wf2;
	}

	/**
	 * @param wf2 the wf2 to set
	 */
	public void setWf2(String wf2) {
		this.wf2 = wf2;
	}

	/**
	 * @return the wf3
	 */
	public String getWf3() {
		return wf3;
	}

	/**
	 * @param wf3 the wf3 to set
	 */
	public void setWf3(String wf3) {
		this.wf3 = wf3;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardexNo, caseNo, ddoNo, designation, districtName, dob, empNo, firstName, id, lastName,
				middleName, mobileNo, officeName, pan, salutation, wf1, wf2, wf3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EDPBECUserDto)) {
			return false;
		}
		EDPBECUserDto other = (EDPBECUserDto) obj;
		return Objects.equals(cardexNo, other.cardexNo) && Objects.equals(caseNo, other.caseNo)
				&& Objects.equals(ddoNo, other.ddoNo) && Objects.equals(designation, other.designation)
				&& Objects.equals(districtName, other.districtName) && Objects.equals(dob, other.dob)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(officeName, other.officeName) && Objects.equals(pan, other.pan)
				&& Objects.equals(salutation, other.salutation) && Objects.equals(wf1, other.wf1)
				&& Objects.equals(wf2, other.wf2) && Objects.equals(wf3, other.wf3);
	}

	@Override
	public String toString() {
		return "EDPBECUserDto [id=" + id + ", districtName=" + districtName + ", ddoNo=" + ddoNo + ", cardexNo="
				+ cardexNo + ", officeName=" + officeName + ", salutation=" + salutation + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", designation=" + designation + ", dob="
				+ dob + ", pan=" + pan + ", mobileNo=" + mobileNo + ", caseNo=" + caseNo + ", empNo=" + empNo + ", wf1="
				+ wf1 + ", wf2=" + wf2 + ", wf3=" + wf3 + "]";
	}

	public EDPBECUserDto(String districtName, String ddoNo, String cardexNo, String officeName, String salutation,
			String firstName, String middleName, String lastName, String designation, String dob, String pan,
			Long mobileNo, String caseNo, String wf1, String wf2, String wf3) {
		super();
		this.districtName = districtName;
		this.ddoNo = ddoNo;
		this.cardexNo = cardexNo;
		this.officeName = officeName;
		this.salutation = salutation;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.designation = designation;
		this.dob = dob;
		this.pan = pan;
		this.mobileNo = mobileNo;
		this.caseNo = caseNo;
		this.wf1 = wf1;
		this.wf2 = wf2;
		this.wf3 = wf3;
	}
}
