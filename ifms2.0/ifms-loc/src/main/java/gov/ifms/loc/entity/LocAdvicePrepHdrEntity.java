package gov.ifms.loc.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.loc.util.LocConstant;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The Class LocAdvicePrepHdrEntity.
 *
 * @version v 1.0
 * @created 2021/02/23 12:11:35
 */
@Entity
@Table(name = "TLOC_LC_ADVICE_HDR", schema = LocConstant.LOC_SCHEMA)
public class LocAdvicePrepHdrEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TLOC_ADVICE_HDR_ID")
	private Long id;

	/**
	 * The advice no.
	 */
	@Column(name = "ADVICE_NO")
	private String adviceNo;

	/**
	 * The advice date.
	 */
	@Column(name = "ADVICE_DT")
	private Date adviceDate;

	/**
	 * The district id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DISTRICT_ID", nullable = false, referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity districtId;

	/**
	 * The div code.
	 */
	@Column(name = "DIVISION_CD")
	private String divCode;

	/**
	 * The div id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DIVISION_ID", nullable = false, referencedColumnName = "DIVISION_ID")
	private LocMsDivisonEntity divId;

	/**
	 * The sub treasury id.
	 */
	@Column(name = "TO_OR_SUB_TO_ID")
	private Long toOrSubToId;

	/**
	 * The drawing office id.
	 */
	@Column(name = "DRAWING_OFFICE_ID")
	private Long drawingOfficeId;

	/**
	 * The bank id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "BANK_ID", nullable = false, referencedColumnName = "BANK_ID")
	private LocMsBankEntity bankId;

	/**
	 * The lc valid from date.
	 */
	@Column(name = "LC_VALID_FROM_DT")
	private String lcValidFromDate;

	/**
	 * The status id.
	 */
	@Column(name = "STATUS_ID")
	private Long statusId;

	/**
	 * The wf id.
	 */
	@Column(name = "WF_ID")
	private Long wfId;

	/**
	 * The wf role id.
	 */
	@Column(name = "WF_ROLE_ID")
	private Long wfRoleId;

	/**
	 * The dept id.
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false, referencedColumnName = "DEPARTMENT_ID")
	private EDPMsDepartmentEntity deptId;

	/**
	 * The office id.
	 */
	@Column(name = "OFFICE_ID")
	private Long officeId;

	/**
	 * The ref no.
	 */
	@Column(name = "REFERENCE_NO")
	private String refNo;

	/**
	 * The ref date.
	 */
	@Column(name = "REFERENCE_DT")
	private Date refDate;

	/**
	 * The virtual token no.
	 */
	@Column(name = "VIRTUAL_TOKEN_NO")
	private Integer virtualTokenNo;

	/**
	 * The virtual token date.
	 */
	@Column(name = "VIRTUAL_TOKEN_DT")
	private Date virtualTokenDate;

	/**
	 * The net amt.
	 */
	@PositiveOrZero
	@Column(name = "NET_AMT")
	private Double netAmt;

	/**
	 * The gross amt.
	 */
	@PositiveOrZero
	@Column(name = "GROSS_AMT")
	private Double grossAmt;

	/**
	 * The gross amt.
	 */
	@Column(name = "CARDEX_NO")
	private Long cardexNo;

	/**
	 * The gross amt.
	 */
	@Column(name = "DDO_NO")
	private String ddoNo;

	/**
	 * The gross amt.
	 */
	@Column(name = "PAYMENT_TYPE")
	private Long paymentTypeId;

	/**
	 * The gross amt.
	 */
	@Column(name = "CHEQUE_LIST_TYPE")
	private Long chequeListType;

	/**
	 * The gross amt.
	 */
	@Column(name = "ADVICE_DETAILS")
	private Long adviceDetails;

	/**
	 * The Closing Balance.
	 */
	@PositiveOrZero
	@Column(name = "CLOSING_BALANCE")
	private Double closingBalance;

	/**
	 * The openingBalance.
	 */
	@PositiveOrZero
	@Column(name = "OPENING_BALANCE")
	private Double openingBalance;

	/**
	 * The New Balance Amount.
	 */
	@PositiveOrZero
	@Column(name = "NEW_LC_BALANCE")
	private Double newBalanceAmnt;

	/**
	 * The Deduction Amount.
	 */
	@PositiveOrZero
	@Column(name = "DEDUCTION_AMNT")
	private Double deductionAmount;

	/**
	 * The raise objection Flag.
	 */
	@Column(name = "RAISE_OBJECTION_FLAG")
	private Character raiseObjectionFlag;

	/**
	 * The Raise objection Remarks.
	 */
	@Column(name = "RAISE_OBJECTION_REMARKS")
	private String raiseObjectionRemarks;

	@Column(name = "ADVC_MONTH")
	private String advcmonth;

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
	public EDPMsDistrictEntity getDistrictId() {
		return districtId;
	}

	/**
	 * Sets the district id.
	 *
	 * @param districtId the new district id
	 */
	public void setDistrictId(EDPMsDistrictEntity districtId) {
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
	public LocMsDivisonEntity getDivId() {
		return divId;
	}

	/**
	 * Sets the div id.
	 *
	 * @param divId the new div id
	 */
	public void setDivId(LocMsDivisonEntity divId) {
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
	public LocMsBankEntity getBankId() {
		return bankId;
	}

	/**
	 * Sets the bank id.
	 *
	 * @param bankId the new bank id
	 */
	public void setBankId(LocMsBankEntity bankId) {
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
	public EDPMsDepartmentEntity getDeptId() {
		return deptId;
	}

	/**
	 * Sets the dept id.
	 *
	 * @param deptId the new dept id
	 */
	public void setDeptId(EDPMsDepartmentEntity deptId) {
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
	 * Instantiates a new loc advice prep hdr entity.
	 *
	 * @param id the id
	 */
	public LocAdvicePrepHdrEntity(Long id) {
		this.id = id;
	}

	/**
	 * Instantiates a new loc advice prep hdr entity.
	 */
	public LocAdvicePrepHdrEntity() {
		super();
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

	public Long getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Long paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
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

	/**
	 * @return the closing balance
	 */
	public Double getClosingBalance() {
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getAdvcmonth() {
		return advcmonth;
	}

	public void setAdvcmonth(String advcmonth) {
		this.advcmonth = advcmonth;
	}

	public Double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(Double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Double getNewBalanceAmnt() {
		return newBalanceAmnt;
	}

	public void setNewBalanceAmnt(Double newBalanceAmnt) {
		this.newBalanceAmnt = newBalanceAmnt;
	}

	public Double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(Double deductionAmount) {
		this.deductionAmount = deductionAmount;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocAdvicePrepHdrEntity))
			return false;
		LocAdvicePrepHdrEntity that = (LocAdvicePrepHdrEntity) o;
		return Objects.equals(getId(), that.getId()) && Objects.equals(getAdviceNo(), that.getAdviceNo())
				&& Objects.equals(getAdviceDate(), that.getAdviceDate())
				&& Objects.equals(getDistrictId(), that.getDistrictId())
				&& Objects.equals(getDivCode(), that.getDivCode()) && Objects.equals(getDivId(), that.getDivId())
				&& Objects.equals(getToOrSubToId(), that.getToOrSubToId())
				&& Objects.equals(getDrawingOfficeId(), that.getDrawingOfficeId())
				&& Objects.equals(getBankId(), that.getBankId())
				&& Objects.equals(getLcValidFromDate(), that.getLcValidFromDate())
				&& Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getWfId(), that.getWfId())
				&& Objects.equals(getWfRoleId(), that.getWfRoleId()) && Objects.equals(getDeptId(), that.getDeptId())
				&& Objects.equals(getOfficeId(), that.getOfficeId()) && Objects.equals(getRefNo(), that.getRefNo())
				&& Objects.equals(getRefDate(), that.getRefDate())
				&& Objects.equals(getVirtualTokenNo(), that.getVirtualTokenNo())
				&& Objects.equals(getVirtualTokenDate(), that.getVirtualTokenDate())
				&& Objects.equals(getNetAmt(), that.getNetAmt()) && Objects.equals(getGrossAmt(), that.getGrossAmt())
				&& Objects.equals(getCardexNo(), that.getCardexNo()) && Objects.equals(getDdoNo(), that.getDdoNo())
				&& Objects.equals(getPaymentTypeId(), that.getPaymentTypeId())
				&& Objects.equals(getChequeListType(), that.getChequeListType())
				&& Objects.equals(getAdviceDetails(), that.getAdviceDetails())
				&& Objects.equals(getClosingBalance(), that.getClosingBalance())
				&& Objects.equals(getAdvcmonth(), that.getAdvcmonth());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getAdviceNo(), getAdviceDate(), getDistrictId(), getDivCode(), getDivId(),
				getToOrSubToId(), getDrawingOfficeId(), getBankId(), getLcValidFromDate(), getStatusId(), getWfId(),
				getWfRoleId(), getDeptId(), getOfficeId(), getRefNo(), getRefDate(), getVirtualTokenNo(),
				getVirtualTokenDate(), getNetAmt(), getGrossAmt(), getCardexNo(), getDdoNo(), getPaymentTypeId(),
				getChequeListType(), getAdviceDetails(), getClosingBalance(), getAdvcmonth());
	}
}
