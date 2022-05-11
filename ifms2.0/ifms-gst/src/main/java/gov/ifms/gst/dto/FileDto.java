package gov.ifms.gst.dto;

import java.util.Date;

public class FileDto {
	private String fileName;
	private short noOfTransaction;
	private Double totalAmount = 0.00;
	private Date fileDt;

	public Date getFileDt() {
		return fileDt;
	}

	public void setFileDt(Date fileDt) {
		this.fileDt = fileDt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public short getNoOfTransaction() {
		return noOfTransaction;
	}

	public void setNoOfTransaction(short noOfTransaction) {
		this.noOfTransaction = noOfTransaction;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
