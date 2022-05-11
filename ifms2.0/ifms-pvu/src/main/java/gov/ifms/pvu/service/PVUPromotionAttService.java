package gov.ifms.pvu.service;


import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUPromotionAttConverter;
import gov.ifms.pvu.dto.PVUPromotionAttDto;
import gov.ifms.pvu.entity.PVUPromotionAttEntity;
import gov.ifms.pvu.repository.PVUPromotionAttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PVUPromotionAttService extends BasePVUAttachmentService<PVUPromotionAttEntity, PVUPromotionAttDto> {

    @Autowired
    private PVUPromotionAttRepository repository;

    @Autowired
    private PVUPromotionAttConverter converter;

    @Override
    public BasePVUAttachmentRepository<PVUPromotionAttEntity> getRepository() {
        return repository;
    }

    @Override
    public BasePVUAttachmentConverter<PVUPromotionAttEntity, PVUPromotionAttDto> getConverter() {
        return converter;
    }

    @Override
    public List<PVUPromotionAttEntity> getAttachmentByReferenceId(IdDto dto) {
        return this.repository.findAllByEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
    }

    @Override
    public void updateStatusAsDelete(IdDto dto) {
        this.repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
    }

}
