package gov.ifms.edp.service;

import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.entity.EDPMsSubModuleEntity;

/**
 * The Interface EDPMsSubModuleService.
 */
public interface EDPMsSubModuleService {

	/**
	 * Returns all instances of the EDPMsSubModuleService type.
	 * 
	 * @return all EDPMsModuleEntity
	 */
	List<EDPMsSubModuleEntity> getMsSubModules();

	/**
	 * Retrieves an EDPMsModuleEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the EDPMsModuleEntity with the given id or {@literal null} if none
	 *         found
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	List<EDPMsSubModuleEntity> getMsSubModule(Long id) throws CustomException;

}
