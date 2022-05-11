package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUEmployeeEventStatusDto;
import gov.ifms.pvu.entity.PVUEmployeeEventStatusEntity;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;

/**
 * The Class PVUEmployeeEventStatusConverter class.
 * 
 * @version v 1.0
 * @created 2020/02/15 14:20:18
 *
 */
@Component
public class PVUEmployeeEventStatusConverter implements BaseConverter<PVUEmployeeEventStatusEntity,PVUEmployeeEventStatusDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeeEventStatus entity
	 */
	@Override
	public PVUEmployeeEventStatusEntity toEntity(PVUEmployeeEventStatusDto dto) {
		PVUEmployeeEventStatusEntity entity = new PVUEmployeeEventStatusEntity();
		BeanUtils.copyProperties(dto, entity);
		if (!Utils.isEmpty(dto.getTransId())) {
			entity.setTransId(dto.getTransId());
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeeEventStatus  dto
	 */
	@Override
	public PVUEmployeeEventStatusDto toDTO(PVUEmployeeEventStatusEntity entity) {
		PVUEmployeeEventStatusDto dto = new PVUEmployeeEventStatusDto();
		BeanUtils.copyProperties(entity, dto);
		if (!Utils.isEmpty(entity.getTransId())) {
			dto.setTransId(entity.getTransId());
		}
		
		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
			dto.setEmployeeCode(entity.getEmpId().getEmployeeCode());
		}
		return dto;
	}
	
}
