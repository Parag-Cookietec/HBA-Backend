package gov.ifms.pvu.converter;

import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUMsGradePayDto;
import gov.ifms.pvu.entity.PVUMsGradePayEntity;

/**
 * The Class PVUGradePayConverter class.
 * 
 * @version v 1.0
 * @created 2019/12/23 11:25:42
 *
 */
@Component
public class PVUMsGradePayConverter implements BaseConverter<PVUMsGradePayEntity, PVUMsGradePayDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUGradePay entity
	 */
	@Override
	public PVUMsGradePayEntity toEntity(PVUMsGradePayDto dto) {
		PVUMsGradePayEntity entity = new PVUMsGradePayEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUGradePay dto
	 */
	@Override
	public PVUMsGradePayDto toDTO(PVUMsGradePayEntity entity) {
		PVUMsGradePayDto dto = new PVUMsGradePayDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setPayBandId(entity.getPayBand().getId());
		return dto;
	}

}
