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
import gov.ifms.edp.converter.EDPMsAccountHeadConverter;
import gov.ifms.edp.dto.EDPMsAccountHeadDto;
import gov.ifms.edp.entity.EDPMsAccountHeadEntity;
import gov.ifms.edp.repository.EDPMsAccountHeadRepository;

/**
 * The Class EDPMsAccountHeadServiceImpl.
 */
@Service
public class EDPMsAccountHeadServiceImpl implements EDPMsAccountHeadService  {
	
	/** The EDPMsAccountHeadAsMethodName repository. */
	@Autowired
	private EDPMsAccountHeadRepository repository;
	
	/** The EDPMsAccountHeadAsMethodName helper. */
	@Autowired
	private EDPMsAccountHeadConverter converter;

	/**
	 * Returns all instances of the EDPMsAccountHeadEntity type.
	 * 
	 * @return all EDPMsAccountHeadEntity
	 */
	@Override
	public List<EDPMsAccountHeadEntity> getMsAccountHeads(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an EDPMsAccountHeadEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsAccountHeadEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsAccountHeadEntity getMsAccountHead(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsAccountHeadEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsAccountHeadEntity
	 */
	@Override
	public EDPMsAccountHeadEntity saveOrUpdateMsAccountHead(EDPMsAccountHeadEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsAccountHeadEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteMsAccountHead(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPMsAccountHeadEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPMsAccountHeadEntity> saveMsAccountHeads(List<EDPMsAccountHeadEntity> entities) {
		return (List<EDPMsAccountHeadEntity>) repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPMsAccountHead items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAccountHeadDto>
	 */
	
	@Override
	public PagebleDTO<EDPMsAccountHeadDto> edpMsAccountHeadAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsAccountHeadEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPMsAccountHeadEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPMsAccountHeadEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}
	
	
}
