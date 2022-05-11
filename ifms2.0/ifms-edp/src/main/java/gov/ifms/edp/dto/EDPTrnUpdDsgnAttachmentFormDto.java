package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPTrnUpdDsgnAttachmentFormDto.
 */
public class EDPTrnUpdDsgnAttachmentFormDto implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPTrnUpdDsgnAttachmentDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPTrnUpdDsgnAttachmentDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the attch to set
	 */
	public void setAttch(List<EDPTrnUpdDsgnAttachmentDto> attch) {
		this.attch = attch;
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
		if (!(obj instanceof EDPTrnUpdDsgnAttachmentFormDto)) {
			return false;
		}
		EDPTrnUpdDsgnAttachmentFormDto other = (EDPTrnUpdDsgnAttachmentFormDto) obj;
		return Objects.equals(attch, other.attch);
	}
	
}
