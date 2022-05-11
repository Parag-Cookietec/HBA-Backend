package gov.ifms.pvu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.FieldError;

import gov.ifms.common.base.DTO;
import gov.ifms.common.exception.ValidationUtil;
import gov.ifms.common.util.Utils;
import gov.ifms.pvu.util.PvuConstant;

/**
 * The Class PVURopDetailRequest.
 */
public class PVUACPDetailRequest extends DTO {

	/** The emp no. */
	private Long empNo;

	/** The pay scale. */
	private Long payScaleId;

	/** The effective date. */
	private String effectiveDate;

	/** The pay commission. */
	private Long payCommission;

	private Long acpType;

	private Long type;

	private Long officeId;

	private Boolean isViewPage;

	public Boolean getIsViewPage() {
		return isViewPage;
	}

	public void setIsViewPage(Boolean isViewPage) {
		this.isViewPage = isViewPage;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the type
	 */
	public Long getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	 * @return the acpType
	 */
	public Long getAcpType() {
		return acpType;
	}

	/**
	 * @param acpType the acpType to set
	 */
	public void setAcpType(Long acpType) {
		this.acpType = acpType;
	}

	/**
	 * Gets the emp no.
	 *
	 * @return the empNo
	 */
	public Long getEmpNo() {
		return empNo;
	}

	/**
	 * Sets the emp no.
	 *
	 * @param empNo the empNo to set
	 */
	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the payScaleId
	 */
	public Long getPayScaleId() {
		return payScaleId;
	}

	/**
	 * @param payScaleId the payScaleId to set
	 */
	public void setPayScaleId(Long payScaleId) {
		this.payScaleId = payScaleId;
	}

	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * @return the payCommission
	 */
	public Long getPayCommission() {
		return payCommission;
	}

	/**
	 * @param payCommission the payCommission to set
	 */
	public void setPayCommission(Long payCommission) {
		this.payCommission = payCommission;
	}

	@Override
	public void validateAll() {
		List<FieldError> errors = null;
		errors = this.businessValidateACPValid();
		if (errors.isEmpty())
			return;
		ValidationUtil.throwErrors(errors);
	}

	@Override
	public List<FieldError> businessValidate() {
		List<FieldError> errors = new ArrayList<>();
		FieldError error = null;

		if (Utils.isEmpty(this.getEffectiveDate())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "Effective Date can't be empty",
					PvuConstant.EMPTY_STRING);

			errors.add(error);
		}

		if (Utils.isEmpty(this.getAcpType())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "acp Type", PvuConstant.EMPTY_STRING);
			errors.add(error);
		}

		if (Utils.isEmpty(this.getEmpNo())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "Employee No", PvuConstant.EMPTY_STRING);
			errors.add(error);
		}

		if (Utils.isEmpty(this.getPayCommission())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "PayComission ", PvuConstant.EMPTY_STRING);
			errors.add(error);
		}

		return errors;
	}

	public List<FieldError> businessValidateACPValid() {
		List<FieldError> errors = new ArrayList<>();
		FieldError error = null;

		if (Utils.isEmpty(this.getEffectiveDate())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "Effective Date can't be empty",
					PvuConstant.EMPTY_STRING);
			errors.add(error);
		}

		if (Utils.isEmpty(this.getAcpType())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "Employee No", PvuConstant.EMPTY_STRING);
			errors.add(error);
		}

		if (Utils.isEmpty(this.getEmpNo())) {
			error = new FieldError(PvuConstant.PVU_ACP_DETAIL_REQUEST, "PayComission ", PvuConstant.EMPTY_STRING);
			errors.add(error);
		}
		return errors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(acpType, effectiveDate, empNo, isViewPage, officeId, payCommission, payScaleId, type);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PVUACPDetailRequest)) {
			return false;
		}
		PVUACPDetailRequest other = (PVUACPDetailRequest) obj;
		return Objects.equals(acpType, other.acpType) && Objects.equals(effectiveDate, other.effectiveDate)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(isViewPage, other.isViewPage)
				&& Objects.equals(officeId, other.officeId) && Objects.equals(payCommission, other.payCommission)
				&& Objects.equals(payScaleId, other.payScaleId) && Objects.equals(type, other.type);
	}

}
