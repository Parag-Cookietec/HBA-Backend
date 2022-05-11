package gov.ifms.workflow.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.workflow.dto.WfActionDto;
import gov.ifms.workflow.dto.WfConfigDto;
import gov.ifms.workflow.entity.MsWorkflowActionEntity;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import gov.ifms.workflow.entity.WfConfigEntity;

import static gov.ifms.workflow.entity.MsWorkflowEntity.distinctByKey;

/**
 * The Class WfConfigConverter.
 */
@Component
public class WfConfigConverter implements BaseConverter<WfConfigEntity, WfConfigDto> {

	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the wf config entity
	 */
	@Override
	public WfConfigEntity toEntity(WfConfigDto dto) {
		WfConfigEntity entity = new WfConfigEntity();
		entity.setOfficeTypeId(new EDPLuLookUpInfoEntity(dto.getOfficeTypeId()));
		entity.setMsWorkflowRoleEntity(new MsWorkflowRoleEntity(dto.getWfRoleId()));
		entity.setMsWorkflowActionEntity(new MsWorkflowActionEntity(dto.getWfActionId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the wf config dto
	 */
	@Override
	public WfConfigDto toDTO(WfConfigEntity entity) {
		WfConfigDto dto = new WfConfigDto();
		dto.setOfficeTypeId(entity.getOfficeTypeId().getLookUpInfoId());
		dto.setWfRoleId(entity.getMsWorkflowRoleEntity().getWfRoleId());
		dto.setWfActionId(entity.getMsWorkflowActionEntity().getWfActionId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To wf action DTO.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<WfActionDto> toWfActionDTO(List<WfConfigEntity> entities) {
		List<WfActionDto> dtos = new ArrayList<>();
		entities.stream().forEach(entity -> {
			WfActionDto dto = new WfActionDto();
			dto.setCurrentWorkflowId(entity.getWorkflowId());
			dto.setWfActionId(entity.getMsWorkflowActionEntity().getWfActionId());
			dto.setWfActionName(entity.getMsWorkflowActionEntity().getWfActionName());
			dto.setAssignedWfRoleId(entity.getNextWfRoleId());
			dto.setTrnStatus(entity.getTrnStatus());
			dto.setCurrentWfRoleId(entity.getMsWorkflowRoleEntity().getWfRoleId());
			dto.setWfStatus(entity.getWfStatus());
			dto.setCurrentActionLevel(entity.getActionLevel());
			dto.setWfRoleCode(entity.getMsWorkflowRoleEntity().getWfRoleCode());
			dto.setNextActionLevel(entity.getNextActionLevel());
			dto.setWfActionCode(entity.getMsWorkflowActionEntity().getWfActionCode());
			dtos.add(dto);
		});
		return dtos;
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<WfConfigEntity> list) {
		return list.stream().filter(distinctByKey(WfConfigEntity::getWfStatus))
				.map(entityInList -> new EDPSDTDto(entityInList.getWorkflowId(), entityInList.getWfStatus(), null))
				.collect(Collectors.toList());
	}

	/**
	 * To trn status.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toTrnStatus(List<WfConfigEntity> list) {
		return list.stream().filter(distinctByKey(WfConfigEntity::getTrnStatus))
				.map(entityInList -> new EDPSDTDto(entityInList.getWorkflowId(), entityInList.getTrnStatus(), null))
				.collect(Collectors.toList());
	}

}
