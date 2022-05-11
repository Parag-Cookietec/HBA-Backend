package gov.ifms.pvu.service;

import java.util.List;

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
import gov.ifms.pvu.converter.PVUMsPayScaleConverter;
import gov.ifms.pvu.dto.PVUMsPayScaleDto;
import gov.ifms.pvu.entity.PVUMsPayScaleEntity;
import gov.ifms.pvu.repository.PVUMsPayScaleRepository;


/**
 * The Class PVUMsPayScaleController.
 * 
 * @version v 1.0
 * @created 2020/01/12 16:58:17
 */
@Service
public class PVUMsPayScaleServiceImpl implements PVUMsPayScaleService  {
	
	/** The logger. */
	private Logger  LOGGER=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUMsPayScaleAsMethodName repository. */
	@Autowired
	private PVUMsPayScaleRepository repository;
	
	/** The PVUMsPayScaleAsMethodName helper. */
	@Autowired
	private PVUMsPayScaleConverter converter;

	/**
	 * Retrieves an PVUMsPayScaleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUMsPayScaleEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUMsPayScaleEntity getMsPayScale(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUMsPayScaleEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUMsPayScaleEntity
	 */
	@Override
	public PVUMsPayScaleEntity saveOrUpdateMsPayScale(PVUMsPayScaleEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the PVUMsPayScaleEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	/* // uncomment method when require  delete api
	@Override
	public void deleteMsPayScale(long id,int isDelete) {
		repository.deleteMsPayScale(id, isDelete ,
				OAuthUtility.getCurrentUserUserId(),new java.util.Date());
	}
    */
	/**
	 * Fetch all the PVUMsPayScale items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUMsPayScaleDto>
	 */
	@Override
	public PagebleDTO<PVUMsPayScaleDto> getMsPayScales(PageDetails pageDetail) throws CustomException{
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<PVUMsPayScaleEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
	        Specification<PVUMsPayScaleEntity> dataSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
	        Page<PVUMsPayScaleEntity> page = repository.findAll(dataSpec, pageable);
	        
	        return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		}
		catch (Exception ex) {
			    LOGGER.error(ex.toString());
				throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**+
	 *
	 * @return ScaleValue
	 */
	@Override
	public List<PVUMsPayScaleEntity> getScaleValue() {
		return repository.findAll();
	}




}
