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
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsModuleConverter;
import gov.ifms.edp.dto.EDPMsModuleDto;
import gov.ifms.edp.entity.EDPMsModuleEntity;
import gov.ifms.edp.repository.EDPMsModuleRepository;

/**
 * The Class EDPMsModuleServiceImpl.
 */
@Service
public class EDPMsModuleServiceImpl implements EDPMsModuleService  {

	/** The EDPMsModuleAsMethodName repository. */
	@Autowired
	private EDPMsModuleRepository repository;
	
	/** The EDPMsModuleAsMethodName helper. */
	@Autowired
	private EDPMsModuleConverter converter;

	/**
	 * Returns all instances of the EDPMsModuleEntity type.
	 * 
	 * @return all EDPMsModuleEntity
	 */
	@Override
	public List<EDPMsModuleEntity> getMsModules(){
		return repository.findByActiveStatus(Constant.ACTIVE_STATUS);
	}
	
	/**
	 * Retrieves an EDPMsModuleEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsModuleEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsModuleEntity getMsModule(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsModuleEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsModuleEntity
	 */
	@Override
	public EDPMsModuleEntity saveOrUpdateMsModule(EDPMsModuleEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsModuleEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteMsModule(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPMsModuleEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPMsModuleEntity> saveMsModules(List<EDPMsModuleEntity> entities) {
		return repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPMsModule items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleDto>
	 */
	
	@Override
	public PagebleDTO<EDPMsModuleDto> edpMsModuleAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsModuleEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPMsModuleEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPMsModuleEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}
	
	
}
