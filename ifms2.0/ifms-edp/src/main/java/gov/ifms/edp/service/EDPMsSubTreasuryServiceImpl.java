package gov.ifms.edp.service;

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
import gov.ifms.edp.converter.EDPMsSubTreasuryConverter;
import gov.ifms.edp.dto.EDPMsSubTreasuryDto;
import gov.ifms.edp.entity.EDPMsSubTreasuryEntity;
import gov.ifms.edp.repository.EDPMsSubTreasuryRepository;

/**
 * The Class EDPMsSubTreasuryController.
 * 
 * @version 1.0
 * @created 2020/01/20 10:59:54
 */
@Service
public class EDPMsSubTreasuryServiceImpl implements EDPMsSubTreasuryService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsSubTreasuryAsMethodName repository. */
	@Autowired
	private EDPMsSubTreasuryRepository repository;

	/** The EDPMsSubTreasuryAsMethodName helper. */
	@Autowired
	private EDPMsSubTreasuryConverter converter;

	/**
	 * Retrieves an EDPMsSubTreasuryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsSubTreasuryEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsSubTreasuryEntity getMsSubTreasury(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsSubTreasuryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsSubTreasuryEntity
	 */
	@Override
	public EDPMsSubTreasuryEntity saveOrUpdateMsSubTreasury(EDPMsSubTreasuryEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPMsSubTreasuryEntity with the given id.
	 *
	 * @param id       must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsSubTreasury(long id, int isDelete) {
		// Inactive sub treasury
	}

	/**
	 * Fetch all the EDPMsSubTreasury items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsSubTreasuryDto> getMsSubTreasurys(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsSubTreasuryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsSubTreasuryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsSubTreasuryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
