package gov.ifms.pvu.dto;

import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * The Class PVURevisionOfPayDto.
 *
 * @version v 1.0
 * @created 2020/01/09 12:59:56
 */
public class PVURevisionOfPayEmployeeDto extends BaseDto implements Serializable {

    /**
     * The serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private long revisionOfPayId;

    private String transNo;

    private long payCommFor;

    private LocalDate payCommEffDate;

    private LocalDate nextIncrDate;

    private long statusId;

    private long employeeId;

    private long sevenPayLevel;

    private long sevenPayCellId;

    private long sixPayBand;

    private long sixPayBandValue;

    private long sixGradePay;

    private long reasonForExcludeId;

    private long revBasicPay;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRevisionOfPayId() {
        return revisionOfPayId;
    }

    public void setRevisionOfPayId(long revisionOfPayId) {
        this.revisionOfPayId = revisionOfPayId;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public long getPayCommFor() {
        return payCommFor;
    }

    public void setPayCommFor(long payCommFor) {
        this.payCommFor = payCommFor;
    }

    public LocalDate getPayCommEffDate() {
        return payCommEffDate;
    }

    public void setPayCommEffDate(LocalDate payCommEffDate) {
        this.payCommEffDate = payCommEffDate;
    }

    public LocalDate getNextIncrDate() {
        return nextIncrDate;
    }

    public void setNextIncrDate(LocalDate nextIncrDate) {
        this.nextIncrDate = nextIncrDate;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getSevenPayLevel() {
        return sevenPayLevel;
    }

    public void setSevenPayLevel(long sevenPayLevel) {
        this.sevenPayLevel = sevenPayLevel;
    }

    public long getSevenPayCellId() {
        return sevenPayCellId;
    }

    public void setSevenPayCellId(long sevenPayCellId) {
        this.sevenPayCellId = sevenPayCellId;
    }

    public long getSixPayBand() {
        return sixPayBand;
    }

    public void setSixPayBand(long sixPayBand) {
        this.sixPayBand = sixPayBand;
    }

    public long getSixGradePay() {
        return sixGradePay;
    }

    public void setSixGradePay(long sixGradePay) {
        this.sixGradePay = sixGradePay;
    }

    public long getReasonForExcludeId() {
        return reasonForExcludeId;
    }

    public void setReasonForExcludeId(long reasonForExcludeId) {
        this.reasonForExcludeId = reasonForExcludeId;
    }

    public long getRevBasicPay() {
        return revBasicPay;
    }

    public void setRevBasicPay(long revBasicPay) {
        this.revBasicPay = revBasicPay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PVURevisionOfPayEmployeeDto)) return false;
        PVURevisionOfPayEmployeeDto that = (PVURevisionOfPayEmployeeDto) o;
        return getId() == that.getId() &&
                getRevisionOfPayId() == that.getRevisionOfPayId() &&
                getPayCommFor() == that.getPayCommFor() &&
                getStatusId() == that.getStatusId() &&
                getEmployeeId() == that.getEmployeeId() &&
                getSevenPayLevel() == that.getSevenPayLevel() &&
                getSevenPayCellId() == that.getSevenPayCellId() &&
                getSixPayBand() == that.getSixPayBand() &&
                sixPayBandValue == that.sixPayBandValue &&
                getSixGradePay() == that.getSixGradePay() &&
                getReasonForExcludeId() == that.getReasonForExcludeId() &&
                getRevBasicPay() == that.getRevBasicPay() &&
                Objects.equals(getTransNo(), that.getTransNo()) &&
                Objects.equals(getPayCommEffDate(), that.getPayCommEffDate()) &&
                Objects.equals(getNextIncrDate(), that.getNextIncrDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRevisionOfPayId(), getTransNo(), getPayCommFor(), getPayCommEffDate(), getNextIncrDate(), getStatusId(), getEmployeeId(), getSevenPayLevel(), getSevenPayCellId(), getSixPayBand(), sixPayBandValue, getSixGradePay(), getReasonForExcludeId(), getRevBasicPay());
    }

    @Override
    public String toString() {
        return "PVURevisionOfPayEmployeeDto{" +
                "id=" + id +
                ", revisionOfPayId=" + revisionOfPayId +
                ", transNo='" + transNo + '\'' +
                ", payCommFor=" + payCommFor +
                ", payCommEffDate=" + payCommEffDate +
                ", nextIncrDate=" + nextIncrDate +
                ", statusId=" + statusId +
                ", employeeId=" + employeeId +
                ", sevenPayLevel=" + sevenPayLevel +
                ", sevenPayCellId=" + sevenPayCellId +
                ", sixPayBand=" + sixPayBand +
                ", sixPayBandValue=" + sixPayBandValue +
                ", sixGradePay=" + sixGradePay +
                ", reasonForExcludeId=" + reasonForExcludeId +
                ", revBasicPay=" + revBasicPay +
                '}';
    }
}
