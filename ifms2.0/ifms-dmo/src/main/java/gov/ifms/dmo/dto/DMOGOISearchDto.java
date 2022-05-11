package gov.ifms.dmo.dto;

import java.time.LocalDate;

public class DMOGOISearchDto {

	private Long id;
	private Long dpId;
	private Long parentId;
	private Long loanFinanceYearId;
	private Long nameOfMinistry;
	private Long loanPurpose;
	private Long planSchemeName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String adviceNo;
	private LocalDate adviceDate;
	private String adviceBy;
    private int pageIndex = 0;
    private int pageElement = 10;
    
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
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDpId() {
		return dpId;
	}
	public void setDpId(Long dpId) {
		this.dpId = dpId;
	}
	public String getAdviceNo() {
		return adviceNo;
	}
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}
	public LocalDate getAdviceDate() {
		return adviceDate;
	}
	public void setAdviceDate(LocalDate adviceDate) {
		this.adviceDate = adviceDate;
	}
	public String getAdviceBy() {
		return adviceBy;
	}
	public void setAdviceBy(String adviceBy) {
		this.adviceBy = adviceBy;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public Long getLoanFinanceYearId() {
		return loanFinanceYearId;
	}
	public void setLoanFinanceYearId(Long loanFinanceYearId) {
		this.loanFinanceYearId = loanFinanceYearId;
	}
	public Long getNameOfMinistry() {
		return nameOfMinistry;
	}
	public void setNameOfMinistry(Long nameOfMinistry) {
		this.nameOfMinistry = nameOfMinistry;
	}
	public Long getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(Long loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public Long getPlanSchemeName() {
		return planSchemeName;
	}
	public void setPlanSchemeName(Long planSchemeName) {
		this.planSchemeName = planSchemeName;
	}
	
}
