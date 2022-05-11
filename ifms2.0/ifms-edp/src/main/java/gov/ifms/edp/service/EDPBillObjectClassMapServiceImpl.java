package gov.ifms.edp.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPBillObjectClassMapConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPBillObjectClassMapDto;
import gov.ifms.edp.dto.EDPBillTypeObjectClassMappingDTO;
import gov.ifms.edp.entity.EDPBillObjectClassMapEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPBillObjectClassMapRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPBillObjectClassMapServiceImpl.
 * 
 * @version 1.0
 * @created 2020/01/02 11:05:49
 */
@Service
public class EDPBillObjectClassMapServiceImpl implements EDPBillObjectClassMapService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPBillObjectClassMapAsMethodName repository. */
	@Autowired
	private EDPBillObjectClassMapRepository repository;

	/** The EDPBillObjectClassMapAsMethodName helper. */
	@Autowired
	private EDPBillObjectClassMapConverter converter;
	
	/** The lookupinfoservice. */
	@Autowired
	private EDPLuLookUpInfoService lookupinfoservice;

	/**
	 * Retrieves an EDPBillObjectClassMapEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPBillObjectClassMapEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPBillObjectClassMapEntity getBillObjectClassMap(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPBillObjectClassMapEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPBillObjectClassMapEntity
	 */
	@Override
	public EDPBillObjectClassMapEntity saveOrUpdateBillObjectClassMap(EDPBillObjectClassMapEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPBillObjectClassMapEntity with the given id.
	 *
	 * @param id must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteBillObjectClassMap(long id, int isDelete) {
		repository.deleteBillObjectClassMap(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPBillObjectClassMap items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPBillObjectClassMapDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPBillObjectClassMapDto> getBillObjectClassMaps(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPBillObjectClassMapEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPBillObjectClassMapEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPBillObjectClassMapEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Ge bill object class type details.
	 *
	 * @return the EDP bill type object class mapping DTO
	 */
	@Override
	public EDPBillTypeObjectClassMappingDTO geBillObjectClassTypeDetails() {
		EDPBillTypeObjectClassMappingDTO dto=new EDPBillTypeObjectClassMappingDTO();
		dto.setBillType(lookupinfoservice.findByLookUpName(EDPConstant.LIST_OF_BILLS).stream()
				.map(entity -> new ClueDto(entity.getLookUpInfoId(), entity.getLookUpInfoName(), null, null))
				.collect(Collectors.toList()));
		dto.setObjectClass(repository.getObjectClassData().stream()
				.map(object -> new ClueDto(Long.valueOf(object[0].toString()), object[1].toString(), null, null))
				.collect(Collectors.toList()));
		return dto;
	}

	/**
	 * Save or update bill object class map.
	 *
	 * @param dto the dto
	 * @return the EDP bill object class map dto
	 */
	@Override
	public EDPBillObjectClassMapDto saveOrUpdateBillObjectClassMap(EDPBillObjectClassMapDto dto) {
		List<EDPBillObjectClassMapEntity> listEntity=converter.toListOfEntity(dto);
		List<EDPBillObjectClassMapEntity> listData=repository.findByBillTypeIdLookUpInfoIdAndActiveStatus(dto.getBillTypeId(),Constant.ACTIVE_STATUS);
		if(CollectionUtils.isEmpty(listData)) {
			repository.saveAll(listEntity);
		}else {
			listData.forEach(entity->repository.deleteBillObjectClassMap(entity.getBillObjmapId(), Constant.IN_ACTIVE_STATUS, OAuthUtility.getCurrentUserUserId(), new Date()));
			repository.saveAll(listEntity);
		}
		return converter.listToDTO(listEntity);
	}

	/**
	 * Gets the object class.
	 *
	 * @param id the id
	 * @return the object class
	 */
	@Override
	public EDPBillTypeObjectClassMappingDTO getObjectClass(Long id) {
		List<EDPBillObjectClassMapEntity> listData=repository.findByBillTypeIdLookUpInfoIdAndActiveStatus(id,Constant.ACTIVE_STATUS);
		EDPBillTypeObjectClassMappingDTO dto=new EDPBillTypeObjectClassMappingDTO();
		dto.setObjectClass(listData.stream()
					.map(object -> new ClueDto(object.getObjectClassId() ,Boolean.TRUE))
					.collect(Collectors.toList()));
		return dto;
	}

}
