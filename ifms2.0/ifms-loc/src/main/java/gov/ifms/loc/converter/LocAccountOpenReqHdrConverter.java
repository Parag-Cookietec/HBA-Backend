package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.loc.dto.LocAccountOpenReqHdrDto;
import gov.ifms.loc.entity.LocAccountOpenReqHdrEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class LocAccountOpenReqHdrConverter class.
 *
 * @version 1.0
 * @created 2020/12/22 12:52:20
 */
@Component
public class LocAccountOpenReqHdrConverter implements BaseConverter<LocAccountOpenReqHdrEntity, LocAccountOpenReqHdrDto> {

    @Autowired
    private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocAccountOpenReqHdr entity
     */
    @Override
    public LocAccountOpenReqHdrEntity toEntity(LocAccountOpenReqHdrDto dto) {
        LocAccountOpenReqHdrEntity entity = new LocAccountOpenReqHdrEntity();
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
    public LocAccountOpenReqHdrDto toDTO(LocAccountOpenReqHdrEntity entity) {
        LocAccountOpenReqHdrDto dto = new LocAccountOpenReqHdrDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    /**
     * Sets the dto to entity.
     *
     * @param dto    the dto
     * @param entity the entity
     */
    private void setDtoToEntity(LocAccountOpenReqHdrDto dto, LocAccountOpenReqHdrEntity entity) {
        if (null != dto.getDepartmentId()) {
            entity.setDeptIdReHdr(new EDPMsDepartmentEntity(dto.getDepartmentId()));
        }
        if (null != dto.getToOfficeId()) {
            entity.setToOfficeId(new EDPMsOfficeEntity(dto.getToOfficeId()));
        }
        if (null != dto.getDistrictId()) {
            entity.setDistrictIdReHdr(new EDPMsDistrictEntity(dto.getDistrictId()));
        }
        if (null != dto.getRequestingOfficeId()) {
            entity.setRequestingOfficeId(new EDPMsOfficeEntity(dto.getRequestingOfficeId()));
        }
        if (null != dto.getOfficeNameId()) {
            entity.setOfficeNameId(new EDPMsOfficeEntity(dto.getOfficeNameId()));
        }
        if (null != dto.getStatusId()) {
            EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = edpLuLookUpInfoRepository.getOne(dto.getStatusId());
            entity.setStatusId(edpLuLookUpInfoEntity);
        }
    }

}
