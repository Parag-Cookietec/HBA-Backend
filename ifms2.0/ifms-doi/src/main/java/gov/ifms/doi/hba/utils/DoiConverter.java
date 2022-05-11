package gov.ifms.doi.hba.utils;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.hba.dto.TdoiHbaClaimEntryDTO;
import gov.ifms.doi.hba.dto.TdoiHbaProposalDTO;
import gov.ifms.doi.hba.entity.TdoiHbaClaimEntryEntity;
import gov.ifms.doi.hba.entity.TdoiHbaProposalEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoiConverter implements BaseConverter<TdoiHbaClaimEntryEntity, TdoiHbaClaimEntryDTO> {
    @Override
    public TdoiHbaClaimEntryEntity toEntity(TdoiHbaClaimEntryDTO dto) {
        return null;
    }

    @Override
    public TdoiHbaClaimEntryDTO toDTO(TdoiHbaClaimEntryEntity entity) {
        TdoiHbaClaimEntryDTO dto = new TdoiHbaClaimEntryDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
