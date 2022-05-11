package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPMsStateDto;
import gov.ifms.edp.entity.EDPMsStateEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPMsStateConverter class.
 *
 * @version v 1.0
 * @created 2019/12/12 00:20:00
 *
 */
@Component
public class EDPMsStateConverter implements BaseConverter<EDPMsStateEntity,EDPMsStateDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the EDPMsState entity
     */
    @Override
    public EDPMsStateEntity toEntity(EDPMsStateDto dto) {
        EDPMsStateEntity entity = new EDPMsStateEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the EDPMsState  dto
     */
    @Override
    public EDPMsStateDto toDTO(EDPMsStateEntity entity) {
        EDPMsStateDto dto = new EDPMsStateDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
