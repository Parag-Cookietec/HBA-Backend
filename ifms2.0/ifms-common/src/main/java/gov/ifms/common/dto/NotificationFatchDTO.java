package gov.ifms.common.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * This Class For notification Details Input
 *
 */
public class NotificationFatchDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2158121888688972118L;

	@NotNull
	private Long pouId;

	@NotNull
	private List<Long> listOfMenu;
	
	@NotNull
	private Object userId;


	public Long getPouId() {
		return pouId;
	}

	public void setPouId(Long pouId) {
		this.pouId = pouId;
	}

	public List<Long> getListOfMenu() {
		return listOfMenu;
	}

	public void setListOfMenu(List<Long> listOfMenu) {
		this.listOfMenu = listOfMenu;
	}

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NotificationFatchDTO that = (NotificationFatchDTO) o;
		return Objects.equals(pouId, that.pouId) &&
				Objects.equals(listOfMenu, that.listOfMenu) &&
				Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pouId, listOfMenu, userId);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", NotificationFatchDTO.class.getSimpleName() + "[", "]")
				.add("pouId=" + pouId)
				.add("listOfMenu=" + listOfMenu)
				.add("userId=" + userId)
				.toString();
	}
}
