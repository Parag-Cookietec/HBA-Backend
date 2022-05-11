package gov.ifms.edp.report.dto;

import java.io.Serializable;

/**
 * The Class CommonReportPdfResponseDto.
 */
public class CommonReportFileResponseDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The base 64 string. */
	private String base64String;
	
	/** The file name. */
	private String fileName;

	/**
	 * Gets the base 64 string.
	 *
	 * @return the base 64 string
	 */
	public String getBase64String() {
		return base64String;
	}

	/**
	 * Sets the base 64 string.
	 *
	 * @param base64String the new base 64 string
	 */
	public void setBase64String(String base64String) {
		this.base64String = base64String;
	}

	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
