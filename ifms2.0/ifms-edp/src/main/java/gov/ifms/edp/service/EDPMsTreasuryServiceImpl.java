package gov.ifms.edp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchCriteria;
import gov.ifms.common.pagination.SpecificationImpl;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.converter.EDPMsTreasuryConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsTreasuryDto;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPMsOfficeRepository;
import gov.ifms.edp.repository.EDPMsTreasuryRepository;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPMsTreasuryServiceImpl.
 */
@Service
public class EDPMsTreasuryServiceImpl implements EDPMsTreasuryService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/** The EDPMsTreasuryAsMethodName repository. */
	@Autowired
	private EDPMsTreasuryRepository repository;

	/** The EDPMsTreasuryAsMethodName helper. */
	@Autowired
	private EDPMsTreasuryConverter converter;

	/** The EDPMsOfficeAsMethodName repository. */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/**
	 * Retrieves an EDPMsTreasuryEntity by its id.
	 * 
	 * @param id must not be {@literal null}.
	 * @return the EDPMsTreasuryEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public EDPMsTreasuryEntity getMsTreasury(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given EDPMsTreasuryEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param entity the entity
	 * @return the saved EDPMsTreasuryEntity
	 */
	@Override
	public EDPMsTreasuryEntity saveOrUpdateMsTreasury(EDPMsTreasuryEntity entity) {
		return repository.save(entity);
	}

	/**
	 * Deletes the EDPMsTreasuryEntity with the given id.
	 *
	 * @param id       must not be {@literal null}.
	 * @param isDelete the is delete
	 * @throws IllegalArgumentException in case the given {@code id} is
	 *                                  {@literal null}
	 */
	@Override
	public void deleteMsTreasury(long id, int isDelete) {
		repository.deleteMsTreasury(id, isDelete, OAuthUtility.getCurrentUserUserId(), new java.util.Date());
	}

	/**
	 * Fetch all the EDPMsTreasury items with pagination.
	 *
	 * @param pageDetail the page detail
	 * @return List<EDPMsTreasuryDto>
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<EDPMsTreasuryDto> getMsTreasurys(PageDetails pageDetail) throws CustomException {
		try {
			PageRequest pageable = null;
			SearchCriteria searchCriteria = new SearchCriteria();
			SpecificationImpl<EDPMsTreasuryEntity> spec = new SpecificationImpl<>();
			pageable = pageDetail.getPageDetails(pageDetail);
			Specification<EDPMsTreasuryEntity> dataSpec = searchCriteria.getSpecificationDetails(spec,
					pageDetail.getJsonArr());
			Page<EDPMsTreasuryEntity> page = repository.findAll(dataSpec, pageable);

			return new PagebleDTO<>(page.getSize(), page.getTotalPages(), page.getTotalElements(),
					converter.toDTO(page.getContent()));
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * This method is used to get treasury by district id
	 * 
	 * @param districtId
	 * @return List<ClueDto>
	 */
	@Override
	public List<ClueDto> getMsTreasurysByDistrictId(Long districtId) {
		if(districtId.equals(EDPConstant.DISTRICT_AHMEDABAD_PAO_ID)) {
			districtId = EDPConstant.DISTRICT_AHMEDABAD_ID;
		} else if(districtId.equals(EDPConstant.DISTRICT_GANDHINAGAR_PAO_ID)) {
			districtId = EDPConstant.DISTRICT_GANDHINAGAR_ID;
		}
		List<EDPMsTreasuryEntity> treasuryEnties = repository.findByDistrictIdAndActiveStatus(districtId,
				Constant.ACTIVE_STATUS);
		return treasuryEnties.stream().map(treasuryEntity -> {
			ClueDto treasuryDto = new ClueDto();
			treasuryDto.setId(treasuryEntity.getTreasuryId());
			treasuryDto.setName(treasuryEntity.getTreasuryName());
			treasuryDto.setCode(treasuryEntity.getTreasuryCode());
			return treasuryDto;
		}).collect(Collectors.toList());
	}

	/**
	 * This method is used to check treasury off name by district id
	 * 
	 * @param districtId
	 * @return List<ClueDto>
	 */
	@Override
	public List<EDPMsTreasuryEntity> checkToNameByDistrictId(ClueDto clueDto) {
		List<EDPMsTreasuryEntity> treasuryEnties = repository.findByDistrictIdAndActiveStatus(clueDto.getDistrictid(),
				Constant.ACTIVE_STATUS);
		if (!treasuryEnties.isEmpty()) {
			return treasuryEnties.stream().filter(
					entity -> entity.getTreasuryName().equals(clueDto.getOfficeName() + ", " + clueDto.getName()))
					.collect(Collectors.toList());
		}
		return treasuryEnties;
	}

	@Transactional(rollbackFor = CustomException.class)
	public void saveTreasurySubTresuryOffice(Long officeId) {
		try {
			EDPMsOfficeEntity edpMsOfficeEntity = edpMsOfficeRepository.findByOfficeIdAndActiveStatus(officeId,
					Constant.ACTIVE_STATUS);
			EDPMsTreasuryEntity edpMsTreasuryEntity = new EDPMsTreasuryEntity();
			edpMsTreasuryEntity.setTreasuryName(edpMsOfficeEntity.getOfficeNameDisp());
			edpMsTreasuryEntity.setActiveStatus(Constant.ACTIVE_STATUS);
			edpMsTreasuryEntity.setDistrictId(edpMsOfficeEntity.getDistrictId().getDistrictId());

			if (null != edpMsOfficeEntity.getTreasuryType() && EDPConstant.EDP_TREASURY_TYPE.equals(edpMsOfficeEntity.getTreasuryType())) {
				repository.save(edpMsTreasuryEntity);
			}
			if (null != edpMsOfficeEntity.getTreasuryType() && EDPConstant.EDP_SUB_TREASURY_TYPE.equals(edpMsOfficeEntity.getTreasuryType())) {
				List<EDPMsTreasuryEntity> treasuryEnties = repository.findByDistrictIdAndActiveStatus(
						edpMsOfficeEntity.getDistrictId().getDistrictId(), Constant.ACTIVE_STATUS);
				List<EDPMsTreasuryEntity> toEntities = treasuryEnties.stream()
						.filter(entity -> entity.getParentId() == null || entity.getParentId() == 0)
						.collect(Collectors.toList());
				edpMsTreasuryEntity.setParentId(toEntities.get(0).getTreasuryId());
				repository.save(edpMsTreasuryEntity);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
