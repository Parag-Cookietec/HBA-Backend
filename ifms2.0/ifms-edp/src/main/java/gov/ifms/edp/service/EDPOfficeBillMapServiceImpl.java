package gov.ifms.edp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.base.Status;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPOfficeBillMapConverter;
import gov.ifms.edp.converter.EDPOfficeBillMapItrConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsOfficeDto;
import gov.ifms.edp.dto.EDPOfficeBillMapDto;
import gov.ifms.edp.entity.EDPOfficeBillMapEntity;
import gov.ifms.edp.entity.EDPOfficeBillMapItrEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPOfficeBillMapItrRepository;
import gov.ifms.edp.repository.EDPOfficeBillMapRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPOfficeBillMapServiceImpl.
 */
@Service
public class EDPOfficeBillMapServiceImpl implements EDPOfficeBillMapService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPofficeBillMapAsMethodName repository. */
	@Autowired
	private EDPOfficeBillMapRepository repository;

	/** The EDPofficeBillMapAsMethodName helper. */
	@Autowired
	private EDPOfficeBillMapConverter converter;

	/** The bill map itr repository. */
	@Autowired
	private EDPOfficeBillMapItrRepository billMapItrRepository;

	/** The EDPOfficeBillMapItrAsMethodName helper. */
	@Autowired
	private EDPOfficeBillMapItrConverter billMapItrConverter;

	/**
	 * Retrieves an EDPofficeBillMapEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPofficeBillMapEntity with the given id or {@literal null} if
	 *         none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPOfficeBillMapEntity getofficeBillMap(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPofficeBillMapEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPofficeBillMapEntity
	 */
	@Override
	public EDPOfficeBillMapEntity saveOrUpdateofficeBillMap(EDPOfficeBillMapEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPofficeBillMapEntity with the given id.
	 *
	 * @param id       must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteofficeBillMap(long id, int isDelete) {
		/**
		 * repository.deleteofficeBillMap(id, isDelete ,
		 * OAuthUtility.getCurrentUserUserId(),new java.util.Date());
		 */
	}

	/**
	 * Fetch all the EDPofficeBillMap items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPofficeBillMapDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPOfficeBillMapDto> getofficeBillMaps(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPOfficeBillMapEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPOfficeBillMapEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPOfficeBillMapEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Save office bill map.
	 *
	 * @param dto    the dto
	 * @param status the status
	 */
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void saveOfficeBillMap(EDPMsOfficeDto dto, boolean isUpdate) {

		boolean isSubmitted = false;
		if (((isUpdate || (dto.getOfficeStatus() != null
				&& (dto.getOfficeStatus() == 281 || dto.getOfficeStatus() == 282 || dto.getOfficeStatus() == 283)))
				&& dto.getFormAction() != Status.SUBMITTED)) {
			isSubmitted = false;
		} else {
			isSubmitted = true;
		}
		if (!CollectionUtils.isEmpty(dto.getSelectedBills())) {
			saveSelectedBills(dto, isSubmitted);
		} else if (dto.getBillType() != null && dto.getBillSubmittedTo() != null) {
			saveSubmittedBills(dto, isSubmitted);
		}

	}

	/**
	 * Save submitted bills.
	 *
	 * @param dto         the dto
	 * @param isSubmitted the is submitted
	 */
	private void saveSubmittedBills(EDPMsOfficeDto dto, boolean isSubmitted) {
		if (dto.getIsNewOffice() != null && dto.getIsNewOffice() && dto.getOfficeId() != null) {
			repository.updateActiveStatusByOfficeId(dto.getOfficeId(), EDPConstant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new Date());
		}
		EDPOfficeBillMapEntity edpOfficeBillMapEntity = convertToBillMapEntity(dto);
		if (isSubmitted) {
			edpOfficeBillMapEntity = repository.save(edpOfficeBillMapEntity);
		} else {
			List<EDPOfficeBillMapEntity> list = repository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
					EDPConstant.ACTIVE_STATUS_TRUE);
			if (!list.isEmpty()) {
				edpOfficeBillMapEntity.setOfficeBillMapId(list.get(0).getOfficeBillMapId());
			}
		}

		EDPOfficeBillMapItrEntity officeBillMapItrEntity = billMapItrConverter.toEntity(edpOfficeBillMapEntity);
		billMapItrRepository.save(officeBillMapItrEntity);
	}

	/**
	 * Save selected bills.
	 *
	 * @param dto         the dto
	 * @param isSubmitted the is submitted
	 */
	private void saveSelectedBills(EDPMsOfficeDto dto, boolean isSubmitted) {
		updateActiveStatusItr(dto.getOfficeId());

		if (dto.getIsNewOffice() != null && dto.getIsNewOffice() && dto.getOfficeId() != null) {
			repository.updateActiveStatusByOfficeId(dto.getOfficeId(), EDPConstant.INACTIVE_STATUS,
					OAuthUtility.getCurrentUserUserId(), new Date());
		}

		for (Long selectedBill : dto.getSelectedBills()) {
			EDPOfficeBillMapEntity edpOfficeBillMapEntity = convertToBillMapEntity(dto);
			edpOfficeBillMapEntity.setBillListId(selectedBill);
			if (isSubmitted) {
				edpOfficeBillMapEntity = repository.save(edpOfficeBillMapEntity);
			} else {
				List<EDPOfficeBillMapEntity> list = repository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
						EDPConstant.ACTIVE_STATUS_TRUE);

				if (!list.isEmpty()) {
					edpOfficeBillMapEntity.setOfficeBillMapId(list.get(0).getOfficeBillMapId());
				}
			}
			EDPOfficeBillMapItrEntity officeBillMapItrEntity = billMapItrConverter.toEntity(edpOfficeBillMapEntity);
			billMapItrRepository.save(officeBillMapItrEntity);
		}

	}

	/**
	 * Update active status itr.
	 *
	 * @param officeId the office id
	 */
	private void updateActiveStatusItr(Long officeId) {
		billMapItrRepository.updateActiveStatusByOfficeId(officeId, EDPConstant.INACTIVE_STATUS,
				OAuthUtility.getCurrentUserUserId(), new Date());
	}

	/**
	 * Convert to bill map entity.
	 *
	 * @param dto the dto
	 * @return the EDP office bill map entity
	 */
	private EDPOfficeBillMapEntity convertToBillMapEntity(EDPMsOfficeDto dto) {
		EDPOfficeBillMapEntity edpOfficeBillMapEntity = new EDPOfficeBillMapEntity();
		edpOfficeBillMapEntity.setOfficeId(dto.getOfficeId());
		edpOfficeBillMapEntity.setBillSubmittedTo(dto.getBillSubmittedTo());
		edpOfficeBillMapEntity.setBillType(dto.getBillType());
		return edpOfficeBillMapEntity;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateOfficeBillsItr(EDPMsOfficeDto dto) {
		/** mark old records as inactive */
		updateActiveStatusItr(dto.getOfficeId());

		if (CollectionUtils.isEmpty(dto.getSelectedBills())) {
			updateOfficeItrBills(dto);
		} else {
			updateOfficeItrSelectedBills(dto);
		}
	}

	/**
	 * Saves all bills for particular office based on request received.
	 * 
	 * @param dto
	 */
	private void updateOfficeItrBills(EDPMsOfficeDto dto) {
		EDPOfficeBillMapEntity edpMsBillentity = convertToBillMapEntity(dto);

		List<EDPOfficeBillMapEntity> list = repository.findByOfficeIdAndActiveStatus(dto.getOfficeId(),
				EDPConstant.ACTIVE_STATUS_TRUE);

		if (list != null && !list.isEmpty()) {
			edpMsBillentity.setOfficeBillMapId(list.get(0).getOfficeBillMapId());
		}

		billMapItrRepository.save(billMapItrConverter.toEntity(edpMsBillentity));
	}

	/**
	 * Saves selected bills for particular office based on request received.
	 * 
	 * @param dto
	 */
	private void updateOfficeItrSelectedBills(EDPMsOfficeDto dto) {
		List<EDPOfficeBillMapItrEntity> edpItrBillUpdateList = new ArrayList<>();
		for (Long billId : dto.getSelectedBills()) {
			EDPOfficeBillMapEntity edpOfficeBillMapEntity = convertToBillMapEntity(dto);
			edpOfficeBillMapEntity.setBillListId(billId);

			edpItrBillUpdateList.add(billMapItrConverter.toEntity(edpOfficeBillMapEntity));
		}

		billMapItrRepository.saveAll(edpItrBillUpdateList);
	}

	@Override
	public void approveOfficeBillMap(EDPMsOfficeDto dto) {
		if (dto.getSelectedBills() != null && !dto.getSelectedBills().isEmpty()) {
			approveSelectedBills(dto);
		} else {
			approveAllBills(dto);
		}
	}

	private void approveAllBills(EDPMsOfficeDto dto) {
		updateOldBillsStatus(dto.getOfficeId(), EDPConstant.INACTIVE_STATUS);

		EDPOfficeBillMapEntity edpOfficeBillMapEntity = convertToBillMapEntity(dto);
		edpOfficeBillMapEntity = repository.save(edpOfficeBillMapEntity);

		billMapItrRepository.save(billMapItrConverter.toEntity(edpOfficeBillMapEntity));
	}

	private void approveSelectedBills(EDPMsOfficeDto dto) {
		updateOldBillsStatus(dto.getOfficeId(), EDPConstant.INACTIVE_STATUS);
		List<EDPOfficeBillMapItrEntity> itrBillEntityList = new ArrayList<>();

		for (Long selectedBill : dto.getSelectedBills()) {
			EDPOfficeBillMapEntity edpOfficeBillMapEntity = convertToBillMapEntity(dto);
			edpOfficeBillMapEntity.setBillListId(selectedBill);

			edpOfficeBillMapEntity = repository.save(edpOfficeBillMapEntity);
			itrBillEntityList.add(billMapItrConverter.toEntity(edpOfficeBillMapEntity));
		}

		billMapItrRepository.saveAll(itrBillEntityList);
	}

	private void updateOldBillsStatus(Long officeId, int activeStatus) {
		billMapItrRepository.updateActiveStatusByOfficeId(officeId, activeStatus, OAuthUtility.getCurrentUserUserId(),
				new Date());

		repository.updateActiveStatusByOfficeId(officeId, activeStatus, OAuthUtility.getCurrentUserUserId(),
				new Date());
	}

	@Override
	public List<Long> getSubmitedOfficeIdByOfficeId(Long officeId) {
		List<Long> list = repository.getSubmitedOfficeIdByOfficeId(officeId, Constant.ACTIVE_STATUS);
		return list;

	}
}