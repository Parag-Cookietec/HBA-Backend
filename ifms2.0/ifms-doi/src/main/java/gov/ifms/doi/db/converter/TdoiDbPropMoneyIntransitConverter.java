package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropMoneyIntransitDTO;

import gov.ifms.doi.db.entity.TdoiDbPropMoneyIntransitEntity;

@Component
public class TdoiDbPropMoneyIntransitConverter{

	public TdoiDbPropMoneyIntransitEntity toEntity(TdoiDbPropMoneyIntransitDTO dto) {
		TdoiDbPropMoneyIntransitEntity entity = new TdoiDbPropMoneyIntransitEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropMoneyIntransitDTO> toDtoListFromEntityList(List<TdoiDbPropMoneyIntransitEntity> entityList) {
		List<TdoiDbPropMoneyIntransitDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropMoneyIntransitEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropMoneyIntransitDTO toDtoFromEntity(TdoiDbPropMoneyIntransitEntity entity) {
		TdoiDbPropMoneyIntransitDTO dto=new TdoiDbPropMoneyIntransitDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

