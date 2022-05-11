package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslFireWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslFireWfEntity;

@Component
public class TdoiDbPropslFireWfConverter{

	public TdoiDbPropslFireWfEntity toEntity(TdoiDbPropslFireWfDTO dto) {
		TdoiDbPropslFireWfEntity entity = new TdoiDbPropslFireWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslFireWfDTO> toDtoListFromEntityList(List<TdoiDbPropslFireWfEntity> entityList) {
		List<TdoiDbPropslFireWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslFireWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslFireWfDTO toDtoFromEntity(TdoiDbPropslFireWfEntity entity) {
		TdoiDbPropslFireWfDTO dto=new TdoiDbPropslFireWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

