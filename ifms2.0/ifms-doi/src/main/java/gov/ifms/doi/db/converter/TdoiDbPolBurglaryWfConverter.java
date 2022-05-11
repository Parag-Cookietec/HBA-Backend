package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolBurglaryWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPolBurglaryWfEntity;

@Component
public class TdoiDbPolBurglaryWfConverter{

	public TdoiDbPolBurglaryWfEntity toEntity(TdoiDbPolBurglaryWfDTO dto) {
		TdoiDbPolBurglaryWfEntity entity = new TdoiDbPolBurglaryWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolBurglaryWfDTO> toDtoListFromEntityList(List<TdoiDbPolBurglaryWfEntity> entityList) {
		List<TdoiDbPolBurglaryWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolBurglaryWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolBurglaryWfDTO toDtoFromEntity(TdoiDbPolBurglaryWfEntity entity) {
		TdoiDbPolBurglaryWfDTO dto=new TdoiDbPolBurglaryWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

