package gov.ifms.pvu.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ifms.common.dao.NativeQueryResultsMapper;
import gov.ifms.common.dto.IdDto;
import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.pvu.converter.PVUEmployeTypeChangeConverter;
import gov.ifms.pvu.converter.PVUEmployeTypeChangeSDConverter;
import gov.ifms.pvu.dto.PVUEmployeTypeChangeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeListingSPDto;
import gov.ifms.pvu.dto.PVUEmployeeTypeSPDto;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeEntity;
import gov.ifms.pvu.entity.PVUEmployeTypeChangeSDEntity;
import gov.ifms.pvu.repository.PVUEmployeTypeChangeRepository;
import gov.ifms.pvu.repository.PVUEmployeTypeChangeSDRepository;
import gov.ifms.pvu.util.PvuConstant;

@Service
public class PVUEmployeTypeChangeServiceImpl implements PVUEmployeTypeChangeService {

	@Autowired
	private PVUEmployeTypeChangeRepository repository;

	@Autowired
	private PVUEmployeTypeChangeSDRepository empSDrepository;

	@Autowired
	private PVUEmployeTypeChangeConverter converter;

	@Autowired
	private PVUEmployeTypeChangeSDConverter empSdconverter;

	@Override
	public List<PVUEmployeeTypeSPDto> getEmployeeDetails(PVUEmployeTypeChangeDto dto) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_IS_SEARCH, Objects.nonNull(dto.getEmpNo()) ? 1 : 2);
		argsMap.put(Constant.IN_OFFICE_ID,
				Objects.nonNull(dto.getOfficeId()) ? dto.getOfficeId() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMP_PAY_TYPE,
				Objects.nonNull(dto.getEmpPaytype()) ? dto.getEmpPaytype() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMPLOYEE_NO,
				Objects.nonNull(dto.getEmpNo()) ? dto.getEmpNo() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMPLOYEE_NAME,
				Objects.nonNull(dto.getEmpName()) ? dto.getEmpName() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_EMP_TYPE,
				Objects.nonNull(dto.getEmptype()) ? dto.getEmptype() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_DESIGNATION_ID,
				Objects.nonNull(dto.getDesigId()) ? dto.getDesigId() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_PAN_NO, Objects.nonNull(dto.getPanNo()) ? dto.getPanNo() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_RETIREMENT_DATE,
				Objects.nonNull(dto.getRetirementDate()) ? dto.getRetirementDate().toString() : StringUtils.EMPTY);
		String procName = Constant.PVU_SCHEMA
				.concat(Constant.DOT.concat(PvuConstant.PVU_SP_ADHC_PROB_REGLR_EMP_SEARCH));
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, argsMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeTypeSPDto.class)
				: Collections.emptyList();

	}

	@Override
	public PVUEmployeTypeChangeDto saveOrUpdateEmploye(PVUEmployeTypeChangeDto dto) throws CustomException {
		PVUEmployeTypeChangeEntity entity = repository.findByEmpId(dto.getEmpId());
		if (Objects.nonNull(entity))
			return null;
		if (dto.getStatusId() == 327) {
			if (Objects.isNull(dto.getTpvuRegPrboId())) {
				int yearStartid = LocalDate.now().getYear();
				int month = LocalDate.now().getMonthValue();
				String fy;
				if (month > 3)
					fy = String.valueOf(yearStartid).substring(2) + "-" + String.valueOf(yearStartid + 1).substring(2);
				else
					fy = String.valueOf(yearStartid - 1).substring(2) + "-" + String.valueOf(yearStartid).substring(2);
				Long count = repository.getyearCount(fy + "/%") + 1L;
				int sizeCheck = String.valueOf(count).length();
				String seqdup = String.valueOf(count);
				switch (sizeCheck) {
				case 0:
					seqdup = "00000";
					break;
				case 1:
					seqdup = "00000" + count;
					break;
				case 2:
					seqdup = "0000" + count;
					break;
				case 3:
					seqdup = "000" + count;
					break;
				case 4:
					seqdup = "00" + count;
					break;
				case 5:
					seqdup = "0" + count;
					break;
				default:

				}
				dto.setTransNo(fy + "/PVU/EPTC/" + seqdup);
				dto.setRefDate(LocalDateTime.now());
				dto.setEmpPaytype(156L);
				dto.setFinancialYearId(this.getFinancialYear(dto.getConvEffecDate()));
			}
			PVUEmployeTypeChangeSDEntity pVUEmployeTypeSDChange = new PVUEmployeTypeChangeSDEntity();
			BeanUtils.copyProperties(converter.toEntity(dto), pVUEmployeTypeSDChange);
			pVUEmployeTypeSDChange.setActiveStatus(0);
			PVUEmployeTypeChangeSDEntity empSd = empSDrepository.save(pVUEmployeTypeSDChange);
			dto.setTpvuRegPrboSdId(empSd.getTpvuRegPrboSdId());
			PVUEmployeeTypeDto empdto = repository.validateAdhoc(dto.getEmpId());
			if (Objects.nonNull(empdto)) {
				long count = empdto.getEOL() + empdto.getIncremnt() + empdto.getTransfer() + empdto.getSuspension();
				if (count > 0)
					return this.validateEmployee(empdto);
			}
			PVUEmployeTypeChangeEntity pVUEmployeTypeChange = repository.save(converter.toEntity(dto));
			this.updatePVUData(pVUEmployeTypeChange);
			return converter.toDTO(pVUEmployeTypeChange);
		} else {
			PVUEmployeTypeChangeSDEntity sdEntity = empSDrepository.findByEmpId(dto.getEmpId());
			PVUEmployeTypeChangeSDEntity pVUEmployeTypeSDChange = new PVUEmployeTypeChangeSDEntity();
			BeanUtils.copyProperties(converter.toEntity(dto), pVUEmployeTypeSDChange);
			if (Objects.nonNull(sdEntity)) {
				pVUEmployeTypeSDChange.setTpvuRegPrboSdId(sdEntity.getTpvuRegPrboSdId());
			}
			return empSdconverter.toDTO(empSDrepository.save(pVUEmployeTypeSDChange));
		}
	}

	private PVUEmployeTypeChangeDto validateEmployee(PVUEmployeeTypeDto empdto) {
		PVUEmployeTypeChangeDto dto = new PVUEmployeTypeChangeDto();
		if (empdto.getEOL() == 1)
			dto.setErrorCode("EOL");
		else if (empdto.getSuspension() == 1)
			dto.setErrorCode("Suspension");
		else if (empdto.getTransfer() == 1)
			dto.setErrorCode("Transfer");
		else if (empdto.getIncremnt() == 1)
			dto.setErrorCode("Increment");
		dto.setErrortransNo(empdto.getTransNo());
		return dto;
	}

	private void updatePVUData(PVUEmployeTypeChangeEntity pVUEmployeTypeChange) {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_OFFICE_ID, pVUEmployeTypeChange.getOfficeId());
		argsMap.put(Constant.IN_PVU_ADHC_PROB_REGLR_SD_ID, pVUEmployeTypeChange.getTpvuRegPrboSdId());
		argsMap.put(Constant.IN_CREATED_BY_USER, pVUEmployeTypeChange.getCreatedBy());
		argsMap.put(Constant.IN_CREATED_BY_POST, pVUEmployeTypeChange.getCreatedByPost());
		repository.callStoredProcedure("PVU.SP_ADHC_PROB_REGLR_SUBMIT", argsMap);
		argsMap.clear();
		argsMap.put(Constant.IN_EMP_ID, pVUEmployeTypeChange.getEmpId());
		argsMap.put(Constant.IN_TRN_ID, pVUEmployeTypeChange.getTpvuRegPrboId());
		if (pVUEmployeTypeChange.getCurrentEmpPaytype() == 161 && pVUEmployeTypeChange.getEmpIncEligible() == 2)
			repository.callStoredProcedure("PVU.P_PVU_PROB_AUTO_INCR", argsMap);
	}

	private Long getFinancialYear(LocalDate convEffecDate) {
		int monthId = convEffecDate.getMonthValue();
		String fyYear;
		if (monthId > 3)
			fyYear = convEffecDate.getYear() + "-" + (convEffecDate.getYear() + 1);
		else
			fyYear = (convEffecDate.getYear() - 1) + "-" + convEffecDate.getYear();
		return repository.findFYYearId(fyYear);
	}

	@Override
	public PVUEmployeTypeChangeDto getEmployeTypeChange(PVUEmployeTypeChangeDto id) {
		PVUEmployeTypeChangeDto dto;
		if (id.getStatusId() == 327) {
			dto = converter.toDTO(repository.findByTpvuRegPrboSdId(id.getId()));
		} else {
			dto = empSdconverter.toDTO(empSDrepository.getOne(id.getId()));
		}
		PVUEmployeeTypeDto employeeTypeDto = repository.getEmpDetails(dto.getEmpId());
		dto.setOfficeName(employeeTypeDto.getOfficeName());
		dto.setEmpTypeName(employeeTypeDto.getEmpTypeName());
		dto.setOfficeName(employeeTypeDto.getOfficeName());
		dto.setClassName(employeeTypeDto.getEmpClassName());
		dto.setDesigName(employeeTypeDto.getDesigName());
		dto.setEmpNo(employeeTypeDto.getEmpNo());
		dto.setEmpName(employeeTypeDto.getEmpName());
		dto.setDoj(employeeTypeDto.getDoj());
		return dto;
	}

	@Override
	public void deleteEmployeTypeChange(IdDto id) {
		repository.deleteEmpTypeChange(id.getId());
	}

	@Override
	public List<PVUEmployeeTypeListingSPDto> fetchEmpTypeChange(PVUEmployeTypeChangeDto dto) throws CustomException {
		Map<String, Object> argsMap = new LinkedHashMap<>();
		argsMap.put(Constant.IN_OFFICE_ID,
				Objects.nonNull(dto.getOfficeId()) ? dto.getOfficeId() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMPLOYEE_NO,
				Objects.nonNull(dto.getEmpNo()) ? dto.getEmpNo() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMPLOYEE_NAME,
				Objects.nonNull(dto.getEmpName()) ? dto.getEmpName() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_DESIGNATION_ID,
				Objects.nonNull(dto.getDesigId()) ? dto.getDesigId() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_REF_FROM_DATE,
				Objects.nonNull(dto.getRefFromDate()) ? dto.getRefFromDate().toString() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_REF_TO_DATE,
				Objects.nonNull(dto.getRefToDate()) ? dto.getRefToDate().toString() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_REF_NO, Objects.nonNull(dto.getTransNo()) ? dto.getTransNo() : StringUtils.EMPTY);
		argsMap.put(Constant.IN_STATUS_ID,
				Objects.nonNull(dto.getStatusId()) ? dto.getStatusId() : Constant.OUTWARD_FLAG_ZERO);
		argsMap.put(Constant.IN_EMP_PAY_TYPE,
				Objects.nonNull(dto.getEmpPaytype()) ? dto.getEmpPaytype() : Constant.OUTWARD_FLAG_ZERO);
		String procName = Constant.PVU_SCHEMA.concat(Constant.DOT.concat(PvuConstant.PVU_SP_ADHC_PROB_REGLR_EMP_LIST));
		List<Object[]> objectPvuSp = repository.callStoredProcedure(procName, argsMap);
		return !objectPvuSp.isEmpty() ? NativeQueryResultsMapper.map(objectPvuSp, PVUEmployeeTypeListingSPDto.class)
				: Collections.emptyList();
	}

	@Override
	public PVUEmployeeTypeDto findEmployeeOfficedetails(Long empId) {
		return repository.getEmpDetails(empId);
	}

}
