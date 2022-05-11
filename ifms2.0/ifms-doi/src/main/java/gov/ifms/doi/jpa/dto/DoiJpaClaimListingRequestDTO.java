/**
 * 
 */
package gov.ifms.doi.jpa.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;

/**
 * @author Rudra
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoiJpaClaimListingRequestDTO extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -865234763050338224L;

	private Long district;
	
	private Long schemeType;
	
	private int month;
	
	private int year;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date fromDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date endDate;
	
	private String disabledDied;
	
	private String claimListingCriteria;

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	public Long getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(Long schemeType) {
		this.schemeType = schemeType;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDisabledDied() {
		return disabledDied;
	}

	public void setDisabledDied(String disabledDied) {
		this.disabledDied = disabledDied;
	}

	public String getClaimListingCriteria() {
		return claimListingCriteria;
	}

	public void setClaimListingCriteria(String claimListingCriteria) {
		this.claimListingCriteria = claimListingCriteria;
	}
}
