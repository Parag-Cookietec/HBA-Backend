package gov.ifms.loc.workflow.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class WfReqNoGenDto.
 */
public class WfReqNoGenDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2213278917720891614L;

	/** The wf request id. */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long wfRequestId;

	/** The wf request no. */
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String wfRequestNo;

	/** The menu id. */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long menuId;

	/** The type id. */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long typeId;

	/**
	 * Gets the wf request id.
	 *
	 * @return the wf request id
	 */
	public long getWfRequestId() {
		return wfRequestId;
	}

	/**
	 * Sets the wf request id.
	 *
	 * @param wfRequestId the new wf request id
	 */
	public void setWfRequestId(long wfRequestId) {
		this.wfRequestId = wfRequestId;
	}

	/**
	 * Gets the wf request no.
	 *
	 * @return the wf request no
	 */
	public String getWfRequestNo() {
		return wfRequestNo;
	}

	/**
	 * Sets the wf request no.
	 *
	 * @param wfRequestNo the new wf request no
	 */
	public void setWfRequestNo(String wfRequestNo) {
		this.wfRequestNo = wfRequestNo;
	}

	/**
	 * Gets the menu id.
	 *
	 * @return the menu id
	 */
	public long getMenuId() {
		return menuId;
	}

	/**
	 * Sets the menu id.
	 *
	 * @param menuId the new menu id
	 */
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	/**
	 * Gets the type id.
	 *
	 * @return the type id
	 */
	public long getTypeId() {
		return typeId;
	}

	/**
	 * Sets the type id.
	 *
	 * @param typeId the new type id
	 */
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfReqNoGenDto that = (WfReqNoGenDto) o;
		return wfRequestId == that.wfRequestId &&
				menuId == that.menuId &&
				typeId == that.typeId &&
				Objects.equals(wfRequestNo, that.wfRequestNo);
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(wfRequestId, wfRequestNo, menuId, typeId);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", WfReqNoGenDto.class.getSimpleName() + "[", "]")
				.add("wfRequestId=" + wfRequestId)
				.add("wfRequestNo='" + wfRequestNo + "'")
				.add("menuId=" + menuId)
				.add("typeId=" + typeId)
				.toString();
	}
}
