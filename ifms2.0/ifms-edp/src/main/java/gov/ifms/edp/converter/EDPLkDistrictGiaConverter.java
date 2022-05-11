package gov.ifms.edp.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import gov.ifms.edp.dto.EDPLkDistrictGiaDto;
import gov.ifms.edp.entity.EDPLkDistrictGiaEntity;
import gov.ifms.edp.entity.EDPLuLookUpInfoEntity;
import gov.ifms.edp.entity.EDPMsDistrictEntity;
import gov.ifms.common.base.BaseConverter;

/**
 * The Class EDPLkDistrictGiaConverter class.
 * 
 * @version v 1.0
 * @created 2020/07/07 11:40:45
 *
 */
@Component
public class EDPLkDistrictGiaConverter implements BaseConverter<EDPLkDistrictGiaEntity, EDPLkDistrictGiaDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPLkDistrictGia entity
	 */
	@Override
	public EDPLkDistrictGiaEntity toEntity(EDPLkDistrictGiaDto dto) {
		EDPLkDistrictGiaEntity entity = new EDPLkDistrictGiaEntity();
		BeanUtils.copyProperties(dto, entity);
		if(null != dto.getDistrictId()) {
			entity.setDistrictId(new EDPMsDistrictEntity(dto.getDistrictId()));
		}
		if(null != dto.getIsJilla()) {
			entity.setIsJilla(new EDPLuLookUpInfoEntity(dto.getIsJilla()));
		}
		if(null != dto.getIsGram()) {
			entity.setIsGram(new EDPLuLookUpInfoEntity(dto.getIsGram()));
		}
		if(null != dto.getIsTaluka()) {
			entity.setIsTaluka(new EDPLuLookUpInfoEntity(dto.getIsTaluka()));
		}
		if(null != dto.getIsCorporation()) {
			entity.setIsCorporation(new EDPLuLookUpInfoEntity(dto.getIsCorporation()));
		}
		if(null != dto.getIsMunicipality()) {
			entity.setIsMunicipality(new EDPLuLookUpInfoEntity(dto.getIsMunicipality()));
		}
		if(null != dto.getIsNotifiedArea()) {
			entity.setIsNotifiedArea(new EDPLuLookUpInfoEntity(dto.getIsNotifiedArea()));
		}
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPLkDistrictGia dto
	 */
	@Override
	public EDPLkDistrictGiaDto toDTO(EDPLkDistrictGiaEntity entity) {
		EDPLkDistrictGiaDto dto = new EDPLkDistrictGiaDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setDistrictId(entity.getDistrictId().getDistrictId());
		dto.setIsJilla(entity.getIsJilla().getLookUpInfoId());
		dto.setIsGram(entity.getIsGram().getLookUpInfoId());
		dto.setIsTaluka(entity.getIsTaluka().getLookUpInfoId());
		dto.setIsCorporation(entity.getIsCorporation().getLookUpInfoId());
		dto.setIsMunicipality(entity.getIsMunicipality().getLookUpInfoId());
		dto.setIsNotifiedArea(entity.getIsNotifiedArea().getLookUpInfoId());
		return dto;
	}

}
