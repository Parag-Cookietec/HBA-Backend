package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPUsrPoTrnsAttItrDto;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttEntity;
import gov.ifms.edp.entity.EDPUsrPoTrnsAttItrEntity;

/**
 * The Class EDPUsrPoTrnsAttItrConverter.
 */
@Component
public class EDPUsrPoTrnsAttItrConverter implements BaseConverter<EDPUsrPoTrnsAttItrEntity,EDPUsrPoTrnsAttItrDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPUsrPoTrnsAtt entity
	 */
	@Override
	public EDPUsrPoTrnsAttItrEntity toEntity(EDPUsrPoTrnsAttItrDto dto) {
		EDPUsrPoTrnsAttItrEntity entity = new EDPUsrPoTrnsAttItrEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPUsrPoTrnsAtt  dto
	 */
	@Override
	public EDPUsrPoTrnsAttItrDto toDTO(EDPUsrPoTrnsAttItrEntity entity) {
		EDPUsrPoTrnsAttItrDto dto = new EDPUsrPoTrnsAttItrDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To itr entity.
	 *
	 * @param entityList the entity list
	 * @return the list
	 */
	public List<EDPUsrPoTrnsAttItrEntity> toItrEntity(List<EDPUsrPoTrnsAttEntity> entityList) {
		return entityList.stream().map(this::toItrEntity).collect(Collectors.toList());
	}
	
	/**
	 * To itr entity.
	 *
	 * @param entity the entity
	 * @return the EDP usr po trns att itr entity
	 */
	public EDPUsrPoTrnsAttItrEntity toItrEntity(EDPUsrPoTrnsAttEntity entity) {
		EDPUsrPoTrnsAttItrEntity itrEntity = new EDPUsrPoTrnsAttItrEntity();
		BeanUtils.copyProperties(entity, itrEntity);
		itrEntity.setEdpUsrPoTrnsHeadrId(entity.getEdpUsrPoTrnsHeadrId());
		itrEntity.setEdpUsrPoTranAttId(entity);
		itrEntity.setAttachmentId(entity.getAttachmentId());
		return itrEntity;
	}
	
}
