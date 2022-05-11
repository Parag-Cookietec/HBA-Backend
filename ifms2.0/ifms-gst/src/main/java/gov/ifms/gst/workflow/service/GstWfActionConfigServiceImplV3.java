package gov.ifms.gst.workflow.service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.gst.repository.LuLookUpInfoRepository;
import gov.ifms.gst.util.GSTConstant;
import gov.ifms.gst.workflow.dto.GstTrnIdRemAssToUserDto;
import gov.ifms.gst.workflow.dto.GstTrnSubmitAssignedToDto;
import gov.ifms.gst.workflow.dto.GstWfActionConfigAsyncSubmitTrnResDto;
import gov.ifms.gst.workflow.dto.MenuTblInfoDto;
import gov.ifms.gst.workflow.dto.WfLoginUserDetDto;
import gov.ifms.gst.workflow.dto.WfUserDetailsV3;
import gov.ifms.gst.workflow.dto.WfUserDto;
import gov.ifms.gst.workflow.dto.WfUserRequestDtoV3;
import gov.ifms.gst.workflow.entity.GstWfActionConfigEntity;
import gov.ifms.gst.workflow.entity.GstWfRequestEntity;
import gov.ifms.gst.workflow.entity.GstWfRlBrTypeMenuAuthEntity;
//import gov.ifms.gst.workflow.entity.GstWfRlBrTypeMenuAuthEntity;
import gov.ifms.gst.workflow.repository.GstWfActionConfigRepository;
import gov.ifms.gst.workflow.repository.GstWfRequestRepository;
import gov.ifms.gst.workflow.repository.GstWfRlBrTypeMenuAuthRepository;
//import gov.ifms.gst.workflow.repository.GstWfRlBrTypeMenuAuthRepository;
import gov.ifms.gst.workflow.util.GstQueryConstant;
import gov.ifms.gst.workflow.util.GstWorkFlowConstant;
import gov.ifms.gst.workflow.util.SendBack;

/**
 * The Class GstWfActionConfigServiceImplV3.
 */
@Service
public class GstWfActionConfigServiceImplV3 implements GstWfActionConfigServiceV3 {

	/** The log. */
	Logger log = LoggerFactory.getLogger(GstWfActionConfigServiceImplV3.class);

	/** The Constant WF_REQ_NOT_VALID. */
	private static final String WF_REQ_NOT_VALID = "Workflow Request No. %s is not valid!";
	
	/** The Constant USER_ALLOWED. */
	public static final String USER_ALLOWED = "User allowed to fetch from workflow role id {0}";
	

	/**
	 * The repository.
	 */
	@Autowired
	private GstWfActionConfigRepository repository;

	/** The edp lu look up info repository. */
	@Autowired
	private LuLookUpInfoRepository luLookUpInfoRepository;


	/** The wf req repo. */
	@Autowired
	private GstWfRequestRepository wfReqRepo;

	/** The wf auth repo. */
	@Autowired
	private GstWfRlBrTypeMenuAuthRepository wfAuthRepo;

	@Override
	public List<GstWfActionConfigEntity> getNextWfActions(long menuId) throws CustomException {

		GstWfRlBrTypeMenuAuthEntity penAuth = getWfRoleAndBrIdByMenuId(menuId);
		WfLoginUserDetDto wfDetFromToken = getWfDetFromToken(menuId);
		long fromWfRoleId = wfDetFromToken.getWfRoleIds().stream().filter(x -> x== penAuth.getWfRoleId()).findFirst().orElseThrow(() -> new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED));
		Long branchTypeId = null;
		if(!CollectionUtils.isEmpty(wfDetFromToken.getBranches())) {
		 branchTypeId = wfDetFromToken.getBranches().stream().map(x -> x.getBranchTypeId()).filter(x-> x.equals(penAuth.getBranchTypeId())).findFirst().orElse(null);
		}
		
		EDPMsOfficeDto office = wfDetFromToken.getOfficeDto();

