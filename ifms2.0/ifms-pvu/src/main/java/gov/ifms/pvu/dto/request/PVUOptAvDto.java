package gov.ifms.pvu.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PVUOptAvDto implements Serializable {
    /** The serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private Long payCommissionId;

    //5th pay
    private Long cPayScaleId;

    private Long pPayScaleId;

    private long pBasicPayValue;

    //6th
    private Long cPayBandId;

    private Long cGradePayId;

    private Long pPayBandId;

    private Long pGradePayId;

    private Long pPayBandValue;

    private Long oaPayBandValue;

    private Long empDeptCatId;

    //7th
    private String cPayLevelValue;

    private Long cCellIdValue;

    private String pPayLevelValue;

    private Long pCellIdValue;

    private Long pPayCellId;

    //All output
    private Long oaBasicPayValue;

    public Long getPayCommissionId() {
        return payCommissionId;
    }

    public void setPayCommissionId(Long payCommissionId) {
        this.payCommissionId = payCommissionId;
    }

    public Long getcPayScaleId() {
        return cPayScaleId;
    }

    public void setcPayScaleId(Long cPayScaleId) {
        this.cPayScaleId = cPayScaleId;
    }

    public Long getpPayScaleId() {
        return pPayScaleId;
    }

    public void setpPayScaleId(Long pPayScaleId) {
        this.pPayScaleId = pPayScaleId;
    }

    public long getpBasicPayValue() {
        return pBasicPayValue;
    }

    public void setpBasicPayValue(long pBasicPayValue) {
        this.pBasicPayValue = pBasicPayValue;
    }

    public Long getcPayBandId() {
        return cPayBandId;
    }

    public void setcPayBandId(Long cPayBandId) {
        this.cPayBandId = cPayBandId;
    }

    public Long getcGradePayId() {
        return cGradePayId;
    }

    public void setcGradePayId(Long cGradePayId) {
        this.cGradePayId = cGradePayId;
    }

    public Long getpPayBandId() {
        return pPayBandId;
    }

    public void setpPayBandId(Long pPayBandId) {
        this.pPayBandId = pPayBandId;
    }

    public Long getpGradePayId() {
        return pGradePayId;
    }

    public void setpGradePayId(Long pGradePayId) {
        this.pGradePayId = pGradePayId;
    }

    public Long getpPayBandValue() {
        return pPayBandValue;
    }

    public void setpPayBandValue(Long pPayBandValue) {
        this.pPayBandValue = pPayBandValue;
    }

    public String getcPayLevelValue() {
        return cPayLevelValue;
    }

    public void setcPayLevelValue(String cPayLevelValue) {
        this.cPayLevelValue = cPayLevelValue;
    }

    public Long getcCellIdValue() {
        return cCellIdValue;
    }

    public void setcCellIdValue(Long cCellIdValue) {
        this.cCellIdValue = cCellIdValue;
    }

    public String getpPayLevelValue() {
        return pPayLevelValue;
    }

    public void setpPayLevelValue(String pPayLevelValue) {
        this.pPayLevelValue = pPayLevelValue;
    }

    public Long getpCellIdValue() {
        return pCellIdValue;
    }

    public void setpCellIdValue(Long pCellIdValue) {
        this.pCellIdValue = pCellIdValue;
    }

    public Long getOaBasicPayValue() {
        return oaBasicPayValue;
    }

    public void setOaBasicPayValue(Long oaBasicPayValue) {
        this.oaBasicPayValue = oaBasicPayValue;
    }

    public Long getpPayCellId() {
        return pPayCellId;
    }

    public void setpPayCellId(Long pPayCellId) {
        this.pPayCellId = pPayCellId;
    }

    public Long getOaPayBandValue() {
        return oaPayBandValue;
    }

    public void setOaPayBandValue(Long oaPayBandValue) {
        this.oaPayBandValue = oaPayBandValue;
    }

    public Long getEmpDeptCatId() {
        return empDeptCatId;
    }

    public void setEmpDeptCatId(Long empDeptCatId) {
        this.empDeptCatId = empDeptCatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PVUOptAvDto that = (PVUOptAvDto) o;
        return pBasicPayValue == that.pBasicPayValue &&
                Objects.equals(payCommissionId, that.payCommissionId) &&
                Objects.equals(cPayScaleId, that.cPayScaleId) &&
                Objects.equals(pPayScaleId, that.pPayScaleId) &&
                Objects.equals(cPayBandId, that.cPayBandId) &&
                Objects.equals(cGradePayId, that.cGradePayId) &&
                Objects.equals(pPayBandId, that.pPayBandId) &&
                Objects.equals(pGradePayId, that.pGradePayId) &&
                Objects.equals(pPayBandValue, that.pPayBandValue) &&
                Objects.equals(oaPayBandValue, that.oaPayBandValue) &&
                Objects.equals(empDeptCatId, that.empDeptCatId) &&
                Objects.equals(cPayLevelValue, that.cPayLevelValue) &&
                Objects.equals(cCellIdValue, that.cCellIdValue) &&
                Objects.equals(pPayLevelValue, that.pPayLevelValue) &&
                Objects.equals(pCellIdValue, that.pCellIdValue) &&
                Objects.equals(pPayCellId, that.pPayCellId) &&
                Objects.equals(oaBasicPayValue, that.oaBasicPayValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payCommissionId, cPayScaleId, pPayScaleId, pBasicPayValue, cPayBandId, cGradePayId, pPayBandId, pGradePayId, pPayBandValue, oaPayBandValue, empDeptCatId, cPayLevelValue, cCellIdValue, pPayLevelValue, pCellIdValue, pPayCellId, oaBasicPayValue);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PVUOptAvDto{");
        sb.append("payCommissionId=").append(payCommissionId);
        sb.append(", cPayScaleId=").append(cPayScaleId);
        sb.append(", pPayScaleId=").append(pPayScaleId);
        sb.append(", pBasicPayValue=").append(pBasicPayValue);
        sb.append(", cPayBandId=").append(cPayBandId);
        sb.append(", cGradePayId=").append(cGradePayId);
        sb.append(", pPayBandId=").append(pPayBandId);
        sb.append(", pGradePayId=").append(pGradePayId);
        sb.append(", pPayBandValue=").append(pPayBandValue);
        sb.append(", oaPayBandValue=").append(oaPayBandValue);
        sb.append(", empDeptCatId=").append(empDeptCatId);
        sb.append(", cPayLevelValue='").append(cPayLevelValue).append('\'');
        sb.append(", cCellIdValue=").append(cCellIdValue);
        sb.append(", pPayLevelValue='").append(pPayLevelValue).append('\'');
        sb.append(", pCellIdValue=").append(pCellIdValue);
        sb.append(", pPayCellId=").append(pPayCellId);
        sb.append(", oaBasicPayValue=").append(oaBasicPayValue);
        sb.append('}');
        return sb.toString();
    }
}
