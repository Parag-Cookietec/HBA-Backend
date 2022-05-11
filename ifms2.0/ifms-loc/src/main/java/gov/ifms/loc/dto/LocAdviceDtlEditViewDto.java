package gov.ifms.loc.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocAdviceDtlEditViewDto.
 */
@NativeQueryResultEntity
public class LocAdviceDtlEditViewDto implements Serializable {

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
	 * The advice no.
	 */
	@NativeQueryResultColumn(index = 1)
	private String adviceNo;

	/**
	 * The advice date.
	 */
	@NativeQueryResultColumn(index = 2)
	private Date adviceDate;

	/**
	 * The div id.
	 */
	@NativeQueryResultColumn(index = 3)
	private Long divId;

	/**
	 * The div code.
	 */
	@NativeQueryResultColumn(index = 4)
	private String divCode;

	/**
	 * The div name.
	 */
	@NativeQueryResultColumn(index = 5)
	private String divName;

	/**
	 * The dept id.
	 */
	@NativeQueryResultColumn(index = 6)
	private Long deptId;

	/**
	 * The dept name.
	 */
	@NativeQueryResultColumn(index = 7)
	private String deptName;

	/**
	 * The district id.
	 */
	@NativeQueryResultColumn(index = 8)
	private Long districtId;

	/**
	 * The district name.
	 */
	@NativeQueryResultColumn(index = 9)
	private String districtName;

	/**
	 * The to or sub to id.
	 */
	@NativeQueryResultColumn(index = 10)
	private Long toOrSubToId;

	/**
	 * The to or sub to name.
	 */
	@NativeQueryResultColumn(index = 11)
	private String toOrSubToName;

	/**
	 * The office id.
	 */
	@NativeQueryResultColumn(index = 12)
	private Long officeId;

	/**
	 * The office name.
	 */
	@NativeQueryResultColumn(index = 13)
	private String officeName;

	/**
	 * The drawing office id.
	 */
	@NativeQueryResultColumn(index = 14)
	private Long drawingOfficeId;

	/**
	 * The drawing office name.
	 */
	@NativeQueryResultColumn(index = 15)
	private String drawingOfficeName;

	/**
	 * The bank id.
	 */
	@NativeQueryResultColumn(index = 16)
	private Long bankId;

	/**
	 * The bank name.
	 */
	@NativeQueryResultColumn(index = 17)
	private String bankName;

	/**
	 * The lc valid from date.
	 */
	@NativeQueryResultColumn(index = 18)
	private String lcValidFromDate;

	/**
	 * The advice month.
	 */
	@NativeQueryResultColumn(index = 19)
	private String adviceMonth;

	/**
	 * The payment type id.
	 */
	@NativeQueryResultColumn(index = 20)
	private String paymentTypeId;

	/**
	 * The payment type name.
	 */
	@NativeQueryResultColumn(index = 21)
	private String paymentTypeName;

	/**
	 * The ref no.
	 */
	@NativeQueryResultColumn(index = 22)
	private String refNo;

	/**
	 * The ref date.
	 */
	@NativeQueryResultColumn(index = 23)
	private Date refDate;

	/**
	 * The cardex no.
	 */
	@NativeQueryResultColumn(index = 24)
	private Long cardexNo;

	/**
	 * The ddo no.
	 */
	@NativeQueryResultColumn(index = 25)
	private String ddoNo;

	/** The net amt. */
	@NativeQueryResultColumn(index = 26)
	private Double netAmt;

	/** The gross amt. */
	@NativeQueryResultColumn(index = 27)
	private Double grossAmt;

	/** The ded amt. */
	@NativeQueryResultColumn(index = 28)
	private Double dedAmt;

	/** The closing blnc. */
	@NativeQueryResultColumn(index = 29)
	private Double closingBlnc;

	/** The new lc blnc. */
	@NativeQueryResultColumn(index = 30)
	private Double newLcBlnc;

	/** The open blnc. */
	@NativeQueryResultColumn(index = 31)
	private Double openBlnc;

	/** The raise objection flag. */
	@NativeQueryResultColumn(index = 32)
	private Character raiseObjectionFlag;

