package gov.ifms.dmo.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gov.ifms.common.exception.CustomException;
import gov.ifms.common.util.Constant;
import gov.ifms.common.util.ErrorResponse;
import gov.ifms.dmo.dto.DMOLookUpDto;
import gov.ifms.dmo.service.EDPDepartmentMstService;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.entity.EDPMsHodEntity;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;
import gov.ifms.edp.repository.EDPMsHodRepository;

@Service
public class EDPDepartmentMstServiceImpl implements EDPDepartmentMstService {

	/** The logger. */
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	EDPMsDepartmentRepository departmentServiceRepository;

	@Autowired
	EDPMsHodRepository edpMsHodRepository;

	@Override
	public List<DMOLookUpDto> getAllDepartment() throws CustomException {
		try {
			List<EDPMsDepartmentEntity> listDeptMs = departmentServiceRepository
					.findByActiveStatus(Constant.ACTIVE_STATUS, Sort.by(Sort.Direction.ASC, "departmentName"));
			return listDeptMs.stream().map(deptMs -> {
				DMOLookUpDto respDto = new DMOLookUpDto();
				respDto.setId(deptMs.getDepartmentId());
				respDto.setName(deptMs.getDepartmentName());
				return respDto;
			}).collect(Collectors.toList());
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

	@Override
	public List<DMOLookUpDto> getAllHODByDepartment(DMOLookUpDto dto) throws CustomException {
		try {
			List<EDPMsHodEntity> edpMsHodEntities = edpMsHodRepository.findByDepartmentIdDepartmentId(dto.getId());
			return edpMsHodEntities.stream().sorted(Comparator.comparing(EDPMsHodEntity::getHodName)).map(hod -> {
				DMOLookUpDto respDto = new DMOLookUpDto();
				respDto.setId(hod.getHodId());
				respDto.setName(hod.getHodName());
				return respDto;
			}).collect(Collectors.toList());
		} catch (Exception ex) {
			logger.error(ex.toString());
			throw new CustomException(ErrorResponse.ERROR_WHILE_FATCHING);
		}
	}

}
