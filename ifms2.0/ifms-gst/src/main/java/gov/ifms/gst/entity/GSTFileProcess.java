package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TPAO_FILE_PROCESS", schema = GSTConstant.GST_SCHEMA)
public class GSTFileProcess extends BaseEntity implements Serializable {

	public static final String TRN_SCREEN_BMS = "GFP";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_PROCESS_ID")
	private long id;

	@Column(name = "PAO_FILE_HDR_ID")
	private long paoFileHdrId;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_RECV_DT")
	private Date fileRecvDt;

	@Column(name = "FILE_GENERATE_DT")
	private Date fileGenerateDt;

	@Column(name = "STATE_CD")
	private short stateCd;

	@Column(name = "FILE_TYPE_CD")
	private String fileTypeCd;

	@Column(name = "RECORD_COUNT")
	private short recordCount;

	@Column(name = "FILE_FORMAT_TYPE")
	private String fileFormatType;

	@Column(name = "IS_FILE_PROCESSED")
	private char fileProcessed;

	@Column(name = "FILE_PROCESS_DT")
	private Date fileProcessedDt;

	@Column(name = "FILE_PROCESS_STATUS")
	private String fileProcessStatus;
	
	

	public GSTFileProcess(Long id) {
		super();
		this.id = id;
	}

	public GSTFileProcess() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPaoFileHdrId() {
		return paoFileHdrId;
	}

	public void setPaoFileHdrId(Long paoFileHdrId) {
		this.paoFileHdrId = paoFileHdrId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getFileRecvDt() {
		return fileRecvDt;
	}

	public void setFileRecvDt(Date fileRecvDt) {
		this.fileRecvDt = fileRecvDt;
	}

	public Date getFileGenerateDt() {
		return fileGenerateDt;
	}

	public void setFileGenerateDt(Date fileGenerateDt) {
		this.fileGenerateDt = fileGenerateDt;
	}

	public short getStateCd() {
		return stateCd;
	}

	public void setStateCd(short stateCd) {
		this.stateCd = stateCd;
	}

	public String getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public Short getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Short recordCount) {
		this.recordCount = recordCount;
	}

	public String getFileFormatType() {
		return fileFormatType;
	}

	public void setFileFormatType(String fileFormatType) {
		this.fileFormatType = fileFormatType;
	}

	public char getFileProcessed() {
		return fileProcessed;
	}

	public void setFileProcessed(char fileProcessed) {
		this.fileProcessed = fileProcessed;
	}

	public Date getFileProcessedDt() {
		return fileProcessedDt;
	}

	public void setFileProcessedDt(Date fileProcessedDt) {
		this.fileProcessedDt = fileProcessedDt;
	}

	public String getFileProcessStatus() {
		return fileProcessStatus;
	}

	public void setFileProcessStatus(String fileProcessStatus) {
		this.fileProcessStatus = fileProcessStatus;
	}

}
