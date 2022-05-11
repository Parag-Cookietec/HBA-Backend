
package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocChequeCancelListDto.
 */
@NativeQueryResultEntity
public class LocChequeToChequeSrchData implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The hdr id. */
    @NativeQueryResultColumn(index = 0)
    private Long lcAdviceId;

    /** The cheque NO. */
    @NativeQueryResultColumn(index = 1)
    private String chequeNO;

    /** The div code. */
    @NativeQueryResultColumn(index = 2)
    private String divCode;

    /** The cheque amt. */
    @NativeQueryResultColumn(index = 3)
    private Double chequeAmt;

    /** The cheque date. */
    @NativeQueryResultColumn(index = 4)
    private Date chequeDate;

    /** The in favour. */
    @NativeQueryResultColumn(index = 5)
    private String partyName;

    /** The advice no. */
    @NativeQueryResultColumn(index = 6)
    private String adviceNo;

    /** The cardex no. */
    @NativeQueryResultColumn(index = 7)
    private Long cardexNo;

    /** The ddo no. */
    @NativeQueryResultColumn(index = 8)
    private String ddoNo;
   
    /** The district id. */
    @NativeQueryResultColumn(index = 9)
    private Long districtId;
   
    /** The dept id. */
    @NativeQueryResultColumn(index = 10)
    private Long deptId;
   
    /** The office id. */
    @NativeQueryResultColumn(index = 11)
    private Long officeId;

    /** The div id. */
    @NativeQueryResultColumn(index = 12)
    private Long divId;

    /** The next chq dtl. */
    private LocAdviceEpayChqDtlDto nextChqDtl;

    /**
     * Gets the lc advice id.
     *
     * @return the lc advice id
     */
    public Long getLcAdviceId() {
        return lcAdviceId;
    }

    /**
     * Sets the lc advice id.
     *
     * @param lcAdviceId the new lc advice id
     */
    public void setLcAdviceId(Long lcAdviceId) {
        this.lcAdviceId = lcAdviceId;
    }

    /**
     * Gets the cheque NO.
     *
     * @return the cheque NO
     */
    public String getChequeNO() {
        return chequeNO;
    }

    /**
     * Sets the cheque NO.
     *
     * @param chequeNO the new cheque NO
     */
    public void setChequeNO(String chequeNO) {
        this.chequeNO = chequeNO;
    }

    /**
     * Gets the div code.
     *
     * @return the div code
     */
    public String getDivCode() {
        return divCode;
    }

    /**
     * Sets the div code.
     *
     * @param divCode the new div code
     */
    public void setDivCode(String divCode) {
        this.divCode = divCode;
    }

    /**
     * Gets the cheque amt.
     *
     * @return the cheque amt
     */
    public Double getChequeAmt() {
        return chequeAmt;
    }

    /**
     * Sets the cheque amt.
     *
     * @param chequeAmt the new cheque amt
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
     * Gets the party name.
     *
     * @return the party name
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * Sets the party name.
     *
     * @param partyName the new party name
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
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
     * Gets the cardex no.
     *
     * @return the cardex no
     */
    public Long getCardexNo() {
        return cardexNo;
    }

    /**
     * Sets the cardex no.
     *
     * @param cardexNo the new cardex no
     */
    public void setCardexNo(Long cardexNo) {
        this.cardexNo = cardexNo;
    }

    /**
     * Gets the ddo no.
     *
     * @return the ddo no
     */
    public String getDdoNo() {
        return ddoNo;
    }

    /**
     * Sets the ddo no.
     *
     * @param ddoNo the new ddo no
     */
    public void setDdoNo(String ddoNo) {
        this.ddoNo = ddoNo;
    }

    /**
     * Gets the district id.
     *
     * @return the district id
     */
    public Long getDistrictId() {
        return districtId;
    }

    /**
     * Sets the district id.
     *
     * @param districtId the new district id
     */
    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    /**
     * Gets the dept id.
     *
     * @return the dept id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * Sets the dept id.
     *
     * @param deptId the new dept id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * Gets the office id.
     *
     * @return the office id
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * Sets the office id.
     *
     * @param officeId the new office id
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    /**
     * Gets the div id.
     *
     * @return the div id
     */
    public Long getDivId() {
        return divId;
    }

    /**
     * Sets the div id.
     *
     * @param divId the new div id
     */
    public void setDivId(Long divId) {
        this.divId = divId;
    }

    /**
     * Gets the next chq dtl.
     *
     * @return the next chq dtl
     */
    public LocAdviceEpayChqDtlDto getNextChqDtl() {
        return nextChqDtl;
    }

    /**
     * Sets the next chq dtl.
     *
     * @param nextChqDtl the new next chq dtl
     */
    public void setNextChqDtl(LocAdviceEpayChqDtlDto nextChqDtl) {
        this.nextChqDtl = nextChqDtl;
    }
}
