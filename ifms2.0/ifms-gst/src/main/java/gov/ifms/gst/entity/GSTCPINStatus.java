package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_CPIN_STATUS", schema = GSTConstant.GST_SCHEMA)
public class GSTCPINStatus extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_CPIN_STATUS = "GCS";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CPIN_STATUS_ID")
	private long id;

	@Column(name = "FILE_NO")
	private String fileNumber;

	@Column(name = "FILE_DT")
	private Date fileDt;

	@Column(name = "RECORD_TYPE")
	@Enumerated(EnumType.STRING)
	private RecordType recordType;

	@Column(name = "CIN_NO")
	private String cinNo;

	@Column(name = "CPIN_NO")
	private long cpinNo;

	@Column(name = "CPIN_AMOUNT")
	private Double cpinAmount;

	@Column(name = "GOVT_CREDIT_DT")
	private Date govtCreditDt;

	@Column(name = "FILE_STATUS_ID")
	private long fileStatusId;

	@Column(name = "FILE_STATUS")
	private String fileStatus;

	@Column(name = "SIGNED_DATA")
	private String signedData;

	@Column(name = "TRANS_STATUS_ID")
	private long transStatusId;

	@Column(name = "TRANS_STATUS")
	private String transStatus;

	@Column(name = "REFERENCE_NO")
	private String refrenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime refrenceDt;

	public GSTCPINStatus(long id) {
		super();
		this.id = id;
	}

	public GSTCPINStatus() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

	public Date getFileDt() {
		return fileDt;
	}

	public void setFileDt(Date fileDt) {
		this.fileDt = fileDt;
	}

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public Double getCpinAmount() {
		return cpinAmount;
	}

	public void setCpinAmount(Double cpinAmount) {
		this.cpinAmount = cpinAmount;
	}

	public Date getGovtCreditDt() {
		return govtCreditDt;
	}

	public void setGovtCreditDt(Date govtCreditDt) {
		this.govtCreditDt = govtCreditDt;
	}

	public long getFileStatusId() {
		return fileStatusId;
	}

	public void setFileStatusId(long fileStatusId) {
		this.fileStatusId = fileStatusId;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	public String getSignedData() {
		return signedData;
	}

	public void setSignedData(String signedData) {
		this.signedData = signedData;
	}

	public long getTransStatusId() {
		return transStatusId;
	}

	public void setTransStatusId(long transStatusId) {
		this.transStatusId = transStatusId;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public LocalDateTime getRefrenceDt() {
		return refrenceDt;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}

	public void setRefrenceDt(LocalDateTime refrenceDt) {
		this.refrenceDt = refrenceDt;
	}

	public static String getTrnScreenCpinStatus() {
		return TRN_SCREEN_CPIN_STATUS;
	}

}
