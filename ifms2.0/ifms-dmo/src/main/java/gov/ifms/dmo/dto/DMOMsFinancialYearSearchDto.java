package gov.ifms.dmo.dto;

import javax.persistence.Lob;

/**
 * The Class DMOMsFinancialYearSearchDto.
 */
public class DMOMsFinancialYearSearchDto {

	private String fromYearId = "";
	private String toYearId = "";
	@Lob
	private String getResult;
	public String getFromYearId() {
		return fromYearId;
	}
	public void setFromYearId(String fromYearId) {
		this.fromYearId = fromYearId;
	}
	public String getToYearId() {
		return toYearId;
	}
	public void setToYearId(String toYearId) {
		this.toYearId = toYearId;
	}
	public String getGetResult() {
		return getResult;
	}
	public void setGetResult(String getResult) {
		this.getResult = getResult;
	}
	
	
	
}
