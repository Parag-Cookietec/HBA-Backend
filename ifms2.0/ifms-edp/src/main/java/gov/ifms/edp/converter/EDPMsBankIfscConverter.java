package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPMsBankIfscDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsBankIfscEntity;

/**
 * The Class EDPMsBankIfscConverter class.
 * 
 * @version v 1.0
 * @created 2020/05/28 17:17:24
 *
 */
@Component
public class EDPMsBankIfscConverter implements BaseConverter<EDPMsBankIfscEntity, EDPMsBankIfscDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsBankIfsc entity
	 */
	@Override
	public EDPMsBankIfscEntity toEntity(EDPMsBankIfscDto dto) {
		EDPMsBankIfscEntity entity = new EDPMsBankIfscEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsBankIfsc dto
	 */
	@Override
	public EDPMsBankIfscDto toDTO(EDPMsBankIfscEntity entity) {
		EDPMsBankIfscDto dto = new EDPMsBankIfscDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsBankIfscEntity> list) {
		return list.stream().map(entityList -> new EDPSDTDto(entityList.getId(), entityList.getBankName(),
				entityList.getIfscCode(), entityList.getBankAddress())).collect(Collectors.toList());
	}

}
