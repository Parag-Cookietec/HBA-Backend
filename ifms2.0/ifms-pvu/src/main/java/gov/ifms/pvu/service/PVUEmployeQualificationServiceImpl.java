package gov.ifms.pvu.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ibm.db2.jcc.am.ad;

import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.pvu.converter.PVUEmployeCCCExamDetailConverter;
import gov.ifms.pvu.converter.PVUEmployeDeptExamDetailsConverter;
import gov.ifms.pvu.converter.PVUEmployeLangExamConverter;
import gov.ifms.pvu.converter.PVUEmployeQualificationConverter;
import gov.ifms.pvu.dto.EmployeeChangeType;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailEditableDto;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailView;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsEditableDto;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsView;
import gov.ifms.pvu.dto.PVUEmployeLangExamEditableDto;
import gov.ifms.pvu.dto.PVUEmployeLangExamView;
import gov.ifms.pvu.dto.PVUEmployeNomineeUpdateDto;
import gov.ifms.pvu.dto.PVUEmployeQualificationDto;
import gov.ifms.pvu.dto.PVUEmployeQualificationView;
import gov.ifms.pvu.dto.PVUEmployeeQualificationDtos;
import gov.ifms.pvu.dto.PVUEmployeeQualificationUpdateDtos;
import gov.ifms.pvu.dto.PVUEmployeeSqlQueries;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.repository.PVUEmployeCCCExamDetailRepository;
import gov.ifms.pvu.repository.PVUEmployeDeptExamDetailsRepository;
import gov.ifms.pvu.repository.PVUEmployeLangExamRepository;
import gov.ifms.pvu.repository.PVUEmployeQualificationRepository;
import gov.ifms.pvu.util.PvuConstant;
import gov.ifms.pvu.util.PvuUtils;

