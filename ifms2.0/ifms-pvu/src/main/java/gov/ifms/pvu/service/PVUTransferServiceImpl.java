package gov.ifms.pvu.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.logging.annotation.Trace;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.converter.EDPMsOfficeConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVUTransferConverter;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUTransferDto;
import gov.ifms.pvu.dto.PVUTransferEmployeeDetailsDto;
import gov.ifms.pvu.dto.PVUTransferEmployeeView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.pvu.entity.PVUTransferEntity;
import gov.ifms.pvu.repository.PVUTransferRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUTransferController.
 *
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */
@Service
public class PVUTransferServiceImpl implements PVUTransferService {

    /**
     * The logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private PVUTransferRepository repository;

    @Autowired
    private PVYFacade pvuFacade;

    @Autowired
    private PVUTransferConverter converter;


    /**
     * The office repository.
     */
    @Autowired
    private EDPMsOfficeRepository officeRepository;

    /**
     * The office converter.
     */
    @Autowired
    private EDPMsOfficeConverter officeConverter;

    /**
     * The district repository.
     */
    @Autowired
    private EDPMsDistrictRepository districtRepository;

    /**
     * The district converter.
     */
    @Autowired
    private EDPMsDistrictConverter districtConverter;

    @Autowired
    private EDPMsDesignationRepository eDPMsDesignationRepository;

    @Trace
    @Autowired
    private EDPMsDesignationConverter eDPMsDesignationConverter;

    @Autowired
    private PVUEmployeeEventStatusService pvuEmployeeEventStatusService;

    @Autowired
    private EDPLuLookUpInfoRepository lookUpInfoRepository;


    @Autowired
    private PVUEmployeEventsService pvuEmployeEventsService;



