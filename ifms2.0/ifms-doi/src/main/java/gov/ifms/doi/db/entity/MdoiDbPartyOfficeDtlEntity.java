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

import com.fasterxml.jackson.annotation.JsonBackReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the MDOI_DB_PARTY_OFFICE_DTL database table.
 * 
 */
@Entity
@Table(name = "MDOI_DB_PARTY_OFFICE_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "MdoiDbPartyOfficeDtlEntity.findAll", query = "SELECT m FROM MdoiDbPartyOfficeDtlEntity m")
public class MdoiDbPartyOfficeDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_PARTY_OFFC_ID", unique = true, nullable = false)
	private long dbPartyOffcId;

	@Column(name = "CITY_ID")
	private long cityId;

	@Column(name = "CITY_NAME", length = 60)
	private String cityName;

	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "OFFC_TYPE_ID")
	private long offcTypeId;

	@Column(name = "OFFICE_ADDRESS", length = 200)
	private String officeAddress;

	@Column(name = "OFFICE_NAME", length = 30)
	private String officeName;

	private int pincode;

	@Column(name = "TALUKA_ID")
	private long talukaId;

	// bi-directional many-to-one association to MdoiDbPartyMst
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "DB_PARTY_ID", nullable = false)
	private MdoiDbPartyMstEntity mdoiDbPartyMst;

	public MdoiDbPartyOfficeDtlEntity() {
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

	public MdoiDbPartyMstEntity getMdoiDbPartyMst() {
		return this.mdoiDbPartyMst;
	}

	public void setMdoiDbPartyMst(MdoiDbPartyMstEntity mdoiDbPartyMst) {
		this.mdoiDbPartyMst = mdoiDbPartyMst;
	}

}