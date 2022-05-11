package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_RBI_MOE_RESLVD_CASE", schema = GSTConstant.GST_SCHEMA)
public class RBIMoeReslvdCase extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RMRC";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOE_RESLVD_CASE_ID")
	private long id;

	@Column(name = "RBI_MOE_RES_ID")
	private long rbiMoeResId;

	@Column(name = "RESOLVED_CASE_ID")
	private String resolvedCaseId;

	@Column(name = "CONF_STS_ID")
	private String confStsId;

	@Column(name = "REJCD_MOD_ID")
	private String rejcdModId;

	@Column(name = "STMT_INSTR_ID")
	private String stmtInstrId;

	@Column(name = "STMT_ENDTOEND_ID")
	private String stmtEndtoendId;

	@Column(name = "STMT_TOT_TAX_AMT")
	private Double stmtTotTaxAmt;

	@Column(name = "CORRCTN_INSTR_ID")
	private String corrctnInstrId;

	@Column(name = "CORRCTN_ENDTOEND_ID")
	private String corrctnEndtoendId;

	@Column(name = "CORRCTN_TOT_TAX_AMT")
	private Double corrctnTotTaxAmt;

	@Column(name = "RESL_INTBK_STTLM_AMT")
	private String reslIntbkSttlmAmt;

	@Column(name = "RESL_INTBK_STTLM_DT")
	private Date reslIntbkSttlmDt;

	@Column(name = "RESL_ADDNL_INFO")
	private String reslAddnlInfo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public RBIMoeReslvdCase(Long id) {
		super();
		this.id = id;
	}

	public RBIMoeReslvdCase() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiMoeResId() {
		return rbiMoeResId;
	}

	public void setRbiMoeResId(long rbiMoeResId) {
		this.rbiMoeResId = rbiMoeResId;
	}

	public String getResolvedCaseId() {
		return resolvedCaseId;
	}

	public void setResolvedCaseId(String resolvedCaseId) {
		this.resolvedCaseId = resolvedCaseId;
	}

	public String getConfStsId() {
		return confStsId;
	}

	public void setConfStsId(String confStsId) {
		this.confStsId = confStsId;
	}

	public String getRejcdModId() {
		return rejcdModId;
	}

	public void setRejcdModId(String rejcdModId) {
		this.rejcdModId = rejcdModId;
	}

	public String getStmtInstrId() {
		return stmtInstrId;
	}

	public void setStmtInstrId(String stmtInstrId) {
		this.stmtInstrId = stmtInstrId;
	}

	public String getStmtEndtoendId() {
		return stmtEndtoendId;
	}

	public void setStmtEndtoendId(String stmtEndtoendId) {
		this.stmtEndtoendId = stmtEndtoendId;
	}

	public Double getStmtTotTaxAmt() {
		return stmtTotTaxAmt;
	}

	public void setStmtTotTaxAmt(Double stmtTotTaxAmt) {
		this.stmtTotTaxAmt = stmtTotTaxAmt;
	}

	public String getCorrctnInstrId() {
		return corrctnInstrId;
	}

	public void setCorrctnInstrId(String corrctnInstrId) {
		this.corrctnInstrId = corrctnInstrId;
	}

	public String getCorrctnEndtoendId() {
		return corrctnEndtoendId;
	}

	public void setCorrctnEndtoendId(String corrctnEndtoendId) {
		this.corrctnEndtoendId = corrctnEndtoendId;
	}

	public Double getCorrctnTotTaxAmt() {
		return corrctnTotTaxAmt;
	}

	public void setCorrctnTotTaxAmt(Double corrctnTotTaxAmt) {
		this.corrctnTotTaxAmt = corrctnTotTaxAmt;
	}

	public String getReslIntbkSttlmAmt() {
		return reslIntbkSttlmAmt;
	}

	public void setReslIntbkSttlmAmt(String reslIntbkSttlmAmt) {
		this.reslIntbkSttlmAmt = reslIntbkSttlmAmt;
	}

	public Date getReslIntbkSttlmDt() {
		return reslIntbkSttlmDt;
	}

	public void setReslIntbkSttlmDt(Date reslIntbkSttlmDt) {
		this.reslIntbkSttlmDt = reslIntbkSttlmDt;
	}

	public String getReslAddnlInfo() {
		return reslAddnlInfo;
	}

	public void setReslAddnlInfo(String reslAddnlInfo) {
		this.reslAddnlInfo = reslAddnlInfo;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

}
