package gov.ifms.pvu.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.util.PvuConstant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUEmployeDto.
 * 
 * @version v 1.0
 * @created 2019/11/22 01:17:36
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PVUExpressEmployeeDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The salutation. */

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String employeeNo;

	@NotNull
	private Long empPayTypeId;

	private String caseNo;

	@NotNull
	private Long salutationId;

	/** The employee name. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String empFirstName;

	/** The employee middle name. */
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String empMiddleName;

	/** The employee surname. */
	@Pattern(regexp = Constant.Regex.VALIDATION_NAME_CAP_MIN_0_MAX_50_DIGIT)
	private String empLastName;

	@NotNull
	private Long designationId;

	/** The date of birth. */
	@NotBlank
	private String dateOfBirth;

	/** The pan no. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_PAN_NUMBER)
	private String panNo;

	/** The mobile no. */
	@NotBlank
	@Pattern(regexp = Constant.Regex.VALIDATION_MOBILE_NO_10_DIGIT,message = PvuConstant.EXP_EMP_MOBILE_NO_INVALID)
	private String mobileNo;

	private String designation;

	private String salutation;

	/**
	 * Instantiates a new base dto.
	 */
	public PVUExpressEmployeeDto() {
	}

	public PVUExpressEmployeeDto(String employeeNo, String salutation, String empFirstName, String empMiddleName, String empLastName, String designation) {
		this.employeeNo = employeeNo;
		this.salutation = salutation;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.designation = designation;
	}

	public Long getEmpPayTypeId() {
		return empPayTypeId;
	}

	public void setEmpPayTypeId(Long empPayTypeId) {
		this.empPayTypeId = empPayTypeId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Long getSalutationId() {
		return salutationId;
	}

	public void setSalutationId(Long salutationId) {
		this.salutationId = salutationId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PVUExpressEmployeeDto that = (PVUExpressEmployeeDto) o;
		return Objects.equals(employeeNo, that.employeeNo) && Objects.equals(empPayTypeId, that.empPayTypeId) && Objects.equals(caseNo, that.caseNo) && Objects.equals(salutationId, that.salutationId) && Objects.equals(empFirstName, that.empFirstName) && Objects.equals(empMiddleName, that.empMiddleName) && Objects.equals(empLastName, that.empLastName) && Objects.equals(designationId, that.designationId) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(panNo, that.panNo) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(designation, that.designation) && Objects.equals(salutation, that.salutation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeNo, empPayTypeId, caseNo, salutationId, empFirstName, empMiddleName, empLastName, designationId, dateOfBirth, panNo, mobileNo, designation, salutation);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("PVUExpressEmployeeDto{");
		sb.append("employeeNo='").append(employeeNo).append('\'');
		sb.append(", empPayTypeId=").append(empPayTypeId);
		sb.append(", caseNo='").append(caseNo).append('\'');
		sb.append(", salutationId=").append(salutationId);
		sb.append(", empFirstName='").append(empFirstName).append('\'');
		sb.append(", empMiddleName='").append(empMiddleName).append('\'');
		sb.append(", empLastName='").append(empLastName).append('\'');
		sb.append(", designationId=").append(designationId);
		sb.append(", dateOfBirth='").append(dateOfBirth).append('\'');
		sb.append(", panNo='").append(panNo).append('\'');
		sb.append(", mobileNo='").append(mobileNo).append('\'');
		sb.append(", designation='").append(designation).append('\'');
		sb.append(", salutation='").append(salutation).append('\'');
		sb.append('}');
		return sb.toString();
	}
}