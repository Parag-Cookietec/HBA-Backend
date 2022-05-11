package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPDesignationAttachmentForm.
 */
public class EDPDesignationAttachmentForm implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPAddDesAttachmentDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPAddDesAttachmentDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the new attch
	 */
	public void setAttch(List<EDPAddDesAttachmentDto> attch) {
		this.attch = attch;
	}

	/**
	 * Instantiates a new EDP designation attachment form.
	 */
	public EDPDesignationAttachmentForm() {
		super();
	}

	/**
	 * Instantiates a new EDP designation attachment form.
	 *
	 * @param attch the attch
	 */
	public EDPDesignationAttachmentForm(List<EDPAddDesAttachmentDto> attch) {
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
		if (!(obj instanceof EDPDesignationAttachmentForm)) {
			return false;
		}
		EDPDesignationAttachmentForm other = (EDPDesignationAttachmentForm) obj;
		return Objects.equals(attch, other.attch);
	}

}
