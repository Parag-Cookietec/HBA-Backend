package gov.ifms.gst.dto;

import java.sql.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class GstReportDtlsFileSummaryDto.
 *
 * @version v 1.0
 * @created 2022/01/23 21:58:33
 *
 */

public class GstReportDtlsFileSummaryDto {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/**
	 * Instantiates a new gst report dtls cin status dto.
	 */
	public GstReportDtlsFileSummaryDto() {
		super();
	}
	
	@NativeQueryResultColumn(index = 0)
	private String fileName;
	@NativeQueryResultColumn(index = 1)
	private Integer totalFile;
	@NativeQueryResultColumn(index = 2)
	private Integer totalChallans;
	@NativeQueryResultColumn(index = 3)
	private Double cgstAmount;
	@NativeQueryResultColumn(index = 4)
	private Double igstAmount;
	@NativeQueryResultColumn(index = 5)
	private Double sgstAmount;
	@NativeQueryResultColumn(index = 6)
	private Double totalAmount;


	/**
	 * @param fileName
	 * @param totalFile
	 * @param totalChallans
	 * @param cgstAmount
	 * @param igstAmount
	 * @param sgstAmount
	 * @param totalAmount
	 */
	public GstReportDtlsFileSummaryDto(String fileName, Integer totalFile, Integer totalChallans, Double cgstAmount,
			Double igstAmount, Double sgstAmount, Double totalAmount) {
		super();
		this.fileName = fileName;
		this.totalFile = totalFile;
		this.totalChallans = totalChallans;
		this.cgstAmount = cgstAmount;
		this.igstAmount = igstAmount;
		this.sgstAmount = sgstAmount;
		this.totalAmount = totalAmount;
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the totalFile
	 */
	public Integer getTotalFile() {
		return totalFile;
	}


	/**
	 * @param totalFile the totalFile to set
	 */
	public void setTotalFile(Integer totalFile) {
		this.totalFile = totalFile;
	}


	/**
	 * @return the totalChallans
	 */
	public Integer getTotalChallans() {
		return totalChallans;
	}


	/**
	 * @param totalChallans the totalChallans to set
	 */
	public void setTotalChallans(Integer totalChallans) {
		this.totalChallans = totalChallans;
	}


	/**
	 * @return the cgstAmount
	 */
	public Double getCgstAmount() {
		return cgstAmount;
	}


	/**
	 * @param cgstAmount the cgstAmount to set
	 */
	public void setCgstAmount(Double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}


	/**
	 * @return the igstAmount
	 */
	public Double getIgstAmount() {
		return igstAmount;
	}


	/**
	 * @param igstAmount the igstAmount to set
	 */
	public void setIgstAmount(Double igstAmount) {
		this.igstAmount = igstAmount;
	}


	/**
	 * @return the sgstAmount
	 */
	public Double getSgstAmount() {
		return sgstAmount;
	}


	/**
	 * @param sgstAmount the sgstAmount to set
	 */
	public void setSgstAmount(Double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}


	/**
	 * @return the totalAmount
	 */
	public Double getTotalAmount() {
		return totalAmount;
	}


	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
