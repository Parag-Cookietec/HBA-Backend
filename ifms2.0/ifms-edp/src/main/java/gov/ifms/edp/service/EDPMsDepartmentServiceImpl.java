package gov.ifms.edp.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import gov.ifms.edp.converter.EDPMsDepartmentConverter;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPDepartmentViewDto;
import gov.ifms.edp.dto.EDPMsDepartmentDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPOfficeItrRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPNativeSQLUtil;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsDepartmentServiceImpl.
 */
@Service
public class EDPMsDepartmentServiceImpl implements EDPMsDepartmentService {

	/** The EDPMsDepartmentAsMethodName repository. */
	@Autowired
	private EDPMsDepartmentRepository repository;

	/** The office repo. */
	@Autowired
	private EDPMsOfficeRepository officeRepo;

	/** The EDPMsDepartmentAsMethodName helper. */
	@Autowired
	private EDPMsDepartmentConverter converter;

	/** The office itr repository. */
	@Autowired
	private EDPOfficeItrRepository officeItrRepository;

	/** The office itr converter. */
	@Autowired
	private EDPOfficeItrConverter officeItrConverter;

	/**
	 * Returns all instances of the EDPMsDepartmentEntity type.
	 * 
	 * @return all EDPMsDepartmentEntity
	 */
	@Override
	public List<EDPMsDepartmentEntity> getMsDepartments() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPMsDepartmentEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsDepartmentEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsDepartmentEntity getMsDepartment(long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsDepartmentEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPMsDepartmentEntity
	 */
	@Override
	public EDPMsDepartmentEntity saveOrUpdateMsDepartment(EDPMsDepartmentEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPMsDepartmentEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteMsDepartment(long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPMsDepartmentEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPMsDepartmentEntity> saveMsDepartments(List<EDPMsDepartmentEntity> entities) {
		return (List<EDPMsDepartmentEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPMsDepartment items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsDepartmentDto>
	 */

	@Override
	public PagebleDTO<EDPMsDepartmentDto> edpMsDepartmentAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPMsDepartmentEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsDepartmentEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsDepartmentEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the department by postId.
	 *
	 * @param userId the user id
	 * @return the department by postId
	 * @throws CustomException
	 */
	@Override
	public List<EDPDepartmentViewDto> getDepartmentByPostId(Long postId) throws CustomException {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("postId", postId);
		return NativeQueryResultsMapper.map(
				repository.executeSQLQuery(EDPNativeSQLUtil.getDepartmentByPostId(), paramMap),
				EDPDepartmentViewDto.class);
	}

	/**
	 * Find by office type id.
	 *
	 * @param officeTypeId the office type id
	 * @return the list
	 */
	@Override
	public List<EDPMsDepartmentEntity> findByOfficeTypeId(Long officeTypeId) {
		Set<Long> lookUpInfoIds = new HashSet<>();
		lookUpInfoIds.add(officeTypeId);
		List<EDPMsOfficeEntity> lstOffice = officeRepo.findByOfficeTypeIdLookUpInfoIdIn(lookUpInfoIds);
		return lstOffice.stream().map(EDPMsOfficeEntity::getDepartmentId).collect(Collectors.toList());
	}

	/**
	 * Gets the all code and id.
	 *
	 * @return the all code and id
	 */
	@Override
	public List<ClueDto> getAllCodeAndId() {
		List<EDPMsDepartmentEntity> allActiveEntity = repository.findByActiveStatus(EDPConstant.ACTIVE_STATUS_TRUE,
				EDPUtility.getJpaSort(EDPConstant.DEPARTMENT_NAME, EDPConstant.ORDER_ASC));
		return getDepartmentIdAndCodeInClueDto(allActiveEntity);
	}

	/**
	 * Gets the department id and code in clue dto.
	 *
	 * @param listEntity the list entity
	 * @return the department id and code in clue dto
	 */
	private List<ClueDto> getDepartmentIdAndCodeInClueDto(List<EDPMsDepartmentEntity> listEntity) {
		return listEntity.stream().map(
				entity -> new ClueDto(entity.getDepartmentId(), entity.getDepartmentName(), entity.getDepartmentCode()))
				.collect(Collectors.toList());
	}

	/**
	 * insert row in department table when department is created
	 *
	 * @param edpMsOfficeEntity the entity
	 * @return void
	 */
	public void createDeparmtment(EDPMsOfficeEntity edpMsOfficeEntity) {
		if (null != edpMsOfficeEntity) {
			EDPMsDepartmentEntity edpMsDepartmentEntity = new EDPMsDepartmentEntity();
			edpMsDepartmentEntity.setDepartmentName(edpMsOfficeEntity.getOfficeName());
			edpMsDepartmentEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			EDPMsDepartmentEntity savedDept = repository.save(edpMsDepartmentEntity);
			edpMsOfficeEntity.setDepartmentId(savedDept);
			EDPOfficeItrEntity edpOfficeItrEntity = officeItrConverter.toEntity(edpMsOfficeEntity);
			edpOfficeItrEntity.setDepartmentId(new EDPMsDepartmentEntity(savedDept.getDepartmentId()));
			officeItrRepository.save(edpOfficeItrEntity);
		}
	}
}
