package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.common.util.Constant;
import gov.ifms.edp.dto.EDPRightsMappingDataDto;
import gov.ifms.edp.dto.EDPtusrRgMapDtlDto;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsMenuEntity;
import gov.ifms.edp.entity.EDPtusrRgMapDtlEntity;
import gov.ifms.edp.entity.EDPtusrRgMapEntity;
import gov.ifms.edp.util.EDPConstant;

/**
 * The Class EDPtusrRgMapDtlConverter class.
 * 
 * @version 1.0
 * @created 2020/07/16 09:31:33
 *
 */
@Component
public class EDPtusrRgMapDtlConverter implements BaseConverter<EDPtusrRgMapDtlEntity,EDPtusrRgMapDtlDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPtusrRgMapDtl entity
	 */
	@Override
	public EDPtusrRgMapDtlEntity toEntity(EDPtusrRgMapDtlDto dto) {
		EDPtusrRgMapDtlEntity entity = new EDPtusrRgMapDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPtusrRgMapDtl  dto
	 */
	@Override
	public EDPtusrRgMapDtlDto toDTO(EDPtusrRgMapDtlEntity entity) {
		EDPtusrRgMapDtlDto dto = new EDPtusrRgMapDtlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * Rights mapping data dtoto entity.
	 *
	 * @param dataDto the data dto
	 * @return the ED ptusr rg map dtl entity
	 */
	public EDPtusrRgMapDtlEntity rightsMappingDataDtotoEntity(EDPRightsMappingDataDto dataDto, Long rgMapId) {
		EDPtusrRgMapDtlEntity entity = new EDPtusrRgMapDtlEntity();
		if(null!= dataDto.getIsRightsRemoved() && dataDto.getIsRightsRemoved())
			entity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		if(null!= dataDto.getIsRightsRemoved() && !dataDto.getIsRightsRemoved()) 
			entity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		entity.setMenuId(new EDPMsMenuEntity(dataDto.getMenuId()));
		entity.setTusrRgMapId(new EDPtusrRgMapEntity(rgMapId));
		return entity;
	}

	/**
	 * Tusr rg map dtl save entity to entity.
	 *
	 * @param edpRightsMappingDataDto the edp rights mapping data dto
	 * @param savedEntity 
	 * @return the ED ptusr rg map dtl entity
	 */
	public EDPtusrRgMapDtlEntity tusrRgMapDtlSaveEntitytoEntity(EDPRightsMappingDataDto edpRightsMappingDataDto, EDPtusrRgMapDtlEntity savedEntity) {
		if(null!= edpRightsMappingDataDto.getIsRightsRemoved() && edpRightsMappingDataDto.getIsRightsRemoved())
			savedEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_YES));
		if(null!= edpRightsMappingDataDto.getIsRightsRemoved() && !edpRightsMappingDataDto.getIsRightsRemoved()) 
			savedEntity.setIsRemoved(new EDPLuLookUpInfoEntity(EDPConstant.LOOKUP_INFO_NO));
		if(null == edpRightsMappingDataDto.getIsRightsRemoved())
			savedEntity.setIsRemoved(null);
		savedEntity.setMenuId(new EDPMsMenuEntity(edpRightsMappingDataDto.getMenuId()));
		savedEntity.setActiveStatus(Constant.ACTIVE_STATUS);
		return savedEntity;
	}
	
}
