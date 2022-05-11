package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.List;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class LocChqBookData.
 */
public class LocChqBookData implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The div code. */
	@NativeQueryResultColumn(index = 0)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 1)
	private String divName;

	/** The bank name. */
	@NativeQueryResultColumn(index = 2)
	private String bankName;

	/** The bank acc no. */
	@NativeQueryResultColumn(index = 3)
	private String bankAccNo;

	/** The bank id. */
	@NativeQueryResultColumn(index = 4)
	private Long bankId;

	/** The div id. */
	@NativeQueryResultColumn(index = 5)
	private Long divId;

	/** The req type list. */
	private List<LocIdNameDto> reqTypeList;

	/** The cheque type list. */
	private List<LocIdNameDto> chequeTypeList;

	/**
	 * Gets the div code.
	 *
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the divName
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the divName to set
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the bank acc no.
	 *
	 * @return the bankAccNo
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * Sets the bank acc no.
	 *
	 * @param bankAccNo the bankAccNo to set
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * Gets the req type list.
	 *
	 * @return the reqTypeList
	 */
	public List<LocIdNameDto> getReqTypeList() {
		return reqTypeList;
	}

	/**
	 * Sets the req type list.
	 *
	 * @param reqTypeList the reqTypeList to set
	 */
	public void setReqTypeList(List<LocIdNameDto> reqTypeList) {
		this.reqTypeList = reqTypeList;
	}

	/**
	 * Gets the cheque type list.
	 *
	 * @return the chequeTypeList
	 */
	public List<LocIdNameDto> getChequeTypeList() {
		return chequeTypeList;
	}

	/**
	 * Sets the cheque type list.
	 *
	 * @param chequeTypeList the chequeTypeList to set
	 */
	public void setChequeTypeList(List<LocIdNameDto> chequeTypeList) {
		this.chequeTypeList = chequeTypeList;
	}

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
	 * @return the divId
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

}
