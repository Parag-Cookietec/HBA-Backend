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
import gov.ifms.pvu.converter.PVUEmployeeJoiningPayConverter;
import gov.ifms.pvu.dto.PVUEmployeeJoiningPayDto;
import gov.ifms.pvu.entity.PVUEmployeeJoiningPayEntity;
import gov.ifms.pvu.repository.PVUEmployeeJoiningPayRepository;

/**
 * The Class PVUEmployeeJoiningPayController.
 * 
 * @version v 1.0
 * @created 2020/05/15 11:25:19
 */
@Service
public class PVUEmployeeJoiningPayServiceImpl implements PVUEmployeeJoiningPayService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmployeeJoiningPayAsMethodName repository. */
	@Autowired
	private PVUEmployeeJoiningPayRepository repository;

	/** The PVUEmployeeJoiningPayAsMethodName helper. */
	@Autowired
	private PVUEmployeeJoiningPayConverter converter;

	/**
	 * Retrieves an PVUEmployeeJoiningPayEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeeJoiningPayEntity with the given id or {@literal null}
	 *         if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeeJoiningPayEntity getEmployeeJoiningPay(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeeJoiningPayEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeeJoiningPayEntity
	 */
	@Override
	public PVUEmployeeJoiningPayEntity saveOrUpdateEmployeeJoiningPay(PVUEmployeeJoiningPayEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeeJoiningPay items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeeJoiningPayDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeeJoiningPayDto> getEmployeeJoiningPays(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeeJoiningPayEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmployeeJoiningPayEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmployeeJoiningPayEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
