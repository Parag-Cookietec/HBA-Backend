package gov.ifms.workflow.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.workflow.dto.MsWorkflowDto;
import gov.ifms.workflow.dto.WfActionDto;
import gov.ifms.workflow.entity.MsWorkflowActionEntity;
import gov.ifms.workflow.entity.MsWorkflowEntity;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;
import static gov.ifms.workflow.entity.MsWorkflowEntity.distinctByKey;


/**
 * The Class MsWorkflowConverter.
 * 
 * @version 1.0
 * @created 2019/08/29 16:52:45
 *
 */
@Component
public class MsWorkflowConverter implements BaseConverter<MsWorkflowEntity, MsWorkflowDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the MsWorkflowEntity entity
	 */
	@Override
	public MsWorkflowEntity toEntity(MsWorkflowDto dto) {
		MsWorkflowEntity entity = new MsWorkflowEntity();
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
	 * @return the MsWorkflowDto dto
	 */
	@Override
	public MsWorkflowDto toDTO(MsWorkflowEntity entity) {
		MsWorkflowDto dto = new MsWorkflowDto();
		dto.setOfficeTypeId(entity.getOfficeTypeId().getLookUpInfoId());
		dto.setWfRoleId(entity.getMsWorkflowRoleEntity().getWfRoleId());
		dto.setWfActionId(entity.getMsWorkflowActionEntity().getWfActionId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To Dto
	 *
	 * @param entities
	 * @return the list
	 */
	public List<WfActionDto> toWfActionDTO(List<MsWorkflowEntity> entities) {
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
	public List<EDPSDTDto> toEDPSDTDto(List<MsWorkflowEntity> list) {
		return list.stream().filter(distinctByKey(MsWorkflowEntity::getWfStatus))
				.map(entityInList -> new EDPSDTDto(entityInList.getWorkflowId(), entityInList.getWfStatus(), null))
				.collect(Collectors.toList());
	}

	public List<EDPSDTDto> toTrnStatus(List<MsWorkflowEntity> list) {
		return list.stream().filter(distinctByKey(MsWorkflowEntity::getTrnStatus))
				.map(entityInList -> new EDPSDTDto(entityInList.getWorkflowId(), entityInList.getTrnStatus(), null))
				.collect(Collectors.toList());
	}

}
