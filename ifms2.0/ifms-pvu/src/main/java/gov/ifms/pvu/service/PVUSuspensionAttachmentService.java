package gov.ifms.pvu.service;


import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSuspensionAttachmentConverter;
import gov.ifms.pvu.dto.PVUSuspensionAttachmentDto;
import gov.ifms.pvu.entity.PVUSuspensionAttachmentEntity;
import gov.ifms.pvu.repository.PVUSuspensionAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PVUSuspensionAttachmentService extends BasePVUAttachmentService<PVUSuspensionAttachmentEntity, PVUSuspensionAttachmentDto> {

    @Autowired
    private PVUSuspensionAttachmentRepository repository;

    @Autowired
    private PVUSuspensionAttachmentConverter converter;

    @Override
    public BasePVUAttachmentRepository<PVUSuspensionAttachmentEntity> getRepository() {
        return repository;
    }

    @Override
    public BasePVUAttachmentConverter<PVUSuspensionAttachmentEntity, PVUSuspensionAttachmentDto> getConverter() {
        return converter;
    }


    @Override
    public List<PVUSuspensionAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
        return repository.findAllBySuspensionIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
    }

    @Override
    public void updateStatusAsDelete(IdDto dto) {
        repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
    }
}
