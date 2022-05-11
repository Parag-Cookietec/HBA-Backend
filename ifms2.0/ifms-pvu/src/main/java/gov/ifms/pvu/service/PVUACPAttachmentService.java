package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUACPAttachmentConverter;
import gov.ifms.pvu.dto.PVUACPAttachmentDto;
import gov.ifms.pvu.entity.PVUACPAttachmentEntity;
import gov.ifms.pvu.repository.PVUACPAttachmentRepository;

@Service
public class PVUACPAttachmentService extends BasePVUAttachmentService<PVUACPAttachmentEntity, PVUACPAttachmentDto> {

	@Autowired
	private PVUACPAttachmentRepository repository;

	@Autowired
	private PVUACPAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUACPAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUACPAttachmentEntity, PVUACPAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUACPAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByAcpEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}
}
