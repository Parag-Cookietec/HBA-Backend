package gov.ifms.workflow.entity;

import gov.ifms.common.util.Constant;
import gov.ifms.edp.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;


@Entity
@Table(name = "WF_REQUEST", schema = Constant.WORKFLOW_SCHEMA)
public class WfRequestEntity extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wfRequestSeq")
	@GenericGenerator(name = "wfRequestSeq",strategy = "sequence",parameters = {
			@org.hibernate.annotations.Parameter(name="sequence_name",value = "MASTER_V1.WF_REQUEST_ID_SEQ")
	})
	@Column(name = "WF_REQUEST_ID")
	private long wfRequestId;

	@Column(name = "WF_REQUEST_NO")
	private String wfRequestNo;

	@Column(name = "MENU_ID")
	private long menuId;

	@Column(name = "TYPE_ID")
	private long typeId;

	@Column(name = "STATUS_ID")
	private long statusId;

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

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WfRequestEntity that = (WfRequestEntity) o;
		return wfRequestId == that.wfRequestId &&
				menuId == that.menuId &&
				typeId == that.typeId &&
				statusId == that.statusId &&
				Objects.equals(wfRequestNo, that.wfRequestNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wfRequestId, wfRequestNo, menuId, typeId, statusId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", WfRequestEntity.class.getSimpleName() + "[", "]")
				.add("wfRequestId=" + wfRequestId)
				.add("wfRequestNo='" + wfRequestNo + "'")
				.add("menuId=" + menuId)
				.add("typeId=" + typeId)
				.add("statusId=" + statusId)
				.toString();
	}
}
