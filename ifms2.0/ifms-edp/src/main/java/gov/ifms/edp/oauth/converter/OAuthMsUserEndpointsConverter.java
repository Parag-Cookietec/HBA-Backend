package gov.ifms.edp.oauth.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.oauth.dto.OAuthMsUserEndpointsDTO;
import gov.ifms.edp.oauth.entity.OAuthMsUserEndpointsEntity;

/**
 * The Class OAuthMsUserEndpointsConverter.
 */
@Component
public class OAuthMsUserEndpointsConverter
		implements BaseConverter<OAuthMsUserEndpointsEntity, OAuthMsUserEndpointsDTO> {

	/**
	 * To Entity.
	 *
	 * @param dto the dto
	 * @return the o auth ms user endpoints entity
	 */
	@Override
	public OAuthMsUserEndpointsEntity toEntity(OAuthMsUserEndpointsDTO dto) {
		OAuthMsUserEndpointsEntity entity = new OAuthMsUserEndpointsEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the o auth ms user endpoints DTO
	 */
	@Override
	public OAuthMsUserEndpointsDTO toDTO(OAuthMsUserEndpointsEntity entity) {
		OAuthMsUserEndpointsDTO dto = new OAuthMsUserEndpointsDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Convert ENtityList To DTO list.
	 *
	 * @param dtoList the dto list
	 * @return the list
	 */
	public List<OAuthMsUserEndpointsDTO> entityListToDtoList(List<OAuthMsUserEndpointsEntity> dtoList) {
		return dtoList.stream().map(this::toDTO).collect(Collectors.toList());
	}

	/**
	 * Convert list To DTO list entityList.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	public List<OAuthMsUserEndpointsEntity> dtoListToEntityList(List<OAuthMsUserEndpointsDTO> entityList) {
		return entityList.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
