package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_HBA_CLAIM_LOSS_DTL database table.
 * * @author Sagar Jadhav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaClaimLossDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long lossDtlId;

	private double claimedAmount;

	private double dedSalvageValue;

	private double itemActualValue;

	private String itemDesc;

	private short itemNumSrno;

	private double lossTimeValue;
	
	// private TdoiHbaClaimEntryDTO tdoiHbaClaimEntry;

	public long getLossDtlId() {
		return lossDtlId;
	}

	public void setLossDtlId(long lossDtlId) {
		this.lossDtlId = lossDtlId;
	}

	public double getClaimedAmount() {
		return claimedAmount;
	}

	public void setClaimedAmount(double claimedAmount) {
		this.claimedAmount = claimedAmount;
	}

	public double getDedSalvageValue() {
		return dedSalvageValue;
	}

	public void setDedSalvageValue(double dedSalvageValue) {
		this.dedSalvageValue = dedSalvageValue;
	}

	public double getItemActualValue() {
		return itemActualValue;
	}

	public void setItemActualValue(double itemActualValue) {
		this.itemActualValue = itemActualValue;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public short getItemNumSrno() {
		return itemNumSrno;
	}

	public void setItemNumSrno(short itemNumSrno) {
		this.itemNumSrno = itemNumSrno;
	}

	public double getLossTimeValue() {
		return lossTimeValue;
	}

	public void setLossTimeValue(double lossTimeValue) {
		this.lossTimeValue = lossTimeValue;
	}



}
