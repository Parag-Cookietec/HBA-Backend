package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsBalMonBankwisePendingTrans8658ReportDto {

	@NativeQueryResultColumn(index = 0)
	private String bakname;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTransactions;
	@NativeQueryResultColumn(index = 2)
	private Double amount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public GstReportDtlsBalMonBankwisePendingTrans8658ReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the bakname
	 */
	public String getBakname() {
		return bakname;
	}

	/**
	 * @param bakname the bakname to set
	 */
	public void setBakname(String bakname) {
		this.bakname = bakname;
	}

	/**
	 * @return the noOfTransactions
	 */
	public Integer getNoOfTransactions() {
		return noOfTransactions;
	}

	/**
	 * @param noOfTransactions the noOfTransactions to set
	 */
	public void setNoOfTransactions(Integer noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
