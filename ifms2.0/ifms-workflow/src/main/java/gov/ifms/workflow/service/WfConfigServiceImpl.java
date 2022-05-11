/*
 * 
 */
package gov.ifms.workflow.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.EncryptDecryptUtil;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.workflow.converter.WfConfigConverter;
import gov.ifms.workflow.dto.AssignedToTrnDto;
import gov.ifms.workflow.dto.WfConfigDto;
import gov.ifms.workflow.dto.WfRequestDto;
import gov.ifms.workflow.dto.WfUserDto;
import gov.ifms.workflow.entity.LkMenuTblInfoEntity;
import gov.ifms.workflow.entity.WfConfigEntity;
import gov.ifms.workflow.repository.*;
import gov.ifms.workflow.util.QueryConstant;
import gov.ifms.workflow.util.WorkFlowConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class MsWorkflowServiceImpl.
 *
 * @version 1.0
 * @created 2019/08/29 16:52:45ApiResponse
 */

@Service
public class WfConfigServiceImpl implements WfConfigService {

    /** The repository. */
    @Autowired
    private WfConfigRepository repository;

    /** The office repo. */
    @Autowired
    private EDPMsOfficeRepository officeRepo;

    /** The trn bud wf repo. */
    @Autowired
    private TrnBudWfRepository trnBudWfRepo;

    /** The wf action repo. */
    @Autowired
    private MsWorkflowActionRepository wfActionRepo;

    /** The tbl info repo. */
    @Autowired
    private LkMenuTblInfoRepository tblInfoRepo;

    /** The converter. */
    @Autowired
    private WfConfigConverter converter;

    /** The security util. */
    @Autowired
    EncryptDecryptUtil securityUtil;

    @Autowired
    WfRepository wfRepo;

    /**
     * Gets the ms workflows.
     *
     * @return the ms workflows
     */
    @Override
    public List<WfConfigEntity> getMsWorkflows() {
        return repository.findAll();
    }

    /**
     * Gets the ms workflow.
     *
     * @param id the id
     * @return the ms workflow
     */
    @Override
    public WfConfigEntity getMsWorkflow(Long id) {
        return repository.getOne(id);
    }

    /**
     * Save or update ms workflow.
     *
     * @param bpn the bpn
     * @return the wf config entity
     */
    @Override
    public WfConfigEntity saveOrUpdateMsWorkflow(WfConfigEntity bpn) {
        return repository.save(bpn);
    }

    /**
     * Delete ms workflow.
     *
     * @param id the id
     */
    @Override
    public void deleteMsWorkflow(Long id) {
        repository.deleteById(id);

    }

    /**
     * Save ms workflows.
     *
     * @param entities the entities
     * @return the list
     */
    @Override
    @Transactional
    public List<WfConfigEntity> saveMsWorkflows(List<WfConfigEntity> entities) {
        return repository.saveAll(entities).stream()
                .sorted(Comparator.comparingLong(WfConfigEntity::getWorkflowId)).collect(Collectors.toList());
    }

