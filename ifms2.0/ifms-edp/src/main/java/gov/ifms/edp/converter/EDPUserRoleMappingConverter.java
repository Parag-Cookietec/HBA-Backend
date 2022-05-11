package gov.ifms.edp.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPEmpByOffIdDto;
import gov.ifms.edp.dto.EDPUserRoleMappingDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPUserRoleMappingEntity;

/**
 * The Class EDPUserRoleMappingConverter class.
 * 
 * @version 1.0
 * @created 2019/12/30 11:27:53
 *
 */
@Component
public class EDPUserRoleMappingConverter implements BaseConverter<EDPUserRoleMappingEntity, EDPUserRoleMappingDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUserRoleMapping entity
	 */
	@Override
	public EDPUserRoleMappingEntity toEntity(EDPUserRoleMappingDto dto) {
		EDPUserRoleMappingEntity entity = new EDPUserRoleMappingEntity();

		BeanUtils.copyProperties(dto, entity);
		entity.setPostOfficeUserId(new EDPLkPoOffUserEntity(dto.getPostOfficeUserId()));
		entity.setSubmissionStatus(new EDPLuLookUpInfoEntity(dto.getSubmissionStatus()));
		return entity;
	}

	/**
	 * To entity list.
	 *
	 * @param dtos the dtos
	 * @return the list
	 */
	public List<EDPUserRoleMappingEntity> toEntityList(List<EDPUserRoleMappingDto> dtos) {
		EDPUserRoleMappingEntity entity = null;
		ArrayList<EDPUserRoleMappingEntity> list = new ArrayList<>();
		for (EDPUserRoleMappingDto dto : dtos) {
			entity = new EDPUserRoleMappingEntity();
			BeanUtils.copyProperties(dto, entity);
			list.add(entity);
		}
		return list;
	}

	/**
	 * To DTO list.
	 *
	 * @param entities the entities
	 * @return the list
	 */
	public List<EDPUserRoleMappingDto> toDTOList(List<EDPUserRoleMappingEntity> entities) {

		EDPUserRoleMappingDto dto = null;
		ArrayList<EDPUserRoleMappingDto> list = new ArrayList<>();
		for (EDPUserRoleMappingEntity entity : entities) {
			dto = new EDPUserRoleMappingDto();
			BeanUtils.copyProperties(dto, entity);
			list.add(dto);
		}
		return list;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUserRoleMapping dto
	 */
	@Override
	public EDPUserRoleMappingDto toDTO(EDPUserRoleMappingEntity entity) {
		EDPUserRoleMappingDto dto = new EDPUserRoleMappingDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setPostOfficeUserId(entity.getPostOfficeUserId().getLkPoOffUserId());
		dto.setSubmissionStatus(entity.getSubmissionStatus().getLookUpInfoId());
		return dto;
	}
	
	public EDPEmpByOffIdDto toEmpByOffIdDto(EDPEmployeEntity entity) {
		EDPEmpByOffIdDto dto = new EDPEmpByOffIdDto();
		dto.setEmpId(entity.getEmpId());
		dto.setEmpName(entity.getEmployeeName());
		dto.setEmpNo(entity.getEmployeeCode());
		return dto;
	}
	
	public List<EDPEmpByOffIdDto> toEmpOffIdDTO(List<EDPLkPoOffUserEntity> entity) {
		List<EDPEmpByOffIdDto> list =new ArrayList<>();
		for (EDPLkPoOffUserEntity edpLkPoOffUserEntity : entity) {
		EDPEmpByOffIdDto dto = new EDPEmpByOffIdDto();
		dto.setEmpNo(edpLkPoOffUserEntity.getUserId().getUserCode());
		list.add(dto);
		}
		return list;
	}
	
}
