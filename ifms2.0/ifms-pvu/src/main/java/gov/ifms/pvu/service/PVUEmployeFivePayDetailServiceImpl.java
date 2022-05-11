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
import gov.ifms.pvu.converter.PVUEmployeFivePayDetailConverter;
import gov.ifms.pvu.dto.PVUEmployeFivePayDetailDto;
import gov.ifms.pvu.entity.PVUEmployeFivePayDetailEntity;
import gov.ifms.pvu.repository.PVUEmployeFivePayDetailRepository;


/**
 * The Class PVUEmployeFivePayDetailServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/12/10 18:06:31
 */
@Service
public class PVUEmployeFivePayDetailServiceImpl implements PVUEmployeFivePayDetailService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeFivePayDetailRepository repository. */
	@Autowired
	private PVUEmployeFivePayDetailRepository repository;

	/** The PVUEmployeFivePayDetailConverter converter. */
	@Autowired
	private PVUEmployeFivePayDetailConverter converter;

	/**
	 * Retrieves an PVUEmployeFivePayDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeFivePayDetailEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeFivePayDetailEntity getPVUEmployeFivePayDetailEntity(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeFivePayDetailEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeFivePayDetailEntity
	 */
	@Override
	public PVUEmployeFivePayDetailEntity saveOrUpdatePVUEmployeFivePayDetailEntity(
			PVUEmployeFivePayDetailEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUEmployeFivePayDetailEntity with the given id.
	 *
	 * @param pageDetail the page detail
	 * @return the PVU employe five pay detail entitys
	 * @throws CustomException the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	/**
	 * Fetch all the PVUEmployeFivePayDetailEntity items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeFivePayDetailEntityDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeFivePayDetailDto> getPVUEmployeFivePayDetailEntitys(PageDetails pageDetail)
			throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeFivePayDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeFivePayDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeFivePayDetailEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
