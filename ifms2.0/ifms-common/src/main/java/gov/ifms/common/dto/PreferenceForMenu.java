package gov.ifms.common.dto;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@NativeQueryResultEntity
public class PreferenceForMenu {

	@NotNull
	@NativeQueryResultColumn(index = 5)
	private Long menuId;

	@NotNull
	@NativeQueryResultColumn(index = 1)
	private Integer isSms;

	@NotNull
	@NativeQueryResultColumn(index = 2)
	private Integer isEmail;

	@NotNull
	@NativeQueryResultColumn(index = 3)
	private Integer isSn;

	@NotNull
	private Integer activeStatus;

	@NativeQueryResultColumn(index = 0)
	private Long pouId;

	@NativeQueryResultColumn(index = 4)
	private Long userId;

	public Long getPouId() {
		return pouId;
	}

	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Integer getIsSms() {
		return isSms;
	}

	public void setIsSms(Integer isSms) {
		this.isSms = isSms;
	}

	public Integer getIsEmail() {
		return isEmail;
	}

	public void setIsEmail(Integer isEmail) {
		this.isEmail = isEmail;
	}

	public Integer getIsSn() {
		return isSn;
	}

	public void setIsSn(Integer isSn) {
		this.isSn = isSn;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PreferenceForMenu that = (PreferenceForMenu) o;
		return Objects.equals(menuId, that.menuId) && Objects.equals(isSms, that.isSms) && Objects.equals(isEmail, that.isEmail) && Objects.equals(isSn, that.isSn) && Objects.equals(activeStatus, that.activeStatus) && Objects.equals(pouId, that.pouId) && Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(menuId, isSms, isEmail, isSn, activeStatus, pouId, userId);
	}
}
