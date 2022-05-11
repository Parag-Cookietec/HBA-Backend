package gov.ifms.pvu.service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.pvu.converter.PVUMsPayCellConverter;
import gov.ifms.pvu.dto.PVUMsPayCellDto;
import gov.ifms.pvu.entity.PVUMsPayCellEntity;
import gov.ifms.pvu.repository.PVUMsPayCellRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


/**
 * The Class PVUMsPayCellServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/12/23 17:34:36
 */
@Service
public class PVUMsPayCellServiceImpl implements PVUMsPayCellService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUMsPayCellRepository repository. */
	@Autowired
	private PVUMsPayCellRepository repository;
	
	/** The PVUMsPayCellConverter converter. */
	@Autowired
	private PVUMsPayCellConverter converter;

	/**
	 * Retrieves an PVUMsPayCellEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayCellEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsPayCellEntity getMsPayCell(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsPayCellEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayCellEntity
	 */
	@Override
	public PVUMsPayCellEntity saveOrUpdateMsPayCell(PVUMsPayCellEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUMsPayCell items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsPayCellDto>
	 */
	@Override
	public PagebleDTO<PVUMsPayCellDto> getMsPayCells(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsPayCellEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUMsPayCellEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUMsPayCellEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
}
