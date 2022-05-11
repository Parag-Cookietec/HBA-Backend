package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbFireRiskLocDTO;

import gov.ifms.doi.db.entity.TdoiDbFireRiskLocEntity;

@Component
public class TdoiDbFireRiskLocConverter{

	public TdoiDbFireRiskLocEntity toEntity(TdoiDbFireRiskLocDTO dto) {
		TdoiDbFireRiskLocEntity entity = new TdoiDbFireRiskLocEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbFireRiskLocDTO> toDtoListFromEntityList(List<TdoiDbFireRiskLocEntity> entityList) {
		List<TdoiDbFireRiskLocDTO> dtoList = new ArrayList<>();
		for (TdoiDbFireRiskLocEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbFireRiskLocDTO toDtoFromEntity(TdoiDbFireRiskLocEntity entity) {
		TdoiDbFireRiskLocDTO dto=new TdoiDbFireRiskLocDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

