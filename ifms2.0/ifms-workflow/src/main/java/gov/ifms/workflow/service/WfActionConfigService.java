package gov.ifms.workflow.service;

import java.sql.SQLException;
import java.util.List;

import gov.ifms.common.exception.CustomException;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.workflow.dto.*;

import gov.ifms.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.workflow.dto.WfActionConfigSubmitTrnResDto;
import gov.ifms.workflow.dto.WfCurrentTrnStatusDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfRequestReOffConDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.dto.WfUserReqSDDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import gov.ifms.workflow.entity.WfActionConfigEntity;
import gov.ifms.workflow.entity.WfRequestEntity;

public interface WfActionConfigService {

	List<WfActionConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException;

	LkMenuTblInfoEntity getTblInfo(long menuId, Long eventId);

	List<WfUserDto> getUsersByWfActConfigId(WfActConfUserRequestDto dto) throws CustomException;

	List<WfActionConfigSubmitTrnResDto> submitWfActConfigTrn(WfActionConfigSubmitTrnDto dto) throws SQLException;

	List<WfCurrentTrnStatusDto> getCurrentTrnStatus(WfRequestDto dto) throws CustomException;

	int saveWfActConfigTrn(WfUserReqSDDto dto) throws CustomException;

	EDPMsOfficeDto getTrnChildOffice(WfUserReqSDDto dto);

	List<String> getMsWorkflowTrnStatus(Long id, Long officeId);

	List<WfActionConfigEntity> getDefaultSubmitAction(WfRequestDto dto) throws CustomException;

	int defaultSubmitWf(WfRequestDto dto) throws CustomException;

	WfActionConfigSubmitTrnResDto returnToOfficeCon(WfRequestReOffConDto dto) throws CustomException;

	List<MsWorkflowRoleEntity> getWfRlDcoCoCreatorForGrant() throws CustomException;

	List<WfUserDto> getGrantUsersByWfActConfigId(WfGrantUserRequestDto dto) throws CustomException;

	WfRequestEntity genWfRequestNo(WfRequestEntity entity) throws SQLException;

	List<WfActionConfigAsyncSubmitTrnResDto> submitWfBulkIns(TrnSubmitAssignedToDto dto) throws CustomException;

	long getWfReqId(String wfReqNo) throws CustomException;

	String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException;

	void updateWfReqStatus(String wfReqNo,String luName,String luInfoName) throws CustomException;

}
