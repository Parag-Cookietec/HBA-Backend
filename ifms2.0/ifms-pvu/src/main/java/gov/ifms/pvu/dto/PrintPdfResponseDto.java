package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The PrintPdfResponseDto.
 *
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */
public class PrintPdfResponseDto  implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PrintPdfResponseDto [result=" + result + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(result);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrintPdfResponseDto other = (PrintPdfResponseDto) obj;
		return Objects.equals(result, other.result);
	}

	

}
