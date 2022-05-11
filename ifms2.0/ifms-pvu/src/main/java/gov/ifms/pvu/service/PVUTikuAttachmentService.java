package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUTikuAttachmentConverter;
import gov.ifms.pvu.dto.PVUTikuAttachmentDto;
import gov.ifms.pvu.entity.PVUTikuAttachmentEntity;
import gov.ifms.pvu.repository.PVUEmployeTikuPayAttRepository;

@Service
public class PVUTikuAttachmentService extends BasePVUAttachmentService<PVUTikuAttachmentEntity, PVUTikuAttachmentDto> {

	@Autowired
	private PVUEmployeTikuPayAttRepository repository;

	@Autowired
	private PVUTikuAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUTikuAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUTikuAttachmentEntity, PVUTikuAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUTikuAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByTikuPayEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}
}
