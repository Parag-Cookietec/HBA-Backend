package gov.ifms.common.dto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class PreferencePostDTO {
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long createdByPost;

	private Object createdByUserId;
	
	List<PreferenceForMenu> preferenceForMenu;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCreatedByPost() {
		return createdByPost;
	}

	public void setCreatedByPost(Long createdByPost) {
		this.createdByPost = createdByPost;
	}

	public List<PreferenceForMenu> getPreferenceForMenu() {
		return preferenceForMenu;
	}

	public void setPreferenceForMenu(List<PreferenceForMenu> preferenceForMenu) {
		this.preferenceForMenu = preferenceForMenu;
	}

	public Object getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Object createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PreferencePostDTO that = (PreferencePostDTO) o;
		return Objects.equals(userId, that.userId) &&
				Objects.equals(createdByPost, that.createdByPost) &&
				Objects.equals(createdByUserId, that.createdByUserId) &&
				Objects.equals(preferenceForMenu, that.preferenceForMenu);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, createdByPost, createdByUserId, preferenceForMenu);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PreferencePostDTO.class.getSimpleName() + "[", "]")
				.add("userId=" + userId)
				.add("createdByPost=" + createdByPost)
				.add("createdByUserId=" + createdByUserId)
				.add("preferenceForMenu=" + preferenceForMenu)
				.toString();
	}
}
