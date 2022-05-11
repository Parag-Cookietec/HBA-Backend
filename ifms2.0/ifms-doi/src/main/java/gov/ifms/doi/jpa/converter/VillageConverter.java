/**
 * 
 */
package gov.ifms.doi.jpa.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import gov.ifms.doi.jpa.dto.VillageDTO;
import gov.ifms.doi.jpa.entity.VillageEntity;

/**
 * @author Rudra
 *
 */
@Component
public class VillageConverter {

	public VillageEntity toEntity(VillageDTO dto) {
		VillageEntity entity = new VillageEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	public List<VillageDTO> toDtoListFromEntityList(List<VillageEntity> entityList) {
		ArrayList<VillageDTO> dtoList = new ArrayList<>();
		for (VillageEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
		return dtoList;
	}

	public VillageDTO toDtoFromEntity(VillageEntity entity) {
		VillageDTO dto = new VillageDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
