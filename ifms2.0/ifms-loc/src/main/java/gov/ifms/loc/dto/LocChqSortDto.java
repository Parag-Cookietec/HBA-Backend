package gov.ifms.loc.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class LocChqSortDto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@NativeQueryResultEntity
public class LocChqSortDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1469574623019993401L;

	/** The chq no. */
	@NativeQueryResultColumn(index = 0)
	private String chqNo;

	/** The chq date. */
	@NativeQueryResultColumn(index = 1)
	private Date chqDate;

	/** The chq to chq no. */
	@NativeQueryResultColumn(index = 2)
	private String chqToChqNo;

	/** The chq to chq date. */
	@NativeQueryResultColumn(index = 3)
	private Date chqToChqDate;

	/**
	 * Gets the chq no.
	 *
	 * @return the chq no
	 */
	public String getChqNo() {
		return chqNo;
	}

	/**
	 * Sets the chq no.
	 *
	 * @param chqNo the new chq no
	 */
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}

	/**
	 * Gets the chq date.
	 *
	 * @return the chq date
	 */
	public Date getChqDate() {
		return chqDate;
	}

	/**
	 * Sets the chq date.
	 *
	 * @param chqDate the new chq date
	 */
	public void setChqDate(Date chqDate) {
		this.chqDate = chqDate;
	}

	/**
	 * Gets the chq to chq no.
	 *
	 * @return the chq to chq no
	 */
	public String getChqToChqNo() {
		return chqToChqNo;
	}

	/**
	 * Sets the chq to chq no.
	 *
	 * @param chqToChqNo the new chq to chq no
	 */
	public void setChqToChqNo(String chqToChqNo) {
		this.chqToChqNo = chqToChqNo;
	}

	/**
	 * Gets the chq to chq date.
	 *
	 * @return the chq to chq date
	 */
	public Date getChqToChqDate() {
		return chqToChqDate;
	}

	/**
	 * Sets the chq to chq date.
	 *
	 * @param chqToChqDate the new chq to chq date
	 */
	public void setChqToChqDate(Date chqToChqDate) {
		this.chqToChqDate = chqToChqDate;
	}

	/**
	 * Instantiates a new loc chq sort dto.
	 *
	 * @param chqNo   the chq no
	 * @param chqDate the chq date
	 */
	public LocChqSortDto(String chqNo, Date chqDate) {
		this.chqNo = chqNo;
		this.chqDate = chqDate;
	}

	/**
	 * Instantiates a new loc chq sort dto.
	 */
	public LocChqSortDto() {
		super();
	}

}
