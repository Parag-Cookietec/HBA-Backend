package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUMsEventDto;
import gov.ifms.pvu.entity.PVUMsEventEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUMsEventConverter class.
 */
@Component
public class PVUMsEventConverter implements BaseConverter<PVUMsEventEntity, PVUMsEventDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVUMsEventEntity entity
     */
    @Override
    public PVUMsEventEntity toEntity(PVUMsEventDto dto) {
        PVUMsEventEntity entity = new PVUMsEventEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVUMsEventDto dto
     */
    @Override
    public PVUMsEventDto toDTO(PVUMsEventEntity entity) {
        PVUMsEventDto dto = new PVUMsEventDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
