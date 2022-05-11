package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFireBuildingValDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFireBuildingValEntity;

@Component
public class TdoiDbPolFireBuildingValConverter{

	public TdoiDbPolFireBuildingValEntity toEntity(TdoiDbPolFireBuildingValDTO dto) {
		TdoiDbPolFireBuildingValEntity entity = new TdoiDbPolFireBuildingValEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFireBuildingValDTO> toDtoListFromEntityList(List<TdoiDbPolFireBuildingValEntity> entityList) {
		List<TdoiDbPolFireBuildingValDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFireBuildingValEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFireBuildingValDTO toDtoFromEntity(TdoiDbPolFireBuildingValEntity entity) {
		TdoiDbPolFireBuildingValDTO dto=new TdoiDbPolFireBuildingValDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

