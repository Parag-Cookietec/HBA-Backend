package gov.ifms.pvu.service;


import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSeniorScaleAttConverter;
import gov.ifms.pvu.dto.PVUSeniorScaleAttDto;
import gov.ifms.pvu.entity.PVUSeniorScaleAttEntity;
import gov.ifms.pvu.repository.PVUSeniorScaleAttRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PVUSeniorScaleAttService extends BasePVUAttachmentService<PVUSeniorScaleAttEntity, PVUSeniorScaleAttDto> {

    @Autowired
    private PVUSeniorScaleAttRepository repository;

    @Autowired
    private PVUSeniorScaleAttConverter converter;

    @Override
    public BasePVUAttachmentRepository<PVUSeniorScaleAttEntity> getRepository() {
        return repository;
    }

    @Override
    public BasePVUAttachmentConverter<PVUSeniorScaleAttEntity, PVUSeniorScaleAttDto> getConverter() {
        return converter;
    }

    @Override
    public List<PVUSeniorScaleAttEntity> getAttachmentByReferenceId(IdDto dto) {
        return this.repository.findAllByEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
    }

    @Override
    public void updateStatusAsDelete(IdDto dto) {
        this.repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
    }

}
