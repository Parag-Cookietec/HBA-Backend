package gov.ifms.doi.ac.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * The persistent class for the TDOI_AC_DEAD_STOCK_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.dto.BaseDto;

public class TdoiAcDeadStockRegisterDTO extends BaseDto {
	private static final long serialVersionUID = 1L;

	private long deadStkRegId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date depositAmountDt;

	private String dispReceivrName;

	private double dispRecvAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date dispRecvDt;

	private String disposalStatus;

	private String disposalType;

	private long disposalTypeId;

	private long equipTypeId;

	private String equipmentName;

	private int finalDispQty;

	private double govtDepositAmt;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date orderVoucherDt;

	private String orderVoucherNo;

	private String purchReceivrName;

	private double purchaseAmount;

	private String purchaseOrderNo;

	private int quantity;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DoiJPAConstants.DOI_DATE_TIME_FORMAT)
	private Date referenceDt;

	private String referenceNo;

	private double remainingEquipAmt;

	private int remainingQty;

	private String remarks;

	private String serialNo;

	public long getDeadStkRegId() {
		return this.deadStkRegId;
	}

	public void setDeadStkRegId(long deadStkRegId) {
		this.deadStkRegId = deadStkRegId;
	}

	public Date getDepositAmountDt() {
		return this.depositAmountDt;
	}

	public void setDepositAmountDt(Date depositAmountDt) {
		this.depositAmountDt = depositAmountDt;
	}

	public String getDispReceivrName() {
		return this.dispReceivrName;
	}

	public void setDispReceivrName(String dispReceivrName) {
		this.dispReceivrName = dispReceivrName;
	}

	public double getDispRecvAmt() {
		return this.dispRecvAmt;
	}

	public void setDispRecvAmt(double dispRecvAmt) {
		this.dispRecvAmt = dispRecvAmt;
	}

	public Date getDispRecvDt() {
		return this.dispRecvDt;
	}

	public void setDispRecvDt(Date dispRecvDt) {
		this.dispRecvDt = dispRecvDt;
	}

	public String getDisposalStatus() {
		return this.disposalStatus;
	}

	public void setDisposalStatus(String disposalStatus) {
		this.disposalStatus = disposalStatus;
	}

	public String getDisposalType() {
		return this.disposalType;
	}

	public void setDisposalType(String disposalType) {
		this.disposalType = disposalType;
	}

	public long getDisposalTypeId() {
		return this.disposalTypeId;
	}

	public void setDisposalTypeId(long disposalTypeId) {
		this.disposalTypeId = disposalTypeId;
	}

	public long getEquipTypeId() {
		return this.equipTypeId;
	}

	public void setEquipTypeId(long equipTypeId) {
		this.equipTypeId = equipTypeId;
	}

	public String getEquipmentName() {
		return this.equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getFinalDispQty() {
		return this.finalDispQty;
	}

	public void setFinalDispQty(int finalDispQty) {
		this.finalDispQty = finalDispQty;
	}

	public double getGovtDepositAmt() {
		return this.govtDepositAmt;
	}

	public void setGovtDepositAmt(double govtDepositAmt) {
		this.govtDepositAmt = govtDepositAmt;
	}

	public Date getOrderVoucherDt() {
		return this.orderVoucherDt;
	}

	public void setOrderVoucherDt(Date orderVoucherDt) {
		this.orderVoucherDt = orderVoucherDt;
	}

	public String getOrderVoucherNo() {
		return this.orderVoucherNo;
	}

	public void setOrderVoucherNo(String orderVoucherNo) {
		this.orderVoucherNo = orderVoucherNo;
	}

	public String getPurchReceivrName() {
		return this.purchReceivrName;
	}

	public void setPurchReceivrName(String purchReceivrName) {
		this.purchReceivrName = purchReceivrName;
	}

	public double getPurchaseAmount() {
		return this.purchaseAmount;
	}

	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPurchaseOrderNo() {
		return this.purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getReferenceDt() {
		return this.referenceDt;
	}

	public void setReferenceDt(Date referenceDt) {
		this.referenceDt = referenceDt;
	}

	public String getReferenceNo() {
		return this.referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public double getRemainingEquipAmt() {
		return this.remainingEquipAmt;
	}

	public void setRemainingEquipAmt(double remainingEquipAmt) {
		this.remainingEquipAmt = remainingEquipAmt;
	}

	public int getRemainingQty() {
		return this.remainingQty;
	}

	public void setRemainingQty(int remainingQty) {
		this.remainingQty = remainingQty;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

}
