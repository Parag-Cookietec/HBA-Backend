package gov.ifms.loc.workflow.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import gov.ifms.edp.entity.BaseEntity;
import gov.ifms.loc.util.LocConstant;


/**
 * The Class LocWfRequestEntity.
 */
@Entity
@Table(name = "TLOC_WF_REQUEST", schema = LocConstant.LOC_SCHEMA)
public class LocWfRequestEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7061964085863848968L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "locWfRequestSeq")
	@GenericGenerator(name = "locWfRequestSeq",strategy = "sequence",parameters = {
			@org.hibernate.annotations.Parameter(name="sequence_name",value = "LOC.TLOC_WF_REQUEST_ID_SEQ")
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
		LocWfRequestEntity that = (LocWfRequestEntity) o;
		return wfRequestId == that.wfRequestId && menuId == that.menuId && typeId == that.typeId && statusId == that.statusId && Objects.equals(wfRequestNo, that.wfRequestNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(wfRequestId, wfRequestNo, menuId, typeId, statusId);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LocWfRequestEntity{");
		sb.append("wfRequestId=").append(wfRequestId);
		sb.append(", wfRequestNo='").append(wfRequestNo).append('\'');
		sb.append(", menuId=").append(menuId);
		sb.append(", typeId=").append(typeId);
		sb.append(", statusId=").append(statusId);
		sb.append('}');
		return sb.toString();
	}
}
