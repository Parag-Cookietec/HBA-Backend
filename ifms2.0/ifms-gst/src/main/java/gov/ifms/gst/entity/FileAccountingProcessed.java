package gov.ifms.gst.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

@Entity
@Table(name = "TPAO_FILE_ACCOUNT_PROCESSED", schema = GSTConstant.GST_SCHEMA)
public class FileAccountingProcessed extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Object TRN_SCREEN_BMS = "GFAP";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ACCOUNT_ID")
	private long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_PROCESS_ID")
	private GSTFileProcess fileProcessId;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "NO_OF_CHALLANS")
	private Short noOfChallans;

	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "VOUCHER_NO")
	private String voucherNo;

	@Column(name = "TOT_CHALLAN_AMT")
	private Double totChallanAmt;

	@Column(name = "FILE_ACCOUNTS_STATUS")
	private String fileAccountsStatus;

	@Column(name = "ACCOUNTING_DT")
	private LocalDateTime accountingDt;

	@Column(name = "ACCOUNT_DONE_BY")
	private long accountDoneBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Short getNoOfChallans() {
		return noOfChallans;
	}

	public void setNoOfChallans(Short noOfChallans) {
		this.noOfChallans = noOfChallans;
	}

	public Date getChallanDt() {
		return challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public String getFileAccountsStatus() {
		return fileAccountsStatus;
	}

	public void setFileAccountsStatus(String fileAccountsStatus) {
		this.fileAccountsStatus = fileAccountsStatus;
	}

	public LocalDateTime getAccountingDt() {
		return accountingDt;
	}

	public void setAccountingDt(LocalDateTime accountingDt) {
		this.accountingDt = accountingDt;
	}

	public long getAccountDoneBy() {
		return accountDoneBy;
	}

	public void setAccountDoneBy(long accountDoneBy) {
		this.accountDoneBy = accountDoneBy;
	}

	public static Object getTrnScreenBms() {
		return TRN_SCREEN_BMS;
	}

	public FileAccountingProcessed(Long id) {
		super();
		this.id = id;
	}

	public FileAccountingProcessed() {
		super();
	}

	public GSTFileProcess getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(GSTFileProcess fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

}
