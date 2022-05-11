package gov.ifms.loc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.List;

/**
 * The Class LocAdviceDtlDataDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAdviceDtlDataDto implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * The bank id.
     */
    @NativeQueryResultColumn(index = 0)
    private Long bankId;

    /**
     * The bank name.
     */
    @NativeQueryResultColumn(index = 1)
    private String bankName;

    /**
     * The div id.
     */
    @NativeQueryResultColumn(index = 2)
    private Long divId;

    /**
     * The div name.
     */
    @NativeQueryResultColumn(index = 3)
    private String divName;

    /**
     * The div code.
     */
    @NativeQueryResultColumn(index = 4)
    private String divCode;

    /**
     * The tres sub tres id.
     */
    private Long tresSubTresId;

    /**
     * The tres sub tres name.
     */
    private String tresSubTresName;

    /**
     * The lc validfrom.
     */
    private String lcValidfrom;

    /**
     * The advice no.
     */
    private String adviceNo;

    /**
     * The advice date.
     */
    private String adviceDate;

    /**
     * The payment type.
     */
    private List<LocIdNameDto> paymentType;

    /**
     * Gets the bank id.
     *
     * @return the bank id
     */
    public Long getBankId() {
        return bankId;
    }

    /**
     * Sets the bank id.
     *
     * @param bankId the new bank id
     */
    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    /**
     * Gets the bank name.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     *
     * @param bankName the new bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * Gets the tres sub tres id.
     *
     * @return the tres sub tres id
     */
    public Long getTresSubTresId() {
        return tresSubTresId;
    }

    /**
     * Sets the tres sub tres id.
     *
     * @param tresSubTresId the new tres sub tres id
     */
    public void setTresSubTresId(Long tresSubTresId) {
        this.tresSubTresId = tresSubTresId;
    }

    /**
     * Gets the tres sub tres name.
     *
     * @return the tres sub tres name
     */
    public String getTresSubTresName() {
        return tresSubTresName;
    }

    /**
     * Sets the tres sub tres name.
     *
     * @param tresSubTresName the new tres sub tres name
     */
    public void setTresSubTresName(String tresSubTresName) {
        this.tresSubTresName = tresSubTresName;
    }

    /**
     * Gets the payment type.
     *
     * @return the payment type
     */
    public List<LocIdNameDto> getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the payment type.
     *
     * @param paymentType the new payment type
     */
    public void setPaymentType(List<LocIdNameDto> paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Gets the lc validfrom.
     *
     * @return the lc validfrom
     */
    public String getLcValidfrom() {
        return lcValidfrom;
    }

    /**
     * Sets the lc validfrom.
     *
     * @param lcValidfrom the new lc validfrom
     */
    public void setLcValidfrom(String lcValidfrom) {
        this.lcValidfrom = lcValidfrom;
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
    public String getAdviceDate() {
        return adviceDate;
    }

    /**
     * Sets the advice date.
     *
     * @param adviceDate the new advice date
     */
    public void setAdviceDate(String adviceDate) {
        this.adviceDate = adviceDate;
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
     * Gets the div name.
     *
     * @return the div name
     */
    public String getDivName() {
        return divName;
    }

    /**
     * Sets the div name.
     *
     * @param divName the new div name
     */
    public void setDivName(String divName) {
        this.divName = divName;
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
}
