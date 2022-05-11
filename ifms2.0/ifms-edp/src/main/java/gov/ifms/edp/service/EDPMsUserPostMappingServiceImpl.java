/*
 * 
 */
package gov.ifms.edp.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsUserConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsHeaderConverter;
import gov.ifms.edp.converter.EDPUserPoTrnsItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPHeaderParam;
import gov.ifms.edp.dto.EDPIdDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPPostMapDto;
import gov.ifms.edp.dto.EDPUserPostDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsDetailDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsHeaderDto;
import gov.ifms.edp.dto.EDPUsrPoTrnsSearchViewDto;
import gov.ifms.edp.employe.EDPEmployeConverter;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.employe.EDPEmployeRepository;
import gov.ifms.edp.entity.EDPLkEmpUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserItrEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsHeaderEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLkEmpUserRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserItrRepository;
import gov.ifms.edp.repository.EDPLkPoOffUserRepository;
import gov.ifms.edp.repository.EDPLkPostOfficeRepository;
import gov.ifms.edp.repository.EDPLkPostUserRepository;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsUserRepository;
import gov.ifms.edp.repository.EDPTedpUptTrnDataRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsHeaderRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsItrRepository;
import gov.ifms.edp.repository.EDPUsrPoTrnsRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.edp.workflow.service.EDPWorkflowRequestHandler;

/**
 * The Class EDPMsUserPostMappingServiceImpl.
 */

@Service
public class EDPMsUserPostMappingServiceImpl implements EDPMsUserPostMappingService {

	/** The edp lk post user repository. */
	@Autowired
	private EDPLkPostUserRepository edpLkPostUserRepository;

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The edp employe repository. */
	@Autowired
	private EDPEmployeRepository edpEmployeRepository;

	/** The edp lk po off user repository. */
	@Autowired
	private EDPLkPoOffUserRepository edpLkPoOffUserRepository;

	/** The edp usr po trns repository. */
	@Autowired
	private EDPUsrPoTrnsRepository edpUsrPoTrnsRepository;

	/** The edp usr po trns header repository. */
	@Autowired
	private EDPUsrPoTrnsHeaderRepository edpUsrPoTrnsHeaderRepository;

	/** The edp usr po trns header converter. */
	@Autowired
	private EDPUserPoTrnsHeaderConverter edpUsrPoTrnsHeaderConverter;

	/** The edp user po trns converter. */
	@Autowired
	private EDPUserPoTrnsConverter edpUserPoTrnsConverter;

	/** The edp employe converter. */
	@Autowired
	private EDPEmployeConverter edpEmployeConverter;

	/** The edp ms user converter. */
	@Autowired
	private EDPMsUserConverter edpMsUserConverter;

	/** The edp ms user repository. */
	@Autowired
	private EDPMsUserRepository edpMsUserRepository;

	/** The edp lk emp user repository. */
	@Autowired
	private EDPLkEmpUserRepository edpLkEmpUserRepository;

	/** The edp lk post office repository. */
	@Autowired
	private EDPLkPostOfficeRepository edpLkPostOfficeRepository;

	/** The edp user po trns itr converter. */
	@Autowired
	private EDPUserPoTrnsItrConverter edpUserPoTrnsItrConverter;

	/** The edp usr po trns itr repository. */
	@Autowired
	private EDPUsrPoTrnsItrRepository edpUsrPoTrnsItrRepository;

	/** The edp lk po off user itr repository. */
	@Autowired
	private EDPLkPoOffUserItrRepository edpLkPoOffUserItrRepository;

	/** The edp tedp upt trn data repository. */
	@Autowired
	private EDPTedpUptTrnDataRepository edpTedpUptTrnDataRepository;

	@Autowired
	private EDPWorkflowRequestHandler wfRequestHandler;

	/** The wf role repository. */
	@Autowired
	private EDPLkPuoMenuRLWFRepository wfRoleRepository;
	
	/** The district converter. */
	@Autowired
	private EDPMsDistrictConverter districtConverter;
	
	/** The district repository. */
	@Autowired
	private EDPMsDistrictRepository districtRepository;

