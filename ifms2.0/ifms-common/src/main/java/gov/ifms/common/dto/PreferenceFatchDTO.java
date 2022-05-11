package gov.ifms.common.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * @author IFMS 2.0
 *
 */
public class PreferenceFatchDTO {
	
	@NotNull
	private Object userId;

	private List<Long> listOfMenu;

	public Object getUserId() {
		return userId;
	}

	public void setUserId(Object userId) {
		this.userId = userId;
	}

	public List<Long> getListOfMenu() {
		return listOfMenu;
	}

	public void setListOfMenu(List<Long> listOfMenu) {
		this.listOfMenu = listOfMenu;
	}



}
