package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class PVURevisionOfPayAnnexureDto.
 *
 * @version v 1.0
 * @created 2020/04/20 
 */
@NativeQueryResultEntity
public class PVURevisionOfPayAnnexureView implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @NativeQueryResultColumn(index = 0)
    private String empName;
    
    @NativeQueryResultColumn(index = 1)
    private String empDesignation;
    
    @NativeQueryResultColumn(index = 2)
    private String empStatus;
    
    @NativeQueryResultColumn(index = 3)
    private String payBand;
    
    @NativeQueryResultColumn(index = 4)
    private String payBandId;
    
    @NativeQueryResultColumn(index = 5)
    private String gradePay;
    
    @NativeQueryResultColumn(index = 6)
    private String gradePayId;
    
    @NativeQueryResultColumn(index = 7)
    private String payLevel;
    
    @NativeQueryResultColumn(index = 8)
    private String payLevelId;
    
    @NativeQueryResultColumn(index = 9)
    private String payCellId;
    
    @NativeQueryResultColumn(index = 10)
    private String cellIdValue;
    
    @NativeQueryResultColumn(index = 11)
    private String rBasicPay;
    
    @NativeQueryResultColumn(index = 12)
    private String dateOfNextIncr;
    
    @NativeQueryResultColumn(index = 13)
    private String payBandValue;
    
    @NativeQueryResultColumn(index = 14)
    private String curentBasicPay;
    
    @NativeQueryResultColumn(index = 15)
    private String dearnessPay;
    
    @NativeQueryResultColumn(index = 16)
    private String dearnessAllowance;
    
    @NativeQueryResultColumn(index = 17)
    private String npaAmount;
    
    @NativeQueryResultColumn(index = 18)
    private String tExistingEmoluments;
    
    @NativeQueryResultColumn(index = 19)
    private String fitmentAmount;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getPayBand() {
		return payBand;
	}

	public void setPayBand(String payBand) {
		this.payBand = payBand;
	}

	public String getPayBandId() {
		return payBandId;
	}

	public void setPayBandId(String payBandId) {
		this.payBandId = payBandId;
	}

	public String getGradePay() {
		return gradePay;
	}

	public void setGradePay(String gradePay) {
		this.gradePay = gradePay;
	}

	public String getGradePayId() {
		return gradePayId;
	}

	public void setGradePayId(String gradePayId) {
		this.gradePayId = gradePayId;
	}

	public String getPayLevel() {
		return payLevel;
	}

	public void setPayLevel(String payLevel) {
		this.payLevel = payLevel;
	}

	public String getPayLevelId() {
		return payLevelId;
	}

	public void setPayLevelId(String payLevelId) {
		this.payLevelId = payLevelId;
	}

	public String getPayCellId() {
		return payCellId;
	}

	public void setPayCellId(String payCellId) {
		this.payCellId = payCellId;
	}

	public String getCellIdValue() {
		return cellIdValue;
	}

	public void setCellIdValue(String cellIdValue) {
		this.cellIdValue = cellIdValue;
	}

	public String getrBasicPay() {
		return rBasicPay;
	}

	public void setrBasicPay(String rBasicPay) {
		this.rBasicPay = rBasicPay;
	}

	public String getDateOfNextIncr() {
		return dateOfNextIncr;
	}

	public void setDateOfNextIncr(String dateOfNextIncr) {
		this.dateOfNextIncr = dateOfNextIncr;
	}

	public String getPayBandValue() {
		return payBandValue;
	}

	public void setPayBandValue(String payBandValue) {
		this.payBandValue = payBandValue;
	}

	public String getCurentBasicPay() {
		return curentBasicPay;
	}

	public void setCurentBasicPay(String curentBasicPay) {
		this.curentBasicPay = curentBasicPay;
	}

	public String getDearnessPay() {
		return dearnessPay;
	}

	public void setDearnessPay(String dearnessPay) {
		this.dearnessPay = dearnessPay;
	}

	public String getDearnessAllowance() {
		return dearnessAllowance;
	}

	public void setDearnessAllowance(String dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public String getNpaAmount() {
		return npaAmount;
	}

	public void setNpaAmount(String npaAmount) {
		this.npaAmount = npaAmount;
	}

	public String gettExistingEmoluments() {
		return tExistingEmoluments;
	}

	public void settExistingEmoluments(String tExistingEmoluments) {
		this.tExistingEmoluments = tExistingEmoluments;
	}

	public String getFitmentAmount() {
		return fitmentAmount;
	}

	public void setFitmentAmount(String fitmentAmount) {
		this.fitmentAmount = fitmentAmount;
	}

	@Override
	public String toString() {
		return "PVURevisionOfPayAnnexureView [empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empStatus=" + empStatus + ", payBand=" + payBand + ", payBandId=" + payBandId + ", gradePay="
				+ gradePay + ", gradePayId=" + gradePayId + ", payLevel=" + payLevel + ", payLevelId=" + payLevelId
				+ ", payCellId=" + payCellId + ", cellIdValue=" + cellIdValue + ", rBasicPay=" + rBasicPay
				+ ", dateOfNextIncr=" + dateOfNextIncr + ", payBandValue=" + payBandValue + ", curentBasicPay="
				+ curentBasicPay + ", dearnessPay=" + dearnessPay + ", dearnessAllowance=" + dearnessAllowance
				+ ", npaAmount=" + npaAmount + ", tExistingEmoluments=" + tExistingEmoluments + ", fitmentAmount="
				+ fitmentAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cellIdValue, curentBasicPay, dateOfNextIncr, dearnessAllowance, dearnessPay, empDesignation,
				empName, empStatus, fitmentAmount, gradePay, gradePayId, npaAmount, payBand, payBandId, payBandValue,
				payCellId, payLevel, payLevelId, rBasicPay, tExistingEmoluments);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PVURevisionOfPayAnnexureView)) {
			return false;
		}
		PVURevisionOfPayAnnexureView other = (PVURevisionOfPayAnnexureView) obj;
		return Objects.equals(cellIdValue, other.cellIdValue) && Objects.equals(curentBasicPay, other.curentBasicPay)
				&& Objects.equals(dateOfNextIncr, other.dateOfNextIncr)
				&& Objects.equals(dearnessAllowance, other.dearnessAllowance)
				&& Objects.equals(dearnessPay, other.dearnessPay)
				&& Objects.equals(empDesignation, other.empDesignation) && Objects.equals(empName, other.empName)
				&& Objects.equals(empStatus, other.empStatus) && Objects.equals(fitmentAmount, other.fitmentAmount)
				&& Objects.equals(gradePay, other.gradePay) && Objects.equals(gradePayId, other.gradePayId)
				&& Objects.equals(npaAmount, other.npaAmount) && Objects.equals(payBand, other.payBand)
				&& Objects.equals(payBandId, other.payBandId) && Objects.equals(payBandValue, other.payBandValue)
				&& Objects.equals(payCellId, other.payCellId) && Objects.equals(payLevel, other.payLevel)
				&& Objects.equals(payLevelId, other.payLevelId) && Objects.equals(rBasicPay, other.rBasicPay)
				&& Objects.equals(tExistingEmoluments, other.tExistingEmoluments);
	}

	
    
   
}