/**
 * The Class PVUEmployeQualificationServiceImpl.
 *
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 */
@Service
public class PVUEmployeQualificationServiceImpl implements PVUEmployeQualificationService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	/**
	 * The PVUEmployeQualificationAsMethodName repository.
	 */
	@Autowired
	private PVUEmployeQualificationRepository repository;

	/**
	 * The PVUEmployeQualificationAsMethodName repository.
	 */
	@Autowired
	private EDPLuLookUpInfoRepository luLookUpInfoRepository;

	/**
	 * The dept exam details repository.
	 */
	@Autowired
	private PVUEmployeDeptExamDetailsRepository deptExamDetailsRepository;

	/**
	 * The ccc exam detail repository.
	 */
	@Autowired
	private PVUEmployeCCCExamDetailRepository cccExamDetailRepository;

	/**
	 * The lang exam repository.
	 */
	@Autowired
	private PVUEmployeLangExamRepository langExamRepository;

	/**
	 * The PVUEmployeQualificationAsMethodName helper.
	 */
	@Autowired
	private PVUEmployeQualificationConverter converter;

	/**
	 * The dept exam details converter.
	 */
	@Autowired
	private PVUEmployeDeptExamDetailsConverter deptExamDetailsConverter;

	/**
	 * The ccc exam detail converter.
	 */
	@Autowired
	private PVUEmployeCCCExamDetailConverter cccExamDetailConverter;

	/**
	 * The lang exam converter.
	 */
	@Autowired
	private PVUEmployeLangExamConverter langExamConverter;

	/**
	 * Retrieves an PVUEmployeQualificationEntity by its id.
	 *
	 * @param id must not be {@literal null}.
	 * @return the PVUEmployeQualificationEntity with the given id or
	 *         {@literal null} if none found
	 * @throws IllegalArgumentException if {@code id} is {@literal null}
	 */
	@Override
	public PVUEmployeQualificationEntity getEmployeQualification(Long id) {
		return repository.getOne(id);
	}

	/**
	 * Saves a given PVUEmployeQualificationEntity. Use the returned instance for
	 * further operations as the save operation might have changed the entity
	 * instance completely.
	 *
	 * @param dto the dto
	 * @return the saved PVUEmployeQualificationEntity
	 * @throws CustomException the custom exception
	 */
	@Override
	@ExceptionHandler
	public PVUEmployeeQualificationDtos saveOrUpdateEmployeQualification(PVUEmployeeQualificationDtos dto)
			throws CustomException {
		PVUEmployeeQualificationDtos allQualExamDtos = new PVUEmployeeQualificationDtos();
		try {
			EDPLuLookUpInfoEntity exemptedStatusId = this.luLookUpInfoRepository
					.findByLookUpInfoName(PvuConstant.CONSTANT_EXEMPTED);
			EDPLuLookUpInfoEntity nonExempted = this.luLookUpInfoRepository.findBylookUpInfoId(PvuConstant.CONSTANT_PASS_ID);
			List<PVUEmployeQualificationEntity> employeQualificationEntity = this.repository
					.saveAll(converter.toEntity(dto.getPvuEmployeQualificationDto()));
			allQualExamDtos.setPvuEmployeQualificationDto(converter.toDTO(employeQualificationEntity));
			List<PVUEmployeLangExamEntity> langExamEntity = this.langExamRepository
					.saveAll(langExamConverter.toEntity(dto.getPvuEmployeLangExamDto()));
			allQualExamDtos.setPvuEmployeLangExamDto(langExamConverter.toDTO(langExamEntity));
			PVUEmployeEntity employeEntity = !employeQualificationEntity.isEmpty()
					? employeQualificationEntity.get(0).getPvuEmployeEntity()
					: null;
			if (employeEntity != null) {
				setPVUEmployeDeptExamDetail(dto, allQualExamDtos, exemptedStatusId, nonExempted, employeEntity);
				setPVUEmployeCCCExamDetail(dto, allQualExamDtos, exemptedStatusId, nonExempted, employeEntity);
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return allQualExamDtos;
	}

	/**
	 * Gets the employe qualification by emp id.
	 *
	 * @param id the id
	 * @return the employe qualification by emp id
	 * @throws CustomException
	 */
	@Override
	public PVUEmployeeQualificationDtos getEmployeQualificationByEmpId(Long id) throws CustomException {
		PVUEmployeeQualificationDtos allQualExamDtos = new PVUEmployeeQualificationDtos();
		try {
			List<PVUEmployeQualificationEntity> employeQualificationEntity = repository
					.findPVUEmployeQualificationEntityBypvuEmployeEntityEmpIdAndActiveStatus(id,
							Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(employeQualificationEntity)) {
				allQualExamDtos.setPvuEmployeQualificationDto(converter.toDTO(employeQualificationEntity));
			}
			List<PVUEmployeDeptExamDetailsEntity> pvuEmployeDeptExamDetailsEntities = deptExamDetailsRepository
					.findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(id,
							Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(pvuEmployeDeptExamDetailsEntities)) {
				if ((pvuEmployeDeptExamDetailsEntities.get(0) != null)
						&& (pvuEmployeDeptExamDetailsEntities.get(0).getExamStatus() != null)
						&& (pvuEmployeDeptExamDetailsEntities.get(0).getExamStatus().getLookUpInfoName()
								.equalsIgnoreCase(PvuConstant.CONSTANT_EXEMPTED)) &&
						(pvuEmployeDeptExamDetailsEntities.get(0).getDeptExamName() == null
								|| pvuEmployeDeptExamDetailsEntities.get(0).getDeptExamName().isEmpty())) {
					allQualExamDtos.setExemptedDeptExam(
							deptExamDetailsConverter.toDTO(pvuEmployeDeptExamDetailsEntities.get(0)));
					allQualExamDtos.setExemptedDeptExamFlag(true);
				} else {
					allQualExamDtos.setPvuEmployeDeptExamDetailsDto(
							deptExamDetailsConverter.toDTO(pvuEmployeDeptExamDetailsEntities));
					allQualExamDtos.setExemptedDeptExamFlag(false);
				}
			}
			List<PVUEmployeCCCExamDetailEntity> pvuEmployeCCCExamDetailEntities = cccExamDetailRepository
					.findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(id,
							Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(pvuEmployeCCCExamDetailEntities)) {
				if ((pvuEmployeCCCExamDetailEntities.get(0) != null)
						&& (pvuEmployeCCCExamDetailEntities.get(0).getExamStatus() != null)
						&& (pvuEmployeCCCExamDetailEntities.get(0).getExamStatus().getLookUpInfoName()
								.equalsIgnoreCase(PvuConstant.CONSTANT_EXEMPTED))  && (pvuEmployeCCCExamDetailEntities.get(0).getCccExamName() == null)) {
					allQualExamDtos
							.setExemptedCccExam(cccExamDetailConverter.toDTO(pvuEmployeCCCExamDetailEntities.get(0)));
					allQualExamDtos.setExemptedCccExamFlag(true);
				} else {
					allQualExamDtos.setPvuEmployeCCCExamDetailDto(
							cccExamDetailConverter.toDTO(pvuEmployeCCCExamDetailEntities));
					allQualExamDtos.setExemptedCccExamFlag(false);
				}
			}
			List<PVUEmployeLangExamEntity> pvuEmployeLangExamEntities = langExamRepository
					.findPVUEmployeLangExamEntityBypvuEmployeEntityEmpIdAndActiveStatus(id, Constant.ACTIVE_STATUS);
			if (!CollectionUtils.isEmpty(pvuEmployeLangExamEntities)) {
				allQualExamDtos.setPvuEmployeLangExamDto(langExamConverter.toDTO(pvuEmployeLangExamEntities));
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return allQualExamDtos;
	}

	/**
	 * Update qualification active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateQualificationActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.repository.updateActiveStatusByQualificationId(id, activeStatus, OAuthUtility.getCurrentUserUserId(),
					new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Update dept exam active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateDeptExamActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.deptExamDetailsRepository.updateActiveStatusByEmpDeptExamDetailId(id, activeStatus,
					OAuthUtility.getCurrentUserUserId(), new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Update ccc exam active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateCccExamActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.cccExamDetailRepository.updateActiveStatusByEmpCCCExamDetailId(id, activeStatus,
					OAuthUtility.getCurrentUserUserId(), new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Update lang exam active status.
	 *
	 * @param id           the id
	 * @param activeStatus the active status
	 * @throws CustomException the custom exception
	 */
	@Override
	public void updateLangExamActiveStatus(Long id, int activeStatus) throws CustomException {
		try {
			this.langExamRepository.updateActiveStatusByempLangExamId(id, activeStatus,
					OAuthUtility.getCurrentUserUserId(), new Date());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_UPDATE_ACTIVESTATUS);
		}
	}

	/**
	 * Sets the PVU employe CCC exam detail.
	 *
	 * @param dto              the dto
	 * @param allQualExamDtos  the all qual exam dtos
	 * @param exemptedStatusId the exempted status id
	 * @param nonExempted      the non exempted
	 * @param employeEntity    the employe entity
	 */
	public void setPVUEmployeCCCExamDetail(PVUEmployeeQualificationDtos dto,
			PVUEmployeeQualificationDtos allQualExamDtos, EDPLuLookUpInfoEntity exemptedStatusId,
			EDPLuLookUpInfoEntity nonExempted, PVUEmployeEntity employeEntity) {
		if (dto.isExemptedCccExamFlag()) {
			PVUEmployeCCCExamDetailEntity exemptedDeptExam = null;
			if(dto.getExemptedCccExam() != null){
				 exemptedDeptExam = cccExamDetailConverter.toEntity(dto.getExemptedCccExam());
			}
			allQualExamDtos.setExemptedCccExamFlag(dto.isExemptedCccExamFlag());
			if (exemptedDeptExam != null) {
				exemptedDeptExam.setExamStatus(exemptedStatusId);
				cccExamDetailRepository.save(exemptedDeptExam);
				allQualExamDtos.setExemptedCccExam(cccExamDetailConverter.toDTO(exemptedDeptExam));
				cccExamDetailRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
						employeEntity.getEmpId(), Collections.singletonList(exemptedDeptExam.getEmpCCCExamDetailId()));
			}
		} else if (!dto.isExemptedCccExamFlag()) {
			List<PVUEmployeCCCExamDetailEntity> normDeptExams = cccExamDetailConverter
					.toEntity(dto.getPvuEmployeCCCExamDetailDto());
			normDeptExams.forEach(e -> e.setExamStatus(nonExempted));
			cccExamDetailRepository.saveAll(normDeptExams);
			if ((!CollectionUtils.isEmpty(normDeptExams))) {
				List<Long> notIn = normDeptExams.stream().map(PVUEmployeCCCExamDetailEntity::getEmpCCCExamDetailId)
						.collect(Collectors.toList());
				cccExamDetailRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
						employeEntity.getEmpId(), notIn);
			}
			allQualExamDtos.setExemptedCccExamFlag(dto.isExemptedCccExamFlag());
			allQualExamDtos.setPvuEmployeCCCExamDetailDto(cccExamDetailConverter.toDTO(normDeptExams));
		}
	}

	/**
	 * Sets the PVU employe CCC exam detail.
	 *
	 * @param dto              the dto
	 * @param allQualExamDtos  the all qual exam dtos
	 * @param exemptedStatusId the exempted status id
	 */
	public void setPVUEmployeCCCExamDetailEdit(PVUEmployeeQualificationUpdateDtos dto,
			PVUEmployeeQualificationUpdateDtos allQualExamDtos, EDPLuLookUpInfoEntity exemptedStatusId,
			EmployeeChangeType type) {
		if (dto.isExemptedCccExamFlag() && dto.getExemptedCccExam() != null) {
			PVUEmployeCCCExamDetailEntity exemptedDeptExam = cccExamDetailConverter.toEditableEntity(dto.getExemptedCccExam());
			allQualExamDtos.setExemptedCccExamFlag(dto.isExemptedCccExamFlag());
			if (exemptedDeptExam != null) {
				cccExamDetailRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
						dto.getExemptedCccExam().getEmpId(), Collections.singletonList(exemptedDeptExam.getEmpCCCExamDetailId()));
				type.setEmpccetype(exemptedDeptExam.getChangeType());
				exemptedDeptExam.setExamStatus(exemptedStatusId);
				List<PVUEmployeCCCExamDetailEntity>  list = cccExamDetailRepository.
						findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(dto.getExemptedCccExam().getEmpId(), Constant.ACTIVE_STATUS);
				list.add(exemptedDeptExam);
				cccExamDetailRepository.saveAll(list);
				allQualExamDtos.setExemptedCccExam(cccExamDetailConverter.toEditableDTO(exemptedDeptExam));
			}
		} else if (!dto.isExemptedCccExamFlag()) {
			List<PVUEmployeCCCExamDetailEntity>  normcccExams = alreadyRecordSetUnActiveStatu(dto);
			dto.getPvuEmployeCCCExamDetailDto().stream().filter(obj -> PvuUtils.getChangeType(obj.getChangeType()))
					.forEach(ccOb -> normcccExams.add(cccExamDetailConverter.toEditableEntity(ccOb)));
			if(!normcccExams.isEmpty()){
				type.setEmpccetype(dto.getPvuEmployeCCCExamDetailDto().get(0).getChangeType());
				cccExamDetailRepository.saveAll(normcccExams);

			}
		}
	}

	private List<PVUEmployeCCCExamDetailEntity> alreadyRecordSetUnActiveStatu(PVUEmployeeQualificationUpdateDtos dto) {
		List<PVUEmployeCCCExamDetailEntity>  list = null;
		if(dto.getPvuEmployeCCCExamDetailDto() != null && dto.getPvuEmployeCCCExamDetailDto().get(0) != null){
		  list = cccExamDetailRepository.
					findPVUEmployeCCCExamDetailEntityBypvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmployeCCCExamDetailDto().get(0).getEmpId(), Constant.ACTIVE_STATUS);
		}
		if(!list.isEmpty()){
			list.stream().filter(e -> e.getExamStatus().getLookUpInfoId() == PvuConstant.EXEMPTED_ID_LU_INFO && e.getCccExamName() == null)
					.forEach(e -> e.setActiveStatus(Constant.IN_ACTIVE_STATUS));
		}else{
			list = new ArrayList<>();
		}
		return list;
	}


	/**
	 * Sets the PVU employe dept exam detail.
	 *
	 * @param dto              the dto
	 * @param allQualExamDtos  the all qual exam dtos
	 * @param exemptedStatusId the exempted status id
	 * @param nonExempted      the non exempted
	 * @param employeEntity    the employe entity
	 */
	private void setPVUEmployeDeptExamDetail(PVUEmployeeQualificationDtos dto,
			PVUEmployeeQualificationDtos allQualExamDtos, EDPLuLookUpInfoEntity exemptedStatusId,
			EDPLuLookUpInfoEntity nonExempted, PVUEmployeEntity employeEntity) {
		if (dto.isExemptedDeptExamFlag()  ) {
			PVUEmployeDeptExamDetailsEntity exemptedDeptExam =null;
			 if(dto.getExemptedDeptExam() != null){
				  exemptedDeptExam = deptExamDetailsConverter
						 .toEntity(dto.getExemptedDeptExam());
			 }
			allQualExamDtos.setExemptedDeptExamFlag(dto.isExemptedDeptExamFlag());
			if (exemptedDeptExam != null) {
				exemptedDeptExam.setExamStatus(exemptedStatusId);
				deptExamDetailsRepository.save(exemptedDeptExam);
				deptExamDetailsRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
						employeEntity.getEmpId(), Collections.singletonList(exemptedDeptExam.getEmpDeptExamDetailId()));
				allQualExamDtos.setExemptedDeptExam(deptExamDetailsConverter.toDTO(exemptedDeptExam));
			}
		} else if (!dto.isExemptedDeptExamFlag()) {
			List<PVUEmployeDeptExamDetailsEntity> normDeptExams = deptExamDetailsConverter
					.toEntity(dto.getPvuEmployeDeptExamDetailsDto());
			normDeptExams.forEach(e -> e.setExamStatus(nonExempted));
			deptExamDetailsRepository.saveAll(normDeptExams);
			if ((!CollectionUtils.isEmpty(normDeptExams))) {
				List<Long> notIn = normDeptExams.stream().map(PVUEmployeDeptExamDetailsEntity::getEmpDeptExamDetailId)
						.collect(Collectors.toList());
				deptExamDetailsRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
						employeEntity.getEmpId(), notIn);
			}
			allQualExamDtos.setExemptedDeptExamFlag(dto.isExemptedDeptExamFlag());
			allQualExamDtos.setPvuEmployeDeptExamDetailsDto(deptExamDetailsConverter.toDTO(normDeptExams));
		}
	}
	
	public void setPVUEmployeDeptExamDetailForEdit(PVUEmployeeQualificationUpdateDtos dto,
			PVUEmployeeQualificationUpdateDtos allQualExamDtos, EDPLuLookUpInfoEntity exemptedStatusId,
			 EmployeeChangeType type) {
		if (dto.isExemptedDeptExamFlag() &&  dto.getExemptedDeptExam() != null) {
			PVUEmployeDeptExamDetailsEntity exemptedDeptExam = null;
			if(dto.getExemptedDeptExam() != null){
				 exemptedDeptExam = deptExamDetailsConverter.toUpdateEntity(dto.getExemptedDeptExam());
			}
			deptExamDetailsRepository.updateWithStatusActiveStatusByEmpId(Constant.IN_ACTIVE_STATUS,
					dto.getExemptedDeptExam().getEmpId(), Collections.singletonList(exemptedDeptExam.getEmpDeptExamDetailId()));

			allQualExamDtos.setExemptedDeptExamFlag(dto.isExemptedDeptExamFlag());
			if (exemptedDeptExam != null && exemptedDeptExam.getRemarks() != null) {
				type.setEmpDptDtltype(exemptedDeptExam.getChangeType());
				exemptedDeptExam.setExamStatus(exemptedStatusId);
				List<PVUEmployeDeptExamDetailsEntity> list =	deptExamDetailsRepository.
						findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(dto.getExemptedDeptExam().getEmpId() , Constant.ACTIVE_STATUS);
				list.add(exemptedDeptExam);
				deptExamDetailsRepository.saveAll(list);
			}
		} else if (!dto.isExemptedDeptExamFlag()) {
			List<PVUEmployeDeptExamDetailsEntity> normDeptExams  = alreadyRecordSetUnActiveStatuDPT(dto);
			dto.getPvuEmployeDeptExamDetailsDto().stream().filter(obj -> PvuUtils.getChangeType(obj.getChangeType()))
					.forEach(ccOb -> normDeptExams.add(deptExamDetailsConverter.toUpdateEntity(ccOb)));
			if(!normDeptExams.isEmpty()) {
				type.setEmpDptDtltype(normDeptExams.get(0).getChangeType());
				deptExamDetailsRepository.saveAll(normDeptExams);
			}
		}
	}

		private List<PVUEmployeDeptExamDetailsEntity> alreadyRecordSetUnActiveStatuDPT(PVUEmployeeQualificationUpdateDtos dto) {
			List<PVUEmployeDeptExamDetailsEntity> list = null;
			if(dto.getPvuEmployeDeptExamDetailsDto() != null){
			list =	deptExamDetailsRepository.
					findPVUEmployeDeptExamDetailsEntityBypvuEmployeEntityEmpIdAndActiveStatus(dto.getPvuEmployeDeptExamDetailsDto().get(0).getEmpId(), Constant.ACTIVE_STATUS);
		}
		if(!list.isEmpty()){
				list.stream().filter(e -> e.getExamStatus().getLookUpInfoId() == PvuConstant.EXEMPTED_ID_LU_INFO && e.getDeptExamName() == null)
						.forEach(e -> e.setActiveStatus(Constant.IN_ACTIVE_STATUS));
			}else{
				list = new ArrayList<>();
			}
			return list;
		}

	@Override
	public PVUEmployeeQualificationUpdateDtos editEmployeQualification(PVUEmployeeQualificationUpdateDtos dto ,EmployeeChangeType type)
			throws CustomException {
		PVUEmployeeQualificationUpdateDtos allQualExamDtos = new PVUEmployeeQualificationUpdateDtos();
		try {
			EDPLuLookUpInfoEntity exemptedStatusId = this.luLookUpInfoRepository
					.findByLookUpInfoName(PvuConstant.CONSTANT_EXEMPTED);
 		 	List<PVUEmployeQualificationEntity> qDtoList = new ArrayList<>();
			List<PVUEmployeQualificationDto> qEntityList = new ArrayList<>();
			List<PVUEmployeQualificationEntity> employeQualificationEntity = null;
			List<PVUEmployeLangExamEntity> langExamEntitys = null;
			if (dto.getPvuEmployeQualificationDto() != null) {
				dto.getPvuEmployeQualificationDto().stream().filter(h -> PvuUtils.getChangeType(h.getChangeType()))
						.forEach(qualificationDto -> qDtoList.add(converter.toEntity(qualificationDto)));
				if (!qDtoList.isEmpty()) {
					employeQualificationEntity = this.repository.saveAll(qDtoList);
					type.setEmpQualitype(employeQualificationEntity.get(0).getChangeType());
				}
			}
			if (employeQualificationEntity != null) {
				for (PVUEmployeQualificationEntity qualificationentity : employeQualificationEntity) {
					qEntityList.add(converter.toDTO(qualificationentity));
				}
				allQualExamDtos.setPvuEmployeQualificationDto(qEntityList);
			}
			
				List<PVUEmployeLangExamEntity> langExamEntity = new ArrayList<>();
				dto.getPvuEmployeLangExamDto().stream().filter(h -> PvuUtils.getChangeType(h.getChangeType()))
						.forEach(langs -> langExamEntity.add(langExamConverter.toEditabelEntity(langs)));

				if (!langExamEntity.isEmpty()) {
					langExamEntitys = this.langExamRepository.saveAll(langExamEntity);
					type.setEmpLangtype(langExamEntitys.get(0).getChangeType());
				}
				
				List<PVUEmployeLangExamEditableDto> pvuEmployeLangExamEditableDtos = new ArrayList<>();
				langExamEntity.stream().forEach(entitylangs -> pvuEmployeLangExamEditableDtos
						.add(langExamConverter.toEditabelDTO(entitylangs)));
				
					allQualExamDtos.setPvuEmployeLangExamDto(pvuEmployeLangExamEditableDtos);
					setPVUEmployeDeptExamDetailForEdit(dto, allQualExamDtos, exemptedStatusId,type);
					setPVUEmployeCCCExamDetailEdit(dto, allQualExamDtos, exemptedStatusId,type);
				
			
		} catch (Exception e) {
			logger.error(e.toString(), e);
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
		return allQualExamDtos;
	}
	
	@Override
	public List<PVUEmployeQualificationView> getHistoryOfEmpQulifictionByEmpId(IdDto idDtod) throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpQulifictionByEmpId(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeQualificationView.class)
				: Collections.emptyList();
	}

	@Override
	public List<PVUEmployeDeptExamDetailsView> getHistoryOfEmpDeptExamDetailsByEmpId(IdDto idDtod)
			throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpDeptExamDetailsByEmpId(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeDeptExamDetailsView.class)
				: Collections.emptyList();
	}

	@Override
	public List<PVUEmployeCCCExamDetailView> getHistoryOfEmpCceDeptExamDetailsByEmpId(IdDto idDtod)
			throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpCSSEXMOfDTLDetails(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeCCCExamDetailView.class)
				: Collections.emptyList();
	}
	
	@Override
	public List<PVUEmployeLangExamView> getHistoryOfEmpLngDeptExamDetailsByEmpId(IdDto idDtod)
			throws CustomException {
		StringBuilder sb = new StringBuilder();
		PVUEmployeeSqlQueries.getQuerieOfHistoryOfEmpLagExamDetails(idDtod, sb);
		List<Object[]> objectPvuSp = repository.executeSQLQueryOnly(sb.toString());
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeLangExamView.class)
				: Collections.emptyList();
	}




}
