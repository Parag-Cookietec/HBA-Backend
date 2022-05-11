package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUEmployeePayTypeAttachmentConverter;
import gov.ifms.pvu.dto.PVUEmployeePayTypeAttachmentDto;
import gov.ifms.pvu.entity.PVUEmployeePayTypeAttachmentEntity;
import gov.ifms.pvu.repository.PVUEmployeePayTypeAttachmentRepository;

/**
 * The Class PVUReversionAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/01/13 15:56:29
 */
@Service
public class PVUEmployeePayTypeAttachmentService
		extends BasePVUAttachmentService<PVUEmployeePayTypeAttachmentEntity, PVUEmployeePayTypeAttachmentDto> {

	@Autowired
	private PVUEmployeePayTypeAttachmentRepository repository;

	@Autowired
	private PVUEmployeePayTypeAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUEmployeePayTypeAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUEmployeePayTypeAttachmentEntity, PVUEmployeePayTypeAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUEmployeePayTypeAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByReversionTpvuRegPrboSdIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}

}
