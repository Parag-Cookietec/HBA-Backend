package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_HBA_CLAIM_REJECT database table. * @author
 * Sagar Jadhav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaClaimRejectDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long claimRejectId;

	private long claimRecommId;

	private short isRejectResolved;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date rejectGenerateDt;

	private int rejectReasonSrno;

	private String rejectTypeDesc;

	private long rejectTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date resolutionDt;

	// bi-directional many-to-one association to TdoiHbaClaimEntry
	private TdoiHbaClaimEntryDTO tdoiHbaClaimEntry;

	public long getClaimRejectId() {
		return claimRejectId;
	}

	public void setClaimRejectId(long claimRejectId) {
		this.claimRejectId = claimRejectId;
	}

	public long getClaimRecommId() {
		return claimRecommId;
	}

	public void setClaimRecommId(long claimRecommId) {
		this.claimRecommId = claimRecommId;
	}

	public short getIsRejectResolved() {
		return isRejectResolved;
	}

	public void setIsRejectResolved(short isRejectResolved) {
		this.isRejectResolved = isRejectResolved;
	}

	public Date getRejectGenerateDt() {
		return rejectGenerateDt;
	}

	public void setRejectGenerateDt(Date rejectGenerateDt) {
		this.rejectGenerateDt = rejectGenerateDt;
	}

	public int getRejectReasonSrno() {
		return rejectReasonSrno;
	}

	public void setRejectReasonSrno(int rejectReasonSrno) {
		this.rejectReasonSrno = rejectReasonSrno;
	}

	public String getRejectTypeDesc() {
		return rejectTypeDesc;
	}

	public void setRejectTypeDesc(String rejectTypeDesc) {
		this.rejectTypeDesc = rejectTypeDesc;
	}

	public long getRejectTypeId() {
		return rejectTypeId;
	}

	public void setRejectTypeId(long rejectTypeId) {
		this.rejectTypeId = rejectTypeId;
	}

	public Date getResolutionDt() {
		return resolutionDt;
	}

	public void setResolutionDt(Date resolutionDt) {
		this.resolutionDt = resolutionDt;
	}

	public TdoiHbaClaimEntryDTO getTdoiHbaClaimEntry() {
		return tdoiHbaClaimEntry;
	}

	public void setTdoiHbaClaimEntry(TdoiHbaClaimEntryDTO tdoiHbaClaimEntry) {
		this.tdoiHbaClaimEntry = tdoiHbaClaimEntry;
	}

}
