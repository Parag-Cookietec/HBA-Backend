package gov.ifms.common.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The EDPIdDto.
 *
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */
public class SerachApprovedDto {

	private Long id;
	private String loanNumber;
	private Long instituteId;
	private String typeOfLoan;
	private String typeOfPayable;
	private String referenceNo;
	private Long chequeNo;
	private Long loanPurpose;
	private Long ministryId;
	private Long schemeId;
	private LocalDate chequeDate;
	private String memoNo;
	private String sanctionNo;
	private String transDesc;
	private LocalDate memoDate;
	private String letterNo;
	private LocalDate letterDate;
	private String adviceNo;
	private LocalDate fromDate;
	private LocalDate toDate;
    private int pageIndex = 0;
    private int pageElement = 10;
	private List<Long> ids = new ArrayList<>();
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
	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getMinistryId() {
		return ministryId;
	}
	public void setMinistryId(Long ministryId) {
		this.ministryId = ministryId;
	}
	public Long getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(Long schemeId) {
		this.schemeId = schemeId;
	}
	public Long getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(Long loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getTransDesc() {
		return transDesc;
	}
	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}
	public String getSanctionNo() {
		return sanctionNo;
	}
	public void setSanctionNo(String sanctionNo) {
		this.sanctionNo = sanctionNo;
	}
	public String getLetterNo() {
		return letterNo;
	}
	public void setLetterNo(String letterNo) {
		this.letterNo = letterNo;
	}
	public LocalDate getLetterDate() {
		return letterDate;
	}
	public void setLetterDate(LocalDate letterDate) {
		this.letterDate = letterDate;
	}
	public String getAdviceNo() {
		return adviceNo;
	}
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}
	public LocalDate getChequeDate() {
		return chequeDate;
	}
	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}
	public LocalDate getMemoDate() {
		return memoDate;
	}
	public void setMemoDate(LocalDate memoDate) {
		this.memoDate = memoDate;
	}
	public Long getChequeNo() {
		return chequeNo;
	}
	public void setChequeNo(Long chequeNo) {
		this.chequeNo = chequeNo;
	}
	public String getMemoNo() {
		return memoNo;
	}
	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public Long getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}
	public String getTypeOfPayable() {
		return typeOfPayable;
	}
	public void setTypeOfPayable(String typeOfPayable) {
		this.typeOfPayable = typeOfPayable;
	}
	public String getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
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
	public String getTypeOfLoan() {
		return typeOfLoan;
	}
	public void setTypeOfLoan(String typeOfLoan) {
		this.typeOfLoan = typeOfLoan;
	}
}
