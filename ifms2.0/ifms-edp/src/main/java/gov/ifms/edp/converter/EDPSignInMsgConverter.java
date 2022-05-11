package gov.ifms.edp.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSignInMsgDto;
import gov.ifms.edp.entity.EDPSignInMsgEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class EDPSignInMsgConverter class.
 * 
 * @version 1.0
 * @created 2019/12/26 11:14:39
 *
 */
@Component
public class EDPSignInMsgConverter implements BaseConverter<EDPSignInMsgEntity, EDPSignInMsgDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPostOffice entity
	 */
	@Override
	public EDPSignInMsgEntity toEntity(EDPSignInMsgDto dto) {
		EDPSignInMsgEntity entity = new EDPSignInMsgEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPostOffice  dto
	 */
	@Override
	public EDPSignInMsgDto toDTO(EDPSignInMsgEntity entity) {
		EDPSignInMsgDto dto = new EDPSignInMsgDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
