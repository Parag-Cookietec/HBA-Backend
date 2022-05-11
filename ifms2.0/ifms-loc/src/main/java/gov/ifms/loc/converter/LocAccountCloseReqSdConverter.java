package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAccountCloseReqSdDto;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountCloseReqSdEntity;
import gov.ifms.loc.entity.LocAccountOpeningRequestHdrEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class LocAccountCloseReqSdConverter.
 */
@Component
public class LocAccountCloseReqSdConverter implements BaseConverter<LocAccountCloseReqSdEntity, LocAccountCloseReqSdDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the loc account close req sd entity
     */
    @Override
    public LocAccountCloseReqSdEntity toEntity(LocAccountCloseReqSdDto dto) {
        LocAccountCloseReqSdEntity entity = new LocAccountCloseReqSdEntity();
        BeanUtils.copyProperties(dto, entity);
        setDtoToEntity(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the loc account close req sd dto
     */
    @Override
    public LocAccountCloseReqSdDto toDTO(LocAccountCloseReqSdEntity entity) {
        LocAccountCloseReqSdDto dto = new LocAccountCloseReqSdDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }


    /**
     * Sets the dto to entity.
     *
     * @param dto    the dto
     * @param entity the entity
     */
    private void setDtoToEntity(LocAccountCloseReqSdDto dto, LocAccountCloseReqSdEntity entity) {
        if (null != dto.getLcOpenRequestId()) {
            entity.setLcOpenRequestId(new LocAccountOpeningRequestHdrEntity(dto.getLcOpenRequestId()));
        }

        if (null != dto.getLcCloseReqHdrId()) {
            entity.setLcCloseReqHdrId(new LocAccountCloseReqHdrEntity(dto.getLcCloseReqHdrId()));
        }
    }
}
