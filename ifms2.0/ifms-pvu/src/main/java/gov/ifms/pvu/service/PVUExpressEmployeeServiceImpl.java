package gov.ifms.pvu.service;


import com.google.common.base.Strings;
import gov.ifms.common.base.PagebleDTO;
import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.pagination.PageDetails;
import gov.ifms.common.pagination.SearchParam;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.dto.EDPMsPostDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.oauth.util.OAuthUtility;
import gov.ifms.edp.repository.EDPLuLookUpInfoRepository;
import gov.ifms.edp.repository.EDPMsDesignationRepository;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.converter.PVUExpressEmployeeConverter;
import gov.ifms.pvu.dto.PvuExpEmpView;
import gov.ifms.pvu.dto.response.PVUExpressEmployeeDto;
import gov.ifms.pvu.entity.PVUEmployeDepartmentEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.repository.PVUEmployeDepartmentRepository;
import gov.ifms.pvu.repository.PVUEmployeRepository;
import gov.ifms.pvu.util.PvuConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The Class PVUEmployeServiceImpl.
 *
 * @version v 1.0
 * @created 2019/11/20 12:05:07
 */
@Service
public class PVUExpressEmployeeServiceImpl implements PVUExpressEmployeeService {

	/**
	 * The logger.
	 */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private PVUEmployeRepository repository;

	@Autowired
	private EDPLuLookUpInfoRepository lookUpInfoRepository;

	@Autowired
	private EDPMsDesignationRepository designationRepository;

	@Autowired
	private PVUEmployeDepartmentRepository departmentRepository;

