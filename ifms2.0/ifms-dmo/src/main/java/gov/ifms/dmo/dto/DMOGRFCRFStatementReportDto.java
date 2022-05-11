package gov.ifms.dmo.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class DMOGRFCRFStatementReportDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String id;

	@NativeQueryResultColumn(index = 1)
	private String saleDetailId;

	@NativeQueryResultColumn(index = 2)
	private String saleDate;

	@NativeQueryResultColumn(index = 3)
	private String currAccBal;

	@NativeQueryResultColumn(index = 4)
	private String scurityTypeId;

	@NativeQueryResultColumn(index = 5)
	private String currFaceVal;

	@NativeQueryResultColumn(index = 6)
	private String salePrice;

	@NativeQueryResultColumn(index = 7)
	private String brokenDays;

	@NativeQueryResultColumn(index = 8)
	private String accrIntrstRecvd;

	@NativeQueryResultColumn(index = 9)
	private String stAccTrfrAmt;

	@NativeQueryResultColumn(index = 10)
	private String progBalAcc;
	
	@NativeQueryResultColumn(index = 11)
	private String costValue;
	
	@NativeQueryResultColumn(index = 12)
	private String brokenPeriodInterest;

	@NativeQueryResultColumn(index = 13)
	private long count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSaleDetailId() {
		return saleDetailId;
	}

	public void setSaleDetailId(String saleDetailId) {
		this.saleDetailId = saleDetailId;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getCurrAccBal() {
		return currAccBal;
	}

	public void setCurrAccBal(String currAccBal) {
		this.currAccBal = currAccBal;
	}

	public String getScurityTypeId() {
		return scurityTypeId;
	}

	public void setScurityTypeId(String scurityTypeId) {
		this.scurityTypeId = scurityTypeId;
	}

	public String getCurrFaceVal() {
		return currFaceVal;
	}

	public void setCurrFaceVal(String currFaceVal) {
		this.currFaceVal = currFaceVal;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	public String getBrokenDays() {
		return brokenDays;
	}

	public void setBrokenDays(String brokenDays) {
		this.brokenDays = brokenDays;
	}

	public String getBrokenPeriodInterest() {
		return brokenPeriodInterest;
	}

	public void setBrokenPeriodInterest(String brokenPeriodInterest) {
		this.brokenPeriodInterest = brokenPeriodInterest;
	}

	public String getStAccTrfrAmt() {
		return stAccTrfrAmt;
	}

	public void setStAccTrfrAmt(String stAccTrfrAmt) {
		this.stAccTrfrAmt = stAccTrfrAmt;
	}

	public String getProgBalAcc() {
		return progBalAcc;
	}

	public void setProgBalAcc(String progBalAcc) {
		this.progBalAcc = progBalAcc;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getAccrIntrstRecvd() {
		return accrIntrstRecvd;
	}

	public void setAccrIntrstRecvd(String accrIntrstRecvd) {
		this.accrIntrstRecvd = accrIntrstRecvd;
	}

	public String getCostValue() {
		return costValue;
	}

	public void setCostValue(String costValue) {
		this.costValue = costValue;
	}

}
