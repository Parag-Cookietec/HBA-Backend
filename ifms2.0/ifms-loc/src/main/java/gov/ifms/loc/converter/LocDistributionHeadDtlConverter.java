package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocDistributionHeadDtlDto;
import gov.ifms.loc.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class LocDistributionHeadDtlConverter class.
 *
 * @version v 1.0
 * @created 2021/02/11 14:51:40
 */
@Component
public class LocDistributionHeadDtlConverter implements BaseConverter<LocDistributionHeadDtlEntity, LocDistributionHeadDtlDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocDistributionHeadDtl entity
     */
    @Override
    public LocDistributionHeadDtlEntity toEntity(LocDistributionHeadDtlDto dto) {
        LocDistributionHeadDtlEntity entity = new LocDistributionHeadDtlEntity();
        if (null != dto.getHdrId()) {
            entity.setHdrId(new LocDistributionHdrEntity(dto.getHdrId()));
        }
        if (null != dto.getDemandId()) {
            entity.setDemandId(new LocMsDemandEntity(dto.getDemandId()));
        }
        if (null != dto.getMajorHeadId()) {
            entity.setMajorHeadId(new LocMsMajorHeadEntity(dto.getMajorHeadId()));
        }
        if (null != dto.getSubMajorHeadId()) {
            entity.setSubMajorHeadId(new LocMsSubMajorHeadEntity(dto.getSubMajorHeadId()));
        }
        if (null != dto.getMinorHeadId()) {
            entity.setMinorHeadId(new LocMsMinorHeadEntity(dto.getMinorHeadId()));
        }
        if (null != dto.getDetailedHeadId()) {
            entity.setDetailedHeadId(new LocMsDetailHeadEntity(dto.getDetailedHeadId()));
        }
        if (null != dto.getItemWorkName()) {
            entity.setItemWorkName(new LocMsItemEntity(dto.getItemWorkName()));
        }
        if (null != dto.getObjectClass()) {
            entity.setObjectClass(new LocMsObjectClassEntity(dto.getObjectClass()));
        }
        if (null != dto.getSubHeadId()) {
            entity.setSubHeadId(new LocMsSubHeadEntity(dto.getSubHeadId()));
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocDistributionHeadDtl  dto
     */
    @Override
    public LocDistributionHeadDtlDto toDTO(LocDistributionHeadDtlEntity entity) {
        LocDistributionHeadDtlDto dto = new LocDistributionHeadDtlDto();
        dto.setHdrId(entity.getHdrId().getId());
        dto.setDemandId(entity.getDemandId().getDemandId());
        dto.setSubMajorHeadId(entity.getSubMajorHeadId().getSubMajorHeadId());
        dto.setMajorHeadId(entity.getMajorHeadId().getMajorHeadId());
        dto.setMinorHeadId(entity.getMinorHeadId().getMinorHeadId());
        dto.setDetailedHeadId(entity.getDetailedHeadId().getDetailHeadId());
        dto.setItemWorkName(entity.getItemWorkName().getItemId());
        dto.setObjectClass(entity.getObjectClass().getObjectClassId());

        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
