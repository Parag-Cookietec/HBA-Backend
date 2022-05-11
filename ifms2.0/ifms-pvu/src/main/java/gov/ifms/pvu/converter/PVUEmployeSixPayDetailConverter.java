package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.pvu.dto.PVUEmployeSixPayDetailDto;
import gov.ifms.pvu.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class PVUEmployeSixPayDetailConverter class.
 *
 * @version v 1.0
 * @created 2019/11/26 12:51:22
 */
@Component
public class PVUEmployeSixPayDetailConverter
        implements BaseConverter<PVUEmployeSixPayDetailEntity, PVUEmployeSixPayDetailDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVUEmploye6PayDetail entity
     */
    @Override
    public PVUEmployeSixPayDetailEntity toEntity(PVUEmployeSixPayDetailDto dto) {
        if (dto == null) {
            return null;
        }

        PVUEmployeSixPayDetailEntity entity = new PVUEmployeSixPayDetailEntity();
        BeanUtils.copyProperties(dto, entity);
        if (dto.getEmpId() != 0) {
            entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
        }
        if (dto.getGradePay() != null && dto.getGradePay() != 0) {
            entity.setGradePay(new PVUMsGradePayEntity(dto.getGradePay()));
        }
        if (dto.getStatusId() != null && dto.getStatusId() != 0) {
            entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
        }
        if (dto.getNpaAmount() != null && dto.getNpaAmount() != 0) {
            entity.setNpaAmount(new EDPLuLookUpInfoEntity(dto.getNpaAmount()));
        }

        if (dto.getPreRevisedPayScale() != null && dto.getPreRevisedPayScale() > 0) {
            entity.setPreRevisedPayScale(new PVUMsPayScaleEntity(dto.getPreRevisedPayScale()));
        }

        if (dto.getRevisedPayBand()  != null && dto.getRevisedPayBand() != 0) {
            entity.setRevisedPayBand(new PVUMsPayBandEntity(dto.getRevisedPayBand()));
        }
        if (dto.getEmpDesignationAsOn() != null && dto.getEmpDesignationAsOn() != 0) {
            entity.setEmpDesignationAsOn(new EDPMsDesignationEntity(dto.getEmpDesignationAsOn()));
        }
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVUEmploye6PayDetail dto
     */
    @Override
    public PVUEmployeSixPayDetailDto toDTO(PVUEmployeSixPayDetailEntity entity) {
        if (entity == null) {
            return null;
        }

        PVUEmployeSixPayDetailDto dto = new PVUEmployeSixPayDetailDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setEmpId(entity.getPvuEmployeEntity() != null ? entity.getPvuEmployeEntity().getEmpId() : 0);
        dto.setGradePay(entity.getGradePay() != null ? entity.getGradePay().getId() : 0);
        dto.setGradePayName(entity.getGradePay() != null ? entity.getGradePay().getGradePayValue() : "");
        dto.setNpaAmount(entity.getNpaAmount() != null ? entity.getNpaAmount().getLookUpInfoId() : 0);
        dto.setNpaAmountName(entity.getNpaAmount() != null ? entity.getNpaAmount().getLookUpInfoName() : "");

        dto.setPreRevisedPayScale(entity.getPreRevisedPayScale() != null ? entity.getPreRevisedPayScale().getPayScaleId() : 0);
        dto.setPreRevisedPayScaleName(entity.getPreRevisedPayScale() != null ? entity.getPreRevisedPayScale().getPayScaleDispVal() : "");
        dto.setRevisedPayBand(entity.getRevisedPayBand() != null ? entity.getRevisedPayBand().getId() : 0);
        dto.setRevisedPayBandName(entity.getRevisedPayBand() != null ? entity.getRevisedPayBand().getPayBandDispVal() : "");
        dto.setEmpDesignationAsOn(entity.getEmpDesignationAsOn() != null ? entity.getEmpDesignationAsOn().getDesignationId() : 0);
        dto.setEmpDesignationAsOnName(entity.getEmpDesignationAsOn() != null ? entity.getEmpDesignationAsOn().getDesignationName() : "");
        dto.setStatusId(entity.getStatusId() != null ? entity.getStatusId().getLookUpInfoId() : 0);
        return dto;
    }

}
