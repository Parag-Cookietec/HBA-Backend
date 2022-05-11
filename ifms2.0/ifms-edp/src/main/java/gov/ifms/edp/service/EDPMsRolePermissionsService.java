package gov.ifms.edp.service;

import java.util.List;
import java.util.Set;

import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.entity.EDPMsRolePermissionsEntity;

/**
 * The Interface EDPMsRolePermissionsService.
 *
 * @author db2admin
 */
public interface EDPMsRolePermissionsService {

	/**
	 * Gets the EDP ms R ole activity by role activity id in.
	 *
	 * @param idList the id list
	 * @return the EDP ms R ole activity by role activity id in
	 */
	List<EDPMsRolePermissionsEntity> getEDPMsROleActivityByRoleActivityIdIn(Set<Long> idList);

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	List<ClueDto> getAll();
}
