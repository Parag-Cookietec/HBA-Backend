package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsTreasuryDto;
import gov.ifms.edp.entity.EDPMsTreasuryEntity;

/**
 * The Class EDPMsTreasuryConverter class.
 * 
 * @version 1.0
 * @created 2019/12/11 14:53:04
 *
 */
@Component
public class EDPMsTreasuryConverter implements BaseConverter<EDPMsTreasuryEntity, EDPMsTreasuryDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsTreasury entity
	 */
	@Override
	public EDPMsTreasuryEntity toEntity(EDPMsTreasuryDto dto) {
		EDPMsTreasuryEntity entity = new EDPMsTreasuryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsTreasury dto
	 */
	@Override
	public EDPMsTreasuryDto toDTO(EDPMsTreasuryEntity entity) {
		EDPMsTreasuryDto dto = new EDPMsTreasuryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To clue DTO.
	 *
	 * @param treasuryEntitylist the treasury entitylist
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsTreasuryEntity> treasuryEntitylist) {
		return treasuryEntitylist.stream()
				.map(entityInList -> new ClueDto(entityInList.getTreasuryId(),entityInList.getTreasuryName(),null,null))
				.collect(Collectors.toList());
	}

}
