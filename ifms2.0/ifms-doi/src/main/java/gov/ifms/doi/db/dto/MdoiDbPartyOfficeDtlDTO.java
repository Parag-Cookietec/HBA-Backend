package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the MDOI_DB_PARTY_OFFICE_DTL database table.
 * 
 */

public class MdoiDbPartyOfficeDtlDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long dbPartyOffcId;

	private long cityId;

	private String cityName;

	private long districtId;

	private long offcTypeId;

	private String officeAddress;

	private String officeName;

	private int pincode;

	private long talukaId;

	// bi-directional many-to-one association to MdoiDbPartyMst

	private MdoiDbPartyMstDTO mdoiDbPartyMst;

	public MdoiDbPartyOfficeDtlDTO() {
	}

	public long getDbPartyOffcId() {
		return this.dbPartyOffcId;
	}

	public void setDbPartyOffcId(long dbPartyOffcId) {
		this.dbPartyOffcId = dbPartyOffcId;
	}

	public long getCityId() {
		return this.cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getDistrictId() {
		return this.districtId;
	}

	public void setDistrictId(long districtId) {
		this.districtId = districtId;
	}

	public long getOffcTypeId() {
		return this.offcTypeId;
	}

	public void setOffcTypeId(long offcTypeId) {
		this.offcTypeId = offcTypeId;
	}

	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficeName() {
		return this.officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public int getPincode() {
		return this.pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public long getTalukaId() {
		return this.talukaId;
	}

	public void setTalukaId(long talukaId) {
		this.talukaId = talukaId;
	}

	public MdoiDbPartyMstDTO getMdoiDbPartyMst() {
		return this.mdoiDbPartyMst;
	}

	public void setMdoiDbPartyMst(MdoiDbPartyMstDTO mdoiDbPartyMst) {
		this.mdoiDbPartyMst = mdoiDbPartyMst;
	}

}
