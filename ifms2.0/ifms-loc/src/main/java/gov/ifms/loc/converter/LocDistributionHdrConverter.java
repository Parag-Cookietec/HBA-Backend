package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocDistributionHdrDto;
import gov.ifms.loc.entity.LocDistributionHdrEntity;
import gov.ifms.loc.entity.LocMsCircleEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class LocDistributionHdrConverter class.
 *
 * @version v 1.0
 * @created 2021/02/11 14:33:34
 */
@Component
public class LocDistributionHdrConverter implements BaseConverter<LocDistributionHdrEntity, LocDistributionHdrDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocDistributionHdr entity
     */
    @Override
    public LocDistributionHdrEntity toEntity(LocDistributionHdrDto dto) {
        LocDistributionHdrEntity entity = new LocDistributionHdrEntity();
        if (null != dto.getDivId()) {
            entity.setDivId(new LocMsDivisonEntity(dto.getDivId()));
        }
        if (null != dto.getCircleId()) {
            entity.setCircleId(new LocMsCircleEntity(dto.getCircleId()));
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocDistributionHdr  dto
     */
    @Override
    public LocDistributionHdrDto toDTO(LocDistributionHdrEntity entity) {
        LocDistributionHdrDto dto = new LocDistributionHdrDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
