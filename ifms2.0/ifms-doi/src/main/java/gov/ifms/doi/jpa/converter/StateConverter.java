/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.StateDTO;
import gov.ifms.doi.jpa.entity.StateEntity;

/**
 * @author Sagar Jadhav
 *
 */
@Component
public class StateConverter {

	public StateEntity toEntity(StateDTO dto) {
		StateEntity entity = new StateEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<StateDTO> toDtoListFromEntityList(List<StateEntity> entityList) {
		ArrayList<StateDTO> dtoList = new ArrayList<>();
		for (StateEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public StateDTO toDtoFromEntity(StateEntity entity) {
		StateDTO dto = new StateDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
