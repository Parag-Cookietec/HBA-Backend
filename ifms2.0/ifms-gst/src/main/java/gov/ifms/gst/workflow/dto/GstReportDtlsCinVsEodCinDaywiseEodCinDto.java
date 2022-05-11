package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCinVsEodCinDaywiseEodCinDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCinVsEodCinDaywiseEodCinDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls Cin Vs EodCin daywise eod cin dto.
	 */
	public GstReportDtlsCinVsEodCinDaywiseEodCinDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private Date date;
	@NativeQueryResultColumn(index = 1)
	private Integer noOfTransaction;
	@NativeQueryResultColumn(index = 2)
	private Double amount;


	public GstReportDtlsCinVsEodCinDaywiseEodCinDto(Date date, Integer noOfTransaction, Double amount) {
		super();
		this.date = date;
		this.noOfTransaction = noOfTransaction;
		this.amount = amount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getNoOfTransaction() {
		return noOfTransaction;
	}


	public void setNoOfTransaction(Integer noOfTransaction) {
		this.noOfTransaction = noOfTransaction;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
