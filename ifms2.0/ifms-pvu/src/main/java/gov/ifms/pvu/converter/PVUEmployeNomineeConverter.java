package gov.ifms.pvu.converter;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.pvu.dto.PVUEmployeNomineeDto;
import gov.ifms.pvu.dto.PVUEmployeNomineeUpdateDto;
import gov.ifms.pvu.entity.PVUEmployeEntity;
import gov.ifms.pvu.entity.PVUEmployeNomineeEntity;
import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;

/**
 * The Class PVUEmployeNomineeConverter class.
 * 
 * @version v 1.0
 * @created 2019/11/27 03:02:40
 *
 */
@Component
public class PVUEmployeNomineeConverter implements BaseConverter<PVUEmployeNomineeEntity,PVUEmployeNomineeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUEmployeNominee entity
	 */
	@Override
	public PVUEmployeNomineeEntity toEntity(PVUEmployeNomineeDto dto) {
		PVUEmployeNomineeEntity entity = new PVUEmployeNomineeEntity();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if(dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if(dto.getRelationship() != 0) {
			entity.setRelationship(new EDPLuLookUpInfoEntity(dto.getRelationship()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUEmployeNominee  dto
	 */
	@Override
	public PVUEmployeNomineeDto toDTO(PVUEmployeNomineeEntity entity) {
		PVUEmployeNomineeDto dto = new PVUEmployeNomineeDto();
		BeanUtils.copyProperties(entity, dto);
		if(entity.getPvuEmployeEntity() != null) {
			dto.setEmpId(entity.getPvuEmployeEntity().getEmpId());
		}
		if(entity.getRelationship() != null) {
			dto.setRelationship(entity.getRelationship().getLookUpInfoId());
			dto.setRelationshipName(entity.getRelationship().getLookUpInfoName());
		}
		if(entity.getStatusId() != null) {
			dto.setStatusId(entity.getStatusId().getLookUpInfoId());
		}
		return dto;
	}
	
	public PVUEmployeNomineeEntity toEntityUpdate(PVUEmployeNomineeEntity entity , PVUEmployeNomineeDto dto) {
		if (dto.getEmpId() != 0) {
			entity.setPvuEmployeEntity(new PVUEmployeEntity(dto.getEmpId()));
		}
		if (dto.getRelationship() != 0) {
			entity.setRelationship(new EDPLuLookUpInfoEntity(dto.getRelationship()));
		}
		if (dto.getStatusId() != 0) {
			entity.setStatusId(new EDPLuLookUpInfoEntity(dto.getStatusId()));
		}
		if (dto.getRelationship() != 0) {
			entity.setRelationship(new EDPLuLookUpInfoEntity(dto.getRelationship()));
		}
		if (dto.getNomineeName() != null) {
			entity.setNomineeName(dto.getNomineeName());
		}
		if (dto.getNomineeAge() != null) {
			entity.setNomineeAge(dto.getNomineeAge());
		}
		if (dto.getNomineeShare() != 0) {
			entity.setNomineeShare(dto.getNomineeShare());
		}
		if (dto.getNomineeAddress() != null) {
			entity.setNomineeAddress(dto.getNomineeAddress());
		}
		if (dto.getNomineePhoto() != null) {
			entity.setNomineePhoto(dto.getNomineePhoto());
		}
		if (dto.getNpsNomineeFormName() !=null) {
			entity.setNpsNomineeFormName(dto.getNpsNomineeFormName());
		}
		if (dto.getChangeType() != 0) {
			entity.setChangeType(dto.getChangeType());
		}
		if (dto.getOtherRelationship() != null) {
			entity.setOtherRelationship(dto.getOtherRelationship());
		}
		entity.setUpdatedDate(new Date());
		return entity;
	}
	
}
