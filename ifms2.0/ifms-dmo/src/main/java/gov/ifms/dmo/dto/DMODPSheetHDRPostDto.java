package gov.ifms.dmo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetHDRPostDto implements Serializable {

	private static final long serialVersionUID = 1L;
	/** The Date of Previous DP Sheet Submitted */
	private String dpSheetReciveDate;
	/** The DP Sheet Entry Sheet Date **/
	private String dpSheetDate;
	/** The Gujarat Advice Code. **/
	private int gogCode;
	/**
	 * The page index.
	 */
	private int pageIndex = 0;
	/**
	 * The page element.
	 */
	private int pageElement = 10;

	public String getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	public void setDpSheetReciveDate(String dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

	public String getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(String dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
	}

	public int getGogCode() {
		return gogCode;
	}

	public void setGogCode(int gogCode) {
		this.gogCode = gogCode;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageElement() {
		return pageElement;
	}

	public void setPageElement(int pageElement) {
		this.pageElement = pageElement;
	}

}
