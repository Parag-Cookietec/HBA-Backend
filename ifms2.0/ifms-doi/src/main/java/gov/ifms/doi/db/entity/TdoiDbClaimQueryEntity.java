package gov.ifms.doi.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_CLAIM_QUERY database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_CLAIM_QUERY", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbClaimQueryEntity.findAll", query = "SELECT t FROM TdoiDbClaimQueryEntity t")
public class TdoiDbClaimQueryEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_CLAIM_QUERY_ID", unique = true, nullable = false)
	private long dbClaimQueryId;

	@Column(name = "IS_QUERY_RESOLVED")
	private short isQueryResolved;

	@Temporal(TemporalType.DATE)
	@Column(name = "QUERY_GENERATE_DT")
	private Date queryGenerateDt;

	@Column(name = "QUERY_SRNO", nullable = false)
	private int querySrno;

	@Column(name = "QUERY_TYPE_DESC", length = 200)
	private String queryTypeDesc;

	@Column(name = "QUERY_TYPE_ID", nullable = false)
	private long queryTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "RESOLUTION_DT")
	private Date resolutionDt;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	@ManyToOne
	@JoinColumn(name = "DB_CLAIM_ID", nullable = false)
	private TdoiDbClaimEntryEntity tdoiDbClaimEntry;

	public TdoiDbClaimQueryEntity() {
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

	public TdoiDbClaimEntryEntity getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryEntity tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}