package gov.ifms.loc.workflow.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;

/**
 * The Class BudgetMsDemandDto.
 * 
 * @version 1.0
 * @created 2021/03/01 17:21:07
 *
 */
public class LocPaymentDtlsDto implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@NativeQueryResultColumn(index = 0)
	private long id;

	/** The code. */
	@NativeQueryResultColumn(index = 1)
	private String code;

	/** The desc. */
	@NativeQueryResultColumn(index = 2)
	private String desc;

	/** The code name. */
	@NativeQueryResultColumn(index = 3)
	private String codeName;

	/**
	 * Instantiates a new loc payment dtls dto.
	 */
	public LocPaymentDtlsDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the code name.
	 *
	 * @return the code name
	 */
	public String getCodeName() {
		return codeName;
	}

	/**
	 * Sets the code name.
	 *
	 * @param codeName the new code name
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
