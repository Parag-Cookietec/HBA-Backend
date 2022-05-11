package gov.ifms.gst.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;
import gov.ifms.edp.dto.BaseDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NativeQueryResultEntity
public class ManualEntryLstResDto implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private Long id;

	/** The referenceNumber. */
	@NativeQueryResultColumn(index = 1)
	private String referenceNo;

	@NativeQueryResultColumn(index = 2)
	private String cinNo;

	@NativeQueryResultColumn(index = 3)
	private Double totalEntryAmt;

	@NativeQueryResultColumn(index = 4)
	private String manualEntryDt;

	@NativeQueryResultColumn(index = 5)
	private String valueDt;

	@NativeQueryResultColumn(index = 6)
	private Long typeId;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 7)
	private String trnStatus;

	/** The trnStatus. */
	@NativeQueryResultColumn(index = 8)
	private String wfStatus;

	@NativeQueryResultColumn(index = 9)
	private int isEditable;

	@NativeQueryResultColumn(index = 10)
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

	public String getCinNo() {
		return cinNo;
	}

	public void setCinNo(String cinNo) {
		this.cinNo = cinNo;
	}

	public Double getTotalEntryAmt() {
		return totalEntryAmt;
	}

	public void setTotalEntryAmt(Double totalEntryAmt) {
		this.totalEntryAmt = totalEntryAmt;
	}

	public String getManualEntryDt() {
		return manualEntryDt;
	}

	public void setManualEntryDt(String manualEntryDt) {
		this.manualEntryDt = manualEntryDt;
	}

	public String getValueDt() {
		return valueDt;
	}

	public void setValueDt(String valueDt) {
		this.valueDt = valueDt;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
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


