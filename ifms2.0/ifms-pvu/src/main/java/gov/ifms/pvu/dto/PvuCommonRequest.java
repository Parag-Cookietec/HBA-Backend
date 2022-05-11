package gov.ifms.pvu.dto;

import java.util.Map;

/**
 * The Class PvuCommonRequest.
 */
public class PvuCommonRequest {

	/** The request. */
	private Map<String, Long> request;

	private Map<String, Object> data;

	/**
	 * Gets the request.
	 *
	 * @return the request
	 */
	public Map<String, Long> getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 *
	 * @param request the request
	 */
	public void setRequest(Map<String, Long> request) {
		this.request = request;
	}


	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
}
