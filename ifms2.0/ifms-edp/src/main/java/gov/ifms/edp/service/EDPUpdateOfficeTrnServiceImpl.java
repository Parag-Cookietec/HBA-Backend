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
import gov.ifms.edp.converter.EDPUpdateOfficeTrnConverter;
import gov.ifms.edp.dto.EDPUpdateOfficeTrnDto;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.repository.EDPUpdateOfficeTrnRepository;

/**
 * The Class UpdateOfficeTrnController.
 * 
 * @version 1.0
 * @created 2020/09/21 16:41:54
 */
@Service
public class EDPUpdateOfficeTrnServiceImpl implements EDPUpdateOfficeTrnService {

	/** The UpdateOfficeTrnAsMethodName repository. */
	@Autowired
	private EDPUpdateOfficeTrnRepository repository;

	/** The UpdateOfficeTrnAsMethodName helper. */
	@Autowired
	private EDPUpdateOfficeTrnConverter converter;

	/**
	 * Returns all instances of the UpdateOfficeTrnEntity type.
	 * 
	 * @return all UpdateOfficeTrnEntity
	 */
	@Override
	public List<EDPUpdateOfficeTrnEntity> getUpdateOfficeTrns() {
		return repository.findAll();
	}

	/**
	 * Retrieves an UpdateOfficeTrnEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the UpdateOfficeTrnEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPUpdateOfficeTrnEntity getUpdateOfficeTrn(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given UpdateOfficeTrnEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved UpdateOfficeTrnEntity
	 */
	@Override
	public EDPUpdateOfficeTrnEntity saveOrUpdateUpdateOfficeTrn(EDPUpdateOfficeTrnEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the UpdateOfficeTrnEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteUpdateOfficeTrn(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given UpdateOfficeTrnEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPUpdateOfficeTrnEntity> saveUpdateOfficeTrns(List<EDPUpdateOfficeTrnEntity> entities) {
		return (List<EDPUpdateOfficeTrnEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the UpdateOfficeTrn items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<UpdateOfficeTrnDto>
	 */

	@Override
	public PagebleDTO<EDPUpdateOfficeTrnDto> updateOfficeTrnAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPUpdateOfficeTrnEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPUpdateOfficeTrnEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPUpdateOfficeTrnEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

}
