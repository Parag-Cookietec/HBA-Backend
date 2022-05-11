package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCinVsEodCinDaywiseDrillDownDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCinVsEodCinDaywiseDrillDownDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls Cin Vs EodCin dto.
	 */
	public GstReportDtlsCinVsEodCinDaywiseDrillDownDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private Date date;
	@NativeQueryResultColumn(index = 1)
	private Integer cinEodNoOfTransaction;
	@NativeQueryResultColumn(index = 2)
	private Double cinEodAmount;
	@NativeQueryResultColumn(index = 3)
	private Integer cinNoOfTransaction;
	@NativeQueryResultColumn(index = 4)
	private Double cinAmount;
	@NativeQueryResultColumn(index = 5)
	private Integer differenceNoOfTransaction;
	@NativeQueryResultColumn(index = 6)
	private Double differenceEodAmount;


	public GstReportDtlsCinVsEodCinDaywiseDrillDownDto(Date date, Integer cinNoOfTransaction, Double cinAmount,
			Integer cinEodNoOfTransaction, Double cinEodAmount, Integer differenceNoOfTransaction,
			Double differenceEodAmount) {
		super();
		this.date = date;
		this.cinNoOfTransaction = cinNoOfTransaction;
		this.cinAmount = cinAmount;
		this.cinEodNoOfTransaction = cinEodNoOfTransaction;
		this.cinEodAmount = cinEodAmount;
		this.differenceNoOfTransaction = differenceNoOfTransaction;
		this.differenceEodAmount = differenceEodAmount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Integer getCinNoOfTransaction() {
		return cinNoOfTransaction;
	}


	public void setCinNoOfTransaction(Integer cinNoOfTransaction) {
		this.cinNoOfTransaction = cinNoOfTransaction;
	}


	public Double getCinAmount() {
		return cinAmount;
	}


	public void setCinAmount(Double cinAmount) {
		this.cinAmount = cinAmount;
	}


	public Integer getCinEodNoOfTransaction() {
		return cinEodNoOfTransaction;
	}


	public void setCinEodNoOfTransaction(Integer cinEodNoOfTransaction) {
		this.cinEodNoOfTransaction = cinEodNoOfTransaction;
	}


	public Double getCinEodAmount() {
		return cinEodAmount;
	}


	public void setCinEodAmount(Double cinEodAmount) {
		this.cinEodAmount = cinEodAmount;
	}


	public Integer getDifferenceNoOfTransaction() {
		return differenceNoOfTransaction;
	}


	public void setDifferenceNoOfTransaction(Integer differenceNoOfTransaction) {
		this.differenceNoOfTransaction = differenceNoOfTransaction;
	}


	public Double getDifferenceEodAmount() {
		return differenceEodAmount;
	}


	public void setDifferenceEodAmount(Double differenceEodAmount) {
		this.differenceEodAmount = differenceEodAmount;
	}


}
