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
import gov.ifms.edp.converter.EDPLuLookUpConverter;
import gov.ifms.edp.dto.EDPLuLookUpDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.repository.EDPLuLookUpRepository;

/**
 * The Class EDPLuLookUpServiceImpl.
 */
@Service
public class EDPLuLookUpServiceImpl implements EDPLuLookUpService  {
	
	/** The EDPLuLookUpAsMethodName repository. */
	@Autowired
	private EDPLuLookUpRepository repository;
	
	/** The EDPLuLookUpAsMethodName helper. */
	@Autowired
	private EDPLuLookUpConverter converter;

	/**
	 * Returns all instances of the EDPLuLookUpEntity type.
	 * 
	 * @return all EDPLuLookUpEntity
	 */
	@Override
	public List<EDPLuLookUpEntity> getLuLookUps(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an EDPLuLookUpEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLuLookUpEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPLuLookUpEntity getLuLookUp(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLuLookUpEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPLuLookUpEntity
	 */
	@Override
	public EDPLuLookUpEntity saveOrUpdateLuLookUp(EDPLuLookUpEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPLuLookUpEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteLuLookUp(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPLuLookUpEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPLuLookUpEntity> saveLuLookUps(List<EDPLuLookUpEntity> entities) {
		return (List<EDPLuLookUpEntity>) repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPLuLookUp items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpDto>
	 */
	
	@Override
	public PagebleDTO<EDPLuLookUpDto> edpLuLookUpAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPLuLookUpEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPLuLookUpEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPLuLookUpEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}
	
	
}
