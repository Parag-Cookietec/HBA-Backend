package gov.ifms.pvu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import gov.ifms.pvu.converter.PVUSuspensionPayDetailsConverter;
import gov.ifms.pvu.dto.PVUSuspensionPayDetailsDto;
import gov.ifms.pvu.entity.PVUSuspensionPayDetailsEntity;
import gov.ifms.pvu.repository.PVUSuspensionPayDetailsRepository;

/**
 * The Class PVUSuspensionPayDetailsController.
 *
 * @version v 1.0
 * @created 2019/12/19 12:16:05
 */
@Service
public class PVUSuspensionPayDetailsServiceImpl implements PVUSuspensionPayDetailsService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(PVUSuspensionPayDetailsServiceImpl.class.getName());

	/**
	 * The PVUSuspensionPayDetailsRepository repository.
	 */
	@Autowired
	private PVUSuspensionPayDetailsRepository repository;

	/**
	 * The PVUSuspensionPayDetailsConverter converter.
	 */
	@Autowired
	private PVUSuspensionPayDetailsConverter converter;

	/**
	 * Retrieves an PVUSuspensionPayDetailsEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUSuspensionPayDetailsEntity with the given id or
	 *         {@literal null} if none found
	 * @throws CustomException
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUSuspensionPayDetailsEntity getSuspensionPayDetails(Long id) throws CustomException {
		try {
			return repository.getOne(id);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Saves a given PVUSuspensionPayDetailsEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUSuspensionPayDetailsEntity
	 * @throws CustomException
	 */
	@Override
	public PVUSuspensionPayDetailsEntity saveOrUpdateSuspensionPayDetails(PVUSuspensionPayDetailsEntity entity)
			throws CustomException {
		try {
			return repository.save(entity);
		} catch (DataIntegrityViolationException e) {
			throw new CustomException(ErrorResponse.REFERENCE_NOT_EXISTS);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Fetch all the PVUSuspensionPayDetails items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUSuspensionPayDetailsDto>
	 */
	@Override
	public PagebleDTO<PVUSuspensionPayDetailsDto> getSuspensionPayDetailss(PageDetails pageDetail)
			throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUSuspensionPayDetailsEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUSuspensionPayDetailsEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUSuspensionPayDetailsEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
