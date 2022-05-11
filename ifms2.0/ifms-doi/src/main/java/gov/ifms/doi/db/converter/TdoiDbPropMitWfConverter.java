package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropMitWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPropMitWfEntity;

@Component
public class TdoiDbPropMitWfConverter{

	public TdoiDbPropMitWfEntity toEntity(TdoiDbPropMitWfDTO dto) {
		TdoiDbPropMitWfEntity entity = new TdoiDbPropMitWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropMitWfDTO> toDtoListFromEntityList(List<TdoiDbPropMitWfEntity> entityList) {
		List<TdoiDbPropMitWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropMitWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropMitWfDTO toDtoFromEntity(TdoiDbPropMitWfEntity entity) {
		TdoiDbPropMitWfDTO dto=new TdoiDbPropMitWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

