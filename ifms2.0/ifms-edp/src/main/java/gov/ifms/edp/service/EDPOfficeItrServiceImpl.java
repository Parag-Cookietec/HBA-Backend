package gov.ifms.edp.service;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeItrDto;
import gov.ifms.edp.dto.EDPOfficeItrView;
import gov.ifms.edp.dto.EDPOfficeSummaryDDODto;
import gov.ifms.edp.dto.EDPOfficeSummaryDto;
import gov.ifms.edp.dto.EDPOfficeTransferDetails;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.entity.EDPOfficeItrEntity;
import gov.ifms.edp.entity.EDPOfficeModuleEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeItrRepository;
import gov.ifms.edp.repository.EDPOfficeModuleRepository;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.repository.EDPUpdateOfficeTrnRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPOfficeItrServiceImpl.
 */
@Service
public class EDPOfficeItrServiceImpl implements EDPOfficeItrService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPEdpOfficeItrAsMethodName repository. */
	@Autowired
	private EDPOfficeItrRepository repository;

	/** The EDPEdpOfficeItrAsMethodName helper. */
	@Autowired
	private EDPOfficeItrConverter converter;

	/** The office bill map itr repository. */
	@Autowired
	private EDPOfficeBillMapItrRepository officeBillMapItrRepository;

	/** The office module repository. */
	@Autowired
	private EDPOfficeModuleRepository officeModuleRepository;

	/** The edp ms office service impl. */
	@Autowired
	private EDPMsOfficeServiceImpl edpMsOfficeServiceImpl;

	/** The EDPMsOfficeAsMethodName repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	/** The EDPUpdateOfficeTrnRepository repository. */
	@Autowired
	private EDPUpdateOfficeTrnRepository edpOfficeTrnRepository;

	/** The sub office itr repository. */
	@Autowired
	private EDPSubOfficeItrRepository subOfficeItrRepository;

	/**
	 * Retrieves an EDPEdpOfficeItrEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPEdpOfficeItrEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPOfficeItrEntity getEdpOfficeItr(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPEdpOfficeItrEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPEdpOfficeItrEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPOfficeItrEntity saveOrUpdateEdpOfficeItr(EDPOfficeItrEntity entity) throws CustomException {
		try {
			return repository.save(entity);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Deletes the EDPEdpOfficeItrEntity with the given id.
	 *
	 * @param trnNumber the trn number
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteEdpOfficeItr(String trnNumber) throws CustomException {
		try {
			EDPOfficeItrEntity officeItrEntity = repository.findTopByTransactionNo(trnNumber,
					EDPUtility.getJpaSort("officeItrId", EDPConstant.ORDER_DESC));
			if (officeItrEntity == null) {
				throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
			}

			EDPUpdateOfficeTrnEntity officeTrnEntity = officeItrEntity.getOfficeTrnEntity();
			officeTrnEntity.setActiveStatus(EDPConstant.INACTIVE_STATUS);
			officeTrnEntity.setStatusId(EDPConstant.STATUS_CANCELLED_ID);
			edpOfficeTrnRepository.save(officeTrnEntity);
			subOfficeItrRepository.updateActiveStatusByOfficeTrnId(officeTrnEntity.getUpdOffcTrnId(),
					EDPConstant.INACTIVE_STATUS, OAuthUtility.getCurrentUserUserId(), new Date());
			repository.updateActiveStatusByTransactionNo(trnNumber, EDPConstant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new Date());
		} catch (Exception e) {
			logger.error(e.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Fetch all the EDPEdpOfficeItr items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPEdpOfficeItrDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeItrDto> getEdpOfficeItrs(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPOfficeItrEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPOfficeItrEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPOfficeItrEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * List edp offices.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeItrView> listEdpOffices(PageDetails pageDetail) throws CustomException {
		try {
			String procName = null;
			Map<String, Object> argsMap = EDPUtility.populateArgumentsWfList(pageDetail, 0);
			procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SEARCH_OFFICE_WF));
			List<Object[]> objectSp = this.scListingSp(procName, argsMap);
			int totalPages = !objectSp.isEmpty() ? Integer.parseInt(objectSp.get(0)[10].toString()) : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, converter.toListView(objectSp));

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Populate arguments.
	 *
	 * @param pageDetail the page detail
	 * @param index      the index
	 * @return the map
	 */
	private Map<String, Object> populateArguments(PageDetails pageDetail, int index) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		argsMap.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(
					search -> argsMap.put(EDPConstant.getSearchList(index).get(search.getKey()), search.getValue()));
		} else {
			EDPConstant.getSearchList(index).forEach((k, v) -> argsMap.put(EDPConstant.getSearchList(index).get(k), 0));
		}
		return argsMap;
	}

	/**
	 * Sc listing sp.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 */
	private List<Object[]> scListingSp(String procName, Map<String, Object> map) {
		return this.repository.callStoredProcedure(procName, map);
	}

	/**
	 * List edp update offices.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeItrView> listEdpUpdateOffices(PageDetails pageDetail) throws CustomException {
		try {
			String procName = null;
			Map<String, Object> argsMap = populateArguments(pageDetail, 8);
			procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_UPDATE_OFFICE_WF));
			List<Object[]> objectSp = this.scListingSp(procName, argsMap);
			int totalPages = !objectSp.isEmpty() ? Integer.parseInt(objectSp.get(0)[10].toString()) : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, converter.toListView(objectSp));

		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Update list edp office.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeSummaryDto> summaryListEdpOffice(PageDetails pageDetail) throws CustomException {
		try {

			Map<String, Object> argsMap = populateArguments(pageDetail, 2);
			argsMap.put(EDPConstant.IN_PARENT_LOOKUP_ID_KEY, EDPConstant.IN_PARENT_LOOKUP_ID_VALUE);
			argsMap.remove(Constant.IN_USER_LIST);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SUMMARY_EDP_WF));
			List<Object[]> objectSp = this.scListingSp(procName, argsMap);
			List<EDPOfficeSummaryDto> listSummary = NativeQueryResultsMapper.map(objectSp, EDPOfficeSummaryDto.class);
			if (listSummary.size() == 1) {
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, 0, Collections.emptyList());
			} else {
				return new PagebleDTO<>(pageDetail.getPageElement(), 0, listSummary.isEmpty() ? 0 : listSummary.size(),
						listSummary);
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Search summary list DDO office.
	 *
	 * @param pageDetail the page detail
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public PagebleDTO<EDPOfficeSummaryDDODto> searchSummaryListDDOOffice(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> argsMap = populateArguments(pageDetail, 1);

			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SUMMARY_DDO_WF));
			argsMap.put(EDPConstant.STATUS_VALUE, 0);
			argsMap.remove(Constant.IN_USER_LIST);
			List<Object[]> objectSp = this.scListingSp(procName, argsMap);
			List<EDPOfficeSummaryDDODto> listSummary = NativeQueryResultsMapper.map(objectSp,
					EDPOfficeSummaryDDODto.class);
			int count = listSummary != null && !listSummary.isEmpty() ? listSummary.get(0).getTotalCount() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, listSummary);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Search summary list DDO office detail.
	 *
	 * @param pageDetail the page detail
	 * @return the pageble DTO
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeSummaryDDODto> searchSummaryListDDOOfficeDetail(PageDetails pageDetail)
			throws CustomException {
		try {
			Map<String, Object> argsMap = populateArguments(pageDetail, 1);
			String procName = Constant.EDP_SCHEMA.concat(Constant.DOT.concat(EDPConstant.SP_EDP_SUMMARY_DDO_DETAIL));
			argsMap.remove(Constant.IN_USER_LIST);
			argsMap.put(EDPConstant.STATUS_VALUE, 0);
			argsMap.put(EDPConstant.IN_OFFICE_ID_VALUE, OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId());
			List<Object[]> objectSp = this.scListingSp(procName, argsMap);
			List<EDPOfficeSummaryDDODto> listSummary = NativeQueryResultsMapper.map(objectSp,
					EDPOfficeSummaryDDODto.class);
			int count = listSummary != null && !listSummary.isEmpty() ? listSummary.get(0).getTotalCount() : 0;
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, count, listSummary);
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the edp office itr.
	 *
	 * @param trnNo the trn no
	 * @return the edp office itr
	 * @throws CustomException the custom exception
	 */
	@Override
	public EDPMsOfficeDto getEdpOfficeItr(String trnNo) throws CustomException {
		EDPOfficeItrEntity itrEntity = repository.findTopByTransactionNo(trnNo,
				EDPUtility.getJpaSort("officeItrId", EDPConstant.ORDER_DESC));
		if (itrEntity != null) {
			EDPMsOfficeDto officeDto = converter.toOfficeDto(itrEntity);
			Long officeId = officeDto.getOfficeId();
			EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.getOne(officeId);
			List<EDPOfficeBillMapItrEntity> billMapEntities = officeBillMapItrRepository
					.findByOfficeIdAndActiveStatus(officeId, Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(billMapEntities)) {
				officeDto.setBillSubmittedTo(billMapEntities.get(0).getBillSubmittedTo());
				officeDto.setBillType(billMapEntities.get(0).getBillType());
				officeDto.setSelectedBills(billMapEntities.stream().map(EDPOfficeBillMapItrEntity::getBillListId)
						.collect(Collectors.toSet()));
			}
			List<EDPOfficeModuleEntity> officeModuleEntities = officeModuleRepository
					.findByOfficeIdAndActiveStatus(officeId, Constant.ACTIVE_STATUS);
			setNameById(itrEntity, officeDto, officeModuleEntities);
			Long prvOfficeStatusId = repository.findLastApprovedOfficeStatus(officeId);
			if (prvOfficeStatusId != null) {
				EDPLuLookUpInfoEntity lookUpInfo = lookUpInfoRepository.findBylookUpInfoId(prvOfficeStatusId);
				if (lookUpInfo != null) {
					officeDto.setPrvOfficeStatusId(prvOfficeStatusId);
					officeDto.setPrvOfficeStatus(lookUpInfo.getLookUpInfoName());
				}
			}
			if (null != officeEntity.getCreatedDate())
				officeDto.setCreatedDate(officeEntity.getCreatedDate());

			if (itrEntity.getOfficeTransferId() != null) {
				officeDto.setOfficeTransferDetails(getOfficeTransferDetails(itrEntity.getOfficeTransferId()));
			}

			return officeDto;
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Get Transfered Office Details based on input.
	 *
	 * @param officeId the office id
	 * @return EDPOfficeTransferDetails
	 */
	private EDPOfficeTransferDetails getOfficeTransferDetails(Long officeId) {
		EDPMsOfficeEntity transOfficeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId,
				EDPConstant.ACTIVE_STATUS_TRUE);
		if (transOfficeEntity == null) {
			return null;
		}

		EDPOfficeTransferDetails officeTransDto = new EDPOfficeTransferDetails();
		officeTransDto.setOfficeId(transOfficeEntity.getOfficeId());
		officeTransDto.setOfficeName(transOfficeEntity.getOfficeName());
		officeTransDto.setOfficeName(transOfficeEntity.getOfficeName());
		officeTransDto.setDistrictId(
				transOfficeEntity.getDistrictId() != null ? transOfficeEntity.getDistrictId().getDistrictId() : null);
		officeTransDto.setCardexNo(transOfficeEntity.getCardexno().toString());
		officeTransDto.setDdoNo(transOfficeEntity.getDdoNo());

		return officeTransDto;
	}

	/**
	 * Sets the name by id.
	 *
	 * @param entity               the entity
	 * @param officeDto            the office dto
	 * @param officeModuleEntities the office module entities
	 */
	private void setNameById(EDPOfficeItrEntity entity, EDPMsOfficeDto officeDto,
			List<EDPOfficeModuleEntity> officeModuleEntities) {
		if (!CollectionUtils.isEmpty(officeModuleEntities)) {

			officeDto.setModuleId(
					officeModuleEntities.stream().map(EDPOfficeModuleEntity::getModuleId).collect(Collectors.toList()));
		}
		if (null != entity.getLevelId()) {
			officeDto.setLevelName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getLevelId()));
		}
		if (null != entity.getDdoType()) {
			officeDto
					.setDdoTypeName(edpMsOfficeServiceImpl.getNameByLookUpId(Long.parseLong(entity.getDdoType() + "")));
		}
		if (null != entity.getNonDdo()) {
			officeDto.setNonDdoTypeName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getNonDdo()));
		}
		if (null != entity.getPvuId()) {
			officeDto.setPvuName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getPvuId()));
		}
		if (null != entity.getRequestTo()) {
			officeDto.setRequestToName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getRequestTo()));
		}
		if (null != entity.getTreasuryType()) {
			officeDto.setTreasuryTypeName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getTreasuryType()));
		}
		if (null != entity.getIsCo()) {
			officeDto.setIsCoName(edpMsOfficeServiceImpl.getNameByLookUpId(entity.getIsCo()));
		} else {
			officeDto.setIsCoName(edpMsOfficeServiceImpl.getNameByLookUpId(1l));
		}
		if (null != entity.getHodId()) {
			EDPMsOfficeEntity hodEntity = edpMsOfficeRepository.getOne(Long.parseLong(entity.getHodId() + ""));
			officeDto.setHodName(hodEntity.getOfficeName());
		}
		if (null != entity.getCoId()) {
			officeDto.setCoDesgName(
					edpMsOfficeServiceImpl.getDesignationNameById(Long.parseLong(entity.getCoId() + "")));
		}
		if (null != entity.getDesgDdoId()) {
			officeDto.setDesgDdoName(edpMsOfficeServiceImpl.getDesignationNameById(entity.getDesgDdoId()));
		}
	}

}
