package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDOI_AC_EXPENDITURE_REP database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_EXPENDITURE_REP", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcExpenditureRepEntity.findAll", query = "SELECT t FROM TdoiAcExpenditureRepEntity t")
public class TdoiAcExpenditureRepEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXPEND_REP_ID", unique = true, nullable = false)
	private long expendRepId;

	@Temporal(TemporalType.DATE)
	@Column(name = "CHEQUE_DT")
	private Date chequeDt;

	@Column(name = "CHEQUE_NO")
	private long chequeNo;

	@Column(name = "EXPEND_TYPE_DESC", length = 50)
	private String expendTypeDesc;

	@Column(name = "EXPEND_TYPE_ID")
	private long expendTypeId;

	@Temporal(TemporalType.DATE)
	@Column(name = "FROM_DT")
	private Date fromDt;

	@Column(name = "MAJORHEAD_DESC", length = 50)
	private String majorheadDesc;

	@Column(name = "MAJORHEAD_ID")
	private long majorheadId;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "STATUS_DESC", length = 50)
	private String statusDesc;

	@Column(name = "STAUS_ID")
	private long stausId;

	@Column(name = "SUBHEAD_DESC", length = 50)
	private String subheadDesc;

	@Column(name = "SUBHEAD_ID")
	private long subheadId;

	@Temporal(TemporalType.DATE)
	@Column(name = "TO_DT")
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
