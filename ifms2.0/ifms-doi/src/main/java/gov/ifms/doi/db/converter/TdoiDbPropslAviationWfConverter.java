package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslAviationWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslAviationWfEntity;

@Component
public class TdoiDbPropslAviationWfConverter{

	public TdoiDbPropslAviationWfEntity toEntity(TdoiDbPropslAviationWfDTO dto) {
		TdoiDbPropslAviationWfEntity entity = new TdoiDbPropslAviationWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslAviationWfDTO> toDtoListFromEntityList(List<TdoiDbPropslAviationWfEntity> entityList) {
		List<TdoiDbPropslAviationWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslAviationWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslAviationWfDTO toDtoFromEntity(TdoiDbPropslAviationWfEntity entity) {
		TdoiDbPropslAviationWfDTO dto=new TdoiDbPropslAviationWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

