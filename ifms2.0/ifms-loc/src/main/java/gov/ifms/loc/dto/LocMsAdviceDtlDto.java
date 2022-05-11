package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * The Class LocMsAdviceDtlDto.
 */
public class LocMsAdviceDtlDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The advice id. */
	private Long adviceId;

	/** The advice desc. */
	private String adviceDesc;

	/**
	 * Gets the advice id.
	 *
	 * @return the advice id
	 */
	public Long getAdviceId() {
		return adviceId;
	}

	/**
	 * Sets the advice id.
	 *
	 * @param adviceId the new advice id
	 */
	public void setAdviceId(Long adviceId) {
		this.adviceId = adviceId;
	}

	/**
	 * Gets the advice desc.
	 *
	 * @return the advice desc
	 */
	public String getAdviceDesc() {
		return adviceDesc;
	}

	/**
	 * Sets the advice desc.
	 *
	 * @param adviceDesc the new advice desc
	 */
	public void setAdviceDesc(String adviceDesc) {
		this.adviceDesc = adviceDesc;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LocMsAdviceDtlDto))
			return false;
		if (!super.equals(o))
			return false;
		LocMsAdviceDtlDto that = (LocMsAdviceDtlDto) o;
		return Objects.equals(getAdviceId(), that.getAdviceId())
				&& Objects.equals(getAdviceDesc(), that.getAdviceDesc());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getAdviceId(), getAdviceDesc());
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "LocMsAdviceDtlDto{" + "adviceId=" + adviceId + ", adviceDesc='" + adviceDesc + '\'' + '}';
	}
}
