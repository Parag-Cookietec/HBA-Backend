package gov.ifms.workflow.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.ifms.common.util.EncryptDecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.workflow.converter.PvuTrnEmpCrWfConverter;
import gov.ifms.workflow.dto.PvuTrnEmpCrWfDto;
import gov.ifms.workflow.entity.PvuTrnEmpCrWfEntity;
import gov.ifms.workflow.repository.PvuTrnEmpCrWfRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.util.QueryConstant;
import gov.ifms.workflow.util.WorkFlowConstant;


/**
 * The Class PvuTrnEmpCrWfServiceImpl.
 */
@Service
public class PvuTrnEmpCrWfServiceImpl implements PvuTrnEmpCrWfService {

    @Autowired
    private PvuTrnEmpCrWfRepository repository;

    @Autowired
    private WfRepository wfRepo;

    @Autowired
    private PvuTrnEmpCrWfConverter converter;

    @Autowired
    EncryptDecryptUtil securityUtil;


    /**
     * Gets the trn edp wfs.
     *
     * @return the trn edp wfs
     */
    @Override
    public List<PvuTrnEmpCrWfEntity> getTrnEdpWfs() {
        return repository.findAll();
    }

    /**
     * Gets the trn edp wf.
     *
     * @param id the id
     * @return the trn edp wf
     */
    @Override
    public PvuTrnEmpCrWfEntity getTrnEdpWf(Long id) {
        return repository.getOne(id);
    }

    /**
     * Save or update trn edp wf.
     *
     * @param bpn the bpn
     * @return the trn edp wf entity
     */
    @Override
    public PvuTrnEmpCrWfEntity saveOrUpdateTrnEdpWf(PvuTrnEmpCrWfEntity bpn) {
        return repository.save(bpn);
    }

    /**
     * Delete trn edp wf.
     *
     * @param id the id
     */
    @Override
    public void deleteTrnEdpWf(Long id) {
        repository.deleteById(id);

    }

    /**
     * Save trn edp wf.
     *
     * @param entities the entities
     * @return the list
     */
    @Override
    public List<PvuTrnEmpCrWfEntity> saveTrnEdpWf(List<PvuTrnEmpCrWfEntity> entities) {
        return  repository.saveAll(entities);
    }

