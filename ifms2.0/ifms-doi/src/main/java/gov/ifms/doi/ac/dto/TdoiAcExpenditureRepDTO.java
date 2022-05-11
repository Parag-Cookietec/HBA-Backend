package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_EXPENDITURE_REP database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcExpenditureRepDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long expendRepId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date chequeDt;

	private long chequeNo;

	private String expendTypeDesc;

	private long expendTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date fromDt;

	private String majorheadDesc;

	private long majorheadId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private String statusDesc;

	private long stausId;

	private String subheadDesc;

	private long subheadId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date toDt;

	public long getExpendRepId() {
		return this.expendRepId;
	}

	public void setExpendRepId(long expendRepId) {
		this.expendRepId = expendRepId;
	}

	public Date getChequeDt() {
		return this.chequeDt;
	}

	public void setChequeDt(Date chequeDt) {
		this.chequeDt = chequeDt;
	}

	public long getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(long chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getExpendTypeDesc() {
		return this.expendTypeDesc;
	}

	public void setExpendTypeDesc(String expendTypeDesc) {
		this.expendTypeDesc = expendTypeDesc;
	}

	public long getExpendTypeId() {
		return this.expendTypeId;
	}

	public void setExpendTypeId(long expendTypeId) {
		this.expendTypeId = expendTypeId;
	}

	public Date getFromDt() {
		return this.fromDt;
	}

	public void setFromDt(Date fromDt) {
		this.fromDt = fromDt;
	}

	public String getMajorheadDesc() {
		return this.majorheadDesc;
	}

	public void setMajorheadDesc(String majorheadDesc) {
		this.majorheadDesc = majorheadDesc;
	}

	public long getMajorheadId() {
		return this.majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public long getStausId() {
		return this.stausId;
	}

	public void setStausId(long stausId) {
		this.stausId = stausId;
	}

	public String getSubheadDesc() {
		return this.subheadDesc;
	}

	public void setSubheadDesc(String subheadDesc) {
		this.subheadDesc = subheadDesc;
	}

	public long getSubheadId() {
		return this.subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public Date getToDt() {
		return this.toDt;
	}

	public void setToDt(Date toDt) {
		this.toDt = toDt;
	}

}