		return repository.findWorkflowRuleIdAndWfActionsAndBrIdWithSubType(office.getOfficeTypeId(),
				fromWfRoleId, menuId, Constant.VALID_WF_ACTION_ID,
				GstWorkFlowConstant.DEFAULT_WF_ACTION_LEVEL, branchTypeId,
				Constant.ACTIVE_STATUS, GstWorkFlowConstant.DEFAULT_IS_DISPLAY_IN_POPUP, office.getSubTypeId());
	}

	public MenuTblInfoDto getTblInfo(long menuId) throws CustomException {
		return repository.executeSQLQuerySingle(GstQueryConstant.getMenuTblInfoFromMenuIdQrStr(),
				GstQueryConstant.getMenuTblInfoFromMenuIdQrMap(menuId), MenuTblInfoDto.class);
	}

	public MenuTblInfoDto getTblInfoByWfActionConfigId(long wfActionConfigId) throws CustomException {
		return repository.executeSQLQuerySingle(GstQueryConstant.getMenuTblInfoFromGstWfActionConfigIdQrStr(),
				GstQueryConstant.getMenuTblInfoFromGstWfActionConfigIdQrMap(wfActionConfigId), MenuTblInfoDto.class);
	}

	@Override
	public List<WfUserDto> getUsersByWfActConfigId(WfUserRequestDtoV3 dto) throws CustomException {
		GstWfActionConfigEntity wfActConf = repository.findByActionConfigIdAndActiveStatus(dto.getWfActionConfigId(),
				Constant.ACTIVE_STATUS);
		if (wfActConf != null) {
			GstWfRlBrTypeMenuAuthEntity penAuth = getWfRoleAndBrIdByMenuId(dto.getMenuId());
			WfLoginUserDetDto wfDetFromToken = getWfDetFromToken(dto.getMenuId());
			long wfRoleId = wfDetFromToken.getWfRoleIds().stream().filter(x -> x== penAuth.getWfRoleId()).findFirst().orElseThrow(() -> new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED));
			log.info(USER_ALLOWED,wfRoleId);
			if (wfActConf.getSendBackFlag() == SendBack.DEFUALT.getValue()) {
				return getUsersForForwardWf(wfDetFromToken, wfActConf,dto);
			}
		} else {
			throw new CustomException(HttpStatus.BAD_REQUEST, MsgConstant.WORKFLOW_ACTION_CONFIG_NOTVALID);
		}
		return Collections.emptyList();
	}

	public List<WfUserDto> getUsersForForwardWf(WfLoginUserDetDto wfDetFromToken, GstWfActionConfigEntity wfActConf, WfUserRequestDtoV3 dto) {
		if (wfActConf.getToBranchTypeId() != null) {
			return repository
					.findUserByNextWfRoleAndBranchId(
							wfActConf.getIsToOfficeSelReq()!=0?dto.getOfficeId():wfDetFromToken.getOfficeDto().getOfficeId(), wfActConf.getTargetMenuId()==null?dto.getMenuId():wfActConf.getTargetMenuId(), wfActConf
									.getToWorkFlowRoleId(),
							dto.getBranchId(), Constant.ACTIVE_STATUS)
					.stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == wfDetFromToken.getPouId()
							&& wfUserDto.getWfRoleId().equals(wfActConf.getFromWfRoleId())))
					.collect(Collectors.toList());
		} else {
			return repository
					.findUserByNextWfRole(
							wfActConf.getIsToOfficeSelReq()!=0?dto.getOfficeId():wfDetFromToken.getOfficeDto().getOfficeId(), wfActConf.getTargetMenuId()==null?dto.getMenuId():wfActConf.getTargetMenuId(), wfActConf.getToWorkFlowRoleId(), Constant.ACTIVE_STATUS)
					.stream()
					.filter(wfUserDto -> !(wfUserDto.getPouId() == wfDetFromToken.getPouId()
							&& wfUserDto.getWfRoleId().equals(wfActConf.getFromWfRoleId())))
					.collect(Collectors.toList());
		}
	}


	

	@Override
	@Transactional
	public GstWfRequestEntity genWfRequestNo(GstWfRequestEntity entity) throws SQLException {
		entity.setStatusId(luLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
				GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_INIT).getLookUpInfoId());
		GstWfRequestEntity responseEntity = wfReqRepo.save(entity);
		DecimalFormat df = new DecimalFormat("000000");
		responseEntity.setWfRequestNo("20-21/WF/RQ/" + String.format("%04d", entity.getMenuId()) + "/"
				+ df.format(responseEntity.getWfRequestId()));
		return responseEntity;
	}

	@Override
	@Transactional
	public void submitWfBulkIns(GstTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException {
		boolean isCompleted = false;
		GstWfActionConfigEntity wfActConf = repository.findByActionConfigIdAndActiveStatus(dto.getActionConfigId(),
				Constant.ACTIVE_STATUS);
//		GstWfRlBrTypeMenuAuthEntity penAuth = getWfRoleAndBrIdByMenuId(wfActConf.getEdpMsMenuEntity().getMenuId());
//		long wfRoleId = wfDetFromToken.getWfRoleIds().stream().filter(x -> x== penAuth.getWfRoleId()).findFirst().orElseThrow(() -> new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED));
//		log.info("Execution time of bulk operation is {} ms", wfRoleId);

		WfUserDetailsV3 assignByLoginUser = new WfUserDetailsV3();
		assignByLoginUser.setPouId(wfDetFromToken.getPouId());
		assignByLoginUser.setOfficeId(wfDetFromToken.getOfficeDto().getOfficeId());
		if(null != wfDetFromToken.getBranches())
		assignByLoginUser.setBranchId(wfDetFromToken.getBranches().get(0).getBranchId());
		assignByLoginUser.setPostId(wfDetFromToken.getPostId());
		assignByLoginUser.setUserId(wfDetFromToken.getUserId());
		if(null != wfDetFromToken.getWfRoleIds())
		assignByLoginUser.setWfRoleId(wfDetFromToken.getWfRoleIds().stream().findFirst().get());
		

		MenuTblInfoDto tblOfTbl = getTblInfo(dto.getMenuId());

		List<GstWfActionConfigAsyncSubmitTrnResDto> wfActionConfigServiceList;
		final long wfRequestId = wfReqRepo
				.findByWfRequestNoAndActiveStatus(dto.getWfRequestNo(), Constant.ACTIVE_STATUS)
				.map(GstWfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, dto.getWfRequestNo())));


		isCompleted = callSubmitWfSpV3(dto.prepareTrnDto(),wfActConf,wfRequestId,assignByLoginUser);

		if (isCompleted) {
			wfActionConfigServiceList = repository.executeSQLQuery(
					GstQueryConstant.getInsTrnDetailsQrString(tblOfTbl.getSchemaName(), tblOfTbl.getWfTblName()),
					GstQueryConstant.getInsTrnDetailsQrParamMap(dto.getWfRequestNo()),
					GstWfActionConfigAsyncSubmitTrnResDto.class);
			long failedCount = wfActionConfigServiceList.stream().filter(trn -> trn.getSqlErrCode() < 0).count();
			long statusId = luLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
					GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
					GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_SUCCESSFUL).getLookUpInfoId();
			if (failedCount > 0) {
				statusId = luLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
						GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED).getLookUpInfoId();
			} else {
				long partFailedCount = wfActionConfigServiceList.stream().filter(trn -> trn.getSqlErrCode() > 0)
						.count();
				if (partFailedCount > 0) {
					statusId = luLookUpInfoRepository
							.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
									GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
									GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_PARTIALLY_FAILED)
							.getLookUpInfoId();
				}
			}
			try{
				repository.executeNativeUpdateSQLQuery(
						GstQueryConstant.updatePensionWfReqStatusQrStr(),
						GstQueryConstant.updatePensionWfReqStatusQrParamMap(statusId,wfDetFromToken.getUserId(), wfDetFromToken.getPostId(),wfRequestId));
			}catch (RuntimeException ex){
				ex.printStackTrace();
			}

		} else {
			final long isFailedLuInfoId = luLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
							GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
							GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_FAILED)
					.getLookUpInfoId();
			wfReqRepo.updateWfReqStsByWfReqId(isFailedLuInfoId, wfRequestId,
					wfDetFromToken.getUserId(), wfDetFromToken.getPostId(),
					new Date());
		}
	}

	@Transactional
	public boolean callSubmitWfSpV3(List<GstTrnIdRemAssToUserDto> trnDtos, GstWfActionConfigEntity wfActConf, long wfRequestId, WfUserDetailsV3 assignByLoginUser) {
		log.info("####Submitting to stored procedure for both...");
		trnDtos.stream().forEach(trnDto -> {
			wfReqRepo.callWfStoredProcedure(
					GSTConstant.GST_SCHEMA.concat(Constant.DOT.concat(GstWorkFlowConstant.WF_TRN_BULK_SUBMIT_V3)),
					GstQueryConstant.getWfTrnBulkOpV3SPMapSingle(trnDto,
							assignByLoginUser, wfActConf, wfRequestId));
		});
		return true;
	}

	@Override
	@Transactional
	public long getWfReqId(String wfReqNo) throws CustomException {
		final long initiatedStatusId = luLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
						GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS, Constant.ACTIVE_STATUS,
						GstWorkFlowConstant.LU_LOOKUP_NAME_WF_REQ_STATUS_INIT)
				.getLookUpInfoId();
		return wfReqRepo.findByWfRequestNoAndStatusIdAndActiveStatus(wfReqNo, initiatedStatusId, Constant.ACTIVE_STATUS)
				.map(GstWfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));
	}

	@Override
	@Transactional
	public String getWfReqStatusByWfReqNo(String wfReqNo) throws CustomException {
		return wfReqRepo.findByWfRequestNoAndActiveStatus(wfReqNo, Constant.ACTIVE_STATUS)
				.map(r -> luLookUpInfoRepository.findBylookUpInfoId(r.getStatusId()).getLookUpInfoName())
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));
	}

	@Override
	@Transactional
	public void updateWfReqStatus(String wfReqNo, String luName, String luInfoName, WfLoginUserDetDto wfDetFromToken) throws CustomException {
		long statusId = luLookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(
				luName, Constant.ACTIVE_STATUS, luInfoName).getLookUpInfoId();
		final long wfRequestId = wfReqRepo.findByWfRequestNoAndActiveStatus(wfReqNo, Constant.ACTIVE_STATUS)
				.map(GstWfRequestEntity::getWfRequestId)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfReqNo)));

		wfReqRepo.updateWfReqStsByWfReqId(statusId, wfRequestId,wfDetFromToken.getUserId(), wfDetFromToken.getPostId(),new Date());
	}

	@Override
	@Async
	public void submitWfBulkOpGst(GstTrnSubmitAssignedToDto dto, WfLoginUserDetDto wfDetFromToken) throws CustomException {
		log.info("Async Submit bulk operation start...");
		Instant start = Instant.now();
		submitWfBulkIns(dto,wfDetFromToken);
		Instant end = Instant.now();
		log.info("Async Submit bulk operation ends...");
		log.info("Execution time of bulk operation is {} ms", Duration.between(start,end).toMillis());
	}

	/**
	 * Gets the wf role and br id by menu id.
	 *
	 * @param menuId the menu id
	 * @return the wf role and br id by menu id
	 * @throws CustomException the custom exception
	 */
	@Transactional
	private GstWfRlBrTypeMenuAuthEntity getWfRoleAndBrIdByMenuId(long menuId) throws CustomException {
		return wfAuthRepo.findTop1ByMenuIdAndActiveStatus(menuId,Constant.ACTIVE_STATUS).orElseThrow(() -> new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED));
	}
	
	
	
	/**
	 * Gets the submit trn details by wf req no.
	 *
	 * @param wfRequestNo the wf request no
	 * @return the submit trn details by wf req no
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<GstWfActionConfigAsyncSubmitTrnResDto> getSubmitTrnDetailsByWfReqNo(String wfRequestNo) throws CustomException {
		GstWfRequestEntity wfRequestEntity = wfReqRepo
				.findByWfRequestNoAndActiveStatus(wfRequestNo, Constant.ACTIVE_STATUS)
				.orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
						String.format(WF_REQ_NOT_VALID, wfRequestNo)));
		MenuTblInfoDto tblOfTbl = getTblInfo(wfRequestEntity.getMenuId());
		return  repository.executeSQLQuery(
				GstQueryConstant.getInsTrnDetailsQrString(tblOfTbl.getSchemaName(), tblOfTbl.getWfTblName()),
				GstQueryConstant.getInsTrnDetailsQrParamMap(wfRequestNo),
				GstWfActionConfigAsyncSubmitTrnResDto.class);
	}

	/**
	 * Gets the wf det from token.
	 *
	 * @param menuID the menu ID
	 * @return the wf det from token
	 */
	private WfLoginUserDetDto getWfDetFromToken(long menuID){
		WfLoginUserDetDto loginUserDetDto = new WfLoginUserDetDto();
		EDPMsPostDto postDto = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		loginUserDetDto.setUserId(OAuthUtility.getCurrentUserUserId());
		loginUserDetDto.setPostId(postDto.getPostId());
		loginUserDetDto.setPostId(postDto.getLkPoOffUserId());
		loginUserDetDto.setOfficeDto(postDto.getOauthTokenPostDTO().getEdpMsOfficeDto());
		loginUserDetDto.setWfRoleIds(OAuthUtility.getWfRoleOfMenuWithLinkMenuUsingMenuId(menuID));
		loginUserDetDto.setBranches(postDto.getBranches());
		return loginUserDetDto;
	}

}
