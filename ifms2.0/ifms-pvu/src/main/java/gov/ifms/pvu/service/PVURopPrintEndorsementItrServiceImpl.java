package gov.ifms.pvu.service;

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
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVURopPrintEndorsementItrConverter;
import gov.ifms.pvu.dto.PVURopPrintEndorsementItrDto;
import gov.ifms.pvu.entity.PVURopPrintEndorsementItrEntity;
import gov.ifms.pvu.repository.PVURopPrintEndorsementItrRepository;

/**
 * The Class PVURopPrintEndorsementItrController.
 * 
 * @version v 1.0
 * @created 2020/04/15 17:57:19
 */
@Service
public class PVURopPrintEndorsementItrServiceImpl implements PVURopPrintEndorsementItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURopPrintEndorsementItrAsMethodName repository. */
	@Autowired
	private PVURopPrintEndorsementItrRepository repository;

	/** The PVURopPrintEndorsementItrAsMethodName helper. */
	@Autowired
	private PVURopPrintEndorsementItrConverter converter;

	/**
	 * Retrieves an PVURopPrintEndorsementItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopPrintEndorsementItrEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURopPrintEndorsementItrEntity getPVURopPrintEndorsementItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVURopPrintEndorsementItrEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopPrintEndorsementItrEntity
	 */
	@Override
	public PVURopPrintEndorsementItrEntity saveOrUpdatePVURopPrintEndorsementItr(
			PVURopPrintEndorsementItrEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVURopPrintEndorsementItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopPrintEndorsementItrDto>
	 */
	@Override
	public PagebleDTO<PVURopPrintEndorsementItrDto> getPVURopPrintEndorsementItrs(PageDetails pageDetail)
			throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVURopPrintEndorsementItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVURopPrintEndorsementItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVURopPrintEndorsementItrEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
