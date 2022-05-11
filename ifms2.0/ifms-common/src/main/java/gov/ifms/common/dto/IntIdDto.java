package gov.ifms.common.dto;

import java.io.Serializable;

/**
 * The EDPIntIdDto.
 *
 * @version 1.0
 * @created 2019/07/26 15:15:38
 */
public class IntIdDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private Integer id;

	/**
	 * Instantiates a new int id dto.
	 */
	public IntIdDto() {
	}

	/**
	 * Instantiates a new int id dto.
	 *
	 * @param id the id
	 */
	public IntIdDto(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
