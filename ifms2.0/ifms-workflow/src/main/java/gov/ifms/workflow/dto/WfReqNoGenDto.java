package gov.ifms.workflow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;


public class WfReqNoGenDto implements Serializable {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private long wfRequestId;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private String wfRequestNo;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long menuId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long typeId;

	public long getWfRequestId() {
		return wfRequestId;
	}

	public void setWfRequestId(long wfRequestId) {
		this.wfRequestId = wfRequestId;
	}

	public String getWfRequestNo() {
		return wfRequestNo;
	}

	public void setWfRequestNo(String wfRequestNo) {
		this.wfRequestNo = wfRequestNo;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(wfRequestId, wfRequestNo, menuId, typeId);
	}

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
