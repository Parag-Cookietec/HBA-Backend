package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_GST_FILE_SUMMRY", schema = GSTConstant.GST_SCHEMA)
public class GSTFileSummery extends BaseEntity implements Serializable {
	public static final String TRN_SCREEN_BMS = "GFS";

	/** The designation id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GST_FILE_SUMM_ID")
	private Long id;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_DATE")
	private Date fileDate;

	@Column(name = "STATE_CD")
	private Short stateCd;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Column(name = "TOT_REC_CNT")
	private int totRecCnt;

	@Column(name = "TOT_FILE_CNT")
	private int totFileCnt;

	@Column(name = "CGST_AMT")
	private Double cgstAmt;

	@Column(name = "IGST_AMT")
	private Double igstAmt;

	@Column(name = "SGST_AMT")
	private Double sgstAmt;

	@Column(name = "CESS_AMT")
	private Double cessAmt;

	@Column(name = "TOT_AMT")
	private Double totAmt;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "FILE_READ_DT")
	private LocalDateTime fileReadDt;

	public Double getSgstAmt() {
		return sgstAmt;
	}

	public void setSgstAmt(Double sgstAmt) {
		this.sgstAmt = sgstAmt;
	}

	public Double getCessAmt() {
		return cessAmt;
	}

	public void setCessAmt(Double cessAmt) {
		this.cessAmt = cessAmt;
	}

	public Double getTotAmt() {
		return totAmt;
	}

	public void setTotAmt(Double totAmt) {
		this.totAmt = totAmt;
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

	public LocalDateTime getFileReadDt() {
		return fileReadDt;
	}

	public void setFileReadDt(LocalDateTime fileReadDt) {
		this.fileReadDt = fileReadDt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getTotRecCnt() {
		return totRecCnt;
	}

	public void setTotRecCnt(int totRecCnt) {
		this.totRecCnt = totRecCnt;
	}

	public int getTotFileCnt() {
		return totFileCnt;
	}

	public void setTotFileCnt(int totFileCnt) {
		this.totFileCnt = totFileCnt;
	}

	public Double getCgstAmt() {
		return cgstAmt;
	}

	public void setCgstAmt(Double cgstAmt) {
		this.cgstAmt = cgstAmt;
	}

	public Double getIgstAmt() {
		return igstAmt;
	}

	public void setIgstAmt(Double igstAmt) {
		this.igstAmt = igstAmt;
	}

	public static String getTrnScreenBms() {
		return TRN_SCREEN_BMS;
	}

	public GSTFileSummery(Long id) {
		super();
		this.id = id;
	}

	public GSTFileSummery() {
		super();
	}
}
