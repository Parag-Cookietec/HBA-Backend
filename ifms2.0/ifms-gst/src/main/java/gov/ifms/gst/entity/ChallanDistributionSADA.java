package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TPAO_CHALLAN_DISTRIBUTE_SA_DA", schema = GSTConstant.GST_SCHEMA)
public class ChallanDistributionSADA extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Object TRN_SCREEN_RASB = "CDSA";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHALLAN_DISTRIB_ID")
	private long id;

	@Column(name = "FILE_PROCESS_ID")
	private long fileProcessId;

	@Column(name = "DISTRIBUTE_DT")
	private LocalDateTime distributeDt;

	@Column(name = "BANK_CD")
	private String bankCd;

	@Column(name = "BANK_NAME")
	private String bankName;

	@Column(name = "TOTAL_CHALLANS")
	private Short totalChallans;

	@Column(name = "AVAILABLE_CHALLANS")
	private Short availableChallans;

	@Column(name = "TO_BE_DITRIBUTED")
	private Short toBeDitributed;

	@Column(name = "DISTRIBUTE_STATUS")
	private String distributeStatus;

	@Column(name = "TOTAL_DITRIBUTED")
	private Short totalDitributed;

	@Column(name = "SA_DA_NAME")
	private String saDaName;

	@Column(name = "TOT_CHALLAN_AMT")
	private Double totChallanAmt;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	@Column(name = "SA_DA_ID")
	private Long saDaId;
	@Column(name = "BANK_ID")
	private Long bankId;

	public ChallanDistributionSADA(Long id) {
		super();
		this.id = id;
	}

	public ChallanDistributionSADA() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFileProcessId() {
		return fileProcessId;
	}

	public void setFileProcessId(long fileProcessId) {
		this.fileProcessId = fileProcessId;
	}

	public LocalDateTime getDistributeDt() {
		return distributeDt;
	}

	public void setDistributeDt(LocalDateTime distributeDt) {
		this.distributeDt = distributeDt;
	}

	public String getBankCd() {
		return bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Short getTotalChallans() {
		return totalChallans;
	}

	public void setTotalChallans(Short totalChallans) {
		this.totalChallans = totalChallans;
	}

	public Short getAvailableChallans() {
		return availableChallans;
	}

	public void setAvailableChallans(Short availableChallans) {
		this.availableChallans = availableChallans;
	}

	public Short getToBeDitributed() {
		return toBeDitributed;
	}

	public void setToBeDitributed(Short toBeDitributed) {
		this.toBeDitributed = toBeDitributed;
	}

	public String getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}

	public Short getTotalDitributed() {
		return totalDitributed;
	}

	public void setTotalDitributed(Short totalDitributed) {
		this.totalDitributed = totalDitributed;
	}

	public String getSaDaName() {
		return saDaName;
	}

	public void setSaDaName(String saDaName) {
		this.saDaName = saDaName;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
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

	public Long getSaDaId() {
		return saDaId;
	}

	public void setSaDaId(Long saDaId) {
		this.saDaId = saDaId;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public static Object getTrnScreenRasb() {
		return TRN_SCREEN_RASB;
	}

}
