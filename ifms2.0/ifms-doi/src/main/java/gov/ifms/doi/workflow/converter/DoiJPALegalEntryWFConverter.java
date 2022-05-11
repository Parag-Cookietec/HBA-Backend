package gov.ifms.doi.workflow.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.common.base.BaseConverter;
import gov.ifms.doi.workflow.dto.DOIJpaLegalEntryWFDTO;
import gov.ifms.doi.workflow.entity.DOIJpaLegalEntryWFEntity;

/**
 * 
 * @author Rudra
 *
 */
@Component
public class DoiJPALegalEntryWFConverter implements BaseConverter<DOIJpaLegalEntryWFEntity, DOIJpaLegalEntryWFDTO> {

	/**
	 * To entity.
	 *
	 * @param dto the dto
	 * @return the JPA entity
	 */
	@Override
	public DOIJpaLegalEntryWFEntity toEntity(DOIJpaLegalEntryWFDTO dto) {
		DOIJpaLegalEntryWFEntity entity = new DOIJpaLegalEntryWFEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	@Override
	public DOIJpaLegalEntryWFDTO toDTO(DOIJpaLegalEntryWFEntity entity) {
		DOIJpaLegalEntryWFDTO dto = new DOIJpaLegalEntryWFDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<DOIJpaLegalEntryWFDTO> toDTO(List<DOIJpaLegalEntryWFEntity> entityList) {
		List<DOIJpaLegalEntryWFDTO> dtoList = new ArrayList<>();
		entityList.forEach(entity -> dtoList.add(toDTO(entity)));
		return dtoList;
	}

}
