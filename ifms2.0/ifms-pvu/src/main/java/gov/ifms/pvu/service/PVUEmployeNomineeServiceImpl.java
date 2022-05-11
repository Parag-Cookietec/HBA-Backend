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
import gov.ifms.pvu.converter.PVUEmployeNomineeConverter;
import gov.ifms.pvu.dto.PVUEmployeNomineeDto;
import gov.ifms.pvu.entity.PVUEmployeNomineeEntity;
import gov.ifms.pvu.repository.PVUEmployeNomineeRepository;


/**
 * The Class PVUEmployeNomineeServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 */
@Service
public class PVUEmployeNomineeServiceImpl implements PVUEmployeNomineeService  {
	
	/** The logger. */
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeNomineeAsMethodName repository. */
	@Autowired
	private PVUEmployeNomineeRepository repository;
	
	/** The PVUEmployeNomineeAsMethodName helper. */
	@Autowired
	private PVUEmployeNomineeConverter converter;

	/**
	 * Retrieves an PVUEmployeNomineeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeNomineeEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeNomineeEntity getEmployeNominee(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeNomineeEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeNomineeEntity
	 */
	@Override
	public PVUEmployeNomineeEntity saveOrUpdateEmployeNominee(PVUEmployeNomineeEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeNominee items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeNomineeDto>
	 */
	@Override
	public PagebleDTO<PVUEmployeNomineeDto> getEmployeNominees(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUEmployeNomineeEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUEmployeNomineeEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUEmployeNomineeEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    logger.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
}