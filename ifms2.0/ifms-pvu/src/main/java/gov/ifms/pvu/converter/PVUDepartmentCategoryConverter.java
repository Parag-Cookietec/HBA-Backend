package gov.ifms.pvu.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.pvu.dto.PVUDepartmentCategoryDto;
import gov.ifms.pvu.entity.PVUDepartmentCategoryEntity;

/**
 * The Class PVUDepartmentCategoryConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/31 16:57:07
 *
 */
@Component
public class PVUDepartmentCategoryConverter implements BaseConverter<PVUDepartmentCategoryEntity,PVUDepartmentCategoryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUDepartmentCategory entity
	 */
	@Override
	public PVUDepartmentCategoryEntity toEntity(PVUDepartmentCategoryDto dto) {
		PVUDepartmentCategoryEntity entity = new PVUDepartmentCategoryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUDepartmentCategory  dto
	 */
	@Override
	public PVUDepartmentCategoryDto toDTO(PVUDepartmentCategoryEntity entity) {
		PVUDepartmentCategoryDto dto = new PVUDepartmentCategoryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To EDPSDT dtos.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDtos(List<PVUDepartmentCategoryEntity> list) {
		return list
				.stream().map(entityList -> new EDPSDTDto(entityList.getDeptCategoryId(),
						entityList.getDepartmentCategoryName(), entityList.getDepartmentCategoryCode()))
				.collect(Collectors.toList());
	}
	
}
