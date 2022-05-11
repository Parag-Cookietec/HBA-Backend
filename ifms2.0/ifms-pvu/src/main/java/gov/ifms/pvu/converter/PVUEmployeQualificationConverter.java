package gov.ifms.pvu.converter;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.pvu.dto.PVUEmployeQualificationDto;
import gov.ifms.pvu.dto.PVUEmployeQualificationView;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeQualificationEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;

/**
 * The Class PVUEmployeQualificationConverter class.
 * 
 * @version v 1.0
 * @created 2019/11/27 06:11:13
 *
 */
@Component
public class PVUEmployeQualificationConverter implements BaseConverter<PVUEmployeQualificationEntity,PVUEmployeQualificationDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeQualification entity
	 */
	@Override
	public PVUEmployeQualificationEntity toEntity(PVUEmployeQualificationDto dto) {
		PVUEmployeQualificationEntity entity = new PVUEmployeQualificationEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getDegree() != 0) {
			entity.setDegree(new PVUMsCourseEntity(dto.getDegree()));
		}
		if(dto.getCourseName() != 0) {
			entity.setCourseName(new PVUMsCourseEntity(dto.getCourseName()));
		}
		if(dto.getPassingYear() != 0) {
			entity.setPassingYear(new EDPMsFinancialYearEntity(dto.getPassingYear()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getRemarks() != null) {
			entity.setRemarks(dto.getRemarks());
		}
		if (dto.getPercentageCGPA() != null) {
			entity.setPercentageCGPA(dto.getPercentageCGPA());
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		if (dto.getOtherCourseName() != null) {
			entity.setOtherCourseName(dto.getOtherCourseName());
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeQualification  dto
	 */
	@Override
	public PVUEmployeQualificationDto toDTO(PVUEmployeQualificationEntity entity) {
		PVUEmployeQualificationDto dto = new PVUEmployeQualificationDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getDegree() != null) {
			dto.setDegree(entity.getDegree().getCourseId());
			dto.setDegreeName(entity.getDegree().getCourseName());
		}
		if(entity.getCourseName() != null) {
			dto.setCourseName(entity.getCourseName().getCourseId());
			dto.setCourseIdName(entity.getCourseName().getCourseName());
		}
		if(entity.getPassingYear() != null) {
			dto.setPassingYear(entity.getPassingYear().getFinancialYearId());
			dto.setPassingYearName(entity.getPassingYear().getFyStartMonth());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		return dto;
	}
	
}
