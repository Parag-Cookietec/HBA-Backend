package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocMsCircleDto;
import gov.ifms.loc.entity.LocMsCircleEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocMsCircleConvertor implements BaseConverter<LocMsCircleEntity, LocMsCircleDto> {


    /**
     * To entity.
     *
     * @param dto the dto
     * @return the loc ms circle entity
     */
    @Override
    public LocMsCircleEntity toEntity(LocMsCircleDto dto) {
        LocMsCircleEntity entity = new LocMsCircleEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the loc ms circle dto
     */
    @Override
    public LocMsCircleDto toDTO(LocMsCircleEntity entity) {
        LocMsCircleDto dto = new LocMsCircleDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
