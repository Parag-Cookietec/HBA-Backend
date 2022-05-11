package gov.ifms.dmo.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class DMODPSheetSearchDto implements Serializable {

	private static final long serialVersionUID = 1L;
	@NativeQueryResultColumn(index = 0)
	private String dpSheetId;
	@NativeQueryResultColumn(index = 1)
	private String financialYear;
	@NativeQueryResultColumn(index = 2)
	private String refNo;
	@NativeQueryResultColumn(index = 3)
	private String refDate;
	@NativeQueryResultColumn(index = 4)
	private String dpSheetDate;
	private String rcvdFrOn;
	private String sentToOn;
	private String lyingWith;
	private String wfSts;
	private String sts;
	@NativeQueryResultColumn(index = 6)
	private int gogCode;
	@NativeQueryResultColumn(index = 7)
	private String dpSheetReciveDate;
	@NativeQueryResultColumn(index = 8)
	private long count;

	public String getDpSheetId() {
		return dpSheetId;
	}

	public void setDpSheetId(String dpSheetId) {
		this.dpSheetId = dpSheetId;
	}

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getRefDate() {
		return refDate;
	}

	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}

	public String getDpSheetDate() {
		return dpSheetDate;
	}

	public void setDpSheetDate(String dpSheetDate) {
		this.dpSheetDate = dpSheetDate;
	}

	public String getRcvdFrOn() {
		return rcvdFrOn;
	}

	public void setRcvdFrOn(String rcvdFrOn) {
		this.rcvdFrOn = rcvdFrOn;
	}

	public String getSentToOn() {
		return sentToOn;
	}

	public void setSentToOn(String sentToOn) {
		this.sentToOn = sentToOn;
	}

	public String getLyingWith() {
		return lyingWith;
	}

	public void setLyingWith(String lyingWith) {
		this.lyingWith = lyingWith;
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

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getGogCode() {
		return gogCode;
	}

	public void setGogCode(int gogCode) {
		this.gogCode = gogCode;
	}

	public String getDpSheetReciveDate() {
		return dpSheetReciveDate;
	}

	public void setDpSheetReciveDate(String dpSheetReciveDate) {
		this.dpSheetReciveDate = dpSheetReciveDate;
	}

}
