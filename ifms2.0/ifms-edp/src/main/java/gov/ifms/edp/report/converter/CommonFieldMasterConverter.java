package gov.ifms.edp.report.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.report.dto.CommonFieldMasterDto;
import gov.ifms.edp.report.entity.CommonFieldMasterEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class CommonFieldMasterConverter class.
 * 
 * @version 1.0
 * @created 2021/02/23 13:41:52
 *
 */
@Component
public class CommonFieldMasterConverter implements BaseConverter<CommonFieldMasterEntity,CommonFieldMasterDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the CommonFieldMaster entity
	 */
	@Override
	public CommonFieldMasterEntity toEntity(CommonFieldMasterDto dto) {
		CommonFieldMasterEntity entity = new CommonFieldMasterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the CommonFieldMaster  dto
	 */
	@Override
	public CommonFieldMasterDto toDTO(CommonFieldMasterEntity entity) {
		CommonFieldMasterDto dto = new CommonFieldMasterDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
