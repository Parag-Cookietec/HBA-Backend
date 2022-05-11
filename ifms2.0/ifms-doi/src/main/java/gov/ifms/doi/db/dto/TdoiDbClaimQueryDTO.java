package gov.ifms.doi.db.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_CLAIM_QUERY database table.
 * 
 */

public class TdoiDbClaimQueryDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbClaimQueryId;

	private short isQueryResolved;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date queryGenerateDt;

	private int querySrno;

	private String queryTypeDesc;

	private long queryTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date resolutionDt;

	// bi-directional many-to-one association to TdoiDbClaimEntry

	private TdoiDbClaimEntryDTO tdoiDbClaimEntry;

	public TdoiDbClaimQueryDTO() {
	}

	public long getDbClaimQueryId() {
		return this.dbClaimQueryId;
	}

	public void setDbClaimQueryId(long dbClaimQueryId) {
		this.dbClaimQueryId = dbClaimQueryId;
	}

	public short getIsQueryResolved() {
		return this.isQueryResolved;
	}

	public void setIsQueryResolved(short isQueryResolved) {
		this.isQueryResolved = isQueryResolved;
	}

	public Date getQueryGenerateDt() {
		return this.queryGenerateDt;
	}

	public void setQueryGenerateDt(Date queryGenerateDt) {
		this.queryGenerateDt = queryGenerateDt;
	}

	public int getQuerySrno() {
		return this.querySrno;
	}

	public void setQuerySrno(int querySrno) {
		this.querySrno = querySrno;
	}

	public String getQueryTypeDesc() {
		return this.queryTypeDesc;
	}

	public void setQueryTypeDesc(String queryTypeDesc) {
		this.queryTypeDesc = queryTypeDesc;
	}

	public long getQueryTypeId() {
		return this.queryTypeId;
	}

	public void setQueryTypeId(long queryTypeId) {
		this.queryTypeId = queryTypeId;
	}

	public Date getResolutionDt() {
		return this.resolutionDt;
	}

	public void setResolutionDt(Date resolutionDt) {
		this.resolutionDt = resolutionDt;
	}

	public TdoiDbClaimEntryDTO getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryDTO tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}
