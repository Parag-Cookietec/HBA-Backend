package gov.ifms.doi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_CLAIM_PREV_LOSS database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_CLAIM_PREV_LOSS", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbClaimPrevLossEntity.findAll", query = "SELECT t FROM TdoiDbClaimPrevLossEntity t")
public class TdoiDbClaimPrevLossEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PREV_LOSS_ID", unique = true, nullable = false)
	private long prevLossId;

	@Column(name = "CLAIM_AMOUNT")
	private double claimAmount;

	@Column(name = "CLAIM_DESC", length = 200)
	private String claimDesc;

	@Column(name = "CLAIM_YEAR_ID")
	private long claimYearId;

	@Column(name = "LOSS_SRNO")
	private short lossSrno;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	@ManyToOne
	@JoinColumn(name = "DB_CLAIM_ID", nullable = false)
	private TdoiDbClaimEntryEntity tdoiDbClaimEntry;

	public TdoiDbClaimPrevLossEntity() {
	}

	public long getPrevLossId() {
		return this.prevLossId;
	}

	public void setPrevLossId(long prevLossId) {
		this.prevLossId = prevLossId;
	}

	public double getClaimAmount() {
		return this.claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimDesc() {
		return this.claimDesc;
	}

	public void setClaimDesc(String claimDesc) {
		this.claimDesc = claimDesc;
	}

	public long getClaimYearId() {
		return this.claimYearId;
	}

	public void setClaimYearId(long claimYearId) {
		this.claimYearId = claimYearId;
	}

	public short getLossSrno() {
		return this.lossSrno;
	}

	public void setLossSrno(short lossSrno) {
		this.lossSrno = lossSrno;
	}

	public TdoiDbClaimEntryEntity getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryEntity tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}