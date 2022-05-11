package gov.ifms.edp.dto;

import java.io.Serializable;

public class EDPMenuWfDto  implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The trn usr wf role id. */
	private Long trnUsrWfRoleId;

	/** The lk user menu id. */
	private long menuId;

	/** The workflow role id. */
	private long wfRoleId;

	private int isRemoved;

	public Long getTrnUsrWfRoleId() {
		return trnUsrWfRoleId;
	}

	public void setTrnUsrWfRoleId(Long trnUsrWfRoleId) {
		this.trnUsrWfRoleId = trnUsrWfRoleId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getWfRoleId() {
		return wfRoleId;
	}

	public void setWfRoleId(long wfRoleId) {
		this.wfRoleId = wfRoleId;
	}

	public int getIsRemoved() {
		return isRemoved;
	}

	public void setIsRemoved(int isRemoved) {
		this.isRemoved = isRemoved;
	}

}
