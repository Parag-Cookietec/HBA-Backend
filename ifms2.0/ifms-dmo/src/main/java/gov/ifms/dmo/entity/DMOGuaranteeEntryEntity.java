package gov.ifms.dmo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.ifms.common.util.Constant;

@Entity
@Table(name = "TDMO_GUARANTEE_ENTRY", schema = Constant.DMO_SCHEMA)
public class DMOGuaranteeEntryEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/** The is GUARANTEE_ENTRY_ID. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GUARANTEE_ENTRY_ID")
	private Long id;

	/** The is REFERENCE_NO. */
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	/** The is REFERENCE_DT. */
	@Column(name = "REFERENCE_DT")
	private LocalDateTime referenceDt;

	/** The is CRDTR_DEPT_ID. */
	@Column(name = "CRDTR_DEPT_ID")
	private Long crdtrDeptId;

	/** The is CRDTR_DEPT_NAME. */
	@Column(name = "CRDTR_DEPT_NAME")
	private String crdtrDeptName;

	/** The is CRDTR_HOD_ID. */
	@Column(name = "CRDTR_HOD_ID")
	private Long crdtrHodId;

	/** The is CRDTR_HOD_NAME. */
	@Column(name = "CRDTR_HOD_NAME")
	private String crdtrHodName;

	/** The is CRDTR_INSTITUTE_ID. */
	@Column(name = "CRDTR_INSTITUTE_ID")
	private Long crdtrInstituteId;

	/** The is CRDTR_INSTITUTE_NAME. */
	@Column(name = "CRDTR_INSTITUTE_NAME")
	private String crdtrInstituteName;

	/** The is DEBTR_DEPT_ID. */
	@Column(name = "DEBTR_DEPT_ID")
	private Long debtrDeptId;

	/** The is DEBTR_DEPT_NAME. */
	@Column(name = "DEBTR_DEPT_NAME")
	private String debtrDeptName;

	/** The is DEBTR_HOD_ID. */
	@Column(name = "DEBTR_HOD_ID")
	private Long debtrHodId;

	/** The is DEBTR_HOD_NAME. */
	@Column(name = "DEBTR_HOD_NAME")
	private String debtrHodName;

	/** The is DEBTR_INSTITUTE_ID. */
	@Column(name = "DEBTR_INSTITUTE_ID")
	private Long debtrInstituteId;

	/** The is DEBTR_INSTITUTE_NAME. */
	@Column(name = "DEBTR_INSTITUTE_NAME")
	private String debtrInstituteName;

	/** The is GUARANTEE_AMOUNT. */
	@Column(name = "GUARANTEE_AMOUNT")
	private Double guaranteeAmount;

	/** The is GUARANTEE_TENURE. */
	@Column(name = "GUARANTEE_TENURE")
	private Integer guaranteeTenure;

	/** The is GUARANTEE_FEE_RATE. */
	@Column(name = "GUARANTEE_FEE_RATE")
	private Double guaranteeFeeRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCrdtrDeptId() {
		return crdtrDeptId;
	}

	public void setCrdtrDeptId(Long crdtrDeptId) {
		this.crdtrDeptId = crdtrDeptId;
	}

	public String getCrdtrDeptName() {
		return crdtrDeptName;
	}

	public void setCrdtrDeptName(String crdtrDeptName) {
		this.crdtrDeptName = crdtrDeptName;
	}

	public Long getCrdtrHodId() {
		return crdtrHodId;
	}

	public void setCrdtrHodId(Long crdtrHodId) {
		this.crdtrHodId = crdtrHodId;
	}

	public String getCrdtrHodName() {
		return crdtrHodName;
	}

	public void setCrdtrHodName(String crdtrHodName) {
		this.crdtrHodName = crdtrHodName;
	}

	public Long getCrdtrInstituteId() {
		return crdtrInstituteId;
	}

	public void setCrdtrInstituteId(Long crdtrInstituteId) {
		this.crdtrInstituteId = crdtrInstituteId;
	}

	public String getCrdtrInstituteName() {
		return crdtrInstituteName;
	}

	public void setCrdtrInstituteName(String crdtrInstituteName) {
		this.crdtrInstituteName = crdtrInstituteName;
	}

	public Long getDebtrDeptId() {
		return debtrDeptId;
	}

	public void setDebtrDeptId(Long debtrDeptId) {
		this.debtrDeptId = debtrDeptId;
	}

	public String getDebtrDeptName() {
		return debtrDeptName;
	}

	public void setDebtrDeptName(String debtrDeptName) {
		this.debtrDeptName = debtrDeptName;
	}

	public Long getDebtrHodId() {
		return debtrHodId;
	}

	public void setDebtrHodId(Long debtrHodId) {
		this.debtrHodId = debtrHodId;
	}

	public String getDebtrHodName() {
		return debtrHodName;
	}

	public void setDebtrHodName(String debtrHodName) {
		this.debtrHodName = debtrHodName;
	}

	public Long getDebtrInstituteId() {
		return debtrInstituteId;
	}

	public void setDebtrInstituteId(Long debtrInstituteId) {
		this.debtrInstituteId = debtrInstituteId;
	}

	public String getDebtrInstituteName() {
		return debtrInstituteName;
	}

	public void setDebtrInstituteName(String debtrInstituteName) {
		this.debtrInstituteName = debtrInstituteName;
	}

	public Double getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(Double guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public Integer getGuaranteeTenure() {
		return guaranteeTenure;
	}

	public void setGuaranteeTenure(Integer guaranteeTenure) {
		this.guaranteeTenure = guaranteeTenure;
	}

	public Double getGuaranteeFeeRate() {
		return guaranteeFeeRate;
	}

	public void setGuaranteeFeeRate(Double guaranteeFeeRate) {
		this.guaranteeFeeRate = guaranteeFeeRate;
	}

}
