package gov.ifms.gst.workflow.service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.workflow.dto.*;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;


import java.sql.SQLException;
import java.util.List;

/**
 * The Interface GstWfActionConfigService.
 */
public interface GstWfActionConfigService {

	/**
	 * Gets the next wf actions.
	 *
	 * @param dto the dto
	 * @return the next wf actions
	 * @throws CustomException the custom exception
	 */
	List<GstWfActionConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException;

	/**
	 * Gets the users by wf act config id.
	 *
	 * @param dto the dto
	 * @return the users by wf act config id
	 * @throws CustomException the custom exception
	 */
	List<WfUserDto> getUsersByWfActConfigId(WfActConfUserRequestDto dto) throws CustomException;

	/**
	 * Submit wf act config trn.
	 *
	 * @param dto the dto
	 * @return the list
	 * @throws SQLException the SQL exception
	 * @throws CustomException the custom exception
	 */
	List<WfActionConfigSubmitTrnResDto> submitWfActConfigTrn(WfActionConfigSubmitTrnDto dto) throws SQLException, CustomException;

	/**
	 * Save wf act config trn.
	 *
	 * @param dto the dto
	 * @return the int
	 * @throws CustomException the custom exception
	 */
	int saveWfActConfigTrn(WfUserReqSDDto dto) throws CustomException;
}