	@Autowired
	private PVUExpressEmployeeConverter converter;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public PVUExpressEmployeeDto saveOrUpdateExpEmp(PVUExpressEmployeeDto dto) throws CustomException {
		validatePanNo(dto.getPanNo());
		EDPMsPostDto loginUserDet = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		Optional<PVUEmployeEntity> foundEmpEntity = Optional.empty();
		logger.info(PvuConstant.EXP_EMP_SUB_PAY_TYPE_MSG,dto.getEmpPayTypeId());
		if(dto.getEmpPayTypeId().equals(PvuConstant.EMP_PAY_TYPE_REGULAR)){
			validateCaseNo(dto.getCaseNo());
			if(Strings.isNullOrEmpty(dto.getCaseNo())){
				throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, PvuConstant.EXP_EMP_CASE_NO_NOT_VALID);
			}
			foundEmpEntity = Optional.of(findEmpByCaseNoForExpEmp(dto.getCaseNo(),dto.getEmpPayTypeId()));
		}else if(dto.getEmpPayTypeId().equals(PvuConstant.EMP_PAY_TYPE_PROBATION)){
			if(!Strings.isNullOrEmpty(dto.getCaseNo())){
				validateCaseNo(dto.getCaseNo());
				foundEmpEntity = Optional.of(findEmpByCaseNoForExpEmp(dto.getCaseNo(),dto.getEmpPayTypeId()));
			}else{
				dto.setCaseNo(null);
			}
		}else if (dto.getEmpPayTypeId().equals(PvuConstant.EMP_PAY_TYPE_FIX)){
			dto.setCaseNo(null);
		}else{
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,PvuConstant.EXP_EMP_PAY_TYPE_NOT_VALID);
		}
		PVUEmployeEntity employeeEntity;
		if(!foundEmpEntity.isPresent()){
			employeeEntity = repository.save(converter.toEntity(dto));
			departmentRepository.save(converter.toPvuDptEntity(dto,employeeEntity.getEmpId()));
			dto.setSalutation(lookUpInfoRepository.findBylookUpInfoId(dto.getSalutationId()).getLookUpInfoName());
			dto.setDesignation(designationRepository.findById(dto.getDesignationId()).map(EDPMsDesignationEntity::getDesignationName).orElse(null));
		}else{
			employeeEntity = setEmployeeEntity(foundEmpEntity.get(),dto,loginUserDet);
			Optional<PVUEmployeDepartmentEntity> dptDetails= departmentRepository.findByPvuEmployeEntityEmpId(employeeEntity.getEmpId());
			if(dptDetails.isPresent()){
				setEmpDeptEntity(dptDetails.get(),dto,loginUserDet);
				dto.setDesignation(dptDetails.get().getDesignationId().getDesignationName());
			}else{
				departmentRepository.save(converter.toPvuDptEntity(dto,employeeEntity.getEmpId()));
			}
			dto.setSalutation(employeeEntity.getSalutation().getLookUpInfoName());
		}
		employeeEntity.setEmployeeCode(Long.parseLong(repository.executeNativeSQLQuerySingle(PvuConstant.EMP_CODE_GEN_QUERY,null).toString()));
		dto.setEmployeeNo(employeeEntity.getEmployeeCode().toString());
		return new PVUExpressEmployeeDto(dto.getEmployeeNo(),dto.getSalutation(),employeeEntity.getEmployeeName(),employeeEntity.getEmployeeMiddleName(),employeeEntity.getEmployeeSurname(),dto.getDesignation());
	}

	@Override
	public PVUExpressEmployeeDto getExpEmpByCaseNo(PVUExpressEmployeeDto dto) throws CustomException {
		if(dto.getCaseNo()==null || dto.getCaseNo().isEmpty()){
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, PvuConstant.EXP_EMP_CASE_NO_NOT_VALID);
		}
		PVUEmployeEntity emp = findEmpByCaseNoForExpEmp(dto.getCaseNo(),dto.getEmpPayTypeId());
		Optional<PVUEmployeDepartmentEntity> optDept = departmentRepository.findByPvuEmployeEntityEmpId(emp.getEmpId());
		if(optDept.isPresent()){
			return converter.toDTO(emp,optDept.get().getEmpPayType().getLookUpInfoId()
					,optDept.get().getDesignationId().getDesignationId());
		}
		return converter.toDTO(emp,null,null);
	}

	private PVUEmployeEntity findEmpByCaseNoForExpEmp(String caseNo,long empPayTypeId) throws CustomException{
		EDPMsPostDto loginUserDet = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		Optional<PVUEmployeEntity> foundEmpEntity;
        validateCaseNo(caseNo);
		List<PVUEmployeEntity> foundEmps = repository.getExpEmpByCaseNoFromAllOffice(caseNo, empPayTypeId, PvuConstant.SAVE_AS_DRAFT_ID, Constant.ACTIVE_STATUS);
		if(foundEmps.isEmpty()){
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, PvuConstant.EXP_EMP_CASE_NO_NOT_VALID);
		}else{
			foundEmpEntity = foundEmps.stream().filter(e -> e.getOfficeId().getOfficeId().equals(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId())).findFirst();
			if(foundEmpEntity.isPresent()){
				return foundEmpEntity.get();
			}
			else{
				Optional<PVUEmployeEntity> foundEmpOtherOff = foundEmps.stream().filter(e -> !e.getOfficeId().getOfficeId().equals(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId())).findFirst();
				if(foundEmpOtherOff.isPresent()){
					EDPMsOfficeEntity office = foundEmpOtherOff.get().getOfficeId();
					throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,
							String.format(PvuConstant.EXP_EMP_CASE_NO_EXISTS,office.getOfficeName().toUpperCase(),office.getDdoNo(),office.getCardexno().toString()));
				}else{
					throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,PvuConstant.EXP_EMP_CASE_NO_NOT_VALID);
				}
			}
		}
	}

	@Override
	public PagebleDTO<PvuExpEmpView> getExpEmpSearchList(PageDetails pageDetail) throws CustomException {
		EDPMsPostDto loginUserDet = OAuthUtility.getCurrentUserLoginPostFromOauthToken();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put(Constant.IN_PAGE_INDEX, pageDetail.getPageIndex());
		map.put(Constant.IN_PAGE_SIZE, pageDetail.getPageElement());
		map.put(PvuConstant.IN_OFFICE_ID,loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId());
		List<SearchParam> searchParams = pageDetail.getJsonArr();
		if (searchParams != null && !searchParams.isEmpty()) {
			searchParams.forEach(e -> {
				String key = PvuConstant.getExpEmpSearchList().get(e.getKey());
				if (key != null) {
					map.put(key, e.getValue());
				}
			});
		}
		String procName = Constant.PVU_SCHEMA
				.concat(Constant.DOT.concat(PvuConstant.SP_PVU_EXPRESS_EMPLOYEE_SEARCH_LISTING));
		List<PvuExpEmpView> objectSp = this.callStoreProcWithNoResult(procName, map, PvuExpEmpView.class);
		int totalPages = !Utils.isEmpty(objectSp) ? (objectSp.get(0).getTotalRecords()) : objectSp.size();
		return new PagebleDTO<>(pageDetail.getPageElement(), 0, totalPages, objectSp);
	}

	@Override
	public String getExpEmpByPanNo(String panNo) throws CustomException {
		if(panNo!=null && !panNo.isEmpty()){
			if(panNo.matches(Constant.Regex.VALIDATION_PAN_NUMBER)){
				validatePanNo(panNo);
			}else{
				throw new CustomException(HttpStatus.BAD_REQUEST,PvuConstant.EXP_EMP_PAN_NOT_VALID);
			}
		}
		return null;
	}

	@Override
	public PVUExpressEmployeeDto getExpEmpByEmpId(long id) throws CustomException {
		PVUEmployeEntity employeEntity = repository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,PvuConstant.EXP_EMP_NOT_EXISTS));
		PVUEmployeDepartmentEntity empDept = departmentRepository.findByPvuEmployeEntityEmpId(employeEntity.getEmpId()).orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR,PvuConstant.EXP_EMP_NOT_EXISTS));
		return converter.toDTO(employeEntity,empDept.getEmpPayType().getLookUpInfoId(),empDept.getDesignationId().getDesignationId());

	}

	@Transactional
	public PVUEmployeEntity setEmployeeEntity(PVUEmployeEntity employeeEntity,PVUExpressEmployeeDto dto,EDPMsPostDto loginUserDet){
		employeeEntity.setSalutation(employeeEntity.getSalutation()==null?new EDPLuLookUpInfoEntity(dto.getSalutationId()):employeeEntity.getSalutation());
		employeeEntity.setEmployeeName(Strings.isNullOrEmpty(employeeEntity.getEmployeeName())?dto.getEmpFirstName():employeeEntity.getEmployeeName());
		employeeEntity.setEmployeeMiddleName(Strings.isNullOrEmpty(employeeEntity.getEmployeeMiddleName())?dto.getEmpMiddleName():employeeEntity.getEmployeeMiddleName());
		employeeEntity.setEmployeeSurname(Strings.isNullOrEmpty(employeeEntity.getEmployeeSurname())?dto.getEmpLastName():employeeEntity.getEmployeeSurname());
		employeeEntity.setDateOfBirth(employeeEntity.getDateOfBirth()==null?EDPUtility.getDateValue(dto.getDateOfBirth()):employeeEntity.getDateOfBirth());
		employeeEntity.setPanNo(employeeEntity.getPanNo()==null?dto.getPanNo():employeeEntity.getPanNo());
		employeeEntity.setMobileNo(employeeEntity.getMobileNo()==null?dto.getMobileNo(): employeeEntity.getMobileNo());
		employeeEntity.setStatusId(new EDPLuLookUpInfoEntity(Constant.LU_APPROVED_LOOKUP_INFO_ID));
		employeeEntity.setOfficeName(employeeEntity.getOfficeName()==null?loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeName():employeeEntity.getOfficeName());
		employeeEntity.setEmpSrcType(PvuConstant.EXP_EMP_SRC_TYPE);
		return employeeEntity;
	}

	@Transactional
	public PVUEmployeDepartmentEntity setEmpDeptEntity(PVUEmployeDepartmentEntity departmentEntity,PVUExpressEmployeeDto dto,EDPMsPostDto loginUserDet){
		departmentEntity.setDesignationId(departmentEntity.getDesignationId()==null?new EDPMsDesignationEntity(dto.getDesignationId()):departmentEntity.getDesignationId());
		departmentEntity.setEmpPayType(departmentEntity.getEmpType()==null?new EDPLuLookUpInfoEntity(dto.getEmpPayTypeId()):departmentEntity.getEmpPayType());
		departmentEntity.setDistrictId(departmentEntity.getDistrictId()==null?new EDPMsDistrictEntity(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getDistrictId()):departmentEntity.getDistrictId());
		departmentEntity.setDdoCode(departmentEntity.getDdoCode()==null?loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getDdoNo():departmentEntity.getDdoCode());
		departmentEntity.setCardexNo(departmentEntity.getCardexNo()==null?loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getCardexno().toString():departmentEntity.getCardexNo());
		departmentEntity.setPresentOffice(departmentEntity.getPresentOffice()==null?new EDPMsOfficeEntity(loginUserDet.getOauthTokenPostDTO().getEdpMsOfficeDto().getOfficeId()):departmentEntity.getPresentOffice());
		return departmentEntity;
	}

	private <T> List<T> callStoreProcWithNoResult(String procName, Map<String, Object> map, Class<T> view) throws CustomException {
		List<Object[]> objectPvuSp = repository.callStoredProcedureWithNoResult(procName, map);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, view) : Collections.emptyList();
	}

	private void validatePanNo(String panNo) throws CustomException {
		List<PVUEmployeEntity> empCheck = repository.findExpEmpByPanNoStatusIdActiveStatus(panNo,Constant.LU_APPROVED_LOOKUP_INFO_ID ,Constant.ACTIVE_STATUS);
		if(!empCheck.isEmpty()){
			PVUEmployeEntity emp = empCheck.stream().findFirst().orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, PvuConstant.EXP_EMP_PAN_NO_NOT_VALID));
			throw new CustomException(HttpStatus.BAD_REQUEST,String.format(PvuConstant.EMP_MATHCHED_BY_PAN,emp.getPanNo(),emp.getOfficeId().getOfficeName().toUpperCase(),emp.getOfficeId().getDdoNo(),emp.getOfficeId().getCardexno().toString()));
		}
	}

	private void validateCaseNo(String caseNo) throws CustomException {
		List<PVUEmployeEntity> empCheck = repository.findExpEmpByCaseNoStatusIdActiveStatus(caseNo,Constant.LU_APPROVED_LOOKUP_INFO_ID ,Constant.ACTIVE_STATUS);
		if(!empCheck.isEmpty()){
			PVUEmployeEntity emp = empCheck.stream().findFirst().orElseThrow(() -> new CustomException(HttpStatus.BAD_REQUEST, PvuConstant.EXP_EMP_CASE_NO_NOT_VALID));
			StringBuilder msg = new StringBuilder(String.format(PvuConstant.EMP_MATHCHED_BY_CASE,emp.getEmployeeCode().toString()));
			if(!Strings.isNullOrEmpty(emp.getPanNo())){
				msg.append(", ").append(emp.getPanNo()).append(".");
			}
			throw new CustomException(HttpStatus.BAD_REQUEST,msg.toString());
		}
	}
}
