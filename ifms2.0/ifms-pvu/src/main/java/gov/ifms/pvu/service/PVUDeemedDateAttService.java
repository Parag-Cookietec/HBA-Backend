package gov.ifms.pvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUDeemedDateAttConverter;
import gov.ifms.pvu.dto.PVUDeemedDateAttDto;
import gov.ifms.pvu.entity.PVUDeemedDateAttEntity;
import gov.ifms.pvu.repository.PVUDeemedDateAttRepository;

/**
 * The Class PVUDeemedDateAttController.
 * 
 * @version v 1.0
 * @created 2020/03/21 11:30:34
 *
 */
@Service
public class PVUDeemedDateAttService extends BasePVUAttachmentService<PVUDeemedDateAttEntity, PVUDeemedDateAttDto> {
	@Autowired
	private PVUDeemedDateAttRepository repository;

	@Autowired
	private PVUDeemedDateAttConverter converter;

	@Override
	public BasePVUAttachmentRepository<PVUDeemedDateAttEntity> getRepository() {
		return repository;
	}

	@Override
	public BasePVUAttachmentConverter<PVUDeemedDateAttEntity, PVUDeemedDateAttDto> getConverter() {
		return converter;
	}

	@Override
	public List<PVUDeemedDateAttEntity> getAttachmentByReferenceId(IdDto dto) {
		return this.repository.findAllByEntityIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

	@Override
	public void updateStatusAsDelete(IdDto dto) {
		this.repository.updateStatusAsDelete(dto.getId(), Constant.IN_ACTIVE_STATUS);
	}
}
