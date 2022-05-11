package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeToChequeDetailDto;
import gov.ifms.loc.entity.LocChequeToChequeDetailEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocChequeToChequeDetailConverter class.
 * 
 * @version v 1.0
 * @created 2021/03/22 10:16:18
 *
 */
@Component
public class LocChequeToChequeDetailConverter implements BaseConverter<LocChequeToChequeDetailEntity,LocChequeToChequeDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocChequeToChequeDetail entity
	 */
	@Override
	public LocChequeToChequeDetailEntity toEntity(LocChequeToChequeDetailDto dto) {
		LocChequeToChequeDetailEntity entity = new LocChequeToChequeDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocChequeToChequeDetail  dto
	 */
	@Override
	public LocChequeToChequeDetailDto toDTO(LocChequeToChequeDetailEntity entity) {
		LocChequeToChequeDetailDto dto = new LocChequeToChequeDetailDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
