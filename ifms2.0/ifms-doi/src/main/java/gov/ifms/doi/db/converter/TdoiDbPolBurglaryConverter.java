package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolBurglaryDTO;

import gov.ifms.doi.db.entity.TdoiDbPolBurglaryEntity;

@Component
public class TdoiDbPolBurglaryConverter{

	public TdoiDbPolBurglaryEntity toEntity(TdoiDbPolBurglaryDTO dto) {
		TdoiDbPolBurglaryEntity entity = new TdoiDbPolBurglaryEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolBurglaryDTO> toDtoListFromEntityList(List<TdoiDbPolBurglaryEntity> entityList) {
		List<TdoiDbPolBurglaryDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolBurglaryEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolBurglaryDTO toDtoFromEntity(TdoiDbPolBurglaryEntity entity) {
		TdoiDbPolBurglaryDTO dto=new TdoiDbPolBurglaryDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

