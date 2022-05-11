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
import gov.ifms.edp.converter.EDPMsColumnsConverter;
import gov.ifms.edp.dto.EDPMsColumnsDto;
import gov.ifms.edp.entity.EDPMsColumnsEntity;
import gov.ifms.edp.repository.EDPMsColumnsRepository;

/**
 * The Class EDPMsColumnsServiceImpl.
 */
@Service
public class EDPMsColumnsServiceImpl implements EDPMsColumnsService {

	/** The EDPMsColumnsAsMethodName repository. */
	@Autowired
	private EDPMsColumnsRepository repository;

	/** The EDPMsColumnsAsMethodName helper. */
	@Autowired
	private EDPMsColumnsConverter converter;

	/**
	 * Returns all instances of the EDPMsColumnsEntity type.
	 * 
	 * @return all EDPMsColumnsEntity
	 */
	@Override
	public List<EDPMsColumnsEntity> getMsColumnss() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsColumnsEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsColumnsEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsColumnsEntity getMsColumns(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsColumnsEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsColumnsEntity
	 */
	@Override
	public EDPMsColumnsEntity saveOrUpdateMsColumns(EDPMsColumnsEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsColumnsEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsColumns(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsColumnsEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsColumnsEntity> saveMsColumnss(List<EDPMsColumnsEntity> entities) {
		return (List<EDPMsColumnsEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsColumns items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsColumnsDto>
	 */

	@Override
	public PagebleDTO<EDPMsColumnsDto> edpMsColumnsAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsColumnsEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsColumnsEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsColumnsEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

}
