package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.List;

public class AccountingEntriesDto implements Serializable {

	private char IsEntryMatched;

	private Long moeId;

	private String moeStatus;

	private String moeType;

	private List<AccountCreditEntryDto> creditEntries;

	private List<AccDebitEntryDto> debitEntries;

	public char getIsEntryMatched() {
		return IsEntryMatched;
	}

	public void setIsEntryMatched(char isEntryMatched) {
		IsEntryMatched = isEntryMatched;
	}

	public Long getMoeId() {
		return moeId;
	}

	public void setMoeId(Long moeId) {
		this.moeId = moeId;
	}

	public String getMoeStatus() {
		return moeStatus;
	}

	public void setMoeStatus(String moeStatus) {
		this.moeStatus = moeStatus;
	}

	public String getMoeType() {
		return moeType;
	}

	public void setMoeType(String moeType) {
		this.moeType = moeType;
	}

	public List<AccountCreditEntryDto> getCreditEntries() {
		return creditEntries;
	}

	public void setCreditEntries(List<AccountCreditEntryDto> creditEntries) {
		this.creditEntries = creditEntries;
	}

	public List<AccDebitEntryDto> getDebitEntries() {
		return debitEntries;
	}

	public void setDebitEntries(List<AccDebitEntryDto> debitEntries) {
		this.debitEntries = debitEntries;
	}
}