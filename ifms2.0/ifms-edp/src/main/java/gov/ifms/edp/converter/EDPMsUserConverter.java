package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsUserDto;
import gov.ifms.edp.entity.EDPMsUserEntity;
import gov.ifms.edp.oauth.service.OAuthServiceImpl;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsUserConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 15:19:32
 *
 */
@Component
public class EDPMsUserConverter implements BaseConverter<EDPMsUserEntity, EDPMsUserDto> {

	/** The oauth service. */
	@Autowired
	private OAuthServiceImpl oauthService;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsUser entity
	 */
	@Override
	public EDPMsUserEntity toEntity(EDPMsUserDto dto) {
		EDPMsUserEntity entity = new EDPMsUserEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsUser dto
	 */
	@Override
	public EDPMsUserDto toDTO(EDPMsUserEntity entity) {
		EDPMsUserDto dto = new EDPMsUserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Employee to user dto.
	 *
	 * @param edpEmployeDto the edp employe dto
	 * @return the EDP ms user entity
	 */
	public EDPMsUserEntity employeeToUserDto(ClueDto edpEmployeDto) {
		EDPMsUserEntity userEntity = new EDPMsUserEntity();
		userEntity.setUserCode(Long.parseLong(edpEmployeDto.getCode()));
		userEntity.setUserName(edpEmployeDto.getName());
		userEntity.setPassword(oauthService.encodePassword(EDPConstant.DEFAULT_PASWD));
		userEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		return userEntity;

	}

	/**
	 * To clue dto.
	 *
	 * @param entity the entity
	 * @return the clue dto
	 */
	public ClueDto toClueDto(EDPMsUserEntity entity) {
		ClueDto dto = new ClueDto();
		dto.setId(entity.getUserId());
		dto.setName(entity.getUserName());
		return dto;
	}

}
