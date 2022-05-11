package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPTedpUptTrnDataDto;
import gov.ifms.edp.entity.EDPTedpUptTrnDataEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPTedpUptTrnDataConverter class.
 * 
 * @version 1.0
 * @created 2020/07/08 13:14:11
 *
 */
@Component
public class EDPTedpUptTrnDataConverter implements BaseConverter<EDPTedpUptTrnDataEntity, EDPTedpUptTrnDataDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPTedpUptTrnData entity
	 */
	@Override
	public EDPTedpUptTrnDataEntity toEntity(EDPTedpUptTrnDataDto dto) {
		EDPTedpUptTrnDataEntity entity = new EDPTedpUptTrnDataEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPTedpUptTrnData dto
	 */
	@Override
	public EDPTedpUptTrnDataDto toDTO(EDPTedpUptTrnDataEntity entity) {
		EDPTedpUptTrnDataDto dto = new EDPTedpUptTrnDataDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
