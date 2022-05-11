package gov.ifms.pvu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVURopAttachmentConverter;
import gov.ifms.pvu.dto.PVURopAttachmentDto;
import gov.ifms.pvu.entity.PVURopAttachmentEntity;
import gov.ifms.pvu.repository.PVURopAttachmentRepository;


/**
 * The Class PVURopAttachmentController.
 * 
 * @version v 1.0
 * @created 2020/03/17 11:14:39
 */
@Service
public class PVURopAttachmentService extends BasePVUAttachmentService<PVURopAttachmentEntity, PVURopAttachmentDto>  {
	
	/** The PVURopAttachmentAsMethodName repository. */
	@Autowired
	private PVURopAttachmentRepository repository;
	
	/** The PVURopAttachmentAsMethodName helper. */
	@Autowired
	private PVURopAttachmentConverter converter;

	/**
	 * Gets the repository.
	 *
	 * @return the repository
	 */
	@Override
	public BasePVUAttachmentRepository<PVURopAttachmentEntity> getRepository() {
		return repository;
	}

	/**
	 * Gets the converter.
	 *
	 * @return the converter
	 */
	@Override
	public BasePVUAttachmentConverter<PVURopAttachmentEntity, PVURopAttachmentDto> getConverter() {
		return converter;
	}

	/**
	 * Gets the attachment by reference id.
	 *
	 * @param dto the dto
	 * @return the attachment by reference id
	 */
	@Override
	public List<PVURopAttachmentEntity> getAttachmentByReferenceId(IdDto dto) {
		return repository.findAllByPvuRevisionOfPayEntityIdAndActiveStatus(dto.getId(),Constant.ACTIVE_STATUS);
	}

	/**
	 * Update status as delete.
	 *
	 * @param dto the dto
	 */
	@Override
	public void updateStatusAsDelete(IdDto dto) {
		repository.deleteAttchment(dto.getId(), Constant.IN_ACTIVE_STATUS, OAuthUtility.getCurrentUserUserId(),
				new Date());
	}
	
}
