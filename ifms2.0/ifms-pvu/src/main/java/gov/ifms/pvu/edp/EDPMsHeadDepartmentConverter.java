package gov.ifms.pvu.edp;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSDTDto;

/**
 * The Class EDPMsHeadDepartmentConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/15 15:35:39
 *
 */
@Component
public class EDPMsHeadDepartmentConverter implements BaseConverter<EDPMsHeadDepartmentEntity,EDPMsHeadDepartmentDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsHeadDepartment entity
	 */
	@Override
	public EDPMsHeadDepartmentEntity toEntity(EDPMsHeadDepartmentDto dto) {
		EDPMsHeadDepartmentEntity entity = new EDPMsHeadDepartmentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsHeadDepartment  dto
	 */
	@Override
	public EDPMsHeadDepartmentDto toDTO(EDPMsHeadDepartmentEntity entity) {
		EDPMsHeadDepartmentDto dto = new EDPMsHeadDepartmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsHeadDepartmentEntity> list) {
		return list.stream().filter(ent -> Objects.nonNull(ent.getDepartmentId()))
				.map(entityInList -> new EDPSDTDto(entityInList.getHodId(), entityInList.getHodName(),
						entityInList.getHodCode(), entityInList.getDepartmentId().getDepartmentId()))
				.collect(Collectors.toList());
	}
	
}
