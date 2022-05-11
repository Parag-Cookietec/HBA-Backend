package gov.ifms.workflow.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The Class WfRequestDto
 */
public class WfRequestReOffConDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	@NotNull
	private Long conHdrId;

	@NotNull
	private Long hdrId;

	@NotNull
	private Long menuId;

	@NotNull
	private Long pouId;

	@NotNull
	private Long loginOfficeId;

	@NotNull
	private Long wfActionId;

	@NotNull
	private String remarks;

	private Long branchId;

	public Long getConHdrId() {
		return conHdrId;
	}

	public void setConHdrId(Long conHdrId) {
		this.conHdrId = conHdrId;
	}

	public Long getHdrId() {
		return hdrId;
	}

	public void setHdrId(Long hdrId) {
		this.hdrId = hdrId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getPouId() {
		return pouId;
	}

	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public Long getLoginOfficeId() {
		return loginOfficeId;
	}

	public void setLoginOfficeId(Long loginOfficeId) {
		this.loginOfficeId = loginOfficeId;
	}

	public Long getWfActionId() {
		return wfActionId;
	}

	public void setWfActionId(Long wfActionId) {
		this.wfActionId = wfActionId;
	}

	public Long getBranchId() {
		return branchId;
	}

	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfRequestReOffConDto that = (WfRequestReOffConDto) o;
		return Objects.equals(conHdrId, that.conHdrId) &&
				Objects.equals(hdrId, that.hdrId) &&
				Objects.equals(menuId, that.menuId) &&
				Objects.equals(pouId, that.pouId) &&
				Objects.equals(loginOfficeId, that.loginOfficeId) &&
				Objects.equals(wfActionId, that.wfActionId) &&
				Objects.equals(remarks, that.remarks) &&
				Objects.equals(branchId, that.branchId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(conHdrId, hdrId, menuId, pouId, loginOfficeId, wfActionId, remarks, branchId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfRequestReOffConDto.class.getSimpleName() + "[", "]")
				.add("conHdrId=" + conHdrId)
				.add("hdrId=" + hdrId)
				.add("menuId=" + menuId)
				.add("pouId=" + pouId)
				.add("loginOfficeId=" + loginOfficeId)
				.add("wfActionId=" + wfActionId)
				.add("remarks='" + remarks + "'")
				.add("branchId=" + branchId)
				.toString();
	}
}
