package gov.ifms.gst.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

@Entity
@Table(name = "TPAO_LOAD_BALANCER_AO", schema = GSTConstant.GST_SCHEMA)
public class LoadBalancerAO extends BaseEntity implements Serializable {

	public static final Object TRN_SCREEN_LBAO = "LBAO";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AO_LB_ID")
	private long id;

	@Column(name = "TRANSFER_DT")
	private Date transferDt;

	@Column(name = "BANK_ID")
	private long bankId;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "FROM_SA_DA_ID")
	private long fromSaDaId;

	@Column(name = "FROM_SA_DA_NAME")
	private String fromSaDaName;

	@Column(name = "TOTAL_CHALLANS")
	private int totalChallans;

	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;

	@Column(name = "TO_BANK_ID")
	private long toBankId;

	@Column(name = "TO_BANK_NAME")
	private String toBankName;

	@Column(name = "TO_BRANCH_ID")
	private long toBranchId;

	@Column(name = "TO_BRANCH_NAME")
	private String toBranchName;

	@Column(name = "TO_SA_DA_ID")
	private long toSaDaId;

	@Column(name = "TO_SA_DA_NAME")
	private String toSaDaName;

	@Column(name = "TOTAL_CHALLANS_TRNF")
	private int totalChallansTrnf;

	@Column(name = "TOTAL_AMOUNT_TRNF")
	private Double totalAmountTrnf;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	public LoadBalancerAO(Long id) {
		super();
		this.id = id;
	}

	public LoadBalancerAO() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTransferDt() {
		return transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getFromSaDaId() {
		return fromSaDaId;
	}

	public void setFromSaDaId(long fromSaDaId) {
		this.fromSaDaId = fromSaDaId;
	}

	public String getFromSaDaName() {
		return fromSaDaName;
	}

	public void setFromSaDaName(String fromSaDaName) {
		this.fromSaDaName = fromSaDaName;
	}

	public int getTotalChallans() {
		return totalChallans;
	}

	public void setTotalChallans(int totalChallans) {
		this.totalChallans = totalChallans;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getToBankId() {
		return toBankId;
	}

	public void setToBankId(long toBankId) {
		this.toBankId = toBankId;
	}

	public String getToBankName() {
		return toBankName;
	}

	public void setToBankName(String toBankName) {
		this.toBankName = toBankName;
	}

	public long getToBranchId() {
		return toBranchId;
	}

	public void setToBranchId(long toBranchId) {
		this.toBranchId = toBranchId;
	}

	public String getToBranchName() {
		return toBranchName;
	}

	public void setToBranchName(String toBranchName) {
		this.toBranchName = toBranchName;
	}

	public long getToSaDaId() {
		return toSaDaId;
	}

	public void setToSaDaId(long toSaDaId) {
		this.toSaDaId = toSaDaId;
	}

	public String getToSaDaName() {
		return toSaDaName;
	}

	public void setToSaDaName(String toSaDaName) {
		this.toSaDaName = toSaDaName;
	}

	public int getTotalChallansTrnf() {
		return totalChallansTrnf;
	}

	public void setTotalChallansTrnf(int totalChallansTrnf) {
		this.totalChallansTrnf = totalChallansTrnf;
	}

	public Double getTotalAmountTrnf() {
		return totalAmountTrnf;
	}

	public void setTotalAmountTrnf(Double totalAmountTrnf) {
		this.totalAmountTrnf = totalAmountTrnf;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public LocalDateTime getReferenceDt() {
		return referenceDt;
	}

	public void setReferenceDt(LocalDateTime referenceDt) {
		this.referenceDt = referenceDt;
	}

	public static Object getTrnScreenLbao() {
		return TRN_SCREEN_LBAO;
	}

}
