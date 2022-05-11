package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChequeBookHdrInfoDto.
 */
@NativeQueryResultEntity
public class LocChequeBookHdrInfoDto implements Serializable {

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

	/** The cheque type. */
	@NativeQueryResultColumn(index = 4)
	private String chequeType;

	/** The req type. */
	@NativeQueryResultColumn(index = 5)
	private String reqType;

	/** The ref no. */
	@NativeQueryResultColumn(index = 6)
	private String refNo;

	/** The ref date. */
	@NativeQueryResultColumn(index = 7)
	private Date refDate;

	/**
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * @return the divName
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * @param divName the divName to set
	 */
	public void setDivName(String divName) {
		this.divName = divName;
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
	 * @return the bankAccNo
	 */
	public String getBankAccNo() {
		return bankAccNo;
	}

	/**
	 * @param bankAccNo the bankAccNo to set
	 */
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	/**
	 * @return the chequeType
	 */
	public String getChequeType() {
		return chequeType;
	}

	/**
	 * @param chequeType the chequeType to set
	 */
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	/**
	 * @return the reqType
	 */
	public String getReqType() {
		return reqType;
	}

	/**
	 * @param reqType the reqType to set
	 */
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * @return the refDate
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

}
