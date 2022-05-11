package gov.ifms.loc.dto;

import gov.ifms.edp.dto.BaseDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * The Class LocAdvicePrepHdrDto.
 *
 * @version v 1.0
 * @created 2021/02/23 12:11:35
 */
public class LocAdvicePrepHdrDto extends BaseDto implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@NotNull
	private Long id;

	/**
	 * The advice no.
	 */
	private String adviceNo;

	/**
	 * The advice date.
	 */
	private Date adviceDate;

	/**
	 * The district id.
	 */
	private Long districtId;

	/**
	 * The div code.
	 */
	private String divCode;

	/**
	 * The div id.
	 */
	private Long divId;

	/**
	 * The to or sub to id.
	 */
	private Long toOrSubToId;

	/**
	 * The drawing office id.
	 */
	private Long drawingOfficeId;

	/**
	 * The bank id.
	 */
	private Long bankId;

	/**
	 * The lc valid from date.
	 */
	private String lcValidFromDate;

	/**
	 * The status id.
	 */
	private Long statusId;

	/**
	 * The wf id.
	 */
	private Long wfId;

	/**
	 * The wf role id.
	 */
	private Long wfRoleId;

	/**
	 * The dept id.
	 */
	private Long deptId;

	/**
	 * The office id.
	 */
	private Long officeId;

	/**
	 * The ref no.
	 */
	private String refNo;

	/**
	 * The ref date.
	 */
	private Date refDate;

	/**
	 * The virtual token no.
	 */
	private Integer virtualTokenNo;

	/**
	 * The virtual token date.
	 */
	private Date virtualTokenDate;

	/**
	 * The net amt.
	 */
	private Double netAmt;

	/**
	 * The gross amt.
	 */
	private Double grossAmt;

	/**
	 * The wf user req Sd dto.
	 */
	private WfUserReqSDDto wfUserReqSdDto;

	/**
	 * The wf user cardex No dto.
	 */
	private Long cardexNo;

	/**
	 * The wf user ddo No dto.
	 */
	private String ddoNo;

	/**
	 * The wf user payment Type dto.
	 */

	private Long paymentTypeId;

	/**
	 * The wf user chequeList Type dto.
	 */
	private Long chequeListType;

	/**
	 * The wf user advice Details dto.
	 */
	private Long adviceDetails;

	/**
	 * The payment type.
	 */

	private String advcmonth;

	/**
	 * The raiseObjectionFlag.
	 */

	private Character raiseObjectionFlag;

	/**
	 * The raiseObjectionRemarks.
	 */

	private String raiseObjectionRemarks;

	/**
	 * LocAdvicePrepHdrDto Constructor.
	 */
	public LocAdvicePrepHdrDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the status id.
	 *
	 * @return the status id
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * Sets the status id.
	 *
	 * @param statusId the new status id
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * Gets the wf id.
	 *
	 * @return the wf id
	 */
	public Long getWfId() {
		return wfId;
	}

	/**
	 * Sets the wf id.
	 *
	 * @param wfId the new wf id
	 */
	public void setWfId(Long wfId) {
		this.wfId = wfId;
	}

	/**
	 * Gets the wf role id.
	 *
	 * @return the wf role id
	 */
	public Long getWfRoleId() {
		return wfRoleId;
	}

	/**
	 * Sets the wf role id.
	 *
	 * @param wfRoleId the new wf role id
	 */
	public void setWfRoleId(Long wfRoleId) {
		this.wfRoleId = wfRoleId;
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

	public WfUserReqSDDto getWfUserReqSdDto() {
		return wfUserReqSdDto;
	}

	public void setWfUserReqSdDto(WfUserReqSDDto wfUserReqSdDto) {
		this.wfUserReqSdDto = wfUserReqSdDto;
	}

	/**
	 * Gets the virtual token no.
	 *
	 * @return the virtual token no
	 */
	public Integer getVirtualTokenNo() {
		return virtualTokenNo;
	}

	/**
	 * Sets the virtual token no.
	 *
	 * @param virtualTokenNo the new virtual token no
	 */
	public void setVirtualTokenNo(Integer virtualTokenNo) {
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
	 * @return the cardexNo
	 */
	public Long getCardexNo() {
		return cardexNo;
	}

	/**
	 * @param cardexNo the cardexNo to set
	 */
	public void setCardexNo(Long cardexNo) {
		this.cardexNo = cardexNo;
	}

	/**
	 * @return the ddoNo
	 */
	public String getDdoNo() {
		return ddoNo;
	}

	/**
	 * @param ddoNo the ddoNo to set
	 */
	public void setDdoNo(String ddoNo) {
		this.ddoNo = ddoNo;
	}

	/**
	 * @return the chequeListType
	 */
	public Long getChequeListType() {
		return chequeListType;
	}

	/**
	 * @param chequeListType the chequeListType to set
	 */
	public void setChequeListType(Long chequeListType) {
		this.chequeListType = chequeListType;
	}

	/**
	 * @return the adviceDetails
	 */
	public Long getAdviceDetails() {
		return adviceDetails;
	}

	/**
	 * @param adviceDetails the adviceDetails to set
	 */
	public void setAdviceDetails(Long adviceDetails) {
		this.adviceDetails = adviceDetails;
	}

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getAdvcmonth() {
		return advcmonth;
	}

	public void setAdvcmonth(String advcmonth) {
		this.advcmonth = advcmonth;
	}

	/**
	 * @return the raiseObjectionFlag
	 */
	public Character getRaiseObjectionFlag() {
		return raiseObjectionFlag;
	}

	/**
	 * @param raiseObjectionFlag the raiseObjectionFlag to set
	 */
	public void setRaiseObjectionFlag(Character raiseObjectionFlag) {
		this.raiseObjectionFlag = raiseObjectionFlag;
	}

	/**
	 * @return the raiseObjectionRemarks
	 */
	public String getRaiseObjectionRemarks() {
		return raiseObjectionRemarks;
	}

	/**
	 * @param raiseObjectionRemarks the raiseObjectionRemarks to set
	 */
	public void setRaiseObjectionRemarks(String raiseObjectionRemarks) {
		this.raiseObjectionRemarks = raiseObjectionRemarks;
	}

}
