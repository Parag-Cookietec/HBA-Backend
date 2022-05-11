package gov.ifms.loc.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountOpenReqBankItrDto;
import gov.ifms.loc.entity.LocAccountOpenReqBankItrEntity;

/**
 * The Class LocAccountOpenReqBankSdConverter class.
 * 
 * @version 1.0
 * @created 2021/01/01 16:35:39
 *
 */
@Component
public class LocAccountOpenReqBankItrConverter
		implements BaseConverter<LocAccountOpenReqBankItrEntity, LocAccountOpenReqBankItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the LocAccountOpenReqBankSd entity
	 */
	@Override
	public LocAccountOpenReqBankItrEntity toEntity(LocAccountOpenReqBankItrDto dto) {
		LocAccountOpenReqBankItrEntity entity = new LocAccountOpenReqBankItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the LocAccountOpenReqBankSd dto
	 */
	@Override
	public LocAccountOpenReqBankItrDto toDTO(LocAccountOpenReqBankItrEntity entity) {
		LocAccountOpenReqBankItrDto dto = new LocAccountOpenReqBankItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
