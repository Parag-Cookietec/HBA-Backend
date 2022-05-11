package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPUsrPoTrnsAttFormDto.
 */
public class EDPUsrPoTrnsAttFormDto implements Serializable  {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPUsrPoTrnsAttDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPUsrPoTrnsAttDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the attch to set
	 */
	public void setAttch(List<EDPUsrPoTrnsAttDto> attch) {
		this.attch = attch;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attch);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof EDPUsrPoTrnsAttFormDto)) {
			return false;
		}
		EDPUsrPoTrnsAttFormDto other = (EDPUsrPoTrnsAttFormDto) obj;
		return Objects.equals(attch, other.attch);
	}
	
}
