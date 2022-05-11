package gov.ifms.gst.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.gst.dto.GSTBankRateMasterDto;
import gov.ifms.gst.entity.GSTBankRateMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class GSTBankRateMasterConverter.
 * 
 * @version v 1.0.
 * @created 2021/07/14 11:40:45.
 *
 */
@Component
public class GSTBankRateMasterConverter implements BaseConverter<GSTBankRateMaster, GSTBankRateMasterDto> {


	@Override
	public GSTBankRateMaster toEntity(GSTBankRateMasterDto dto) {
		GSTBankRateMaster entity = new GSTBankRateMaster();
		entity.setActiveStatus(Constant.ACTIVE_STATUS);
		entity.setId(dto.getId());
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public GSTBankRateMasterDto toDTO(GSTBankRateMaster entity) {
		GSTBankRateMasterDto dto = new GSTBankRateMasterDto();
		dto.setId(entity.getId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
