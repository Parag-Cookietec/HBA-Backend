package gov.ifms.edp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsSubOfficeConverter;
import gov.ifms.edp.converter.EDPSubOfficeItrConverter;
import gov.ifms.edp.dto.EDPMsSubOfficeDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsSubOfficeEntity;
import gov.ifms.edp.entity.EDPSubOfficeItrEntity;
import gov.ifms.edp.entity.EDPUpdateOfficeTrnEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsSubOfficeRepository;
import gov.ifms.edp.repository.EDPSubOfficeItrRepository;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPMsSubOfficeServiceImpl.
 */
@Service
public class EDPMsSubOfficeServiceImpl implements EDPMsSubOfficeService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsSubOfficeAsMethodName repository. */
	@Autowired
	private EDPMsSubOfficeRepository repository;

	/** The EDPMsSubOfficeAsMethodName helper. */
	@Autowired
	private EDPMsSubOfficeConverter converter;

	/** The sub office itr repository. */
	@Autowired
	private EDPSubOfficeItrRepository subOfficeItrRepository;

	/** The sub office itr converter. */
	@Autowired
	private EDPSubOfficeItrConverter subOfficeItrConverter;

	/** The edp ms office repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/** The lookupinforepository. */
	@Autowired
	private EDPLuLookUpInfoRepository lookupinforepository;

	/** The edp lu look up info repository. */
	@Autowired
	private EDPLuLookUpInfoRepository edpLuLookUpInfoRepository;

	@Autowired
	private EDPSubOfficeItrService itrService;

	@Autowired
	private EDPMsOfficeService edpMsOfficeService;

	/**
	 * Retrieves an EDPMsSubOfficeEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsSubOfficeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsSubOfficeEntity getMsSubOffice(Long id) {
		return repository.findBySubOfficeIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
	}

	/**
	 * Saves a given EDPMsSubOfficeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsSubOfficeEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public EDPMsSubOfficeEntity saveOrUpdateMsSubOffice(EDPMsSubOfficeEntity entity, EDPMsSubOfficeDto dto)
			throws CustomException {
		try {
			entity.setSubOfficeCode(null);
			if (dto.getDepartmentId() != null) {
				entity.setDeptId(new EDPMsDepartmentEntity(dto.getDepartmentId()));
			}
			/**
			 * Using dept id from request if (dto.getDepartmentId() != null) {
			 * EDPMsOfficeEntity officeEntity =
			 * edpMsOfficeRepository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
			 * EDPConstant.ACTIVE_STATUS_TRUE);
			 * entity.setDeptId(officeEntity.getDepartmentId()); }
			 */
			EDPLuLookUpInfoEntity saveAsDraft = edpLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_SAVAS_DRAFT);
			if (null != saveAsDraft)
				entity.setStatus(saveAsDraft.getLookUpInfoId());
			EDPMsSubOfficeEntity subOfficeEntity = null;
			if (dto.getIsUpdate() == null || !dto.getIsUpdate()) {
				entity.setIsUpdate(new EDPLuLookUpInfoEntity(Constant.LONG_ONE_VALUE));
				subOfficeEntity = repository.save(entity);
				if (!StringUtils.isEmpty(entity.getSubOfficeCode())) {
					saveSubOffice(entity);
				}
			} else {
				if (!StringUtils.isEmpty(entity.getSubOfficeCode())) {
					saveSubOffice(entity);
				}
				entity.setIsUpdate(new EDPLuLookUpInfoEntity(Constant.LONG_TWO_VALUE));
				subOfficeEntity = entity;
			}
			EDPSubOfficeItrEntity subOfficeItrEntity = subOfficeItrConverter.toEntity(subOfficeEntity);
			if (entity.getOfficeTrnId() != null) {
				EDPUpdateOfficeTrnEntity officeTrnEntity = edpMsOfficeService
						.getLastOfficeTrn(entity.getOfficeId().getOfficeId(), EDPConstant.ACTIVE_STATUS_TRUE);
				if (officeTrnEntity != null) {
					subOfficeItrEntity.setOfficeTrnEntity(officeTrnEntity);
				}
			}

			if (null != dto.getSubOfficeItrId())
				subOfficeItrEntity.setSubOfficeItrId(dto.getSubOfficeItrId());
			subOfficeItrRepository.save(subOfficeItrEntity);
			return subOfficeEntity;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_CREATE);
		}
	}

	/**
	 * Save sub office.
	 *
	 * @param entity the entity
	 */
	private void saveSubOffice(EDPMsSubOfficeEntity entity) {
		List<EDPSubOfficeItrEntity> previousEntity = subOfficeItrRepository
				.findBySubOfficeCodeAndActiveStatus(entity.getSubOfficeCode(), Constant.ACTIVE_STATUS);
		for (EDPSubOfficeItrEntity edpSubOfficeItrEntity : previousEntity) {
			edpSubOfficeItrEntity.setActiveStatus(Constant.IN_ACTIVE_STATUS);
			subOfficeItrRepository.save(edpSubOfficeItrEntity);
		}
	}

	/**
	 * Deletes the EDPMsSubOfficeEntity with the given id.
	 *
	 * @param id           must not be {@literal null}.
	 * @param activeStatus the active status
	 * @throws CustomException          the custom exception
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsSubOffice(Long id, int activeStatus) throws CustomException {
		try {
			EDPMsSubOfficeEntity subOffice = getMsSubOffice(id);
			if (subOffice != null) {
				List<EDPSubOfficeItrEntity> subOfficeItrEntities = subOfficeItrRepository
						.findBySubOfficeIdAndActiveStatus(subOffice.getSubOfficeId(), Constant.ACTIVE_STATUS);
				for (EDPSubOfficeItrEntity itrEntity : subOfficeItrEntities) {
					subOfficeItrRepository.updateActiveStatusBySubOfficeId(itrEntity.getSubOfficeItrId(), activeStatus,
							OAuthUtility.getCurrentUserUserId(), new Date());
				}
			}
			this.repository.updateActiveStatusByOfficeId(id, activeStatus, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Fetch all the EDPMsSubOffice items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsSubOfficeDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsSubOfficeDto> getMsSubOffices(PageDetails pageDetail) throws CustomException {
		try {
			Optional<SearchParam> isUpdateOffice = pageDetail.getJsonArr().stream()
					.filter(parm -> parm.getKey().equals(EDPConstant.IS_UPDATE_KEY)).findFirst();

			Optional<SearchParam> flagKey = pageDetail.getJsonArr().stream()
					.filter(parm -> parm.getKey().equals(EDPConstant.FLAG_KEY)).findFirst();

			Optional<SearchParam> displaySubOffice = pageDetail.getJsonArr().stream()
					.filter(parm -> parm.getKey().equals(EDPConstant.DISPLAY_SUB_OFFICE)).findFirst();

			if (isUpdateOffice.isPresent() && flagKey.isPresent()) {
				List<SearchParam> jsonArray1 = pageDetail.getJsonArr();
				jsonArray1.remove(isUpdateOffice.get());
				pageDetail.setJsonArr(jsonArray1);

				List<SearchParam> jsonArray2 = pageDetail.getJsonArr();
				jsonArray2.remove(flagKey.get());
				pageDetail.setJsonArr(jsonArray2);

				Boolean isDispOff = false;
				if (displaySubOffice.isPresent()) {
					List<SearchParam> jsonArray3 = pageDetail.getJsonArr();
					jsonArray3.remove(displaySubOffice.get());
					pageDetail.setJsonArr(jsonArray3);
					isDispOff = Boolean.parseBoolean(displaySubOffice.get().getValue());
				}

				if (Boolean.parseBoolean(isUpdateOffice.get().getValue())
						&& Boolean.parseBoolean(flagKey.get().getValue())) {
					return itrService.getsubOfficeItrs(pageDetail);
				} else if (isDispOff) {
					return itrService.getsubOfficeItrs(pageDetail);
				} else {
					return getMsSubOfficesPageDetails(pageDetail);
				}
			} else {
				return getMsSubOfficesPageDetails(pageDetail);
			}
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Gets the ms sub offices page details.
	 *
	 * @param pageDetail the page detail
	 * @return the ms sub offices page details
	 */
	private PagebleDTO<EDPMsSubOfficeDto> getMsSubOfficesPageDetails(PageDetails pageDetail) {
		PageRequest pageable = null;
		pageDetail.setSortByColumn("updatedDate");
		pageDetail.setSortOrder("DESC");
		SearchCriteria searchCriteria = new SearchCriteria();
		SpecificationImpl<EDPMsSubOfficeEntity> spec = new SpecificationImpl<>();
		pageable = pageDetail.getPageDetails(pageDetail);
		Specification<EDPMsSubOfficeEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
				pageDetail.getJsonArr());
		Page<EDPMsSubOfficeEntity> page = repository.findAll(dataSpec, pageable);

		return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
				converter.toDTO(page.getContent()));
	}

	/**
	 * Gets the sub office code.
	 *
	 * @param officeId the office id
	 * @return the sub office code
	 * @throws CustomException the custom exception
	 */
	@Override
	public String getSubOfficeCode(Long officeId) throws CustomException {
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId,
				EDPConstant.ACTIVE_STATUS_TRUE);
		if (officeEntity != null) {
			Optional<Long> obj = repository.findLastSubOfficeCode(officeEntity.getOfficeId());
			return EDPUtility.generateSubOfficeNo(officeEntity.getDistrictId().getDistrictCode(),
					officeEntity.getDdoNo(), officeEntity.getCardexno(), obj.isPresent() ? obj.get() : 0L);
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Approve all sub office by office id.
	 *
	 * @param officeId the office id
	 * @return the int
	 * @throws CustomException
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void approveAllSubOfficeByOfficeId(Long officeId) throws CustomException {
		List<EDPMsSubOfficeEntity> subOfficeEntities = repository.findByOfficeIdOfficeIdAndActiveStatus(officeId,
				Constant.ACTIVE_STATUS);
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId,
				Constant.ACTIVE_STATUS);
		for (EDPMsSubOfficeEntity subOffEntity : subOfficeEntities) {
			EDPMsSubOfficeEntity subOfficeEntity = null;
			subOffEntity.setSubOfficeCode(getSubOfficeCode(officeId));
			if (null != officeEntity.getDepartmentId()) {
				subOffEntity.setDeptId(new EDPMsDepartmentEntity(officeEntity.getDepartmentId().getDepartmentId()));
			}
			EDPLuLookUpInfoEntity approve = lookupinforepository
					.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
			subOffEntity.setStatus(approve.getLookUpInfoId());
			subOfficeEntity = repository.save(subOffEntity);
			EDPSubOfficeItrEntity edpMsSubOffItrEntity = subOfficeItrConverter.toSubOffItrEntity(subOfficeEntity);
			if (edpMsSubOffItrEntity != null) {
				edpMsSubOffItrEntity.setSubOfficeId(subOfficeEntity.getSubOfficeId());
				subOfficeItrRepository.save(edpMsSubOffItrEntity);
			}
		}

	}

	/**
	 * Update sub office.
	 *
	 * @param subOfficeItrEntities the sub office itr entities
	 *
	private void updateSubOffice(List<EDPSubOfficeItrEntity> subOfficeItrEntities) {
		for (EDPSubOfficeItrEntity itrEntity : subOfficeItrEntities) {
			if (itrEntity.getSubOfficeId() != null) {
				this.repository.updateActiveStatusByOfficeId(itrEntity.getSubOfficeId(), Constant.INACTIVE_STATUS,
						OAuthUtility.getCurrentUserUserId(), new Date());
			}
		}
	}/

	/**
	 * Update all sub office data.
	 */
	public void updateAllSubOfficeData(EDPMsOfficeEntity entity) {
		if (null != entity.getOfficeId()) {
			Long officeId = entity.getOfficeId();
			List<EDPMsSubOfficeEntity> subOfficeList = repository.findByOfficeIdOfficeIdAndActiveStatus(officeId,
					Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(subOfficeList)) {
				List<EDPMsSubOfficeEntity> updateSubOfficeList = getSubOfficeData(entity, subOfficeList);
				repository.saveAll(updateSubOfficeList);
			}
			updateSubOfficeItrEntity(entity, officeId);
		}
	}

	/**
	 * Gets the sub office data.
	 *
	 * @param entity        the entity
	 * @param subOfficeList the sub office list
	 * @return the sub office data
	 */
	private List<EDPMsSubOfficeEntity> getSubOfficeData(EDPMsOfficeEntity entity,
			List<EDPMsSubOfficeEntity> subOfficeList) {
		return subOfficeList.stream().map(subOffice -> {
			if (!entity.getDistrictId().getDistrictId().equals(subOffice.getDistrict().getDistrictId())) {
				subOffice.setTaluka(null);
			}
			if (null != entity.getDistrictId())
				subOffice.setDistrict(entity.getDistrictId());
			if (null != entity.getDepartmentId())
				subOffice.setDeptId(entity.getDepartmentId());
			if (null != entity.getHodId())
				subOffice.setHodId(new EDPMsOfficeEntity(Long.valueOf(String.valueOf(entity.getHodId()))));
			return subOffice;
		}).collect(Collectors.toList());
	}

	/**
	 * Update sub office itr entity.
	 *
	 * @param entity   the entity
	 * @param officeId the office id
	 */
	private void updateSubOfficeItrEntity(EDPMsOfficeEntity entity, Long officeId) {
		List<EDPSubOfficeItrEntity> subOfficeItrList = subOfficeItrRepository
				.findByOfficeIdOfficeIdAndActiveStatus(officeId, Constant.ACTIVE_STATUS);
		if (!CollectionUtils.isEmpty(subOfficeItrList)) {
			List<EDPSubOfficeItrEntity> updateSubOfficeList = subOfficeItrList.stream().map(subItrOffice -> {
				if (!entity.getDistrictId().getDistrictId().equals(subItrOffice.getDistrict().getDistrictId())) {
					subItrOffice.setTaluka(null);
				}
				if (null != entity.getDistrictId())
					subItrOffice.setDistrict(entity.getDistrictId());
				if (null != entity.getDepartmentId())
					subItrOffice.setDeptId(entity.getDepartmentId());
				if (null != entity.getHodId())
					subItrOffice.setHodId(new EDPMsOfficeEntity(Long.valueOf(String.valueOf(entity.getHodId()))));
				return subItrOffice;
			}).collect(Collectors.toList());
			subOfficeItrRepository.saveAll(updateSubOfficeList);
		}
	}

	/**
	 * Update sub office code.
	 *
	 * @param subOffice the sub office
	 * @param office    the office
	 */
	public void updateSubOfficeCode(EDPMsSubOfficeEntity subOffice, EDPMsOfficeEntity office) {
		StringBuilder subOfficCode = new StringBuilder();
		String[] subOfficeCodeArray = subOffice.getSubOfficeCode().split(EDPConstant.SLASH);
		String subOfficeNo = subOfficeCodeArray[subOfficeCodeArray.length - 1];
		if (null != office.getDistrictId())
			subOfficCode.append(office.getDistrictId().getDistrictId());
		if (null != office.getDdoNo())
			subOfficCode.append(EDPConstant.SLASH + office.getDdoNo());
		if (null != office.getCardexno())
			subOfficCode.append(EDPConstant.SLASH + office.getCardexno());
		if (null != subOfficeNo)
			subOfficCode.append(EDPConstant.SLASH + subOfficeNo);
		if (!StringUtils.isEmpty(subOfficCode.toString()))
			subOffice.setSubOfficeCode(subOfficCode.toString());
	}

	/**
	 * Update sub office itr code.
	 *
	 * @param subOfficeItr the sub office itr
	 * @param office       the office
	 */
	public void updateSubOfficeItrCode(EDPSubOfficeItrEntity subOfficeItr, EDPMsOfficeEntity office) {
		StringBuilder subOfficCode = new StringBuilder();
		String[] subOfficeCodeArray = subOfficeItr.getSubOfficeCode().split(EDPConstant.SLASH);
		String subOfficeNo = subOfficeCodeArray[subOfficeCodeArray.length - 1];
		if (null != office.getDistrictId())
			subOfficCode.append(office.getDistrictId().getDistrictId());
		if (null != office.getDdoNo())
			subOfficCode.append(EDPConstant.SLASH + office.getDdoNo());
		if (null != office.getCardexno())
			subOfficCode.append(EDPConstant.SLASH + office.getCardexno());
		if (null != subOfficeNo)
			subOfficCode.append(EDPConstant.SLASH + subOfficeNo);
		if (!StringUtils.isEmpty(subOfficCode.toString()))
			subOfficeItr.setSubOfficeCode(subOfficCode.toString());
	}

	/**
	 * Update sub office itr.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateSubOfficeItr(Long id, int activeStatus) throws CustomException {
		EDPMsSubOfficeEntity subOffice = getMsSubOffice(id);
		if (subOffice != null) {
			List<EDPSubOfficeItrEntity> subOfficeItrEntities = subOfficeItrRepository
					.findBySubOfficeCodeAndActiveStatus(subOffice.getSubOfficeCode(), Constant.ACTIVE_STATUS);
			for (EDPSubOfficeItrEntity itrEntity : subOfficeItrEntities) {
				subOfficeItrRepository.updateActiveStatusBySubOfficeId(itrEntity.getSubOfficeItrId(), activeStatus,
						OAuthUtility.getCurrentUserUserId(), new Date());
			}
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSubOfficeItr(EDPMsOfficeEntity entity) {
		if (entity.getOfficeId() != null) {
			List<EDPSubOfficeItrEntity> subOfficeItrList = subOfficeItrRepository
					.findByOfficeIdOfficeIdAndActiveStatus(entity.getOfficeId(), Constant.ACTIVE_STATUS);
			if (subOfficeItrList != null && !subOfficeItrList.isEmpty()) {
				subOfficeItrList.stream().map(subOfficeItr -> {
					setOfficeData(entity, subOfficeItr);
					return subOfficeItr;
				}).collect(Collectors.toList());
				subOfficeItrRepository.saveAll(subOfficeItrList);
			}
		}
	}

	/**
	 * Sets the office data.
	 *
	 * @param entity       the entity
	 * @param subOfficeItr the sub office itr
	 */
	private void setOfficeData(EDPMsOfficeEntity entity, EDPSubOfficeItrEntity subOfficeItr) {
		if (entity.getDistrictId() != null) {
			Long subOfficeDistId = subOfficeItr.getDistrict() != null ? subOfficeItr.getDistrict().getDistrictId()
					: null;
			if (!entity.getDistrictId().getDistrictId().equals(subOfficeDistId)) {
				subOfficeItr.setTaluka(null);
			}
			subOfficeItr.setDistrict(entity.getDistrictId());
		}
		if (entity.getDepartmentId() != null)
			subOfficeItr.setDeptId(entity.getDepartmentId());

		if (entity.getHodId() != null)
			subOfficeItr.setHodId(new EDPMsOfficeEntity(Long.valueOf(String.valueOf(entity.getHodId()))));
	}

	@Override
	public void copyMsSubOffice(EDPMsOfficeEntity newOfficeEntity, EDPUpdateOfficeTrnEntity officeTrnEntity) {
		List<EDPMsSubOfficeEntity> subOfficeList = repository
				.findByOfficeIdOfficeIdAndActiveStatus(newOfficeEntity.getOfficeId(), EDPConstant.ACTIVE_STATUS_TRUE);

		if (subOfficeList != null && !subOfficeList.isEmpty()) {
			List<EDPSubOfficeItrEntity> subOfficeItrList = new ArrayList<>();

			subOfficeList.stream().forEach(x -> {
				EDPSubOfficeItrEntity subOfficeItr = subOfficeItrConverter.toEntity(x);
				subOfficeItr.setSubOfficeCode(null);
				subOfficeItr.setIsUpdate(new EDPLuLookUpInfoEntity(Constant.LONG_TWO_VALUE));
				subOfficeItr.setUpdatedBy(OAuthUtility.getCurrentUserUserId());
				subOfficeItr.setUpdatedDate(new Date());
				subOfficeItr.setUpdatedByPost(OAuthUtility.getCurrentUserLkPOUId());
				subOfficeItr.setOfficeTrnEntity(officeTrnEntity);
				subOfficeItr.setStatus(Constant.SAVE_AS_DRAFT_STATUS_ID);

				subOfficeItrList.add(subOfficeItr);
			});

			subOfficeItrRepository.saveAll(subOfficeItrList);
		}
	}

	@Override
	public void approveAllSubOfficeUpdate(Long officeId, Long officeTrnId) throws CustomException {
		List<EDPMsSubOfficeEntity> subOfficeList = repository
				.findByOfficeIdOfficeIdAndActiveStatus(officeId, EDPConstant.ACTIVE_STATUS_TRUE);
		if (subOfficeList != null && !subOfficeList.isEmpty()) {
			subOfficeList.forEach(x -> x.setActiveStatus(Constant.IN_ACTIVE_STATUS));
			
			repository.saveAll(subOfficeList);
		}
		
		List<EDPSubOfficeItrEntity> subOfficeItrList = repository.findByOfficeTrnId(officeTrnId.longValue(), Constant.ACTIVE_STATUS);
		EDPMsOfficeEntity officeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId,
				Constant.ACTIVE_STATUS);
		for (EDPSubOfficeItrEntity subItrEntity : subOfficeItrList) {
			EDPMsSubOfficeEntity subOfficeEntity = subOfficeItrConverter.toItrEntity(subItrEntity);
			subOfficeEntity.setSubOfficeCode(getSubOfficeCode(officeId));
			if (null != officeEntity.getDepartmentId()) {
				subOfficeEntity.setDeptId(new EDPMsDepartmentEntity(officeEntity.getDepartmentId().getDepartmentId()));
			}
			EDPLuLookUpInfoEntity approve = lookupinforepository
					.findByLookUpInfoName(EDPConstant.LK_STATUS_VAL_APPROVED);
			subOfficeEntity.setStatus(approve.getLookUpInfoId());
			subOfficeEntity = repository.save(subOfficeEntity);

			EDPSubOfficeItrEntity subOfficeItr = subOfficeItrConverter.toSubOffItrEntity(subOfficeEntity);
			if (subOfficeItr != null) {
				subOfficeItr.setSubOfficeId(subOfficeEntity.getSubOfficeId());
				subOfficeItrRepository.save(subOfficeItr);
			}
		}
	}
}
