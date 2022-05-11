package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import gov.ifms.edp.dto.BaseDto;

public class PVUEmployeTypeChangeDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tpvuRegPrboId;
	
	private Long tpvuRegPrboSdId;

    private Long officeId;
	
	private Long empId;
	
	private Long financialYearId;
	
	private String transNo;
	
	private LocalDateTime refDate;
	
	private String convOrderNo;
	
	private LocalDate convEffecDate;
	
	private LocalDate convOrderDate;
	
	private Long empPaytype;
	
	private Long payCommId; 
	
	private LocalDateTime cdateNextInc;

	private LocalDateTime dateNextInc;

	private Long statusId;
	
	private String officeName;

	private String empTypeName;

	private String desigName;

	private String className;
	
	private String status;
	
	private Long id;
	
	private Long currentEmpPaytype;
	
	private Long empIncEligible;
	
	private String panNo;
	
	private LocalDate retirementDate;
	
	private String empName;
	
	private Long emptype;
	
	private Long desigId;
	
	private Long empNo;
	
	private String doj;
	
	private LocalDate refFromDate;
	
	private LocalDate refToDate;
	
	private String errorCode;
	
	private String errortransNo;
	/**
	 * @return the tpvuRegPrboId
	 */
	public Long getTpvuRegPrboId() {
		return tpvuRegPrboId;
	}

	/**
	 * @param tpvuRegPrboId the tpvuRegPrboId to set
	 */
	public void setTpvuRegPrboId(Long tpvuRegPrboId) {
		this.tpvuRegPrboId = tpvuRegPrboId;
	}

	/**
	 * @return the officeId
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the empId
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * @return the financialYearId
	 */
	public Long getFinancialYearId() {
		return financialYearId;
	}

	/**
	 * @param financialYearId the financialYearId to set
	 */
	public void setFinancialYearId(Long financialYearId) {
		this.financialYearId = financialYearId;
	}

	/**
	 * @return the transNo
	 */
	public String getTransNo() {
		return transNo;
	}

	/**
	 * @param transNo the transNo to set
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * @return the refDate
	 */
	public LocalDateTime getRefDate() {
		return refDate;
	}

	/**
	 * @param refDate the refDate to set
	 */
	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	/**
	 * @return the convOrderNo
	 */
	public String getConvOrderNo() {
		return convOrderNo;
	}

	/**
	 * @param convOrderNo the convOrderNo to set
	 */
	public void setConvOrderNo(String convOrderNo) {
		this.convOrderNo = convOrderNo;
	}

	/**
	 * @return the convEffecDate
	 */
	public LocalDate getConvEffecDate() {
		return convEffecDate;
	}

	/**
	 * @param convEffecDate the convEffecDate to set
	 */
	public void setConvEffecDate(LocalDate convEffecDate) {
		this.convEffecDate = convEffecDate;
	}

	/**
	 * @return the convOrderDate
	 */
	public LocalDate getConvOrderDate() {
		return convOrderDate;
	}

	/**
	 * @param convOrderDate the convOrderDate to set
	 */
	public void setConvOrderDate(LocalDate convOrderDate) {
		this.convOrderDate = convOrderDate;
	}

	/**
	 * @return the empPaytype
	 */
	public Long getEmpPaytype() {
		return empPaytype;
	}

	/**
	 * @param empPaytype the empPaytype to set
	 */
	public void setEmpPaytype(Long empPaytype) {
		this.empPaytype = empPaytype;
	}

	/**
	 * @return the payCommId
	 */
	public Long getPayCommId() {
		return payCommId;
	}

	/**
	 * @param payCommId the payCommId to set
	 */
	public void setPayCommId(Long payCommId) {
		this.payCommId = payCommId;
	}

	/**
	 * @return the cdateNextInc
	 */
	public LocalDateTime getCdateNextInc() {
		return cdateNextInc;
	}

	/**
	 * @param cdateNextInc the cdateNextInc to set
	 */
	public void setCdateNextInc(LocalDateTime cdateNextInc) {
		this.cdateNextInc = cdateNextInc;
	}

	/**
	 * @return the dateNextInc
	 */
	public LocalDateTime getDateNextInc() {
		return dateNextInc;
	}

	/**
	 * @param dateNextInc the dateNextInc to set
	 */
	public void setDateNextInc(LocalDateTime dateNextInc) {
		this.dateNextInc = dateNextInc;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the empTypeName
	 */
	public String getEmpTypeName() {
		return empTypeName;
	}

	/**
	 * @param empTypeName the empTypeName to set
	 */
	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}

	/**
	 * @return the desigName
	 */
	public String getDesigName() {
		return desigName;
	}

	/**
	 * @param desigName the desigName to set
	 */
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the currentEmpPaytype
	 */
	public Long getCurrentEmpPaytype() {
		return currentEmpPaytype;
	}

	/**
	 * @param currentEmpPaytype the currentEmpPaytype to set
	 */
	public void setCurrentEmpPaytype(Long currentEmpPaytype) {
		this.currentEmpPaytype = currentEmpPaytype;
	}

	/**
	 * @return the empIncEligible
	 */
	public Long getEmpIncEligible() {
		return empIncEligible;
	}

	/**
	 * @param empIncEligible the empIncEligible to set
	 */
	public void setEmpIncEligible(Long empIncEligible) {
		this.empIncEligible = empIncEligible;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cdateNextInc, className, convEffecDate, convOrderDate, convOrderNo,
				currentEmpPaytype, dateNextInc, desigName,  empId, empIncEligible, empPaytype,
				empTypeName, financialYearId, id, officeId, officeName, payCommId, refDate, status, statusId,
				tpvuRegPrboId, transNo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUEmployeTypeChangeDto)) {
			return false;
		}
		PVUEmployeTypeChangeDto other = (PVUEmployeTypeChangeDto) obj;
		return Objects.equals(cdateNextInc, other.cdateNextInc) && Objects.equals(className, other.className)
				&& Objects.equals(convEffecDate, other.convEffecDate)
				&& Objects.equals(convOrderDate, other.convOrderDate) && Objects.equals(convOrderNo, other.convOrderNo)
				&& Objects.equals(currentEmpPaytype, other.currentEmpPaytype)
				&& Objects.equals(dateNextInc, other.dateNextInc) && Objects.equals(desigName, other.desigName)
				&& Objects.equals(empId, other.empId)
				&& Objects.equals(empIncEligible, other.empIncEligible) && Objects.equals(empPaytype, other.empPaytype)
				&& Objects.equals(empTypeName, other.empTypeName)
				&& Objects.equals(financialYearId, other.financialYearId) && Objects.equals(id, other.id)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(officeName, other.officeName)
				&& Objects.equals(payCommId, other.payCommId) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(status, other.status) && Objects.equals(statusId, other.statusId)
				&& Objects.equals(tpvuRegPrboId, other.tpvuRegPrboId) && Objects.equals(transNo, other.transNo);
	}

	/**
	 * @return the tpvuRegPrboSdId
	 */
	public Long getTpvuRegPrboSdId() {
		return tpvuRegPrboSdId;
	}

	/**
	 * @param tpvuRegPrboSdId the tpvuRegPrboSdId to set
	 */
	public void setTpvuRegPrboSdId(Long tpvuRegPrboSdId) {
		this.tpvuRegPrboSdId = tpvuRegPrboSdId;
	}

	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}

	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	/**
	 * @return the retirementDate
	 */
	public LocalDate getRetirementDate() {
		return retirementDate;
	}

	/**
	 * @param retirementDate the retirementDate to set
	 */
	public void setRetirementDate(LocalDate retirementDate) {
		this.retirementDate = retirementDate;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the emptype
	 */
	public Long getEmptype() {
		return emptype;
	}

	/**
	 * @param emptype the emptype to set
	 */
	public void setEmptype(Long emptype) {
		this.emptype = emptype;
	}

	/**
	 * @return the desigId
	 */
	public Long getDesigId() {
		return desigId;
	}

	/**
	 * @param desigId the desigId to set
	 */
	public void setDesigId(Long desigId) {
		this.desigId = desigId;
	}

	/**
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the doj
	 */
	public String getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(String doj) {
		this.doj = doj;
	}

	/**
	 * @return the refFromDate
	 */
	public LocalDate getRefFromDate() {
		return refFromDate;
	}

	/**
	 * @param refFromDate the refFromDate to set
	 */
	public void setRefFromDate(LocalDate refFromDate) {
		this.refFromDate = refFromDate;
	}

	/**
	 * @return the refToDate
	 */
	public LocalDate getRefToDate() {
		return refToDate;
	}

	/**
	 * @param refToDate the refToDate to set
	 */
	public void setRefToDate(LocalDate refToDate) {
		this.refToDate = refToDate;
	}

	/**
	 * @return the errortransNo
	 */
	public String getErrortransNo() {
		return errortransNo;
	}

	/**
	 * @param errortransNo the errortransNo to set
	 */
	public void setErrortransNo(String errortransNo) {
		this.errortransNo = errortransNo;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	
}
