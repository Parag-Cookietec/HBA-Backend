package gov.ifms.gst.entity;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.gst.util.GSTConstant;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TPAO_SCROLL_DISTRIBUTE", schema = GSTConstant.GST_SCHEMA)
public class ScrollDistribute extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Object TRN_SCREEN_LBAO = "SD";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SCROLL_DISTRIB_ID")
	private long id;

	@Column(name = "FILE_PROCESS_ID")
	private long fileProcessId;

	@Column(name = "SCROLL_NO")
	private String scrollNo;

	@Column(name = "SCROLL_DT")
	private LocalDateTime scrollDt;

	@Column(name = "NO_OF_CHALLANS")
	private short noOfChallans;

	@Column(name = "CHALLAN_DT")
	private Date challanDt;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "TOT_CHALLAN_AMT")
	private Double totChallanAmt;

	@Column(name = "DISTRIBUTE_STATUS")
	private String distributeStatus;

	@Column(name = "DISTRIBUTION_DT")
	private LocalDateTime distributionDt;

	@Column(name = "DISTRIBUTED_TO")
	private long distributedTo;

	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;
	
	@Column(name = "BRANCH_ID")
	private Long branchId;

	public ScrollDistribute(Long id) {
		super();
		this.id = id;
	}

	public ScrollDistribute() {
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

	public String getScrollNo() {
		return scrollNo;
	}

	public void setScrollNo(String scrollNo) {
		this.scrollNo = scrollNo;
	}

	public LocalDateTime getScrollDt() {
		return scrollDt;
	}

	public void setScrollDt(LocalDateTime scrollDt) {
		this.scrollDt = scrollDt;
	}

	public short getNoOfChallans() {
		return noOfChallans;
	}

	public void setNoOfChallans(short noOfChallans) {
		this.noOfChallans = noOfChallans;
	}

	public Date getChallanDt() {
		return challanDt;
	}

	public void setChallanDt(Date challanDt) {
		this.challanDt = challanDt;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Double getTotChallanAmt() {
		return totChallanAmt;
	}

	public void setTotChallanAmt(Double totChallanAmt) {
		this.totChallanAmt = totChallanAmt;
	}

	public String getDistributeStatus() {
		return distributeStatus;
	}

	public void setDistributeStatus(String distributeStatus) {
		this.distributeStatus = distributeStatus;
	}

	public LocalDateTime getDistributionDt() {
		return distributionDt;
	}

	public void setDistributionDt(LocalDateTime distributionDt) {
		this.distributionDt = distributionDt;
	}

	public long getDistributedTo() {
		return distributedTo;
	}

	public void setDistributedTo(long distributedTo) {
		this.distributedTo = distributedTo;
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

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

}
