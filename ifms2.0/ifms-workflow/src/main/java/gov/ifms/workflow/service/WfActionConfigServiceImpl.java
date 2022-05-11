package gov.ifms.workflow.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import gov.ifms.workflow.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsBranchRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.workflow.converter.WfActionConfigConverter;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import gov.ifms.workflow.entity.WfActionConfigEntity;
import gov.ifms.workflow.entity.WfRequestEntity;
import gov.ifms.workflow.repository.LkMenuTblInfoRepository;
import gov.ifms.workflow.repository.MsWorkflowRoleRepository;
import gov.ifms.workflow.repository.WfActionConfigRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.repository.WfRequestRepository;
import gov.ifms.workflow.util.QueryConstant;
import gov.ifms.workflow.util.SendBack;
import gov.ifms.workflow.util.WorkFlowConstant;

@Service
public class WfActionConfigServiceImpl implements WfActionConfigService {

	Logger logger = LoggerFactory.getLogger(WfActionConfigServiceImpl.class);

	private static final String WF_REQ_NOT_VALID = "Workflow Request No. %s is not valid!";

	/**
	 * The repository.
	 */
	@Autowired
	private WfActionConfigRepository repository;

	/**
	 * The office repo.
	 */
	@Autowired
	private EDPMsOfficeRepository officeRepo;

	/**
	 * The tbl info repo.
	 */
	@Autowired
	private LkMenuTblInfoRepository tblInfoRepo;

	/**
	 *
	 */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/**
	 * The security util.
	 */
	@Autowired
	private EncryptDecryptUtil securityUtil;

	@Autowired
	private WfRepository wfRepo;

	@Autowired
	private EDPMsBranchRepository branchRepository;
	/**
	 * The MsWorkflowRoleRepository.
	 */
	@Autowired
	private MsWorkflowRoleRepository wfRlRepo;

	@Autowired
	private WfActionConfigConverter wfActionConfigConverter;

	@Autowired
	private EDPLkPoOffUserRepository pouRepository;

	@Autowired
	private WfRequestRepository wfReqRepo;

	@Override
	public List<WfActionConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException {
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getOfficeId());
		EDPMsBranchEntity branch = null;

		Long entryCount = null;
		int isCoOffice = WorkFlowConstant.IS_CO_OFFICE_ZERO;
		int isFdOffice = WorkFlowConstant.IS_FD_OFFICE_ZERO;
		if (office.getStatusId() == WorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == WorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS) {
			if ((null != office.getIsCo()) && (office.getIsCo() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID)) {
				isCoOffice = WorkFlowConstant.IS_CO_OFFICE_ONE;
			} else if ((null != office.getIsFd()) && (office.getIsFd() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID)) {
				isFdOffice = WorkFlowConstant.IS_CO_OFFICE_ONE;
			}
		}

		AssignedToTrnDto assignedToDto = findActualWfRoleId(dto.getTrnId(), dto.getMenuId(), dto.getEventId(),
				office.getOfficeTypeId().getLookUpInfoId(), dto.getOfficeId(), dto.getLkPOUId(), dto.getBranchId(),
				isFdOffice);

