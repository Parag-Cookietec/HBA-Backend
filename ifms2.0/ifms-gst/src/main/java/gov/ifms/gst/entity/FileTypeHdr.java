package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TPAO_FILE_TYPE_HDR", schema = GSTConstant.GST_SCHEMA)
public class FileTypeHdr extends BaseEntity implements Serializable{
	public static final String TRN_SCREEN_CFD = "FTH";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAO_FILE_HDR_ID")
	private long id;

	@Column(name = "FILE_TYPE_CD")
	private String fileTypeCd;

	@Column(name = "FILE_TYPE_DESC")
	private String fileTypeDesc;

	@Column(name = "FILE_RECV_FREQ")
	private String fileRecvFreq;
	
	public FileTypeHdr(long id) {
		super();
		this.id = id;
	}

	public FileTypeHdr() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileTypeCd() {
		return fileTypeCd;
	}

	public void setFileTypeCd(String fileTypeCd) {
		this.fileTypeCd = fileTypeCd;
	}

	public String getFileTypeDesc() {
		return fileTypeDesc;
	}

	public void setFileTypeDesc(String fileTypeDesc) {
		this.fileTypeDesc = fileTypeDesc;
	}

	public String getFileRecvFreq() {
		return fileRecvFreq;
	}

	public void setFileRecvFreq(String fileRecvFreq) {
		this.fileRecvFreq = fileRecvFreq;
	}

	public String getTimeToPull() {
		return timeToPull;
	}

	public void setTimeToPull(String timeToPull) {
		this.timeToPull = timeToPull;
	}

	public static String getTrnScreenCfd() {
		return TRN_SCREEN_CFD;
	}

	@Column(name = "TIME_TO_PULL")
	private String timeToPull;
}
