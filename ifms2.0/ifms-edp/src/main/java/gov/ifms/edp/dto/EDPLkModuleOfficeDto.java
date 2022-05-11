package gov.ifms.edp.dto;

import java.io.Serializable;

import gov.ifms.common.dao.NativeQueryResultColumn;
import gov.ifms.common.dao.NativeQueryResultEntity;

/**
 * The Class EDPLkModuleOfficeDto.
 */
@NativeQueryResultEntity
public class EDPLkModuleOfficeDto implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The mod office type id. */
	@NativeQueryResultColumn(index = 0)
	private Long modOfficeTypeId;
	
	/** The module id. */
	@NativeQueryResultColumn(index = 1)
	private Long moduleId;
	
	/** The module name. */
	@NativeQueryResultColumn(index = 2)
	private String module;

	/**
	 * Gets the mod office type id.
	 *
	 * @return the mod office type id
	 */
	public Long getModOfficeTypeId() {
		return modOfficeTypeId;
	}

	/**
	 * Sets the mod office type id.
	 *
	 * @param modOfficeTypeId the new mod office type id
	 */
	public void setModOfficeTypeId(Long modOfficeTypeId) {
		this.modOfficeTypeId = modOfficeTypeId;
	}

	/**
	 * Gets the module id.
	 *
	 * @return the module id
	 */
	public Long getModuleId() {
		return moduleId;
	}

	/**
	 * Sets the module id.
	 *
	 * @param moduleId the new module id
	 */
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * Gets the module.
	 *
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * Sets the module.
	 *
	 * @param module the new module
	 */
	public void setModule(String module) {
		this.module = module;
	}
		
}