    /**
     * Retrieves an PVUTransferEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the PVUTransferEntity with the given id or {@literal null} if none
     * found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    @Override
    public PVUTransferEntity getTransferById(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given PVUTransferEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param dto the entity
     * @return the saved PVU4TransferEntity
     */
    @Transactional(rollbackFor = CustomException.class)
    @Override
    public PVUTransferDto saveOrUpdateTransfer(PVUTransferDto dto) throws CustomException {

        PVUTransferEntity entity = converter.toEntity(dto);
        EDPLuLookUpInfoEntity submitLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.SUBMIT);
        if (dto.getStatusId() == 0) {
            entity.setStatus(submitLookupInfo);
        }
        entity = repository.save(entity);
        long empNo = dto.getEmployeeNo();
        dto = this.converter.toDTO(entity);
        dto.setEmployeeNo(empNo);
        return dto;
    }
    @Transactional
    private void reset(Long empId) throws CustomException {
        PVUEmployeeEventStatusEntity employeeStatus = pvuEmployeeEventStatusService.findOneByEmpId(empId);
        employeeStatus.setTransfer(0);
        employeeStatus.setTransId(null);
        pvuEmployeeEventStatusService.saveOrUpdateEmployeeEventStatus(employeeStatus);
    }


    /**
     * Fetch all the PVUEmployeSuspension items with pagination.
     *
     * @param pageDetail the page detail
     * @return List<PVUEmployeSuspensionDto>
     * @throws CustomException the custom exception
     */
    @Override
    public PagebleDTO<PVUTransferEmployeeView> getJoiningTransferList(PageDetails pageDetail)
            throws CustomException {
        try {
            Map<String, Object> map = buildPageInMapList(pageDetail);
            String procName = Constant.PVU_SCHEMA
                    .concat(Constant.DOT.concat(PvuConstant.PVU_TRANSFER_JOINING_EMPLOYEES));
            List<PVUTransferEmployeeView> objStorePro = this.storeProcPvu(procName, map);
            int totalPages = objStorePro.size();
            return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Gets the pvu search fields.
     *
     * @return the pvu search fields
     */
    @Override
    public List<PVUSearchEnum> getPvuSearchFields() {
        return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE,
                PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
                PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
                PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION, PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO,
                PVUSearchEnum.PVU_SEARCH_FIELD_CPF_NO,
                PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT,
                PVUSearchEnum.PVU_SEARCH_CARDEX,
                PVUSearchEnum.PVU_SEARCH_DDO,
                PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE);
    }
    public List<PVUTransferEmployeeView> storeProcPvu(String procName, Map<String, Object> map)
            throws CustomException {
        List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUTransferEmployeeView.class)
                : Collections.emptyList();
    }

    @Override
    public PagebleDTO<PVUTransferEmployeeView> getTransferList(PageDetails pageDetail) throws CustomException {
        try {
            Map<String, Object> map = buildPageInMapList(pageDetail);
            String procName = Constant.PVU_SCHEMA
                    .concat(Constant.DOT.concat(PvuConstant.PVU_TRANSFER_EMPLOYEES));
            List<PVUTransferEmployeeView> objStorePro = this.storeProcPvu(procName, map);
            int totalPages = objStorePro.size();
            return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }


    public List<PVUSearchEnum> getTransferSearchFieldsList() {
        return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_FROM,
                PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH,
                PVUSearchEnum.PVU_SEARCH_FIELD_TO,
                PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO,
                PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
                PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME,
                PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
                PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO,
                PVUSearchEnum.PVU_SEARCH_FIELD_CPF_NO,
                PVUSearchEnum.PVU_SEARCH_PAN,
                PVUSearchEnum.PVU_SEARCH_DISTRICT,
                PVUSearchEnum.PVU_SEARCH_CARDEX,
                PVUSearchEnum.PVU_SEARCH_DDO,
                PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
                PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,
                PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
                PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID,
                PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS
                );

    }

    private Map<String, Object> buildPageInMapList(PageDetails pageDetail) {
        IdDto idDto = new IdDto();
        idDto.setId(OAuthUtility.getCurrentUserUserId());
        List<IdDto> lst = new ArrayList<>();
        lst.add(idDto);

        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> collect = getTransferSearchFieldsList().stream()
                .collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
        return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
    }

    @Override
    public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
        try {
            Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
            String procName = Constant.PVU_SCHEMA
                    .concat(Constant.DOT.concat(PvuConstant.PVU_EMPLOYEE_TRANSFER_JOIN_LOOKUP_SP));
            List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupTransferCreationSp(procName);
            resultMap = lstPVUEmployeCreationDDLView.stream()
                    .collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
            return resultMap;
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
    }

    /**
     * Lookup employee EOL creation sp.
     *
     * @param procName the proc name
     * @return the list
     * @throws CustomException the custom exception
     */
    private List<PVUEmployeCreationDDLView> lookupTransferCreationSp(String procName) throws CustomException {
        List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
                : Collections.emptyList();
    }

    @Override
    public List<EDPMsOfficeDto> getOfficeByDistrict(Long id) throws CustomException {
        List<EDPMsOfficeEntity> officeList = null;
        try {
            officeList = officeRepository.findByDistrictIdDistrictIdAndActiveStatusAndIsVerified(id, Constant.ACTIVE_STATUS, Constant.IS_VERIFIED);
        } catch (Exception ex) {
            logger.error(ex.toString(), ex);
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
        if (officeList.isEmpty()) {
            throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
        } else {
            return officeConverter.toDTO(officeList);
        }
    }

    /**
     * Gets the employe details.
     *
     * @return the employe details
     * @throws CustomException the custom exception
     */
    @Override
    public PVUTransferEmployeeDetailsDto getLookupDetails() throws CustomException {
        PVUTransferEmployeeDetailsDto pvuTransferEmployeeDetailsDto = new PVUTransferEmployeeDetailsDto();
        pvuTransferEmployeeDetailsDto.setDistrict(districtConverter.toEDPSDTDto(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS, EDPConstant.STATE_ID_GUJ, EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))));
        pvuTransferEmployeeDetailsDto.setDesignation(eDPMsDesignationConverter.toEDPSDTDto(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)));
        return pvuTransferEmployeeDetailsDto;
    }

    @Override
    public void deleteTransferById(Long trnEventId, int inactiveStatus) throws CustomException {
            try {
                this.repository.updateActiveStatus(trnEventId, inactiveStatus, OAuthUtility.getCurrentUserUserId(),
                        new Date());
            } catch (Exception ex) {
                throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
            }
    }

    private String getTransactionNumber(String eventName) throws CustomException {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.TRN_SCREEN, eventName);
        String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.TRANSACTION_NO_GENERATION));
        List<Object[]> nextSequanceNumber = repository.callStoredProcedure(procName, map);
        if (!Utils.isEmpty(nextSequanceNumber)) {
            return (String) nextSequanceNumber.get(0)[0];
        } else {
            throw new CustomException(ErrorResponse.TRN_GENERATION_FAILED);
        }
    }

    @ExceptionHandler
    @Transactional(rollbackFor = Exception.class)
    @Override
    public PVUTransferDto insertInITR(PvuWFWrapperDto wrapperDto) throws CustomException {
        Date approvedDate = new Date();
        Optional<PVUTransferEntity> find = repository.findById(wrapperDto.getTrnId());
        PVUTransferEntity entity;
        PVUEmployeeEventStatusEntity statusEntry;
        if ((find.isPresent()) && (find.get().getStatus() != null)) {
            entity = find.get();
            if (entity.getTrnNo() == null && wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PVU_TRANSFER_PENDING_FOR_JOINING))
            {
                statusEntry = pvuEmployeeEventStatusService.inProgressAnyEvent(entity.getPvuEmployeEntity().getEmpId());
                entity.setTrnNo(getTransactionNumber(Constant.TRN));
                statusEntry.setTransfer(Constant.ACTIVE_STATUS);
                entity.setRefDate(LocalDateTime.now());
                entity=repository.save(entity);
                pvuEmployeeEventStatusService.updateEventInfo(statusEntry, entity.getTrnNo());
            }
            Boolean isReturn = pvuFacade.callWorkFlowApis(wrapperDto);
            if (isReturn.equals(Boolean.TRUE)) {
                return onWorkflowAction(wrapperDto, approvedDate, find, entity);
            }
            throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
        } else {
            if (find.isPresent()) {
                throw new CustomException(HttpStatus.CONFLICT,
                        String.format(MsgConstant.PVU_PROMOTION_ALREADY_APPROVED, find.get().getTrnNo()));
            }
            throw new CustomException(HttpStatus.CONFLICT, MsgConstant.ERROR_WHILE_SAVEFILE);
        }

    }

    @Transactional
    private PVUTransferDto onWorkflowAction(PvuWFWrapperDto wrapperDto, Date approvedDate, Optional<PVUTransferEntity> find, PVUTransferEntity entity) throws CustomException {
        PVUTransferDto dto;
        if(find.isPresent()) {
            if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PVU_TRANSFER_PENDING_FOR_JOINING)) {
                EDPLuLookUpInfoEntity fwdTOTargetLocLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.FORWARD_TARGET_LOCATION);
                entity.setStatus(fwdTOTargetLocLookupInfo);
                repository.updateStatusId(fwdTOTargetLocLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
                        OAuthUtility.getCurrentUserUserId(), approvedDate);
            } else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.PULLED_BACK)) {
                EDPLuLookUpInfoEntity pullbackLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.PULLBACK_BY_PF_APPROVER);
                entity.setStatus(pullbackLookupInfo);
                repository.updateStatusId(pullbackLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
                        OAuthUtility.getCurrentUserUserId(), approvedDate);
                reset(find.get().getPvuEmployeEntity().getEmpId());
            } else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
                EDPLuLookUpInfoEntity empDDOApprovStatsLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.DDO_APPROVED);
                entity.setStatus(empDDOApprovStatsLookupInfo);
                repository.updateStatusId(empDDOApprovStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(),
                        OAuthUtility.getCurrentUserUserId(), approvedDate);
                dto = converter.toDTO(entity);
                saveEmpEvent(dto, find.get().getPvuEmployeEntity(), wrapperDto.getWfStatus());
                reset(find.get().getPvuEmployeEntity().getEmpId());
            } else if (wrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
                EDPLuLookUpInfoEntity empRejectStatsLookupInfo = lookUpInfoRepository.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.TRANSFER_STATUS_ID, Constant.ACTIVE_STATUS, Constant.REJECTED_BY_TAR_LOC);
                repository.updateStatusId(empRejectStatsLookupInfo.getLookUpInfoId(), wrapperDto.getTrnId(), OAuthUtility.getCurrentUserUserId(), approvedDate);
                reset(entity.getPvuEmployeEntity().getEmpId());
            }
          }
            insertITR(wrapperDto);
            dto = converter.toDTO(entity);

            return dto;

    }

    public void insertITR(final PvuWFWrapperDto pvuWFWrapperDto) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_TRN_NO, pvuWFWrapperDto.getTrnId());
        map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
        String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_TRN_ITRS));
        repository.callStoredProcedure(procName, map);
    }
    @Transactional
    public void saveEmpEvent(PVUTransferDto dto, PVUEmployeEntity employee, String wfStatus) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(Constant.IN_TRN_NO, dto.getTrnNo());
        map.put(Constant.IN_STATUS_ID, wfStatus);
        String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_APPROVE_TRANSFER));
        repository.callStoredProcedure(procName, map);
    }




}
