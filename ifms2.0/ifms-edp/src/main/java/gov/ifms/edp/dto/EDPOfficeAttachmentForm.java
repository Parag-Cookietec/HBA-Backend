package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPOfficeAttachmentForm.
 */
public class EDPOfficeAttachmentForm implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPOfficeAttachmentDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPOfficeAttachmentDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the new attch
	 */
	public void setAttch(List<EDPOfficeAttachmentDto> attch) {
		this.attch = attch;
	}

	/**
	 * Instantiates a new EDP office attachment form.
	 */
	public EDPOfficeAttachmentForm() {
		super();
	}

	/**
	 * Instantiates a new EDP office attachment form.
	 *
	 * @param attch the attch
	 */
	public EDPOfficeAttachmentForm(List<EDPOfficeAttachmentDto> attch) {
		super();
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
		if (!(obj instanceof EDPOfficeAttachmentForm)) {
			return false;
		}
		EDPOfficeAttachmentForm other = (EDPOfficeAttachmentForm) obj;
		return Objects.equals(attch, other.attch);
	}

}
