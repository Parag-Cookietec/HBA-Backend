package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_RBI_ACC_STMT_TRANXN", schema = GSTConstant.GST_SCHEMA)
public class RBIAccStmtTranxn extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_LBAO = "RAST";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RBI_ACC_TRANXN_ID")
	private long id;

	@Column(name = "RBI_ACC_STMT_ID")
	private long rbiAccStmtId;

	@Column(name = "NTRY_REF_ID")
	private String ntryRefId;

	@Column(name = "CCY_INR_AMT")
	private Double ccyInrAmt;

	@Column(name = "CRT_DBT_TYPE")
	private String crtDbtType;

	@Column(name = "RVSL_IND_TYPE")
	private String rvslIndType;

	@Column(name = "STATUS_TYPE")
	private String statusType;

	@Column(name = "BOOKING_DT")
	private Date bookingDt;

	@Column(name = "VALUE_DT")
	private Date valueDt;

	@Column(name = "BOOK_TX_CD")
	private String bookTxCd;

	public RBIAccStmtTranxn(Long id) {
		super();
		this.id = id;
	}

	public RBIAccStmtTranxn() {
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

	public String getNtryRefId() {
		return ntryRefId;
	}

	public void setNtryRefId(String ntryRefId) {
		this.ntryRefId = ntryRefId;
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

	public String getRvslIndType() {
		return rvslIndType;
	}

	public void setRvslIndType(String rvslIndType) {
		this.rvslIndType = rvslIndType;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public Date getBookingDt() {
		return bookingDt;
	}

	public void setBookingDt(Date bookingDt) {
		this.bookingDt = bookingDt;
	}

	public Date getValueDt() {
		return valueDt;
	}

	public void setValueDt(Date valueDt) {
		this.valueDt = valueDt;
	}

	public String getBookTxCd() {
		return bookTxCd;
	}

	public void setBookTxCd(String bookTxCd) {
		this.bookTxCd = bookTxCd;
	}

}
