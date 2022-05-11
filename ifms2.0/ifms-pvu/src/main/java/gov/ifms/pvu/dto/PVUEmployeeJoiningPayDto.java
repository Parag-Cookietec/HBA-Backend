package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

/**
 * The Class PVUEmployeeJoiningPayDto.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 *
 */
public class PVUEmployeeJoiningPayDto extends BaseDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The joining pay id. */
	private Long joiningPayId;

	/** The emp id. */
	private Long empId;

	/** The join pay comm id. */
	private Long joinPayCommId;
	private String joinPayCommName;

	/** The pay scale. */
	private String payScale;

	/** The basic pay. */
	private Long basicPay;

	/** The pay band id. */
	private Long payBandId;
	private String payBandName;

	/** The grade pay id. */
	private Long gradePayId;
	private String gradePayName;

	/** The pay band value. */
	private Long payBandValue;

	/** The pay level id. */
	private Long payLevelId;
	private String payLevelName;

	/** The cell id. */
	private Long cellId;
	private Long cellValue;

	/**
	 * PVUEmployeeJoiningPayDto Constructor.
	 */
	public PVUEmployeeJoiningPayDto() {
		super();
	}

	/**
	 * getter setter.
	 *
	 * @return the joining pay id
	 */

	/**
	 * @return the joiningPayId
	 */
	public Long getJoiningPayId() {
		return joiningPayId;
	}

	/**
	 * Sets the joining pay id.
	 *
	 * @param joiningPayId the joiningPayId to set
	 */
	public void setJoiningPayId(Long joiningPayId) {
		this.joiningPayId = joiningPayId;
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
	 * Gets the join pay comm id.
	 *
	 * @return the joinPayCommId
	 */
	public Long getJoinPayCommId() {
		return joinPayCommId;
	}

	/**
	 * Sets the join pay comm id.
	 *
	 * @param joinPayCommId the joinPayCommId to set
	 */
	public void setJoinPayCommId(Long joinPayCommId) {
		this.joinPayCommId = joinPayCommId;
	}

	/**
	 * Gets the pay scale.
	 *
	 * @return the payScale
	 */
	public String getPayScale() {
		return payScale;
	}

	/**
	 * Sets the pay scale.
	 *
	 * @param payScale the payScale to set
	 */
	public void setPayScale(String payScale) {
		this.payScale = payScale;
	}

	/**
	 * Gets the basic pay.
	 *
	 * @return the basicPay
	 */
	public Long getBasicPay() {
		return basicPay;
	}

	/**
	 * Sets the basic pay.
	 *
	 * @param basicPay the basicPay to set
	 */
	public void setBasicPay(Long basicPay) {
		this.basicPay = basicPay;
	}

	/**
	 * Gets the pay band id.
	 *
	 * @return the payBandId
	 */
	public Long getPayBandId() {
		return payBandId;
	}

	/**
	 * Sets the pay band id.
	 *
	 * @param payBandId the payBandId to set
	 */
	public void setPayBandId(Long payBandId) {
		this.payBandId = payBandId;
	}

	/**
	 * Gets the grade pay id.
	 *
	 * @return the gradePayId
	 */
	public Long getGradePayId() {
		return gradePayId;
	}

	/**
	 * Sets the grade pay id.
	 *
	 * @param gradePayId the gradePayId to set
	 */
	public void setGradePayId(Long gradePayId) {
		this.gradePayId = gradePayId;
	}

	/**
	 * Gets the pay band value.
	 *
	 * @return the payBandValue
	 */
	public Long getPayBandValue() {
		return payBandValue;
	}

	/**
	 * Sets the pay band value.
	 *
	 * @param payBandValue the payBandValue to set
	 */
	public void setPayBandValue(Long payBandValue) {
		this.payBandValue = payBandValue;
	}

	/**
	 * Gets the pay level id.
	 *
	 * @return the payLevelId
	 */
	public Long getPayLevelId() {
		return payLevelId;
	}

	/**
	 * Sets the pay level id.
	 *
	 * @param payLevelId the payLevelId to set
	 */
	public void setPayLevelId(Long payLevelId) {
		this.payLevelId = payLevelId;
	}

	/**
	 * Gets the cell id.
	 *
	 * @return the cellId
	 */
	public Long getCellId() {
		return cellId;
	}

	/**
	 * Sets the cell id.
	 *
	 * @param cellId the cellId to set
	 */
	public void setCellId(Long cellId) {
		this.cellId = cellId;
	}

	/**
	 * @return the joinPayCommName
	 */
	public String getJoinPayCommName() {
		return joinPayCommName;
	}

	/**
	 * @param joinPayCommName the joinPayCommName to set
	 */
	public void setJoinPayCommName(String joinPayCommName) {
		this.joinPayCommName = joinPayCommName;
	}

	/**
	 * @return the payBandName
	 */
	public String getPayBandName() {
		return payBandName;
	}

	/**
	 * @param payBandName the payBandName to set
	 */
	public void setPayBandName(String payBandName) {
		this.payBandName = payBandName;
	}

	/**
	 * @return the gradePayName
	 */
	public String getGradePayName() {
		return gradePayName;
	}

	/**
	 * @param gradePayName the gradePayName to set
	 */
	public void setGradePayName(String gradePayName) {
		this.gradePayName = gradePayName;
	}

	/**
	 * @return the payLevelName
	 */
	public String getPayLevelName() {
		return payLevelName;
	}

	/**
	 * @param payLevelName the payLevelName to set
	 */
	public void setPayLevelName(String payLevelName) {
		this.payLevelName = payLevelName;
	}

	/**
	 * @return the cellValue
	 */
	public Long getCellValue() {
		return cellValue;
	}

	/**
	 * @param cellValue the cellValue to set
	 */
	public void setCellValue(Long cellValue) {
		this.cellValue = cellValue;
	}

	/**
	 * hascode method.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(joiningPayId, empId, joinPayCommId, payScale, basicPay, payBandId, gradePayId, payBandValue,
				payLevelId, cellId);
	}

	/**
	 * equals method.
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
		if (!(obj instanceof PVUEmployeeJoiningPayDto)) {
			return false;
		}

		PVUEmployeeJoiningPayDto other = (PVUEmployeeJoiningPayDto) obj;

		return Objects.equals(joiningPayId, other.joiningPayId) && Objects.equals(empId, other.empId)
				&& Objects.equals(joinPayCommId, other.joinPayCommId) && Objects.equals(payScale, other.payScale)
				&& Objects.equals(basicPay, other.basicPay) && Objects.equals(payBandId, other.payBandId)
				&& Objects.equals(gradePayId, other.gradePayId) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payLevelId, other.payLevelId) && Objects.equals(cellId, other.cellId);
	}

	/**
	 * toString method.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVUEmployeeJoiningPayDto [joiningPayId = " + joiningPayId + ",empId = " + empId + ",joinPayCommId = "
				+ joinPayCommId + ",payScale = " + payScale + ",basicPay = " + basicPay + ",payBandId = " + payBandId
				+ ",gradePayId = " + gradePayId + ",payBandValue = " + payBandValue + ",payLevelId = " + payLevelId
				+ ",cellId = " + cellId + ",]";
	}

}