	/**
	 * Gets the post user mapping by header id.
	 *
	 * @param edpUsrTrnHeaderId the edp usr trn header id
	 * @return the post user mapping by header id
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPUsrPoTrnsHeaderDto getPostUserMappingByHeaderId(Long edpUsrTrnHeaderId) throws CustomException {
		try {
			return getEDPUserPostList(edpUsrTrnHeaderId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Gets the EDP user post list.
	 *
	 * @param headerId the header id
	 * @return the EDP user post list
	 * @throws CustomException the custom exception
	 */
	private EDPUsrPoTrnsHeaderDto getEDPUserPostList(Long headerId) throws CustomException {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(Constant.IN_HDR_ID, headerId);
		EDPUsrPoTrnsHeaderDto headerDto = new EDPUsrPoTrnsHeaderDto();

		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_USER_POST_MAPPING_DETAILS));
		List<Object[]> postOfficeUserList = edpLkPostUserRepository.callStoredProcedure(procName, paramMap);

		if (!postOfficeUserList.isEmpty()) {
			Object[] pou = postOfficeUserList.get(0);

			headerDto.setPostName(EDPUtility.convertObjectToString(pou[1]));
			String fromUserCode = null;
			String toUserCode = null;

			if (null != pou[3]) {
				headerDto.setFromUserId(EDPUtility.convertObjectToLong(pou[3]));
				headerDto.setFromUserName(EDPUtility.convertObjectToString(pou[4]));
				fromUserCode = EDPUtility.convertObjectToString(pou[11]);
				headerDto.setFromUserCode(fromUserCode);

			} else {
				EDPIdDto iddto = new EDPIdDto();
				iddto.setOfficeId(EDPUtility.convertObjectToLong(pou[7]));
				List<EDPPostMapDto> vacantPosts = getVacantPost(iddto);
				headerDto.setVacantPostsDto(vacantPosts);
			}

			if (null != pou[5]) {
				headerDto.setToUserId(EDPUtility.convertObjectToLong(pou[5]));
				headerDto.setToUserName(EDPUtility.convertObjectToString(pou[6]));
				toUserCode = EDPUtility.convertObjectToString(pou[12]);
				headerDto.setToUserCode(toUserCode);
			}

			if (null != pou[18]) {
				headerDto.setToEmpId(EDPUtility.convertObjectToLong(pou[18]));
				toUserCode = EDPUtility.convertObjectToString(pou[19]);
				headerDto.setToUserCode(toUserCode);
				headerDto.setToUserName(EDPUtility.convertObjectToString(pou[20]));

			}

			headerDto.setOfficeId(EDPUtility.convertObjectToLong(pou[7]));
			headerDto.setTrnNo(EDPUtility.convertObjectToString(pou[8]));
			headerDto.setEdpUsrPoTrnsHeaderId(EDPUtility.convertObjectToLong(pou[9]));
			headerDto.setCreatedDate(EDPUtility.getDateValue(EDPUtility.convertObjectToString(pou[10])));
			headerDto.setDistrictId(EDPUtility.convertObjectToLong(pou[13]));
			headerDto.setStatusId(EDPUtility.convertObjectToLong(pou[14]));
			headerDto.setOfficeName(EDPUtility.convertObjectToString(pou[15]));
			setWorkflowParams(pou, headerDto);

			List<ClueDto> detailDtoList = new ArrayList<>();
			postOfficeUserList.forEach(pouData -> detailDtoList.add(getPostOfficeClueDto(pouData)));

			headerDto.setDetailDto(detailDtoList);
			try {

				if (null != fromUserCode) {
					EDPIdDto fromDto = new EDPIdDto();
					fromDto.setUserCode(fromUserCode);
					fromDto.setFrom(true);
					fromDto.setOfficeId(EDPUtility.convertObjectToLong(pou[7]));
					headerDto.setFromUserPost(getPostDetailsForEmp(fromDto));
				}
				if (null != toUserCode) {
					EDPIdDto toDto = new EDPIdDto();
					toDto.setUserCode(toUserCode);
					toDto.setFrom(false);
					headerDto.setToUserPost(getPostDetailsForEmp(toDto));
				}

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
			}

		}

		return headerDto;
	}

	private void setWorkflowParams(Object[] pou, EDPUsrPoTrnsHeaderDto headerDto) {
		String trnStatus = EDPUtility.convertObjectToString(pou[24]);
		boolean wfInRequest = EDPUtility.convertObjectToLong(pou[27]).equals(EDPConstant.LOOKUP_INFO_YES) ? Boolean.TRUE
				: Boolean.FALSE;
		if ((trnStatus.equalsIgnoreCase(EDPConstant.LK_STATUS_VAL_REJECTED)
				|| trnStatus.equalsIgnoreCase(EDPConstant.LK_STATUS_VAL_PENDING)
				|| trnStatus.equalsIgnoreCase(EDPConstant.LK_STATUS_VAL_APPROVED)) 
				&& wfInRequest) {
			headerDto.setIsObjectionRequired(Boolean.TRUE);
			headerDto.setHasObjection(
					EDPUtility.convertObjectToLong(pou[25]).equals(EDPConstant.LOOKUP_INFO_YES) ? Boolean.TRUE
							: Boolean.FALSE);
			headerDto.setObjectionRemarks(EDPUtility.convertObjectToString(pou[26]));
		} else {
			headerDto.setIsObjectionRequired(Boolean.FALSE);
		}
		headerDto.setWfInRequest(wfInRequest);
	}

	/**
	 * Gets the post office clue dto.
	 *
	 * @param objArr the obj arr
	 * @return the post office clue dto
	 */
	private ClueDto getPostOfficeClueDto(Object[] objArr) {
		return new ClueDto(EDPUtility.convertObjectToLong(objArr[17]), EDPUtility.convertObjectToLong(objArr[0]),
				(EDPUtility.convertObjectToLong(objArr[2]).equals(EDPConstant.LONG_VALUE_ONE)) ? Boolean.FALSE
						: Boolean.TRUE);
	}

	/**
	 * Creates the UP mapping attachment.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the EDP usr po trns entity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPUsrPoTrnsHeaderDto createUserPostMapping(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto)
			throws CustomException {
		generateTrnNo(edpUsrPoTrnsHeaderDto);
		EDPUsrPoTrnsHeaderDto responseDto = saveRequestAsDraft(edpUsrPoTrnsHeaderDto);
		if (responseDto.isWfSaveDrftApiCall()) {
			wfRequestHandler.saveAsDraftWf(edpUsrPoTrnsHeaderDto.getCurMenuId(),
					edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId());
		}
		if (!responseDto.isWfInRequest() && responseDto.getFormAction().equals(Status.SUBMITTED)) {
			wfRequestHandler.wfDirectSubmiteApiCall(edpUsrPoTrnsHeaderDto.getCurMenuId(),
					edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId());
		}
		return responseDto;
	}

	/**
	 * Save as draft.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the EDP usr po trns header dto
	 * @throws CustomException the custom exception
	 */
	@Transactional(rollbackFor = CustomException.class)
	public EDPUsrPoTrnsHeaderDto saveRequestAsDraft(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto)
			throws CustomException {
		try {
			if (null == edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId()) {
				EDPUsrPoTrnsHeaderEntity headerEntity = getHdrEntityData(edpUsrPoTrnsHeaderDto);
				edpUsrPoTrnsHeaderRepository.flush();
				edpUsrPoTrnsHeaderDto.setEdpUsrPoTrnsHeaderId(headerEntity.getEdpUsrPoTrnsHeaderId());
				edpUsrPoTrnsHeaderDto.setTrnDate(headerEntity.getCreatedDate());
			}
			updateHdrEntityStatus(edpUsrPoTrnsHeaderDto);
			List<EDPUsrPoTrnsEntity> userPoTrnsEntityList = edpUsrPoTrnsRepository
					.findAllByEdpUsrPoTrnsHeaderIdEdpUsrPoTrnsHeaderId(edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId());
			List<EDPUsrPoTrnsDetailDto> requestDtoList = edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsDetailDto();
			List<EDPUsrPoTrnsEntity> dtoDetailForSave = new ArrayList<>();
			if (!CollectionUtils.isEmpty(requestDtoList))
				dtoDetailForSave = saveDataIntoTables(edpUsrPoTrnsHeaderDto, userPoTrnsEntityList, requestDtoList);
			if ((!edpUsrPoTrnsHeaderDto.isWfInRequest() || edpUsrPoTrnsHeaderDto.isWfSubmit())
					&& edpUsrPoTrnsHeaderDto.getFormAction() == Status.SUBMITTED) {
				submitRequest(dtoDetailForSave, edpUsrPoTrnsHeaderDto);
			}
			return edpUsrPoTrnsHeaderDto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Save data into tables.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @param userPoTrnsEntityList  the user po trns entity list
	 * @param requestDtoList        the request dto list
	 * @param roleId                the role id
	 * @return the list
	 * @throws CustomException
	 */
	private List<EDPUsrPoTrnsEntity> saveDataIntoTables(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto,
			List<EDPUsrPoTrnsEntity> userPoTrnsEntityList, List<EDPUsrPoTrnsDetailDto> requestDtoList) {
		if (CollectionUtils.isEmpty(userPoTrnsEntityList)) {
			edpUsrPoTrnsHeaderDto.setWfSaveDrftApiCall(Boolean.TRUE);
			return saveListAsNew(requestDtoList, edpUsrPoTrnsHeaderDto);
		} else if (userPoTrnsEntityList.size() > requestDtoList.size()) {
			return updateListAndDeActiveRemaingRecords(requestDtoList, edpUsrPoTrnsHeaderDto, userPoTrnsEntityList);
		} else if (userPoTrnsEntityList.size() < requestDtoList.size()) {
			return updateListAndAddNewRecord(requestDtoList, edpUsrPoTrnsHeaderDto, userPoTrnsEntityList);
		} else {
			return updateList(requestDtoList, edpUsrPoTrnsHeaderDto, userPoTrnsEntityList);
		}
	}

	/**
	 * Gets the hdr entity data.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the hdr entity data
	 */
	private EDPUsrPoTrnsHeaderEntity getHdrEntityData(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		edpUsrPoTrnsHeaderDto.setStatusId(Constant.SAVE_AS_DRAFT_STATUS_ID);
		edpUsrPoTrnsHeaderDto.setInitiatedBy(OAuthUtility.getCurrentUserLkPOUId());
		EDPUsrPoTrnsHeaderEntity headerEntity = edpUsrPoTrnsHeaderConverter.toEntity(edpUsrPoTrnsHeaderDto);
		headerEntity.setRequestType(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_POST_TRANSFER_REQUEST_TYPE_ID));
		return edpUsrPoTrnsHeaderRepository.save(headerEntity);
	}

	/**
	 * Update hdr entity status.
	 *
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 */
	private void updateHdrEntityStatus(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		if((null != edpUsrPoTrnsHeaderDto.getHasObjection() && edpUsrPoTrnsHeaderDto.getHasObjection())) {
			edpUsrPoTrnsHeaderRepository.updateObjectionForHeader(EDPConstant.LOOKUP_INFO_YES, edpUsrPoTrnsHeaderDto.getObjectionRemarks(), edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId());
		}
		if ((!edpUsrPoTrnsHeaderDto.isWfInRequest() || edpUsrPoTrnsHeaderDto.isWfSubmit())
				&& null != edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId()
				&& edpUsrPoTrnsHeaderDto.getFormAction().equals(Status.SUBMITTED)) {
			edpUsrPoTrnsHeaderRepository.updateUserPoTrnsHeaderStatus(edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId(),
					Constant.LU_APPROVED_LOOKUP_INFO_ID, OAuthUtility.getCurrentUserUserId(), new Date());
		}
	}

	/**
	 * Update list.
	 *
	 * @param requestDtoList        the request dto list
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @param userPoTrnsEntityList  the user po trns entity list
	 * @return the list
	 */
	private List<EDPUsrPoTrnsEntity> updateList(List<EDPUsrPoTrnsDetailDto> requestDtoList,
			EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto, List<EDPUsrPoTrnsEntity> userPoTrnsEntityList) {
		List<EDPUsrPoTrnsEntity> response = new ArrayList<>();
		for (int i = 0; i < userPoTrnsEntityList.size(); i++) {
			EDPUsrPoTrnsEntity savedEntity = userPoTrnsEntityList.get(i);
			savedEntity = edpUserPoTrnsConverter.trnsDetailDtoToEDPUsrPoTrnsEntity(requestDtoList.get(i), savedEntity,
					edpUsrPoTrnsHeaderDto);
			response.add(savedEntity);
		}
		List<EDPUsrPoTrnsEntity> saveEntity = edpUsrPoTrnsRepository.saveAll(response);
		insertOnlyActiveRecordInItr(saveEntity);
		return saveEntity;
	}

	/**
	 * Save list as new.
	 *
	 * @param requestDtoList        the request dto list
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @return the list
	 */
	private List<EDPUsrPoTrnsEntity> saveListAsNew(List<EDPUsrPoTrnsDetailDto> requestDtoList,
			EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		List<EDPUsrPoTrnsEntity> entityListForSave = requestDtoList.stream()
				.map(dto -> edpUserPoTrnsConverter.trnsDetailDtoToNewEDPUsrPoTrnsEntity(dto, edpUsrPoTrnsHeaderDto))
				.collect(Collectors.toList());
		List<EDPUsrPoTrnsEntity> saveEntity = edpUsrPoTrnsRepository.saveAll(entityListForSave);
		insertOnlyActiveRecordInItr(saveEntity);
		return saveEntity;
	}

	/**
	 * Update list and de active remaing records.
	 *
	 * @param requestDtoList        the request dto list
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @param userPoTrnsEntityList  the user po trns entity list
	 * @return the list
	 */
	private List<EDPUsrPoTrnsEntity> updateListAndDeActiveRemaingRecords(List<EDPUsrPoTrnsDetailDto> requestDtoList,
			EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto, List<EDPUsrPoTrnsEntity> userPoTrnsEntityList) {
		List<EDPUsrPoTrnsEntity> response = new ArrayList<>();
		for (int i = 0; i < userPoTrnsEntityList.size(); i++) {
			EDPUsrPoTrnsEntity savedEntity = userPoTrnsEntityList.get(i);
			if (requestDtoList.size() > i) {
				savedEntity = edpUserPoTrnsConverter.trnsDetailDtoToEDPUsrPoTrnsEntity(requestDtoList.get(i),
						savedEntity, edpUsrPoTrnsHeaderDto);
			} else {
				savedEntity.setActiveStatus(Constant.INACTIVE_STATUS);
			}
			response.add(savedEntity);
		}
		List<EDPUsrPoTrnsEntity> saveEntity = edpUsrPoTrnsRepository.saveAll(response);
		insertOnlyActiveRecordInItr(saveEntity);
		return saveEntity;
	}

	/**
	 * Update list and add new record.
	 *
	 * @param requestDtoList        the request dto list
	 * @param edpUsrPoTrnsHeaderDto the edp usr po trns header dto
	 * @param userPoTrnsEntityList  the user po trns entity list
	 * @return the list
	 */
	private List<EDPUsrPoTrnsEntity> updateListAndAddNewRecord(List<EDPUsrPoTrnsDetailDto> requestDtoList,
			EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto, List<EDPUsrPoTrnsEntity> userPoTrnsEntityList) {
		List<EDPUsrPoTrnsEntity> response = new ArrayList<>();
		for (int i = 0; i < requestDtoList.size(); i++) {
			if (userPoTrnsEntityList.size() > i) {
				EDPUsrPoTrnsEntity savedEntity = userPoTrnsEntityList.get(i);
				savedEntity = edpUserPoTrnsConverter.trnsDetailDtoToEDPUsrPoTrnsEntity(requestDtoList.get(i),
						savedEntity, edpUsrPoTrnsHeaderDto);
				response.add(savedEntity);
			} else {
				EDPUsrPoTrnsDetailDto dto = requestDtoList.get(i);
				response.add(edpUserPoTrnsConverter.trnsDetailDtoToNewEDPUsrPoTrnsEntity(dto, edpUsrPoTrnsHeaderDto));
			}
		}
		List<EDPUsrPoTrnsEntity> saveEntity = edpUsrPoTrnsRepository.saveAll(response);
		insertOnlyActiveRecordInItr(saveEntity);
		return saveEntity;
	}

	/**
	 * Insert only active record in itr.
	 *
	 * @param entityList the entity list
	 */
	private void insertOnlyActiveRecordInItr(List<EDPUsrPoTrnsEntity> entityList) {
		List<EDPUsrPoTrnsItrEntity> itrList = new ArrayList<>();
		for (EDPUsrPoTrnsEntity entity : entityList) {
			if (entity.getActiveStatus() == 1) {
				itrList.add(edpUserPoTrnsItrConverter.trnsEntityToItrEntity(entity));
			}
		}
		if (!CollectionUtils.isEmpty(itrList)) {
			edpUsrPoTrnsItrRepository.saveAll(itrList);
		}
	}

	/**
	 * Checks if is not null and not zero.
	 *
	 * @param t the t
	 * @return true, if is not null and not zero
	 */
	private boolean isNotNullAndNotZero(Long t) {
		return !(t == null || t == 0);
	}

	private void generateTrnNo(EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) {
		if (!isNotNullAndNotZero(edpUsrPoTrnsHeaderDto.getEdpUsrPoTrnsHeaderId())) {
			Map<String, Object> argMap = new HashMap<>();
			argMap.put(Constant.TRN_SCREEN, edpUsrPoTrnsHeaderDto.getMenuCode());
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EDP_TRN_NO_GEN));
			List<Object[]> responseList = edpUsrPoTrnsHeaderRepository.callStoredProcedure(procName, argMap);
			edpUsrPoTrnsHeaderDto.setTrnNo(EDPUtility.convertObjectToString(responseList.get(0)[0]));
		}
	}

	/**
	 * Delete UP mapping attachment.
	 *
	 * @param headerId the header id
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = CustomException.class)
	public void deleteUPMapping(Long headerId) throws CustomException {
		try {
			edpUsrPoTrnsHeaderRepository.deleteUserPoTrnsHeaderById(headerId, Constant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new java.util.Date());
			edpUsrPoTrnsRepository.updateActiveStatus(headerId, Constant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new java.util.Date());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			throw new CustomException(ErrorResponse.ERROR_WHILE_DELETE);
		}
	}

	/**
	 * Gets the post details by emp no.
	 *
	 * @param dto the dto
	 * @return the post details by emp no
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPUserPostDto getPostDetailsByEmpNo(EDPIdDto dto) throws CustomException {
		Map<String, Object> argMap = new HashMap<>();
		argMap.put(Constant.IN_USER_CODE,Long.valueOf(dto.getUserCode()));
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_CHECK_UPT_REQUEST_EXISTS));
		List<Object[]> requestdList = edpUsrPoTrnsRepository.callStoredProcedure(procName, argMap);
		if (CollectionUtils.isEmpty(requestdList)) {
			return getPostDetailsForEmp(dto);
		} else {
			throw new CustomException(10001, getErrorMessage(requestdList, dto));
		}
	}

	/**
	 * Gets the post details for emp.
	 *
	 * @param dto the dto
	 * @return the post details for emp
	 * @throws CustomException the custom exception
	 */
	private EDPUserPostDto getPostDetailsForEmp(EDPIdDto dto) throws CustomException {
		if (dto.isFrom()) {
			return getFromPosts(dto);
		} else {
			return getToPosts(dto);
		}
	}

	/**
	 * Gets the from posts.
	 *
	 * @param dto the dto
	 * @return the from posts
	 * @throws CustomException the custom exception
	 */
	private EDPUserPostDto getFromPosts(EDPIdDto dto) throws CustomException {
		try {
			List<Object[]> objects = employeeSearchSpCall(dto);
			if (!CollectionUtils.isEmpty(objects)) {
				List<Long> officeId = objects.stream().map(obj -> EDPUtility.convertObjectToLong(obj[9]))
						.collect(Collectors.toList());
				if (dto.getOfficeId() == null || officeId.contains(dto.getOfficeId())) {
					return convertToDto(objects, dto);
				} else {
					throw new CustomException(ErrorResponse.ERROR_EDP_EMP_OFFICE_NOT_MAPPED);
				}
			} else {
				throw new CustomException(ErrorResponse.ERROR_INVALID_EMPLOYEE_NO);
			}
		} catch (CustomException ce) {
			CustomException ce1 = ce;
			logger.error(ce1.getMessage(), ce1);
			throw ce1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the to posts.
	 *
	 * @param dto the dto
	 * @return the to posts
	 * @throws CustomException the custom exception
	 */
	private EDPUserPostDto getToPosts(EDPIdDto dto) throws CustomException {
		EDPUserPostDto edpUserPostDto = null;
		List<Object[]> objects = employeeSearchSpCall(dto);
		if (CollectionUtils.isEmpty(objects)) {
			Optional<EDPEmployeEntity> opEmployeeEntity = edpEmployeRepository
					.findByEmployeeCodeAndActiveStatus(Long.valueOf(dto.getUserCode()), Constant.ACTIVE_STATUS);
			if (opEmployeeEntity.isPresent()) {
				edpUserPostDto = getEdpUserPostDtoFromEmployeeEntity(opEmployeeEntity.get());
			} else {
				throw new CustomException(ErrorResponse.ERROR_INVALID_EMPLOYEE_NO);
			}
		} else {
			edpUserPostDto = convertToDto(objects, dto);
		}
		return edpUserPostDto;
	}

	/**
	 * Convert to dto.
	 *
	 * @param objects the objects
	 * @param dto     the dto
	 * @return the EDP user post dto
	 */
	private EDPUserPostDto convertToDto(List<Object[]> objects, EDPIdDto dto) {
		EDPUserPostDto edpUserPostDto = new EDPUserPostDto();
		edpUserPostDto.setUserId(objects.get(0)[1] != null ? Long.parseLong(String.valueOf(objects.get(0)[1])) : 0);
		edpUserPostDto.setName(getEmployeeNameFromSpResponse(objects.get(0)));
		edpUserPostDto.setUserCode(objects.get(0)[12] != null ? Long.parseLong(String.valueOf(objects.get(0)[12])) : 0);
		List<EDPPostMapDto> postMapDtos = mapObjectsToPostMapDto(objects);
		setInSameOfficeInEDPPostMapDto(postMapDtos, dto);
		Comparator<EDPPostMapDto> compareById = (EDPPostMapDto o1, EDPPostMapDto o2) -> (o2.getIsPrimaryPost())
				.compareTo(o1.getIsPrimaryPost());
		Collections.sort(postMapDtos, compareById);
		edpUserPostDto.setPostMapDto(postMapDtos);
		return edpUserPostDto;
	}

	/**
	 * Gets the edp user post dto from employee entity.
	 *
	 * @param employeeEntity the employee entity
	 * @return the edp user post dto from employee entity
	 */
	private EDPUserPostDto getEdpUserPostDtoFromEmployeeEntity(EDPEmployeEntity employeeEntity) {
		EDPUserPostDto edpUserPostDto = new EDPUserPostDto();
		edpUserPostDto.setEmpId(employeeEntity.getEmpId());
		edpUserPostDto.setName(EDPUtility.getEmployeeNameFromEmployeeEntity(employeeEntity));
		edpUserPostDto.setUserCode(employeeEntity.getEmployeeCode());
		return edpUserPostDto;
	}

	/**
	 * Map objects to post map dto.
	 *
	 * @param objects the objects
	 * @return true, if successful
	 */
	private List<EDPPostMapDto> mapObjectsToPostMapDto(List<Object[]> objects) {
		List<EDPPostMapDto> postMapListDto = new ArrayList<>();
		for (Object[] object : objects) {
			EDPPostMapDto postMapDto = getEDPPostMapDto(object);
			postMapListDto.add(postMapDto);
		}
		return postMapListDto;
	}

	/**
	 * Change post.
	 *
	 * @param dto the dto
	 * @return the EDP user post dto
	 * @throws CustomException the custom exception
	 */
	public Boolean changePost(EDPIdDto dto) throws CustomException {
		try {
			Optional<EDPLkPoOffUserEntity> opUserOfficeEntity = edpLkPoOffUserRepository
					.findByUserIdUserIdAndActiveStatusAndIsPrimaryPostLookUpInfoName(dto.getUserId(),
							Constant.ACTIVE_STATUS, Constant.LOOKUP_YES);
			if (opUserOfficeEntity.isPresent()) {
				EDPLkPoOffUserEntity userOfficeEntity = opUserOfficeEntity.get();
				userOfficeEntity.setIsPrimaryPost(new EDPLuLookUpInfoEntity(1l));
				edpLkPoOffUserRepository.save(userOfficeEntity);
				Optional<EDPLkPoOffUserEntity> secOpUserOfficeEntity = edpLkPoOffUserRepository
						.findByLkPostOfficeIdPostOfficeIdAndUserIdUserIdAndActiveStatus(dto.getLkPoOffId(),
								dto.getUserId(), Constant.ACTIVE_STATUS);
				if (secOpUserOfficeEntity.isPresent()) {
					EDPLkPoOffUserEntity secUserOfficeEntity = secOpUserOfficeEntity.get();
					secUserOfficeEntity.setIsPrimaryPost(new EDPLuLookUpInfoEntity(2l));
					edpLkPoOffUserRepository.save(userOfficeEntity);
				}
				return true;
			} else {
				throw new CustomException(ErrorResponse.INVALID_JSON_FORMAT);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Gets the vacant post.
	 *
	 * @param idDto the id dto
	 * @return the vacant post
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPPostMapDto> getVacantPost(EDPIdDto idDto) throws CustomException {
		List<EDPPostMapDto> postMapDtos = new ArrayList<>();
		EDPMsOfficeDto edpMsOfficeDto = OAuthUtility.getCurrentUserOfficeOauthToken();

		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(EDPConstant.IN_OFFICE_ID_VALUE,
				null != idDto.getOfficeId() ? idDto.getOfficeId() : edpMsOfficeDto.getOfficeId());
		argsMap.put(EDPConstant.IN_IS_VACANT_POST, EDPConstant.LOOKUP_NAME_YES);
		argsMap.put(EDPConstant.IN_STATUS, EDPConstant.LK_STATUS_VAL_APPROVED);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_OFFICE_VACANT_POST_DTLS));
		List<Object[]> objects = edpLkPostUserRepository.callStoredProcedure(procName, argsMap);

		if (!CollectionUtils.isEmpty(objects)) {
			for (Object[] object : objects) {
				EDPPostMapDto postMapDto = new EDPPostMapDto();
				postMapDto.setLkPoOffId(
						object[0] != null ? Long.parseLong(String.valueOf(object[0])) : EDPConstant.VALUE_ZERO);
				postMapDto.setPostId(
						object[1] != null ? Long.parseLong(String.valueOf(object[1])) : EDPConstant.VALUE_ZERO);
				postMapDto.setPostName(String.valueOf(object[2]));
				postMapDto.setUserName(object[5] != null ? String.valueOf(object[5]) : "");
				postMapDto.setChecked(true);
				postMapDtos.add(postMapDto);
			}
		}

		return getDistictList(postMapDtos);
	}

	/**
	 * Gets the distict list.
	 *
	 * @param postMapDtos the post map dtos
	 * @return the distict list
	 */
	private List<EDPPostMapDto> getDistictList(List<EDPPostMapDto> postMapDtos) {
		return new ArrayList<>(postMapDtos.stream().collect(Collectors.toCollection(() -> new TreeSet<EDPPostMapDto>(
				(p1, p2) -> Long.valueOf(p1.getLkPoOffId()).compareTo(Long.valueOf(p2.getLkPoOffId()))))));
	}

	/**
	 * Search listfor upd dsg.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPUsrPoTrnsSearchViewDto> searchListforUpdDsg(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> argsMap = EDPUtility.populateArgumentsWfList(pageDetail, 6);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_USER_POST_TRANSFRER));
			List<Object[]> objectSp = edpUsrPoTrnsRepository.callStoredProcedure(procName, argsMap);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, objectSp.isEmpty() ? 0 : objectSp.size(),
					NativeQueryResultsMapper.map(objectSp, EDPUsrPoTrnsSearchViewDto.class));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Employee search sp call.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	private List<Object[]> employeeSearchSpCall(EDPIdDto dto) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(EDPConstant.IN_USER_CODE, dto.getUserCode());
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_EMP_POST_OFFICE_DETAILS));
		return edpLkPoOffUserRepository.callStoredProcedure(procName, argsMap);
	}

	/**
	 * Gets the employee name from sp response.
	 *
	 * @param object the object
	 * @return the employee name from sp response
	 */
	private String getEmployeeNameFromSpResponse(Object[] object) {
		StringBuilder stringBuilder = new StringBuilder();
		if (null != object[2]) {
			stringBuilder.append(object[2]);
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (null != object[3]) {
			stringBuilder.append(object[3]);
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (null != object[4]) {
			stringBuilder.append(object[4]);
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		if (null != object[5]) {
			stringBuilder.append(object[5]);
			stringBuilder.append(Constant.SINGLE_SPACE);
		}
		return stringBuilder.toString();
	}

	/**
	 * Gets the EDP post map dto.
	 *
	 * @param object the object
	 * @return the EDP post map dto
	 */
	private EDPPostMapDto getEDPPostMapDto(Object[] object) {
		EDPPostMapDto postMapDto = new EDPPostMapDto();
		postMapDto.setLkPoOffId(object[11] != null ? Long.parseLong(String.valueOf(object[11])) : 0);
		postMapDto.setPostId(object[7] != null ? Long.parseLong(String.valueOf(object[7])) : 0);
		postMapDto.setPostName(object[8] != null ? String.valueOf(object[8]) : "");
		postMapDto.setOfficeId(object[9] != null ? Long.parseLong(String.valueOf(object[9])) : 0);
		if (null != object[6] && String.valueOf(object[6]).equalsIgnoreCase(EDPConstant.LOOKUP_YES)) {
			postMapDto.setIsPrimaryPost(Boolean.TRUE);
			postMapDto.setPostType(EDPConstant.PRIMARY_POST);
		} else {
			postMapDto.setIsPrimaryPost(Boolean.FALSE);
			postMapDto.setPostType(EDPConstant.SECONDARY_POST);
		}
		postMapDto.setOfficeName(String.valueOf(object[10]));
		postMapDto.setLkPoOffId(object[11] != null ? Long.parseLong(String.valueOf(object[11])) : 0);
		postMapDto.setDistrictId(object[13] != null ? Long.parseLong(String.valueOf(object[13])) : 0);
		return postMapDto;
	}

	/**
	 * Sets the in same office in EDP post map dto.
	 *
	 * @param postMapDtos the post map dtos
	 * @param dto         the dto
	 */
	private void setInSameOfficeInEDPPostMapDto(List<EDPPostMapDto> postMapDtos, EDPIdDto dto) {
		EDPMsOfficeDto currentUserOffice = OAuthUtility.getCurrentUserOfficeOauthToken();
		boolean isDatOffice = !StringUtils.isEmpty(currentUserOffice.getOfficeDivision())
				&& currentUserOffice.getOfficeDivision().equalsIgnoreCase(EDPConstant.DAT_OFFICE);
		Optional<EDPPostMapDto> primaryPostDto = postMapDtos.stream().filter(EDPPostMapDto::getIsPrimaryPost)
				.findFirst();
		postMapDtos.forEach(postDto -> {
			if (null != dto.getOfficeId() && dto.getOfficeId() == postDto.getOfficeId()) {
				postDto.setIsSameOffice(Boolean.TRUE);
			} else {
				if (isDatOffice && postDto.getOfficeId() == primaryPostDto.get().getOfficeId()
						&& null == dto.getOfficeId()) {
					postDto.setIsSameOffice(Boolean.TRUE);
				} else if (!isDatOffice && postDto.getOfficeId() == currentUserOffice.getOfficeId()
						&& null == dto.getOfficeId()) {
					postDto.setIsSameOffice(Boolean.TRUE);
				} else {
					postDto.setIsSameOffice(Boolean.FALSE);
				}
			}
		});
	}

	/**
	 * Gets the error message.
	 *
	 * @param requestdList the requestd list
	 * @param dto          the dto
	 * @return the error message
	 */
	private String getErrorMessage(List<Object[]> requestdList, EDPIdDto dto) {
		List<Object[]> userData = edpUsrPoTrnsRepository
				.findUserNameAndPostNameAndOfficeByLkpouId(EDPUtility.convertObjectToLong(requestdList.get(0)[0]));
		List<String> empnoString = Arrays.asList(EDPUtility.convertObjectToString(userData.get(0)[0]).split(","));
		StringBuilder byEmpNo = new StringBuilder();
		for (Object str : empnoString) {
			byEmpNo.append(str);
		}

		return MessageFormat.format(MsgConstant.EDP_REQUEST_INITIATE_POST_TRANSFER_EMPLOYEE, dto.getUserCode(),
				byEmpNo.toString(), userData.get(0)[1], userData.get(0)[2], userData.get(0)[3], userData.get(0)[4],
				userData.get(0)[5], EDPUtility.convertObjectToLong(userData.get(0)[6]), requestdList.get(0)[2]);
	}

	/**
	 * Submit.
	 *
	 * @param edpUsrPoTrnsEntityList the edp usr po trns entity list
	 * @throws CustomException the custom exception 1. Update Post Vacancy status 2.
	 *                         Inactive previous user 3. Create Post-Office-User for
	 *                         new user 4. Insert row into Itr Table
	 */
	public void submitRequest(List<EDPUsrPoTrnsEntity> edpUsrPoTrnsEntityList,
			EDPUsrPoTrnsHeaderDto edpUsrPoTrnsHeaderDto) throws CustomException {
		List<EDPUsrPoTrnsEntity> entityList = edpUsrPoTrnsEntityList.stream()
				.filter(entity -> entity.getActiveStatus() == 1).collect(Collectors.toList());
		if (!CollectionUtils.isEmpty(entityList)) {
			EDPUsrPoTrnsEntity singalEntity = entityList.get(0);
			EDPMsUserEntity userEntity = getToUserEntity(singalEntity);
			saveTransactionDataSpCall(edpUsrPoTrnsHeaderDto, userEntity);
			if (null == singalEntity.getToUserId() && null == singalEntity.getToEmpId()
					&& null != singalEntity.getFromUserId()) {
				updatePostAsVacantPostAndDeActiveFromUser(singalEntity.getFromUserId().getUserId(), entityList);
			} else if ((null != singalEntity.getToUserId() || null != singalEntity.getToEmpId())
					&& null == singalEntity.getFromUserId()) {
				updatePostFromVacantToUserOrEmployee(entityList, userEntity);
			} else if ((null != singalEntity.getToUserId() || null != singalEntity.getToEmpId())
					&& null != singalEntity.getFromUserId()) {
				updatePostFromUserToUserOrEmployee(entityList, userEntity);
			}
		}
	}

	/**
	 * Update post as vacant post and de active from user.
	 *
	 * @param fromUserId the from user id
	 * @param entityList the entity list
	 * @throws CustomException the custom exception
	 */
	private void updatePostAsVacantPostAndDeActiveFromUser(Long fromUserId, List<EDPUsrPoTrnsEntity> entityList)
			throws CustomException {
		try {
			Set<Long> lkPostOfficeId = entityList.stream().map(entity -> entity.getPostOfficeId().getPostOfficeId())
					.collect(Collectors.toSet());
			edpLkPostOfficeRepository.updateLkPostOfficeAsVacantPost(EDPConstant.LOOKUP_INFO_YES,
					OAuthUtility.getCurrentUserUserId(), new Date(), lkPostOfficeId,
					OAuthUtility.getCurrentUserLkPOUId());

			edpLkPoOffUserRepository.multipalUpdateActiveStatus(lkPostOfficeId, Constant.IN_ACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), OAuthUtility.getCurrentUserLkPOUId(), new Date());
			deactiveUserIfNoPostActive(fromUserId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Update post from vacant to user or employee.
	 *
	 * @param edpUsrPoTrnsEntity the edp usr po trns entity list
	 * @param entityList         the entity list
	 * @throws CustomException the custom exception
	 */
	private void updatePostFromVacantToUserOrEmployee(List<EDPUsrPoTrnsEntity> entityList, EDPMsUserEntity userEntity)
			throws CustomException {
		try {
			insertOrUpdateLkPoOffUserEntityForVacantToUser(entityList, userEntity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Deactive user if no post active.
	 *
	 * @param userId the user id
	 */
	private void deactiveUserIfNoPostActive(Long userId) {
		List<EDPLkPoOffUserEntity> lkPoOffUserList = edpLkPoOffUserRepository.findByUserIdUserIdAndActiveStatus(userId,
				Constant.ACTIVE_STATUS);
		if (CollectionUtils.isEmpty(lkPoOffUserList)) {
			edpMsUserRepository.updateActiveStatus(Constant.IN_ACTIVE_STATUS, OAuthUtility.getCurrentUserUserId(),
					new Date(), OAuthUtility.getCurrentUserLkPOUId(), userId);
		}
	}

	/**
	 * Creates the user or get user from employee.
	 *
	 * @param employeeId the employee id
	 * @return the EDP ms user entity
	 * @throws CustomException the custom exception
	 */
	private EDPMsUserEntity createUserOrGetUserFromEmployee(EDPEmployeEntity employeeId) throws CustomException {
		try {
			EDPLkEmpUserEntity lkUserEmployeeEntit = edpLkEmpUserRepository.findByEmpIdEmpId(employeeId.getEmpId());
			if (null != lkUserEmployeeEntit) {
				return checkAndUpdateActiveStatusOfEmployeeMapping(lkUserEmployeeEntit);
			} else {
				EDPEmployeEntity edpEmployeEntity = edpEmployeRepository.getOne(employeeId.getEmpId());
				EDPMsUserEntity edpMsUserEntity = edpMsUserRepository
						.findByUserCodeAndActiveStatus(edpEmployeEntity.getEmployeeCode(), Constant.ACTIVE_STATUS);

				if (null != edpMsUserEntity && edpMsUserEntity.getActiveStatus() == 1) {
					insertIntoEDPLkEmpUserEntity(edpMsUserEntity.getUserId(), employeeId.getEmpId());
					return edpMsUserEntity;
				} else if (null != edpMsUserEntity) {
					edpMsUserEntity.setActiveStatus(Constant.ACTIVE_STATUS);
					insertIntoEDPLkEmpUserEntity(edpMsUserEntity.getUserId(), employeeId.getEmpId());
					return edpMsUserRepository.save(edpMsUserEntity);
				} else {
					return createUserFromEmp(edpEmployeEntity);
				}
			}
		} catch (Exception ex) {
			logger.error("Error occured while fatching/ creating user.", ex);
			throw new CustomException(ErrorResponse.UNKNOWN_ERROR_OCCURED);
		}
	}

	/**
	 * Check and update active status of employee mapping.
	 *
	 * @param lkUserEmployeeEntit the lk user employee entit
	 * @return the EDP ms user entity
	 */
	private EDPMsUserEntity checkAndUpdateActiveStatusOfEmployeeMapping(EDPLkEmpUserEntity lkUserEmployeeEntit) {
		if (lkUserEmployeeEntit.getActiveStatus() != Constant.ACTIVE_STATUS) {
			lkUserEmployeeEntit.setActiveStatus(Constant.ACTIVE_STATUS);
			edpLkEmpUserRepository.save(lkUserEmployeeEntit);
		}
		Optional<EDPMsUserEntity> user = edpMsUserRepository.findById(lkUserEmployeeEntit.getUserId().getUserId());
		if (user.isPresent() && user.get().getActiveStatus() == 1) {
			return user.get();
		} else if (user.isPresent()) {
			EDPMsUserEntity userEntity = user.get();
			userEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			return edpMsUserRepository.save(userEntity);
		}
		return lkUserEmployeeEntit.getUserId();
	}

	/**
	 * Insert into EDP lk emp user entity.
	 *
	 * @param userId  the user id
	 * @param toEmpId the to emp id
	 * @return the EDP lk emp user entity
	 */
	private EDPLkEmpUserEntity insertIntoEDPLkEmpUserEntity(Long userId, Long toEmpId) {
		EDPLkEmpUserEntity edpLkEmpUserEntity = new EDPLkEmpUserEntity();
		edpLkEmpUserEntity.setUserId(new EDPMsUserEntity(userId));
		edpLkEmpUserEntity.setEmpId(new EDPEmployeEntity(toEmpId));
		return edpLkEmpUserRepository.save(edpLkEmpUserEntity);
	}

	/**
	 * Creates the user from emp.
	 *
	 * @param edpEmployeEntity the edp employe entity
	 * @return the EDP ms user entity
	 */
	private EDPMsUserEntity createUserFromEmp(EDPEmployeEntity edpEmployeEntity) {
		EDPMsUserEntity userEntity = edpMsUserConverter
				.employeeToUserDto(edpEmployeConverter.toClueDto(edpEmployeEntity));
		userEntity = edpMsUserRepository.save(userEntity);
		insertIntoEDPLkEmpUserEntity(userEntity.getUserId(), edpEmployeEntity.getEmpId());
		return userEntity;
	}

	/**
	 * Insert into lk po off itr.
	 *
	 * @param lkPoOffUserEntity the lk po off user entity
	 */
	private void insertIntoLkPoOffItr(EDPLkPoOffUserEntity lkPoOffUserEntity) {
		EDPLkPoOffUserItrEntity itrEntity = new EDPLkPoOffUserItrEntity();
		BeanUtils.copyProperties(lkPoOffUserEntity, itrEntity);
		itrEntity.setLkPoOffUserId(lkPoOffUserEntity);
		itrEntity.setMenuId(EDPConstant.POST_TRANSFER_MENU_ID);
		edpLkPoOffUserItrRepository.save(itrEntity);
	}

	/**
	 * Insert or update lk po off user entity for vacant to user.
	 *
	 * @param entityList the entity list
	 * @param userEntity the user entity
	 */
	private void insertOrUpdateLkPoOffUserEntityForVacantToUser(List<EDPUsrPoTrnsEntity> entityList,
			EDPMsUserEntity userEntity) {
		Set<Long> lkPostOfficeId = entityList.stream().map(entity -> entity.getPostOfficeId().getPostOfficeId())
				.collect(Collectors.toSet());
		List<EDPLkPoOffUserEntity> lkPoOffUserEntityList;
		if (null == entityList.get(0).getFromUserId()) {
			edpLkPostOfficeRepository.updateLkPostOfficeAsVacantPost(EDPConstant.LOOKUP_INFO_NO,
					OAuthUtility.getCurrentUserUserId(), new Date(), lkPostOfficeId,
					OAuthUtility.getCurrentUserLkPOUId());

			lkPoOffUserEntityList = edpLkPoOffUserRepository.findByLkPostOfficeIdAndUserIdValueAsNull(lkPostOfficeId);
		}else{
			lkPoOffUserEntityList = edpLkPoOffUserRepository
					.findByActiveStatusAndLkPostOfficeIdPostOfficeIdIn(Constant.ACTIVE_STATUS, lkPostOfficeId);
		}
		EDPLkPoOffUserEntity primaryPost = edpLkPoOffUserRepository
				.findByUserIdUserIdAndIsPrimaryPostLookUpInfoIdAndActiveStatus(userEntity.getUserId(),
						EDPConstant.LOOKUP_INFO_YES, Constant.ACTIVE_STATUS);
		boolean isPrimaryPostInRequest = Boolean.FALSE;
		for (EDPUsrPoTrnsEntity entity : entityList) {
			Optional<EDPLkPoOffUserEntity> lkPoEntity = lkPoOffUserEntityList.stream().filter(lkEntity -> lkEntity
					.getLkPostOfficeId().getPostOfficeId().equals(entity.getPostOfficeId().getPostOfficeId()))
					.findFirst();
			if (!isPrimaryPostInRequest) {
				isPrimaryPostInRequest = EDPConstant.LOOKUP_INFO_YES.equals(entity.getWillBePrimary().getLookUpInfoId())
						? Boolean.TRUE
						: Boolean.FALSE;
			}
			if (lkPoEntity.isPresent()) {
				EDPLkPoOffUserEntity lkPoOffUserEntity = lkPoEntity.get();
				lkPoOffUserEntity.setUserId(userEntity);
				lkPoOffUserEntity.setIsPrimaryPost(entity.getWillBePrimary());
				lkPoOffUserEntity.setActiveStatus(Constant.ACTIVE_STATUS);
				lkPoOffUserEntity = edpLkPoOffUserRepository.save(lkPoOffUserEntity);
				insertIntoLkPoOffItr(lkPoOffUserEntity);
			} else {
				EDPLkPoOffUserEntity lkPoOffUserEntity = getNewLkPoOffUserEntityFromEDPUsrPoTrnsEntity(entity,
						userEntity);
				lkPoOffUserEntity = edpLkPoOffUserRepository.save(lkPoOffUserEntity);
				insertIntoLkPoOffItr(lkPoOffUserEntity);
			}
		}
		if (isPrimaryPostInRequest && null != primaryPost) {
			primaryPost.setIsPrimaryPost(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
			edpLkPoOffUserRepository.save(primaryPost);
		}
	}

	/**
	 * Gets the new lk po off user entity from EDP usr po trns entity.
	 *
	 * @param entity     the entity
	 * @param userEntity the user entity
	 * @return the new lk po off user entity from EDP usr po trns entity
	 */
	private EDPLkPoOffUserEntity getNewLkPoOffUserEntityFromEDPUsrPoTrnsEntity(EDPUsrPoTrnsEntity entity,
			EDPMsUserEntity userEntity) {
		EDPLkPoOffUserEntity lkEntity = new EDPLkPoOffUserEntity();
		lkEntity.setIsPrimaryPost(entity.getWillBePrimary());
		lkEntity.setLkPostOfficeId(entity.getPostOfficeId());
		lkEntity.setUserId(userEntity);
		return lkEntity;
	}

	/**
	 * Update post from user to user or employee.
	 *
	 * @param edpUsrPoTrnsEntity the edp usr po trns entity
	 * @param entityList         the entity list
	 * @throws CustomException the custom exception
	 */
	private void updatePostFromUserToUserOrEmployee(List<EDPUsrPoTrnsEntity> entityList, EDPMsUserEntity userEntity)
			throws CustomException {
		try {
			insertOrUpdateLkPoOffUserEntityForVacantToUser(entityList, userEntity);
			deactiveUserIfNoPostActive(entityList.get(0).getFromUserId().getUserId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE);
		}
	}

	/**
	 * Gets the to user entity.
	 *
	 * @param singalEntity the singal entity
	 * @return the to user entity
	 * @throws CustomException
	 */
	private EDPMsUserEntity getToUserEntity(EDPUsrPoTrnsEntity singalEntity) throws CustomException {
		boolean isTransferToUser = null != singalEntity.getToUserId() ? Boolean.TRUE : Boolean.FALSE;
		EDPMsUserEntity userEntity = isTransferToUser ? singalEntity.getToUserId() : null;
		if (!isTransferToUser && null != singalEntity.getToEmpId() && null != singalEntity.getToEmpId().getEmpId()) {
			userEntity = createUserOrGetUserFromEmployee(singalEntity.getToEmpId());
		}
		return userEntity;
	}

	/**
	 * Save transaction data sp call.
	 *
	 * @param saveHeaderDto the save header dto
	 */
	private void saveTransactionDataSpCall(EDPUsrPoTrnsHeaderDto saveHeaderDto, EDPMsUserEntity userEntity)
			throws CustomException {
		try {
			edpTedpUptTrnDataRepository.updateActiveStatusByHeaderId(Constant.ACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new Date(), saveHeaderDto.getEdpUsrPoTrnsHeaderId(),
					OAuthUtility.getCurrentUserLkPOUId());
			Map<String, Object> argsMap = getArgsMapForSaveTransactionDataSp(saveHeaderDto, userEntity);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_UPT_TRN_DATA_INSERT));
			edpLkPostUserRepository.callStoredProcedureWithNoResult(procName, argsMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CALL_SP);
		}
	}

	/**
	 * Gets the args map for save transaction data sp.
	 *
	 * @param saveHeaderDto the save header dto
	 * @param fromUserId    the from user id
	 * @return the args map for save transaction data sp
	 */
	private Map<String, Object> getArgsMapForSaveTransactionDataSp(EDPUsrPoTrnsHeaderDto saveHeaderDto,
			EDPMsUserEntity userEntity) {
		Long fromUserId = null != saveHeaderDto.getFromUserId() ? saveHeaderDto.getFromUserId() : 0l;
		Long toUserId = null != userEntity ? userEntity.getUserId() : 0l;
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(EDPConstant.IN_HDR_ID, saveHeaderDto.getEdpUsrPoTrnsHeaderId());
		argsMap.put(EDPConstant.IN_FROM_USER_ID, fromUserId);
		argsMap.put(EDPConstant.IN_TO_USER_ID, toUserId);
		argsMap.put(EDPConstant.IN_CREATED_BY, OAuthUtility.getCurrentUserUserId());
		argsMap.put(EDPConstant.IN_CREATED_BY_POST, OAuthUtility.getCurrentUserLoginPostFromOauthToken().getPostId());
		argsMap.put(EDPConstant.IN_UPDATED_BY_POST, OAuthUtility.getCurrentUserLkPOUId());
		argsMap.put(EDPConstant.IN_LK_POST_OFFICE_ID,
				saveHeaderDto.getEdpUsrPoTrnsDetailDto().get(0).getPostOfficeId());
		return argsMap;
	}

	/**
	 * Gets the approve post user mapping by header id.
	 *
	 * @param edpUsrTrnHeaderId the edp usr trn header id
	 * @return the approve post user mapping by header id
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPUsrPoTrnsHeaderDto getApprovePostUserMappingByHeaderId(Long edpUsrTrnHeaderId) throws CustomException {
		try {
			return getApproveRequestList(edpUsrTrnHeaderId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Gets the approve request list.
	 *
	 * @param headerId the header id
	 * @return the approve request list
	 * @throws CustomException the custom exception
	 */
	private EDPUsrPoTrnsHeaderDto getApproveRequestList(Long headerId) throws CustomException {
		try {
			List<Object[]> postOfficeUserList = getUserPostMappingDetailsSpCall(headerId);
			List<Object[]> trnData = getUserPostTrnDataViewSpCall(headerId);
			EDPUsrPoTrnsHeaderDto headerDto = new EDPUsrPoTrnsHeaderDto();
			if (!postOfficeUserList.isEmpty()) {
				Object[] pou = postOfficeUserList.get(0);
				headerDto.setOfficeId(EDPUtility.convertObjectToLong(pou[7]));
				headerDto.setTrnNo(EDPUtility.convertObjectToString(pou[8]));
				headerDto.setEdpUsrPoTrnsHeaderId(EDPUtility.convertObjectToLong(pou[9]));
				headerDto.setCreatedDate(EDPUtility.getDateValue(EDPUtility.convertObjectToString(pou[10])));
				headerDto.setDistrictId(EDPUtility.convertObjectToLong(pou[13]));
				headerDto.setStatusId(EDPUtility.convertObjectToLong(pou[14]));
				headerDto.setOfficeName(EDPUtility.convertObjectToString(pou[15]));
				List<ClueDto> detailDtoList = getDetailsDto(postOfficeUserList);
				headerDto.setDetailDto(detailDtoList);
				if (null != pou[3]) {
					setFromUserData(headerDto, pou, trnData);
				} else {
					headerDto.setVacantPostsDto(getVacantDataFromTrnData(trnData));
				}
				if (null != pou[5])
					setToUserData(headerDto, pou, trnData);
				if (null != pou[18]) {
					setToEmpData(headerDto, pou);
				}
				setWorkflowParams(pou, headerDto);
			}
			return headerDto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the user post mapping details sp call.
	 *
	 * @param headerId the header id
	 * @return the user post mapping details sp call
	 */
	private List<Object[]> getUserPostMappingDetailsSpCall(Long headerId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(Constant.IN_HDR_ID, headerId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_GET_USER_POST_MAPPING_DETAILS));
		return edpLkPostUserRepository.callStoredProcedure(procName, paramMap);
	}

	/**
	 * Gets the user post trn data view sp call.
	 *
	 * @param headerId the header id
	 * @return the user post trn data view sp call
	 */
	private List<Object[]> getUserPostTrnDataViewSpCall(Long headerId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put(Constant.IN_HDR_ID, headerId);
		String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_UPT_TRN_DATA_VIEW));
		return edpTedpUptTrnDataRepository.callStoredProcedure(procName, paramMap);
	}

	/**
	 * Gets the details dto.
	 *
	 * @param postOfficeUserList the post office user list
	 * @return the details dto
	 */
	private List<ClueDto> getDetailsDto(List<Object[]> postOfficeUserList) {
		return postOfficeUserList.stream().map(pouData -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setTedpUptId(EDPUtility.convertObjectToLong(pouData[17]));
			clueDto.setWillBePrimary(
					(EDPUtility.convertObjectToLong(pouData[2]).equals(EDPConstant.LONG_VALUE_ONE)) ? Boolean.FALSE
							: Boolean.TRUE);
			clueDto.setPostOfficeId(EDPUtility.convertObjectToLong(pouData[0]));
			return clueDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Sets the from user data.
	 *
	 * @param headerDto the header dto
	 * @param pou       the pou
	 * @param trnData   the trn data
	 */
	private void setFromUserData(EDPUsrPoTrnsHeaderDto headerDto, Object[] pou, List<Object[]> trnData) {
		headerDto.setFromUserId(EDPUtility.convertObjectToLong(pou[3]));
		headerDto.setFromUserName(EDPUtility.convertObjectToString(pou[4]));
		headerDto.setFromUserCode(EDPUtility.convertObjectToString(pou[11]));
		headerDto.setFromUserPost(getUserDataFromTrnData(trnData, headerDto.getOfficeId(), Boolean.TRUE));
	}

	/**
	 * Sets the to user data.
	 */
	private void setToUserData(EDPUsrPoTrnsHeaderDto headerDto, Object[] pou, List<Object[]> trnData) {
		headerDto.setToUserId(EDPUtility.convertObjectToLong(pou[5]));
		headerDto.setToUserName(EDPUtility.convertObjectToString(pou[6]));
		headerDto.setToUserCode(EDPUtility.convertObjectToString(pou[12]));
		headerDto.setToUserPost(getUserDataFromTrnData(trnData, headerDto.getOfficeId(), Boolean.FALSE));
	}

	private void setToEmpData(EDPUsrPoTrnsHeaderDto headerDto, Object[] pou) {
		headerDto.setToEmpId(EDPUtility.convertObjectToLong(pou[18]));
		headerDto.setToUserCode(EDPUtility.convertObjectToString(pou[19]));
		headerDto.setToUserName(EDPUtility.convertObjectToString(pou[20]));
	}

	private EDPUserPostDto getUserDataFromTrnData(List<Object[]> trnData, Long officeId, boolean isFromUser) {
		EDPUserPostDto edpUserPostDto = new EDPUserPostDto();
		List<EDPPostMapDto> postMapDtos = trnData.stream()
				.filter(obj -> (isFromUser && null != obj[4]) || (!isFromUser && null != obj[6]))
				.map(obj -> getEDPMsPOstMapDtoFromTrnData(obj, officeId)).collect(Collectors.toList());
		Comparator<EDPPostMapDto> compareById = (EDPPostMapDto o1, EDPPostMapDto o2) -> (o2.getIsPrimaryPost())
				.compareTo(o1.getIsPrimaryPost());
		Collections.sort(postMapDtos, compareById);
		edpUserPostDto.setPostMapDto(postMapDtos);
		return edpUserPostDto;
	}

	/**
	 * Gets the EDP ms P ost map dto from trn data.
	 *
	 * @param obj the obj
	 * @return the EDP ms P ost map dto from trn data
	 */
	private EDPPostMapDto getEDPMsPOstMapDtoFromTrnData(Object[] obj, Long officeId) {
		EDPPostMapDto postMapDto = new EDPPostMapDto();
		postMapDto.setLkPoOffId(obj[1] != null ? Long.parseLong(String.valueOf(obj[1])) : 0);
		postMapDto.setPostId(obj[3] != null ? Long.parseLong(String.valueOf(obj[3])) : 0);
		postMapDto.setPostName(obj[2] != null ? String.valueOf(obj[2]) : EDPConstant.EMPTY_STRING);
		postMapDto.setOfficeId(obj[10] != null ? Long.parseLong(String.valueOf(obj[10])) : 0);
		if (null != obj[9] && String.valueOf(obj[9]).equalsIgnoreCase(EDPConstant.LOOKUP_YES)) {
			postMapDto.setIsPrimaryPost(Boolean.TRUE);
			postMapDto.setPostType(EDPConstant.PRIMARY_POST);
		} else {
			postMapDto.setIsPrimaryPost(Boolean.FALSE);
			postMapDto.setPostType(EDPConstant.SECONDARY_POST);
		}
		postMapDto.setLkPoOffId(obj[1] != null ? Long.parseLong(String.valueOf(obj[1])) : 0);
		postMapDto.setIsSameOffice(officeId.equals(postMapDto.getOfficeId()) ? Boolean.TRUE : Boolean.FALSE);
		return postMapDto;
	}

	/**
	 * Gets the vacant data from trn data.
	 *
	 * @param trnData the trn data
	 * @return the vacant data from trn data
	 */
	private List<EDPPostMapDto> getVacantDataFromTrnData(List<Object[]> trnData) {

		return trnData.stream().filter(obj -> null == obj[4] && null == obj[6]).map(obj -> {
			EDPPostMapDto postMapDto = new EDPPostMapDto();
			postMapDto.setLkPoOffId(obj[1] != null ? Long.parseLong(String.valueOf(obj[1])) : 0);
			postMapDto.setPostId(obj[3] != null ? Long.parseLong(String.valueOf(obj[3])) : 0);
			postMapDto.setPostName(obj[2] != null ? String.valueOf(obj[2]) : EDPConstant.EMPTY_STRING);
			postMapDto.setOfficeId(obj[10] != null ? Long.parseLong(String.valueOf(obj[10])) : 0);
			postMapDto.setLkPoOffId(obj[1] != null ? Long.parseLong(String.valueOf(obj[1])) : 0);
			return postMapDto;
		}).collect(Collectors.toList());
	}

	/**
	 * Gets the submit popup details.
	 *
	 * @param headerId the header id
	 * @return the submit popup details
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPHeaderParam> getSubmitPopupDetails(Long headerId) throws CustomException {
		List<EDPHeaderParam> headerParams = new ArrayList<>();

		List<Object[]> hdrDetails = getUserPostMappingDetailsSpCall(headerId);

		if (!hdrDetails.isEmpty()) {
			Object[] pou = hdrDetails.get(0);

			if (null != pou[3]) {
				headerParams.add(setHeaderParam(EDPConstant.POST_TRANSFER_FROM, EDPConstant.EMPLOYEE_NO_STRING));
				headerParams.add(setHeaderParam(EDPConstant.FROM_EMP_NO, EDPUtility.convertObjectToString(pou[11])));
				headerParams.add(setHeaderParam(EDPConstant.FROM_EMP_NAME, EDPUtility.convertObjectToString(pou[4])));
			} else {
				headerParams.add(setHeaderParam(EDPConstant.POST_TRANSFER_FROM, EDPConstant.VACANT_POST_STRING));
				headerParams.add(setHeaderParam(EDPConstant.FROM_EMP_NO, EDPUtility.getDashWithSpace()));
				headerParams.add(setHeaderParam(EDPConstant.FROM_EMP_NAME, EDPUtility.getDashWithSpace()));
			}

			if (null != pou[5]) {
				headerParams.add(setHeaderParam(EDPConstant.POST_TRANSFER_TO, EDPConstant.EMPLOYEE_NO_STRING));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NO, EDPUtility.convertObjectToString(pou[12])));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NAME, EDPUtility.convertObjectToString(pou[6])));

			} else if (null != pou[18]) {
				headerParams.add(setHeaderParam(EDPConstant.POST_TRANSFER_TO, EDPConstant.EMPLOYEE_NO_STRING));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NO, EDPUtility.convertObjectToString(pou[19])));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NAME, EDPUtility.convertObjectToString(pou[20])));
			} else {
				headerParams.add(setHeaderParam(EDPConstant.POST_TRANSFER_TO, EDPConstant.VACANT_POST_STRING));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NO, EDPUtility.getDashWithSpace()));
				headerParams.add(setHeaderParam(EDPConstant.TO_EMP_NAME, EDPUtility.getDashWithSpace()));
			}
			headerParams.add(setHeaderParam(EDPConstant.DISTRICT, EDPUtility.convertObjectToString(pou[23])));
			headerParams.add(setHeaderParam(EDPConstant.DDO_NO, EDPUtility.convertObjectToString(pou[21])));
			headerParams.add(setHeaderParam(EDPConstant.CARDEX_NO, EDPUtility.convertObjectToString(pou[22])));
			headerParams.add(setHeaderParam(EDPConstant.OFFICE_NAME_STRING, EDPUtility.convertObjectToString(pou[15])));

		}
		return headerParams;
	}

	/**
	 * Sets the header param.
	 *
	 * @param label the label
	 * @param value the value
	 * @return the EDP header param
	 */
	private EDPHeaderParam setHeaderParam(String label, String value) {
		return new EDPHeaderParam(label, value);
	}

	/**
	 * Checks if is workflow required.
	 *
	 * @param officeId the office id
	 * @param userId the user id
	 * @return the boolean
	 */
	@Override
	public Boolean isWorkflowRequired(Long officeId, Long userId) {
		Set<Long> roleIds = OAuthUtility.getWfRoleUsingMenuId(EDPConstant.POST_TRANSFER_MENU_ID);
		if (null == userId)
			return Boolean.FALSE;
		else if (OAuthUtility.isCurrentUserIsDAT() && (roleIds.isEmpty() || roleIds.contains(45L)))
			return Boolean.FALSE;
		else
			return workflowRequiredCondition(officeId, userId);
	}

	/**
	 * Workflow required condition.
	 *
	 * @param officeId the office id
	 * @param userId the user id
	 * @return the boolean
	 */
	private Boolean workflowRequiredCondition(Long officeId, Long userId) {
		List<String> wfRoleNames = wfRoleRepository.findWfRolesForOfficeUserAndMenu(officeId,
				EDPConstant.POST_TRANSFER_MENU_ID, userId);
		if (!wfRoleNames.isEmpty() && (wfRoleNames.contains(EDPConstant.APPROVER_ROLE))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Gets the listing filter data.
	 *
	 * @return the listing filter data
	 */
	@Override
	public ClueDto getListingFilterData() {
		ClueDto officedetailsdto = new ClueDto();
		
		List<ClueDto> distList = districtConverter.toClueDTO(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ,
								EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC)));
		
		List<Object[]> dataList = edpUsrPoTrnsRepository.executeNativeSQLQuery(EDPNativeSQLUtil.GET_EDP_WF_TRN_STATUS_QUERY,null);
		Set<ClueDto> wfStatusSet = new HashSet<>();
		Set<ClueDto> trnStatusSet = new HashSet<>();
		dataList.forEach(obj->{
			if(null != obj[0]) 				
				trnStatusSet.add(getClueDtoForStatus(obj[0]));		
			if(null != obj[1]) 
				trnStatusSet.add(getClueDtoForStatus(obj[1]));	
			if(null != obj[2]) 			
				wfStatusSet.add(getClueDtoForStatus(obj[2]));	
			if(null != obj[3]) 
				wfStatusSet.add(getClueDtoForStatus(obj[3]));	
		});
        officedetailsdto.setDistricts(distList);
        List<ClueDto> wfStatusList = wfStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
		List<ClueDto> trnStatusList = trnStatusSet.stream().sorted((o1, o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        officedetailsdto.setTransStatusList(trnStatusList);
        officedetailsdto.setWorkFlowStatusList(wfStatusList);
	    return officedetailsdto;
	}
	
	/**
	 * Gets the clue dto for status.
	 *
	 * @param status the status
	 * @return the clue dto for status
	 */
	private ClueDto getClueDtoForStatus(Object status) {
		ClueDto dto = new ClueDto();
		dto.setStatusId(EDPUtility.convertObjectToString(status));
		dto.setName(EDPUtility.convertObjectToString(status));
		return dto;
	}
	
}
