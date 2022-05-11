package gov.ifms.gst.dto;

import java.io.Serializable;

/**
 * The Class GSTBankWisePenalInterestDto.
 *
 * @version v 1.0
 * @created 2021/10/02 16:58:33
 *
 */

public class GSTBankWisePenalInterestDto implements Serializable{

    private Long year;
    private Long month;
    private Double claimAmount;
    private Double earliearReceivedAmount;
    private Double remainingAmount;

    public GSTBankWisePenalInterestDto(Long year, Long month, Double claimAmount, Double earliearReceivedAmount, Double remainingAmount) {
        this.year = year;
        this.month = month;
        this.claimAmount = claimAmount;
        this.earliearReceivedAmount = earliearReceivedAmount;
        this.remainingAmount = remainingAmount;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public Double getEarliearReceivedAmount() {
        return earliearReceivedAmount;
    }

    public void setEarliearReceivedAmount(Double earliearReceivedAmount) {
        this.earliearReceivedAmount = earliearReceivedAmount;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

}
