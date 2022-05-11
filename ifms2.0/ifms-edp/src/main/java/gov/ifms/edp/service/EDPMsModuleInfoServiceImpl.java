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
import gov.ifms.edp.converter.EDPMsModuleInfoConverter;
import gov.ifms.edp.dto.EDPMsModuleInfoDto;
import gov.ifms.edp.entity.EDPMsModuleInfoEntity;
import gov.ifms.edp.repository.EDPMsModuleInfoRepository;

/**
 * The Class EDPMsModuleInfoServiceImpl.
 */
@Service
public class EDPMsModuleInfoServiceImpl implements EDPMsModuleInfoService  {
	
	/** The EDPMsModuleInfoAsMethodName repository. */
	@Autowired
	private EDPMsModuleInfoRepository repository;
	
	/** The EDPMsModuleInfoAsMethodName helper. */
	@Autowired
	private EDPMsModuleInfoConverter converter;

	/**
	 * Returns all instances of the EDPMsModuleInfoEntity type.
	 * 
	 * @return all EDPMsModuleInfoEntity
	 */
	@Override
	public List<EDPMsModuleInfoEntity> getMsModuleInfos(){
		return repository.findAll();
	}
	
	/**
	 * Retrieves an EDPMsModuleInfoEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsModuleInfoEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsModuleInfoEntity getMsModuleInfo(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsModuleInfoEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsModuleInfoEntity
	 */
	@Override
	public EDPMsModuleInfoEntity saveOrUpdateMsModuleInfo(EDPMsModuleInfoEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsModuleInfoEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	
	@Override
	public void deleteMsModuleInfo(Long id) {
		repository.deleteById(id);

	}
    
	/**
	 * Saves all given EDPMsModuleInfoEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */
	
	@Override
	public List<EDPMsModuleInfoEntity> saveMsModuleInfos(List<EDPMsModuleInfoEntity> entities) {
		return (List<EDPMsModuleInfoEntity>) repository.saveAll(entities);
	}
 
	/**
	 * Fetch all the EDPMsModuleInfo items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsModuleInfoDto>
	 */
	
	@Override
	public PagebleDTO<EDPMsModuleInfoDto> edpMsModuleInfoAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsModuleInfoEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();
		
		pageable = pageDetail.getPageDetails(pageDetail);
        Specification<EDPMsModuleInfoEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
        Page<EDPMsModuleInfoEntity> page = repository.findAll(empSpec, pageable);
        
		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the ms module info by module id.
	 *
	 * @param moduleId the module id
	 * @return the ms module info by module id
	 */
	@Override
	public List<EDPMsModuleInfoEntity> getMsModuleInfoByModuleId(long moduleId) {
		return repository.findByParentModuleIdModuleID(moduleId);
	}
	
	
}
