package gov.ifms.workflow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import gov.ifms.workflow.converter.EdpTrnOffModWfConverter;
import gov.ifms.workflow.dto.EdpTrnOffModWfDto;
import gov.ifms.workflow.entity.EdpLkTrnOffModWfEntity;
import gov.ifms.workflow.entity.EdpTrnOffModWfEntity;
import gov.ifms.workflow.repository.EdpTrnOffModWfRepository;
import gov.ifms.workflow.repository.WfRepository;
import gov.ifms.workflow.util.WorkFlowConstant;

/**
 * The Class EdpTrnOffModWfServiceImpl.
 */
@Service
public class EdpTrnOffModWfServiceImpl implements EdpTrnOffModWfService {

	@Autowired
	private EdpTrnOffModWfRepository repository;

	@Autowired
	private WfRepository wfRepo;

	@Autowired
	private EdpTrnOffModWfConverter converter;

	/**
	 * Gets the trn edp wfs.
	 *
	 * @return the trn edp wfs
	 */
	@Override
	public List<EdpTrnOffModWfEntity> getTrnEdpWfs() {
		return repository.findAll();
	}

	/**
	 * Gets the trn edp wf.
	 *
	 * @param id the id
	 * @return the trn edp wf
	 */
	@Override
	public EdpTrnOffModWfEntity getTrnEdpWf(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Save or update trn edp wf.
	 *
	 * @param bpn the bpn
	 * @return the trn edp wf entity
	 */
	@Override
	public EdpTrnOffModWfEntity saveOrUpdateTrnEdpWf(EdpTrnOffModWfEntity bpn) {
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
	public List<EdpTrnOffModWfEntity> saveTrnEdpWf(List<EdpTrnOffModWfEntity> entities) {
		return repository.saveAll(entities);
	}

	/**
	 * Trn edp wf as method name search.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 */
	@Override
	public PagebleDTO<EdpTrnOffModWfDto> trnEdpWfAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EdpTrnOffModWfEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EdpTrnOffModWfEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EdpTrnOffModWfEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * save or update Trn Edp Wf Sp
	 *
	 * @param dto
	 * @return the long
	 */
	@Override
	public Long saveOrUpdateTrnEdpWfSp(EdpTrnOffModWfDto dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("IN_TRN_ID", dto.getEdpTrnOffId());
		map.put("IN_CURRENT_WORKFLOW_ID", dto.getCurrentWorkflowId());
		map.put("IN_WF_ACTION_ID", dto.getWfActionId());
		map.put("IN_ASSIGNED_TO_WF_ROLE_ID", dto.getAssignedToWfRoleId());
		map.put("IN_ASSIGNED_TO_USER_ID", dto.getAssignedToUserId());
		map.put("IN_ASSIGNED_TO_POST_ID", dto.getAssignedToPostId());
		map.put("IN_ASSIGNED_TO_OFFICE_ID", dto.getAssignedToOfficeId());
		map.put("IN_TRN_STATUS", dto.getTrnStatus());
		map.put("IN_REMARKS", dto.getRemarks());
		map.put("IN_CREATED_BY", dto.getCreatedBy());
		map.put("IN_CREATED_BY_POST", dto.getCreatedByPost());
		map.put("IN_UPDATED_BY", dto.getUpdatedBy());
		map.put("IN_UPDATED_BY_POST", dto.getUpdatedByPost());
		map.put("IN_ASSIGNED_BY_WF_ROLE_ID", dto.getAssignedByWfRoleId());
		map.put("IN_ASSIGNED_BY_POST_ID", dto.getAssignedByPostId());
		map.put("IN_ASSIGNED_BY_USER_ID", dto.getAssignedByUserId());
		map.put("IN_ASSIGNED_BY_OFFICE_ID", dto.getAssignedByOfficeId());
		map.put("IN_MENU_ID", dto.getMenuId());
		map.put("IN_ACTIVE_STATUS", Constant.ACTIVE_STATUS);
		Long edpWfTrnId = repository.callWfSPLong(
				Constant.WORKFLOW_SCHEMA.concat(Constant.DOT.concat(WorkFlowConstant.SP_INS_TRN_EDP_WF)), map);
		if (edpWfTrnId != null) {
			List<EdpLkTrnOffModWfEntity> edpLkTrnOffModWfEntities;
			edpLkTrnOffModWfEntities = dto.getWfAttachmentIds().stream().map(wfAttachId -> {
				EdpLkTrnOffModWfEntity edpLkTrnOffModWfEntity = new EdpLkTrnOffModWfEntity();
				edpLkTrnOffModWfEntity.setEdpWfAttachId(wfAttachId);
				edpLkTrnOffModWfEntity.setEdpWfTrnId(edpWfTrnId);
				edpLkTrnOffModWfEntity.setMenuId(dto.getMenuId());
				return edpLkTrnOffModWfEntity;
			}).collect(Collectors.toList());
			wfRepo.saveAll(edpLkTrnOffModWfEntities);
		}
		return edpWfTrnId;
	}
}
