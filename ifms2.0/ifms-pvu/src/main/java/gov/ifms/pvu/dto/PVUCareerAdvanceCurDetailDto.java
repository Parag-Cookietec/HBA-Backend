package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class PVUCareerAdvanceCurDetailDto.
 * 
 * @version v 1.0
 * @created 2020/05/26 11:46:59
 *
 */
public class PVUCareerAdvanceCurDetailDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The effective date. */
	private String effectiveDate;

	/** The emp no. */
	private Long empNo;

	/** The pay commission. */
	private Long payCommission;

	private long advSchType;

	private Boolean isViewPage;

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public Long getPayCommission() {
		return payCommission;
	}

	public void setPayCommission(Long payCommission) {
		this.payCommission = payCommission;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public long getAdvSchType() {
		return advSchType;
	}

	public void setAdvSchType(long advSchType) {
		this.advSchType = advSchType;
	}

	public Boolean getIsViewPage() {
		return isViewPage;
	}

	public void setIsViewPage(Boolean isViewPage) {
		this.isViewPage = isViewPage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(advSchType, effectiveDate, empNo, isViewPage, payCommission);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PVUCareerAdvanceCurDetailDto)) {
			return false;
		}
		PVUCareerAdvanceCurDetailDto other = (PVUCareerAdvanceCurDetailDto) obj;
		return advSchType == other.advSchType && Objects.equals(effectiveDate, other.effectiveDate)
				&& Objects.equals(empNo, other.empNo) && Objects.equals(isViewPage, other.isViewPage)
				&& Objects.equals(payCommission, other.payCommission);
	}

}
