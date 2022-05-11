package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocChequeToChequeWfDto;
import gov.ifms.loc.entity.LocChequeToChequeWfEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class LocAccountOpenReqDtlConverter class.
 *
 * @version 1.0
 * @created 2020/12/23 11:53:12
 *
 */
@Component
public class LocChequeToChequeConverter implements BaseConverter<LocChequeToChequeWfEntity, LocChequeToChequeWfDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocAccountOpenReqDtl entity
     */
    @Override
    public LocChequeToChequeWfEntity toEntity(LocChequeToChequeWfDto dto) {
        LocChequeToChequeWfEntity entity = new LocChequeToChequeWfEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocAccountOpenReqDtl dto
     */
    @Override
    public LocChequeToChequeWfDto toDTO(LocChequeToChequeWfEntity entity) {
        LocChequeToChequeWfDto dto = new LocChequeToChequeWfDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
