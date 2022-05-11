package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslBurglaryEntity;

@Component
public class TdoiDbPropslBurglaryConverter{

	public TdoiDbPropslBurglaryEntity toEntity(TdoiDbPropslBurglaryDTO dto) {
		TdoiDbPropslBurglaryEntity entity = new TdoiDbPropslBurglaryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslBurglaryDTO> toDtoListFromEntityList(List<TdoiDbPropslBurglaryEntity> entityList) {
		List<TdoiDbPropslBurglaryDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslBurglaryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslBurglaryDTO toDtoFromEntity(TdoiDbPropslBurglaryEntity entity) {
		TdoiDbPropslBurglaryDTO dto=new TdoiDbPropslBurglaryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

