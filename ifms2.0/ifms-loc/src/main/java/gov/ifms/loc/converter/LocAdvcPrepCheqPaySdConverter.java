package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.loc.dto.LocAdvcPrepCheqPaySdDto;
import gov.ifms.loc.entity.LocAdvcPrepCheqPaySdEntity;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class LocAdvcPrepCheqPaySdConverter implements BaseConverter<LocAdvcPrepCheqPaySdEntity, LocAdvcPrepCheqPaySdDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocChqDtlDtl entity
     */
    @Override
    public LocAdvcPrepCheqPaySdEntity toEntity(LocAdvcPrepCheqPaySdDto dto) {
        LocAdvcPrepCheqPaySdEntity entity = new LocAdvcPrepCheqPaySdEntity();
        if (null != dto.getAdviceHdrId()) {
            entity.setAdviceHdrId(new LocAdvicePrepHdrEntity(dto.getAdviceHdrId()));
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocChqDtlDtl dto
     */
    @Override
    public LocAdvcPrepCheqPaySdDto toDTO(LocAdvcPrepCheqPaySdEntity entity) {
        LocAdvcPrepCheqPaySdDto dto = new LocAdvcPrepCheqPaySdDto();
        dto.setAdviceHdrId(entity.getAdviceHdrId().getId());
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
