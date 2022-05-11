package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsUserPassHistDto;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPMsUserPassHistEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class EDPMsUserPassHistConverter.
 */
@Component
public class EDPMsUserPassHistConverter implements BaseConverter<EDPMsUserPassHistEntity, EDPMsUserPassHistDto> {

	
	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsUser entity
	 */
	@Override
	public EDPMsUserPassHistEntity toEntity(EDPMsUserPassHistDto dto) {
		EDPMsUserPassHistEntity entity = new EDPMsUserPassHistEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setUserId(new EDPMsUserEntity(OAuthUtility.getCurrentUserUserId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsUser dto
	 */
	@Override
	public EDPMsUserPassHistDto toDTO(EDPMsUserPassHistEntity entity) {
		EDPMsUserPassHistDto dto = new EDPMsUserPassHistDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getUserId().getUserId());
		return dto;
	}
	
	
}
