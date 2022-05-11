package gov.ifms.workflow.service;

import java.sql.SQLException;
import java.util.List;

import gov.ifms.workflow.dto.WfConfigTrnDto;

/**
 * The Interface WfConfigTrnService.
 */
public interface WfConfigTrnService {

	/**
	 * Gets the wf rl cd by rop trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by rop trn id
	 */
	String getWfRlCdByRopTrnId(long trnId);

	/**
	 * Save or update trn edp wf sp.
	 *
	 * @param dto the dto
	 * @return the long
	 */
	Long submitWfConfigTrn(WfConfigTrnDto dto);

	/**
	 * Save or update trn edp wf sp list.
	 *
	 * @param dtos the dtos
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	boolean submitWfConfigTrnList(List<WfConfigTrnDto> dtos) throws SQLException;

	/**
	 * Gets the current user POU id.
	 *
	 * @param dto        the dto
	 * @param isAssignBy the is assign by
	 * @return the current user POU id
	 */
	Long getCurrentUserPOUId(WfConfigTrnDto dto, boolean isAssignBy);

	/**
	 * Sets the POU id.
	 *
	 * @param dto the dto
	 * @return the wf config trn dto
	 */
	WfConfigTrnDto setPOUId(WfConfigTrnDto dto);
}
