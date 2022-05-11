package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPUsrPoTrnsDetailDto;
import gov.ifms.edp.entity.EDPLkPostOfficeEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsItrEntity;

/**
 * The Class EDPUserPoTrnsItrConverter.
 */
@Component
public class EDPUserPoTrnsItrConverter implements BaseConverter<EDPUsrPoTrnsItrEntity, EDPUsrPoTrnsDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUserPoTrns entity
	 */
	@Override
	public EDPUsrPoTrnsItrEntity toEntity(EDPUsrPoTrnsDetailDto dto) {
		EDPUsrPoTrnsItrEntity entity = new EDPUsrPoTrnsItrEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setEdpUsrPoTrnsId(new EDPUsrPoTrnsEntity(dto.getEdpUsrPoTrnsId()));
		entity.setPostOfficeId(new EDPLkPostOfficeEntity(dto.getPostOfficeId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUserPoTrns dto
	 */
	@Override
	public EDPUsrPoTrnsDetailDto toDTO(EDPUsrPoTrnsItrEntity entity) {
		EDPUsrPoTrnsDetailDto dto = new EDPUsrPoTrnsDetailDto();
		dto.setPostOfficeId(entity.getPostOfficeId().getPostOfficeId());
		dto.setEdpUsrPoTrnsId(entity.getEdpUsrPoTrnsId().getEdpUsrPoTrnsId());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * Trns entity to itr entity.
	 *
	 * @return the EDP usr po trns itr entity
	 */
	public EDPUsrPoTrnsItrEntity trnsEntityToItrEntity(EDPUsrPoTrnsEntity entity) {
		EDPUsrPoTrnsItrEntity itrEntity = new EDPUsrPoTrnsItrEntity();
		BeanUtils.copyProperties(entity, itrEntity);
		itrEntity.setEdpUsrPoTrnsHearerId(entity.getEdpUsrPoTrnsHeaderId());
		itrEntity.setEdpUsrPoTrnsId(entity);
		return itrEntity;
	}

}