    /**
     * Trn edp wf as method name search.
     *
     * @param pageDetail the page detail
     * @return the pageble DTO
     */
    @Override
    public PagebleDTO<PvuTrnEmpCrWfDto> trnEdpWfAsMethodNameSearch(PageDetails pageDetail) {
        SpecificationImpl<PvuTrnEmpCrWfEntity> spec = new SpecificationImpl<>();
        PageRequest pageable = null;
        SearchCriteria searchCriteria = new SearchCriteria();

        pageable = pageDetail.getPageDetails(pageDetail);
        Specification<PvuTrnEmpCrWfEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
                pageDetail.getJsonArr());
        Page<PvuTrnEmpCrWfEntity> page = repository.findAll(empSpec, pageable);

        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
                converter.toDTO(page.getContent()));
    }

    /**
     * save or update Trn Edp Wf SP
     * @param dto
     * @return long
     */
    @Override
    public Long saveOrUpdateTrnEdpWfSp(PvuTrnEmpCrWfDto dto) {
        Long assignedByUserId = (dto.getAssignByUserId() == null) ? null : Long.parseLong(securityUtil.decrypt(dto.getAssignByUserId()));
        Map<String, Object> map = new HashMap<>();
        map.put("IN_TRN_ID", dto.getTrnId());
        map.put("IN_CURRENT_WORKFLOW_ID", dto.getCurrentWorkflowId());
        map.put("IN_WF_ACTION_ID", dto.getWfActionId());
        map.put("IN_ASSIGNED_TO_ACTION_LEVEL", dto.getAssignToActionLevel());
        map.put("IN_ASSIGNED_TO_WF_ROLE_ID", dto.getAssignToWfRoleId());
        map.put("IN_ASSIGNED_TO_USER_ID", dto.getAssignToUserId());
        map.put("IN_ASSIGNED_TO_POST_ID", dto.getAssignToPostId());
        map.put("IN_ASSIGNED_TO_OFFICE_ID", dto.getAssignToOfficeId());
        map.put("IN_ASSIGNED_TO_POU_ID", dto.getAssignToPOUId());
        map.put("IN_TRN_STATUS", dto.getTrnStatus());
        map.put("IN_WF_STATUS", dto.getWfStatus());
        map.put("IN_REMARKS", dto.getRemarks());
        map.put("IN_CREATED_BY", assignedByUserId);
        map.put("IN_CREATED_BY_POST", dto.getAssignByPostId());
        map.put("IN_UPDATED_BY", assignedByUserId);
        map.put("IN_UPDATED_BY_POST", dto.getAssignByPostId());
        map.put("IN_ASSIGNED_BY_ACTION_LEVEL", dto.getAssignByActionLevel());
        map.put("IN_ASSIGNED_BY_WF_ROLE_ID", dto.getAssignByWfRoleId());
        map.put("IN_ASSIGNED_BY_POST_ID", dto.getAssignByPostId());
        map.put("IN_ASSIGNED_BY_USER_ID", assignedByUserId);
        map.put("IN_ASSIGNED_BY_OFFICE_ID", dto.getAssignByOfficeId());
        map.put("IN_ASSIGNED_BY_POU_ID", dto.getAssignByPOUId());
        map.put("IN_MENU_ID", dto.getMenuId());
        map.put("IN_ACTIVE_STATUS", Constant.ACTIVE_STATUS);
        map.put("IN_EVENT_ID", dto.getEventId());
        return repository.callWfSPLong(Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_INS_TRN_PVU_WF)), map);
    }

    /**
     * save or update TrnEdpWfSpList
     * @param dtos
     * @return boolean
     * @throws SQLException
     */
    @Override
    public boolean saveOrUpdateTrnEdpWfSpList(List<PvuTrnEmpCrWfDto> dtos) throws SQLException {
        List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
        dtos.forEach(dto -> {
            Long assignedByUserId = (dto.getAssignByUserId() == null) ? null : Long.parseLong(securityUtil.decrypt(dto.getAssignByUserId()));
            Map<Integer, Object> map = new HashMap<>();
            map.put(1, dto.getTrnId());
            map.put(2, dto.getCurrentWorkflowId());
            map.put(3, dto.getWfActionId());
            map.put(4, dto.getAssignToWfRoleId());
            map.put(5, dto.getAssignToUserId());
            map.put(6, dto.getAssignToPostId());
            map.put(7, dto.getAssignToOfficeId());
            map.put(8, dto.getTrnStatus());
            map.put(9, dto.getWfStatus());
            map.put(10, dto.getRemarks());
            map.put(11, dto.getAssignByWfRoleId());
            map.put(12, dto.getAssignByPostId());
            map.put(13, assignedByUserId);
            map.put(14, dto.getAssignByOfficeId());
            map.put(15, dto.getMenuId());
            map.put(16, assignedByUserId);
            map.put(17, dto.getAssignByPostId());
            map.put(18, assignedByUserId);
            map.put(19, dto.getAssignByPostId());
            map.put(20, dto.getEventId());
            map.put(21, Constant.ACTIVE_STATUS);
            map.put(22, dto.getAssignByActionLevel());
            map.put(23, dto.getAssignToActionLevel());
            map.put(24, dto.getAssignToPOUId());
            map.put(25, dto.getAssignByPOUId());
            parameterMapList.add(map);
        });
        return wfRepo.callStoreProcBatch("{CALL " + Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_INS_TRN_PVU_WF_MULTIPLE)) + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", parameterMapList);
    }



    /**
     * get current user POU Id
     * @param dto
     * @return long
     */
    @Override
    public Long getCurrentUserPOUId(PvuTrnEmpCrWfDto dto ,boolean isAssignBy) {
        Map<String, Object> map = new HashMap<>();
        if(isAssignBy){
            map.put("userId", dto.getAssignByUserId());
            map.put("postId", dto.getAssignByPostId());
            map.put("officeId", dto.getAssignByOfficeId());
        } else {
            map.put("userId", dto.getAssignToUserId());
            map.put("postId", dto.getAssignToPostId());
            map.put("officeId", dto.getAssignToOfficeId());
        }
        Object[] obj = wfRepo.executeNativeSQLQuerySingleResult(QueryConstant.getCurrentUserPOUId(), map);
        return obj != null ? Long.parseLong(obj[0].toString()) : null;
    }

    /**
     * set POU id
     * @param dto
     * @return PvuTrnEmpCrWfDto dto
     */
    @Override
    public PvuTrnEmpCrWfDto setPOUId(PvuTrnEmpCrWfDto dto) {
        if(dto.getAssignByPOUId() == null){
            dto.setAssignByPOUId(this.getCurrentUserPOUId(dto , Boolean.TRUE));
        }

        return  dto;
    }

	/**
	 * Gets the wf rl cd by rop trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by rop trn id
	 */
	@Override
	public String getWfRlCdByRopTrnId(long trnId) {
		return wfRepo.findWfRlCdByRopTrnId(trnId, Constant.ACTIVE_STATUS);
	}
    
	/**
	 * Gets the wf rl cd by rop trn id.
	 *
	 * @param trnId the trn id
	 * @return the wf rl cd by rop trn id
	 */
	@Override
	public String getWfRlCdByIncTrnId(Long trnId) {
		return wfRepo.findWfRlCdByIncTrnId(trnId, Constant.ACTIVE_STATUS);
	}
}

