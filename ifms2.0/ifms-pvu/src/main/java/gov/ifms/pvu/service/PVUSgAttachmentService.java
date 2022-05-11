package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSgAttachmentConverter;
import gov.ifms.pvu.dto.PVUSgAttachmentDto;
import gov.ifms.pvu.entity.PVUSgAttachmentEntity;
import gov.ifms.pvu.repository.PVUSgAttachmentRepository;


/**
 * The Class PVUSgAttachmentController.
 *
 * @version v 1.0
 * @created 2019/12/19 18:51:39
 */
@Service
public class PVUSgAttachmentService extends BasePVUAttachmentService<PVUSgAttachmentEntity, PVUSgAttachmentDto>  {

	/** The PVUSgAttachmentAsMethodName repository. */
	@Autowired
	private PVUSgAttachmentRepository repository;

	/** The PVUSgAttachmentAsMethodName helper. */
	@Autowired
	private PVUSgAttachmentConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUSgAttachmentEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUSgAttachmentEntity, PVUSgAttachmentDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUSgAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllBySgEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}




}
