package gov.ifms.edp.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import gov.ifms.edp.dto.EDPLuLookUpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.converter.EDPLuLookUpInfoConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPLuLookUpInfoDto;
import gov.ifms.edp.dto.EDPLuLookUpResponse;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPLuLookUpRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPLuLookUpInfoServiceImpl.
 */
@Service
public class EDPLuLookUpInfoServiceImpl implements EDPLuLookUpInfoService {

	/** The EDPLuLookUpInfoAsMethodName repository. */
	@Autowired
	private EDPLuLookUpInfoRepository repository;

	/** The EDPLuLookUpInfoAsMethodName helper. */
	@Autowired
	private EDPLuLookUpInfoConverter converter;

	/** The e DP lu look up repository. */
	@Autowired
	private EDPLuLookUpRepository eDPLuLookUpRepository;

	/**
	 * Returns all instances of the EDPLuLookUpInfoEntity type.
	 * 
	 * @return all EDPLuLookUpInfoEntity
	 */
	@Override
	public List<EDPLuLookUpInfoEntity> getLuLookUpInfos() {
		return repository.findAll();
	}

	/**
	 * Retrieves an EDPLuLookUpInfoEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPLuLookUpInfoEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPLuLookUpInfoEntity getLuLookUpInfo(long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPLuLookUpInfoEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param bpn the bpn
	 * @return the saved EDPLuLookUpInfoEntity
	 */
	@Override
	public EDPLuLookUpInfoEntity saveOrUpdateLuLookUpInfo(EDPLuLookUpInfoEntity bpn) {
		return repository.save(bpn);
	}

	/**
	 * Deletes the EDPLuLookUpInfoEntity with the given id.
	 * 
	 * @param id must not be {@literal null}.
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */

	@Override
	public void deleteLuLookUpInfo(long id) {
		repository.deleteById(id);

	}

	/**
	 * Saves all given EDPLuLookUpInfoEntity entities.
	 *
	 * @param entities the entities
	 * @return the saved entities
	 * @throws IllegalArgumentException in case the given entity is {@literal null}.
	 */

	@Override
	public List<EDPLuLookUpInfoEntity> saveLuLookUpInfos(List<EDPLuLookUpInfoEntity> entities) {
		return (List<EDPLuLookUpInfoEntity>) repository.saveAll(entities);
	}

	/**
	 * Fetch all the EDPLuLookUpInfo items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPLuLookUpInfoDto>
	 */

	@Override
	public PagebleDTO<EDPLuLookUpInfoDto> edpLuLookUpInfoAsMethodNameSearch(PageDetails pageDetail) {
		SpecificationImpl<EDPLuLookUpInfoEntity> spec = new SpecificationImpl<>();
		PageRequest pageable = null;
		SearchCriteria searchCriteria = new SearchCriteria();

		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPLuLookUpInfoEntity> empSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPLuLookUpInfoEntity> page = repository.findAll(empSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Find by look up id.
	 *
	 * @return the list
	 */
	@Override
	public List<ClueDto> findByLookUpId() {
		EDPLuLookUpEntity eDPLuLookUpEntity = eDPLuLookUpRepository.findByLookUpName(Constant.LOOKUP_NAME_OBJECT_TYPE);
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
				eDPLuLookUpEntity.getLookUpId(), Constant.ACTIVE_STATUS);
		return eDPLuLookUpInfoEntities.stream().map(eDPLuLookUpInfoEntity -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(eDPLuLookUpInfoEntity.getLookUpInfoId());
			clueDto.setName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCode(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCodeName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			return clueDto;

		}).collect(Collectors.toList());
	}

	/**
	 * Find by look up name.
	 *
	 * @param lookUpName the look up name
	 * @return the list
	 */
	@Override
	public List<EDPLuLookUpInfoEntity> findByLookUpName(final String lookUpName) {
		return repository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(lookUpName, Constant.ACTIVE_STATUS,
				EDPUtility.getJpaSort(EDPConstant.LOOKUP_INFO_ID,EDPConstant.ORDER_ASC));
	}

	/**
	 * Fetch all the EDPLuLookUpInfoEntity items For PVU Office Type.
	 *
	 * @param lookUpId the look up id
	 * @return List<EDPLuLookUpInfoEntity>
	 */
	@Override
	public List<EDPLuLookUpInfoEntity> findByEdpLuLookUpEntityLookUpIdAndActiveStatus(Long lookUpId) {
		return repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(lookUpId, Constant.ACTIVE_STATUS);
	}

	/**
	 * Find by look up name.
	 *
	 * @param lookUpName the look up name
	 * @param sortColumnName the sort column name
	 * @param order the order
	 * @return the list
	 */
	@Override
	public List<EDPLuLookUpInfoEntity> findByLookUpName(String lookUpName,String sortColumnName,int order) {
		return repository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(lookUpName, Constant.ACTIVE_STATUS,
				EDPUtility.getJpaSort(sortColumnName,order));
	}

	@Override
	public List<ClueDto> findIdAndNameByLookUpName(String lookupName) {
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = repository.findByEdpLuLookUpEntityLookUpNameAndActiveStatus(
				lookupName, Constant.ACTIVE_STATUS);
		return eDPLuLookUpInfoEntities.stream().map(eDPLuLookUpInfoEntity -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(eDPLuLookUpInfoEntity.getLookUpInfoId());
			clueDto.setName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCode(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCodeName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			return clueDto;

		}).collect(Collectors.toList());
	}

	@Override
	public List<EDPLuLookUpResponse> getLookUpInfoByParentName(Set<String> lookTypes) {
		return repository.getLookUpByParentName(lookTypes);
	}
	
	/**
     * Gets the look up info by parent look up.
     *
     * @param lookTypes the look types
     * @return the look up info by parent look up
     */
    @Override
    public Map<String,List<EDPLuLookUpResponse>> getLookUpInfoByParentLookUp(Set<String> lookTypes) {
        List<EDPLuLookUpResponse> responseList=getLookUpInfoByParentName(lookTypes);
        if(!CollectionUtils.isEmpty(responseList)) {
            return responseList.stream().collect(Collectors.groupingBy(EDPLuLookUpResponse::getLookupType));
           
        }
        return Collections.emptyMap();
    }

	@Override
	public List<ClueDto> getLookUpInfoByParentLookUpId(SearchDto dto) {
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = repository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
				dto.getId(), Constant.ACTIVE_STATUS);
		return eDPLuLookUpInfoEntities.stream().map(eDPLuLookUpInfoEntity -> {
			ClueDto clueDto = new ClueDto();
			clueDto.setId(eDPLuLookUpInfoEntity.getLookUpInfoId());
			clueDto.setName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCode(eDPLuLookUpInfoEntity.getLookUpInfoName());
			clueDto.setCodeName(eDPLuLookUpInfoEntity.getLookUpInfoName());
			return clueDto;

		}).collect(Collectors.toList());
	}
}
