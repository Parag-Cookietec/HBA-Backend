package gov.ifms.edp.service;

import java.util.List;

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
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.dto.EDPMsDistrictDto;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.repository.EDPMsDistrictRepository;

/**
 * The Class EDPMsDistrictServiceImpl.
 */
@Service
public class EDPMsDistrictServiceImpl implements EDPMsDistrictService {

	/** The EDPDistrictNameAsMethodName repository. */
	@Autowired
	private EDPMsDistrictRepository repository;

	/** The EDPDistrictNameAsMethodName helper. */
	@Autowired
	private EDPMsDistrictConverter converter;

	/**
	 * Retrieves an EDPDistrictNameEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPDistrictNameEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsDistrictEntity getDistrictName(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPDistrictNameEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPDistrictNameEntity
	 */
	@Override
	public EDPMsDistrictEntity saveOrUpdateDistrictName(EDPMsDistrictEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the EDPDistrictName items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPDistrictNameDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsDistrictDto> getDistrictNames(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsDistrictEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsDistrictEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
			Page<EDPMsDistrictEntity> page = repository.findAll(dataSpec, pageable);
			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the all district.
	 *
	 * @return the all district
	 */
	@Override
	public List<EDPMsDistrictEntity> getAllDistrict() {
		return this.repository.findByActiveStatus(Constant.ACTIVE_STATUS);
	}

}
