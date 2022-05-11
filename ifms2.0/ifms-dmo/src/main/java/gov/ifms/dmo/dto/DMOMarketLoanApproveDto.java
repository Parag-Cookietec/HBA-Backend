package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DMOMarketLoanApproveDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Long dpSheetId;
	
	private String sanctionOrderNo;

	private LocalDateTime sanctionOrderDt;
	
	private LocalDate loanReceiptDt;
	
	private Double loanAmount;
	
	private int loanTenure;
	
	private int moratoriumPeriod;
	
	private String tranDesc;
	
	private Double loanRoi;

	
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
	 * @return the dpSheetId
	 */
	public Long getDpSheetId() {
		return dpSheetId;
	}

	/**
	 * @param dpSheetId the dpSheetId to set
	 */
	public void setDpSheetId(Long dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	/**
	 * @return the sanctionOrderNo
	 */
	public String getSanctionOrderNo() {
		return sanctionOrderNo;
	}

	/**
	 * @param sanctionOrderNo the sanctionOrderNo to set
	 */
	public void setSanctionOrderNo(String sanctionOrderNo) {
		this.sanctionOrderNo = sanctionOrderNo;
	}

	/**
	 * @return the sanctionOrderDt
	 */
	public LocalDateTime getSanctionOrderDt() {
		return sanctionOrderDt;
	}

	/**
	 * @param sanctionOrderDt the sanctionOrderDt to set
	 */
	public void setSanctionOrderDt(LocalDateTime sanctionOrderDt) {
		this.sanctionOrderDt = sanctionOrderDt;
	}

	/**
	 * @return the loanReceiptDt
	 */
	public LocalDate getLoanReceiptDt() {
		return loanReceiptDt;
	}

	/**
	 * @param loanReceiptDt the loanReceiptDt to set
	 */
	public void setLoanReceiptDt(LocalDate loanReceiptDt) {
		this.loanReceiptDt = loanReceiptDt;
	}

	/**
	 * @return the loanAmount
	 */
	public Double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the loanTenure
	 */
	public int getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	/**
	 * @return the moratoriumPeriod
	 */
	public int getMoratoriumPeriod() {
		return moratoriumPeriod;
	}

	/**
	 * @param moratoriumPeriod the moratoriumPeriod to set
	 */
	public void setMoratoriumPeriod(int moratoriumPeriod) {
		this.moratoriumPeriod = moratoriumPeriod;
	}

	/**
	 * @return the tranDesc
	 */
	public String getTranDesc() {
		return tranDesc;
	}

	/**
	 * @param tranDesc the tranDesc to set
	 */
	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}

	/**
	 * @return the loanRoi
	 */
	public Double getLoanRoi() {
		return loanRoi;
	}

	/**
	 * @param loanRoi the loanRoi to set
	 */
	public void setLoanRoi(Double loanRoi) {
		this.loanRoi = loanRoi;
	}
	
	

}
