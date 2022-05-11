package gov.ifms.pvu.converter;

import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

import java.util.Date;

import gov.ifms.edp.util.EDPUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUEmployeHistoryDto;
import gov.ifms.pvu.dto.PVUEmployeHistoryEditFormdataDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeHistoryEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class PVUEmployeHistoryConverter class.  
 * 
 * @version v 1.0
 * @created 2019/11/29 17:29:29
 *
 */
@Component
public class PVUEmployeHistoryConverter implements BaseConverter<PVUEmployeHistoryEntity,PVUEmployeHistoryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeHistory entity
	 */
	@Override
	public PVUEmployeHistoryEntity toEntity(PVUEmployeHistoryDto dto) {
		PVUEmployeHistoryEntity entity = new PVUEmployeHistoryEntity();

		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId()!=0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getEmployementType()!=0) {
			entity.setEmployementType(new EDPLuLookUpInfoEntity(dto.getEmployementType()));
		}
		if(dto.getEmpServiceContinuation()!=0) {
			entity.setEmpServiceContinuation(new EDPLuLookUpInfoEntity(dto.getEmpServiceContinuation()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeHistory  dto
	 */
	@Override
	public PVUEmployeHistoryDto toDTO(PVUEmployeHistoryEntity entity) {
		PVUEmployeHistoryDto dto = new PVUEmployeHistoryDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity()!=null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getEmployementType()!=null) {
			dto.setEmployementType(entity.getEmployementType().getLookUpInfoId());
		}
		if(entity.getEmpServiceContinuation()!=null) {
			dto.setEmpServiceContinuation(entity.getEmpServiceContinuation().getLookUpInfoId());
		}
		return dto;
	}
	
	public PVUEmployeHistoryEntity toEntityUpdate(PVUEmployeHistoryEntity entity,
			PVUEmployeHistoryEditFormdataDto dto) {
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getEmployementType() != 0) {
			entity.setEmployementType(new EDPLuLookUpInfoEntity(dto.getEmployementType()));
		}
		if (dto.getEmpServiceContinuation() != 0) {
			entity.setEmpServiceContinuation(new EDPLuLookUpInfoEntity(dto.getEmpServiceContinuation()));
		}
		if (dto.getDeptName() != null) {
			entity.setDeptName(dto.getDeptName());
		}
		if (dto.getOfficeName() != null) {
			entity.setOfficeName(dto.getOfficeName());
		}
		if (dto.getOfficeAdd() != null) {
			entity.setOfficeAdd(dto.getOfficeAdd());
		}

		if (dto.getFromDate()!= null) {
			entity.setFromDate(EDPUtility.getDateValue(dto.getFromDate()));
		}
		if (dto.getToDate() != null) {
			entity.setToDate(EDPUtility.getDateValue(dto.getToDate()));
		}

		if (dto.getEmpDesignationHist() != null) {
			entity.setEmpDesignationHist(dto.getEmpDesignationHist());
		}
		extracted(entity, dto);
		return entity;
	}

	private void extracted(PVUEmployeHistoryEntity entity, PVUEmployeHistoryEditFormdataDto dto) {
		if (dto.getLastPayDrawn() != 0) {
			entity.setLastPayDrawn(dto.getLastPayDrawn());
		}
		if (dto.getEmployeHistroyId() != 0) {
			entity.setEmployeHistroyId(dto.getEmployeHistroyId());
		}

		if (dto.getEmpServiceContinuation() != 0) {
			entity.setEmpServiceContinuation(new EDPLuLookUpInfoEntity(dto.getEmpServiceContinuation()));
		}

		if (dto.getOrderNoDate() != null) {
			entity.setOrderNoDate(dto.getOrderNoDate());
		}
		if (dto.getEmployeHistroyId() != 0) {
			entity.setEmployeHistroyId(dto.getEmployeHistroyId());
		}

		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
			entity.setUpdatedDate(new Date());
		}
		if (dto.getCreatedDate() == null) {
			entity.setCreatedDate(new Date());
		}
	}
	
	public PVUEmployeHistoryEditFormdataDto toUpdateDTO(PVUEmployeHistoryEntity entity) {
		PVUEmployeHistoryEditFormdataDto dto = new PVUEmployeHistoryEditFormdataDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity()!=null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getEmployementType()!=null) {
			dto.setEmployementType(entity.getEmployementType().getLookUpInfoId());
		}
		if(entity.getEmpServiceContinuation()!=null) {
			dto.setEmpServiceContinuation(entity.getEmpServiceContinuation().getLookUpInfoId());
		}
		return dto;
	}
	
	
}
