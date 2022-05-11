package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUserMnuRolePrmDto;
import gov.ifms.edp.entity.EDPLkUserMenuEntity;
import gov.ifms.edp.entity.EDPTrnUserMnuRolePrmEntity;

/**
 * The Class EDPUserMenuRolePrmConverter class.
 * 
 * @version 1.0
 * @created 2019/12/30 11:47:19
 *
 */
@Component
public class EDPUserMenuRolePrmConverter implements BaseConverter<EDPTrnUserMnuRolePrmEntity, EDPTrnUserMnuRolePrmDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDP trn user mnu role prm entity
	 */
	@Override
	public EDPTrnUserMnuRolePrmEntity toEntity(EDPTrnUserMnuRolePrmDto dto) {
		EDPTrnUserMnuRolePrmEntity entity = new EDPTrnUserMnuRolePrmEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setLkUserMenuId(new EDPLkUserMenuEntity(dto.getLkUserMenuId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP trn user mnu role prm dto
	 */
	@Override
	public EDPTrnUserMnuRolePrmDto toDTO(EDPTrnUserMnuRolePrmEntity entity) {
		EDPTrnUserMnuRolePrmDto dto = new EDPTrnUserMnuRolePrmDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setLkUserMenuId(entity.getLkUserMenuId().getLkUserMenuId());
		return dto;
	}

}
