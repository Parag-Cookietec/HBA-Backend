package gov.ifms.edp.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

/**
 * The Class EDPUserRoleMpAttachmentForm.
 */
public class EDPUserRoleMpAttachmentForm implements Serializable {

	/**  The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The attch. */
	@Valid
	private List<EDPTrnUserMpAttDto> attch;

	/**
	 * Gets the attch.
	 *
	 * @return the attch
	 */
	public List<EDPTrnUserMpAttDto> getAttch() {
		return attch;
	}

	/**
	 * Sets the attch.
	 *
	 * @param attch the new attch
	 */
	public void setAttch(List<EDPTrnUserMpAttDto> attch) {
		this.attch = attch;
	}

	/**
	 * Instantiates a new EDP user role mp attachment form.
	 */
	public EDPUserRoleMpAttachmentForm() {
		super();
	}

	/**
	 * Instantiates a new EDP user role mp attachment form.
	 *
	 * @param attch the attch
	 */
	public EDPUserRoleMpAttachmentForm(List<EDPTrnUserMpAttDto> attch) {
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
		if (!(obj instanceof EDPUserRoleMpAttachmentForm)) {
			return false;
		}
		EDPUserRoleMpAttachmentForm other = (EDPUserRoleMpAttachmentForm) obj;
		return Objects.equals(attch, other.attch);
	}

}
