package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolElecWfDTO;

import gov.ifms.doi.db.entity.TdoiDbPolElecWfEntity;

@Component
public class TdoiDbPolElecWfConverter{

	public TdoiDbPolElecWfEntity toEntity(TdoiDbPolElecWfDTO dto) {
		TdoiDbPolElecWfEntity entity = new TdoiDbPolElecWfEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolElecWfDTO> toDtoListFromEntityList(List<TdoiDbPolElecWfEntity> entityList) {
		List<TdoiDbPolElecWfDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolElecWfEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolElecWfDTO toDtoFromEntity(TdoiDbPolElecWfEntity entity) {
		TdoiDbPolElecWfDTO dto=new TdoiDbPolElecWfDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

