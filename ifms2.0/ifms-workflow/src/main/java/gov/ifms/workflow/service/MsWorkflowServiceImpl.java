package gov.ifms.workflow.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.workflow.converter.MsWorkflowConverter;
import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.MsWorkflowDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.MsWorkflowEntity;
import gov.ifms.workflow.repository.*;
import gov.ifms.workflow.util.QueryConstant;
import gov.ifms.workflow.util.WorkFlowConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The Class MsWorkflowServiceImpl.
 *
 * @version 1.0
 * @created 2019/08/29 16:52:45ApiResponse
 */

@Service
public class MsWorkflowServiceImpl implements MsWorkflowService {

    /**
     * The logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MsWorkflowServiceImpl.class.getName());

    /**
     * The MsWorkflowRepository repository.
     */
    @Autowired
    private MsWorkflowRepository repository;

    /**
     * The EDPMsOfficeRepository officeRepo
     */
    @Autowired
    private EDPMsOfficeRepository officeRepo;

    /**
     * The TrnBudWfRepository trnBudWfRepo
     */
    @Autowired
    private TrnBudWfRepository trnBudWfRepo;

    /**
     * The MsWorkflowActionRepository wfActionRepo
     */
    @Autowired
    private MsWorkflowActionRepository wfActionRepo;

    /**
     * The LkMenuTblInfoRepository tblInfoRepo
     */
    @Autowired
    private LkMenuTblInfoRepository tblInfoRepo;

    /**
     * The BudgetWfMsWorkflowAsMethodName helper.
     */
    @Autowired
    private MsWorkflowConverter converter;

    /**
     * The EncryptDecryptUtil securityUtil
     */
    @Autowired
    EncryptDecryptUtil securityUtil;

    /**
     * The WfRepository wfRepo
     */
    @Autowired
    WfRepository wfRepo;

    /**
     * Returns all instances of the MsWorkflowEntity type.
     *
     * @return all MsWorkflowEntity
     */
    @Override
    public List<MsWorkflowEntity> getMsWorkflows() {
        return repository.findAll();
    }

    /**
     * Retrieves MsWorkflowEntity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the MsWorkflowEntity with the given id or {@literal null} if
     */
    @Override
    public MsWorkflowEntity getMsWorkflow(Long id) {
        return repository.getOne(id);
    }

    /**
     * Saves a given MsWorkflowEntity. Use the returned instance for further
     * operations as the save operation might have changed the entity instance
     * completely.
     *
     * @param bpn the entity
     * @return the saved MsWorkflowEntity
     */
    @Override
    public MsWorkflowEntity saveOrUpdateMsWorkflow(MsWorkflowEntity bpn) {
        return repository.save(bpn);
    }

    /**
     * Deletes the MsWorkflowEntity with the given id.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteMsWorkflow(Long id) {
        repository.deleteById(id);

    }

    /**
     * Saves all given MsWorkflowEntity entities.
     *
     * @param entities the entities
     * @return the saved entities
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    @Override
    @Transactional
    public List<MsWorkflowEntity> saveMsWorkflows(List<MsWorkflowEntity> entities) {
        return repository.saveAll(entities).stream()
                .sorted(Comparator.comparingLong(MsWorkflowEntity::getWorkflowId)).collect(Collectors.toList());
    }

    /**
     * Fetch all the MsWorkflowDto with pagination.
     *
     * @param pageDetail the page detail
     * @return PagebleDTO<MsWorkflowDto>
     */

