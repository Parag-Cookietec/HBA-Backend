package gov.ifms.loc.workflow.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.loc.util.LocDBConstants;
import gov.ifms.loc.workflow.dto.AssignedToTrnDto;
import gov.ifms.loc.workflow.dto.MenuTblInfoDto;
import gov.ifms.loc.workflow.dto.WfActConfUserRequestDto;
import gov.ifms.loc.workflow.dto.WfActionConfigSubmitTrnDto;
import gov.ifms.loc.workflow.dto.WfActionConfigSubmitTrnResDto;
import gov.ifms.loc.workflow.dto.WfActionConfigTrnDto;
import gov.ifms.loc.workflow.dto.WfRequestDto;
import gov.ifms.loc.workflow.dto.WfRlandPrDto;
import gov.ifms.loc.workflow.dto.WfUserDto;
import gov.ifms.loc.workflow.dto.WfUserReqSDDto;
import gov.ifms.loc.workflow.entity.LocWfActionConfigEntity;
import gov.ifms.loc.workflow.repository.LocWfActionConfigRepository;
import gov.ifms.loc.workflow.util.LocQueryConstant;
import gov.ifms.loc.workflow.util.LocWorkFlowConstant;
import gov.ifms.loc.workflow.util.SendBack;

/**
 * The Class LocWfActionConfigServiceImpl.
 */
@Service
public class LocWfActionConfigServiceImpl implements LocWfActionConfigService {

	Logger logger = LoggerFactory.getLogger(LocWfActionConfigServiceImpl.class);

	/**
	 * The repository.
	 */
	@Autowired
	private LocWfActionConfigRepository repository;

	/**
	 * The office repo.
	 */
	@Autowired
	private EDPMsOfficeRepository officeRepo;

	/**
	 * The security util.
	 */
	@Autowired
	private EncryptDecryptUtil securityUtil;

	/** The pou repository. */
	@Autowired
	private EDPLkPoOffUserRepository pouRepository;

	@Override
	public List<LocWfActionConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException {
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getOfficeId());

		Long entryCount;
		int isCoOffice = LocWorkFlowConstant.IS_CO_OFFICE_ZERO;
		int isToOffice = LocWorkFlowConstant.IS_TO_OFFICE_ZERO;
		if (office.getStatusId() == LocWorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == LocWorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS) {
			if ((null != office.getIsCo()) && (office.getIsCo() == LocWorkFlowConstant.LU_YES_LOOKUP_INFO_ID)) {
				isCoOffice = LocWorkFlowConstant.IS_CO_OFFICE_ONE;
			} else if (null != office.getIsTreasury() && (office.getIsTreasury() == EDPConstant.LOOKUP_TRUE || office.getOfficeSubType() == EDPConstant.TREASURY_OFFICE_SUB_TYPE)) {
				isToOffice = LocWorkFlowConstant.IS_TO_OFFICE_ONE;
			}
		}

		AssignedToTrnDto assignedToDto = findActualWfRoleId(dto.getTrnId(), dto.getMenuId(),
				office.getOfficeTypeId().getLookUpInfoId(), dto.getOfficeId(), dto.getLkPOUId(), dto.getBranchId(),
				isToOffice,office.getSubType()==null?null:office.getSubType().getSubTypeId());

		if (dto.getLkPOUId() != null) {
			entryCount = repository.verifyUserWfRole(dto.getMenuId(), assignedToDto.getAssignToWfRoleId(),
					Constant.ACTIVE_STATUS, dto.getLkPOUId());
		} else {
			entryCount = repository.verifyUserWfRole(
					Long.parseLong(securityUtil.decrypt(String.valueOf(dto.getUserId()))), dto.getPostId(),
					dto.getOfficeId(), dto.getMenuId(), assignedToDto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS);
		}

