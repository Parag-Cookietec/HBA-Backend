package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.loc.dto.LocAccountOpenReqBankDtlDto;
import gov.ifms.loc.entity.LocAccountOpenReqBankDtlEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class LocAccountOpenReqBankDtlConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 18:18:37
 *
 */
@Component
public class LocAccountOpenReqBankDtlConverter
		implements BaseConverter<LocAccountOpenReqBankDtlEntity, LocAccountOpenReqBankDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqBankDtl entity
	 */
	@Override
	public LocAccountOpenReqBankDtlEntity toEntity(LocAccountOpenReqBankDtlDto dto) {
		LocAccountOpenReqBankDtlEntity entity = new LocAccountOpenReqBankDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqBankDtl dto
	 */
	@Override
	public LocAccountOpenReqBankDtlDto toDTO(LocAccountOpenReqBankDtlEntity entity) {
		LocAccountOpenReqBankDtlDto dto = new LocAccountOpenReqBankDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
