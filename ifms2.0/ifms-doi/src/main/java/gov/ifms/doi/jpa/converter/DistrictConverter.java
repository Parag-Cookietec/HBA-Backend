/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.DistrictDTO;
import gov.ifms.doi.jpa.entity.DistrictEntity;

/**
 * @author Rudra
 *
 */
@Component
public class DistrictConverter {

	public DistrictEntity toEntity(DistrictDTO dto) {
		DistrictEntity entity = new DistrictEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<DistrictDTO> toDtoListFromEntityList(List<DistrictEntity> entityList) {
		ArrayList<DistrictDTO> dtoList = new ArrayList<>();
		for (DistrictEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public DistrictDTO toDtoFromEntity(DistrictEntity entity) {
		DistrictDTO dto = new DistrictDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
