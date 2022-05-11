package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TPAO_RBI_ACC_STMT_BAL", schema = GSTConstant.GST_SCHEMA)
public class RBIAccStmtBal extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_RASB = "RASB";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_ACC_BAL_ID")
	private long id;

	@Column(name = "RBI_ACC_STMT_ID")
	private long rbiAccStmtId;

	@Column(name = "BAL_CD_TYPE")
	private String balCdType;

	@Column(name = "CCY_INR_AMT")
	private Double ccyInrAmt;

	@Column(name = "CRT_DBT_TYPE")
	private String crtDbtType;

	@Column(name = "CDT_DBT_DTTM")
	private LocalDateTime cdtDbtDttm;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public RBIAccStmtBal(Long id) {
		super();
		this.id = id;
	}

	public RBIAccStmtBal() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRbiAccStmtId() {
		return rbiAccStmtId;
	}

	public void setRbiAccStmtId(long rbiAccStmtId) {
		this.rbiAccStmtId = rbiAccStmtId;
	}

	public String getBalCdType() {
		return balCdType;
	}

	public void setBalCdType(String balCdType) {
		this.balCdType = balCdType;
	}

	public Double getCcyInrAmt() {
		return ccyInrAmt;
	}

	public void setCcyInrAmt(Double ccyInrAmt) {
		this.ccyInrAmt = ccyInrAmt;
	}

	public String getCrtDbtType() {
		return crtDbtType;
	}

	public void setCrtDbtType(String crtDbtType) {
		this.crtDbtType = crtDbtType;
	}

	public LocalDateTime getCdtDbtDttm() {
		return cdtDbtDttm;
	}

	public void setCdtDbtDttm(LocalDateTime cdtDbtDttm) {
		this.cdtDbtDttm = cdtDbtDttm;
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

	public static String getTrnScreenRasb() {
		return TRN_SCREEN_RASB;
	}

}
