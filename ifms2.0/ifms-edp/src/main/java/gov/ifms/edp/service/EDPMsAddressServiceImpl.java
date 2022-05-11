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
import gov.ifms.edp.converter.EDPMsAddressConverter;
import gov.ifms.edp.dto.EDPMsAddressDto;
import gov.ifms.edp.entity.EDPMsAddressEntity;
import gov.ifms.edp.repository.EDPMsAddressRepository;

/**
 * The Class EDPMsAddressServiceImpl.
 */
@Service
public class EDPMsAddressServiceImpl implements EDPMsAddressService {

	/** The EDPMsAddressAsMethodName repository. */
	@Autowired
	private EDPMsAddressRepository repository;

	/** The EDPMsAddressAsMethodName helper. */
	@Autowired
	private EDPMsAddressConverter converter;

	/**
	 * Returns all instances of the EDPMsAddressEntity type.
	 * 
	 * @return all EDPMsAddressEntity
	 */
	@Override
	public List<EDPMsAddressEntity> getMsAddresss() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsAddressEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsAddressEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsAddressEntity getMsAddress(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsAddressEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsAddressEntity
	 */
	@Override
	public EDPMsAddressEntity saveOrUpdateMsAddress(EDPMsAddressEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsAddressEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsAddress(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsAddressEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsAddressEntity> saveMsAddresss(List<EDPMsAddressEntity> entities) {
		return (List<EDPMsAddressEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsAddress items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsAddressDto>
	 */

	@Override
	public PagebleDTO<EDPMsAddressDto> edpMsAddressAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsAddressEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsAddressEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsAddressEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

}
