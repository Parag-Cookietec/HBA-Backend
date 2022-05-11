package gov.ifms.gst.workflow.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsCinVsEodCinDifferenceDrillDownDto.
 *
 * @version 1.0
 * @created 2022/01/09 17:21:07
 *
 */
public class GstReportDtlsCinVsEodCinDifferenceDrillDownDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public GstReportDtlsCinVsEodCinDifferenceDrillDownDto() {
		super();
	}

	@NativeQueryResultColumn(index = 0)
	private Date date;
	@NativeQueryResultColumn(index = 1)
	private Integer cinNoOfTransaction;
	@NativeQueryResultColumn(index = 2)
	private Double cinAmount;
	@NativeQueryResultColumn(index = 3)
	private Integer eodCinNoOfTransaction;
	@NativeQueryResultColumn(index = 4)
	private Double eodCinAmount;


	public GstReportDtlsCinVsEodCinDifferenceDrillDownDto(Date date, Integer cinNoOfTransaction, Double cinAmount,
			Integer eodCinNoOfTransaction, Double eodCinAmount) {
		super();
		this.date = date;
		this.cinNoOfTransaction = cinNoOfTransaction;
		this.cinAmount = cinAmount;
		this.eodCinNoOfTransaction = eodCinNoOfTransaction;
		this.eodCinAmount = eodCinAmount;
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


	public Integer getEodCinNoOfTransaction() {
		return eodCinNoOfTransaction;
	}


	public void setEodCinNoOfTransaction(Integer eodCinNoOfTransaction) {
		this.eodCinNoOfTransaction = eodCinNoOfTransaction;
	}


	public Double getEodCinAmount() {
		return eodCinAmount;
	}


	public void setEodCinAmount(Double eodCinAmount) {
		this.eodCinAmount = eodCinAmount;
	}


}
