package gov.ifms.doi.ac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDOI_AC_TE_EXPENDITURE_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_TE_EXPENDITURE_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcTeExpenditureDtlEntity.findAll", query = "SELECT t FROM TdoiAcTeExpenditureDtlEntity t")
public class TdoiAcTeExpenditureDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TE_EXPEN_DTL_ID", unique = true, nullable = false)
	private long teExpenDtlId;

	@Column(name = "EDP_CODE")
	private long edpCode;

	@Column(name = "EXPENDITURE_AMT")
	private double expenditureAmt;

	@Column(name = "TRANS_FRM_OR_TO", length = 4)
	private String transFrmOrTo;

	@Column(name = "TRANSFR_DTL_ID", nullable = false)
	private long transfrDtlId;

	public long getTeExpenDtlId() {
		return this.teExpenDtlId;
	}

	public void setTeExpenDtlId(long teExpenDtlId) {
		this.teExpenDtlId = teExpenDtlId;
	}

	public long getEdpCode() {
		return this.edpCode;
	}

	public void setEdpCode(long edpCode) {
		this.edpCode = edpCode;
	}

	public double getExpenditureAmt() {
		return this.expenditureAmt;
	}

	public void setExpenditureAmt(double expenditureAmt) {
		this.expenditureAmt = expenditureAmt;
	}

	public String getTransFrmOrTo() {
		return this.transFrmOrTo;
	}

	public void setTransFrmOrTo(String transFrmOrTo) {
		this.transFrmOrTo = transFrmOrTo;
	}

	public long getTransfrDtlId() {
		return this.transfrDtlId;
	}

	public void setTransfrDtlId(long transfrDtlId) {
		this.transfrDtlId = transfrDtlId;
	}

}
