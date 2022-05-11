package gov.ifms.doi.db.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the MDOI_DB_PARTY_MST database table.
 * 
 */

public class MdoiDbPartyMstDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbPartyId;

	private String cityName;

	private String contactNum;

	private long districtId;

	private String emailId;

	private String gstinNumb;

	private String panNumb;

	private String partyAddress;

	private long partyTypeId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private long talukaId;

	// bi-directional many-to-one association to MdoiDbPartyBankDtl
	private List<MdoiDbPartyBankDtlDTO> mdoiDbPartyBankDtls;

	// bi-directional many-to-one association to MdoiDbPartyOfficeDtl
	private List<MdoiDbPartyOfficeDtlDTO> mdoiDbPartyOfficeDtls;

	public MdoiDbPartyMstDTO() {
	}

	public long getDbPartyId() {
		return this.dbPartyId;
	}

	public void setDbPartyId(long dbPartyId) {
		this.dbPartyId = dbPartyId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGstinNumb() {
		return this.gstinNumb;
	}

	public void setGstinNumb(String gstinNumb) {
		this.gstinNumb = gstinNumb;
	}

	public String getPanNumb() {
		return this.panNumb;
	}

	public void setPanNumb(String panNumb) {
		this.panNumb = panNumb;
	}

	public String getPartyAddress() {
		return this.partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public long getPartyTypeId() {
		return this.partyTypeId;
	}

	public void setPartyTypeId(long partyTypeId) {
		this.partyTypeId = partyTypeId;
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

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	public List<MdoiDbPartyBankDtlDTO> getMdoiDbPartyBankDtls() {
		return this.mdoiDbPartyBankDtls;
	}

	public void setMdoiDbPartyBankDtls(List<MdoiDbPartyBankDtlDTO> mdoiDbPartyBankDtls) {
		this.mdoiDbPartyBankDtls = mdoiDbPartyBankDtls;
	}

	public MdoiDbPartyBankDtlDTO addMdoiDbPartyBankDtl(MdoiDbPartyBankDtlDTO mdoiDbPartyBankDtl) {
		getMdoiDbPartyBankDtls().add(mdoiDbPartyBankDtl);
		mdoiDbPartyBankDtl.setMdoiDbPartyMst(this);

		return mdoiDbPartyBankDtl;
	}

	public MdoiDbPartyBankDtlDTO removeMdoiDbPartyBankDtl(MdoiDbPartyBankDtlDTO mdoiDbPartyBankDtl) {
		getMdoiDbPartyBankDtls().remove(mdoiDbPartyBankDtl);
		mdoiDbPartyBankDtl.setMdoiDbPartyMst(null);

		return mdoiDbPartyBankDtl;
	}

	public List<MdoiDbPartyOfficeDtlDTO> getMdoiDbPartyOfficeDtls() {
		return this.mdoiDbPartyOfficeDtls;
	}

	public void setMdoiDbPartyOfficeDtls(List<MdoiDbPartyOfficeDtlDTO> mdoiDbPartyOfficeDtls) {
		this.mdoiDbPartyOfficeDtls = mdoiDbPartyOfficeDtls;
	}

	public MdoiDbPartyOfficeDtlDTO addMdoiDbPartyOfficeDtl(MdoiDbPartyOfficeDtlDTO mdoiDbPartyOfficeDtl) {
		getMdoiDbPartyOfficeDtls().add(mdoiDbPartyOfficeDtl);
		mdoiDbPartyOfficeDtl.setMdoiDbPartyMst(this);

		return mdoiDbPartyOfficeDtl;
	}

	public MdoiDbPartyOfficeDtlDTO removeMdoiDbPartyOfficeDtl(MdoiDbPartyOfficeDtlDTO mdoiDbPartyOfficeDtl) {
		getMdoiDbPartyOfficeDtls().remove(mdoiDbPartyOfficeDtl);
		mdoiDbPartyOfficeDtl.setMdoiDbPartyMst(null);

		return mdoiDbPartyOfficeDtl;
	}

}
