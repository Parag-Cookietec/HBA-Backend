package gov.ifms.loc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocAdviceEpayChqDtlDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocAdviceEpayChqDtlDto {

	/** The chq ser start. */
	@NativeQueryResultColumn(index = 0)
	private String chqSerStart;

	/** The chq series end. */
	@NativeQueryResultColumn(index = 1)
	private String chqSeriesEnd;

	/** The last chq no. */
	private String lastChqNo;

	/** The new chq no. */
	private String newChqNo;

	/** The next chq series. */
	private List<LocAdviceEpayChqDtlDto> nextChqSeries;

	/**
	 * Gets the last chq no.
	 *
	 * @return the last chq no
	 */
	public String getLastChqNo() {

		return lastChqNo;
	}

	/**
	 * Sets the last chq no.
	 *
	 * @param lastChqNo the new last chq no
	 */
	public void setLastChqNo(String lastChqNo) {
		this.lastChqNo = lastChqNo;
	}

	/**
	 * Gets the new chq no.
	 *
	 * @return the new chq no
	 */
	public String getNewChqNo() {
		return newChqNo;
	}

	/**
	 * Sets the new chq no.
	 *
	 * @param newChqNo the new new chq no
	 */
	public void setNewChqNo(String newChqNo) {
		this.newChqNo = newChqNo;
	}

	/**
	 * Gets the chq ser start.
	 *
	 * @return the chq ser start
	 */
	public String getChqSerStart() {
		return chqSerStart;
	}

	/**
	 * Sets the chq ser start.
	 *
	 * @param chqSerStart the new chq ser start
	 */
	public void setChqSerStart(String chqSerStart) {
		this.chqSerStart = chqSerStart;
	}

	/**
	 * Gets the chq series end.
	 *
	 * @return the chq series end
	 */
	public String getChqSeriesEnd() {
		return chqSeriesEnd;
	}

	/**
	 * Sets the chq series end.
	 *
	 * @param chqSeriesEnd the new chq series end
	 */
	public void setChqSeriesEnd(String chqSeriesEnd) {
		this.chqSeriesEnd = chqSeriesEnd;
	}

	/**
	 * Gets the next chq series.
	 *
	 * @return the next chq series
	 */
	public List<LocAdviceEpayChqDtlDto> getNextChqSeries() {
		return nextChqSeries;
	}

	/**
	 * Sets the next chq series.
	 *
	 * @param nextChqSeries the new next chq series
	 */
	public void setNextChqSeries(List<LocAdviceEpayChqDtlDto> nextChqSeries) {
		this.nextChqSeries = nextChqSeries;
	}
}
