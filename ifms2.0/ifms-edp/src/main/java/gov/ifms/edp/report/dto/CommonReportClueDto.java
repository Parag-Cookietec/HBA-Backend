package gov.ifms.edp.report.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CommonReportClueDto.
 */
@JsonInclude(Include.NON_NULL)
public class CommonReportClueDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1l;
	
	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The is current year. */
	private Integer isCurrentYear;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the checks if is current year.
	 *
	 * @return the checks if is current year
	 */
	public Integer getIsCurrentYear() {
		return isCurrentYear;
	}

	/**
	 * Sets the checks if is current year.
	 *
	 * @param isCurrentYear the new checks if is current year
	 */
	public void setIsCurrentYear(Integer isCurrentYear) {
		this.isCurrentYear = isCurrentYear;
	}
	
}
