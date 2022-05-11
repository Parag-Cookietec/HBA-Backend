package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocCheckCancelHdrInfoDto.
 */
@NativeQueryResultEntity
public class LocCheckCancelHdrInfoDto implements Serializable {

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
    private Date refDate;

    /**
     * The cheque no.
     */
    @NativeQueryResultColumn(index = 2)
    private String chequeNo;

    /**
     * The advice date.
     */
    @NativeQueryResultColumn(index = 3)
    private Double chequeAmt;

    /**
     * The division code.
     */
    @NativeQueryResultColumn(index = 4)
    private Date chequeDate;

    /**
     * The Division Name.
     */
    @NativeQueryResultColumn(index = 5)
    private String inFavourOf;

    /**
     * The treasury Office.
     */
    @NativeQueryResultColumn(index = 6)
    private String adviceNo;

    /**
     * The Drawing Officer.
     */
    @NativeQueryResultColumn(index = 7)
    private Date adviceDate;

    /**
     * The division code.
     */
    @NativeQueryResultColumn(index = 8)
    private String divisionCode;

    /**
     * The division name.
     */
    @NativeQueryResultColumn(index = 9)
    private String divisionName;

    /**
     * The Division Name.
     */
    @NativeQueryResultColumn(index = 10)
    private String drawingOfficeName;

    /**
     * The Division Name.
     */
    @NativeQueryResultColumn(index = 11)
    private String chequeCancelAmt;

    /**
     * Gets the ref no.
     *
     * @return the ref no
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * Sets the ref no.
     *
     * @param refNo the new ref no
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
     * Gets the ref date.
     *
     * @return the ref date
     */
    public Date getRefDate() {
        return refDate;
    }

    /**
     * Sets the ref date.
     *
     * @param refDate the new ref date
     */
    public void setRefDate(Date refDate) {
        this.refDate = refDate;
    }

   

    /**
	 * @return the chequeAmt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * @param chequeAmt the chequeAmt to set
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
     * Gets the cheque date.
     *
     * @return the cheque date
     */
    public Date getChequeDate() {
        return chequeDate;
    }

    /**
     * Sets the cheque date.
     *
     * @param chequeDate the new cheque date
     */
    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    /**
     * Gets the in favour of.
     *
     * @return the in favour of
     */
    public String getInFavourOf() {
        return inFavourOf;
    }

    /**
     * Sets the in favour of.
     *
     * @param inFavourOf the new in favour of
     */
    public void setInFavourOf(String inFavourOf) {
        this.inFavourOf = inFavourOf;
    }

    /**
     * Gets the advice no.
     *
     * @return the advice no
     */
    public String getAdviceNo() {
        return adviceNo;
    }

    /**
     * Sets the advice no.
     *
     * @param adviceNo the new advice no
     */
    public void setAdviceNo(String adviceNo) {
        this.adviceNo = adviceNo;
    }

    /**
     * Gets the advice date.
     *
     * @return the advice date
     */
    public Date getAdviceDate() {
        return adviceDate;
    }

    /**
     * Sets the advice date.
     *
     * @param adviceDate the new advice date
     */
    public void setAdviceDate(Date adviceDate) {
        this.adviceDate = adviceDate;
    }

   
    /**
     * Gets the division name.
     *
     * @return the division name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
	 * @return the chequeNo
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo the chequeNo to set
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @return the divisionCode
	 */
	public String getDivisionCode() {
		return divisionCode;
	}

	/**
	 * @param divisionCode the divisionCode to set
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	/**
     * Sets the division name.
     *
     * @param divisionName the new division name
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * Gets the drawing office name.
     *
     * @return the drawing office name
     */
    public String getDrawingOfficeName() {
        return drawingOfficeName;
    }

    /**
     * Sets the drawing office name.
     *
     * @param drawingOfficeName the new drawing office name
     */
    public void setDrawingOfficeName(String drawingOfficeName) {
        this.drawingOfficeName = drawingOfficeName;
    }

    /**
     * Gets the cheque cancel amt.
     *
     * @return the cheque cancel amt
     */
    public String getChequeCancelAmt() {
        return chequeCancelAmt;
    }

    /**
     * Sets the cheque cancel amt.
     *
     * @param chequeCancelAmt the new cheque cancel amt
     */
    public void setChequeCancelAmt(String chequeCancelAmt) {
        this.chequeCancelAmt = chequeCancelAmt;
    }
}
