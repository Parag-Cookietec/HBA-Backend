package gov.ifms.pvu.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.pvu.common.BasePVUAttachmentDto;

/**
 * The Class PVURopAttachmentDto.
 * 
 * @version v 1.0
 * @created 2020/03/17 11:14:39
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PVURopAttachmentDto extends BasePVUAttachmentDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rop attachment id. */
	private Long id;

	/** The rol event id. */
	private Long rolEventId;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the rol event id.
	 *
	 * @return the rol event id
	 */
	public Long getRolEventId() {
		return rolEventId;
	}

	/**
	 * Sets the rol event id.
	 *
	 * @param rolEventId the new rol event id
	 */
	public void setRolEventId(Long rolEventId) {
		this.rolEventId = rolEventId;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, rolEventId);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PVURopAttachmentDto other = (PVURopAttachmentDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(rolEventId, other.rolEventId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "PVURopAttachmentDto [id=" + id + ", rolEventId=" + rolEventId + "]";
	}
}
