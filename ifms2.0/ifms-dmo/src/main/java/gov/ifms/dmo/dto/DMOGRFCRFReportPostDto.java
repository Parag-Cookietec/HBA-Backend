package gov.ifms.dmo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGRFCRFReportPostDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String financialYear;
	private String fromDate;
	private String toDate;
	private String typeOfSecurity;
	private String investFromId;
	private String accountTypeId;
	private Integer pageIndex = 0;
	private int pageSize = 250;

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTypeOfSecurity() {
		return typeOfSecurity;
	}

	public void setTypeOfSecurity(String typeOfSecurity) {
		this.typeOfSecurity = typeOfSecurity;
	}

	public String getInvestFromId() {
		return investFromId;
	}

	public void setInvestFromId(String investFromId) {
		this.investFromId = investFromId;
	}

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
