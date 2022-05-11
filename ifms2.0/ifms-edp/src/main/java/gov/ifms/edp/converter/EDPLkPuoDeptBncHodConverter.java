package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPLkPuoDeptBncHodDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkPuoDeptBncHodEntity;
import gov.ifms.edp.entity.EDPMsBranchEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;

/**
 * The Class EDPLkPuoDeptBncHodConverter class.
 * 
 * @version 1.0
 * @created 2019/12/19 12:31:18
 *
 */
@Component
public class EDPLkPuoDeptBncHodConverter implements BaseConverter<EDPLkPuoDeptBncHodEntity,EDPLkPuoDeptBncHodDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPuoDeptBncHod entity
	 */
	@Override
	public EDPLkPuoDeptBncHodEntity toEntity(EDPLkPuoDeptBncHodDto dto) {
		EDPLkPuoDeptBncHodEntity entity = new EDPLkPuoDeptBncHodEntity();
		/**
		 * entity.setPostUserOfficeId(new
		 * EDPLkPostOfficeEntity(dto.getPostUserOfficeId()));
		 */
		entity.setDepartmentId(new EDPMsDepartmentEntity(dto.getDepartmentId()));
		entity.setBranchId(new EDPMsBranchEntity(dto.getBranchId()));
		entity.setHodNameId(new EDPEmployeEntity(dto.getHodNameId()));
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPuoDeptBncHod  dto
	 */
	@Override
	public EDPLkPuoDeptBncHodDto toDTO(EDPLkPuoDeptBncHodEntity entity) {
		EDPLkPuoDeptBncHodDto dto = new EDPLkPuoDeptBncHodDto();
		/** dto.setPostUserOfficeId(entity.getPostUserOfficeId().getPostUserId()); */
		dto.setDepartmentId(entity.getDepartmentId().getDepartmentId());
		dto.setBranchId(entity.getBranchId().getBranchId());
		dto.setHodNameId(entity.getHodNameId().getEmpId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
