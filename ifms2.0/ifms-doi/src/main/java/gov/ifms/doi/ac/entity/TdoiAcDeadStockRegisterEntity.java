package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TDOI_AC_DEAD_STOCK_REGISTER database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_DEAD_STOCK_REGISTER", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcDeadStockRegisterEntity.findAll", query = "SELECT t FROM TdoiAcDeadStockRegisterEntity t")
public class TdoiAcDeadStockRegisterEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEAD_STK_REG_ID", unique = true, nullable = false)
	private long deadStkRegId;

	@Temporal(TemporalType.DATE)
	@Column(name = "DEPOSIT_AMOUNT_DT")
	private Date depositAmountDt;

	@Column(name = "DISP_RECEIVR_NAME", length = 60)
	private String dispReceivrName;

	@Column(name = "DISP_RECV_AMT")
	private double dispRecvAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "DISP_RECV_DT")
	private Date dispRecvDt;

	@Column(name = "DISPOSAL_STATUS", length = 40)
	private String disposalStatus;

	@Column(name = "DISPOSAL_TYPE", length = 30)
	private String disposalType;

	@Column(name = "DISPOSAL_TYPE_ID")
	private long disposalTypeId;

	@Column(name = "EQUIP_TYPE_ID")
	private long equipTypeId;

	@Column(name = "EQUIPMENT_NAME", length = 30)
	private String equipmentName;

	@Column(name = "FINAL_DISP_QTY")
	private int finalDispQty;

	@Column(name = "GOVT_DEPOSIT_AMT")
	private double govtDepositAmt;

	@Temporal(TemporalType.DATE)
	@Column(name = "ORDER_VOUCHER_DT")
	private Date orderVoucherDt;

	@Column(name = "ORDER_VOUCHER_NO", length = 30)
	private String orderVoucherNo;

	@Column(name = "PURCH_RECEIVR_NAME", length = 60)
	private String purchReceivrName;

	@Column(name = "PURCHASE_AMOUNT")
	private double purchaseAmount;

	@Column(name = "PURCHASE_ORDER_NO", length = 30)
	private String purchaseOrderNo;

	private int quantity;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "REMAINING_EQUIP_AMT")
	private double remainingEquipAmt;

	@Column(name = "REMAINING_QTY")
	private int remainingQty;

	@Column(length = 100)
	private String remarks;

	@Column(name = "SERIAL_NO", length = 30)
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
