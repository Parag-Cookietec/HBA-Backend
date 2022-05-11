package gov.ifms.pvu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dto.IdDto;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.common.BasePVUAttachmentConverter;
import gov.ifms.pvu.common.BasePVUAttachmentRepository;
import gov.ifms.pvu.common.BasePVUAttachmentService;
import gov.ifms.pvu.converter.PVUSteppingUpAttConverter;
import gov.ifms.pvu.dto.PVUSteppingUpAttDto;
import gov.ifms.pvu.entity.PVUSteppingUpAttEntity;
import gov.ifms.pvu.repository.PVUSteppingUpAttRepository;

@Service
public class PVUSteppingUpAttService extends BasePVUAttachmentService<PVUSteppingUpAttEntity, PVUSteppingUpAttDto> {

	/** The repository. */
    @Autowired
    private PVUSteppingUpAttRepository repository;

    /** The converter. */
    @Autowired
    private PVUSteppingUpAttConverter converter;

	/**
	 * update Status As Delete
	 *
	 * @param IdDto dto
	 * @return 
	 */
    @Override
    public void updateStatusAsDelete(IdDto dto) {
        this.repository.updateStatusAsDelete(dto.getId(),Constant.IN_ACTIVE_STATUS);
    }

    /** The repository. */
	@Override
	public BasePVUAttachmentRepository<PVUSteppingUpAttEntity> getRepository() {
		return repository;
	}

	/** get converter. */
	@Override
	public BasePVUAttachmentConverter<PVUSteppingUpAttEntity, PVUSteppingUpAttDto> getConverter() {
		return converter;
	}
	
	/**
	 * get Attachment by Id.
	 *
	 * @param IdDto dto
	 * @return List<PVUSteppingUpAttEntity>
	 */
	@Override
	public List<PVUSteppingUpAttEntity> getAttachmentByReferenceId(IdDto dto) {
		return this.repository.findAllByEntityStEventIdAndActiveStatus(dto.getId(), Constant.ACTIVE_STATUS);
	}

}
