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
 * The persistent class for the TDOI_DB_PROPSL_EQUIP_DTLS database table.
 * 
 */
@Entity
@Table(name = "TDOI_DB_PROPSL_EQUIP_DTLS", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiDbPropslEquipDtlEntity.findAll", query = "SELECT t FROM TdoiDbPropslEquipDtlEntity t")
public class TdoiDbPropslEquipDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQUIP_DTLS_ID", unique = true, nullable = false)
	private long equipDtlsId;

	@Column(name = "EQUIP_DESC", length = 200)
	private String equipDesc;

	@Column(name = "EQUIP_HIRE_PUR")
	private long equipHirePur;

	@Column(name = "EQUIP_QUANTITY")
	private short equipQuantity;

	@Column(name = "EQUIPMENT_DTLS", length = 60)
	private String equipmentDtls;

	@Column(name = "EXCESS_CL_AMT")
	private double excessClAmt;

	@Column(name = "MANUFACTURE_YR")
	private short manufactureYr;

	@Column(name = "SUM_INSURED")
	private double sumInsured;

	// bi-directional many-to-one association to TdoiDbPropslElecEquip
	@ManyToOne
	@JoinColumn(name = "DB_ELEC_EQUIP_ID", nullable = false)
	private TdoiDbPropslElecEquipEntity tdoiDbPropslElecEquip;

	public TdoiDbPropslEquipDtlEntity() {
	}

	public long getEquipDtlsId() {
		return this.equipDtlsId;
	}

	public void setEquipDtlsId(long equipDtlsId) {
		this.equipDtlsId = equipDtlsId;
	}

	public String getEquipDesc() {
		return this.equipDesc;
	}

	public void setEquipDesc(String equipDesc) {
		this.equipDesc = equipDesc;
	}

	public long getEquipHirePur() {
		return this.equipHirePur;
	}

	public void setEquipHirePur(long equipHirePur) {
		this.equipHirePur = equipHirePur;
	}

	public short getEquipQuantity() {
		return this.equipQuantity;
	}

	public void setEquipQuantity(short equipQuantity) {
		this.equipQuantity = equipQuantity;
	}

	public String getEquipmentDtls() {
		return this.equipmentDtls;
	}

	public void setEquipmentDtls(String equipmentDtls) {
		this.equipmentDtls = equipmentDtls;
	}

	public double getExcessClAmt() {
		return this.excessClAmt;
	}

	public void setExcessClAmt(double excessClAmt) {
		this.excessClAmt = excessClAmt;
	}

	public short getManufactureYr() {
		return this.manufactureYr;
	}

	public void setManufactureYr(short manufactureYr) {
		this.manufactureYr = manufactureYr;
	}

	public double getSumInsured() {
		return this.sumInsured;
	}

	public void setSumInsured(double sumInsured) {
		this.sumInsured = sumInsured;
	}

	public TdoiDbPropslElecEquipEntity getTdoiDbPropslElecEquip() {
		return this.tdoiDbPropslElecEquip;
	}

	public void setTdoiDbPropslElecEquip(TdoiDbPropslElecEquipEntity tdoiDbPropslElecEquip) {
		this.tdoiDbPropslElecEquip = tdoiDbPropslElecEquip;
	}

}