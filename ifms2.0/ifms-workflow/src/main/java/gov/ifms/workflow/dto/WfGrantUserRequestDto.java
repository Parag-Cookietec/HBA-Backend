package gov.ifms.workflow.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class WfRequestDto
 */
public class WfGrantUserRequestDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	@NotNull
	private Long officeId;
	
	@NotNull
	private Long menuId;

	@NotNull
	private Long toWfRoleId;

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getToWfRoleId() {
		return toWfRoleId;
	}

	public void setToWfRoleId(Long toWfRoleId) {
		this.toWfRoleId = toWfRoleId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfGrantUserRequestDto that = (WfGrantUserRequestDto) o;
		return Objects.equals(officeId, that.officeId) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(toWfRoleId, that.toWfRoleId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(officeId, menuId, toWfRoleId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfGrantUserRequestDto.class.getSimpleName() + "[", "]")
				.add("officeId=" + officeId)
				.add("menuId=" + menuId)
				.add("toWfRoleId=" + toWfRoleId)
				.toString();
	}
}
