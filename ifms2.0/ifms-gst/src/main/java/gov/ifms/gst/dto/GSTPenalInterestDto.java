package gov.ifms.gst.dto;

import java.io.Serializable;

/**
 * class GSTPenalInterestDto  
 */

public class GSTPenalInterestDto  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long id;
	
	private Long bankId;
	

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

}