		if (dto.getLkPOUId() != null) {
			entryCount = repository.verifyUserWfRole(dto.getMenuId(), assignedToDto.getAssignToWfRoleId(),
					Constant.ACTIVE_STATUS, dto.getLkPOUId());
		} else {
			entryCount = repository.verifyUserWfRole(
					Long.parseLong(securityUtil.decrypt(String.valueOf(dto.getUserId()))), dto.getPostId(),
					dto.getOfficeId(), dto.getMenuId(), assignedToDto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS);
		}
		if (assignedToDto.getAssignToBranchId() != 0) {
			branch = branchRepository.findByBranchIdAndActiveStatus(assignedToDto.getAssignToBranchId(),
					Constant.ACTIVE_STATUS);
			long userCount = repository.verifyUserBranch(dto.getLkPOUId(), assignedToDto.getAssignToBranchId(),
					Constant.ACTIVE_STATUS);
			entryCount = entryCount & userCount;
		}
		if (entryCount != null && entryCount == 1) {
			if (branch == null) {
				return repository.findWorkflowRuleIdAndWfActions(office.getOfficeTypeId().getLookUpInfoId(),
						assignedToDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID,
						assignedToDto.getAssignToActionLevel(), isCoOffice, WorkFlowConstant.DEFAULT_IS_CO, isFdOffice,
						WorkFlowConstant.DEFAULT_IS_FD, Constant.ACTIVE_STATUS,
						WorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP);
			} else {
				return repository.findWorkflowRuleIdAndWfActionsAndBrId(office.getOfficeTypeId().getLookUpInfoId(),
						assignedToDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID,
						assignedToDto.getAssignToActionLevel(), branch.getBranchTypeId().getLookUpInfoId(), isCoOffice,
						WorkFlowConstant.DEFAULT_IS_CO, isFdOffice, WorkFlowConstant.DEFAULT_IS_FD,
						Constant.ACTIVE_STATUS, WorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP);
			}
		} else {
			throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
		}
	}

	private AssignedToTrnDto findActualWfRoleId(long trnId, long menuId, Long eventId, long officeTypeId,
			long loginOfficeId, Long pouId, Long branchId, int isFdOffice) throws CustomException {
		LkMenuTblInfoEntity lkMenuTblInfoEntity = getTblInfo(menuId, eventId);
		Optional<AssignedToTrnDto> trnDto = findActualWfRlIdAndLvlV2(lkMenuTblInfoEntity.getSchemaName(),
				lkMenuTblInfoEntity.getTrnWfTblName(), trnId, loginOfficeId, pouId, branchId);
		if (trnDto.isPresent()) {
			return trnDto.get();
		} else {
			List<WfRlandPrDto> initWfRlAndPr = repository.findWfInitWfRolesAndPr(menuId, officeTypeId,
					Constant.ACTIVE_STATUS, isFdOffice, WorkFlowConstant.DEFAULT_IS_FD);
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
				if (userWfRl.size() == 1) {
					Optional<WfRlandPrDto> finalInitWfRlObj = initWfRlAndPr.stream()
							.filter(obj -> obj.getWfRoleId().equals(userWfRl.get(0))).findFirst();
					if (finalInitWfRlObj.isPresent()) {
						finalInitWfRl = finalInitWfRlObj.get().getWfRoleId();
					}
				} else {
					Optional<WfRlandPrDto> finalInitWfRlObj = initWfRlAndPr.stream()
							.filter(wfRlandPrDto -> userWfRl.contains(wfRlandPrDto.getWfRoleId()))
							.max(Comparator.comparing(WfRlandPrDto::getPriority));
					if (finalInitWfRlObj.isPresent()) {
						finalInitWfRl = finalInitWfRlObj.get().getWfRoleId();
					}
				}
			}
			return new AssignedToTrnDto(finalInitWfRl, WorkFlowConstant.DEFAULT_WF_ACTION_LEVEL,
					branchId == null ? 0 : branchId);
		}
	}

	@Override
	public LkMenuTblInfoEntity getTblInfo(long menuId, Long eventId) {
		LkMenuTblInfoEntity lkMenuTblInfoEntity = null;
		if (eventId != null) {
			lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventId(menuId, Constant.ACTIVE_STATUS,
					eventId);
		} else {
			lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(menuId,
					Constant.ACTIVE_STATUS);
		}
		return lkMenuTblInfoEntity;
	}

	@Override
	public List<WfUserDto> getUsersByWfActConfigId(WfActConfUserRequestDto dto) throws CustomException {
		logger.info("Get workflow users API Start...");
		Instant start = Instant.now();
		List<WfUserDto> userList;
		WfActionConfigEntity wfActConf = repository.findByActionconfigIdAndActiveStatus(dto.getWfActionConfigId(),
				Constant.ACTIVE_STATUS);
		if (wfActConf != null) {
			if (wfActConf.getSendBackFlag() == SendBack.DEFUALT.getValue()) {
				userList = getUsersForForwardWf(dto, wfActConf);
				Instant end = Instant.now();
				logger.info("Get workflow users API End...");
				logger.info("Execution time of fetch operation is {} ms", Duration.between(start,end).toMillis());
				return userList;
			} else if (wfActConf.getSendBackFlag() == SendBack.PRIVIOUS.getValue()) {
				userList = getUsersForPreviousWf(dto, wfActConf);
				Instant end = Instant.now();
				logger.info("Get workflow users API End...");
				logger.info("Execution time of fetch operation is {} ms", Duration.between(start,end).toMillis());
				return userList;
			} else if (wfActConf.getSendBackFlag() == SendBack.REWORK.getValue()) {
				userList = getUsersForReworkWf(dto, wfActConf);
				Instant end = Instant.now();
				logger.info("Get workflow users API End...");
				logger.info("Execution time of fetch operation is {} ms", Duration.between(start,end).toMillis());
				return userList;
			} else if (wfActConf.getSendBackFlag() == SendBack.RETURN_INITIATOR.getValue()) {
				userList = getUsersForInitiateWf(dto, wfActConf);
				Instant end = Instant.now();
				logger.info("Get workflow users API End...");
				logger.info("Execution time of fetch operation is {} ms", Duration.between(start,end).toMillis());
				return userList;
			}
		} else {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.WORKFLOW_ACTION_CONFIG_NOTVALID);
		}
		return Collections.emptyList();
	}

	public List<WfUserDto> getUsersForInitiateWf(WfActConfUserRequestDto dto, WfActionConfigEntity wfActConf)
			throws CustomException {
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo.getTableAndSchemaByWfActConfig(wfActConf.getActionconfigId(),
				Constant.ACTIVE_STATUS);
		return wfRepo
				.executeSQLQuery(
						QueryConstant.getUserForInitiatorWfQrString(tblOfTbl.getSchemaName(),
								tblOfTbl.getTrnWfTblName(), wfActConf),
						QueryConstant.getUserForInitiatorWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	@Override
	public List<WfActionConfigSubmitTrnResDto> submitWfActConfigTrn(WfActionConfigSubmitTrnDto dto)
			throws SQLException {
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo
				.getTableAndSchemaByWfActConfig(dto.getWfDetails().get(0).getActionConfigId(), Constant.ACTIVE_STATUS);
		wfRepo.executeNativeUpdateSQLQuery(
				QueryConstant.updateActStsForWfTrnQrString(tblOfTbl.getSchemaName(), tblOfTbl.getTrnWfTblName()),
				QueryConstant.updateActStsForWfTrnQrParamMap(dto.getWfDetails().get(0).getTrnId()));
		List<WfActionConfigSubmitTrnResDto> resDtoList = new ArrayList<>();
		dto.getWfDetails().forEach(wf -> {
			WfActionConfigEntity wfActConf = repository.findByActionconfigIdAndActiveStatus(wf.getActionConfigId(),
					Constant.ACTIVE_STATUS);
			Long wfId = wfRepo.callWfSPLong(QueryConstant.getWfTrnSubmitSpQueryString(),
					QueryConstant.getWfTrnSubmitSpQueryMap(wf, wfActConf, decryptUserId(wf.getAssignedTo().getUserId()),
							decryptUserId(wf.getAssignedBy().getUserId())));
			try {
				resDtoList.add(wfRepo.executeSQLQuerySingle(
						QueryConstant.getInsTrnDetailsQrStringQrString(tblOfTbl.getSchemaName(),
								tblOfTbl.getTrnWfTblName()),
						QueryConstant.getInsTrnDetailsQrStringQrParamMap(wfId), WfActionConfigSubmitTrnResDto.class));
			} catch (CustomException e) {
				e.printStackTrace();
			}
		});
		if (resDtoList.size() == 1) {
			if (!StringUtils.isEmpty(tblOfTbl.getAttachTblName())) {
				wfRepo.executeNativeUpdateSQLQuery(
						QueryConstant.updateTrnAttachQrStr(tblOfTbl.getSchemaName(), tblOfTbl.getAttachTblName()),
						QueryConstant.updateTrnAttachQrParamMap(resDtoList.get(0).getWfId(),
								dto.getWfDetails().get(0).getAssignedBy().getWfRoleId(), resDtoList.get(0).getTrnId()));
			}
			WfActionConfigTrnDto submitDto = dto.getWfDetails().get(0);
			if (!StringUtils.isEmpty(tblOfTbl.getMoveTblName())
					&& !StringUtils.isEmpty(tblOfTbl.getLayTblName() != null)) {
				wfRepo.callWfStoredProcedure(
						Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_WF_TRN_MV_LY_SUBMIT)),
						QueryConstant.getWfTrnMvLySpQueryMap(submitDto, resDtoList.get(0).getWfId(),
								decryptUserId(submitDto.getAssignedTo().getUserId()),
								decryptUserId(submitDto.getAssignedBy().getUserId()), tblOfTbl.getSchemaName(),
								tblOfTbl.getMoveTblName(), tblOfTbl.getLayTblName()));
			}
		} else if (resDtoList.size() >= 1) {
			Optional<WfActionConfigTrnDto> wfTrnEntity = dto.getWfDetails().stream()
					.filter(wf -> !wf.getAssignedBy().getWfRoleId().equals(wf.getAssignedTo().getWfRoleId()))
					.findFirst();
			if (wfTrnEntity.isPresent()) {
				WfActionConfigTrnDto submitDto = wfTrnEntity.get();
				long actionConfigId = submitDto.getActionConfigId();
				Optional<WfActionConfigSubmitTrnResDto> tmpResDto = resDtoList.stream()
						.filter(res -> res.getActionConfigId() == actionConfigId).findFirst();
				if (tmpResDto.isPresent() && tblOfTbl.getAttachTblName() != null) {
					wfRepo.executeNativeUpdateSQLQuery(
							QueryConstant.updateTrnAttachQrStr(tblOfTbl.getSchemaName(), tblOfTbl.getAttachTblName()),
							QueryConstant.updateTrnAttachQrParamMap(tmpResDto.get().getWfId(),
									wfTrnEntity.get().getAssignedBy().getWfRoleId(), tmpResDto.get().getTrnId()));
				}
				if (tmpResDto.isPresent() && tblOfTbl.getMoveTblName() != null && tblOfTbl.getLayTblName() != null) {
					wfRepo.callWfStoredProcedure(
							Constant.WORKFLOW_SCHEMA
									.concat(Constant.DOT.concat(WorkFlowConstant.SP_WF_TRN_MV_LY_SUBMIT)),
							QueryConstant.getWfTrnMvLySpQueryMap(submitDto, tmpResDto.get().getWfId(),
									decryptUserId(submitDto.getAssignedTo().getUserId()),
									decryptUserId(submitDto.getAssignedBy().getUserId()), tblOfTbl.getSchemaName(),
									tblOfTbl.getMoveTblName(), tblOfTbl.getLayTblName()));
				}
			}
		}
		return resDtoList;
	}

	@Override
	public List<WfCurrentTrnStatusDto> getCurrentTrnStatus(WfRequestDto dto) throws CustomException {
		LkMenuTblInfoEntity tblInfo = this.getTblInfo(dto.getMenuId(), dto.getEventId());
		Map<String, Object> map = new HashMap<>();
		map.put(WorkFlowConstant.TRN_ID, dto.getTrnId());
		List<Object[]> objects = wfRepo.executeSQLQuery(QueryConstant.getCurrentTrnStatus(tblInfo), map);
		if (!Utils.isEmpty(objects)) {
			return NativeQueryResultsMapper.map(objects, WfCurrentTrnStatusDto.class);
		}
		return Collections.emptyList();
	}

	public List<WfUserDto> getUsersForForwardWf(WfActConfUserRequestDto dto, WfActionConfigEntity wfActConf) throws CustomException{
		if (wfActConf.getToBranchTypeId() != null) {
			Set<Object[]> userListDto = repository
					.findUserByNextWfRoleAndBTId(
							dto.getOfficeId(), dto.getMenuId(), wfActConf
									.getToWorkFlowRoleId(),
							wfActConf.getToBranchTypeId(), Constant.ACTIVE_STATUS);
			return NativeQueryResultsMapper.map(userListDto.stream().collect(Collectors.toList()), WfUserDto.class).stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == dto.getPouId()
					&& wfUserDto.getWfRoleId() == wfActConf.getFromWorkFlowRoleEntity().getWfRoleId()))
					.collect(Collectors.toList());
		} else {
			Set<Object[]> userListDto = repository
					.findUserByNextWfRole(
							dto.getOfficeId(), dto.getMenuId(), wfActConf.getToWorkFlowRoleId(), Constant.ACTIVE_STATUS);
			return NativeQueryResultsMapper.map(userListDto.stream().collect(Collectors.toList()), WfUserDto.class).stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == dto.getPouId()
							&& wfUserDto.getWfRoleId() == wfActConf.getFromWorkFlowRoleEntity().getWfRoleId()))
					.collect(Collectors.toList());
		}

	}

	public Optional<AssignedToTrnDto> findActualWfRlIdAndLvlV2(String schemaName, String tblName, Long trnId,
			long loginOfficeId, Long pouId, Long branchId) throws CustomException {
		List<AssignedToTrnDto> assignedToList = wfRepo.executeSQLQuery(
				QueryConstant.getActualWfRoleIdWithAssignBy(schemaName, tblName),
				QueryConstant.getActTrnQrParamMap(trnId), AssignedToTrnDto.class);
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

	public List<WfUserDto> getUsersForPreviousWf(WfActConfUserRequestDto dto, WfActionConfigEntity wfActConf)
			throws CustomException {
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo.getTableAndSchemaByWfActConfig(wfActConf.getActionconfigId(),
				Constant.ACTIVE_STATUS);
		return wfRepo.executeSQLQuery(
				QueryConstant.getUserForPrevWfQrString(tblOfTbl.getSchemaName(), tblOfTbl.getTrnWfTblName()),
				QueryConstant.getUserForPrevWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	public List<WfUserDto> getUsersForReworkWf(WfActConfUserRequestDto dto, WfActionConfigEntity wfActConf)
			throws CustomException {
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo.getTableAndSchemaByWfActConfig(wfActConf.getActionconfigId(),
				Constant.ACTIVE_STATUS);
		return wfRepo
				.executeSQLQuery(
						QueryConstant.getUserForReworkWfQrString(tblOfTbl.getSchemaName(), tblOfTbl.getTrnWfTblName(),
								wfActConf),
						QueryConstant.getUserForReworkWfQrParamMap(dto, wfActConf), WfUserDto.class);
	}

	@Override
	public int saveWfActConfigTrn(WfUserReqSDDto dto) throws CustomException {
		LkMenuTblInfoEntity tblInfo = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),
				Constant.ACTIVE_STATUS);
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getOfficeId());
		Optional<AssignedToTrnDto> assignedToDtoOp = findActualWfRlIdAndLvlV2(tblInfo.getSchemaName(),
				tblInfo.getTrnWfTblName(), dto.getTrnId(), dto.getOfficeId(), dto.getPouId(), dto.getBranchId());
		long pouId;
		int isFdOffice = WorkFlowConstant.IS_FD_OFFICE_ZERO;
		if (office.getStatusId() == WorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == WorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS && null != office.getIsFd()
				&& office.getIsFd() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID) {
			isFdOffice = WorkFlowConstant.IS_FD_OFFICE_ONE;
		}
		AssignedToTrnDto atDto = findActualWfRoleId(dto.getTrnId(), dto.getMenuId(), null,
				office.getOfficeTypeId().getLookUpInfoId(), dto.getOfficeId(), dto.getPouId(), dto.getBranchId(),
				isFdOffice);
		if (assignedToDtoOp.isPresent()) {
			pouId = assignedToDtoOp.get().getAssignToPouId();
			if (pouId == dto.getPouId() || pouId == 0) {
				wfRepo.executeNativeUpdateSQLQuery(
						QueryConstant.updateActStsForWfTrnQrString(tblInfo.getSchemaName(), tblInfo.getTrnWfTblName()),
						QueryConstant.updateActStsForWfTrnQrParamMap(dto.getTrnId()));
				dto.setUserId(decryptUserId(dto.getUserId()));
				return wfRepo.executeNativeUpdateSQLQuery(
						QueryConstant.updateAssignToTrnQrString(tblInfo.getSchemaName(), tblInfo.getTrnWfTblName()),
						QueryConstant.updateAssignToTrnQrParamMap(dto, assignedToDtoOp.get()));
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
			return wfRepo.executeNativeUpdateSQLQuery(
					QueryConstant.insTrnSaveQrStr(tblInfo.getSchemaName(), tblInfo.getTrnWfTblName()),
					QueryConstant.insTrnSaveQrParamMap(dto, atDto));
		}
	}

	@Override
	public EDPMsOfficeDto getTrnChildOffice(WfUserReqSDDto dto) {
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),
				Constant.ACTIVE_STATUS);
		Object[] object = wfRepo.executeNativeSQLQuerySingleResult(
				QueryConstant.getChildOfficeQrStr(tblOfTbl.getSchemaName(), tblOfTbl.getTrnWfTblName()),
				QueryConstant.getChildOfficeQrStr(dto));
		return new EDPMsOfficeDto(Long.parseLong(object[0].toString()), object[1].toString());
	}

	private Long decryptUserId(Object userId) {
		if (userId instanceof Integer || userId instanceof Long) {
			return Long.valueOf(String.valueOf(userId));
		} else if (userId instanceof String) {
			return Long.parseLong(securityUtil.decrypt(String.valueOf(userId)));
		} else {
			return null;
		}
	}

	 /**
     * Getting transaction status based on menu or office id
     */
    	@Override
    	public List<String> getMsWorkflowTrnStatus(Long id, Long officeId) {
    		if(Objects.isNull(officeId)) {
    			return   repository.findStatusbyMenu( id, Constant.ACTIVE_STATUS);
    		}   else {
    		EDPMsOfficeEntity office = officeRepo.getOne(officeId);
    		return   repository.findbyMenuandOffice(office.getOfficeTypeId().getLookUpInfoId(), id, Constant.ACTIVE_STATUS);
    		}

    	}


	@Override
	public List<WfActionConfigEntity> getDefaultSubmitAction(WfRequestDto dto) throws CustomException {
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getOfficeId());
		int isCoOffice = WorkFlowConstant.IS_CO_OFFICE_ZERO;
		int isFdOffice = WorkFlowConstant.IS_FD_OFFICE_ZERO;
		if (null != office.getStatusId() && office.getStatusId() == WorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == WorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS) {
			if (null != office.getIsCo() && office.getIsCo() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID) {
				isCoOffice = WorkFlowConstant.IS_CO_OFFICE_ONE;
			} else if (null != office.getIsFd() && office.getIsFd() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID) {
				isFdOffice = WorkFlowConstant.IS_CO_OFFICE_ONE;
			}
		}
		return repository.directWfActions(office.getOfficeTypeId().getLookUpInfoId(), dto.getMenuId(),
				Constant.VALID_WF_ACTION_ID, WorkFlowConstant.DEFAULT_WF_SUBMIT_ACTION_LEVEL, isCoOffice,
				WorkFlowConstant.DEFAULT_IS_CO, isFdOffice, WorkFlowConstant.DEFAULT_IS_FD, dto.getWfRoleIds());
	}

	@Override
	public int defaultSubmitWf(WfRequestDto dto) throws CustomException {
		List<WfActionConfigEntity> defaultSubmitAction = this.getDefaultSubmitAction(dto);
		if (defaultSubmitAction.isEmpty()) {
			throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
		}
		WfUserReqSDDto wfUserDto = new WfUserReqSDDto();
		wfUserDto.setTrnId(dto.getTrnId());
		wfUserDto.setPostId(dto.getPostId());
		wfUserDto.setPouId(dto.getLkPOUId());
		wfUserDto.setOfficeId(dto.getOfficeId());
		wfUserDto.setUserId(decryptUserId(dto.getUserId()));
		LkMenuTblInfoEntity tblInfo = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(dto.getMenuId(),
				Constant.ACTIVE_STATUS);
		wfRepo.executeNativeUpdateSQLQuery(
				QueryConstant.updateActStsForWfTrnQrString(tblInfo.getSchemaName(), tblInfo.getTrnWfTblName()),
				QueryConstant.updateActStsForWfTrnQrParamMap(dto.getTrnId()));
		return wfRepo.executeNativeUpdateSQLQuery(
				QueryConstant.insTrnDirectSubmitQrStr(tblInfo.getSchemaName(), tblInfo.getTrnWfTblName()),
				QueryConstant.insTrnSubmitParamMap(wfUserDto, defaultSubmitAction.get(0)));
	}

	@Override
	public WfActionConfigSubmitTrnResDto returnToOfficeCon(WfRequestReOffConDto dto) throws CustomException {
		// 1. Assigned to wf role fetch for con hdr id
		EDPMsOfficeEntity office = officeRepo.getOne(dto.getLoginOfficeId());

		int isFdOffice = WorkFlowConstant.IS_FD_OFFICE_ZERO;
		if (office.getStatusId() == WorkFlowConstant.LU_APPROVED_LOOKUP_INFO_ID
				&& office.getOfficeStatus() == WorkFlowConstant.LU_ACTIVE_LOOKUP_INFO_ID
				&& office.getActiveStatus() == Constant.ACTIVE_STATUS && (null != office.getIsFd())
				&& (office.getIsFd() == WorkFlowConstant.LU_YES_LOOKUP_INFO_ID)) {
			isFdOffice = WorkFlowConstant.IS_CO_OFFICE_ONE;
		}

		LkMenuTblInfoEntity tblOfTbl = getTblInfo(dto.getMenuId(), null);
		AssignedToTrnDto assignedToDto = findActualWfRoleId(dto.getConHdrId(), dto.getMenuId(), null,
				office.getOfficeTypeId().getLookUpInfoId(), dto.getLoginOfficeId(), dto.getPouId(), dto.getBranchId(),
				isFdOffice);

		// 2. fetch wfactionconfig for return to office action
		WfActionConfigSubmitTrnResDto assignedByFromRetWfTbl;
		WfActionConfigSubmitTrnResDto insHdrWfTbl = null;
		WfActionConfigEntity wfActionConfig = repository.findReturnWFActWfRuleId(dto.getMenuId(),
				office.getOfficeTypeId().getLookUpInfoId(), assignedToDto.getAssignToWfRoleId(), dto.getWfActionId(),
				Constant.VALID_WF_ACTION_ID, WorkFlowConstant.DIRECT_IS_DISPLAY_IN_POPUP);
		if (wfActionConfig != null) {
			// 3.Get Approver user details from return wf table
			assignedByFromRetWfTbl = wfRepo.executeSQLQuerySingle(QueryConstant.getUserForReturnToOfficeQrStr(tblOfTbl),
					QueryConstant.getUserForReturnToOfficeQrParamMap(dto, assignedToDto.getAssignToWfRoleId(),
							wfActionConfig.getToWorkFlowRoleId(), office.getOfficeId()),
					WfActionConfigSubmitTrnResDto.class);

			// 4.
			wfRepo.executeNativeUpdateSQLQuery(
					QueryConstant.updateActStsForWfTrnQrString(tblOfTbl.getSchemaName(), tblOfTbl.getReturnWfTblName()),
					QueryConstant.updateActStsForWfTrnQrParamMap(dto.getHdrId()));
			WfUserDto loginUserDet = wfRepo.executeSQLQuerySingle(QueryConstant.getUserDetailsFromPouIdQrStr(),
					QueryConstant.getUserDetailsFromPouIdQrMap(dto.getPouId()), WfUserDto.class);
			Long wfId = wfRepo.callWfSPLong(QueryConstant.getWfTrnSubmitSpQueryString(),
					QueryConstant.getRetToOffWfTrnSubmitSpQueryMap(dto, wfActionConfig, assignedByFromRetWfTbl,
							loginUserDet, assignedToDto));
			try {
				insHdrWfTbl = wfRepo.executeSQLQuerySingle(
						QueryConstant.getInsTrnDetailsQrStringQrString(tblOfTbl.getSchemaName(),
								tblOfTbl.getReturnWfTblName()),
						QueryConstant.getInsTrnDetailsQrStringQrParamMap(wfId), WfActionConfigSubmitTrnResDto.class);
			} catch (CustomException e) {
				e.printStackTrace();
			}

		} else {
			throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
		}
		return insHdrWfTbl;
	}

	@Override
	public List<MsWorkflowRoleEntity> getWfRlDcoCoCreatorForGrant() throws CustomException {
		return wfRlRepo.findDcoCoCreatorWfRoleForGrant(WorkFlowConstant.WF_ROLE_ID_DEPARTMENT_GRANT_APPROVER,
				WorkFlowConstant.WF_ROLE_ID_CO_APPROVER, Constant.ACTIVE_STATUS);
	}

	@Override
	public List<WfUserDto> getGrantUsersByWfActConfigId(WfGrantUserRequestDto dto) throws CustomException {
		Set<Object[]> userListDto = repository.findUserByNextWfRole(dto.getOfficeId(), dto.getMenuId(), dto.getToWfRoleId(),
				Constant.ACTIVE_STATUS);
		return NativeQueryResultsMapper.map(userListDto.stream().collect(Collectors.toList()), WfUserDto.class);
	}

	@Override
	@Transactional
	public WfRequestEntity genWfRequestNo(WfRequestEntity entity) throws SQLException {
		entity.setStatusId(edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
				WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_INIT).getLookUpInfoId());
		WfRequestEntity responseEntity = wfReqRepo.save(entity);
		DecimalFormat df = new DecimalFormat("000000");
		responseEntity.setWfRequestNo("20-21/WF/RQ/" + String.format("%04d", entity.getMenuId()) + "/"
				+ df.format(responseEntity.getWfRequestId()));
		return responseEntity;
	}

	@Override
	@Transactional
	public List<WfActionConfigAsyncSubmitTrnResDto> submitWfBulkIns(TrnSubmitAssignedToDto dto) throws CustomException {
		boolean isCompleted = false;
		LkMenuTblInfoEntity tblOfTbl = tblInfoRepo.getTableAndSchemaByWfActConfig(dto.getActionConfigId(),
				Constant.ACTIVE_STATUS);
		List<WfActionConfigAsyncSubmitTrnResDto> wfActionConfigServiceList = new ArrayList<>();
		final long wfRequestId = wfReqRepo
				.findByWfRequestNoAndActiveStatus(dto.getWfRequestNo(), Constant.ACTIVE_STATUS)
				.map(WfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, dto.getWfRequestNo())));
		if (dto instanceof TrnSubmitAssignedToUserImpl) {
			logger.info("Assigned to Single User");
			TrnSubmitAssignedToUserImpl trnDto = (TrnSubmitAssignedToUserImpl) dto;
			trnDto.getAssignTo().setUserId(decryptUserId(trnDto.getAssignTo().getUserId()));
			trnDto.getAssignBy().setUserId(decryptUserId(trnDto.getAssignBy().getUserId()));
			WfActionConfigEntity wfActConf = repository.findByActionconfigIdAndActiveStatus(trnDto.getActionConfigId(),
					Constant.ACTIVE_STATUS);
			trnDto.getTrnDto().stream()
					.forEach(trnIdRemDto -> wfReqRepo.callWfStoredProcedure(
							Constant.WORKFLOW_SCHEMA
									.concat(Constant.DOT.concat(WorkFlowConstant.WF_TRN_BULK_SUBMIT_V3)),
							QueryConstant.getWfTrnBulkOpV3SPMapSingle(trnIdRemDto, trnDto.getAssignTo(),
									trnDto.getAssignBy(), wfActConf, wfRequestId)));
			isCompleted = true;
		} else if (dto instanceof TrnSubmitAssignedToUsersImpl) {
			logger.info("Assigned to Multiple User");
			TrnSubmitAssignedToUsersImpl trnDto = (TrnSubmitAssignedToUsersImpl) dto;
			trnDto.getAssignBy().setUserId(decryptUserId(trnDto.getAssignBy().getUserId()));
			WfActionConfigEntity wfActConf = repository.findByActionconfigIdAndActiveStatus(trnDto.getActionConfigId(),
					Constant.ACTIVE_STATUS);
			trnDto.getTrnDto().stream().forEach(trnIdRemAssToUserDto -> {
				trnIdRemAssToUserDto.getAssignTo()
						.setUserId(decryptUserId(trnIdRemAssToUserDto.getAssignTo().getUserId()));
				wfReqRepo.callWfStoredProcedure(
						Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.WF_TRN_BULK_SUBMIT_V3)),
						QueryConstant.getWfTrnBulkOpV3SPMapSingle(trnIdRemAssToUserDto,
								trnIdRemAssToUserDto.getAssignTo(), trnDto.getAssignBy(), wfActConf, wfRequestId));
			});
			isCompleted = true;
		}
		if (isCompleted) {
			wfActionConfigServiceList = wfRepo.executeSQLQuery(
					QueryConstant.getInsTrnDetailsQrString(tblOfTbl.getSchemaName(), tblOfTbl.getTrnWfTblName()),
					QueryConstant.getInsTrnDetailsQrParamMap(dto.getWfRequestNo()),
					WfActionConfigAsyncSubmitTrnResDto.class);
			long failedCount = wfActionConfigServiceList.stream().filter(trn -> trn.getSqlErrCode() < 0).count();
			long statusId = edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
					WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
					WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_SUCCESSFUL).getLookUpInfoId();
			if (failedCount > 0) {
				statusId = edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
						WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED).getLookUpInfoId();
			} else {
				long partFailedCount = wfActionConfigServiceList.stream().filter(trn -> trn.getSqlErrCode() > 0)
						.count();
				if (partFailedCount > 0) {
					statusId = edpLuLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
									WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
									WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_PARTIALLY_FAILED)
							.getLookUpInfoId();
				}
			}
			wfReqRepo.updateWfReqStsByWfReqId(statusId, wfRequestId,
					Long.parseLong(dto.getAssignBy().getUserId().toString()), dto.getAssignBy().getPostId(),
					new Date());
			return wfActionConfigServiceList;
		} else {
			final long isFailedLuInfoId = edpLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
							WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
							WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED)
					.getLookUpInfoId();
			wfReqRepo.updateWfReqStsByWfReqId(isFailedLuInfoId, wfRequestId,
					Long.parseLong(dto.getAssignBy().getUserId().toString()), dto.getAssignBy().getPostId(),
					new Date());
			return wfActionConfigServiceList;
		}
	}

	@Override
	@Transactional
	public long getWfReqId(String wfReqNo) throws CustomException {
		final long initiatedStatusId = edpLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
						WorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_INIT)
				.getLookUpInfoId();
		return wfReqRepo.findByWfRequestNoAndStatusIdAndActiveStatus(wfReqNo, initiatedStatusId, Constant.ACTIVE_STATUS)
				.map(WfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));
	}

	@Override
	@Transactional
	public String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException {
		return wfReqRepo.findByWfRequestNoAndActiveStatus(wfReqNo, Constant.ACTIVE_STATUS)
				.map(r -> edpLuLookUpInfoRepository.findBylookUpInfoId(r.getStatusId()).getLookUpInfoName())
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));
	}

	@Override
	@Transactional
	public void updateWfReqStatus(String wfReqNo, String luName, String luInfoName) throws CustomException {
		long statusId = edpLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				luName, Constant.ACTIVE_STATUS, luInfoName).getLookUpInfoId();
		final long wfRequestId = wfReqRepo.findByWfRequestNoAndActiveStatus(wfReqNo, Constant.ACTIVE_STATUS)
				.map(WfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));
		wfReqRepo.updateWfReqStsByWfReqId(statusId, wfRequestId);
	}
}
