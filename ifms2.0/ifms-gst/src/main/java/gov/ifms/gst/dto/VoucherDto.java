package gov.ifms.gst.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoucherDto implements Serializable {

	private String fileName;
	private String status;
	private Date fileDate;
	private Double totalAmount = 0.00;
	private String voucherNo;
	private String refrenceNo;
	private Short totalNoOfTransaction = 0;
	private String fileTypeCd;
	private short stateCd;
	private Date refrenceDt;
	private List<CreditHeadDto> creditHead = new ArrayList<>();
	private List<FileDto> fileDto = new ArrayList<>();
	private Long menuId;
	private String message;
	private Long fileAccountingProcessedId;

	public List<FileDto> getFileDto() {
		return fileDto;
	}

	public void setFileDto(List<FileDto> fileDto) {
		this.fileDto = fileDto;
	}

	public List<CreditHeadDto> getCreditHead() {
		return creditHead;
	}

	public void setCreditHead(List<CreditHeadDto> creditHead) {
		this.creditHead = creditHead;
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

	public Short getTotalNoOfTransaction() {
		return totalNoOfTransaction;
	}

	public void setTotalNoOfTransaction(Short totalNoOfTransaction) {
		this.totalNoOfTransaction = totalNoOfTransaction;
	}

	private List<Dtos> dtos = new ArrayList<>();

	public List<Dtos> getDtos() {
		return dtos;
	}

	public void setDtos(List<Dtos> dtos) {
		this.dtos = dtos;
	}

	public String getRefrenceNo() {
		return refrenceNo;
	}

	public void setRefrenceNo(String refrenceNo) {
		this.refrenceNo = refrenceNo;
	}

	public String getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public Date getRefrenceDt() {
		return refrenceDt;
	}

	public void setRefrenceDt(Date refrenceDt) {
		this.refrenceDt = refrenceDt;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getFileAccountingProcessedId() {
		return fileAccountingProcessedId;
	}

	public void setFileAccountingProcessedId(Long fileAccountingProcessedId) {
		this.fileAccountingProcessedId = fileAccountingProcessedId;
	}
}