	/** The raise objection Remarks. */
	@NativeQueryResultColumn(index = 33)
	private String raiseObjectionRemarks;
	
	
	/** The district code. */
	@NativeQueryResultColumn(index = 34)
	private Long districtCode;
	

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
	 * Gets the div id.
	 *
	 * @return the div id
	 */
	public Long getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(Long divId) {
		this.divId = divId;
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
	 * Gets the dept id.
	 *
	 * @return the dept id
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the new dept id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the dept name
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName the new dept name
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	 * Gets the district name.
	 *
	 * @return the district name
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * Sets the district name.
	 *
	 * @param districtName the new district name
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	/**
	 * Gets the office id.
	 *
	 * @return the office id
	 */
	public Long getOfficeId() {
		return officeId;
	}

	/**
	 * Sets the office id.
	 *
	 * @param officeId the new office id
	 */
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * Gets the office name.
	 *
	 * @return the office name
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * Sets the office name.
	 *
	 * @param officeName the new office name
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * Gets the drawing office id.
	 *
	 * @return the drawing office id
	 */
	public Long getDrawingOfficeId() {
		return drawingOfficeId;
	}

	/**
	 * Sets the drawing office id.
	 *
	 * @param drawingOfficeId the new drawing office id
	 */
	public void setDrawingOfficeId(Long drawingOfficeId) {
		this.drawingOfficeId = drawingOfficeId;
	}

	/**
	 * Gets the drawing office name.
	 *
	 * @return the drawing office name
	 */
	public String getDrawingOfficeName() {
		return drawingOfficeName;
	}

	/**
	 * Sets the drawing office name.
	 *
	 * @param drawingOfficeName the new drawing office name
	 */
	public void setDrawingOfficeName(String drawingOfficeName) {
		this.drawingOfficeName = drawingOfficeName;
	}

	/**
	 * Gets the bank id.
	 *
	 * @return the bank id
	 */
	public Long getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the new bank id
	 */
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	/**
	 * Gets the bank name.
	 *
	 * @return the bank name
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * Sets the bank name.
	 *
	 * @param bankName the new bank name
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * Gets the lc valid from date.
	 *
	 * @return the lc valid from date
	 */
	public String getLcValidFromDate() {
		return lcValidFromDate;
	}

	/**
	 * Sets the lc valid from date.
	 *
	 * @param lcValidFromDate the new lc valid from date
	 */
	public void setLcValidFromDate(String lcValidFromDate) {
		this.lcValidFromDate = lcValidFromDate;
	}

	/**
	 * Gets the advice month.
	 *
	 * @return the advice month
	 */
	public String getAdviceMonth() {
		return adviceMonth;
	}

	/**
	 * Sets the advice month.
	 *
	 * @param adviceMonth the new advice month
	 */
	public void setAdviceMonth(String adviceMonth) {
		this.adviceMonth = adviceMonth;
	}

	/**
	 * Gets the payment type id.
	 *
	 * @return the payment type id
	 */
	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	/**
	 * Sets the payment type id.
	 *
	 * @param paymentTypeId the new payment type id
	 */
	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
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
	 * Gets the to or sub to id.
	 *
	 * @return the to or sub to id
	 */
	public Long getToOrSubToId() {
		return toOrSubToId;
	}

	/**
	 * Sets the to or sub to id.
	 *
	 * @param toOrSubToId the new to or sub to id
	 */
	public void setToOrSubToId(Long toOrSubToId) {
		this.toOrSubToId = toOrSubToId;
	}

	/**
	 * Gets the to or sub to name.
	 *
	 * @return the to or sub to name
	 */
	public String getToOrSubToName() {
		return toOrSubToName;
	}

	/**
	 * Sets the to or sub to name.
	 *
	 * @param toOrSubToName the new to or sub to name
	 */
	public void setToOrSubToName(String toOrSubToName) {
		this.toOrSubToName = toOrSubToName;
	}

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
	 * Gets the ref date.
	 *
	 * @return the ref date
	 */
	public Date getRefDate() {
		return refDate;
	}

	/**
	 * Sets the ref date.
	 *
	 * @param refDate the new ref date
	 */
	public void setRefDate(Date refDate) {
		this.refDate = refDate;
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
	 * Gets the ded amt.
	 *
	 * @return the ded amt
	 */
	public Double getDedAmt() {
		return dedAmt;
	}

	/**
	 * Sets the ded amt.
	 *
	 * @param dedAmt the new ded amt
	 */
	public void setDedAmt(Double dedAmt) {
		this.dedAmt = dedAmt;
	}

	/**
	 * Gets the closing blnc.
	 *
	 * @return the closing blnc
	 */
	public Double getClosingBlnc() {
		return closingBlnc;
	}

	/**
	 * Sets the closing blnc.
	 *
	 * @param closingBlnc the new closing blnc
	 */
	public void setClosingBlnc(Double closingBlnc) {
		this.closingBlnc = closingBlnc;
	}

	/**
	 * Gets the new lc blnc.
	 *
	 * @return the new lc blnc
	 */
	public Double getNewLcBlnc() {
		return newLcBlnc;
	}

	/**
	 * Sets the new lc blnc.
	 *
	 * @param newLcBlnc the new new lc blnc
	 */
	public void setNewLcBlnc(Double newLcBlnc) {
		this.newLcBlnc = newLcBlnc;
	}

	/**
	 * Gets the open blnc.
	 *
	 * @return the open blnc
	 */
	public Double getOpenBlnc() {
		return openBlnc;
	}

	/**
	 * Sets the open blnc.
	 *
	 * @param openBlnc the new open blnc
	 */
	public void setOpenBlnc(Double openBlnc) {
		this.openBlnc = openBlnc;
	}

	/**
	 * Gets the raise objection flag.
	 *
	 * @return the raiseObjectionFlag
	 */
	public Character getRaiseObjectionFlag() {
		return raiseObjectionFlag;
	}

	/**
	 * Sets the raise objection flag.
	 *
	 * @param raiseObjectionFlag the raiseObjectionFlag to set
	 */
	public void setRaiseObjectionFlag(Character raiseObjectionFlag) {
		this.raiseObjectionFlag = raiseObjectionFlag;
	}

	/**
	 * Gets the raise objection remarks.
	 *
	 * @return the raiseObjectionRemarks
	 */
	public String getRaiseObjectionRemarks() {
		return raiseObjectionRemarks;
	}

	/**
	 * Sets the raise objection remarks.
	 *
	 * @param raiseObjectionRemarks the raiseObjectionRemarks to set
	 */
	public void setRaiseObjectionRemarks(String raiseObjectionRemarks) {
		this.raiseObjectionRemarks = raiseObjectionRemarks;
	}

	/**
	 * Gets the district code.
	 *
	 * @return the district code
	 */
	public Long getDistrictCode() {
		return districtCode;
	}

	/**
	 * Sets the district code.
	 *
	 * @param districtCode the new district code
	 */
	public void setDistrictCode(Long districtCode) {
		this.districtCode = districtCode;
	}

}
