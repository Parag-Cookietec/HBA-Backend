package gov.ifms.dmo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMODPSheetSearchHDRPostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * The page index.
	 */
	private int pageIndex = 0;
	/**
	 * The page element.
	 */
	private int pageElement = 10;
	private String fy;
	private String dpSheetFrDt;
	private String dpSheetToDt;
	private String refNo;
	private String refNoFrDt;
	private String refNoToDt;
	private String rcvdFrOrTo;
	private String sentTo;
	private String wfSts;
	private String sts;

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

	public String getFy() {
		return fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getDpSheetFrDt() {
		return dpSheetFrDt;
	}

	public void setDpSheetFrDt(String dpSheetFrDt) {
		this.dpSheetFrDt = dpSheetFrDt;
	}

	public String getDpSheetToDt() {
		return dpSheetToDt;
	}

	public void setDpSheetToDt(String dpSheetToDt) {
		this.dpSheetToDt = dpSheetToDt;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getRefNoFrDt() {
		return refNoFrDt;
	}

	public void setRefNoFrDt(String refNoFrDt) {
		this.refNoFrDt = refNoFrDt;
	}

	public String getRefNoToDt() {
		return refNoToDt;
	}

	public void setRefNoToDt(String refNoToDt) {
		this.refNoToDt = refNoToDt;
	}

	public String getRcvdFrOrTo() {
		return rcvdFrOrTo;
	}

	public void setRcvdFrOrTo(String rcvdFrOrTo) {
		this.rcvdFrOrTo = rcvdFrOrTo;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getWfSts() {
		return wfSts;
	}

	public void setWfSts(String wfSts) {
		this.wfSts = wfSts;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

}
