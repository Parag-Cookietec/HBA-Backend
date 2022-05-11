package gov.ifms.pvu.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Utils;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDesignationEntity;
import gov.ifms.edp.entity.EDPMsFinancialYearEntity;
import gov.ifms.edp.entity.EDPMsOfficeEntity;
import gov.ifms.edp.entity.EDPMsPostEntity;
import gov.ifms.pvu.dto.PVUIncrementEventDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUIncrementEventEntity;

/**
 * The Class PVUIncrementEventConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/09 19:28:39
 *
 */
@Component
public class PVUIncrementEventConverter implements BaseConverter<PVUIncrementEventEntity, PVUIncrementEventDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUIncrementEvent entity
	 */
	@Override
	public PVUIncrementEventEntity toEntity(PVUIncrementEventDto dto) {
		PVUIncrementEventEntity entity = new PVUIncrementEventEntity();
		if (!Utils.isEmpty(dto.getOfficeId())) {
			entity.setOfficeId(new EDPMsOfficeEntity(dto.getOfficeId()));
		}

		if (!Utils.isEmpty(dto.getFinancialYear())) {
			entity.setFinancialYear(new EDPMsFinancialYearEntity(dto.getFinancialYear()));
		}

		entity.setEventOrderNo(dto.getEventOrderNo());

		if (!Utils.isEmpty(dto.getIncrementFor())) {
			entity.setIncrementFor(new EDPLuLookUpInfoEntity(dto.getIncrementFor()));
		}

		if (!Utils.isEmpty(dto.getIncrementType())) {
			entity.setIncrementType(new EDPLuLookUpInfoEntity(dto.getIncrementType()));
		}

		if (!Utils.isEmpty(dto.getClassId())) {
			entity.setClassId(new EDPLuLookUpInfoEntity(dto.getClassId()));
		}

		if (!Utils.isEmpty(dto.getDesignationId())) {
			entity.setDesignationId(new EDPMsDesignationEntity(dto.getDesignationId()));
		}

		if (!Utils.isEmpty(dto.getIncrementEffDate())) {
			entity.setIncrementEffDate(dto.getIncrementEffDate());
		}

		if (!Utils.isEmpty(dto.getDateNextInc())) {
			entity.setDateNextInc(dto.getDateNextInc());
		}

		if (!Utils.isEmpty(dto.getEmpId())) {
			entity.setEmpId(new PVUEmployeEntity(dto.getEmpId()));
		}
		
		if (!Utils.isEmpty(dto.getEmpType())) {
			entity.setEmpType(new EDPLuLookUpInfoEntity(dto.getEmpType()));
		}

		if (!Utils.isEmpty(dto.getEmpPayType())) {
			entity.setEmpPayType(new EDPLuLookUpInfoEntity(dto.getEmpPayType()));
		}
		
		if (!Utils.isEmpty(dto.getStatusId())) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		
		if (!Utils.isEmpty(dto.getPostId())) {
			entity.setPostId(new EDPMsPostEntity(dto.getPostId()));
		}
		
		if (!Utils.isEmpty(dto.getEmpNo())) {
			entity.setEmpNo(dto.getEmpNo());
		}
		entity.setGpf(dto.getGpf());
		BeanUtils.copyProperties(dto, entity);
		
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUIncrementEvent dto
	 */
	@Override
	public PVUIncrementEventDto toDTO(PVUIncrementEventEntity entity) {
		PVUIncrementEventDto dto = new PVUIncrementEventDto();
		if (!Utils.isEmpty(entity.getOfficeId())) {
			dto.setOfficeId(entity.getOfficeId().getOfficeId());
		}

		if (!Utils.isEmpty(entity.getFinancialYear())) {
			dto.setFinancialYear(entity.getFinancialYear().getFinancialYearId());
			dto.setFinancialYearName(entity.getFinancialYear().getFyStart());
		}
		
		dto.setTrnNo(dto.getTrnNo());
		dto.setEventOrderNo(entity.getEventOrderNo());

		if (!Utils.isEmpty(entity.getIncrementFor())) {
			dto.setIncrementFor(entity.getIncrementFor().getLookUpInfoId());
			dto.setIncrementForName(entity.getIncrementFor().getLookUpInfoName());
		}

		if (!Utils.isEmpty(entity.getIncrementType())) {
			dto.setIncrementType(entity.getIncrementType().getLookUpInfoId());
			dto.setIncrementTypeName(entity.getIncrementType().getLookUpInfoName());
		}

		if (!Utils.isEmpty(entity.getClassId())) {
			dto.setClassId(entity.getClassId().getLookUpInfoId());
			dto.setClassName(entity.getClassId().getLookUpInfoName());
		}

		if (!Utils.isEmpty(entity.getDesignationId())) {
			dto.setDesignationId(entity.getDesignationId().getDesignationId());
			dto.setDesignationName(entity.getDesignationId().getDesignationName());
		}

		if (!Utils.isEmpty(entity.getIncrementEffDate())) {
			dto.setIncrementEffDate(entity.getIncrementEffDate());
		}

		if (!Utils.isEmpty(entity.getDateNextInc())) {
			dto.setDateNextInc(entity.getDateNextInc());
		}

		if (!Utils.isEmpty(entity.getEmpId())) {
			dto.setEmpId(entity.getEmpId().getEmpId());
		}
		
		if (!Utils.isEmpty(entity.getEmpType())) {
			dto.setEmpType(entity.getEmpType().getLookUpInfoId());
			dto.setEmpTypeName(entity.getEmpType().getLookUpInfoName());
		}
		
		if (!Utils.isEmpty(entity.getEmpPayType())) {
			dto.setEmpPayType(entity.getEmpPayType().getLookUpInfoId());
			dto.setEmpPayTypeName(entity.getEmpPayType().getLookUpInfoName());
		}

		if (!Utils.isEmpty(entity.getStatusId())) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		
		if (!Utils.isEmpty(entity.getPostId())) {
			dto.setPostId(entity.getPostId().getPostId());
		}
		
		if (!Utils.isEmpty(entity.getEmpNo())) {
			dto.setEmpNo(entity.getEmpNo());
		}
		dto.setGpf(entity.getGpf());
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
