package gov.ifms.pvu.dto;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.edp.dto.BaseDto;


/**
 * The Class PVUEmployePayDetailDtos.
 *
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PVUEmployePayDetailDtos extends BaseDto {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4035914344981150459L;

	/** The pvu employefourth pay detail dto. */
	@Valid
	private PVUEmployeFourthPayDetailDto pvuEmployefourthPayDetailDto;

	/** The pvu employefive pay detail dto. */
	@Valid
	private PVUEmployeFivePayDetailDto pvuEmployefivePayDetailDto;

	/** The pvu employe six pay detail dto. */
	@Valid
	private PVUEmployeSixPayDetailDto pvuEmployeSixPayDetailDto;

	/** The pvu employe seven pay detail dto. */
	@Valid
	private PVUEmployeSevenPayDetailDto pvuEmployeSevenPayDetailDto;

	/** The pvu employe fix pay details dto. */
	@Valid
	private PVUEmployeFixPayDetailsDto pvuEmployeFixPayDetailsDto;
	
	/** The pvu employee joining pay dto. */
	@Valid
	private PVUEmployeeJoiningPayDto pvuEmployeeJoiningPayDto;
	
	/** The pvu emp bank detail dto. */
	@Valid
	private PVUEmpBankDetailDto pvuEmpBankDetailDto;
	
	/**
	 * Gets the pvu employe fix pay details dto.
	 *
	 * @return the pvu employe fix pay details dto
	 */
	public PVUEmployeFixPayDetailsDto getPvuEmployeFixPayDetailsDto() {
		return pvuEmployeFixPayDetailsDto;
	}

	/**
	 * Sets the pvu employe fix pay details dto.
	 *
	 * @param pvuEmployeFixPayDetailsDto the new pvu employe fix pay details dto
	 */
	public void setPvuEmployeFixPayDetailsDto(PVUEmployeFixPayDetailsDto pvuEmployeFixPayDetailsDto) {
		this.pvuEmployeFixPayDetailsDto = pvuEmployeFixPayDetailsDto;
	}

	/**
	 * Gets the pvu employe six pay detail dto.
	 *
	 * @return the pvuEmployeSixPayDetailDto
	 */
	public PVUEmployeSixPayDetailDto getPvuEmployeSixPayDetailDto() {
		return pvuEmployeSixPayDetailDto;
	}

	/**
	 * Sets the pvu employe six pay detail dto.
	 *
	 * @param pvuEmployeSixPayDetailDto the pvuEmployeSixPayDetailDto to set
	 */
	public void setPvuEmployeSixPayDetailDto(PVUEmployeSixPayDetailDto pvuEmployeSixPayDetailDto) {
		this.pvuEmployeSixPayDetailDto = pvuEmployeSixPayDetailDto;
	}

	/**
	 * Gets the pvu employe seven pay detail dto.
	 *
	 * @return the pvuEmployeSevenPayDetailDto
	 */
	public PVUEmployeSevenPayDetailDto getPvuEmployeSevenPayDetailDto() {
		return pvuEmployeSevenPayDetailDto;
	}

	/**
	 * Sets the pvu employe seven pay detail dto.
	 *
	 * @param pvuEmployeSevenPayDetailDto the pvuEmployeSevenPayDetailDto to set
	 */
	public void setPvuEmployeSevenPayDetailDto(PVUEmployeSevenPayDetailDto pvuEmployeSevenPayDetailDto) {
		this.pvuEmployeSevenPayDetailDto = pvuEmployeSevenPayDetailDto;
	}

	/**
	 * Gets the pvu employefive pay detail dto.
	 *
	 * @return the pvuEmployefivePayDetailDto
	 */
	public PVUEmployeFivePayDetailDto getPvuEmployefivePayDetailDto() {
		return pvuEmployefivePayDetailDto;
	}

	/**
	 * Sets the pvu employefive pay detail dto.
	 *
	 * @param pvuEmployefivePayDetailDto the pvuEmployefivePayDetailDto to set
	 */
	public void setPvuEmployefivePayDetailDto(PVUEmployeFivePayDetailDto pvuEmployefivePayDetailDto) {
		this.pvuEmployefivePayDetailDto = pvuEmployefivePayDetailDto;
	}

	/**
	 * Gets the pvu employefourth pay detail dto.
	 *
	 * @return the pvuEmployefourthPayDetailDto
	 */
	public PVUEmployeFourthPayDetailDto getPvuEmployefourthPayDetailDto() {
		return pvuEmployefourthPayDetailDto;
	}

	/**
	 * Sets the pvu employefourth pay detail dto.
	 *
	 * @param pvuEmployefourthPayDetailDto the pvuEmployefourthPayDetailDto to set
	 */
	public void setPvuEmployefourthPayDetailDto(PVUEmployeFourthPayDetailDto pvuEmployefourthPayDetailDto) {
		this.pvuEmployefourthPayDetailDto = pvuEmployefourthPayDetailDto;
	}

	/**
	 * Gets the pvu employee joining pay dto.
	 *
	 * @return the pvu employee joining pay dto
	 */
	public PVUEmployeeJoiningPayDto getPvuEmployeeJoiningPayDto() {
		return pvuEmployeeJoiningPayDto;
	}

	/**
	 * Sets the pvu employee joining pay dto.
	 *
	 * @param pvuEmployeeJoiningPayDto the new pvu employee joining pay dto
	 */
	public void setPvuEmployeeJoiningPayDto(PVUEmployeeJoiningPayDto pvuEmployeeJoiningPayDto) {
		this.pvuEmployeeJoiningPayDto = pvuEmployeeJoiningPayDto;
	}

	public PVUEmpBankDetailDto getPvuEmpBankDetailDto() {
		return pvuEmpBankDetailDto;
	}

	public void setPvuEmpBankDetailDto(PVUEmpBankDetailDto pvuEmpBankDetailDto) {
		this.pvuEmpBankDetailDto = pvuEmpBankDetailDto;
	}

}
