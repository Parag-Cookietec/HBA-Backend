package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolAviationWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPolAviationWfEntity;

@Component
public class TdoiDbPolAviationWfConverter{

	public TdoiDbPolAviationWfEntity toEntity(TdoiDbPolAviationWfDTO dto) {
		TdoiDbPolAviationWfEntity entity = new TdoiDbPolAviationWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolAviationWfDTO> toDtoListFromEntityList(List<TdoiDbPolAviationWfEntity> entityList) {
		List<TdoiDbPolAviationWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolAviationWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolAviationWfDTO toDtoFromEntity(TdoiDbPolAviationWfEntity entity) {
		TdoiDbPolAviationWfDTO dto=new TdoiDbPolAviationWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

