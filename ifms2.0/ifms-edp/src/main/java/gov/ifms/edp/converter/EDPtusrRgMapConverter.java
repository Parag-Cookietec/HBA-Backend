package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.edp.dto.EDPRightsMappingDto;
import gov.ifms.edp.dto.EDPtusrRgMapDto;
import gov.ifms.edp.employe.EDPEmployeEntity;
import gov.ifms.edp.entity.EDPLkPoOffUserEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.util.EDPConstant;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPtusrRgMapConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:23:40
 *
 */
@Component
public class EDPtusrRgMapConverter implements BaseConverter<EDPtusrRgMapEntity,EDPtusrRgMapDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMap entity
	 */
	@Override
	public EDPtusrRgMapEntity toEntity(EDPtusrRgMapDto dto) {
		EDPtusrRgMapEntity entity = new EDPtusrRgMapEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMap  dto
	 */
	@Override
	public EDPtusrRgMapDto toDTO(EDPtusrRgMapEntity entity) {
		EDPtusrRgMapDto dto = new EDPtusrRgMapDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Edp rights mapping dto to entity.
	 *
	 * @param dto the dto
	 * @return the ED ptusr rg map entity
	 */
	public EDPtusrRgMapEntity edpRightsMappingDtoToEntity(EDPRightsMappingDto dto) {
		EDPtusrRgMapEntity entity = new EDPtusrRgMapEntity();
		entity.setPoOffUserId(new EDPLkPoOffUserEntity(dto.getLkPoOffUserId()));
		entity.setToEmpId(new EDPEmployeEntity(dto.getEmpId()));
		if(dto.isHasObjection()) {
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		}else{
			entity.setHasObjection(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			
		}
		if(dto.isWfInRequest()) {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		}else {
			entity.setWfInRequest(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));			
		}
		return entity;
	}
	
}
