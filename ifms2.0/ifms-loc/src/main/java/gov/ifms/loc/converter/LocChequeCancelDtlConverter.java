package gov.ifms.loc.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeCancelDtlDto;
import gov.ifms.loc.dto.LocChequeCancelEditViewDtlDto;
import gov.ifms.loc.entity.LocChequeCancelDtlEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocChequeCancelDtlConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/06 17:42:56
 *
 */
@Component
public class LocChequeCancelDtlConverter implements BaseConverter<LocChequeCancelDtlEntity,LocChequeCancelDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeCancelDtl entity
	 */
	@Override
	public LocChequeCancelDtlEntity toEntity(LocChequeCancelDtlDto dto) {
		LocChequeCancelDtlEntity entity = new LocChequeCancelDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeCancelDtl  dto
	 */
	@Override
	public LocChequeCancelDtlDto toDTO(LocChequeCancelDtlEntity entity) {
		LocChequeCancelDtlDto dto = new LocChequeCancelDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	/**
	 * Dtlto sd DTO.
	 *
	 * @param entity the entity
	 * @return the list
	 */
	public List<LocChequeCancelEditViewDtlDto> dtltoSdDTO(List<LocChequeCancelDtlEntity> entity ) {
		 List<LocChequeCancelEditViewDtlDto> dtoList =new ArrayList<>();
		 for(LocChequeCancelDtlEntity dtlEntity : entity) {
			 LocChequeCancelEditViewDtlDto dto=new LocChequeCancelEditViewDtlDto();
			 BeanUtils.copyProperties(dtlEntity, dto);
				dtoList.add(dto);
		 }
		 
		return dtoList;
	}
	
}
