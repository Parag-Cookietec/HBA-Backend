package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUAcpRemarksDto;
import gov.ifms.pvu.entity.PVUAcpRemarksEntity;

/**
 * The Class PVURopRemarksEntityConverter class.
 * 
 * @version v 1.0
 * @created 2020/04/14 15:45:41
 *
 */
@Component
public class PVUAcpRemarksConverter implements BaseConverter<PVUAcpRemarksEntity, PVUAcpRemarksDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVURopRemarksEntity entity
	 */
	@Override
	public PVUAcpRemarksEntity toEntity(PVUAcpRemarksDto dto) {
		PVUAcpRemarksEntity entity = new PVUAcpRemarksEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVURopRemarksEntity dto
	 */
	@Override
	public PVUAcpRemarksDto toDTO(PVUAcpRemarksEntity entity) {
		PVUAcpRemarksDto dto = new PVUAcpRemarksDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
