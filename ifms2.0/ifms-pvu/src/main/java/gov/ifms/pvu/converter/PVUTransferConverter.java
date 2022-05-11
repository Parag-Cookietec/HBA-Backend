package gov.ifms.pvu.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.pvu.dto.PVUTransferDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUTransferEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class PVUTransferConverter class.
 *
 * @version v 1.0
 * @created 2019/12/21 22:53:07
 */
@Component
public class PVUTransferConverter implements BaseConverter<PVUTransferEntity, PVUTransferDto> {

     /**
     * To entity.
     *
     * @param dto the dto
     * @return the PVUTransfer entity
     */
     @Autowired
     private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

    @Override
    public PVUTransferEntity toEntity(PVUTransferDto dto) {
        PVUTransferEntity entity = new PVUTransferEntity();
        BeanUtils.copyProperties(dto, entity, "employees");
        if (dto.getStatusId() != 0) {
            entity.setStatus(new EDPLuLookUpInfoEntity(dto.getStatusId()));
        }
        if (dto.getOfficeId() != 0) {
            entity.setOffice(new EDPMsOfficeEntity(dto.getOfficeId()));
        }
        if (dto.getDistrictId() != 0) {
            entity.setDistrict(new EDPMsDistrictEntity(dto.getDistrictId()));
        }
        if (dto.getTransferNoonType() != 0) {
            entity.setTransferNoonType(new EDPLuLookUpInfoEntity(dto.getTransferNoonType()));
        }
        if (dto.getReasonForTransfer() != 0) {
            entity.setReasonForTransfer(new EDPLuLookUpInfoEntity(dto.getReasonForTransfer()));
        }
        if (dto.getJoiningNoonType() != 0) {
            entity.setJoiningNoonType(new EDPLuLookUpInfoEntity(dto.getJoiningNoonType()));
        }

        if (dto.getSubOfficeId() != 0) {
            entity.setSubOfficeId(new EDPMsSubOfficeEntity(dto.getSubOfficeId()));
        }
        if (dto.getJoiningSubOfficeId() != 0) {
            entity.setJoiningSubOfficeId(new EDPMsSubOfficeEntity(dto.getJoiningSubOfficeId()));
        }
        if (dto.getEmployeeId() != 0) {
            entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmployeeId()));
        }
        if (dto.getCurOfficeId() != 0) {
            entity.setCurOffice(new EDPMsOfficeEntity(dto.getCurOfficeId()));
        }
        if (dto.getCurDistrict() != 0) {
            entity.setCurDistrict(new EDPMsDistrictEntity(dto.getCurDistrict()));
        }
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the PVUTransfer dto
     */
    @Override
    public PVUTransferDto toDTO(PVUTransferEntity entity) {
        PVUTransferDto dto = new PVUTransferDto();
        BeanUtils.copyProperties(entity, dto);
        if (entity.getPvuEmployeEntity() != null) {
            dto.setEmployeeId(entity.getPvuEmployeEntity().getEmpId());
            if (entity.getPvuEmployeEntity().getEmployeeCode() != null) {
                dto.setEmployeeNo(entity.getPvuEmployeEntity().getEmployeeCode());
                dto.setEmpName(entity.getPvuEmployeEntity().getEmployeeName());
                PVUEmployeDepartmentEntity pvuEmployeDepartmentEntity=pvuEmployeDepartmentRepository.findOneByPvuEmployeEntityEmpId(entity.getPvuEmployeEntity().getEmpId());
                if(pvuEmployeDepartmentEntity!=null && pvuEmployeDepartmentEntity.getDesignationId() !=null)
                    dto.setEmpDesignation(pvuEmployeDepartmentEntity.getDesignationId().getDesignationName());

            }
        }

        if (entity.getStatus() != null) {
            dto.setStatusId(entity.getStatus().getLookUpInfoId());
        }
        if (entity.getOffice() != null) {
            dto.setOfficeId(entity.getOffice().getOfficeId());
        }
        if (entity.getDistrict() != null) {
            dto.setDistrictId(entity.getDistrict().getDistrictId());
        }
        setJoiningInfo(entity, dto);
        return dto;
    }

    private void setJoiningInfo(PVUTransferEntity entity, PVUTransferDto dto) {
        if (entity.getTransferNoonType() != null) {
            dto.setTransferNoonType(entity.getTransferNoonType().getLookUpInfoId());
        }
        if (entity.getReasonForTransfer() != null) {
            dto.setReasonForTransfer(entity.getReasonForTransfer().getLookUpInfoId());
        }
        if (entity.getJoiningNoonType() != null) {
            dto.setJoiningNoonType(entity.getJoiningNoonType().getLookUpInfoId());
        }

        if (entity.getSubOfficeId() != null) {
            dto.setSubOfficeId(entity.getSubOfficeId().getSubOfficeId());
            if (entity.getSubOfficeId().getSubOfficeId() != null) {
                dto.setCurSubOfficeName(entity.getSubOfficeId().getSubOfficeName());
            }
        }
        if (entity.getJoiningSubOfficeId() != null) {
            dto.setJoiningSubOfficeId(entity.getJoiningSubOfficeId().getSubOfficeId());
        }
        if (entity.getPvuEmployeEntity() != null) {
            dto.setEmployeeId(entity.getPvuEmployeEntity().getEmpId());
         }
        if (entity.getCurOffice() != null) {
            dto.setCurOfficeId(entity.getCurOffice().getOfficeId());
            if (entity.getCurOffice().getOfficeId() != null) {
                dto.setCurOffName(entity.getCurOffice().getOfficeName());
            }
        }
        if (entity.getCurDistrict() != null) {
            dto.setCurDistrict(entity.getCurDistrict().getDistrictId());
            if (entity.getCurDistrict().getDistrictId() != null) {
                dto.setCurDistrictName(entity.getCurDistrict().getDistrictName());
            }
        }
    }

}
