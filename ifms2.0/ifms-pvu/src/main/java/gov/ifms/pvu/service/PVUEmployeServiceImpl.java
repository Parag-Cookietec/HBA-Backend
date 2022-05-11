package gov.ifms.pvu.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import gov.ifms.edp.converter.*;
import gov.ifms.edp.repository.*;
import gov.ifms.pvu.dto.*;
import gov.ifms.pvu.dto.response.PVUPairView;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.filenet.api.core.Document;
import com.filenet.api.util.Id;

import gov.ifms.common.attachment.dto.AttachmentMasterDto;
import gov.ifms.common.attachment.dto.FileUploadResponseDto;
import gov.ifms.common.attachment.service.AttachmentService;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.constant.MsgConstant;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.dto.SearchDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.common.util.FilenetUtility;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPLuLookUpEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.service.EDPLuLookUpInfoService;
import gov.ifms.edp.service.EDPMsStateService;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVUDepartmentCategoryConverter;
import gov.ifms.pvu.converter.PVUEmployeAddressConverter;
import gov.ifms.pvu.converter.PVUEmployeConverter;
import gov.ifms.pvu.converter.PVUEmployeNomineeConverter;
import gov.ifms.pvu.converter.PVUMsCourseConverter;
import gov.ifms.pvu.dto.enumration.PVUSearchEnum;
import gov.ifms.pvu.entity.PVUEmployeAddressEntity;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeNomineeEntity;
import gov.ifms.pvu.repository.PVUDepartmentCategoryRepository;
import gov.ifms.pvu.repository.PVUEmployeAddressRepository;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeNomineeRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.repository.PVUMsCourseRepository;
import gov.ifms.pvu.util.PVUNativeSqlQueryConstant;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;
import gov.ifms.pvu.wrapper.PVYFacade;

