package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUMsPayBandConverter;
import gov.ifms.pvu.dto.PVUMsPayBandDto;
import gov.ifms.pvu.entity.PVUMsPayBandEntity;
import gov.ifms.pvu.repository.PVUMsPayBandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


/**
 * The Class PvuMsPayBandServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/12/23 14:46:10
 */
@Service
public class PvuMsPayBandServiceImpl implements PvuMsPayBandService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUMsPayBandRepository repository. */
	@Autowired
	private PVUMsPayBandRepository repository;
	
	/** The PVUMsPayBandConverter converter. */
	@Autowired
	private PVUMsPayBandConverter converter;

	/**
	 * Retrieves an PVUMsPayBandEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayBandEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsPayBandEntity getPayBandById(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsPayBandEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayBandEntity
	 */
	@Override
	public PVUMsPayBandEntity saveOrUpdateMsPayBand(PVUMsPayBandEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUMS_PAY_BAND items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMS_PAY_BANDDto>
	 */
	@Override
	public PagebleDTO<PVUMsPayBandDto> getMsPayBands(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsPayBandEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUMsPayBandEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUMsPayBandEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