    /**
     * Ms workflow as method name search.
     *
     * @param pageDetail the page detail
     * @return the pageble DTO
     */
    @Override
    public PagebleDTO<WfConfigDto> msWorkflowAsMethodNameSearch(PageDetails pageDetail) {
        SpecificationImpl<WfConfigEntity> spec = new SpecificationImpl<>();
        PageRequest pageable = null;
        SearchCriteria searchCriteria = new SearchCriteria();

        pageable = pageDetail.getPageDetails(pageDetail);
        Specification<WfConfigEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<WfConfigEntity> page = repository.findAll(empSpec, pageable);

        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                converter.toDTO(page.getContent()));
    }

    /**
     * Gets the users by wf action id.
     *
     * @param dto the dto
     * @return the users by wf action id
     * @throws CustomException the custom exception
     */
    @Override
    public List<WfUserDto> getUsersByWfActionId(WfRequestDto dto) throws CustomException {
        if (dto.getWfActionId() == wfActionRepo.findByWfActionNameAndValidWfActionId(
                Constant.WF_ACTION_REWORK, Constant.VALID_WF_ACTION_ID).getWfActionId()
                || dto.getWfActionId() == wfActionRepo.findByWfActionNameAndValidWfActionId(
                Constant.WF_ACTION_SEND_BACK, Constant.VALID_WF_ACTION_ID).getWfActionId()
                ||  dto.getWfActionId() == wfActionRepo.findByWfActionNameAndValidWfActionId(
                Constant.WF_ACTION_RETURN, Constant.VALID_WF_ACTION_ID).getWfActionId()) {
            LkMenuTblInfoEntity lkMenuTblInfoEntity = getTblInfo(dto.getMenuId(), dto.getEventId());
            return wfRepo.executeSQLQuery(
                    QueryConstant.getUserForBackActQrString(lkMenuTblInfoEntity.getSchemaName(),
                            lkMenuTblInfoEntity.getTrnWfTblName()),
                    QueryConstant.getUserForBackActQrParamMap(dto), WfUserDto.class);
        } else {
            return repository.findUserByNextWfRole(dto.getOfficeId(), dto.getMenuId(), dto.getNextWfRoleId(), Constant.ACTIVE_STATUS);
        }
    }

    /**
     * Gets the next wf actions.
     *
     * @param dto the dto
     * @return the next wf actions
     * @throws CustomException the custom exception
     */
    @Override
    public List<WfConfigEntity> getNextWfActions(WfRequestDto dto) throws CustomException {
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
            throw new CustomException(ErrorResponse.WF_ACTIONS_NOT_ALLOWED);
        }
    }

    /**
     * Gets the wf role id by post id and menu id.
     *
     * @param postId the post id
     * @param menuId the menu id
     * @return the wf role id by post id and menu id
     */
    @Override
    public long getWfRoleIdByPostIdAndMenuId(long postId, long menuId) {
        return 0;
    }

    /**
     * Checks if is editable sc header.
     *
     * @param id the id
     * @return the boolean
     */
    @Override
    public Boolean isEditableScHeader(Long id) {
        Long count = trnBudWfRepo.countByTrnBudSceHeaderIdAndAssignedUserId(id, OAuthUtility.getCurrentUserUserId());
        return count > 0;
    }

    /**
     * Find actual wf role id.
     *
     * @param wfRoleIds the wf role ids
     * @param trnId the trn id
     * @param menuId the menu id
     * @param eventId the event id
     * @param officeTypeId the office type id
     * @return the assigned to trn dto
     * @throws CustomException the custom exception
     */
    private AssignedToTrnDto findActualWfRoleId(List<Long> wfRoleIds, long trnId, long menuId, Long eventId , long officeTypeId) throws CustomException {
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

    /**
     * Gets the ms workflow status.
     *
     * @param menuId the menu id
     * @return the ms workflow status
     */
    @Override
    public List<EDPSDTDto> getMsWorkflowStatus(long menuId) {
        List<EDPSDTDto> workflowStatus = converter.toEDPSDTDto(repository.findDistinctByMenuId(menuId));
        if (workflowStatus != null && !workflowStatus.isEmpty()) {
            return workflowStatus;
        }
        return Collections.emptyList();
    }

    /**
     * Gets the tbl info.
     *
     * @param menuId the menu id
     * @param eventId the event id
     * @return the tbl info
     */
    private LkMenuTblInfoEntity getTblInfo(long menuId, Long eventId) {
        LkMenuTblInfoEntity lkMenuTblInfoEntity = null;
        if (eventId != null) {
            lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventId(menuId, Constant.ACTIVE_STATUS, eventId);
        } else {
            lkMenuTblInfoEntity = tblInfoRepo.findByMenuIdAndActiveStatusAndEventIdIsNull(menuId, Constant.ACTIVE_STATUS);
        }
        return lkMenuTblInfoEntity;
    }

    /**
     * Gets the ms workflow trn status.
     *
     * @param id the id
     * @return the ms workflow trn status
     */
    @Override
    public List<EDPSDTDto> getMsWorkflowTrnStatus(Long id) {
        List<EDPSDTDto> workflowStatus = converter.toTrnStatus(repository.findDistinctByMenuId(id));
        if (workflowStatus != null && !workflowStatus.isEmpty()) {
            return workflowStatus;
        }
        return Collections.emptyList();
    }
}
