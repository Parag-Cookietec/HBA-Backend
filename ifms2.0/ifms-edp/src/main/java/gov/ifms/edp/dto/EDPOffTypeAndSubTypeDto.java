package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * The Class EDPOffTypeAndSubTypeDto.
 */
public class EDPOffTypeAndSubTypeDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Long officeTypeId;

	/** The lk po off id. */
	private Long officeSubTypeId;

	public EDPOffTypeAndSubTypeDto() {
	}

	public Long getOfficeTypeId() {
		return officeTypeId;
	}

	public void setOfficeTypeId(Long officeTypeId) {
		this.officeTypeId = officeTypeId;
	}

	public Long getOfficeSubTypeId() {
		return officeSubTypeId;
	}

	public void setOfficeSubTypeId(Long officeSubTypeId) {
		this.officeSubTypeId = officeSubTypeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof EDPOffTypeAndSubTypeDto)) return false;
		EDPOffTypeAndSubTypeDto that = (EDPOffTypeAndSubTypeDto) o;
		return Objects.equals(getOfficeTypeId(), that.getOfficeTypeId()) && Objects.equals(getOfficeSubTypeId(), that.getOfficeSubTypeId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getOfficeTypeId(), getOfficeSubTypeId());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EDPOffTypeAndSubTypeDto{");
		sb.append("officeTypeId=").append(officeTypeId);
		sb.append(", officeSubTypeId=").append(officeSubTypeId);
		sb.append('}');
		return sb.toString();
	}
}
