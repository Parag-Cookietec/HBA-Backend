package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPLkPostUserOfficeDto;
import gov.ifms.edp.entity.EDPLkPostUserOfficeEntity;

/**
 * The Class EDPLkPostUserOfficeConverter.
 */
@Component
public class EDPLkPostUserOfficeConverter implements BaseConverter<EDPLkPostUserOfficeEntity, EDPLkPostUserOfficeDto>{

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP lk post user office entity
	 */
	@Override
	public EDPLkPostUserOfficeEntity toEntity(EDPLkPostUserOfficeDto dto) {
		EDPLkPostUserOfficeEntity entity = new EDPLkPostUserOfficeEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP lk post user office dto
	 */
	@Override
	public EDPLkPostUserOfficeDto toDTO(EDPLkPostUserOfficeEntity entity) {
		EDPLkPostUserOfficeDto dto = new EDPLkPostUserOfficeDto();
		dto.setOfficeId(entity.getOfficeEntity().getOfficeId());
		dto.setPostId(entity.getPostEntity().getPostId());
		dto.setUserId(entity.getUserEntity().getUserId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To DTO.
	 *
	 * @param list the list
	 * @return the list
	 */
	@Override
	public List<EDPLkPostUserOfficeDto> toDTO(List<EDPLkPostUserOfficeEntity> list){
			return list.stream().map(this::toDTO).collect(Collectors.toList());
		}

}
