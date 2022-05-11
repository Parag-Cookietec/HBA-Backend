package gov.ifms.workflow.converter;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.workflow.dto.EdpTrnOffModWfDto;
import gov.ifms.workflow.entity.EdpTrnOffModWfEntity;



/**
 * The Class EdpTrnOffModWfConverter.
 */
@Component
public class EdpTrnOffModWfConverter implements BaseConverter<EdpTrnOffModWfEntity,EdpTrnOffModWfDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the trn edp wf entity
	 */
	@Override
	public EdpTrnOffModWfEntity toEntity(EdpTrnOffModWfDto dto) {
		EdpTrnOffModWfEntity entity = new EdpTrnOffModWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the trn edp wf dto
	 */
	@Override
	public EdpTrnOffModWfDto toDTO(EdpTrnOffModWfEntity entity) {
		EdpTrnOffModWfDto dto = new EdpTrnOffModWfDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To view.
	 *
	 * @param trnId
	 * @return the trn edp wf dto
	 */
	public EdpTrnOffModWfDto toView(Long trnId) {
		EdpTrnOffModWfDto dto = new EdpTrnOffModWfDto();
		dto.setEdpTrnOffModWfId(trnId);
		return dto;
	}
	
}
