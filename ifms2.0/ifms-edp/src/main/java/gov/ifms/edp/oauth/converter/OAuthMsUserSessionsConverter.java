package gov.ifms.edp.oauth.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.oauth.dto.OAuthMsUserSessionsDTO;
import gov.ifms.edp.oauth.entity.OAuthMsUserSessionsEntity;


/**
 * The Class OAuthMsUserSessionsConverter.
 */
@Component
public class OAuthMsUserSessionsConverter  implements BaseConverter<OAuthMsUserSessionsEntity, OAuthMsUserSessionsDTO>  {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the o auth ms user sessions entity
	 */
	@Override
	public OAuthMsUserSessionsEntity toEntity(OAuthMsUserSessionsDTO dto) {
		OAuthMsUserSessionsEntity entity = new OAuthMsUserSessionsEntity();
		EDPMsUserEntity user = new EDPMsUserEntity();
		user.setUserId(dto.getEdpMsUserEntityId());
		entity.setEdpMsUserEntityId(user);
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the o auth ms user sessions DTO
	 */
	@Override
	public OAuthMsUserSessionsDTO toDTO(OAuthMsUserSessionsEntity entity) {
		OAuthMsUserSessionsDTO dto = new OAuthMsUserSessionsDTO();
		dto.setEdpMsUserEntityId(entity.getEdpMsUserEntityId().getUserId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
