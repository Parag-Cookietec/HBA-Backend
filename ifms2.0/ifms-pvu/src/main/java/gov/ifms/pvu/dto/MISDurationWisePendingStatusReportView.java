package gov.ifms.pvu.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 */
@NativeQueryResultEntity
public class MISDurationWisePendingStatusReportView implements Serializable {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@NativeQueryResultColumn(index = 0)
	private int daysone;
	
	@NativeQueryResultColumn(index = 1)
	private int daystwo;
	
	@NativeQueryResultColumn(index = 2)
	private int daysthree;
	
	@NativeQueryResultColumn(index = 2)
	private int daysFour;

	public int getDaysone() {
		return daysone;
	}

	public void setDaysone(int daysone) {
		this.daysone = daysone;
	}

	public int getDaystwo() {
		return daystwo;
	}

	public void setDaystwo(int daystwo) {
		this.daystwo = daystwo;
	}

	public int getDaysthree() {
		return daysthree;
	}

	public void setDaysthree(int daysthree) {
		this.daysthree = daysthree;
	}

	public int getDaysFour() {
		return daysFour;
	}

	public void setDaysFour(int daysFour) {
		this.daysFour = daysFour;
	}


	
	
	
}
