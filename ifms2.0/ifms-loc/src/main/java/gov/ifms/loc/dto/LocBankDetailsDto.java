package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocBankDetailsDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocBankDetailsDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The bank ifsc code. */
	@NativeQueryResultColumn(index = 0)
	private Long bankId;

	/** The bank name. */
	@NativeQueryResultColumn(index = 1)
	private String bankName;

	/** The bank branch id. */
	@NativeQueryResultColumn(index = 2)
	private Long bankBranchId;

	/** The bank branch name. */
	@NativeQueryResultColumn(index = 3)
	private String bankBranchName;

	/** The bank branch code. */
	@NativeQueryResultColumn(index = 4)
	private String bankBranchCode;

	/** The bank branch list. */
	private List<LocBankDetailsDto> bankBranchList;

	/**
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bankBranchId
	 */
	public Long getBankBranchId() {
		return bankBranchId;
	}

	/**
	 * @param bankBranchId the bankBranchId to set
	 */
	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	/**
	 * @return the bankBranchName
	 */
	public String getBankBranchName() {
		return bankBranchName;
	}

	/**
	 * @param bankBranchName the bankBranchName to set
	 */
	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	/**
	 * @return the bankBranchCode
	 */
	public String getBankBranchCode() {
		return bankBranchCode;
	}

	/**
	 * @param bankBranchCode the bankBranchCode to set
	 */
	public void setBankBranchCode(String bankBranchCode) {
		this.bankBranchCode = bankBranchCode;
	}

	/**
	 * @return the bankBranchList
	 */
	public List<LocBankDetailsDto> getBankBranchList() {
		return bankBranchList;
	}

	/**
	 * @param bankBranchList the bankBranchList to set
	 */
	public void setBankBranchList(List<LocBankDetailsDto> bankBranchList) {
		this.bankBranchList = bankBranchList;
	}

}
