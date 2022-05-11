package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPropslElecWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPropslElecWfEntity;

@Component
public class TdoiDbPropslElecWfConverter{

	public TdoiDbPropslElecWfEntity toEntity(TdoiDbPropslElecWfDTO dto) {
		TdoiDbPropslElecWfEntity entity = new TdoiDbPropslElecWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPropslElecWfDTO> toDtoListFromEntityList(List<TdoiDbPropslElecWfEntity> entityList) {
		List<TdoiDbPropslElecWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPropslElecWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPropslElecWfDTO toDtoFromEntity(TdoiDbPropslElecWfEntity entity) {
		TdoiDbPropslElecWfDTO dto=new TdoiDbPropslElecWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

