package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUCareerAdvancementAttConverter;
import gov.ifms.pvu.dto.PVUCareerAdvanceAttachmentsDto;
import gov.ifms.pvu.entity.PVUCareerAdvanceAttachmentsEntity;
import gov.ifms.pvu.repository.PVUCareerAdvanceAttachmentsRepository;

@Service
public class PVUCareerAdvanceAttachmentService extends BasePVUAttachmentService<PVUCareerAdvanceAttachmentsEntity, PVUCareerAdvanceAttachmentsDto>{

	
    @Autowired
    private PVUCareerAdvanceAttachmentsRepository repository;

    @Autowired
    private PVUCareerAdvancementAttConverter converter;
    
	@Override
	public BasePVUAttachmentRepository<PVUCareerAdvanceAttachmentsEntity> getRepository() {
		 return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUCareerAdvanceAttachmentsEntity, PVUCareerAdvanceAttachmentsDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUCareerAdvanceAttachmentsEntity> getAttachmentByReferenceId(IdDto dto) {
		return this.repository.findAllByEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		this.repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
	}

}
