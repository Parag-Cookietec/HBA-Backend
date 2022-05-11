package gov.ifms.pvu.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.pvu.dto.PVUMsCourseDto;
import gov.ifms.pvu.entity.PVUMsCourseEntity;

/**
 * The Class PVUMsCourseConverter class.
 * 
 * @version v 1.0
 * @created 2020/01/01 02:52:33
 *
 */
@Component
public class PVUMsCourseConverter implements BaseConverter<PVUMsCourseEntity, PVUMsCourseDto> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the PVUMsCourse entity
	 */
	@Override
	public PVUMsCourseEntity toEntity(PVUMsCourseDto dto) {
		PVUMsCourseEntity entity = new PVUMsCourseEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the PVUMsCourse dto
	 */
	@Override
	public PVUMsCourseDto toDTO(PVUMsCourseEntity entity) {
		PVUMsCourseDto dto = new PVUMsCourseDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<PVUMsCourseEntity> list) {
		return list.stream()
				.map(entityInList -> new EDPSDTDto(entityInList.getCourseId(), entityInList.getCourseName(),
						entityInList.getCourseCode(), entityInList.getParentCourseId()))
				.collect(Collectors.toList());
	}

	/**
	 * To course EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toCourseEDPSDTDto(List<PVUMsCourseEntity> list) {
		return list.stream()
				.map(entityInList -> new EDPSDTDto(entityInList.getCourseId(), entityInList.getCourseName(),
						entityInList.getCourseCode(), entityInList.getParentCourseId(),
						entityInList.getIsCCCExempted()))
				.collect(Collectors.toList());
	}

}
