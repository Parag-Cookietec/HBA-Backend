package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUCsAttachmentsConverter;
import gov.ifms.pvu.dto.PVUCsAttachmentDto;
import gov.ifms.pvu.entity.PVUCsAttachmentsEntity;
import gov.ifms.pvu.repository.PVUCsAttachmentRepository;

@Service
public class PVUCsAttachmentService extends BasePVUAttachmentService<PVUCsAttachmentsEntity, PVUCsAttachmentDto> {

	@Autowired
	private PVUCsAttachmentRepository repository;

	@Autowired
	private PVUCsAttachmentsConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUCsAttachmentsEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUCsAttachmentsEntity, PVUCsAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUCsAttachmentsEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByChangeOfScaleIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}
}
