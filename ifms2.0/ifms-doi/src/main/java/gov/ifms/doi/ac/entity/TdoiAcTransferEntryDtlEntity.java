package gov.ifms.doi.ac.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the TDOI_AC_TRANSFER_ENTRY_DTL database table.
 * 
 */
import gov.ifms.doi.jpa.constant.DoiJPAConstants;
import gov.ifms.doi.jpa.entity.BaseEntity;

@Entity
@Table(name = "TDOI_AC_TRANSFER_ENTRY_DTL", schema = DoiJPAConstants.DOI_SCHEMA)
@NamedQuery(name = "TdoiAcTransferEntryDtlEntity.findAll", query = "SELECT t FROM TdoiAcTransferEntryDtlEntity t")
public class TdoiAcTransferEntryDtlEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSFR_DTL_ID", unique = true, nullable = false)
	private long transfrDtlId;

	@Column(name = "BUDG_TYPE_ID")
	private long budgTypeId;

	@Column(name = "CARDEX_NO", length = 30)
	private String cardexNo;

	@Column(name = "CLASS_ID")
	private long classId;

	@Column(name = "DDO_OFFC_ID")
	private long ddoOffcId;

	@Column(name = "DEMAND_NO")
	private long demandNo;

	@Column(name = "DETL_HEAD_ID")
	private long detlHeadId;

	@Column(name = "DO_OPERATOR", length = 10)
	private String doOperator;

	@Column(name = "EXP_TYPE_ID")
	private long expTypeId;

	@Column(name = "FUND_TYPE_ID")
	private long fundTypeId;

	@Column(name = "MAJORHEAD_ID")
	private long majorheadId;

	@Column(name = "MINORHEAD_ID")
	private long minorheadId;

	@Column(name = "OBJ_CLASS_ID")
	private long objClassId;

	@Column(name = "REFERENCE_DT")
	private Date referenceDt;

	@Column(name = "REFERENCE_NO", length = 30)
	private String referenceNo;

	@Column(name = "SCHEME_NO", length = 10)
	private String schemeNo;

	@Column(name = "SUBHEAD_ID")
	private long subheadId;

	@Column(name = "SUBMAJORHEAD_ID")
	private long submajorheadId;

	@Column(name = "TE_AMOUNT")
	private double teAmount;

	@Column(name = "TE_TYPE_ID")
	private long teTypeId;

	@Column(name = "TRANS_FRM_OR_TO", length = 4)
	private String transFrmOrTo;

	@Column(name = "TRANSFER_DT")
	private Date transferDt;

	@Column(name = "TRANSFER_ENTRY_NO", length = 30)
	private String transferEntryNo;

	// bi-directional many-to-one association to TdoiAcTransferEntry
	@ManyToOne
	@JoinColumn(name = "TRANSFER_ENTRY_ID", nullable = false)
	private TdoiAcTransferEntryEntity tdoiAcTransferEntry;

	public long getTransfrDtlId() {
		return this.transfrDtlId;
	}

	public void setTransfrDtlId(long transfrDtlId) {
		this.transfrDtlId = transfrDtlId;
	}

	public long getBudgTypeId() {
		return this.budgTypeId;
	}

	public void setBudgTypeId(long budgTypeId) {
		this.budgTypeId = budgTypeId;
	}

	public String getCardexNo() {
		return this.cardexNo;
	}

	public void setCardexNo(String cardexNo) {
		this.cardexNo = cardexNo;
	}

	public long getClassId() {
		return this.classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public long getDdoOffcId() {
		return this.ddoOffcId;
	}

	public void setDdoOffcId(long ddoOffcId) {
		this.ddoOffcId = ddoOffcId;
	}

	public long getDemandNo() {
		return this.demandNo;
	}

	public void setDemandNo(long demandNo) {
		this.demandNo = demandNo;
	}

	public long getDetlHeadId() {
		return this.detlHeadId;
	}

	public void setDetlHeadId(long detlHeadId) {
		this.detlHeadId = detlHeadId;
	}

	public String getDoOperator() {
		return this.doOperator;
	}

	public void setDoOperator(String doOperator) {
		this.doOperator = doOperator;
	}

	public long getExpTypeId() {
		return this.expTypeId;
	}

	public void setExpTypeId(long expTypeId) {
		this.expTypeId = expTypeId;
	}

	public long getFundTypeId() {
		return this.fundTypeId;
	}

	public void setFundTypeId(long fundTypeId) {
		this.fundTypeId = fundTypeId;
	}

	public long getMajorheadId() {
		return this.majorheadId;
	}

	public void setMajorheadId(long majorheadId) {
		this.majorheadId = majorheadId;
	}

	public long getMinorheadId() {
		return this.minorheadId;
	}

	public void setMinorheadId(long minorheadId) {
		this.minorheadId = minorheadId;
	}

	public long getObjClassId() {
		return this.objClassId;
	}

	public void setObjClassId(long objClassId) {
		this.objClassId = objClassId;
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

	public String getSchemeNo() {
		return this.schemeNo;
	}

	public void setSchemeNo(String schemeNo) {
		this.schemeNo = schemeNo;
	}

	public long getSubheadId() {
		return this.subheadId;
	}

	public void setSubheadId(long subheadId) {
		this.subheadId = subheadId;
	}

	public long getSubmajorheadId() {
		return this.submajorheadId;
	}

	public void setSubmajorheadId(long submajorheadId) {
		this.submajorheadId = submajorheadId;
	}

	public double getTeAmount() {
		return this.teAmount;
	}

	public void setTeAmount(double teAmount) {
		this.teAmount = teAmount;
	}

	public long getTeTypeId() {
		return this.teTypeId;
	}

	public void setTeTypeId(long teTypeId) {
		this.teTypeId = teTypeId;
	}

	public String getTransFrmOrTo() {
		return this.transFrmOrTo;
	}

	public void setTransFrmOrTo(String transFrmOrTo) {
		this.transFrmOrTo = transFrmOrTo;
	}

	public Date getTransferDt() {
		return this.transferDt;
	}

	public void setTransferDt(Date transferDt) {
		this.transferDt = transferDt;
	}

	public String getTransferEntryNo() {
		return this.transferEntryNo;
	}

	public void setTransferEntryNo(String transferEntryNo) {
		this.transferEntryNo = transferEntryNo;
	}

	public TdoiAcTransferEntryEntity getTdoiAcTransferEntry() {
		return this.tdoiAcTransferEntry;
	}

	public void setTdoiAcTransferEntry(TdoiAcTransferEntryEntity tdoiAcTransferEntry) {
		this.tdoiAcTransferEntry = tdoiAcTransferEntry;
	}

}
