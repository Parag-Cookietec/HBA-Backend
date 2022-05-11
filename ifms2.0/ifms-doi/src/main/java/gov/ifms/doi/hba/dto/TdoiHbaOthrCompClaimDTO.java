package gov.ifms.doi.hba.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_HBA_OTHR_COMP_CLAIM database table.
 * * @author Sagar Jadhav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TdoiHbaOthrCompClaimDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long othrCompClaimId;

	private double claimAmtRecevd;

	private String companyName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyEndDt;

	private String policyNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date policyStartDt;

	private double sumInsured;

	private TdoiHbaClaimEntryDTO tdoiHbaClaimEntry;

	public long getOthrCompClaimId() {
		return othrCompClaimId;
	}

	public void setOthrCompClaimId(long othrCompClaimId) {
		this.othrCompClaimId = othrCompClaimId;
	}

	public double getClaimAmtRecevd() {
		return claimAmtRecevd;
	}

	public void setClaimAmtRecevd(double claimAmtRecevd) {
		this.claimAmtRecevd = claimAmtRecevd;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getPolicyEndDt() {
		return policyEndDt;
	}

	public void setPolicyEndDt(Date policyEndDt) {
		this.policyEndDt = policyEndDt;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public Date getPolicyStartDt() {
		return policyStartDt;
	}

	public void setPolicyStartDt(Date policyStartDt) {
		this.policyStartDt = policyStartDt;
	}

	public double getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public TdoiHbaClaimEntryDTO getTdoiHbaClaimEntry() {
		return tdoiHbaClaimEntry;
	}

	public void setTdoiHbaClaimEntry(TdoiHbaClaimEntryDTO tdoiHbaClaimEntry) {
		this.tdoiHbaClaimEntry = tdoiHbaClaimEntry;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
