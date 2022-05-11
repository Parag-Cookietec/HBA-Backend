package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;

public class GstReportDtlsGSTNRBIFileSummaryReceivedReportDto {

	@NativeQueryResultColumn(index = 0)
	private String fileTypeCode;
	@NativeQueryResultColumn(index = 1)
	private String eodClosed;
	@NativeQueryResultColumn(index = 2)
	private String gstnOrRbi;
	@NativeQueryResultColumn(index = 3)
	private String isFileProcessed;
	@NativeQueryResultColumn(index = 4)	
	private Integer filesToBeDownloadedCount;
	@NativeQueryResultColumn(index = 5)
	private Double filesToBeDownloadedAmount;	
	@NativeQueryResultColumn(index = 6)
	private Integer filesDownloadedCount;
	@NativeQueryResultColumn(index = 7)	
	private Double filesDownloadedAmount;	
	@NativeQueryResultColumn(index = 8)
	private Integer pendingToBeDownloadedCount;
	@NativeQueryResultColumn(index = 9)
	private Double pendingToBeDownloadedAmount;
	
	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public GstReportDtlsGSTNRBIFileSummaryReceivedReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the fileTypeCode
	 */
	public String getFileTypeCode() {
		return fileTypeCode;
	}

	/**
	 * @param fileTypeCode the fileTypeCode to set
	 */
	public void setFileTypeCode(String fileTypeCode) {
		this.fileTypeCode = fileTypeCode;
	}

	/**
	 * @return the eodClosed
	 */
	public String getEodClosed() {
		return eodClosed;
	}

	/**
	 * @param eodClosed the eodClosed to set
	 */
	public void setEodClosed(String eodClosed) {
		this.eodClosed = eodClosed;
	}

	/**
	 * @return the gstnOrRbi
	 */
	public String getGstnOrRbi() {
		return gstnOrRbi;
	}

	/**
	 * @param gstnOrRbi the gstnOrRbi to set
	 */
	public void setGstnOrRbi(String gstnOrRbi) {
		this.gstnOrRbi = gstnOrRbi;
	}

	/**
	 * @return the isFileProcessed
	 */
	public String getIsFileProcessed() {
		return isFileProcessed;
	}

	/**
	 * @param isFileProcessed the isFileProcessed to set
	 */
	public void setIsFileProcessed(String isFileProcessed) {
		this.isFileProcessed = isFileProcessed;
	}

	/**
	 * @return the filesToBeDownloadedCount
	 */
	public Integer getFilesToBeDownloadedCount() {
		return filesToBeDownloadedCount;
	}

	/**
	 * @param filesToBeDownloadedCount the filesToBeDownloadedCount to set
	 */
	public void setFilesToBeDownloadedCount(Integer filesToBeDownloadedCount) {
		this.filesToBeDownloadedCount = filesToBeDownloadedCount;
	}

	/**
	 * @return the filesToBeDownloadedAmount
	 */
	public Double getFilesToBeDownloadedAmount() {
		return filesToBeDownloadedAmount;
	}

	/**
	 * @param filesToBeDownloadedAmount the filesToBeDownloadedAmount to set
	 */
	public void setFilesToBeDownloadedAmount(Double filesToBeDownloadedAmount) {
		this.filesToBeDownloadedAmount = filesToBeDownloadedAmount;
	}

	/**
	 * @return the filesDownloadedCount
	 */
	public Integer getFilesDownloadedCount() {
		return filesDownloadedCount;
	}

	/**
	 * @param filesDownloadedCount the filesDownloadedCount to set
	 */
	public void setFilesDownloadedCount(Integer filesDownloadedCount) {
		this.filesDownloadedCount = filesDownloadedCount;
	}

	/**
	 * @return the filesDownloadedAmount
	 */
	public Double getFilesDownloadedAmount() {
		return filesDownloadedAmount;
	}

	/**
	 * @param filesDownloadedAmount the filesDownloadedAmount to set
	 */
	public void setFilesDownloadedAmount(Double filesDownloadedAmount) {
		this.filesDownloadedAmount = filesDownloadedAmount;
	}

	/**
	 * @return the pendingToBeDownloadedCount
	 */
	public Integer getPendingToBeDownloadedCount() {
		return pendingToBeDownloadedCount;
	}

	/**
	 * @param pendingToBeDownloadedCount the pendingToBeDownloadedCount to set
	 */
	public void setPendingToBeDownloadedCount(Integer pendingToBeDownloadedCount) {
		this.pendingToBeDownloadedCount = pendingToBeDownloadedCount;
	}

	/**
	 * @return the pendingToBeDownloadedAmount
	 */
	public Double getPendingToBeDownloadedAmount() {
		return pendingToBeDownloadedAmount;
	}

	/**
	 * @param pendingToBeDownloadedAmount the pendingToBeDownloadedAmount to set
	 */
	public void setPendingToBeDownloadedAmount(Double pendingToBeDownloadedAmount) {
		this.pendingToBeDownloadedAmount = pendingToBeDownloadedAmount;
	}
}
