package gov.ifms.pvu.dto;

import java.io.Serializable;
import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISDurationPendingEnumOneReport implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private String daysOne;
	
	@NativeQueryResultColumn(index = 1)
	private String daysTwo;

	@NativeQueryResultColumn(index = 2)
	private String daysThree;

	@NativeQueryResultColumn(index = 3)
	private String daysFour;

	public String getDaysOne() {
		return daysOne;
	}

	public void setDaysOne(String daysOne) {
		this.daysOne = daysOne;
	}

	
	public String getDaysTwo() {
		return daysTwo;
	}

	public void setDaysTwo(String daysTwo) {
		this.daysTwo = daysTwo;
	}

	public String getDaysThree() {
		return daysThree;
	}

	public void setDaysThree(String daysThree) {
		this.daysThree = daysThree;
	}

	public String getDaysFour() {
		return daysFour;
	}

	public void setDaysFour(String daysFour) {
		this.daysFour = daysFour;
	}
	
	
	
	
	


	
	
	
	
}