    @Override
    public PagebleDTO<MsWorkflowDto> msWorkflowAsMethodNameSearch(PageDetails pageDetail) {
        SpecificationImpl<MsWorkflowEntity> spec = new SpecificationImpl<>();
        PageRequest pageable = null;
        SearchCriteria searchCriteria = new SearchCriteria();

        pageable = pageDetail.getPageDetails(pageDetail);
        Specification<MsWorkflowEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<MsWorkflowEntity> page = repository.findAll(empSpec, pageable);

        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                converter.toDTO(page.getContent()));
    }

    /**
     * get UsersByWfActionId
     *
     * @param dto
     * @return List<WfUserDto>
     * @throws CustomException
     */
    @Override
    public List<WfUserDto> getUsersByWfActionId(WfRequestDto dto) throws CustomException {
        if (dto.getWfActionId() == wfActionRepo.findByWfActionNameAndValidWfActionId(
                Constant.WF_ACTION_REWORK, Constant.VALID_WF_ACTION_ID).getWfActionId()
                || dto.getWfActionId() == wfActionRepo.findByWfActionNameAndValidWfActionId(
                Constant.WF_ACTION_SEND_BACK, Constant.VALID_WF_ACTION_ID).getWfActionId()
                ||  dto.getWfActionId() == wfActionRepo.findByWfActionCodeAndValidWfActionId(
                WorkFlowConstant.WF_ACTION_RETURN_CODE, Constant.VALID_WF_ACTION_ID).getWfActionId()) {
            LkMenuTblInfoEntity lkMenuTblInfoEntity = getTblInfo(dto.getMenuId(), dto.getEventId());
            return wfRepo.executeSQLQuery(
                    QueryConstant.getUserForBackActQrString(lkMenuTblInfoEntity.getSchemaName(),
                            lkMenuTblInfoEntity.getTrnWfTblName()),
                    QueryConstant.getUserForBackActQrParamMap(dto), WfUserDto.class);
        } else {
            Set<Object[]> userListDto = repository
                    .findUserByNextWfRole(
                            dto.getOfficeId(), dto.getMenuId(), dto.getNextWfRoleId(), Constant.ACTIVE_STATUS);
            return NativeQueryResultsMapper.map(userListDto.stream().collect(Collectors.toList()), WfUserDto.class);
        }
    }

    /**
     * get NextWfActions
     *
     * @param dto
     * @return List<MsWorkflowEntity>
     * @throws CustomException
     */
    @Override
    public List<MsWorkflowEntity> getNextWfActions(WfRequestDto dto) throws CustomException {
        long officeTypeId = officeRepo.getOne(dto.getOfficeId()).getOfficeTypeId().getLookUpInfoId();
        AssignedToTrnDto assignedToDto = findActualWfRoleId(dto.getWfRoleIds(), dto.getTrnId(), dto.getMenuId(), dto.getEventId() , officeTypeId);
        Long entryCount = null;
        if(dto.getLkPOUId()!=null) {
        	entryCount = repository.verifyUserWfRole(dto.getMenuId(), assignedToDto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS, dto.getLkPOUId());
        }else {
        	entryCount = repository.verifyUserWfRole(Long.parseLong(securityUtil.decrypt(String.valueOf(dto.getUserId()))), dto.getPostId(), dto.getOfficeId(), dto.getMenuId(), assignedToDto.getAssignToWfRoleId(), Constant.ACTIVE_STATUS);
        }
        if (entryCount != null && entryCount == 1) {
            return repository.findWorkflowRuleIdAndWfActions(officeTypeId, assignedToDto.getAssignToWfRoleId(), dto.getMenuId(), Constant.VALID_WF_ACTION_ID, assignedToDto.getAssignToActionLevel());
        } else {
            LOGGER.info(ErrorResponse.WF_ACTIONS_NOT_ALLOWED.getMessage(), ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
    }

    /**
     * get WfRoleIdByPostIdAndMenuId
     *
     * @param postId
     * @param menuId
     * @return long
     */
    @Override
    public long getWfRoleIdByPostIdAndMenuId(long postId, long menuId) {
        return 0;
    }

    /**
     * isEditableScHeader
     *
     * @param id
     * @return boolean
     */
    @Override
    public Boolean isEditableScHeader(Long id) {
        Long count = trnBudWfRepo.countByTrnBudSceHeaderIdAndAssignedUserId(id, OAuthUtility.getCurrentUserUserId());
        return count > 0;
    }

    /**
     * @param wfRoleIds
     * @param trnId
     * @param menuId
     * @param eventId
     * @return AssignedToTrnDto
     * @throws CustomException
     */
    @Override
    public AssignedToTrnDto findActualWfRoleId(List<Long> wfRoleIds, long trnId, long menuId, Long eventId , long officeTypeId) throws CustomException {
        LkMenuTblInfoEntity lkMenuTblInfoEntity = getTblInfo(menuId, eventId);
        Object[] obj = wfRepo.executeNativeSQLQuerySingleResult(QueryConstant
                        .getActTrnQrString(lkMenuTblInfoEntity.getSchemaName(), lkMenuTblInfoEntity.getTrnWfTblName()),
                QueryConstant.getActTrnQrParamMap(trnId));
        AssignedToTrnDto dto;
        if (obj == null) {
            dto = new AssignedToTrnDto(repository.findWfInitWfRoleId(menuId, Constant.ACTIVE_STATUS ,officeTypeId), WorkFlowConstant.DEFAULT_WF_ACTION_LEVEL);
        } else {
            long wfRoleId = (obj[0] == null ? repository.findWfInitWfRoleId(menuId, Constant.ACTIVE_STATUS, officeTypeId) : Long.parseLong(obj[0].toString()));
            int actionLevel = (obj[1] == null ? WorkFlowConstant.DEFAULT_WF_ACTION_LEVEL : Integer.parseInt(obj[1].toString()));
            dto = new AssignedToTrnDto(wfRoleId, actionLevel);
        }
        if (wfRoleIds.contains(dto.getAssignToWfRoleId())) {
            return dto;
        } else {
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
    }

    @Autowired
    EDPMsMenuRepository edpMsMenuRepository;

    /**
     * Gets the ms workflow status.
     *
     * @param menuId the menu id
     * @return the ms workflow status
     */
    @Override
    @Cacheable(value = "msWorkflowStatus" ,key = "#menuId")
    public List<EDPSDTDto> getMsWorkflowStatus(long menuId) {

        List<EDPSDTDto> workflowStatus = null;

        if(getMsWorkByLinkManuId(menuId) != null && !getMsWorkByLinkManuId(menuId).isEmpty()){
            workflowStatus =  getMsWorkByLinkManuId(menuId);
        }else{
            workflowStatus = converter.toEDPSDTDto(repository.findDistinctByMenuId(menuId));
        }
        if (workflowStatus != null && !workflowStatus.isEmpty()) {
            return workflowStatus;
        }
        return Collections.emptyList();
    }

    @Override
    public List<EDPSDTDto> getMsWorkflowStatusV2(long menuId) {
        List<MsWorkflowEntity> entities = repository.findDistinctByMenuId(menuId);
        List<EDPSDTDto> response = new ArrayList<>();
        entities.stream().map(e -> e.getWfStatus()).distinct().filter(s -> !s.trim().equals("Autorised/Returned")).forEach(s -> {
            response.add(new EDPSDTDto(entities.stream().filter(e -> e.getWfStatus().equals(s)).findFirst().map(x->x.getWorkflowId()).orElse(0l), s, null));
        });
        response.add(new EDPSDTDto(0L, "Authorized"));
        response.add(new EDPSDTDto(0L, "Return"));
        return response;
    }


    public List<EDPSDTDto> getMsWorkByLinkManuId(long menuId) {
        try{
            List<EDPMsMenuEntity> edpMsMenuEntity = edpMsMenuRepository
                    .findByActiveStatusAndLinkMenuId(Constant.ACTIVE_STATUS, menuId);
            List<Long> ids = null;
            if(edpMsMenuEntity != null && edpMsMenuEntity.size() > 0){
                ids = edpMsMenuEntity.stream().filter(e ->e.getMenuId() != 0).filter(e ->e.getLinkMenuId() != 0).map(e->e.getMenuId()).collect(Collectors.toList());
            }
            List<MsWorkflowEntity> list = repository.findDistinctByMenuIdIn(ids);
            List<EDPSDTDto> workflowStatus = converter.toEDPSDTDto(list);
            return workflowStatus;
        }catch(Exception e){
        }
        return Collections.emptyList();
    }

    private LkMenuTblInfoEntity getTblInfo(long menuId, Long eventId) {
        LkMenuTblInfoEntity lkMenuTblInfoEntity = null;
        if (eventId != null) {
            lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventId(menuId, Constant.ACTIVE_STATUS, eventId);
        } else {
            lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(menuId, Constant.ACTIVE_STATUS);
        }
        return lkMenuTblInfoEntity;
    }

    @Override
    public List<EDPSDTDto> getMsWorkflowTrnStatus(Long id) {
        List<EDPSDTDto> workflowStatus = converter.toTrnStatus(repository.findDistinctByMenuId(id));
        if (workflowStatus != null && !workflowStatus.isEmpty()) {
            return workflowStatus;
        }
        return Collections.emptyList();
    }

    @Override
    public AssignedToTrnDto findActualWfRoleIdForPVUHistory(List<Long> wfRoleIds, long trnId, long menuId, Long eventId , long officeTypeId) throws CustomException {
        LkMenuTblInfoEntity lkMenuTblInfoEntity = getTblInfo(menuId, eventId);
        Object[] obj = wfRepo.executeNativeSQLQuerySingleResult(QueryConstant
                        .getActTrnQrString(lkMenuTblInfoEntity.getSchemaName(), lkMenuTblInfoEntity.getTrnWfTblName()),
                QueryConstant.getActTrnQrParamMap(trnId));
        AssignedToTrnDto dto;
        if (obj == null) {
            dto = new AssignedToTrnDto(repository.findWfInitWfRoleId(menuId, Constant.ACTIVE_STATUS ,officeTypeId), WorkFlowConstant.DEFAULT_WF_ACTION_LEVEL);
        } else {
            long wfRoleId = (obj[0] == null ? repository.findWfInitWfRoleId(menuId, Constant.ACTIVE_STATUS, officeTypeId) : Long.parseLong(obj[0].toString()));
            int actionLevel = (obj[1] == null ? WorkFlowConstant.DEFAULT_WF_ACTION_LEVEL : Integer.parseInt(obj[1].toString()));
            dto = new AssignedToTrnDto(wfRoleId, actionLevel);
        }
        return dto;
    }
}
