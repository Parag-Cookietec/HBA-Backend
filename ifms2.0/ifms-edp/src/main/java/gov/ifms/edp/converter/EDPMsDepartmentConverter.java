/*
 * 
 */
package gov.ifms.edp.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.edp.dto.ClueDto;
import gov.ifms.edp.dto.EDPMsDepartmentDto;
import gov.ifms.edp.dto.EDPSDTDto;
import gov.ifms.edp.entity.EDPMsDepartmentEntity;
import gov.ifms.edp.repository.EDPMsDepartmentRepository;

/**
 * The Class EDPMsDepartmentConverter class.
 * 
 * @version 1.0
 * @created 2019/08/29 15:05:35
 *
 */
@Component
public class EDPMsDepartmentConverter implements BaseConverter<EDPMsDepartmentEntity, EDPMsDepartmentDto> {

	/** The edp ms department repository. */
	@Autowired
	private EDPMsDepartmentRepository edpMsDepartmentRepository;

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the EDPMsDepartment entity
	 */
	@Override
	public EDPMsDepartmentEntity toEntity(EDPMsDepartmentDto dto) {
		EDPMsDepartmentEntity entity = new EDPMsDepartmentEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDPMsDepartment dto
	 */
	@Override
	public EDPMsDepartmentDto toDTO(EDPMsDepartmentEntity entity) {
		EDPMsDepartmentDto dto = new EDPMsDepartmentDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
	
	/**
	 * To DTO.
	 *
	 * @param entity the entity
	 * @return the EDP ms department dto
	 */
	public ClueDto toClueDTO(EDPMsDepartmentEntity entity) {
		return new ClueDto(entity.getDepartmentId(), entity.getDepartmentName(), entity.getDepartmentCode());
	}
	

	/**
	 * Id to EDP depart ment entity.
	 *
	 * @param id the id
	 * @return the EDP ms department entity
	 */
	public EDPMsDepartmentEntity idToEDPDepartMentEntity(long id) {
		Optional<EDPMsDepartmentEntity> entity = this.edpMsDepartmentRepository.findById(id);
		if (entity.isPresent())
			return entity.get();
		else
			throw new EntityNotFoundException("bpn id Should not be null");

	}

	/**
	 * To EDPSDT dto.
	 *
	 * @param list the list
	 * @return the list
	 */
	public List<EDPSDTDto> toEDPSDTDto(List<EDPMsDepartmentEntity> list) {
		return list.stream().map(entityInList -> new EDPSDTDto(entityInList.getDepartmentId(),
				entityInList.getDepartmentName(), entityInList.getDepartmentCode())).collect(Collectors.toList());
	}

}
