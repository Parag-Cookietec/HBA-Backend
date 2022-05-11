package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolMitWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPolMitWfEntity;

@Component
public class TdoiDbPolMitWfConverter{

	public TdoiDbPolMitWfEntity toEntity(TdoiDbPolMitWfDTO dto) {
		TdoiDbPolMitWfEntity entity = new TdoiDbPolMitWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolMitWfDTO> toDtoListFromEntityList(List<TdoiDbPolMitWfEntity> entityList) {
		List<TdoiDbPolMitWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolMitWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolMitWfDTO toDtoFromEntity(TdoiDbPolMitWfEntity entity) {
		TdoiDbPolMitWfDTO dto=new TdoiDbPolMitWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

