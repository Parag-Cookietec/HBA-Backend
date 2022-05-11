package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.gst.util.GSTUtility;

import java.io.Serializable;

@NativeQueryResultEntity
public class GSTBlockCpinListingDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The referenceNumber. */
	@NativeQueryResultColumn(index = 1)
	private String referenceNo;

	/** The referenceDate. */
	@NativeQueryResultColumn(index = 2)
	private String referenceDt;

	/** The effectiveFromDate. */
	@NativeQueryResultColumn(index = 3)
	private Long cpinNo;

	/** The effectiveToDate. */
	@NativeQueryResultColumn(index = 4)
	private String recStatus;

	/** The bankRate. */
	@NativeQueryResultColumn(index = 5)
	private Double cpinAmount;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 6)
	private String trnStatus;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 7)
	private String wfStatus;

	@NativeQueryResultColumn(index = 8)
	private int isEditable;

	@NativeQueryResultColumn(index = 9)
	private int totalRecords;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(String referenceDt) {
		this.referenceDt = referenceDt;
	}

	public Long getCpinNo() {
		return cpinNo;
	}

	public void setCpinNo(Long cpinNo) {
		this.cpinNo = cpinNo;
	}

	public String getRecStatus() {
		return recStatus;
	}

	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}

	public Double getCpinAmount() {
		return cpinAmount;
	}

	public void setCpinAmount(Double cpinAmount) {
		this.cpinAmount = cpinAmount;
	}

	public String getTrnStatus() {
		return trnStatus;
	}

	public void setTrnStatus(String trnStatus) {
		this.trnStatus = trnStatus;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public int getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(int isEditable) {
		this.isEditable = isEditable;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
}
