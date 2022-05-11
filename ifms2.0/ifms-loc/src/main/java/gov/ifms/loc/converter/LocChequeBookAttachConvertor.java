package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeBookAttachDto;
import gov.ifms.loc.entity.LocChequeBookAttachEntity;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocChequeBookAttachConvertor implements BaseConverter<LocChequeBookAttachEntity, LocChequeBookAttachDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the loc cheque book attach entity
	 */
	@Override
	public LocChequeBookAttachEntity toEntity(LocChequeBookAttachDto dto) {
		LocChequeBookAttachEntity entity = new LocChequeBookAttachEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the loc cheque book attach dto
	 */
	@Override
	public LocChequeBookAttachDto toDTO(LocChequeBookAttachEntity entity) {
		LocChequeBookAttachDto dto = new LocChequeBookAttachDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
