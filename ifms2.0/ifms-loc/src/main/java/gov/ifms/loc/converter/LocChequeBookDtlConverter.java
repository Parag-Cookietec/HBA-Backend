package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocChequeBookDtlDto;
import gov.ifms.loc.entity.LocChequeBookDtlEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LOCChequeBookDtlConverter class.
 * 
 * @version v 1.0
 * @created 2021/01/16 14:08:08
 *
 */
@Component
public class LocChequeBookDtlConverter implements BaseConverter<LocChequeBookDtlEntity,LocChequeBookDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LOCChequeBookDtl entity
	 */
	@Override
	public LocChequeBookDtlEntity toEntity(LocChequeBookDtlDto dto) {
		LocChequeBookDtlEntity entity = new LocChequeBookDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LOCChequeBookDtl  dto
	 */
	@Override
	public LocChequeBookDtlDto toDTO(LocChequeBookDtlEntity entity) {
		LocChequeBookDtlDto dto = new LocChequeBookDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
