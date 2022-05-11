/*
 * 
 */
package gov.ifms.edp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.edp.converter.EDPMsActivitiesHeadConverter;
import gov.ifms.edp.dto.EDPMsActivitiesHeadDto;
import gov.ifms.edp.entity.EDPMsActivitiesHeadEntity;
import gov.ifms.edp.repository.EDPMsActivitiesHeadRepository;

/**
 * The Class EDPMsActivitiesHeadServiceImpl.
 */
@Service
public class EDPMsActivitiesHeadServiceImpl implements EDPMsActivitiesHeadService  {
		
	/** The EDPMsActivitiesHeadAsMethodName repository. */
	@Autowired
	private EDPMsActivitiesHeadRepository repository;
	
	/** The EDPMsActivitiesHeadAsMethodName helper. */
	@Autowired
	private EDPMsActivitiesHeadConverter converter;

	/**
	 * Returns all instances of the EDPMsActivitiesHeadEntity type.
	 * 
	 * @return all EDPMsActivitiesHeadEntity
	 */
	@Override
	public List<EDPMsActivitiesHeadEntity> getMsActivitiesHeads(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an EDPMsActivitiesHeadEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsActivitiesHeadEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsActivitiesHeadEntity getMsActivitiesHead(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsActivitiesHeadEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsActivitiesHeadEntity
	 */
	@Override
	public EDPMsActivitiesHeadEntity saveOrUpdateMsActivitiesHead(EDPMsActivitiesHeadEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsActivitiesHeadEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteMsActivitiesHead(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPMsActivitiesHeadEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPMsActivitiesHeadEntity> saveMsActivitiesHeads(List<EDPMsActivitiesHeadEntity> entities) {
		return (List<EDPMsActivitiesHeadEntity>) repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPMsActivitiesHead items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsActivitiesHeadDto>
	 */
	
	@Override
	public PagebleDTO<EDPMsActivitiesHeadDto> edpMsActivitiesHeadAsMethodNameSearch(PageDetails pageDetail)	{
		SpecificationImpl<EDPMsActivitiesHeadEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPMsActivitiesHeadEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPMsActivitiesHeadEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}
	
	
}