		if (entryCount != null && entryCount == 1) {
			if(office.getSubType()==null){
				return repository.findWorkflowRuleIdAndWfActionsWithSubTypeNull(office.getOfficeTypeId().getLookUpInfoId(),
						assignedToDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID,
						assignedToDto.getAssignToActionLevel(), isCoOffice, LocWorkFlowConstant.DEFAULT_IS_CO, isToOffice,
						LocWorkFlowConstant.DEFAULT_IS_TO, Constant.ACTIVE_STATUS,
						LocWorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP);
			}else{
				return repository.findWorkflowRuleIdAndWfActionsWithSubType(office.getOfficeTypeId().getLookUpInfoId(),
						assignedToDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID,
						assignedToDto.getAssignToActionLevel(), isCoOffice, LocWorkFlowConstant.DEFAULT_IS_CO, isToOffice,
						LocWorkFlowConstant.DEFAULT_IS_TO, Constant.ACTIVE_STATUS,
						LocWorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP,office.getSubType().getSubTypeId());
			}

		} else {
			throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
		}
	}

	/**
	 * Find actual wf role id.
	 *
	 * @param trnId the trn id
	 * @param menuId the menu id
	 * @param officeTypeId the office type id
	 * @param loginOfficeId the login office id
	 * @param pouId the pou id
	 * @param branchId the branch id
	 * @param isToOffice the is to office
	 * @param subTypeId the sub type id
	 * @return the assigned to trn dto
	 * @throws CustomException the custom exception
	 */
	private AssignedToTrnDto findActualWfRoleId(long trnId, long menuId, long officeTypeId,
			long loginOfficeId, Long pouId, Long branchId, int isToOffice,Long subTypeId) throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfo(menuId);
		Optional<AssignedToTrnDto> trnDto = findActualWfRlIdAndLvlV2(menuTblInfoDto.getSchemaName(),
				menuTblInfoDto.getWfTblName(), trnId, loginOfficeId, pouId, branchId);
		if (trnDto.isPresent()) {
			return trnDto.get();
		} else {
			List<WfRlandPrDto> initWfRlAndPr;
			if(subTypeId==null) {
				initWfRlAndPr = repository.findWfInitWfRolesAndPrWithSubTypeNull(menuId, officeTypeId,
						Constant.ACTIVE_STATUS, isToOffice, LocWorkFlowConstant.DEFAULT_IS_TO);
			}else{
				initWfRlAndPr = repository.findWfInitWfRolesAndPrWithSubType(menuId, officeTypeId,subTypeId,
						Constant.ACTIVE_STATUS, isToOffice, LocWorkFlowConstant.DEFAULT_IS_TO);
			}
			long finalInitWfRl = 0;
			if (initWfRlAndPr.isEmpty()) {
				throw new CustomException(ErrorResponse.INIT_WF_RL_IS_NOT_CONFIGURED);
			}
			if (initWfRlAndPr.size() == 1) {
				finalInitWfRl = initWfRlAndPr.get(0).getWfRoleId();
			} else {
				List<Long> userWfRl = repository.getUserWfRole(menuId, pouId, Constant.ACTIVE_STATUS);
				if (userWfRl.isEmpty()) {
					throw new CustomException(ErrorResponse.WF_RL_IS_NOT_ASSIGNED);
				}
				Optional<WfRlandPrDto> finalInitWfRlObj;
				if (userWfRl.size() == 1) {
					finalInitWfRlObj = initWfRlAndPr.stream()
							.filter(obj -> obj.getWfRoleId().equals(userWfRl.get(0))).findFirst();
				} else {
					finalInitWfRlObj = initWfRlAndPr.stream()
							.filter(wfRlAndPrDto -> userWfRl.contains(wfRlAndPrDto.getWfRoleId()))
							.max(Comparator.comparing(WfRlandPrDto::getPriority));
				}
				if (finalInitWfRlObj.isPresent()) {
					finalInitWfRl = finalInitWfRlObj.get().getWfRoleId();
				}
			}
			return new AssignedToTrnDto(finalInitWfRl, LocWorkFlowConstant.DEFAULT_WF_ACTION_LEVEL,
					branchId == null ? 0 : branchId);
		}
	}

	public MenuTblInfoDto getTblInfo(long menuId) throws CustomException {
		return repository.executeSQLQuerySingle(LocQueryConstant.getMenuTblInfoFromMenuIdQrStr(),
				LocQueryConstant.getMenuTblInfoFromMenuIdQrMap(menuId), MenuTblInfoDto.class);
	}

	public MenuTblInfoDto getTblInfoByWfActionConfigId(long wfActionConfigId) throws CustomException {
		return repository.executeSQLQuerySingle(LocQueryConstant.getMenuTblInfoFromLocWfActionConfigIdQrStr(),
				LocQueryConstant.getMenuTblInfoFromLocWfActionConfigIdQrMap(wfActionConfigId), MenuTblInfoDto.class);
	}

	@Override
	public List<WfUserDto> getUsersByWfActConfigId(WfActConfUserRequestDto dto) throws CustomException {
		LocWfActionConfigEntity wfActConf = repository.findByActionConfigIdAndActiveStatus(dto.getWfActionConfigId(),
				Constant.ACTIVE_STATUS);
		if (wfActConf != null) {
			if (wfActConf.getSendBackFlag() == SendBack.DEFUALT.getValue()) {
				return getUsersForForwardWf(dto, wfActConf);
			} else if (wfActConf.getSendBackFlag() == SendBack.PRIVIOUS.getValue()) {
				return getUsersForPreviousWf(dto, wfActConf);
			} else if (wfActConf.getSendBackFlag() == SendBack.REWORK.getValue()) {
				return getUsersForReworkWf(dto, wfActConf);
			} else if (wfActConf.getSendBackFlag() == SendBack.RETURN_INITIATOR.getValue()) {
				return getUsersForInitiateWf(dto, wfActConf);
			}
		} else {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.WORKFLOW_ACTION_CONFIG_NOTVALID);
		}
		return Collections.emptyList();
	}

	public List<WfUserDto> getUsersForInitiateWf(WfActConfUserRequestDto dto, LocWfActionConfigEntity wfActConf)
			throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfo(wfActConf.getEdpMsMenuEntity().getMenuId());
		return repository
				.executeSQLQuery(
						LocQueryConstant.getUserForInitiatorWfQrString(menuTblInfoDto.getSchemaName(),
								menuTblInfoDto.getWfTblName(), wfActConf),
						LocQueryConstant.getUserForInitiatorWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	@Override
	public List<WfActionConfigSubmitTrnResDto> submitWfActConfigTrn(WfActionConfigSubmitTrnDto dto)
			throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfoByWfActionConfigId(dto.getWfDetails().get(0).getActionConfigId());
		repository.executeNativeUpdateSQLQuery(
				LocQueryConstant.updateActStsForWfTrnQrString(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName()),
				LocQueryConstant.updateActStsForWfTrnQrParamMap(dto.getWfDetails().get(0).getTrnId()));
		List<WfActionConfigSubmitTrnResDto> resDtoList = new ArrayList<>();
		dto.getWfDetails().forEach(wf -> {
			LocWfActionConfigEntity wfActConf = repository.findByActionConfigIdAndActiveStatus(wf.getActionConfigId(),
					Constant.ACTIVE_STATUS);
			Long wfId = repository.callWfSPLong(LocQueryConstant.getWfTrnSubmitSpQueryString(),
					LocQueryConstant.getWfTrnSubmitSpQueryMap(wf, wfActConf, decryptUserId(wf.getAssignedTo().getUserId()),
							decryptUserId(wf.getAssignedBy().getUserId())));
			try {
				resDtoList.add(repository.executeSQLQuerySingle(
						LocQueryConstant.getInsTrnDetailsQrStringQrString(menuTblInfoDto.getSchemaName(),
								menuTblInfoDto.getWfTblName()),
						LocQueryConstant.getInsTrnDetailsQrStringQrParamMap(wfId), WfActionConfigSubmitTrnResDto.class));
			} catch (CustomException e) {
				e.printStackTrace();
			}
		});
		if (resDtoList.size() == 1) {
			if (!StringUtils.isEmpty(menuTblInfoDto.getWfAttTblName())) {
				repository.executeNativeUpdateSQLQuery(
						LocQueryConstant.updateTrnAttachQrStr(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfAttTblName()),
						LocQueryConstant.updateTrnAttachQrParamMap(resDtoList.get(0).getWfId(),
								dto.getWfDetails().get(0).getAssignedBy().getWfRoleId(), resDtoList.get(0).getTrnId()));
			}
			WfActionConfigTrnDto submitDto = dto.getWfDetails().get(0);
			if (!StringUtils.isEmpty(menuTblInfoDto.getWfMoveTblName())
					&& !StringUtils.isEmpty(menuTblInfoDto.getWfLayTblName() != null)) {
				repository.callWfStoredProcedure(
						LocDBConstants.LOC_SCHEMA.concat(Constant.DOT.concat(LocWorkFlowConstant.SP_LOC_WF_TRN_MV_LY_SUBMIT)),
						LocQueryConstant.getWfTrnMvLySpQueryMap(submitDto, resDtoList.get(0).getWfId(),
								decryptUserId(submitDto.getAssignedTo().getUserId()),
								decryptUserId(submitDto.getAssignedBy().getUserId()), menuTblInfoDto.getSchemaName(),
								menuTblInfoDto.getWfMoveTblName(), menuTblInfoDto.getWfLayTblName()));
			}
		}
		return resDtoList;
	}

	@Override
	public int saveWfActConfigTrn(WfUserReqSDDto dto) throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfo(dto.getMenuId());
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getOfficeId());
		Optional<AssignedToTrnDto> assignedToDtoOp = findActualWfRlIdAndLvlV2(menuTblInfoDto.getSchemaName(),
				menuTblInfoDto.getWfTblName(), dto.getTrnId(), dto.getOfficeId(), dto.getPouId(), dto.getBranchId());
		long pouId;
		int isToOffice = LocWorkFlowConstant.IS_TO_OFFICE_ZERO;
		if (office.getStatusId() == LocWorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == LocWorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS && null != office.getIsTreasury() && (office.getIsTreasury() == EDPConstant.LOOKUP_TRUE || office.getOfficeSubType() == EDPConstant.TREASURY_OFFICE_SUB_TYPE)) {
			isToOffice = LocWorkFlowConstant.IS_TO_OFFICE_ONE;
		}
		AssignedToTrnDto atDto = findActualWfRoleId(dto.getTrnId(), dto.getMenuId(),
				office.getOfficeTypeId().getLookUpInfoId(), dto.getOfficeId(), dto.getPouId(), dto.getBranchId(),
				isToOffice,office.getSubType()==null?null:office.getSubType().getSubTypeId());
		if (assignedToDtoOp.isPresent()) {
			pouId = assignedToDtoOp.get().getAssignToPouId();
			if (pouId == dto.getPouId() || pouId == 0) {
				repository.executeNativeUpdateSQLQuery(
						LocQueryConstant.updateActStsForWfTrnQrString(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName()),
						LocQueryConstant.updateActStsForWfTrnQrParamMap(dto.getTrnId()));
				dto.setUserId(decryptUserId(dto.getUserId()));
				return repository.executeNativeUpdateSQLQuery(
						LocQueryConstant.updateAssignToTrnQrString(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName()),
						LocQueryConstant.updateAssignToTrnQrParamMap(dto, assignedToDtoOp.get()));
			} else {
				Optional<EDPLkPoOffUserEntity> pouEntity = pouRepository.findById(pouId);
				StringBuilder errMsg = new StringBuilder();
				if (pouEntity.isPresent()) {
					errMsg.append(pouEntity.get().getUserId().getUserName());
					errMsg.append(" is working on this transaction reference.");
				} else {
					errMsg.append("Another user is working on this transaction reference.");
				}
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, errMsg.toString());
			}
		} else {
			dto.setUserId(decryptUserId(dto.getUserId()));
			return repository.executeNativeUpdateSQLQuery(
					LocQueryConstant.insTrnSaveQrStr(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName()),
					LocQueryConstant.insTrnSaveQrParamMap(dto, atDto));
		}
	}

	public List<WfUserDto> getUsersForForwardWf(WfActConfUserRequestDto dto, LocWfActionConfigEntity wfActConf) {
		if (wfActConf.getToBranchTypeId() != null) {
			return repository
					.findUserByNextWfRoleAndBTId(
							dto.getOfficeId(), wfActConf.getTargetMenuId()==null?dto.getMenuId():wfActConf.getTargetMenuId(), wfActConf
									.getToWorkFlowRoleId(),
							wfActConf.getToBranchTypeId(), Constant.ACTIVE_STATUS)
					.stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == dto.getPouId()
							&& wfUserDto.getWfRoleId().equals(wfActConf.getFromWfRoleId())))
					.collect(Collectors.toList());
		} else {
			return repository
					.findUserByNextWfRole(
							dto.getOfficeId(),wfActConf.getTargetMenuId()==null?dto.getMenuId():wfActConf.getTargetMenuId(), wfActConf.getToWorkFlowRoleId(), Constant.ACTIVE_STATUS)
					.stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == dto.getPouId()
							&& wfUserDto.getWfRoleId().equals(wfActConf.getFromWfRoleId())))
					.collect(Collectors.toList());
		}

	}

	public Optional<AssignedToTrnDto> findActualWfRlIdAndLvlV2(String schemaName, String tblName, Long trnId,
			long loginOfficeId, Long pouId, Long branchId) throws CustomException {
		List<AssignedToTrnDto> assignedToList = repository.executeSQLQuery(
				LocQueryConstant.getActualWfRoleIdWithAssignBy(schemaName, tblName),
				LocQueryConstant.getActTrnQrParamMap(trnId), AssignedToTrnDto.class);
		if (assignedToList.size() > 1) {
			if (branchId != null) {
				Long userWithBranchCount = repository.verifyUserBranch(pouId, branchId, Constant.ACTIVE_STATUS);
				if (userWithBranchCount != null && userWithBranchCount > 0) {
					return assignedToList.stream().filter(
							at -> (at.getAssignToOfficeId() == loginOfficeId && at.getAssignToBranchId() == branchId))
							.findFirst();
				} else {
					return assignedToList.stream()
							.filter(at -> at.getAssignToOfficeId() == loginOfficeId && at.getAssignToBranchId() == 0L)
							.findFirst();
				}
			} else {
				return assignedToList.stream()
						.filter(at -> at.getAssignToOfficeId() == loginOfficeId && at.getAssignToBranchId() == 0L)
						.findFirst();
			}
		} else {
			if (!assignedToList.isEmpty()) {
				return Optional.ofNullable(assignedToList.get(0));
			} else {
				return Optional.empty();
			}
		}
	}

	public List<WfUserDto> getUsersForPreviousWf(WfActConfUserRequestDto dto, LocWfActionConfigEntity wfActConf)
			throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfo(wfActConf.getEdpMsMenuEntity().getMenuId());
		return repository.executeSQLQuery(
				LocQueryConstant.getUserForPrevWfQrString(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName()),
				LocQueryConstant.getUserForPrevWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	public List<WfUserDto> getUsersForReworkWf(WfActConfUserRequestDto dto, LocWfActionConfigEntity wfActConf)
			throws CustomException {
		MenuTblInfoDto menuTblInfoDto = getTblInfo(wfActConf.getEdpMsMenuEntity().getMenuId());
		return repository
				.executeSQLQuery(
						LocQueryConstant.getUserForReworkWfQrString(menuTblInfoDto.getSchemaName(), menuTblInfoDto.getWfTblName(),
								wfActConf),
						LocQueryConstant.getUserForReworkWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	/**
	 * Decrypt user id.
	 *
	 * @param userId the user id
	 * @return the long
	 */
	private Long decryptUserId(Object userId) {
		if (userId instanceof Integer || userId instanceof Long) {
			return Long.valueOf(String.valueOf(userId));
		} else if (userId instanceof String) {
			return Long.parseLong(securityUtil.decrypt(String.valueOf(userId)));
		} else {
			return null;
		}
	}
}
