package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "MS_GST_PARTY", schema = GSTConstant.GST_SCHEMA)
public class MsGstParty extends BaseEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PARTY_ID")
	public Long id;

	@Column(name = "FIRM_NAME")
	public String firmName;

	@Column(name = "GSTIN")
	public String gstin;

	@Column(name = "ASSIGNED_TO")
	public String assignedTo;

	@Column(name = "AUTH_STATUS")
	public String authStatus;

	@Column(name = "COMP_IND")
	public String compInd;

	@Column(name = "DIVISION")
	public String division;

	@Column(name = "EMAIL")
	public String email;

	@Column(name = "LEGAL_NAME")
	public String legalName;

	@Column(name = "MOBILE")
	public String mobile;

	@Column(name = "PAN")
	public String pan;

	@Column(name = "RANGE_VALUE")
	public String rangeValue;

	@Column(name = "TIN")
	public String tin;

	@Column(name = "UNIT")
	public String unit;

	@Column(name = "REG_TYPE")
	public String regType;

	@Column(name = "REG_START_DATE")
	public Date regStartDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getCompInd() {
		return compInd;
	}

	public void setCompInd(String compInd) {
		this.compInd = compInd;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getRangeValue() {
		return rangeValue;
	}

	public void setRangeValue(String rangeValue) {
		this.rangeValue = rangeValue;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public Date getRegStartDate() {
		return regStartDate;
	}

	public void setRegStartDate(Date regStartDate) {
		this.regStartDate = regStartDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MsGstParty msGstParty = (MsGstParty) o;
		return Objects.equals(id, msGstParty.id) && Objects.equals(firmName, msGstParty.firmName) && Objects.equals(gstin, msGstParty.gstin) && Objects.equals(assignedTo, msGstParty.assignedTo) && Objects.equals(authStatus, msGstParty.authStatus) && Objects.equals(compInd, msGstParty.compInd) && Objects.equals(division, msGstParty.division) && Objects.equals(email, msGstParty.email) && Objects.equals(legalName, msGstParty.legalName) && Objects.equals(mobile, msGstParty.mobile) && Objects.equals(pan, msGstParty.pan) && Objects.equals(rangeValue, msGstParty.rangeValue) && Objects.equals(tin, msGstParty.tin) && Objects.equals(unit, msGstParty.unit) && Objects.equals(regType, msGstParty.regType) && Objects.equals(regStartDate, msGstParty.regStartDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firmName, gstin, assignedTo, authStatus, compInd, division, email, legalName, mobile, pan, rangeValue, tin, unit, regType, regStartDate);
	}
}


