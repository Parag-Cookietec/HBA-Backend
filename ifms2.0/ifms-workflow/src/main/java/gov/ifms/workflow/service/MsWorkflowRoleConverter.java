package gov.ifms.workflow.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.workflow.dto.MsWorkflowRoleDto;
import gov.ifms.workflow.entity.MsWorkflowRoleEntity;

@Component
public class MsWorkflowRoleConverter  implements BaseConverter<MsWorkflowRoleEntity, MsWorkflowRoleDto>{

	/**
	 * @param dto the dto
	 * @return msWorkflowRoleEntity
	 */
	@Override
	public MsWorkflowRoleEntity toEntity(MsWorkflowRoleDto dto) {
		MsWorkflowRoleEntity msWorkflowRoleEntity = new MsWorkflowRoleEntity();
		BeanUtils.copyProperties(dto, msWorkflowRoleEntity);
		return msWorkflowRoleEntity;
	}

	/**
	 *
	 * @param entity the entity
	 * @return dto
	 */
	@Override
	public MsWorkflowRoleDto toDTO(MsWorkflowRoleEntity entity) {
		MsWorkflowRoleDto dto = new MsWorkflowRoleDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
