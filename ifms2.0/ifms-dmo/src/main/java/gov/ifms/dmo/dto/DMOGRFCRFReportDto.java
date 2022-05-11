package gov.ifms.dmo.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

@NativeQueryResultEntity
public class DMOGRFCRFReportDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String id;

	@NativeQueryResultColumn(index = 1)
	private String accountTypeId;

	@NativeQueryResultColumn(index = 2)
	private String investFromId;

	@NativeQueryResultColumn(index = 3)
	private String dateOfPurchase;

	@NativeQueryResultColumn(index = 4)
	private String scurityTypeId;

	@NativeQueryResultColumn(index = 5)
	private String nameOfSecurity;
	@NativeQueryResultColumn(index = 6)
	private String faceValue;
	@NativeQueryResultColumn(index = 7)
	private String purchasePrice;
	@NativeQueryResultColumn(index = 8)
	private String brokenDays;
	@NativeQueryResultColumn(index = 9)
	private String brokenPeriodInterest;
	@NativeQueryResultColumn(index = 10)
	private String totalPurchaseCost;
	@NativeQueryResultColumn(index = 11)
	private String purchaseValue;
	@NativeQueryResultColumn(index = 12)
	private long count;

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getNameOfSecurity() {
		return nameOfSecurity;
	}

	public void setNameOfSecurity(String nameOfSecurity) {
		this.nameOfSecurity = nameOfSecurity;
	}

	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(String purchaseValue) {
		this.purchaseValue = purchaseValue;
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

	public String getTotalPurchaseCost() {
		return totalPurchaseCost;
	}

	public void setTotalPurchaseCost(String totalPurchaseCost) {
		this.totalPurchaseCost = totalPurchaseCost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getInvestFromId() {
		return investFromId;
	}

	public void setInvestFromId(String investFromId) {
		this.investFromId = investFromId;
	}

	public String getScurityTypeId() {
		return scurityTypeId;
	}

	public void setScurityTypeId(String scurityTypeId) {
		this.scurityTypeId = scurityTypeId;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
