package gov.ifms.pvu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUMsReasonConverter;
import gov.ifms.pvu.dto.PVUMsReasonDto;
import gov.ifms.pvu.entity.PVUMsReasonEntity;
import gov.ifms.pvu.repository.PVUMsReasonRepository;

/**
 * The Class PVUMsReasonController.
 * 
 * @version v 1.0
 * @created 2020/04/14 02:50:39
 */
@Service
public class PVUMsReasonServiceImpl implements PVUMsReasonService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUMsReasonAsMethodName repository. */
	@Autowired
	private PVUMsReasonRepository repository;

	/** The PVUMsReasonAsMethodName helper. */
	@Autowired
	private PVUMsReasonConverter converter;

	/**
	 * Retrieves an PVUMsReasonEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsReasonEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsReasonEntity getMsReason(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsReasonEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsReasonEntity
	 */
	@Override
	public PVUMsReasonEntity saveOrUpdateMsReason(PVUMsReasonEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUMsReason items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsReasonDto>
	 */
	@Override
	public PagebleDTO<PVUMsReasonDto> getMsReasons(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsReasonEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUMsReasonEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUMsReasonEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<PVUMsReasonDto> getRopReasons() {
		List<PVUMsReasonEntity> lstRopReason = repository.findByReasonTypeAndActiveStatus(Constant.ROP_REASON_TYPE, Constant.ACTIVE_STATUS);
		return converter.toDTO(lstRopReason);
	}

	@Override
	public List<PVUMsReasonDto> getEventsReasons() {
		List<PVUMsReasonEntity> lstRopReason = repository.findByReasonTypeAndActiveStatus(Constant.EVENT_REASON_TYPE, Constant.ACTIVE_STATUS);
		return converter.toDTO(lstRopReason);
	}

}
