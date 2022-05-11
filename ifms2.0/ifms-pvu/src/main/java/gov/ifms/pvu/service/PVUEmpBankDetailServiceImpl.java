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
import gov.ifms.pvu.converter.PVUEmpBankDetailConverter;
import gov.ifms.pvu.dto.PVUEmpBankDetailDto;
import gov.ifms.pvu.entity.PVUEmpBankDetailEntity;
import gov.ifms.pvu.repository.PVUEmpBankDetailRepository;

/**
 * The Class PVUEmpBankDetailController.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:22:19
 */
@Service
public class PVUEmpBankDetailServiceImpl implements PVUEmpBankDetailService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVUEmpBankDetailAsMethodName repository. */
	@Autowired
	private PVUEmpBankDetailRepository repository;

	/** The PVUEmpBankDetailAsMethodName helper. */
	@Autowired
	private PVUEmpBankDetailConverter converter;

	/**
	 * Retrieves an PVUEmpBankDetailEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmpBankDetailEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmpBankDetailEntity getEmpBankDetail(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmpBankDetailEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmpBankDetailEntity
	 */
	@Override
	public PVUEmpBankDetailEntity saveOrUpdateEmpBankDetail(PVUEmpBankDetailEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmpBankDetail items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmpBankDetailDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmpBankDetailDto> getEmpBankDetails(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmpBankDetailEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<PVUEmpBankDetailEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<PVUEmpBankDetailEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
