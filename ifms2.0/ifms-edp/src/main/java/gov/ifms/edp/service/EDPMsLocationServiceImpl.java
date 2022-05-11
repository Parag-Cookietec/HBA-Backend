package gov.ifms.edp.service;

import java.util.Collections;
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
import gov.ifms.edp.converter.EDPMsLocationConverter;
import gov.ifms.edp.dto.EDPMsLocationDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsLocationEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsLocationRepository;

/**
 * The Class EDPMsLocationServiceImpl.
 */
@Service
public class EDPMsLocationServiceImpl implements EDPMsLocationService {

	/** The EDPMsLocationAsMethodName repository. */
	@Autowired
	private EDPMsLocationRepository repository;

	/** The EDPMsLocationAsMethodName helper. */
	@Autowired
	private EDPMsLocationConverter converter;

	/** The edp lu look up info repository. */
	@Autowired
	EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	/**
	 * Returns all instances of the EDPMsLocationEntity type.
	 * 
	 * @return all EDPMsLocationEntity
	 */
	@Override
	public List<EDPMsLocationEntity> getMsLocations() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsLocationEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsLocationEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsLocationEntity getMsLocation(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsLocationEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsLocationEntity
	 */
	@Override
	public EDPMsLocationEntity saveOrUpdateMsLocation(EDPMsLocationEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsLocationEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsLocation(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsLocationEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsLocationEntity> saveMsLocations(List<EDPMsLocationEntity> entities) {
		return (List<EDPMsLocationEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsLocation items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsLocationDto>
	 */

	@Override
	public PagebleDTO<EDPMsLocationDto> edpMsLocationAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsLocationEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsLocationEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
		Page<EDPMsLocationEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(), converter.toDTO(page.getContent()));
	}

	/**
	 * Find district.
	 *
	 * @return the list
	 */
	@Override
	public List<EDPMsLocationEntity> findDistrict() {
		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_DISTRICT);
		if (edpLuLookUpInfoEntity != null) {
			return repository.findByLocationTypeIdLookUpInfoIdAndActiveStatusAndLocationCodeNotInOrderByLocationNameAsc(
					edpLuLookUpInfoEntity.getLookUpInfoId(), Constant.ACTIVE_STATUS, Constant.DEFAULT_LOCATION_CODE);
		}
		return Collections.emptyList();
	}

	/**
	 * This method is used to find all Taluka by lookup info id.
	 *
	 * @return List of List<EDPMsLocationEntity>
	 */
	@Override
	public List<EDPMsLocationEntity> findTaluka() {

		EDPLuLookUpInfoEntity edpLuLookUpInfoEntity = edpLuLookUpInfoRepository.findByLookUpInfoName(Constant.LOOKUP_NAME_TALUKA);
		if (edpLuLookUpInfoEntity != null) {
			return repository.findByLocationTypeIdLookUpInfoIdAndActiveStatusOrderByLocationNameAsc(edpLuLookUpInfoEntity.getLookUpInfoId(),
					Constant.ACTIVE_STATUS);
		}
		return Collections.emptyList();
	}

}
