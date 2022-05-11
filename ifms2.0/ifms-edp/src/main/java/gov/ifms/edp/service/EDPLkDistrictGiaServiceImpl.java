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
import gov.ifms.edp.converter.EDPLkDistrictGiaConverter;
import gov.ifms.edp.dto.EDPLkDistrictGiaDto;
import gov.ifms.edp.entity.EDPLkDistrictGiaEntity;
import gov.ifms.edp.repository.EDPLkDistrictGiaRepository;


/**
 * The Class EDPLkDistrictGiaController.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 */
@Service
public class EDPLkDistrictGiaServiceImpl implements EDPLkDistrictGiaService  {
	
	/** The logger. */
	private Logger  logger =LoggerFactory.getLogger(this.getClass().getName());
	
	/** The EDPLkDistrictGiaAsMethodName repository. */
	@Autowired
	private EDPLkDistrictGiaRepository repository;
	
	/** The EDPLkDistrictGiaAsMethodName helper. */
	@Autowired
	private EDPLkDistrictGiaConverter converter;

	/**
	 * Retrieves an EDPLkDistrictGiaEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkDistrictGiaEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPLkDistrictGiaEntity getLkDistrictGia(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLkDistrictGiaEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPLkDistrictGiaEntity
	 */
	@Override
	public EDPLkDistrictGiaEntity saveOrUpdateLkDistrictGia(EDPLkDistrictGiaEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the EDPLkDistrictGia items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkDistrictGiaDto>
	 */
	@Override
	public PagebleDTO<EDPLkDistrictGiaDto> getLkDistrictGias(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPLkDistrictGiaEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<EDPLkDistrictGiaEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<EDPLkDistrictGiaEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	

		
		
		

		
	
}
