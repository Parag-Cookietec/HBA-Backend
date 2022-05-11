package gov.ifms.gst.dto;

import java.io.Serializable;

public class FileTypeHdrDto implements Serializable {

	private long id;
	private String fileTypeCd;
	private String fileTypeDesc;
	private String fileRecvFreq;

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
}
