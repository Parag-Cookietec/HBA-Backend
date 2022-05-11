package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsDto;
import gov.ifms.pvu.dto.PVUEmployeDeptExamDetailsEditableDto;
import gov.ifms.pvu.entity.PVUEmployeDeptExamDetailsEntity;
import gov.ifms.pvu.entity.PVUEmployeEntity;

/**
 * The Class PVUEmployeDeptExamDetailsConverter class.
 *
 * @version v 1.0
 * @created 2019/11/27 06:15:41
 *
 */
@Component
public class PVUEmployeDeptExamDetailsConverter
		implements BaseConverter<PVUEmployeDeptExamDetailsEntity, PVUEmployeDeptExamDetailsDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeDeptExamDetails entity
	 */
	@Override
	public PVUEmployeDeptExamDetailsEntity toEntity(PVUEmployeDeptExamDetailsDto dto) {
		PVUEmployeDeptExamDetailsEntity entity = new PVUEmployeDeptExamDetailsEntity();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getExamBody() != 0) {
			entity.setExamBody(new EDPLuLookUpInfoEntity(dto.getExamBody()));
		}
		if (dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeDeptExamDetails dto
	 */
	@Override
	public PVUEmployeDeptExamDetailsDto toDTO(PVUEmployeDeptExamDetailsEntity entity) {
		PVUEmployeDeptExamDetailsDto dto = new PVUEmployeDeptExamDetailsDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (entity.getExamBody() != null) {
			dto.setExamBody(entity.getExamBody().getLookUpInfoId());
			dto.setExamBodyName(entity.getExamBody().getLookUpInfoName());
		}
		if (entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		return dto;
	}

	public PVUEmployeDeptExamDetailsEntity toUpdateEntity(PVUEmployeDeptExamDetailsEditableDto dto) {
		PVUEmployeDeptExamDetailsEntity entity = new PVUEmployeDeptExamDetailsEntity();
		if (dto.getEmpDeptExamDetailId() != 0) {
			entity.setEmpDeptExamDetailId(dto.getEmpDeptExamDetailId());
		}
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getExamBody() != 0) {
			entity.setExamBody(new EDPLuLookUpInfoEntity(dto.getExamBody()));
		}
		if (dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		if (dto.getExamBody() != 0) {
			entity.setExamBody(new EDPLuLookUpInfoEntity(dto.getExamBody()));
		}
		if (dto.getDeptExamName() != null) {
			entity.setDeptExamName(dto.getDeptExamName());
		}
		if (dto.getDateOfPassing() != null) {
			entity.setDateOfPassing(EDPUtility.getDateValue(dto.getDateOfPassing()));
		}
		if (dto.getRemarks() != null) {
			entity.setRemarks(dto.getRemarks());
		}
		if (dto.getOtherDeptHodName()!= null) {
			entity.setOtherDeptHodName(dto.getOtherDeptHodName());
		}
		if (dto.getExamAttempts() != 0) {
			entity.setExamAttempts(dto.getExamAttempts());
		}
		if (dto.getDeptHodName() !=  null) {
			entity.setDeptHodName(dto.getDeptHodName());
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		return entity;
	}

	public PVUEmployeDeptExamDetailsEditableDto toUpdateDTO(PVUEmployeDeptExamDetailsEntity entity) {
		PVUEmployeDeptExamDetailsEditableDto dto = new PVUEmployeDeptExamDetailsEditableDto();
		BeanUtils.copyProperties(entity, dto);
		if (entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if (entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if (entity.getExamBody() != null) {
			dto.setExamBody(entity.getExamBody().getLookUpInfoId());
			dto.setExamBodyName(entity.getExamBody().getLookUpInfoName());
		}
		if (entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		return dto;
	}
	
}
