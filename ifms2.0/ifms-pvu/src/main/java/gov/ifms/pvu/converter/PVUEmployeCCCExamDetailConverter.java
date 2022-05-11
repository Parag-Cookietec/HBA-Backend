package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailDto;
import gov.ifms.pvu.dto.PVUEmployeCCCExamDetailEditableDto;
import gov.ifms.pvu.entity.PVUEmployeCCCExamDetailEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUMsCourseEntity;

/**
 * The Class PVUEmployeCCCExamDetailConverter class.
 *
 * @version v 1.0
 * @created 2019/11/27 23:30:53
 *
 */
@Component
public class PVUEmployeCCCExamDetailConverter
		implements BaseConverter<PVUEmployeCCCExamDetailEntity, PVUEmployeCCCExamDetailDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeCCCExamDetail entity
	 */
	@Override
	public PVUEmployeCCCExamDetailEntity toEntity(PVUEmployeCCCExamDetailDto dto) {
		PVUEmployeCCCExamDetailEntity entity = new PVUEmployeCCCExamDetailEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getExamBody() != 0) {
			entity.setExamBody(new PVUMsCourseEntity(dto.getExamBody()));
		}
		if(dto.getCccExamName() != 0) {
			entity.setCccExamName(new EDPLuLookUpInfoEntity(dto.getCccExamName()));
		}
		if(dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeCCCExamDetail dto
	 */
	@Override
	public PVUEmployeCCCExamDetailDto toDTO(PVUEmployeCCCExamDetailEntity entity) {
		PVUEmployeCCCExamDetailDto dto = new PVUEmployeCCCExamDetailDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getExamBody() != null) {
			dto.setExamBody(entity.getExamBody().getCourseId());
			dto.setExamBodyName(entity.getExamBody().getCourseName());
		}
		if(entity.getCccExamName() != null) {
			dto.setCccExamName(entity.getCccExamName().getLookUpInfoId());
			dto.setCccExamIdName(entity.getCccExamName().getLookUpInfoName());
		}
		if(entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		
		return dto;
	}
	
	public PVUEmployeCCCExamDetailEntity toEditableEntity(PVUEmployeCCCExamDetailEditableDto dto) {
		PVUEmployeCCCExamDetailEntity entity = new PVUEmployeCCCExamDetailEntity();
		if (dto.getEmpCCCExamDetailId() != 0) {
			entity.setEmpCCCExamDetailId(dto.getEmpCCCExamDetailId());
		}
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getExamBody() != 0) {
			entity.setExamBody(new PVUMsCourseEntity(dto.getExamBody()));
		}
		if(dto.getCccExamName() != 0) {
			entity.setCccExamName(new EDPLuLookUpInfoEntity(dto.getCccExamName()));
		} 
		if(dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getExamBody() != 0) {
			entity.setExamBody(new PVUMsCourseEntity(dto.getExamBody()));
		}
		if (dto.getDateOfExam() != null) {
			entity.setDateOfExam(EDPUtility.getDateValue(dto.getDateOfExam()));
		}
		if (dto.getDateOfPassing() != null) {
			entity.setDateOfPassing(EDPUtility.getDateValue(dto.getDateOfPassing()));
		}
		if (dto.getRemarks() != null) {
			entity.setRemarks(dto.getRemarks());
		}
		if (dto.getCccExamName() != 0) {
			entity.setCccExamName(new EDPLuLookUpInfoEntity(dto.getCccExamName()));
		}
		if (dto.getCertificateNo() != null) {
			entity.setCertificateNo(dto.getCertificateNo());
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		return entity;
	}
	
	
	public PVUEmployeCCCExamDetailEditableDto toEditableDTO(PVUEmployeCCCExamDetailEntity entity) {
		PVUEmployeCCCExamDetailEditableDto dto = new PVUEmployeCCCExamDetailEditableDto();

		BeanUtils.copyProperties(entity, dto);
		if (entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if (entity.getExamBody() != null) {
			dto.setExamBody(entity.getExamBody().getCourseId());
			dto.setExamBodyName(entity.getExamBody().getCourseName());
		}
		if (entity.getCccExamName() != null) {
			dto.setCccExamName(entity.getCccExamName().getLookUpInfoId());
			dto.setCccExamIdName(entity.getCccExamName().getLookUpInfoName());
		}
		if (entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}

		return dto;
	}
	
}
