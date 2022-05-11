package gov.ifms.pvu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Date;

import javax.persistence.*;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.*;
import gov.ifms.workflow.entity.MsWorkflowActionEntity;

/**
 * The Class PVUTransferEntity.
 *
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */
@Entity
@Table(name = "T_PVU_TRN_EVNT", schema = Constant.PVU_SCHEMA)
public class PVUTransferEntity extends BaseEntity implements Serializable {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "T_PVU_TRN_EVNT_ID")
	private long id;

	@Column(name = "TRN_NO")
	private String trnNo;

	/**
	 * The office id.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity office;

	/**
	 * The transfer order no.
	 */
	@Column(name = "TR_ORDER_NO")
	private String transferOrderNo;

	/**
	 * The transfer order date.
	 */
	@Column(name = "TR_ORDER_DATE")
	private LocalDate transferOrderDate;

	@ManyToOne
	@JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
	private PVUEmployeEntity pvuEmployeEntity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity district;

	/**
	 * The cardex no.
	 */
	@Column(name = "CARDEX_NO")
	private String cardexNo;

	/**
	 * The ddo code.
	 */
	@Column(name = "DDO_CODE")
	private String ddoCode;

	@ManyToOne
	@JoinColumn(name = "TR_SUB_OFFICE_ID", referencedColumnName = "S_OFFICE_ID")
	private EDPMsSubOfficeEntity subOfficeId;

	@Column(name = "RELIEVING_DATE")
	private Date relievingDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TR_NOON_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity transferNoonType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REASON_FOR_TR", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity reasonForTransfer;

	@Column(name = "TR_REMARKS")
	private String transferRemarks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JN_NOON_TYPE", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity joiningNoonType;

	@Column(name = "JN_REMARKS")
	private String joiningRemarks;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "STATUS_ID", referencedColumnName = "LOOKUP_INFO_ID")
	private EDPLuLookUpInfoEntity status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JN_SUB_OFFICE_ID", referencedColumnName = "S_OFFICE_ID")
	private EDPMsSubOfficeEntity joiningSubOfficeId;

	@Column(name = "ACT_DATE_OF_JN")
	private Date actualJoiningDate;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "WF_ACTION", referencedColumnName = "WF_ACTION_ID")
	private MsWorkflowActionEntity workflowActionId;

	@Column(name = "WF_STATUS")
	private long workflowStatusId;

	/**
	 * The office id.
	 */
	@ManyToOne
	@JoinColumn(name = "C_OFFICE_ID", referencedColumnName = "OFFICE_ID")
	private EDPMsOfficeEntity curOffice;

	@ManyToOne
	@JoinColumn(name = "C_DISTRICT_ID", referencedColumnName = "DISTRICT_ID")
	private EDPMsDistrictEntity curDistrict;

	/**
	 * The cardex no.
	 */
	@Column(name = "C_CARDEX_NO")
	private String curCardexNo;

	/**
	 * The ddo code.
	 */
	@Column(name = "C_DDO_CODE")
	private String curDDONo;

	@Column(name = "REF_DATE")
	private LocalDateTime refDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrnNo() {
		return trnNo;
	}

	public void setTrnNo(String trnNo) {
		this.trnNo = trnNo;
	}

	public EDPMsOfficeEntity getOffice() {
		return office;
	}

	public void setOffice(EDPMsOfficeEntity office) {
		this.office = office;
	}

	public String getTransferOrderNo() {
		return transferOrderNo;
	}

	public void setTransferOrderNo(String transferOrderNo) {
		this.transferOrderNo = transferOrderNo;
	}

	public LocalDate getTransferOrderDate() {
		return transferOrderDate;
	}

	public void setTransferOrderDate(LocalDate transferOrderDate) {
		this.transferOrderDate = transferOrderDate;
	}

	public PVUEmployeEntity getPvuEmployeEntity() {
		return pvuEmployeEntity;
	}

	public void setPvuEmployeEntity(PVUEmployeEntity pvuEmployeEntity) {
		this.pvuEmployeEntity = pvuEmployeEntity;
	}

	public EDPMsDistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(EDPMsDistrictEntity district) {
		this.district = district;
	}

	public String getCardexNo() {
		return cardexNo;
	}

	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	public String getDdoCode() {
		return ddoCode;
	}

	public void setDdoCode(String ddoCode) {
		this.ddoCode = ddoCode;
	}

	public EDPMsSubOfficeEntity getSubOfficeId() {
		return subOfficeId;
	}

	public void setSubOfficeId(EDPMsSubOfficeEntity subOfficeId) {
		this.subOfficeId = subOfficeId;
	}

	public Date getRelievingDate() {
		return relievingDate;
	}

	public void setRelievingDate(Date relievingDate) {
		this.relievingDate = relievingDate;
	}

	public EDPLuLookUpInfoEntity getTransferNoonType() {
		return transferNoonType;
	}

	public void setTransferNoonType(EDPLuLookUpInfoEntity transferNoonType) {
		this.transferNoonType = transferNoonType;
	}

	public EDPLuLookUpInfoEntity getReasonForTransfer() {
		return reasonForTransfer;
	}

	public void setReasonForTransfer(EDPLuLookUpInfoEntity reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}

	public String getTransferRemarks() {
		return transferRemarks;
	}

	public void setTransferRemarks(String transferRemarks) {
		this.transferRemarks = transferRemarks;
	}

	public EDPLuLookUpInfoEntity getJoiningNoonType() {
		return joiningNoonType;
	}

	public void setJoiningNoonType(EDPLuLookUpInfoEntity joiningNoonType) {
		this.joiningNoonType = joiningNoonType;
	}

	public String getJoiningRemarks() {
		return joiningRemarks;
	}

	public void setJoiningRemarks(String joiningRemarks) {
		this.joiningRemarks = joiningRemarks;
	}

	public EDPLuLookUpInfoEntity getStatus() {
		return status;
	}

	public void setStatus(EDPLuLookUpInfoEntity status) {
		this.status = status;
	}

	public EDPMsSubOfficeEntity getJoiningSubOfficeId() {
		return joiningSubOfficeId;
	}

	public void setJoiningSubOfficeId(EDPMsSubOfficeEntity joiningSubOfficeId) {
		this.joiningSubOfficeId = joiningSubOfficeId;
	}

	public Date getActualJoiningDate() {
		return actualJoiningDate;
	}

	public void setActualJoiningDate(Date actualJoiningDate) {
		this.actualJoiningDate = actualJoiningDate;
	}

	public MsWorkflowActionEntity getWorkflowActionId() {
		return workflowActionId;
	}

	public void setWorkflowActionId(MsWorkflowActionEntity workflowActionId) {
		this.workflowActionId = workflowActionId;
	}

	public long getWorkflowStatusId() {
		return workflowStatusId;
	}

	public void setWorkflowStatusId(long workflowStatusId) {
		this.workflowStatusId = workflowStatusId;
	}


	public EDPMsOfficeEntity getCurOffice() {
		return curOffice;
	}

	public void setCurOffice(EDPMsOfficeEntity curOffice) {
		this.curOffice = curOffice;
	}

	public EDPMsDistrictEntity getCurDistrict() {
		return curDistrict;
	}

	public void setCurDistrict(EDPMsDistrictEntity curDistrict) {
		this.curDistrict = curDistrict;
	}

	public String getCurCardexNo() {
		return curCardexNo;
	}

	public void setCurCardexNo(String curCardexNo) {
		this.curCardexNo = curCardexNo;
	}

	public String getCurDDONo() {
		return curDDONo;
	}

	public void setCurDDONo(String curDDONo) {
		this.curDDONo = curDDONo;
	}

		public LocalDateTime getRefDate() {
		return refDate;
	}

	public void setRefDate(LocalDateTime refDate) {
		this.refDate = refDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PVUTransferEntity)) return false;
		PVUTransferEntity that = (PVUTransferEntity) o;
		return getId() == that.getId() &&
				getWorkflowStatusId() == that.getWorkflowStatusId() &&
				Objects.equals(getTrnNo(), that.getTrnNo()) &&
				Objects.equals(getOffice(), that.getOffice()) &&
				Objects.equals(getTransferOrderNo(), that.getTransferOrderNo()) &&
				Objects.equals(getTransferOrderDate(), that.getTransferOrderDate()) &&
				Objects.equals(getPvuEmployeEntity(), that.getPvuEmployeEntity()) &&
				Objects.equals(getDistrict(), that.getDistrict()) &&
				Objects.equals(getCardexNo(), that.getCardexNo()) &&
				Objects.equals(getDdoCode(), that.getDdoCode()) &&
				Objects.equals(getSubOfficeId(), that.getSubOfficeId()) &&
				Objects.equals(getRelievingDate(), that.getRelievingDate()) &&
				Objects.equals(getTransferNoonType(), that.getTransferNoonType()) &&
				Objects.equals(getReasonForTransfer(), that.getReasonForTransfer()) &&
				Objects.equals(getTransferRemarks(), that.getTransferRemarks()) &&
				Objects.equals(getJoiningNoonType(), that.getJoiningNoonType()) &&
				Objects.equals(getJoiningRemarks(), that.getJoiningRemarks()) &&
				Objects.equals(getStatus(), that.getStatus()) &&
				Objects.equals(getJoiningSubOfficeId(), that.getJoiningSubOfficeId()) &&
				Objects.equals(getActualJoiningDate(), that.getActualJoiningDate()) &&
				Objects.equals(getWorkflowActionId(), that.getWorkflowActionId()) &&
				Objects.equals(getCurOffice(), that.getCurOffice()) &&
				Objects.equals(getCurDistrict(), that.getCurDistrict()) &&
				Objects.equals(getCurCardexNo(), that.getCurCardexNo()) &&
				Objects.equals(getCurDDONo(), that.getCurDDONo()) &&
				Objects.equals(getRefDate(), that.getRefDate());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTrnNo(), getOffice(), getTransferOrderNo(), getTransferOrderDate(), getPvuEmployeEntity(), getDistrict(), getCardexNo(), getDdoCode(), getSubOfficeId(), getRelievingDate(), getTransferNoonType(), getReasonForTransfer(), getTransferRemarks(), getJoiningNoonType(), getJoiningRemarks(), getStatus(), getJoiningSubOfficeId(), getActualJoiningDate(), getWorkflowActionId(), getWorkflowStatusId(), getCurOffice(), getCurDistrict(), getCurCardexNo(), getCurDDONo(), getRefDate());
	}

	@Override
	public String toString() {
		return "PVUTransferEntity{" +
				"id=" + id +
				", trnNo='" + trnNo + '\'' +
				", office=" + office +
				", transferOrderNo='" + transferOrderNo + '\'' +
				", transferOrderDate=" + transferOrderDate +
				", pvuEmployeEntity=" + pvuEmployeEntity +
				", district=" + district +
				", cardexNo='" + cardexNo + '\'' +
				", ddoCode='" + ddoCode + '\'' +
				", subOfficeId=" + subOfficeId +
				", relievingDate=" + relievingDate +
				", transferNoonType=" + transferNoonType +
				", reasonForTransfer=" + reasonForTransfer +
				", transferRemarks='" + transferRemarks + '\'' +
				", joiningNoonType=" + joiningNoonType +
				", joiningRemarks='" + joiningRemarks + '\'' +
				", status=" + status +
				", joiningSubOfficeId=" + joiningSubOfficeId +
				", actualJoiningDate=" + actualJoiningDate +
				", workflowActionId=" + workflowActionId +
				", workflowStatusId=" + workflowStatusId +
				", curOffice=" + curOffice +
				", curDistrict=" + curDistrict +
				", curCardexNo='" + curCardexNo + '\'' +
				", curDDONo='" + curDDONo + '\'' +
				", refDate=" + refDate +
				'}';
	}
}
