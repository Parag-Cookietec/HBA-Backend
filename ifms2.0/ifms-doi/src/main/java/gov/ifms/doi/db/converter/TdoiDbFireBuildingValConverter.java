package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbFireBuildingValDTO;

import gov.ifms.doi.db.entity.TdoiDbFireBuildingValEntity;

@Component
public class TdoiDbFireBuildingValConverter{

	public TdoiDbFireBuildingValEntity toEntity(TdoiDbFireBuildingValDTO dto) {
		TdoiDbFireBuildingValEntity entity = new TdoiDbFireBuildingValEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbFireBuildingValDTO> toDtoListFromEntityList(List<TdoiDbFireBuildingValEntity> entityList) {
		List<TdoiDbFireBuildingValDTO> dtoList = new ArrayList<>();
		for (TdoiDbFireBuildingValEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbFireBuildingValDTO toDtoFromEntity(TdoiDbFireBuildingValEntity entity) {
		TdoiDbFireBuildingValDTO dto=new TdoiDbFireBuildingValDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

