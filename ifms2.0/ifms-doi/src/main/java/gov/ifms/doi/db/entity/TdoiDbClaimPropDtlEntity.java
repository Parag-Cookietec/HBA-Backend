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
 * The persistent class for the TDOI_DB_CLAIM_PROP_DTL database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_CLAIM_PROP_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbClaimPropDtlEntity.findAll", query = "SELECT t FROM TdoiDbClaimPropDtlEntity t")
public class TdoiDbClaimPropDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROP_DTL_ID", unique = true, nullable = false)
	private long propDtlId;

	@Column(name = "CLAIMED_AMOUNT")
	private double claimedAmount;

	@Column(name = "ITEM_ACTUAL_VALUE")
	private double itemActualValue;

	@Column(name = "ITEM_DESC", length = 100)
	private String itemDesc;

	@Column(name = "ITEM_NUM_SRNO")
	private short itemNumSrno;

	@Column(name = "ITEM_SRNO", length = 20)
	private String itemSrno;

	@Column(name = "LOSS_TIME_VALUE")
	private double lossTimeValue;

	// bi-directional many-to-one association to TdoiDbClaimEntry
	@ManyToOne
	@JoinColumn(name = "DB_CLAIM_ID", nullable = false)
	private TdoiDbClaimEntryEntity tdoiDbClaimEntry;

	public TdoiDbClaimPropDtlEntity() {
	}

	public long getPropDtlId() {
		return this.propDtlId;
	}

	public void setPropDtlId(long propDtlId) {
		this.propDtlId = propDtlId;
	}

	public double getClaimedAmount() {
		return this.claimedAmount;
	}

	public void setClaimedAmount(double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public double getItemActualValue() {
		return this.itemActualValue;
	}

	public void setItemActualValue(double itemActualValue) {
		this.itemActualValue = itemActualValue;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public short getItemNumSrno() {
		return this.itemNumSrno;
	}

	public void setItemNumSrno(short itemNumSrno) {
		this.itemNumSrno = itemNumSrno;
	}

	public String getItemSrno() {
		return this.itemSrno;
	}

	public void setItemSrno(String itemSrno) {
		this.itemSrno = itemSrno;
	}

	public double getLossTimeValue() {
		return this.lossTimeValue;
	}

	public void setLossTimeValue(double lossTimeValue) {
		this.lossTimeValue = lossTimeValue;
	}

	public TdoiDbClaimEntryEntity getTdoiDbClaimEntry() {
		return this.tdoiDbClaimEntry;
	}

	public void setTdoiDbClaimEntry(TdoiDbClaimEntryEntity tdoiDbClaimEntry) {
		this.tdoiDbClaimEntry = tdoiDbClaimEntry;
	}

}