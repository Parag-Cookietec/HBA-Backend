package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUReversionAttachmentConverter;
import gov.ifms.pvu.dto.PVUReversionAttachmentDto;
import gov.ifms.pvu.entity.PVUReversionAttachmentEntity;
import gov.ifms.pvu.repository.PVUReversionAttachmentRepository;

/**
 * The Class PVUReversionAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 */
@Service
public class PVUReversionAttachmentService
		extends BasePVUAttachmentService<PVUReversionAttachmentEntity, PVUReversionAttachmentDto> {

	@Autowired
	private PVUReversionAttachmentRepository repository;

	@Autowired
	private PVUReversionAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUReversionAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUReversionAttachmentEntity, PVUReversionAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUReversionAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByReversionIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}

}
