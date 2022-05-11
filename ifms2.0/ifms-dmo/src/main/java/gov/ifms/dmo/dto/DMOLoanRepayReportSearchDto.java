package gov.ifms.dmo.dto;

import javax.persistence.Lob;

/**
 * The Class BaseDto.
 */
public class DMOLoanRepayReportSearchDto {

	private String fromDate = "";
	private String toDate = "";
	private String pageIndex = "0";
	private String pageSize = "10";
	private String typeOfLoan = "";
	private String sanctionNo = "";
	private String ministryName = "";
	private String schemeName = "";
	private String loanPurpose = "";
	private String loanDescription = "";
	private String instituteId = "";
	private String nssfId = "";
	private String goiId = "";
	private String marketId = "";
	private String institutionId = "";
	@Lob
	private String getResult;
	
	public String getNssfId() {
		return nssfId;
	}
	public void setNssfId(String nssfId) {
		this.nssfId = nssfId;
	}
	public String getGoiId() {
		return goiId;
	}
	public void setGoiId(String goiId) {
		this.goiId = goiId;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
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
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getSanctionNo() {
		return sanctionNo;
	}
	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
	}
	public String getMinistryName() {
		return ministryName;
	}
	public void setMinistryName(String ministryName) {
		this.ministryName = ministryName;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getLoanDescription() {
		return loanDescription;
	}
	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
	public String getGetResult() {
		return getResult;
	}
	public void setGetResult(String getResult) {
		this.getResult = getResult;
	}
	public String getTypeOfLoan() {
		return typeOfLoan;
	}
	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}
	public String getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}
	
}
