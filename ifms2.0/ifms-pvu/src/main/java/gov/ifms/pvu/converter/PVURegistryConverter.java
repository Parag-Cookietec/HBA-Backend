package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.pvu.dto.PVURegistryDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import gov.ifms.pvu.entity.PVURegistryEntity;

/**
 * The Class PVURegistryConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/12 12:05:26
 *
 */
@Component
public class PVURegistryConverter implements BaseConverter<PVURegistryEntity, PVURegistryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURegistry entity
	 */
	@Override
	public PVURegistryEntity toEntity(PVURegistryDto dto) {
		PVURegistryEntity entity = new PVURegistryEntity();

		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmpId() != 0)
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		if (dto.getId() != 0)
			entity.setId(new PVUMsEventEntity(dto.getId()));
		if (dto.getStatusId() != 0)
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURegistry dto
	 */
	@Override
	public PVURegistryDto toDTO(PVURegistryEntity entity) {
		PVURegistryDto dto = new PVURegistryDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getEmpId() != null)
			dto.setEmpId(entity.getEmpId().getEmpId());
		if (entity.getId() != null)
			dto.setId(entity.getId().getId());
		if (entity.getStatusId() != null)
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		return dto;
	}

}
