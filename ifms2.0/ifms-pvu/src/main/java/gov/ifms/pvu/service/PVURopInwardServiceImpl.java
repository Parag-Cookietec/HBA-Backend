package gov.ifms.pvu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsDesignationConverter;
import gov.ifms.edp.converter.EDPMsDistrictConverter;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.repository.EDPMsDistrictRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeCreationDDLView;
import gov.ifms.pvu.dto.PVUEmployeDetailsDto;
import gov.ifms.pvu.dto.PVURopInwardView;
import gov.ifms.pvu.dto.PvuWFWrapperDto;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVURopInwardEntity;
import gov.ifms.pvu.repository.PVURopInwardRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVURopInwardController.
 * 
 * @version v 1.0
 * @created 2020/03/12 14:42:25
 */
@Service
public class PVURopInwardServiceImpl implements PVURopInwardService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The PVURopInwardAsMethodName repository. */
	@Autowired
	private PVURopInwardRepository repository;

	/**
     * The district repository.
     */
    @Autowired
    private EDPMsDistrictRepository districtRepository;

    /**
     * The district converter.
     */
    @Autowired
    private EDPMsDistrictConverter districtConverter;

    /** The e DP ms designation repository. */
    @Autowired
    private EDPMsDesignationRepository eDPMsDesignationRepository;

    /** The e DP ms designation converter. */
    @Autowired
    private EDPMsDesignationConverter eDPMsDesignationConverter;
    
    /** The pvu facade. */
    @Autowired
    private PVYFacade pvuFacade;
    
	/**
	 * Retrieves an PVURopInwardEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVURopInwardEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVURopInwardEntity getRopInward(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVURopInwardEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved PVURopInwardEntity
	 */
	@Override
	public PVURopInwardEntity saveOrUpdateRopInward(PVURopInwardEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVURopInward items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVURopInwardDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVURopInwardView> getRopInwards(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMP_RP_INWARD_LIST_WF).toString();
			List<PVURopInwardView> objStorePro = this.storeProcPvu(procName, map, PVURopInwardView.class);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
     * Builds the page in map.
     *
     * @param pageDetail the page detail
     * @return the map
     */
    private Map<String, Object> buildPageInMap(PageDetails pageDetail) {
        Map<String, String> collect = getPvuSearchFields().stream()
                .collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
        return SearchParam.buildPageInMap(null, pageDetail, collect);
    }
    
    /**
     * Gets the pvu search fields.
     *
     * @return the pvu search fields
     */
    @Override
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.SEARCH_FIELD_IN_TRN_STATUS,
				PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_FROM_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_FORWARD_TO_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EVENT_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_PAN, PVUSearchEnum.PVU_SEARCH_DISTRICT, PVUSearchEnum.PVU_SEARCH_CARDEX,
				PVUSearchEnum.PVU_SEARCH_DDO, PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID,
				PVUSearchEnum.PVU_SEARCH_EMPLOYEE_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_FROM_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_INWARD_TO_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE,
				PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS,
				PVUSearchEnum.SEARCH_FIELD_IN_POU_ID,PVUSearchEnum.PVU_SEARCH_FIELD_TRN_NO);
	}
    
    /**
     * Store proc pvu.
     * @param <T>
     *
     * @param procName the proc name
     * @param map      the map
     * @param view 
     * @return the list
     * @throws CustomException the custom exception
     */
    public <T> List<T> storeProcPvu(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
        List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
        return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view)
                : Collections.emptyList();
    }
    
    /**
     * Gets the inward lu look up info as map.
     *
     * @return the inward lu look up info as map
     * @throws CustomException the custom exception
     */
    @Override
    public PVUEmployeDetailsDto getInwardLuLookUpInfo() throws CustomException {
    	PVUEmployeDetailsDto pvuEmployeDetailsDto = new PVUEmployeDetailsDto();
        try {
        	pvuEmployeDetailsDto.setLstLuLookUp(getInwardLookupSearch());
        	pvuEmployeDetailsDto.setDistrict(districtConverter.toEDPSDTDto(districtRepository.findByActiveStatusAndStateId(Constant.ACTIVE_STATUS,EDPConstant.STATE_ID_GUJ,EDPUtility.getJpaSort(EDPConstant.DISTRICT_NAME, EDPConstant.ORDER_ASC))));
        	pvuEmployeDetailsDto.setDesignation(eDPMsDesignationConverter.toEDPSDTDto(eDPMsDesignationRepository.findByActiveStatusEquals(Constant.ACTIVE_STATUS)));
        } catch (Exception ex) {
            throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
        }
		return pvuEmployeDetailsDto;
    }

	/**
	 * Gets the inward lookup search.
	 *
	 * @return the inward lookup search
	 * @throws CustomException the custom exception
	 */
    public Map<String, List<PVUEmployeCreationDDLView>> getInwardLookupSearch() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMP_ROP_INWARD_LK_SP).toString();
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.storeProcPvu(procName, Collections.emptyMap(), PVUEmployeCreationDDLView.class);
		resultMap = lstPVUEmployeCreationDDLView.stream()
		        .collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		return resultMap;
	}
    
	/**
	 * Generate inward number.
	 *
	 * @param fieldValue the field value
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean generateInwardNumber(List<IdDto> dtos) throws CustomException {
		try {
			List<Map<Integer, Object>> parameterMapList = new ArrayList<>();
			dtos.forEach(dto -> {
	            Map<Integer, Object> map = new HashMap<>();
	            map.put(1, dto.getId());
	            parameterMapList.add(map);
	        });
			return repository.callStoreProcBatch("{CALL " + Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INWARD_NO_GENERATION)) + "(?)}", parameterMapList);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Submit rop inward.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitRopInward(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Submit rop distributor.
	 *
	 * @param wrapperDto the wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean submitRopDistributor(List<PvuWFWrapperDto> wrapperDto) throws CustomException {
		try {
			return pvuFacade.callWorkFlowApis(wrapperDto);
		} catch (Exception e) {
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

}
