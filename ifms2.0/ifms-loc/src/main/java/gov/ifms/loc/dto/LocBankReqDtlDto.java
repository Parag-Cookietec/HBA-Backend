package gov.ifms.loc.dto;

public interface LocBankReqDtlDto {

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	Long getHdrId();

	/**
	 * Gets the sd/Dtl id.
	 *
	 * @return the sd/Dtl id
	 */
	Long getDtlId();

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	Long getBankId();

	/**
	 * Gets the bank remarks.
	 *
	 * @return the bank remarks
	 */
	String getBankRemarks();

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	String getBankName();

	/**
	 * Gets the bank address.
	 *
	 * @return the bank address
	 */
	String getBankAddress();

	/**
	 * Gets the bank ifsc code.
	 *
	 * @return the bank ifsc code
	 */
	String getBankIfscCode();

	/**
	 * Gets the bank branch id.
	 *
	 * @return the bank branch id
	 */
	Long getBankBranchId();

}
