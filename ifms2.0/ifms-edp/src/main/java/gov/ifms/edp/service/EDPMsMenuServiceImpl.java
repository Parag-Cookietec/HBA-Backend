package gov.ifms.edp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPMsMenuConverter;
import gov.ifms.edp.dto.EDPMsMenuDto;
import gov.ifms.edp.dto.EDPMsRolePermissionsDto;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.repository.EDPMsMenuRepository;
import gov.ifms.edp.util.EDPNativeSQLUtil;

/**
 * The Class EDPMsMenuServiceImpl.
 */
@Service
public class EDPMsMenuServiceImpl implements EDPMsMenuService {

	/** The EDPMsMenuAsMethodName repository. */
	@Autowired
	private EDPMsMenuRepository repository;

	/** The EDPMsMenuAsMethodName helper. */
	@Autowired
	private EDPMsMenuConverter converter;

	/**
	 * Returns all instances of the EDPMsMenuEntity type.
	 * 
	 * @return all EDPMsMenuEntity
	 */
	@Override
	public List<EDPMsMenuEntity> getMsMenus() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsMenuEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsMenuEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsMenuEntity getMsMenu(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsMenuEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsMenuEntity
	 */
	@Override
	public EDPMsMenuEntity saveOrUpdateMsMenu(EDPMsMenuEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsMenuEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsMenu(Long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsMenuEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsMenuEntity> saveMsMenus(List<EDPMsMenuEntity> entities) {
		return (List<EDPMsMenuEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsMenu items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsMenuDto>
	 */

	@Override
	public PagebleDTO<EDPMsMenuDto> edpMsMenuAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsMenuEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsMenuEntity> empSpec = searchCriteria.getSpecificationDetails(spec, pageDetail.getJsonArr());
		Page<EDPMsMenuEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the ms menu by sub module id.
	 *
	 * @param subModuleId the sub module id
	 * @return the ms menu by sub module id
	 */
	@Override
	public List<EDPMsMenuEntity> getMsMenuBySubModuleId(Long subModuleId) {
		return repository.findByActiveStatusAndSubModuleIdSubModuleId(Constant.ACTIVE_STATUS,subModuleId);
	}

	/**
	 * Gets the permission by menu and post id.
	 *
	 * @param postId the post id
	 * @return the permission by menu and post id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<EDPMsRolePermissionsDto> getPermissionByMenuAndPostId(Long postId) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("postId", postId);
		
			List<Object[]> result = repository.executeSQLQuery(EDPNativeSQLUtil.getPerissionsByMenuAndPostId(), map);
				return NativeQueryResultsMapper.map(result, EDPMsRolePermissionsDto.class);
	}

	/**
	 * Gets the ms menu by module id.
	 *
	 * @param moduleId the module id
	 * @return the ms menu by module id
	 */
	@Override
	public List<EDPMsMenuEntity> getMsMenuByModuleId(Long moduleId) {
		return repository.findByModuleIdModuleIDAndActiveStatus(moduleId , Constant.ACTIVE_STATUS);
	}

}
