package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.loc.dto.LocAccountCloseReqHdrDto;
import gov.ifms.loc.entity.LocAccountCloseReqHdrEntity;
import gov.ifms.loc.entity.LocAccountOpeningRequestHdrEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * The Class LocAccountCloseReqHdrConverter.
 */
@Component
public class LocAccountCloseReqHdrConverter implements BaseConverter<LocAccountCloseReqHdrEntity, LocAccountCloseReqHdrDto> {


    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocAccountOpenReqHdr entity
     */

    @Override
    public LocAccountCloseReqHdrEntity toEntity(LocAccountCloseReqHdrDto dto) {
        LocAccountCloseReqHdrEntity entity = new LocAccountCloseReqHdrEntity();
        BeanUtils.copyProperties(dto, entity);
        setDtoToEntity(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocAccountOpenReqHdr  dto
     */

    @Override
    public LocAccountCloseReqHdrDto toDTO(LocAccountCloseReqHdrEntity entity) {
        LocAccountCloseReqHdrDto dto = new LocAccountCloseReqHdrDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }


    /**
     * Sets the dto to entity.
     *
     * @param dto    the dto
     * @param entity the entity
     */
    private void setDtoToEntity(LocAccountCloseReqHdrDto dto, LocAccountCloseReqHdrEntity entity) {
        if (null != dto.getLcOpenRequestId()) {
            entity.setLcOpenRequestId(new LocAccountOpeningRequestHdrEntity(dto.getLcOpenRequestId()));
        }

        if (null != dto.getOfficeId()) {
            entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
        }
	

    }
}