package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFireWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFireWfEntity;

@Component
public class TdoiDbPolFireWfConverter{

	public TdoiDbPolFireWfEntity toEntity(TdoiDbPolFireWfDTO dto) {
		TdoiDbPolFireWfEntity entity = new TdoiDbPolFireWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFireWfDTO> toDtoListFromEntityList(List<TdoiDbPolFireWfEntity> entityList) {
		List<TdoiDbPolFireWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFireWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFireWfDTO toDtoFromEntity(TdoiDbPolFireWfEntity entity) {
		TdoiDbPolFireWfDTO dto=new TdoiDbPolFireWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

