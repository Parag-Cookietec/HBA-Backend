package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.pvu.dto.PVUMsPayLevelDto;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.entity.PVUMsPayLevelEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUMsPayLevelConverter class.
 */
@Component
public class PVUMsPayLevelConverter implements BaseConverter<PVUMsPayLevelEntity, PVUMsPayLevelDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVUMsPayLevel entity
     */
    @Override
    public PVUMsPayLevelEntity toEntity(PVUMsPayLevelDto dto) {
        PVUMsPayLevelEntity entity = new PVUMsPayLevelEntity();
        BeanUtils.copyProperties(dto, entity);
        entity.setPayBand(new PVUMsPayBandEntity(dto.getPayBandId()));
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVUMsPayLevel  dto
     */
    @Override
    public PVUMsPayLevelDto toDTO(PVUMsPayLevelEntity entity) {
        PVUMsPayLevelDto dto = new PVUMsPayLevelDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setPayBandId(entity.getPayBand().getId());
        return dto;
    }

}
