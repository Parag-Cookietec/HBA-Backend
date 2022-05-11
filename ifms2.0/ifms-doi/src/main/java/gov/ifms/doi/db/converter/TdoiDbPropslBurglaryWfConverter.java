package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslBurglaryWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslBurglaryWfEntity;

@Component
public class TdoiDbPropslBurglaryWfConverter{

	public TdoiDbPropslBurglaryWfEntity toEntity(TdoiDbPropslBurglaryWfDTO dto) {
		TdoiDbPropslBurglaryWfEntity entity = new TdoiDbPropslBurglaryWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslBurglaryWfDTO> toDtoListFromEntityList(List<TdoiDbPropslBurglaryWfEntity> entityList) {
		List<TdoiDbPropslBurglaryWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslBurglaryWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslBurglaryWfDTO toDtoFromEntity(TdoiDbPropslBurglaryWfEntity entity) {
		TdoiDbPropslBurglaryWfDTO dto=new TdoiDbPropslBurglaryWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

