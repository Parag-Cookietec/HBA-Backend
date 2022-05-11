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
import gov.ifms.pvu.converter.PVUEmployeFourthPayDetailConverter;
import gov.ifms.pvu.dto.PVUEmployeFourthPayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeFourthPayDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeFourthPayDetailRepository;

/**
 * The Class PVUEmployeFourthPayDetailServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:00:08
 */
@Service
public class PVUEmployeFourthPayDetailServiceImpl implements PVUEmployeFourthPayDetailService {

	/** The logger. */
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeFourthPayDetailRepository repository. */
	@Autowired
	private PVUEmployeFourthPayDetailRepository repository;

	/** The PVUEmployeFourthPayDetailConverter converter. */
	@Autowired
	private PVUEmployeFourthPayDetailConverter converter;

	/**
	 * Retrieves an PVUEmployeFourthPayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFourthPayDetailEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeFourthPayDetailEntity getPVUEmployeFourthPayDetailEntity(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeFourthPayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFourthPayDetailEntity
	 */
	@Override
	public PVUEmployeFourthPayDetailEntity saveOrUpdatePVUEmployeFourthPayDetailEntity(
			PVUEmployeFourthPayDetailEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUEmployeFourthPayDetailEntity with the given id.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU employe fourth pay detail entitys
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	/**
	 * Fetch all the PVUEmployeFourthPayDetailEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeFourthPayDetailEntityDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeFourthPayDetailDto> getPVUEmployeFourthPayDetailEntitys(PageDetails pageDetail)
			throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeFourthPayDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeFourthPayDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeFourthPayDetailEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			LOGGER.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
