package gov.ifms.doi.db.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;

import gov.ifms.doi.db.dto.TdoiDbPolFireRiDtlDTO;

import gov.ifms.doi.db.entity.TdoiDbPolFireRiDtlEntity;

@Component
public class TdoiDbPolFireRiDtlConverter{

	public TdoiDbPolFireRiDtlEntity toEntity(TdoiDbPolFireRiDtlDTO dto) {
		TdoiDbPolFireRiDtlEntity entity = new TdoiDbPolFireRiDtlEntity();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}


	public List<TdoiDbPolFireRiDtlDTO> toDtoListFromEntityList(List<TdoiDbPolFireRiDtlEntity> entityList) {
		List<TdoiDbPolFireRiDtlDTO> dtoList = new ArrayList<>();
		for (TdoiDbPolFireRiDtlEntity entity : entityList) {
			dtoList.add(toDtoFromEntity(entity));
		}
	return dtoList;
	}


	public TdoiDbPolFireRiDtlDTO toDtoFromEntity(TdoiDbPolFireRiDtlEntity entity) {
		TdoiDbPolFireRiDtlDTO dto=new TdoiDbPolFireRiDtlDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}


}

