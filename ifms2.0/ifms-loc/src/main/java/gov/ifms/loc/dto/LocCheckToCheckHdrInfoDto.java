package gov.ifms.loc.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class LocCheckToCheckHdrInfoDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The ref no.
	 */
	@NativeQueryResultColumn(index = 0)
	private String refNo;

	/**
	 * The ref date.
	 */
	@NativeQueryResultColumn(index = 1)
	private String refDate;

	/**
	 * The cheque no.
	 */
	@NativeQueryResultColumn(index = 2)
	private String missingChequeNo;

	/**
	 * The cheque no.
	 */
	@NativeQueryResultColumn(index = 3)
	private String chequeNo;
	
	/**
	 * The Division Name.
	 */
	@NativeQueryResultColumn(index = 4)
	private Long chequeAmt;

	/**
	 * The division code.
	 */
	@NativeQueryResultColumn(index = 5)
	private String chequeDate;

	/**
	 * The Division Name.
	 */
	@NativeQueryResultColumn(index = 6)
	private String inFavourOf;

	/**
	 * The treasury Office.
	 */
	@NativeQueryResultColumn(index = 7)
	private String adviceNo;

	/**
	 * The Drawing Officer.
	 */
	@NativeQueryResultColumn(index = 8)
	private String adviceDate;

	/**
	 * The division code.
	 */
	@NativeQueryResultColumn(index = 9)
	private String divisionCode;

	/**
	 * The division name.
	 */
	@NativeQueryResultColumn(index = 10)
	private String divisionName;

	/**
	 * The Division Name.
	 */
	@NativeQueryResultColumn(index = 11)
	private String drawingOfficeName;

	

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getMissingChequeNo() {
		return missingChequeNo;
	}

	public void setMissingChequeNo(String missingChequeNo) {
		this.missingChequeNo = missingChequeNo;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getInFavourOf() {
		return inFavourOf;
	}

	public void setInFavourOf(String inFavourOf) {
		this.inFavourOf = inFavourOf;
	}

	public String getAdviceNo() {
		return adviceNo;
	}

	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDrawingOfficeName() {
		return drawingOfficeName;
	}

	public void setDrawingOfficeName(String drawingOfficeName) {
		this.drawingOfficeName = drawingOfficeName;
	}

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public String getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getAdviceDate() {
		return adviceDate;
	}

	public void setAdviceDate(String adviceDate) {
		this.adviceDate = adviceDate;
	}

	public long getChequeAmt() {
		return chequeAmt;
	}

	public void setChequeAmt(long chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

}
