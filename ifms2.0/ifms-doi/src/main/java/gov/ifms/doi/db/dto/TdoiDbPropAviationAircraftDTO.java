package gov.ifms.doi.db.dto;

import gov.ifms.doi.jpa.dto.BaseDto;

/**
 * The persistent class for the TDOI_DB_PROP_AVIATION_AIRCRAFT database table.
 * 
 */

public class TdoiDbPropAviationAircraftDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long aviatAircrftId;

	private String aircraftType;

	private int constructYr;

	private int engineNum;

	private String makeType;

	private int purchaseYr;

	private String regnNo;

	private String seatingCapacity;

	private String seriesNo;

	// bi-directional many-to-one association to TdoiDbPropslAviation

	private TdoiDbPropslAviationDTO tdoiDbPropslAviation;

	public TdoiDbPropAviationAircraftDTO() {
	}

	public long getAviatAircrftId() {
		return this.aviatAircrftId;
	}

	public void setAviatAircrftId(long aviatAircrftId) {
		this.aviatAircrftId = aviatAircrftId;
	}

	public String getAircraftType() {
		return this.aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public int getConstructYr() {
		return this.constructYr;
	}

	public void setConstructYr(int constructYr) {
		this.constructYr = constructYr;
	}

	public int getEngineNum() {
		return this.engineNum;
	}

	public void setEngineNum(int engineNum) {
		this.engineNum = engineNum;
	}

	public String getMakeType() {
		return this.makeType;
	}

	public void setMakeType(String makeType) {
		this.makeType = makeType;
	}

	public int getPurchaseYr() {
		return this.purchaseYr;
	}

	public void setPurchaseYr(int purchaseYr) {
		this.purchaseYr = purchaseYr;
	}

	public String getRegnNo() {
		return this.regnNo;
	}

	public void setRegnNo(String regnNo) {
		this.regnNo = regnNo;
	}

	public String getSeatingCapacity() {
		return this.seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getSeriesNo() {
		return this.seriesNo;
	}

	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}

	public TdoiDbPropslAviationDTO getTdoiDbPropslAviation() {
		return this.tdoiDbPropslAviation;
	}

	public void setTdoiDbPropslAviation(TdoiDbPropslAviationDTO tdoiDbPropslAviation) {
		this.tdoiDbPropslAviation = tdoiDbPropslAviation;
	}

}
