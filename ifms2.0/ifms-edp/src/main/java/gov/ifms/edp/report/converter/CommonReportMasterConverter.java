package gov.ifms.edp.report.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.report.dto.CommonReportMasterDto;
import gov.ifms.edp.report.entity.CommonReportMasterEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class CommonReportMasterConverter class.
 * 
 * @version 1.0
 * @created 2021/02/23 13:34:48
 *
 */
@Component
public class CommonReportMasterConverter implements BaseConverter<CommonReportMasterEntity,CommonReportMasterDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the CommonReportMaster entity
	 */
	@Override
	public CommonReportMasterEntity toEntity(CommonReportMasterDto dto) {
		CommonReportMasterEntity entity = new CommonReportMasterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the CommonReportMaster  dto
	 */
	@Override
	public CommonReportMasterDto toDTO(CommonReportMasterEntity entity) {
		CommonReportMasterDto dto = new CommonReportMasterDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
