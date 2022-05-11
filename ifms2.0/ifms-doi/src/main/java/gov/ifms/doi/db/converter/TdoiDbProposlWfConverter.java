package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbProposlWfDTO;

import gov.ifms.doi.db.entity.TdoiDbProposlWfEntity;

@Component
public class TdoiDbProposlWfConverter{

	public TdoiDbProposlWfEntity toEntity(TdoiDbProposlWfDTO dto) {
		TdoiDbProposlWfEntity entity = new TdoiDbProposlWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbProposlWfDTO> toDtoListFromEntityList(List<TdoiDbProposlWfEntity> entityList) {
		List<TdoiDbProposlWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbProposlWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbProposlWfDTO toDtoFromEntity(TdoiDbProposlWfEntity entity) {
		TdoiDbProposlWfDTO dto=new TdoiDbProposlWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

