package gov.ifms.pvu.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPMsUserService;
import gov.ifms.pvu.dto.PVUEmployeAddressView;
import gov.ifms.pvu.dto.PVUEmployeEventView;
import gov.ifms.pvu.entity.PVUEmployeAddressEntity;
import gov.ifms.pvu.repository.PVUEmployeAddressRepository;
import gov.ifms.pvu.util.PvuConstant;


/**
 * The Class PVUEmployeAddressServiceImpl.
 * 
 * @version v 1.0
 * @created 2019/11/22 03:23:32
 */
@Service
public class PVUEmployeAddressServiceImpl implements PVUEmployeAddressService  {
	
	/** The logger. */
	private Logger logger=LoggerFactory.getLogger(this.getClass().getName());
	
	/** The PVUEmployeAddressAsMethodName repository. */
	@Autowired
	private PVUEmployeAddressRepository repository;
	
	/** The edp ms user service. */
	@Autowired
	private EDPMsUserService edpMsUserService;

	/**
	 * Retrieves an PVUEmployeAddressEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeAddressEntity with the given id or {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeAddressEntity getEmployeAddress(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeAddressEntity. Use the returned instance for further operations
	 * as the save operation might have changed the entity instance completely.
	 *
	 * @param entity the entity
	 * @return the saved PVUEmployeAddressEntity
	 */
	@Override
	public PVUEmployeAddressEntity saveOrUpdateEmployeAddress(PVUEmployeAddressEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Fetch all the PVUEmployeAddress items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<PVUEmployeAddressDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeAddressView> getEmployeAddresss(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMPLOYEE_DETAIL).toString();
			List<PVUEmployeAddressView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.toString());
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
		List<IdDto> lst = edpMsUserService.getDependentUerIdByUserId(OAuthUtility.getCurrentUserUserId());
		StringBuilder stringBuilder = new StringBuilder();
		for (IdDto dto : lst) {
			stringBuilder.append((dto.getId().toString())).append(Constant.COMMA);
		}
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		map.put(Constant.IN_USER_LIST, stringBuilder.substring(0, stringBuilder.length() - 1));
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams
					.forEach(search -> map.put(PvuConstant.getSearchList().get(search.getKey()), search.getValue()));
		} else {
			PvuConstant.getSearchList().forEach((k, v) -> map.put(PvuConstant.getSearchList().get(k), 0));
		}
		return map;
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUEmployeAddressView> storeProcPvu(String procName, Map<String, Object> map) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeAddressView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the all employe events.
	 *
	 * @param pageDetail the page detail
	 * @return the all employe events
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeEventView> getAllEmployeEvents(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT).append(PvuConstant.PVU_EMPLOYEE_DETAIL).toString();
			List<PVUEmployeAddressView> objStorePro = this.storeProcPvu(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, null);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}
	
}