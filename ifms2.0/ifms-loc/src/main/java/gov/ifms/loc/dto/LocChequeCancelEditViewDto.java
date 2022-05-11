package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.edp.dto.BaseDto;

/**
 * The Class LocChequeCancelEditViewDto.
 */
public class LocChequeCancelEditViewDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;
	
	@NativeQueryResultColumn(index = 1)
	private String refNo;

	@NativeQueryResultColumn(index = 2)
	private Date refNoDate;
	
	@NativeQueryResultColumn(index = 3)
	private String approvalDate;
	
	/** The cheque NO. */
	@NativeQueryResultColumn(index = 4)
	private String chequeNO;

	@NativeQueryResultColumn(index = 5)
	private Date chequeDate;



	@NativeQueryResultColumn(index = 6)
	private Double chequeAmt;

	/** The in favour. */
	@NativeQueryResultColumn(index = 7)
	private String inFavour;

	

	@NativeQueryResultColumn(index = 8)
	private String reason;
	

	@NativeQueryResultColumn(index = 9)
	private String divId;

	@NativeQueryResultColumn(index = 10)
	private Long bankID;
	
	
	@NativeQueryResultColumn(index = 11)
	private Long lcAdviceId;
	
	@NativeQueryResultColumn(index = 12)
	private String divCode;
	
	/** The advice no. */
	@NativeQueryResultColumn(index = 13)
	private String adviceNo;

	

	/** The cheque dtl list. */
	private List<LocChequeCancelEditViewDtlDto> chequeDtlList;

	
	public LocChequeCancelEditViewDto() {
		super();
	}


	/**
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}


	/**
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}


	/**
	 * @return the refNo
	 */
	public String getRefNo() {
		return refNo;
	}


	/**
	 * @param refNo the refNo to set
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	/**
	 * @return the refNoDate
	 */
	public Date getRefNoDate() {
		return refNoDate;
	}


	/**
	 * @param refNoDate the refNoDate to set
	 */
	public void setRefNoDate(Date refNoDate) {
		this.refNoDate = refNoDate;
	}


	/**
	 * @return the approvalDate
	 */
	public String getApprovalDate() {
		return approvalDate;
	}


	/**
	 * @param approvalDate the approvalDate to set
	 */
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}


	/**
	 * @return the chequeNO
	 */
	public String getChequeNO() {
		return chequeNO;
	}


	/**
	 * @param chequeNO the chequeNO to set
	 */
	public void setChequeNO(String chequeNO) {
		this.chequeNO = chequeNO;
	}


	/**
	 * @return the chequeDate
	 */
	public Date getChequeDate() {
		return chequeDate;
	}


	/**
	 * @param chequeDate the chequeDate to set
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}


	/**
	 * @return the chequeAmt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}


	/**
	 * @param chequeAmt the chequeAmt to set
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}


	/**
	 * @return the inFavour
	 */
	public String getInFavour() {
		return inFavour;
	}


	/**
	 * @param inFavour the inFavour to set
	 */
	public void setInFavour(String inFavour) {
		this.inFavour = inFavour;
	}


	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}


	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}


	/**
	 * @return the divId
	 */
	public String getDivId() {
		return divId;
	}


	/**
	 * @param divId the divId to set
	 */
	public void setDivId(String divId) {
		this.divId = divId;
	}


	/**
	 * @return the bankID
	 */
	public Long getBankID() {
		return bankID;
	}


	/**
	 * @param bankID the bankID to set
	 */
	public void setBankID(Long bankID) {
		this.bankID = bankID;
	}


	/**
	 * @return the lcAdviceId
	 */
	public Long getLcAdviceId() {
		return lcAdviceId;
	}


	/**
	 * @param lcAdviceId the lcAdviceId to set
	 */
	public void setLcAdviceId(Long lcAdviceId) {
		this.lcAdviceId = lcAdviceId;
	}


	/**
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}


	/**
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}


	/**
	 * @return the adviceNo
	 */
	public String getAdviceNo() {
		return adviceNo;
	}


	/**
	 * @param adviceNo the adviceNo to set
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}


	/**
	 * @return the chequeDtlList
	 */
	public List<LocChequeCancelEditViewDtlDto> getChequeDtlList() {
		return chequeDtlList;
	}


	/**
	 * @param chequeDtlList the chequeDtlList to set
	 */
	public void setChequeDtlList(List<LocChequeCancelEditViewDtlDto> chequeDtlList) {
		this.chequeDtlList = chequeDtlList;
	}

	
}
