package gov.ifms.dmo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DMOGuaranteeEntryPostDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String referenceNo;
	private LocalDateTime referenceDt;
	@NotNull(message = "{crdtr.dept.id.notNull}")
	private Long crdtrDeptId;
	private String crdtrDeptName;
	@NotNull(message = "{crdtr.hod.name.notNull}")
	private Long crdtrHodId;
	private String crdtrHodName;
	@NotNull(message = "{crdtr.institute.name.notNull}")
	private Long crdtrInstituteId;
	private String crdtrInstituteName;
	@NotNull(message = "{debtr.dept.id.notNull}")
	private Long debtrDeptId;
	private String debtrDeptName;
	@NotNull(message = "{debtr.hod.name.notNull}")
	private Long debtrHodId;
	private String debtrHodName;
	@NotNull(message = "{debtr.institute.name.notNull}")
	private Long debtrInstituteId;
	private String debtrInstituteName;
	@NotNull(message = "{guranatee.amt.notNull}")
	private Double guaranteeAmount;
	@NotNull(message = "{guranatee.tenure.notNull}")
	private Integer guaranteeTenure;
	@NotNull(message = "{guranatee.fee.rate.notNull}")
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
