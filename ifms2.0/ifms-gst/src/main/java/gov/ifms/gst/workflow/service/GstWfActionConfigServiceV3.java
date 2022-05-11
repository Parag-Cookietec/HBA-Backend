package gov.ifms.gst.workflow.service;

import java.sql.SQLException;
import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.gst.workflow.dto.GstTrnSubmitAssignedToDto;
import gov.ifms.gst.workflow.dto.GstWfActionConfigAsyncSubmitTrnResDto;
import gov.ifms.gst.workflow.dto.WfLoginUserDetDto;
import gov.ifms.gst.workflow.dto.WfUserDto;
import gov.ifms.gst.workflow.dto.WfUserRequestDtoV3;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;
import gov.ifms.gst.workflow.entity.GstWfRequestEntity;


/**
 * The Interface GstWfActionConfigServiceV3.
 */
public interface GstWfActionConfigServiceV3 {

	/**
	 * Gets the next wf actions.
	 *
	 * @param menuId the menu id
	 * @return the next wf actions
	 * @throws CustomException the custom exception
	 */
	List<GstWfActionConfigEntity> getNextWfActions(long menuId) throws CustomException;

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
	 * @return the gst wf request entity
	 * @throws SQLException the SQL exception
	 */
	GstWfRequestEntity genWfRequestNo(GstWfRequestEntity entity) throws SQLException;

	/**
	 * Submit wf bulk ins.
	 *
	 * @param dto the dto
	 * @param wfDetFromToken the wf det from token
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	void submitWfBulkIns(GstTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException;

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
	 * Submit wf bulk op Gst.
	 *
	 * @param dto the dto
	 * @param wfDetFromToken the wf det from token
	 * @return the future
	 * @throws CustomException the custom exception
	 */
	void submitWfBulkOpGst(GstTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException;
	

	/**
	 * Gets the submit trn details by wf req no.
	 *
	 * @param wfRequestNo the wf request no
	 * @return the submit trn details by wf req no
	 * @throws CustomException the custom exception
	 */
List<GstWfActionConfigAsyncSubmitTrnResDto> getSubmitTrnDetailsByWfReqNo(String wfRequestNo) throws CustomException;

}
