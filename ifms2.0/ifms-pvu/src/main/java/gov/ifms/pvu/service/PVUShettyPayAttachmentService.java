package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUShettyPayAttachmentConverter;
import gov.ifms.pvu.dto.PVUShettyPayAttachmentDto;
import gov.ifms.pvu.entity.PVUShettyPayAttachmentEntity;
import gov.ifms.pvu.repository.PVUShettyPayAttachmentRepository;

/**
 * The Class PVUReversionAttachmentController.
 *
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 */
@Service
public class PVUShettyPayAttachmentService
		extends BasePVUAttachmentService<PVUShettyPayAttachmentEntity, PVUShettyPayAttachmentDto> {

	@Autowired
	private PVUShettyPayAttachmentRepository repository;

	@Autowired
	private PVUShettyPayAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUShettyPayAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUShettyPayAttachmentEntity, PVUShettyPayAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUShettyPayAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllBySpIdIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}

}
