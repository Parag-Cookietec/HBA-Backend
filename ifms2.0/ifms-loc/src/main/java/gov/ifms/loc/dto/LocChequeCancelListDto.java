package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChequeCancelListDto.
 */
@NativeQueryResultEntity
public class LocChequeCancelListDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The hdr id. */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;

	/** The cheque NO. */
	@NativeQueryResultColumn(index = 1)
	private String chequeNO;

	/** The div code. */
	@NativeQueryResultColumn(index = 2)
	private String divCode;

	/** The cheque amt. */
	@NativeQueryResultColumn(index = 3)
	private Double chequeAmt;

	/** The cheque date. */
	@NativeQueryResultColumn(index = 4)
	private Date chequeDate;

	/** The in favour. */
	@NativeQueryResultColumn(index = 5)
	private String inFavour;

	/** The advice no. */
	@NativeQueryResultColumn(index = 6)
	private String adviceNo;

	/** The bank id. */
	@NativeQueryResultColumn(index = 7)
	private Long bankId;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 8)
	private Long cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 9)
	private String ddoNo;
	
	@NativeQueryResultColumn(index = 10)
	private Long divId;
	

	/** The cheque dtl list. */
	private List<LocChequeCancelDetailDto> chequeDtlList;

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdrId
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the hdrId to set
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the cheque NO.
	 *
	 * @return the chequeNO
	 */
	public String getChequeNO() {
		return chequeNO;
	}

	/**
	 * Sets the cheque NO.
	 *
	 * @param chequeNO the chequeNO to set
	 */
	public void setChequeNO(String chequeNO) {
		this.chequeNO = chequeNO;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the divCode
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the divCode to set
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the cheque amt.
	 *
	 * @return the chequeAmt
	 */
	public Double getChequeAmt() {
		return chequeAmt;
	}

	/**
	 * Sets the cheque amt.
	 *
	 * @param chequeAmt the chequeAmt to set
	 */
	public void setChequeAmt(Double chequeAmt) {
		this.chequeAmt = chequeAmt;
	}

	/**
	 * Gets the cheque date.
	 *
	 * @return the chequeDate
	 */
	public Date getChequeDate() {
		return chequeDate;
	}

	/**
	 * Sets the cheque date.
	 *
	 * @param chequeDate the chequeDate to set
	 */
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * Gets the in favour.
	 *
	 * @return the inFavour
	 */
	public String getInFavour() {
		return inFavour;
	}

	/**
	 * Sets the in favour.
	 *
	 * @param inFavour the inFavour to set
	 */
	public void setInFavour(String inFavour) {
		this.inFavour = inFavour;
	}

	/**
	 * Gets the advice no.
	 *
	 * @return the adviceNo
	 */
	public String getAdviceNo() {
		return adviceNo;
	}

	/**
	 * Sets the advice no.
	 *
	 * @param adviceNo the adviceNo to set
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	/**
	 * Gets the cheque dtl list.
	 *
	 * @return the chequeDtlList
	 */
	public List<LocChequeCancelDetailDto> getChequeDtlList() {
		return chequeDtlList;
	}

	/**
	 * Sets the cheque dtl list.
	 *
	 * @param chequeDtlList the chequeDtlList to set
	 */
	public void setChequeDtlList(List<LocChequeCancelDetailDto> chequeDtlList) {
		this.chequeDtlList = chequeDtlList;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bankId
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the bankId to set
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	
	/**
	 * @return the divId
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * @param divId the divId to set
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
	}

	/**
	 * Instantiates a new loc cheque cancel list dto.
	 */
	public LocChequeCancelListDto() {
		super();

	}

}
