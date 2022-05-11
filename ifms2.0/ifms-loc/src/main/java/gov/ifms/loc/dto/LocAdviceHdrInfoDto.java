package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocAdviceHdrInfoDto.
 */
public class LocAdviceHdrInfoDto implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The advice no.
     */
    @NativeQueryResultColumn(index = 0)
    private String adviceNo;

    /**
     * The advice date.
     */
    @NativeQueryResultColumn(index = 1)
    private Date adviceDate;

    /**
     * The division code.
     */
    @NativeQueryResultColumn(index = 2)
    private String divisionCode;

    /**
     * The Division Name.
     */
    @NativeQueryResultColumn(index = 3)
    private String divisionName;

    /**
     * The referance date.
     */
    @NativeQueryResultColumn(index = 4)
    private Date referanceDate;

    /**
     * The ref no.
     */
    @NativeQueryResultColumn(index = 5)
    private String referanceNumber;

    /**
     * The treasury Office.
     */
    @NativeQueryResultColumn(index = 6)
    private String treasuryOffice;

    /**
     * The Drawing Officer.
     */
    @NativeQueryResultColumn(index = 7)
    private String drawingOfficer;

    /**
     * The net Amt.
     */
    @NativeQueryResultColumn(index = 8)
    private Long netAmt;

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
     * Gets the division code.
     *
     * @return the division code
     */
    public String getDivisionCode() {
        return divisionCode;
    }

    /**
     * Sets the division code.
     *
     * @param divisionCode the new division code
     */
    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
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
     * Sets the division name.
     *
     * @param divisionName the new division name
     */
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    /**
     * Gets the treasury office.
     *
     * @return the treasury office
     */
    public String getTreasuryOffice() {
        return treasuryOffice;
    }

    /**
     * Sets the treasury office.
     *
     * @param treasuryOffice the new treasury office
     */
    public void setTreasuryOffice(String treasuryOffice) {
        this.treasuryOffice = treasuryOffice;
    }

    /**
     * Gets the drawing officer.
     *
     * @return the drawing officer
     */
    public String getDrawingOfficer() {
        return drawingOfficer;
    }

    /**
     * Sets the drawing officer.
     *
     * @param drawingOfficer the new drawing officer
     */
    public void setDrawingOfficer(String drawingOfficer) {
        this.drawingOfficer = drawingOfficer;
    }

    /**
     * Gets the net amt.
     *
     * @return the net amt
     */
    public Long getNetAmt() {
        return netAmt;
    }

    /**
     * Sets the net amt.
     *
     * @param netAmt the new net amt
     */
    public void setNetAmt(Long netAmt) {
        this.netAmt = netAmt;
    }

    public Date getReferanceDate() {
        return referanceDate;
    }

    public void setReferanceDate(Date referanceDate) {
        this.referanceDate = referanceDate;
    }

    public String getReferanceNumber() {
        return referanceNumber;
    }

    public void setReferanceNumber(String referanceNumber) {
        this.referanceNumber = referanceNumber;
    }
}
