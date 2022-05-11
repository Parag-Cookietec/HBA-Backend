package gov.ifms.doi.ac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDOI_AC_TE_RECOVERY_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_TE_RECOVERY_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcTeRecoveryDtlEntity.findAll", query = "SELECT t FROM TdoiAcTeRecoveryDtlEntity t")
public class TdoiAcTeRecoveryDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TE_RECOVERY_DTL_ID", unique = true, nullable = false)
	private long teRecoveryDtlId;

	@Column(name = "EDP_CODE")
	private long edpCode;

	@Column(name = "RECOVERY_AMT")
	private double recoveryAmt;

	@Column(name = "TRANS_FRM_OR_TO", length = 4)
	private String transFrmOrTo;

	@Column(name = "TRANSFR_DTL_ID", nullable = false)
	private long transfrDtlId;

	public long getTeRecoveryDtlId() {
		return this.teRecoveryDtlId;
	}

	public void setTeRecoveryDtlId(long teRecoveryDtlId) {
		this.teRecoveryDtlId = teRecoveryDtlId;
	}

	public long getEdpCode() {
		return this.edpCode;
	}

	public void setEdpCode(long edpCode) {
		this.edpCode = edpCode;
	}

	public double getRecoveryAmt() {
		return this.recoveryAmt;
	}

	public void setRecoveryAmt(double recoveryAmt) {
		this.recoveryAmt = recoveryAmt;
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
