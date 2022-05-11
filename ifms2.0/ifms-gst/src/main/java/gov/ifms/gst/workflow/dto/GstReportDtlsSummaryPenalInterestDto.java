package gov.ifms.gst.workflow.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsSummaryPenalInterestDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsSummaryPenalInterestDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public GstReportDtlsSummaryPenalInterestDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private String nameOfBank;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTransaction;
	@NativeQueryResultColumn(index = 2)
	private Double penalInterestAmount;

	public GstReportDtlsSummaryPenalInterestDto(String nameOfBank, Integer noOfTransaction,
			Double penalInterestAmount) {
		super();
		this.nameOfBank = nameOfBank;
		this.noOfTransaction = noOfTransaction;
		this.penalInterestAmount = penalInterestAmount;
	}

	public String getNameOfBank() {
		return nameOfBank;
	}

	public void setNameOfBank(String nameOfBank) {
		this.nameOfBank = nameOfBank;
	}

	public Integer getNoOfTransaction() {
		return noOfTransaction;
	}

	public void setNoOfTransaction(Integer noOfTransaction) {
		this.noOfTransaction = noOfTransaction;
	}

	public Double getPenalInterestAmount() {
		return penalInterestAmount;
	}

	public void setPenalInterestAmount(Double penalInterestAmount) {
		this.penalInterestAmount = penalInterestAmount;
	}

}
