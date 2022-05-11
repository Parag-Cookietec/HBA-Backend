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
import gov.ifms.edp.converter.EDPLkPostOfficeDesignationLocationConverter;
import gov.ifms.edp.dto.EDPLkPostOfficeDesignationLocationDto;
import gov.ifms.edp.entity.EDPLkPostOfficeDesignationLocationEntity;
import gov.ifms.edp.repository.EDPLkPostOfficeDesignationLocationRepository;

/**
 * The Class EDPLkPostOfficeDesignationLocationServiceImpl.
 */
@Service
public class EDPLkPostOfficeDesignationLocationServiceImpl implements EDPLkPostOfficeDesignationLocationService  {
	
	/** The EDPLkPostOfficeDesignationLocationAsMethodName repository. */
	@Autowired
	private EDPLkPostOfficeDesignationLocationRepository repository;
	
	/** The EDPLkPostOfficeDesignationLocationAsMethodName helper. */
	@Autowired
	private EDPLkPostOfficeDesignationLocationConverter converter;

	/**
	 * Returns all instances of the EDPLkPostOfficeDesignationLocationEntity type.
	 * 
	 * @return all EDPLkPostOfficeDesignationLocationEntity
	 */
	@Override
	public List<EDPLkPostOfficeDesignationLocationEntity> getLkPostOfficeDesignationLocations(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an EDPLkPostOfficeDesignationLocationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLkPostOfficeDesignationLocationEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPLkPostOfficeDesignationLocationEntity getLkPostOfficeDesignationLocation(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLkPostOfficeDesignationLocationEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPLkPostOfficeDesignationLocationEntity
	 */
	@Override
	public EDPLkPostOfficeDesignationLocationEntity saveOrUpdateLkPostOfficeDesignationLocation(EDPLkPostOfficeDesignationLocationEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPLkPostOfficeDesignationLocationEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteLkPostOfficeDesignationLocation(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPLkPostOfficeDesignationLocationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPLkPostOfficeDesignationLocationEntity> saveLkPostOfficeDesignationLocations(List<EDPLkPostOfficeDesignationLocationEntity> entities) {
		return (List<EDPLkPostOfficeDesignationLocationEntity>) repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPLkPostOfficeDesignationLocation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLkPostOfficeDesignationLocationDto>
	 */
	
	@Override
	public PagebleDTO<EDPLkPostOfficeDesignationLocationDto> edpLkPostOfficeDesignationLocationAsMethodNameSearch(PageDetails pageDetail)	{
		SpecificationImpl<EDPLkPostOfficeDesignationLocationEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPLkPostOfficeDesignationLocationEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPLkPostOfficeDesignationLocationEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}
	
	
}
