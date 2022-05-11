package gov.ifms.edp.dto;

import java.util.Objects;

/**
 * The Class EDPReportDto.
 */
public class EDPReportFileResponseDto {
	
	/** The base 64 string. */
	private String base64String;
	
	/** The file name. */
	private String fileName;
	
	/**
	 * @return the base64String
	 */
	public String getBase64String() {
		return base64String;
	}

	/**
	 * @param base64String the base64String to set
	 */
	public void setBase64String(String base64String) {
		this.base64String = base64String;
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
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(base64String, fileName);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPReportFileResponseDto)) {
			return false;
		}
		EDPReportFileResponseDto other = (EDPReportFileResponseDto) obj;
		return Objects.equals(base64String, other.base64String) && Objects.equals(fileName, other.fileName);
	}
	
	
}
