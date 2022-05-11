package gov.ifms.loc.workflow.service;

import java.sql.SQLException;
import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.loc.workflow.dto.LocTrnSubmitAssignedToDto;
import gov.ifms.loc.workflow.dto.LocWfActionConfigAsyncSubmitTrnResDto;
import gov.ifms.loc.workflow.dto.WfLoginUserDetDto;
import gov.ifms.loc.workflow.dto.WfUserDto;
import gov.ifms.loc.workflow.dto.WfUserRequestDtoV3;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import gov.ifms.loc.workflow.entity.LocWfRequestEntity;


/**
 * The Interface LocWfActionConfigServiceV3.
 */
public interface LocWfActionConfigServiceV3 {

	/**
	 * Gets the next wf actions.
	 *
	 * @param menuId the menu id
	 * @return the next wf actions
	 * @throws CustomException the custom exception
	 */
	List<LocWfActionConfigEntity> getNextWfActions(long menuId) throws CustomException;

	/**
	 * Gets the users by wf act config id.
	 *
	 * @param dto the dto
	 * @return the users by wf act config id
	 * @throws CustomException the custom exception
	 */
	List<WfUserDto> getUsersByWfActConfigId(WfUserRequestDtoV3 dto) throws CustomException;

	/**
	 * Gen wf request no.
	 *
	 * @param entity the entity
	 * @return the loc wf request entity
	 * @throws SQLException the SQL exception
	 */
	LocWfRequestEntity genWfRequestNo(LocWfRequestEntity entity) throws SQLException;

	/**
	 * Submit wf bulk ins.
	 *
	 * @param dto the dto
	 * @param wfDetFromToken the wf det from token
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	void submitWfBulkIns(LocTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException;

	/**
	 * Gets the wf req id.
	 *
	 * @param wfReqNo the wf req no
	 * @return the wf req id
	 * @throws CustomException the custom exception
	 */
	long getWfReqId(String wfReqNo) throws CustomException;

	/**
	 * Gets the wf req status by wf req no.
	 *
	 * @param wfReqNo the wf req no
	 * @return the wf req status by wf req no
	 * @throws CustomException the custom exception
	 */
	String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException;

	/**
	 * Update wf req status.
	 *
	 * @param wfReqNo the wf req no
	 * @param luName the lu name
	 * @param luInfoName the lu info name
	 * @param wfDetFromToken the wf det from token
	 * @throws CustomException the custom exception
	 */
	void updateWfReqStatus(String wfReqNo,String luName,String luInfoName, WfLoginUserDetDto wfDetFromToken) throws CustomException;

	/**
	 * Submit wf bulk op Loc.
	 *
	 * @param dto the dto
	 * @param wfDetFromToken the wf det from token
	 * @return the future
	 * @throws CustomException the custom exception
	 */
	void submitWfBulkOpLoc(LocTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException;
	

	/**
	 * Gets the submit trn details by wf req no.
	 *
	 * @param wfRequestNo the wf request no
	 * @return the submit trn details by wf req no
	 * @throws CustomException the custom exception
	 */
	List<LocWfActionConfigAsyncSubmitTrnResDto> getSubmitTrnDetailsByWfReqNo(String wfRequestNo) throws CustomException;

}
