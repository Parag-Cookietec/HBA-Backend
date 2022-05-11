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

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the TDOI_DB_POL_AVIATION_AIRCRAFT database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_POL_AVIATION_AIRCRAFT", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPolAviationAircraftEntity.findAll", query = "SELECT t FROM TdoiDbPolAviationAircraftEntity t")
public class TdoiDbPolAviationAircraftEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AVIAT_AIRCRFT_ID", unique = true, nullable = false)
	private long aviatAircrftId;

	@Column(name = "AIRCRAFT_TYPE", length = 40)
	private String aircraftType;

	@Column(name = "CONSTRUCT_YR")
	private int constructYr;

	@Column(name = "ENGINE_NUM")
	private int engineNum;

	@Column(name = "MAKE_TYPE", length = 50)
	private String makeType;

	@Column(name = "PURCHASE_YR")
	private int purchaseYr;

	@Column(name = "REGN_NO", length = 50)
	private String regnNo;

	@Column(name = "SEATING_CAPACITY", length = 50)
	private String seatingCapacity;

	@Column(name = "SERIES_NO", length = 50)
	private String seriesNo;

	// bi-directional many-to-one association to TdoiDbPolAviation
	@ManyToOne
	@JoinColumn(name = "POL_AVIATION_ID", nullable = false)
	private TdoiDbPolAviationEntity tdoiDbPolAviation;

	public TdoiDbPolAviationAircraftEntity() {
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

	public TdoiDbPolAviationEntity getTdoiDbPolAviation() {
		return this.tdoiDbPolAviation;
	}

	public void setTdoiDbPolAviation(TdoiDbPolAviationEntity tdoiDbPolAviation) {
		this.tdoiDbPolAviation = tdoiDbPolAviation;
	}

}