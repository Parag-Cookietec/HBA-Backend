package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdvicePrepListingDto.
 */
@NativeQueryResultEntity
public class LocAdviceInwardListingDto implements Serializable {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The hdr id.
	 */
	@NativeQueryResultColumn(index = 0)
	private Long hdrId;
	/**
	 * The ref no.
	 */
	@NativeQueryResultColumn(index = 1)
	private String refNo;

	/**
	 * The virtual token no.
	 */
	@NativeQueryResultColumn(index = 2)
	private Long virtualTokenNo;

	/**
	 * The virtual token date.
	 */
	@NativeQueryResultColumn(index = 3)
	private Date virtualTokenDate;

	/** The advice no. */
	@NativeQueryResultColumn(index = 4)
	private String adviceNo;

	/**
	 * The advice date.
	 */
	@NativeQueryResultColumn(index = 5)
	private Date adviceDate;

	/** The cardex no. */
	@NativeQueryResultColumn(index = 6)
	private Long cardexNo;

	/** The ddo no. */
	@NativeQueryResultColumn(index = 7)
	private String ddoNo;

	/** The div code. */
	@NativeQueryResultColumn(index = 8)
	private String divCode;

	/** The div name. */
	@NativeQueryResultColumn(index = 9)
	private String divName;

	/** The circle code. */
	@NativeQueryResultColumn(index = 10)
	private String circleCode;

	/** The payment type name. */
	@NativeQueryResultColumn(index = 11)
	private String paymentTypeName;

	/** The district id. */
	@NativeQueryResultColumn(index = 12)
	private Long districtId;

	/** The party name. */
	@NativeQueryResultColumn(index = 13)
	private String partyName;

	/**
	 * The gross amt.
	 */
	@NativeQueryResultColumn(index = 14)
	private Double grossAmt;

	/** The deduction amt. */
	@NativeQueryResultColumn(index = 15)
	private Double deductionAmt;

	/**
	 * The net amt.
	 */
	@NativeQueryResultColumn(index = 16)
	private Double netAmt;
	
	/**
	 * The is editable.
	 */
	@NativeQueryResultColumn(index = 17)
	private Long isEditable;


	/**
	 * Gets the ref no.
	 *
	 * @return the ref no
	 */
	public String getRefNo() {
		return refNo;
	}

	/**
	 * Sets the ref no.
	 *
	 * @param refNo the new ref no
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	/**
	 * Gets the virtual token no.
	 *
	 * @return the virtual token no
	 */
	public Long getVirtualTokenNo() {
		return virtualTokenNo;
	}

	/**
	 * Sets the virtual token no.
	 *
	 * @param virtualTokenNo the new virtual token no
	 */
	public void setVirtualTokenNo(Long virtualTokenNo) {
		this.virtualTokenNo = virtualTokenNo;
	}

	/**
	 * Gets the virtual token date.
	 *
	 * @return the virtual token date
	 */
	public Date getVirtualTokenDate() {
		return virtualTokenDate;
	}

	/**
	 * Sets the virtual token date.
	 *
	 * @param virtualTokenDate the new virtual token date
	 */
	public void setVirtualTokenDate(Date virtualTokenDate) {
		this.virtualTokenDate = virtualTokenDate;
	}

	/**
	 * Gets the advice no.
	 *
	 * @return the advice no
	 */
	public String getAdviceNo() {
		return adviceNo;
	}

	/**
	 * Sets the advice no.
	 *
	 * @param adviceNo the new advice no
	 */
	public void setAdviceNo(String adviceNo) {
		this.adviceNo = adviceNo;
	}

	/**
	 * Gets the advice date.
	 *
	 * @return the advice date
	 */
	public Date getAdviceDate() {
		return adviceDate;
	}

	/**
	 * Sets the advice date.
	 *
	 * @param adviceDate the new advice date
	 */
	public void setAdviceDate(Date adviceDate) {
		this.adviceDate = adviceDate;
	}

	/**
	 * Gets the gross amt.
	 *
	 * @return the gross amt
	 */
	public Double getGrossAmt() {
		return grossAmt;
	}

	/**
	 * Sets the gross amt.
	 *
	 * @param grossAmt the new gross amt
	 */
	public void setGrossAmt(Double grossAmt) {
		this.grossAmt = grossAmt;
	}

	/**
	 * Gets the net amt.
	 *
	 * @return the net amt
	 */
	public Double getNetAmt() {
		return netAmt;
	}

	/**
	 * Sets the net amt.
	 *
	 * @param netAmt the new net amt
	 */
	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
	}

	/**
	 * Gets the hdr id.
	 *
	 * @return the hdr id
	 */
	public Long getHdrId() {
		return hdrId;
	}

	/**
	 * Sets the hdr id.
	 *
	 * @param hdrId the new hdr id
	 */
	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	/**
	 * Gets the cardex no.
	 *
	 * @return the cardex no
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * Sets the cardex no.
	 *
	 * @param cardexNo the new cardex no
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * Gets the ddo no.
	 *
	 * @return the ddo no
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * Sets the ddo no.
	 *
	 * @param ddoNo the new ddo no
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * Gets the div code.
	 *
	 * @return the div code
	 */
	public String getDivCode() {
		return divCode;
	}

	/**
	 * Sets the div code.
	 *
	 * @param divCode the new div code
	 */
	public void setDivCode(String divCode) {
		this.divCode = divCode;
	}

	/**
	 * Gets the div name.
	 *
	 * @return the div name
	 */
	public String getDivName() {
		return divName;
	}

	/**
	 * Sets the div name.
	 *
	 * @param divName the new div name
	 */
	public void setDivName(String divName) {
		this.divName = divName;
	}

	/**
	 * Gets the circle code.
	 *
	 * @return the circle code
	 */
	public String getCircleCode() {
		return circleCode;
	}

	/**
	 * Sets the circle code.
	 *
	 * @param circleCode the new circle code
	 */
	public void setCircleCode(String circleCode) {
		this.circleCode = circleCode;
	}

	/**
	 * Gets the payment type name.
	 *
	 * @return the payment type name
	 */
	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	/**
	 * Sets the payment type name.
	 *
	 * @param paymentTypeName the new payment type name
	 */
	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}

	/**
	 * Gets the party name.
	 *
	 * @return the party name
	 */
	public String getPartyName() {
		return partyName;
	}

	/**
	 * Sets the party name.
	 *
	 * @param partyName the new party name
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	/**
	 * Gets the deduction amt.
	 *
	 * @return the deduction amt
	 */
	public Double getDeductionAmt() {
		return deductionAmt;
	}

	/**
	 * Sets the deduction amt.
	 *
	 * @param deductionAmt the new deduction amt
	 */
	public void setDeductionAmt(Double deductionAmt) {
		this.deductionAmt = deductionAmt;
	}

	/**
	 * Gets the district id.
	 *
	 * @return the district id
	 */
	public Long getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	
	/**
	 * Gets the checks if is editable.
	 *
	 * @return the checks if is editable
	 */
	public Long getIsEditable() {
		return isEditable;
	}

	/**
	 * Sets the checks if is editable.
	 *
	 * @param isEditable the new checks if is editable
	 */
	public void setIsEditable(Long isEditable) {
		this.isEditable = isEditable;
	}


}
