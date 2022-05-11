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
import gov.ifms.edp.converter.EDPLkPuoMenuRLWFConverter;
import gov.ifms.edp.dto.EDPLkPuoMenuRLWFDto;
import gov.ifms.edp.entity.EDPTrnUsrMnuWfRole;
import gov.ifms.edp.repository.EDPLkPuoMenuRLWFRepository;

/**
 * The Class EDPLkPuoMenuRLWFServiceImpl.
 */
@Service
public class EDPLkPuoMenuRLWFServiceImpl implements EDPLkPuoMenuRLWFService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPLkPuoMenuRLWFAsMethodName repository. */
	@Autowired
	private EDPLkPuoMenuRLWFRepository repository;

	/** The EDPLkPuoMenuRLWFAsMethodName helper. */
	@Autowired
	private EDPLkPuoMenuRLWFConverter converter;

	/**
	 * Retrieves an EDPLkPuoMenuRLWFEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPuoMenuRLWFEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPTrnUsrMnuWfRole getLkPuoMenuRLWF(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLkPuoMenuRLWFEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkPuoMenuRLWFEntity
	 */
	@Override
	public EDPTrnUsrMnuWfRole saveOrUpdateLkPuoMenuRLWF(EDPTrnUsrMnuWfRole entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPLkPuoMenuRLWFEntity with the given id.
	 *
	 * @param id       must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteLkPuoMenuRLWF(long id, int isDelete) {
		// Delete Code
	}

	/**
	 * Fetch all the EDPLkPuoMenuRLWF items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPuoMenuRLWFDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPLkPuoMenuRLWFDto> getLkPuoMenuRLWFs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPTrnUsrMnuWfRole> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPTrnUsrMnuWfRole> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPTrnUsrMnuWfRole> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
