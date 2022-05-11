package gov.ifms.gst.dto;

import java.util.Date;

public class AccDebitEntryDto {

	private static final long serialVersionUID = 1L;
	private long id;
	private String referenceNo;
	private Date referenceDt;
	private String cinNo;
	private long majorheadId;
	private String majorhead;
	private long submajorheadId;
	private String submajorhead;
	private long minorheadId;
	private String minorhead;
	private String subhead;
	private long subheadId;
	private long detailheadId;
	private String detailhead;
	private String entryDesc;
	private Double debitAmount;

	public AccDebitEntryDto(){}

	public AccDebitEntryDto(String referenceNo, Date referenceDt, String cinNo, long majorheadId, String majorhead, long submajorheadId, String submajorhead, long minorheadId, String minorhead, String subhead, long subheadId, long detailheadId, String detailhead, String entryDesc, Double debitAmount) {
		this.referenceNo = referenceNo;
		this.referenceDt = referenceDt;
		this.cinNo = cinNo;
		this.majorheadId = majorheadId;
		this.majorhead = majorhead;
		this.submajorheadId = submajorheadId;
		this.submajorhead = submajorhead;
		this.minorheadId = minorheadId;
		this.minorhead = minorhead;
		this.subhead = subhead;
		this.subheadId = subheadId;
		this.detailheadId = detailheadId;
		this.detailhead = detailhead;
		this.entryDesc = entryDesc;
		this.debitAmount = debitAmount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long getMajorheadId() {
		return majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public String getMajorhead() {
		return majorhead;
	}

	public void setMajorhead(String majorhead) {
		this.majorhead = majorhead;
	}

	public long getSubmajorheadId() {
		return submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public String getSubmajorhead() {
		return submajorhead;
	}

	public void setSubmajorhead(String submajorhead) {
		this.submajorhead = submajorhead;
	}

	public long getMinorheadId() {
		return minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public String getMinorhead() {
		return minorhead;
	}

	public void setMinorhead(String minorhead) {
		this.minorhead = minorhead;
	}

	public String getSubhead() {
		return subhead;
	}

	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}

	public long getSubheadId() {
		return subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getDetailheadId() {
		return detailheadId;
	}

	public void setDetailheadId(long detailheadId) {
		this.detailheadId = detailheadId;
	}

	public String getDetailhead() {
		return detailhead;
	}

	public void setDetailhead(String detailhead) {
		this.detailhead = detailhead;
	}

	public String getEntryDesc() {
		return entryDesc;
	}

	public void setEntryDesc(String entryDesc) {
		this.entryDesc = entryDesc;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
