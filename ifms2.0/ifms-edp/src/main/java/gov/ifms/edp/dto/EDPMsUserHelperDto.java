package gov.ifms.edp.dto;

/**
 * @author Admin
 *
 * @param <T>
 */
public class EDPMsUserHelperDto {
	Object response;
	String message;

	

	public EDPMsUserHelperDto(Object response, String message) {
		super();
		this.response = response;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
