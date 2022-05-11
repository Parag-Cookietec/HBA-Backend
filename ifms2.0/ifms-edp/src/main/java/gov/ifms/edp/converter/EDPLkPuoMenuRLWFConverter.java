package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPLkPuoMenuRLWFDto;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPLkPuoMenuRLWFConverter class.
 * 
 * @version 1.0
 * @created 2019/11/28 12:49:10
 *
 */
@Component
public class EDPLkPuoMenuRLWFConverter implements BaseConverter<EDPTrnUsrMnuWfRole,EDPLkPuoMenuRLWFDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkPuoMenuRLWF entity
	 */
	@Override
	public EDPTrnUsrMnuWfRole toEntity(EDPLkPuoMenuRLWFDto dto) {
		EDPTrnUsrMnuWfRole entity = new EDPTrnUsrMnuWfRole();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkPuoMenuRLWF  dto
	 */
	@Override
	public EDPLkPuoMenuRLWFDto toDTO(EDPTrnUsrMnuWfRole entity) {
		EDPLkPuoMenuRLWFDto dto = new EDPLkPuoMenuRLWFDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
}
