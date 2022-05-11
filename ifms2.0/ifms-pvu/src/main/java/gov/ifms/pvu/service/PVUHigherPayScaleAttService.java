package gov.ifms.pvu.service;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUHigherPayScaleAttConverter;
import gov.ifms.pvu.dto.PVUHigherPayScaleAttDto;
import gov.ifms.pvu.entity.PVUHigherPayScaleAttEntity;
import gov.ifms.pvu.repository.PVUHigherPayScaleAttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PVUHigherPayScaleAttService extends BasePVUAttachmentService<PVUHigherPayScaleAttEntity, PVUHigherPayScaleAttDto>
{
    @Autowired
    private PVUHigherPayScaleAttRepository repository;

    @Autowired
    private PVUHigherPayScaleAttConverter converter;


    @Override
    public BasePVUAttachmentRepository<PVUHigherPayScaleAttEntity> getRepository() {
        return repository;
    }

    @Override
    public BasePVUAttachmentConverter<PVUHigherPayScaleAttEntity, PVUHigherPayScaleAttDto> getConverter() {
        return converter;
    }

    @Override
    public List<PVUHigherPayScaleAttEntity> getAttachmentByReferenceId(IdDto dto) {
        return this.repository.findAllByEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
    }

    @Override
    public void updateStatusAsDelete(IdDto dto) {
        this.repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
    }
}
