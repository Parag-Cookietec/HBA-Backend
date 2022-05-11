package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.util.EDPUtility;
import gov.ifms.pvu.dto.PVUEmployeLangExamDto;
import gov.ifms.pvu.dto.PVUEmployeLangExamEditableDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeLangExamEntity;

/**
 * The Class PVUEmployeLangExamConverter class.
 *
 * @version v 1.0
 * @created 2019/11/27 23:55:09
 *
 */
@Component
public class PVUEmployeLangExamConverter implements BaseConverter<PVUEmployeLangExamEntity,PVUEmployeLangExamDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeLangExam entity
	 */
	@Override
	public PVUEmployeLangExamEntity toEntity(PVUEmployeLangExamDto dto) {
		PVUEmployeLangExamEntity entity = new PVUEmployeLangExamEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getLangName() != 0) {
			entity.setLangName(new EDPLuLookUpInfoEntity(dto.getLangName()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if(dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		if(dto.getExamType() != 0) {
			entity.setExamType(new EDPLuLookUpInfoEntity(dto.getExamType()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeLangExam  dto
	 */
	@Override
	public PVUEmployeLangExamDto toDTO(PVUEmployeLangExamEntity entity) {
		PVUEmployeLangExamDto dto = new PVUEmployeLangExamDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getLangName() != null) {
			dto.setLangName(entity.getLangName().getLookUpInfoId());
			dto.setLangIdName(entity.getLangName().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if(entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		if(entity.getExamType() != null) {
			dto.setExamType(entity.getExamType().getLookUpInfoId());
			dto.setExamTypeName(entity.getExamType().getLookUpInfoName());
		}
		return dto;
	}

	public PVUEmployeLangExamEntity toEditabelEntity(PVUEmployeLangExamEditableDto dto) {
		PVUEmployeLangExamEntity entity = new PVUEmployeLangExamEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getLangName() != 0) {
			entity.setLangName(new EDPLuLookUpInfoEntity(dto.getLangName()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if(dto.getExamStatus() != 0) {
			entity.setExamStatus(new EDPLuLookUpInfoEntity(dto.getExamStatus()));
		}
		if(dto.getExamType() != 0) {
			entity.setExamType(new EDPLuLookUpInfoEntity(dto.getExamType()));
		}
		if(dto.getSeatNo() != null) {
			entity.setSeatNo(dto.getSeatNo());
		}
		if(dto.getRemarks() != null) {
			entity.setRemarks(dto.getRemarks());
		}
		if(dto.getDateOfPassing() != null) {
			entity.setDateOfPassing(EDPUtility.getDateValue(dto.getDateOfPassing()));
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		return entity;
	}
	
	public PVUEmployeLangExamEditableDto toEditabelDTO(PVUEmployeLangExamEntity entity) {
		PVUEmployeLangExamEditableDto dto = new PVUEmployeLangExamEditableDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getLangName() != null) {
			dto.setLangName(entity.getLangName().getLookUpInfoId());
			dto.setLangIdName(entity.getLangName().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		if(entity.getExamStatus() != null) {
			dto.setExamStatus(entity.getExamStatus().getLookUpInfoId());
			dto.setExamStatusName(entity.getExamStatus().getLookUpInfoName());
		}
		if(entity.getExamType() != null) {
			dto.setExamType(entity.getExamType().getLookUpInfoId());
			dto.setExamTypeName(entity.getExamType().getLookUpInfoName());
		}
		return dto;
	}
	
}
