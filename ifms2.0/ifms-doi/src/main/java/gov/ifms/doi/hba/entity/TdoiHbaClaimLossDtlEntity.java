package gov.ifms.doi.hba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_HBA_CLAIM_LOSS_DTL database table.
 * * @author Sagar Jadhav
 */
@Entity
@Table(name = "TDOI_HBA_CLAIM_LOSS_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiHbaClaimLossDtlEntity.findAll", query = "SELECT t FROM TdoiHbaClaimLossDtlEntity t")
public class TdoiHbaClaimLossDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOSS_DTL_ID", unique = true, nullable = false)
	private long lossDtlId;

	@Column(name = "CLAIMED_AMOUNT")
	private double claimedAmount;

	@Column(name = "DED_SALVAGE_VALUE")
	private double dedSalvageValue;

	@Column(name = "ITEM_ACTUAL_VALUE")
	private double itemActualValue;

	@Column(name = "ITEM_DESC", length = 100)
	private String itemDesc;

	@Column(name = "ITEM_NUM_SRNO")
	private short itemNumSrno;

	@Column(name = "LOSS_TIME_VALUE")
	private double lossTimeValue;

	// bi-directional many-to-one association to TdoiHbaClaimEntry
	@ManyToOne
	@JoinColumn(name = "HBA_CLAIM_ID", nullable = false)
	@JsonBackReference
	private TdoiHbaClaimEntryEntity tdoiHbaClaimEntry;

	/**
	 * @return the lossDtlId
	 */
	public long getLossDtlId() {
		return lossDtlId;
	}

	/**
	 * @param lossDtlId the lossDtlId to set
	 */
	public void setLossDtlId(long lossDtlId) {
		this.lossDtlId = lossDtlId;
	}

	/**
	 * @return the claimedAmount
	 */
	public double getClaimedAmount() {
		return claimedAmount;
	}

	/**
	 * @param claimedAmount the claimedAmount to set
	 */
	public void setClaimedAmount(double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	/**
	 * @return the dedSalvageValue
	 */
	public double getDedSalvageValue() {
		return dedSalvageValue;
	}

	/**
	 * @param dedSalvageValue the dedSalvageValue to set
	 */
	public void setDedSalvageValue(double dedSalvageValue) {
		this.dedSalvageValue = dedSalvageValue;
	}

	/**
	 * @return the itemActualValue
	 */
	public double getItemActualValue() {
		return itemActualValue;
	}

	/**
	 * @param itemActualValue the itemActualValue to set
	 */
	public void setItemActualValue(double itemActualValue) {
		this.itemActualValue = itemActualValue;
	}

	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/**
	 * @return the itemNumSrno
	 */
	public short getItemNumSrno() {
		return itemNumSrno;
	}

	/**
	 * @param itemNumSrno the itemNumSrno to set
	 */
	public void setItemNumSrno(short itemNumSrno) {
		this.itemNumSrno = itemNumSrno;
	}

	/**
	 * @return the lossTimeValue
	 */
	public double getLossTimeValue() {
		return lossTimeValue;
	}

	/**
	 * @param lossTimeValue the lossTimeValue to set
	 */
	public void setLossTimeValue(double lossTimeValue) {
		this.lossTimeValue = lossTimeValue;
	}

	/**
	 * @return the tdoiHbaClaimEntry
	 */
	public TdoiHbaClaimEntryEntity getTdoiHbaClaimEntry() {
		return tdoiHbaClaimEntry;
	}

	/**
	 * @param tdoiHbaClaimEntry the tdoiHbaClaimEntry to set
	 */
	public void setTdoiHbaClaimEntry(TdoiHbaClaimEntryEntity tdoiHbaClaimEntry) {
		this.tdoiHbaClaimEntry = tdoiHbaClaimEntry;
	}

}