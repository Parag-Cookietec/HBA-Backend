package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;

@Entity
@Table(name = "T_PVU_ADHC_PROB_REGLR", schema = Constant.PVU_SCHEMA)
public class PVUEmployeTypeChangeEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PVU_ADHC_PROB_REGLR_ID")
	private Long tpvuRegPrboId;
	
	@Column(name = "PVU_ADHC_PROB_REGLR_SD_ID")
	private Long tpvuRegPrboSdId;

	@Column(name = "OFFICE_ID")
    private Long officeId;
	
	@Column(name = "EMP_ID")
	private Long empId;
	
	@Column(name = "FINANCIAL_YEAR")
	private Long financialYearId;
	
	@Column(name = "TRN_NO")
	private String transNo;
	
	@Column(name = "REF_DATE")
	private LocalDateTime refDate;
	
	@Column(name = "CONV_ORDER_NO")
	private String convOrderNo;
	
	@Column(name = "CONV_EFF_DATE")
	private LocalDate convEffecDate;
	
	@Column(name = "CONV_ORDER_DATE")
	private LocalDate convOrderDate;
	
	@Column(name = "EMP_PAY_TYPE")
	private Long empPaytype;
	
	@Column(name = "PAY_COMM")
	private Long payCommId; 
	
	@Column(name = "C_DATE_NXT_INCR")
	private LocalDateTime cdateNextInc;

	@Column(name = "DATE_NXT_INCR")
	private LocalDateTime dateNextInc;

	@Column(name = "STATUS_ID")
	private Long statusId;
	
	@Column(name = "C_PAY_TYPE")
	private Long currentEmpPaytype;

	@Column(name = "EMP_INC_ELIGIBLE")
	private Long empIncEligible;

	public PVUEmployeTypeChangeEntity(Long transactionId) {
	}
	
	public PVUEmployeTypeChangeEntity() {
	}


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

//	/**
//	 * @return the empChangeType
//	 */
//	public Long getEmpChangeType() {
//		return empChangeType;
//	}
//
//	/**
//	 * @param empChangeType the empChangeType to set
//	 */
//	public void setEmpChangeType(Long empChangeType) {
//		this.empChangeType = empChangeType;
//	}
//
//	/**
//	 * @return the empIncEligible
//	 */
//	public Long getEmpIncEligible() {
//		return empIncEligible;
//	}
//
//	/**
//	 * @param empIncEligible the empIncEligible to set
//	 */
//	public void setEmpIncEligible(Long empIncEligible) {
//		this.empIncEligible = empIncEligible;
//	}

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

	@Override
	public int hashCode() {
		return Objects.hash(cdateNextInc, convEffecDate, convOrderDate, convOrderNo, currentEmpPaytype, dateNextInc,
				empId, empPaytype, financialYearId, officeId, payCommId, refDate, statusId, tpvuRegPrboId,
				tpvuRegPrboSdId, transNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUEmployeTypeChangeEntity)) {
			return false;
		}
		PVUEmployeTypeChangeEntity other = (PVUEmployeTypeChangeEntity) obj;
		return Objects.equals(cdateNextInc, other.cdateNextInc) && Objects.equals(convEffecDate, other.convEffecDate)
				&& Objects.equals(convOrderDate, other.convOrderDate) && Objects.equals(convOrderNo, other.convOrderNo)
				&& Objects.equals(currentEmpPaytype, other.currentEmpPaytype)
				&& Objects.equals(dateNextInc, other.dateNextInc) && Objects.equals(empId, other.empId)
				&& Objects.equals(empPaytype, other.empPaytype)
				&& Objects.equals(financialYearId, other.financialYearId) && Objects.equals(officeId, other.officeId)
				&& Objects.equals(payCommId, other.payCommId) && Objects.equals(refDate, other.refDate)
				&& Objects.equals(statusId, other.statusId) && Objects.equals(tpvuRegPrboId, other.tpvuRegPrboId)
				&& Objects.equals(tpvuRegPrboSdId, other.tpvuRegPrboSdId) && Objects.equals(transNo, other.transNo);
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
}
