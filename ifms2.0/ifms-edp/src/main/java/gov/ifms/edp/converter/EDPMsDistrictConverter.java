package gov.ifms.edp.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsDistrictDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsDistrictEntity;

/**
 * The Class EDPMsDistrictConverter.
 */
@Component
public class EDPMsDistrictConverter implements BaseConverter<EDPMsDistrictEntity,EDPMsDistrictDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPDistrictName entity
	 */
	@Override
	public EDPMsDistrictEntity toEntity(EDPMsDistrictDto dto) {
		EDPMsDistrictEntity entity = new EDPMsDistrictEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPDistrictName  dto
	 */
	@Override
	public EDPMsDistrictDto toDTO(EDPMsDistrictEntity entity) {
		EDPMsDistrictDto dto = new EDPMsDistrictDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


	/**
	 * To clue DTO.
	 *
	 * @param districtEntity the district entity
	 * @return the list
	 */
	public List<ClueDto> toClueDTO(List<EDPMsDistrictEntity> districtEntity) {
		return districtEntity.stream()
				.map(entityInList -> new ClueDto(entityInList.getDistrictId(), entityInList.getDistrictName(),
						entityInList.getDistrictCode(), entityInList.getDistrictCodeName(),entityInList.getStdCode()))
				.collect(Collectors.toList());
	
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsDistrictEntity> list) {
		return list.stream().map(entityInList -> new EDPSDTDto(entityInList.getDistrictId(),
				entityInList.getDistrictName(), entityInList.getDistrictCode())).collect(Collectors.toList());
	}

}
