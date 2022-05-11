package gov.ifms.doi.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

/**
 * The persistent class for the MDOI_DB_FIRE_SUM_INSR_MST database table.
 * 
 */
@Entity
@Table(name = "MDOI_DB_FIRE_SUM_INSR_MST", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "MdoiDbFireSumInsrMstEntity.findAll", query = "SELECT m FROM MdoiDbFireSumInsrMstEntity m")
public class MdoiDbFireSumInsrMstEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;
	private long riskCoverId;

	private String riskCoverType;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RISK_COVER_ID", unique = true, nullable = false)
	public long getRiskCoverId() {
		return this.riskCoverId;
	}

	public void setRiskCoverId(long riskCoverId) {
		this.riskCoverId = riskCoverId;
	}

	@Column(name = "RISK_COVER_TYPE", length = 50)
	public String getRiskCoverType() {
		return this.riskCoverType;
	}

	public void setRiskCoverType(String riskCoverType) {
		this.riskCoverType = riskCoverType;
	}

}