package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPTrnUserItrDto;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.entity.EDPTrnUserItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;

/**
 * The Class EDPTrnUserItrConverter.
 */
@Component
public class EDPTrnUserItrConverter implements BaseConverter<EDPTrnUserItrEntity, EDPTrnUserItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsUser entity
	 */
	@Override
	public EDPTrnUserItrEntity toEntity(EDPTrnUserItrDto dto) {
		EDPTrnUserItrEntity entity = new EDPTrnUserItrEntity();
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
	public EDPTrnUserItrDto toDTO(EDPTrnUserItrEntity entity) {
		EDPTrnUserItrDto dto = new EDPTrnUserItrDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setUserId(entity.getUserId().getUserId());
		return dto;
	}

	/**
	 * Edp ms user totrn user itr.
	 *
	 * @param edpMsUserEntity the edp ms user entity
	 * @return the EDP trn user itr entity
	 */
	public EDPTrnUserItrEntity  edpMsUserTotrnUserItr(EDPMsUserEntity edpMsUserEntity) {
		EDPTrnUserItrEntity edpTrnUserItrEntity = new EDPTrnUserItrEntity();
		BeanUtils.copyProperties(edpMsUserEntity, edpTrnUserItrEntity);
		return edpTrnUserItrEntity;
		
	}

}
