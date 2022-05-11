package gov.ifms.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import gov.ifms.workflow.converter.TrnBudWfConverter;
import gov.ifms.workflow.dto.TrnBudWfDto;
import gov.ifms.workflow.entity.MsWorkflowEntity;
import gov.ifms.workflow.entity.TrnBudWfEntity;
import gov.ifms.workflow.repository.MsWorkflowRepository;
import gov.ifms.workflow.repository.TrnBudWfRepository;
import gov.ifms.workflow.util.WorkFlowConstant;

/**
 * The Class TrnBudWfServiceImpl.
 * 
 * @version 1.0
 * @created 2019/09/20 17:45:45
 */
@Service
public class TrnBudWfServiceImpl implements TrnBudWfService {

	
	/** The TrnBudWfAsMethodName repository. */
	@Autowired
	private TrnBudWfRepository repository;
	
	@Autowired
	private MsWorkflowRepository wfRepo;
	
	/** The TrnBudWfAsMethodName helper. */
	@Autowired
	private TrnBudWfConverter converter;

	/**
	 * Returns all instances of the TrnBudWfEntity type.
	 * 
	 * @return all TrnBudWfEntity
	 */
	@Override
	public List<TrnBudWfEntity> getTrnBudWfs() {
		return repository.findAll();
	}

	/**
	 * Retrieves an TrnBudWfEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the TrnBudWfEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public TrnBudWfEntity getTrnBudWf(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given TrnBudWfEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param bpn the entity
	 * @return the saved TrnBudWfEntity
	 */
	@Override
	public TrnBudWfEntity saveOrUpdateTrnBudWf(TrnBudWfEntity bpn) {
		return repository.save(bpn);
	}
	
	/**
	 * Deletes the TrnBudWfEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteTrnBudWf(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given TrnBudWfEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	@Override
	public List<TrnBudWfEntity> saveTrnBudWf(List<TrnBudWfEntity> entities) {
		return  repository.saveAll(entities);
	}

	/**
	 * Fetch all the TrnBudWf items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<TrnBudWfDto>
	 */
	@Override
	public PagebleDTO<TrnBudWfDto> trnBudWfAsMethodNameSearch(PageDetails pageDetail){
		SpecificationImpl<TrnBudWfEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<TrnBudWfEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<TrnBudWfEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * saveOrUpdateTrnBudWfSp
	 *
	 * @param entity the entity
	 * @return List<Object[]>
	 */
	@Override
	public List<Object[]> saveOrUpdateTrnBudWfSp(TrnBudWfEntity entity) {
		if(entity.getAssignedWfRoleId()==null) {
			TrnBudWfEntity trnWf = repository.findWfRuleIdTrnBudWf(entity.getTrnBudSceHeaderId(), entity.getAssignedPostId(), entity.getAssignedUserId(), entity.getOfficeId());
			Optional<MsWorkflowEntity> wfEntity = wfRepo.findById(trnWf.getCurrentWorkflowId());
			if(wfEntity.isPresent()) {
				entity.setAssignedWfRoleId(wfEntity.get().getMsWorkflowRoleEntity().getWfRoleId());
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("IN_TRN_BUD_SCE_HEADER_ID", entity.getTrnBudSceHeaderId());
		map.put("IN_CURRENT_WORKFLOW_ID", entity.getCurrentWorkflowId());
		map.put("IN_ASSIGNED_WF_ROLE_ID", entity.getAssignedWfRoleId());
		map.put("IN_WF_ACTION_ID", entity.getWfActionId());
		map.put("IN_ASSIGNED_USER_ID", entity.getAssignedUserId());
		map.put("IN_CREATED_BY", entity.getCreatedBy());
		map.put("IN_CREATED_BY_POST", entity.getCreatedByPost());
		map.put("IN_UPDATED_BY", entity.getUpdatedBy());
		map.put("IN_UPDATED_BY_POST", entity.getUpdatedByPost());
		map.put("IN_REMARKS", entity.getRemarks());
		map.put("IN_TRAN_STATUS", entity.getTranStatus());
		map.put("IN_OFFICE_ID", entity.getOfficeId());
		map.put("IN_ASSIGNED_POST_ID", entity.getAssignedPostId());
		map.put("IN_ASSIGNED_BY_POST_ID", entity.getAssignedByPostId());
		map.put("IN_ASSIGNED_BY_USER_ID", entity.getAssignedByUserId());
		map.put("IN_ASSIGNED_BY_OFFICE_ID", entity.getAssignedByOfficeId());
		
		return repository.callWfSP(
				Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_INS_TRN_BUD_WF)), map);
		
				
	}
}
