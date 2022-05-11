package gov.ifms.edp.employe;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.util.EDPUtility;

/**
 * The Class EDPEmployeConverter.
 */
@Component
public class EDPEmployeConverter implements BaseConverter<EDPEmployeEntity,EDPEmployeDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVU employe entity
	 */
	@Override
	public EDPEmployeEntity toEntity(EDPEmployeDto dto) {
		EDPEmployeEntity entity = new EDPEmployeEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVU employe dto
	 */
	@Override
	public EDPEmployeDto toDTO(EDPEmployeEntity entity) {
		EDPEmployeDto dto = new EDPEmployeDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	/**
	 * To clue dto.
	 *
	 * @param entity the entity
	 * @return the clue dto
	 */
	public ClueDto toClueDto(EDPEmployeEntity entity) {
		ClueDto dto = new ClueDto();
		dto.setId(entity.getEmpId());
		dto.setName(EDPUtility.getEmployeeNameFromEmployeeEntity(entity));
		dto.setCode(String.valueOf(entity.getEmployeeCode()));
		return dto;
	}

}