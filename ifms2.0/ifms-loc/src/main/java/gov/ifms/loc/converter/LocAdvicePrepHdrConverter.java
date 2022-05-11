package gov.ifms.loc.converter;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.loc.dto.LocAdvicePrepHdrDto;
import gov.ifms.loc.entity.LocAdvicePrepHdrEntity;
import gov.ifms.loc.entity.LocMsBankEntity;
import gov.ifms.loc.entity.LocMsDivisonEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * The Class LocAdvicePrepHdrConverter class.
 *
 * @version v 1.0
 * @created 2021/02/23 12:11:35
 */
@Component
public class LocAdvicePrepHdrConverter implements BaseConverter<LocAdvicePrepHdrEntity, LocAdvicePrepHdrDto> {

    /**
     * To entity.
     *
     * @param dto the dto
     * @return the LocAdvicePrepHdr entity
     */
    @Override
    public LocAdvicePrepHdrEntity toEntity(LocAdvicePrepHdrDto dto) {
        LocAdvicePrepHdrEntity entity = new LocAdvicePrepHdrEntity();
        if (null != dto.getDivId()) {
            entity.setDivId(new LocMsDivisonEntity(dto.getDivId()));
        }
        if (null != dto.getBankId()) {
            entity.setBankId(new LocMsBankEntity(dto.getBankId()));
        }
        if (null != dto.getDeptId()) {
            entity.setDeptId(new EDPMsDepartmentEntity(dto.getDeptId()));
        }
        if (null != dto.getDistrictId()) {
            entity.setDistrictId(new EDPMsDistrictEntity(dto.getDistrictId()));
        }
        if (null != dto.getCardexNo()) {
            entity.setCardexNo(dto.getCardexNo());
        }
        if (null != dto.getDdoNo()) {
            entity.setDdoNo(dto.getDdoNo());
        }
        if (null != dto.getPaymentTypeId()) {
            entity.setPaymentTypeId(dto.getPaymentTypeId());
        }

        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * To DTO.
     *
     * @param entity the entity
     * @return the LocAdvicePrepHdr  dto
     */
    @Override
    public LocAdvicePrepHdrDto toDTO(LocAdvicePrepHdrEntity entity) {
        LocAdvicePrepHdrDto dto = new LocAdvicePrepHdrDto();
        dto.setDistrictId(entity.getDistrictId().getDistrictId());
        dto.setBankId(entity.getBankId().getbankId());
        dto.setDivId(entity.getDivId().getDivisonId());
        dto.setDeptId(entity.getDeptId().getDepartmentId());
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}