/**
 * The Class PVUEmployeServiceImpl.
 *
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 */
@Service
public class PVUEmployeServiceImpl implements PVUEmployeService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private PVUEmployeRepository repository;

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * The PVUEmployeRepository repository.
	 */
	@Autowired
	private PVUEmployeDepartmentRepository pvuEmployeDepartmentRepository;

	/**
	 * The PVUEmployeConverter converter.
	 */
	@Autowired
	private PVUEmployeConverter converter;

	/**
	 * The PVUEmployeAddressConverter emp add converter.
	 */
	@Autowired
	private PVUEmployeAddressConverter empAddConverter;

	/**
	 * The PVUEmployeNomineeConverter emp nominee converter.
	 */
	@Autowired
	private PVUEmployeNomineeConverter empNomineeConverter;

	/**
	 * The PVUEmployeAddressRepository employe address repository.
	 */
	@Autowired
	private PVUEmployeAddressRepository employeAddressRepository;

	/**
	 * The PVUEmployeNomineeRepository emp nominee repository.
	 */
	@Autowired
	private PVUEmployeNomineeRepository empNomineeRepository;

	/**
	 * The EDPMsStateService edp ms state service.
	 */
	@Autowired
	private EDPMsStateService edpMsStateService;

	/**
	 * The PVUGradePayRepository repository.
	 */
	@Autowired
	private EDPMsDesignationRepository designationRepository;

	/**
	 * The PVUGradePayRepository repository.
	 */
	@Autowired
	private EDPMsDesignationConverter designationConverter;

	/**
	 * The course repository.
	 */
	@Autowired
	private PVUMsCourseRepository courseRepository;

	/**
	 * The course converter.
	 */
	@Autowired
	private PVUMsCourseConverter courseConverter;

	/**
	 * The e DP lu look up info repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository eDPLuLookUpInfoRepository;

	/**
	 * The e DP lu look up repository.
	 */
	@Autowired
	private EDPLuLookUpRepository eDPLuLookUpRepository;

	/**
	 * The e DP ms financial year repository.
	 */
	@Autowired
	private EDPMsFinancialYearRepository eDPMsFinancialYearRepository;

	/**
	 * The e DP ms financial year converter.
	 */
	@Autowired
	private EDPMsFinancialYearConverter eDPMsFinancialYearConverter;

	/**
	 * The EDPLuLookUpInfoService edp ms state service.
	 */
	@Autowired
	private EDPLuLookUpInfoService edpLuLookUpInfoService;

	/**
	 * The e DP ms department repository.
	 */
	@Autowired
	private EDPMsDepartmentRepository eDPMsDepartmentRepository;

	/**
	 * The e DP ms department converter.
	 */
	@Autowired
	private EDPMsDepartmentConverter eDPMsDepartmentConverter;

	/**
	 * The pvu facade.
	 */
	@Autowired
	private PVYFacade pvuFacade;

	/**
	 * The edp ms office repository.
	 */
	@Autowired
	private EDPMsOfficeRepository edpMsOfficeRepository;

	/**
	 * The edp ms office converter.
	 */
	@Autowired
	private EDPMsOfficeConverter edpMsOfficeConverter;

	/**
	 * The pvu dept cat repository.
	 */
	@Autowired
	private PVUDepartmentCategoryRepository pvuDeptCatRepository;

	/**
	 * The pvu dept cat converter.
	 */
	@Autowired
	private PVUDepartmentCategoryConverter pvuDeptCatConverter;

	@Autowired
	private EDPMsBankIfscConverter edpMsBankIfscConverter;

	@Autowired
	private EDPMsBankIfscRepository edpMsBankIfscRepository;

	@Autowired
	PVUEmployeQualificationService pvuEmployeQualificationService;

	@Autowired
	PVUEmployeDepartmentService pvuEmployeDepartmentService;

	@Autowired
	EDPMsBankBranchRepository edpMsBankBranchRepository;

	@Autowired
	EDPMsBankBranchConverter edpMsBankBranchConverter;

	/**
	 * Retrieves an PVUEmployeEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeEntity getEmploye(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Retrieves an PVUEmployeEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeEntity with the given id or {@literal null} if none
	 *         found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeEntity getActiveEmployee(Long id, int activeStatus) throws CustomException {
		return repository.findByEmpIdAndActiveStatus(id, activeStatus)
				.orElseThrow(() -> new CustomException(ErrorResponse.RECORD_NOT_FOUND));
	}

	/**
	 * Saves a given PVUEmployeEntity. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUEmployeEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	@ExceptionHandler
	@Transactional(rollbackFor = Exception.class)
	public PVUEmployeeDtos saveOrUpdateEmploye(PVUEmployeeDtos dto) throws CustomException {
		PVUEmployeeDtos dtos = new PVUEmployeeDtos();
		try {
			PVUEmployeEntity entity = repository.save(converter.toEntity(dto.getPvuEmployeDto()));
			if (dto.getPvuEmployeDto().getPhotoAttachment().get(0).getAttachment() != null
					&& !dto.getPvuEmployeDto().getPhotoAttachment().get(0).getAttachment().isEmpty()) {
				dto.getPvuEmployeDto().getPhotoAttachment()
						.forEach(photoDto -> photoDto.setTransactionId(entity.getEmpId()));
				List<FileUploadResponseDto> uploadAttachment = attachmentService
						.createPostAttachment(dto.getPvuEmployeDto().getPhotoAttachment().get(0));
				if (uploadAttachment != null && !uploadAttachment.isEmpty()) {
					entity.setEmployeePhoto(uploadAttachment.get(0).getDocumentId());
					entity.setEmployeePhotoName(uploadAttachment.get(0).getFilename());
				}
			}
			dto.getPvuEmployeAddressDto().setEmpId(entity.getEmpId());
			PVUEmployeAddressEntity addressEntity = employeAddressRepository
					.save(empAddConverter.toEntity(dto.getPvuEmployeAddressDto()));
			List<PVUEmployeNomineeDto> nomList = new ArrayList<>();
			dto.getPvuEmployeNomineeDto().forEach(nomineeDto -> nomineeDto.setEmpId(entity.getEmpId()));
			dto.getPvuEmployeNomineeDto().forEach(nom -> {
				PVUEmployeNomineeEntity ent = empNomineeConverter.toEntity(nom);
				validateAndSetNomineeDetails(nom, ent);
				empNomineeRepository.save(ent);
				nomList.add(empNomineeConverter.toDTO(ent));
			});
			dtos.setPvuEmployeDto(converter.toDTO(entity));
			if (!StringUtils.isBlank(dtos.getPvuEmployeDto().getEmployeePhoto())) {
				dtos.getPvuEmployeDto()
						.setEmpViewPhoto(getAttachments(dtos.getPvuEmployeDto().getEmployeePhoto()).getImage());
			}
			dtos.setPvuEmployeAddressDto(empAddConverter.toDTO(addressEntity));
			dtos.setPvuEmployeNomineeDto(nomList);

		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return dtos;
	}

	private void validateAndSetNomineeDetails(PVUEmployeNomineeDto nom, PVUEmployeNomineeEntity ent) {
		if (nom.getGenNomineePhotoAttachment() != null && nom.getGenNomineePhotoAttachment().getAttachment() != null
				&& !nom.getGenNomineePhotoAttachment().getAttachment().isEmpty()) {
			List<FileUploadResponseDto> uploadAttachment = saveFileAndGetDocumentId(nom.getGenNomineePhotoAttachment(),
					ent.getEmpNomineeId());
			if (uploadAttachment != null && !uploadAttachment.isEmpty()) {
				ent.setGenNomineePhoto(uploadAttachment.get(0).getDocumentId());
				ent.setGenNomineeFormName(uploadAttachment.get(0).getFilename());
			}
		}
		if (nom.getNomineePhotoAttachment() != null && nom.getNomineePhotoAttachment().getAttachment() != null
				&& !nom.getNomineePhotoAttachment().getAttachment().isEmpty()) {
			List<FileUploadResponseDto> uploadAttachment = saveFileAndGetDocumentId(nom.getNomineePhotoAttachment(),
					ent.getEmpNomineeId());
			if (uploadAttachment != null && !uploadAttachment.isEmpty()) {
				ent.setNomineePhoto(uploadAttachment.get(0).getDocumentId());
				ent.setNomineePhotoName(uploadAttachment.get(0).getFilename());
			}
		}
		if (nom.getNpsNomineePhotoAttachment() != null && nom.getNpsNomineePhotoAttachment().getAttachment() != null
				&& !nom.getNpsNomineePhotoAttachment().getAttachment().isEmpty()) {
			List<FileUploadResponseDto> uploadAttachment = saveFileAndGetDocumentId(nom.getNpsNomineePhotoAttachment(),
					ent.getEmpNomineeId());
			if (uploadAttachment != null && !uploadAttachment.isEmpty()) {
				ent.setNpsNomineePhoto(uploadAttachment.get(0).getDocumentId());
				ent.setNpsNomineeFormName(uploadAttachment.get(0).getFilename());
			}
		}
	}

	/**
	 * Save file and get document id.
	 *
	 * @param att   the att
	 * @param trnId the trn id
	 * @return the list
	 */
	public List<FileUploadResponseDto> saveFileAndGetDocumentId(AttachmentMasterDto att, long trnId) {
		if (att != null) {
			att.setTransactionId(trnId);
			List<FileUploadResponseDto> npsPhoto = null;
			try {
				npsPhoto = attachmentService.createPostAttachment(att);
			} catch (CustomException e) {
				logger.error(e.toString(), e);
			}
			return npsPhoto;
		}
		return Collections.emptyList();
	}

	/**
	 * Gets the employes.
	 *
	 * @param pageDetail the page detail
	 * @return the employes
	 * @throws CustomException the custom exception
	 */
	@Override
	public PagebleDTO<PVUEmployeAddressView> getEmployes(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = buildPageInMap(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_EMPLOYEE_DETAIL).toString();
			List<PVUEmployeAddressView> objStorePro = this.storeProcPvu(procName, map);
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, getEmployeeRowCount(objStorePro), objStorePro);
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * @param objStorePro
	 * @return
	 * @throws CustomException
	 */
	private long getEmployeeRowCount(List<PVUEmployeAddressView> objStorePro) throws CustomException {
		try {
			return objStorePro.isEmpty() ? 0 : Long.parseLong(objStorePro.get(0).getEmployeeRowCount());
		} catch (NumberFormatException ex) {
			logger.error(ex.toString(), ex);
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
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append((OAuthUtility.getCurrentUserUserId())).append(Constant.COMMA);
		Map<String, String> collect = getPvuSearchFields().stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		return SearchParam.buildPageInMap(stringBuilder, pageDetail, collect);
	}

	/**
	 * Store proc pvu.
	 *
	 * @param procName the proc name
	 * @param map      the map
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
	public PagebleDTO<PVUCommonEmployeView> getAllCommonEmploye(PageDetails pageDetail) throws CustomException {
		try {
			Map<String, Object> map = PvuConstant.buildPageInMapCommonEmp(pageDetail);
			String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
					.append(PvuConstant.PVU_COMMON_EMPLOYEE_DETAIL).toString();
			List<PVUCommonEmployeView> objStorePro = this.storeProcCommonEmp(procName, map);
			int totalPages = objStorePro.size();
			return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objStorePro);
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	/**
	 * Lookup employee creation sp.
	 *
	 * @param procName the proc name
	 * @param map      the map
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	public List<PVUCommonEmployeView> storeProcCommonEmp(String procName, Map<String, Object> map)
			throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUCommonEmployeView.class)
				: Collections.emptyList();
	}

	/**
	 * Lookup employee creation sp.
	 *
	 * @param procName the proc name
	 * @return the list
	 * @throws CustomException the custom exception
	 */
	private List<PVUEmployeCreationDDLView> lookupEmployeeCreationSp(String procName) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, Collections.emptyMap());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCreationDDLView.class)
				: Collections.emptyList();
	}

	/**
	 * Gets the all lu look up info as map.
	 *
	 * @return the all lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	public Map<String, List<PVUEmployeCreationDDLView>> getAllLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = new StringBuilder(Constant.PVU_SCHEMA_MASTER).append(Constant.DOT)
				.append(PvuConstant.PVU_EMPLOYEE_CREATION_LOOKUP_SP).toString();
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeCreationSp(procName);
		resultMap = lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		return resultMap;
	}

	/**
	 * Gets the employee details.
	 *
	 * @param id the id
	 * @return the employee details
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUEmployeeDtos getEmployeeDetails(Long id) throws CustomException {
		PVUEmployeeDtos pvuEmployeeDtos = new PVUEmployeeDtos();
		try {
			Optional<PVUEmployeEntity> pvuEmployeEntity = repository.findByEmpIdAndActiveStatus(id,
					Constant.ACTIVE_STATUS);
			if (pvuEmployeEntity.isPresent()) {
				PVUEmployeAddressEntity pvuEmployeAddressEntity = employeAddressRepository
						.findPVUEmployeAddressEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
				List<PVUEmployeNomineeEntity> listPvuEmployeNomineeEntity = empNomineeRepository
						.findPVUEmployeNomineeEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
				pvuEmployeeDtos.setPvuEmployeDto(converter.toDTO(pvuEmployeEntity.get()));
				if (!StringUtils.isBlank(pvuEmployeeDtos.getPvuEmployeDto().getEmployeePhoto())) {
					pvuEmployeeDtos.getPvuEmployeDto().setEmpViewPhoto(
							getAttachments(pvuEmployeeDtos.getPvuEmployeDto().getEmployeePhoto()).getImage());
				}
				if (pvuEmployeAddressEntity != null) {
					pvuEmployeeDtos.setPvuEmployeAddressDto(empAddConverter.toDTO(pvuEmployeAddressEntity));
				}
				if (listPvuEmployeNomineeEntity != null && !listPvuEmployeNomineeEntity.isEmpty()) {
					pvuEmployeeDtos.setPvuEmployeNomineeDto(empNomineeConverter.toDTO(listPvuEmployeNomineeEntity));
				}
			}

		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return pvuEmployeeDtos;
	}

	/**
	 * This method fetch all lookup and master details from cache and return data.
	 * 
	 * @return PVUEmployeeLookupInfoDto
	 */
	@Override
	public PvuLookupInfoDto getPvuLookupInfo() {
		PvuLookupInfoDto pvuLookupInfoDto = getPvuLookupInfoDto();
		pvuLookupInfoDto.setHodDepartment(getHODDepartments());
		return pvuLookupInfoDto;
	}

	/**
	 * This is cache method to set all lookup and master to DTO object.
	 * 
	 * @return PvuLookupInfoDto
	 */

	@Override
	@Cacheable(value = "pvuLookupInfo")
	public PvuLookupInfoDto getPvuLookupInfoDto() {
		PvuLookupInfoDto pvuLookupInfoDto = new PvuLookupInfoDto();
		try {
			pvuLookupInfoDto.setLstLuLookUp(getAllLuLookUpInfoAsMap());
			pvuLookupInfoDto.setYearOfPassing(eDPMsFinancialYearConverter
					.toEDPSDTDto(eDPMsFinancialYearRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).stream()
					.sorted(Comparator.comparing(EDPSDTDto::getName).reversed()).collect(Collectors.toList()));
			pvuLookupInfoDto.setDeptCategory(
					pvuDeptCatConverter.toEDPSDTDtos(pvuDeptCatRepository.findByActiveStatus(Constant.ACTIVE_STATUS,
							EDPUtility.getJpaSort(PvuConstant.DEPT_CATEGORY_NAME, EDPConstant.ORDER_ASC))));
			pvuLookupInfoDto.setBankIfsc(edpMsBankBranchConverter
					.toEDPSDTDto(edpMsBankBranchRepository.findByActiveStatus(Constant.ACTIVE_STATUS,
							EDPUtility.getJpaSort(PvuConstant.IFSC_CODE, EDPConstant.ORDER_ASC))));

			List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = null;
			EDPLuLookUpEntity eDPLuLookUpEntity = eDPLuLookUpRepository.findByLookUpName(PvuConstant.COURSE_CATEGORY);
			if (eDPLuLookUpEntity != null) {
				eDPLuLookUpInfoEntities = eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
						eDPLuLookUpEntity.getLookUpId(), Constant.ACTIVE_STATUS);
			}
			if (eDPLuLookUpInfoEntities != null && !eDPLuLookUpInfoEntities.isEmpty()) {
				eDPLuLookUpInfoEntities.forEach(entityInList -> {
					if (PvuConstant.CCC_EXAM.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuLookupInfoDto.setCccExamBody(courseConverter
								.toEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					} else if (PvuConstant.COURSE_NAME.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuLookupInfoDto.setCourse(courseConverter
								.toCourseEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					} else if (PvuConstant.SCHOOL_DEGREE.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuLookupInfoDto.setSchoolDegree(courseConverter
								.toEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					}
				});
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return pvuLookupInfoDto;
	}

	/**
	 * This is cache method to get Hod department DTO object.
	 * 
	 * @return list of hod offices
	 */
	@Override
	@Cacheable(value = "pvuHodDepartment")
	public List<EDPSDTDto> getHODDepartments() {
		List<EDPSDTDto> hodDepartments = null;
		try {
			Set<String> statusNameList = new HashSet<>();
			statusNameList.add(EDPConstant.LK_STATUS_VAL_APPROVED);
			statusNameList.add(EDPConstant.LK_STATUS_VAL_ACTIVE);
			List<EDPLuLookUpInfoEntity> approveLookUpInfo = eDPLuLookUpInfoRepository
					.findByLookUpInfoNameIn(statusNameList);
			Set<Short> statusIdList = approveLookUpInfo.stream()
					.map(entity -> Short.valueOf(String.valueOf(entity.getLookUpInfoId()))).collect(Collectors.toSet());
			EDPLuLookUpInfoEntity yesInfoEntity = eDPLuLookUpInfoRepository
					.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
			Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;

			hodDepartments = edpMsOfficeConverter.toEDPSDTDtos(
					edpMsOfficeRepository.findAllHodOffice(statusIdList, lookUpYesId, EDPConstant.ACTIVE_STATUS_TRUE));
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return hodDepartments;
	}

	/**
	 * This is evict cache method to flush HOD data.
	 */
	@Override
	@CacheEvict(value = "pvuHodDepartment", allEntries = true)
	public boolean evictHODDepartmentsCache() {
		return Boolean.TRUE;
	}

	/**
	 * Gets the employe look up info.
	 *
	 * @return the employe look up info
	 */
	@Override
	@Deprecated
	public PVUEmployeDetailsDto getEmployeLookUpInfo() {
		PVUEmployeDetailsDto pvuEmployeDetailsDto = new PVUEmployeDetailsDto();
		List<EDPLuLookUpInfoEntity> eDPLuLookUpInfoEntities = null;
		try {
			getLookupMasterData(pvuEmployeDetailsDto);
			EDPLuLookUpEntity eDPLuLookUpEntity = eDPLuLookUpRepository.findByLookUpName(PvuConstant.COURSE_CATEGORY);
			if (eDPLuLookUpEntity != null) {
				eDPLuLookUpInfoEntities = eDPLuLookUpInfoRepository.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(
						eDPLuLookUpEntity.getLookUpId(), Constant.ACTIVE_STATUS);
			}
			if (eDPLuLookUpInfoEntities != null && !eDPLuLookUpInfoEntities.isEmpty()) {
				eDPLuLookUpInfoEntities.forEach(entityInList -> {
					if (PvuConstant.CCC_EXAM.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuEmployeDetailsDto.setCccExamBody(courseConverter
								.toEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					} else if (PvuConstant.COURSE_NAME.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuEmployeDetailsDto.setCourse(courseConverter
								.toCourseEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					} else if (PvuConstant.SCHOOL_DEGREE.equalsIgnoreCase(entityInList.getLookUpInfoName())) {
						pvuEmployeDetailsDto.setSchoolDegree(courseConverter
								.toEDPSDTDto(courseRepository.findByCourseCategoryLookUpInfoIdAndActiveStatus(
										entityInList.getLookUpInfoId(), Constant.ACTIVE_STATUS)));
					}
				});
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return pvuEmployeDetailsDto;
	}

	/**
	 * Gets the lookup master data.
	 *
	 * @param pvuEmployeDetailsDto the pvu employe details dto
	 * @return the lookup master data
	 * @throws CustomException the custom exception
	 */
	@Deprecated
	private void getLookupMasterData(PVUEmployeDetailsDto pvuEmployeDetailsDto) throws CustomException {
		Set<String> statusNameList = new HashSet<>();
		statusNameList.add(EDPConstant.LK_STATUS_VAL_APPROVED);
		statusNameList.add(EDPConstant.LK_STATUS_VAL_ACTIVE);
		List<EDPLuLookUpInfoEntity> approveLookUpInfo = eDPLuLookUpInfoRepository
				.findByLookUpInfoNameIn(statusNameList);
		Set<Short> statusIdList = approveLookUpInfo.stream()
				.map(entity -> Short.valueOf(String.valueOf(entity.getLookUpInfoId()))).collect(Collectors.toSet());
		EDPLuLookUpInfoEntity yesInfoEntity = eDPLuLookUpInfoRepository
				.findByLookUpInfoName(EDPConstant.LOOKUP_NAME_YES);
		Long lookUpYesId = yesInfoEntity != null ? yesInfoEntity.getLookUpInfoId() : 0l;
		pvuEmployeDetailsDto.setLstLuLookUp(getAllLuLookUpInfoAsMap());
		pvuEmployeDetailsDto.setDesignation(designationConverter.toEDPSDTDto(designationRepository.findByActiveStatus(
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(EDPConstant.DESIGNATION_NAME, EDPConstant.ORDER_ASC))));
		pvuEmployeDetailsDto.setLstSDTData(edpMsStateService.getSDTData());
		pvuEmployeDetailsDto.setYearOfPassing(eDPMsFinancialYearConverter
				.toEDPSDTDto(eDPMsFinancialYearRepository.findByActiveStatus(Constant.ACTIVE_STATUS)).stream()
				.sorted(Comparator.comparing(EDPSDTDto::getName).reversed()).collect(Collectors.toList()));
		pvuEmployeDetailsDto.setAdministrativeDepartment(eDPMsDepartmentConverter
				.toEDPSDTDto(eDPMsDepartmentRepository.findByActiveStatus(Constant.ACTIVE_STATUS,
						EDPUtility.getJpaSort(EDPConstant.DEPARTMENT_NAME, EDPConstant.ORDER_ASC))));
		pvuEmployeDetailsDto.setHodDepartment(edpMsOfficeConverter.toEDPSDTDtos(
				edpMsOfficeRepository.findAllHodOffice(statusIdList, lookUpYesId, EDPConstant.ACTIVE_STATUS_TRUE)));
		pvuEmployeDetailsDto.setDeptCategory(pvuDeptCatConverter.toEDPSDTDtos(pvuDeptCatRepository.findByActiveStatus(
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(PvuConstant.DEPT_CATEGORY_NAME, EDPConstant.ORDER_ASC))));
		pvuEmployeDetailsDto.setBankIfsc(edpMsBankIfscConverter.toEDPSDTDto(edpMsBankIfscRepository.findByActiveStatus(
				Constant.ACTIVE_STATUS, EDPUtility.getJpaSort(PvuConstant.IFSC_CODE, EDPConstant.ORDER_ASC))));
	}

	/**
	 * Checks if is dublicate pan number.
	 *
	 * @param fieldValue the field value
	 * @return the PVU employee dtos
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean validatePanNumber(String fieldValue) throws CustomException {
		try {
			if (fieldValue != null) {
				EDPLuLookUpInfoEntity submitStatusId = eDPLuLookUpInfoRepository
						.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
								Constant.ACTIVE_STATUS, Constant.APPROVED);
				List<PVUEmployeEntity> pvuEmployeEntityList = repository
						.findByPanNoIgnoreCaseAndStatusIdLookUpInfoId(fieldValue, submitStatusId.getLookUpInfoId());
				if (pvuEmployeEntityList != null && !pvuEmployeEntityList.isEmpty()) {
					return Boolean.TRUE;
				}
			}
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return Boolean.FALSE;
	}

	/**
	 * Gets the pvu search fields.
	 *
	 * @return the pvu search fields
	 */
	@Override
	public List<PVUSearchEnum> getPvuSearchFields() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IS_SEARCH, PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_NAME, PVUSearchEnum.PVU_SEARCH_FIELD_CASE_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_START_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_END_DATE,
				PVUSearchEnum.PVU_SEARCH_FIELD_EMP_TYPE, PVUSearchEnum.PVU_SEARCH_FIELD_PPAN_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_GPF_NO, PVUSearchEnum.PVU_SEARCH_FIELD_CPF_NO,
				PVUSearchEnum.PVU_SEARCH_FIELD_CLASS_ID, PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_RETIREMENT_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_EMPLOYEE_PAY_TYPE,
				PVUSearchEnum.PVU_SEARCH_FIELD_OFFICE, PVUSearchEnum.PVU_SEARCH_FIELD_DESIGNATION,
				PVUSearchEnum.PVU_SEARCH_FIELD_EFFECTIVE_DATE, PVUSearchEnum.PVU_SEARCH_FIELD_POST_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_MENU_ID, PVUSearchEnum.PVU_SEARCH_FIELD_WF_ROLE_ID,
				PVUSearchEnum.PVU_SEARCH_FIELD_WF_STATUS, PVUSearchEnum.SEARCH_FIELD_IN_POU_ID);
	}

	/**
	 * Gets the common response by id.
	 *
	 * @param dto the dto
	 * @return the common response by id
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUCommonResponse getCommonResponseById(IdDto dto) throws CustomException {
		Optional<PVUEmployeEntity> find = this.repository.findById(dto.getId());
		return getCommonResponse(dto.getId(), find);
	}

	/**
	 * Gets the common response.
	 *
	 * @param employeeId the employee id
	 * @param find       the find
	 * @return the common response
	 * @throws CustomException the custom exception
	 */
	private PVUCommonResponse getCommonResponse(Long employeeId, Optional<PVUEmployeEntity> find)
			throws CustomException {
		if (find.isPresent()) {
			PVUCommonResponse response = new PVUCommonResponse();
			PVUEmployeEntity found = find.get();
			response.setEmpId(found.getEmpId());
			response.setEmployeeName(found.getEmployeeName());
			response.setEmployeeNo(found.getEmployeeCode());
			response.setSalutation(found.getSalutation() != null ? found.getSalutation().getLookUpInfoName() : ""); // PV-3355
			response.setMiddelName(found.getEmployeeMiddleName());
			response.setLastName(found.getEmployeeSurname());
			response.setGender(found.getGender() != null ? found.getGender().getLookUpInfoName() : null);
			response.setEmailId(found.getEmailID());
			response.setMobileNo(found.getMobileNo());
			response.setPanNo(found.getPanNo());
			response.setOfficeName(found.getOfficeId() != null ? found.getOfficeId().getOfficeName() : null);
			response.setCardexNo(found.getOfficeId() != null ? found.getOfficeId().getCardexno() : null);
			response.setDdoNo(found.getOfficeId() != null ? found.getOfficeId().getDdoNo() : null);
			response.setOfficeAddress(found.getOfficeId().getAddrLine1() != null
					? found.getOfficeId().getAddrLine1() + found.getOfficeId().getAddrLine2()
					: null);
			getEmpDeptResponse(employeeId, response);
			return response;
		}
		throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
	}

	/**
	 * Gets the emp by emp number.
	 *
	 * @param id the id
	 * @return the emp by emp number
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUCommonResponse getEmpByEmpNumber(Long id) throws CustomException {
		Optional<PVUEmployeEntity> employeeEntity = repository.findByEmployeeCodeAndActiveStatus(id,
				Constant.ACTIVE_STATUS);
		if (employeeEntity.isPresent()) {
			return getCommonResponse(employeeEntity.get().getEmpId(), employeeEntity);
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	/**
	 * Gets the DDL lu look up info as map. It will fetch data using cache
	 *
	 * @return the DDL lu look up info as map
	 * @throws CustomException the custom exception
	 */
	@Override
	@Cacheable(value = "ddlLuLookUpInfoAsMap")
	public Map<String, List<PVUEmployeCreationDDLView>> getDDLLuLookUpInfoAsMap() throws CustomException {
		Map<String, List<PVUEmployeCreationDDLView>> resultMap = null;
		String procName = new StringBuilder(Constant.PVU_SCHEMA).append(Constant.DOT)
				.append(PvuConstant.PVU_EMPLOYEE_SEARCH_LOOKUP).toString();
		List<PVUEmployeCreationDDLView> lstPVUEmployeCreationDDLView = this.lookupEmployeeCreationSp(procName);
		/**
		 * Below code is commented as designation will be fetched from separate API.
		 * List of designation will not be part of this api response payload. It is
		 * changed for performance improvement. lstPVUEmployeCreationDDLView
		 * .addAll(getActiveedpMsDesignation(edpMsDesignationService.findactiveedpMsDesignation()));
		 */
		resultMap = lstPVUEmployeCreationDDLView.stream()
				.collect(Collectors.groupingBy(PVUEmployeCreationDDLView::getLookupType));
		return resultMap;
	}

	/**
	 * Gets the office type by edp id.
	 *
	 * @param lookUpId the look up id
	 * @return the office type by edp id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVUEmployeCreationDDLView> getOfficeTypeByEdpId(Long lookUpId) throws CustomException {
		List<EDPLuLookUpInfoEntity> edpLuLookUpInfoEntitys = edpLuLookUpInfoService
				.findByEdpLuLookUpEntityLookUpIdAndActiveStatus(lookUpId);
		return edpLuLookUpInfoEntitys.stream().map(officType -> {
			PVUEmployeCreationDDLView lookUpInfo = new PVUEmployeCreationDDLView();
			lookUpInfo.setLookupInfoId(officType.getLookUpInfoId());
			lookUpInfo.setLookupInfoName(officType.getLookUpInfoName());
			return lookUpInfo;
		}).collect(Collectors.toList());
	}

	/**
	 * Update active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */

	@Override
	public void updateActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.empNomineeRepository.updateActiveStatusByNomineeId(id, activeStatus,
					OAuthUtility.getCurrentUserUserId(), new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Gets the duplicate pan no detail.
	 *
	 * @param fieldValue the field value
	 * @return the duplicate pan no detail
	 * @throws CustomException the custom exception
	 */
	@Override
	public PVUCommonResponse getDuplicatePanNoDetail(String fieldValue) throws CustomException {
		try {
			EDPLuLookUpInfoEntity submitStatusId = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			List<PVUEmployeEntity> pvuEmployeEntityList = repository
					.findByPanNoIgnoreCaseAndStatusIdLookUpInfoId(fieldValue, submitStatusId.getLookUpInfoId());
			if (!pvuEmployeEntityList.isEmpty()) {
				return getCommonResponse(pvuEmployeEntityList.get(0).getEmpId(),
						Optional.of(pvuEmployeEntityList.get(0)));
			}
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return null;
	}

	/**
	 * Gets the employee WF history by emp id.
	 *
	 * @param id the id
	 * @return the employee WF history by emp id
	 * @throws CustomException the custom exception
	 */
	@Override
	public List<PVUEmployeeWfHSTDto> getEmployeeWFHistoryByEmpId(Long id) throws CustomException {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT  WF.T_PVU_EMPCR_WF_ID  ,US.USER_NAME , POST.POST_NAME ,WF.CREATED_DATE ,  ").append(
				" WMW.WORKFLOW_NAME ,   WF.WF_STATUS ,WF.TRN_STATUS  , WF.REMARKS, OFC.OFFICE_NAME, DESGN.DESIGNATION_NAME, WFROLE.WF_ROLE_NAME ")
				.append(" FROM   ").append(Constant.PVU_SCHEMA).append(".T_PVU_EMPCR_WF WF   ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_USER US ON US.USER_ID = WF.ASSIGN_BY_USER_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_POST POST ON POST.POST_ID = WF.ASSIGN_BY_POST_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_MS_WORKFLOW wmw ON WMW.WORKFLOW_ID = WF.CURRENT_WORKFLOW_ID ").append(Constant.INNER_JOIN)
				.append(Constant.PVU_SCHEMA_MASTER).append(".MS_OFFICE OFC ON OFC.OFFICE_ID = WF.ASSIGN_BY_OFFICE_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".MS_DESIGNATION DESGN ON DESGN.DESIGNATION_ID = POST.DESIGNATION_ID ")
				.append(Constant.INNER_JOIN).append(Constant.PVU_SCHEMA_MASTER)
				.append(".WF_WORKFLOW_ROLE WFROLE ON WFROLE.WF_ROLE_ID = WF.ASSIGN_BY_WF_ROLE_ID ")
				.append(" WHERE WF.TRN_ID = :empId ORDER BY WF.CREATED_DATE DESC");
		HashMap<String, Object> objectMap = new HashMap<>();
		objectMap.put("empId", id);
		List<Object[]> objectPvuSp = repository.executeSQLQuery(sb.toString(), objectMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeWfHSTDto.class)
				: Collections.emptyList();
	}

	/**
	 * Insert employee itr.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */

	@Override
	public PVUCommonResponse insertEmployeeItr(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		PVUCommonResponse pvuCommonResponse = null;
		Optional<PVUEmployeEntity> find = repository.findById(pvuWFWrapperDto.getTrnId());
		if (find.isPresent() && !validatePanNumber(find.get().getPanNo()).equals(Boolean.TRUE)) {
			EDPLuLookUpInfoEntity empApprovStatsLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.APPROVED);
			if (find.get().getStatusId().getLookUpInfoId() != empApprovStatsLookupInfo.getLookUpInfoId()) {
				Boolean isReturn = pvuFacade.callWorkFlowApis(pvuWFWrapperDto);
				if (isReturn.equals(Boolean.TRUE)) {
					return validateAndApprovedEmployee(pvuWFWrapperDto);
				}
			} else {
				throw new CustomException(HttpStatus.CONFLICT,
						MessageFormat.format(MsgConstant.EMP_ALREADY_APPROVED, find.get().getEmployeeCode()));
			}
		} else {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.PVU_EMP_PANNO_ALREADY_EXIST, find.get().getPanNo()));
		}
		return pvuCommonResponse;
	}

	/**
	 * Gets the auto employee number.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the auto employee number
	 * @throws CustomException the custom exception
	 */
	@Override
	public Boolean getAutoEmployeeNumber(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
			Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_EMP_ID, pvuWFWrapperDto.getTrnId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.GENERATE_EMPLOYEE_NUMBER));
		repository.callStoredProcedure(procName, map);
		return Boolean.TRUE;
	}

	/**
	 * Execute workflow api.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the boolean
	 * @throws CustomException the custom exception
	 */
	public void insertEmpInITRs(final PvuWFWrapperDto pvuWFWrapperDto) throws CustomException {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_EMP_ID, pvuWFWrapperDto.getTrnId());
		map.put(Constant.IN_WORKFLOW_ID, pvuWFWrapperDto.getCurrentWorkflowId());
		map.put(Constant.IN_WF_ROLE_ID, pvuWFWrapperDto.getAssignToWfRoleId());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_EMPS_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	/**
	 * Gets the emp dept response.
	 *
	 * @param employeeId the employee id
	 * @param response   the response
	 * @return the emp dept response
	 */
	private void getEmpDeptResponse(Long employeeId, PVUCommonResponse response) {
		PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
				.findFirstByPvuEmployeEntityEmpId(employeeId);
		if (department != null) {
			response.setDateOfJoining(department.getDateOfJoiningGOG());
			response.setDesignationName(
					department.getDesignationId() != null ? department.getDesignationId().getDesignationName() : null);
			response.setDateOfRetirement(department.getDateOfRetirement());
			response.setClassName(
					department.getEmpClass() != null ? department.getEmpClass().getLookUpInfoName() : null);
			response.setDistrictName(
					department.getDistrictId() != null ? department.getDistrictId().getDistrictName() : null);
			response.setDistrictId(department.getDistrictId().getDistrictId());
			response.setStation(department.getStation());
			response.setTaluka(department.getTaluka() != null ? department.getTaluka().getTalukaName() : null);
			response.setPayLevelName(department.getPayCommissionJoiningTime() != null
					? department.getPayCommissionJoiningTime().getLookUpInfoName()
					: null);
			response.setParentDepartment(
					department.getParentHeadDept() != null ? department.getParentHeadDept().getDepartmentName() : null);
			response.setHeadOfDepartment(
					department.getHodName() != null ? department.getHodName().getOfficeName() : null);
		}
	}

	/**
	 * Validate and approved employee.
	 *
	 * @param pvuWFWrapperDto the pvu WF wrapper dto
	 * @return the PVU common response
	 * @throws CustomException the custom exception
	 */
	private PVUCommonResponse validateAndApprovedEmployee(final PvuWFWrapperDto pvuWFWrapperDto)
			throws CustomException {
		EDPLuLookUpInfoEntity empSubmitStatusLookupInfo = eDPLuLookUpInfoRepository
				.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
						Constant.ACTIVE_STATUS, Constant.SUBMIT);
		if (empSubmitStatusLookupInfo != null) {
			repository.updateStatusIdForPVUEmployeEntity(empSubmitStatusLookupInfo.getLookUpInfoId(),
					pvuWFWrapperDto.getTrnId());
		}
		if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.APPROVED)) {
			getAutoEmployeeNumber(pvuWFWrapperDto);
		} else if (pvuWFWrapperDto.getWfStatus().equalsIgnoreCase(Constant.REJECTED)) {
			EDPLuLookUpInfoEntity empRejectStatusLookupInfo = eDPLuLookUpInfoRepository
					.findByEdpLuLookUpEntityLookUpNameAndActiveStatusAndLookUpInfoName(Constant.STATUS_ID,
							Constant.ACTIVE_STATUS, Constant.REJECTED);
			repository.updateStatusIdForPVUEmployeEntity(empRejectStatusLookupInfo.getLookUpInfoId(),
					pvuWFWrapperDto.getTrnId());
		}
		insertEmpInITRs(pvuWFWrapperDto);
		repository.flush();
		Optional<PVUEmployeEntity> employeeEntity = repository.findByEmpIdAndActiveStatus(pvuWFWrapperDto.getTrnId(),
				Constant.ACTIVE_STATUS);
		return getCommonResponse(pvuWFWrapperDto.getTrnId(), employeeEntity);
	}

	/**
	 * Update active status by emp id.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 */
	@Override
	public void updateActiveStatusByEmpId(Long id, int activeStatus) {
		Optional<PVUEmployeEntity> pvuEmployeEntity = repository.findByEmpIdAndActiveStatus(id,
				Constant.ACTIVE_STATUS);
		repository.updateActiveStatusByEmpId(id, activeStatus, OAuthUtility.getCurrentUserUserId(), new Date());
		expressEmployeecheckStatus(pvuEmployeEntity);
	}

	private void expressEmployeecheckStatus(Optional<PVUEmployeEntity> pvuEmployeEntity) {
		if(pvuEmployeEntity.isPresent() && pvuEmployeEntity.get().getEmployeeCode() != null && pvuEmployeEntity.get().getEmployeeCode() != 0
		){
			pvuEmployeEntity.get().setEmpSrcType(1);
			pvuEmployeEntity.get().setActiveStatus(1);
			pvuEmployeEntity.get().setStatusId(new EDPLuLookUpInfoEntity(327));
			repository.save(pvuEmployeEntity.get());
		}
	}

	/**
	 * Gets the employee photo by emp id.
	 *
	 * @param id the id
	 * @return the employee photo by emp id
	 */
	@Override
	public void deleteEmployeePhotoByEmpId(Long id) {
		Optional<PVUEmployeEntity> employeeEntity = repository.findByEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
		if (employeeEntity.isPresent() && !StringUtils.isBlank(employeeEntity.get().getEmployeePhoto())) {
			employeeEntity.get().setEmployeePhotoName(null);
			employeeEntity.get().setEmployeePhoto(null);
			repository.save(employeeEntity.get());
		}
	}

	/**
	 * Gets the employee nominee photos by nominee id.
	 *
	 * @param fieldValue the field value
	 * @return the employee nominee photos by nominee id
	 * @throws CustomException the custom exception
	 * @throws IOException     Signals that an I/O exception has occurred.
	 */
	@Override
	public ClueDto getAttachments(String fieldValue) throws CustomException, IOException {
		if (!StringUtils.isBlank(fieldValue)) {
			Id docId = new Id(fieldValue);
			final Document document = FilenetUtility.retrieveDocument(docId);
			String base64String = EDPUtility.convertFilenetDocumentIntoBase64String(document.accessContentStream(0));
			ClueDto dto = new ClueDto();
			dto.setImage(base64String);
			return dto;
		}
		throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
	}

	/**
	 * Delete nominee attachements by nominee id.
	 *
	 * @param pvuCommonRequest the pvu common request
	 */
	@Override
	public void deleteNomineeAttachementsByNomineeId(PvuCommonRequest pvuCommonRequest) {
		Optional<PVUEmployeNomineeEntity> nomineeEntity = Optional.empty();
		if (!pvuCommonRequest.getRequest().isEmpty()) {
			Map<String, Long> nomineeData = pvuCommonRequest.getRequest();
			nomineeEntity = deleteNomineeAttachment(nomineeEntity, nomineeData);
			if (nomineeEntity.isPresent()) {
				empNomineeRepository.save(nomineeEntity.get());
			}
		}
	}

	/**
	 * Delete nominee attachment.
	 *
	 * @param nomineeEntity the nominee entity
	 * @param nomineeData   the nominee data
	 * @return the optional
	 */
	private Optional<PVUEmployeNomineeEntity> deleteNomineeAttachment(Optional<PVUEmployeNomineeEntity> nomineeEntity,
			Map<String, Long> nomineeData) {
		if (nomineeData.get(PvuConstant.PHOTO) != null) {
			nomineeEntity = getNomineeEntity(nomineeData.get(PvuConstant.PHOTO));
			if (nomineeEntity.isPresent()) {
				nomineeEntity.get().setNomineePhotoName(null);
				nomineeEntity.get().setNomineePhoto(null);
			}
		} else if (nomineeData.get(PvuConstant.GEN) != null) {
			nomineeEntity = getNomineeEntity(nomineeData.get(PvuConstant.GEN));
			if (nomineeEntity.isPresent()) {
				nomineeEntity.get().setGenNomineeFormName(null);
				nomineeEntity.get().setGenNomineePhoto(null);
			}
		} else if (nomineeData.get(PvuConstant.NPS) != null) {
			nomineeEntity = getNomineeEntity(nomineeData.get(PvuConstant.NPS));
			if (nomineeEntity.isPresent()) {
				nomineeEntity.get().setNpsNomineePhoto(null);
				nomineeEntity.get().setNpsNomineeFormName(null);
			}
		}
		return nomineeEntity;
	}

	/**
	 * Gets the nominee entity.
	 *
	 * @param id the id
	 * @return the nominee entity
	 */
	private Optional<PVUEmployeNomineeEntity> getNomineeEntity(Long id) {
		return empNomineeRepository.findOneByEmpNomineeIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
	}

	@Override
	public PVUCommonResponse getEmpByEmpNo(SearchDto dto) throws CustomException {
		Optional<PVUEmployeEntity> employeeEntity = repository.findByEmployeeCodeAndActiveStatus(dto.getId(),
				Constant.ACTIVE_STATUS);
		if (Boolean.TRUE.equals(dto.getTransfer()) && !employeeEntity.get().getOfficeId().getOfficeId()
				.equals(OAuthUtility.getCurrentUserOfficeOauthToken().getOfficeId())) {
			throw new CustomException(HttpStatus.CONFLICT,
					MessageFormat.format(MsgConstant.ERROR_EMPLOYEE_NOT_IN_OFFICE, dto.getId().toString()));
		}

		if (employeeEntity.isPresent()) {
			PVUEmployeDepartmentEntity department = this.pvuEmployeDepartmentRepository
					.findFirstByPvuEmployeEntityEmpId(employeeEntity.get().getEmpId());

			if (null != department && (department.getEmpPayType().getLookUpInfoId() == PvuConstant.CONTRACT
					|| department.getEmpPayType().getLookUpInfoId() == PvuConstant.RE_APPOINTED)) {
				throw new CustomException(HttpStatus.CONFLICT, MsgConstant.TRANSFER_NOT_ALLOWED);

			}
			PVUCommonResponse commonResponse = getCommonResponse(employeeEntity.get().getEmpId(), employeeEntity);
			if (commonResponse.getSubOfficeName() == null || commonResponse.getSubOfficeName().equals("")) {
				commonResponse.setSubOfficeName("NA");
			}
			return commonResponse;
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
	}

	@Override
	public Map<String, Object> getEmployeeApproverNameAndDesignation(Long id) throws CustomException {
		Map<String, Object> map = new HashMap<>();
		map.put("trnId", id);
		List<Object[]> objects = repository
				.executeSQLQuery(PVUNativeSqlQueryConstant.getEmployeeApproverNameAndDesignation(), map);
		Map<String, Object> response = new HashMap<>();
		if (!objects.isEmpty()) {
			response.put("APPROVER_DESIGNATION", String.valueOf(objects.get(0)[1]));
			response.put("APPROVER_NAME", String.valueOf(objects.get(0)[0]));
		} else {
			throw new CustomException(ErrorResponse.RECORD_NOT_FOUND);
		}
		return response;
	}

	public List<PVUSearchEnum> getPvuSearchFields1() {
		return Arrays.asList(PVUSearchEnum.PVU_SEARCH_FIELD_IN_DEPTID, PVUSearchEnum.PVU_SEARCH_FIELD_PAYBANDID,
				PVUSearchEnum.PVU_SEARCH_FIELD_IN_GRADEPAYID);
	}

	private Map<String, Object> buildPageInEntryPayEmp(PageDetails pageDetail, List<PVUSearchEnum> lstSearchEum) {
		Map<String, String> collect = lstSearchEum.stream()
				.collect(Collectors.toMap(PVUSearchEnum::getKey, PVUSearchEnum::getValue));
		List<SearchParam> searchParams = pageDetail.getJsonArr();

		Map<String, Object> map = new LinkedHashMap<>();
		if (!Utils.isEmpty(searchParams)) {
			Map<String, Object> map1 = SearchParam.getMap(searchParams, collect);
			map.putAll(map1);

		} else {
			Map<String, Object> map1 = SearchParam.getDefaultMap(collect);
			map.putAll(map1);
		}
		return map;
	}

	@Override
	public Long getEntryPaySearchEmployes(PageDetails pageDetail) throws CustomException {
		Long status = null;
		try {
			Map<String, Object> map = buildPageInEntryPayEmp(pageDetail, getPvuSearchFields1());

			status = repository
					.callSPLong(Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.ENTRY_6_TH_PAY_COMM)), map);
		} catch (NoResultException nre) {
			logger.error(nre.toString(), nre);
		} catch (Exception ex) {
			logger.error(ex.toString(), ex);
		}
		return status;
	}

	public PVUEmployeeUpdateDtos editabelEmploye(PVUEmpDeptQualifiUpdate dto, EmployeeChangeType type)
			throws CustomException {
		PVUEmployeeUpdateDtos dtos = new PVUEmployeeUpdateDtos();
		if (dto.getPvuEmployeDto().getEmpId() == 0) {
			throw new CustomException(404, "Employee is not exit");
		}
		try {
			Optional<PVUEmployeEntity> pvuEmployeEntity = repository
					.findByEmpIdAndActiveStatus(dto.getPvuEmployeDto().getEmpId(), Constant.ACTIVE_STATUS);
			if (!pvuEmployeEntity.isPresent()) {
				throw new CustomException(404, "Employee no found");
			}
			PVUEmployeEntity entity = pvuEmployeEntity.get();
			if (PvuUtils.getChangeType(dto.getPvuEmployeDto().getChangeType())) {
				repository.save(converter.toUpdateEntity(pvuEmployeEntity.get(), dto.getPvuEmployeDto()));
				type.setEmptype(dto.getPvuEmployeDto().getChangeType());
			}
			extractedAttachmentOfEmployee(dto, entity);
			PVUEmployeAddressEntity pvuEmployeAddEntity = null;
			if (dto.getPvuEmployeAddressDto() != null
					&& PvuUtils.getChangeType(dto.getPvuEmployeAddressDto().getChangeType())
					&& dto.getPvuEmployeAddressDto().getEmpAddressId() != 0) {
				pvuEmployeAddEntity = employeAddressRepository
						.findPVUEmployeAddressEntityBypvuEmployeEntityEmpIdAndActiveStatus(
								dto.getPvuEmployeDto().getEmpId(), Constant.ACTIVE_STATUS);
				dto.getPvuEmployeAddressDto().setEmpId(entity.getEmpId());
				empAddConverter.setEditFiledEntityById(dto.getPvuEmployeAddressDto(), pvuEmployeAddEntity);
				employeAddressRepository.save(pvuEmployeAddEntity);
				type.setEmpAddtype(dto.getPvuEmployeAddressDto().getChangeType());
			}
			if (dto.getPvuEmployeNomineeDto() != null) {
				dto.getPvuEmployeNomineeDto().forEach(nomineeDto -> nomineeDto.setEmpId(entity.getEmpId()));
				for (PVUEmployeNomineeDto nom : dto.getPvuEmployeNomineeDto()) {
					if (nom != null) {
						if (nom.getEmpNomineeId() != 0) {
							extracNomeeniDetails(type, nom);
						}
						if (nom.getChangeType() == 2) { // new nominee create
							type.setEmpNomitype(nom.getChangeType());
							PVUEmployeNomineeEntity ent = new PVUEmployeNomineeEntity();
							nomineeEntityValidateAndSave(nom, ent);
						}

					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return dtos;
	}

	private void extractedAttachmentOfEmployee(PVUEmpDeptQualifiUpdate dto, PVUEmployeEntity entity)
			throws CustomException {
		if (dto.getPvuEmployeDto().getPhotoAttachment() != null
				&& dto.getPvuEmployeDto().getPhotoAttachment().get(0) != null
				&& dto.getPvuEmployeDto().getPhotoAttachment().get(0).getMenuId() != null) {
			if (dto.getPvuEmployeDto().getPhotoAttachment().get(0).getAttachment() != null
					&& !dto.getPvuEmployeDto().getPhotoAttachment().get(0).getAttachment().isEmpty()) {
				dto.getPvuEmployeDto().getPhotoAttachment()
						.forEach(photoDto -> photoDto.setTransactionId(entity.getEmpId()));
				List<FileUploadResponseDto> uploadAttachment = attachmentService
						.createPostAttachment(dto.getPvuEmployeDto().getPhotoAttachment().get(0));
				if (uploadAttachment != null && !uploadAttachment.isEmpty()) {
					entity.setEmployeePhoto(uploadAttachment.get(0).getDocumentId());
					entity.setEmployeePhotoName(uploadAttachment.get(0).getFilename());
				}

			} else if (dto.getPvuEmployeDto().getPhotoAttachment().get(0).getChangeType() == 3) {
				entity.setEmployeePhoto("");
				entity.setEmployeePhotoName("");
			}
		}
	}

	private void extracNomeeniDetails(EmployeeChangeType type, PVUEmployeNomineeDto nom) {
		Optional<PVUEmployeNomineeEntity> entOption = this.getNomineeEntity(nom.getEmpNomineeId());
		if ((entOption.isPresent() && nom.getChangeType() == 0) && ((nom.getGenNomineePhotoAttachment() != null
				&& nom.getGenNomineePhotoAttachment().getChangeType() > 0)
				|| (nom.getNomineePhotoAttachment() != null && nom.getNomineePhotoAttachment().getChangeType() > 0)
				|| (nom.getNpsNomineePhotoAttachment() != null
						&& nom.getNpsNomineePhotoAttachment().getChangeType() > 0))) {
			type.setEmpNomitype(type.getEmpconstant());
			nomineeEntityValidateAndSave(nom, entOption.get());
		}
		if (entOption.isPresent() && nom.getChangeType() == 1) {
			type.setEmpNomitype(nom.getChangeType());
			nomineeEntityValidateAndSave(nom, entOption.get());
		}
		if (entOption.isPresent() && nom.getChangeType() == 3) {
			type.setEmpNomitype(nom.getChangeType());
			PVUEmployeNomineeEntity ent = entOption.get();
			ent.setActiveStatus(Constant.IN_ACTIVE_STATUS);
			ent.setChangeType(nom.getChangeType());
			empNomineeRepository.save(ent);
		}
	}

	private void nomineeEntityValidateAndSave(PVUEmployeNomineeDto nom, PVUEmployeNomineeEntity ent) {
		empNomineeConverter.toEntityUpdate(ent, nom);
		validateAndSetNomineeDetailsForEditEmployee(nom, ent);
		empNomineeRepository.save(ent);
	}

	@Override
	public Boolean employeUpdateAllfiled(PVUEmpDeptQualifiUpdate dto) throws CustomException {
		boolean status = true;
		EmployeeChangeType type = new EmployeeChangeType();
		type.setEmpRole(dto.getRoleId());
		editabelEmploye(dto, type);
		type.setEmpId(dto.getPvuEmployeDto().getEmpId());
		pvuEmployeQualificationService.editEmployeQualification(dto.getQualificationDto(), type);
		pvuEmployeDepartmentService.editEmployeeDepartment(dto.getDepartmentDto(), type);
		try {
			insertPVUEmpDeptQualifiUpdateITRs(type);
		} catch (Exception e) {
		}
		return status;
	}

	public void insertPVUEmpDeptQualifiUpdateITRs(EmployeeChangeType type) {
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_EMP_ID, type.getEmpId());
		map.put(Constant.IN_WORKFLOW_ID, type.getEmpWorkFlow());
		map.put(PvuConstant.IN_ROLE_ID, type.getEmpRole());
		map.put(PvuConstant.TYPE_EMP, type.getEmptype());
		map.put(PvuConstant.TYPE_EMP_ADDR, type.getEmpAddtype());
		map.put(PvuConstant.TYPE_EMP_NOMI, type.getEmpNomitype());
		map.put(PvuConstant.TYPE_EMP_QUALI, type.getEmpQualitype());
		map.put(PvuConstant.TYPE_EMP_PRV_HIST, type.getEmpHis());
		map.put(PvuConstant.TYPE_EMP_DPT_DTL, type.getEmpDpttype());
		map.put(PvuConstant.TYPE_EMP_LANG, type.getEmpLangtype());
		map.put(PvuConstant.TYPE_EMP_CCCEXM, type.getEmpccetype());
		map.put(PvuConstant.TYPE_DPTEXM_DTL, type.getEmpDptDtltype());
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.INSERT_IN_APPROVED_EMPS_ITRS));
		repository.callStoredProcedure(procName, map);
	}

	@Override
	public List<PVUEmployeUpdateDto> getHistoryOfEmpDetailsByItrTabel(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpDetails(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeUpdateDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<PVUEmployeNomineeUpdateDto> getHistoryOfEmpNominiByEmpId(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpNominiByEmpId(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeNomineeUpdateDto.class)
				: Collections.emptyList();
	}

	@Override
	public List<PVUEmployeAddressUpdateDto> getHistoryOfEmpAddressByEmpId(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpAddressByEmpId(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeAddressUpdateDto.class)
				: Collections.emptyList();
	}

	public List<PVUPairView> getOfficeNameByOfficeType(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getOfficeNameByOfficeType(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUPairView.class)
				: Collections.emptyList();
	}

	public void validateAndSetNomineeDetailsForEditEmployee(PVUEmployeNomineeDto nom, PVUEmployeNomineeEntity ent) {
		if (nom.getGenNomineePhotoAttachment() != null && nom.getGenNomineePhotoAttachment().getChangeType() == 3) {
			ent.setGenNomineePhoto("");
			ent.setGenNomineeFormName("");
		} else if (nom.getGenNomineePhotoAttachment() != null) {
			validateAndSetNomineeDetails(nom, ent);
		}
		if (nom.getNomineePhotoAttachment() != null && nom.getNomineePhotoAttachment().getChangeType() == 3) {
			ent.setNomineePhoto("");
			ent.setNomineePhotoName("");
		} else if (nom.getNomineePhotoAttachment() != null) {
			validateAndSetNomineeDetails(nom, ent);
		}
		if (nom.getNpsNomineePhotoAttachment() != null && nom.getNpsNomineePhotoAttachment().getChangeType() == 3) {
			ent.setNpsNomineePhoto("");
			ent.setNpsNomineeFormName("");
		} else if (nom.getNpsNomineePhotoAttachment() != null) {
			validateAndSetNomineeDetails(nom, ent);
		}
	}

}
