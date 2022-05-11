package gov.ifms.edp.report.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.report.dto.CommonDesignMasterDto;
import gov.ifms.edp.report.entity.CommonDesignMasterEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class CommonDesignMasterConverter class.
 * 
 * @version 1.0
 * @created 2021/02/23 13:37:15
 *
 */
@Component
public class CommonDesignMasterConverter implements BaseConverter<CommonDesignMasterEntity,CommonDesignMasterDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the CommonDesignMaster entity
	 */
	@Override
	public CommonDesignMasterEntity toEntity(CommonDesignMasterDto dto) {
		CommonDesignMasterEntity entity = new CommonDesignMasterEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the CommonDesignMaster  dto
	 */
	@Override
	public CommonDesignMasterDto toDTO(CommonDesignMasterEntity entity) {
		CommonDesignMasterDto dto = new CommonDesignMasterDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
