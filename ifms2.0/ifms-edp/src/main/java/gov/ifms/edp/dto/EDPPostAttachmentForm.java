package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPPostAttachmentForm.
 * 
 * @version 1.0
 * @created 2019/09/11 10:20:29
 *
 */
public class EDPPostAttachmentForm implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPPostAttachmentDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPPostAttachmentDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the new attch
	 */
	public void setAttch(List<EDPPostAttachmentDto> attch) {
		this.attch = attch;
	}

	/**
	 * Instantiates a new EDP post attachment form.
	 */
	public EDPPostAttachmentForm() {
		super();
	}

	/**
	 * Instantiates a new EDP post attachment form.
	 *
	 * @param attch the attch
	 */
	public EDPPostAttachmentForm(List<EDPPostAttachmentDto> attch) {
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
		if (!(obj instanceof EDPPostAttachmentForm)) {
			return false;
		}
		EDPPostAttachmentForm other = (EDPPostAttachmentForm) obj;
		return Objects.equals(attch, other.attch);
	}

}
