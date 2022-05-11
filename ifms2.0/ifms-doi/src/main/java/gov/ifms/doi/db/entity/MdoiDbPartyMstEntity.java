package gov.ifms.doi.db.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the MDOI_DB_PARTY_MST database table.
 * 
 */
@Entity
@Table(name = "MDOI_DB_PARTY_MST", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "MdoiDbPartyMstEntity.findAll", query = "SELECT m FROM MdoiDbPartyMstEntity m")
public class MdoiDbPartyMstEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DB_PARTY_ID", unique = true, nullable = false)
	private long dbPartyId;

	@Column(name = "CITY_NAME", length = 100)
	private String cityName;

	@Column(name = "CONTACT_NUM", length = 40)
	private String contactNum;

	@Column(name = "DISTRICT_ID")
	private long districtId;

	@Column(name = "EMAIL_ID", length = 30)
	private String emailId;

	@Column(name = "GSTIN_NUMB", length = 30)
	private String gstinNumb;

	@Column(name = "PAN_NUMB", length = 10)
	private String panNumb;

	@Column(name = "PARTY_ADDRESS", length = 200)
	private String partyAddress;

	@Column(name = "PARTY_TYPE_ID", nullable = false)
	private long partyTypeId;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "TALUKA_ID")
	private long talukaId;

	// bi-directional many-to-one association to MdoiDbPartyBankDtl
	@OneToMany(mappedBy = "mdoiDbPartyMst",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MdoiDbPartyBankDtlEntity> mdoiDbPartyBankDtls;

	// bi-directional many-to-one association to MdoiDbPartyOfficeDtl
	@OneToMany(mappedBy = "mdoiDbPartyMst",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<MdoiDbPartyOfficeDtlEntity> mdoiDbPartyOfficeDtls;

	public MdoiDbPartyMstEntity() {
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

	public List<MdoiDbPartyBankDtlEntity> getMdoiDbPartyBankDtls() {
		return this.mdoiDbPartyBankDtls;
	}

	public void setMdoiDbPartyBankDtls(List<MdoiDbPartyBankDtlEntity> mdoiDbPartyBankDtls) {
		this.mdoiDbPartyBankDtls = mdoiDbPartyBankDtls;
	}

	public MdoiDbPartyBankDtlEntity addMdoiDbPartyBankDtl(MdoiDbPartyBankDtlEntity mdoiDbPartyBankDtl) {
		getMdoiDbPartyBankDtls().add(mdoiDbPartyBankDtl);
		mdoiDbPartyBankDtl.setMdoiDbPartyMst(this);

		return mdoiDbPartyBankDtl;
	}

	public MdoiDbPartyBankDtlEntity removeMdoiDbPartyBankDtl(MdoiDbPartyBankDtlEntity mdoiDbPartyBankDtl) {
		getMdoiDbPartyBankDtls().remove(mdoiDbPartyBankDtl);
		mdoiDbPartyBankDtl.setMdoiDbPartyMst(null);

		return mdoiDbPartyBankDtl;
	}

	public List<MdoiDbPartyOfficeDtlEntity> getMdoiDbPartyOfficeDtls() {
		return this.mdoiDbPartyOfficeDtls;
	}

	public void setMdoiDbPartyOfficeDtls(List<MdoiDbPartyOfficeDtlEntity> mdoiDbPartyOfficeDtls) {
		this.mdoiDbPartyOfficeDtls = mdoiDbPartyOfficeDtls;
	}

	public MdoiDbPartyOfficeDtlEntity addMdoiDbPartyOfficeDtl(MdoiDbPartyOfficeDtlEntity mdoiDbPartyOfficeDtl) {
		getMdoiDbPartyOfficeDtls().add(mdoiDbPartyOfficeDtl);
		mdoiDbPartyOfficeDtl.setMdoiDbPartyMst(this);

		return mdoiDbPartyOfficeDtl;
	}

	public MdoiDbPartyOfficeDtlEntity removeMdoiDbPartyOfficeDtl(MdoiDbPartyOfficeDtlEntity mdoiDbPartyOfficeDtl) {
		getMdoiDbPartyOfficeDtls().remove(mdoiDbPartyOfficeDtl);
		mdoiDbPartyOfficeDtl.setMdoiDbPartyMst(null);

		return mdoiDbPartyOfficeDtl;
	}

}